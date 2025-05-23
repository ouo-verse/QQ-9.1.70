package com.qzone.publish.ui.model;

import NS_MOBILE_MATERIAL.BubbleSource;
import NS_MOBILE_MATERIAL.CommentBubble;
import NS_MOBILE_MATERIAL.CommentUgcDeco;
import NS_MOBILE_MATERIAL.MaterialCate;
import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_MATERIAL.UgcDecoQualReq;
import NS_MOBILE_MATERIAL.material_cate_get_rsp;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.JceUtils;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneBarrageEffectData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final String BARRAGE_EFFECT_DATA = "barrage_effect_data";
    public static final IDBCacheDataWrapper.a<QzoneBarrageEffectData> DB_CREATOR = new a();
    private static final String TAG = "SuperPersonalFontData";
    public static final String TYPE_BARRAGE_EFFECT_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 1;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public ArrayList<BarrageEffectInfo> fontList = new ArrayList<>();

    @NeedParcel
    public int defaultFont = 0;

    @NeedParcel
    public int newCustomFontId = 0;

    @NeedParcel
    public long newCustomFontIdEndTime = 0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<QzoneBarrageEffectData> {
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
        public QzoneBarrageEffectData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(QzoneBarrageEffectData.BARRAGE_EFFECT_DATA));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    QzoneBarrageEffectData qzoneBarrageEffectData = (QzoneBarrageEffectData) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    return qzoneBarrageEffectData;
                } catch (Exception unused) {
                } catch (OutOfMemoryError unused2) {
                    QZLog.w("QzoneBarrageEffectData", "QzoneBarrageEffectData createFromCursor Error");
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(QzoneBarrageEffectData.BARRAGE_EFFECT_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    public static QzoneBarrageEffectData createFromResponse(long j3, material_cate_get_rsp material_cate_get_rspVar) {
        MaterialCate materialCate;
        if (material_cate_get_rspVar == null || (materialCate = material_cate_get_rspVar.stCate) == null || materialCate.vecItem == null) {
            return null;
        }
        QzoneBarrageEffectData qzoneBarrageEffectData = new QzoneBarrageEffectData();
        qzoneBarrageEffectData.uin = j3;
        try {
            if (!TextUtils.isEmpty(material_cate_get_rspVar.stCate.mapExtInfo.get("iLastUsedId"))) {
                qzoneBarrageEffectData.defaultFont = transferToInt(material_cate_get_rspVar.stCate.mapExtInfo.get("iLastUsedId"));
            } else {
                qzoneBarrageEffectData.defaultFont = -1;
            }
            Iterator<MaterialItem> it = material_cate_get_rspVar.stCate.vecItem.iterator();
            while (it.hasNext()) {
                MaterialItem next = it.next();
                BarrageEffectInfo barrageEffectInfo = new BarrageEffectInfo();
                barrageEffectInfo.coverUrl = next.stThumb.strUrl;
                barrageEffectInfo.price = next.iPrice;
                barrageEffectInfo.name = next.strItemName;
                barrageEffectInfo.f51896id = next.iItemId;
                barrageEffectInfo.fontType = next.iItemType;
                boolean z16 = true;
                if (transferToInt(next.mapExtInfo.get("iUserQualType")) != 1) {
                    z16 = false;
                }
                barrageEffectInfo.hasAuth = z16;
                barrageEffectInfo.fillData(next);
                barrageEffectInfo.fontUsedTips = next.mapExtInfo.get("strPriceDesc");
                barrageEffectInfo.actId = next.mapExtInfo.get("iActId");
                barrageEffectInfo.ruleId = next.mapExtInfo.get("iRuleId");
                barrageEffectInfo.type = next.iTypeId;
                BubbleSource bubbleSource = new BubbleSource();
                bubbleSource.strTextColor1 = next.mapExtInfo.get("strTextColor1");
                bubbleSource.strTextColor2 = next.mapExtInfo.get("strTextColor2");
                if (next.vecFile.size() > 4) {
                    bubbleSource.strAndUrl1 = next.vecFile.get(2).strUrl;
                    bubbleSource.strAndUrl2 = next.vecFile.get(3).strUrl;
                }
                if (next.vecFile.size() > 2) {
                    barrageEffectInfo.strFrameZip = next.vecFile.get(2).strUrl;
                }
                barrageEffectInfo.stSource = bubbleSource;
                if (next.mapExtInfo.containsKey("iFrameRate")) {
                    barrageEffectInfo.iFrameRate = Integer.parseInt(next.mapExtInfo.get("iFrameRate"));
                }
                qzoneBarrageEffectData.fontList.add(barrageEffectInfo);
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 2, "font list size = " + qzoneBarrageEffectData.fontList.size());
            }
        } catch (Throwable th5) {
            QZLog.e(TAG, "createFromResponse Throwable, msg = " + th5.getMessage());
        }
        return qzoneBarrageEffectData;
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

    private static long transferToLong(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable th5) {
            QZLog.e(TAG, "transferToLong Throwable, msg = " + th5.getMessage());
            return 0L;
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
        contentValues.put(BARRAGE_EFFECT_DATA, marshall);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class BarrageEffectInfo implements SmartParcelable {

        @NeedParcel
        public String coverUrl = "";

        @NeedParcel
        public int price = 0;

        @NeedParcel
        public String name = "";

        @NeedParcel
        public int fontType = 0;

        @NeedParcel
        public boolean hasAuth = false;

        @NeedParcel
        public String fontUsedTips = "";

        @NeedParcel
        public String actId = "";

        @NeedParcel
        public String ruleId = "";

        /* renamed from: id, reason: collision with root package name */
        @NeedParcel
        public int f51896id = -1;

        @NeedParcel
        public String strTextColor = "";

        @NeedParcel
        public String strAndBgUrl = "";

        @NeedParcel
        public String strIosBgUrl = "";

        @NeedParcel
        public int type = 0;

        @NeedParcel
        public BubbleSource stSource = null;

        @NeedParcel
        public String strFrameZip = "";

        @NeedParcel
        public int iFrameRate = -1;

        public static BarrageEffectInfo fromJson(String str) {
            BarrageEffectInfo barrageEffectInfo = new BarrageEffectInfo();
            barrageEffectInfo.fillData(str);
            return barrageEffectInfo;
        }

        public static int parseColor(String str) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            String trim = str.trim();
            if (!trim.startsWith("#")) {
                trim = "#" + trim;
            }
            try {
                return Color.parseColor(trim);
            } catch (Exception e16) {
                e16.printStackTrace();
                return 0;
            }
        }

        public void fillData(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f51896id = jSONObject.optInt("iItemId");
                this.strTextColor = jSONObject.optString("strTextColor");
                this.strAndBgUrl = jSONObject.optString("strAndBgUrl");
                this.strIosBgUrl = jSONObject.optString("strIosBgUrl");
                this.type = jSONObject.optInt("type");
                BubbleSource bubbleSource = new BubbleSource();
                bubbleSource.strAndUrl1 = jSONObject.optString("strAndUrl1");
                bubbleSource.strAndUrl2 = jSONObject.optString("strAndUrl2");
                bubbleSource.strTextColor1 = jSONObject.optString("strTextColor1");
                bubbleSource.strTextColor2 = jSONObject.optString("strTextColor2");
                this.stSource = bubbleSource;
                this.strFrameZip = jSONObject.optString("strFrameZip");
                this.iFrameRate = jSONObject.optInt("iFrameRate");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        public byte[] toJceData() {
            if (this.f51896id <= 0) {
                return null;
            }
            CommentUgcDeco commentUgcDeco = new CommentUgcDeco();
            CommentBubble commentBubble = new CommentBubble();
            commentUgcDeco.stBubble = commentBubble;
            commentBubble.iItemId = this.f51896id;
            commentBubble.strAndBgUrl = this.strAndBgUrl;
            commentBubble.strTextColor = this.strTextColor;
            commentBubble.strIosBgUrl = this.strIosBgUrl;
            commentBubble.eType = this.type;
            commentBubble.stSource = this.stSource;
            commentBubble.strFrameZip = this.strFrameZip;
            commentBubble.iFrameRate = this.iFrameRate;
            return JceUtils.encodeWup(commentUgcDeco);
        }

        public byte[] toJceReqData() {
            UgcDecoQualReq ugcDecoQualReq = new UgcDecoQualReq();
            HashMap hashMap = new HashMap();
            ugcDecoQualReq.mapItemId = hashMap;
            hashMap.put(128, Integer.valueOf(this.f51896id));
            return JceUtils.encodeWup(ugcDecoQualReq);
        }

        public String toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("iItemId", this.f51896id);
                jSONObject.put("strTextColor", this.strTextColor);
                jSONObject.put("strAndBgUrl", this.strAndBgUrl);
                jSONObject.put("strIosBgUrl", this.strIosBgUrl);
                jSONObject.put("type", this.type);
                jSONObject.put("strAndUrl1", this.stSource.strAndUrl1);
                jSONObject.put("strAndUrl2", this.stSource.strAndUrl2);
                jSONObject.put("strTextColor1", this.stSource.strTextColor1);
                jSONObject.put("strTextColor2", this.stSource.strTextColor2);
                jSONObject.put("iFrameRate", this.iFrameRate);
                jSONObject.put("strFrameZip", this.strFrameZip);
                return jSONObject.toString();
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }

        public static BarrageEffectInfo fromFeedsJceData(byte[] bArr) {
            CommentUgcDeco commentUgcDeco;
            CommentBubble commentBubble;
            if (bArr == null || (commentUgcDeco = (CommentUgcDeco) JceUtils.decodeWup(CommentUgcDeco.class, bArr)) == null || (commentBubble = commentUgcDeco.stBubble) == null || commentBubble.iItemId <= 0) {
                return null;
            }
            BarrageEffectInfo barrageEffectInfo = new BarrageEffectInfo();
            CommentBubble commentBubble2 = commentUgcDeco.stBubble;
            barrageEffectInfo.f51896id = commentBubble2.iItemId;
            barrageEffectInfo.strAndBgUrl = commentBubble2.strAndBgUrl;
            barrageEffectInfo.strTextColor = commentBubble2.strTextColor;
            barrageEffectInfo.strIosBgUrl = commentBubble2.strIosBgUrl;
            barrageEffectInfo.type = commentBubble2.eType;
            barrageEffectInfo.stSource = commentBubble2.stSource;
            barrageEffectInfo.strFrameZip = commentBubble2.strFrameZip;
            barrageEffectInfo.iFrameRate = commentBubble2.iFrameRate;
            return barrageEffectInfo;
        }

        public void fillData(MaterialItem materialItem) {
            ArrayList<MaterialFile> arrayList;
            if (materialItem != null && (arrayList = materialItem.vecFile) != null && arrayList.size() >= 2) {
                this.strTextColor = materialItem.mapExtInfo.get("TextColor");
                this.strAndBgUrl = materialItem.vecFile.get(0).strUrl;
                this.strIosBgUrl = materialItem.vecFile.get(1).strUrl;
                if (materialItem.vecFile.size() > 2) {
                    this.strFrameZip = materialItem.vecFile.get(2).strUrl;
                    return;
                }
                return;
            }
            this.f51896id = -1;
        }
    }
}
