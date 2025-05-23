package com.qzone.homepage.business.model;

import NS_MOBILE_MATERIAL.CustomTrack;
import NS_MOBILE_MATERIAL.CustomTrackAction;
import NS_MOBILE_MATERIAL.UgcCustomTrack;
import NS_QMALL_COVER.CustomTrackDeco;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.b;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneCustomTrackData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String COLUMN_CUSTOMTRACK_DATA = "custom_track_data";
    public static final IDBCacheDataWrapper.a<QzoneCustomTrackData> DB_CREATOR = new a();
    public static final String TYPE_COLUMN_CUSTOMTRACK_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 1;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public int iItemId = -1;

    @NeedParcel
    public int iAppId = 149;

    @NeedParcel
    public int dataSource = -1;

    @NeedParcel
    public ArrayList<FunnySpaceModel> blockModelList = new ArrayList<>();

    @NeedParcel
    public ArrayList<FunnySpaceModel> normalModelList = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<QzoneCustomTrackData> {
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
        public QzoneCustomTrackData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(QzoneCustomTrackData.COLUMN_CUSTOMTRACK_DATA));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    QzoneCustomTrackData qzoneCustomTrackData = (QzoneCustomTrackData) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    return qzoneCustomTrackData;
                } catch (Exception unused) {
                } catch (OutOfMemoryError unused2) {
                    b.i("QzoneCustomTrackData", "QzoneCustomTrackData createFromCursor Error");
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(QzoneCustomTrackData.COLUMN_CUSTOMTRACK_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034 A[Catch: all -> 0x0058, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000d, B:8:0x0017, B:10:0x001a, B:12:0x0026, B:14:0x002a, B:15:0x002e, B:17:0x0034, B:24:0x003e, B:20:0x004a), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized QzoneCustomTrackData customtrackreadFromJce(long j3, CustomTrackDeco customTrackDeco) {
        QzoneCustomTrackData qzoneCustomTrackData;
        CustomTrack customTrack;
        ArrayList<CustomTrackAction> arrayList;
        Iterator<CustomTrackAction> it;
        synchronized (QzoneCustomTrackData.class) {
            qzoneCustomTrackData = new QzoneCustomTrackData();
            qzoneCustomTrackData.uin = j3;
            if (customTrackDeco != null) {
                qzoneCustomTrackData.iItemId = customTrackDeco.iItemId;
                qzoneCustomTrackData.dataSource = 1;
                byte[] bArr = customTrackDeco.strExtFields;
                if (bArr != null && bArr.length != 0) {
                    customTrack = (CustomTrack) t5.b.b(CustomTrack.class, bArr);
                    if (customTrack != null && (arrayList = customTrack.Actions) != null) {
                        it = arrayList.iterator();
                        while (it.hasNext()) {
                            CustomTrackAction next = it.next();
                            if (next.is_block == 1) {
                                qzoneCustomTrackData.blockModelList.add(FunnySpaceModel.createCustomTrack(next, qzoneCustomTrackData.iItemId));
                            } else {
                                qzoneCustomTrackData.normalModelList.add(FunnySpaceModel.createCustomTrack(next, qzoneCustomTrackData.iItemId));
                            }
                        }
                    }
                }
            }
            customTrack = null;
            if (customTrack != null) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
            }
        }
        return qzoneCustomTrackData;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[Catch: all -> 0x0056, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:8:0x0015, B:10:0x0018, B:12:0x0024, B:14:0x0028, B:15:0x002c, B:17:0x0032, B:24:0x003c, B:20:0x0048), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized QzoneCustomTrackData customtrackreadFromUgcBuffer(long j3, UgcCustomTrack ugcCustomTrack) {
        QzoneCustomTrackData qzoneCustomTrackData;
        CustomTrack customTrack;
        ArrayList<CustomTrackAction> arrayList;
        Iterator<CustomTrackAction> it;
        synchronized (QzoneCustomTrackData.class) {
            qzoneCustomTrackData = new QzoneCustomTrackData();
            if (ugcCustomTrack != null) {
                qzoneCustomTrackData.iItemId = ugcCustomTrack.iItemId;
                qzoneCustomTrackData.dataSource = 1;
                byte[] bArr = ugcCustomTrack.strExtFields;
                if (bArr != null && bArr.length != 0) {
                    customTrack = (CustomTrack) t5.b.b(CustomTrack.class, bArr);
                    if (customTrack != null && (arrayList = customTrack.Actions) != null) {
                        it = arrayList.iterator();
                        while (it.hasNext()) {
                            CustomTrackAction next = it.next();
                            if (next.is_block == 1) {
                                qzoneCustomTrackData.blockModelList.add(FunnySpaceModel.createCustomTrack(next, qzoneCustomTrackData.iItemId));
                            } else {
                                qzoneCustomTrackData.normalModelList.add(FunnySpaceModel.createCustomTrack(next, qzoneCustomTrackData.iItemId));
                            }
                        }
                    }
                }
            }
            customTrack = null;
            if (customTrack != null) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
            }
        }
        return qzoneCustomTrackData;
    }

    public static synchronized List<FunnySpaceModel> mergeToatalModels(QzoneCustomTrackData qzoneCustomTrackData, List<FunnySpaceModel> list) {
        synchronized (QzoneCustomTrackData.class) {
            if (list == null) {
                list = new ArrayList<>();
            } else {
                list.clear();
            }
            ArrayList<FunnySpaceModel> arrayList = qzoneCustomTrackData.normalModelList;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<FunnySpaceModel> it = qzoneCustomTrackData.normalModelList.iterator();
                while (it.hasNext()) {
                    FunnySpaceModel next = it.next();
                    if (next != null) {
                        list.add(next);
                    }
                }
            }
            ArrayList<FunnySpaceModel> arrayList2 = qzoneCustomTrackData.blockModelList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<FunnySpaceModel> it5 = qzoneCustomTrackData.blockModelList.iterator();
                while (it5.hasNext()) {
                    FunnySpaceModel next2 = it5.next();
                    if (next2 != null) {
                        list.add(next2);
                    }
                }
            }
        }
        return list;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(COLUMN_CUSTOMTRACK_DATA, marshall);
    }

    @Override // com.qzone.component.cache.database.a, com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void readFrom(ContentValues contentValues) {
    }
}
