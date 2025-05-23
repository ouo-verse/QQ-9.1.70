package com.qzone.proxy.feedcomponent.model;

import NS_QMALL_COVER.PolymorphicPraise;
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
public class PolymorphicPraiseData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<PolymorphicPraiseData> DB_CREATOR = new a();
    public static final String POLY_PRAISE_DATA = "polymorphic_praise_data";
    public static final String TYPE_POLY_PRAISE_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 4;

    @NeedParcel
    public ArrayList<PolymorphicPraiseEmotionData> emotionDatas;

    @NeedParcel
    public int itemId;

    @NeedParcel
    public PolymorphicPraiseEmotionData polyPraiseEmotionData;

    @NeedParcel
    public int polyPraiseType = 0;

    @NeedParcel
    public long uin;

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<PolymorphicPraiseData> {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        
            if (r0 == null) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        
            com.tencent.qmethod.pandoraex.monitor.OaidMonitor.parcelRecycle(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        
            if (r0 == null) goto L14;
         */
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public PolymorphicPraiseData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(PolymorphicPraiseData.POLY_PRAISE_DATA));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    try {
                        obtain.unmarshall(blob, 0, blob.length);
                        obtain.setDataPosition(0);
                        PolymorphicPraiseData polymorphicPraiseData = (PolymorphicPraiseData) ParcelableWrapper.createDataFromParcel(obtain);
                        OaidMonitor.parcelRecycle(obtain);
                        return polymorphicPraiseData;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                } catch (OutOfMemoryError unused) {
                    com.qzone.proxy.feedcomponent.b.i("PolymorphicPraiseData", "PolymorphicPraiseData createFromCursor Error");
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(PolymorphicPraiseData.POLY_PRAISE_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 4;
        }
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(POLY_PRAISE_DATA, marshall);
    }

    public static PolymorphicPraiseData createFromJce(PolymorphicPraise polymorphicPraise) {
        if (polymorphicPraise == null) {
            return null;
        }
        PolymorphicPraiseData polymorphicPraiseData = new PolymorphicPraiseData();
        polymorphicPraiseData.uin = com.qzone.adapter.feedcomponent.i.H().j0();
        polymorphicPraiseData.itemId = polymorphicPraise.iItemId;
        polymorphicPraiseData.emotionDatas = PolymorphicPraiseEmotionData.createEmotionDataFromJce(polymorphicPraise.vecEmotionPraise);
        polymorphicPraiseData.polyPraiseEmotionData = PolymorphicPraiseEmotionData.createFromJce(polymorphicPraise.stOperationPraise);
        polymorphicPraiseData.polyPraiseType = polymorphicPraise.iGuideToUse;
        return polymorphicPraiseData;
    }

    public boolean equals(Object obj) {
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData;
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PolymorphicPraiseData)) {
            return false;
        }
        PolymorphicPraiseData polymorphicPraiseData = (PolymorphicPraiseData) obj;
        if (polymorphicPraiseData.itemId != this.itemId || polymorphicPraiseData.emotionDatas == null || this.emotionDatas == null || (!((polymorphicPraiseEmotionData = polymorphicPraiseData.polyPraiseEmotionData) == null && this.polyPraiseEmotionData == null) && ((polymorphicPraiseEmotionData2 = this.polyPraiseEmotionData) == null || !polymorphicPraiseEmotionData2.equals(polymorphicPraiseEmotionData)))) {
            return false;
        }
        int size = this.emotionDatas.size();
        int size2 = polymorphicPraiseData.emotionDatas.size();
        if (size2 < size) {
            size = size2;
        }
        for (int i3 = 0; i3 < size; i3++) {
            PolymorphicPraiseEmotionData polymorphicPraiseEmotionData3 = this.emotionDatas.get(i3);
            PolymorphicPraiseEmotionData polymorphicPraiseEmotionData4 = polymorphicPraiseData.emotionDatas.get(i3);
            if (polymorphicPraiseEmotionData4 == null || !polymorphicPraiseEmotionData4.equals(polymorphicPraiseEmotionData3)) {
                return false;
            }
        }
        return true;
    }
}
