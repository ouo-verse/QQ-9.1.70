package com.qzone.homepage.ui.component.newpanel;

import NS_MOBILE_MAIN_PAGE.s_red_info;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RedInfo extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<RedInfo> DB_CREATOR = new a();
    private static final String DESC = "desc";
    private static final String IS_NEW = "uIsNew";
    private static final String LOGO = "logo";
    private static final String SUMMARY = "summary";
    private static final String UIN = "uin";

    @NeedParcel
    public String desc;

    @NeedParcel
    public String logo;

    @NeedParcel
    public String summary;

    @NeedParcel
    public long uIsNew;

    @NeedParcel
    public long uin;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<RedInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RedInfo createFromCursor(Cursor cursor) {
            RedInfo redInfo = new RedInfo();
            redInfo.logo = cursor.getString(cursor.getColumnIndex(RedInfo.LOGO));
            redInfo.summary = cursor.getString(cursor.getColumnIndex("summary"));
            redInfo.desc = cursor.getString(cursor.getColumnIndex("desc"));
            redInfo.uIsNew = cursor.getLong(cursor.getColumnIndex(RedInfo.IS_NEW));
            redInfo.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            return redInfo;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(RedInfo.LOGO, "TEXT"), new IDBCacheDataWrapper.c("summary", "TEXT"), new IDBCacheDataWrapper.c("desc", "TEXT"), new IDBCacheDataWrapper.c(RedInfo.IS_NEW, "INTEGER"), new IDBCacheDataWrapper.c("uin", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 0;
        }
    }

    public static RedInfo createFrom(s_red_info s_red_infoVar) {
        RedInfo redInfo = new RedInfo();
        redInfo.logo = s_red_infoVar.logo;
        redInfo.summary = s_red_infoVar.summary;
        redInfo.desc = s_red_infoVar.desc;
        redInfo.uIsNew = s_red_infoVar.uIsNew;
        redInfo.uin = s_red_infoVar.uin;
        return redInfo;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("RedInfo {\n");
        if (!TextUtils.isEmpty(this.logo)) {
            sb5.append("logo: ");
            sb5.append(this.logo);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.summary)) {
            sb5.append("summary: ");
            sb5.append(this.summary);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.desc)) {
            sb5.append("desc: ");
            sb5.append(this.desc);
            sb5.append("\n");
        }
        sb5.append("uIsNew: ");
        sb5.append(this.uIsNew);
        sb5.append("}");
        return sb5.toString();
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(LOGO, this.logo);
        contentValues.put("summary", this.summary);
        contentValues.put("desc", this.desc);
        contentValues.put(IS_NEW, Long.valueOf(this.uIsNew));
        contentValues.put("uin", Long.valueOf(this.uin));
    }
}
