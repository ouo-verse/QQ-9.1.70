package com.qzone.common.business.model;

import NS_MOBILE_CUSTOM.AvatarItem;
import NS_MOBILE_CUSTOM.AvatarItemView;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AvatarCacheData extends com.qzone.component.cache.database.a implements Parcelable {
    public static final IDBCacheDataWrapper.a<AvatarCacheData> DB_CREATOR = new a();
    public static final String IHASNEWFLAG = "iHasNewFlag";
    public static final String IPROPERTY = "iProperty";
    public static final String ITYPE = "iType";
    public static final String MAPEXTINFO = "mapExtInfo";
    public static final String PARAM_CACHE_DATA = "AvatarCacheData";
    public static final String PARAM_NAMEPLATE = "isNameplate";
    public static final String STRAVATARNAME = "strAvatarName";
    public static final String STRDESCRIPTION = "strDescription";
    public static final String STRID = "strId";
    public static final String STRTHUMBURL = "strThumbUrl";
    public static final String STRTRACEINFO = "strTraceInfo";
    public static final String TAG = "AvatarCacheData";
    public static final String TYPE_IHASNEWFLAG = "INTEGER";
    public static final String TYPE_IPROPERTY = "INTEGER";
    public static final String TYPE_ITYPE = "INTEGER";
    public static final String TYPE_MAPEXTINFO = "BLOB";
    public static final String TYPE_STRAVATARNAME = "TEXT";
    public static final String TYPE_STRDESCRIPTION = "TEXT";
    public static final String TYPE_STRID = "TEXT";
    public static final String TYPE_STRTHUMBURL = "TEXT";
    public static final String TYPE_STRTRACEINFO = "TEXT";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String TYPE_VECVIEW = "BLOB";
    public static final String UIN = "uin";
    public static final String VECVIEW = "vecView";
    public long uin = 0;
    public String strId = "";
    public int iType = 0;
    public int iProperty = 0;
    public String strAvatarName = "";
    public String strDescription = "";
    public String strThumbUrl = "";
    public ArrayList<AvatarItemView> vecView = null;
    public int iHasNewFlag = 0;
    public String strTraceInfo = "";
    public Map<String, String> mapExtInfo = null;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AvatarCacheData createFromCursor(Cursor cursor) {
            byte[] blob;
            AvatarCacheData avatarCacheData = new AvatarCacheData();
            int columnIndex = cursor.getColumnIndex("uin");
            if (columnIndex >= 0) {
                avatarCacheData.uin = cursor.getLong(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("strId");
            if (columnIndex2 >= 0) {
                avatarCacheData.strId = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex(AvatarCacheData.ITYPE);
            if (columnIndex3 >= 0) {
                avatarCacheData.iType = cursor.getInt(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex(AvatarCacheData.IPROPERTY);
            if (columnIndex4 >= 0) {
                avatarCacheData.iProperty = cursor.getInt(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex(AvatarCacheData.STRAVATARNAME);
            if (columnIndex5 >= 0) {
                avatarCacheData.strAvatarName = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex(AvatarCacheData.STRDESCRIPTION);
            if (columnIndex6 >= 0) {
                avatarCacheData.strDescription = cursor.getString(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex("strThumbUrl");
            if (columnIndex7 >= 0) {
                avatarCacheData.strThumbUrl = cursor.getString(columnIndex7);
            }
            avatarCacheData.vecView = new ArrayList<>();
            int columnIndex8 = cursor.getColumnIndex("vecView");
            if (columnIndex8 >= 0) {
                byte[] blob2 = cursor.getBlob(columnIndex8);
                try {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(blob2, 0, blob2.length);
                    obtain.setDataPosition(0);
                    obtain.readList(avatarCacheData.vecView, AvatarItemView.class.getClassLoader());
                    OaidMonitor.parcelRecycle(obtain);
                } catch (Exception e16) {
                    QZLog.w(e16);
                }
            }
            int columnIndex9 = cursor.getColumnIndex(AvatarCacheData.IHASNEWFLAG);
            if (columnIndex9 >= 0) {
                avatarCacheData.iHasNewFlag = cursor.getInt(columnIndex9);
            }
            int columnIndex10 = cursor.getColumnIndex(AvatarCacheData.STRTRACEINFO);
            if (columnIndex10 >= 0) {
                avatarCacheData.strTraceInfo = cursor.getString(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex("mapExtInfo");
            if (columnIndex11 >= 0 && (blob = cursor.getBlob(columnIndex11)) != null) {
                try {
                    Parcel obtain2 = Parcel.obtain();
                    obtain2.unmarshall(blob, 0, blob.length);
                    obtain2.setDataPosition(0);
                    avatarCacheData.mapExtInfo = obtain2.readHashMap(getClass().getClassLoader());
                    OaidMonitor.parcelRecycle(obtain2);
                } catch (Exception e17) {
                    QZLog.w(e17);
                }
            }
            return avatarCacheData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("strId", "TEXT"), new IDBCacheDataWrapper.c(AvatarCacheData.ITYPE, "INTEGER"), new IDBCacheDataWrapper.c(AvatarCacheData.IPROPERTY, "INTEGER"), new IDBCacheDataWrapper.c(AvatarCacheData.STRAVATARNAME, "TEXT"), new IDBCacheDataWrapper.c(AvatarCacheData.STRDESCRIPTION, "TEXT"), new IDBCacheDataWrapper.c("strThumbUrl", "TEXT"), new IDBCacheDataWrapper.c("vecView", "BLOB"), new IDBCacheDataWrapper.c(AvatarCacheData.IHASNEWFLAG, "INTEGER"), new IDBCacheDataWrapper.c(AvatarCacheData.STRTRACEINFO, "TEXT"), new IDBCacheDataWrapper.c("mapExtInfo", "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 3;
        }
    }

    public static AvatarCacheData createFromResponse(long j3, AvatarItem avatarItem) {
        AvatarCacheData avatarCacheData = new AvatarCacheData();
        avatarCacheData.uin = j3;
        avatarCacheData.strId = avatarItem.strId;
        avatarCacheData.iType = avatarItem.iType;
        avatarCacheData.iProperty = avatarItem.iProperty;
        avatarCacheData.strAvatarName = avatarItem.strAvatarName;
        avatarCacheData.strDescription = avatarItem.strDescription;
        avatarCacheData.strThumbUrl = avatarItem.strThumbUrl;
        avatarCacheData.vecView = avatarItem.vecView;
        avatarCacheData.iHasNewFlag = avatarItem.iHasNewFlag;
        avatarCacheData.strTraceInfo = avatarItem.strTraceInfo;
        avatarCacheData.mapExtInfo = avatarItem.mapExtInfo;
        return avatarCacheData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put("strId", this.strId);
        contentValues.put(ITYPE, Integer.valueOf(this.iType));
        contentValues.put(IPROPERTY, Integer.valueOf(this.iProperty));
        contentValues.put(STRAVATARNAME, this.strAvatarName);
        contentValues.put(STRDESCRIPTION, this.strDescription);
        contentValues.put("strThumbUrl", this.strThumbUrl);
        Parcel obtain = Parcel.obtain();
        obtain.writeList(this.vecView);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put("vecView", marshall);
        contentValues.put(IHASNEWFLAG, Integer.valueOf(this.iHasNewFlag));
        contentValues.put(STRTRACEINFO, this.strTraceInfo);
        Parcel obtain2 = Parcel.obtain();
        obtain2.writeMap(this.mapExtInfo);
        byte[] marshall2 = obtain2.marshall();
        OaidMonitor.parcelRecycle(obtain2);
        contentValues.put("mapExtInfo", marshall2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeList(this.vecView);
    }
}
