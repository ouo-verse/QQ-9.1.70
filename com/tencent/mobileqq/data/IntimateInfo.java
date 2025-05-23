package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.g;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import f61.e;
import f61.f;
import f61.h;
import f61.i;
import f61.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.mutualmark.mutualmark$ResourceInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$CommonBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$CommonGroupChatInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$DateTips;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$DnaInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$FriendInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$MutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$MutualScoreCard;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$OneGroupInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$PrefetchMutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$RspBody;
import tencent.im.oidb.oidb_0xd6c.oidb_0xd6c$RspBody;
import tencent.im.oidb.recheck_flag_info.recheck_flag_info$RecheckFlagInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class IntimateInfo extends Entity {
    public static final String TAG = "IntimateInfo";

    @notColumn
    public List<f61.a> activityBanner;
    public String addFriendWording;

    @notColumn
    public List<oidb_0xcf4$CommonBody> commonBodies;

    @notColumn
    public List<CommonBody> commonBodyList;
    public String commonBodyListStr;

    @notColumn
    public List<CommonTroopInfo> commonTroopInfoList;
    public String commonTroopInfoListJsonStr;
    public String commonTroopTips;

    @notColumn
    public List<DNAInfo> dnaInfoList;
    public String dnaInfoListJonStr;

    @notColumn
    public f61.b emptyStatusInfo;
    public FriendGiftInfo friendGiftInfo;

    @unique
    public String friendUin;

    @notColumn
    public List<f61.c> genericCardInfoList;

    @notColumn
    public boolean isShowRedPoint;

    @notColumn
    public e loveAchievementInfo;

    @notColumn
    public f loveTreeInfo;
    public String loveTreeJsonStr;

    @notColumn
    public int mCanRecheckCount;

    @notColumn
    public List<MutualMarkInfo> markInfoList;
    public String markInfoListJsonStr;
    public int maskDays;
    public int maskLevel;
    public int maskType;

    @notColumn
    public List<MemoryDayInfo> memoryDayInfoList;
    public String memoryDayListJsonStr;

    @notColumn
    public h mutualMarkList;

    @notColumn
    public ArrayList<i> newDnaInfos;

    @notColumn
    public List<PrefetchMutualMarkInfo> prefetchMutualMarkInfoList;
    public String prefetchMutualMarkInfoListJsonStr;

    @notColumn
    public CommonTroopInfo recentChatTroopInfo;
    public String recentChatTroopInfoJsonStr;

    @notColumn
    public IntimateScoreCardInfo scoreCardInfo;
    public String scoreCardInfoJsonStr;

    @notColumn
    public l specialWordInfo;
    public long updateTimeMills;
    public boolean useNewType;
    public int beFriendDays = -2;
    public int lastAnimAfterFriendDays = 0;
    public int addFriendSource = -1;
    public int addFriendSubSource = -1;
    public boolean isFriend = true;
    public int currentScore = 0;
    public int lastAnimAfterScore = 0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class CommonBody {
        public int cmd;
        public byte[] rspBodyContent;

        public static CommonBody copyFrom(oidb_0xcf4$CommonBody oidb_0xcf4_commonbody) {
            int i3;
            byte[] bArr = null;
            if (oidb_0xcf4_commonbody == null) {
                return null;
            }
            CommonBody commonBody = new CommonBody();
            if (oidb_0xcf4_commonbody.uint32_oidb_cmd.has()) {
                i3 = oidb_0xcf4_commonbody.uint32_oidb_cmd.get();
            } else {
                i3 = 0;
            }
            commonBody.cmd = i3;
            if (oidb_0xcf4_commonbody.string_oidb_body.has()) {
                bArr = oidb_0xcf4_commonbody.string_oidb_body.get().toByteArray();
            }
            commonBody.rspBodyContent = bArr;
            return commonBody;
        }

        public static CommonBody copyFromJson(JSONObject jSONObject) {
            CommonBody commonBody = new CommonBody();
            commonBody.cmd = jSONObject.optInt("cmd");
            commonBody.rspBodyContent = Base64.decode(jSONObject.optString("rspBodyContent"), 0);
            return commonBody;
        }

        public JSONObject getJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cmd", this.cmd);
                jSONObject.put("rspBodyContent", Base64.encodeToString(this.rspBodyContent, 0));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONObject;
        }

        public String toString() {
            return "CommonBody{cmd=" + this.cmd + ", rspBodyContent=" + this.rspBodyContent.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class CommonTroopInfo implements Parcelable {
        public static final Parcelable.Creator<CommonTroopInfo> CREATOR = new a();
        public long recentMsgTime;
        public String troopCode;
        public String troopName;
        public String troopUin;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a implements Parcelable.Creator<CommonTroopInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommonTroopInfo createFromParcel(Parcel parcel) {
                return new CommonTroopInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public CommonTroopInfo[] newArray(int i3) {
                return new CommonTroopInfo[i3];
            }
        }

        public CommonTroopInfo() {
        }

        public static CommonTroopInfo copyFrom(oidb_0xcf4$OneGroupInfo oidb_0xcf4_onegroupinfo) {
            String str;
            String str2;
            long j3;
            if (oidb_0xcf4_onegroupinfo == null) {
                return null;
            }
            CommonTroopInfo commonTroopInfo = new CommonTroopInfo();
            String str3 = "";
            if (!oidb_0xcf4_onegroupinfo.uint64_group_uin.has()) {
                str = "";
            } else {
                str = String.valueOf(oidb_0xcf4_onegroupinfo.uint64_group_uin.get());
            }
            commonTroopInfo.troopUin = str;
            if (!oidb_0xcf4_onegroupinfo.uint64_group_code.has()) {
                str2 = "";
            } else {
                str2 = String.valueOf(oidb_0xcf4_onegroupinfo.uint64_group_code.get());
            }
            commonTroopInfo.troopCode = str2;
            if (oidb_0xcf4_onegroupinfo.string_group_name.has()) {
                str3 = oidb_0xcf4_onegroupinfo.string_group_name.get().toStringUtf8();
            }
            commonTroopInfo.troopName = str3;
            if (oidb_0xcf4_onegroupinfo.uint32_cmduin_last_msg_time.has()) {
                j3 = oidb_0xcf4_onegroupinfo.uint32_cmduin_last_msg_time.get();
            } else {
                j3 = 0;
            }
            commonTroopInfo.recentMsgTime = j3;
            return commonTroopInfo;
        }

        public static CommonTroopInfo copyFromJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            CommonTroopInfo commonTroopInfo = new CommonTroopInfo();
            commonTroopInfo.troopUin = jSONObject.optString("troopUin", "");
            commonTroopInfo.troopCode = jSONObject.optString(IProfileProtocolConst.PARAM_TROOP_CODE, "");
            commonTroopInfo.troopName = jSONObject.optString("troopName", "");
            commonTroopInfo.recentMsgTime = jSONObject.optLong("recentMsgTime", 0L);
            return commonTroopInfo;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public JSONObject getJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.troopUin)) {
                    jSONObject.put("troopUin", this.troopUin);
                }
                if (!TextUtils.isEmpty(this.troopCode)) {
                    jSONObject.put(IProfileProtocolConst.PARAM_TROOP_CODE, this.troopCode);
                }
                if (!TextUtils.isEmpty(this.troopName)) {
                    jSONObject.put("troopName", this.troopName);
                }
                jSONObject.put("recentMsgTime", this.recentMsgTime);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONObject;
        }

        public String toString() {
            return "CommonTroopInfo{troopUin='" + this.troopUin + "', troopCode='" + this.troopCode + "', troopName='" + this.troopName + "', recentMsgTime=" + this.recentMsgTime + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.troopUin);
            parcel.writeString(this.troopCode);
            parcel.writeString(this.troopName);
            parcel.writeLong(this.recentMsgTime);
        }

        public CommonTroopInfo(Parcel parcel) {
            this.troopUin = parcel.readString();
            this.troopCode = parcel.readString();
            this.troopName = parcel.readString();
            this.recentMsgTime = parcel.readLong();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class DNAInfo {
        public String iconUrl;
        public String linkColor;
        public String linkUrl;
        public String linkWording;
        public int type;
        public String viceTitle;
        public String wording;

        public static DNAInfo copyFrom(oidb_0xcf4$DnaInfo oidb_0xcf4_dnainfo) {
            int i3;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            if (oidb_0xcf4_dnainfo == null) {
                return null;
            }
            DNAInfo dNAInfo = new DNAInfo();
            if (oidb_0xcf4_dnainfo.eDnaType.has()) {
                i3 = oidb_0xcf4_dnainfo.eDnaType.get();
            } else {
                i3 = 0;
            }
            dNAInfo.type = i3;
            String str6 = "";
            if (!oidb_0xcf4_dnainfo.bytes_icon_url.has()) {
                str = "";
            } else {
                str = oidb_0xcf4_dnainfo.bytes_icon_url.get().toStringUtf8();
            }
            dNAInfo.iconUrl = str;
            if (!oidb_0xcf4_dnainfo.bytes_wording.has()) {
                str2 = "";
            } else {
                str2 = oidb_0xcf4_dnainfo.bytes_wording.get().toStringUtf8();
            }
            dNAInfo.wording = str2;
            if (!oidb_0xcf4_dnainfo.bytes_vice_title.has()) {
                str3 = "";
            } else {
                str3 = oidb_0xcf4_dnainfo.bytes_vice_title.get().toStringUtf8();
            }
            dNAInfo.viceTitle = str3;
            if (!oidb_0xcf4_dnainfo.bytes_link_url.has()) {
                str4 = "";
            } else {
                str4 = oidb_0xcf4_dnainfo.bytes_link_url.get().toStringUtf8();
            }
            dNAInfo.linkUrl = str4;
            if (!oidb_0xcf4_dnainfo.bytes_link_wording.has()) {
                str5 = "";
            } else {
                str5 = oidb_0xcf4_dnainfo.bytes_link_wording.get().toStringUtf8();
            }
            dNAInfo.linkWording = str5;
            if (oidb_0xcf4_dnainfo.bytes_link_colour.has()) {
                str6 = oidb_0xcf4_dnainfo.bytes_link_colour.get().toStringUtf8();
            }
            dNAInfo.linkColor = str6;
            return dNAInfo;
        }

        public static DNAInfo copyFromJson(JSONObject jSONObject) {
            DNAInfo dNAInfo = new DNAInfo();
            dNAInfo.type = jSONObject.optInt("type");
            dNAInfo.iconUrl = jSONObject.optString("iconUrl");
            dNAInfo.wording = jSONObject.optString("wording");
            dNAInfo.viceTitle = jSONObject.optString("viceTitle");
            dNAInfo.linkUrl = jSONObject.optString("linkUrl");
            dNAInfo.linkWording = jSONObject.optString("linkWording");
            dNAInfo.linkColor = jSONObject.optString("linkColor");
            return dNAInfo;
        }

        public JSONObject getJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.type);
                jSONObject.put("iconUrl", this.iconUrl);
                jSONObject.put("wording", this.wording);
                jSONObject.put("viceTitle", this.viceTitle);
                jSONObject.put("linkUrl", this.linkUrl);
                jSONObject.put("linkWording", this.linkWording);
                jSONObject.put("linkColor", this.linkColor);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONObject;
        }

        public String toString() {
            return "DNAInfo{type=" + this.type + ", iconUrl='" + this.iconUrl + "', wording='" + this.wording + "', viceTitle='" + this.viceTitle + "', linkUrl='" + this.linkUrl + "', linkWording='" + this.linkWording + "', linkColor='" + this.linkColor + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class FriendGiftInfo {
        public String str_custom_url;
        public String str_desc;
        public List<String> str_gift_url;
        public int str_send_times;

        public static FriendGiftInfo copyFrom(CommonBody commonBody) {
            List<String> list;
            String str;
            int i3;
            if (commonBody == null) {
                return null;
            }
            FriendGiftInfo friendGiftInfo = new FriendGiftInfo();
            try {
                oidb_0xd6c$RspBody mergeFrom = new oidb_0xd6c$RspBody().mergeFrom(commonBody.rspBodyContent);
                if (mergeFrom.str_gift_url.has()) {
                    list = mergeFrom.str_gift_url.get();
                } else {
                    list = null;
                }
                friendGiftInfo.str_gift_url = list;
                String str2 = "";
                if (!mergeFrom.str_custom_url.has()) {
                    str = "";
                } else {
                    str = mergeFrom.str_custom_url.get();
                }
                friendGiftInfo.str_custom_url = str;
                if (mergeFrom.str_desc.has()) {
                    str2 = mergeFrom.str_desc.get();
                }
                friendGiftInfo.str_desc = str2;
                if (mergeFrom.str_send_times.has()) {
                    i3 = mergeFrom.str_send_times.get();
                } else {
                    i3 = 0;
                }
                friendGiftInfo.str_send_times = i3;
                return friendGiftInfo;
            } catch (Exception unused) {
                return null;
            }
        }

        public String toString() {
            return "FriendGiftInfo{str_gift_url=" + this.str_gift_url + "str_send_times=" + this.str_send_times + "str_desc=" + this.str_desc + "str_custom_url=" + this.str_custom_url + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class IntimateScoreCardInfo {
        public String buttonDescribe;
        public String buttonUrl;
        public int days;
        public int level;
        public String levelDescribe;
        public int score;
        public String title;
        public long type;
        public String typeDescribe;

        public static IntimateScoreCardInfo copyFrom(oidb_0xcf4$MutualScoreCard oidb_0xcf4_mutualscorecard) {
            if (oidb_0xcf4_mutualscorecard == null) {
                return null;
            }
            IntimateScoreCardInfo intimateScoreCardInfo = new IntimateScoreCardInfo();
            intimateScoreCardInfo.type = oidb_0xcf4_mutualscorecard.eMutualMarkNewType.get();
            intimateScoreCardInfo.level = oidb_0xcf4_mutualscorecard.uint32_level.get();
            intimateScoreCardInfo.days = oidb_0xcf4_mutualscorecard.uint32_days.get();
            if (oidb_0xcf4_mutualscorecard.bytes_title.has()) {
                intimateScoreCardInfo.title = oidb_0xcf4_mutualscorecard.bytes_title.get().toStringUtf8();
            }
            intimateScoreCardInfo.score = oidb_0xcf4_mutualscorecard.uint32_score.get();
            if (oidb_0xcf4_mutualscorecard.bytes_type_describe.has()) {
                intimateScoreCardInfo.typeDescribe = oidb_0xcf4_mutualscorecard.bytes_type_describe.get().toStringUtf8();
            }
            if (oidb_0xcf4_mutualscorecard.bytes_level_describe.has()) {
                intimateScoreCardInfo.levelDescribe = oidb_0xcf4_mutualscorecard.bytes_level_describe.get().toStringUtf8();
            }
            if (oidb_0xcf4_mutualscorecard.bytes_button_describe.has()) {
                intimateScoreCardInfo.buttonDescribe = oidb_0xcf4_mutualscorecard.bytes_button_describe.get().toStringUtf8();
            }
            if (oidb_0xcf4_mutualscorecard.bytes_button_url.has()) {
                intimateScoreCardInfo.buttonUrl = oidb_0xcf4_mutualscorecard.bytes_button_url.get().toStringUtf8();
            }
            return intimateScoreCardInfo;
        }

        public static IntimateScoreCardInfo copyFromJson(JSONObject jSONObject) {
            IntimateScoreCardInfo intimateScoreCardInfo = new IntimateScoreCardInfo();
            intimateScoreCardInfo.type = jSONObject.optLong("type");
            intimateScoreCardInfo.level = jSONObject.optInt("level");
            intimateScoreCardInfo.days = jSONObject.optInt("days");
            intimateScoreCardInfo.title = jSONObject.optString("title");
            intimateScoreCardInfo.score = jSONObject.optInt(LocalPhotoFaceInfo.SCORE);
            intimateScoreCardInfo.typeDescribe = jSONObject.optString("typeDescribe");
            intimateScoreCardInfo.levelDescribe = jSONObject.optString("levelDescribe");
            intimateScoreCardInfo.buttonDescribe = jSONObject.optString("buttonDescribe");
            intimateScoreCardInfo.buttonUrl = jSONObject.optString("buttonUrl");
            return intimateScoreCardInfo;
        }

        public JSONObject getJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.type);
                jSONObject.put("level", this.level);
                jSONObject.put("days", this.days);
                jSONObject.put("title", this.title);
                jSONObject.put(LocalPhotoFaceInfo.SCORE, this.score);
                jSONObject.put("typeDescribe", this.typeDescribe);
                jSONObject.put("levelDescribe", this.levelDescribe);
                jSONObject.put("buttonDescribe", this.buttonDescribe);
                jSONObject.put("buttonUrl", this.buttonUrl);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONObject;
        }

        public String toString() {
            return "IntimateScoreCardInfo{type=" + this.type + ", level='" + this.level + "', days='" + this.days + "', title='" + this.title + "', score='" + this.score + "', typeDescribe='" + this.typeDescribe + "', levelDescribe='" + this.levelDescribe + "', buttonDescribe='" + this.buttonDescribe + "', buttonUrl='" + this.buttonUrl + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class MemoryDayInfo {
        public long date;
        public int dateType;
        public String iconUrl;
        public int jumpType;
        public String linkColor;
        public String linkUrl;
        public String linkWording;
        public String wording;

        public static MemoryDayInfo copyFrom(oidb_0xcf4$DateTips oidb_0xcf4_datetips) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5 = null;
            if (oidb_0xcf4_datetips == null) {
                return null;
            }
            MemoryDayInfo memoryDayInfo = new MemoryDayInfo();
            memoryDayInfo.date = NetConnInfoCenter.getServerTimeMillis();
            memoryDayInfo.dateType = oidb_0xcf4_datetips.eDateType.get();
            if (oidb_0xcf4_datetips.bytes_icon_url.has()) {
                str = oidb_0xcf4_datetips.bytes_icon_url.get().toStringUtf8();
            } else {
                str = null;
            }
            memoryDayInfo.iconUrl = str;
            if (oidb_0xcf4_datetips.bytes_wording.has()) {
                str2 = oidb_0xcf4_datetips.bytes_wording.get().toStringUtf8();
            } else {
                str2 = null;
            }
            memoryDayInfo.wording = str2;
            if (oidb_0xcf4_datetips.bytes_link_url.has()) {
                str3 = oidb_0xcf4_datetips.bytes_link_url.get().toStringUtf8();
            } else {
                str3 = null;
            }
            memoryDayInfo.linkUrl = str3;
            if (oidb_0xcf4_datetips.bytes_link_wording.has()) {
                str4 = oidb_0xcf4_datetips.bytes_link_wording.get().toStringUtf8();
            } else {
                str4 = null;
            }
            memoryDayInfo.linkWording = str4;
            if (oidb_0xcf4_datetips.bytes_link_colour.has()) {
                str5 = oidb_0xcf4_datetips.bytes_link_colour.get().toStringUtf8();
            }
            memoryDayInfo.linkColor = str5;
            memoryDayInfo.jumpType = oidb_0xcf4_datetips.eJumpType.get();
            return memoryDayInfo;
        }

        public static MemoryDayInfo copyFromJson(JSONObject jSONObject) {
            MemoryDayInfo memoryDayInfo = new MemoryDayInfo();
            memoryDayInfo.date = jSONObject.optInt("date");
            memoryDayInfo.dateType = jSONObject.optInt("dateType");
            memoryDayInfo.iconUrl = jSONObject.optString("iconUrl");
            memoryDayInfo.wording = jSONObject.optString("wording");
            memoryDayInfo.linkUrl = jSONObject.optString("linkUrl");
            memoryDayInfo.linkWording = jSONObject.optString("linkWording");
            memoryDayInfo.linkColor = jSONObject.optString("linkColor");
            memoryDayInfo.jumpType = jSONObject.optInt("jumpType");
            return memoryDayInfo;
        }

        public JSONObject getJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("date", this.date);
                jSONObject.put("dateType", this.dateType);
                jSONObject.put("iconUrl", this.iconUrl);
                jSONObject.put("wording", this.wording);
                jSONObject.put("linkUrl", this.linkUrl);
                jSONObject.put("linkWording", this.linkWording);
                jSONObject.put("linkColor", this.linkColor);
                jSONObject.put("jumpType", this.jumpType);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONObject;
        }

        public String toString() {
            return "MemoryDayInfo{date=" + this.date + ", dateType='" + this.dateType + "', wording='" + this.wording + "', iconUrl='" + this.iconUrl + "', linkUrl='" + this.linkUrl + "', linkWording='" + this.linkWording + "', linkColor='" + this.linkColor + "', jumpType='" + this.jumpType + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class MutualMarkInfo {
        public int days;
        public int level;
        public long subLevel;
        public int type;
        public String iconStaticUrl = "";
        public mutualmark$ResourceInfo gradeResourceInfo = new mutualmark$ResourceInfo();
        public String minVersion = "";
        public String maxVersion = "";

        public static MutualMarkInfo copyFrom(oidb_0xcf4$MutualMarkInfo oidb_0xcf4_mutualmarkinfo) {
            int i3;
            int i16;
            long j3;
            if (oidb_0xcf4_mutualmarkinfo == null) {
                return null;
            }
            MutualMarkInfo mutualMarkInfo = new MutualMarkInfo();
            int i17 = 0;
            if (oidb_0xcf4_mutualmarkinfo.eMutualMarkNewType.has()) {
                i3 = oidb_0xcf4_mutualmarkinfo.eMutualMarkNewType.get();
            } else {
                i3 = 0;
            }
            mutualMarkInfo.type = i3;
            if (oidb_0xcf4_mutualmarkinfo.uint32_level.has()) {
                i16 = oidb_0xcf4_mutualmarkinfo.uint32_level.get();
            } else {
                i16 = 0;
            }
            mutualMarkInfo.level = i16;
            if (oidb_0xcf4_mutualmarkinfo.uint32_days.has()) {
                i17 = oidb_0xcf4_mutualmarkinfo.uint32_days.get();
            }
            mutualMarkInfo.days = i17;
            if (oidb_0xcf4_mutualmarkinfo.uint64_sub_level.has()) {
                j3 = oidb_0xcf4_mutualmarkinfo.uint64_sub_level.get();
            } else {
                j3 = 0;
            }
            mutualMarkInfo.subLevel = j3;
            if (oidb_0xcf4_mutualmarkinfo.bytes_grade_resource_info.has()) {
                try {
                    mutualMarkInfo.gradeResourceInfo.mergeFrom(oidb_0xcf4_mutualmarkinfo.bytes_grade_resource_info.get().toByteArray());
                } catch (Throwable th5) {
                    QLog.i(IntimateInfo.TAG, 1, "parseFrom error:" + th5.getMessage());
                    mutualMarkInfo.gradeResourceInfo = null;
                }
            }
            if (oidb_0xcf4_mutualmarkinfo.msg_special_word_info.has() && oidb_0xcf4_mutualmarkinfo.msg_special_word_info.get().bytes_static_url.has()) {
                mutualMarkInfo.iconStaticUrl = oidb_0xcf4_mutualmarkinfo.msg_special_word_info.get().bytes_static_url.get().toStringUtf8();
            }
            mutualmark$ResourceInfo mutualmark_resourceinfo = mutualMarkInfo.gradeResourceInfo;
            if (mutualmark_resourceinfo != null && mutualmark_resourceinfo.bytes_static_url.has() && !TextUtils.isEmpty(mutualMarkInfo.gradeResourceInfo.bytes_static_url.get().toStringUtf8())) {
                mutualMarkInfo.iconStaticUrl = mutualMarkInfo.gradeResourceInfo.bytes_static_url.get().toStringUtf8();
            }
            mutualMarkInfo.iconStaticUrl = g.b(mutualMarkInfo.iconStaticUrl);
            if (oidb_0xcf4_mutualmarkinfo.bytes_min_ver.has() && !TextUtils.isEmpty(oidb_0xcf4_mutualmarkinfo.bytes_min_ver.get().toStringUtf8())) {
                mutualMarkInfo.minVersion = oidb_0xcf4_mutualmarkinfo.bytes_min_ver.get().toStringUtf8();
            }
            if (oidb_0xcf4_mutualmarkinfo.bytes_max_ver.has() && !TextUtils.isEmpty(oidb_0xcf4_mutualmarkinfo.bytes_max_ver.get().toStringUtf8())) {
                mutualMarkInfo.maxVersion = oidb_0xcf4_mutualmarkinfo.bytes_max_ver.get().toStringUtf8();
            }
            if (!g.j(mutualMarkInfo.minVersion, mutualMarkInfo.maxVersion)) {
                QLog.i(IntimateInfo.TAG, 1, "oidb_0xcf4.MutualMarkInfo\uff0cisCurrentVersionShouldShow=false");
                return null;
            }
            return mutualMarkInfo;
        }

        public static MutualMarkInfo copyFromJson(JSONObject jSONObject) {
            MutualMarkInfo mutualMarkInfo = new MutualMarkInfo();
            mutualMarkInfo.type = jSONObject.optInt("type");
            mutualMarkInfo.level = jSONObject.optInt("level");
            mutualMarkInfo.days = jSONObject.optInt("days");
            mutualMarkInfo.subLevel = jSONObject.optInt("subLevel");
            mutualMarkInfo.iconStaticUrl = jSONObject.optString("iconStaticUrl");
            mutualMarkInfo.minVersion = jSONObject.optString("minVersion");
            mutualMarkInfo.maxVersion = jSONObject.optString("maxVersion");
            return mutualMarkInfo;
        }

        public JSONObject getJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.type);
                jSONObject.put("level", this.level);
                jSONObject.put("days", this.days);
                jSONObject.put("subLevel", this.subLevel);
                jSONObject.put("iconStaticUrl", this.iconStaticUrl);
                jSONObject.put("minVersion", this.minVersion);
                jSONObject.put("maxVersion", this.maxVersion);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONObject;
        }

        public String toString() {
            return "MutualMarkInfo{type=" + this.type + ", level=" + this.level + ", days=" + this.days + ", subLevel=" + this.subLevel + ", iconStaticUrl=" + this.iconStaticUrl + ", minVersion=" + this.minVersion + ", maxVersion=" + this.maxVersion + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class PrefetchMutualMarkInfo extends MutualMarkInfo {
        public int currentDays;

        public static PrefetchMutualMarkInfo copyFrom(oidb_0xcf4$PrefetchMutualMarkInfo oidb_0xcf4_prefetchmutualmarkinfo) {
            int i3;
            int i16;
            int i17;
            long j3;
            if (oidb_0xcf4_prefetchmutualmarkinfo == null) {
                return null;
            }
            PrefetchMutualMarkInfo prefetchMutualMarkInfo = new PrefetchMutualMarkInfo();
            int i18 = 0;
            if (oidb_0xcf4_prefetchmutualmarkinfo.eMutualMarkNewType.has()) {
                i3 = oidb_0xcf4_prefetchmutualmarkinfo.eMutualMarkNewType.get();
            } else {
                i3 = 0;
            }
            prefetchMutualMarkInfo.type = i3;
            if (oidb_0xcf4_prefetchmutualmarkinfo.uint32_level.has()) {
                i16 = oidb_0xcf4_prefetchmutualmarkinfo.uint32_level.get();
            } else {
                i16 = 0;
            }
            prefetchMutualMarkInfo.level = i16;
            if (oidb_0xcf4_prefetchmutualmarkinfo.uint32_days.has()) {
                i17 = oidb_0xcf4_prefetchmutualmarkinfo.uint32_days.get();
            } else {
                i17 = 0;
            }
            prefetchMutualMarkInfo.days = i17;
            if (oidb_0xcf4_prefetchmutualmarkinfo.uint32_current_days.has()) {
                i18 = oidb_0xcf4_prefetchmutualmarkinfo.uint32_current_days.get();
            }
            prefetchMutualMarkInfo.currentDays = i18;
            if (oidb_0xcf4_prefetchmutualmarkinfo.uint64_sub_level.has()) {
                j3 = oidb_0xcf4_prefetchmutualmarkinfo.uint64_sub_level.get();
            } else {
                j3 = 0;
            }
            prefetchMutualMarkInfo.subLevel = j3;
            if (oidb_0xcf4_prefetchmutualmarkinfo.bytes_grade_resource_info.has()) {
                try {
                    prefetchMutualMarkInfo.gradeResourceInfo.mergeFrom(oidb_0xcf4_prefetchmutualmarkinfo.bytes_grade_resource_info.get().toByteArray());
                } catch (Throwable th5) {
                    QLog.i(IntimateInfo.TAG, 1, "parseFrom error:" + th5.getMessage());
                    prefetchMutualMarkInfo.gradeResourceInfo = null;
                }
            }
            mutualmark$ResourceInfo mutualmark_resourceinfo = prefetchMutualMarkInfo.gradeResourceInfo;
            if (mutualmark_resourceinfo != null && mutualmark_resourceinfo.bytes_static_url.has() && !TextUtils.isEmpty(prefetchMutualMarkInfo.gradeResourceInfo.bytes_static_url.get().toStringUtf8())) {
                prefetchMutualMarkInfo.iconStaticUrl = prefetchMutualMarkInfo.gradeResourceInfo.bytes_static_url.get().toStringUtf8();
            }
            prefetchMutualMarkInfo.iconStaticUrl = g.b(prefetchMutualMarkInfo.iconStaticUrl);
            if (oidb_0xcf4_prefetchmutualmarkinfo.bytes_min_ver.has() && !TextUtils.isEmpty(oidb_0xcf4_prefetchmutualmarkinfo.bytes_min_ver.get().toStringUtf8())) {
                prefetchMutualMarkInfo.minVersion = oidb_0xcf4_prefetchmutualmarkinfo.bytes_min_ver.get().toStringUtf8();
            }
            if (oidb_0xcf4_prefetchmutualmarkinfo.bytes_max_ver.has() && !TextUtils.isEmpty(oidb_0xcf4_prefetchmutualmarkinfo.bytes_max_ver.get().toStringUtf8())) {
                prefetchMutualMarkInfo.maxVersion = oidb_0xcf4_prefetchmutualmarkinfo.bytes_max_ver.get().toStringUtf8();
            }
            if (!g.j(prefetchMutualMarkInfo.minVersion, prefetchMutualMarkInfo.maxVersion)) {
                QLog.i(IntimateInfo.TAG, 1, "oidb_0xcf4.PrefetchMutualMarkInfo\uff0cisCurrentVersionShouldShow=false");
                return null;
            }
            return prefetchMutualMarkInfo;
        }

        public static PrefetchMutualMarkInfo copyFromJson(JSONObject jSONObject) {
            PrefetchMutualMarkInfo prefetchMutualMarkInfo = new PrefetchMutualMarkInfo();
            prefetchMutualMarkInfo.type = jSONObject.optInt("type");
            prefetchMutualMarkInfo.level = jSONObject.optInt("level");
            prefetchMutualMarkInfo.days = jSONObject.optInt("days");
            prefetchMutualMarkInfo.currentDays = jSONObject.optInt("currentDays");
            prefetchMutualMarkInfo.subLevel = jSONObject.optInt("subLevel");
            prefetchMutualMarkInfo.iconStaticUrl = jSONObject.optString("iconStaticUrl");
            prefetchMutualMarkInfo.minVersion = jSONObject.optString("minVersion");
            prefetchMutualMarkInfo.maxVersion = jSONObject.optString("maxVersion");
            return prefetchMutualMarkInfo;
        }

        @Override // com.tencent.mobileqq.data.IntimateInfo.MutualMarkInfo
        public JSONObject getJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.type);
                jSONObject.put("level", this.level);
                jSONObject.put("days", this.days);
                jSONObject.put("subLevel", this.subLevel);
                jSONObject.put("currentDays", this.currentDays);
                jSONObject.put("iconStaticUrl", this.iconStaticUrl);
                jSONObject.put("minVersion", this.minVersion);
                jSONObject.put("maxVersion", this.maxVersion);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONObject;
        }

        @Override // com.tencent.mobileqq.data.IntimateInfo.MutualMarkInfo
        public String toString() {
            return "MutualMarkInfo{type=" + this.type + ", level=" + this.level + ", days=" + this.days + ", currentDays=" + this.currentDays + ", subLevel=" + this.subLevel + ", iconStaticUrl=" + this.iconStaticUrl + ", minVersion=" + this.minVersion + ", maxVersion=" + this.maxVersion + '}';
        }
    }

    public static int convert0xcf4Type2MutualMaskType(int i3) {
        if (i3 != 1) {
            if (i3 == 2) {
                return 5;
            }
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 9) {
                            switch (i3) {
                                case 20:
                                    return 2;
                                case 21:
                                    return 3;
                                case 22:
                                    return 1;
                                default:
                                    return 0;
                            }
                        }
                        return 4;
                    }
                    return 7;
                }
                return 8;
            }
            return 12;
        }
        return 6;
    }

    public static String convertUinKeyForGroupCard(String str, String str2) {
        return str + "_" + str2;
    }

    public static IntimateInfo copyFrom(QQAppInterface qQAppInterface, oidb_0xcf4$RspBody oidb_0xcf4_rspbody) {
        String str;
        List<oidb_0xcf4$PrefetchMutualMarkInfo> list;
        List<oidb_0xcf4$MutualMarkInfo> list2;
        oidb_0xcf4$CommonGroupChatInfo oidb_0xcf4_commongroupchatinfo;
        List<oidb_0xcf4$OneGroupInfo> list3;
        oidb_0xcf4$FriendInfo oidb_0xcf4_friendinfo;
        int i3;
        int i16;
        oidb_0xcf4$MutualMarkInfo oidb_0xcf4_mutualmarkinfo;
        int i17;
        int i18;
        if (oidb_0xcf4_rspbody != null && qQAppInterface != null) {
            IntimateInfo intimateInfo = new IntimateInfo();
            String str2 = "";
            if (!oidb_0xcf4_rspbody.uint64_to_uin.has()) {
                str = "";
            } else {
                str = String.valueOf(oidb_0xcf4_rspbody.uint64_to_uin.get());
            }
            intimateInfo.friendUin = str;
            intimateInfo.useNewType = true;
            if (oidb_0xcf4_rspbody.msg_cur_mutual_mark_info.has() && (oidb_0xcf4_mutualmarkinfo = oidb_0xcf4_rspbody.msg_cur_mutual_mark_info.get()) != null) {
                int i19 = 0;
                if (oidb_0xcf4_mutualmarkinfo.eMutualMarkNewType.has()) {
                    i17 = oidb_0xcf4_mutualmarkinfo.eMutualMarkNewType.get();
                } else {
                    i17 = 0;
                }
                intimateInfo.maskType = i17;
                if (oidb_0xcf4_mutualmarkinfo.uint32_level.has()) {
                    i18 = oidb_0xcf4_mutualmarkinfo.uint32_level.get();
                } else {
                    i18 = 0;
                }
                intimateInfo.maskLevel = i18;
                if (oidb_0xcf4_mutualmarkinfo.uint32_days.has()) {
                    i19 = oidb_0xcf4_mutualmarkinfo.uint32_days.get();
                }
                intimateInfo.maskDays = i19;
            }
            if (oidb_0xcf4_rspbody.msg_friend_info.has() && (oidb_0xcf4_friendinfo = oidb_0xcf4_rspbody.msg_friend_info.get()) != null) {
                int i26 = -1;
                if (oidb_0xcf4_friendinfo.uint32_add_frd_days.has()) {
                    i3 = oidb_0xcf4_friendinfo.uint32_add_frd_days.get();
                } else {
                    i3 = -1;
                }
                intimateInfo.beFriendDays = i3;
                if (oidb_0xcf4_friendinfo.uint32_add_frd_source.has()) {
                    i16 = oidb_0xcf4_friendinfo.uint32_add_frd_source.get();
                } else {
                    i16 = -1;
                }
                intimateInfo.addFriendSource = i16;
                if (oidb_0xcf4_friendinfo.uint32_add_frd_sub_source.has()) {
                    i26 = oidb_0xcf4_friendinfo.uint32_add_frd_sub_source.get();
                }
                intimateInfo.addFriendSubSource = i26;
                if (oidb_0xcf4_friendinfo.bytes_add_frd_wording.has()) {
                    str2 = oidb_0xcf4_friendinfo.bytes_add_frd_wording.get().toStringUtf8();
                }
                intimateInfo.addFriendWording = str2;
            }
            if (oidb_0xcf4_rspbody.msg_common_group_chat_info.has() && (oidb_0xcf4_commongroupchatinfo = oidb_0xcf4_rspbody.msg_common_group_chat_info.get()) != null) {
                if (oidb_0xcf4_commongroupchatinfo.msg_one_group_info.has()) {
                    intimateInfo.recentChatTroopInfo = CommonTroopInfo.copyFrom(oidb_0xcf4_commongroupchatinfo.msg_one_group_info.get());
                }
                if (oidb_0xcf4_commongroupchatinfo.rpt_msg_one_group_info.has() && (list3 = oidb_0xcf4_commongroupchatinfo.rpt_msg_one_group_info.get()) != null && list3.size() > 0) {
                    intimateInfo.commonTroopInfoList = new ArrayList();
                    Iterator<oidb_0xcf4$OneGroupInfo> it = list3.iterator();
                    while (it.hasNext()) {
                        CommonTroopInfo copyFrom = CommonTroopInfo.copyFrom(it.next());
                        if (copyFrom != null) {
                            intimateInfo.commonTroopInfoList.add(copyFrom);
                        }
                    }
                }
                if (oidb_0xcf4_commongroupchatinfo.bytes_wording.has()) {
                    intimateInfo.commonTroopTips = oidb_0xcf4_commongroupchatinfo.bytes_wording.get().toStringUtf8();
                }
            }
            if (oidb_0xcf4_rspbody.rpt_msg_mutual_mark_info.has() && (list2 = oidb_0xcf4_rspbody.rpt_msg_mutual_mark_info.get()) != null && list2.size() > 0) {
                intimateInfo.markInfoList = new ArrayList();
                Iterator<oidb_0xcf4$MutualMarkInfo> it5 = list2.iterator();
                while (it5.hasNext()) {
                    MutualMarkInfo copyFrom2 = MutualMarkInfo.copyFrom(it5.next());
                    if (copyFrom2 != null && g.n(copyFrom2.type)) {
                        intimateInfo.markInfoList.add(copyFrom2);
                    }
                }
            }
            if (oidb_0xcf4_rspbody.rpt_msg_prefetch_mutual_mark_info.has() && (list = oidb_0xcf4_rspbody.rpt_msg_prefetch_mutual_mark_info.get()) != null && list.size() > 0) {
                intimateInfo.prefetchMutualMarkInfoList = new ArrayList();
                Iterator<oidb_0xcf4$PrefetchMutualMarkInfo> it6 = list.iterator();
                while (it6.hasNext()) {
                    PrefetchMutualMarkInfo copyFrom3 = PrefetchMutualMarkInfo.copyFrom(it6.next());
                    if (copyFrom3 != null && g.n(copyFrom3.type)) {
                        intimateInfo.prefetchMutualMarkInfoList.add(copyFrom3);
                    }
                }
            }
            if (oidb_0xcf4_rspbody.rpt_msg_dna_info.has()) {
                intimateInfo.dnaInfoList = new ArrayList();
                List<oidb_0xcf4$DnaInfo> list4 = oidb_0xcf4_rspbody.rpt_msg_dna_info.get();
                if (list4 != null && list4.size() > 0) {
                    Iterator<oidb_0xcf4$DnaInfo> it7 = list4.iterator();
                    while (it7.hasNext()) {
                        DNAInfo copyFrom4 = DNAInfo.copyFrom(it7.next());
                        if (copyFrom4 != null) {
                            intimateInfo.dnaInfoList.add(copyFrom4);
                        }
                    }
                }
            }
            if (oidb_0xcf4_rspbody.rpt_msg_data_tips.has()) {
                intimateInfo.memoryDayInfoList = new ArrayList();
                List<oidb_0xcf4$DateTips> list5 = oidb_0xcf4_rspbody.rpt_msg_data_tips.get();
                if (list5 != null) {
                    Iterator<oidb_0xcf4$DateTips> it8 = list5.iterator();
                    while (it8.hasNext()) {
                        MemoryDayInfo copyFrom5 = MemoryDayInfo.copyFrom(it8.next());
                        if (copyFrom5 != null) {
                            intimateInfo.memoryDayInfoList.add(copyFrom5);
                        }
                    }
                }
            }
            if (oidb_0xcf4_rspbody.rpt_msg_common_rspbody.has()) {
                intimateInfo.commonBodyList = new ArrayList();
                List<oidb_0xcf4$CommonBody> list6 = oidb_0xcf4_rspbody.rpt_msg_common_rspbody.get();
                if (list6 != null) {
                    for (oidb_0xcf4$CommonBody oidb_0xcf4_commonbody : list6) {
                        CommonBody copyFrom6 = CommonBody.copyFrom(oidb_0xcf4_commonbody);
                        if (copyFrom6 != null) {
                            intimateInfo.commonBodyList.add(copyFrom6);
                            int i27 = copyFrom6.cmd;
                            if (i27 == 3436) {
                                intimateInfo.friendGiftInfo = FriendGiftInfo.copyFrom(copyFrom6);
                            } else if (i27 == 3399) {
                                byte[] byteArray = oidb_0xcf4_commonbody.string_oidb_body.get().toByteArray();
                                try {
                                    recheck_flag_info$RecheckFlagInfo recheck_flag_info_recheckflaginfo = new recheck_flag_info$RecheckFlagInfo();
                                    recheck_flag_info_recheckflaginfo.mergeFrom(byteArray);
                                    intimateInfo.isShowRedPoint = recheck_flag_info_recheckflaginfo.bool_has_redtouch.get();
                                    intimateInfo.mCanRecheckCount = recheck_flag_info_recheckflaginfo.uint32_recheck_num.get();
                                } catch (Exception e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.w("intimate_relationship", 2, "parse 0xd47 body exception:" + e16.getStackTrace());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (oidb_0xcf4_rspbody.rpt_msg_mutual_score_card.has()) {
                IntimateScoreCardInfo copyFrom7 = IntimateScoreCardInfo.copyFrom(oidb_0xcf4_rspbody.rpt_msg_mutual_score_card.get());
                intimateInfo.scoreCardInfo = copyFrom7;
                if (copyFrom7 != null) {
                    intimateInfo.currentScore = copyFrom7.score;
                }
            }
            intimateInfo.updateTimeMills = NetConnInfoCenter.getServerTimeMillis();
            intimateInfo.isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(intimateInfo.friendUin), TAG);
            intimateInfo.commonBodies = oidb_0xcf4_rspbody.rpt_msg_common_rspbody.get();
            copyFrom848NewInfo(qQAppInterface, oidb_0xcf4_rspbody, intimateInfo);
            intimateInfo.loveTreeInfo = f.b(oidb_0xcf4_rspbody.msg_love_tree_info.get());
            return intimateInfo;
        }
        return null;
    }

    private static void copyFrom848NewInfo(QQAppInterface qQAppInterface, oidb_0xcf4$RspBody oidb_0xcf4_rspbody, IntimateInfo intimateInfo) {
        if (oidb_0xcf4_rspbody.msg_love_ach_info.has()) {
            intimateInfo.loveAchievementInfo = e.a(oidb_0xcf4_rspbody.msg_love_ach_info.get());
        }
        if (oidb_0xcf4_rspbody.rpt_new_dna_info.has()) {
            intimateInfo.newDnaInfos = i.a(oidb_0xcf4_rspbody.rpt_new_dna_info.get());
        }
        if (oidb_0xcf4_rspbody.msg_empty_status.has()) {
            intimateInfo.emptyStatusInfo = f61.b.a(oidb_0xcf4_rspbody.msg_empty_status.get());
        }
    }

    public static String getUinFromGroupCardKey(String str) {
        String[] split;
        if (str != null && (split = str.split("_")) != null && split.length >= 2) {
            return split[1];
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        if (!TextUtils.isEmpty(this.commonTroopInfoListJsonStr)) {
            try {
                JSONArray jSONArray = new JSONArray(this.commonTroopInfoListJsonStr);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    CommonTroopInfo copyFromJson = CommonTroopInfo.copyFromJson(jSONArray.getJSONObject(i3));
                    if (copyFromJson != null) {
                        if (this.commonTroopInfoList == null) {
                            this.commonTroopInfoList = new ArrayList();
                        }
                        this.commonTroopInfoList.add(copyFromJson);
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        } else {
            this.commonTroopInfoList = null;
        }
        if (!TextUtils.isEmpty(this.recentChatTroopInfoJsonStr)) {
            try {
                this.recentChatTroopInfo = CommonTroopInfo.copyFromJson(new JSONObject(this.recentChatTroopInfoJsonStr));
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        } else {
            this.recentChatTroopInfo = null;
        }
        if (!TextUtils.isEmpty(this.markInfoListJsonStr)) {
            try {
                JSONArray jSONArray2 = new JSONArray(this.markInfoListJsonStr);
                for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                    MutualMarkInfo copyFromJson2 = MutualMarkInfo.copyFromJson(jSONArray2.getJSONObject(i16));
                    if (copyFromJson2 != null) {
                        if (this.markInfoList == null) {
                            this.markInfoList = new ArrayList();
                        }
                        this.markInfoList.add(copyFromJson2);
                    }
                }
            } catch (JSONException e18) {
                e18.printStackTrace();
            }
        } else {
            this.markInfoList = null;
        }
        if (!TextUtils.isEmpty(this.prefetchMutualMarkInfoListJsonStr)) {
            try {
                JSONArray jSONArray3 = new JSONArray(this.prefetchMutualMarkInfoListJsonStr);
                for (int i17 = 0; i17 < jSONArray3.length(); i17++) {
                    PrefetchMutualMarkInfo copyFromJson3 = PrefetchMutualMarkInfo.copyFromJson(jSONArray3.getJSONObject(i17));
                    if (copyFromJson3 != null) {
                        if (this.prefetchMutualMarkInfoList == null) {
                            this.prefetchMutualMarkInfoList = new ArrayList();
                        }
                        this.prefetchMutualMarkInfoList.add(copyFromJson3);
                    }
                }
            } catch (JSONException e19) {
                e19.printStackTrace();
            }
        } else {
            this.prefetchMutualMarkInfoList = null;
        }
        if (!TextUtils.isEmpty(this.dnaInfoListJonStr)) {
            try {
                JSONArray jSONArray4 = new JSONArray(this.dnaInfoListJonStr);
                for (int i18 = 0; i18 < jSONArray4.length(); i18++) {
                    DNAInfo copyFromJson4 = DNAInfo.copyFromJson(jSONArray4.getJSONObject(i18));
                    if (copyFromJson4 != null) {
                        if (this.dnaInfoList == null) {
                            this.dnaInfoList = new ArrayList();
                        }
                        this.dnaInfoList.add(copyFromJson4);
                    }
                }
            } catch (JSONException e26) {
                e26.printStackTrace();
            }
        } else {
            this.dnaInfoList = null;
        }
        if (!TextUtils.isEmpty(this.memoryDayListJsonStr)) {
            try {
                JSONArray jSONArray5 = new JSONArray(this.memoryDayListJsonStr);
                for (int i19 = 0; i19 < jSONArray5.length(); i19++) {
                    MemoryDayInfo copyFromJson5 = MemoryDayInfo.copyFromJson(jSONArray5.getJSONObject(i19));
                    if (copyFromJson5 != null) {
                        if (this.memoryDayInfoList == null) {
                            this.memoryDayInfoList = new ArrayList();
                        }
                        this.memoryDayInfoList.add(copyFromJson5);
                    }
                }
            } catch (JSONException e27) {
                e27.printStackTrace();
            }
        } else {
            this.memoryDayInfoList = null;
        }
        if (!TextUtils.isEmpty(this.commonBodyListStr)) {
            try {
                JSONArray jSONArray6 = new JSONArray(this.commonBodyListStr);
                for (int i26 = 0; i26 < jSONArray6.length(); i26++) {
                    CommonBody copyFromJson6 = CommonBody.copyFromJson(jSONArray6.getJSONObject(i26));
                    if (copyFromJson6 != null) {
                        if (this.commonBodyList == null) {
                            this.commonBodyList = new ArrayList();
                        }
                        this.commonBodyList.add(copyFromJson6);
                        if (copyFromJson6.cmd == 3436 && copyFromJson6.rspBodyContent != null) {
                            this.friendGiftInfo = FriendGiftInfo.copyFrom(copyFromJson6);
                        }
                    }
                }
            } catch (JSONException e28) {
                e28.printStackTrace();
            }
        } else {
            this.commonBodyList = null;
        }
        if (!this.useNewType) {
            this.useNewType = true;
            this.maskType = convert0xcf4Type2MutualMaskType(this.maskType);
            List<MutualMarkInfo> list = this.markInfoList;
            if (list != null) {
                for (MutualMarkInfo mutualMarkInfo : list) {
                    mutualMarkInfo.type = convert0xcf4Type2MutualMaskType(mutualMarkInfo.type);
                }
            }
            List<PrefetchMutualMarkInfo> list2 = this.prefetchMutualMarkInfoList;
            if (list2 != null) {
                for (PrefetchMutualMarkInfo prefetchMutualMarkInfo : list2) {
                    prefetchMutualMarkInfo.type = convert0xcf4Type2MutualMaskType(prefetchMutualMarkInfo.type);
                }
            }
        }
        if (!TextUtils.isEmpty(this.scoreCardInfoJsonStr)) {
            try {
                this.scoreCardInfo = IntimateScoreCardInfo.copyFromJson(new JSONObject(this.scoreCardInfoJsonStr));
            } catch (JSONException e29) {
                e29.printStackTrace();
            }
        } else {
            this.scoreCardInfo = null;
        }
        this.loveTreeInfo = f.c(this.loveTreeJsonStr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        JSONObject jSONObject;
        List<CommonTroopInfo> list = this.commonTroopInfoList;
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<CommonTroopInfo> it = this.commonTroopInfoList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next().getJSONObject());
            }
            this.commonTroopInfoListJsonStr = jSONArray.toString();
        } else {
            this.commonTroopInfoListJsonStr = "";
        }
        CommonTroopInfo commonTroopInfo = this.recentChatTroopInfo;
        if (commonTroopInfo != null && (jSONObject = commonTroopInfo.getJSONObject()) != null) {
            this.recentChatTroopInfoJsonStr = jSONObject.toString();
        }
        List<MutualMarkInfo> list2 = this.markInfoList;
        if (list2 != null && list2.size() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<MutualMarkInfo> it5 = this.markInfoList.iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put(it5.next().getJSONObject());
            }
            this.markInfoListJsonStr = jSONArray2.toString();
        } else {
            this.markInfoListJsonStr = "";
        }
        List<PrefetchMutualMarkInfo> list3 = this.prefetchMutualMarkInfoList;
        if (list3 != null && list3.size() > 0) {
            JSONArray jSONArray3 = new JSONArray();
            Iterator<PrefetchMutualMarkInfo> it6 = this.prefetchMutualMarkInfoList.iterator();
            while (it6.hasNext()) {
                jSONArray3.mo162put(it6.next().getJSONObject());
            }
            this.prefetchMutualMarkInfoListJsonStr = jSONArray3.toString();
        } else {
            this.prefetchMutualMarkInfoListJsonStr = "";
        }
        List<DNAInfo> list4 = this.dnaInfoList;
        if (list4 != null && list4.size() > 0) {
            JSONArray jSONArray4 = new JSONArray();
            Iterator<DNAInfo> it7 = this.dnaInfoList.iterator();
            while (it7.hasNext()) {
                jSONArray4.mo162put(it7.next().getJSONObject());
            }
            this.dnaInfoListJonStr = jSONArray4.toString();
        } else {
            this.dnaInfoListJonStr = "";
        }
        if (this.memoryDayInfoList != null) {
            JSONArray jSONArray5 = new JSONArray();
            Iterator<MemoryDayInfo> it8 = this.memoryDayInfoList.iterator();
            while (it8.hasNext()) {
                jSONArray5.mo162put(it8.next().getJSONObject());
            }
            this.memoryDayListJsonStr = jSONArray5.toString();
        } else {
            this.memoryDayListJsonStr = "";
        }
        List<CommonBody> list5 = this.commonBodyList;
        if (list5 != null && list5.size() > 0) {
            JSONArray jSONArray6 = new JSONArray();
            Iterator<CommonBody> it9 = this.commonBodyList.iterator();
            while (it9.hasNext()) {
                jSONArray6.mo162put(it9.next().getJSONObject());
            }
            this.commonBodyListStr = jSONArray6.toString();
        } else {
            this.commonBodyListStr = "";
        }
        IntimateScoreCardInfo intimateScoreCardInfo = this.scoreCardInfo;
        if (intimateScoreCardInfo != null) {
            this.scoreCardInfoJsonStr = intimateScoreCardInfo.getJSONObject().toString();
        } else {
            this.scoreCardInfoJsonStr = "";
        }
        f fVar = this.loveTreeInfo;
        if (fVar != null) {
            this.loveTreeJsonStr = fVar.a();
        }
    }

    public String toString() {
        return "IntimateInfo{friendUin='" + this.friendUin + "', maskType=" + this.maskType + ", maskLevel=" + this.maskLevel + ", maskDays=" + this.maskDays + ", useNewType=" + this.useNewType + ", beFriendDays=" + this.beFriendDays + ", lastAnimAfterFriendDays=" + this.lastAnimAfterFriendDays + ", currentScore=" + this.currentScore + ", lastAnimAfterScore=" + this.lastAnimAfterScore + ", addFriendSource=" + this.addFriendSource + ", addFriendSubSource=" + this.addFriendSubSource + ", addFriendWording=" + this.addFriendWording + ", markInfoListJsonStr=" + this.markInfoListJsonStr + ", prefetchMutualMarkInfoListJsonStr=" + this.prefetchMutualMarkInfoListJsonStr + ", isFriend=" + this.isFriend + ", updateTimeMills=" + this.updateTimeMills + ", scoreCardInfo=" + this.scoreCardInfo + ", newDnaInfos=" + this.newDnaInfos + '}';
    }
}
