package com.qzone.personalize.business;

import NS_MOBILE_CUSTOM.FeedSkinInfo;
import NS_MOBILE_FEEDS.cell_feeds_deco;
import NS_MOBILE_FEEDS.cell_userinfo;
import NS_MOBILE_FEEDS.s_user;
import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_QMALL_COVER.FeedQzmallDeco;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_QMALL_COVER.QzmallFeedSkin;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.l;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedSkinData extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<FeedSkinData> DB_CREATOR = new a();
    public static final String PERSONAL_LOGIN_NEWCARD_DATA = "personalloginnewcard_data";
    public static final String STORE_KEY = "FeedSkinInfoData";
    public static final String TYPE_FIRE_CRACKER_DATA = "BLOB";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 3;

    @NeedParcel
    public ImageUrl customBubbleSkinImageUrl;

    @NeedParcel
    public String customBubbleSkinUrl;

    @NeedParcel
    public String desc;

    @NeedParcel
    public boolean hasAuth;

    @NeedParcel
    public int iFrameRate;

    @NeedParcel
    public int iNewFeedSkin;

    @NeedParcel
    public int iPrice;

    @NeedParcel
    public int iTemSkinType;

    @NeedParcel
    public long lTime;

    @NeedParcel
    public long lUin;

    @NeedParcel
    public ArrayList<Integer> lv10Numbers;

    @NeedParcel
    public Map<String, String> mapExtInfo;

    @NeedParcel
    public int nSkinType;

    @NeedParcel
    public String sPicUrl;

    @NeedParcel
    public String sSkinId;

    @NeedParcel
    public String stThumb;

    @NeedParcel
    public String strBgColor;

    @NeedParcel
    public String strFrameZip;

    @NeedParcel
    public String strGradientColorBegin;

    @NeedParcel
    public String strGradientColorEnd;

    @NeedParcel
    public String strItemName;

    @NeedParcel
    public String strMusicH5Url;

    @NeedParcel
    public String strTraceInfo;

    @NeedParcel
    public String title;

    @NeedParcel
    public int vip_property;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<FeedSkinData> {
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
        public FeedSkinData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(FeedSkinData.PERSONAL_LOGIN_NEWCARD_DATA));
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    obtain.unmarshall(blob, 0, blob.length);
                    obtain.setDataPosition(0);
                    FeedSkinData feedSkinData = (FeedSkinData) ParcelableWrapper.createDataFromParcel(obtain);
                    OaidMonitor.parcelRecycle(obtain);
                    return feedSkinData;
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
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(FeedSkinData.PERSONAL_LOGIN_NEWCARD_DATA, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 3;
        }
    }

    public FeedSkinData() {
        this.sSkinId = "";
        this.lUin = 0L;
        this.sPicUrl = "";
        this.lTime = 0L;
        this.desc = "";
        this.title = "";
        this.vip_property = 0;
        this.nSkinType = 0;
        this.strMusicH5Url = "";
        this.mapExtInfo = null;
        this.strBgColor = "";
        this.strGradientColorBegin = "";
        this.strGradientColorEnd = "";
        this.customBubbleSkinUrl = "";
        this.hasAuth = false;
        this.stThumb = "";
        this.iPrice = 0;
        this.iTemSkinType = -1;
    }

    public static FeedSkinData create(l lVar) {
        cell_userinfo cell_userinfoVar;
        s_user s_userVar;
        FeedQzmallDeco feedQzmallDeco;
        QzmallFeedSkin qzmallFeedSkin;
        cell_feeds_deco cell_feeds_decoVar;
        FeedQzmallDeco feedQzmallDeco2;
        QzmallFeedSkin qzmallFeedSkin2;
        if (lVar != null && (cell_feeds_decoVar = lVar.f50367n0) != null) {
            if (cell_feeds_decoVar == null || cell_feeds_decoVar.decoration == null || (feedQzmallDeco2 = (FeedQzmallDeco) i.H().u(FeedQzmallDeco.class, cell_feeds_decoVar.decoration)) == null || (qzmallFeedSkin2 = feedQzmallDeco2.stFeedSkin) == null) {
                return null;
            }
            FeedSkinData fromFeedSkinInfo = fromFeedSkinInfo(qzmallFeedSkin2.stFeedSkinInfo);
            QzmallCustomBubbleSkin qzmallCustomBubbleSkin = feedQzmallDeco2.stBubbleSkin;
            if (qzmallCustomBubbleSkin != null) {
                String str = qzmallCustomBubbleSkin.strFeedsPicUrl;
                fromFeedSkinInfo.customBubbleSkinUrl = str;
                fromFeedSkinInfo.customBubbleSkinImageUrl = PictureUrl.calculateImageUrl(str);
            }
            return fromFeedSkinInfo;
        }
        if (lVar == null || (cell_userinfoVar = lVar.f50342b) == null || (s_userVar = cell_userinfoVar.user) == null || s_userVar.decoration == null || (feedQzmallDeco = (FeedQzmallDeco) i.H().u(FeedQzmallDeco.class, lVar.f50342b.user.decoration)) == null || (qzmallFeedSkin = feedQzmallDeco.stFeedSkin) == null) {
            return null;
        }
        return fromFeedSkinInfo(qzmallFeedSkin.stFeedSkinInfo);
    }

    public static FeedSkinData fromMatirialInfo(MaterialItem materialItem, long j3, boolean z16) {
        if (materialItem == null) {
            return null;
        }
        FeedSkinData feedSkinData = new FeedSkinData();
        try {
            feedSkinData.lUin = j3;
            feedSkinData.sSkinId = materialItem.iItemId + "";
            MaterialFile materialFile = materialItem.stThumb;
            if (materialFile != null) {
                feedSkinData.stThumb = materialFile.strUrl;
            }
            feedSkinData.iTemSkinType = materialItem.iItemType;
            int i3 = materialItem.iTypeId;
            if (i3 == 0) {
                feedSkinData.nSkinType = 364;
            } else if (1 == i3) {
                feedSkinData.nSkinType = QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE;
            } else {
                QZLog.e("feedskin", "error parse feedskin " + materialItem);
                return null;
            }
            ArrayList<MaterialFile> arrayList = materialItem.vecFile;
            if (arrayList != null && arrayList.size() != 0) {
                if (materialItem.vecFile.size() == 1) {
                    feedSkinData.sPicUrl = materialItem.vecFile.get(0).strUrl;
                } else {
                    feedSkinData.sPicUrl = materialItem.vecFile.get(1).strUrl;
                }
                if (materialItem.vecFile.size() > 2 && "frame.zip".equals(materialItem.vecFile.get(2).strName)) {
                    feedSkinData.strFrameZip = materialItem.vecFile.get(2).strUrl;
                }
            }
            feedSkinData.iPrice = materialItem.iPrice;
            feedSkinData.strItemName = materialItem.strItemName;
            Map<String, String> map = materialItem.mapExtInfo;
            if (map != null) {
                if (map.containsKey("iUserQualType")) {
                    feedSkinData.hasAuth = transferToInt(materialItem.mapExtInfo.get("iUserQualType")) == 1;
                }
                if (materialItem.mapExtInfo.containsKey("strBgColor")) {
                    feedSkinData.strBgColor = materialItem.mapExtInfo.get("strBgColor");
                }
                if (materialItem.mapExtInfo.containsKey("strGradientColorBegin")) {
                    feedSkinData.strGradientColorBegin = materialItem.mapExtInfo.get("strGradientColorBegin");
                }
                if (materialItem.mapExtInfo.containsKey("strGradientColorEnd")) {
                    feedSkinData.strGradientColorEnd = materialItem.mapExtInfo.get("strGradientColorEnd");
                }
                if (materialItem.mapExtInfo.containsKey("iFrameRate")) {
                    feedSkinData.iFrameRate = transferToInt(materialItem.mapExtInfo.get("iFrameRate"));
                }
                if (z16) {
                    if (materialItem.mapExtInfo.containsKey("iNewFeedSkin")) {
                        feedSkinData.iNewFeedSkin = transferToInt(materialItem.mapExtInfo.get("iNewFeedSkin"));
                    }
                } else {
                    feedSkinData.iNewFeedSkin = 1;
                }
            }
        } catch (Throwable th5) {
            QZLog.e("FeedSkinData", "createFromResponse Throwable, msg = " + th5.getMessage());
        }
        return feedSkinData;
    }

    public static int transferToInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable th5) {
            QZLog.e("FeedSkinData", "transferToInt Throwable, msg = " + th5.getMessage());
            return 0;
        }
    }

    public void update(l lVar) {
        cell_userinfo cell_userinfoVar;
        s_user s_userVar;
        FeedQzmallDeco feedQzmallDeco;
        QzmallFeedSkin qzmallFeedSkin;
        FeedSkinInfo feedSkinInfo;
        cell_feeds_deco cell_feeds_decoVar;
        FeedQzmallDeco feedQzmallDeco2;
        QzmallFeedSkin qzmallFeedSkin2;
        FeedSkinInfo feedSkinInfo2;
        if (lVar != null && (cell_feeds_decoVar = lVar.f50367n0) != null) {
            if (cell_feeds_decoVar == null || cell_feeds_decoVar.decoration == null || (feedQzmallDeco2 = (FeedQzmallDeco) i.H().u(FeedQzmallDeco.class, cell_feeds_decoVar.decoration)) == null || (qzmallFeedSkin2 = feedQzmallDeco2.stFeedSkin) == null || (feedSkinInfo2 = qzmallFeedSkin2.stFeedSkinInfo) == null || TextUtils.isEmpty(feedSkinInfo2.sSkinId)) {
                return;
            }
            updateFeedSkinInfo(feedQzmallDeco2.stFeedSkin.stFeedSkinInfo);
            QzmallCustomBubbleSkin qzmallCustomBubbleSkin = feedQzmallDeco2.stBubbleSkin;
            if (qzmallCustomBubbleSkin == null || qzmallCustomBubbleSkin.iItemId == 0) {
                return;
            }
            String str = qzmallCustomBubbleSkin.strFeedsPicUrl;
            this.customBubbleSkinUrl = str;
            this.customBubbleSkinImageUrl = PictureUrl.calculateImageUrl(str);
            return;
        }
        if (lVar == null || (cell_userinfoVar = lVar.f50342b) == null || (s_userVar = cell_userinfoVar.user) == null || s_userVar.decoration == null || (feedQzmallDeco = (FeedQzmallDeco) i.H().u(FeedQzmallDeco.class, lVar.f50342b.user.decoration)) == null || (qzmallFeedSkin = feedQzmallDeco.stFeedSkin) == null || (feedSkinInfo = qzmallFeedSkin.stFeedSkinInfo) == null || TextUtils.isEmpty(feedSkinInfo.sSkinId)) {
            return;
        }
        updateFeedSkinInfo(feedQzmallDeco.stFeedSkin.stFeedSkinInfo);
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.lUin));
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(PERSONAL_LOGIN_NEWCARD_DATA, marshall);
    }

    private void updateFeedSkinInfo(FeedSkinInfo feedSkinInfo) {
        String str;
        if (feedSkinInfo == null) {
            return;
        }
        String str2 = feedSkinInfo.desc;
        if (str2 != null && str2.length() > 0) {
            str = feedSkinInfo.desc;
        } else {
            str = feedSkinInfo.strItemSummary;
        }
        String str3 = feedSkinInfo.sSkinId;
        this.sSkinId = str3;
        this.lUin = feedSkinInfo.lUin;
        int i3 = feedSkinInfo.sSkinType;
        this.nSkinType = i3;
        if (i3 == 392) {
            this.sPicUrl = feedSkinInfo.sPicUrl;
        } else {
            this.sPicUrl = com.qzone.personalize.business.a.a(str3);
        }
        this.lTime = feedSkinInfo.lTime;
        this.desc = str;
        this.title = feedSkinInfo.title;
        this.vip_property = feedSkinInfo.vip_property;
        this.strTraceInfo = feedSkinInfo.strTraceInfo;
        this.strMusicH5Url = feedSkinInfo.strMusicH5Url;
        this.mapExtInfo = feedSkinInfo.mapExtInfo;
        this.strBgColor = feedSkinInfo.strBgColor;
        this.strGradientColorBegin = feedSkinInfo.strGradientColorBegin;
        this.strGradientColorEnd = feedSkinInfo.strGradientColorEnd;
    }

    public static FeedSkinData copy(FeedSkinData feedSkinData) {
        if (feedSkinData == null) {
            return null;
        }
        FeedSkinData feedSkinData2 = new FeedSkinData();
        feedSkinData2.sSkinId = feedSkinData.sSkinId;
        feedSkinData2.lUin = feedSkinData.lUin;
        feedSkinData2.nSkinType = feedSkinData.nSkinType;
        feedSkinData2.sPicUrl = feedSkinData.sPicUrl;
        feedSkinData2.lTime = feedSkinData.lTime;
        feedSkinData2.desc = feedSkinData.desc;
        feedSkinData2.title = feedSkinData.title;
        feedSkinData2.vip_property = feedSkinData.vip_property;
        feedSkinData2.strTraceInfo = feedSkinData.strTraceInfo;
        feedSkinData2.strMusicH5Url = feedSkinData.strMusicH5Url;
        feedSkinData2.mapExtInfo = feedSkinData.mapExtInfo;
        feedSkinData2.strBgColor = feedSkinData.strBgColor;
        feedSkinData2.strGradientColorBegin = feedSkinData.strGradientColorBegin;
        feedSkinData2.strGradientColorEnd = feedSkinData.strGradientColorEnd;
        feedSkinData2.customBubbleSkinUrl = feedSkinData.customBubbleSkinUrl;
        feedSkinData2.customBubbleSkinImageUrl = feedSkinData.customBubbleSkinImageUrl;
        feedSkinData2.iNewFeedSkin = feedSkinData.iNewFeedSkin;
        feedSkinData2.hasAuth = feedSkinData.hasAuth;
        feedSkinData2.stThumb = feedSkinData.stThumb;
        feedSkinData2.iPrice = feedSkinData.iPrice;
        feedSkinData2.iTemSkinType = feedSkinData.iTemSkinType;
        feedSkinData2.strItemName = feedSkinData.strItemName;
        feedSkinData2.strFrameZip = feedSkinData.strFrameZip;
        feedSkinData2.iFrameRate = feedSkinData.iFrameRate;
        feedSkinData2.lv10Numbers = feedSkinData.lv10Numbers;
        return feedSkinData2;
    }

    public static FeedSkinData fromFeedSkinInfo(FeedSkinInfo feedSkinInfo) {
        String str;
        if (feedSkinInfo == null) {
            return null;
        }
        String str2 = feedSkinInfo.desc;
        if (str2 != null && str2.length() > 0) {
            str = feedSkinInfo.desc;
        } else {
            str = feedSkinInfo.strItemSummary;
        }
        FeedSkinData feedSkinData = new FeedSkinData();
        String str3 = feedSkinInfo.sSkinId;
        feedSkinData.sSkinId = str3;
        feedSkinData.lUin = feedSkinInfo.lUin;
        int i3 = feedSkinInfo.sSkinType;
        feedSkinData.nSkinType = i3;
        if (i3 == 392) {
            feedSkinData.sPicUrl = feedSkinInfo.sPicUrl;
        } else {
            feedSkinData.sPicUrl = com.qzone.personalize.business.a.a(str3);
        }
        feedSkinData.lTime = feedSkinInfo.lTime;
        feedSkinData.desc = str;
        feedSkinData.title = feedSkinInfo.title;
        feedSkinData.vip_property = feedSkinInfo.vip_property;
        feedSkinData.strTraceInfo = feedSkinInfo.strTraceInfo;
        feedSkinData.strMusicH5Url = feedSkinInfo.strMusicH5Url;
        feedSkinData.mapExtInfo = feedSkinInfo.mapExtInfo;
        feedSkinData.strBgColor = feedSkinInfo.strBgColor;
        feedSkinData.strGradientColorBegin = feedSkinInfo.strGradientColorBegin;
        feedSkinData.strGradientColorEnd = feedSkinInfo.strGradientColorEnd;
        return feedSkinData;
    }

    public FeedSkinData(String str, long j3, String str2, long j16) {
        this(str, j3, str2, j16, "", "", 0, "", 364, "");
    }

    public FeedSkinData(String str, long j3, String str2, long j16, String str3, String str4, int i3, String str5, int i16, String str6) {
        this.mapExtInfo = null;
        this.strBgColor = "";
        this.strGradientColorBegin = "";
        this.strGradientColorEnd = "";
        this.customBubbleSkinUrl = "";
        this.hasAuth = false;
        this.stThumb = "";
        this.iPrice = 0;
        this.iTemSkinType = -1;
        this.sSkinId = str;
        this.lUin = j3;
        this.sPicUrl = str2;
        this.lTime = j16;
        this.desc = str3;
        this.title = str4;
        this.vip_property = i3;
        this.strTraceInfo = str5;
        this.nSkinType = i16;
        this.strMusicH5Url = str6;
    }

    public FeedSkinData(int i3) {
        this.sSkinId = "";
        this.lUin = 0L;
        this.sPicUrl = "";
        this.lTime = 0L;
        this.desc = "";
        this.title = "";
        this.vip_property = 0;
        this.nSkinType = 0;
        this.strMusicH5Url = "";
        this.mapExtInfo = null;
        this.strBgColor = "";
        this.strGradientColorBegin = "";
        this.strGradientColorEnd = "";
        this.customBubbleSkinUrl = "";
        this.hasAuth = false;
        this.stThumb = "";
        this.iPrice = 0;
        this.iTemSkinType = -1;
        this.iNewFeedSkin = i3;
    }
}
