package com.qzone.proxy.feedcomponent.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class InterestingMsgPicturesTabList implements IDBCacheDataWrapper, SmartParcelable {
    public static final String DATA_NAME = "data";
    static final String DATA_TYPE = "BLOB";
    public static final IDBCacheDataWrapper.a<InterestingMsgPicturesTabList> DB_CREATOR = new a();

    @NeedParcel
    public ArrayList<InterestingMsgPicturesTabInfo> interestingMsgPicturesTabInfoList;

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<InterestingMsgPicturesTabList> {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
        
            if (r2 == null) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public InterestingMsgPicturesTabList createFromCursor(Cursor cursor) {
            InterestingMsgPicturesTabList interestingMsgPicturesTabList;
            Parcel parcel;
            Exception e16;
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("data"));
            Parcel parcel2 = null;
            try {
                try {
                    if (blob == null) {
                        return null;
                    }
                    try {
                        parcel = Parcel.obtain();
                        try {
                            parcel.unmarshall(blob, 0, blob.length);
                            parcel.setDataPosition(0);
                            interestingMsgPicturesTabList = (InterestingMsgPicturesTabList) ParcelableWrapper.createDataFromParcel(parcel);
                            try {
                                OaidMonitor.parcelRecycle(parcel);
                            } catch (Exception e17) {
                                e16 = e17;
                                com.qzone.proxy.feedcomponent.b.c("InterestingMsgPicturesTabList", "createFromCursor:" + e16.toString());
                            } catch (OutOfMemoryError unused) {
                                parcel2 = parcel;
                                com.qzone.proxy.feedcomponent.b.i("InterestingMsgPicturesTabList", "InterestingMsgPicturesTabList memory Error");
                                if (parcel2 != null) {
                                    OaidMonitor.parcelRecycle(parcel2);
                                }
                                return interestingMsgPicturesTabList;
                            }
                        } catch (Exception e18) {
                            e16 = e18;
                            interestingMsgPicturesTabList = null;
                        } catch (OutOfMemoryError unused2) {
                            interestingMsgPicturesTabList = null;
                        }
                    } catch (Exception e19) {
                        parcel = null;
                        e16 = e19;
                        interestingMsgPicturesTabList = null;
                    } catch (OutOfMemoryError unused3) {
                        interestingMsgPicturesTabList = null;
                    }
                    OaidMonitor.parcelRecycle(parcel);
                    return interestingMsgPicturesTabList;
                } catch (Throwable th5) {
                    th = th5;
                    parcel2 = parcel;
                    if (parcel2 != null) {
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                if (parcel2 != null) {
                    OaidMonitor.parcelRecycle(parcel2);
                }
                throw th;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("data", "BLOB")};
        }
    }

    public InterestingMsgPicturesTabList(ArrayList<InterestingMsgPicturesTabInfo> arrayList) {
        this.interestingMsgPicturesTabInfoList = arrayList;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put("data", marshall);
    }

    public InterestingMsgPicturesTabList() {
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void readFrom(ContentValues contentValues) {
    }
}
