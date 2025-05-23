package com.qzone.homepage.diy.protocol;

import FACADE_DIY.UserFacadeInfo;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.homepage.diy.preload.DIYPreloadData;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.b;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneDIYData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<QzoneDIYData> DB_CREATOR = new a();
    public static final String QZONE_DIY_DATA = "qzone_diy_data";
    private static final String TAG = "QzoneDIYData";
    public static final String TYPE_QBOSS_ADV_DESC_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 1;

    @NeedParcel
    public String checksum;

    @NeedParcel
    public int code;

    /* renamed from: id, reason: collision with root package name */
    @NeedParcel
    public String f47531id;

    @NeedParcel
    public String layout;

    @NeedParcel
    public DIYPreloadData prealoadData;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public int switchStatus = 0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<QzoneDIYData> {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        
            if (r0 != null) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        
            com.tencent.qmethod.pandoraex.monitor.OaidMonitor.parcelRecycle(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
        
            if (r0 == null) goto L12;
         */
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public QzoneDIYData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(QzoneDIYData.QZONE_DIY_DATA));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    QzoneDIYData qzoneDIYData = (QzoneDIYData) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    return qzoneDIYData;
                } catch (Exception unused) {
                } catch (OutOfMemoryError unused2) {
                    b.i(QzoneDIYData.TAG, "QzoneDIYData createFromCursor Error");
                }
            } catch (Throwable th5) {
                if (obtain != null) {
                    OaidMonitor.parcelRecycle(obtain);
                }
                throw th5;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(QzoneDIYData.QZONE_DIY_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    private static DIYPreloadData parseJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        DIYPreloadData dIYPreloadData = new DIYPreloadData();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 2) {
                JSONArray optJSONArray = jSONArray.optJSONObject(0).optJSONArray("child");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        if (optJSONObject != null) {
                            if ("0".equals(optJSONObject.optString("id"))) {
                                if (!dIYPreloadData.mIsVideo) {
                                    dIYPreloadData.mIsVideo = false;
                                }
                                dIYPreloadData.mImageUrl = optJSONObject.optString("content");
                            } else if ("1".equals(optJSONObject.optString("id"))) {
                                dIYPreloadData.mIsVideo = true;
                                dIYPreloadData.mVideoUrl = optJSONObject.optString("content");
                                dIYPreloadData.mVideoFrameUrl = optJSONObject.optString("video_frame");
                            }
                            if (QZLog.isColorLevel()) {
                                QZLog.i(TAG, 2, " parseJson id = " + optJSONObject.optString("id"));
                            }
                        }
                    }
                }
            } else if (QZLog.isColorLevel()) {
                QZLog.i(TAG, 2, "preloadResources with json array error json = " + str);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return dIYPreloadData;
    }

    public String toString() {
        return "id = " + this.f47531id + " code =" + this.code + " layout = " + this.layout;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(QZONE_DIY_DATA, marshall);
    }

    public static QzoneDIYData createQzoneDIYData(long j3, UserFacadeInfo userFacadeInfo) {
        if (userFacadeInfo == null) {
            return null;
        }
        QzoneDIYData qzoneDIYData = new QzoneDIYData();
        qzoneDIYData.uin = j3;
        qzoneDIYData.checksum = userFacadeInfo.checksum;
        qzoneDIYData.code = userFacadeInfo.code;
        String str = userFacadeInfo.layout;
        qzoneDIYData.layout = str;
        qzoneDIYData.f47531id = userFacadeInfo.f24896id;
        qzoneDIYData.switchStatus = userFacadeInfo.switchStatus;
        qzoneDIYData.prealoadData = parseJson(str);
        return qzoneDIYData;
    }

    @Override // com.qzone.component.cache.database.a, com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void readFrom(ContentValues contentValues) {
    }
}
