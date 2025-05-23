package com.qzone.homepage.ui.Facade.model;

import NS_MOBILE_CUSTOM.Facade;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FacadeCacheData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String CATE = "cate";
    public static final String CATE_DB_TYPE = "TEXT";
    public static final IDBCacheDataWrapper.a<FacadeCacheData> DB_CREATOR = new a();
    public static final String DESCRIPTION = "description";
    public static final String DESCRIPTION_DB_TYPE = "TEXT";
    public static final String DYNAMIC_TYPE = "dynamic_type";
    public static final String DYNAMIC_TYPE_DB_TYPE = "INTEGER";
    public static final String EXT_INFO = "ext_info";
    public static final String EXT_INFO_DB_TYPE = "BLOB";
    public static final String FACADE_SET = "facade_set_sub_ids";
    public static final String FACADE_SET_DB_TYPE = "BLOB";
    public static final String FACADE_STYLE = "facade_style";
    public static final String FACADE_STYLE_DB_TYPE = "INTEGER";
    public static final String FACADE_VIEW_DATA = "facade_view_data";
    public static final String FACADE_VIEW_DATA_TYPE = "BLOB";
    public static final String HAS_NEW = "has_new";
    public static final String HAS_NEW_DB_TYPE = "INTEGER";
    public static final String ID = "item_id";
    public static final String ID_DB_TYPE = "TEXT UNIQUE";
    public static final String IS_EDITABLE = "is_editable";
    public static final String IS_EDITABLE_DB_TYPE = "INTEGER";
    public static final String NAME = "name";
    public static final String NAME_DB_TYPE = "TEXT";
    public static final String THUMB_URL = "thumb_url";
    public static final String THUMB_URL_DB_TYPE = "TEXT";
    public static final String TRACE_INFO = "trace_info";
    public static final String TRACE_INFO_DB_TYPE = "TEXT";
    public static final String TYPE = "type";
    public static final String TYPE_DB_TYPE = "INTEGER";
    public static final int VERSION = 2;

    /* renamed from: VIP, reason: collision with root package name */
    public static final String f47632VIP = "vip_property";
    public static final String VIP_DB_TYPE = "INTEGER";

    @NeedParcel
    public int isEditable;

    @NeedParcel
    public int isNew;

    @NeedParcel
    public String mDescription;

    @NeedParcel
    public Map<String, String> mExtInfo;

    @NeedParcel
    public int mFacadeStyle;

    @NeedParcel
    public volatile ArrayList<FacadeViewData> mFacadeViewDatas;

    @NeedParcel
    public String mId;

    @NeedParcel
    public String mName;

    @NeedParcel
    public int mSubTypeForDynamic;

    @NeedParcel
    public String mThumbUrl;

    @NeedParcel
    public String mTraceInfo;

    @NeedParcel
    public int mType;

    @NeedParcel
    public int mVipProperty;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<FacadeCacheData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FacadeCacheData createFromCursor(Cursor cursor) {
            FacadeCacheData facadeCacheData = new FacadeCacheData();
            facadeCacheData.mId = cursor.getString(cursor.getColumnIndex("item_id"));
            facadeCacheData.mType = cursor.getInt(cursor.getColumnIndex("type"));
            facadeCacheData.mVipProperty = cursor.getInt(cursor.getColumnIndex(FacadeCacheData.f47632VIP));
            facadeCacheData.mName = cursor.getString(cursor.getColumnIndex("name"));
            facadeCacheData.mSubTypeForDynamic = cursor.getInt(cursor.getColumnIndex(FacadeCacheData.DYNAMIC_TYPE));
            facadeCacheData.mDescription = cursor.getString(cursor.getColumnIndex("description"));
            facadeCacheData.mThumbUrl = cursor.getString(cursor.getColumnIndex(FacadeCacheData.THUMB_URL));
            facadeCacheData.isNew = cursor.getInt(cursor.getColumnIndex(FacadeCacheData.HAS_NEW));
            facadeCacheData.isEditable = cursor.getInt(cursor.getColumnIndex(FacadeCacheData.IS_EDITABLE));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(FacadeCacheData.FACADE_VIEW_DATA));
            if (blob != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                facadeCacheData.mFacadeViewDatas = ParcelableWrapper.createArrayListFromParcel(obtain);
                if (facadeCacheData.mFacadeViewDatas != null) {
                    facadeCacheData.mFacadeViewDatas.removeAll(Collections.singleton(null));
                }
                OaidMonitor.parcelRecycle(obtain);
            }
            facadeCacheData.mFacadeStyle = cursor.getInt(cursor.getColumnIndex(FacadeCacheData.FACADE_STYLE));
            facadeCacheData.mTraceInfo = cursor.getString(cursor.getColumnIndex("trace_info"));
            byte[] blob2 = cursor.getBlob(cursor.getColumnIndex("ext_info"));
            if (blob2 != null) {
                Parcel obtain2 = Parcel.obtain();
                obtain2.unmarshall(blob2, 0, blob2.length);
                obtain2.setDataPosition(0);
                facadeCacheData.mExtInfo = obtain2.readHashMap(getClass().getClassLoader());
                OaidMonitor.parcelRecycle(obtain2);
            }
            return facadeCacheData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("item_id", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("cate", "TEXT"), new IDBCacheDataWrapper.c("type", "INTEGER"), new IDBCacheDataWrapper.c(FacadeCacheData.f47632VIP, "INTEGER"), new IDBCacheDataWrapper.c("name", "TEXT"), new IDBCacheDataWrapper.c(FacadeCacheData.DYNAMIC_TYPE, "INTEGER"), new IDBCacheDataWrapper.c("description", "TEXT"), new IDBCacheDataWrapper.c(FacadeCacheData.THUMB_URL, "TEXT"), new IDBCacheDataWrapper.c(FacadeCacheData.FACADE_SET, "BLOB"), new IDBCacheDataWrapper.c(FacadeCacheData.HAS_NEW, "INTEGER"), new IDBCacheDataWrapper.c(FacadeCacheData.IS_EDITABLE, "INTEGER"), new IDBCacheDataWrapper.c(FacadeCacheData.FACADE_VIEW_DATA, "BLOB"), new IDBCacheDataWrapper.c(FacadeCacheData.FACADE_STYLE, "INTEGER"), new IDBCacheDataWrapper.c("trace_info", "TEXT"), new IDBCacheDataWrapper.c("ext_info", "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 2;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FacadeCacheData)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return ((FacadeCacheData) obj).mId.equals(this.mId);
    }

    public List<String> getImageUrls() {
        ArrayList<ConfigArea> arrayList;
        DownloadableInfo downloadableInfo;
        ArrayList arrayList2 = new ArrayList();
        if (this.mFacadeViewDatas != null) {
            Iterator<FacadeViewData> it = this.mFacadeViewDatas.iterator();
            while (it.hasNext()) {
                FacadeViewData next = it.next();
                if (next != null && (downloadableInfo = next.mCustomFileInfo) != null) {
                    arrayList2.add(downloadableInfo.fileUrl);
                }
                if (next != null && (arrayList = next.mConfigRect) != null) {
                    Iterator<ConfigArea> it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        ConfigArea next2 = it5.next();
                        if (next2 != null && !TextUtils.isEmpty(next2.imageUrl)) {
                            arrayList2.add(next2.imageUrl);
                        }
                    }
                }
            }
        } else if (QZLog.isDevelopLevel()) {
            QZLog.d("FACADE", 4, "facade id:" + this.mId + ", name:" + this.mName + ", config rects: null");
        }
        return arrayList2;
    }

    public List<String> getImageWithoutAvatarUrls() {
        ArrayList<ConfigArea> arrayList;
        DownloadableInfo downloadableInfo;
        ArrayList arrayList2 = new ArrayList();
        if (this.mFacadeViewDatas != null) {
            Iterator<FacadeViewData> it = this.mFacadeViewDatas.iterator();
            while (it.hasNext()) {
                FacadeViewData next = it.next();
                if (next != null && (downloadableInfo = next.mCustomFileInfo) != null) {
                    arrayList2.add(downloadableInfo.fileUrl);
                }
                if (next != null && (arrayList = next.mConfigRect) != null) {
                    Iterator<ConfigArea> it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        ConfigArea next2 = it5.next();
                        if (next2 != null && !TextUtils.isEmpty(next2.imageUrl) && next2.type != 11) {
                            arrayList2.add(next2.imageUrl);
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    public String getTransparentVideoBgUrl() {
        Map<String, String> map = this.mExtInfo;
        if (map == null || !map.containsKey("strTransparentVideo")) {
            return null;
        }
        return this.mExtInfo.get("strTransparentVideo");
    }

    public String getVideoBgUrl() {
        Map<String, String> map = this.mExtInfo;
        if (map == null || !map.containsKey("strAnimationVideoUrl")) {
            return null;
        }
        return this.mExtInfo.get("strAnimationVideoUrl");
    }

    public int hashCode() {
        String str = this.mId;
        return 217 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "facadeId:" + this.mId + " facadeName:" + this.mName + " description" + this.mDescription;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("item_id", this.mId);
        contentValues.put("type", Integer.valueOf(this.mType));
        contentValues.put(f47632VIP, Integer.valueOf(this.mVipProperty));
        contentValues.put("name", this.mName);
        contentValues.put(DYNAMIC_TYPE, Integer.valueOf(this.mSubTypeForDynamic));
        contentValues.put("description", this.mDescription);
        contentValues.put(THUMB_URL, this.mThumbUrl);
        contentValues.put(HAS_NEW, Integer.valueOf(this.isNew));
        contentValues.put(IS_EDITABLE, Integer.valueOf(this.isEditable));
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeArrayListToParcel(obtain, 0, this.mFacadeViewDatas);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(FACADE_VIEW_DATA, marshall);
        contentValues.put(FACADE_STYLE, Integer.valueOf(this.mFacadeStyle));
        contentValues.put("trace_info", this.mTraceInfo);
        Parcel obtain2 = Parcel.obtain();
        obtain2.writeMap(this.mExtInfo);
        byte[] marshall2 = obtain2.marshall();
        OaidMonitor.parcelRecycle(obtain2);
        contentValues.put("ext_info", marshall2);
    }

    public static FacadeCacheData createFromJce(Facade facade, long j3) {
        if (facade == null) {
            return null;
        }
        FacadeCacheData facadeCacheData = new FacadeCacheData();
        facadeCacheData.mId = facade.strId;
        facadeCacheData.mType = facade.iType;
        facadeCacheData.mVipProperty = facade.iProperty;
        facadeCacheData.mName = facade.strFacadeName;
        facadeCacheData.mDescription = facade.strDescription;
        facadeCacheData.mThumbUrl = facade.strThumbUrl;
        facadeCacheData.isNew = facade.iHasNewFlag;
        facadeCacheData.isEditable = facade.iCanEdit;
        facadeCacheData.mFacadeViewDatas = FacadeViewData.createFromJce(facade.vecView, j3);
        if (facadeCacheData.mFacadeViewDatas != null) {
            facadeCacheData.mFacadeViewDatas.removeAll(Collections.singleton(null));
        }
        facadeCacheData.mFacadeStyle = facade.iStyle;
        facadeCacheData.mTraceInfo = facade.strTraceInfo;
        facadeCacheData.mExtInfo = facade.mapExtInfo;
        return facadeCacheData;
    }
}
