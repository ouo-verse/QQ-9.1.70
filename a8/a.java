package a8;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends com.qzone.component.cache.database.a {
    public static final IDBCacheDataWrapper.a<a> DB_CREATOR = new C0019a();
    public static final String NICKNAME = "nickname";
    public static final String NICKNAME_TYPE = "text";
    public static final String UIN = "uin";
    public static final String UTN_TYPE = "long unique";
    public String nickname;
    public long uin;

    /* compiled from: P */
    /* renamed from: a8.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0019a implements IDBCacheDataWrapper.a<a> {
        C0019a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromCursor(Cursor cursor) {
            return new a(cursor.getLong(cursor.getColumnIndex("uin")), cursor.getString(cursor.getColumnIndex("nickname")));
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 0;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", a.UTN_TYPE), new IDBCacheDataWrapper.c("nickname", "text")};
        }
    }

    public a(long j3, String str) {
        this.uin = j3;
        if (TextUtils.isEmpty(str)) {
            this.nickname = String.valueOf(j3);
        } else {
            this.nickname = str;
        }
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put("nickname", this.nickname);
    }
}
