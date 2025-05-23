package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasCellCommentView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellLuckyMoney;
import com.qzone.proxy.feedcomponent.model.CellRedBonus;
import com.qzone.proxy.feedcomponent.model.CellVisitorInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedComment extends FeedViewSection {
    public static final int FOLD = 2;
    public static final int FoldMinSize = 3;
    public static final int FoldSize = 30;
    public static final int LOAD_MORE = 0;
    public static boolean PRAISE_AVATAR_MODE = false;
    static final String TAG = "FeedComment";
    public static final int UN_FOLD = 1;
    public static ImageUrl redpocketImageUrl;
    boolean canInsertImage;
    View.OnClickListener clickListener;
    protected BusinessFeedData feedData;
    boolean isGoodFeed;
    protected boolean isLoading;
    boolean isPassive;
    boolean isQunfeed;
    boolean isRecommendFeed;
    protected CanvasCellCommentView mCanvasCommentView;
    protected GuideCommentBar mCommentBar;
    protected CellCommentInfo mCommentInfo;
    int mGoodsType;
    protected CellLikeInfo mLikeInfo;
    protected View mLoadingPro;
    protected View mLoadingTips;
    protected CellLuckyMoney mLuckyMoney;
    protected TextView mMoreText;
    protected VisitAndPraiseAvatarsView mPraiseAvatarsView;
    protected CellRedBonus mRedBonus;
    boolean mShowMoreView;
    protected CellCommentInfo.CommentState mState;
    protected CellVisitorInfo mVisitorInfo;
    protected ViewGroup moreCmtTopView;
    protected boolean moreCommentLoaded;
    protected PraiseListView praiseListView;
    protected boolean showMoreOnBottom;
    static final String COMMENT_MORE = com.qzone.adapter.feedcomponent.j.K(1094);
    static final String COMMENT_UNFOLD = com.qzone.adapter.feedcomponent.j.K(1095);
    static final String REPLY_MORE = com.qzone.adapter.feedcomponent.j.K(1093);
    static final int PRAISE_AVATARS_VIEW_BOTTOM_MARGIN = (int) (FeedGlobalEnv.g().getDensity() * 5.0f);
    private static String interest = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentInterest", "\u611f\u5174\u8da3");
    private static String interestSoOn = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentInterestSoOn", "\u7b49");
    private static String tenThousandInterest = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentTenThousandInterest", "\u4e07\u4eba\u611f\u5174\u8da3");
    private static String manyInterest = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CommentManyInterest", "\u7b49%d\u4eba\u611f\u5174\u8da3");
    public static final boolean RECOMMEND_FEED_SHOW_PRAISE_LIST_VIEW = com.qzone.adapter.feedcomponent.i.H().U("QZoneSetting", "RecommendFeedShowPraiseListView", false);
    public static final boolean RECOMMEND_FEED_SHOW_COMMENT_LIST = com.qzone.adapter.feedcomponent.i.H().U("QZoneSetting", "RecommendFeedShowCommentList", true);
    public static final boolean RECOMMEND_FEED_SHOW_COMMENT_BAR = com.qzone.adapter.feedcomponent.i.H().U("QZoneSetting", "RecommendFeedShowCommentBar", false);

    public FeedComment(Context context, FeedView feedView) {
        super(context, feedView);
        this.clickListener = new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedComment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!com.qzone.adapter.feedcomponent.i.H().W0() && view.getId() == com.qzone.adapter.feedcomponent.j.O(2239)) {
                    FeedComment feedComment = FeedComment.this;
                    CellCommentInfo cellCommentInfo = feedComment.mCommentInfo;
                    if (cellCommentInfo != null && cellCommentInfo.actionType == 36) {
                        com.qzone.proxy.feedcomponent.ui.g gVar = feedComment.onFeedElementClickListener;
                        FeedElement feedElement = FeedElement.CONTENT;
                        int i3 = feedComment.feedPosition;
                        gVar.onClick(view, feedElement, i3, Integer.valueOf(i3));
                    } else {
                        CellCommentInfo.CommentState commentState = feedComment.mState;
                        CellCommentInfo.CommentState commentState2 = CellCommentInfo.CommentState.FOLDED;
                        if (commentState == commentState2) {
                            feedComment.mState = CellCommentInfo.CommentState.UNFOLD;
                            if (feedComment.moreCommentLoaded) {
                                feedComment.onUpdate();
                                FeedComment feedComment2 = FeedComment.this;
                                feedComment2.onFeedElementClickListener.onClick(view, FeedElement.MORE_COMMENT, feedComment2.feedPosition, 1);
                            } else {
                                if (!feedComment.isQunfeed) {
                                    feedComment.startLoadingMore();
                                }
                                FeedComment feedComment3 = FeedComment.this;
                                feedComment3.onFeedElementClickListener.onClick(view, FeedElement.MORE_COMMENT, feedComment3.feedPosition, 0);
                            }
                        } else {
                            feedComment.mState = commentState2;
                            feedComment.onFeedElementClickListener.onClick(view, FeedElement.MORE_COMMENT, feedComment.feedPosition, 2);
                            FeedComment.this.onUpdate();
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        init();
    }

    static boolean checkOperatemaskEnabled(int i3, int i16) {
        if ((i3 & (1 << i16)) != 0) {
            return true;
        }
        return false;
    }

    private void hideCommentViewIfNeed() {
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2;
        BusinessFeedData businessFeedData3 = this.feedData;
        if (businessFeedData3 != null && (businessFeedData2 = businessFeedData3.parentFeedData) != null && businessFeedData2.isFriendLikeContainer()) {
            this.mCanvasCommentView.setVisibility(8);
        }
        BusinessFeedData businessFeedData4 = this.feedData;
        if (businessFeedData4 == null || (businessFeedData = businessFeedData4.parentFeedData) == null || !businessFeedData.isFrdLikeVideoContainer()) {
            return;
        }
        this.mCanvasCommentView.setVisibility(8);
    }

    private void initCommentBar(BusinessFeedData businessFeedData) {
        BusinessFeedData originalInfo;
        setHintText(businessFeedData);
        GuideCommentBar guideCommentBar = this.mCommentBar;
        if (guideCommentBar != null) {
            guideCommentBar.setShowRapidCommentInBox(businessFeedData.isFeedCommentRapidCommentInBox());
        }
        boolean checkOperatemaskEnabled = checkOperatemaskEnabled(businessFeedData.getFeedCommInfo().operatemask, 26);
        if (!checkOperatemaskEnabled && (originalInfo = businessFeedData.getOriginalInfo()) != null) {
            checkOperatemaskEnabled = checkOperatemaskEnabled(originalInfo.getFeedCommInfo().operatemask, 26);
        }
        GuideCommentBar guideCommentBar2 = this.mCommentBar;
        if (guideCommentBar2 != null) {
            guideCommentBar2.setShowDoodleIcon(checkOperatemaskEnabled);
            boolean z16 = false;
            this.mCommentBar.setShowGiftIcon(false);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCommentBar.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, AreaConst.AREA_VERTICAL_MARGIN - AreaConst.f48748dp3);
                this.mCommentBar.setLayoutParams(marginLayoutParams);
            }
            this.mCommentBar.setCellPokeLike(businessFeedData.cellPokeLike);
            boolean z17 = businessFeedData.feedType == 4098;
            GuideCommentBar guideCommentBar3 = this.mCommentBar;
            if (!z17 && businessFeedData.isCommentPokeLike()) {
                z16 = true;
            }
            guideCommentBar3.setCommentPokeLike(z16);
        }
    }

    private void initCommentView(BusinessFeedData businessFeedData) {
        if (this.isRecommendFeed && !RECOMMEND_FEED_SHOW_COMMENT_LIST) {
            setCommentViewVisibile(false);
            return;
        }
        if (businessFeedData.getFeedCommInfo().isYunYingFeeds()) {
            this.mCanvasCommentView.setVisibility(8);
            return;
        }
        BusinessFeedData businessFeedData2 = businessFeedData.parentFeedData;
        if ((businessFeedData2 == null || !businessFeedData2.isFriendLikeContainer()) && !businessFeedData.isQCircleRecommFeed()) {
            return;
        }
        this.mCanvasCommentView.setVisibility(8);
    }

    private void setPraiseViewVisible(int i3) {
        if (PRAISE_AVATAR_MODE) {
            this.mPraiseAvatarsView.setVisibility(i3);
        } else {
            this.praiseListView.setVisibility(i3);
        }
    }

    private void setRapidIconVisibility(BusinessFeedData businessFeedData) {
        GuideCommentBar guideCommentBar = this.mCommentBar;
        if (guideCommentBar != null) {
            guideCommentBar.setRapidIconVisibility((businessFeedData.isAdFeeds() || !(businessFeedData.isFeedCommentInsertImage() || businessFeedData.getFeedCommInfo().canPresent())) ? 8 : 0);
        }
    }

    private void updateCommentBar() {
        if ((this.isRecommendFeed && !RECOMMEND_FEED_SHOW_COMMENT_LIST) || this.feedData.isQCircleRecommFeed()) {
            setCommentViewVisibile(false);
        } else {
            hideCommentViewIfNeed();
            GuideCommentBar guideCommentBar = this.mCommentBar;
            if (guideCommentBar != null) {
                if (this.isPassive) {
                    guideCommentBar.setPadding(guideCommentBar.getPaddingLeft(), AreaConst.dp10, this.mCommentBar.getPaddingRight(), AreaConst.dp5);
                    this.mCommentBar.setShowRedPocket(false);
                } else if (this.mCommentInfo == null && this.praiseListView.isEmpty()) {
                    GuideCommentBar guideCommentBar2 = this.mCommentBar;
                    guideCommentBar2.setPadding(guideCommentBar2.getPaddingLeft(), 0, this.mCommentBar.getPaddingRight(), this.mCommentBar.getPaddingBottom());
                } else {
                    GuideCommentBar guideCommentBar3 = this.mCommentBar;
                    guideCommentBar3.setPadding(guideCommentBar3.getPaddingLeft(), AreaConst.f48749dp4, this.mCommentBar.getPaddingRight(), this.mCommentBar.getPaddingBottom());
                }
            }
        }
        this.mCanvasCommentView.forceLayout();
        GuideCommentBar guideCommentBar4 = this.mCommentBar;
        if (guideCommentBar4 != null) {
            guideCommentBar4.forceLayout();
        }
    }

    private void updateCommentView() {
        BusinessFeedData businessFeedData;
        if ((this.isRecommendFeed && !RECOMMEND_FEED_SHOW_PRAISE_LIST_VIEW) || ((businessFeedData = this.feedData) != null && businessFeedData.isQCircleRecommFeed())) {
            FeedViewSection.setViewGone(this.mPraiseAvatarsView);
            FeedViewSection.setViewGone(this.praiseListView);
        } else if (PRAISE_AVATAR_MODE) {
            CellLikeInfo cellLikeInfo = this.mLikeInfo;
            if (cellLikeInfo != null) {
                if (this.isGoodFeed) {
                    updateGoodCustomString();
                } else {
                    this.mPraiseAvatarsView.setPraiseData(cellLikeInfo.getUserList(), this.mLikeInfo.likeNum);
                }
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mPraiseAvatarsView.getLayoutParams();
            if (this.mLikeInfo != null) {
                updatePraiseViewMargin(marginLayoutParams, PRAISE_AVATARS_VIEW_BOTTOM_MARGIN);
            } else {
                updatePraiseViewMargin(marginLayoutParams, 0);
            }
            this.mPraiseAvatarsView.setVisitInfo(this.mVisitorInfo);
            this.mPraiseAvatarsView.forceLayout();
        } else {
            this.praiseListView.setLikeInfo(this.feedData, this.mLikeInfo, this.isGoodFeed, this.mGoodsType);
            this.praiseListView.setRedPocketInfo(this.mRedBonus, this.feedData);
            this.praiseListView.setSpaceRedPocketInfo(this.mLuckyMoney, this.feedData);
            BusinessFeedData businessFeedData2 = this.feedData;
            if (businessFeedData2 != null) {
                if (businessFeedData2.isSubOfSingleAdvContainerFeed()) {
                    this.praiseListView.setLikeInfo(null, null, this.isGoodFeed, this.mGoodsType);
                }
                this.praiseListView.setForwardListInfo(this.feedData.getCellForwardInfo(), this.feedData);
                this.praiseListView.setCommentCountInfo(this.feedData.getCommentInfoV2(), this.feedData);
            }
            this.praiseListView.update();
        }
        updateCommentBar();
    }

    private void updateGoodCustomString() {
        String str;
        int i3 = this.mLikeInfo.likeNum;
        if (i3 == 1) {
            str = interest;
        } else if (i3 > 10000) {
            str = interestSoOn + (i3 / 10000.0d) + tenThousandInterest;
        } else {
            str = manyInterest;
        }
        this.mPraiseAvatarsView.setPraiseData(this.mLikeInfo.getUserList(), this.mLikeInfo.likeNum, false, str, com.qzone.adapter.feedcomponent.j.o(), 13);
    }

    private void updatePraiseViewMargin(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        if (marginLayoutParams.topMargin == 0 && marginLayoutParams.bottomMargin == i3) {
            return;
        }
        marginLayoutParams.topMargin = 0;
        marginLayoutParams.bottomMargin = i3;
        this.mPraiseAvatarsView.requestLayout();
    }

    protected boolean canShowGuideCommentBar() {
        if (this.mFeedData.isRecommendFeed()) {
            return RECOMMEND_FEED_SHOW_COMMENT_BAR;
        }
        BusinessFeedData businessFeedData = this.feedData;
        return (businessFeedData.hideCommentBar || businessFeedData.isQCircleRecommFeed() || !this.mFeedData.getLocalInfo().canComment || this.mFeedData.isSubFeed) ? false : true;
    }

    CanvasCellCommentView generateCellCommentView() {
        return new CanvasCellCommentView(getContext(), null);
    }

    public GuideCommentBar getCommentBar() {
        return this.mCommentBar;
    }

    public void handleBottomReplyMore(boolean z16) {
        FeedViewSection.setViewGone(this.moreCmtTopView);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public boolean haveMultipleViews() {
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public List<View> obtainViews() {
        ArrayList arrayList = new ArrayList();
        if (this.praiseListView == null) {
            PraiseListView praiseListView = new PraiseListView(getContext(), null);
            this.praiseListView = praiseListView;
            praiseListView.setId(DittoUIEngine.g().getResourceId("@id/feed_praise_avatars_view"));
        }
        if (this.moreCmtTopView == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(DittoUIEngine.g().getResourceId("@layout/qzone_viewstub_more_comment_top"), (ViewGroup) null);
            this.moreCmtTopView = viewGroup;
            this.mLoadingPro = viewGroup.findViewById(com.qzone.adapter.feedcomponent.j.O(2240));
            this.mLoadingTips = this.moreCmtTopView.findViewById(com.qzone.adapter.feedcomponent.j.O(2241));
            this.mMoreText = (TextView) this.moreCmtTopView.findViewById(com.qzone.adapter.feedcomponent.j.O(2239));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int i3 = AreaConst.dp8;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i3;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i3;
            this.moreCmtTopView.setLayoutParams(layoutParams);
        }
        if (this.mCanvasCommentView == null) {
            this.mCanvasCommentView = generateCellCommentView();
        }
        if (this.mCommentBar == null) {
            GuideCommentBar guideCommentBar = new GuideCommentBar(getContext());
            this.mCommentBar = guideCommentBar;
            guideCommentBar.setId(DittoUIEngine.g().getResourceId("@id/feed_guide_comment_bar"));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            int i16 = AreaConst.dp8;
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = i16;
            ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = i16;
            this.mCommentBar.setLayoutParams(layoutParams2);
        }
        arrayList.add(this.praiseListView);
        arrayList.add(this.moreCmtTopView);
        arrayList.add(this.mCanvasCommentView);
        arrayList.add(this.mCommentBar);
        return arrayList;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onApplyFeedData() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData.feedType == 4098) {
            MyFeedViewBuilder.setCommentAreaData(businessFeedData, this);
            return;
        }
        setPhotoMode(com.qzone.adapter.feedcomponent.i.H().W());
        CellCommentInfo commentInfoV2 = this.mFeedData.getCommentInfoV2();
        if (commentInfoV2 != null) {
            CellCommentInfo.CommentState commentState = commentInfoV2.commentState;
            if (commentState == null) {
                commentInfoV2.commentState = CellCommentInfo.CommentState.FOLDED;
                com.qzone.proxy.feedcomponent.b.i("CommentState", "commentState is null !!");
            } else if (commentState == CellCommentInfo.CommentState.LOADING) {
                commentInfoV2.commentState = CellCommentInfo.CommentState.FOLDED;
            }
        }
        setIsPassive(false);
        setFeedData(this.mFeedData);
        setLikeInfo(this.mFeedData.getLikeInfoV2());
        setRedBonusInfo(this.mFeedData.getCellRedBonus());
        setLuckyMoneyInfo(this.mFeedData.getCellLuckyMoney());
        setVisitorInfo(this.mFeedData.getVisitorInfo());
        setShowGuide(canShowGuideCommentBar());
        setCommentInfo(this.mFeedData.getCommentInfoV2(), false);
        onUpdate();
    }

    public void onPause() {
        CanvasCellCommentView canvasCellCommentView = this.mCanvasCommentView;
        if (canvasCellCommentView != null) {
            canvasCellCommentView.onPause();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        CanvasCellCommentView canvasCellCommentView = this.mCanvasCommentView;
        if (canvasCellCommentView != null) {
            canvasCellCommentView.onRecycled();
        }
        PraiseListView praiseListView = this.praiseListView;
        if (praiseListView != null) {
            praiseListView.onRecycled();
        }
        GuideCommentBar guideCommentBar = this.mCommentBar;
        if (guideCommentBar != null) {
            guideCommentBar.onRecycled();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateIdle() {
        CanvasCellCommentView canvasCellCommentView = this.mCanvasCommentView;
        if (canvasCellCommentView != null) {
            canvasCellCommentView.onStateIdle();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void onStateScrolling() {
        onPause();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void onUpdate() {
        CellCommentInfo cellCommentInfo = this.mCommentInfo;
        if (cellCommentInfo != null) {
            this.mState = cellCommentInfo.commentState;
            this.moreCommentLoaded = cellCommentInfo.moreCommentHasLoaded > 0;
            this.mCanvasCommentView.setFeedData(this.feedData);
            boolean commentInfo = this.mCanvasCommentView.setCommentInfo(this.mCommentInfo, this.mState, this.showMoreOnBottom ? 258 : 257, this.canInsertImage);
            this.mShowMoreView = commentInfo;
            if (!this.showMoreOnBottom) {
                handleCommentMoreView(commentInfo, this.mCommentInfo.commentNum);
            }
        } else {
            this.mCanvasCommentView.setFeedData(this.feedData);
            this.mCanvasCommentView.setCommentInfo(null, this.mState, this.showMoreOnBottom ? 258 : 257, this.canInsertImage);
            FeedViewSection.setViewGone(this.moreCmtTopView);
        }
        updateCommentView();
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setAlpha(int i3) {
        GuideCommentBar guideCommentBar = this.mCommentBar;
        if (guideCommentBar != null) {
            guideCommentBar.setTrans(i3);
        }
    }

    public void setCommentInfo(CellCommentInfo cellCommentInfo, boolean z16) {
        this.mCommentInfo = cellCommentInfo;
        this.showMoreOnBottom = z16;
    }

    public void setCommentViewVisibile(boolean z16) {
        CanvasCellCommentView canvasCellCommentView = this.mCanvasCommentView;
        if (canvasCellCommentView == null) {
            return;
        }
        if (z16) {
            if (canvasCellCommentView.getVisibility() != 0) {
                this.mCanvasCommentView.setVisibility(0);
            }
        } else if (canvasCellCommentView.getVisibility() != 8) {
            this.mCanvasCommentView.setVisibility(8);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setFeedPosition(int i3) {
        super.setFeedPosition(i3);
        CanvasCellCommentView canvasCellCommentView = this.mCanvasCommentView;
        if (canvasCellCommentView != null) {
            canvasCellCommentView.setFeedPosition(i3, this.mRootView.mIndex);
        }
        GuideCommentBar guideCommentBar = this.mCommentBar;
        if (guideCommentBar != null) {
            guideCommentBar.setFeedPosition(i3, this.mRootView.mIndex);
        }
        PraiseListView praiseListView = this.praiseListView;
        if (praiseListView != null) {
            praiseListView.setFeedPosition(i3, this.mRootView.mIndex);
        }
    }

    public void setHintText(BusinessFeedData businessFeedData) {
        if (this.mCommentBar != null) {
            this.mCommentBar.setHintText(this.isPassive ? com.qzone.adapter.feedcomponent.d.b(businessFeedData) : null);
        }
    }

    public void setIsPassive(boolean z16) {
        this.isPassive = z16;
        CanvasCellCommentView canvasCellCommentView = this.mCanvasCommentView;
        if (canvasCellCommentView != null) {
            canvasCellCommentView.setIsPassive(z16);
        }
    }

    public void setLikeInfo(CellLikeInfo cellLikeInfo) {
        this.mLikeInfo = cellLikeInfo;
        if (this.mCanvasCommentView != null) {
            if ((this.isRecommendFeed && !RECOMMEND_FEED_SHOW_PRAISE_LIST_VIEW) || this.feedData.isQCircleRecommFeed()) {
                this.mCanvasCommentView.setPraiseListIsVisibility(false);
            } else if (this.mLikeInfo == null) {
                this.mCanvasCommentView.setPraiseListIsVisibility(false);
            } else {
                this.mCanvasCommentView.setPraiseListIsVisibility(true);
            }
        }
    }

    public void setLuckyMoneyInfo(CellLuckyMoney cellLuckyMoney) {
        this.mLuckyMoney = cellLuckyMoney;
        if (this.mCanvasCommentView != null) {
            if ((this.isRecommendFeed && !RECOMMEND_FEED_SHOW_PRAISE_LIST_VIEW) || this.feedData.isQCircleRecommFeed()) {
                this.mCanvasCommentView.setSpaceRedBonusListIsVisibility(false);
            } else if (this.mLuckyMoney == null) {
                this.mCanvasCommentView.setSpaceRedBonusListIsVisibility(false);
            } else {
                this.mCanvasCommentView.setSpaceRedBonusListIsVisibility(true);
            }
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        super.setOnFeedElementClickListener(gVar);
        CanvasCellCommentView canvasCellCommentView = this.mCanvasCommentView;
        if (canvasCellCommentView != null) {
            canvasCellCommentView.setOnFeedElementClickListener(gVar);
        }
        GuideCommentBar guideCommentBar = this.mCommentBar;
        if (guideCommentBar != null) {
            guideCommentBar.setOnFeedElementClickListener(gVar);
        }
        PraiseListView praiseListView = this.praiseListView;
        if (praiseListView != null) {
            praiseListView.setOnFeedElementClickListener(gVar);
        }
    }

    public void setPhotoMode(int i3) {
        this.mCanvasCommentView.setPhotoMode(i3);
    }

    public void setRedBonusInfo(CellRedBonus cellRedBonus) {
        this.mRedBonus = cellRedBonus;
        if (this.mCanvasCommentView != null) {
            if ((this.isRecommendFeed && !RECOMMEND_FEED_SHOW_PRAISE_LIST_VIEW) || this.feedData.isQCircleRecommFeed()) {
                this.mCanvasCommentView.setRedBonusListIsVisibility(false);
            } else if (this.mRedBonus == null) {
                this.mCanvasCommentView.setRedBonusListIsVisibility(false);
            } else {
                this.mCanvasCommentView.setRedBonusListIsVisibility(true);
            }
        }
    }

    public void setShowGuide(boolean z16) {
        GuideCommentBar guideCommentBar = this.mCommentBar;
        if (guideCommentBar != null) {
            guideCommentBar.setVisibility(z16 ? 0 : 8);
        }
    }

    public void setUseWhiteBg(boolean z16) {
        GuideCommentBar guideCommentBar = this.mCommentBar;
        if (guideCommentBar != null) {
            guideCommentBar.setUseWhiteBg(z16);
        }
    }

    public void setVisitorInfo(CellVisitorInfo cellVisitorInfo) {
        this.mVisitorInfo = cellVisitorInfo;
    }

    public void startLoadingMore() {
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        FeedViewSection.setViewVisbile(this.mLoadingPro);
        FeedViewSection.setViewVisbile(this.mLoadingTips);
        FeedViewSection.setViewGone(this.mMoreText);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    public void reset() {
        this.isPassive = false;
        this.isQunfeed = false;
        this.isGoodFeed = false;
        this.mGoodsType = 0;
        this.mState = null;
        this.mCommentInfo = null;
        this.mLikeInfo = null;
        this.isLoading = false;
        this.feedData = null;
        this.mRedBonus = null;
        this.mLuckyMoney = null;
        this.mVisitorInfo = null;
        CanvasCellCommentView canvasCellCommentView = this.mCanvasCommentView;
        if (canvasCellCommentView != null) {
            canvasCellCommentView.reset();
        }
        TextView textView = this.mMoreText;
        if (textView != null) {
            FeedViewSection.setViewGone(textView);
        }
        PraiseListView praiseListView = this.praiseListView;
        if (praiseListView != null) {
            praiseListView.reset();
        }
    }

    static {
        FeedGlobalEnv.g();
        PRAISE_AVATAR_MODE = FeedGlobalEnv.PRAISE_AVATAR_MODE;
    }

    public void handleCommentMoreView(boolean z16, int i3) {
        if (z16) {
            FeedViewSection.setViewVisbile(this.moreCmtTopView);
            if (this.isLoading) {
                FeedViewSection.setViewVisbile(this.mLoadingPro);
                FeedViewSection.setViewVisbile(this.mLoadingTips);
                FeedViewSection.setViewGone(this.mMoreText);
                return;
            } else {
                FeedViewSection.setViewGone(this.mLoadingPro);
                FeedViewSection.setViewGone(this.mLoadingTips);
                if (this.mState == CellCommentInfo.CommentState.FOLDED) {
                    this.mMoreText.setText(COMMENT_MORE);
                } else {
                    this.mMoreText.setText(COMMENT_UNFOLD);
                }
                FeedViewSection.setViewVisbile(this.mMoreText);
                return;
            }
        }
        this.mState = CellCommentInfo.CommentState.NONE;
        FeedViewSection.setViewGone(this.moreCmtTopView);
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        this.feedData = businessFeedData;
        this.canInsertImage = businessFeedData.isFeedCommentInsertImage();
        this.isQunfeed = com.qzone.adapter.feedcomponent.i.H().u1(businessFeedData);
        this.isRecommendFeed = businessFeedData.isRecommendFeed() || businessFeedData.isQCircleRecommFeed();
        this.isGoodFeed = businessFeedData.getFeedCommInfo().isQbossPurchaseFeeds();
        if (businessFeedData.getGoods() != null) {
            this.mGoodsType = businessFeedData.getGoods().goodsType;
        }
        if (com.qzone.adapter.feedcomponent.i.H().S0() && !TextUtils.isEmpty(businessFeedData.feedCommentReadstr)) {
            this.mCanvasCommentView.setContentDescription(businessFeedData.feedCommentReadstr);
        }
        if ((this.isRecommendFeed && !RECOMMEND_FEED_SHOW_PRAISE_LIST_VIEW) || businessFeedData.isQCircleRecommFeed()) {
            FeedViewSection.setViewGone(this.mPraiseAvatarsView);
            FeedViewSection.setViewGone(this.praiseListView);
        } else if (businessFeedData.isNewAdvStyle() && businessFeedData.getRecommAction() != null) {
            setPraiseViewVisible(8);
        } else {
            setPraiseViewVisible(0);
        }
        setRapidIconVisibility(businessFeedData);
        initCommentView(businessFeedData);
        initCommentBar(businessFeedData);
    }

    public void setPraiseViewVisible(boolean z16) {
        PraiseListView praiseListView = this.praiseListView;
        if (praiseListView == null) {
            return;
        }
        praiseListView.setVisibility(z16 ? 0 : 8);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedViewSection
    protected void attachView(NormalAbsFeedView normalAbsFeedView) {
    }

    void init() {
    }
}
