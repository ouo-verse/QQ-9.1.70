package com.qzone.publish.ui.model;

import NS_MOBILE_MATERIAL.MaterialCate;
import NS_MOBILE_MATERIAL.MaterialItem;
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
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes39.dex */
public class QzoneSuperPersonalFontData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<QzoneSuperPersonalFontData> DB_CREATOR = new a();
    public static final String SUPER_PERSONAL_FONT_DATA = "personalfont_data";
    private static final String TAG = "SuperPersonalFontData";
    public static final String TYPE_SUPER_PERSONAL_FONT_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 1;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public ArrayList<SuperFontInfo> fontList = new ArrayList<>();

    @NeedParcel
    public int defaultFont = 0;

    @NeedParcel
    public int newCustomFontId = 0;

    @NeedParcel
    public long newCustomFontIdEndTime = 0;

    /* loaded from: classes39.dex */
    public static class SuperFontInfo implements SmartParcelable {

        @NeedParcel
        public String coverUrl = "";

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
        public int f51897id = -1;

        @NeedParcel
        public long lSparkleFlag = 0;

        @NeedParcel
        public String strTextColor = "";

        @NeedParcel
        public int iShadowOffsetX = 0;

        @NeedParcel
        public int iShadowOffsetY = 0;

        @NeedParcel
        public int iShadowBlurRadius = 0;

        @NeedParcel
        public String strShadowColor = "";

        @NeedParcel
        public ArrayList<String> vecGradientColor = null;

        @NeedParcel
        public ArrayList<Double> vecGradientPosition = null;

        @NeedParcel
        public int iGradientDirection = 0;

        @NeedParcel
        public ArrayList<String> vecTextColorAnimation = null;

        @NeedParcel
        public int iTextColorSpanTime = 0;

        public static SuperFontInfo fromJson(String str) {
            SuperFontInfo superFontInfo = new SuperFontInfo();
            superFontInfo.fillData(str);
            return superFontInfo;
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
                this.f51897id = jSONObject.optInt("iItemId");
                this.lSparkleFlag = jSONObject.optLong("lSparkleFlag");
                this.strTextColor = jSONObject.optString("strTextColor");
                this.iShadowOffsetX = jSONObject.optInt("iShadowOffsetX");
                this.iShadowOffsetY = jSONObject.optInt("iShadowOffsetY");
                this.iShadowBlurRadius = jSONObject.optInt("iShadowBlurRadius");
                this.strShadowColor = jSONObject.optString("strShadowColor");
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("vecGradientColor");
                    int length = optJSONArray == null ? 0 : optJSONArray.length();
                    this.vecGradientColor = new ArrayList<>();
                    for (int i3 = 0; i3 < length; i3++) {
                        this.vecGradientColor.add(optJSONArray.getString(i3));
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                this.vecGradientPosition = new ArrayList<>();
                try {
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("vecGradientPosition");
                    int length2 = optJSONArray2 == null ? 0 : optJSONArray2.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        this.vecGradientPosition.add(Double.valueOf(optJSONArray2.getDouble(i16)));
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                this.iGradientDirection = jSONObject.optInt("iGradientDirection");
                this.vecTextColorAnimation = new ArrayList<>();
                try {
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("vecTextColorAnimation");
                    int length3 = optJSONArray3 == null ? 0 : optJSONArray3.length();
                    for (int i17 = 0; i17 < length3; i17++) {
                        this.vecTextColorAnimation.add(optJSONArray3.getString(i17));
                    }
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
                this.iTextColorSpanTime = jSONObject.optInt("iTextColorSpanTime");
            } catch (Exception e19) {
                e19.printStackTrace();
            }
        }

        public String toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("iItemId", this.f51897id);
                jSONObject.put("lSparkleFlag", this.lSparkleFlag);
                jSONObject.put("strTextColor", this.strTextColor);
                jSONObject.put("iShadowOffsetX", this.iShadowOffsetX);
                jSONObject.put("iShadowOffsetY", this.iShadowOffsetY);
                jSONObject.put("iShadowBlurRadius", this.iShadowBlurRadius);
                jSONObject.put("strShadowColor", this.strShadowColor);
                ArrayList<String> arrayList = this.vecGradientColor;
                if (arrayList != null && !arrayList.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    int size = this.vecGradientColor.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jSONArray.mo162put(this.vecGradientColor.get(i3));
                    }
                    jSONObject.put("vecGradientColor", jSONArray);
                }
                ArrayList<Double> arrayList2 = this.vecGradientPosition;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    int size2 = this.vecGradientPosition.size();
                    for (int i16 = 0; i16 < size2; i16++) {
                        jSONArray2.mo162put(this.vecGradientPosition.get(i16));
                    }
                    jSONObject.put("vecGradientPosition", jSONArray2);
                }
                jSONObject.put("iGradientDirection", this.iGradientDirection);
                ArrayList<String> arrayList3 = this.vecTextColorAnimation;
                if (arrayList3 != null && !arrayList3.isEmpty()) {
                    JSONArray jSONArray3 = new JSONArray();
                    int size3 = this.vecTextColorAnimation.size();
                    for (int i17 = 0; i17 < size3; i17++) {
                        jSONArray3.mo162put(this.vecTextColorAnimation.get(i17));
                    }
                    jSONObject.put("vecTextColorAnimation", jSONArray3);
                }
                jSONObject.put("iTextColorSpanTime", this.iTextColorSpanTime);
                return jSONObject.toString();
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<QzoneSuperPersonalFontData> {
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
        public QzoneSuperPersonalFontData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("personalfont_data"));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    QzoneSuperPersonalFontData qzoneSuperPersonalFontData = (QzoneSuperPersonalFontData) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    return qzoneSuperPersonalFontData;
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("personalfont_data", "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    public static QzoneSuperPersonalFontData createFromResponse(long j3, material_cate_get_rsp material_cate_get_rspVar) {
        MaterialCate materialCate;
        if (material_cate_get_rspVar == null || (materialCate = material_cate_get_rspVar.stCate) == null || materialCate.vecItem == null) {
            return null;
        }
        QzoneSuperPersonalFontData qzoneSuperPersonalFontData = new QzoneSuperPersonalFontData();
        qzoneSuperPersonalFontData.uin = j3;
        try {
            qzoneSuperPersonalFontData.newCustomFontId = transferToInt(material_cate_get_rspVar.stCate.mapExtInfo.get("iNewSparkleId"));
            qzoneSuperPersonalFontData.newCustomFontIdEndTime = transferToLong(material_cate_get_rspVar.stCate.mapExtInfo.get("lNewSparkleEndTime"));
            if (!TextUtils.isEmpty(material_cate_get_rspVar.stCate.mapExtInfo.get("iLastSparkleId"))) {
                qzoneSuperPersonalFontData.defaultFont = transferToInt(material_cate_get_rspVar.stCate.mapExtInfo.get("iLastSparkleId"));
            } else {
                qzoneSuperPersonalFontData.defaultFont = -1;
            }
            Iterator<MaterialItem> it = material_cate_get_rspVar.stCate.vecItem.iterator();
            while (it.hasNext()) {
                MaterialItem next = it.next();
                SuperFontInfo superFontInfo = new SuperFontInfo();
                superFontInfo.coverUrl = next.stThumb.strUrl;
                superFontInfo.f51897id = next.iItemId;
                superFontInfo.fontType = next.iItemType;
                boolean z16 = true;
                if (transferToInt(next.mapExtInfo.get("iUserQualType")) != 1) {
                    z16 = false;
                }
                superFontInfo.hasAuth = z16;
                superFontInfo.fillData(next.mapExtInfo.get("sparkle_json"));
                superFontInfo.fontUsedTips = next.mapExtInfo.get("strPriceDesc");
                superFontInfo.actId = next.mapExtInfo.get("iActId");
                superFontInfo.ruleId = next.mapExtInfo.get("iRuleId");
                qzoneSuperPersonalFontData.fontList.add(superFontInfo);
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 2, "font list size = " + qzoneSuperPersonalFontData.fontList.size());
            }
        } catch (Throwable th5) {
            QZLog.e(TAG, "createFromResponse Throwable, msg = " + th5.getMessage());
        }
        return qzoneSuperPersonalFontData;
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
        contentValues.put("personalfont_data", marshall);
    }
}
