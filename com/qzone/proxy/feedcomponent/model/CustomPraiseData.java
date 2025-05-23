package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_CustomPraise;
import NS_MOBILE_FEEDS.stcustomPraise;
import NS_QMALL_COVER.QzmallCustomPraise;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes39.dex */
public class CustomPraiseData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String CUSTOM_PRAISE_DATA = "custom_praise_data";
    public static final IDBCacheDataWrapper.a<CustomPraiseData> DB_CREATOR = new a();
    public static final String TYPE_CUSTOM_PRAISE_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 4;

    @NeedParcel
    public int cmShowActionId;

    @NeedParcel
    public int frameRate;

    @NeedParcel
    public int itemId;

    @NeedParcel
    public String praiseComboZipUrl;

    @NeedParcel
    public ImageUrl praiseIconImageUrl;

    @NeedParcel
    public String praiseIconUrl;

    @NeedParcel
    public String praiseSummery;

    @NeedParcel
    public int praiseType;

    @NeedParcel
    public String praiseZipUrl;

    @NeedParcel
    public ImageUrl strPraiseListImageUrl;

    @NeedParcel
    public String strPraisePicBefore;

    @NeedParcel
    public String strPraiseZipAfter;

    @NeedParcel
    public long uin;

    @NeedParcel
    public String strPraiseListPic = "";

    @NeedParcel
    public int subType = 0;
    public long comboCount = 1;

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<CustomPraiseData> {
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
        public CustomPraiseData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(CustomPraiseData.CUSTOM_PRAISE_DATA));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    CustomPraiseData customPraiseData = (CustomPraiseData) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    return customPraiseData;
                } catch (Exception unused) {
                } catch (OutOfMemoryError unused2) {
                    com.qzone.proxy.feedcomponent.b.i("CustomPraiseData", "CustomPraiseData createFromCursor Error");
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(CustomPraiseData.CUSTOM_PRAISE_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 4;
        }
    }

    public static CustomPraiseData createFrom(s_CustomPraise s_custompraise) {
        if (s_custompraise == null || s_custompraise.customPraise == null) {
            return null;
        }
        CustomPraiseData customPraiseData = new CustomPraiseData();
        customPraiseData.itemId = s_custompraise.iItemId;
        stcustomPraise stcustompraise = s_custompraise.customPraise;
        customPraiseData.strPraiseListPic = stcustompraise.strPraisePic;
        customPraiseData.praiseComboZipUrl = stcustompraise.strPraiseComboZip;
        customPraiseData.frameRate = stcustompraise.iFrameRate;
        customPraiseData.praiseZipUrl = stcustompraise.strPraiseZip;
        customPraiseData.comboCount = stcustompraise.uiComboCount;
        String str = TextUtils.isEmpty(stcustompraise.strPraiseButton) ? s_custompraise.customPraise.strPraisePic : s_custompraise.customPraise.strPraiseButton;
        customPraiseData.praiseIconUrl = str;
        customPraiseData.praiseIconImageUrl = PictureUrl.calculateImageUrl(str);
        stcustomPraise stcustompraise2 = s_custompraise.customPraise;
        customPraiseData.praiseType = stcustompraise2.customPraisetype;
        customPraiseData.itemId = stcustompraise2.iItemId;
        customPraiseData.cmShowActionId = stcustompraise2.iPraiseActId;
        customPraiseData.subType = stcustompraise2.subpraisetype;
        return customPraiseData;
    }

    public CellDecorateInfo.CellCustomPraise toCellCustomPraise() {
        CellDecorateInfo.CellCustomPraise cellCustomPraise = new CellDecorateInfo.CellCustomPraise();
        cellCustomPraise.iItemId = this.itemId;
        cellCustomPraise.strPraiseZip = this.praiseZipUrl;
        cellCustomPraise.strPraisePic = this.strPraiseListPic;
        cellCustomPraise.strPraiseComboZip = this.praiseComboZipUrl;
        cellCustomPraise.strPraiseButton = this.praiseIconUrl;
        cellCustomPraise.iFrameRate = this.frameRate;
        cellCustomPraise.uiComboCount = this.comboCount;
        cellCustomPraise.subType = this.subType;
        cellCustomPraise.type = this.praiseType;
        cellCustomPraise.cmShowActionId = this.cmShowActionId;
        return cellCustomPraise;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(CUSTOM_PRAISE_DATA, marshall);
    }

    public HashMap<Integer, String> toExternParam(HashMap<Integer, String> hashMap, int i3) {
        int i16;
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(108, String.valueOf(this.itemId));
        hashMap.put(109, String.valueOf(this.praiseSummery));
        hashMap.put(110, String.valueOf(this.frameRate));
        hashMap.put(111, String.valueOf(i3));
        hashMap.put(120, String.valueOf(this.praiseType));
        hashMap.put(125, String.valueOf(this.subType));
        if (this.cmShowActionId != 0 && ((i16 = this.subType) == 3 || i16 == 4)) {
            hashMap.put(199, String.valueOf(this.cmShowActionId));
        }
        return hashMap;
    }

    public static CustomPraiseData createFromResponse(QzmallCustomPraise qzmallCustomPraise) {
        if (qzmallCustomPraise == null) {
            return null;
        }
        CustomPraiseData customPraiseData = new CustomPraiseData();
        customPraiseData.uin = qzmallCustomPraise.lUin;
        customPraiseData.itemId = qzmallCustomPraise.iItemId;
        customPraiseData.praiseComboZipUrl = qzmallCustomPraise.strPraiseComboZip;
        String str = qzmallCustomPraise.strPraisePic;
        customPraiseData.praiseIconUrl = str;
        customPraiseData.praiseIconImageUrl = PictureUrl.calculateImageUrl(str);
        customPraiseData.praiseZipUrl = qzmallCustomPraise.strPraiseZip;
        customPraiseData.frameRate = qzmallCustomPraise.iFrameRate;
        customPraiseData.praiseSummery = qzmallCustomPraise.strItemSummary;
        String str2 = qzmallCustomPraise.strPraiseListPic;
        customPraiseData.strPraiseListPic = str2;
        customPraiseData.strPraiseListImageUrl = PictureUrl.calculateImageUrl(str2);
        customPraiseData.praiseType = qzmallCustomPraise.iType;
        customPraiseData.subType = qzmallCustomPraise.iSubPraisetype;
        customPraiseData.strPraisePicBefore = qzmallCustomPraise.strPraisePicBefore;
        customPraiseData.strPraiseZipAfter = qzmallCustomPraise.strPraiseZipAfter;
        int i3 = 0;
        try {
            if (!TextUtils.isEmpty(qzmallCustomPraise.strCmShowActionId)) {
                i3 = Integer.parseInt(qzmallCustomPraise.strCmShowActionId);
            }
        } catch (Exception unused) {
        }
        customPraiseData.cmShowActionId = i3;
        return customPraiseData;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomPraiseData)) {
            return false;
        }
        CustomPraiseData customPraiseData = (CustomPraiseData) obj;
        return this.uin == customPraiseData.uin && this.itemId == customPraiseData.itemId && this.frameRate == customPraiseData.frameRate && this.praiseType == customPraiseData.praiseType && this.cmShowActionId == customPraiseData.cmShowActionId && com.qzone.proxy.feedcomponent.util.k.b(this.praiseIconUrl, customPraiseData.praiseIconUrl) && com.qzone.proxy.feedcomponent.util.k.b(this.praiseComboZipUrl, customPraiseData.praiseComboZipUrl) && com.qzone.proxy.feedcomponent.util.k.b(this.praiseZipUrl, customPraiseData.praiseZipUrl) && com.qzone.proxy.feedcomponent.util.k.b(this.praiseSummery, customPraiseData.praiseSummery) && com.qzone.proxy.feedcomponent.util.k.b(this.strPraiseListPic, customPraiseData.strPraiseListPic);
    }

    public static CustomPraiseData createFrom(long j3, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            CustomPraiseData customPraiseData = new CustomPraiseData();
            customPraiseData.uin = j3;
            customPraiseData.itemId = jSONObject.getInt("itemId");
            customPraiseData.praiseType = jSONObject.optInt("CustomPraiseType", 0);
            customPraiseData.praiseIconUrl = jSONObject.getString("praiseButton");
            customPraiseData.praiseIconImageUrl = PictureUrl.calculateImageUrl(jSONObject.getString("praiseButton"));
            customPraiseData.strPraiseListPic = jSONObject.getString("praiseThumb");
            customPraiseData.praiseZipUrl = jSONObject.getString("praiseZip");
            customPraiseData.praiseComboZipUrl = jSONObject.getString("praiseComboZip");
            customPraiseData.frameRate = jSONObject.getInt("frameRate");
            customPraiseData.praiseSummery = jSONObject.getString("summery");
            int optInt = jSONObject.optInt("subPraiseType", 0);
            customPraiseData.subType = optInt;
            if (optInt == 3) {
                try {
                    String optString = jSONObject.optString("cmActionId", "");
                    if (!TextUtils.isEmpty(optString)) {
                        customPraiseData.cmShowActionId = Integer.parseInt(optString);
                    }
                } catch (Exception unused) {
                    com.qzone.proxy.feedcomponent.b.c("CustomPraiseData", "cmShowActionId erro");
                    customPraiseData.cmShowActionId = 0;
                }
            }
            return customPraiseData;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static CustomPraiseData createFrom(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getFeedCommInfo().extendInfo == null) {
            return null;
        }
        String str = businessFeedData.getFeedCommInfo().extendInfo.get("high_five_iconUrlZip");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        CustomPraiseData customPraiseData = new CustomPraiseData();
        customPraiseData.itemId = 1;
        customPraiseData.praiseZipUrl = str;
        customPraiseData.praiseComboZipUrl = str;
        customPraiseData.frameRate = 30;
        return customPraiseData;
    }

    public static CustomPraiseData createFrom(CellDecorateInfo.CellCustomPraise cellCustomPraise) {
        if (cellCustomPraise == null) {
            return null;
        }
        CustomPraiseData customPraiseData = new CustomPraiseData();
        customPraiseData.itemId = cellCustomPraise.iItemId;
        customPraiseData.strPraiseListPic = cellCustomPraise.strPraisePic;
        String str = cellCustomPraise.strPraiseButton;
        customPraiseData.praiseIconUrl = str;
        customPraiseData.praiseIconImageUrl = PictureUrl.calculateImageUrl(str);
        customPraiseData.frameRate = cellCustomPraise.iFrameRate;
        customPraiseData.praiseComboZipUrl = cellCustomPraise.strPraiseComboZip;
        customPraiseData.praiseZipUrl = cellCustomPraise.strPraiseZip;
        customPraiseData.praiseType = cellCustomPraise.type;
        customPraiseData.comboCount = cellCustomPraise.uiComboCount;
        customPraiseData.subType = cellCustomPraise.subType;
        customPraiseData.cmShowActionId = cellCustomPraise.cmShowActionId;
        return customPraiseData;
    }
}
