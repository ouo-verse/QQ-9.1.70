package com.qzone.publish.ui.model;

import NS_MOBILE_MATERIAL.MaterialCate;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_MATERIAL.material_cate_get_rsp;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.util.l;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.R;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes39.dex */
public class PersonalFontData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<PersonalFontData> DB_CREATOR = new a();
    public static final int FullType = 1;
    public static final int HanYiColorType = 3;
    public static final int HanYiXuanDongType = 4;
    public static final String PERSONAL_FONT_DATA = "personalfont_data";
    private static final String TAG = "PersonalFontData";
    public static final String TYPE_FIRE_CRACKER_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final int TrueType = 2;
    public static final String UIN = "uin";
    public static final int VERSION = 2;

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public ArrayList<FontInfo> fontList = new ArrayList<>();

    @NeedParcel
    public int defaultFont = 0;

    @NeedParcel
    public int newCustomFontId = 0;

    @NeedParcel
    public long newCustomFontIdEndTime = 0;

    @NeedParcel
    public String hasMoreString = "";

    @NeedParcel
    public int mType = 1;

    /* loaded from: classes39.dex */
    public static class FontInfo implements SmartParcelable {

        @NeedParcel
        public String coverUrl = "";

        /* renamed from: id, reason: collision with root package name */
        @NeedParcel
        public int f51895id = 0;

        @NeedParcel
        public int fontType = 0;

        @NeedParcel
        public String fontName = "";

        @NeedParcel
        public boolean hasAuth = false;

        @NeedParcel
        public String fontUrl = "";

        @NeedParcel
        public int fontFormatType = 0;

        @NeedParcel
        public int fontFileSize = 0;

        @NeedParcel
        public String actId = "";

        @NeedParcel
        public String ruleId = "";

        @NeedParcel
        public String iVipActId = "";

        @NeedParcel
        public String iVipRuleId = "";

        @NeedParcel
        public String iPrice = "";

        @NeedParcel
        public String iVipPrice = "";

        @NeedParcel
        public String strPriceDesc = "";

        @NeedParcel
        public String strJumpUrlForActivity = "";

        @NeedParcel
        public String strBackgroundFileJson = "";
    }

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<PersonalFontData> {
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
        public PersonalFontData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("personalfont_data"));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    PersonalFontData personalFontData = (PersonalFontData) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    return personalFontData;
                } catch (Exception unused) {
                } catch (OutOfMemoryError unused2) {
                    QZLog.w(PersonalFontData.TAG, "PersonalFontData createFromCursor Error");
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
            return 2;
        }
    }

    public static PersonalFontData createFromResponse(long j3, material_cate_get_rsp material_cate_get_rspVar) {
        MaterialCate materialCate;
        String str;
        if (material_cate_get_rspVar == null || (materialCate = material_cate_get_rspVar.stCate) == null || materialCate.vecItem == null) {
            return null;
        }
        PersonalFontData personalFontData = new PersonalFontData();
        personalFontData.uin = j3;
        try {
            personalFontData.newCustomFontId = transferToInt(material_cate_get_rspVar.stCate.mapExtInfo.get("iNewCustomFontId"));
            personalFontData.newCustomFontIdEndTime = transferToLong(material_cate_get_rspVar.stCate.mapExtInfo.get("lNewCustomFontEndTime"));
            Map<String, String> map = material_cate_get_rspVar.mapExtInfo;
            if (map != null) {
                personalFontData.hasMoreString = map.get("hasMoreBtnText");
            } else {
                personalFontData.hasMoreString = l.a(R.string.p1e);
            }
            if (!TextUtils.isEmpty(material_cate_get_rspVar.stCate.mapExtInfo.get("iLastUsedFontId"))) {
                personalFontData.defaultFont = transferToInt(material_cate_get_rspVar.stCate.mapExtInfo.get("iLastUsedFontId"));
            } else {
                personalFontData.defaultFont = -1;
            }
            Iterator<MaterialItem> it = material_cate_get_rspVar.stCate.vecItem.iterator();
            while (it.hasNext()) {
                MaterialItem next = it.next();
                FontInfo fontInfo = new FontInfo();
                fontInfo.coverUrl = next.stThumb.strUrl;
                fontInfo.fontFileSize = next.vecFile.isEmpty() ? 0 : next.vecFile.get(0).iSize;
                fontInfo.f51895id = next.iItemId;
                fontInfo.fontType = next.iItemType;
                fontInfo.fontName = next.strItemName;
                fontInfo.hasAuth = transferToInt(next.mapExtInfo.get("iUserQualType")) == 1;
                fontInfo.fontFormatType = transferToInt(next.mapExtInfo.get("iFontType"));
                fontInfo.strPriceDesc = next.mapExtInfo.get("strPriceDesc");
                if (!next.vecFile.isEmpty()) {
                    str = next.vecFile.get(0).strUrl;
                } else {
                    str = "";
                }
                fontInfo.fontUrl = str;
                fontInfo.actId = next.mapExtInfo.get("iActId");
                fontInfo.ruleId = next.mapExtInfo.get("iRuleId");
                fontInfo.iVipActId = next.mapExtInfo.get("iVipActId");
                fontInfo.iVipPrice = next.mapExtInfo.get("iVipPrice");
                fontInfo.iVipRuleId = next.mapExtInfo.get("iVipRuleId");
                fontInfo.strJumpUrlForActivity = next.mapExtInfo.get("strJumpUrl");
                if (next.mapExtInfo.containsKey("strCustomFontJson")) {
                    fontInfo.strBackgroundFileJson = next.mapExtInfo.get("strCustomFontJson");
                }
                try {
                    fontInfo.iPrice = String.format("%.2f", Float.valueOf(Integer.parseInt(next.mapExtInfo.get("iPrice")) / 10.0f));
                } catch (Exception unused) {
                }
                personalFontData.fontList.add(fontInfo);
            }
            if (QZLog.isDevelopLevel()) {
                QZLog.d(TAG, 4, "font list size = " + personalFontData.fontList.size());
            }
        } catch (Throwable th5) {
            QZLog.e(TAG, "createFromResponse Throwable, msg = " + th5.getMessage());
        }
        return personalFontData;
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
