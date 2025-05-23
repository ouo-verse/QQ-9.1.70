package com.qzone.component.banner;

import NS_MOBILE_AD_BANNER.MultiBanner;
import NS_MOBILE_AD_BANNER.QueryADBannerUnit;
import NS_MOBILE_AD_BANNER.TimeRange;
import NS_MOBILE_AD_BANNER.VideoBanner;
import TianShuJce.AdPlacementInfo;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BusinessADBannerData extends com.qzone.component.cache.database.a implements SmartParcelable {
    private static final String COLUMNS_AD_ID = "ad_id";
    private static final String COLUMNS_AD_TYPE = "ad_type";
    private static final String COLUMNS_BTNTEXT = "btnText";
    private static final String COLUMNS_CLOSE_BUTTON = "close_button";
    private static final String COLUMNS_DESCRIPTION = "description";
    private static final String COLUMNS_DURATION = "duraion";
    private static final String COLUMNS_IUIN = "iUin";
    private static final String COLUMNS_JUM_URL = "jum_url";
    private static final String COLUMNS_NICK = "nick";
    private static final String COLUMNS_PIC_URL = "pic_url";
    private static final String COLUMNS_PRIORITY = "priority";
    private static final String COLUMNS_REOPEN_HOURS = "reopen_hours";
    private static final String COLUMNS_REPORT_INFO = "report_info";
    private static final String COLUMNS_ROOMID = "roomId";
    private static final String COLUMNS_SCHEME_URL = "scheme_url";
    private static final String COLUMNS_STRPICMD5 = "strPicMD5";
    private static final String COLUMNS_TIME_BEGIN = "time_begin";
    private static final String COLUMNS_TIME_END = "time_end";
    private static final String COLUMNS_TRACEINFO = "trace_info";
    private static final String COLUMNS_TRACE_ID = "trace_id";
    private static final String COLUMNS_TYPE = "type";
    public static final IDBCacheDataWrapper.a<BusinessADBannerData> DB_CREATOR = new a();
    public static final String KEY_BANNER_APPID = "banner_appid";
    public static final String STORE_KEY = "ADBannerData";

    @NeedParcel
    public String btText;

    @NeedParcel
    public String description;

    @NeedParcel
    public long duration;

    @NeedParcel
    public String dynBannerJsonData;

    @NeedParcel
    public int eAdType;

    @NeedParcel
    public Map<String, String> extendinfo;

    @NeedParcel
    public boolean hasCloseButton;

    @NeedParcel
    public long iAdID;

    @NeedParcel
    public long iTimeBegin;

    @NeedParcel
    public long iTimeEnd;

    @NeedParcel
    public long iTraceID;

    @NeedParcel
    public long iUin;

    @NeedParcel
    public ArrayList<MultiBanner> multibanner;

    @NeedParcel
    public Map<Integer, String> newRepoertInfoList;

    @NeedParcel
    public String nick;

    @NeedParcel
    public int patternId;

    @NeedParcel
    public int priority;

    @NeedParcel
    public int reopenHours;

    @NeedParcel
    public String report_info;

    @NeedParcel
    public String roomId;

    @NeedParcel
    public String schemeUrl;

    @NeedParcel
    public String strJmpUrl;

    @NeedParcel
    public String strPicMD5;

    @NeedParcel
    public String strPicUrl;

    @NeedParcel
    public String strTraceInfo;

    @NeedParcel
    public AdPlacementInfo tianshuAdPlacementInfo;

    @NeedParcel
    public int type;

    @NeedParcel
    public ArrayList<VideoBanner> videobanners;
    public HashMap<Long, Long> videobannersHasClick;

    public BusinessADBannerData() {
        this.strPicUrl = "";
        this.strJmpUrl = "";
        this.iAdID = 0L;
        this.iTraceID = 0L;
        this.eAdType = 0;
        this.iTimeBegin = 0L;
        this.iTimeEnd = 0L;
        this.schemeUrl = "";
        this.hasCloseButton = false;
        this.reopenHours = 0;
        this.priority = 0;
        this.duration = 0L;
        this.report_info = "";
        this.type = 0;
        this.description = "";
        this.btText = "";
        this.strTraceInfo = "";
        this.iUin = 0L;
        this.roomId = "";
        this.nick = "";
        this.multibanner = null;
        this.videobanners = null;
        this.extendinfo = null;
        this.videobannersHasClick = null;
        this.dynBannerJsonData = "";
    }

    public static String getJumpTraceInfoUrl(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
            return str;
        }
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str3 = str + "&qboss_trace=" + str2;
        } else {
            str3 = str + "?qboss_trace=" + str2;
        }
        String str4 = str3 + MobileReportManager.getStringQboos2H5(BaseApplicationImpl.getApplication().getRuntime().getAccount(), str2, ContainerUtils.FIELD_DELIMITER);
        QLog.i(ComponentFactory.ComponentType.BANNER, 4, "qzone banner getJumpTraceInfoUrl  = " + str4);
        return str4;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("ad_id", Long.valueOf(this.iAdID));
        contentValues.put("trace_id", Long.valueOf(this.iTraceID));
        contentValues.put(COLUMNS_PIC_URL, this.strPicUrl);
        contentValues.put(COLUMNS_JUM_URL, this.strJmpUrl);
        contentValues.put("ad_type", Long.valueOf(this.iAdID));
        contentValues.put(COLUMNS_TIME_BEGIN, Long.valueOf(this.iTimeBegin));
        contentValues.put(COLUMNS_TIME_END, Long.valueOf(this.iTimeEnd));
        contentValues.put(COLUMNS_SCHEME_URL, this.schemeUrl);
        contentValues.put(COLUMNS_CLOSE_BUTTON, Integer.valueOf(!this.hasCloseButton ? 0 : 1));
        contentValues.put(COLUMNS_REOPEN_HOURS, Integer.valueOf(this.reopenHours));
        contentValues.put("priority", Integer.valueOf(this.priority));
        contentValues.put(COLUMNS_DURATION, Long.valueOf(this.duration));
        contentValues.put("report_info", this.report_info);
        contentValues.put(COLUMNS_STRPICMD5, this.strPicMD5);
        contentValues.put("type", Integer.valueOf(this.type));
        contentValues.put("description", this.description);
        contentValues.put("btnText", this.btText);
        contentValues.put("trace_info", this.strTraceInfo);
        contentValues.put(COLUMNS_IUIN, Long.valueOf(this.iUin));
        contentValues.put("roomId", this.roomId);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<BusinessADBannerData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusinessADBannerData createFromCursor(Cursor cursor) {
            BusinessADBannerData businessADBannerData = new BusinessADBannerData();
            businessADBannerData.iAdID = cursor.getLong(cursor.getColumnIndex("ad_id"));
            businessADBannerData.iTraceID = cursor.getLong(cursor.getColumnIndex("trace_id"));
            businessADBannerData.strPicUrl = cursor.getString(cursor.getColumnIndex(BusinessADBannerData.COLUMNS_PIC_URL));
            businessADBannerData.strJmpUrl = cursor.getString(cursor.getColumnIndex(BusinessADBannerData.COLUMNS_JUM_URL));
            businessADBannerData.eAdType = cursor.getInt(cursor.getColumnIndex("ad_type"));
            businessADBannerData.iTimeBegin = cursor.getLong(cursor.getColumnIndex(BusinessADBannerData.COLUMNS_TIME_BEGIN));
            businessADBannerData.iTimeEnd = cursor.getLong(cursor.getColumnIndex(BusinessADBannerData.COLUMNS_TIME_END));
            businessADBannerData.schemeUrl = cursor.getString(cursor.getColumnIndex(BusinessADBannerData.COLUMNS_SCHEME_URL));
            businessADBannerData.hasCloseButton = cursor.getInt(cursor.getColumnIndex(BusinessADBannerData.COLUMNS_CLOSE_BUTTON)) == 1;
            businessADBannerData.reopenHours = cursor.getInt(cursor.getColumnIndex(BusinessADBannerData.COLUMNS_REOPEN_HOURS));
            businessADBannerData.priority = cursor.getInt(cursor.getColumnIndex("priority"));
            businessADBannerData.duration = cursor.getLong(cursor.getColumnIndex(BusinessADBannerData.COLUMNS_DURATION));
            businessADBannerData.report_info = cursor.getString(cursor.getColumnIndex("report_info"));
            businessADBannerData.strPicMD5 = cursor.getString(cursor.getColumnIndex(BusinessADBannerData.COLUMNS_STRPICMD5));
            businessADBannerData.type = cursor.getInt(cursor.getColumnIndex("type"));
            businessADBannerData.description = cursor.getString(cursor.getColumnIndex("description"));
            businessADBannerData.btText = cursor.getString(cursor.getColumnIndex("btnText"));
            businessADBannerData.strTraceInfo = cursor.getString(cursor.getColumnIndex("trace_info"));
            businessADBannerData.iUin = cursor.getLong(cursor.getColumnIndex(BusinessADBannerData.COLUMNS_IUIN));
            businessADBannerData.roomId = cursor.getString(cursor.getColumnIndex("roomId"));
            businessADBannerData.nick = cursor.getString(cursor.getColumnIndex("nick"));
            return businessADBannerData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 5;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("ad_id", "INTEGER"), new IDBCacheDataWrapper.c("trace_id", "INTEGER"), new IDBCacheDataWrapper.c(BusinessADBannerData.COLUMNS_PIC_URL, "TEXT"), new IDBCacheDataWrapper.c(BusinessADBannerData.COLUMNS_JUM_URL, "TEXT"), new IDBCacheDataWrapper.c("ad_type", "INTEGER"), new IDBCacheDataWrapper.c(BusinessADBannerData.COLUMNS_TIME_BEGIN, "INTEGER"), new IDBCacheDataWrapper.c(BusinessADBannerData.COLUMNS_TIME_END, "INTEGER"), new IDBCacheDataWrapper.c(BusinessADBannerData.COLUMNS_SCHEME_URL, "TEXT"), new IDBCacheDataWrapper.c(BusinessADBannerData.COLUMNS_CLOSE_BUTTON, "INTEGER"), new IDBCacheDataWrapper.c(BusinessADBannerData.COLUMNS_REOPEN_HOURS, "INTEGER"), new IDBCacheDataWrapper.c("priority", "INTEGER"), new IDBCacheDataWrapper.c(BusinessADBannerData.COLUMNS_DURATION, "INTEGER"), new IDBCacheDataWrapper.c("report_info", "TEXT"), new IDBCacheDataWrapper.c(BusinessADBannerData.COLUMNS_STRPICMD5, "TEXT"), new IDBCacheDataWrapper.c("type", "INTEGER"), new IDBCacheDataWrapper.c("description", "TEXT"), new IDBCacheDataWrapper.c("btnText", "TEXT"), new IDBCacheDataWrapper.c("trace_info", "TEXT"), new IDBCacheDataWrapper.c(BusinessADBannerData.COLUMNS_IUIN, "INTEGER"), new IDBCacheDataWrapper.c("roomId", "TEXT"), new IDBCacheDataWrapper.c("nick", "TEXT")};
        }
    }

    public BusinessADBannerData(QueryADBannerUnit queryADBannerUnit) {
        this.strPicUrl = "";
        this.strJmpUrl = "";
        this.iAdID = 0L;
        this.iTraceID = 0L;
        this.eAdType = 0;
        this.iTimeBegin = 0L;
        this.iTimeEnd = 0L;
        this.schemeUrl = "";
        this.hasCloseButton = false;
        this.reopenHours = 0;
        this.priority = 0;
        this.duration = 0L;
        this.report_info = "";
        this.type = 0;
        this.description = "";
        this.btText = "";
        this.strTraceInfo = "";
        this.iUin = 0L;
        this.roomId = "";
        this.nick = "";
        this.multibanner = null;
        this.videobanners = null;
        this.extendinfo = null;
        this.videobannersHasClick = null;
        this.dynBannerJsonData = "";
        if (queryADBannerUnit != null) {
            this.eAdType = queryADBannerUnit.eAdType;
            this.iAdID = queryADBannerUnit.iAdID;
            TimeRange timeRange = queryADBannerUnit.sShowTimeRange;
            this.iTimeBegin = timeRange.iTimeBegin;
            this.iTimeEnd = timeRange.iTimeEnd;
            this.iTraceID = queryADBannerUnit.iTraceID;
            String str = queryADBannerUnit.strJmpUrl;
            this.strJmpUrl = str;
            this.strPicUrl = queryADBannerUnit.strPicUrl;
            this.schemeUrl = queryADBannerUnit.strSchemeUrl;
            this.hasCloseButton = queryADBannerUnit.noCloseButton == 0;
            this.reopenHours = queryADBannerUnit.reopenHours;
            this.priority = queryADBannerUnit.priority;
            this.duration = queryADBannerUnit.duration;
            this.report_info = queryADBannerUnit.report_info;
            this.strPicMD5 = queryADBannerUnit.strPicMD5;
            this.type = queryADBannerUnit.type;
            this.description = queryADBannerUnit.description;
            this.btText = queryADBannerUnit.btnText;
            String str2 = queryADBannerUnit.strTraceInfo;
            this.strTraceInfo = str2;
            this.iUin = queryADBannerUnit.iUin;
            this.roomId = queryADBannerUnit.roomId;
            this.nick = queryADBannerUnit.nick;
            this.multibanner = queryADBannerUnit.multibanner;
            this.videobanners = queryADBannerUnit.videobanners;
            this.extendinfo = queryADBannerUnit.extendinfo;
            this.dynBannerJsonData = queryADBannerUnit.DynBannerJsonData;
            this.patternId = queryADBannerUnit.pattern_id;
            this.tianshuAdPlacementInfo = queryADBannerUnit.tianshuAdPlacementInfo;
            this.strJmpUrl = getJumpTraceInfoUrl(str, str2);
        }
    }
}
