package com.qzone.proxy.personalitycomponent.model;

import BOSSStrategyCenter.tAdvDesc;
import NS_COMM_VIP_GROWTH.UserClientShowInfo;
import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import NS_MOBILE_MAIN_PAGE.s_profile;
import NS_QMALL_COVER.ActYellowDiamond;
import NS_QMALL_COVER.DataForQboss;
import NS_QMALL_COVER.MainpageQzmallDeco;
import NS_QMALL_COVER.QzmallCustomVip;
import NS_QMALL_COVER.QzmallVipWidget;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.component.cache.database.a;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasAdv;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import t5.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WidgetCacheQzoneVipData extends a implements Parcelable {
    public static final String ADV_LINK = "adv_link";
    public static final String ADV_TRACE_INFO = "adv_traceinfo";
    public static final String CACHETIME = "cachetime";
    public static final String COMVIPISANNUAL = "com_vip_isannual";
    public static final String COMVIPISANNUALEVER = "com_vip_isannual_ever";
    public static final String COMVIPLEVEL = "com_vip_level";
    public static final String COMVIPTYPE = "com_vip_type";
    public static final String CUSTOMTYPE = "customType";
    public static final String CUSTOM_DIAMOND_URL = "customDiamondUrl";
    public static final String CUSTOM_WIDGET_ANIMATION_URL = "widgetAnimationUrl";
    public static final String CUSTOM_WIDGET_BG_URL = "widgetBgUrl";
    public static final String ISANNUALVIP = "is_annualvip";
    public static final String ISSUPERVIP = "is_supervip";
    public static final String ISVIP = "is_vip";
    public static final String IS_CUSTOM_DIAMOND_USER = "isCustomDiamondUser";
    public static final String IS_UNION_VIP = "is_union_vip";
    public static final String KEEP_SHOW_ADV = "keep_show_adv";
    public static final String NAMEPLATEFLAG = "nameplate_flag";
    public static final String NEW_VIP_MAP_ICON = "new_vip_map_icon";
    public static final String PERSONALIZEDYELLOWVIPID = "personalizedYellowVipId";
    public static final String PERSONALIZEDYELLOWVIPURL = "personalizedYellowVipUrl";
    public static final String SHOW_ADV_DURATION = "show_adv_duration";
    public static final String SHOW_NEW_VIP = "show_new_vip";
    public static final String SHOW_UNION_VIP = "show_union_vip";
    public static final String STARVIPISANNUAL = "star_vip_isannual";
    public static final String STARVIPISHIGH = "star_vip_is_high";
    public static final String STARVIPLEVEL = "star_vip_level";
    public static final String STARVIPSTATUS = "star_vip_status";
    public static final String TYPE_ADV_LINK = "TEXT";
    public static final String TYPE_ADV_TRACE_INFO = "TEXT";
    public static final String TYPE_CACHETIME = "INTEGER";
    public static final String TYPE_COMVIPISANNUAL = "INTEGER";
    public static final String TYPE_COMVIPISANNUALEVER = "INTEGER";
    public static final String TYPE_COMVIPLEVEL = "INTEGER";
    public static final String TYPE_COMVIPTYPE = "INTEGER";
    public static final String TYPE_CUSTOMTYPE = "INTEGER";
    public static final String TYPE_CUSTOM_DIAMOND_URL = "TEXT";
    public static final String TYPE_CUSTOM_WIDGET_ANIMATION_URL = "TEXT";
    public static final String TYPE_CUSTOM_WIDGET_BG_URL = "TEXT";
    public static final String TYPE_ISANNUALVIP = "INTEGER";
    public static final String TYPE_ISSUPERVIP = "INTEGER";
    public static final String TYPE_ISVIP = "INTEGER";
    public static final String TYPE_IS_CUSTOM_DIAMOND_USER = "INTEGER";
    public static final String TYPE_IS_UNION_VIP = "INTEGER";
    public static final String TYPE_KEEP_SHOW_ADV = "INTEGER";
    public static final String TYPE_NAMEPLATEFLAG = "INTEGER";
    public static final String TYPE_NEW_VIP_MAP_ICON = "BLOB";
    public static final String TYPE_PERSONALIZEDYELLOWVIPID = "INTEGER";
    public static final String TYPE_PERSONALIZEDYELLOWVIPURL = "TEXT";
    public static final String TYPE_SHOW_ADV_DURATION = "INTEGER";
    public static final String TYPE_SHOW_NEW_VIP = "INTEGER";
    public static final String TYPE_SHOW_UNION_VIP = "INTEGER";
    public static final String TYPE_STARVIPISANNUAL = "INTEGER";
    public static final String TYPE_STARVIPISHIGH = "INTEGER";
    public static final String TYPE_STARVIPLEVEL = "INTEGER";
    public static final String TYPE_STARVIPSTATUS = "INTEGER";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String TYPE_UNION_VIP_KEEP_DAYS = "INTEGER";
    public static final String TYPE_UNION_VIP_LEVEL = "INTEGER";
    public static final String TYPE_UNION_VIP_MAP_ICON = "BLOB";
    public static final String TYPE_UNION_VIP_RATIO = "INTEGER";
    public static final String TYPE_UNION_VIP_SCORE = "INTEGER";
    public static final String TYPE_UNION_VIP_SPEED = "INTEGER";
    public static final String TYPE_UPDATETIME = "INTEGER";
    public static final String TYPE_VIPLEFTDAYS = "TEXT";
    public static final String TYPE_VIPLEVEL = "INTEGER";
    public static final String TYPE_VIPRATIO = "INTEGER";
    public static final String TYPE_VIPSCORE = "INTEGER";
    public static final String TYPE_VIPSPEED = "INTEGER";
    public static final String TYPE_VIP_KEEP_DAYS = "INTEGER";
    public static final String TYPE_VIP_WIDGET_JUMP_URL = "TEXT";
    public static final String TYPE_WIDGET_REDPOINTTRACE = "TEXT";
    public static final String UIN = "uin";
    public static final String UNION_VIP_KEEP_DAYS = "union_vip_keep_days";
    public static final String UNION_VIP_LEVEL = "union_vip_level";
    public static final String UNION_VIP_MAP_ICON = "union_vip_map_icon";
    public static final String UNION_VIP_RATIO = "union_vip_ratio";
    public static final String UNION_VIP_SCORE = "union_vip_score";
    public static final String UNION_VIP_SPEED = "union_vip_speed";
    public static final String UPDATETIME = "updatetime";
    public static final int VERSION = 23;
    public static final String VIPLEFTDAYS = "vipLeftDays";
    public static final String VIPLEVEL = "vip_level";
    public static final String VIPRATIO = "vip_ratio";
    public static final String VIPSCORE = "vip_score";
    public static final String VIPSPEED = "vip_speed";
    public static final String VIP_KEEP_DAYS = "vidKeepDays";
    public static final String VIP_WIDGET_JUMP_URL = "vip_widget_jump_url";
    public static final String WIDGET_REDPOINTTRACE = "redPointTrace";
    public String advLink;
    public String advTraceInfo;
    public int cachetime;
    public int comVipType;
    public int comViplevel;
    public String customDiamondUrl;
    public int customType;
    public int isAnnualVip;
    public boolean isComAnnualVip;
    public boolean isComAnnualVipEver;
    public boolean isCustomDiamondUser;
    public boolean isHighStarVip;
    public boolean isStarAnnualVip;
    public boolean isSuperVip;
    public boolean isUnionVip;
    public boolean isVip;
    public int keepShowAdv;
    public int nameplateFlag;
    public String personalizedYellowVipUrl;
    public Map<String, QQUnionIconInfo> qqNewVipIconMap;
    public Map<String, QQUnionIconInfo> qqUnionIconMap;
    public long showAdvDuration;
    public boolean showNewVip;
    public boolean showUnionVip;
    public int starVipLevel;
    public int starVipStatus;
    public long uin;
    public int unionVipKeepDays;
    public int unionVipLevel;
    public int unionVipRatio;
    public int unionVipScore;
    public int unionVipSpeed;
    public int updatetime;
    public int vipKeepdays;
    public String vipLeftDays;
    public int vipLevel;
    public int vipRatio;
    public int vipScore;
    public int vipSpeed;
    public String vipurl;
    public String widgetAdAnimation;
    public String widgetBg;
    public String widgetStrRedpointTrace;
    public static final Parcelable.Creator<WidgetCacheQzoneVipData> CREATOR = new Parcelable.Creator<WidgetCacheQzoneVipData>() { // from class: com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WidgetCacheQzoneVipData createFromParcel(Parcel parcel) {
            return new WidgetCacheQzoneVipData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WidgetCacheQzoneVipData[] newArray(int i3) {
            return new WidgetCacheQzoneVipData[i3];
        }
    };
    public static final IDBCacheDataWrapper.a<WidgetCacheQzoneVipData> DB_CREATOR = new IDBCacheDataWrapper.a<WidgetCacheQzoneVipData>() { // from class: com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData.2
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.ISVIP, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.ISSUPERVIP, "INTEGER"), new IDBCacheDataWrapper.c("vip_level", "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.VIPSCORE, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.VIPSPEED, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.VIPRATIO, "INTEGER"), new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("cachetime", "INTEGER"), new IDBCacheDataWrapper.c("updatetime", "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.VIPLEFTDAYS, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.ISANNUALVIP, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.NAMEPLATEFLAG, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.STARVIPSTATUS, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.STARVIPLEVEL, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.STARVIPISANNUAL, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.STARVIPISHIGH, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.COMVIPTYPE, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.COMVIPLEVEL, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.COMVIPISANNUAL, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.COMVIPISANNUALEVER, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.PERSONALIZEDYELLOWVIPURL, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.VIP_WIDGET_JUMP_URL, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.CUSTOMTYPE, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.VIP_KEEP_DAYS, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.WIDGET_REDPOINTTRACE, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.IS_CUSTOM_DIAMOND_USER, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.CUSTOM_DIAMOND_URL, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.CUSTOM_WIDGET_ANIMATION_URL, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.CUSTOM_WIDGET_BG_URL, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.SHOW_UNION_VIP, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.IS_UNION_VIP, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.UNION_VIP_KEEP_DAYS, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.UNION_VIP_LEVEL, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.UNION_VIP_RATIO, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.UNION_VIP_SCORE, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.UNION_VIP_SPEED, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.KEEP_SHOW_ADV, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.SHOW_ADV_DURATION, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.ADV_LINK, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.ADV_TRACE_INFO, "TEXT"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.UNION_VIP_MAP_ICON, "BLOB"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.SHOW_NEW_VIP, "INTEGER"), new IDBCacheDataWrapper.c(WidgetCacheQzoneVipData.NEW_VIP_MAP_ICON, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 23;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public WidgetCacheQzoneVipData createFromCursor(Cursor cursor) {
            WidgetCacheQzoneVipData widgetCacheQzoneVipData = new WidgetCacheQzoneVipData();
            widgetCacheQzoneVipData.isVip = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.ISVIP)) == 1;
            widgetCacheQzoneVipData.isSuperVip = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.ISSUPERVIP)) == 1;
            widgetCacheQzoneVipData.vipLevel = cursor.getInt(cursor.getColumnIndex("vip_level"));
            widgetCacheQzoneVipData.vipScore = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.VIPSCORE));
            widgetCacheQzoneVipData.vipSpeed = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.VIPSPEED));
            widgetCacheQzoneVipData.vipRatio = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.VIPRATIO));
            widgetCacheQzoneVipData.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            widgetCacheQzoneVipData.vipLeftDays = cursor.getString(cursor.getColumnIndex(WidgetCacheQzoneVipData.VIPLEFTDAYS));
            widgetCacheQzoneVipData.cachetime = cursor.getInt(cursor.getColumnIndex("cachetime"));
            widgetCacheQzoneVipData.updatetime = cursor.getInt(cursor.getColumnIndex("updatetime"));
            widgetCacheQzoneVipData.isAnnualVip = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.ISANNUALVIP));
            widgetCacheQzoneVipData.nameplateFlag = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.NAMEPLATEFLAG));
            widgetCacheQzoneVipData.starVipStatus = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.STARVIPSTATUS));
            widgetCacheQzoneVipData.starVipLevel = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.STARVIPLEVEL));
            widgetCacheQzoneVipData.isStarAnnualVip = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.STARVIPISANNUAL)) != 0;
            widgetCacheQzoneVipData.isHighStarVip = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.STARVIPISHIGH)) != 0;
            widgetCacheQzoneVipData.comVipType = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.COMVIPTYPE));
            widgetCacheQzoneVipData.comViplevel = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.COMVIPLEVEL));
            widgetCacheQzoneVipData.isComAnnualVip = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.COMVIPISANNUAL)) != 0;
            widgetCacheQzoneVipData.isComAnnualVipEver = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.COMVIPISANNUALEVER)) != 0;
            widgetCacheQzoneVipData.personalizedYellowVipUrl = cursor.getString(cursor.getColumnIndex(WidgetCacheQzoneVipData.PERSONALIZEDYELLOWVIPURL));
            widgetCacheQzoneVipData.vipurl = cursor.getString(cursor.getColumnIndex(WidgetCacheQzoneVipData.VIP_WIDGET_JUMP_URL));
            widgetCacheQzoneVipData.customType = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.CUSTOMTYPE));
            widgetCacheQzoneVipData.vipKeepdays = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.VIP_KEEP_DAYS));
            widgetCacheQzoneVipData.widgetStrRedpointTrace = cursor.getString(cursor.getColumnIndex(WidgetCacheQzoneVipData.WIDGET_REDPOINTTRACE));
            widgetCacheQzoneVipData.isCustomDiamondUser = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.IS_CUSTOM_DIAMOND_USER)) != 0;
            widgetCacheQzoneVipData.customDiamondUrl = cursor.getString(cursor.getColumnIndex(WidgetCacheQzoneVipData.CUSTOM_DIAMOND_URL));
            widgetCacheQzoneVipData.widgetAdAnimation = cursor.getString(cursor.getColumnIndex(WidgetCacheQzoneVipData.CUSTOM_WIDGET_ANIMATION_URL));
            widgetCacheQzoneVipData.widgetBg = cursor.getString(cursor.getColumnIndex(WidgetCacheQzoneVipData.CUSTOM_WIDGET_BG_URL));
            widgetCacheQzoneVipData.showUnionVip = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.SHOW_UNION_VIP)) != 0;
            widgetCacheQzoneVipData.isUnionVip = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.IS_UNION_VIP)) != 0;
            widgetCacheQzoneVipData.unionVipKeepDays = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.UNION_VIP_KEEP_DAYS));
            widgetCacheQzoneVipData.unionVipLevel = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.UNION_VIP_LEVEL));
            widgetCacheQzoneVipData.unionVipRatio = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.UNION_VIP_RATIO));
            widgetCacheQzoneVipData.unionVipScore = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.UNION_VIP_SCORE));
            widgetCacheQzoneVipData.unionVipSpeed = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.UNION_VIP_SPEED));
            widgetCacheQzoneVipData.keepShowAdv = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.KEEP_SHOW_ADV));
            widgetCacheQzoneVipData.showAdvDuration = cursor.getLong(cursor.getColumnIndex(WidgetCacheQzoneVipData.SHOW_ADV_DURATION));
            widgetCacheQzoneVipData.advLink = cursor.getString(cursor.getColumnIndex(WidgetCacheQzoneVipData.ADV_LINK));
            widgetCacheQzoneVipData.advTraceInfo = cursor.getString(cursor.getColumnIndex(WidgetCacheQzoneVipData.ADV_TRACE_INFO));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(WidgetCacheQzoneVipData.UNION_VIP_MAP_ICON));
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(blob, 0, blob.length);
            obtain.setDataPosition(0);
            widgetCacheQzoneVipData.qqUnionIconMap = obtain.readHashMap(getClass().getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            widgetCacheQzoneVipData.showNewVip = cursor.getInt(cursor.getColumnIndex(WidgetCacheQzoneVipData.SHOW_NEW_VIP)) != 0;
            byte[] blob2 = cursor.getBlob(cursor.getColumnIndex(WidgetCacheQzoneVipData.NEW_VIP_MAP_ICON));
            Parcel obtain2 = Parcel.obtain();
            obtain2.unmarshall(blob2, 0, blob2.length);
            obtain2.setDataPosition(0);
            widgetCacheQzoneVipData.qqNewVipIconMap = obtain2.readHashMap(getClass().getClassLoader());
            OaidMonitor.parcelRecycle(obtain2);
            return widgetCacheQzoneVipData;
        }
    };

    public WidgetCacheQzoneVipData() {
        this.isVip = false;
        this.isSuperVip = false;
        this.vipLevel = 0;
        this.vipScore = 0;
        this.vipSpeed = 0;
        this.vipRatio = 0;
        this.uin = 0L;
        this.cachetime = 0;
        this.updatetime = 0;
        this.vipLeftDays = "";
        this.isAnnualVip = 0;
        this.nameplateFlag = 0;
        this.starVipStatus = 0;
        this.starVipLevel = 0;
        this.isStarAnnualVip = false;
        this.isHighStarVip = false;
        this.comVipType = 0;
        this.comViplevel = 0;
        this.isComAnnualVip = false;
        this.isComAnnualVipEver = false;
        this.personalizedYellowVipUrl = "";
        this.vipurl = "";
        this.customType = 0;
        this.vipKeepdays = 0;
        this.widgetStrRedpointTrace = "";
        this.widgetAdAnimation = "";
        this.widgetBg = "";
        this.keepShowAdv = 0;
        this.showAdvDuration = 0L;
        this.advLink = "";
        this.advTraceInfo = "";
        this.isCustomDiamondUser = false;
        this.customDiamondUrl = "";
    }

    public static void mergeWithOldCacheForQQUnionVip(WidgetCacheQzoneVipData widgetCacheQzoneVipData, WidgetCacheQzoneVipData widgetCacheQzoneVipData2) {
        widgetCacheQzoneVipData.showUnionVip = widgetCacheQzoneVipData2.showUnionVip;
        widgetCacheQzoneVipData.isUnionVip = widgetCacheQzoneVipData2.isUnionVip;
        widgetCacheQzoneVipData.unionVipKeepDays = widgetCacheQzoneVipData2.unionVipKeepDays;
        widgetCacheQzoneVipData.unionVipLevel = widgetCacheQzoneVipData2.unionVipLevel;
        widgetCacheQzoneVipData.unionVipRatio = widgetCacheQzoneVipData2.unionVipRatio;
        widgetCacheQzoneVipData.unionVipScore = widgetCacheQzoneVipData2.unionVipScore;
        widgetCacheQzoneVipData.unionVipSpeed = widgetCacheQzoneVipData2.unionVipSpeed;
    }

    public static void updateNewVip(WidgetCacheQzoneVipData widgetCacheQzoneVipData, UserClientShowInfo userClientShowInfo) {
        widgetCacheQzoneVipData.showNewVip = userClientShowInfo.iIsUseVipIcon != 0;
        widgetCacheQzoneVipData.qqNewVipIconMap = QQUnionIconInfo.convertToQQUnionIconMap(userClientShowInfo.mapIconInfo);
    }

    public static void updateQQUnionVip(WidgetCacheQzoneVipData widgetCacheQzoneVipData, UserClientShowInfo userClientShowInfo) {
        widgetCacheQzoneVipData.showUnionVip = userClientShowInfo.iIsUseVipIcon != 0;
        widgetCacheQzoneVipData.isUnionVip = userClientShowInfo.iVip != 0;
        widgetCacheQzoneVipData.unionVipLevel = userClientShowInfo.iLevel;
        widgetCacheQzoneVipData.unionVipRatio = userClientShowInfo.iVipRatio;
        widgetCacheQzoneVipData.unionVipScore = userClientShowInfo.iScore;
        widgetCacheQzoneVipData.unionVipSpeed = userClientShowInfo.iSpeed;
        widgetCacheQzoneVipData.unionVipKeepDays = userClientShowInfo.iKeepVipDays;
        widgetCacheQzoneVipData.qqUnionIconMap = QQUnionIconInfo.convertToQQUnionIconMap(userClientShowInfo.mapIconInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(ISVIP, Integer.valueOf(this.isVip ? 1 : 0));
        contentValues.put(ISSUPERVIP, Integer.valueOf(this.isSuperVip ? 1 : 0));
        contentValues.put("vip_level", Integer.valueOf(this.vipLevel));
        contentValues.put(VIPSCORE, Integer.valueOf(this.vipScore));
        contentValues.put(VIPSPEED, Integer.valueOf(this.vipSpeed));
        contentValues.put(VIPRATIO, Integer.valueOf(this.vipRatio));
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put("cachetime", Integer.valueOf(this.cachetime));
        contentValues.put("updatetime", Integer.valueOf(this.updatetime));
        contentValues.put(VIPLEFTDAYS, this.vipLeftDays);
        contentValues.put(ISANNUALVIP, Integer.valueOf(this.isAnnualVip));
        contentValues.put(NAMEPLATEFLAG, Integer.valueOf(this.nameplateFlag));
        contentValues.put(STARVIPSTATUS, Integer.valueOf(this.starVipStatus));
        contentValues.put(STARVIPLEVEL, Integer.valueOf(this.starVipLevel));
        contentValues.put(STARVIPISANNUAL, Integer.valueOf(this.isStarAnnualVip ? 1 : 0));
        contentValues.put(STARVIPISHIGH, Integer.valueOf(this.isHighStarVip ? 1 : 0));
        contentValues.put(COMVIPTYPE, Integer.valueOf(this.comVipType));
        contentValues.put(COMVIPLEVEL, Integer.valueOf(this.comViplevel));
        contentValues.put(COMVIPISANNUAL, Integer.valueOf(this.isComAnnualVip ? 1 : 0));
        contentValues.put(COMVIPISANNUALEVER, Integer.valueOf(this.isComAnnualVipEver ? 1 : 0));
        contentValues.put(PERSONALIZEDYELLOWVIPURL, this.personalizedYellowVipUrl);
        contentValues.put(VIP_WIDGET_JUMP_URL, this.vipurl);
        contentValues.put(CUSTOMTYPE, Integer.valueOf(this.customType));
        contentValues.put(VIP_KEEP_DAYS, Integer.valueOf(this.vipKeepdays));
        contentValues.put(WIDGET_REDPOINTTRACE, this.widgetStrRedpointTrace);
        contentValues.put(IS_CUSTOM_DIAMOND_USER, Boolean.valueOf(this.isCustomDiamondUser));
        contentValues.put(CUSTOM_DIAMOND_URL, this.customDiamondUrl);
        contentValues.put(CUSTOM_WIDGET_ANIMATION_URL, this.widgetAdAnimation);
        contentValues.put(CUSTOM_WIDGET_BG_URL, this.widgetBg);
        contentValues.put(SHOW_UNION_VIP, Integer.valueOf(this.showUnionVip ? 1 : 0));
        contentValues.put(IS_UNION_VIP, Integer.valueOf(this.isUnionVip ? 1 : 0));
        contentValues.put(UNION_VIP_LEVEL, Integer.valueOf(this.unionVipLevel));
        contentValues.put(UNION_VIP_RATIO, Integer.valueOf(this.unionVipRatio));
        contentValues.put(UNION_VIP_SCORE, Integer.valueOf(this.unionVipScore));
        contentValues.put(UNION_VIP_SPEED, Integer.valueOf(this.unionVipSpeed));
        contentValues.put(UNION_VIP_KEEP_DAYS, Integer.valueOf(this.unionVipKeepDays));
        contentValues.put(KEEP_SHOW_ADV, Integer.valueOf(this.keepShowAdv));
        contentValues.put(SHOW_ADV_DURATION, Long.valueOf(this.showAdvDuration));
        contentValues.put(ADV_LINK, this.advLink);
        contentValues.put(ADV_TRACE_INFO, this.advTraceInfo);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.writeMap(this.qqUnionIconMap);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(UNION_VIP_MAP_ICON, marshall);
        contentValues.put(SHOW_NEW_VIP, Boolean.valueOf(this.showNewVip));
        Parcel obtain2 = Parcel.obtain();
        obtain2.setDataPosition(0);
        obtain2.writeMap(this.qqNewVipIconMap);
        byte[] marshall2 = obtain2.marshall();
        OaidMonitor.parcelRecycle(obtain2);
        contentValues.put(NEW_VIP_MAP_ICON, marshall2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByte(this.isVip ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSuperVip ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.vipLevel);
        parcel.writeInt(this.vipScore);
        parcel.writeInt(this.vipSpeed);
        parcel.writeInt(this.vipRatio);
        parcel.writeLong(this.uin);
        parcel.writeInt(this.cachetime);
        parcel.writeInt(this.updatetime);
        parcel.writeString(this.vipLeftDays);
        parcel.writeInt(this.isAnnualVip);
        parcel.writeInt(this.nameplateFlag);
        parcel.writeInt(this.starVipStatus);
        parcel.writeInt(this.starVipLevel);
        parcel.writeByte(this.isStarAnnualVip ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isHighStarVip ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.comVipType);
        parcel.writeInt(this.comViplevel);
        parcel.writeByte(this.isComAnnualVip ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isComAnnualVipEver ? (byte) 1 : (byte) 0);
        parcel.writeString(this.personalizedYellowVipUrl);
        parcel.writeString(this.vipurl);
        parcel.writeInt(this.customType);
        parcel.writeInt(this.vipKeepdays);
        parcel.writeString(this.widgetStrRedpointTrace);
        parcel.writeString(this.widgetAdAnimation);
        parcel.writeString(this.widgetBg);
        parcel.writeInt(this.keepShowAdv);
        parcel.writeLong(this.showAdvDuration);
        parcel.writeString(this.advLink);
        parcel.writeString(this.advTraceInfo);
        parcel.writeByte(this.isCustomDiamondUser ? (byte) 1 : (byte) 0);
        parcel.writeString(this.customDiamondUrl);
        parcel.writeByte(this.isUnionVip ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.unionVipLevel);
        parcel.writeInt(this.unionVipScore);
        parcel.writeInt(this.unionVipSpeed);
        parcel.writeInt(this.unionVipRatio);
        parcel.writeInt(this.unionVipKeepDays);
        parcel.writeByte(this.showUnionVip ? (byte) 1 : (byte) 0);
        parcel.writeMap(this.qqUnionIconMap);
        parcel.writeByte(this.showNewVip ? (byte) 1 : (byte) 0);
        parcel.writeMap(this.qqNewVipIconMap);
    }

    public static WidgetQzoneVipData convertToBusinessData(WidgetCacheQzoneVipData widgetCacheQzoneVipData) {
        if (widgetCacheQzoneVipData == null) {
            return null;
        }
        WidgetQzoneVipData widgetQzoneVipData = new WidgetQzoneVipData();
        widgetQzoneVipData.isVip = widgetCacheQzoneVipData.isVip;
        widgetQzoneVipData.isSuperVip = widgetCacheQzoneVipData.isSuperVip;
        widgetQzoneVipData.vipLevel = widgetCacheQzoneVipData.vipLevel;
        widgetQzoneVipData.vipScore = widgetCacheQzoneVipData.vipScore;
        widgetQzoneVipData.vipSpeed = widgetCacheQzoneVipData.vipSpeed;
        widgetQzoneVipData.vipRatio = widgetCacheQzoneVipData.vipRatio;
        widgetQzoneVipData.uin = widgetCacheQzoneVipData.uin;
        widgetQzoneVipData.vipLeftDays = widgetCacheQzoneVipData.vipLeftDays;
        widgetQzoneVipData.cachetime = widgetCacheQzoneVipData.cachetime;
        widgetQzoneVipData.updatetime = widgetCacheQzoneVipData.updatetime;
        widgetQzoneVipData.loginUin = LoginData.getInstance().getUin();
        widgetQzoneVipData.isAnnualVip = widgetCacheQzoneVipData.isAnnualVip;
        widgetQzoneVipData.nameplateFlag = widgetCacheQzoneVipData.nameplateFlag;
        widgetQzoneVipData.starVipStatus = widgetCacheQzoneVipData.starVipStatus;
        widgetQzoneVipData.starVipLevel = widgetCacheQzoneVipData.starVipLevel;
        widgetQzoneVipData.isStarAnnualVip = widgetCacheQzoneVipData.isStarAnnualVip;
        widgetQzoneVipData.isHighStarVip = widgetCacheQzoneVipData.isHighStarVip;
        widgetQzoneVipData.comVipType = widgetCacheQzoneVipData.comVipType;
        widgetQzoneVipData.comViplevel = widgetCacheQzoneVipData.comViplevel;
        widgetQzoneVipData.isComAnnualVip = widgetCacheQzoneVipData.isComAnnualVip;
        widgetQzoneVipData.isComAnnualVipEver = widgetCacheQzoneVipData.isComAnnualVipEver;
        widgetQzoneVipData.personalizedYellowVipUrl = widgetCacheQzoneVipData.personalizedYellowVipUrl;
        widgetQzoneVipData.vipurl = widgetCacheQzoneVipData.vipurl;
        widgetQzoneVipData.customType = widgetCacheQzoneVipData.customType;
        widgetQzoneVipData.vipKeepdays = widgetCacheQzoneVipData.vipKeepdays;
        widgetQzoneVipData.widgetStrRedpointTrace = widgetCacheQzoneVipData.widgetStrRedpointTrace;
        widgetQzoneVipData.isCustomDiamondUser = widgetCacheQzoneVipData.isCustomDiamondUser;
        widgetQzoneVipData.customDiamondUrl = widgetCacheQzoneVipData.customDiamondUrl;
        widgetQzoneVipData.widgetAdAnimation = widgetCacheQzoneVipData.widgetAdAnimation;
        widgetQzoneVipData.widgetBg = widgetCacheQzoneVipData.widgetBg;
        widgetQzoneVipData.showUnionVip = widgetCacheQzoneVipData.showUnionVip;
        widgetQzoneVipData.isUnionVip = widgetCacheQzoneVipData.isUnionVip;
        widgetQzoneVipData.unionVipKeepDays = widgetCacheQzoneVipData.unionVipKeepDays;
        widgetQzoneVipData.unionVipLevel = widgetCacheQzoneVipData.unionVipLevel;
        widgetQzoneVipData.unionVipRatio = widgetCacheQzoneVipData.unionVipRatio;
        widgetQzoneVipData.unionVipScore = widgetCacheQzoneVipData.unionVipScore;
        widgetQzoneVipData.unionVipSpeed = widgetCacheQzoneVipData.unionVipSpeed;
        widgetQzoneVipData.keepShowAdv = widgetCacheQzoneVipData.keepShowAdv;
        widgetQzoneVipData.showAdvDuration = widgetCacheQzoneVipData.showAdvDuration;
        widgetQzoneVipData.advLink = widgetCacheQzoneVipData.advLink;
        widgetQzoneVipData.advTraceInfo = widgetCacheQzoneVipData.advTraceInfo;
        widgetQzoneVipData.qqUnionIconMap = widgetCacheQzoneVipData.qqUnionIconMap;
        widgetQzoneVipData.showNewVip = widgetCacheQzoneVipData.showNewVip;
        widgetQzoneVipData.qqNewIconMap = widgetCacheQzoneVipData.qqNewVipIconMap;
        return widgetQzoneVipData;
    }

    public static WidgetCacheQzoneVipData createFromResponse(s_profile s_profileVar) {
        DataForQboss dataForQboss;
        ActYellowDiamond actYellowDiamond;
        QzmallVipWidget qzmallVipWidget;
        QzmallCustomVip qzmallCustomVip;
        if (s_profileVar == null) {
            return null;
        }
        WidgetCacheQzoneVipData widgetCacheQzoneVipData = new WidgetCacheQzoneVipData();
        widgetCacheQzoneVipData.isVip = s_profileVar.vip != 0;
        widgetCacheQzoneVipData.isSuperVip = s_profileVar.viptype == 1;
        widgetCacheQzoneVipData.vipLevel = s_profileVar.viplevel;
        widgetCacheQzoneVipData.vipScore = s_profileVar.vipscore;
        widgetCacheQzoneVipData.vipSpeed = s_profileVar.vipspeed;
        widgetCacheQzoneVipData.vipRatio = s_profileVar.vipratio;
        widgetCacheQzoneVipData.uin = s_profileVar.uin;
        widgetCacheQzoneVipData.vipLeftDays = s_profileVar.strvipoverday;
        widgetCacheQzoneVipData.updatetime = (int) (System.currentTimeMillis() / 1000);
        widgetCacheQzoneVipData.isAnnualVip = s_profileVar.isAnnualVip;
        widgetCacheQzoneVipData.nameplateFlag = s_profileVar.nameplate_flag;
        widgetCacheQzoneVipData.vipKeepdays = s_profileVar.vip_keepdays;
        star_info star_infoVar = s_profileVar.stuStarInfo;
        if (star_infoVar != null) {
            widgetCacheQzoneVipData.starVipStatus = star_infoVar.iStarStatus;
            widgetCacheQzoneVipData.starVipLevel = star_infoVar.iStarLevel;
            widgetCacheQzoneVipData.isStarAnnualVip = star_infoVar.isAnnualVip != 0;
            widgetCacheQzoneVipData.isHighStarVip = star_infoVar.isHighStarVip != 0;
        }
        combine_diamond_info combine_diamond_infoVar = s_profileVar.stuCombineDiamondInfo;
        if (combine_diamond_infoVar != null) {
            widgetCacheQzoneVipData.comVipType = combine_diamond_infoVar.iShowType;
            widgetCacheQzoneVipData.comViplevel = combine_diamond_infoVar.iVipLevel;
            widgetCacheQzoneVipData.isComAnnualVip = combine_diamond_infoVar.isAnnualVip != 0;
            widgetCacheQzoneVipData.isComAnnualVipEver = combine_diamond_infoVar.isAnnualVipEver != 0;
        }
        byte[] bArr = s_profileVar.QzmallProfileDecoGetRsp;
        if (bArr != null) {
            MainpageQzmallDeco mainpageQzmallDeco = (MainpageQzmallDeco) b.b(MainpageQzmallDeco.class, bArr);
            if (mainpageQzmallDeco != null && (qzmallCustomVip = mainpageQzmallDeco.stCustomVip) != null && qzmallCustomVip.iItemId != -1) {
                widgetCacheQzoneVipData.personalizedYellowVipUrl = qzmallCustomVip.strSrcUrl;
                widgetCacheQzoneVipData.customType = qzmallCustomVip.eCustomVipType;
            }
            if (mainpageQzmallDeco != null && (qzmallVipWidget = mainpageQzmallDeco.stVipWidget) != null) {
                widgetCacheQzoneVipData.widgetStrRedpointTrace = qzmallVipWidget.strRedpointTrace;
            }
            if (mainpageQzmallDeco != null && (actYellowDiamond = mainpageQzmallDeco.stYellowDiamond) != null) {
                widgetCacheQzoneVipData.isCustomDiamondUser = actYellowDiamond.iTenYearUser == 1;
                widgetCacheQzoneVipData.customDiamondUrl = actYellowDiamond.strPicZip;
            }
            if (mainpageQzmallDeco != null && (dataForQboss = mainpageQzmallDeco.stQbossData) != null) {
                Map<Integer, tAdvDesc> map = dataForQboss.map_adv_desc;
                if ((map != null ? map.get(2722) : null) != null) {
                    String readQzoneWidgetCache = ((IVasAdv) QRoute.api(IVasAdv.class)).readQzoneWidgetCache();
                    if (!TextUtils.isEmpty(readQzoneWidgetCache)) {
                        try {
                            JSONObject jSONObject = new JSONObject(readQzoneWidgetCache);
                            widgetCacheQzoneVipData.widgetAdAnimation = jSONObject.getString("novip");
                            widgetCacheQzoneVipData.widgetBg = jSONObject.getString("vip");
                            widgetCacheQzoneVipData.advLink = jSONObject.getString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                            widgetCacheQzoneVipData.keepShowAdv = jSONObject.optInt(KEEP_SHOW_ADV);
                            widgetCacheQzoneVipData.showAdvDuration = jSONObject.optLong(SHOW_ADV_DURATION);
                            widgetCacheQzoneVipData.advTraceInfo = jSONObject.getString(MiniGameCenterHippyFragment.EXTRA_KEY_AD_TRACE_INFO);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
        }
        widgetCacheQzoneVipData.vipurl = s_profileVar.vipurl;
        return widgetCacheQzoneVipData;
    }

    public WidgetCacheQzoneVipData(Parcel parcel) {
        this.isVip = false;
        this.isSuperVip = false;
        this.vipLevel = 0;
        this.vipScore = 0;
        this.vipSpeed = 0;
        this.vipRatio = 0;
        this.uin = 0L;
        this.cachetime = 0;
        this.updatetime = 0;
        this.vipLeftDays = "";
        this.isAnnualVip = 0;
        this.nameplateFlag = 0;
        this.starVipStatus = 0;
        this.starVipLevel = 0;
        this.isStarAnnualVip = false;
        this.isHighStarVip = false;
        this.comVipType = 0;
        this.comViplevel = 0;
        this.isComAnnualVip = false;
        this.isComAnnualVipEver = false;
        this.personalizedYellowVipUrl = "";
        this.vipurl = "";
        this.customType = 0;
        this.vipKeepdays = 0;
        this.widgetStrRedpointTrace = "";
        this.widgetAdAnimation = "";
        this.widgetBg = "";
        this.keepShowAdv = 0;
        this.showAdvDuration = 0L;
        this.advLink = "";
        this.advTraceInfo = "";
        this.isCustomDiamondUser = false;
        this.customDiamondUrl = "";
        this.isVip = parcel.readByte() != 0;
        this.isSuperVip = parcel.readByte() != 0;
        this.vipLevel = parcel.readInt();
        this.vipScore = parcel.readInt();
        this.vipSpeed = parcel.readInt();
        this.vipRatio = parcel.readInt();
        this.uin = parcel.readLong();
        this.cachetime = parcel.readInt();
        this.updatetime = parcel.readInt();
        this.vipLeftDays = parcel.readString();
        this.isAnnualVip = parcel.readInt();
        this.nameplateFlag = parcel.readInt();
        this.starVipStatus = parcel.readInt();
        this.starVipLevel = parcel.readInt();
        this.isStarAnnualVip = parcel.readByte() != 0;
        this.isHighStarVip = parcel.readByte() != 0;
        this.comVipType = parcel.readInt();
        this.comViplevel = parcel.readInt();
        this.isComAnnualVip = parcel.readByte() != 0;
        this.isComAnnualVipEver = parcel.readByte() != 0;
        this.personalizedYellowVipUrl = parcel.readString();
        this.vipurl = parcel.readString();
        this.customType = parcel.readInt();
        this.vipKeepdays = parcel.readInt();
        this.widgetStrRedpointTrace = parcel.readString();
        this.widgetAdAnimation = parcel.readString();
        this.widgetBg = parcel.readString();
        this.keepShowAdv = parcel.readInt();
        this.showAdvDuration = parcel.readLong();
        this.advLink = parcel.readString();
        this.advTraceInfo = parcel.readString();
        this.isCustomDiamondUser = parcel.readByte() != 0;
        this.customDiamondUrl = parcel.readString();
        this.isUnionVip = parcel.readByte() != 0;
        this.unionVipLevel = parcel.readInt();
        this.unionVipScore = parcel.readInt();
        this.unionVipSpeed = parcel.readInt();
        this.unionVipRatio = parcel.readInt();
        this.unionVipKeepDays = parcel.readInt();
        this.showUnionVip = parcel.readByte() != 0;
        if (this.qqUnionIconMap == null) {
            this.qqUnionIconMap = new HashMap();
        }
        parcel.readMap(this.qqUnionIconMap, QQUnionIconInfo.class.getClassLoader());
        this.showNewVip = parcel.readByte() != 0;
        if (this.qqNewVipIconMap == null) {
            this.qqNewVipIconMap = new HashMap();
        }
        parcel.readMap(this.qqNewVipIconMap, QQUnionIconInfo.class.getClassLoader());
    }
}
