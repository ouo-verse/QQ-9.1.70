package com.tencent.mobileqq.guild.feed.launcher;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.guild.feed.presenter.l;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedEntry;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import ij1.h;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedDetailInitBean extends GuildFeedSchemeBean {

    /* renamed from: d, reason: collision with root package name */
    private transient GProStFeed f220050d;
    private int feedType;
    private String joinGuildSig;
    private long lastModifiedTime;
    private AnimationParams mAnimationParams;
    private String mAtId;
    private String mChannelInfoName;
    private String mCommentId;
    private int mCommentNum;
    private String mCommentTransfer;
    private long mCreateTime;
    protected HashMap<String, String> mDiscoverSearchDtParams;
    private String mFeedId;
    private int mFromPage;
    private GuildFeedPublishInfo mGuildFeedPublishInfo;
    private String mInviteCode;
    private boolean mLikeClicked = false;
    private int mLikeNum;
    private String mPageid;
    private int mPosition;
    private String mPosterTinyId;
    private int mPreferNum;
    private int mPreferStatus;
    private String mReplyId;
    private int mShareNum;
    private String mTabid;
    private String mTinyAvatorUrl;
    private String mVisitorTinyId;

    private static GuildFeedDetailInitBean a(GProStFeed gProStFeed, String str, GuildFeedBaseInitBean guildFeedBaseInitBean) {
        GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed = initFeedDetailInitBeanFromFeed(gProStFeed);
        initFeedDetailInitBeanFromFeed.setShareSource(10);
        updateJoinParam(initFeedDetailInitBeanFromFeed, guildFeedBaseInitBean);
        if (initFeedDetailInitBeanFromFeed.mDiscoverSearchDtParams == null) {
            initFeedDetailInitBeanFromFeed.mDiscoverSearchDtParams = new HashMap<>();
        }
        initFeedDetailInitBeanFromFeed.mDiscoverSearchDtParams.put("sp_trace_id", str);
        initFeedDetailInitBeanFromFeed.setJumpExtraInfo(guildFeedBaseInitBean.getJumpExtraInfo());
        QLog.i("GuildFeedDetailInitBean", 2, "initFeedDetailBeanForDiscover traceId=" + str);
        return initFeedDetailInitBeanFromFeed;
    }

    private static GuildFeedDetailInitBean b(GProStFeed gProStFeed, String str, GuildFeedBaseInitBean guildFeedBaseInitBean) {
        GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed = initFeedDetailInitBeanFromFeed(gProStFeed);
        updateJoinParam(initFeedDetailInitBeanFromFeed, guildFeedBaseInitBean);
        initFeedDetailInitBeanFromFeed.setShareSource(guildFeedBaseInitBean.getShareSource());
        return initFeedDetailInitBeanFromFeed;
    }

    private static GuildFeedDetailInitBean c(GProStFeed gProStFeed, GuildFeedBaseInitBean guildFeedBaseInitBean) {
        GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed = initFeedDetailInitBeanFromFeed(gProStFeed);
        initFeedDetailInitBeanFromFeed.setShareSource(guildFeedBaseInitBean.getShareSource());
        if (guildFeedBaseInitBean.getJoinInfoParam() != null && guildFeedBaseInitBean.getJoinInfoParam().isValid()) {
            initFeedDetailInitBeanFromFeed.setJoinInfoParam(guildFeedBaseInitBean.getJoinInfoParam());
        }
        return initFeedDetailInitBeanFromFeed;
    }

    private static GuildFeedDetailInitBean d(GProStFeed gProStFeed, String str, GuildFeedBaseInitBean guildFeedBaseInitBean) {
        GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed = initFeedDetailInitBeanFromFeed(gProStFeed);
        initFeedDetailInitBeanFromFeed.setTroopUin(guildFeedBaseInitBean.getTroopUin());
        initFeedDetailInitBeanFromFeed.setTroopRole(guildFeedBaseInitBean.getTroopRole());
        initFeedDetailInitBeanFromFeed.setBusinessType(guildFeedBaseInitBean.getBusinessType());
        return initFeedDetailInitBeanFromFeed;
    }

    public static GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed(GProStFeed gProStFeed, GuildFeedBaseInitBean guildFeedBaseInitBean, String str) {
        GuildFeedDetailInitBean b16;
        if (com.tencent.mobileqq.guild.feed.util.f.b(guildFeedBaseInitBean.getBusinessType())) {
            b16 = a(gProStFeed, str, guildFeedBaseInitBean);
        } else {
            int businessType = guildFeedBaseInitBean.getBusinessType();
            if (businessType != 3 && businessType != 4) {
                if (businessType != 5) {
                    if (businessType == 7) {
                        b16 = d(gProStFeed, str, guildFeedBaseInitBean);
                    } else if (businessType != 10) {
                        switch (businessType) {
                            case 14:
                            case 15:
                            case 16:
                                break;
                            default:
                                b16 = initFeedDetailInitBeanFromFeed(gProStFeed);
                                if (guildFeedBaseInitBean.getJoinInfoParam() != null && guildFeedBaseInitBean.getJoinInfoParam().isValid()) {
                                    b16.setJoinInfoParam(guildFeedBaseInitBean.getJoinInfoParam());
                                    break;
                                }
                                break;
                        }
                    } else {
                        b16 = a(gProStFeed, str, guildFeedBaseInitBean);
                    }
                }
                b16 = c(gProStFeed, guildFeedBaseInitBean);
            } else {
                b16 = b(gProStFeed, str, guildFeedBaseInitBean);
            }
        }
        b16.setBusinessType(guildFeedBaseInitBean.getBusinessType());
        b16.setImmersiveSource(guildFeedBaseInitBean.getImmersiveSource());
        GuildFeedReportSourceInfo guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
        guildFeedReportSourceInfo.addReportItem("extra_feeds_pre_page_id", l.b(guildFeedBaseInitBean.getBusinessType()));
        guildFeedReportSourceInfo.addReportItem("extra_feeds_pre_page_forum_type", l.a(guildFeedBaseInitBean.getBusinessType()));
        b16.setFeedReportSourceInfo(guildFeedReportSourceInfo);
        return b16;
    }

    public static GuildFeedDetailInitBean initFeedDetailInitBeanFromFeedTop(String str, String str2, h hVar) {
        GuildFeedDetailInitBean guildFeedDetailInitBean = new GuildFeedDetailInitBean();
        guildFeedDetailInitBean.setGuildId(str);
        guildFeedDetailInitBean.setChannelId(str2);
        guildFeedDetailInitBean.setFeedId(hVar.f407814h);
        guildFeedDetailInitBean.setCreateTime(hVar.f407816m);
        guildFeedDetailInitBean.setPosterTinyId(hVar.f407815i);
        guildFeedDetailInitBean.setUserType(com.tencent.mobileqq.guild.feed.report.f.j(guildFeedDetailInitBean.getGuildId()));
        guildFeedDetailInitBean.setVisitorTinyId(((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).accountUin());
        return guildFeedDetailInitBean;
    }

    public static void updateJoinParam(GuildFeedDetailInitBean guildFeedDetailInitBean, GuildFeedBaseInitBean guildFeedBaseInitBean) {
        JumpGuildParam.JoinInfoParam joinInfoParam = guildFeedBaseInitBean.getJoinInfoParam();
        if (joinInfoParam != null) {
            joinInfoParam.setJoinSignature(guildFeedDetailInitBean.getJoinGuildSig());
            if ("profile_card".equals(joinInfoParam.getMainSource())) {
                joinInfoParam.setMainSource("mine");
            }
            if ("channel_profile_card".equals(joinInfoParam.getSubSource())) {
                joinInfoParam.setSubSource("mine_like");
            }
            if (joinInfoParam.isValid()) {
                guildFeedDetailInitBean.setJoinInfoParam(joinInfoParam);
            }
        }
    }

    public GuildFeedDetailPreloadParams covertToPreloadParams() {
        long j3;
        long j16 = 0;
        try {
            j3 = Long.parseLong(getChannelId());
            try {
                j16 = Long.parseLong(getGuildId());
            } catch (Exception e16) {
                e = e16;
                QLog.e("GuildFeedDetailInitBean", 1, "covertToStFeed error!", e);
                return new GuildFeedDetailPreloadParams(j16, j3, getFeedId(), this.mPosterTinyId, getCreateTime(), getLastModifiedTime());
            }
        } catch (Exception e17) {
            e = e17;
            j3 = 0;
        }
        return new GuildFeedDetailPreloadParams(j16, j3, getFeedId(), this.mPosterTinyId, getCreateTime(), getLastModifiedTime());
    }

    public AnimationParams getAnimationParams() {
        return this.mAnimationParams;
    }

    public String getAtId() {
        return this.mAtId;
    }

    public String getChannelInfoName() {
        return this.mChannelInfoName;
    }

    public String getCommentId() {
        return this.mCommentId;
    }

    public int getCommentNum() {
        return this.mCommentNum;
    }

    public String getCommentTransfer() {
        return this.mCommentTransfer;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public HashMap<String, String> getDiscoverSearchDtParams() {
        return this.mDiscoverSearchDtParams;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public int getFeedType() {
        return this.feedType;
    }

    public int getFromPage() {
        return this.mFromPage;
    }

    @Nullable
    public GuildFeedPublishInfo getGuildFeedPublishInfo() {
        return this.mGuildFeedPublishInfo;
    }

    public String getInviteCode() {
        return this.mInviteCode;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public boolean getLikeClicked() {
        return this.mLikeClicked;
    }

    public int getLikeNum() {
        return this.mLikeNum;
    }

    public String getPageid() {
        return this.mPageid;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public String getPosterTinyId() {
        return this.mPosterTinyId;
    }

    public int getPreferNum() {
        return this.mPreferNum;
    }

    public int getPreferStatus() {
        return this.mPreferStatus;
    }

    public String getReplyId() {
        return this.mReplyId;
    }

    public int getShareNum() {
        return this.mShareNum;
    }

    public GProStFeed getStFeed() {
        return this.f220050d;
    }

    public String getTabid() {
        return this.mTabid;
    }

    public String getTinyAvator() {
        return this.mTinyAvatorUrl;
    }

    public String getVisitorTinyId() {
        return this.mVisitorTinyId;
    }

    public void setAnimationParams(AnimationParams animationParams) {
        this.mAnimationParams = animationParams;
    }

    public void setAtId(String str) {
        this.mAtId = str;
    }

    public void setChannelInfoName(String str) {
        this.mChannelInfoName = str;
    }

    public void setCommentId(String str) {
        this.mCommentId = str;
    }

    public void setCommentNum(int i3) {
        this.mCommentNum = i3;
    }

    public void setCommentTransfer(String str) {
        this.mCommentTransfer = str;
    }

    public void setCreateTime(long j3) {
        this.mCreateTime = j3;
    }

    public void setDiscoverSearchDtParams(HashMap<String, String> hashMap) {
        this.mDiscoverSearchDtParams = hashMap;
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }

    public void setFeedType(int i3) {
        this.feedType = i3;
    }

    public void setFromPage(int i3) {
        this.mFromPage = i3;
    }

    public void setGuildFeedPublishInfo(GuildFeedPublishInfo guildFeedPublishInfo) {
        this.mGuildFeedPublishInfo = guildFeedPublishInfo;
    }

    public void setInviteCode(String str) {
        this.mInviteCode = str;
    }

    public void setJoinGuildSig(String str) {
        this.joinGuildSig = str;
    }

    public void setLastModifiedTime(long j3) {
        this.lastModifiedTime = j3;
    }

    public void setLikeClicked(boolean z16) {
        this.mLikeClicked = z16;
    }

    public void setLikeNum(int i3) {
        this.mLikeNum = i3;
    }

    public void setPageid(String str) {
        this.mPageid = str;
    }

    public void setPosition(int i3) {
        this.mPosition = i3;
    }

    public void setPosterTinyId(String str) {
        this.mPosterTinyId = str;
    }

    public void setPreferNum(int i3) {
        this.mPreferNum = i3;
    }

    public void setPreferStatus(int i3) {
        this.mPreferStatus = i3;
    }

    public void setReplyId(String str) {
        this.mReplyId = str;
    }

    public void setShareNum(int i3) {
        this.mShareNum = i3;
    }

    public void setStFeed(GProStFeed gProStFeed) {
        this.f220050d = gProStFeed;
    }

    public void setTabid(String str) {
        this.mTabid = str;
    }

    public void setTinyAvator(String str) {
        this.mTinyAvatorUrl = str;
    }

    public void setVisitorTinyId(String str) {
        this.mVisitorTinyId = str;
    }

    public static GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed(GProStFeed gProStFeed) {
        GuildFeedDetailInitBean guildFeedDetailInitBean = new GuildFeedDetailInitBean();
        guildFeedDetailInitBean.setGuildId(String.valueOf(gProStFeed.channelInfo.sign.guildId));
        if (TextUtils.isEmpty(guildFeedDetailInitBean.getGuildId()) || guildFeedDetailInitBean.getGuildId().equals("0")) {
            guildFeedDetailInitBean.setGuildId(String.valueOf(gProStFeed.share.channelShareInfo.channelSign.guildId));
        }
        guildFeedDetailInitBean.setChannelId(String.valueOf(gProStFeed.channelInfo.sign.channelId));
        if (TextUtils.isEmpty(guildFeedDetailInitBean.getChannelId()) || guildFeedDetailInitBean.getChannelId().equals("0")) {
            guildFeedDetailInitBean.setChannelId(String.valueOf(gProStFeed.share.channelShareInfo.channelSign.channelId));
        }
        guildFeedDetailInitBean.setJoinGuildSig(gProStFeed.channelInfo.sign.joinGuildSig);
        guildFeedDetailInitBean.setFeedId(gProStFeed.idd);
        guildFeedDetailInitBean.setCreateTime(gProStFeed.createTime);
        guildFeedDetailInitBean.setPosterTinyId(gProStFeed.poster.idd);
        guildFeedDetailInitBean.setUserType(com.tencent.mobileqq.guild.feed.report.f.j(guildFeedDetailInitBean.getGuildId()));
        guildFeedDetailInitBean.setVisitorTinyId(((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).accountUin());
        guildFeedDetailInitBean.setLastModifiedTime(gProStFeed.meta.lastModifiedTime);
        guildFeedDetailInitBean.setCommentNum(gProStFeed.commentCount);
        guildFeedDetailInitBean.setFeedType(gProStFeed.feedType);
        guildFeedDetailInitBean.setLikeNum(gProStFeed.totalLike.likeCount);
        guildFeedDetailInitBean.setPreferNum(gProStFeed.totalPrefer.preferCountWithoutLike);
        guildFeedDetailInitBean.setPreferStatus(gProStFeed.totalPrefer.preferStatus);
        guildFeedDetailInitBean.setShareNum(gProStFeed.share.sharedCount);
        Iterator<GProFeedEntry> it = gProStFeed.extInfoList.iterator();
        while (it.hasNext()) {
            GProFeedEntry next = it.next();
            if (next.key.equals("qc-tabid")) {
                guildFeedDetailInitBean.setTabid(next.value);
            } else if (next.key.equals("qc-pageid")) {
                guildFeedDetailInitBean.setPageid(next.value);
            }
        }
        guildFeedDetailInitBean.setChannelInfoName(gProStFeed.channelInfo.name);
        return guildFeedDetailInitBean;
    }
}
