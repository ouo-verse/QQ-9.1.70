package com.qzone.album.data.model;

import NS_MOBILE_MATERIAL.MaterialCate;
import NS_MOBILE_MATERIAL.MaterialItem;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MaterialCateCacheData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String CATEID = "iCateId";
    public static final IDBCacheDataWrapper.a<MaterialCateCacheData> DB_CREATOR = new a();
    public static final String TYPE_CATEID = "INTEGER";
    public static final String TYPE_VECITEM = "BLOB";
    public static final String VECITEM = "vecItem";
    public int iCateId;

    @NeedParcel
    public ArrayList<MaterialItem> vecItem = null;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<MaterialCateCacheData> {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
        
            if (r1 == null) goto L14;
         */
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public MaterialCateCacheData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(MaterialCateCacheData.VECITEM));
            Parcel obtain = Parcel.obtain();
            MaterialCateCacheData materialCateCacheData = null;
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    MaterialCateCacheData materialCateCacheData2 = (MaterialCateCacheData) ParcelableWrapper.createDataFromParcel(obtain);
                    if (materialCateCacheData2 != null) {
                        try {
                            materialCateCacheData2.iCateId = cursor.getInt(cursor.getColumnIndex(MaterialCateCacheData.CATEID));
                        } catch (Exception unused) {
                            materialCateCacheData = materialCateCacheData2;
                        } catch (OutOfMemoryError unused2) {
                            materialCateCacheData = materialCateCacheData2;
                            QZLog.w("MaterialCateCacheData", "MaterialCateCacheData createFromCursor Error");
                        }
                    }
                    OaidMonitor.parcelRecycle(obtain);
                    return materialCateCacheData2;
                } catch (Exception unused3) {
                } catch (OutOfMemoryError unused4) {
                }
            } finally {
                if (obtain != null) {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(MaterialCateCacheData.CATEID, "INTEGER"), new IDBCacheDataWrapper.c(MaterialCateCacheData.VECITEM, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 2;
        }
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(CATEID, Integer.valueOf(this.iCateId));
        Parcel obtain = Parcel.obtain();
        obtain.writeList(this.vecItem);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(VECITEM, marshall);
    }

    public static MaterialCateCacheData createFromResponse(long j3, MaterialCate materialCate) {
        if (materialCate == null) {
            return null;
        }
        MaterialCateCacheData materialCateCacheData = new MaterialCateCacheData();
        materialCateCacheData.iCateId = materialCate.iCateId;
        materialCateCacheData.vecItem = materialCate.vecItem;
        return materialCateCacheData;
    }
}
