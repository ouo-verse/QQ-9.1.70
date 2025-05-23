package com.qzone.personalize.floatobject.business.model;

import NS_MOBILE_CUSTOM.CustomFileInfo;
import NS_MOBILE_CUSTOM.FloatItem;
import NS_MOBILE_CUSTOM.FloatItemView;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.open.base.ToastUtil;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FloatCacheData extends com.qzone.component.cache.database.a implements Parcelable {
    public static final Parcelable.Creator<FloatCacheData> CREATOR = new a();
    public static final IDBCacheDataWrapper.a<FloatCacheData> DB_CREATOR = new b();
    public static final String FANGLESPEED = "fAngleSpeed";
    public static final String FSPEED = "fSpeed";
    public static final String ICOUNT = "iCount";
    public static final String IDIRECTION = "iDirection";
    public static final String IMAXANGLE = "iMaxAngle";
    public static final String IMAXSIZE = "iMaxSize";
    public static final String IMINSIZE = "iMinSize";
    public static final String IROTATIONX = "iRotationX";
    public static final String IROTATIONY = "iRotationY";
    public static final String MAPEXTINFO = "mapExtInfo";
    public static final String PARAM_CACHE_DATA = "FloatCacheData";
    public static final float SPEED_SCALE_PARAMS = 10000.0f;
    public static final String STRID = "strId";
    public static final String STRTHUMBURL = "strThumbUrl";
    public static final String TYPE_FANGLESPEED = "FLOAT";
    public static final String TYPE_FSPEED = "FLOAT";
    public static final String TYPE_ICOUNT = "INTEGER";
    public static final String TYPE_IDIRECTION = "INTEGER";
    public static final String TYPE_IMAXANGLE = "INTEGER";
    public static final String TYPE_IMAXSIZE = "INTEGER";
    public static final String TYPE_IMINSIZE = "INTEGER";
    public static final String TYPE_IROTATIONX = "INTEGER";
    public static final String TYPE_IROTATIONY = "INTEGER";
    public static final String TYPE_MAPEXTINFO = "BLOB";
    public static final String TYPE_STRID = "TEXT";
    public static final String TYPE_STRTHUMBURL = "TEXT";
    public static final String TYPE_UIN = "STRING ";
    public static final String TYPE_VECVIEW = "BLOB";
    public static final String UIN = "uin";
    public static final String VECVIEW = "vecView";
    public long uin = 0;
    public String strId = "";
    public float fSpeed = 0.0f;
    public int iMaxAngle = 0;
    public int iCount = 0;
    public float fAngleSpeed = 0.0f;
    public int iRotationX = 0;
    public int iRotationY = 0;
    public int iMaxSize = 0;
    public int iMinSize = 0;
    public int iDirection = 0;
    public String strThumbUrl = "";
    public ArrayList<FloatItemView> vecView = null;
    public Map<String, String> mapExtInfo = null;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements Parcelable.Creator<FloatCacheData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FloatCacheData createFromParcel(Parcel parcel) {
            FloatCacheData floatCacheData = new FloatCacheData();
            if (parcel != null) {
                floatCacheData.uin = parcel.readLong();
                floatCacheData.strId = parcel.readString();
                floatCacheData.fSpeed = parcel.readFloat();
                floatCacheData.iMaxAngle = parcel.readInt();
                floatCacheData.iCount = parcel.readInt();
                floatCacheData.fAngleSpeed = parcel.readFloat();
                floatCacheData.iRotationX = parcel.readInt();
                floatCacheData.iRotationY = parcel.readInt();
                floatCacheData.iMaxSize = parcel.readInt();
                floatCacheData.iMinSize = parcel.readInt();
                floatCacheData.iDirection = parcel.readInt();
                floatCacheData.strThumbUrl = parcel.readString();
                floatCacheData.vecView = parcel.readArrayList(getClass().getClassLoader());
                floatCacheData.mapExtInfo = parcel.readHashMap(getClass().getClassLoader());
            }
            return floatCacheData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FloatCacheData[] newArray(int i3) {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements IDBCacheDataWrapper.a<FloatCacheData> {
        b() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FloatCacheData createFromCursor(Cursor cursor) {
            FloatCacheData floatCacheData = new FloatCacheData();
            floatCacheData.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            floatCacheData.strId = cursor.getString(cursor.getColumnIndex("strId"));
            floatCacheData.fSpeed = cursor.getFloat(cursor.getColumnIndex(FloatCacheData.FSPEED));
            floatCacheData.iMaxAngle = cursor.getInt(cursor.getColumnIndex(FloatCacheData.IMAXANGLE));
            floatCacheData.iCount = cursor.getInt(cursor.getColumnIndex(FloatCacheData.ICOUNT));
            floatCacheData.fAngleSpeed = cursor.getFloat(cursor.getColumnIndex(FloatCacheData.FANGLESPEED));
            floatCacheData.iRotationX = cursor.getInt(cursor.getColumnIndex(FloatCacheData.IROTATIONX));
            floatCacheData.iRotationY = cursor.getInt(cursor.getColumnIndex(FloatCacheData.IROTATIONY));
            floatCacheData.iMaxSize = cursor.getInt(cursor.getColumnIndex(FloatCacheData.IMAXSIZE));
            floatCacheData.iMinSize = cursor.getInt(cursor.getColumnIndex(FloatCacheData.IMINSIZE));
            floatCacheData.iDirection = cursor.getInt(cursor.getColumnIndex(FloatCacheData.IDIRECTION));
            floatCacheData.strThumbUrl = cursor.getString(cursor.getColumnIndex("strThumbUrl"));
            floatCacheData.vecView = new ArrayList<>();
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("vecView"));
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                obtain.readList(floatCacheData.vecView, getClass().getClassLoader());
                OaidMonitor.parcelRecycle(obtain);
            } catch (Exception e16) {
                QZLog.w(e16);
            }
            byte[] blob2 = cursor.getBlob(cursor.getColumnIndex("mapExtInfo"));
            if (blob2 != null) {
                try {
                    Parcel obtain2 = Parcel.obtain();
                    obtain2.unmarshall(blob2, 0, blob2.length);
                    obtain2.setDataPosition(0);
                    floatCacheData.mapExtInfo = obtain2.readHashMap(getClass().getClassLoader());
                    OaidMonitor.parcelRecycle(obtain2);
                } catch (Exception e17) {
                    QZLog.w(e17);
                }
            }
            return floatCacheData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "STRING "), new IDBCacheDataWrapper.c("strId", "TEXT"), new IDBCacheDataWrapper.c(FloatCacheData.FSPEED, "FLOAT"), new IDBCacheDataWrapper.c(FloatCacheData.IMAXANGLE, "INTEGER"), new IDBCacheDataWrapper.c(FloatCacheData.ICOUNT, "INTEGER"), new IDBCacheDataWrapper.c(FloatCacheData.FANGLESPEED, "FLOAT"), new IDBCacheDataWrapper.c(FloatCacheData.IROTATIONX, "INTEGER"), new IDBCacheDataWrapper.c(FloatCacheData.IROTATIONY, "INTEGER"), new IDBCacheDataWrapper.c(FloatCacheData.IMAXSIZE, "INTEGER"), new IDBCacheDataWrapper.c(FloatCacheData.IMINSIZE, "INTEGER"), new IDBCacheDataWrapper.c(FloatCacheData.IDIRECTION, "INTEGER"), new IDBCacheDataWrapper.c("strThumbUrl", "TEXT"), new IDBCacheDataWrapper.c("vecView", "BLOB"), new IDBCacheDataWrapper.c("mapExtInfo", "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 2;
        }
    }

    public static FloatCacheData createFromJsonString(long j3, String str) {
        FloatCacheData floatCacheData = new FloatCacheData();
        try {
            JSONObject jSONObject = new JSONObject(str);
            floatCacheData.uin = j3;
            floatCacheData.fSpeed = jSONObject.getInt("iSpeed") / 10000.0f;
            floatCacheData.iMaxAngle = jSONObject.getInt(IMAXANGLE);
            floatCacheData.iCount = jSONObject.getInt(ICOUNT);
            floatCacheData.fAngleSpeed = jSONObject.getInt("iAngleSpeed") / 10000.0f;
            floatCacheData.iRotationX = jSONObject.getInt(IROTATIONX);
            floatCacheData.iRotationY = jSONObject.getInt(IROTATIONY);
            floatCacheData.iMaxSize = jSONObject.getInt(IMAXSIZE);
            floatCacheData.iMinSize = jSONObject.getInt(IMINSIZE);
            floatCacheData.iDirection = jSONObject.getInt(IDIRECTION);
            floatCacheData.strThumbUrl = jSONObject.getString("strThumbUrl");
            floatCacheData.vecView = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("vecView");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3).getJSONObject("CustomFileInfo");
                FloatItemView floatItemView = new FloatItemView();
                floatItemView.stFileInfo = new CustomFileInfo(jSONObject2.getInt("iFileType"), jSONObject2.getString("strFileUrl"), jSONObject2.getString("strFileMd5"), jSONObject2.getInt("iFileSize"), jSONObject2.getInt("iImageWidth"), jSONObject2.getInt("iImageHeight"));
                floatCacheData.vecView.add(floatItemView);
            }
            return floatCacheData;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put("strId", this.strId);
        contentValues.put(FSPEED, Float.valueOf(this.fSpeed));
        contentValues.put(IMAXANGLE, Integer.valueOf(this.iMaxAngle));
        contentValues.put(ICOUNT, Integer.valueOf(this.iCount));
        contentValues.put(FANGLESPEED, Float.valueOf(this.fAngleSpeed));
        contentValues.put(IROTATIONX, Integer.valueOf(this.iRotationX));
        contentValues.put(IROTATIONY, Integer.valueOf(this.iRotationY));
        contentValues.put(IMAXSIZE, Integer.valueOf(this.iMaxSize));
        contentValues.put(IMINSIZE, Integer.valueOf(this.iMinSize));
        contentValues.put(IDIRECTION, Integer.valueOf(this.iDirection));
        contentValues.put("strThumbUrl", this.strThumbUrl);
        Parcel obtain = Parcel.obtain();
        obtain.writeList(this.vecView);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put("vecView", marshall);
        Parcel obtain2 = Parcel.obtain();
        obtain2.writeMap(this.mapExtInfo);
        byte[] marshall2 = obtain2.marshall();
        OaidMonitor.parcelRecycle(obtain2);
        contentValues.put("mapExtInfo", marshall2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.uin);
        parcel.writeString(this.strId);
        parcel.writeFloat(this.fSpeed);
        parcel.writeInt(this.iMaxAngle);
        parcel.writeInt(this.iCount);
        parcel.writeFloat(this.fAngleSpeed);
        parcel.writeInt(this.iRotationX);
        parcel.writeInt(this.iRotationY);
        parcel.writeInt(this.iMaxSize);
        parcel.writeInt(this.iMinSize);
        parcel.writeInt(this.iDirection);
        parcel.writeString(this.strThumbUrl);
        parcel.writeList(this.vecView);
        parcel.writeMap(this.mapExtInfo);
    }

    public static FloatCacheData createFromResponse(long j3, FloatItem floatItem) {
        int i3;
        int i16;
        if (floatItem == null) {
            return null;
        }
        FloatCacheData floatCacheData = new FloatCacheData();
        floatCacheData.uin = j3;
        floatCacheData.strId = floatItem.strId;
        floatCacheData.fSpeed = floatItem.iSpeed / 10000.0f;
        floatCacheData.iMaxAngle = floatItem.iMaxAngle;
        floatCacheData.iCount = floatItem.iCount;
        floatCacheData.fAngleSpeed = floatItem.iAngleSpeed / 10000.0f;
        floatCacheData.iRotationX = floatItem.iRotationX;
        floatCacheData.iRotationY = floatItem.iRotationY;
        floatCacheData.iMaxSize = floatItem.iMaxSize;
        floatCacheData.iMinSize = floatItem.iMinSize;
        floatCacheData.iDirection = floatItem.iDirection;
        floatCacheData.strThumbUrl = floatItem.strThumbUrl;
        floatCacheData.vecView = floatItem.vecView;
        floatCacheData.mapExtInfo = floatItem.mapExtInfo;
        if (QZLog.isDevelopLevel() && (i3 = floatItem.iMinSize) > 0 && (i16 = floatItem.iMaxSize) > 0 && i3 > i16) {
            ToastUtil.a().f(l.a(R.string.mlb) + floatItem.iMinSize + l.a(R.string.mlc) + floatItem.iMaxSize + l.a(R.string.mld) + "\u8bf7\u8054\u7cfbQQ\u7a7a\u95f4\u8fd0\u8425\u540c\u5b66\u6539\u6b63\u914d\u7f6e\uff0c\u6f02\u6d6e\u7269id=" + floatItem.strId + " (" + floatItem.strFloatName + ")\u3002", 1);
        }
        return floatCacheData;
    }
}
