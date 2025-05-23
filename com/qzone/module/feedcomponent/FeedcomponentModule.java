package com.qzone.module.feedcomponent;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.feed.gift.widget.FeedGiftLayout;
import com.qzone.feed.panorama.PanoramaLayout;
import com.qzone.module.Module;
import com.qzone.module.feedcomponent.FeedcomponentModule;
import com.qzone.module.feedcomponent.actionreport.UserActionReportHelper;
import com.qzone.module.feedcomponent.detail.DetailWidgetAdapter;
import com.qzone.module.feedcomponent.detail.FeedCommentDetailAdapter;
import com.qzone.module.feedcomponent.detail.FeedDetailCommentAdapter;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.ui.CommentTextArea;
import com.qzone.module.feedcomponent.ui.DataPreCalculateTool;
import com.qzone.module.feedcomponent.ui.FeedAdvContainer;
import com.qzone.module.feedcomponent.ui.FeedAutoVideo;
import com.qzone.module.feedcomponent.ui.FeedFriendBirthdayGiftView;
import com.qzone.module.feedcomponent.ui.FeedGoods;
import com.qzone.module.feedcomponent.ui.FeedScrollContainerArea;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.module.feedcomponent.ui.FeedViewBuilder;
import com.qzone.module.feedcomponent.ui.FrdLikeVideoFeedView;
import com.qzone.module.feedcomponent.ui.FrdLikeVideoSlideFeedView;
import com.qzone.module.feedcomponent.ui.FriendAnniversaryFeedView;
import com.qzone.module.feedcomponent.ui.FriendVideoFeedView;
import com.qzone.module.feedcomponent.ui.FunctionGuideFeedView;
import com.qzone.module.feedcomponent.ui.MyFeedViewBuilder;
import com.qzone.module.feedcomponent.ui.NormalAbsFeedView;
import com.qzone.module.feedcomponent.ui.QZoneOldFrdHotVideoFeedListView;
import com.qzone.module.feedcomponent.ui.QzoneSecretFeedView;
import com.qzone.module.feedcomponent.ui.ViewLoader;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasCellCommentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardView;
import com.qzone.module.feedcomponent.view.ExtendGridView;
import com.qzone.module.feedcomponent.view.FeedGifView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.h;
import com.qzone.proxy.feedcomponent.i;
import com.qzone.proxy.feedcomponent.manager.f;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.d;
import com.qzone.proxy.feedcomponent.ui.detail.b;
import com.qzone.proxy.feedcomponent.ui.g;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedcomponentModule extends Module<i, h> {
    d mAreaManager;
    i iComponentUI = new AnonymousClass1();
    h iComponentService = new h() { // from class: com.qzone.module.feedcomponent.FeedcomponentModule.2
        public f obtainFeedManager(int i3, int i16, boolean z16) {
            return new FeedManager(i3, i16, z16);
        }
    };

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class AreaManagerWrapper implements d {
        AreaManager realManager = AreaManager.getInstance();

        AreaManagerWrapper() {
        }

        @Override // com.qzone.proxy.feedcomponent.ui.d
        public void getPicTextArea(String str, String str2, String str3) {
            this.realManager.getPicTextArea(str, str2, str3);
        }

        public void getVisitListArea(String str, String str2) {
            this.realManager.getVisitListArea(str, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class SingletonHolder {
        public static FeedcomponentModule INSTANCE = new FeedcomponentModule();
    }

    public static FeedcomponentModule g() {
        return SingletonHolder.INSTANCE;
    }

    @Override // com.qzone.module.Proxy
    public String getModuleClassName() {
        return null;
    }

    @Override // com.qzone.module.Module
    public String getName() {
        return "FeedcomponentModule";
    }

    @Override // com.qzone.module.Module
    public int getVersion() {
        return 0;
    }

    /* compiled from: P */
    /* renamed from: com.qzone.module.feedcomponent.FeedcomponentModule$1, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass1 implements i {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onThemeColorChange$0() {
            DittoUIEngine.g().clearCache();
            j.S();
            AreaManager.getInstance().onThemeColorChange();
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void calculatePic(BusinessFeedData businessFeedData) {
            DataPreCalculateTool.calculatePic(businessFeedData);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public com.qzone.proxy.feedcomponent.ui.detail.a createDetailWidgetAdapter(Context context, int i3) {
            return new DetailWidgetAdapter(context, i3);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public b createFeedCommentDetailAdapter(Context context, ViewGroup viewGroup, g gVar) {
            return new FeedCommentDetailAdapter(context, viewGroup, gVar);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public b createFeedDetailCommentAdapter(Context context, ViewGroup viewGroup, g gVar) {
            return new FeedDetailCommentAdapter(context, viewGroup, gVar);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void doCommentActionReport(int i3) {
            UserActionReportHelper.doCommentActionReport(i3);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void doFloatViewActionReport(int i3) {
            UserActionReportHelper.doFloatViewActionReport(i3);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void feedVideoReport(BusinessFeedData businessFeedData, int i3, int i16, boolean z16, int i17) {
            UserActionReportHelper.videoReport(businessFeedData, i3, i16, z16, i17);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView generateFeedView(Context context, g gVar, boolean z16, boolean z17) {
            return FeedViewBuilder.generateFeedView(context, gVar, z16, z17);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView generateFrdLikeVideoFeedView(Context context) {
            return ViewLoader.getInstance().obtainFrdLikeVideoFeedView(context);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView generateFrdLikeVideoSlideFeedView(Context context) {
            return ViewLoader.getInstance().obtainFrdLikeVideoSlideFeedView(context);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView generateFriendVideoFeedView(Context context) {
            return ViewLoader.getInstance().obtainFriendVideoFeedView(context);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView gererateFriendAnniversaryFeedView(Context context) {
            return new FriendAnniversaryFeedView(context);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView gererateFunctionGuideFeedView(Context context) {
            return new FunctionGuideFeedView(context);
        }

        public AbsFeedView gererateQzoneSecretFeedView(Context context) {
            return new QzoneSecretFeedView(context);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public d getAreaManagerInstance() {
            FeedcomponentModule feedcomponentModule = FeedcomponentModule.this;
            if (feedcomponentModule.mAreaManager == null) {
                feedcomponentModule.mAreaManager = new AreaManagerWrapper();
            }
            return FeedcomponentModule.this.mAreaManager;
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public int getCellCommentViewBottom(View view) {
            DittoArea clickedArea;
            if (!(view instanceof CanvasCellCommentView) || (clickedArea = ((CanvasCellCommentView) view).getClickedArea()) == null) {
                return 0;
            }
            return clickedArea.getBottom();
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public String getCommentTextAreaDisReplyStr(Comment comment, int i3) {
            return CommentTextArea.getDisReplyStr(comment, i3);
        }

        public int getFeedAutoVideoPlayingPosition() {
            Object h16 = BaseVideoManager.getFeedVideoManager().h();
            if (h16 == null) {
                return 0;
            }
            return ((Integer) h16).intValue();
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public boolean isOriginal(View view) {
            if (view instanceof CanvasFeedContentView) {
                return ((CanvasFeedContentView) view).isForward;
            }
            return false;
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void notifyNetworkChange(boolean z16) {
            try {
                BaseVideoManager.getFeedVideoManager().onNetworkChange(z16);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView obtainFeedAdvContainer(Context context, BusinessFeedData businessFeedData) {
            return ViewLoader.getInstance().obtainFeedAdvContainer(context, businessFeedData);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView obtainFeedBirthdayContainer(Context context, BusinessFeedData businessFeedData) {
            return ViewLoader.getInstance().obtainFeedBirthdayContainer(context, businessFeedData);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView obtainFeedGalleryContainer(Context context, BusinessFeedData businessFeedData) {
            return ViewLoader.getInstance().obtainFeedGalleryContainer(context, businessFeedData);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView obtainFeedView(Context context, g gVar, boolean z16, boolean z17, int i3) {
            return ViewLoader.getInstance().obtianFeedView(context, gVar, z16, z17, i3);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView obtainFriendAnniversyFeedView(Context context) {
            return ViewLoader.getInstance().obtainFriendAnniversyFeedView(context);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView obtainFunctionGuideFeedView(Context context) {
            return ViewLoader.getInstance().obtainFunctionGuideFeedView(context);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView obtainNegativeFeedbackFeedView(Context context) {
            return ViewLoader.getInstance().obtainNegativeFeedbackFeedView(context);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView obtainNewGuideView(Context context) {
            return ViewLoader.getInstance().obtainNewGuideView(context);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView obtainNewUserFeedView(Context context) {
            return ViewLoader.getInstance().obtainNewUserFeedView(context);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView obtainRegisterAnniversyFeedView(Context context) {
            return ViewLoader.getInstance().obtainRegisterAnniversyFeedView(context);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public AbsFeedView obtainVerticalRecomFollowFeedView(Context context) {
            return ViewLoader.getInstance().obtainVerticalRecomFollowFeedView(context);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void onBirthdayGiftSendResult(View view, int i3, boolean z16) {
            if (view instanceof FeedFriendBirthdayGiftView) {
                FeedFriendBirthdayGiftView feedFriendBirthdayGiftView = (FeedFriendBirthdayGiftView) view;
                if (feedFriendBirthdayGiftView.checkMagic(i3)) {
                    if (!z16) {
                        feedFriendBirthdayGiftView.onSendGiftFailed();
                    } else {
                        feedFriendBirthdayGiftView.onSendGiftSuccess();
                    }
                }
            }
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void onBirthdayGiftSending(View view, int i3) {
            if (view instanceof FeedFriendBirthdayGiftView) {
                FeedFriendBirthdayGiftView feedFriendBirthdayGiftView = (FeedFriendBirthdayGiftView) view;
                if (feedFriendBirthdayGiftView.checkMagic(i3)) {
                    feedFriendBirthdayGiftView.onSendingGift();
                }
            }
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void onConfigurationChanged(Configuration configuration) {
            AreaManager.getInstance().onConfigurationChanged(configuration);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void onFeedScrollAction(ViewGroup viewGroup, Adapter adapter, int i3, int i16, int i17, int i18) {
            BusinessFeedData businessFeedData;
            UserActionReportHelper.feedScrollAction(viewGroup, adapter, i3, i16, i17, i18);
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if ((childAt instanceof FeedView) && (businessFeedData = ((AbsFeedView) childAt).mFeedData) != null && businessFeedData.isGDTAdvFeed()) {
                    ((FeedView) childAt).onListScroll();
                }
            }
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void onFeedScrollStateChangedAction(ViewGroup viewGroup, Adapter adapter, int i3, boolean z16, int i16) {
            UserActionReportHelper.feedScrollStateChangedAction(viewGroup, adapter, i3, z16, i16);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void onListViewIdle(ViewGroup viewGroup) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt != null && (childAt instanceof AbsFeedView)) {
                    ((AbsFeedView) childAt).onStateIdle();
                } else if (childAt != null && (childAt instanceof FeedAdvContainer)) {
                    ((FeedAdvContainer) childAt).onStateIdle();
                } else if (childAt != null && (childAt instanceof FrdLikeVideoSlideFeedView)) {
                    ((FrdLikeVideoSlideFeedView) childAt).onStateIdle();
                } else if (childAt != null && (childAt instanceof FrdLikeVideoFeedView)) {
                    ((FrdLikeVideoFeedView) childAt).onStateIdle();
                } else if (childAt != null && (childAt instanceof LinearLayout) && childAt.getId() == j.O(2608)) {
                    handleDetailCommentOnIdle((ViewGroup) childAt);
                }
            }
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void onListViewIdleWithVideoCover(ViewGroup viewGroup, FrameLayout frameLayout, BaseAdapter baseAdapter, boolean z16) {
            BaseVideo feedsCoverVideo;
            FeedAutoVideo currentVideoView;
            List<BaseVideo> playVideoOnFeedListIdle;
            FeedScrollContainerArea feedScrollContainer;
            if (com.qzone.adapter.feedcomponent.i.H().c0()) {
                LinkedList linkedList = null;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    boolean z17 = false;
                    if (childAt != null && (childAt instanceof NormalAbsFeedView)) {
                        AbsFeedView absFeedView = (AbsFeedView) childAt;
                        if (absFeedView.isAlwaysAutoPlayFeed() || (com.qzone.adapter.feedcomponent.i.H().m() && absFeedView.isAutoVideoFeed() && absFeedView.canLiveFeedAutoPlay())) {
                            z17 = true;
                        }
                        if (GdtAdFeedUtil.shouldTryPlayGdtCarouselCardVideo(absFeedView.mFeedData)) {
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                            }
                            linkedList.add(((NormalAbsFeedView) childAt).getAutoVideoView());
                        } else {
                            if (z17) {
                                if (linkedList == null) {
                                    linkedList = new LinkedList();
                                }
                                NormalAbsFeedView normalAbsFeedView = (NormalAbsFeedView) childAt;
                                if (normalAbsFeedView.getAutoVideoView() != null && normalAbsFeedView.getAutoVideoView().isValidVideo()) {
                                    linkedList.add(normalAbsFeedView.getAutoVideoView());
                                }
                            }
                            NormalAbsFeedView normalAbsFeedView2 = (NormalAbsFeedView) childAt;
                            if (normalAbsFeedView2.getAutoVideoView() != null && normalAbsFeedView2.getAutoVideoView().hasGdtVideoPlayedBefore()) {
                                if (linkedList == null) {
                                    linkedList = new LinkedList();
                                }
                                linkedList.add(normalAbsFeedView2.getAutoVideoView());
                            }
                            if (com.qzone.adapter.feedcomponent.i.H().m() && normalAbsFeedView2.getFeedContentAutoVideo() != null) {
                                if (linkedList == null) {
                                    linkedList = new LinkedList();
                                }
                                linkedList.add(normalAbsFeedView2.getFeedContentAutoVideo());
                            }
                            if (!z16 && (feedScrollContainer = normalAbsFeedView2.getFeedScrollContainer()) != null && feedScrollContainer.hasUsed()) {
                                feedScrollContainer.preScrollContent(baseAdapter);
                            }
                        }
                    } else if (childAt != null && (childAt instanceof FriendVideoFeedView)) {
                        if (com.qzone.adapter.feedcomponent.i.H().m() && (playVideoOnFeedListIdle = ((FriendVideoFeedView) childAt).getPlayVideoOnFeedListIdle()) != null) {
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                            }
                            linkedList.addAll(playVideoOnFeedListIdle);
                        }
                    } else if (childAt != null && (childAt instanceof FrdLikeVideoFeedView)) {
                        if (com.qzone.adapter.feedcomponent.i.H().m()) {
                            FrdLikeVideoFeedView frdLikeVideoFeedView = (FrdLikeVideoFeedView) childAt;
                            List<BaseVideo> playVideoOnFeedListIdle2 = frdLikeVideoFeedView.getPlayVideoOnFeedListIdle();
                            frdLikeVideoFeedView.resetPlayState();
                            if (playVideoOnFeedListIdle2 != null) {
                                if (linkedList == null) {
                                    linkedList = new LinkedList();
                                }
                                linkedList.addAll(playVideoOnFeedListIdle2);
                            }
                        }
                    } else if (childAt != null && (childAt instanceof QZoneOldFrdHotVideoFeedListView)) {
                        if (com.qzone.adapter.feedcomponent.i.H().m() && (currentVideoView = ((QZoneOldFrdHotVideoFeedListView) childAt).getCurrentVideoView()) != null) {
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                            }
                            linkedList.add(currentVideoView);
                        }
                    } else if (childAt != null && (childAt instanceof FeedAdvContainer)) {
                        FeedAdvContainer feedAdvContainer = (FeedAdvContainer) childAt;
                        FeedView currentFeedView = feedAdvContainer.getCurrentFeedView();
                        if (currentFeedView != null) {
                            if (currentFeedView.isAlwaysAutoPlayFeed() || (com.qzone.adapter.feedcomponent.i.H().m() && currentFeedView.isAutoVideoFeed() && currentFeedView.canLiveFeedAutoPlay())) {
                                z17 = true;
                            }
                            if (z17) {
                                if (linkedList == null) {
                                    linkedList = new LinkedList();
                                }
                                linkedList.add(currentFeedView.getAutoVideoView());
                            }
                            feedAdvContainer.preScrollContent(baseAdapter);
                        }
                    } else if (frameLayout != null && (feedsCoverVideo = getFeedsCoverVideo(childAt, frameLayout)) != null && com.qzone.adapter.feedcomponent.i.H().m()) {
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                        }
                        linkedList.add(feedsCoverVideo);
                    }
                }
                if (linkedList != null) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        if (((BaseVideo) it.next()) == null) {
                            it.remove();
                        }
                    }
                    BaseVideoManager.getFeedVideoManager().D(linkedList);
                }
            }
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void onListViewScrolling(ViewGroup viewGroup) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt != null && (childAt instanceof AbsFeedView)) {
                    ((AbsFeedView) childAt).onStateScrolling();
                } else if (childAt != null && (childAt instanceof FeedAdvContainer)) {
                    ((FeedAdvContainer) childAt).onStateScrolling();
                } else if (childAt != null && (childAt instanceof FrdLikeVideoSlideFeedView)) {
                    ((FrdLikeVideoSlideFeedView) childAt).onStateScrolling();
                } else if (childAt != null && (childAt instanceof FrdLikeVideoFeedView)) {
                    ((FrdLikeVideoFeedView) childAt).onStateScrolling();
                } else if (childAt != null && (childAt instanceof LinearLayout) && childAt.getId() == j.O(2608)) {
                    handleDetailCommentOnScrolling((ViewGroup) childAt);
                }
            }
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void onThemeColorChange() {
            FeedGlobalEnv.g().postRunnableToNormalThread(new Runnable() { // from class: com.qzone.module.feedcomponent.a
                @Override // java.lang.Runnable
                public final void run() {
                    FeedcomponentModule.AnonymousClass1.lambda$onThemeColorChange$0();
                }
            });
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void onUserActionReportCickListener(View view, FeedElement feedElement, BusinessFeedData businessFeedData, int i3, Object obj, int i16) {
            UserActionReportHelper.userActionReportClickListener(view, feedElement, businessFeedData, i3, obj, i16);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public String parseCommentTextAreaCommentText(User user, String str) {
            return CommentTextArea.parseCommentText(user, str);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public String parseCommentTextAreaReplyText(Reply reply) {
            return CommentTextArea.parseReplyText(reply);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void preCalculateData(BusinessFeedData businessFeedData, boolean z16) {
            DataPreCalculateTool.preCalculate(businessFeedData, z16);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void recyleFeedView(boolean z16, int i3) {
            ViewLoader.getInstance().recyleFeedView(z16, i3);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void replaceVideoInfoIfNecessary(BusinessFeedData businessFeedData) {
            FeedManager.replaceVideoInfoIfNecessary(businessFeedData);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void setFeedViewData(Context context, AbsFeedView absFeedView, BusinessFeedData businessFeedData, boolean z16) {
            FeedViewBuilder.setFeedViewData(context, absFeedView, businessFeedData, z16);
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void setMyFeedViewData(AbsFeedView absFeedView, BusinessFeedData businessFeedData, boolean z16) {
            MyFeedViewBuilder.setFeedViewData(absFeedView, businessFeedData, z16);
        }

        public void updateFollowInfo(AbsFeedView absFeedView, BusinessFeedData businessFeedData, long j3, boolean z16) {
            if (!(absFeedView instanceof NormalAbsFeedView)) {
                if (absFeedView instanceof FeedAdvContainer) {
                    absFeedView.updateFollowInfo(null, j3, z16);
                }
            } else {
                if (businessFeedData == null || businessFeedData.getUser().uin != j3) {
                    return;
                }
                businessFeedData.getFeedCommInfo().isFollowed = z16;
                absFeedView.updateFollowInfo(businessFeedData, j3, z16);
            }
        }

        private void handleDetailCommentOnIdle(ViewGroup viewGroup) {
            if (viewGroup == null || viewGroup.getChildCount() <= 0) {
                return;
            }
            ExtendGridView extendGridView = (ExtendGridView) viewGroup.findViewById(j.O(2256));
            if (extendGridView != null) {
                for (int i3 = 0; i3 < extendGridView.getChildCount(); i3++) {
                    View childAt = extendGridView.getChildAt(i3);
                    if (childAt != null && (childAt instanceof FeedGifView)) {
                        ((FeedGifView) childAt).onStateIdle();
                    }
                }
            }
            CellTextView cellTextView = (CellTextView) viewGroup.findViewById(j.O(2253));
            if (cellTextView != null) {
                cellTextView.onStateIdle();
            }
        }

        private void handleDetailCommentOnScrolling(ViewGroup viewGroup) {
            if (viewGroup == null || viewGroup.getChildCount() <= 0) {
                return;
            }
            ExtendGridView extendGridView = (ExtendGridView) viewGroup.findViewById(j.O(2256));
            if (extendGridView != null) {
                for (int i3 = 0; i3 < extendGridView.getChildCount(); i3++) {
                    View childAt = extendGridView.getChildAt(i3);
                    if (childAt != null && (childAt instanceof FeedGifView)) {
                        ((FeedGifView) childAt).onScrolling();
                    }
                }
            }
            CellTextView cellTextView = (CellTextView) viewGroup.findViewById(j.O(2253));
            if (cellTextView != null) {
                cellTextView.onStateScrolling();
            }
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void updateCardAddFriendItemState(AbsFeedView absFeedView, String str) {
            BusinessFeedData businessFeedData;
            CanvasQzoneCardView qzoneCardView;
            if (absFeedView == null || (businessFeedData = absFeedView.mFeedData) == null || !businessFeedData.isQzoneCardFeed() || !(absFeedView instanceof NormalAbsFeedView) || (qzoneCardView = ((NormalAbsFeedView) absFeedView).getQzoneCardView()) == null) {
                return;
            }
            qzoneCardView.updateFriendUI();
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void onListViewIdleWithPanorama(ViewGroup viewGroup, ListAdapter listAdapter) {
            if (viewGroup == null) {
                return;
            }
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt != null && (childAt instanceof NormalAbsFeedView)) {
                    NormalAbsFeedView normalAbsFeedView = (NormalAbsFeedView) childAt;
                    PanoramaLayout feedPanoramaView = normalAbsFeedView.getFeedPanoramaView();
                    if (feedPanoramaView != null && feedPanoramaView.B() != null && com.qzone.adapter.feedcomponent.i.H().m()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(feedPanoramaView);
                    }
                    FeedGiftLayout feedGiftLayout = normalAbsFeedView.getFeedGiftLayout();
                    if (feedGiftLayout != null) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(feedGiftLayout);
                    }
                    FeedScrollContainerArea feedScrollContainer = normalAbsFeedView.getFeedScrollContainer();
                    if (feedScrollContainer != null && feedScrollContainer.hasUsed()) {
                        feedScrollContainer.preScrollContent(listAdapter);
                    }
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                int size = arrayList.size();
                if (size == 1) {
                    PanoramaLayout panoramaLayout = (PanoramaLayout) arrayList.get(0);
                    if (panoramaLayout != null) {
                        panoramaLayout.setPanoramaPlaying(true);
                        panoramaLayout.Q();
                        return;
                    }
                    return;
                }
                int screenWidth = (int) (((FeedGlobalEnv.g().getScreenWidth() - (AreaConst.dp10 * 2)) * 9) / 16.0f);
                int screenHeight = FeedGlobalEnv.g().getScreenHeight();
                boolean z16 = false;
                for (int i3 = 0; i3 < size; i3++) {
                    PanoramaLayout panoramaLayout2 = (PanoramaLayout) arrayList.get(i3);
                    if (panoramaLayout2 != null) {
                        int[] iArr = new int[2];
                        panoramaLayout2.getLocationOnScreen(iArr);
                        int i16 = iArr[1];
                        if (i16 > AreaConst.dp30 && i16 + screenWidth < screenHeight && !z16) {
                            panoramaLayout2.setPanoramaPlaying(true);
                            panoramaLayout2.Q();
                            z16 = true;
                        } else {
                            panoramaLayout2.setPanoramaPlaying(false);
                        }
                    }
                }
            }
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            int size2 = arrayList2.size();
            int screenWidth2 = (int) (((FeedGlobalEnv.g().getScreenWidth() - (AreaConst.dp8 * 2)) * 9) / 16.0f);
            int screenHeight2 = FeedGlobalEnv.g().getScreenHeight();
            for (int i17 = size2 - 1; i17 >= 0; i17--) {
                FeedGiftLayout feedGiftLayout2 = (FeedGiftLayout) arrayList2.get(i17);
                if (feedGiftLayout2 != null) {
                    int[] iArr2 = new int[2];
                    feedGiftLayout2.getLocationOnScreen(iArr2);
                    int i18 = iArr2[1];
                    if (i18 > AreaConst.dp30 && i18 + screenWidth2 < screenHeight2) {
                        feedGiftLayout2.t();
                        return;
                    }
                }
            }
        }

        public void reset(View view) {
            if (view != null && (view instanceof FeedGoods)) {
                ((FeedGoods) view).reset();
            }
        }

        public void update(View view) {
            if (view != null && (view instanceof FeedGoods)) {
                ((FeedGoods) view).update();
            }
        }

        @Override // com.qzone.proxy.feedcomponent.i
        public void updateRecommenAddFriendItemState(AbsFeedView absFeedView, String str) {
            if (absFeedView != null && (absFeedView instanceof FeedAdvContainer)) {
                ((FeedAdvContainer) absFeedView).updateRecommendFriendsUI(str);
            }
        }

        private BaseVideo getBastVideo(FrameLayout frameLayout) {
            View childAt;
            View childAt2;
            if (frameLayout != null && frameLayout.getChildCount() != 0 && (childAt = frameLayout.getChildAt(0)) != null && (childAt instanceof RelativeLayout)) {
                RelativeLayout relativeLayout = (RelativeLayout) childAt;
                if (relativeLayout.getChildCount() > 0 && (childAt2 = relativeLayout.getChildAt(0)) != null && (childAt2 instanceof BaseVideo)) {
                    return (BaseVideo) childAt2;
                }
            }
            return null;
        }

        public void setFeedData(View view, BusinessFeedData businessFeedData) {
            if (view == null || businessFeedData == null || !(view instanceof FeedGoods)) {
                return;
            }
            FeedGoods feedGoods = (FeedGoods) view;
            feedGoods.setFeedActiveAdvData(businessFeedData.getActiveAdv());
            feedGoods.update();
        }

        public void setOnFeedElementClickListener(View view, g gVar) {
            if (view == null || gVar == null || !(view instanceof FeedGoods)) {
                return;
            }
            ((FeedGoods) view).setOnFeedElementClickListener(gVar);
        }

        private BaseVideo getFeedsCoverVideo(View view, FrameLayout frameLayout) {
            if (frameLayout == null || view == null || !(view instanceof ViewGroup)) {
                return null;
            }
            return getBastVideo((FrameLayout) ((ViewGroup) view).findViewById(frameLayout.getId()));
        }
    }

    @Override // com.qzone.module.Proxy, com.qzone.module.IProxy
    public h getServiceInterface() {
        return this.iComponentService;
    }

    @Override // com.qzone.module.Proxy, com.qzone.module.IProxy
    public i getUiInterface() {
        return this.iComponentUI;
    }
}
