package com.tencent.mobileqq.guild.feed.launcher;

import androidx.annotation.Nullable;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.data.GProStFeedMemoryKeepSerializer;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedGalleryInitBean extends GuildFeedBaseInitBean {
    private static final long serialVersionUID = -7938599264826588327L;
    private int mEnterPos;
    private int mFromPage;
    private GuildFeedPublishInfo mGuildFeedPublishInfo;
    private String mPosterId;
    private List<GuildFeedRichMediaData> mRichMediaDataList;
    private String mSessionId;
    private GProStFeedMemoryKeepSerializer mStFeedWrapper;
    private String mTraceId;
    private GProStFeed mTransStFeed;
    private TransitionBean mTransitionBean;
    private int mTransitionBeanCreatorKey;
    private int openType;
    private String mFeedId = "";
    private String mCommentId = "";
    private String mReplyId = "";
    private boolean showMoreIcon = true;
    private boolean showCloseIcon = true;
    private boolean showEditBtn = false;
    private boolean showFloatLayerIcon = true;
    private boolean longPresPopMoreDialog = false;
    private String mPosterNick = "";
    private String mPosterAvatar = "";
    private String mFeedTitle = "";
    private boolean mShowPageIndex = false;
    private boolean mNeedTransitionAnim = false;
    private boolean mNeedOpenTransitionAnim = false;

    public String getCommentId() {
        return this.mCommentId;
    }

    public int getEnterPos() {
        return this.mEnterPos;
    }

    public GProStFeed getFeed() {
        GProStFeed gProStFeed = this.mTransStFeed;
        if (gProStFeed != null) {
            return gProStFeed;
        }
        if (this.mStFeedWrapper == null) {
            this.mStFeedWrapper = new GProStFeedMemoryKeepSerializer(new GProStFeed());
        }
        return this.mStFeedWrapper.getStFeed();
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public String getFeedTitle() {
        return this.mFeedTitle;
    }

    public int getFromPage() {
        return this.mFromPage;
    }

    @Nullable
    public GuildFeedPublishInfo getGuildFeedPublishInfo() {
        return this.mGuildFeedPublishInfo;
    }

    public int getOpenType() {
        return this.openType;
    }

    public String getPosterAvatar() {
        return this.mPosterAvatar;
    }

    public String getPosterId() {
        return this.mPosterId;
    }

    public String getPosterNick() {
        return this.mPosterNick;
    }

    public String getPublishTaskId() {
        GuildFeedPublishInfo guildFeedPublishInfo = this.mGuildFeedPublishInfo;
        if (guildFeedPublishInfo == null) {
            return "";
        }
        return guildFeedPublishInfo.getMainTaskId();
    }

    public String getReplyId() {
        return this.mReplyId;
    }

    public List<GuildFeedRichMediaData> getRichMediaDataList() {
        return this.mRichMediaDataList;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public TransitionBean getTransitionBean() {
        return this.mTransitionBean;
    }

    public int getTransitionBeanCreatorKey() {
        return this.mTransitionBeanCreatorKey;
    }

    public boolean isFromTroop() {
        int immersiveSource = getImmersiveSource();
        if (getBusinessType() != 7 && immersiveSource != 11 && immersiveSource != 12 && immersiveSource != 13) {
            return false;
        }
        return true;
    }

    public boolean isLongPressPopMoreDialog() {
        return this.longPresPopMoreDialog;
    }

    public boolean isNeedOpenTransitionAnim() {
        return this.mNeedOpenTransitionAnim;
    }

    public boolean isNeedTransitionAnim() {
        return this.mNeedTransitionAnim;
    }

    public boolean isShowCloseIcon() {
        return this.showCloseIcon;
    }

    public boolean isShowEditBtn() {
        return this.showEditBtn;
    }

    public boolean isShowFloatLayerIcon() {
        return this.showFloatLayerIcon;
    }

    public boolean isShowMoreIcon() {
        return this.showMoreIcon;
    }

    public boolean isShowPageIndex() {
        return this.mShowPageIndex;
    }

    public boolean isVideoFeed() {
        if (this.mRichMediaDataList.isEmpty()) {
            return false;
        }
        for (int i3 = 0; i3 < this.mRichMediaDataList.size(); i3++) {
            if (this.mRichMediaDataList.get(i3).getType() == 0) {
                return false;
            }
        }
        return true;
    }

    public void setCommentId(String str) {
        this.mCommentId = str;
    }

    public GuildFeedGalleryInitBean setEnterPos(int i3) {
        this.mEnterPos = i3;
        return this;
    }

    public void setFeed(GProStFeed gProStFeed) {
        if (gProStFeed != null) {
            this.mStFeedWrapper = new GProStFeedMemoryKeepSerializer(gProStFeed);
        }
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }

    public void setFeedTitle(String str) {
        this.mFeedTitle = str;
    }

    public void setFromPage(int i3) {
        this.mFromPage = i3;
    }

    public void setGuildFeedPublishInfo(GuildFeedPublishInfo guildFeedPublishInfo) {
        this.mGuildFeedPublishInfo = guildFeedPublishInfo;
    }

    public void setLongPresPopMoreDialog(boolean z16) {
        this.longPresPopMoreDialog = z16;
    }

    public void setNeedOpenTransitionAnim(boolean z16) {
        this.mNeedOpenTransitionAnim = z16;
    }

    public void setNeedTransitionAnim(boolean z16) {
        this.mNeedTransitionAnim = z16;
    }

    public void setOpenType(int i3) {
        this.openType = i3;
    }

    public void setPosterAvatar(String str) {
        this.mPosterAvatar = str;
    }

    public void setPosterId(String str) {
        this.mPosterId = str;
    }

    public void setPosterNick(String str) {
        this.mPosterNick = str;
    }

    public void setReplyId(String str) {
        this.mReplyId = str;
    }

    public GuildFeedGalleryInitBean setRichMediaDataList(List<GuildFeedRichMediaData> list) {
        this.mRichMediaDataList = list;
        return this;
    }

    public void setSessionId(String str) {
        this.mSessionId = str;
    }

    public void setShowCloseIcon(boolean z16) {
        this.showCloseIcon = z16;
    }

    public void setShowEditBtn(boolean z16) {
        this.showEditBtn = z16;
    }

    public void setShowFloatLayerIcon(boolean z16) {
        this.showFloatLayerIcon = z16;
    }

    public void setShowMoreIcon(boolean z16) {
        this.showMoreIcon = z16;
    }

    public void setShowPageIndex(boolean z16) {
        this.mShowPageIndex = z16;
    }

    public void setTraceId(String str) {
        this.mTraceId = str;
    }

    public void setTransStFeed(GProStFeed gProStFeed) {
        this.mTransStFeed = gProStFeed;
    }

    public GuildFeedGalleryInitBean setTransitionBean(TransitionBean transitionBean) {
        this.mTransitionBean = transitionBean;
        return this;
    }

    public void setTransitionBeanCreatorKey(int i3) {
        this.mTransitionBeanCreatorKey = i3;
    }
}
