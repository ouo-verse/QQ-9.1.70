package com.tencent.mobileqq.data;

import QQService.EVIPSPEC;
import QQService.PrivilegeInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SummaryCard.AlbumInfo;
import SummaryCard.PhotoInfo;
import SummaryCard.TPraiseInfo;
import SummaryCardTaf.SLabelInfo;
import SummaryCardTaf.summaryCardWzryInfo;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileColor;
import com.tencent.mobileqq.profilecard.entity.ProfileGroupLabel;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesEntry;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesItem;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import tencent.im.mutualmark.MutualMarkCard$Guide;
import tencent.im.mutualmark.mutualmark$State;
import tencent.im.oidb.cmd0x703.cmd0x703$PhotoInfo;
import tencent.im.oidb.cmd0x703.cmd0x703$UinPhotoListInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class Card extends Entity {
    public static final long BIRTHDAY_INVALID = 0;
    public static final int CONSTELLATION_INVALID = 0;
    public static final short FEMALE = 1;
    public static final int INVALID_STATE = -1;
    public static final short MALE = 0;
    public static final int PROFESSION_DEFAULT = -1;
    private static final String TAG = "Card";
    public static final short UNKNOWN_MALE = -1;
    public long addSrcId;
    public String addSrcName;
    public long addSubSrcId;
    public byte age;
    public boolean allowCalInteractive;
    public boolean allowClick;
    public boolean allowPeopleSee;
    public long authState;
    public byte bBigClubVipOpen;
    public byte[] bCardInfo;
    public byte bHollywoodVipOpen;
    public byte bQQVipOpen;
    public byte bSuperQQOpen;
    public byte bSuperVipOpen;
    public byte bVoted;
    public boolean babyQSwitch;
    public byte[] bgType;
    public String bindPhoneInfo;
    private Map<Class<? extends IProfileBusinessInfo>, IProfileBusinessInfo> businessInfoMap;
    public long cardId;
    public int cardType;
    public int category;
    public int clothesId;

    @notColumn
    public String coverUrl;
    public String declaration;
    public int defaultCardId;
    public String diyComplicatedInfo;
    public String diyDefaultText;
    public String diyText;
    public float diyTextDegree;
    public int diyTextFontId;
    public float diyTextHeight;
    public float diyTextLocX;
    public float diyTextLocY;
    public float diyTextTransparency;
    public float diyTextWidth;

    @notColumn
    public byte[] dressByte;

    @notColumn
    public boolean dressUpIsOn;
    public String encId;
    public int enlargeQzonePic;
    public short extendFriendEntryAddFriend;
    public short extendFriendEntryContact;
    public int extendFriendFlag;
    public short extendFriendQuestion;
    public int extendFriendVoiceDuration;
    public int favoriteSource;
    public long feedPreviewTime;
    public int fontId;
    public int fontType;

    @notColumn
    public boolean hasRequestZPlanAvatarInfo;
    public String hobbyEntry;
    public int iBigClubVipLevel;
    public int iBigClubVipType;
    public int iHollywoodVipLevel;
    public int iHollywoodVipType;
    public int iMedalCount;
    public int iNewCount;
    public int iQQLevel;
    public int iQQVipLevel;
    public int iQQVipType;
    public int iSuperQQLevel;
    public int iSuperQQType;
    public int iSuperVipLevel;
    public int iSuperVipType;
    public int iUpgradeCount;
    public int iVoteIncrement;
    public int iXManScene1DelayTime;
    public int iXManScene2DelayTime;
    public int idx;
    public boolean isHidePrettyGroutIdentity;
    public boolean isPrettyGroupOwner;

    @notColumn
    public boolean isQCircleDynamicAvatar;
    public boolean isShowCard;

    @notColumn
    public boolean isShowQCircleCover;

    @notColumn
    public boolean isStrongSimilarity;
    public boolean isZPlanAvatar;
    public String isZPlanProfileCardMiniHomeShow;
    public boolean isZplanMasterShow;
    public boolean isZplanProfileCardShow;
    public long lBigClubTemplateId;
    public long lLoginDays;
    public long lQQMasterLogindays;
    public long lSignModifyTime;
    public long lSuperVipTemplateId;
    public long lUserFlag;
    public long lVisitCount;
    public long lVoteCount;
    public byte[] labelInfoBytes;
    public byte[] lastPraiseInfoList;

    @notColumn
    public ArrayList<TPraiseInfo> lastPraiseInfos;
    public int mQQLevelType;
    public Map<String, String> mapQzoneEx;

    @notColumn
    public int mutualCount;

    @notColumn
    public MutualMarkCard$Guide mutualGuide;

    @notColumn
    public String mutualHomeUrl;
    public int nFaceID;
    public int namePlateOfKingDan;
    public boolean namePlateOfKingDanDisplatSwitch;
    public long namePlateOfKingGameId;
    public long namePlateOfKingLoginTime;
    public int popularity;
    public String presentCustourl;
    public String presentDesc;
    public int presentNum;
    public boolean presentSwitch;
    public List<String> presentUrl;
    public String privilegeJumpUrl;
    public String privilegePromptStr;

    @notColumn
    public String qcircleFeedId;

    @notColumn
    public String qcircleFeedPosterUin;

    @notColumn
    public String qcircleVideoCoverUrl;

    @notColumn
    public int qcircleVideoHeight;

    @notColumn
    public String qcircleVideoUrl;

    @notColumn
    public int qcircleVideoWidth;
    public String qid;
    public String qidBgUrl;
    public String qidColor;
    public String qidLogoUrl;

    @notColumn
    public boolean qqCardIsOn;
    public String schoolId;
    public String schoolName;
    public boolean schoolVerifiedFlag;
    public boolean showPublishButton;

    @notColumn
    public String singer;

    @notColumn
    public long songDuration;

    @notColumn
    public String songId;

    @notColumn
    public String songName;

    @notColumn
    public boolean splendidIsGray;

    @notColumn
    public boolean splendidIsOn;

    @notColumn
    public String splendidJumpUrl;

    @notColumn
    public int splendidNValueNum;

    @notColumn
    public int splendidNum;
    public String strAutoRemark;
    public String strCity;
    public String strCompany;
    public String strContactName;
    public String strCountry;
    public String strCurrentBgUrl;
    public String strEmail;
    public String strExtInfo;
    public String strHometownCity;
    public String strHometownCodes;
    public String strHometownCountry;
    public String strHometownDesc;
    public String strHometownProvince;
    public String strLocationCodes;
    public String strLocationDesc;
    public String strLoginDaysDesc;
    public String strMobile;
    public String strNick;
    public String strPersonalNote;
    public String strPromptParams;
    public String strProvince;
    public String strQzoneFeedsDesc;
    public String strQzoneHeader;
    public String strReMark;
    public String strSchool;
    public String strShowName;
    public String strSign;
    public String strSpaceName;
    public String strStatus;
    public String strVoteLimitedNotice;

    @notColumn
    public String strZPlanNightUrl;

    @notColumn
    public String strZPlanProperty;

    @notColumn
    public String strZPlanShpUrl;

    @notColumn
    public String strZplanDayUrl;
    public String strZplanUrl;
    public boolean strangerVoteOpen;

    @notColumn
    public StrongSimilarityData strongSimilarityData;

    @notColumn
    public List<ProfileSummaryHobbiesEntry> summaryEntrys;

    @notColumn
    public long svipPrivilegeLimitTime;

    @notColumn
    public boolean svipPrivilegeNeedShow;
    public byte[] tempChatSig;
    public long uCurMulType;
    public int uFaceTimeStamp;

    @unique
    public String uin;
    public int ulShowControl;
    public long updateTime;
    public byte[] vClosePriv;
    public byte[] vCookies;
    public byte[] vCoverInfo;
    public byte[] vLongNickTopicInfo;
    public byte[] vOpenPriv;
    public byte[] vQQFaceID;
    public byte[] vQzoneCoverInfo;
    public byte[] vQzonePhotos;
    public byte[] vRichSign;
    public byte[] vSeed;
    public int vipMedalId;
    public String vipMedalJumpUrl;
    public String voiceUrl;
    public byte[] wzryHonorInfo;

    @notColumn
    public String zplanAppearanceKey;

    @notColumn
    public String zplanAvatarBackgroundUrl;

    @notColumn
    public String zplanGander;

    @notColumn
    public String zplanNameplateId;
    public short shGender = -1;
    public int constellation = 0;
    public long lBirthday = 0;
    public int iProfession = -1;

    @notColumn
    public short switchMetaFarm = -1;

    @notColumn
    public short switchMusicBox = -1;

    @notColumn
    public short switchStickyNote = -1;

    @notColumn
    public short offlineStickyNote = -1;

    @notColumn
    public short switchQQCircle = -1;

    @notColumn
    public short switchLifeAchievement = -1;

    @notColumn
    public short switchWeiShi = -1;

    @notColumn
    public short switchPrivilege = -1;

    @notColumn
    public short switchMembershipAndRank = -1;

    @notColumn
    public SparseArray<Integer> profileDisplaySettingStates = new SparseArray<>(0);
    public boolean hasFakeData = false;

    @notColumn
    public int likeAreaId = 0;
    public int nameplateVipType = 0;
    public int grayNameplateFlag = 0;
    public int nameplateExtId = 0;
    public int gameCardId = 0;
    public int vipStarFlag = 0;
    public String vipIcons = "";

    @notColumn
    public int vipDataFlag = 0;
    public boolean isSuperRedDiamond = false;
    public boolean isRedDiamond = false;
    public int redLevel = 0;
    public boolean isSuperYellowDiamond = false;
    public boolean isYellowDiamond = false;
    public int yellowLevel = 0;
    public boolean isSuperGreenDiamond = false;
    public boolean isGreenDiamond = false;
    public int greenLevel = 0;
    public int templateRet = 0;
    public long lCurrentStyleId = -1;
    public long lCurrentBgId = -1;
    public String backgroundUrl = "";
    public long backgroundColor = 0;
    public int dynamicCardFlag = 0;
    public String strZipUrl = "";
    public String strActiveUrl = "";
    public String strDrawerCardUrl = "";
    public String strWzryHeroUrl = "";
    public boolean showPresent = false;

    @notColumn
    public String dressUpJumpUrl = "";

    @notColumn
    public List<UsingDressUpItemData> dressUpList = new ArrayList();

    @notColumn
    public String dressSuitJumpUrl = "";

    @notColumn
    public List<GxhSuitItemData> dressSuits = new ArrayList();

    @notColumn
    public String dressUpTitle = "";

    @notColumn
    public DressUpShowType dressUpShowType = DressUpShowType.NONE;

    @notColumn
    public List<GxhIPCollectionData> ipCards = new ArrayList();

    @notColumn
    public String ipCardsJumpUrl = "";

    @notColumn
    public String qqCardJumpUrl = "";

    @notColumn
    public int cardNameplateId = 0;

    @notColumn
    public List<QQCardItemData> qqCardList = new ArrayList();

    @notColumn
    public boolean qqCubIsOn = false;

    @notColumn
    public boolean qqCubIsBlack = true;

    @notColumn
    public List<SvipPrivilegeShow> svipPrivilegeShowItems = new ArrayList();

    @notColumn
    public List<SplendidItemData> splendidItems = new ArrayList();
    public short bHaveVotedCnt = 0;
    public short bAvailVoteCnt = -1;
    public boolean medalSwitchDisable = false;

    @notColumn
    public final List<PhotoInfo> qzonePhotoList = new CopyOnWriteArrayList();

    @notColumn
    public float qcircleCoverY = 0.0f;
    public float diyTextScale = 1.0f;
    public int bigVipBadgeItemId = 0;
    public boolean strangerInviteMeGroupOpen = true;

    @notColumn
    public List<SimilarityData> similarityData = new ArrayList();

    @notColumn
    public List<mutualmark$State> mutualStateList = new ArrayList();

    @notColumn
    public cmd0x703$UinPhotoListInfo mPhotoListInfo = null;

    @notColumn
    public int newSchoolStatusFlagForGuide = 1;
    public boolean troopHonorSwitch = true;
    public int lhLevel = -1;
    public boolean isForbidAccount = false;
    public int forbidCode = 0;

    @notColumn
    public short musicDataStatus = 0;

    @notColumn
    public short recentlyListenSwitch = -1;

    @notColumn
    public int liangNameplateId = 0;

    private void parseLabelList(ArrayList<ProfileGroupLabel> arrayList, JSONArray jSONArray) throws JSONException {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            ProfileGroupLabel profileGroupLabel = new ProfileGroupLabel();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equals("strWording")) {
                    profileGroupLabel.strWording = jSONObject.getString(str);
                } else if (str.equals("attr")) {
                    profileGroupLabel.attr = jSONObject.getLong(str);
                } else if (str.equals("type")) {
                    profileGroupLabel.type = jSONObject.getLong(str);
                } else if (str.equals("text_color")) {
                    String string = jSONObject.getString(str);
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject2 = new JSONObject(string);
                        ProfileColor profileColor = new ProfileColor();
                        Iterator keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String str2 = (String) keys2.next();
                            if (str2.equals(BdhLogUtil.LogTag.Tag_Req)) {
                                profileColor.red = jSONObject2.getLong(str2);
                            } else if (str2.equals("G")) {
                                profileColor.green = jSONObject2.getLong(str2);
                            } else if (str2.equals("B")) {
                                profileColor.blue = jSONObject2.getLong(str2);
                            }
                        }
                        profileGroupLabel.textColor = profileColor;
                    }
                } else if (str.equals("edging_color")) {
                    String string2 = jSONObject.getString(str);
                    if (!TextUtils.isEmpty(string2)) {
                        JSONObject jSONObject3 = new JSONObject(string2);
                        ProfileColor profileColor2 = new ProfileColor();
                        Iterator keys3 = jSONObject3.keys();
                        while (keys3.hasNext()) {
                            String str3 = (String) keys3.next();
                            if (str3.equals(BdhLogUtil.LogTag.Tag_Req)) {
                                profileColor2.red = jSONObject3.getLong(str3);
                            } else if (str3.equals("G")) {
                                profileColor2.green = jSONObject3.getLong(str3);
                            } else if (str3.equals("B")) {
                                profileColor2.blue = jSONObject3.getLong(str3);
                            }
                        }
                        profileGroupLabel.edgingColor = profileColor2;
                    }
                }
            }
            arrayList.add(profileGroupLabel);
        }
    }

    private void parseProfileSummaryHbItem(JSONObject jSONObject, Iterator<String> it, ProfileSummaryHobbiesItem profileSummaryHobbiesItem) throws JSONException {
        while (it.hasNext()) {
            String next = it.next();
            if (next.equals("strTitle")) {
                profileSummaryHobbiesItem.strTitle = jSONObject.getString(next);
            } else if (next.equals("strCoverUrl")) {
                profileSummaryHobbiesItem.strCoverUrl = jSONObject.getString(next);
            } else if (next.equals("strSubInfo")) {
                profileSummaryHobbiesItem.strSubInfo = jSONObject.getString(next);
            } else if (next.equals("strDesc")) {
                profileSummaryHobbiesItem.strDesc = jSONObject.getString(next);
            } else if (next.equals("serviceType")) {
                profileSummaryHobbiesItem.serviceType = jSONObject.getInt(next);
            } else if (next.equals("service")) {
                profileSummaryHobbiesItem.service = jSONObject.getInt(next);
            } else if (next.equals("strTitleIconUrl")) {
                profileSummaryHobbiesItem.strTitleIconUrl = jSONObject.getString(next);
            } else if (next.equals("strJmpUrl")) {
                profileSummaryHobbiesItem.strJmpUrl = jSONObject.getString(next);
            } else if (next.equals("uint64_group_code")) {
                profileSummaryHobbiesItem.groupCode = jSONObject.getLong(next);
            } else if (next.equals("labels") && !TextUtils.isEmpty(jSONObject.getString(next))) {
                ArrayList<ProfileGroupLabel> arrayList = new ArrayList<>();
                parseLabelList(arrayList, new JSONArray(jSONObject.getString("labels")));
                profileSummaryHobbiesItem.labels = arrayList;
            }
        }
    }

    public void addQZonePhotoList(ArrayList<String> arrayList, List<Boolean> list) {
        for (int i3 = 0; i3 < arrayList.size() && i3 < 3; i3++) {
            PhotoInfo photoInfo = new PhotoInfo();
            photoInfo.strPicUrl = arrayList.get(i3);
            HashMap hashMap = new HashMap();
            photoInfo.mapEx = hashMap;
            hashMap.put(BaseProfileQZoneComponent.KEY_IS_VIDEO, list.get(i3).booleanValue() ? "1" : "0");
            this.qzonePhotoList.add(i3, photoInfo);
        }
        if (this.qzonePhotoList.size() != 0) {
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            obtain.writeList(this.qzonePhotoList);
            this.vQzonePhotos = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            return;
        }
        if (this.hasFakeData) {
            return;
        }
        this.vQzonePhotos = null;
    }

    public boolean checkCoverUrl(byte[] bArr) {
        try {
            new cmd0x703$UinPhotoListInfo().mergeFrom(bArr);
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SummaryCard", 2, "checkCoverUrl " + e16.toString());
                return false;
            }
            return false;
        }
    }

    public ArrayList<Integer> getBgTypeArray() {
        if (this.bgType != null) {
            try {
                return (ArrayList) new ObjectInputStream(new ByteArrayInputStream(this.bgType)).readObject();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public List<ProfileSummaryHobbiesEntry> getBigOrderEntrys() {
        if (this.summaryEntrys == null) {
            this.summaryEntrys = new ArrayList();
            if (!TextUtils.isEmpty(this.hobbyEntry)) {
                try {
                    JSONArray jSONArray = new JSONArray(this.hobbyEntry);
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        if (jSONObject != null) {
                            ProfileSummaryHobbiesEntry profileSummaryHobbiesEntry = new ProfileSummaryHobbiesEntry();
                            Iterator keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String str = (String) keys.next();
                                if (str.equals("strName")) {
                                    profileSummaryHobbiesEntry.strName = jSONObject.getString(str);
                                } else if (str.equals("serviceType")) {
                                    profileSummaryHobbiesEntry.serviceType = jSONObject.getInt(str);
                                } else if (str.equals("strServiceUrl")) {
                                    profileSummaryHobbiesEntry.strServiceUrl = jSONObject.getString(str);
                                } else if (str.equals("strServiceType")) {
                                    profileSummaryHobbiesEntry.strServiceType = jSONObject.getString(str);
                                } else if (str.equals("sProfileSummaryHobbiesItem")) {
                                    String string = jSONObject.getString(str);
                                    if (!TextUtils.isEmpty(string)) {
                                        JSONArray jSONArray2 = new JSONArray(string);
                                        ArrayList<ProfileSummaryHobbiesItem> arrayList = new ArrayList<>();
                                        for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i16);
                                            Iterator keys2 = jSONObject2.keys();
                                            ProfileSummaryHobbiesItem profileSummaryHobbiesItem = new ProfileSummaryHobbiesItem();
                                            parseProfileSummaryHbItem(jSONObject2, keys2, profileSummaryHobbiesItem);
                                            arrayList.add(profileSummaryHobbiesItem);
                                        }
                                        profileSummaryHobbiesEntry.sProfileSummaryHobbiesItem = arrayList;
                                    }
                                }
                            }
                            this.summaryEntrys.add(profileSummaryHobbiesEntry);
                        }
                    }
                } catch (JSONException e16) {
                    QLog.e(TAG, 2, e16.toString());
                }
            }
        }
        return this.summaryEntrys;
    }

    public <T extends IProfileBusinessInfo> T getBusinessInfo(Class<? extends IProfileBusinessInfo> cls) {
        IProfileBusinessInfo iProfileBusinessInfo;
        Map<Class<? extends IProfileBusinessInfo>, IProfileBusinessInfo> map = this.businessInfoMap;
        if (map != null) {
            iProfileBusinessInfo = map.get(cls);
        } else {
            iProfileBusinessInfo = null;
        }
        if (iProfileBusinessInfo == null) {
            return null;
        }
        return (T) iProfileBusinessInfo;
    }

    public Object[] getCoverData(int i3) {
        int i16;
        cmd0x703$UinPhotoListInfo cmd0x703_uinphotolistinfo = this.mPhotoListInfo;
        if (cmd0x703_uinphotolistinfo == null && this.vCoverInfo != null) {
            cmd0x703_uinphotolistinfo = new cmd0x703$UinPhotoListInfo();
            try {
                cmd0x703_uinphotolistinfo.mergeFrom(this.vCoverInfo);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SummaryCard", 2, "getCoverData " + e16.toString());
                }
            }
            this.mPhotoListInfo = cmd0x703_uinphotolistinfo;
        }
        String str = null;
        int i17 = -1;
        if (cmd0x703_uinphotolistinfo != null && cmd0x703_uinphotolistinfo.rpt_msg_photo_info.get() != null) {
            List<cmd0x703$PhotoInfo> list = cmd0x703_uinphotolistinfo.rpt_msg_photo_info.get();
            List<Integer> list2 = cmd0x703_uinphotolistinfo.rpt_selected_id_list.get();
            if (list2 != null && list2.size() > 0) {
                Integer num = list2.get(0);
                if (num != null) {
                    i17 = num.intValue();
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("SummaryCard", 2, "getCoverData idList is empty!");
            }
            for (int i18 = 0; i18 < list.size(); i18++) {
                cmd0x703$PhotoInfo cmd0x703_photoinfo = list.get(i18);
                int i19 = cmd0x703_photoinfo.uint32_timestamp.get();
                if (cmd0x703_photoinfo.uint32_id.get() == i17 && (i3 < i19 || i19 == 0)) {
                    str = cmd0x703_photoinfo.str_url.get();
                    i16 = cmd0x703_photoinfo.uint32_timestamp.get();
                    break;
                }
            }
            i16 = 0;
            if (cmd0x703_uinphotolistinfo.str_default_photo.has() && !TextUtils.isEmpty(cmd0x703_uinphotolistinfo.str_default_photo.get())) {
                str = cmd0x703_uinphotolistinfo.str_default_photo.get();
            }
            if (TextUtils.isEmpty(str) && list.size() > 0) {
                cmd0x703$PhotoInfo cmd0x703_photoinfo2 = list.get(list.size() - 1);
                if (i3 < cmd0x703_photoinfo2.uint32_timestamp.get()) {
                    str = cmd0x703_photoinfo2.str_url.get();
                    i16 = cmd0x703_photoinfo2.uint32_timestamp.get();
                }
            }
        } else {
            i16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SummaryCard", 2, "getCoverData selectedId:" + i17 + " retTime:" + i16 + " retUrl:" + str);
        }
        return new Object[]{str, Integer.valueOf(i16)};
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ProfileLabelInfo> getLabelList() {
        ArrayList arrayList = null;
        if (this.labelInfoBytes != null) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.labelInfoBytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                ArrayList arrayList2 = (ArrayList) objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    objectInputStream.close();
                    arrayList = arrayList2;
                } catch (Exception e16) {
                    e = e16;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    if (arrayList != null) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        if (arrayList != null) {
            return new ArrayList();
        }
        return arrayList;
    }

    public ArrayList<TPraiseInfo> getLastPraiseInfoList() {
        ArrayList<TPraiseInfo> arrayList = this.lastPraiseInfos;
        if (arrayList != null) {
            return arrayList;
        }
        if (this.lastPraiseInfoList != null) {
            try {
                ArrayList<TPraiseInfo> arrayList2 = (ArrayList) new ObjectInputStream(new ByteArrayInputStream(this.lastPraiseInfoList)).readObject();
                this.lastPraiseInfos = arrayList2;
                return arrayList2;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<PrivilegeInfo> getPrivilegeCloseInfo() {
        ArrayList arrayList = null;
        if (this.vClosePriv != null) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.vClosePriv);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                ArrayList arrayList2 = (ArrayList) objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    objectInputStream.close();
                    arrayList = arrayList2;
                } catch (Exception e16) {
                    e = e16;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    if (arrayList != null) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        if (arrayList != null) {
            return new ArrayList();
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x003e -> B:15:0x004f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<PrivilegeInfo> getPrivilegeOpenInfo() {
        ObjectInputStream objectInputStream;
        ArrayList arrayList = null;
        arrayList = null;
        arrayList = null;
        arrayList = null;
        arrayList = null;
        ObjectInputStream objectInputStream2 = null;
        arrayList = null;
        try {
            try {
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (this.vOpenPriv != null) {
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.vOpenPriv));
                } catch (Exception e17) {
                    e = e17;
                    objectInputStream = null;
                } catch (OutOfMemoryError e18) {
                    e = e18;
                    objectInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (Exception e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    ArrayList arrayList2 = (ArrayList) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (Exception e26) {
                        e26.printStackTrace();
                    }
                    arrayList = arrayList2;
                } catch (Exception e27) {
                    e = e27;
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (arrayList == null) {
                    }
                } catch (OutOfMemoryError e28) {
                    e = e28;
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (arrayList == null) {
                    }
                }
            }
            if (arrayList == null) {
                return new ArrayList();
            }
            return arrayList;
        } catch (Throwable th6) {
            th = th6;
            objectInputStream2 = objectInputStream;
        }
    }

    public String getProfileCardDesc() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("-->templateRet=" + this.templateRet);
        sb5.append(",styleId=" + this.lCurrentStyleId);
        sb5.append(",backgroundId=" + this.lCurrentBgId);
        sb5.append(",backgroundUrl=" + this.backgroundUrl);
        sb5.append(",backgroundColor=" + this.backgroundColor);
        sb5.append(",ActiveUrl= " + this.strActiveUrl);
        return sb5.toString();
    }

    public List<PhotoInfo> getQZonePhotoList() {
        if (this.qzonePhotoList.size() == 0 && this.vQzonePhotos != null) {
            try {
                Parcel obtain = Parcel.obtain();
                byte[] bArr = this.vQzonePhotos;
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                this.qzonePhotoList.addAll(obtain.readArrayList(getClass().getClassLoader()));
                OaidMonitor.parcelRecycle(obtain);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getQZonePhotoList fail.", e16);
            }
        }
        return this.qzonePhotoList;
    }

    public int getVipLevel(EVIPSPEC evipspec) {
        if (evipspec == EVIPSPEC.E_SP_QQVIP) {
            return this.iQQVipLevel;
        }
        if (evipspec == EVIPSPEC.E_SP_SUPERQQ) {
            return this.iSuperQQLevel;
        }
        if (evipspec == EVIPSPEC.E_SP_SUPERVIP) {
            return this.iSuperVipLevel;
        }
        if (evipspec == EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD) {
            return this.iHollywoodVipLevel;
        }
        return -1;
    }

    public int getVipType(EVIPSPEC evipspec) {
        if (evipspec == EVIPSPEC.E_SP_QQVIP) {
            return this.iQQVipType;
        }
        if (evipspec == EVIPSPEC.E_SP_SUPERQQ) {
            return this.iSuperQQType;
        }
        if (evipspec == EVIPSPEC.E_SP_SUPERVIP) {
            return this.iSuperVipType;
        }
        if (evipspec == EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD) {
            return this.iHollywoodVipType;
        }
        return -1;
    }

    public ArrayList<summaryCardWzryInfo> getWzryHonorInfo() {
        if (this.wzryHonorInfo != null) {
            try {
                return (ArrayList) new ObjectInputStream(new ByteArrayInputStream(this.wzryHonorInfo)).readObject();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public boolean hasGotPhotoUrl() {
        if (this.vQzonePhotos == null) {
            return false;
        }
        return true;
    }

    public boolean isLuckyVip() {
        return isVipOpen(EVIPSPEC.E_SP_QQVIP);
    }

    public boolean isNewSchoolStatusWriteForGuide() {
        if (this.newSchoolStatusFlagForGuide != 0) {
            return true;
        }
        return false;
    }

    public boolean isNoCover() {
        cmd0x703$UinPhotoListInfo cmd0x703_uinphotolistinfo = this.mPhotoListInfo;
        if (cmd0x703_uinphotolistinfo == null) {
            getCoverData(0);
            cmd0x703_uinphotolistinfo = this.mPhotoListInfo;
        }
        if (cmd0x703_uinphotolistinfo == null || !cmd0x703_uinphotolistinfo.cover_flag.has() || cmd0x703_uinphotolistinfo.cover_flag.get() != 0) {
            return false;
        }
        return true;
    }

    public boolean isPhotoUseCache() {
        if ((this.ulShowControl & 32) == 0) {
            return false;
        }
        return true;
    }

    public boolean isShowFeeds() {
        if ((this.ulShowControl & 4) == 0) {
            return false;
        }
        return true;
    }

    public boolean isShowPhoto() {
        if ((this.ulShowControl & 16) == 0) {
            return false;
        }
        return true;
    }

    public boolean isShowXMan() {
        if ((this.ulShowControl & 64) == 0) {
            return false;
        }
        return true;
    }

    public boolean isShowZan() {
        if ((this.ulShowControl & 1) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0014, code lost:
    
        if (r3.bSuperQQOpen == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001d, code lost:
    
        if (r3.bSuperVipOpen == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0026, code lost:
    
        if (r3.bHollywoodVipOpen == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002f, code lost:
    
        if (r3.bBigClubVipOpen == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
    
        if (r3.bQQVipOpen == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0032, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isVipOpen(EVIPSPEC evipspec) {
        boolean z16 = true;
        if (evipspec != EVIPSPEC.E_SP_QQVIP) {
            if (evipspec != EVIPSPEC.E_SP_SUPERQQ) {
                if (evipspec != EVIPSPEC.E_SP_SUPERVIP) {
                    if (evipspec != EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD) {
                        if (evipspec != EVIPSPEC.E_SP_BIGCLUB) {
                            return false;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void putBusinessInfo(IProfileBusinessInfo iProfileBusinessInfo) {
        if (this.businessInfoMap == null) {
            this.businessInfoMap = new HashMap();
        }
        this.businessInfoMap.put(iProfileBusinessInfo.getClass(), iProfileBusinessInfo);
    }

    public void removeBusinessInfo(Class<? extends IProfileBusinessInfo> cls) {
        Map<Class<? extends IProfileBusinessInfo>, IProfileBusinessInfo> map = this.businessInfoMap;
        if (map != null) {
            map.remove(cls);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void saveBigOrderEntrys(List<ProfileSummaryHobbiesEntry> list) {
        List<ProfileSummaryHobbiesEntry> list2;
        String str;
        Iterator<ProfileSummaryHobbiesEntry> it;
        String str2;
        Iterator<ProfileSummaryHobbiesEntry> it5;
        Iterator<ProfileSummaryHobbiesItem> it6;
        Card card = this;
        String str3 = "serviceType";
        JSONStringer jSONStringer = new JSONStringer();
        card.hobbyEntry = "";
        try {
            jSONStringer.array();
            Iterator<ProfileSummaryHobbiesEntry> it7 = list.iterator();
            while (it7.hasNext()) {
                try {
                    ProfileSummaryHobbiesEntry next = it7.next();
                    jSONStringer.object().key("strName").value(next.strName).key("strServiceUrl").value(next.strServiceUrl).key("strServiceType").value(next.strServiceType).key(str3).value(next.serviceType);
                    if (next.sProfileSummaryHobbiesItem != null) {
                        JSONStringer array = new JSONStringer().array();
                        Iterator<ProfileSummaryHobbiesItem> it8 = next.sProfileSummaryHobbiesItem.iterator();
                        while (it8.hasNext()) {
                            ProfileSummaryHobbiesItem next2 = it8.next();
                            array.object().key("strTitle").value(next2.strTitle).key("strCoverUrl").value(next2.strCoverUrl).key("strJmpUrl").value(next2.strJmpUrl).key("strSubInfo").value(next2.strSubInfo).key("strDesc").value(next2.strDesc).key(str3).value(next2.serviceType).key("service").value(next2.service).key("strTitleIconUrl").value(next2.strTitleIconUrl).key("uint64_group_code").value(next2.groupCode);
                            if (next2.labels != null) {
                                JSONStringer array2 = new JSONStringer().array();
                                Iterator<ProfileGroupLabel> it9 = next2.labels.iterator();
                                while (it9.hasNext()) {
                                    ProfileGroupLabel next3 = it9.next();
                                    JSONStringer object = new JSONStringer().object();
                                    String str4 = str3;
                                    object.key(BdhLogUtil.LogTag.Tag_Req).value(next3.textColor.red).key("G").value(next3.textColor.green).key("B").value(next3.textColor.blue);
                                    object.endObject();
                                    JSONStringer object2 = new JSONStringer().object();
                                    object2.key(BdhLogUtil.LogTag.Tag_Req).value(next3.edgingColor.red).key("G").value(next3.edgingColor.green).key("B").value(next3.edgingColor.blue);
                                    object2.endObject();
                                    array2.object().key("strWording").value(next3.strWording).key("type").value(next3.type).key("attr").value(next3.attr).key("text_color").value(object).key("edging_color").value(object2).endObject();
                                    str3 = str4;
                                    it7 = it7;
                                    it8 = it8;
                                }
                                str2 = str3;
                                it5 = it7;
                                it6 = it8;
                                array2.endArray();
                                array.key("labels").value(array2);
                            } else {
                                str2 = str3;
                                it5 = it7;
                                it6 = it8;
                            }
                            array.endObject();
                            str3 = str2;
                            it7 = it5;
                            it8 = it6;
                        }
                        str = str3;
                        it = it7;
                        array.endArray();
                        jSONStringer.key("sProfileSummaryHobbiesItem").value(array);
                    } else {
                        str = str3;
                        it = it7;
                    }
                    jSONStringer.endObject();
                    str3 = str;
                    it7 = it;
                } catch (JSONException e16) {
                    e = e16;
                    card = this;
                    card.hobbyEntry = "";
                    e.printStackTrace();
                    list2 = card.summaryEntrys;
                    if (list2 == null) {
                    }
                }
            }
            jSONStringer.endArray();
            card = this;
            card.hobbyEntry = jSONStringer.toString();
        } catch (JSONException e17) {
            e = e17;
        }
        list2 = card.summaryEntrys;
        if (list2 == null) {
            list2.clear();
            if (list != null && list.size() > 0) {
                card.summaryEntrys.addAll(list);
            }
        }
    }

    public void savePrivilegeClosedInfo(List<PrivilegeInfo> list) {
        if (list == null) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(list);
            this.vClosePriv = byteArrayOutputStream.toByteArray();
            objectOutputStream.flush();
            byteArrayOutputStream.close();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (OutOfMemoryError unused) {
        }
    }

    public void savePrivilegeOpenedInfo(List<PrivilegeInfo> list) {
        if (list == null) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(list);
            this.vOpenPriv = byteArrayOutputStream.toByteArray();
            objectOutputStream.flush();
            byteArrayOutputStream.close();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        for (PrivilegeInfo privilegeInfo : list) {
            if (privilegeInfo.iType == 113) {
                this.bBigClubVipOpen = (byte) 1;
                this.iBigClubVipType = privilegeInfo.iFeeType;
                this.iBigClubVipLevel = privilegeInfo.iLevel;
                return;
            }
        }
    }

    public byte[] setBgType(Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.bgType = byteArray;
            return byteArray;
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void setFeedsShowFlag(boolean z16) {
        if (z16) {
            this.ulShowControl |= 4;
        } else {
            this.ulShowControl &= -5;
        }
    }

    public void setLabelList(Map<Long, SLabelInfo> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && map.size() > 0) {
            for (Map.Entry<Long, SLabelInfo> entry : map.entrySet()) {
                Long key = entry.getKey();
                SLabelInfo value = entry.getValue();
                arrayList.add(new ProfileLabelInfo(key, Long.valueOf(value.likeit), value.name));
            }
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(arrayList);
            this.labelInfoBytes = byteArrayOutputStream.toByteArray();
            objectOutputStream.flush();
            byteArrayOutputStream.close();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public void setLastPraiseInfoList(ArrayList<TPraiseInfo> arrayList) {
        if (arrayList != null) {
            try {
                this.lastPraiseInfos = arrayList;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(arrayList);
                objectOutputStream.flush();
                this.lastPraiseInfoList = byteArrayOutputStream.toByteArray();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void setPhotoShowFlag(boolean z16) {
        if (z16) {
            this.ulShowControl |= 16;
        } else {
            this.ulShowControl &= -17;
        }
    }

    public void setPhotoUseCacheFlag(boolean z16) {
        if (z16) {
            this.ulShowControl |= 32;
        } else {
            this.ulShowControl &= -33;
        }
    }

    public void setVipInfo(VipBaseInfo vipBaseInfo) {
        Map<Integer, VipOpenInfo> map;
        if (vipBaseInfo != null && (map = vipBaseInfo.mOpenInfo) != null) {
            VipOpenInfo vipOpenInfo = map.get(1);
            if (vipOpenInfo != null) {
                this.bQQVipOpen = vipOpenInfo.bOpen ? (byte) 1 : (byte) 0;
                this.iQQVipType = vipOpenInfo.iVipType;
                this.iQQVipLevel = vipOpenInfo.iVipLevel;
            }
            VipOpenInfo vipOpenInfo2 = vipBaseInfo.mOpenInfo.get(2);
            if (vipOpenInfo2 != null) {
                this.bSuperQQOpen = vipOpenInfo2.bOpen ? (byte) 1 : (byte) 0;
                this.iSuperQQType = vipOpenInfo2.iVipType;
                this.iSuperQQLevel = vipOpenInfo2.iVipLevel;
            }
            VipOpenInfo vipOpenInfo3 = vipBaseInfo.mOpenInfo.get(3);
            if (vipOpenInfo3 != null) {
                this.bSuperVipOpen = vipOpenInfo3.bOpen ? (byte) 1 : (byte) 0;
                this.iSuperVipType = vipOpenInfo3.iVipType;
                this.iSuperVipLevel = vipOpenInfo3.iVipLevel;
                long j3 = vipOpenInfo3.lNameplateId;
                this.lSuperVipTemplateId = j3;
                this.lBigClubTemplateId = j3;
            }
            VipOpenInfo vipOpenInfo4 = vipBaseInfo.mOpenInfo.get(7);
            if (vipOpenInfo4 != null) {
                this.bBigClubVipOpen = vipOpenInfo4.bOpen ? (byte) 1 : (byte) 0;
                this.iBigClubVipType = vipOpenInfo4.iVipType;
                this.iBigClubVipLevel = vipOpenInfo4.iVipLevel;
                long j16 = vipOpenInfo4.lNameplateId;
                this.lSuperVipTemplateId = j16;
                this.lBigClubTemplateId = j16;
            }
            if (QLog.isColorLevel()) {
                QLog.d(IndividuationUrlHelper.UrlId.CARD_HOME, 2, "setVipInfo bSuperVipOpen=" + ((int) this.bSuperVipOpen) + ",bQQVipOpen=" + ((int) this.bQQVipOpen) + ",VipLevel=" + this.iQQVipLevel + "card = " + this + ",uin = " + this.uin);
            }
            VipOpenInfo vipOpenInfo5 = vipBaseInfo.mOpenInfo.get(4);
            if (vipOpenInfo5 != null) {
                this.bHollywoodVipOpen = vipOpenInfo5.bOpen ? (byte) 1 : (byte) 0;
                this.iHollywoodVipType = vipOpenInfo5.iVipType;
                this.iHollywoodVipLevel = vipOpenInfo5.iVipLevel;
            }
        }
    }

    public byte[] setWzryHonorInfo(Object obj) {
        if (obj == null) {
            this.wzryHonorInfo = new byte[0];
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.wzryHonorInfo = byteArray;
            return byteArray;
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void setXManFlag(boolean z16) {
        if (z16) {
            this.ulShowControl |= 64;
        } else {
            this.ulShowControl &= -65;
        }
    }

    public void updateCoverData(byte[] bArr) {
        Object valueOf;
        this.vCoverInfo = bArr;
        this.mPhotoListInfo = null;
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[1];
            if (bArr == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(bArr.length);
            }
            objArr[0] = valueOf;
            QLog.d("SummaryCard", 2, String.format("updateCoverData len: %s", objArr));
        }
    }

    public void addQZonePhotoList(AlbumInfo albumInfo) {
        for (int i3 = 0; i3 < albumInfo.vPhotos.size(); i3++) {
            this.qzonePhotoList.add(albumInfo.vPhotos.get(i3));
        }
        if (this.qzonePhotoList.size() != 0) {
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            obtain.writeList(this.qzonePhotoList);
            this.vQzonePhotos = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            return;
        }
        if (this.hasFakeData) {
            return;
        }
        this.vQzonePhotos = null;
    }
}
