package com.qzone.business.plusunion.business.model;

import NS_MOBILE_EXTRA.s_app_info;
import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AppInfo extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<AppInfo> DB_CREATOR = new a();
    private static final int VERSION = 8;

    @NeedParcel
    public int appid;

    @NeedParcel
    public String appname;

    @NeedParcel
    public String downloadUrl;

    @NeedParcel
    public String h5_url;

    @NeedParcel
    public String iconUrl;

    @NeedParcel
    public int isRecommend;

    @NeedParcel
    public int maskAppType;

    @NeedParcel
    public String packageName;

    @NeedParcel
    public String recommendComment;

    @NeedParcel
    public String summary;
    public int appType = 11;
    public long installTime = 0;
    public int cancelable = 0;

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("app_type", Integer.valueOf(this.appType));
        contentValues.put("install_time", Long.valueOf(this.installTime));
        contentValues.put("cancelable", Integer.valueOf(this.cancelable));
        contentValues.put("app_id", Integer.valueOf(this.appid));
        contentValues.put("app_name", this.appname);
        contentValues.put("icon_url", this.iconUrl);
        contentValues.put("download_url", this.downloadUrl);
        contentValues.put("summary", this.summary);
        contentValues.put("is_recommend", Integer.valueOf(this.isRecommend));
        contentValues.put("package", this.packageName);
        contentValues.put("html5_url", this.h5_url);
        contentValues.put("recommend_comment", this.recommendComment);
        contentValues.put("maskAppType", Integer.valueOf(this.maskAppType));
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<AppInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("app_type", "INTEGER"), new IDBCacheDataWrapper.c("install_time", "LONG"), new IDBCacheDataWrapper.c("cancelable", "INTEGER"), new IDBCacheDataWrapper.c("app_id", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("app_name", "TEXT"), new IDBCacheDataWrapper.c("icon_url", "TEXT"), new IDBCacheDataWrapper.c("download_url", "TEXT"), new IDBCacheDataWrapper.c("summary", "TEXT"), new IDBCacheDataWrapper.c("is_recommend", "INTEGER"), new IDBCacheDataWrapper.c("package", "TEXT"), new IDBCacheDataWrapper.c("html5_url", "TEXT"), new IDBCacheDataWrapper.c("recommend_comment", "TEXT"), new IDBCacheDataWrapper.c("maskAppType", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 8;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppInfo createFromCursor(Cursor cursor) {
            if (cursor == null) {
                return null;
            }
            AppInfo appInfo = new AppInfo();
            int columnIndex = cursor.getColumnIndex("app_type");
            if (columnIndex >= 0) {
                appInfo.appType = cursor.getInt(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("install_time");
            if (columnIndex2 >= 0) {
                appInfo.installTime = cursor.getLong(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("cancelable");
            if (columnIndex3 >= 0) {
                appInfo.cancelable = cursor.getInt(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("app_id");
            if (columnIndex4 >= 0) {
                appInfo.appid = cursor.getInt(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("app_name");
            if (columnIndex5 >= 0) {
                appInfo.appname = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("icon_url");
            if (columnIndex6 >= 0) {
                appInfo.iconUrl = cursor.getString(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex("download_url");
            if (columnIndex7 >= 0) {
                appInfo.downloadUrl = cursor.getString(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex("summary");
            if (columnIndex8 >= 0) {
                appInfo.summary = cursor.getString(columnIndex8);
            }
            int columnIndex9 = cursor.getColumnIndex("is_recommend");
            if (columnIndex9 >= 0) {
                appInfo.isRecommend = cursor.getInt(columnIndex9);
            }
            int columnIndex10 = cursor.getColumnIndex("package");
            if (columnIndex10 >= 0) {
                appInfo.packageName = cursor.getString(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex("html5_url");
            if (columnIndex11 >= 0) {
                appInfo.h5_url = cursor.getString(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex("recommend_comment");
            if (columnIndex12 >= 0) {
                appInfo.recommendComment = cursor.getString(columnIndex12);
            }
            int columnIndex13 = cursor.getColumnIndex("maskAppType");
            if (columnIndex13 >= 0) {
                appInfo.maskAppType = cursor.getInt(columnIndex13);
            }
            return appInfo;
        }
    }

    public static AppInfo createFrom(s_app_info s_app_infoVar) {
        if (s_app_infoVar == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.appid = s_app_infoVar.appid;
        appInfo.appname = s_app_infoVar.appname;
        appInfo.iconUrl = s_app_infoVar.iconurl;
        appInfo.downloadUrl = s_app_infoVar.downloadurl_android;
        appInfo.summary = s_app_infoVar.summary;
        appInfo.isRecommend = s_app_infoVar.isrecommend;
        appInfo.packageName = s_app_infoVar.packagename;
        appInfo.appType = 11;
        appInfo.installTime = 0L;
        appInfo.cancelable = 1;
        appInfo.h5_url = s_app_infoVar.h5_url;
        appInfo.recommendComment = s_app_infoVar.recommendcomment;
        appInfo.maskAppType = s_app_infoVar.apptype;
        return appInfo;
    }
}
