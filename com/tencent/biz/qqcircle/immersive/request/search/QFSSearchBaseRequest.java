package com.tencent.biz.qqcircle.immersive.request.search;

import android.text.TextUtils;
import circlesearch.CircleSearchExhibition$StPromptResp;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import java.util.HashMap;
import ua0.j;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSSearchBaseRequest extends QCircleBaseRequest {
    public static final String EXTRA_KEY_BANNER_COUNT = "bannerCount";
    public static final String EXTRA_KEY_FEED_COUNT = "feedCount";
    public static final String EXTRA_KEY_GUESS_COUNT = "guessCount";
    public static final String EXTRA_KEY_HOT_EVENT_COUNT = "hotEventCount";
    public static final String EXTRA_KEY_IS_GUESS_REFRESH = "isGuessRefresh";
    public static final String EXTRA_KEY_IS_LOAD_MORE = "isLoadMore";
    public static final String EXTRA_KEY_IS_PRELOAD = "isPreload";
    public static final String EXTRA_KEY_IS_TEST_ENVIRONMENT = "isTest";
    public static final String EXTRA_KEY_MIX_PAGE_TAG_INFO_COUNT = "mixPageTagInfoCount";
    public static final String EXTRA_KEY_MIX_PAGE_USER_INFO_COUNT = "mixPageUserInfoCount";
    public static final String EXTRA_KEY_PROMPT_TEXT = "promptText";
    public static final String EXTRA_KEY_QUERY_SOURCE = "querySource";
    public static final String EXTRA_KEY_SEARCH_TYPE = "searchType";
    public static final String EXTRA_KEY_SEARCH_WORD = "word";
    public static final String EXTRA_KEY_TAG_COUNT = "tagCount";
    public static final String EXTRA_KEY_USER_COUNT = "userCount";
    protected HashMap<String, String> extraMap = new HashMap<>();

    private QCircleAlphaUserReportDataBuilder b(long j3, String str) {
        if (getSsoResultCode() != 1000) {
            j3 = getSsoResultCode();
            str = getSsoFailMsg();
        }
        return new QCircleAlphaUserReportDataBuilder().setCmd(get$cmd()).setSvrRetCode(String.valueOf(j3)).setRetCode(getRetCode()).setInfo(getInfo()).setMsg(str).setTimeCost(getNetworkTimeCost()).setUrl(getUrl()).setRate(getRate()).setType(getType()).setRefer(getRefer()).setAttachInfo(getAttachInfo()).setExtraInfo(getTraceId()).setCount(getCount(null)).setState(getState()).setFeedId(getFeedId()).setUser(getUser()).setExtras(getExtras());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(long j3, String str) {
        j.c(b(j3, str), this.extraMap);
    }

    public QFSSearchBaseRequest addReportExtraData(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.extraMap.put(str, str2);
        }
        return this;
    }

    public QFSSearchBaseRequest addSearchPageRspExtraData(FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp, boolean z16, long j3) {
        if (feedCloudRead$StGetSearchPageRsp != null && z16 && j3 == 0) {
            this.extraMap.put(EXTRA_KEY_FEED_COUNT, String.valueOf(feedCloudRead$StGetSearchPageRsp.searchFeedInfo.feedList.get().size()));
            this.extraMap.put(EXTRA_KEY_BANNER_COUNT, String.valueOf(feedCloudRead$StGetSearchPageRsp.bannerInfo.banners.get().size()));
            this.extraMap.put(EXTRA_KEY_USER_COUNT, String.valueOf(feedCloudRead$StGetSearchPageRsp.searchUserInfo.userList.get().size()));
            this.extraMap.put(EXTRA_KEY_HOT_EVENT_COUNT, String.valueOf(feedCloudRead$StGetSearchPageRsp.searchHotEventInfo.feedList.get().size()));
            this.extraMap.put(EXTRA_KEY_TAG_COUNT, String.valueOf(feedCloudRead$StGetSearchPageRsp.searchTagInfo.tagList.get().size()));
            this.extraMap.put(EXTRA_KEY_MIX_PAGE_TAG_INFO_COUNT, String.valueOf(feedCloudRead$StGetSearchPageRsp.mixPageTagInfo.feeds.get().size()));
            this.extraMap.put(EXTRA_KEY_MIX_PAGE_USER_INFO_COUNT, String.valueOf(feedCloudRead$StGetSearchPageRsp.mixPageUserInfo.feeds.get().size()));
        }
        return this;
    }

    public QFSSearchBaseRequest addSearchPromptRspExtraData(CircleSearchExhibition$StPromptResp circleSearchExhibition$StPromptResp, boolean z16, long j3) {
        if (circleSearchExhibition$StPromptResp != null && z16 && j3 == 0) {
            this.extraMap.put(EXTRA_KEY_HOT_EVENT_COUNT, String.valueOf(circleSearchExhibition$StPromptResp.ranking.rankings.get().size()));
            this.extraMap.put(EXTRA_KEY_GUESS_COUNT, String.valueOf(circleSearchExhibition$StPromptResp.guess_prompt.guess_info.get().size()));
            this.extraMap.put(EXTRA_KEY_PROMPT_TEXT, circleSearchExhibition$StPromptResp.shading_prompt.text.get());
        }
        return this;
    }

    public void reportCmdSuccessRate(final long j3, final String str) {
        if (TextUtils.equals(str, VSNetworkHelper.ERROR_CACHE_PREFIX)) {
            return;
        }
        if (!WinkHostConstants.AppSetting.isPublicVersion() && !TextUtils.isEmpty(SSODebugUtil.loadTestEnvironment()[0])) {
            this.extraMap.put(EXTRA_KEY_IS_TEST_ENVIRONMENT, "true");
        }
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.request.search.a
            @Override // java.lang.Runnable
            public final void run() {
                QFSSearchBaseRequest.this.c(j3, str);
            }
        });
    }
}
