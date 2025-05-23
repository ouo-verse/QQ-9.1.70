package com.tencent.mobileqq.data;

import GameCenter.RespLastGameInfo;
import SummaryCard.TPraiseInfo;
import SummaryCard.TVideoHeadInfo;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Pair;
import appoint.define.appoint_define$InterestTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.bussiness.achievement.processor.LifeAchievementBusinessProcessor;
import com.tencent.mobileqq.profilecard.entity.ProfileBusiEntry;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.nowsummarycard.NowSummaryCard$CommonTag;
import com.tencent.nowsummarycard.NowSummaryCard$NearbyTag;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import tencent.im.group.group_member_info$InfoCardVideoInfo;
import tencent.im.oidb.cmd0x5e9.GetPhotoList$HeadInfo;
import tencent.im.oidb.cmd0x5e9.GetPhotoList$RspBody;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList$HeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList$RspBody;
import tencent.im.oidb.cmd0x74b.oidb_0x74b$HeadInfo;
import tencent.im.oidb.cmd0x74b.oidb_0x74b$RspBody;
import tencent.im.oidb.cmd0x74b.oidb_0x74b$VideoHeadInfo;
import tencent.im.oidb.cmd0xac5.cmd0xac5$NearbyNowData;

/* loaded from: classes10.dex */
public class NearbyPeopleCard extends Entity {
    private static final String TAG = "Q.nearby_people_card.";
    public int age;
    public String aioDistanceAndTime;
    public String bVideoHeadUrl;
    public byte bVoted;
    public int birthday;
    public String busiEntry;
    public long charm;
    public int charmLevel;

    @notColumn
    public long chatId;
    public String college;
    public long collegeId;
    public String commonLabelString;

    @notColumn
    public List<String> commonLabels;
    public NowSummaryCard$CommonTag commonTag;
    public String company;
    public byte constellation;
    public int curThreshold;
    public byte[] dateInfo;
    public String distance;
    public int entryAbility;
    public String faceScoreIconUrl;
    public String faceScoreTailWording;
    public int faceScoreTailWordingColor;
    public String faceScoreWording;
    public int faceScoreWordingColor;
    public int favoriteSource;
    public long feedPreviewTime;
    public String firstOfficialMsg;
    public String guideAppNowDownloadUrl;
    public String guideAppNowJumpUri;
    public String guideAppNowPackage;
    public String guideAppNowTip;
    public String guideAppNowTipLeftBtn;
    public String guideAppNowTipRightBtnInstalled;
    public String guideAppNowTipRightBtnNotInstalled;
    public String guideVerifiedDialogRightBtnText;
    public String guideVerifiedDialogTitle;
    public String hiWanInfo;
    public List<HiWanItem> hiWanList;
    public String hometownCity;
    public String hometownCountry;
    public String hometownDistrict;
    public String hometownProvice;

    @notColumn
    public HotChatInfo hotInfo;
    public int iIsGodFlag;

    @notColumn
    public List<m92.a> interestTags;

    @notColumn
    public boolean isFriend;

    @notColumn
    public boolean isHostSelf;
    public boolean isPhotoUseCache;
    public boolean isVerified;
    public int job;
    public long lastUpdateNickTime;
    public int likeCount;
    public int likeCountInc;
    public int mHeartNum;
    public byte[] mQQStoryData;
    public byte maritalStatus;
    public int maskMsgFlag;
    public int nLastGameFlag;
    public byte[] nearbyInfo;

    @notColumn
    public cmd0xac5$NearbyNowData nearbyNowData;
    public byte[] nearbyNowDataBytes;
    public NowSummaryCard$NearbyTag nearbyTag;
    public int nextThreshold;
    public String nickname;
    public long nowId;
    public int nowUserType;
    public int oldPhotoCount;
    public String picInfo;

    @notColumn
    public List<PicInfo> picList;

    @notColumn
    public List<TPraiseInfo> praiseList;
    public int profPercent;

    @notColumn
    public List<ProfileBusiEntry> profileBusiEntry;
    public String qzoneFeed;
    public String qzoneName;
    public String qzonePicUrl_1;
    public String qzonePicUrl_2;
    public String qzonePicUrl_3;
    public Pair<Long, String> recentlyJoinedGroup;
    public int sayHelloFlag;
    public String sign;
    public String strFreshNewsInfo;
    public String strGodJumpUrl;
    public String strHotChatInfo;
    public String strLevelType;
    public String strProfileUrl;
    public String strRemark;
    public String strVoteLimitedNotice;
    public long switchGiftVisible;
    public boolean switchHobby;
    public boolean switchQzone;
    public long tagFlag;
    public String tagInfo;
    public int taskFinished;
    public int taskTotal;
    public String timeDiff;
    public long uRoomid;
    public long uiShowControl;
    public String uin;
    public String unverifyGrayTips;
    public long userFlag;
    public byte[] vActivityList;
    public byte[] vCookies;
    public byte[] vGiftInfo;
    public byte[] vGroupList;
    public byte[] vSeed;
    public byte[] vTempChatSig;
    public String videoDetails;
    public PicInfo videoInfo;
    public byte[] xuanYan;
    public long tinyId = 0;
    public byte gender = -1;
    public long ulShowControl = 0;
    public long lUserFlag = 0;
    public boolean godFlag = false;
    public short bHaveVotedCnt = 0;
    public short bAvailVoteCnt = 0;
    public boolean videoHeadFlag = false;
    public boolean isForbidSendMsg = false;
    public boolean isForbidSendGiftMsg = false;
    public String disableSendMsgBtnTips = "";
    public String disableSendGiftBtnTips = "";
    public boolean isForbidSendMsgForTribar = false;
    public boolean isForbidSendGiftMsgForTribar = false;
    public String disableSendMsgBtnTipsForTribar = "";
    public String disableSendGiftBtnTipsForTribar = "";
    public int highScoreNum = 0;
    public boolean mHasStory = false;
    public boolean isSendMsgBtnDownloadAppOpen = true;
    public String sendMsgBtnDownloadAppTips = "";
    public String addPicBtnDownloadAppTips = "";
    public String tribeAppDownloadPageUrl = "";

    /* loaded from: classes10.dex */
    public static class HiWanItem {
        public String icon;
        public int status;
        public String title;
        public int type;
        public String url;
    }

    public void addOrUpdateBuisEntry(ProfileBusiEntry profileBusiEntry) {
        if (profileBusiEntry == null) {
            return;
        }
        int i3 = profileBusiEntry.nBusiEntryType;
        if (this.profileBusiEntry == null) {
            getBusiEntrys();
        }
        boolean z16 = false;
        int i16 = 0;
        while (true) {
            if (i16 >= this.profileBusiEntry.size()) {
                break;
            }
            if (this.profileBusiEntry.get(i16).nBusiEntryType == i3) {
                this.profileBusiEntry.remove(i16);
                this.profileBusiEntry.add(profileBusiEntry);
                z16 = true;
                break;
            }
            i16++;
        }
        if (!z16) {
            this.profileBusiEntry.add(profileBusiEntry);
        }
    }

    public void addQQStoryList(List<group_member_info$InfoCardVideoInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).cover.has()) {
                String stringUtf8 = list.get(i3).cover.get().toStringUtf8();
                if (!TextUtils.isEmpty(stringUtf8)) {
                    arrayList.add(stringUtf8);
                }
            }
        }
        if (arrayList.size() != 0) {
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            obtain.writeList(arrayList);
            this.mQQStoryData = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            return;
        }
        this.mQQStoryData = null;
    }

    public List<ProfileBusiEntry> getBusiEntrys() {
        if (this.profileBusiEntry == null) {
            this.profileBusiEntry = new ArrayList();
            if (!TextUtils.isEmpty(this.busiEntry)) {
                try {
                    JSONArray jSONArray = new JSONArray(this.busiEntry);
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        if (jSONObject != null) {
                            ProfileBusiEntry profileBusiEntry = new ProfileBusiEntry();
                            profileBusiEntry.nBusiEntryType = jSONObject.getInt("nBusiEntryType");
                            profileBusiEntry.strLogoUrl = jSONObject.getString("strLogoUrl");
                            profileBusiEntry.strTitle = jSONObject.getString("strTitle");
                            profileBusiEntry.strContent = jSONObject.getString("strContent");
                            profileBusiEntry.strJumpUrl = jSONObject.getString("strJumpUrl");
                            if (!profileBusiEntry.isEmpty()) {
                                this.profileBusiEntry.add(profileBusiEntry);
                            }
                        }
                    }
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, e16.toString());
                    }
                }
            }
        }
        return this.profileBusiEntry;
    }

    public m92.a getCommonTagInfos() {
        if (this.commonLabels == null) {
            return null;
        }
        m92.a aVar = new m92.a(8);
        for (String str : this.commonLabels) {
            if (str != null) {
                InterestTagInfo interestTagInfo = new InterestTagInfo();
                interestTagInfo.tagBgColor = "#dcebff";
                interestTagInfo.tagTextColor = "#4b83d3";
                interestTagInfo.tagIconUrl = "";
                interestTagInfo.tagName = str;
                aVar.f416459b.add(interestTagInfo);
            }
        }
        return aVar;
    }

    public boolean getIsHostSelf(String str) {
        boolean equals = TextUtils.equals(this.uin, str);
        this.isHostSelf = equals;
        return equals;
    }

    public List<String> getQQStoryList() {
        ArrayList arrayList = new ArrayList();
        if (this.mQQStoryData != null) {
            try {
                Parcel obtain = Parcel.obtain();
                byte[] bArr = this.mQQStoryData;
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                arrayList = obtain.readArrayList(getClass().getClassLoader());
                OaidMonitor.parcelRecycle(obtain);
                return arrayList;
            } catch (Error e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("SummaryCard, getQQStoryList:", 2, e16.toString());
                    return arrayList;
                }
                return arrayList;
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.i("SummaryCard, getQQStoryList:", 2, e17.toString());
                    return arrayList;
                }
                return arrayList;
            }
        }
        return arrayList;
    }

    public List<String> getQZonePhotoList() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.qzonePicUrl_1)) {
            arrayList.add(this.qzonePicUrl_1);
        }
        if (!TextUtils.isEmpty(this.qzonePicUrl_2)) {
            arrayList.add(this.qzonePicUrl_2);
        }
        if (!TextUtils.isEmpty(this.qzonePicUrl_3)) {
            arrayList.add(this.qzonePicUrl_3);
        }
        return arrayList;
    }

    public String getSafetyUin() {
        if (!TextUtils.isEmpty(this.uin) && !"0".equals(this.uin)) {
            return this.uin;
        }
        return String.valueOf(this.tinyId);
    }

    public m92.a getTagInfos(int i3) {
        List<m92.a> list;
        if (i3 < 1 || i3 > 11 || (list = this.interestTags) == null || list.size() == 0) {
            return null;
        }
        for (m92.a aVar : this.interestTags) {
            if (aVar != null && aVar.f416458a == i3) {
                return aVar;
            }
        }
        return null;
    }

    public boolean hasInterestTag() {
        List<m92.a> list = this.interestTags;
        if (list != null && !list.isEmpty()) {
            Iterator<m92.a> it = this.interestTags.iterator();
            while (it.hasNext()) {
                ArrayList<InterestTagInfo> arrayList = it.next().f416459b;
                if (arrayList != null && !arrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasQzonePhotoUrl() {
        if (StringUtil.isEmpty(this.qzonePicUrl_1) && StringUtil.isEmpty(this.qzonePicUrl_2) && StringUtil.isEmpty(this.qzonePicUrl_3)) {
            return false;
        }
        return true;
    }

    public boolean isAddPicBtnDownloadAppOpen() {
        if ((this.uiShowControl & 512) != 0) {
            return true;
        }
        return false;
    }

    public boolean isAuthUser() {
        if ((this.userFlag & 32) == 0) {
            return false;
        }
        return true;
    }

    public boolean isFuXiaoJin() {
        if ((this.userFlag & 512) != 0) {
            return true;
        }
        return false;
    }

    public boolean isOpenRecentPlayingGamesByNative() {
        if ((this.nLastGameFlag & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean isPhotoUseCache() {
        return this.isPhotoUseCache;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        m92.a aVar;
        super.postRead();
        if (TextUtils.isEmpty(this.tagInfo)) {
            this.interestTags = null;
        } else {
            this.interestTags = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(this.tagInfo);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null && (aVar = (m92.a) ((IInterestTagUtils) QRoute.api(IInterestTagUtils.class)).convertFromJSONObject(jSONObject)) != null) {
                        this.interestTags.add(aVar);
                    }
                }
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                } else if (QLog.isColorLevel()) {
                    QLog.i("Q.nearby_people_card.", 2, e16.toString());
                }
            }
        }
        if (TextUtils.isEmpty(this.picInfo)) {
            this.picList = null;
        } else {
            this.picList = PicInfo.b(this.picInfo);
        }
        if (TextUtils.isEmpty(this.videoDetails)) {
            this.videoInfo = null;
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject(this.videoDetails);
                this.videoInfo = new PicInfo();
                if (jSONObject2.has(AppConstants.Key.KEY_QZONE_VIDEO_URL)) {
                    this.videoInfo.f258920i = jSONObject2.getString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
                }
                if (jSONObject2.has("bigPicUrl")) {
                    this.videoInfo.f258917e = jSONObject2.getString("bigPicUrl");
                }
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
        this.hiWanList = new ArrayList();
        if (TextUtils.isEmpty(this.hiWanInfo)) {
            this.hiWanList = null;
        } else {
            try {
                JSONArray jSONArray2 = new JSONArray(this.hiWanInfo);
                for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i16);
                    HiWanItem hiWanItem = new HiWanItem();
                    if (jSONObject3.has("title")) {
                        hiWanItem.title = jSONObject3.getString("title");
                    }
                    if (jSONObject3.has("icon")) {
                        hiWanItem.icon = jSONObject3.getString("icon");
                    }
                    if (jSONObject3.has("url")) {
                        hiWanItem.url = jSONObject3.getString("url");
                    }
                    if (jSONObject3.has("status")) {
                        hiWanItem.status = jSONObject3.getInt("status");
                    }
                    if (jSONObject3.has("type")) {
                        hiWanItem.type = jSONObject3.getInt("type");
                    }
                    this.hiWanList.add(hiWanItem);
                }
            } catch (JSONException e18) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("Q.nearby_people_card.", 4, "hiWanList convertFrom exception : " + e18.getMessage());
                }
            }
        }
        this.commonLabels = new ArrayList();
        if (TextUtils.isEmpty(this.commonLabelString)) {
            this.commonLabels = null;
        } else {
            try {
                JSONArray jSONArray3 = new JSONArray(this.commonLabelString);
                for (int i17 = 0; i17 < jSONArray3.length(); i17++) {
                    this.commonLabels.add(jSONArray3.getString(i17));
                }
            } catch (JSONException e19) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("Q.nearby_people_card.", 4, "hiWanList convertFrom exception : " + e19.getMessage());
                }
            }
        }
        if (TextUtils.isEmpty(this.strHotChatInfo)) {
            this.hotInfo = null;
        } else {
            updateHotChatInfo(this.strHotChatInfo);
        }
        try {
            cmd0xac5$NearbyNowData cmd0xac5_nearbynowdata = new cmd0xac5$NearbyNowData();
            this.nearbyNowData = cmd0xac5_nearbynowdata;
            cmd0xac5_nearbynowdata.mergeFrom(this.nearbyNowDataBytes);
        } catch (Exception unused) {
            this.nearbyNowData = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        super.prewrite();
    }

    public void removeBuisEntry(ProfileBusiEntry profileBusiEntry) {
        if (profileBusiEntry == null) {
            return;
        }
        int i3 = profileBusiEntry.nBusiEntryType;
        if (this.profileBusiEntry == null) {
            getBusiEntrys();
        }
        for (int i16 = 0; i16 < this.profileBusiEntry.size(); i16++) {
            if (this.profileBusiEntry.get(i16).nBusiEntryType == i3) {
                this.profileBusiEntry.remove(i16);
                return;
            }
        }
    }

    public void saveBusiEntrys(List<ProfileBusiEntry> list) {
        int size;
        JSONStringer jSONStringer = new JSONStringer();
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        try {
            if (size > 0) {
                jSONStringer.array();
                for (int i3 = 0; i3 < size; i3++) {
                    ProfileBusiEntry profileBusiEntry = list.get(i3);
                    if (profileBusiEntry != null && !profileBusiEntry.isEmpty()) {
                        jSONStringer.object().key("nBusiEntryType").value(profileBusiEntry.nBusiEntryType).key("strLogoUrl").value(profileBusiEntry.strLogoUrl).key("strTitle").value(profileBusiEntry.strTitle).key("strContent").value(profileBusiEntry.strContent).key("strJumpUrl").value(profileBusiEntry.strJumpUrl).endObject();
                    }
                }
                jSONStringer.endArray();
                this.busiEntry = jSONStringer.toString();
            } else {
                this.busiEntry = "";
            }
        } catch (JSONException e16) {
            this.busiEntry = "";
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, e16.toString());
            }
        }
        List<ProfileBusiEntry> list2 = this.profileBusiEntry;
        if (list2 != null) {
            list2.clear();
            if (list != null && list.size() > 0) {
                this.profileBusiEntry.addAll(list);
            }
        }
    }

    public void setPhotoUseCache(long j3) {
        boolean z16;
        if ((j3 & 1) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isPhotoUseCache = z16;
    }

    public boolean shouldShowHobby() {
        if ((this.uiShowControl & 32) == 0) {
            return true;
        }
        return false;
    }

    public boolean shouldShowLikeBtn() {
        if ((this.uiShowControl & 4) == 0) {
            return false;
        }
        return true;
    }

    public boolean shouldShowQzoneFeed() {
        if ((this.uiShowControl & 1) == 0) {
            return false;
        }
        return true;
    }

    public boolean shouldShowSendMsg() {
        if ((this.uiShowControl & 256) == 0) {
            return true;
        }
        return false;
    }

    public List<PicInfo> updateDisplayPicInfos(byte[] bArr, TVideoHeadInfo tVideoHeadInfo, boolean z16) {
        String str;
        String str2;
        String str3;
        int i3;
        Object valueOf;
        List<oidb_0x74b$HeadInfo> list;
        List<oidb_0x74b$VideoHeadInfo> list2;
        int i16 = -1;
        if (tVideoHeadInfo != null) {
            if (!this.videoHeadFlag && tVideoHeadInfo.iNearbyFlag == 1) {
                this.videoHeadFlag = true;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos|set videoHeadFlag true");
                }
            }
            if (tVideoHeadInfo.vMsg != null) {
                oidb_0x74b$RspBody oidb_0x74b_rspbody = new oidb_0x74b$RspBody();
                try {
                    oidb_0x74b_rspbody.mergeFrom(tVideoHeadInfo.vMsg);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.nearby_people_card.", 2, ".onNearbyCardDownload(), parse vedio head info fail.");
                    }
                }
                if (oidb_0x74b_rspbody.rpt_msg_uin_head_list.has() && (list = oidb_0x74b_rspbody.rpt_msg_uin_head_list.get().get(0).rpt_msg_head_list.get()) != null) {
                    Iterator<oidb_0x74b$HeadInfo> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        oidb_0x74b$HeadInfo next = it.next();
                        if (next.uint32_type.get() == 17) {
                            if (next.uint32_id.has()) {
                                i16 = next.uint32_id.get();
                            }
                            if (next.rpt_videoheadlist.has()) {
                                list2 = next.rpt_videoheadlist.get();
                            } else {
                                list2 = null;
                            }
                            if (list2 != null) {
                                for (oidb_0x74b$VideoHeadInfo oidb_0x74b_videoheadinfo : list2) {
                                    if (oidb_0x74b_videoheadinfo.uint32_video_size.get() == 640) {
                                        str = oidb_0x74b_videoheadinfo.str_url.get();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        str = null;
        if (QLog.isColorLevel()) {
            QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos|basicVideoUrl: " + str + " ,basicVideoId:" + i16 + ",videoHeadFlag:" + this.videoHeadFlag + ",isMySelf:" + z16);
        }
        if (!TextUtils.isEmpty(str)) {
            this.bVideoHeadUrl = str;
        }
        if (bArr == null) {
            return null;
        }
        GetPhotoList$RspBody getPhotoList$RspBody = new GetPhotoList$RspBody();
        if (bArr != null) {
            try {
                getPhotoList$RspBody.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.nearby_people_card.", 2, ".onNearbyCardDownload(), parse head info fail.");
                }
            }
        }
        if (!getPhotoList$RspBody.rpt_msg_uin_heads.has()) {
            return null;
        }
        GetPhotoList$HeadInfo getPhotoList$HeadInfo = getPhotoList$RspBody.rpt_msg_uin_heads.get().get(0).msg_verify_video_info.get();
        String str4 = "";
        if (getPhotoList$HeadInfo != null && getPhotoList$HeadInfo.get() != null && !TextUtils.isEmpty(getPhotoList$HeadInfo.get().str_video_id.get())) {
            PicInfo picInfo = new PicInfo();
            this.videoInfo = picInfo;
            picInfo.C = getPhotoList$HeadInfo.get().str_video_id.get();
            this.videoInfo.f258920i = getPhotoList$HeadInfo.str_video_url.get();
            this.videoInfo.f258917e = getPhotoList$HeadInfo.str_headurl.get();
            JSONObject a16 = this.videoInfo.a();
            if (a16 != null) {
                this.videoDetails = a16.toString();
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos, videoUrl:" + this.videoInfo.f258920i + ", bigPicUrl:" + this.videoInfo.f258917e);
            }
        } else {
            this.videoInfo = null;
            this.videoDetails = "";
            if (QLog.isColorLevel()) {
                QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos, videoInfo is null .");
            }
        }
        List<GetPhotoList$HeadInfo> list3 = getPhotoList$RspBody.rpt_msg_uin_heads.get().get(0).rpt_msg_headinfo.get();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("head size = ");
            if (list3 == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(list3.size());
            }
            sb5.append(valueOf);
            QLog.d("Q.nearby_people_card.", 2, sb5.toString());
        }
        if (list3 == null || list3.isEmpty()) {
            return null;
        }
        this.picList = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        int min = Math.min(18, list3.size());
        for (int i17 = 0; i17 < min; i17++) {
            GetPhotoList$HeadInfo getPhotoList$HeadInfo2 = list3.get(i17);
            PicInfo picInfo2 = new PicInfo();
            picInfo2.f258916d = getPhotoList$HeadInfo2.uint32_headid.get();
            picInfo2.f258917e = getPhotoList$HeadInfo2.str_headurl.get();
            picInfo2.f258918f = picInfo2.f258917e + "250";
            if (i17 == 0 || z16) {
                if (getPhotoList$HeadInfo2.str_video_url.has()) {
                    str2 = getPhotoList$HeadInfo2.str_video_url.get();
                } else {
                    str2 = null;
                }
                picInfo2.f258920i = str2;
                if (getPhotoList$HeadInfo2.str_video_id.has()) {
                    str3 = getPhotoList$HeadInfo2.str_video_id.get();
                } else {
                    str3 = null;
                }
                picInfo2.C = str3;
                if (getPhotoList$HeadInfo2.uint32_video_size.has()) {
                    i3 = getPhotoList$HeadInfo2.uint32_video_size.get();
                } else {
                    i3 = 0;
                }
                if (!TextUtils.isEmpty(picInfo2.f258920i)) {
                    picInfo2.f258921m = DynamicAvatarDownloadManager.j(picInfo2.f258920i);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos, videoUrlSize:" + i3);
                }
            }
            this.picList.add(picInfo2);
            JSONObject a17 = picInfo2.a();
            if (a17 != null) {
                jSONArray.mo162put(a17);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos, picInfo:" + picInfo2);
            }
        }
        if (jSONArray.length() > 0) {
            str4 = jSONArray.toString();
        }
        this.picInfo = str4;
        return this.picList;
    }

    public List<PicInfo> updateEditPicInfos(byte[] bArr, PicInfo picInfo) {
        List<UpdatePhotoList$HeadInfo> list;
        String jSONArray;
        int i3;
        String str;
        String str2;
        if (bArr == null) {
            return null;
        }
        UpdatePhotoList$RspBody updatePhotoList$RspBody = new UpdatePhotoList$RspBody();
        try {
            updatePhotoList$RspBody.mergeFrom(bArr);
            if (updatePhotoList$RspBody.rpt_msg_headinfo.has()) {
                list = updatePhotoList$RspBody.rpt_msg_headinfo.get();
            } else {
                list = null;
            }
        } catch (Exception e16) {
            if (l92.b.f414007a && QLog.isColorLevel()) {
                QLog.d("Q.nearby_people_card.", 2, "rsp_5ea" + e16.toString());
            }
            this.picInfo = "";
        }
        if (list != null && !list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.nearby_people_card.", 2, "edit head size = " + list.size() + ",extraPicInfo:" + picInfo);
            }
            this.picList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            boolean z16 = false;
            for (UpdatePhotoList$HeadInfo updatePhotoList$HeadInfo : list) {
                PicInfo picInfo2 = new PicInfo();
                if (updatePhotoList$HeadInfo.uint32_headid.has()) {
                    i3 = updatePhotoList$HeadInfo.uint32_headid.get();
                } else {
                    i3 = -1;
                }
                picInfo2.f258916d = i3;
                if (!updatePhotoList$HeadInfo.str_headurl.has()) {
                    str = "";
                } else {
                    str = updatePhotoList$HeadInfo.str_headurl.get();
                }
                picInfo2.f258917e = str;
                if (TextUtils.isEmpty(str)) {
                    str2 = "";
                } else {
                    str2 = picInfo2.f258917e + "250";
                }
                picInfo2.f258918f = str2;
                if (updatePhotoList$HeadInfo.str_video_url.has() && updatePhotoList$HeadInfo.str_video_id.has()) {
                    String str3 = updatePhotoList$HeadInfo.str_video_url.get();
                    picInfo2.f258920i = str3;
                    picInfo2.f258921m = DynamicAvatarDownloadManager.j(str3);
                    picInfo2.C = updatePhotoList$HeadInfo.str_video_id.get();
                    if (picInfo != null && picInfo.f258916d == picInfo2.f258916d && !TextUtils.isEmpty(picInfo2.f258920i) && !picInfo2.f258921m.equals(picInfo.f258921m)) {
                        try {
                            FileUtils.copyFile(picInfo.f258921m, picInfo2.f258921m);
                        } catch (Exception e17) {
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.nearby_people_card.", 2, "copy videoHead exception:" + e17.getMessage());
                            }
                        }
                    }
                    z16 = true;
                }
                this.picList.add(picInfo2);
                JSONObject a16 = picInfo2.a();
                if (a16 != null) {
                    jSONArray2.mo162put(a16);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.nearby_people_card.", 2, "picInfo = " + picInfo2);
                }
            }
            if (!this.videoHeadFlag && z16) {
                this.videoHeadFlag = true;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.nearby_people_card.", 2, "rsp_5ea,set videoHeadFlag true");
                }
            }
            if (jSONArray2.length() <= 0) {
                jSONArray = "";
            } else {
                jSONArray = jSONArray2.toString();
            }
            this.picInfo = jSONArray;
            return this.picList;
        }
        return null;
    }

    public void updateHotChatInfo(HotChatInfo hotChatInfo) {
        if (hotChatInfo == null) {
            this.hotInfo = null;
            return;
        }
        this.hotInfo = hotChatInfo;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.hotInfo.name);
            jSONObject.put(QCircleLpReportDc010001.KEY_SUBTYPE, this.hotInfo.subType);
            jSONObject.put("joinUrl", this.hotInfo.joinUrl);
            jSONObject.put("troopUin", this.hotInfo.troopUin);
            jSONObject.put(IProfileProtocolConst.PARAM_TROOP_CODE, this.hotInfo.troopCode);
            this.strHotChatInfo = jSONObject.toString();
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.nearby_people_card.", 2, "convertHotChatInfo2Json error.");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.nearby_people_card.", 2, "convertHotChatInfo2Json : " + jSONObject.toString());
        }
    }

    public void updateInterestTags(List<appoint_define$InterestTag> list) {
        updateInterestTags(this.tagFlag, list);
    }

    public void updateLastGameInfo(RespLastGameInfo respLastGameInfo) {
        if (respLastGameInfo != null && respLastGameInfo.iResult == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("SummaryCard", 2, "updateLastGameInfo|info.bShowGameLogo = " + respLastGameInfo.bShowGameLogo + "|info.bNative = " + respLastGameInfo.bNative + "|info.sLogoUrl = " + respLastGameInfo.sLogoUrl);
            }
            if (respLastGameInfo.bShowGameLogo) {
                int i3 = this.nLastGameFlag | 1;
                this.nLastGameFlag = i3;
                if (respLastGameInfo.bNative) {
                    this.nLastGameFlag = i3 | 2;
                } else {
                    this.nLastGameFlag = i3 & (-3);
                }
                this.strProfileUrl = respLastGameInfo.sProfileUrl;
                return;
            }
            this.nLastGameFlag &= -2;
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SummaryCard", 2, "handleGetSummaryCard|updateLastGameInfo|info = null or info.iResult != 0");
        }
    }

    public void updateInterestTags(long j3, List<appoint_define$InterestTag> list) {
        JSONObject a16;
        this.tagFlag = j3;
        if (list != null && list.size() != 0) {
            List<m92.a> list2 = this.interestTags;
            if (list2 == null) {
                this.interestTags = new ArrayList(list.size());
            } else {
                list2.clear();
            }
            Iterator<appoint_define$InterestTag> it = list.iterator();
            while (it.hasNext()) {
                m92.a aVar = (m92.a) ((IInterestTagUtils) QRoute.api(IInterestTagUtils.class)).convertFrom(it.next());
                if (aVar != null) {
                    this.interestTags.add(aVar);
                }
            }
        } else {
            List<m92.a> list3 = this.interestTags;
            if (list3 != null) {
                list3.clear();
            }
        }
        List<m92.a> list4 = this.interestTags;
        if (list4 != null && list4.size() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (m92.a aVar2 : this.interestTags) {
                    if (aVar2 != null && aVar2.f416459b.size() != 0 && (a16 = aVar2.a()) != null) {
                        jSONArray.mo162put(a16);
                    }
                }
                this.tagInfo = jSONArray.toString();
            } catch (OutOfMemoryError unused) {
                System.gc();
                this.tagInfo = "";
            }
        } else {
            this.tagInfo = "";
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateInterestTags,");
            List<m92.a> list5 = this.interestTags;
            if (list5 != null && list5.size() > 0) {
                sb5.append(this.interestTags.size());
                sb5.append(", {");
                Iterator<m92.a> it5 = this.interestTags.iterator();
                while (it5.hasNext()) {
                    sb5.append(it5.next().toString());
                    sb5.append(",");
                }
                sb5.append("}");
            }
            QLog.i("InterestTag", 4, sb5.toString());
        }
    }

    public boolean hasInterestTag(int i3, long j3) {
        m92.a tagInfos = getTagInfos(i3);
        if (tagInfos == null) {
            return false;
        }
        Iterator<InterestTagInfo> it = tagInfos.f416459b.iterator();
        while (it.hasNext()) {
            if (it.next().tagId == j3) {
                return true;
            }
        }
        return false;
    }

    public void getTagInfos(m92.a[] aVarArr) {
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        for (m92.a aVar : aVarArr) {
            if (aVar != null) {
                m92.a tagInfos = getTagInfos(aVar.f416458a);
                aVar.f416459b.clear();
                if (tagInfos != null && tagInfos.f416459b.size() > 0) {
                    aVar.f416459b.addAll(tagInfos.f416459b);
                }
            }
        }
    }

    public void updateHotChatInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hotInfo = null;
        }
        this.hotInfo = new HotChatInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("name")) {
                this.hotInfo.name = jSONObject.getString("name");
            }
            if (jSONObject.has(QCircleLpReportDc010001.KEY_SUBTYPE)) {
                this.hotInfo.subType = jSONObject.getInt(QCircleLpReportDc010001.KEY_SUBTYPE);
            }
            if (jSONObject.has("joinUrl")) {
                this.hotInfo.joinUrl = jSONObject.getString("joinUrl");
            }
            if (jSONObject.has("troopUin")) {
                this.hotInfo.troopUin = jSONObject.getString("troopUin");
            }
            if (jSONObject.has(IProfileProtocolConst.PARAM_TROOP_CODE)) {
                this.hotInfo.troopCode = jSONObject.getString(IProfileProtocolConst.PARAM_TROOP_CODE);
            }
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.nearby_people_card.", 2, "convert2HotChatInfoFromJson error.");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.nearby_people_card.", 2, "convert2HotChatInfoFromJson: " + this.hotInfo);
        }
    }
}
