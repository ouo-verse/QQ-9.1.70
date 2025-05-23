package com.qzone.personalize.business;

import NS_MOBILE_MATERIAL.MaterialCate;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_MATERIAL.material_cate_get_rsp;
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
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NewCardSkinDataTotal extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<NewCardSkinDataTotal> DB_CREATOR = new a();
    public static final String PERSONAL_NEWCARD_DATA = "personalnewcard_data";
    private static final String TAG = "NewCardSkinDataTotal";
    public static final String TYPE_FIRE_CRACKER_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 1;

    @NeedParcel
    public String defaultFont;

    @NeedParcel
    public int iNewFeedSkin;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public ArrayList<FeedSkinData> fontList = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<NewCardSkinDataTotal> {
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
        public NewCardSkinDataTotal createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(NewCardSkinDataTotal.PERSONAL_NEWCARD_DATA));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    NewCardSkinDataTotal newCardSkinDataTotal = (NewCardSkinDataTotal) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    return newCardSkinDataTotal;
                } catch (Exception unused) {
                } catch (OutOfMemoryError unused2) {
                    QZLog.w("PersonalFontData", "PersonalFontData createFromCursor Error");
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(NewCardSkinDataTotal.PERSONAL_NEWCARD_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    public static NewCardSkinDataTotal createFromResponse(long j3, material_cate_get_rsp material_cate_get_rspVar) {
        MaterialCate materialCate;
        if (material_cate_get_rspVar == null || (materialCate = material_cate_get_rspVar.stCate) == null || materialCate.vecItem == null) {
            return null;
        }
        NewCardSkinDataTotal newCardSkinDataTotal = new NewCardSkinDataTotal();
        newCardSkinDataTotal.uin = j3;
        try {
            newCardSkinDataTotal.iNewFeedSkin = transferToInt(material_cate_get_rspVar.stCate.mapExtInfo.get("iNewFeedSkin"));
            if (material_cate_get_rspVar.stCate.mapExtInfo.containsKey("iLastUsedId")) {
                newCardSkinDataTotal.defaultFont = material_cate_get_rspVar.stCate.mapExtInfo.get("iLastUsedId");
            } else {
                newCardSkinDataTotal.defaultFont = "-2";
            }
            QZLog.d(TAG, 4, "@newcard list size = " + newCardSkinDataTotal.defaultFont);
            Iterator<MaterialItem> it = material_cate_get_rspVar.stCate.vecItem.iterator();
            while (it.hasNext()) {
                FeedSkinData fromMatirialInfo = FeedSkinData.fromMatirialInfo(it.next(), j3, false);
                if (fromMatirialInfo != null) {
                    newCardSkinDataTotal.fontList.add(fromMatirialInfo);
                }
            }
            if (QZLog.isDevelopLevel()) {
                QZLog.d(TAG, 4, "@newcard list size = " + newCardSkinDataTotal.fontList.size());
            }
        } catch (Throwable th5) {
            QZLog.e(TAG, "createFromResponse Throwable, msg = " + th5.getMessage());
        }
        return newCardSkinDataTotal;
    }

    private static int transferToInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable th5) {
            QZLog.e(TAG, "transferToInt Throwable, msg = " + th5.getMessage());
            return 0;
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
        contentValues.put(PERSONAL_NEWCARD_DATA, marshall);
    }
}
