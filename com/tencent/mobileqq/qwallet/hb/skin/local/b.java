package com.tencent.mobileqq.qwallet.hb.skin.local;

import android.annotation.SuppressLint;
import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.skin.local.a;
import com.tencent.mtt.hippy.dom.node.TextNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes16.dex */
public final class b implements com.tencent.mobileqq.qwallet.hb.skin.local.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f277857a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter<HbSkinData> f277858b;

    /* renamed from: c, reason: collision with root package name */
    private final g f277859c = new g();

    /* renamed from: d, reason: collision with root package name */
    private final f f277860d = new f();

    /* renamed from: e, reason: collision with root package name */
    private final SharedSQLiteStatement f277861e;

    /* renamed from: f, reason: collision with root package name */
    private final SharedSQLiteStatement f277862f;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends EntityInsertionAdapter<HbSkinData> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, HbSkinData hbSkinData) {
            supportSQLiteStatement.bindLong(1, hbSkinData.getSkinId());
            if (hbSkinData.getOuterSkinId() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, hbSkinData.getOuterSkinId());
            }
            supportSQLiteStatement.bindLong(3, hbSkinData.getSkinFrom());
            supportSQLiteStatement.bindLong(4, hbSkinData.getSkinType());
            supportSQLiteStatement.bindLong(5, hbSkinData.getPrice());
            if (hbSkinData.getTitle() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, hbSkinData.getTitle());
            }
            if (hbSkinData.getMerchantName() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, hbSkinData.getMerchantName());
            }
            if (hbSkinData.getMerchantLogoUrl() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, hbSkinData.getMerchantLogoUrl());
            }
            if (hbSkinData.getActivityEntryName() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, hbSkinData.getActivityEntryName());
            }
            if (hbSkinData.getActivityUrl() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, hbSkinData.getActivityUrl());
            }
            if (hbSkinData.getActivityIcon() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, hbSkinData.getActivityIcon());
            }
            if (hbSkinData.getDefaultSkinUrl() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, hbSkinData.getDefaultSkinUrl());
            }
            if (hbSkinData.getAioResUrl() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, hbSkinData.getAioResUrl());
            }
            if (hbSkinData.getPopResUrl() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, hbSkinData.getPopResUrl());
            }
            if (hbSkinData.getPopOpenUrl() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, hbSkinData.getPopOpenUrl());
            }
            if (hbSkinData.getPopBrokenUrl() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, hbSkinData.getPopBrokenUrl());
            }
            String a16 = b.this.f277859c.a(hbSkinData.getTail());
            if (a16 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, a16);
            }
            String a17 = b.this.f277860d.a(hbSkinData.t());
            if (a17 == null) {
                supportSQLiteStatement.bindNull(18);
            } else {
                supportSQLiteStatement.bindString(18, a17);
            }
            if (hbSkinData.getVersion() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, hbSkinData.getVersion());
            }
            supportSQLiteStatement.bindLong(20, hbSkinData.getExpireTimeMs());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `hb_skin_table` (`skinId`,`outerSkinId`,`skinFrom`,`skinType`,`price`,`title`,`merchantName`,`merchantLogoUrl`,`activityEntryName`,`activityUrl`,`activityIcon`,`defaultSkinUrl`,`aioResUrl`,`popResUrl`,`popOpenUrl`,`popBrokenUrl`,`tail`,`storyResList`,`version`,`expireTimeMs`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qwallet.hb.skin.local.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C8466b extends SharedSQLiteStatement {
        C8466b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM hb_skin_table WHERE skinFrom = 0 AND version is not ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM hb_skin_table WHERE skinFrom != 0 AND expireTimeMs < ?";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f277857a = roomDatabase;
        this.f277858b = new a(roomDatabase);
        this.f277861e = new C8466b(roomDatabase);
        this.f277862f = new c(roomDatabase);
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.local.a
    public void a(String str) {
        this.f277857a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f277861e.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.f277857a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f277857a.setTransactionSuccessful();
        } finally {
            this.f277857a.endTransaction();
            this.f277861e.release(acquire);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.local.a
    public void b(long j3) {
        this.f277857a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f277862f.acquire();
        acquire.bindLong(1, j3);
        this.f277857a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f277857a.setTransactionSuccessful();
        } finally {
            this.f277857a.endTransaction();
            this.f277862f.release(acquire);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.local.a
    public long c(HbSkinData hbSkinData) {
        this.f277857a.assertNotSuspendingTransaction();
        this.f277857a.beginTransaction();
        try {
            long insertAndReturnId = this.f277858b.insertAndReturnId(hbSkinData);
            this.f277857a.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.f277857a.endTransaction();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.local.a
    public void d(List<HbSkinData> list, String str, long j3, Function1<? super String, Unit> function1) {
        this.f277857a.beginTransaction();
        try {
            a.C8465a.a(this, list, str, j3, function1);
            this.f277857a.setTransactionSuccessful();
        } finally {
            this.f277857a.endTransaction();
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.local.a
    public HbSkinData e(int i3, String str, int i16) {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        HbSkinData hbSkinData;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        int i17;
        String string11;
        int i18;
        String string12;
        int i19;
        String string13;
        String string14;
        String string15;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM hb_skin_table WHERE skinId is ? AND outerSkinId is ? AND skinFrom is ?", 3);
        acquire.bindLong(1, i3);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        acquire.bindLong(3, i16);
        this.f277857a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f277857a, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "skinId");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "outerSkinId");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "skinFrom");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "skinType");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "price");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "title");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "merchantName");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "merchantLogoUrl");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "activityEntryName");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "activityUrl");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "activityIcon");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "defaultSkinUrl");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "aioResUrl");
            roomSQLiteQuery = acquire;
        } catch (Throwable th5) {
            th = th5;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "popResUrl");
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "popOpenUrl");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "popBrokenUrl");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, TextNode.MODE_TAIL);
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "storyResList");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "version");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "expireTimeMs");
                if (query.moveToFirst()) {
                    int i26 = query.getInt(columnIndexOrThrow);
                    if (query.isNull(columnIndexOrThrow2)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow2);
                    }
                    int i27 = query.getInt(columnIndexOrThrow3);
                    int i28 = query.getInt(columnIndexOrThrow4);
                    int i29 = query.getInt(columnIndexOrThrow5);
                    if (query.isNull(columnIndexOrThrow6)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow6);
                    }
                    if (query.isNull(columnIndexOrThrow7)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow7);
                    }
                    if (query.isNull(columnIndexOrThrow8)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow8);
                    }
                    if (query.isNull(columnIndexOrThrow9)) {
                        string5 = null;
                    } else {
                        string5 = query.getString(columnIndexOrThrow9);
                    }
                    if (query.isNull(columnIndexOrThrow10)) {
                        string6 = null;
                    } else {
                        string6 = query.getString(columnIndexOrThrow10);
                    }
                    if (query.isNull(columnIndexOrThrow11)) {
                        string7 = null;
                    } else {
                        string7 = query.getString(columnIndexOrThrow11);
                    }
                    if (query.isNull(columnIndexOrThrow12)) {
                        string8 = null;
                    } else {
                        string8 = query.getString(columnIndexOrThrow12);
                    }
                    if (query.isNull(columnIndexOrThrow13)) {
                        string9 = null;
                    } else {
                        string9 = query.getString(columnIndexOrThrow13);
                    }
                    if (query.isNull(columnIndexOrThrow14)) {
                        i17 = columnIndexOrThrow15;
                        string10 = null;
                    } else {
                        string10 = query.getString(columnIndexOrThrow14);
                        i17 = columnIndexOrThrow15;
                    }
                    if (query.isNull(i17)) {
                        i18 = columnIndexOrThrow16;
                        string11 = null;
                    } else {
                        string11 = query.getString(i17);
                        i18 = columnIndexOrThrow16;
                    }
                    if (query.isNull(i18)) {
                        i19 = columnIndexOrThrow17;
                        string12 = null;
                    } else {
                        string12 = query.getString(i18);
                        i19 = columnIndexOrThrow17;
                    }
                    if (query.isNull(i19)) {
                        string13 = null;
                    } else {
                        string13 = query.getString(i19);
                    }
                    try {
                        HbSkinData.Tail b16 = this.f277859c.b(string13);
                        if (query.isNull(columnIndexOrThrow18)) {
                            string14 = null;
                        } else {
                            string14 = query.getString(columnIndexOrThrow18);
                        }
                        ArrayList<HbSkinData.StoryRes> b17 = this.f277860d.b(string14);
                        if (query.isNull(columnIndexOrThrow19)) {
                            string15 = null;
                        } else {
                            string15 = query.getString(columnIndexOrThrow19);
                        }
                        hbSkinData = new HbSkinData(i26, string, i27, i28, i29, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, b16, b17, string15, query.getLong(columnIndexOrThrow20));
                    } catch (Throwable th6) {
                        th = th6;
                        query.close();
                        roomSQLiteQuery.release();
                        throw th;
                    }
                } else {
                    hbSkinData = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return hbSkinData;
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            th = th8;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.skin.local.a
    public void insertAll(List<HbSkinData> list) {
        this.f277857a.assertNotSuspendingTransaction();
        this.f277857a.beginTransaction();
        try {
            this.f277858b.insert(list);
            this.f277857a.setTransactionSuccessful();
        } finally {
            this.f277857a.endTransaction();
        }
    }
}
