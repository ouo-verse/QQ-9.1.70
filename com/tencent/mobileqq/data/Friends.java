package com.tencent.mobileqq.data;

import QQService.EVIPSPEC;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.PrimaryKeyJoinColumn;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;

/* compiled from: P */
@PrimaryKeyJoinColumn(name = "uin")
/* loaded from: classes10.dex */
public class Friends extends Entity implements Cloneable {
    public static final int BLACK_FLAG_0 = 0;
    public static final int BLACK_FLAG_1 = 1;
    public static final int CLIENT_DEFAULT = 0;
    public static final int CLIENT_IPHONE = 3;
    public static final int CLIENT_MOBILE = 2;
    public static final int CLIENT_PC = 1;
    public static final int FRIEND_TYPE_QIM = 1;
    public static final int GATHER_TYPE_GATHERED = 1;
    public static final int GATHER_TYPE_NORMAL = 0;
    public static final int GATHER_TYPE_RECOMMENDED = 2;
    private static final long LOGIN_TYPE_OFFLINE = 10;
    public static int MULTI_FLAGS_MASK_OLYMPICTORCH = 2;
    public static int MULTI_FLAGS_MASK_SHIELD = 1;
    public static final int NET_2G = 2;
    public static final int NET_3G = 3;
    public static final int NET_4G = 4;
    public static final int NET_5G = 5;
    public static final int NET_UNKNOW = 0;
    public static final int NET_WIFI = 1;
    public static final int TERM_TYPE_ANDROID_PAD = 68104;
    public static final int TERM_TYPE_AOL_CHAOJIHUIYUAN = 73730;
    public static final int TERM_TYPE_AOL_HUIYUAN = 73474;
    public static final int TERM_TYPE_AOL_SQQ = 69378;
    public static final int TERM_TYPE_CAR = 65806;
    public static final int TERM_TYPE_HRTX_IPHONE = 66566;
    public static final int TERM_TYPE_HRTX_PC = 66561;
    public static final int TERM_TYPE_MC_3G = 65795;
    public static final int TERM_TYPE_MISRO_MSG = 69634;
    public static final int TERM_TYPE_MOBILE_ANDROID = 65799;
    public static final int TERM_TYPE_MOBILE_ANDROID_NEW = 72450;
    public static final int TERM_TYPE_MOBILE_HD = 65805;
    public static final int TERM_TYPE_MOBILE_HD_NEW = 71426;
    public static final int TERM_TYPE_MOBILE_IPAD = 68361;
    public static final int TERM_TYPE_MOBILE_IPAD_NEW = 72194;
    public static final int TERM_TYPE_MOBILE_IPHONE = 67586;
    public static final int TERM_TYPE_MOBILE_OTHER = 65794;
    public static final int TERM_TYPE_MOBILE_PC = 65793;
    public static final int TERM_TYPE_MOBILE_WINPHONE_NEW = 72706;
    public static final int TERM_TYPE_QQ_FORELDER = 70922;
    public static final int TERM_TYPE_QQ_SERVICE = 71170;
    public static final int TERM_TYPE_TV_QQ = 69130;
    public static final int TERM_TYPE_WIN8 = 69899;
    public static final int TERM_TYPE_WINPHONE = 65804;
    public String adCode;
    public int age;
    public String alias;
    public String area;
    public long autoStatusUpdateSecond;
    public byte cSpecialFlag;
    public String city;
    public String constellationBgImageUrl;
    public String constellationDateStr;
    public String constellationIconUrl;
    public String constellationJumpUrl;
    public String constellationLuckyColor;
    public String constellationLuckyNumber;
    public String constellationTodayTrend;
    public String constellationTomorrowTrend;

    @notColumn
    public String customOnlineStatus;

    @notColumn
    public int customOnlineStatusType;
    public long datetime;
    public byte detalStatusFlag;
    public String diyDesc;
    public long diyEmoSeverId;
    public int diyEmoType;

    @Deprecated
    public short faceid;
    public byte gender;
    public int iTermType;

    @Deprecated
    public byte isIphoneOnline;

    @Deprecated
    public boolean isMqqOnLine;
    public long lastLoginType;
    public double latitude;
    public double longitude;
    public int mComparePartInt;
    public String mCompareSpell;
    public String medalsInfo;

    @Deprecated
    public byte memberLevel;
    public volatile String name;
    public int namePlateOfKingDan;
    public boolean namePlateOfKingDanDisplatSwitch;
    public long namePlateOfKingGameId;
    public long namePlateOfKingLoginTime;
    public String nameplateCfgInfo;

    @notColumn
    public int netTypeIconId;
    public long onlineStatusUpdateTime;
    public int poiFlag;
    public String poiName;
    public long poiUpdateTime;
    public String recommReason;
    public String remark;
    public long showLoginClient;

    @Deprecated
    public String signature;
    public String singerName;
    public String smartRemark;

    @notColumn
    public int songDuration;
    public long songEndTime;
    public String songId;
    public String songName;

    @notColumn
    public int songPauseRemainTime;
    public int songSourceType;

    @Deprecated
    public byte sqqOnLineState;

    @Deprecated
    public byte sqqtype;

    @notColumn
    public String strTermDesc;
    public String temper;

    @unique
    public String uin;
    public String videoId;
    public String videoName;
    public String videoUrl;
    public String weatherDecs;

    @defaultValue(defaultInteger = 1)
    public int weatherFlag;
    public String weatherIconKey;
    public String weatherPrompt;
    public String weatherTip;
    public String weatherType;
    public String weatherTypeId;
    public long weatherUpdateTime;

    @Deprecated
    public byte status = 10;
    public int groupid = -1;
    public byte gathtertype = 0;

    @Deprecated
    public byte isRemark = 1;
    public int qqVipInfo = 0;
    public int superQqInfo = 0;
    public int superVipInfo = 0;

    @Deprecated
    public int hollywoodVipInfo = 0;
    public int eNetwork = 0;
    public String strMasterUin = "";
    public int multiFlags = 0;
    public int friendType = 0;
    public long abilityBits = 0;
    public int bigClubInfo = 0;
    public int superVipTemplateId = 0;
    public int bigClubTemplateId = 0;
    public int bigClubExtTemplateId = 0;
    public int diyFontId = 0;
    public int vipStartFlag = 0;
    public String vipIcons = "";
    public int vipDataFlag = 0;
    public int gameCardId = 0;
    public int nameplateVipType = 0;
    public int grayNameplateFlag = 0;
    public int cNewLoverDiamondFlag = 0;
    public int relationIconFlag = 0;
    public byte[] iconFlag = null;
    public long uExtOnlineStatus = 0;
    public int iBatteryStatus = 0;
    public String customModel = "";
    public long curOlympicRank = -1;
    public int isBlack = 0;
    public int isBlacked = 0;
    public long robotType = 0;
    public long robotVersion = 0;

    public static boolean isValidUin(long j3) {
        return j3 > 10000;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("FriendsManager", 2, "Friends clone failed." + e16.toString());
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    @SuppressLint({"Range"})
    public boolean entityByCursor(Cursor cursor) {
        this.uin = cursor.getString(cursor.getColumnIndex("uin"));
        this.remark = cursor.getString(cursor.getColumnIndex("remark"));
        this.name = cursor.getString(cursor.getColumnIndex("name"));
        this.cSpecialFlag = (byte) cursor.getShort(cursor.getColumnIndex(AppConstants.Key.CSPECIAL_FLAG));
        this.groupid = cursor.getInt(cursor.getColumnIndex(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID));
        this.detalStatusFlag = (byte) cursor.getShort(cursor.getColumnIndex("detalStatusFlag"));
        this.datetime = cursor.getLong(cursor.getColumnIndex("datetime"));
        this.alias = cursor.getString(cursor.getColumnIndex(NotificationActivity.KEY_ALIAS));
        this.iTermType = cursor.getInt(cursor.getColumnIndex("iTermType"));
        this.qqVipInfo = cursor.getInt(cursor.getColumnIndex("qqVipInfo"));
        this.superQqInfo = cursor.getInt(cursor.getColumnIndex("superQqInfo"));
        this.superVipInfo = cursor.getInt(cursor.getColumnIndex("superVipInfo"));
        this.bigClubInfo = cursor.getInt(cursor.getColumnIndex("bigClubInfo"));
        this.lastLoginType = cursor.getLong(cursor.getColumnIndex("lastLoginType"));
        this.showLoginClient = cursor.getLong(cursor.getColumnIndex("showLoginClient"));
        this.mComparePartInt = cursor.getInt(cursor.getColumnIndex("mComparePartInt"));
        this.mCompareSpell = cursor.getString(cursor.getColumnIndex("mCompareSpell"));
        this.eNetwork = cursor.getInt(cursor.getColumnIndex("eNetwork"));
        this.multiFlags = cursor.getInt(cursor.getColumnIndex("multiFlags"));
        this.abilityBits = cursor.getLong(cursor.getColumnIndex("abilityBits"));
        this.gathtertype = (byte) cursor.getShort(cursor.getColumnIndex("gathtertype"));
        this.smartRemark = cursor.getString(cursor.getColumnIndex("smartRemark"));
        this.age = cursor.getInt(cursor.getColumnIndex("age"));
        this.gender = (byte) cursor.getShort(cursor.getColumnIndex("gender"));
        this.recommReason = cursor.getString(cursor.getColumnIndex("recommReason"));
        this.friendType = cursor.getInt(cursor.getColumnIndex("friendType"));
        this.strMasterUin = cursor.getString(cursor.getColumnIndex("strMasterUin"));
        this.superVipTemplateId = cursor.getInt(cursor.getColumnIndex("superVipTemplateId"));
        this.bigClubTemplateId = cursor.getInt(cursor.getColumnIndex("bigClubTemplateId"));
        this.bigClubExtTemplateId = cursor.getInt(cursor.getColumnIndex("bigClubExtTemplateId"));
        this.gameCardId = cursor.getInt(cursor.getColumnIndex("gameCardId"));
        this.diyFontId = cursor.getInt(cursor.getColumnIndex("diyFontId"));
        this.vipStartFlag = cursor.getInt(cursor.getColumnIndex("vipStartFlag"));
        this.vipIcons = cursor.getString(cursor.getColumnIndex("vipIcons"));
        this.vipDataFlag = cursor.getInt(cursor.getColumnIndex("vipDataFlag"));
        this.nameplateVipType = cursor.getInt(cursor.getColumnIndex("nameplateVipType"));
        this.grayNameplateFlag = cursor.getInt(cursor.getColumnIndex("grayNameplateFlag"));
        this.cNewLoverDiamondFlag = cursor.getInt(cursor.getColumnIndex("cNewLoverDiamondFlag"));
        this.medalsInfo = cursor.getString(cursor.getColumnIndex("medalsInfo"));
        this.relationIconFlag = cursor.getInt(cursor.getColumnIndex("relationIconFlag"));
        this.iconFlag = cursor.getBlob(cursor.getColumnIndex("iconFlag"));
        this.nameplateCfgInfo = cursor.getString(cursor.getColumnIndex("nameplateCfgInfo"));
        this.uExtOnlineStatus = cursor.getLong(cursor.getColumnIndex("uExtOnlineStatus"));
        this.iBatteryStatus = cursor.getInt(cursor.getColumnIndex("iBatteryStatus"));
        this.customModel = cursor.getString(cursor.getColumnIndex("customModel"));
        this.constellationTodayTrend = cursor.getString(cursor.getColumnIndex("constellationTodayTrend"));
        this.constellationTomorrowTrend = cursor.getString(cursor.getColumnIndex("constellationTomorrowTrend"));
        this.constellationBgImageUrl = cursor.getString(cursor.getColumnIndex("constellationBgImageUrl"));
        this.constellationIconUrl = cursor.getString(cursor.getColumnIndex("constellationIconUrl"));
        this.constellationJumpUrl = cursor.getString(cursor.getColumnIndex("constellationJumpUrl"));
        this.constellationDateStr = cursor.getString(cursor.getColumnIndex("constellationDateStr"));
        this.constellationLuckyColor = cursor.getString(cursor.getColumnIndex("constellationLuckyColor"));
        this.constellationLuckyNumber = cursor.getString(cursor.getColumnIndex("constellationLuckyNumber"));
        this.temper = cursor.getString(cursor.getColumnIndex("temper"));
        this.weatherType = cursor.getString(cursor.getColumnIndex("weatherType"));
        this.weatherTypeId = cursor.getString(cursor.getColumnIndex("weatherTypeId"));
        this.weatherTip = cursor.getString(cursor.getColumnIndex("weatherTip"));
        this.adCode = cursor.getString(cursor.getColumnIndex("adCode"));
        this.city = cursor.getString(cursor.getColumnIndex("city"));
        this.area = cursor.getString(cursor.getColumnIndex(GdtGetUserInfoHandler.KEY_AREA));
        this.weatherUpdateTime = cursor.getLong(cursor.getColumnIndex("weatherUpdateTime"));
        this.weatherFlag = cursor.getInt(cursor.getColumnIndex("weatherFlag"));
        this.weatherDecs = cursor.getString(cursor.getColumnIndex("weatherDecs"));
        this.weatherPrompt = cursor.getString(cursor.getColumnIndex("weatherPrompt"));
        this.weatherIconKey = cursor.getString(cursor.getColumnIndex("weatherIconKey"));
        this.autoStatusUpdateSecond = cursor.getLong(cursor.getColumnIndex("autoStatusUpdateSecond"));
        this.curOlympicRank = cursor.getLong(cursor.getColumnIndex("curOlympicRank"));
        this.diyEmoType = cursor.getInt(cursor.getColumnIndex("diyEmoType"));
        this.diyEmoSeverId = cursor.getLong(cursor.getColumnIndex("diyEmoSeverId"));
        this.diyDesc = cursor.getString(cursor.getColumnIndex("diyDesc"));
        this.videoId = cursor.getString(cursor.getColumnIndex("videoId"));
        this.videoName = cursor.getString(cursor.getColumnIndex("videoName"));
        this.videoUrl = cursor.getString(cursor.getColumnIndex(AppConstants.Key.KEY_QZONE_VIDEO_URL));
        this.onlineStatusUpdateTime = cursor.getLong(cursor.getColumnIndex("onlineStatusUpdateTime"));
        this.isBlack = cursor.getInt(cursor.getColumnIndex("isBlack"));
        this.isBlacked = cursor.getInt(cursor.getColumnIndex("isBlacked"));
        this.robotType = cursor.getInt(cursor.getColumnIndex("robotType"));
        this.robotVersion = cursor.getInt(cursor.getColumnIndex("robotVersion"));
        if (QLog.isColorLevel() && this.cSpecialFlag != 0) {
            QLog.i("Friends", 2, "entityByCursor uin=" + this.uin + ", cSpecialFlag=" + ((int) this.cSpecialFlag));
            return true;
        }
        return true;
    }

    public int getBatteryCapacity() {
        int i3 = this.iBatteryStatus & 127;
        if (QLog.isColorLevel()) {
            QLog.d("Friends", 2, "getBatteryCapacity:", Integer.valueOf(i3));
        }
        return i3;
    }

    public String getFriendName() {
        if (!TextUtils.isEmpty(this.name)) {
            return this.name;
        }
        return this.uin;
    }

    public String getFriendNick() {
        if (!TextUtils.isEmpty(this.remark)) {
            return this.remark;
        }
        if (!TextUtils.isEmpty(this.name)) {
            return this.name;
        }
        return this.uin;
    }

    public String getFriendNickWithAlias() {
        if (!TextUtils.isEmpty(this.remark)) {
            return this.remark;
        }
        if (!TextUtils.isEmpty(this.name)) {
            return this.name;
        }
        if (!TextUtils.isEmpty(this.alias)) {
            return this.alias;
        }
        return this.uin;
    }

    public String getFriendNickWithoutUin() {
        if (!TextUtils.isEmpty(this.remark)) {
            return this.remark;
        }
        if (!TextUtils.isEmpty(this.name)) {
            return this.name;
        }
        return "";
    }

    public long getLastLoginType() {
        long j3 = this.lastLoginType;
        if (j3 == 0) {
            return 10L;
        }
        return j3;
    }

    public int getServiceLevel(EVIPSPEC evipspec) {
        int i3;
        int value = evipspec.value();
        if (value != 1) {
            if (value != 2) {
                if (value != 3) {
                    if (value != 7) {
                        return 0;
                    }
                    i3 = this.bigClubInfo;
                } else {
                    i3 = this.superVipInfo;
                }
            } else {
                i3 = this.superQqInfo;
            }
        } else {
            i3 = this.qqVipInfo;
        }
        return i3 & 65535;
    }

    public int getServiceType(EVIPSPEC evipspec) {
        int i3;
        int value = evipspec.value();
        if (value != 1) {
            if (value != 2) {
                if (value != 3) {
                    if (value != 7) {
                        return 0;
                    }
                    i3 = this.bigClubInfo;
                } else {
                    i3 = this.superVipInfo;
                }
            } else {
                i3 = this.superQqInfo;
            }
        } else {
            i3 = this.qqVipInfo;
        }
        return (i3 & ITVKAsset.VOD_ASSET_MASK_BIT) >>> 16;
    }

    public boolean isBatteryCharging() {
        if ((this.iBatteryStatus & 128) > 0) {
            return true;
        }
        return false;
    }

    public boolean isFriend() {
        if (this.groupid >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        if ((r4.bigClubInfo & (-16777216)) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001d, code lost:
    
        if ((r4.superVipInfo & (-16777216)) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0023, code lost:
    
        if ((r4.superQqInfo & (-16777216)) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0029, code lost:
    
        if ((r4.qqVipInfo & (-16777216)) != 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isServiceEnabled(EVIPSPEC evipspec) {
        int value = evipspec.value();
        boolean z16 = true;
        if (value != 1) {
            if (value != 2) {
                if (value != 3) {
                    if (value != 7) {
                        return false;
                    }
                }
            }
        }
    }

    public boolean isShield() {
        if ((this.multiFlags & MULTI_FLAGS_MASK_SHIELD) > 0) {
            return true;
        }
        return false;
    }

    public void setIsBlackFlag(int i3) {
        this.isBlack = i3;
    }

    public void setIsBlackedFlag(int i3) {
        this.isBlacked = i3;
    }

    public void setShieldFlag(boolean z16) {
        if (z16) {
            this.multiFlags |= MULTI_FLAGS_MASK_SHIELD;
        } else {
            this.multiFlags &= ~MULTI_FLAGS_MASK_SHIELD;
        }
    }

    public String toString() {
        return "Friends{uin='" + this.uin + "', remark='" + this.remark + "', name='" + this.name + "', groupid=" + this.groupid + "', gathtertype=" + ((int) this.gathtertype) + ", namePlateOfKingGameId=" + this.namePlateOfKingGameId + ", namePlateOfKingLoginTime=" + this.namePlateOfKingLoginTime + ", namePlateOfKingDan=" + this.namePlateOfKingDan + ", namePlateOfKingDanDisplatSwitch=" + this.namePlateOfKingDanDisplatSwitch + '}';
    }

    public static boolean isValidUin(String str) {
        try {
            return Long.valueOf(Long.parseLong(str)).longValue() > 10000;
        } catch (Exception unused) {
            return false;
        }
    }
}
