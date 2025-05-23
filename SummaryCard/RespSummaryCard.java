package SummaryCard;

import QQService.PrivilegeBaseInfo;
import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespSummaryCard extends JceStruct {
    static Map<String, String> cache_mapQzoneEx;
    static AddFrdSrcInfo cache_stAddFrdSrcInfo;
    static QQApolloInfo cache_stApollo;
    static BindPhoneInfo cache_stBindPhoneInfo;
    static TCampusCircleInfo cache_stCampusCircleInfo;
    static TCoverInfo cache_stCoverInfo;
    static DateCard cache_stDateCard;
    static VipBaseInfo cache_stDiamonds;
    static TEIMInfo cache_stEimInfo;
    static GiftInfo cache_stGiftInfo;
    static HeartInfo cache_stHeartInfo;
    static InterestTagInfo cache_stInterestTag;
    static TMedalWallInfo cache_stMedalWallInfo;
    static TNearbyGodInfo cache_stNearbyGodInfo;
    static TNowBroadcastInfo cache_stNowBroadcastInfo;
    static OlympicInfo cache_stOlympicInfo;
    static PanSocialInfo cache_stPanSocialInfo;
    static PrivilegeBaseInfo cache_stPrivInfo;
    static QCallInfo cache_stQCallInfo;
    static TQimInfo cache_stQimInfo;
    static QiqiVideoInfo cache_stQiqiVideoInfo;
    static TTimInfo cache_stTimInfo;
    static UserFeed cache_stUserFeed;
    static TVideoHeadInfo cache_stVideoHeadInfo;
    static QQVideoInfo cache_stVideoInfo;
    static VipBaseInfo cache_stVipInfo;
    static VoiceInfo cache_stVoiceInfo;
    static WeishiInfo cache_stWeishiInfo;
    static ArrayList<String> cache_vAddQuestion;
    static byte[] cache_vCommLabel;
    static byte[] cache_vExtendCard;
    static byte[] cache_vHotChatInfo;
    static byte[] cache_vLongNickTopicInfo;
    static byte[] cache_vNearbyTaskInfo;
    static byte[] cache_vNowInfo;
    static ArrayList<TPraiseInfo> cache_vPraiseList;
    static byte[] cache_vQzoneCoverInfo;
    static byte[] cache_vResp0x5ebInfo;
    static byte[] cache_vRespCustomLabelInfo;
    static byte[] cache_vRespKandianInfo;
    static byte[] cache_vRespLastGameInfo;
    static byte[] cache_vRespQQStoryInfo;
    static byte[] cache_vRespStarInfo;
    static byte[] cache_vRespTemplateInfo;
    static byte[] cache_vRichSign;
    static byte[] cache_vSeed;
    static byte[] cache_vTempChatSig;
    static byte[] cache_vVisitingCardInfo;
    static ArrayList<byte[]> cache_vvRespServices;
    static ArrayList<byte[]> cache_vvRespServicesBigOrder;
    public byte bAge;
    public short bAvailVoteCnt;
    public short bHaveVotedCnt;
    public byte bSex;
    public byte bValid4Vote;
    public int eAddOption;
    public int i0x6d4Success;
    public int iBirthday;
    public int iContactNotBindQQ;
    public int iFace;
    public int iLastestVoteCount;
    public int iLevel;
    public int iPhotoCount;
    public int iVoteCount;
    public long lCacheControl;
    public long lUIN;
    public long lUserFlag;
    public Map<String, String> mapQzoneEx;
    public AlbumInfo oLatestPhotos;
    public AddFrdSrcInfo stAddFrdSrcInfo;
    public QQApolloInfo stApollo;
    public BindPhoneInfo stBindPhoneInfo;
    public TCampusCircleInfo stCampusCircleInfo;
    public TCoverInfo stCoverInfo;
    public DateCard stDateCard;
    public VipBaseInfo stDiamonds;
    public TEIMInfo stEimInfo;
    public GiftInfo stGiftInfo;
    public HeartInfo stHeartInfo;
    public InterestTagInfo stInterestTag;
    public TMedalWallInfo stMedalWallInfo;
    public TNearbyGodInfo stNearbyGodInfo;
    public TNowBroadcastInfo stNowBroadcastInfo;
    public OlympicInfo stOlympicInfo;
    public PanSocialInfo stPanSocialInfo;
    public PrivilegeBaseInfo stPrivInfo;
    public QCallInfo stQCallInfo;
    public TQimInfo stQimInfo;
    public QiqiVideoInfo stQiqiVideoInfo;
    public TTimInfo stTimInfo;
    public UserFeed stUserFeed;
    public TVideoHeadInfo stVideoHeadInfo;
    public QQVideoInfo stVideoInfo;
    public VipBaseInfo stVipInfo;
    public VoiceInfo stVoiceInfo;
    public WeishiInfo stWeishiInfo;
    public String strAutoRemark;
    public String strCity;
    public String strContactName;
    public String strCountry;
    public String strDiscussName;
    public String strEIMBindPhoneNum;
    public String strEIMId;
    public String strEmail;
    public String strGroupName;
    public String strGroupNick;
    public String strLoginDesc;
    public String strMobile;
    public String strNick;
    public String strPersonal;
    public String strProvince;
    public String strQzoneFeedsDesc;
    public String strQzoneHeader;
    public String strRemark;
    public String strRespMusicInfo;
    public String strShowName;
    public String strSign;
    public String strSpaceName;
    public String strStatus;
    public String strVoteLimitedNotice;
    public long uAccelerateMultiple;
    public long uCareer;
    public long uCurMulType;
    public long uFriendGroupId;
    public long uLoginDays;
    public long uQQMasterLoginDays;
    public long uRichCardNameVer;
    public long uSignModifyTime;
    public long uTemplateId;
    public long ulFaceAddonId;
    public long ulShowControl;
    public ArrayList<String> vAddQuestion;
    public byte[] vCommLabel;
    public byte[] vExtendCard;
    public byte[] vHotChatInfo;
    public byte[] vLongNickTopicInfo;
    public byte[] vNearbyTaskInfo;
    public byte[] vNowInfo;
    public ArrayList<TPraiseInfo> vPraiseList;
    public byte[] vQzoneCoverInfo;
    public byte[] vResp0x5ebInfo;
    public byte[] vRespCustomLabelInfo;
    public byte[] vRespKandianInfo;
    public byte[] vRespLastGameInfo;
    public byte[] vRespQQStoryInfo;
    public byte[] vRespStarInfo;
    public byte[] vRespTemplateInfo;
    public byte[] vRichSign;
    public byte[] vSeed;
    public byte[] vTempChatSig;
    public byte[] vVisitingCardInfo;
    public ArrayList<byte[]> vvRespServices;
    public ArrayList<byte[]> vvRespServicesBigOrder;
    static AlbumInfo cache_oLatestPhotos = new AlbumInfo();
    static int cache_eAddOption = 0;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vAddQuestion = arrayList;
        arrayList.add("");
        cache_vSeed = r3;
        byte[] bArr = {0};
        cache_stVipInfo = new VipBaseInfo();
        cache_stVoiceInfo = new VoiceInfo();
        cache_vRichSign = r3;
        byte[] bArr2 = {0};
        cache_vRespLastGameInfo = r3;
        byte[] bArr3 = {0};
        cache_vRespTemplateInfo = r3;
        byte[] bArr4 = {0};
        cache_vRespStarInfo = r3;
        byte[] bArr5 = {0};
        cache_stDiamonds = new VipBaseInfo();
        ArrayList<byte[]> arrayList2 = new ArrayList<>();
        cache_vvRespServices = arrayList2;
        arrayList2.add(new byte[]{0});
        cache_stDateCard = new DateCard();
        cache_stQCallInfo = new QCallInfo();
        cache_stGiftInfo = new GiftInfo();
        cache_stPanSocialInfo = new PanSocialInfo();
        cache_stVideoInfo = new QQVideoInfo();
        cache_vTempChatSig = r3;
        byte[] bArr6 = {0};
        cache_stInterestTag = new InterestTagInfo();
        cache_stUserFeed = new UserFeed();
        cache_stQiqiVideoInfo = new QiqiVideoInfo();
        cache_stPrivInfo = new PrivilegeBaseInfo();
        cache_stApollo = new QQApolloInfo();
        cache_stAddFrdSrcInfo = new AddFrdSrcInfo();
        cache_stBindPhoneInfo = new BindPhoneInfo();
        cache_vVisitingCardInfo = r3;
        byte[] bArr7 = {0};
        cache_vHotChatInfo = r3;
        byte[] bArr8 = {0};
        cache_stOlympicInfo = new OlympicInfo();
        cache_stCoverInfo = new TCoverInfo();
        cache_stNowBroadcastInfo = new TNowBroadcastInfo();
        cache_stEimInfo = new TEIMInfo();
        cache_stVideoHeadInfo = new TVideoHeadInfo();
        cache_stMedalWallInfo = new TMedalWallInfo();
        ArrayList<byte[]> arrayList3 = new ArrayList<>();
        cache_vvRespServicesBigOrder = arrayList3;
        arrayList3.add(new byte[]{0});
        cache_vResp0x5ebInfo = r3;
        byte[] bArr9 = {0};
        cache_stNearbyGodInfo = new TNearbyGodInfo();
        cache_vRespQQStoryInfo = r3;
        byte[] bArr10 = {0};
        cache_vRespCustomLabelInfo = r3;
        byte[] bArr11 = {0};
        cache_vPraiseList = new ArrayList<>();
        cache_vPraiseList.add(new TPraiseInfo());
        cache_stCampusCircleInfo = new TCampusCircleInfo();
        cache_stTimInfo = new TTimInfo();
        cache_stQimInfo = new TQimInfo();
        cache_stHeartInfo = new HeartInfo();
        cache_vQzoneCoverInfo = r3;
        byte[] bArr12 = {0};
        cache_vNearbyTaskInfo = r3;
        byte[] bArr13 = {0};
        cache_vNowInfo = r3;
        byte[] bArr14 = {0};
        cache_vCommLabel = r3;
        byte[] bArr15 = {0};
        cache_vExtendCard = r3;
        byte[] bArr16 = {0};
        HashMap hashMap = new HashMap();
        cache_mapQzoneEx = hashMap;
        hashMap.put("", "");
        cache_vRespKandianInfo = r2;
        byte[] bArr17 = {0};
        cache_stWeishiInfo = new WeishiInfo();
        cache_vLongNickTopicInfo = r1;
        byte[] bArr18 = {0};
    }

    public RespSummaryCard() {
        this.iFace = 0;
        this.bSex = (byte) 0;
        this.bAge = (byte) 0;
        this.strNick = "";
        this.strRemark = "";
        this.iLevel = 0;
        this.strProvince = "";
        this.strCity = "";
        this.strSign = "";
        this.strGroupName = "";
        this.strGroupNick = "";
        this.strMobile = "";
        this.strContactName = "";
        this.ulShowControl = 0L;
        this.strQzoneFeedsDesc = "";
        this.oLatestPhotos = null;
        this.iVoteCount = 0;
        this.iLastestVoteCount = 0;
        this.bValid4Vote = (byte) 0;
        this.strCountry = "";
        this.strStatus = "";
        this.strAutoRemark = "";
        this.lCacheControl = 0L;
        this.lUIN = 0L;
        this.iPhotoCount = 0;
        this.eAddOption = 101;
        this.vAddQuestion = null;
        this.vSeed = null;
        this.strDiscussName = "";
        this.stVipInfo = null;
        this.strShowName = "";
        this.stVoiceInfo = null;
        this.vRichSign = null;
        this.uSignModifyTime = 0L;
        this.vRespLastGameInfo = null;
        this.lUserFlag = 0L;
        this.uLoginDays = 0L;
        this.strLoginDesc = "";
        this.uTemplateId = 0L;
        this.uQQMasterLoginDays = 20L;
        this.ulFaceAddonId = 0L;
        this.vRespTemplateInfo = null;
        this.strRespMusicInfo = "";
        this.vRespStarInfo = null;
        this.stDiamonds = null;
        this.uAccelerateMultiple = 0L;
        this.vvRespServices = null;
        this.strSpaceName = "";
        this.stDateCard = null;
        this.iBirthday = 0;
        this.stQCallInfo = null;
        this.stGiftInfo = null;
        this.stPanSocialInfo = null;
        this.stVideoInfo = null;
        this.vTempChatSig = null;
        this.stInterestTag = null;
        this.stUserFeed = null;
        this.stQiqiVideoInfo = null;
        this.stPrivInfo = null;
        this.stApollo = null;
        this.stAddFrdSrcInfo = null;
        this.stBindPhoneInfo = null;
        this.vVisitingCardInfo = null;
        this.strVoteLimitedNotice = "";
        this.bHaveVotedCnt = (short) 0;
        this.bAvailVoteCnt = (short) 0;
        this.strEIMBindPhoneNum = "";
        this.strEIMId = "";
        this.strEmail = "";
        this.uCareer = 0L;
        this.strPersonal = "";
        this.vHotChatInfo = null;
        this.stOlympicInfo = null;
        this.stCoverInfo = null;
        this.stNowBroadcastInfo = null;
        this.stEimInfo = null;
        this.stVideoHeadInfo = null;
        this.iContactNotBindQQ = 0;
        this.stMedalWallInfo = null;
        this.vvRespServicesBigOrder = null;
        this.vResp0x5ebInfo = null;
        this.stNearbyGodInfo = null;
        this.vRespQQStoryInfo = null;
        this.vRespCustomLabelInfo = null;
        this.vPraiseList = null;
        this.stCampusCircleInfo = null;
        this.stTimInfo = null;
        this.stQimInfo = null;
        this.stHeartInfo = null;
        this.vQzoneCoverInfo = null;
        this.vNearbyTaskInfo = null;
        this.vNowInfo = null;
        this.uFriendGroupId = 0L;
        this.vCommLabel = null;
        this.vExtendCard = null;
        this.strQzoneHeader = "";
        this.mapQzoneEx = null;
        this.vRespKandianInfo = null;
        this.stWeishiInfo = null;
        this.uRichCardNameVer = 0L;
        this.uCurMulType = 0L;
        this.vLongNickTopicInfo = null;
        this.i0x6d4Success = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iFace = jceInputStream.read(this.iFace, 0, false);
        this.bSex = jceInputStream.read(this.bSex, 1, false);
        this.bAge = jceInputStream.read(this.bAge, 2, false);
        this.strNick = jceInputStream.readString(3, false);
        this.strRemark = jceInputStream.readString(4, false);
        this.iLevel = jceInputStream.read(this.iLevel, 5, false);
        this.strProvince = jceInputStream.readString(6, false);
        this.strCity = jceInputStream.readString(7, false);
        this.strSign = jceInputStream.readString(8, false);
        this.strGroupName = jceInputStream.readString(9, false);
        this.strGroupNick = jceInputStream.readString(10, false);
        this.strMobile = jceInputStream.readString(11, false);
        this.strContactName = jceInputStream.readString(12, false);
        this.ulShowControl = jceInputStream.read(this.ulShowControl, 13, false);
        this.strQzoneFeedsDesc = jceInputStream.readString(14, false);
        this.oLatestPhotos = (AlbumInfo) jceInputStream.read((JceStruct) cache_oLatestPhotos, 15, false);
        this.iVoteCount = jceInputStream.read(this.iVoteCount, 16, false);
        this.iLastestVoteCount = jceInputStream.read(this.iLastestVoteCount, 17, false);
        this.bValid4Vote = jceInputStream.read(this.bValid4Vote, 18, false);
        this.strCountry = jceInputStream.readString(19, false);
        this.strStatus = jceInputStream.readString(20, false);
        this.strAutoRemark = jceInputStream.readString(21, false);
        this.lCacheControl = jceInputStream.read(this.lCacheControl, 22, false);
        this.lUIN = jceInputStream.read(this.lUIN, 23, false);
        this.iPhotoCount = jceInputStream.read(this.iPhotoCount, 24, false);
        this.eAddOption = jceInputStream.read(this.eAddOption, 25, false);
        this.vAddQuestion = (ArrayList) jceInputStream.read((JceInputStream) cache_vAddQuestion, 26, false);
        this.vSeed = jceInputStream.read(cache_vSeed, 27, false);
        this.strDiscussName = jceInputStream.readString(28, false);
        this.stVipInfo = (VipBaseInfo) jceInputStream.read((JceStruct) cache_stVipInfo, 29, false);
        this.strShowName = jceInputStream.readString(30, false);
        this.stVoiceInfo = (VoiceInfo) jceInputStream.read((JceStruct) cache_stVoiceInfo, 31, false);
        this.vRichSign = jceInputStream.read(cache_vRichSign, 32, false);
        this.uSignModifyTime = jceInputStream.read(this.uSignModifyTime, 33, false);
        this.vRespLastGameInfo = jceInputStream.read(cache_vRespLastGameInfo, 34, false);
        this.lUserFlag = jceInputStream.read(this.lUserFlag, 35, false);
        this.uLoginDays = jceInputStream.read(this.uLoginDays, 36, false);
        this.strLoginDesc = jceInputStream.readString(37, false);
        this.uTemplateId = jceInputStream.read(this.uTemplateId, 38, false);
        this.uQQMasterLoginDays = jceInputStream.read(this.uQQMasterLoginDays, 39, false);
        this.ulFaceAddonId = jceInputStream.read(this.ulFaceAddonId, 40, false);
        this.vRespTemplateInfo = jceInputStream.read(cache_vRespTemplateInfo, 41, false);
        this.strRespMusicInfo = jceInputStream.readString(42, false);
        this.vRespStarInfo = jceInputStream.read(cache_vRespStarInfo, 43, false);
        this.stDiamonds = (VipBaseInfo) jceInputStream.read((JceStruct) cache_stDiamonds, 44, false);
        this.uAccelerateMultiple = jceInputStream.read(this.uAccelerateMultiple, 45, false);
        this.vvRespServices = (ArrayList) jceInputStream.read((JceInputStream) cache_vvRespServices, 46, false);
        this.strSpaceName = jceInputStream.readString(47, false);
        this.stDateCard = (DateCard) jceInputStream.read((JceStruct) cache_stDateCard, 48, false);
        this.iBirthday = jceInputStream.read(this.iBirthday, 49, false);
        this.stQCallInfo = (QCallInfo) jceInputStream.read((JceStruct) cache_stQCallInfo, 50, false);
        this.stGiftInfo = (GiftInfo) jceInputStream.read((JceStruct) cache_stGiftInfo, 51, false);
        this.stPanSocialInfo = (PanSocialInfo) jceInputStream.read((JceStruct) cache_stPanSocialInfo, 52, false);
        this.stVideoInfo = (QQVideoInfo) jceInputStream.read((JceStruct) cache_stVideoInfo, 53, false);
        this.vTempChatSig = jceInputStream.read(cache_vTempChatSig, 54, false);
        this.stInterestTag = (InterestTagInfo) jceInputStream.read((JceStruct) cache_stInterestTag, 55, false);
        this.stUserFeed = (UserFeed) jceInputStream.read((JceStruct) cache_stUserFeed, 56, false);
        this.stQiqiVideoInfo = (QiqiVideoInfo) jceInputStream.read((JceStruct) cache_stQiqiVideoInfo, 57, false);
        this.stPrivInfo = (PrivilegeBaseInfo) jceInputStream.read((JceStruct) cache_stPrivInfo, 58, false);
        this.stApollo = (QQApolloInfo) jceInputStream.read((JceStruct) cache_stApollo, 59, false);
        this.stAddFrdSrcInfo = (AddFrdSrcInfo) jceInputStream.read((JceStruct) cache_stAddFrdSrcInfo, 60, false);
        this.stBindPhoneInfo = (BindPhoneInfo) jceInputStream.read((JceStruct) cache_stBindPhoneInfo, 61, false);
        this.vVisitingCardInfo = jceInputStream.read(cache_vVisitingCardInfo, 62, false);
        this.strVoteLimitedNotice = jceInputStream.readString(63, false);
        this.bHaveVotedCnt = jceInputStream.read(this.bHaveVotedCnt, 64, false);
        this.bAvailVoteCnt = jceInputStream.read(this.bAvailVoteCnt, 65, false);
        this.strEIMBindPhoneNum = jceInputStream.readString(66, false);
        this.strEIMId = jceInputStream.readString(67, false);
        this.strEmail = jceInputStream.readString(68, false);
        this.uCareer = jceInputStream.read(this.uCareer, 69, false);
        this.strPersonal = jceInputStream.readString(70, false);
        this.vHotChatInfo = jceInputStream.read(cache_vHotChatInfo, 71, false);
        this.stOlympicInfo = (OlympicInfo) jceInputStream.read((JceStruct) cache_stOlympicInfo, 72, false);
        this.stCoverInfo = (TCoverInfo) jceInputStream.read((JceStruct) cache_stCoverInfo, 73, false);
        this.stNowBroadcastInfo = (TNowBroadcastInfo) jceInputStream.read((JceStruct) cache_stNowBroadcastInfo, 74, false);
        this.stEimInfo = (TEIMInfo) jceInputStream.read((JceStruct) cache_stEimInfo, 75, false);
        this.stVideoHeadInfo = (TVideoHeadInfo) jceInputStream.read((JceStruct) cache_stVideoHeadInfo, 78, false);
        this.iContactNotBindQQ = jceInputStream.read(this.iContactNotBindQQ, 79, false);
        this.stMedalWallInfo = (TMedalWallInfo) jceInputStream.read((JceStruct) cache_stMedalWallInfo, 80, false);
        this.vvRespServicesBigOrder = (ArrayList) jceInputStream.read((JceInputStream) cache_vvRespServicesBigOrder, 81, false);
        this.vResp0x5ebInfo = jceInputStream.read(cache_vResp0x5ebInfo, 82, false);
        this.stNearbyGodInfo = (TNearbyGodInfo) jceInputStream.read((JceStruct) cache_stNearbyGodInfo, 83, false);
        this.vRespQQStoryInfo = jceInputStream.read(cache_vRespQQStoryInfo, 84, false);
        this.vRespCustomLabelInfo = jceInputStream.read(cache_vRespCustomLabelInfo, 85, false);
        this.vPraiseList = (ArrayList) jceInputStream.read((JceInputStream) cache_vPraiseList, 86, false);
        this.stCampusCircleInfo = (TCampusCircleInfo) jceInputStream.read((JceStruct) cache_stCampusCircleInfo, 87, false);
        this.stTimInfo = (TTimInfo) jceInputStream.read((JceStruct) cache_stTimInfo, 88, false);
        this.stQimInfo = (TQimInfo) jceInputStream.read((JceStruct) cache_stQimInfo, 89, false);
        this.stHeartInfo = (HeartInfo) jceInputStream.read((JceStruct) cache_stHeartInfo, 90, false);
        this.vQzoneCoverInfo = jceInputStream.read(cache_vQzoneCoverInfo, 91, false);
        this.vNearbyTaskInfo = jceInputStream.read(cache_vNearbyTaskInfo, 92, false);
        this.vNowInfo = jceInputStream.read(cache_vNowInfo, 93, false);
        this.uFriendGroupId = jceInputStream.read(this.uFriendGroupId, 94, false);
        this.vCommLabel = jceInputStream.read(cache_vCommLabel, 95, false);
        this.vExtendCard = jceInputStream.read(cache_vExtendCard, 96, false);
        this.strQzoneHeader = jceInputStream.readString(97, false);
        this.mapQzoneEx = (Map) jceInputStream.read((JceInputStream) cache_mapQzoneEx, 98, false);
        this.vRespKandianInfo = jceInputStream.read(cache_vRespKandianInfo, 99, false);
        this.stWeishiInfo = (WeishiInfo) jceInputStream.read((JceStruct) cache_stWeishiInfo, 100, false);
        this.uRichCardNameVer = jceInputStream.read(this.uRichCardNameVer, 101, false);
        this.uCurMulType = jceInputStream.read(this.uCurMulType, 102, false);
        this.vLongNickTopicInfo = jceInputStream.read(cache_vLongNickTopicInfo, 103, false);
        this.i0x6d4Success = jceInputStream.read(this.i0x6d4Success, 104, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iFace, 0);
        jceOutputStream.write(this.bSex, 1);
        jceOutputStream.write(this.bAge, 2);
        String str = this.strNick;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.strRemark;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.iLevel, 5);
        String str3 = this.strProvince;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        String str4 = this.strCity;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        String str5 = this.strSign;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        String str6 = this.strGroupName;
        if (str6 != null) {
            jceOutputStream.write(str6, 9);
        }
        String str7 = this.strGroupNick;
        if (str7 != null) {
            jceOutputStream.write(str7, 10);
        }
        String str8 = this.strMobile;
        if (str8 != null) {
            jceOutputStream.write(str8, 11);
        }
        String str9 = this.strContactName;
        if (str9 != null) {
            jceOutputStream.write(str9, 12);
        }
        jceOutputStream.write(this.ulShowControl, 13);
        String str10 = this.strQzoneFeedsDesc;
        if (str10 != null) {
            jceOutputStream.write(str10, 14);
        }
        AlbumInfo albumInfo = this.oLatestPhotos;
        if (albumInfo != null) {
            jceOutputStream.write((JceStruct) albumInfo, 15);
        }
        jceOutputStream.write(this.iVoteCount, 16);
        jceOutputStream.write(this.iLastestVoteCount, 17);
        jceOutputStream.write(this.bValid4Vote, 18);
        String str11 = this.strCountry;
        if (str11 != null) {
            jceOutputStream.write(str11, 19);
        }
        String str12 = this.strStatus;
        if (str12 != null) {
            jceOutputStream.write(str12, 20);
        }
        String str13 = this.strAutoRemark;
        if (str13 != null) {
            jceOutputStream.write(str13, 21);
        }
        jceOutputStream.write(this.lCacheControl, 22);
        jceOutputStream.write(this.lUIN, 23);
        jceOutputStream.write(this.iPhotoCount, 24);
        jceOutputStream.write(this.eAddOption, 25);
        ArrayList<String> arrayList = this.vAddQuestion;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 26);
        }
        byte[] bArr = this.vSeed;
        if (bArr != null) {
            jceOutputStream.write(bArr, 27);
        }
        String str14 = this.strDiscussName;
        if (str14 != null) {
            jceOutputStream.write(str14, 28);
        }
        VipBaseInfo vipBaseInfo = this.stVipInfo;
        if (vipBaseInfo != null) {
            jceOutputStream.write((JceStruct) vipBaseInfo, 29);
        }
        String str15 = this.strShowName;
        if (str15 != null) {
            jceOutputStream.write(str15, 30);
        }
        VoiceInfo voiceInfo = this.stVoiceInfo;
        if (voiceInfo != null) {
            jceOutputStream.write((JceStruct) voiceInfo, 31);
        }
        byte[] bArr2 = this.vRichSign;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 32);
        }
        jceOutputStream.write(this.uSignModifyTime, 33);
        byte[] bArr3 = this.vRespLastGameInfo;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 34);
        }
        jceOutputStream.write(this.lUserFlag, 35);
        jceOutputStream.write(this.uLoginDays, 36);
        String str16 = this.strLoginDesc;
        if (str16 != null) {
            jceOutputStream.write(str16, 37);
        }
        jceOutputStream.write(this.uTemplateId, 38);
        jceOutputStream.write(this.uQQMasterLoginDays, 39);
        jceOutputStream.write(this.ulFaceAddonId, 40);
        byte[] bArr4 = this.vRespTemplateInfo;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 41);
        }
        String str17 = this.strRespMusicInfo;
        if (str17 != null) {
            jceOutputStream.write(str17, 42);
        }
        byte[] bArr5 = this.vRespStarInfo;
        if (bArr5 != null) {
            jceOutputStream.write(bArr5, 43);
        }
        VipBaseInfo vipBaseInfo2 = this.stDiamonds;
        if (vipBaseInfo2 != null) {
            jceOutputStream.write((JceStruct) vipBaseInfo2, 44);
        }
        jceOutputStream.write(this.uAccelerateMultiple, 45);
        ArrayList<byte[]> arrayList2 = this.vvRespServices;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 46);
        }
        String str18 = this.strSpaceName;
        if (str18 != null) {
            jceOutputStream.write(str18, 47);
        }
        DateCard dateCard = this.stDateCard;
        if (dateCard != null) {
            jceOutputStream.write((JceStruct) dateCard, 48);
        }
        jceOutputStream.write(this.iBirthday, 49);
        QCallInfo qCallInfo = this.stQCallInfo;
        if (qCallInfo != null) {
            jceOutputStream.write((JceStruct) qCallInfo, 50);
        }
        GiftInfo giftInfo = this.stGiftInfo;
        if (giftInfo != null) {
            jceOutputStream.write((JceStruct) giftInfo, 51);
        }
        PanSocialInfo panSocialInfo = this.stPanSocialInfo;
        if (panSocialInfo != null) {
            jceOutputStream.write((JceStruct) panSocialInfo, 52);
        }
        QQVideoInfo qQVideoInfo = this.stVideoInfo;
        if (qQVideoInfo != null) {
            jceOutputStream.write((JceStruct) qQVideoInfo, 53);
        }
        byte[] bArr6 = this.vTempChatSig;
        if (bArr6 != null) {
            jceOutputStream.write(bArr6, 54);
        }
        InterestTagInfo interestTagInfo = this.stInterestTag;
        if (interestTagInfo != null) {
            jceOutputStream.write((JceStruct) interestTagInfo, 55);
        }
        UserFeed userFeed = this.stUserFeed;
        if (userFeed != null) {
            jceOutputStream.write((JceStruct) userFeed, 56);
        }
        QiqiVideoInfo qiqiVideoInfo = this.stQiqiVideoInfo;
        if (qiqiVideoInfo != null) {
            jceOutputStream.write((JceStruct) qiqiVideoInfo, 57);
        }
        PrivilegeBaseInfo privilegeBaseInfo = this.stPrivInfo;
        if (privilegeBaseInfo != null) {
            jceOutputStream.write((JceStruct) privilegeBaseInfo, 58);
        }
        QQApolloInfo qQApolloInfo = this.stApollo;
        if (qQApolloInfo != null) {
            jceOutputStream.write((JceStruct) qQApolloInfo, 59);
        }
        AddFrdSrcInfo addFrdSrcInfo = this.stAddFrdSrcInfo;
        if (addFrdSrcInfo != null) {
            jceOutputStream.write((JceStruct) addFrdSrcInfo, 60);
        }
        BindPhoneInfo bindPhoneInfo = this.stBindPhoneInfo;
        if (bindPhoneInfo != null) {
            jceOutputStream.write((JceStruct) bindPhoneInfo, 61);
        }
        byte[] bArr7 = this.vVisitingCardInfo;
        if (bArr7 != null) {
            jceOutputStream.write(bArr7, 62);
        }
        String str19 = this.strVoteLimitedNotice;
        if (str19 != null) {
            jceOutputStream.write(str19, 63);
        }
        jceOutputStream.write(this.bHaveVotedCnt, 64);
        jceOutputStream.write(this.bAvailVoteCnt, 65);
        String str20 = this.strEIMBindPhoneNum;
        if (str20 != null) {
            jceOutputStream.write(str20, 66);
        }
        String str21 = this.strEIMId;
        if (str21 != null) {
            jceOutputStream.write(str21, 67);
        }
        String str22 = this.strEmail;
        if (str22 != null) {
            jceOutputStream.write(str22, 68);
        }
        jceOutputStream.write(this.uCareer, 69);
        String str23 = this.strPersonal;
        if (str23 != null) {
            jceOutputStream.write(str23, 70);
        }
        byte[] bArr8 = this.vHotChatInfo;
        if (bArr8 != null) {
            jceOutputStream.write(bArr8, 71);
        }
        OlympicInfo olympicInfo = this.stOlympicInfo;
        if (olympicInfo != null) {
            jceOutputStream.write((JceStruct) olympicInfo, 72);
        }
        TCoverInfo tCoverInfo = this.stCoverInfo;
        if (tCoverInfo != null) {
            jceOutputStream.write((JceStruct) tCoverInfo, 73);
        }
        TNowBroadcastInfo tNowBroadcastInfo = this.stNowBroadcastInfo;
        if (tNowBroadcastInfo != null) {
            jceOutputStream.write((JceStruct) tNowBroadcastInfo, 74);
        }
        TEIMInfo tEIMInfo = this.stEimInfo;
        if (tEIMInfo != null) {
            jceOutputStream.write((JceStruct) tEIMInfo, 75);
        }
        TVideoHeadInfo tVideoHeadInfo = this.stVideoHeadInfo;
        if (tVideoHeadInfo != null) {
            jceOutputStream.write((JceStruct) tVideoHeadInfo, 78);
        }
        jceOutputStream.write(this.iContactNotBindQQ, 79);
        TMedalWallInfo tMedalWallInfo = this.stMedalWallInfo;
        if (tMedalWallInfo != null) {
            jceOutputStream.write((JceStruct) tMedalWallInfo, 80);
        }
        ArrayList<byte[]> arrayList3 = this.vvRespServicesBigOrder;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 81);
        }
        byte[] bArr9 = this.vResp0x5ebInfo;
        if (bArr9 != null) {
            jceOutputStream.write(bArr9, 82);
        }
        TNearbyGodInfo tNearbyGodInfo = this.stNearbyGodInfo;
        if (tNearbyGodInfo != null) {
            jceOutputStream.write((JceStruct) tNearbyGodInfo, 83);
        }
        byte[] bArr10 = this.vRespQQStoryInfo;
        if (bArr10 != null) {
            jceOutputStream.write(bArr10, 84);
        }
        byte[] bArr11 = this.vRespCustomLabelInfo;
        if (bArr11 != null) {
            jceOutputStream.write(bArr11, 85);
        }
        ArrayList<TPraiseInfo> arrayList4 = this.vPraiseList;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 86);
        }
        TCampusCircleInfo tCampusCircleInfo = this.stCampusCircleInfo;
        if (tCampusCircleInfo != null) {
            jceOutputStream.write((JceStruct) tCampusCircleInfo, 87);
        }
        TTimInfo tTimInfo = this.stTimInfo;
        if (tTimInfo != null) {
            jceOutputStream.write((JceStruct) tTimInfo, 88);
        }
        TQimInfo tQimInfo = this.stQimInfo;
        if (tQimInfo != null) {
            jceOutputStream.write((JceStruct) tQimInfo, 89);
        }
        HeartInfo heartInfo = this.stHeartInfo;
        if (heartInfo != null) {
            jceOutputStream.write((JceStruct) heartInfo, 90);
        }
        byte[] bArr12 = this.vQzoneCoverInfo;
        if (bArr12 != null) {
            jceOutputStream.write(bArr12, 91);
        }
        byte[] bArr13 = this.vNearbyTaskInfo;
        if (bArr13 != null) {
            jceOutputStream.write(bArr13, 92);
        }
        byte[] bArr14 = this.vNowInfo;
        if (bArr14 != null) {
            jceOutputStream.write(bArr14, 93);
        }
        jceOutputStream.write(this.uFriendGroupId, 94);
        byte[] bArr15 = this.vCommLabel;
        if (bArr15 != null) {
            jceOutputStream.write(bArr15, 95);
        }
        byte[] bArr16 = this.vExtendCard;
        if (bArr16 != null) {
            jceOutputStream.write(bArr16, 96);
        }
        String str24 = this.strQzoneHeader;
        if (str24 != null) {
            jceOutputStream.write(str24, 97);
        }
        Map<String, String> map = this.mapQzoneEx;
        if (map != null) {
            jceOutputStream.write((Map) map, 98);
        }
        byte[] bArr17 = this.vRespKandianInfo;
        if (bArr17 != null) {
            jceOutputStream.write(bArr17, 99);
        }
        WeishiInfo weishiInfo = this.stWeishiInfo;
        if (weishiInfo != null) {
            jceOutputStream.write((JceStruct) weishiInfo, 100);
        }
        jceOutputStream.write(this.uRichCardNameVer, 101);
        jceOutputStream.write(this.uCurMulType, 102);
        byte[] bArr18 = this.vLongNickTopicInfo;
        if (bArr18 != null) {
            jceOutputStream.write(bArr18, 103);
        }
        jceOutputStream.write(this.i0x6d4Success, 104);
    }

    public RespSummaryCard(int i3, byte b16, byte b17, String str, String str2, int i16, String str3, String str4, String str5, String str6, String str7, String str8, String str9, long j3, String str10, AlbumInfo albumInfo, int i17, int i18, byte b18, String str11, String str12, String str13, long j16, long j17, int i19, int i26, ArrayList<String> arrayList, byte[] bArr, String str14, VipBaseInfo vipBaseInfo, String str15, VoiceInfo voiceInfo, byte[] bArr2, long j18, byte[] bArr3, long j19, long j26, String str16, long j27, long j28, long j29, byte[] bArr4, String str17, byte[] bArr5, VipBaseInfo vipBaseInfo2, long j36, ArrayList<byte[]> arrayList2, String str18, DateCard dateCard, int i27, QCallInfo qCallInfo, GiftInfo giftInfo, PanSocialInfo panSocialInfo, QQVideoInfo qQVideoInfo, byte[] bArr6, InterestTagInfo interestTagInfo, UserFeed userFeed, QiqiVideoInfo qiqiVideoInfo, PrivilegeBaseInfo privilegeBaseInfo, QQApolloInfo qQApolloInfo, AddFrdSrcInfo addFrdSrcInfo, BindPhoneInfo bindPhoneInfo, byte[] bArr7, String str19, short s16, short s17, String str20, String str21, String str22, long j37, String str23, byte[] bArr8, OlympicInfo olympicInfo, TCoverInfo tCoverInfo, TNowBroadcastInfo tNowBroadcastInfo, TEIMInfo tEIMInfo, TVideoHeadInfo tVideoHeadInfo, int i28, TMedalWallInfo tMedalWallInfo, ArrayList<byte[]> arrayList3, byte[] bArr9, TNearbyGodInfo tNearbyGodInfo, byte[] bArr10, byte[] bArr11, ArrayList<TPraiseInfo> arrayList4, TCampusCircleInfo tCampusCircleInfo, TTimInfo tTimInfo, TQimInfo tQimInfo, HeartInfo heartInfo, byte[] bArr12, byte[] bArr13, byte[] bArr14, long j38, byte[] bArr15, byte[] bArr16, String str24, Map<String, String> map, byte[] bArr17, WeishiInfo weishiInfo, long j39, long j46, byte[] bArr18, int i29) {
        this.iFace = i3;
        this.bSex = b16;
        this.bAge = b17;
        this.strNick = str;
        this.strRemark = str2;
        this.iLevel = i16;
        this.strProvince = str3;
        this.strCity = str4;
        this.strSign = str5;
        this.strGroupName = str6;
        this.strGroupNick = str7;
        this.strMobile = str8;
        this.strContactName = str9;
        this.ulShowControl = j3;
        this.strQzoneFeedsDesc = str10;
        this.oLatestPhotos = albumInfo;
        this.iVoteCount = i17;
        this.iLastestVoteCount = i18;
        this.bValid4Vote = b18;
        this.strCountry = str11;
        this.strStatus = str12;
        this.strAutoRemark = str13;
        this.lCacheControl = j16;
        this.lUIN = j17;
        this.iPhotoCount = i19;
        this.eAddOption = i26;
        this.vAddQuestion = arrayList;
        this.vSeed = bArr;
        this.strDiscussName = str14;
        this.stVipInfo = vipBaseInfo;
        this.strShowName = str15;
        this.stVoiceInfo = voiceInfo;
        this.vRichSign = bArr2;
        this.uSignModifyTime = j18;
        this.vRespLastGameInfo = bArr3;
        this.lUserFlag = j19;
        this.uLoginDays = j26;
        this.strLoginDesc = str16;
        this.uTemplateId = j27;
        this.uQQMasterLoginDays = j28;
        this.ulFaceAddonId = j29;
        this.vRespTemplateInfo = bArr4;
        this.strRespMusicInfo = str17;
        this.vRespStarInfo = bArr5;
        this.stDiamonds = vipBaseInfo2;
        this.uAccelerateMultiple = j36;
        this.vvRespServices = arrayList2;
        this.strSpaceName = str18;
        this.stDateCard = dateCard;
        this.iBirthday = i27;
        this.stQCallInfo = qCallInfo;
        this.stGiftInfo = giftInfo;
        this.stPanSocialInfo = panSocialInfo;
        this.stVideoInfo = qQVideoInfo;
        this.vTempChatSig = bArr6;
        this.stInterestTag = interestTagInfo;
        this.stUserFeed = userFeed;
        this.stQiqiVideoInfo = qiqiVideoInfo;
        this.stPrivInfo = privilegeBaseInfo;
        this.stApollo = qQApolloInfo;
        this.stAddFrdSrcInfo = addFrdSrcInfo;
        this.stBindPhoneInfo = bindPhoneInfo;
        this.vVisitingCardInfo = bArr7;
        this.strVoteLimitedNotice = str19;
        this.bHaveVotedCnt = s16;
        this.bAvailVoteCnt = s17;
        this.strEIMBindPhoneNum = str20;
        this.strEIMId = str21;
        this.strEmail = str22;
        this.uCareer = j37;
        this.strPersonal = str23;
        this.vHotChatInfo = bArr8;
        this.stOlympicInfo = olympicInfo;
        this.stCoverInfo = tCoverInfo;
        this.stNowBroadcastInfo = tNowBroadcastInfo;
        this.stEimInfo = tEIMInfo;
        this.stVideoHeadInfo = tVideoHeadInfo;
        this.iContactNotBindQQ = i28;
        this.stMedalWallInfo = tMedalWallInfo;
        this.vvRespServicesBigOrder = arrayList3;
        this.vResp0x5ebInfo = bArr9;
        this.stNearbyGodInfo = tNearbyGodInfo;
        this.vRespQQStoryInfo = bArr10;
        this.vRespCustomLabelInfo = bArr11;
        this.vPraiseList = arrayList4;
        this.stCampusCircleInfo = tCampusCircleInfo;
        this.stTimInfo = tTimInfo;
        this.stQimInfo = tQimInfo;
        this.stHeartInfo = heartInfo;
        this.vQzoneCoverInfo = bArr12;
        this.vNearbyTaskInfo = bArr13;
        this.vNowInfo = bArr14;
        this.uFriendGroupId = j38;
        this.vCommLabel = bArr15;
        this.vExtendCard = bArr16;
        this.strQzoneHeader = str24;
        this.mapQzoneEx = map;
        this.vRespKandianInfo = bArr17;
        this.stWeishiInfo = weishiInfo;
        this.uRichCardNameVer = j39;
        this.uCurMulType = j46;
        this.vLongNickTopicInfo = bArr18;
        this.i0x6d4Success = i29;
    }
}
