package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_audio;
import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.cell_forward;
import NS_MOBILE_FEEDS.cell_music;
import NS_MOBILE_FEEDS.cell_original;
import NS_MOBILE_FEEDS.cell_share;
import NS_MOBILE_FEEDS.s_droplist_option;
import NS_MOBILE_FEEDS.single_detail;
import NS_MOBILE_FEEDS.single_feed;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.commoncode.module.videorecommend.model.VideoRecommendInfo;
import com.qzone.feed.utils.AlbumRecReporter;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.model.CellMallInfo;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.CellColorfulTail;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BusinessFeedData implements IDBCacheDataWrapper, SmartParcelable {
    public static final int ACTIVE_FEED = 0;
    public static final int BLOGlIST_FEED = 5;
    static final String CALLFOLLOW_MEDAL_TAB = "canfollow_medal_tab";
    public static final int E_GUIDING_BIRTHDAY_CARD_DAY = 16;
    public static final String FAMOUS_TAB = "famous_key";
    public static final int FEED_FROM_UNKNOW = -1;
    public static final int FEED_TYPE_DETAIL = 2;
    public static final int FEED_TYPE_EVENT_PAGE = 12289;
    public static final int FEED_TYPE_EXTEND_FEED = 12290;
    public static final int FEED_TYPE_MINE = 3;
    public static final int FEED_TYPE_NORMAL = 4097;
    public static final int FEED_TYPE_OTHER = 0;
    public static final int FEED_TYPE_PASSIVE = 4098;
    public static final int FEED_TYPE_SECRET_ACTIVE = 8193;
    public static final int FEED_TYPE_SECRET_PASSIVE = 8194;
    public static final int FEED_TYPE_SHUOSHUO_LIST = 4099;
    public static final int FEED_TYPE_VIDEO_LAYER = 16385;
    public static final boolean IFMODIFY = false;
    static final String LBS_TIME_TAB = "lbs_time";
    static final String LIVEMEDAL_TAB = "live_medal_tab";
    public static final int LOGO_NICK_AD = 2;
    static final String LOVERZONE_TAB = "loverzoneicon";
    public static final int MAX_STAUS_UPLOAD = 1;
    public static final int MSGBLIST = 6;
    public static final int MY_FEED = 1;
    public static final int NEWFRIENDFEED = 8;
    static final String NICKNAME_TAB = "nickname";
    public static final int PICTURE_VIEWER = 11;
    public static final int POP_CLICK_SCENE = 2;
    public static final int PUSH = 10;
    public static final int QZONE_FRIEND_FEEDS_STYLE = 100478;
    static final String RECOM_TAB = "recom_key";
    public static final int RELATON_FEED = 3;
    public static final int SPECIALFRIENDFEED = 9;
    static final String STANDALONE_TAB = "standaloneicon";
    static final String STAR_VIP_TAB = "star_vip_tab";
    public static String STORE_KEY = "BusinessFeedData";
    public static final String TAG = "BusinessFeedData";
    static final String TIME_DEL_TAB = "time_del_tab";
    public static final int TODAY_INHISTORY_FEED = 4;
    public static final int TYPE_AUTO_PACK = 1;
    public static final int TYPE_AUTO_SMART_PARCEL = 0;
    static final String USERDIS_TAB = "userdis";
    public static final int USER_HOME = 2;
    static final int VERSION = 139;
    public static final int VIDEOLIST = 7;
    public static final int VIDEO_CLICK_SCENE = 1;
    static final String YELLOW_VIP_TAB = "yellow_vip_tab";

    @NeedParcel
    public CellPictureInfo LongPicsCellPictureInfo;

    @NeedParcel
    public String attachInfo;

    @NeedParcel
    public CellActiveAdv cellActiveAdv;

    @NeedParcel
    public CellAdvContainerAttach cellAdvContainerAttach;

    @NeedParcel
    public CellAlbumEntrance cellAlbumEntrance;

    @NeedParcel
    public CellAttitude cellAttitude;

    @NeedParcel
    public ArrayList<AudioInfo> cellAudioInfo;

    @NeedParcel
    CellBottomRecomm cellBottomRecomm;

    @NeedParcel
    public CellCanvas cellCanvas;

    @NeedParcel
    public CellColorfulTail cellColorfulTail;

    @NeedParcel
    public CellCommentEssence cellCommentEssence;

    @NeedParcel
    public CellCommentInfo cellCommentInfo;

    @NeedParcel
    CellCornerAdv cellCornerAdv;
    public CellCount cellCount;

    @NeedParcel
    public CellCover cellCover;

    @NeedParcel
    public CellDIYData cellDIYData;

    @NeedParcel
    public CellDecorateInfo cellDecorateInfo;

    @NeedParcel
    public ArrayList<Object> cellDetailContent;

    @NeedParcel
    public CellDiss cellDiss;

    @NeedParcel
    public CellDynamicAlbum cellDynamicAlbum;

    @NeedParcel
    public CellFeedCommInfo cellFeedCommInfo;

    @NeedParcel
    public CellFeedSignature cellFeedSignature;

    @NeedParcel
    public FeedSkinData cellFeedSkinInfo;

    @NeedParcel
    public CellFollowGuide cellFollowGuide;

    @NeedParcel
    public CellForwardListInfo cellForwardInfo;

    @NeedParcel
    CellFrdlikeContainer cellFrdlikeContainer;

    @NeedParcel
    public CellFriendBirthdayGift cellFriendBirthdayGift;

    @NeedParcel
    public CellFunctionGuide cellFunctionGuide;

    @NeedParcel
    public CellFunnyTreadSpace cellFunnyTreadSpace;
    public k cellGameRecommend;

    @NeedParcel
    public CellGiftInfo cellGiftInfo;

    @NeedParcel
    public CellGoods cellGoods;

    @NeedParcel
    public CellGroupAlbumInfo cellGroupAlbumInfo;

    @NeedParcel
    public CellGuiding cellGuiding;

    @NeedParcel
    public CellHeader cellHeader;

    @NeedParcel
    public CellHighFiveInfo cellHighFiveInfo;

    @NeedParcel
    public CellIdInfo cellIdInfo;

    @NeedParcel
    public CellInterest cellInterest;

    @NeedParcel
    public CellInterestingMessageEmotion cellInterestingMessageEmotion;

    @NeedParcel
    public CellIntimateSpaceInfo cellIntimateSpaceInfo;

    @NeedParcel
    public CellLBSEvent cellLBSEvent;

    @NeedParcel
    public CellLbsInfo cellLbsInfo;

    @NeedParcel
    public CellLeftThumb cellLeftThumb;

    @NeedParcel
    public CellLikeInfo cellLikeInfo;

    @NeedParcel
    public CellLive cellLive;

    @NeedParcel
    public CellLocalInfo cellLocalInfo;

    @NeedParcel
    public CellLuckyMoney cellLuckyMoney;

    @NeedParcel
    public CellMallInfo cellMallInfo;

    @NeedParcel
    public CellMediaInfo cellMediaInfo;

    @NeedParcel
    public MusicInfo cellMusicInfo;

    @NeedParcel
    public CellNegativeFeedback cellNegativeFeedback;

    @NeedParcel
    public CellOperationInfo cellOperationInfo;

    @NeedParcel
    public CellOperationRegion cellOperationRegion;

    @NeedParcel
    public BusinessFeedData cellOriginalInfo;

    @NeedParcel
    public SmartParcelable cellPatch;

    @NeedParcel
    public CellPermissionInfo cellPermissionInfo;

    @NeedParcel
    public CellPicTextInfo cellPicTextInfo;

    @NeedParcel
    public CellPictureInfo cellPictureInfo;

    @NeedParcel
    public CellPokeLike cellPokeLike;

    @NeedParcel
    public CellPresentInfo cellPresentInfo;

    @NeedParcel
    public CellQbossPsvAdv cellQbossPsvAdv;
    public CellRank cellRank;

    @NeedParcel
    public b cellRecomTag;

    @NeedParcel
    public CellRecommAction cellRecommAction;

    @NeedParcel
    public CellRecommFooter cellRecommFooter;

    @NeedParcel
    public CellRecommHeader cellRecommHeader;

    @NeedParcel
    public CellRecommItem cellRecommItem;

    @NeedParcel
    public CellRecommendList cellRecommendList;

    @NeedParcel
    public CellRedBonus cellRedBonus;

    @NeedParcel
    public CellReferInfo cellReferInfo;

    @NeedParcel
    public CellRemarkInfo cellRemarkInfo;

    @NeedParcel
    public CellSearch cellSearch;

    @NeedParcel
    public CellSeparator cellSeparator;

    @NeedParcel
    public CellShareCard cellShareCard;

    @NeedParcel
    public CellSpecialCare cellSpecialCare;

    @NeedParcel
    public CellSummary cellSummary;

    @NeedParcel
    public CellTemplate cellTemplate;

    @NeedParcel
    public CellTheme cellTheme;

    @NeedParcel
    public CellTitleInfo cellTitleInfo;

    @NeedParcel
    public CellToast cellToast;

    @NeedParcel
    public CellUniverse cellUniverse;

    @NeedParcel
    public CellUpperBanner cellUpperBanner;

    @NeedParcel
    public CellUserInfo cellUserInfo;

    @NeedParcel
    public VideoInfo cellVideoInfo;

    @NeedParcel
    public CellViewMore cellViewMore;

    @NeedParcel
    public CellVisitorInfo cellVisitorInfo;

    @NeedParcel
    public long containerSubType;
    public int currShowHeight;
    public int currShowIndex;
    public boolean disPlayed;
    public boolean fakeRedPocketFeed;
    public String feedAttachReadstr;
    public String feedCommentReadstr;
    public String feedContentReadstr;

    @NeedParcel
    public String feedInfo;
    public String feedLeftThumbReadstr;
    public String feedLikeReadstr;
    public String feedTitleReadstr;

    @NeedParcel
    public int feedType;
    public String feedVisitReadstr;

    @NeedParcel
    public long feeds_update_time;

    @NeedParcel
    public int forwardNum;
    public boolean hasCalculate;

    @NeedParcel
    public int iUnifyRecomType;
    public Integer integerUniTimeLbsKey;
    public boolean isBlankSearchNoResultTip;

    @NeedParcel
    public boolean isFamousRecommFollowed;

    @NeedParcel
    public boolean isForwardFeedData;

    @NeedParcel
    public boolean isMixFake1;

    @NeedParcel
    public boolean isMixFake2;
    public boolean isNew;
    public boolean isParticipate;

    @NeedParcel
    public boolean isRead;

    @NeedParcel
    public boolean isSubFeed;

    @NeedParcel
    public boolean isVideoRecommAutoPlay;
    private boolean mIsFakeMemorySealFeed;
    private boolean mIsMsgFeed;
    private boolean mIsRecommendFeed;
    private boolean mIsReeditFeed;
    private boolean mIsTimelineEmptyFeed;
    public VideoPlayInfo mPreCalVideoPlayInfo;
    private String mRecommendReportUUID;
    String mShootAddr;
    public boolean needShowSearchNoResultTip;
    public long owner_uin;

    @NeedParcel
    public long parentContainerSubType;
    public BusinessFeedData parentFeedData;
    public int photoMode;
    public FeedPictureInfo[] pics;
    public int positionInList;

    @NeedParcel
    public ArrayList<BusinessFeedData> recBusinessFeedDatas;

    @NeedParcel
    public int recommendPageIndex;
    public Calendar searchClickCalendar;
    public Calendar searchRealCalendar;

    @NeedParcel
    public int shareNum;
    public boolean showDateHeader;
    public String timeAreaStr;
    public String timeLbsStr;
    public String uniCanFollowKey;
    public String uniFamousKey;
    public String uniLiveKey;
    String uniLiveMedalKey;
    String uniLoverZoneKey;
    public String uniNickNameKey;
    public String uniRecomKey;
    String uniStandaloneKey;
    public String uniStarVipKey;
    public String uniTimeLbsKey;
    String uniUserdisKey;
    public String uniYellowVipKey;
    public int videoClickScene;

    @NeedParcel
    public Map<Integer, String> videoRecommendBuisParamMap;

    @NeedParcel
    public ArrayList<VideoRecommendInfo> videoRecommendInfos;
    static ConcurrentHashMap<String, SQLiteStatement> tableKeyToStateMap = new ConcurrentHashMap<>();
    public static final IDBCacheDataWrapper.a<BusinessFeedData> DB_CREATOR = new a();
    public int containerIndex = -1;
    public int scrollX = 0;
    public boolean isFromFollowGuide = false;

    @NeedParcel
    public boolean isExposured = false;
    public int qqVideoFeedStatus = 0;
    public boolean isAfterFollowGuide = false;
    private QZoneAdFeedData adFeedData = new QZoneAdFeedData();
    public int feedFrom = -1;

    @NeedParcel
    public boolean isOriginalEmpty = true;

    @NeedParcel
    public int mixVideoIndex = -1;
    public boolean hasDropdownFinishedAddFriend = false;
    public boolean setFeedViewGapWhite = false;
    public boolean isEventTagFeed = false;
    public int fadedTimeScale = 0;
    public boolean hasHighFive = false;

    @NeedParcel
    public boolean isFakeHighFive = false;
    public boolean isNegativeFeedback = false;
    public boolean hasClickedMyEventTag = false;
    public long adPullTimeForCountDown = -1;
    public boolean mIsFriendPlayingRecomm = false;
    public int ignoreTitleGap = 0;
    public boolean barHasPlayedAnimation = false;
    public volatile AlbumRecReporter.c albumRecInfo = null;
    public boolean hideCommentBar = false;
    public boolean hideMoreBtn = false;
    public boolean isQQCircleRecomm = false;
    public boolean isFrdVideoFeedPraiseClicked = false;
    public boolean shouldHide = false;
    Runnable quireFavorTast = new Runnable() { // from class: com.qzone.proxy.feedcomponent.model.BusinessFeedData.1
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    int isAdFeeds = -1;
    boolean mIsFirstVideoInFeeds = false;

    public static BusinessFeedData createBusinessFeedData(VideoRecommendInfo videoRecommendInfo) {
        BusinessFeedData businessFeedData = new BusinessFeedData();
        if (videoRecommendInfo == null) {
            return businessFeedData;
        }
        CellUserInfo cellUserInfo = videoRecommendInfo.mCellUserInfo;
        if (cellUserInfo != null) {
            businessFeedData.cellUserInfo = cellUserInfo;
        }
        CellFeedCommInfo cellFeedCommInfo = videoRecommendInfo.mFeedCommInfo;
        if (cellFeedCommInfo != null) {
            businessFeedData.cellFeedCommInfo = cellFeedCommInfo;
        }
        VideoInfo videoInfo = videoRecommendInfo.mCellVideoInfo;
        if (videoInfo != null) {
            businessFeedData.cellVideoInfo = videoInfo;
        }
        CellIdInfo cellIdInfo = videoRecommendInfo.mCellIdInfo;
        if (cellIdInfo != null) {
            businessFeedData.cellIdInfo = cellIdInfo;
        }
        CellSummary cellSummary = videoRecommendInfo.mCellSummary;
        if (cellSummary != null) {
            businessFeedData.cellSummary = cellSummary;
        }
        CellLikeInfo cellLikeInfo = videoRecommendInfo.mCellLikeInfo;
        if (cellLikeInfo != null) {
            businessFeedData.cellLikeInfo = cellLikeInfo;
        }
        CellCommentInfo cellCommentInfo = videoRecommendInfo.mCellCommentInfo;
        if (cellCommentInfo != null) {
            businessFeedData.cellCommentInfo = cellCommentInfo;
        }
        CellOperationInfo cellOperationInfo = videoRecommendInfo.mCellOperationInfo;
        if (cellOperationInfo != null) {
            businessFeedData.cellOperationInfo = cellOperationInfo;
        }
        CellVisitorInfo cellVisitorInfo = videoRecommendInfo.mCellVisitorInfo;
        if (cellVisitorInfo != null) {
            businessFeedData.cellVisitorInfo = cellVisitorInfo;
        }
        CellLocalInfo cellLocalInfo = new CellLocalInfo();
        businessFeedData.cellLocalInfo = cellLocalInfo;
        cellLocalInfo.fakeType = videoRecommendInfo.feedFakeType;
        CellRedBonus cellRedBonus = videoRecommendInfo.mCellRedBonus;
        if (cellRedBonus != null) {
            businessFeedData.cellRedBonus = cellRedBonus;
        }
        CellRecommAction cellRecommAction = videoRecommendInfo.mCellRecommAction;
        if (cellRecommAction != null) {
            businessFeedData.cellRecommAction = cellRecommAction;
        }
        CellPermissionInfo cellPermissionInfo = videoRecommendInfo.mCellPermissionInfo;
        if (cellPermissionInfo != null) {
            businessFeedData.cellPermissionInfo = cellPermissionInfo;
        }
        CellBottomRecomm cellBottomRecomm = videoRecommendInfo.mCellBottomRecomm;
        if (cellBottomRecomm != null) {
            businessFeedData.setCellBottomRecomm(cellBottomRecomm);
        }
        CellNegativeFeedback cellNegativeFeedback = videoRecommendInfo.mCellNegativeFeedback;
        if (cellNegativeFeedback != null) {
            businessFeedData.cellNegativeFeedback = cellNegativeFeedback;
        }
        CellCornerAdv cellCornerAdv = videoRecommendInfo.mCellCornerAdv;
        if (cellCornerAdv != null) {
            businessFeedData.cellCornerAdv = cellCornerAdv;
        }
        CellPictureInfo cellPictureInfo = videoRecommendInfo.mCellPictureInfo;
        if (cellPictureInfo != null) {
            businessFeedData.cellPictureInfo = cellPictureInfo;
        }
        CellCanvas cellCanvas = videoRecommendInfo.mCellCanvas;
        if (cellCanvas != null) {
            businessFeedData.cellCanvas = cellCanvas;
        }
        return businessFeedData;
    }

    public static BusinessFeedData createFrom(single_feed single_feedVar, int i3) {
        CellRecommAction cellRecommAction;
        if (single_feedVar == null) {
            return null;
        }
        BusinessFeedData createFrom = createFrom(single_feedVar.singlefeed, single_feedVar.feedskey, single_feedVar.feed_info);
        createFrom.feeds_update_time = single_feedVar.feeds_update_time;
        createFrom.feedType = i3;
        createFrom.containerSubType = single_feedVar.uContainerSubType;
        createFrom.iUnifyRecomType = single_feedVar.iUnifyRecomType;
        ArrayList<Map<Integer, byte[]>> arrayList = single_feedVar.recomfeeds;
        if (arrayList != null && !arrayList.isEmpty()) {
            createFrom.recBusinessFeedDatas = new ArrayList<>();
            Iterator<Map<Integer, byte[]>> it = single_feedVar.recomfeeds.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                Map<Integer, byte[]> next = it.next();
                if (next != null && !next.isEmpty()) {
                    BusinessFeedData createFrom2 = createFrom(next, single_feedVar.feedskey, single_feedVar.feed_info);
                    createFrom2.isSubFeed = true;
                    createFrom2.feedType = i3;
                    createFrom2.containerIndex = i16;
                    createFrom2.parentFeedData = createFrom;
                    createFrom2.parentContainerSubType = single_feedVar.uContainerSubType;
                    createFrom2.getFeedCommInfo().isSubOfMultiAdvContainerFeed = createFrom2.isSubOfMultiAdvContainerFeed();
                    createFrom2.getFeedCommInfo().isSubOfSingleAdvContainerFeed = createFrom2.isSubOfSingleAdvContainerFeed();
                    createFrom.recBusinessFeedDatas.add(createFrom2);
                }
                i16++;
            }
        }
        if (createFrom.isSingleAdvContainerFeed() && (cellRecommAction = createFrom.cellRecommAction) != null) {
            cellRecommAction.isHideActionArea = 1;
        }
        if (createFrom.isMultiAdvContainerFeed() && createFrom.getOperationInfo().cookie == null) {
            createFrom.getOperationInfo().cookie = createFrom.getFirstSubFeedCookie();
        }
        return createFrom;
    }

    static void fillFeedData(BusinessFeedData businessFeedData, l lVar) {
        Map<String, String> map;
        cell_comm cell_commVar;
        Map<String, String> map2;
        String str;
        ye.g gVar = ye.g.f450213a;
        if (gVar.f()) {
            gVar.e(businessFeedData, lVar);
            return;
        }
        businessFeedData.cellFeedCommInfo = CellFeedCommInfo.create(lVar);
        businessFeedData.cellUserInfo = CellUserInfo.create(lVar);
        businessFeedData.cellIdInfo = CellIdInfo.create(lVar);
        businessFeedData.cellFeedSkinInfo = FeedSkinData.create(lVar);
        businessFeedData.cellTitleInfo = CellTitleInfo.create(lVar);
        businessFeedData.cellSummary = CellSummary.create(lVar);
        businessFeedData.cellPictureInfo = CellPictureInfo.create(lVar);
        businessFeedData.cellPicTextInfo = CellPicTextInfo.create(lVar);
        cell_music cell_musicVar = lVar.f50354h;
        if (cell_musicVar != null) {
            businessFeedData.cellMusicInfo = com.qzone.proxy.feedcomponent.util.e.j(cell_musicVar);
        }
        businessFeedData.cellGiftInfo = CellGiftInfo.create(lVar);
        businessFeedData.cellVideoInfo = com.qzone.proxy.feedcomponent.util.e.t(lVar.f50356i, businessFeedData.isGDTAdvFeed());
        businessFeedData.cellLbsInfo = CellLbsInfo.create(lVar);
        businessFeedData.cellPermissionInfo = CellPermissionInfo.create(lVar);
        businessFeedData.cellRemarkInfo = CellRemarkInfo.create(lVar);
        businessFeedData.cellCommentInfo = CellCommentInfo.create(lVar);
        businessFeedData.cellCommentEssence = CellCommentEssence.create(lVar);
        businessFeedData.cellLikeInfo = CellLikeInfo.create(lVar);
        cell_share cell_shareVar = lVar.f50366n;
        if (cell_shareVar != null) {
            businessFeedData.shareNum = cell_shareVar.num;
        }
        cell_forward cell_forwardVar = lVar.f50368o;
        if (cell_forwardVar != null) {
            businessFeedData.forwardNum = cell_forwardVar.num;
        }
        businessFeedData.cellOperationInfo = CellOperationInfo.create(lVar);
        businessFeedData.cellVisitorInfo = CellVisitorInfo.create(lVar);
        cell_audio cell_audioVar = lVar.f50384w;
        if (cell_audioVar != null && cell_audioVar.audio != null) {
            businessFeedData.cellAudioInfo = new ArrayList<>();
            for (int i3 = 0; i3 < lVar.f50384w.audio.size(); i3++) {
                businessFeedData.cellAudioInfo.add(com.qzone.proxy.feedcomponent.util.e.d(lVar.f50384w.audio.get(i3)));
            }
        }
        businessFeedData.cellReferInfo = CellReferInfo.create(lVar);
        businessFeedData.cellDetailContent = com.qzone.proxy.feedcomponent.util.e.f(lVar.f50372q);
        businessFeedData.cellLocalInfo = CellLocalInfo.create(lVar);
        businessFeedData.cellLeftThumb = com.qzone.proxy.feedcomponent.util.e.i(lVar.f50390z, businessFeedData.feedType == 4098);
        businessFeedData.cellQbossPsvAdv = com.qzone.proxy.feedcomponent.util.e.o(lVar.A);
        cell_original cell_originalVar = lVar.f50370p;
        if (cell_originalVar != null) {
            businessFeedData.isOriginalEmpty = false;
            businessFeedData.isForwardFeedData = true;
            BusinessFeedData createFrom = createFrom(cell_originalVar.original_data);
            if (createFrom != null && (cell_commVar = lVar.f50340a) != null && (map2 = cell_commVar.extendInfo) != null && (str = map2.get("is_feeds_long_pics_browsing_mode")) != null && str.equals("1") && createFrom.getPictureInfo() != null && createFrom.getPictureInfo().pics != null && createFrom.getPictureInfo().pics.size() != 0) {
                createFrom.getPictureInfo().pics.get(0).fakeLongPic = 1;
            }
            businessFeedData.cellOriginalInfo = createFrom;
            createFrom.isForwardFeedData = true;
        }
        businessFeedData.cellRecommHeader = CellRecommHeader.create(lVar);
        businessFeedData.cellRecommAction = CellRecommAction.create(lVar);
        businessFeedData.cellTemplate = CellTemplate.create(lVar);
        businessFeedData.cellHeader = CellHeader.create(lVar);
        businessFeedData.cellGoods = CellGoods.create(lVar);
        businessFeedData.cellSearch = CellSearch.create(lVar);
        businessFeedData.cellCover = CellCover.create(lVar);
        businessFeedData.cellDynamicAlbum = CellDynamicAlbum.create(lVar);
        businessFeedData.cellSeparator = CellSeparator.create(lVar);
        businessFeedData.cellActiveAdv = CellActiveAdv.create(lVar);
        businessFeedData.cellTheme = CellTheme.create(lVar);
        businessFeedData.cellSpecialCare = CellSpecialCare.create(lVar);
        businessFeedData.cellRecommFooter = CellRecommFooter.create(lVar);
        businessFeedData.cellInterestingMessageEmotion = CellInterestingMessageEmotion.create(lVar);
        businessFeedData.cellRecommItem = CellRecommItem.create(lVar);
        businessFeedData.cellInterest = CellInterest.create(lVar);
        businessFeedData.cellCount = CellCount.create(lVar);
        businessFeedData.cellRank = CellRank.create(lVar);
        businessFeedData.cellFunctionGuide = CellFunctionGuide.create(lVar);
        businessFeedData.cellBottomRecomm = CellBottomRecomm.create(lVar);
        businessFeedData.cellFrdlikeContainer = CellFrdlikeContainer.create(lVar);
        businessFeedData.cellDecorateInfo = CellDecorateInfo.create(lVar);
        businessFeedData.cellViewMore = CellViewMore.create(lVar);
        businessFeedData.cellHighFiveInfo = CellHighFiveInfo.create(lVar);
        businessFeedData.cellAdvContainerAttach = CellAdvContainerAttach.create(lVar);
        businessFeedData.cellLive = CellLive.create(lVar);
        businessFeedData.cellGuiding = CellGuiding.create(lVar);
        if (businessFeedData.isDynamicAlbumFeed() && businessFeedData.getOriginalInfo() != null) {
            businessFeedData.getOriginalInfo().setCellDynamicAlbum(businessFeedData.getCellDynamicAlbum());
        }
        businessFeedData.cellFriendBirthdayGift = CellFriendBirthdayGift.create(lVar);
        businessFeedData.cellAdvContainerAttach = CellAdvContainerAttach.create(lVar);
        CellUserInfo cellUserInfo = businessFeedData.cellUserInfo;
        businessFeedData.cellRedBonus = CellRedBonus.create(lVar, cellUserInfo != null ? cellUserInfo.getUser() : null);
        businessFeedData.cellLuckyMoney = CellLuckyMoney.create(lVar);
        businessFeedData.cellCanvas = CellCanvas.create(lVar);
        businessFeedData.cellForwardInfo = CellForwardListInfo.create(lVar);
        businessFeedData.cellFollowGuide = CellFollowGuide.create(lVar);
        businessFeedData.cellRecomTag = b.a(lVar);
        businessFeedData.cellNegativeFeedback = CellNegativeFeedback.create(lVar);
        businessFeedData.cellCornerAdv = CellCornerAdv.create(lVar);
        businessFeedData.cellShareCard = CellShareCard.create(lVar);
        businessFeedData.cellAlbumEntrance = CellAlbumEntrance.create(lVar);
        businessFeedData.cellPresentInfo = CellPresentInfo.createFrom(lVar);
        CellRecommAction cellRecommAction = businessFeedData.cellRecommAction;
        if (cellRecommAction != null && cellRecommAction.countDownTimer > 0) {
            businessFeedData.adPullTimeForCountDown = SystemClock.elapsedRealtime();
        }
        businessFeedData.cellDiss = CellDiss.create(lVar);
        businessFeedData.cellAttitude = CellAttitude.create(lVar);
        businessFeedData.cellUpperBanner = CellUpperBanner.create(lVar);
        CellFunnyTreadSpace create = CellFunnyTreadSpace.create(lVar);
        CellDecorateInfo cellDecorateInfo = businessFeedData.cellDecorateInfo;
        businessFeedData.cellFunnyTreadSpace = CellFunnyTreadSpace.mergeWithCustomTrack(create, cellDecorateInfo != null ? cellDecorateInfo.customTrackDeco : null);
        businessFeedData.cellOperationRegion = CellOperationRegion.create(lVar);
        CellUserInfo cellUserInfo2 = businessFeedData.cellUserInfo;
        if (cellUserInfo2 != null && cellUserInfo2.getUser() != null) {
            businessFeedData.cellDIYData = CellDIYData.create(lVar, businessFeedData.cellUserInfo.getUser().uin);
        }
        businessFeedData.cellFeedSignature = CellFeedSignature.create(lVar);
        businessFeedData.cellFeedSkinInfo = mergeNewCardData(businessFeedData.cellDecorateInfo, businessFeedData.cellFeedSkinInfo, businessFeedData.cellUserInfo);
        CellUserInfo cellUserInfo3 = businessFeedData.cellUserInfo;
        String str2 = "";
        if (cellUserInfo3 != null && cellUserInfo3.getUser() != null) {
            str2 = businessFeedData.cellUserInfo.getUser().uin + "";
        }
        businessFeedData.cellMallInfo = CellMallInfo.create(lVar, str2);
        businessFeedData.cellRecommendList = CellRecommendList.create(lVar);
        CellUniverse create2 = CellUniverse.create(lVar);
        businessFeedData.cellUniverse = create2;
        businessFeedData.cellGameRecommend = com.qzone.reborn.feedx.presenter.friendplaying.e.d(create2);
        businessFeedData.cellPokeLike = CellPokeLike.create(lVar);
        businessFeedData.cellColorfulTail = CellColorfulTail.create(lVar.A0);
        businessFeedData.cellToast = CellToast.create(lVar);
        mergeGiftData(businessFeedData.cellDecorateInfo, businessFeedData.cellPictureInfo);
        mergeHighFiveData(businessFeedData.cellSummary, businessFeedData.cellHighFiveInfo);
        cell_comm cell_commVar2 = lVar.f50340a;
        if (cell_commVar2 == null || (map = cell_commVar2.extendInfo) == null) {
            return;
        }
        businessFeedData.mIsFriendPlayingRecomm = "2133_1157".equals(map.get("_qboss_patternid"));
    }

    public static void mergeHighFiveData(CellSummary cellSummary, CellHighFiveInfo cellHighFiveInfo) {
        if (cellSummary == null || cellHighFiveInfo == null || TextUtils.isEmpty(cellHighFiveInfo.textPraise) || TextUtils.isEmpty(cellSummary.summary)) {
            return;
        }
        String str = cellHighFiveInfo.originText;
        try {
            if (str.contains("\u6536\u5230\u4e86\u6211\u7684\u8d5e\u5e76")) {
                StringBuilder sb5 = new StringBuilder(str);
                sb5.insert(str.indexOf("\u6536\u5230\u4e86\u6211\u7684\u8d5e\u5e76") + 7, cellHighFiveInfo.textPraise);
                cellSummary.summary = sb5.toString();
            } else if (str.contains("\u56de\u5e94\u4e86\u6211\u7684\u51fb\u638c")) {
                StringBuilder sb6 = new StringBuilder(str);
                sb6.insert(sb6.indexOf("\u56de\u5e94\u4e86\u6211\u7684\u51fb\u638c"), cellHighFiveInfo.textPraise);
                sb6.replace(sb6.indexOf("\u53cc\u65b9\u5171\u51fb\u638c") + 5, sb6.indexOf("\u6b21"), cellHighFiveInfo.highFiveCount + "");
                cellSummary.summary = sb6.toString();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    String calculateFarwardNickName(String str) {
        User user = this.cellOriginalInfo.getUser();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        boolean z16 = (getFeedCommInfo().showMask & 4) > 0;
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(user.nickName) && !z16) {
            sb5.append(com.qzone.proxy.feedcomponent.util.h.d(user.uin, user.nickName));
        }
        sb5.append(" ");
        sb5.append(str);
        return sb5.toString();
    }

    public String calculateTimeDescription() {
        this.timeLbsStr = com.qzone.proxy.feedcomponent.model.a.b(this);
        String str = getFeedCommInfo().feedskey + "_" + getFeedCommInfo().lastModifyTime + LBS_TIME_TAB;
        this.uniTimeLbsKey = str;
        this.integerUniTimeLbsKey = Integer.valueOf(str.hashCode());
        return this.timeLbsStr;
    }

    public String calculateTimeLbs() {
        this.timeLbsStr = com.qzone.proxy.feedcomponent.model.a.b(this);
        String str = getFeedCommInfo().feedskey + LBS_TIME_TAB;
        this.uniTimeLbsKey = str;
        this.integerUniTimeLbsKey = Integer.valueOf(str.hashCode());
        if (getFeedCommInfo().isBizRecomFamousFeeds()) {
            return getUser().qzoneDesc;
        }
        String str2 = this.timeLbsStr;
        if (str2 != null) {
            StringBuilder sb5 = new StringBuilder(str2);
            if (getLbsInfoV2() != null && !TextUtils.isEmpty(getLbsInfoV2().location)) {
                String lbsJumpInfo = getLbsJumpInfo(getLbsInfoV2());
                com.qzone.proxy.feedcomponent.b.e("xxx", "lbs: " + lbsJumpInfo);
                sb5.append("  ");
                if (TextUtils.isEmpty(lbsJumpInfo)) {
                    lbsJumpInfo = getLbsInfoV2().location;
                }
                sb5.append(lbsJumpInfo);
            } else {
                String str3 = getUser().qzoneDesc;
                if (!TextUtils.isEmpty(str3)) {
                    sb5.append(" ");
                    sb5.append(str3);
                }
            }
            this.timeLbsStr = sb5.toString();
        }
        return this.timeLbsStr;
    }

    public boolean canEngage() {
        return getLocalInfo().canLike && getLocalInfo().canShare && getLocalInfo().canComment;
    }

    public void createTemplateIfNull() {
        if (this.cellTemplate == null) {
            this.cellTemplate = new CellTemplate();
        }
    }

    String divideToStringField() {
        return "\n-----------------------------------------------------\n";
    }

    public CellActiveAdv getActiveAdv() {
        return this.cellActiveAdv;
    }

    public QZoneAdFeedData getAdData() {
        return this.adFeedData;
    }

    public String getAlbumRecType() {
        return getFeedCommInfo().getAlbumRecType();
    }

    public VideoInfo getAllVideoInfo() {
        VideoInfo videoInfo = this.cellVideoInfo;
        if (videoInfo != null) {
            return videoInfo;
        }
        if (getOriginalInfo() == null || getOriginalInfo().cellVideoInfo == null) {
            return null;
        }
        return getOriginalInfo().cellVideoInfo;
    }

    public CellAttitude getAttitude() {
        if (this.cellAttitude == null) {
            this.cellAttitude = new CellAttitude();
        }
        return this.cellAttitude;
    }

    public ArrayList<AudioInfo> getAudioInfo() {
        return this.cellAudioInfo;
    }

    public int getBatchUploadPhotoNum() {
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        if (cellPictureInfo != null) {
            return cellPictureInfo.uploadnum;
        }
        BusinessFeedData businessFeedData = this.cellOriginalInfo;
        if (businessFeedData != null) {
            return businessFeedData.getBatchUploadPhotoNum();
        }
        return 0;
    }

    public String getCanFollowKey() {
        return this.uniCanFollowKey;
    }

    public CellAdvContainerAttach getCellAdvContainerAttach() {
        return this.cellAdvContainerAttach;
    }

    public CellBottomRecomm getCellBottomRecomm() {
        return this.cellBottomRecomm;
    }

    public CellCanvas getCellCanvas() {
        return this.cellCanvas;
    }

    public CellColorfulTail getCellColorfulTail() {
        return this.cellColorfulTail;
    }

    public CellCornerAdv getCellCornerAdv() {
        return this.cellCornerAdv;
    }

    public CellCount getCellCount() {
        return this.cellCount;
    }

    public CellDecorateInfo getCellDecorateInfo() {
        return this.cellDecorateInfo;
    }

    public CellDynamicAlbum getCellDynamicAlbum() {
        return this.cellDynamicAlbum;
    }

    public CellFeedCommInfo getCellFeedCommInfo() {
        return this.cellFeedCommInfo;
    }

    public FeedSkinData getCellFeedSkinInfo() {
        if (this.cellFeedSkinInfo == null) {
            this.cellFeedSkinInfo = new FeedSkinData();
        }
        return this.cellFeedSkinInfo;
    }

    public CellForwardListInfo getCellForwardInfo() {
        return this.cellForwardInfo;
    }

    public CellFrdlikeContainer getCellFrdlikeContainer() {
        return this.cellFrdlikeContainer;
    }

    public CellFriendBirthdayGift getCellFriendBirthdayGift() {
        return this.cellFriendBirthdayGift;
    }

    public CellFunctionGuide getCellFunctionGuide() {
        return this.cellFunctionGuide;
    }

    public CellFunnyTreadSpace getCellFunnyTreadSpace() {
        return this.cellFunnyTreadSpace;
    }

    public CellGuiding getCellGuiding() {
        return this.cellGuiding;
    }

    public CellHighFiveInfo getCellHighFiveInfo() {
        return this.cellHighFiveInfo;
    }

    public CellInterest getCellInterest() {
        return this.cellInterest;
    }

    public CellLBSEvent getCellLBSEvent() {
        return this.cellLBSEvent;
    }

    public CellLive getCellLive() {
        CellLive cellLive = this.cellLive;
        if (cellLive != null) {
            return cellLive;
        }
        if (getOriginalInfo() != null) {
            return getOriginalInfo().cellLive;
        }
        return null;
    }

    public CellLuckyMoney getCellLuckyMoney() {
        return this.cellLuckyMoney;
    }

    public CellPresentInfo getCellPresentInfo() {
        return this.cellPresentInfo;
    }

    public CellQbossPsvAdv getCellQbossPsvAdv() {
        return this.cellQbossPsvAdv;
    }

    public CellRank getCellRank() {
        return this.cellRank;
    }

    public CellRecommFooter getCellRecommFooter() {
        return this.cellRecommFooter;
    }

    public CellRecommendList getCellRecommendList() {
        return this.cellRecommendList;
    }

    public CellRecommendList getCellRecommendListSafe() {
        if (this.cellRecommendList == null) {
            this.cellRecommendList = new CellRecommendList();
        }
        return this.cellRecommendList;
    }

    public CellRedBonus getCellRedBonus() {
        return this.cellRedBonus;
    }

    public CellRedBonus getCellRedBonusSafe() {
        if (this.cellRedBonus == null) {
            this.cellRedBonus = new CellRedBonus();
        }
        return this.cellRedBonus;
    }

    public CellSearch getCellSearch() {
        return this.cellSearch;
    }

    public CellSpecialCare getCellSpecialCare() {
        return this.cellSpecialCare;
    }

    @Deprecated
    public CellSummary getCellSummary() {
        if (this.cellSummary == null) {
            this.cellSummary = new CellSummary();
        }
        return this.cellSummary;
    }

    public CellSummary getCellSummaryV2() {
        return this.cellSummary;
    }

    public CellTheme getCellTheme() {
        return this.cellTheme;
    }

    public CellUserInfo getCellUserInfo() {
        if (this.cellUserInfo == null) {
            this.cellUserInfo = new CellUserInfo();
        }
        return this.cellUserInfo;
    }

    public CellViewMore getCellViewMore() {
        return this.cellViewMore;
    }

    public CellCommentEssence getCommentEssence() {
        return this.cellCommentEssence;
    }

    @Deprecated
    public CellCommentInfo getCommentInfo() {
        if (this.cellCommentInfo == null) {
            this.cellCommentInfo = new CellCommentInfo();
        }
        return this.cellCommentInfo;
    }

    public CellCommentInfo getCommentInfoV2() {
        return this.cellCommentInfo;
    }

    public CellCover getCoverInfo() {
        return this.cellCover;
    }

    public String getDebugInfo() {
        return "appid=" + this.cellFeedCommInfo.appid + "\nsubid=" + this.cellFeedCommInfo.subid + "\nfeedskey=" + this.cellFeedCommInfo.feedskey + "\nugckey=" + this.cellFeedCommInfo.ugckey + "\nclientkey=" + this.cellFeedCommInfo.clientkey + "\nfeedsType=" + this.cellFeedCommInfo.feedsType + "\nrefer=" + this.cellFeedCommInfo.refer + "\nactiontype=" + this.cellFeedCommInfo.actiontype + "\nactiongurl=" + this.cellFeedCommInfo.actionurl + "\noriginaltype=" + this.cellFeedCommInfo.actiontype + "\ncurlikekey=" + this.cellFeedCommInfo.curlikekey + "\norglikekey=" + this.cellFeedCommInfo.orglikekey + "\nshowMask=" + this.cellFeedCommInfo.showMask + "\nisFollowed=" + this.cellFeedCommInfo.isFollowed + "\nisHotFeedsFetched=" + this.cellFeedCommInfo.isHotFeedsFetched + "\nisOperationFeed=" + this.cellFeedCommInfo.isOperationFeed() + "\nisBlogSetTop=" + this.cellFeedCommInfo.isBlogSetTop() + "\nisAppAdvFeed=" + this.cellFeedCommInfo.isAppAdvFeed() + "\nisFamousRecommAdvFeed=" + this.cellFeedCommInfo.isFamousRecommAdvFeed() + "\nisFamousSpaceRecommFeed=" + this.cellFeedCommInfo.isFamousSpaceRecommFeed() + "\nisHotRecommFeeds=" + this.cellFeedCommInfo.isHotRecommFeeds() + "\nisQbossAdvFeeds=" + this.cellFeedCommInfo.isQbossAdvFeeds() + "feedsid=" + this.cellFeedCommInfo.feedsid + "\n";
    }

    public ArrayList<Object> getDetailContent() {
        return this.cellDetailContent;
    }

    @Deprecated
    public CellDiss getDissInfo() {
        if (this.cellDiss == null) {
            this.cellDiss = new CellDiss();
        }
        return this.cellDiss;
    }

    public CellDiss getDissInfoV2() {
        return this.cellDiss;
    }

    public boolean getExpArg(int i3) {
        return getFeedCommInfoV2() != null && getFeedCommInfoV2().getExpArg(i3);
    }

    public String getFamousKey() {
        return this.uniFamousKey;
    }

    public CellFeedCommInfo getFeedCommInfo() {
        if (this.cellFeedCommInfo == null) {
            this.cellFeedCommInfo = new CellFeedCommInfo();
        }
        return this.cellFeedCommInfo;
    }

    public CellFeedCommInfo getFeedCommInfoV2() {
        return this.cellFeedCommInfo;
    }

    public FeedPictureInfo[] getFeedPics(int i3) {
        if (this.photoMode != i3) {
            com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().calculatePic(this);
        }
        return this.pics;
    }

    public String getFeedTypeStr() {
        Map<Integer, String> map;
        CellOperationInfo cellOperationInfo = this.cellOperationInfo;
        if (cellOperationInfo == null || (map = cellOperationInfo.cookie) == null) {
            return null;
        }
        return map.get(0);
    }

    public Map<Integer, String> getFirstSubFeedCookie() {
        ArrayList<BusinessFeedData> arrayList = this.recBusinessFeedDatas;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        return this.recBusinessFeedDatas.get(0).getOperationInfo().cookie;
    }

    public CellGiftInfo getGiftInfo() {
        return this.cellGiftInfo;
    }

    public CellGoods getGoods() {
        return this.cellGoods;
    }

    public CellHeader getHeader() {
        return this.cellHeader;
    }

    public long getHostUin() {
        User user = getUser();
        if (user != null) {
            return user.uin;
        }
        return 0L;
    }

    public CellIdInfo getIdInfo() {
        if (this.cellIdInfo == null) {
            this.cellIdInfo = new CellIdInfo();
        }
        return this.cellIdInfo;
    }

    public Integer getIntegerTimeDelKey() {
        return Integer.valueOf(getTimeDelKey() == null ? -1 : getTimeDelKey().hashCode());
    }

    public Integer getIntegerTimeLbsKey() {
        return this.integerUniTimeLbsKey;
    }

    public CellInterestingMessageEmotion getInterestingMessageEmotion() {
        return this.cellInterestingMessageEmotion;
    }

    public boolean getIsNew() {
        return this.isNew;
    }

    public boolean getIsRead() {
        return this.isRead;
    }

    @Deprecated
    public CellLbsInfo getLbsInfo() {
        if (this.cellLbsInfo == null) {
            this.cellLbsInfo = new CellLbsInfo();
        }
        return this.cellLbsInfo;
    }

    public CellLbsInfo getLbsInfoV2() {
        return this.cellLbsInfo;
    }

    public CellLeftThumb getLeftThumb() {
        return this.cellLeftThumb;
    }

    @Deprecated
    public CellLikeInfo getLikeInfo() {
        if (this.cellLikeInfo == null) {
            this.cellLikeInfo = new CellLikeInfo();
        }
        return this.cellLikeInfo;
    }

    public CellLikeInfo getLikeInfoV2() {
        return this.cellLikeInfo;
    }

    public String getLivemedalKey() {
        return this.uniLiveMedalKey;
    }

    @Deprecated
    public CellLocalInfo getLocalInfo() {
        if (this.cellLocalInfo == null) {
            this.cellLocalInfo = new CellLocalInfo();
        }
        return this.cellLocalInfo;
    }

    public CellLocalInfo getLocalInfoV2() {
        return this.cellLocalInfo;
    }

    public CellPictureInfo getLongPicsCellPictureInfo() {
        return this.LongPicsCellPictureInfo;
    }

    public String getLoverZoneKey() {
        return this.uniLoverZoneKey;
    }

    public Comment getMainComment() {
        Comment comment;
        CellCommentInfo cellCommentInfo;
        Comment comment2;
        BusinessFeedData businessFeedData = this.cellOriginalInfo;
        if (businessFeedData != null && (cellCommentInfo = businessFeedData.cellCommentInfo) != null && (comment2 = cellCommentInfo.mainComment) != null) {
            return comment2;
        }
        CellCommentInfo cellCommentInfo2 = this.cellCommentInfo;
        if (cellCommentInfo2 == null || (comment = cellCommentInfo2.mainComment) == null) {
            return null;
        }
        return comment;
    }

    public int getMixVideoIndex() {
        return this.mixVideoIndex;
    }

    public MusicInfo getMusicInfo() {
        return this.cellMusicInfo;
    }

    public String getNickNameKey() {
        return this.uniNickNameKey;
    }

    public long getNocoId() {
        String valueFromCurrencyPassField = getValueFromCurrencyPassField("noco_id");
        if (!TextUtils.isEmpty(valueFromCurrencyPassField)) {
            try {
                return Long.parseLong(valueFromCurrencyPassField);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return -1L;
    }

    @Deprecated
    public CellOperationInfo getOperationInfo() {
        if (this.cellOperationInfo == null) {
            this.cellOperationInfo = new CellOperationInfo();
        }
        return this.cellOperationInfo;
    }

    public CellOperationInfo getOperationInfoV2() {
        return this.cellOperationInfo;
    }

    public BusinessFeedData getOriginalInfo() {
        return this.cellOriginalInfo;
    }

    public BusinessFeedData getOriginalInfoSafe() {
        if (this.cellOriginalInfo == null) {
            this.cellOriginalInfo = new BusinessFeedData();
        }
        return this.cellOriginalInfo;
    }

    public int getParentAdvContainerCount() {
        ArrayList<BusinessFeedData> arrayList;
        BusinessFeedData businessFeedData = this.parentFeedData;
        if (businessFeedData == null || (arrayList = businessFeedData.recBusinessFeedDatas) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Deprecated
    public CellPermissionInfo getPermissionInfo() {
        if (this.cellPermissionInfo == null) {
            this.cellPermissionInfo = new CellPermissionInfo();
        }
        return this.cellPermissionInfo;
    }

    public CellPermissionInfo getPermissionInfoV2() {
        return this.cellPermissionInfo;
    }

    public CellPicTextInfo getPicTextInfo() {
        return this.cellPicTextInfo;
    }

    public CellPictureInfo getPictureInfo() {
        return this.cellPictureInfo;
    }

    public VideoPlayInfo getPreCalVideoPlayInfo(int i3) {
        VideoPlayInfo videoPlayInfo = this.mPreCalVideoPlayInfo;
        if (videoPlayInfo != null && i3 >= 0) {
            videoPlayInfo.coverMaxWidth = i3;
        }
        return videoPlayInfo;
    }

    public String getReComKey() {
        return this.uniRecomKey;
    }

    public ArrayList<BusinessFeedData> getRecBusinessFeedDatas() {
        return this.recBusinessFeedDatas;
    }

    public CellRecommAction getRecommAction() {
        return this.cellRecommAction;
    }

    public CellRecommHeader getRecommHeader() {
        return this.cellRecommHeader;
    }

    public CellRecommItem getRecommItem() {
        return this.cellRecommItem;
    }

    public int getRecommendPageIndex() {
        return this.recommendPageIndex;
    }

    public String getRecommendReportUUID() {
        return this.mRecommendReportUUID;
    }

    @Deprecated
    public CellReferInfo getReferInfo() {
        if (this.cellReferInfo == null) {
            this.cellReferInfo = new CellReferInfo();
        }
        return this.cellReferInfo;
    }

    public CellReferInfo getReferInfoV2() {
        return this.cellReferInfo;
    }

    @Deprecated
    public CellRemarkInfo getRemarkInfo() {
        if (this.cellRemarkInfo == null) {
            this.cellRemarkInfo = new CellRemarkInfo();
        }
        return this.cellRemarkInfo;
    }

    public CellRemarkInfo getRemarkInfoV2() {
        return this.cellRemarkInfo;
    }

    public List<Integer> getSecretFeedLpReserves() {
        ArrayList arrayList = new ArrayList();
        if (getPictureInfo() != null && getPictureInfo().pics != null && getPictureInfo().pics.size() != 0) {
            arrayList.add(3);
        }
        if (getAudioInfo() != null && getAudioInfo().size() != 0) {
            arrayList.add(2);
        }
        if (arrayList.size() == 0) {
            arrayList.add(1);
        }
        return arrayList;
    }

    public CellSeparator getSeparatorInfo() {
        return this.cellSeparator;
    }

    public String getShootAddr() {
        String str;
        CellRemarkInfo cellRemarkInfo = this.cellRemarkInfo;
        if (cellRemarkInfo != null && cellRemarkInfo.shoot_info != null && TextUtils.isEmpty(this.mShootAddr)) {
            long j3 = this.cellRemarkInfo.shoot_info.shoot_time;
            if (j3 > 0) {
                str = "\u62cd\u6444\u4e8e" + com.qzone.proxy.feedcomponent.util.c.b(j3) + " ";
            } else {
                str = "";
            }
            this.mShootAddr = str + this.cellRemarkInfo.shoot_info.shoot_location;
        }
        return this.mShootAddr;
    }

    public int getSinglePicAdvStyle() {
        if (isAdFeeds() && getFeedCommInfo() != null) {
            if (getFeedCommInfo().isVideoAdv()) {
                if (getRecommAction() != null && getRecommAction().isHideActionArea == 0 && canEngage()) {
                    return 4;
                }
            } else if (canEngage()) {
                return 4;
            }
        }
        return -1;
    }

    public String getStandaloneIconKey() {
        return this.uniStandaloneKey;
    }

    public String getStarVipKey() {
        return this.uniStarVipKey;
    }

    public CellTemplate getTemplate() {
        return this.cellTemplate;
    }

    public String getTimeDelKey() {
        if (getFeedCommInfo() == null) {
            return null;
        }
        return getFeedCommInfo().feedskey + TIME_DEL_TAB + this.containerIndex;
    }

    public String getTimeLbsKey() {
        return this.uniTimeLbsKey;
    }

    public String getTimeLbsStr() {
        if (com.qzone.proxy.feedcomponent.model.a.a(this)) {
            calculateTimeDescription();
        }
        return this.timeLbsStr;
    }

    @Deprecated
    public CellTitleInfo getTitleInfo() {
        if (this.cellTitleInfo == null) {
            this.cellTitleInfo = new CellTitleInfo();
        }
        return this.cellTitleInfo;
    }

    public CellTitleInfo getTitleInfoV2() {
        return this.cellTitleInfo;
    }

    public CellUpperBanner getUpperBanner() {
        return this.cellUpperBanner;
    }

    public User getUser() {
        if (this.cellUserInfo == null) {
            this.cellUserInfo = new CellUserInfo();
        }
        return this.cellUserInfo.getUser();
    }

    public String getUserDisKey() {
        return this.uniUserdisKey;
    }

    public String getValueFromCurrencyPassField(String str) {
        if (getRecommAction() != null && !TextUtils.isEmpty(getRecommAction().currency_pass_field)) {
            try {
                JSONObject jSONObject = new JSONObject(getRecommAction().currency_pass_field);
                if (jSONObject.has(str)) {
                    return jSONObject.optString(str);
                }
                return "";
            } catch (Exception e16) {
                e16.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public List<String> getValueFromCurrencyPassFieldArralist(String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (getRecommAction() != null && !TextUtils.isEmpty(getRecommAction().currency_pass_field)) {
            try {
                JSONObject jSONObject = new JSONObject(getRecommAction().currency_pass_field);
                if (jSONObject.has(str) && (optJSONArray = jSONObject.optJSONArray(str)) != null && optJSONArray.length() > 0) {
                    arrayList.clear();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        arrayList.add(optJSONArray.getString(i3));
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return arrayList;
    }

    public VideoInfo getVideoInfo() {
        return this.cellVideoInfo;
    }

    public boolean getVideoRecommAutoPlay() {
        return this.isVideoRecommAutoPlay;
    }

    public Map<Integer, String> getVideoRecommendBuisParamMap() {
        return this.videoRecommendBuisParamMap;
    }

    public ArrayList<VideoRecommendInfo> getVideoRecommendInfo() {
        return this.videoRecommendInfos;
    }

    public CellVisitorInfo getVisitorInfo() {
        return this.cellVisitorInfo;
    }

    public String getYellowVipKey() {
        return this.uniYellowVipKey;
    }

    public boolean hasCustomDropList() {
        ArrayList<s_droplist_option> arrayList;
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return (cellFeedCommInfo == null || (arrayList = cellFeedCommInfo.customDroplist) == null || arrayList.size() <= 0) ? false : true;
    }

    public boolean isAdFeeds() {
        if (this.isAdFeeds == -1) {
            CellFeedCommInfo feedCommInfo = getFeedCommInfo();
            this.isAdFeeds = feedCommInfo.isVideoAdv() || feedCommInfo.isAppAdvFeed() || feedCommInfo.isFamousRecommAdvFeed() || feedCommInfo.isVideoAdvShareFeed() || QZoneAdFeedDataExtKt.isLocalAd(this) ? 1 : 0;
        }
        return this.isAdFeeds == 1;
    }

    public boolean isAdTopInDetail() {
        return getFeedCommInfo().getStMapABTest() != null && getFeedCommInfo().getStMapABTest().containsKey(33) && getFeedCommInfo().getStMapABTest().get(33).intValue() == 1;
    }

    public boolean isAdvContainerFirstFeed() {
        return isCardSpecialFollowMoreRecommendContainerFeed() || isFriendBirthdayContainerFeed() || isRecomEventTagFeed();
    }

    public boolean isAdvContainerThreeGridStyle() {
        Map<Integer, Integer> map;
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return cellFeedCommInfo != null && (map = cellFeedCommInfo.stMapABTest) != null && map.containsKey(19) && this.cellFeedCommInfo.stMapABTest.get(19).intValue() == 1;
    }

    public boolean isAdvMicroVideo() {
        return getVideoInfo() != null && getVideoInfo().videoShowType == 1;
    }

    public boolean isAlbumRecFeed() {
        return getFeedCommInfo().isAlbumRec();
    }

    public boolean isAppAd() {
        return "app".equalsIgnoreCase(getFeedTypeStr());
    }

    public boolean isAppShareCardFeed() {
        return (getFeedCommInfo().feedsAttr2 & 134217728) != 0;
    }

    public boolean isAttach() {
        return this.cellAdvContainerAttach != null;
    }

    public boolean isBabyAlbumFeed() {
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        if (cellPictureInfo != null) {
            return cellPictureInfo.isBabyAlbumData();
        }
        BusinessFeedData businessFeedData = this.cellOriginalInfo;
        if (businessFeedData != null) {
            return businessFeedData.isBabyAlbumFeed();
        }
        return false;
    }

    public boolean isBalconyFeed() {
        return getFeedCommInfo().extendInfo != null && TextUtils.equals("1", getFeedCommInfo().extendInfo.get("Is_Balcony_feeds"));
    }

    public boolean isBirthdayCardFeed() {
        CellGuiding cellGuiding = this.cellGuiding;
        return cellGuiding != null && cellGuiding.guiding_type == 16;
    }

    public boolean isBlogFeed() {
        CellFeedCommInfo cellFeedCommInfo;
        return ef.b.i(this) && (cellFeedCommInfo = this.cellFeedCommInfo) != null && cellFeedCommInfo.appid == 2;
    }

    public boolean isCampusHomeShareFeed() {
        CellShareCard cellShareCard = this.cellShareCard;
        return cellShareCard != null && cellShareCard.type == 4;
    }

    public boolean isCanvasAd() {
        return getCellCanvas() != null;
    }

    public boolean isCardFollowMoreRecommendContainerFeed() {
        return getFeedCommInfo().isBizRecomFeeds() && getFeedCommInfo().isRecomFollowMoreFeed() && getFeedCommInfo().recom_show_type == 1;
    }

    public boolean isCardFollowMoreRecommendVerticalFeed() {
        return getFeedCommInfo().isBizRecomFeeds() && getFeedCommInfo().isRecomFollowMoreFeed() && getFeedCommInfo().recom_show_type == 2;
    }

    public boolean isCardFriendsRecommendContainerFeed() {
        return getFeedCommInfo().isBizRecomFeeds() && getFeedCommInfo().isRecommendFriendsFeed() && getFeedCommInfo().recom_show_type == 1;
    }

    public boolean isCardSchoolRecommendContainerFeed() {
        return getFeedCommInfo().isBizRecomFeeds() && getFeedCommInfo().isRecommendSchoolFeed() && getFeedCommInfo().recom_show_type == 1;
    }

    public boolean isCardSpecialFollowMoreRecommendContainerFeed() {
        return getFeedCommInfo().isBizRecomFeeds() && getFeedCommInfo().isRecomSpecialFollowMoreFeed() && getFeedCommInfo().recom_show_type == 1;
    }

    public boolean isCardStyleButtonButtom() {
        return isSingleAdvContainerFeed();
    }

    public boolean isCardStyleButtonGlobal() {
        return false;
    }

    public boolean isCellQbossPsvAdv() {
        return this.cellQbossPsvAdv != null;
    }

    public boolean isCircleFriendLikeVideoRecomm() {
        return getFeedCommInfo().feedsAttr3 == 4;
    }

    public boolean isCommentEmpty() {
        CellCommentInfo cellCommentInfo = this.cellCommentInfo;
        return cellCommentInfo == null || cellCommentInfo.commentNum <= 0;
    }

    public boolean isCommentPokeLike() {
        return com.qzone.proxy.feedcomponent.util.i.d(this);
    }

    public boolean isCornerAdv() {
        return this.cellCornerAdv != null;
    }

    public boolean isCoupleFeed() {
        return getFeedCommInfo().extendInfo != null && TextUtils.equals("1", getFeedCommInfo().extendInfo.get("is_couple_feed"));
    }

    public boolean isCustomPraiseFeed() {
        CellDecorateInfo cellDecorateInfo;
        CellDecorateInfo.CellCustomPraise cellCustomPraise;
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return (cellFeedCommInfo == null || !cellFeedCommInfo.isCustomPraiseFeed() || (cellDecorateInfo = this.cellDecorateInfo) == null || (cellCustomPraise = cellDecorateInfo.cellCustomPraise) == null || cellCustomPraise.iItemId <= 0) ? false : true;
    }

    public boolean isDanmakuAdv() {
        return false;
    }

    public boolean isDeepLink() {
        CellOperationInfo cellOperationInfo = this.cellOperationInfo;
        return (cellOperationInfo == null || TextUtils.isEmpty(cellOperationInfo.schemaPageUrl)) ? false : true;
    }

    public boolean isDeleteOnTimeFeed() {
        return getFeedCommInfo() != null && getFeedCommInfo().feedsDelTime > 0;
    }

    public boolean isDetailBottomCardAd() {
        return this.feedType == 2 && !(this.cellBottomRecomm == null && this.cellRecommAction == null);
    }

    public boolean isDownloadImmediately() {
        if (isAppAd() && getFeedCommInfo() != null && getFeedCommInfo().getStMapABTest() != null) {
            Map<Integer, Integer> stMapABTest = getFeedCommInfo().getStMapABTest();
            if (stMapABTest.containsKey(15) && stMapABTest.get(15).intValue() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isDynamicAlbumFeed() {
        CellDynamicAlbum cellDynamicAlbum = this.cellDynamicAlbum;
        return cellDynamicAlbum != null && (cellDynamicAlbum.opmask & CellDynamicAlbum.OPMASK) > 0;
    }

    public boolean isEnableLimitChat() {
        return (getFeedCommInfo().feedsAttr2 & 536870912) != 0;
    }

    public boolean isFakeFeed() {
        if (getLocalInfo() == null) {
            return false;
        }
        return getLocalInfo().isFake();
    }

    public boolean isFakeFeedSafe() {
        if (getLocalInfoV2() == null) {
            return false;
        }
        return getLocalInfoV2().isFakeSafe();
    }

    public boolean isFakeMemorySealFeed() {
        return this.mIsFakeMemorySealFeed;
    }

    public boolean isFakeRedPocketFeed() {
        return this.fakeRedPocketFeed;
    }

    public boolean isFeedCommentInsertImage() {
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return (cellFeedCommInfo == null || (cellFeedCommInfo.operatemask & 262144) == 0) ? false : true;
    }

    public boolean isFeedCommentRapidCommentInBox() {
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        if (cellFeedCommInfo != null) {
            return cellFeedCommInfo.isFeedCommentRapidCommentInBox();
        }
        return false;
    }

    public boolean isFirstVideoInFeeds() {
        return this.mIsFirstVideoInFeeds;
    }

    public boolean isFollowGuideFeed() {
        return this.cellFollowGuide != null;
    }

    public boolean isForwardBlogFeed() {
        return isForwardFeed() && getOriginalInfo() != null && getOriginalInfo().isBlogFeed();
    }

    public boolean isForwardFeed() {
        return this.isForwardFeedData;
    }

    public boolean isFrdLikeMiniAppContainer() {
        return this.containerSubType == 8 || this.parentContainerSubType == 8;
    }

    public boolean isFrdLikeMiniAppJumpDirect() {
        Map<Integer, Integer> map;
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return cellFeedCommInfo != null && (map = cellFeedCommInfo.stMapABTest) != null && map.containsKey(31) && this.cellFeedCommInfo.stMapABTest.get(31).intValue() == 1;
    }

    public boolean isFrdLikeVideoContainer() {
        return this.containerSubType == 4;
    }

    public boolean isFriendAnniversaryFeed() {
        CellGuiding cellGuiding;
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        if (cellFeedCommInfo == null || !cellFeedCommInfo.isGuideFeed() || (cellGuiding = this.cellGuiding) == null) {
            return false;
        }
        int i3 = cellGuiding.guiding_type;
        return i3 == 3 || i3 == 5;
    }

    public boolean isFriendBirthdayContainerFeed() {
        ArrayList<BusinessFeedData> arrayList;
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        if (cellFeedCommInfo != null && cellFeedCommInfo.recomtype == 11) {
            return true;
        }
        if (this.containerSubType != 0 || (arrayList = this.recBusinessFeedDatas) == null || arrayList.size() <= 0) {
            return false;
        }
        return this.recBusinessFeedDatas.get(0).isFriendBirthdayGift();
    }

    public boolean isFriendBirthdayGift() {
        ArrayList<FriendBirthdayGift> arrayList;
        CellFriendBirthdayGift cellFriendBirthdayGift = this.cellFriendBirthdayGift;
        return (cellFriendBirthdayGift == null || (arrayList = cellFriendBirthdayGift.gifts) == null || arrayList.size() <= 0) ? false : true;
    }

    public boolean isFriendFeed() {
        Map<String, String> map;
        CellFeedCommInfo feedCommInfo = getFeedCommInfo();
        if (feedCommInfo == null || (map = feedCommInfo.extendInfo) == null) {
            return false;
        }
        return "func_like_brand".equals(map.get("_func_type"));
    }

    public boolean isFriendFeedReadLineFeed() {
        return (getFeedCommInfo().feedsAttr3 & 16) != 0;
    }

    public boolean isFriendLikeContainer() {
        return this.containerSubType == 2;
    }

    public boolean isFriendLikeVerticalSlideContainer() {
        return this.containerSubType == 6;
    }

    public boolean isFriendPlayingFeed() {
        Map<String, String> map;
        return (getFeedCommInfo().extendInfo == null || (map = this.cellFeedCommInfo.extendInfo) == null || !TextUtils.equals(map.get("frd_togeter_type"), "3")) ? false : true;
    }

    public boolean isFriendPlayingFeedV2() {
        Map<String, String> map;
        return (getFeedCommInfo().extendInfo == null || (map = this.cellFeedCommInfo.extendInfo) == null || !TextUtils.equals(map.get("is_new_mini_game_container"), "1")) ? false : true;
    }

    public boolean isFriendPlayingRecomm() {
        return this.mIsFriendPlayingRecomm;
    }

    public boolean isFriendTogetherFeeds() {
        return (getFeedCommInfo().feedsAttr & 8388608) != 0;
    }

    public boolean isFriendVideoCoverFeed() {
        return getFeedCommInfo().extendInfo != null && TextUtils.equals("1", getFeedCommInfo().extendInfo.get("Is_cover_video_feeds"));
    }

    public boolean isFriendVideoFeed() {
        return this.containerSubType == 3;
    }

    public boolean isFunctionGuideFeed() {
        CellGuiding cellGuiding;
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        if (cellFeedCommInfo == null || !cellFeedCommInfo.isGuideFeed() || (cellGuiding = this.cellGuiding) == null) {
            return false;
        }
        int i3 = cellGuiding.guiding_type;
        return i3 == 1 || i3 == 4;
    }

    public boolean isGDTAdvFeed() {
        CellFeedCommInfo feedCommInfoV2 = getFeedCommInfoV2();
        return feedCommInfoV2 != null && feedCommInfoV2.isGDTAdvFeed();
    }

    public boolean isGameRecommendFeed() {
        k kVar = this.cellGameRecommend;
        return (kVar == null || kVar.f50335a == 0) ? false : true;
    }

    public boolean isHandBlog() {
        return getFeedCommInfo().extendInfo != null && "1".equals(getFeedCommInfo().extendInfo.get("blog_hand"));
    }

    public boolean isHasHighFive() {
        int i3;
        CellHighFiveInfo cellHighFiveInfo = this.cellHighFiveInfo;
        return (cellHighFiveInfo == null || (i3 = cellHighFiveInfo.itemId) == -1 || i3 == 0) ? false : true;
    }

    public boolean isHideSecretComment() {
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return (cellFeedCommInfo == null || (cellFeedCommInfo.operatemask & 268435456) == 0) ? false : true;
    }

    public boolean isIndividualAlbumData() {
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        if (cellPictureInfo != null) {
            return cellPictureInfo.isIndividualAlbumData();
        }
        BusinessFeedData businessFeedData = this.cellOriginalInfo;
        if (businessFeedData != null) {
            return businessFeedData.isIndividualAlbumData();
        }
        return false;
    }

    public boolean isInterestMessageFeeds() {
        return (getFeedCommInfo().feedsAttr & 16777216) != 0;
    }

    public boolean isLBSEventFeed() {
        return this.cellLBSEvent != null;
    }

    public boolean isLeftImageH5ShareFeed() {
        CellLeftThumb cellLeftThumb = this.cellLeftThumb;
        return (cellLeftThumb == null || cellLeftThumb.getPictureInfo() == null || this.cellLeftThumb.getParseTitle() == null || this.cellLeftThumb.getParseSummary() == null) ? false : true;
    }

    public boolean isLeftImageRightTextShareFeed() {
        return isLeftImageH5ShareFeed() || isReprintedTextBlogFeed();
    }

    public boolean isLiveVideoFeed() {
        return (this.cellLive == null && (getOriginalInfo() == null || getOriginalInfo().cellLive == null)) ? false : true;
    }

    public boolean isLongPicsBrowsingModeFeed() {
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return cellFeedCommInfo != null && cellFeedCommInfo.isLongPicsBrowsingMode();
    }

    public boolean isLoverAlbumData() {
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        if (cellPictureInfo != null) {
            return cellPictureInfo.isLoverAlbumData();
        }
        BusinessFeedData businessFeedData = this.cellOriginalInfo;
        if (businessFeedData != null) {
            return businessFeedData.isLoverAlbumData();
        }
        return false;
    }

    public boolean isLoverZonePassiveFeed() {
        if (this.feedType != 4098 || getFeedCommInfo() == null) {
            return false;
        }
        String str = getFeedCommInfo().actionurl;
        return !TextUtils.isEmpty(str) && str.startsWith(QzoneConfig.SCHEME_FOR_SWEET_MAIN_PAGE_JUMP);
    }

    public boolean isMixFake1() {
        return this.isMixFake1;
    }

    public boolean isMixFake2() {
        return this.isMixFake2;
    }

    public boolean isMixFakeFeed() {
        return this.isMixFake1 || this.isMixFake2;
    }

    public boolean isMixVideoPic() {
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        if (cellPictureInfo != null && cellPictureInfo.pics != null) {
            return cellPictureInfo.isVideoPicMix();
        }
        if (getOriginalInfo() == null || getOriginalInfo().getPictureInfo() == null || getOriginalInfo().getPictureInfo().pics == null) {
            return false;
        }
        return getOriginalInfo().getPictureInfo().isVideoPicMix();
    }

    public boolean isMixVideoTranscoding(int i3) {
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        return (cellPictureInfo == null || !cellPictureInfo.isVideoPicMix() || this.cellPictureInfo.pics.get(i3) == null || this.cellPictureInfo.pics.get(i3).videodata == null || this.cellPictureInfo.pics.get(i3).videodata.videoStatus != 1) ? false : true;
    }

    public boolean isMsgFeed() {
        return this.mIsMsgFeed;
    }

    public boolean isMultiAdvContainerFeed() {
        return (this.containerSubType == 0 && this.recBusinessFeedDatas != null && (getFeedCommInfo().isBizRecomFamousFeeds() || !getFeedCommInfo().isBizRecomFeeds())) || isRecommendLiveShowContainerFeed();
    }

    public boolean isMultiAlbumData() {
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        if (cellPictureInfo != null) {
            return cellPictureInfo.isMultiAlbumData();
        }
        BusinessFeedData businessFeedData = this.cellOriginalInfo;
        if (businessFeedData != null) {
            return businessFeedData.isMultiAlbumData();
        }
        return false;
    }

    public boolean isMyMediaCardAdvFeed() {
        CellFeedCommInfo feedCommInfo = getFeedCommInfo();
        return feedCommInfo != null && feedCommInfo.isMyMediaCardAdFeed();
    }

    public boolean isNeedShowRapidForwardLayout() {
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return cellFeedCommInfo != null && cellFeedCommInfo.isNeedShowRapidForwordLayout();
    }

    public boolean isNeedShowSearchNoResultTip() {
        return (!this.needShowSearchNoResultTip || this.searchClickCalendar == null || this.searchRealCalendar == null) ? false : true;
    }

    public boolean isNegativeFeedback() {
        return this.isNegativeFeedback;
    }

    public boolean isNewAdvStyle() {
        return false;
    }

    public boolean isNewGuideFeed() {
        CellGuiding cellGuiding = this.cellGuiding;
        if (cellGuiding == null) {
            return false;
        }
        int i3 = cellGuiding.guiding_type;
        if (i3 != 11) {
            return i3 >= 1000 && i3 <= 2000;
        }
        return true;
    }

    public boolean isNewHandBlogFeed() {
        return getFeedCommInfo().extendInfo != null && "1".equals(getFeedCommInfo().extendInfo.get("feeds_blog_hand"));
    }

    public boolean isNewTailStyle() {
        return getCellBottomRecomm().tail_style == 1;
    }

    public boolean isNewUserJoinFeed() {
        int i3;
        CellGuiding cellGuiding = this.cellGuiding;
        return cellGuiding != null && (i3 = cellGuiding.guiding_type) >= 11 && i3 <= 2000;
    }

    public boolean isPYMKFeed() {
        ArrayList<BusinessFeedData> arrayList;
        return getFeedCommInfo() != null && getFeedCommInfo().isBizRecomFeeds() && getFeedCommInfo().isRecommendFriendsFeed() && (arrayList = this.recBusinessFeedDatas) != null && arrayList.size() > 0;
    }

    public boolean isParticipate() {
        return this.isParticipate;
    }

    public boolean isPetPraiseFeed() {
        CellDecorateInfo.CellCustomPraise cellCustomPraise;
        CellDecorateInfo cellDecorateInfo = this.cellDecorateInfo;
        return (cellDecorateInfo == null || (cellCustomPraise = cellDecorateInfo.cellCustomPraise) == null || cellCustomPraise.subType != 1) ? false : true;
    }

    public boolean isPlayBarFeeds() {
        return (getFeedCommInfo().feedsAttr & 16384) != 0;
    }

    public boolean isPublicAccountContainer() {
        Map<String, String> map;
        CellFeedCommInfo feedCommInfo = getFeedCommInfo();
        if (feedCommInfo == null || (map = feedCommInfo.extendInfo) == null) {
            return false;
        }
        return "func_renzheng_puin_container".equals(map.get("_func_type"));
    }

    public boolean isPublicAccountContent() {
        Map<String, String> map;
        CellFeedCommInfo feedCommInfo = getFeedCommInfo();
        if (feedCommInfo == null || (map = feedCommInfo.extendInfo) == null) {
            return false;
        }
        return "func_renzheng_content_recom".equals(map.get("_func_type"));
    }

    public boolean isPublicAccountShare() {
        CellBottomRecomm cellBottomRecomm = getCellBottomRecomm();
        return cellBottomRecomm != null && cellBottomRecomm.anonymity == 26;
    }

    public boolean isQCircleRecommFeed() {
        return getFeedCommInfo().feedsAttr3 == 1 || getFeedCommInfo().feedsAttr3 == 2;
    }

    public boolean isQCircleShareCardFeed() {
        return (getFeedCommInfo().feedsAttr2 & 1073741824) != 0;
    }

    public boolean isQQLiveFeed() {
        CellUniverse cellUniverse = this.cellUniverse;
        return cellUniverse != null && cellUniverse.universeType == 83;
    }

    public boolean isQQNewVip() {
        CellMallInfo.CellQQNewVip cellQQNewVip;
        CellMallInfo cellMallInfo = this.cellMallInfo;
        return (cellMallInfo == null || (cellQQNewVip = cellMallInfo.cellQQNewVip) == null || cellQQNewVip.isShowIcon == 0) ? false : true;
    }

    public boolean isQQUnionVip() {
        CellMallInfo.CellQQUionVip cellQQUionVip;
        CellMallInfo cellMallInfo = this.cellMallInfo;
        return (cellMallInfo == null || (cellQQUionVip = cellMallInfo.cellQQUionVip) == null || cellQQUionVip.iVip == 0) ? false : true;
    }

    public boolean isQQVideoFeeds() {
        return (getFeedCommInfo().feedsAttr3 & 256) != 0;
    }

    public boolean isQzoneCardFeed() {
        return getFeedCommInfo().originaltype == 55 && getOriginalInfo() != null && getOriginalInfo().getUser() != null && getOriginalInfo().getUser().uin > 0;
    }

    public boolean isRecomEventTagFeed() {
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return cellFeedCommInfo != null && cellFeedCommInfo.recomtype == 13;
    }

    public boolean isRecomMyEventTagContainerFeed() {
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return cellFeedCommInfo != null && cellFeedCommInfo.recomtype == 16;
    }

    public boolean isRecommendFeed() {
        return this.mIsRecommendFeed;
    }

    public boolean isRecommendLiveShowContainerFeed() {
        ArrayList<BusinessFeedData> arrayList = this.recBusinessFeedDatas;
        return arrayList != null && arrayList.size() > 0 && getFeedCommInfo().recomtype == 12;
    }

    public boolean isRecommendQQCircleFeed() {
        return (getFeedCommInfo().feedsAttr2 & 268435456) != 0 && this.containerSubType == 9;
    }

    public boolean isReeditFeed() {
        return this.mIsReeditFeed;
    }

    public boolean isRegisterAnniversaryFeed() {
        CellGuiding cellGuiding;
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return cellFeedCommInfo != null && cellFeedCommInfo.isGuideFeed() && (cellGuiding = this.cellGuiding) != null && cellGuiding.guiding_type == 9;
    }

    public boolean isReprintedTextBlogFeed() {
        return isBlogFeed() && getTitleInfoV2() == null;
    }

    public boolean isSecretFeed() {
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return cellFeedCommInfo != null && cellFeedCommInfo.appid == 330;
    }

    public boolean isShuoShuoSingleVideoExcludeForward() {
        VideoInfo videoInfo;
        VideoUrl videoUrl;
        CellFeedCommInfo feedCommInfo = getFeedCommInfo();
        if (feedCommInfo == null || feedCommInfo.appid != 311) {
            return false;
        }
        int i3 = feedCommInfo.bizId;
        return ((i3 != 1 && i3 != 0) || (videoInfo = this.cellVideoInfo) == null || (videoUrl = videoInfo.videoUrl) == null || TextUtils.isEmpty(videoUrl.url)) ? false : true;
    }

    public boolean isSingleAdvContainerFeed() {
        return (this.containerSubType != 1 || this.recBusinessFeedDatas == null || isAdvContainerThreeGridStyle()) ? false : true;
    }

    public boolean isSingleAdvContainerNewStyle() {
        return isCardStyleButtonButtom();
    }

    public boolean isSingleCardStyle() {
        CellRecommAction cellRecommAction;
        return isAdFeeds() && (cellRecommAction = this.cellRecommAction) != null && cellRecommAction.isHideActionArea == 0 && this.recBusinessFeedDatas == null && !this.isSubFeed;
    }

    public boolean isSoftFakeFeed() {
        if (getLocalInfoV2() == null) {
            return false;
        }
        return getLocalInfoV2().isSoftFake();
    }

    public boolean isSoundIconEnabled() {
        return QZoneAdFeedDataExtKt.isGdt585AdVideo(this) || com.qzone.adapter.feedcomponent.i.H().S("QZoneSetting", "ShowVideoSoundIcon", 1) >= 1;
    }

    public boolean isSpecialCareInContainerFeed() {
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return (cellFeedCommInfo == null || cellFeedCommInfo.recomtype != 6 || this.cellSpecialCare == null) ? false : true;
    }

    public boolean isSquareCardStyle() {
        return isSquarePicStyle();
    }

    boolean isSquarePicStyle() {
        CellFeedCommInfo cellFeedCommInfo;
        Map<Integer, Integer> map;
        return isSubOfSingleAdvContainerFeed() && (cellFeedCommInfo = this.cellFeedCommInfo) != null && (map = cellFeedCommInfo.stMapABTest) != null && map.containsKey(2) && this.cellFeedCommInfo.stMapABTest.get(2).intValue() == 1;
    }

    public boolean isSubOfFriendBirthdayContainerFeed() {
        return this.isSubFeed && this.parentFeedData != null && isFriendBirthdayGift();
    }

    public boolean isSubOfMultiAdvContainerFeed() {
        BusinessFeedData businessFeedData;
        return this.isSubFeed && (businessFeedData = this.parentFeedData) != null && businessFeedData.isMultiAdvContainerFeed();
    }

    public boolean isSubOfSingleAdvContainerFeed() {
        BusinessFeedData businessFeedData;
        return (this.isSubFeed && (businessFeedData = this.parentFeedData) != null && businessFeedData.isSingleAdvContainerFeed()) || (this.isSubFeed && this.parentContainerSubType == 1);
    }

    public boolean isSubOfSingleAdvContainerNewStyle() {
        BusinessFeedData businessFeedData;
        return this.isSubFeed && (((businessFeedData = this.parentFeedData) != null && businessFeedData.isSingleAdvContainerNewStyle()) || this.parentContainerSubType == 1);
    }

    public boolean isSupportSoundPlayOut() {
        if (isGDTAdvFeed() && !QZoneAdFeedDataExtKt.isGdt585AdVideo(this)) {
            Map<Integer, Integer> stMapABTest = getFeedCommInfo().getStMapABTest();
            return stMapABTest.containsKey(29) && stMapABTest.get(29).intValue() == 1;
        }
        return isSoundIconEnabled();
    }

    public boolean isTemplateShuoshuo() {
        ArrayList<PictureItem> arrayList;
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        return (cellPictureInfo == null || (arrayList = cellPictureInfo.pics) == null || arrayList.size() <= 0 || TextUtils.isEmpty(this.cellPictureInfo.pics.get(0).audio_summary)) ? false : true;
    }

    public boolean isThemeAlbumFeed() {
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        if (cellPictureInfo != null) {
            return cellPictureInfo.isThemeAlbumData();
        }
        BusinessFeedData businessFeedData = this.cellOriginalInfo;
        if (businessFeedData != null) {
            return businessFeedData.isThemeAlbumFeed();
        }
        return false;
    }

    public boolean isThirdLiveVideoFeed() {
        return getVideoInfo() != null && getVideoInfo().videoSource == 10;
    }

    public boolean isThreeGridStyle() {
        FeedPictureInfo[] feedPictureInfoArr = this.pics;
        if (feedPictureInfoArr == null || feedPictureInfoArr.length != 3) {
            return false;
        }
        return (getFeedCommInfo().getStMapABTest() != null && getFeedCommInfo().getStMapABTest().containsKey(30) && getFeedCommInfo().getStMapABTest().get(30).intValue() == 1) ? false : true;
    }

    public boolean isTimelineEmptyFeed() {
        return this.mIsTimelineEmptyFeed;
    }

    public boolean isTravelAlbumFeed() {
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        if (cellPictureInfo != null) {
            return cellPictureInfo.isTravelAlbumData();
        }
        BusinessFeedData businessFeedData = this.cellOriginalInfo;
        if (businessFeedData != null) {
            return businessFeedData.isTravelAlbumFeed();
        }
        return false;
    }

    public boolean isUGC() {
        return getValueFromCurrencyPassField("feeds_page_type") != "2";
    }

    public boolean isVideo() {
        BusinessFeedData businessFeedData;
        VideoInfo videoInfo;
        VideoUrl videoUrl;
        VideoUrl videoUrl2;
        VideoInfo videoInfo2 = this.cellVideoInfo;
        return ((videoInfo2 == null || (videoUrl2 = videoInfo2.videoUrl) == null || TextUtils.isEmpty(videoUrl2.url)) && ((businessFeedData = this.cellOriginalInfo) == null || (videoInfo = businessFeedData.cellVideoInfo) == null || (videoUrl = videoInfo.videoUrl) == null || TextUtils.isEmpty(videoUrl.url))) ? false : true;
    }

    public boolean isVideoInVideoPicMix(int i3) {
        ArrayList<PictureItem> arrayList;
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        return cellPictureInfo != null && (arrayList = cellPictureInfo.pics) != null && i3 <= Math.min(arrayList.size(), 9) - 1 && i3 >= 0 && this.cellPictureInfo.isVideoPicMix() && this.cellPictureInfo.pics.get(i3).videoflag == 1;
    }

    public boolean isWindowAd() {
        return getCellBottomRecomm() != null && getCellBottomRecomm().iReportFlag == 8 && getCellBottomRecomm().anonymity == CellBottomRecomm.TYPE_ADV;
    }

    public void mergeData(l lVar, Map<Integer, byte[]> map) {
        cell_original cell_originalVar;
        cell_audio cell_audioVar;
        cell_forward cell_forwardVar;
        cell_share cell_shareVar;
        int i3;
        int i16;
        CellDIYData create;
        ye.g gVar = ye.g.f450213a;
        if (gVar.f()) {
            gVar.g(this, lVar, map);
            return;
        }
        logInfo("mergeData", true);
        this.hasCalculate = false;
        if (isContainsCellKey(map, 0)) {
            this.cellFeedCommInfo = CellFeedCommInfo.create(lVar);
            this.cellLocalInfo = CellLocalInfo.create(lVar);
            if (this.cellFeedCommInfo != null) {
                logInfo("merge cell_comm --> time:" + this.cellFeedCommInfo.getTime() + " |opmask:" + this.cellFeedCommInfo.operatemask + ",positionmask:" + this.cellFeedCommInfo.positionmask, false);
            } else {
                logInfo("merge cell_comm --> cellFeedCommInfo is empty", true);
            }
        }
        if (isContainsCellKey(map, 1)) {
            if (lVar != null && lVar.f50342b != null) {
                this.cellUserInfo = CellUserInfo.createWithLocalInfo(this.cellUserInfo, lVar);
            }
            if (this.cellUserInfo != null) {
                logInfo("merge userinfo --> nickName:" + getUser().nickName, false);
            } else {
                logInfo("merge userinfo --> userinfo is empty", true);
            }
        }
        if (isContainsCellKey(map, 67)) {
            CellUserInfo cellUserInfo = this.cellUserInfo;
            if (cellUserInfo != null) {
                com.qzone.proxy.feedcomponent.util.e.c(lVar, cellUserInfo.getUser());
            }
            FeedSkinData feedSkinData = this.cellFeedSkinInfo;
            if (feedSkinData != null) {
                feedSkinData.update(lVar);
            } else {
                this.cellFeedSkinInfo = FeedSkinData.create(lVar);
            }
            CellFeedSignature cellFeedSignature = this.cellFeedSignature;
            if (cellFeedSignature != null) {
                cellFeedSignature.update(lVar);
            } else {
                this.cellFeedSignature = CellFeedSignature.create(lVar);
            }
            CellUserInfo cellUserInfo2 = this.cellUserInfo;
            if (cellUserInfo2 != null && cellUserInfo2.getUser() != null && (create = CellDIYData.create(lVar, this.owner_uin)) != null) {
                this.cellDIYData = create;
            }
        }
        if (isContainsCellKey(map, 2)) {
            this.cellIdInfo = CellIdInfo.create(lVar);
        }
        if (isContainsCellKey(map, 3)) {
            CellTitleInfo create2 = CellTitleInfo.create(lVar);
            this.cellTitleInfo = create2;
            if (create2 != null) {
                logInfo("merge titleInfo --> title:" + this.cellTitleInfo.title, false);
            } else {
                logInfo("merge titleInfo --> titleInfo is empty", true);
            }
        }
        if (isContainsCellKey(map, 4)) {
            CellSummary create3 = CellSummary.create(lVar);
            this.cellSummary = create3;
            if (create3 != null) {
                logInfo("merge cell_summary --> summary:" + this.cellSummary.summary, false);
            } else {
                logInfo("merge cell_summary --> cellSummary is empty", true);
            }
        }
        if (isContainsCellKey(map, 5)) {
            CellPictureInfo create4 = CellPictureInfo.create(lVar);
            this.cellPictureInfo = create4;
            if (create4 != null) {
                ArrayList<PictureItem> arrayList = create4.pics;
                logInfo("merge cell_pic --> picSize:" + (arrayList == null ? 0 : arrayList.size()), false);
            } else {
                logInfo("merge cell_pic --> cellPictureInfo is empty", true);
            }
        }
        if (isContainsCellKey(map, 30)) {
            this.cellPicTextInfo = CellPicTextInfo.create(lVar);
        }
        if (isContainsCellKey(map, 6)) {
            this.cellMusicInfo = com.qzone.proxy.feedcomponent.util.e.j(lVar != null ? lVar.f50354h : null);
        }
        if (isContainsCellKey(map, 19)) {
            this.cellGiftInfo = CellGiftInfo.create(lVar);
        }
        if (isContainsCellKey(map, 7)) {
            this.cellVideoInfo = com.qzone.proxy.feedcomponent.util.e.s(lVar != null ? lVar.f50356i : null);
        }
        if (isContainsCellKey(map, 8)) {
            this.cellLbsInfo = CellLbsInfo.create(lVar);
        }
        if (isContainsCellKey(map, 24)) {
            this.cellPermissionInfo = CellPermissionInfo.create(lVar);
        }
        if (isContainsCellKey(map, 9)) {
            this.cellRemarkInfo = CellRemarkInfo.create(lVar);
        }
        if (isContainsCellKey(map, 10)) {
            CellCommentInfo create5 = CellCommentInfo.create(lVar);
            this.cellCommentInfo = create5;
            if (create5 != null) {
                i16 = create5.commentNum;
                ArrayList<Comment> arrayList2 = create5.commments;
                i3 = arrayList2 != null ? arrayList2.size() : 0;
            } else {
                i3 = 0;
                i16 = 0;
            }
            com.qzone.proxy.feedcomponent.b.i(TAG, "Merge Feed Comment num:" + i16 + " commentRealCount:" + i3 + " ugcKey:" + getFeedCommInfo().ugckey);
        }
        if (isContainsCellKey(map, 11)) {
            this.cellLikeInfo = CellLikeInfo.create(lVar);
        }
        if (isContainsCellKey(map, 12) && lVar != null && (cell_shareVar = lVar.f50366n) != null) {
            this.shareNum = cell_shareVar.num;
        }
        if (isContainsCellKey(map, 13) && lVar != null && (cell_forwardVar = lVar.f50368o) != null) {
            this.forwardNum = cell_forwardVar.num;
        }
        if (isContainsCellKey(map, 18)) {
            this.cellOperationInfo = CellOperationInfo.create(lVar);
        }
        if (isContainsCellKey(map, 20)) {
            this.cellVisitorInfo = CellVisitorInfo.create(lVar);
        }
        if (isContainsCellKey(map, 21)) {
            this.cellAudioInfo = new ArrayList<>();
            if (lVar != null && (cell_audioVar = lVar.f50384w) != null && cell_audioVar.audio != null) {
                for (int i17 = 0; i17 < lVar.f50384w.audio.size(); i17++) {
                    this.cellAudioInfo.add(com.qzone.proxy.feedcomponent.util.e.d(lVar.f50384w.audio.get(i17)));
                }
            }
        }
        if (isContainsCellKey(map, 22)) {
            this.cellReferInfo = CellReferInfo.create(lVar);
        }
        if (isContainsCellKey(map, 15) && lVar != null) {
            this.cellDetailContent = com.qzone.proxy.feedcomponent.util.e.f(lVar.f50372q);
        }
        if (isContainsCellKey(map, 23)) {
            if (lVar != null) {
                this.cellLeftThumb = com.qzone.proxy.feedcomponent.util.e.i(lVar.f50390z, this.feedType == 4098);
            }
            CellLeftThumb cellLeftThumb = this.cellLeftThumb;
            if (cellLeftThumb != null) {
                logInfo("merge cell_left_thumb --> summary:" + cellLeftThumb.getSummary() + " |title:" + cellLeftThumb.getTitle() + "| actionType:" + cellLeftThumb.getActionType() + "| actionUrl:" + cellLeftThumb.getActionUrl() + "| mediaType:" + cellLeftThumb.getMediaType(), false);
            } else {
                logInfo("merge cell_left_thumb --> cellLeftThumb is empty", true);
            }
        }
        if (isContainsCellKey(map, 23) && lVar != null) {
            this.cellQbossPsvAdv = com.qzone.proxy.feedcomponent.util.e.o(lVar.A);
        }
        if (isContainsCellKey(map, 25) && lVar != null) {
            this.cellRecommHeader = CellRecommHeader.create(lVar);
        }
        if (isContainsCellKey(map, 26) && lVar != null) {
            this.cellRecommAction = CellRecommAction.create(lVar);
        }
        if (isContainsCellKey(map, 27) && lVar != null) {
            this.cellTemplate = CellTemplate.create(lVar);
        }
        if (isContainsCellKey(map, 28) && lVar != null) {
            this.cellHeader = CellHeader.create(lVar);
        }
        if (isContainsCellKey(map, 29) && lVar != null) {
            this.cellCover = CellCover.create(lVar);
        }
        if (isContainsCellKey(map, 39) && lVar != null) {
            this.cellDynamicAlbum = CellDynamicAlbum.create(lVar);
        }
        if (isContainsCellKey(map, 33) && lVar != null) {
            this.cellSeparator = CellSeparator.create(lVar);
        }
        if (isContainsCellKey(map, 35) && lVar != null) {
            this.cellTheme = CellTheme.create(lVar);
        }
        if (isContainsCellKey(map, 31) && lVar != null) {
            this.cellGoods = CellGoods.create(lVar);
        }
        if (isContainsCellKey(map, 32) && lVar != null) {
            this.cellSearch = CellSearch.create(lVar);
        }
        if (isContainsCellKey(map, 42) && lVar != null) {
            this.cellSpecialCare = CellSpecialCare.create(lVar);
        }
        if (isContainsCellKey(map, 43) && lVar != null) {
            this.cellRecommFooter = CellRecommFooter.create(lVar);
        }
        if (isContainsCellKey(map, 14)) {
            this.isOriginalEmpty = false;
            if (this.cellOriginalInfo == null) {
                this.cellOriginalInfo = new BusinessFeedData();
            }
            logInfo("merge original data", true);
            if (lVar != null && (cell_originalVar = lVar.f50370p) != null) {
                Map<Integer, byte[]> map2 = cell_originalVar.original_data;
                this.cellOriginalInfo.mergeData(new l(map2), map2);
            }
            this.isForwardFeedData = true;
            this.cellOriginalInfo.isForwardFeedData = true;
        }
        if (isTravelAlbumFeed() && getLbsInfoV2() != null) {
            getLbsInfoV2().showlbs = false;
        }
        if (isContainsCellKey(map, 36) && lVar != null) {
            this.cellInterest = CellInterest.create(lVar);
        }
        if (isContainsCellKey(map, 56) && lVar != null) {
            this.cellLuckyMoney = CellLuckyMoney.create(lVar);
        }
        if (isContainsCellKey(map, 48) && lVar != null) {
            this.cellLBSEvent = CellLBSEvent.create(lVar);
        }
        if (isContainsCellKey(map, 51) && lVar != null) {
            this.cellLive = CellLive.create(lVar);
        }
        if (isDynamicAlbumFeed() && getOriginalInfo() != null) {
            getOriginalInfo().setCellDynamicAlbum(getCellDynamicAlbum());
        }
        if (isContainsCellKey(map, 36) && lVar != null) {
            this.cellInterest = CellInterest.create(lVar);
        }
        if (isContainsCellKey(map, 52) && lVar != null) {
            CellUserInfo cellUserInfo3 = this.cellUserInfo;
            this.cellRedBonus = CellRedBonus.create(lVar, cellUserInfo3 != null ? cellUserInfo3.getUser() : null);
        }
        if (isContainsCellKey(map, 53)) {
            this.cellAdvContainerAttach = CellAdvContainerAttach.create(lVar);
        }
        if (isContainsCellKey(map, 45) && lVar != null) {
            this.cellFriendBirthdayGift = CellFriendBirthdayGift.create(lVar);
        }
        if (isContainsCellKey(map, 53)) {
            this.cellAdvContainerAttach = CellAdvContainerAttach.create(lVar);
        }
        if (isContainsCellKey(map, 68)) {
            this.cellCornerAdv = CellCornerAdv.create(lVar);
        }
        if (isContainsCellKey(map, 55)) {
            this.cellViewMore = CellViewMore.create(lVar);
        }
        if (isContainsCellKey(map, 57)) {
            this.cellDecorateInfo = CellDecorateInfo.create(lVar);
        }
        if (isContainsCellKey(map, 54)) {
            this.cellGuiding = CellGuiding.create(lVar);
        }
        if (isContainsCellKey(map, 59)) {
            this.cellBottomRecomm = CellBottomRecomm.create(lVar);
        }
        if (isContainsCellKey(map, 60)) {
            this.cellFrdlikeContainer = CellFrdlikeContainer.create(lVar);
        }
        if (isContainsCellKey(map, 58)) {
            this.cellCanvas = CellCanvas.create(lVar);
        }
        if (isContainsCellKey(map, 62)) {
            this.cellForwardInfo = CellForwardListInfo.create(lVar);
        }
        if (isContainsCellKey(map, 63)) {
            this.cellFollowGuide = CellFollowGuide.create(lVar);
        }
        if (isContainsCellKey(map, 64)) {
            this.cellRecomTag = b.a(lVar);
        }
        if (isContainsCellKey(map, 66)) {
            this.cellNegativeFeedback = CellNegativeFeedback.create(lVar);
        }
        if (isContainsCellKey(map, 70)) {
            this.cellShareCard = CellShareCard.create(lVar);
        }
        if (isContainsCellKey(map, 73)) {
            this.cellPresentInfo = CellPresentInfo.createFrom(lVar);
        }
        if (this.cellShareCard != null && this.cellLeftThumb != null) {
            this.cellLeftThumb = null;
        }
        if (isContainsCellKey(map, 72)) {
            this.cellAlbumEntrance = CellAlbumEntrance.create(lVar);
        }
        if (isContainsCellKey(map, 57) || isContainsCellKey(map, 67)) {
            this.cellHighFiveInfo = this.cellHighFiveInfo.updateData(lVar);
        }
        if (isContainsCellKey(map, 79) && lVar != null) {
            CellFunnyTreadSpace create6 = CellFunnyTreadSpace.create(lVar);
            CellDecorateInfo cellDecorateInfo = this.cellDecorateInfo;
            this.cellFunnyTreadSpace = CellFunnyTreadSpace.mergeWithCustomTrack(create6, cellDecorateInfo != null ? cellDecorateInfo.customTrackDeco : null);
        }
        if (isContainsCellKey(map, 72)) {
            this.cellAlbumEntrance = CellAlbumEntrance.create(lVar);
        }
        this.cellFeedSkinInfo = mergeNewCardData(this.cellDecorateInfo, this.cellFeedSkinInfo, this.cellUserInfo);
        if (isContainsCellKey(map, 80)) {
            this.cellMallInfo = CellMallInfo.merge(lVar, this.cellMallInfo, getHostUin() + "");
        }
        if (isContainsCellKey(map, 81)) {
            this.cellRecommendList = CellRecommendList.create(lVar);
        }
        if (isContainsCellKey(map, 82)) {
            CellUniverse create7 = CellUniverse.create(lVar);
            this.cellUniverse = create7;
            this.cellGameRecommend = com.qzone.reborn.feedx.presenter.friendplaying.e.d(create7);
        }
        if (isContainsCellKey(map, 83)) {
            this.cellPokeLike = CellPokeLike.create(lVar);
        }
        if (isContainsCellKey(map, 85) && lVar != null) {
            this.cellColorfulTail = CellColorfulTail.create(lVar.A0);
        }
        if (isContainsCellKey(map, 86)) {
            this.cellToast = CellToast.create(lVar);
        }
        mergeGiftData(this.cellDecorateInfo, this.cellPictureInfo);
        mergeHighFiveData(this.cellSummary, this.cellHighFiveInfo);
    }

    public void mergeFeedData(single_feed single_feedVar) {
        Map<Integer, byte[]> map = single_feedVar.singlefeed;
        l lVar = new l(map);
        lVar.P = single_feedVar.feedskey;
        this.feedInfo = single_feedVar.feed_info;
        mergeData(lVar, map);
    }

    public boolean needCalculateFeedView() {
        return false;
    }

    public boolean needPreloadOfflienPkg() {
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        return (cellFeedCommInfo == null || cellFeedCommInfo.getStMapABTest() == null || this.cellFeedCommInfo.getStMapABTest().get(23) == null || this.cellFeedCommInfo.getStMapABTest().get(23).intValue() != 1) ? false : true;
    }

    public boolean needSaveToDb() {
        return this.cellLuckyMoney == null;
    }

    public boolean needShowForwardTitle() {
        if (getOriginalInfo() == null) {
            return false;
        }
        return (getOriginalInfo().getCellSummaryV2() != null || getOriginalInfo().getVideoInfo() != null || getOriginalInfo().getLeftThumb() != null || getOriginalInfo().getPictureInfo() != null) && getOriginalInfo().getFeedCommInfo().isNeedFollowBtn() && !isQzoneCardFeed() && !(getLeftThumb() != null);
    }

    public void preCalculate() {
        preCalculate(true);
    }

    public void setAudioInfo(ArrayList<AudioInfo> arrayList) {
        this.cellAudioInfo = arrayList;
    }

    public void setCanFollowIconKey(int i3) {
        this.uniCanFollowKey = getFeedCommInfo().feedskey + i3 + CALLFOLLOW_MEDAL_TAB + this.containerIndex;
    }

    public void setCellBottomRecomm(CellBottomRecomm cellBottomRecomm) {
        this.cellBottomRecomm = cellBottomRecomm;
    }

    public void setCellCommentInfo(CellCommentInfo cellCommentInfo) {
        this.cellCommentInfo = cellCommentInfo;
    }

    public void setCellCornerAdv(CellCornerAdv cellCornerAdv) {
        this.cellCornerAdv = cellCornerAdv;
    }

    public void setCellDynamicAlbum(CellDynamicAlbum cellDynamicAlbum) {
        this.cellDynamicAlbum = cellDynamicAlbum;
    }

    public void setCellFeedCommInfo(CellFeedCommInfo cellFeedCommInfo) {
        this.cellFeedCommInfo = cellFeedCommInfo;
    }

    public void setCellFrdlikeContainer(CellFrdlikeContainer cellFrdlikeContainer) {
        this.cellFrdlikeContainer = cellFrdlikeContainer;
    }

    public void setCellGuiding(CellGuiding cellGuiding) {
        this.cellGuiding = cellGuiding;
    }

    public void setCellIdInfo(CellIdInfo cellIdInfo) {
        this.cellIdInfo = cellIdInfo;
    }

    public void setCellLbsInfo(CellLbsInfo cellLbsInfo) {
        this.cellLbsInfo = cellLbsInfo;
    }

    public void setCellLikeInfo(CellLikeInfo cellLikeInfo) {
        this.cellLikeInfo = cellLikeInfo;
    }

    public void setCellLocalInfo(CellLocalInfo cellLocalInfo) {
        this.cellLocalInfo = cellLocalInfo;
    }

    public void setCellLuckyMoney(CellLuckyMoney cellLuckyMoney) {
        this.cellLuckyMoney = cellLuckyMoney;
    }

    public void setCellMediaInfo(CellMediaInfo cellMediaInfo) {
        this.cellMediaInfo = cellMediaInfo;
    }

    public void setCellOperationInfo(CellOperationInfo cellOperationInfo) {
        this.cellOperationInfo = cellOperationInfo;
    }

    public void setCellPermissionInfo(CellPermissionInfo cellPermissionInfo) {
        this.cellPermissionInfo = cellPermissionInfo;
    }

    public void setCellPictureInfo(CellPictureInfo cellPictureInfo) {
        this.cellPictureInfo = cellPictureInfo;
    }

    public void setCellPresentInfo(CellPresentInfo cellPresentInfo) {
        this.cellPresentInfo = cellPresentInfo;
    }

    public void setCellRecommAction(CellRecommAction cellRecommAction) {
        this.cellRecommAction = cellRecommAction;
    }

    public void setCellSummary(CellSummary cellSummary) {
        this.cellSummary = cellSummary;
    }

    public void setCellTitleInfo(CellTitleInfo cellTitleInfo) {
        this.cellTitleInfo = cellTitleInfo;
    }

    public void setCellUserInfo(CellUserInfo cellUserInfo) {
        this.cellUserInfo = cellUserInfo;
    }

    public void setCellidInfo(CellIdInfo cellIdInfo) {
        this.cellIdInfo = cellIdInfo;
    }

    public void setCommInfo(CellFeedCommInfo cellFeedCommInfo) {
        this.cellFeedCommInfo = cellFeedCommInfo;
    }

    public void setCommentEssence(CellCommentEssence cellCommentEssence) {
        this.cellCommentEssence = cellCommentEssence;
    }

    public void setCommentInfo(CellCommentInfo cellCommentInfo) {
        this.cellCommentInfo = cellCommentInfo;
    }

    public void setCoverInfo(CellCover cellCover) {
        this.cellCover = cellCover;
    }

    public void setDbPriority(int i3) {
        getLocalInfo().dbPriority = i3;
    }

    public void setDetailContent(ArrayList<Object> arrayList) {
        this.cellDetailContent = arrayList;
    }

    public void setFamousKey(int i3) {
        this.uniFamousKey = getFeedCommInfo().feedskey + ContainerUtils.FIELD_DELIMITER + i3 + ContainerUtils.FIELD_DELIMITER + FAMOUS_TAB + ContainerUtils.FIELD_DELIMITER + this.containerIndex;
    }

    public void setFirstVideoInFeeds(boolean z16) {
        this.mIsFirstVideoInFeeds = z16;
    }

    public void setHeader(CellHeader cellHeader) {
        this.cellHeader = cellHeader;
    }

    public void setInterestingMessageEmotion(CellInterestingMessageEmotion cellInterestingMessageEmotion) {
        this.cellInterestingMessageEmotion = cellInterestingMessageEmotion;
    }

    public void setIsFakeMemorySealFeed(boolean z16) {
        this.mIsFakeMemorySealFeed = z16;
    }

    public void setIsMsgFeed(boolean z16) {
        this.mIsMsgFeed = z16;
    }

    public void setIsNew(boolean z16) {
        this.isNew = z16;
    }

    public void setIsRead(boolean z16) {
        this.isRead = z16;
    }

    public void setIsRecommendFeed(boolean z16) {
        this.mIsRecommendFeed = z16;
    }

    public void setIsReeditFeed(boolean z16) {
        this.mIsReeditFeed = z16;
    }

    public void setIsTimelineEmptyFeed(boolean z16) {
        this.mIsTimelineEmptyFeed = z16;
    }

    public void setLeftThumb(CellLeftThumb cellLeftThumb) {
        this.cellLeftThumb = cellLeftThumb;
    }

    public void setLiveMedalKey(int i3) {
        this.uniLiveKey = getFeedCommInfo().feedskey + i3 + LIVEMEDAL_TAB + this.containerIndex;
    }

    public void setLongPicsCellPictureInfo(CellPictureInfo cellPictureInfo) {
        this.LongPicsCellPictureInfo = cellPictureInfo;
    }

    public void setLoverZoneKey(int i3) {
        this.uniLoverZoneKey = getFeedCommInfo().feedskey + ContainerUtils.FIELD_DELIMITER + i3 + ContainerUtils.FIELD_DELIMITER + LOVERZONE_TAB + this.containerIndex;
    }

    public void setMixVideoIndex(int i3) {
        this.mixVideoIndex = i3;
    }

    public void setMyParticipate(boolean z16) {
        this.isParticipate = z16;
    }

    public void setNegativeFeedback(boolean z16) {
        this.isNegativeFeedback = z16;
    }

    public void setNickNameKey(int i3) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getFeedCommInfo().feedskey);
        sb5.append(i3);
        sb5.append("nickname");
        if (this.isSubFeed) {
            str = "_subIndex_" + this.containerIndex;
        } else {
            str = "";
        }
        sb5.append(str);
        this.uniNickNameKey = sb5.toString();
    }

    public void setOriginalInfo(BusinessFeedData businessFeedData) {
        this.cellOriginalInfo = businessFeedData;
    }

    public void setPermissionInfo(CellPermissionInfo cellPermissionInfo) {
        this.cellPermissionInfo = cellPermissionInfo;
    }

    public void setPicTextInfo(CellPicTextInfo cellPicTextInfo) {
        this.cellPicTextInfo = cellPicTextInfo;
    }

    public void setPictureInfo(CellPictureInfo cellPictureInfo) {
        this.cellPictureInfo = cellPictureInfo;
    }

    public void setPreCalVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        this.mPreCalVideoPlayInfo = videoPlayInfo;
    }

    public void setQbossPsvAdv(CellQbossPsvAdv cellQbossPsvAdv) {
        this.cellQbossPsvAdv = cellQbossPsvAdv;
    }

    public void setRecBusinessFeedDatas(ArrayList<BusinessFeedData> arrayList) {
        this.recBusinessFeedDatas = arrayList;
    }

    public void setRecomKey(int i3) {
        this.uniRecomKey = getFeedCommInfo().feedskey + i3 + RECOM_TAB + this.containerIndex;
    }

    public void setRecommHeader(CellRecommHeader cellRecommHeader) {
        this.cellRecommHeader = cellRecommHeader;
    }

    public void setRecommendPageIndex(int i3) {
        this.recommendPageIndex = i3;
    }

    public void setRecommendReportUUID(String str) {
        this.mRecommendReportUUID = str;
    }

    public void setReferInfo(CellReferInfo cellReferInfo) {
        this.cellReferInfo = cellReferInfo;
    }

    public void setRemarkInfo(CellRemarkInfo cellRemarkInfo) {
        this.cellRemarkInfo = cellRemarkInfo;
    }

    public void setStandaloneKey(int i3) {
        this.uniStandaloneKey = getFeedCommInfo().feedskey + i3 + STANDALONE_TAB + this.containerIndex;
    }

    public void setStarVipKey(int i3) {
        this.uniStarVipKey = getFeedCommInfo().feedskey + i3 + STAR_VIP_TAB + this.containerIndex;
    }

    public void setTheme(CellTheme cellTheme) {
        this.cellTheme = cellTheme;
    }

    public void setUser(User user) {
        getCellUserInfo().setUser(user);
    }

    public void setUserdisKey(int i3) {
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append(getFeedCommInfo().feedskey);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append(i3);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append(USERDIS_TAB);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append(this.containerIndex);
        this.uniUserdisKey = sb5.toString();
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.cellVideoInfo = videoInfo;
    }

    public void setVideoRecommAutoPlay(boolean z16) {
        this.isVideoRecommAutoPlay = z16;
    }

    public void setVideoRecommendBuisParamMap(Map<Integer, String> map) {
        this.videoRecommendBuisParamMap = map;
    }

    public void setVideoRecommendInfo(ArrayList<VideoRecommendInfo> arrayList) {
        this.videoRecommendInfos = arrayList;
    }

    public void setVisitorInfo(CellVisitorInfo cellVisitorInfo) {
        this.cellVisitorInfo = cellVisitorInfo;
    }

    public void setYellowVipKey(int i3) {
        this.uniYellowVipKey = getFeedCommInfo().feedskey + i3 + YELLOW_VIP_TAB + this.containerIndex;
    }

    public boolean switchToTangramProtocol() {
        return getFeedCommInfo().getStMapABTest() != null && getFeedCommInfo().getStMapABTest().containsKey(37) && getFeedCommInfo().getStMapABTest().get(37).intValue() == 1;
    }

    public String toString() {
        if (!FeedGlobalEnv.g().isDebug()) {
            return super.toString();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(STORE_KEY);
        sb5.append("\n");
        sb5.append(String.format("Ver %d\n", 139));
        sb5.append(String.format("shareNum %d, ", Integer.valueOf(this.shareNum)));
        sb5.append(String.format("forwardNum %d", Integer.valueOf(this.forwardNum)));
        sb5.append(divideToStringField());
        CellSeparator cellSeparator = this.cellSeparator;
        if (cellSeparator != null) {
            sb5.append(cellSeparator);
            sb5.append(divideToStringField());
        }
        CellTheme cellTheme = this.cellTheme;
        if (cellTheme != null) {
            sb5.append(cellTheme);
            sb5.append(divideToStringField());
        }
        CellFeedCommInfo cellFeedCommInfo = this.cellFeedCommInfo;
        if (cellFeedCommInfo != null) {
            sb5.append(cellFeedCommInfo);
            sb5.append(divideToStringField());
        }
        CellUserInfo cellUserInfo = this.cellUserInfo;
        if (cellUserInfo != null) {
            sb5.append(cellUserInfo);
            sb5.append(divideToStringField());
        }
        CellIdInfo cellIdInfo = this.cellIdInfo;
        if (cellIdInfo != null) {
            sb5.append(cellIdInfo);
            sb5.append(divideToStringField());
        }
        CellTitleInfo cellTitleInfo = this.cellTitleInfo;
        if (cellTitleInfo != null) {
            sb5.append(cellTitleInfo);
            sb5.append(divideToStringField());
        }
        CellSummary cellSummary = this.cellSummary;
        if (cellSummary != null) {
            sb5.append(cellSummary);
            sb5.append(divideToStringField());
        }
        CellPictureInfo cellPictureInfo = this.cellPictureInfo;
        if (cellPictureInfo != null) {
            sb5.append(cellPictureInfo);
            sb5.append(divideToStringField());
        }
        CellPicTextInfo cellPicTextInfo = this.cellPicTextInfo;
        if (cellPicTextInfo != null) {
            sb5.append(cellPicTextInfo);
            sb5.append(divideToStringField());
        }
        MusicInfo musicInfo = this.cellMusicInfo;
        if (musicInfo != null) {
            sb5.append(musicInfo);
            sb5.append(divideToStringField());
        }
        CellGiftInfo cellGiftInfo = this.cellGiftInfo;
        if (cellGiftInfo != null) {
            sb5.append(cellGiftInfo);
            sb5.append(divideToStringField());
        }
        VideoInfo videoInfo = this.cellVideoInfo;
        if (videoInfo != null) {
            sb5.append(videoInfo);
            sb5.append(divideToStringField());
        }
        CellLbsInfo cellLbsInfo = this.cellLbsInfo;
        if (cellLbsInfo != null) {
            sb5.append(cellLbsInfo);
            sb5.append(divideToStringField());
        }
        CellLive cellLive = this.cellLive;
        if (cellLive != null) {
            sb5.append(cellLive);
            sb5.append(divideToStringField());
        }
        CellRemarkInfo cellRemarkInfo = this.cellRemarkInfo;
        if (cellRemarkInfo != null) {
            sb5.append(cellRemarkInfo);
            sb5.append(divideToStringField());
        }
        CellCommentInfo cellCommentInfo = this.cellCommentInfo;
        if (cellCommentInfo != null) {
            sb5.append(cellCommentInfo);
            sb5.append(divideToStringField());
        }
        CellLikeInfo cellLikeInfo = this.cellLikeInfo;
        if (cellLikeInfo != null) {
            sb5.append(cellLikeInfo);
            sb5.append(divideToStringField());
        }
        CellOperationInfo cellOperationInfo = this.cellOperationInfo;
        if (cellOperationInfo != null) {
            sb5.append(cellOperationInfo);
            sb5.append(divideToStringField());
        }
        CellVisitorInfo cellVisitorInfo = this.cellVisitorInfo;
        if (cellVisitorInfo != null) {
            sb5.append(cellVisitorInfo);
            sb5.append(divideToStringField());
        }
        ArrayList<AudioInfo> arrayList = this.cellAudioInfo;
        if (arrayList != null) {
            sb5.append(arrayList);
            sb5.append(divideToStringField());
        }
        CellReferInfo cellReferInfo = this.cellReferInfo;
        if (cellReferInfo != null) {
            sb5.append(cellReferInfo);
            sb5.append(divideToStringField());
        }
        BusinessFeedData businessFeedData = this.cellOriginalInfo;
        if (businessFeedData != null) {
            sb5.append(businessFeedData);
            sb5.append(divideToStringField());
        }
        ArrayList<Object> arrayList2 = this.cellDetailContent;
        if (arrayList2 != null) {
            sb5.append(String.format("cellDetailContent: %s", arrayList2));
            sb5.append(divideToStringField());
        }
        CellLocalInfo cellLocalInfo = this.cellLocalInfo;
        if (cellLocalInfo != null) {
            sb5.append(cellLocalInfo);
            sb5.append(divideToStringField());
        }
        CellPermissionInfo cellPermissionInfo = this.cellPermissionInfo;
        if (cellPermissionInfo != null) {
            sb5.append(cellPermissionInfo);
            sb5.append(divideToStringField());
        }
        CellLeftThumb cellLeftThumb = this.cellLeftThumb;
        if (cellLeftThumb != null) {
            sb5.append(cellLeftThumb);
            sb5.append(divideToStringField());
        }
        CellQbossPsvAdv cellQbossPsvAdv = this.cellQbossPsvAdv;
        if (cellQbossPsvAdv != null) {
            sb5.append(cellQbossPsvAdv);
            sb5.append(divideToStringField());
        }
        CellRecommHeader cellRecommHeader = this.cellRecommHeader;
        if (cellRecommHeader != null) {
            sb5.append(cellRecommHeader);
            sb5.append(divideToStringField());
        }
        CellRecommAction cellRecommAction = this.cellRecommAction;
        if (cellRecommAction != null) {
            sb5.append(cellRecommAction);
            sb5.append(divideToStringField());
        }
        CellTemplate cellTemplate = this.cellTemplate;
        if (cellTemplate != null) {
            sb5.append(cellTemplate);
            sb5.append(divideToStringField());
        }
        CellHeader cellHeader = this.cellHeader;
        if (cellHeader != null) {
            sb5.append(cellHeader);
            sb5.append(divideToStringField());
        }
        CellGoods cellGoods = this.cellGoods;
        if (cellGoods != null) {
            sb5.append(cellGoods);
            sb5.append(divideToStringField());
        }
        CellSpecialCare cellSpecialCare = this.cellSpecialCare;
        if (cellSpecialCare != null) {
            sb5.append(cellSpecialCare);
            sb5.append(divideToStringField());
        }
        CellRecommFooter cellRecommFooter = this.cellRecommFooter;
        if (cellRecommFooter != null) {
            sb5.append(cellRecommFooter);
            sb5.append(divideToStringField());
        }
        CellSearch cellSearch = this.cellSearch;
        if (cellSearch != null) {
            sb5.append(cellSearch);
            sb5.append(divideToStringField());
        }
        CellCover cellCover = this.cellCover;
        if (cellCover != null) {
            sb5.append(cellCover);
            sb5.append(divideToStringField());
        }
        CellDynamicAlbum cellDynamicAlbum = this.cellDynamicAlbum;
        if (cellDynamicAlbum != null) {
            sb5.append(cellDynamicAlbum);
            sb5.append(divideToStringField());
        }
        String str = this.feedInfo;
        if (str != null) {
            sb5.append(String.format("feedInfo: %s", str));
            sb5.append(divideToStringField());
        }
        sb5.append(String.format("hasCalculate: %s", Boolean.valueOf(this.hasCalculate)));
        sb5.append(divideToStringField());
        sb5.append(String.format("isNew: %s", Boolean.valueOf(this.isNew)));
        sb5.append(divideToStringField());
        sb5.append(String.format("isRead: %s", Boolean.valueOf(this.isRead)));
        sb5.append(divideToStringField());
        sb5.append(String.format("feedType: %d", Integer.valueOf(this.feedType)));
        sb5.append(divideToStringField());
        sb5.append(String.format("isParticipate: %s", Boolean.valueOf(this.isParticipate)));
        sb5.append(divideToStringField());
        sb5.append(String.format("owner_uin: %d", Long.valueOf(this.owner_uin)));
        sb5.append(divideToStringField());
        String str2 = this.timeLbsStr;
        if (str2 != null) {
            sb5.append(String.format("timeLbsStr: %s", str2));
            sb5.append(divideToStringField());
        }
        String str3 = this.uniTimeLbsKey;
        if (str3 != null) {
            sb5.append(String.format("uniTimeLbsKey: %s", str3));
            sb5.append(divideToStringField());
        }
        String str4 = this.uniNickNameKey;
        if (str4 != null) {
            sb5.append(String.format("uniNickNameKey: %s", str4));
            sb5.append(divideToStringField());
        }
        FeedPictureInfo[] feedPictureInfoArr = this.pics;
        if (feedPictureInfoArr != null && feedPictureInfoArr.length > 0) {
            sb5.append("FeedPictureInfo[]: \n");
            for (int i3 = 0; i3 < this.pics.length; i3++) {
                sb5.append(" pics[");
                sb5.append(i3);
                sb5.append("]: ");
                sb5.append(this.pics[i3].h().url);
                sb5.append("\n");
            }
            sb5.append(divideToStringField());
        }
        sb5.append(String.format("photoMode: %d", Integer.valueOf(this.photoMode)));
        sb5.append(divideToStringField());
        String str5 = this.feedTitleReadstr;
        if (str5 != null) {
            sb5.append(String.format("feedTitleReadstr: %s", str5));
            sb5.append(divideToStringField());
        }
        String str6 = this.feedContentReadstr;
        if (str6 != null) {
            sb5.append(String.format("feedContentReadstr: %s", str6));
            sb5.append(divideToStringField());
        }
        String str7 = this.feedCommentReadstr;
        if (str7 != null) {
            sb5.append(String.format("feedCommentReadstr: %s", str7));
            sb5.append(divideToStringField());
        }
        String str8 = this.feedLikeReadstr;
        if (str8 != null) {
            sb5.append(String.format("feedLikeReadstr: %s", str8));
            sb5.append(divideToStringField());
        }
        String str9 = this.feedVisitReadstr;
        if (str9 != null) {
            sb5.append(String.format("feedVisitReadstr: %s", str9));
            sb5.append(divideToStringField());
        }
        String str10 = this.feedAttachReadstr;
        if (str10 != null) {
            sb5.append(String.format("feedAttachReadstr: %s", str10));
            sb5.append(divideToStringField());
        }
        String str11 = this.feedLeftThumbReadstr;
        if (str11 != null) {
            sb5.append(String.format("feedLeftThumbReadstr: %s", str11));
            sb5.append(divideToStringField());
        }
        CellRecommendList cellRecommendList = this.cellRecommendList;
        if (cellRecommendList != null) {
            sb5.append(String.format("feedRecommendListStr: %s", cellRecommendList));
            sb5.append(divideToStringField());
        }
        sb5.append("}");
        return sb5.toString();
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("feed_key", getFeedCommInfo().feedskey);
        contentValues.put("client_key", getFeedCommInfo().clientkey);
        contentValues.put(QZoneResult.UGC_KEY, getFeedCommInfo().ugckey);
        contentValues.put("feed_priority", Integer.valueOf(getLocalInfo().dbPriority));
        contentValues.put("feed_publish_date", Long.valueOf(getFeedCommInfo().getTime()));
        contentValues.put("feed_fake_type", Integer.valueOf(getLocalInfo().fakeType));
        contentValues.put(PhotoCacheData.OWNER_UIN, Long.valueOf(this.owner_uin));
        contentValues.put("not_time_sort", Integer.valueOf(getFeedCommInfo().isNotSortTimeFeed() ? 1 : 0));
        long nanoTime = System.nanoTime();
        byte[] packBusinessFeedData = packBusinessFeedData(this);
        contentValues.put("packType", (Integer) 0);
        long nanoTime2 = System.nanoTime();
        if (com.qzone.proxy.feedcomponent.b.g()) {
            com.qzone.proxy.feedcomponent.b.a("AutoPackCompare", "writeTo  ContentValues size:" + packBusinessFeedData.length + ",costTime(ns):" + (nanoTime2 - nanoTime) + ",USE_AUTOPACK:" + com.qzone.adapter.feedcomponent.h.a());
        }
        contentValues.put("feed_data", packBusinessFeedData);
    }

    private byte[] packBusinessFeedData(BusinessFeedData businessFeedData) {
        Parcel parcel;
        try {
            parcel = Parcel.obtain();
        } catch (Throwable th5) {
            th = th5;
            parcel = null;
        }
        try {
            parcel.setDataPosition(0);
            ParcelableWrapper.writeDataToParcel(parcel, 0, this);
            byte[] marshall = parcel.marshall();
            OaidMonitor.parcelRecycle(parcel);
            return marshall;
        } catch (Throwable th6) {
            th = th6;
            try {
                com.qzone.proxy.feedcomponent.b.d("Feed", "writeTo BusinessFeedData exception.", th);
                return null;
            } finally {
                if (parcel != null) {
                    OaidMonitor.parcelRecycle(parcel);
                }
            }
        }
    }

    public String[] getDanmakuContentsSafely() {
        return new String[0];
    }

    public void preCalculate(boolean z16) {
        com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().preCalculateData(this, z16);
        if (com.qzone.adapter.feedcomponent.i.H().S0()) {
            preCalculateReadStr();
        }
    }

    public void setFakeRedPocketFeed(boolean z16) {
        this.fakeRedPocketFeed = true;
    }

    public static void mergeGiftData(CellDecorateInfo cellDecorateInfo, CellPictureInfo cellPictureInfo) {
        CellDecorateInfo.CellGiftData cellGiftData;
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        if (cellDecorateInfo == null || (cellGiftData = cellDecorateInfo.cellGiftData) == null || cellPictureInfo == null) {
            return;
        }
        cellGiftData.actionUrl = cellPictureInfo.actionurl;
        ArrayList<PictureItem> arrayList = cellPictureInfo.pics;
        if (arrayList == null || arrayList.size() != 1 || (pictureItem = cellPictureInfo.pics.get(0)) == null || (pictureUrl = pictureItem.bigUrl) == null) {
            return;
        }
        cellDecorateInfo.cellGiftData.positiveUrl = pictureUrl.url;
    }

    public static FeedSkinData mergeNewCardData(CellDecorateInfo cellDecorateInfo, FeedSkinData feedSkinData, CellUserInfo cellUserInfo) {
        FeedSkinData copy;
        if (cellDecorateInfo == null || (copy = FeedSkinData.copy(cellDecorateInfo.skinData)) == null) {
            return feedSkinData;
        }
        if (feedSkinData != null) {
            copy.customBubbleSkinImageUrl = feedSkinData.customBubbleSkinImageUrl;
            copy.customBubbleSkinUrl = feedSkinData.customBubbleSkinUrl;
            if (cellUserInfo != null && cellUserInfo.getUser() != null) {
                copy.lUin = cellUserInfo.getUser().uin;
            }
        } else {
            com.qzone.proxy.feedcomponent.b.i(TAG, "mergeNewCardData() FeedSkinData is NULL!");
        }
        return copy;
    }

    public boolean isBrandUgcAdvFeeds() {
        return getExpArg(8);
    }

    public boolean isContainsCellKey(Map<Integer, byte[]> map, Integer num) {
        return map != null && map.containsKey(num);
    }

    public boolean isUgcAdvFeeds() {
        return getExpArg(8);
    }

    public void logInfo(String str, boolean z16) {
        if (z16) {
            com.qzone.proxy.feedcomponent.b.e(STORE_KEY, str);
        }
    }

    public void preCalculateReadStr() {
        CellCommentInfo cellCommentInfo;
        User user;
        User user2;
        ArrayList<Comment> arrayList;
        CellTitleInfo titleInfoV2 = getTitleInfoV2();
        CellSummary cellSummaryV2 = getCellSummaryV2();
        CellLeftThumb leftThumb = getLeftThumb();
        CellCommentInfo commentInfoV2 = getCommentInfoV2();
        BusinessFeedData businessFeedData = this.cellOriginalInfo;
        if (businessFeedData != null) {
            if (cellSummaryV2 == null) {
                cellSummaryV2 = businessFeedData.getCellSummaryV2();
            }
            if (commentInfoV2 == null) {
                commentInfoV2 = this.cellOriginalInfo.getCommentInfoV2();
            }
        }
        StringBuilder sb5 = new StringBuilder(128);
        if (getUser() != null && !TextUtils.isEmpty(getUser().nickName)) {
            sb5.append(getUser().nickName);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(getTimeLbsStr())) {
            sb5.append(getTimeLbsStr() + ", ");
        }
        if (titleInfoV2 != null && !TextUtils.isEmpty(titleInfoV2.title)) {
            sb5.append(titleInfoV2.title + ", ");
        }
        this.feedTitleReadstr = sb5.toString();
        int i3 = 0;
        sb5.delete(0, sb5.length());
        if (titleInfoV2 != null && !TextUtils.isEmpty(titleInfoV2.displayTitle)) {
            sb5.append(titleInfoV2.displayTitle);
            sb5.append(", ");
        }
        if (cellSummaryV2 != null && !TextUtils.isEmpty(cellSummaryV2.displayStr)) {
            sb5.append(cellSummaryV2.displayStr);
            sb5.append(", ");
        }
        if (getPictureInfo() != null && !TextUtils.isEmpty(getPictureInfo().displayStr)) {
            sb5.append(getPictureInfo().displayStr);
        }
        StringBuilder n3 = com.qzone.adapter.feedcomponent.i.H().n(sb5);
        this.feedContentReadstr = com.qzone.adapter.feedcomponent.i.H().b(n3.toString());
        n3.delete(0, n3.length());
        if (getLikeInfoV2() != null && !TextUtils.isEmpty(getLikeInfoV2().displayStr)) {
            n3.append(getLikeInfoV2().displayStr.replaceAll("uin:|nickname:|<|>|[1-9][0-9]{5,10}|%[^>]+", ""));
        }
        this.feedLikeReadstr = n3.toString();
        n3.delete(0, n3.length());
        if (getVisitorInfo() != null && !TextUtils.isEmpty(getVisitorInfo().displayStr)) {
            n3.append(getVisitorInfo().displayStr);
        }
        this.feedVisitReadstr = n3.toString();
        n3.delete(0, n3.length());
        int size = (commentInfoV2 == null || (arrayList = commentInfoV2.commments) == null) ? 0 : arrayList.size();
        int i16 = 0;
        while (i16 < size) {
            Comment comment = commentInfoV2.commments.get(i16);
            User user3 = comment.user;
            if (user3 != null && !TextUtils.isEmpty(user3.nickName) && !TextUtils.isEmpty(comment.comment)) {
                n3.append(comment.user.nickName + "\u8bc4\u8bba: " + comment.comment + "; ");
            }
            List<Reply> list = comment.replies;
            if (list != null) {
                int size2 = list.size();
                int i17 = i3;
                while (i17 < size2) {
                    Reply reply = list.get(i17);
                    if (reply == null || (user = reply.user) == null || TextUtils.isEmpty(user.nickName) || (user2 = reply.targetUser) == null || TextUtils.isEmpty(user2.nickName) || TextUtils.isEmpty(reply.content)) {
                        cellCommentInfo = commentInfoV2;
                    } else {
                        StringBuilder sb6 = new StringBuilder();
                        cellCommentInfo = commentInfoV2;
                        sb6.append(reply.user.nickName);
                        sb6.append(" \u56de\u590d  ");
                        sb6.append(reply.targetUser.nickName);
                        sb6.append(MsgSummary.STR_COLON);
                        sb6.append(reply.content);
                        sb6.append("; ");
                        n3.append(sb6.toString());
                    }
                    i17++;
                    commentInfoV2 = cellCommentInfo;
                }
            }
            i16++;
            commentInfoV2 = commentInfoV2;
            i3 = 0;
        }
        this.feedCommentReadstr = com.qzone.adapter.feedcomponent.i.H().E(n3.toString());
        n3.delete(0, n3.length());
        if (getRemarkInfoV2() != null && !TextUtils.isEmpty(getRemarkInfoV2().remark)) {
            String replaceAll = getRemarkInfoV2().remark.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", "");
            if (!TextUtils.isEmpty(replaceAll)) {
                if (replaceAll.indexOf(123) != -1 && replaceAll.indexOf(44) != -1) {
                    n3.append(replaceAll.replace(replaceAll.substring(replaceAll.indexOf(123), replaceAll.indexOf(44)), "").replace("text", "") + ", ");
                } else {
                    n3.append(replaceAll + ", ");
                }
            }
        }
        if (getRemarkInfoV2() != null && !TextUtils.isEmpty(getRemarkInfoV2().getShootInfoString())) {
            n3.append(getRemarkInfoV2().getShootInfoString() + ", ");
        }
        if (getReferInfoV2() != null && !TextUtils.isEmpty(getReferInfoV2().appName)) {
            n3.append("\u6765\u81ea" + getReferInfoV2().appName.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", "") + ", ");
        }
        if (getPermissionInfoV2() != null && !TextUtils.isEmpty(getPermissionInfoV2().status_info)) {
            n3.append(getPermissionInfoV2().status_info + ", ");
        }
        if (getPermissionInfoV2() != null && !TextUtils.isEmpty(getPermissionInfoV2().permission_info)) {
            n3.append(getPermissionInfoV2().permission_info + ", ");
        }
        if (titleInfoV2 != null && !TextUtils.isEmpty(titleInfoV2.likeListStr)) {
            n3.append(titleInfoV2.likeListStr.replaceAll("uin:|nickname:|<|>|[1-9][0-9]{5,10}", ""));
        }
        this.feedAttachReadstr = n3.toString();
        n3.delete(0, n3.length());
        if (leftThumb != null && !TextUtils.isEmpty(leftThumb.getTitle()) && leftThumb.getUser() != null && !TextUtils.isEmpty(leftThumb.getUser().nickName)) {
            n3.append(leftThumb.getUser().nickName + MsgSummary.STR_COLON + leftThumb.getTitle() + ", ");
        }
        if (leftThumb != null && !TextUtils.isEmpty(leftThumb.getSummary()) && leftThumb.getUser() != null && !TextUtils.isEmpty(leftThumb.getUser().nickName)) {
            n3.append(leftThumb.getUser().nickName + MsgSummary.STR_COLON + leftThumb.getSummary());
        }
        this.feedLeftThumbReadstr = com.qzone.adapter.feedcomponent.i.H().b(n3.toString());
        n3.delete(0, n3.length());
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<BusinessFeedData> {
        a() {
        }

        /* JADX WARN: Not initialized variable reg: 2, insn: 0x001b: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:22:0x001b */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private BusinessFeedData a(byte[] bArr) {
            Parcel parcel;
            Parcel parcel2;
            Parcel parcel3 = null;
            try {
                try {
                    parcel = Parcel.obtain();
                } catch (OutOfMemoryError unused) {
                    parcel = null;
                } catch (Error e16) {
                    e = e16;
                    parcel = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (parcel3 != null) {
                    }
                    throw th;
                }
                try {
                    parcel.unmarshall(bArr, 0, bArr.length);
                    parcel.setDataPosition(0);
                    BusinessFeedData businessFeedData = (BusinessFeedData) ParcelableWrapper.createDataFromParcel(parcel);
                    OaidMonitor.parcelRecycle(parcel);
                    return businessFeedData;
                } catch (OutOfMemoryError unused2) {
                    com.qzone.proxy.feedcomponent.b.i(BusinessFeedData.TAG, "BusinessFeedData memory Error");
                    if (parcel != null) {
                        OaidMonitor.parcelRecycle(parcel);
                    }
                    return null;
                } catch (Error e17) {
                    e = e17;
                    com.qzone.proxy.feedcomponent.b.c(BusinessFeedData.TAG, "createFromCursor:" + e.toString());
                    if (parcel != null) {
                        OaidMonitor.parcelRecycle(parcel);
                    }
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
                parcel3 = parcel2;
                if (parcel3 != null) {
                    OaidMonitor.parcelRecycle(parcel3);
                }
                throw th;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BusinessFeedData createFromCursor(Cursor cursor) {
            int columnIndex = cursor.getColumnIndex("feed_data");
            int columnIndex2 = cursor.getColumnIndex("packType");
            if (columnIndex < 0 || columnIndex2 < 0) {
                return null;
            }
            byte[] blob = cursor.getBlob(columnIndex);
            int i3 = cursor.getInt(columnIndex2);
            long nanoTime = System.nanoTime();
            BusinessFeedData a16 = a(blob);
            long nanoTime2 = System.nanoTime();
            if (!com.qzone.proxy.feedcomponent.b.g()) {
                return a16;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("createFromCursor size:");
            sb5.append(blob.length);
            sb5.append(",costTime(ns):");
            sb5.append(nanoTime2 - nanoTime);
            sb5.append(",USE_AUTOPACK:");
            sb5.append(i3 == 1);
            com.qzone.proxy.feedcomponent.b.a("AutoPackCompare", sb5.toString());
            return a16;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return "CREATE INDEX IF NOT EXISTS desc_index_" + str + " ON " + str + " (feed_priority,feed_publish_date)";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return "feed_priority DESC, feed_publish_date DESC";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("feed_key", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("client_key", "TEXT UNIQUE"), new IDBCacheDataWrapper.c(QZoneResult.UGC_KEY, "TEXT"), new IDBCacheDataWrapper.c("feed_priority", "INTEGER"), new IDBCacheDataWrapper.c("feed_publish_date", "INTEGER"), new IDBCacheDataWrapper.c("feed_fake_type", "INTEGER"), new IDBCacheDataWrapper.c(PhotoCacheData.OWNER_UIN, "INTEGER"), new IDBCacheDataWrapper.c("not_time_sort", "INTEGER"), new IDBCacheDataWrapper.c("feed_data", "BLOB"), new IDBCacheDataWrapper.c("packType", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 139;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public int delRawSql(SQLiteDatabase sQLiteDatabase, String str, String str2) {
            String[] split;
            if (sQLiteDatabase == null) {
                return 0;
            }
            if (!TextUtils.isEmpty(str2) && str2.contains(ContainerUtils.KEY_VALUE_DELIMITER) && !str2.contains(" and ") && !str2.contains(" AND ") && !str2.contains(" or ") && !str2.contains(" OR ") && (split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length > 1 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                String trim = split[0].trim();
                String replace = split[1].trim().replace("'", "");
                if (!TextUtils.isEmpty(trim) && !TextUtils.isEmpty(replace)) {
                    return sQLiteDatabase.delete(str, trim + "=? ", new String[]{replace});
                }
            }
            return sQLiteDatabase.delete(str, str2, null);
        }
    }

    String getLbsJumpInfo(CellLbsInfo cellLbsInfo) {
        String str;
        if (cellLbsInfo != null && cellLbsInfo.extendinfo != null && !TextUtils.isEmpty(cellLbsInfo.location)) {
            String str2 = cellLbsInfo.extendinfo.get("jump_type");
            String str3 = cellLbsInfo.extendinfo.get("jump_id");
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                str = null;
            } else {
                str = "https://m.qzone.com/urljump/urljump?jump_type=" + str2 + "&jump_id=" + str3;
            }
            if (!TextUtils.isEmpty(str)) {
                return "{url:" + str + ",text:" + cellLbsInfo.location + "}";
            }
        }
        return null;
    }

    public void setMixFake(int i3) {
        if (i3 == 1) {
            this.isMixFake1 = true;
        } else if (i3 == 2) {
            this.isMixFake2 = true;
        } else {
            this.isMixFake1 = false;
            this.isMixFake2 = false;
        }
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void readFrom(ContentValues contentValues) {
    }

    public static BusinessFeedData createFrom(single_detail single_detailVar) {
        BusinessFeedData businessFeedData = null;
        if (single_detailVar != null) {
            businessFeedData = createFrom(single_detailVar.singledetail, null, null);
            businessFeedData.feedType = 2;
            businessFeedData.containerSubType = single_detailVar.uContainerSubType;
            ArrayList<Map<Integer, byte[]>> arrayList = single_detailVar.recomfeeds;
            if (arrayList != null && !arrayList.isEmpty()) {
                businessFeedData.recBusinessFeedDatas = new ArrayList<>();
                Iterator<Map<Integer, byte[]>> it = single_detailVar.recomfeeds.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    Map<Integer, byte[]> next = it.next();
                    if (next != null && !next.isEmpty()) {
                        BusinessFeedData createFrom = createFrom(next, single_detailVar.feedskey, single_detailVar.feed_info);
                        createFrom.feedType = 2;
                        createFrom.isSubFeed = true;
                        createFrom.containerIndex = i3;
                        createFrom.parentFeedData = businessFeedData;
                        createFrom.parentContainerSubType = single_detailVar.uContainerSubType;
                        createFrom.getFeedCommInfo().isSubOfMultiAdvContainerFeed = createFrom.isSubOfMultiAdvContainerFeed();
                        createFrom.getFeedCommInfo().isSubOfSingleAdvContainerFeed = createFrom.isSubOfSingleAdvContainerFeed();
                        businessFeedData.recBusinessFeedDatas.add(createFrom);
                    }
                    i3++;
                }
            }
        }
        return businessFeedData;
    }

    public static BusinessFeedData createFrom(Map<Integer, byte[]> map) {
        return createFrom(map, null, null);
    }

    static BusinessFeedData createFrom(Map<Integer, byte[]> map, String str, String str2) {
        BusinessFeedData businessFeedData = new BusinessFeedData();
        l lVar = new l(map);
        businessFeedData.feedInfo = str2;
        lVar.P = str;
        fillFeedData(businessFeedData, lVar);
        if (businessFeedData.getFeedCommInfoV2() == null) {
            businessFeedData.getFeedCommInfo().feedskey = str;
        }
        return businessFeedData;
    }
}
