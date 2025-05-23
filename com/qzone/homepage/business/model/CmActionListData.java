package com.qzone.homepage.business.model;

import NS_QMALL_COVER.CmShowQzoneTrack;
import NS_QMALL_COVER.UserCmShowQzoneTrack;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.b;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CmActionListData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String COLUMN_2D_ACTION_LIST_DATA = "column_2d_action_list_data";
    public static final String COLUMN_3D_ACTION_LIST_DATA = "column_3d_action_list_data";
    public static final IDBCacheDataWrapper.a<CmActionListData> DB_CREATOR = new a();
    private static final String TAG = "CmActionListData";
    public static final String TYPE_COLUMN_2D_ACTION_LIST_DATA = "BLOB";
    public static final String TYPE_COLUMN_3D_ACTION_LIST_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 3;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public ArrayList<CmActionData> m2DActionList = null;

    @NeedParcel
    public ArrayList<CmActionData> m3DActionList = null;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<CmActionListData> {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0056, code lost:
        
            if (r1 != null) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x006d, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x005d, code lost:
        
            com.tencent.qmethod.pandoraex.monitor.OaidMonitor.parcelRecycle(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
        
            if (r1 != null) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
        
            if (r1 == null) goto L18;
         */
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public CmActionListData createFromCursor(Cursor cursor) {
            CmActionListData cmActionListData = new CmActionListData();
            cmActionListData.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            Parcel parcel = null;
            try {
                try {
                    byte[] blob = cursor.getBlob(cursor.getColumnIndex(CmActionListData.COLUMN_2D_ACTION_LIST_DATA));
                    if (blob != null) {
                        parcel = Parcel.obtain();
                        parcel.unmarshall(blob, 0, blob.length);
                        parcel.setDataPosition(0);
                        cmActionListData.m2DActionList = ParcelableWrapper.createArrayListFromParcel(parcel);
                        OaidMonitor.parcelRecycle(parcel);
                    }
                    byte[] blob2 = cursor.getBlob(cursor.getColumnIndex(CmActionListData.COLUMN_3D_ACTION_LIST_DATA));
                    if (blob2 != null) {
                        parcel = Parcel.obtain();
                        parcel.unmarshall(blob2, 0, blob2.length);
                        parcel.setDataPosition(0);
                        cmActionListData.m3DActionList = ParcelableWrapper.createArrayListFromParcel(parcel);
                        OaidMonitor.parcelRecycle(parcel);
                    }
                } catch (Exception unused) {
                } catch (OutOfMemoryError unused2) {
                    b.i(CmActionListData.TAG, "CmActionListData createFromCursor Error");
                }
            } catch (Throwable th5) {
                if (parcel != null) {
                    OaidMonitor.parcelRecycle(parcel);
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(CmActionListData.COLUMN_2D_ACTION_LIST_DATA, "BLOB"), new IDBCacheDataWrapper.c(CmActionListData.COLUMN_3D_ACTION_LIST_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 3;
        }
    }

    public static CmActionListData createActionListFromJce(long j3, UserCmShowQzoneTrack userCmShowQzoneTrack) {
        if (userCmShowQzoneTrack != null && userCmShowQzoneTrack.vecQzoneTrack != null && userCmShowQzoneTrack.vecQzoneTrack3D != null) {
            CmActionListData cmActionListData = new CmActionListData();
            ArrayList<CmActionData> arrayList = new ArrayList<>(userCmShowQzoneTrack.vecQzoneTrack.size());
            ArrayList<CmActionData> arrayList2 = new ArrayList<>(userCmShowQzoneTrack.vecQzoneTrack3D.size());
            Iterator<CmShowQzoneTrack> it = userCmShowQzoneTrack.vecQzoneTrack.iterator();
            while (it.hasNext()) {
                CmActionData create = CmActionData.create(it.next());
                if (create != null) {
                    arrayList.add(create);
                }
            }
            Iterator<CmShowQzoneTrack> it5 = userCmShowQzoneTrack.vecQzoneTrack3D.iterator();
            while (it5.hasNext()) {
                CmActionData create2 = CmActionData.create(it5.next());
                if (create2 != null) {
                    arrayList2.add(create2);
                }
            }
            cmActionListData.uin = j3;
            cmActionListData.m2DActionList = arrayList;
            cmActionListData.m3DActionList = arrayList2;
            if (QZLog.isColorLevel()) {
                QZLog.i(TAG, 2, " createActionListFromJce data = " + cmActionListData.toString());
            }
            return cmActionListData;
        }
        QZLog.i(TAG, 1, " CmActionListData create data = null");
        return null;
    }

    private void putParcelValue(ContentValues contentValues, String str, ArrayList<CmActionData> arrayList) {
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeArrayListToParcel(obtain, 0, arrayList);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(str, marshall);
    }

    public String toString() {
        String str;
        ArrayList<CmActionData> arrayList = this.m2DActionList;
        if (arrayList == null && this.m3DActionList == null) {
            return " action list = null";
        }
        String str2 = "";
        if (arrayList == null) {
            str = "";
        } else {
            str = arrayList.toString();
        }
        ArrayList<CmActionData> arrayList2 = this.m3DActionList;
        if (arrayList2 != null) {
            str2 = arrayList2.toString();
        }
        return "\n2d data = " + str + "\n 3d = " + str2;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        putParcelValue(contentValues, COLUMN_2D_ACTION_LIST_DATA, this.m2DActionList);
        putParcelValue(contentValues, COLUMN_3D_ACTION_LIST_DATA, this.m3DActionList);
    }
}
