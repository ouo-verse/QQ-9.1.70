package com.tencent.qqnt.qwallet.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.qzone.album.data.model.AlbumCacheData;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f361863a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter<PaymentStateEntity> f361864b;

    /* renamed from: c, reason: collision with root package name */
    private final SharedSQLiteStatement f361865c;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends EntityInsertionAdapter<PaymentStateEntity> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, PaymentStateEntity paymentStateEntity) {
            if (paymentStateEntity.getLoginUin() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, paymentStateEntity.getLoginUin());
            }
            if (paymentStateEntity.getPaymentId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, paymentStateEntity.getPaymentId());
            }
            if (paymentStateEntity.getMsgOwnerUin() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, paymentStateEntity.getMsgOwnerUin());
            }
            supportSQLiteStatement.bindLong(4, paymentStateEntity.getPaymentType());
            if (paymentStateEntity.getGroupUin() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, paymentStateEntity.getGroupUin());
            }
            supportSQLiteStatement.bindLong(6, paymentStateEntity.getState());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `aio_payment_state_table` (`loginUin`,`paymentId`,`msgOwnerUin`,`paymentType`,`groupUin`,`state`) VALUES (?,?,?,?,?,?)";
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM aio_payment_state_table";
        }
    }

    public h(RoomDatabase roomDatabase) {
        this.f361863a = roomDatabase;
        this.f361864b = new a(roomDatabase);
        this.f361865c = new b(roomDatabase);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    @Override // com.tencent.qqnt.qwallet.db.g
    public void a() {
        this.f361863a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f361865c.acquire();
        this.f361863a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f361863a.setTransactionSuccessful();
        } finally {
            this.f361863a.endTransaction();
            this.f361865c.release(acquire);
        }
    }

    @Override // com.tencent.qqnt.qwallet.db.g
    public long b(PaymentStateEntity paymentStateEntity) {
        this.f361863a.assertNotSuspendingTransaction();
        this.f361863a.beginTransaction();
        try {
            long insertAndReturnId = this.f361864b.insertAndReturnId(paymentStateEntity);
            this.f361863a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.f361863a.endTransaction();
        }
    }

    @Override // com.tencent.qqnt.qwallet.db.g
    public PaymentStateEntity c(String str, String str2, String str3, int i3) {
        String string;
        String string2;
        String string3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM aio_payment_state_table WHERE loginUin = ? AND paymentId = ? AND msgOwnerUin = ? AND paymentType = ?", 4);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        if (str3 == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str3);
        }
        acquire.bindLong(4, i3);
        this.f361863a.assertNotSuspendingTransaction();
        PaymentStateEntity paymentStateEntity = null;
        String string4 = null;
        Cursor query = DBUtil.query(this.f361863a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, AlbumCacheData.LOGINUIN);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "paymentId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "msgOwnerUin");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "paymentType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "groupUin");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "state");
            if (query.moveToFirst()) {
                if (query.isNull(columnIndexOrThrow)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow3);
                }
                int i16 = query.getInt(columnIndexOrThrow4);
                if (!query.isNull(columnIndexOrThrow5)) {
                    string4 = query.getString(columnIndexOrThrow5);
                }
                paymentStateEntity = new PaymentStateEntity(string, string2, string3, i16, string4, query.getInt(columnIndexOrThrow6));
            }
            return paymentStateEntity;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
