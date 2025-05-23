package com.qzone.module.feedcomponent.actionreport;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import com.qzone.module.feedcomponent.actionreport.control.FeedActionRecorder;
import com.qzone.module.feedcomponent.ui.FeedAdvContainer;
import com.qzone.module.feedcomponent.ui.FeedContainer;
import com.qzone.module.feedcomponent.ui.FeedGalleryContainer;
import com.qzone.module.feedcomponent.ui.FeedScrollContainerArea;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.module.feedcomponent.ui.FriendAnniversaryFeedView;
import com.qzone.module.feedcomponent.ui.FunctionGuideFeedView;
import com.qzone.module.feedcomponent.ui.NegativeFeedbackFeedView;
import com.qzone.module.feedcomponent.ui.QzoneSecretFeedView;
import com.qzone.module.feedcomponent.ui.RegisterAnniversaryFeedView;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasFeedContentView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UserActionReportHelper {
    public static int SCROLL_STATE_FLING = 2;
    public static int SCROLL_STATE_IDLE = 0;
    static boolean feedSrollFlinged = false;
    static BusinessFeedData floatVideoFeedData = null;
    static int floatVideoFeedPos = -1;
    static boolean isFromFloatViewQzoneShare;
    static boolean isNeedReport;
    static boolean isSuperLike;
    static BusinessFeedData mFeedData;
    static int mFeedIndex;
    static boolean startedFastReport;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.module.feedcomponent.actionreport.UserActionReportHelper$12, reason: invalid class name */
    /* loaded from: classes39.dex */
    public static /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement;

        static {
            int[] iArr = new int[FeedElement.values().length];
            $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement = iArr;
            try {
                iArr[FeedElement.PRAISE_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.SUPERLIKE_ANIMATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.COMMENT_BUTTON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.REPLY_BUTTON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.COMMENT_GUIDE_ITEM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.RAPID_COMMENT_IMMEDIATELY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.COMMENT_ITEM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.VISIT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.ORIGINAL_NICKNAME.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.ORIGINAL_SUMMARY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.FORWARD_BUTTON.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.USER_AVATAR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.CONTAINER_USER_AVATAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.SUMMARY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.CONTENT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.PHOTO.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.USER_NICKNAME.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.FRIEND_NICKNAME.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.CONTAINER_USER_NICKNAME.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.ACTION_BUTTON.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.FEEDBACK.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.AUTO_VIDEO_ADV_GET_MORE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.LEFT_THUMB_PIC.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.LEFT_THUMB.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.VIDEO_REMARK.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.CONTENT_EXTERNAL_URL_CLICK.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.AUTO_VIDEO.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.PRAISE_LIST.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.PLAYBAR.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.DROPDOWN_BUTTON.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.FEED_SUGGEST_MORE.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.FEED_ADD_FRIEND.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.HIGH_FIVE_BUTTON.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.REPLY_ITEM.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.FOLLOW_CONTAINER_USER.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[FeedElement.COMMENT_PRAISE_BUTTON.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
        }
    }

    public static void containerOnTouchEvent(final MotionEvent motionEvent, final Object obj) {
        FeedGlobalEnv.g().postRunnableToTTTThread(new Runnable() { // from class: com.qzone.module.feedcomponent.actionreport.UserActionReportHelper.10
            @Override // java.lang.Runnable
            public void run() {
                UserActionReportHelper.realContainerOnTouchEvent(motionEvent, obj);
            }
        });
    }

    public static void doCommentActionReport(final int i3) {
        FeedGlobalEnv.g().postRunnableToTTTThread(new Runnable() { // from class: com.qzone.module.feedcomponent.actionreport.UserActionReportHelper.2
            @Override // java.lang.Runnable
            public void run() {
                UserActionReportHelper.realDoCommentActionReport(i3);
            }
        });
    }

    public static void doFloatViewActionReport(final int i3) {
        FeedGlobalEnv.g().postRunnableToTTTThread(new Runnable() { // from class: com.qzone.module.feedcomponent.actionreport.UserActionReportHelper.11
            @Override // java.lang.Runnable
            public void run() {
                UserActionReportHelper.realDoFloatViewActionReport(i3);
            }
        });
    }

    public static void doQzoneCommentActionReport(int i3, int i16) {
        if (isFromFloatViewQzoneShare) {
            isFromFloatViewQzoneShare = false;
            if (i3 == 26) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedClickReport", "float view open qzone comment cancel");
                }
                FeedActionRecorder.getInstance().addActionPageType(mFeedData, mFeedIndex, System.currentTimeMillis(), i16, 5, 3);
            } else {
                if (i3 != 27) {
                    return;
                }
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedClickReport", "float view open qzone comment finish");
                }
                FeedActionRecorder.getInstance().addActionPageType(mFeedData, mFeedIndex, System.currentTimeMillis(), i16, 5, 4);
            }
        }
    }

    public static void feedAdvContainerPageSelected(final int i3, final int i16, final Object obj) {
        FeedGlobalEnv.g().postRunnableToTTTThread(new Runnable() { // from class: com.qzone.module.feedcomponent.actionreport.UserActionReportHelper.9
            @Override // java.lang.Runnable
            public void run() {
                UserActionReportHelper.realFeedAdvContainerPageSelected(i3, i16, obj);
            }
        });
    }

    public static void feedContainerOverScroll(final int i3, final int i16, final boolean z16, final boolean z17, final int i17, final Object obj) {
        FeedGlobalEnv.g().postRunnableToTTTThread(new Runnable() { // from class: com.qzone.module.feedcomponent.actionreport.UserActionReportHelper.8
            @Override // java.lang.Runnable
            public void run() {
                UserActionReportHelper.realFeedContainerOverScroll(i3, i16, z16, z17, i17, obj);
            }
        });
    }

    public static void feedScrollAction(final ViewGroup viewGroup, final Adapter adapter, final int i3, final int i16, final int i17, final int i18) {
        FeedGlobalEnv.g().postRunnableToTTTThread(new Runnable() { // from class: com.qzone.module.feedcomponent.actionreport.UserActionReportHelper.4
            @Override // java.lang.Runnable
            public void run() {
                UserActionReportHelper.realFeedScrollAction(viewGroup, adapter, i3, i16, i17, i18);
            }
        });
    }

    public static void feedScrollStateChangedAction(final ViewGroup viewGroup, final Adapter adapter, final int i3, final boolean z16, final int i16) {
        FeedGlobalEnv.g().postRunnableToTTTThread(new Runnable() { // from class: com.qzone.module.feedcomponent.actionreport.UserActionReportHelper.5
            @Override // java.lang.Runnable
            public void run() {
                UserActionReportHelper.realFeedScrollStateChangedAction(viewGroup, adapter, i3, z16, i16);
            }
        });
    }

    public static void friendFeedActivityResume(final ViewGroup viewGroup, final Adapter adapter, final int i3) {
        FeedGlobalEnv.g().postRunnableToTTTThread(new Runnable() { // from class: com.qzone.module.feedcomponent.actionreport.UserActionReportHelper.6
            @Override // java.lang.Runnable
            public void run() {
                UserActionReportHelper.realFriendFeedActivityResume(viewGroup, adapter, i3);
            }
        });
    }

    public static void friendFeedActivityStop(final ViewGroup viewGroup, final Adapter adapter, final int i3) {
        FeedGlobalEnv.g().postRunnableToTTTThread(new Runnable() { // from class: com.qzone.module.feedcomponent.actionreport.UserActionReportHelper.7
            @Override // java.lang.Runnable
            public void run() {
                UserActionReportHelper.realFriendFeedActivityStop(viewGroup, adapter, i3);
            }
        });
    }

    static int getFeedViewPosition(ViewGroup viewGroup, View view) {
        if (view instanceof AbsFeedView) {
            ((AbsFeedView) view).getHeadViewCount();
        }
        if (view == null) {
            return -1;
        }
        if (view instanceof FeedView) {
            return ((FeedView) view).getMFeedPosition();
        }
        if (view instanceof FeedContainer) {
            return ((FeedContainer) view).getMFeedPosition();
        }
        if (view instanceof FeedAdvContainer) {
            return ((FeedAdvContainer) view).getMFeedPosition();
        }
        if (view instanceof FeedScrollContainerArea) {
            return ((FeedScrollContainerArea) view).getFeedPosition();
        }
        if (view instanceof AbsFeedView) {
            return ((AbsFeedView) view).getMFeedPosition();
        }
        return -1;
    }

    public static boolean getReportFlag() {
        return isNeedReport;
    }

    public static void realContainerOnTouchEvent(MotionEvent motionEvent, Object obj) {
        if (isNeedReport) {
            ContainerLeftRightScrollReport.getInstance().containerOnTouchEvent(motionEvent, obj);
        }
    }

    public static void realDoCommentActionReport(int i3) {
        if (isNeedReport) {
            CommentActionReport.getInstance().doCommentActionReport(i3);
        }
    }

    static void realDoFloatViewActionReport(int i3) {
        if (mFeedData != null && getReportFlag()) {
            switch (i3) {
                case 6:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "float view cancel report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 7, 1);
                    break;
                case 7:
                    isFromFloatViewQzoneShare = true;
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 8, 1);
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "float view open qzone report");
                        break;
                    }
                    break;
                case 8:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "float view open QQ report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 9, 1);
                    break;
                case 9:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "float view open wechat report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 10, 1);
                    break;
                case 10:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "float view open wechat moments report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 11, 1);
                    break;
                case 11:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list cancel report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 39, 1);
                    break;
                case 12:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list share to qq report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 40, 1);
                    break;
                case 13:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list share to wechat report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 41, 1);
                    break;
                case 14:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list share to wechat moments report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 42, 1);
                    break;
                case 15:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list collect report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 43, 1);
                    break;
                case 16:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list collect cancle report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 44, 1);
                    break;
                case 17:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list reprint report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 51, 1);
                    break;
                case 18:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list hide single feed report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 45, 1);
                    break;
                case 19:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list hide friend feeds report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 46, 1);
                    break;
                case 21:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list delete report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 48, 1);
                    break;
                case 22:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list report report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 47, 1);
                    break;
                case 23:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list subscribe report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 49, 1);
                    break;
                case 24:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list unsubscribe report");
                    }
                    FeedActionRecorder.getInstance().addAction(mFeedData, mFeedIndex, System.currentTimeMillis(), 50, 1);
                    break;
            }
            mFeedData = null;
        }
    }

    public static void realFeedAdvContainerPageSelected(int i3, int i16, Object obj) {
        if (isNeedReport) {
            ContainerLeftRightScrollReport.getInstance().feedAdvContainerPageSelected(i3, i16, obj);
        }
    }

    public static void realFeedContainerOverScroll(int i3, int i16, boolean z16, boolean z17, int i17, Object obj) {
        if (isNeedReport) {
            ContainerLeftRightScrollReport.getInstance().feedContainerOverScroll(i3, i16, z16, z17, i17, obj);
        }
    }

    public static void realFeedScrollAction(ViewGroup viewGroup, Adapter adapter, int i3, int i16, int i17, int i18) {
        if (!startedFastReport && isNeedReport && FeedScrollActionReport.getInstance().reportHzEnough()) {
            if (FeedScrollActionReport.getInstance().getLastReportTime() != -1) {
                addLostScrollFeedLineReport(viewGroup, adapter, System.currentTimeMillis() - FeedScrollActionReport.getInstance().getLastReportTime(), i18);
            }
            FeedScrollActionReport.getInstance().setReportTime();
        }
    }

    public static void realFeedScrollStateChangedAction(ViewGroup viewGroup, Adapter adapter, int i3, boolean z16, int i16) {
        int mFeedPosition;
        if (isNeedReport) {
            if (i3 == SCROLL_STATE_FLING) {
                feedSrollFlinged = true;
                if (startedFastReport) {
                    return;
                }
                startedFastReport = true;
                View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                if (childAt instanceof FeedView) {
                    mFeedPosition = ((FeedView) childAt).getMFeedPosition();
                } else if (childAt instanceof FeedContainer) {
                    mFeedPosition = ((FeedContainer) childAt).getMFeedPosition();
                } else if (childAt instanceof FeedAdvContainer) {
                    mFeedPosition = ((FeedAdvContainer) childAt).getMFeedPosition();
                } else {
                    mFeedPosition = childAt instanceof AbsFeedView ? ((AbsFeedView) childAt).getMFeedPosition() : -1;
                }
                for (int i17 = 0; i17 < viewGroup.getChildCount(); i17++) {
                    View childAt2 = viewGroup.getChildAt(i17);
                    if (childAt2 instanceof FeedView) {
                        FeedScrollActionReport.getInstance().setFastScrollStartTimeAndFeedIndex(System.currentTimeMillis(), ((FeedView) childAt2).getMFeedPosition(), mFeedPosition);
                        return;
                    }
                    if (childAt2 instanceof FeedAdvContainer) {
                        FeedScrollActionReport.getInstance().setFastScrollStartTimeAndFeedIndex(System.currentTimeMillis(), ((FeedAdvContainer) childAt2).getMFeedPosition(), mFeedPosition);
                        return;
                    }
                    if (childAt2 instanceof FeedContainer) {
                        FeedScrollActionReport.getInstance().setFastScrollStartTimeAndFeedIndex(System.currentTimeMillis(), ((FeedContainer) childAt2).getMFeedPosition(), mFeedPosition);
                        return;
                    }
                    if (childAt2 instanceof AbsFeedView) {
                        AbsFeedView absFeedView = (AbsFeedView) childAt2;
                        if (absFeedView.getMFeedPosition() > -1) {
                            FeedScrollActionReport.getInstance().setFastScrollStartTimeAndFeedIndex(System.currentTimeMillis(), absFeedView.getMFeedPosition(), mFeedPosition);
                            return;
                        }
                    }
                }
                return;
            }
            if (feedSrollFlinged && i3 == SCROLL_STATE_IDLE) {
                feedSrollFlinged = false;
                if (startedFastReport) {
                    long finshFastScroll = FeedScrollActionReport.getInstance().finshFastScroll(viewGroup, adapter, System.currentTimeMillis());
                    FeedScrollActionReport.getInstance().setReportTime();
                    addLostScrollFeedLineReport(viewGroup, adapter, finshFastScroll, i16);
                    startedFastReport = false;
                }
            }
        }
    }

    public static void realFriendFeedActivityResume(ViewGroup viewGroup, Adapter adapter, int i3) {
        if (isNeedReport) {
            for (int i16 = 0; i16 < viewGroup.getChildCount(); i16++) {
                View childAt = viewGroup.getChildAt(i16);
                if (childAt instanceof FeedView) {
                    FeedView feedView = (FeedView) childAt;
                    FeedScrollActionReport.getInstance().feedFriendActivitySwitchReport(feedView, feedView.getMFeedPosition(), true, i3);
                } else if ((childAt instanceof FeedContainer) || (childAt instanceof FeedAdvContainer) || (childAt instanceof NegativeFeedbackFeedView) || (childAt instanceof FunctionGuideFeedView) || (childAt instanceof FriendAnniversaryFeedView) || (childAt instanceof FeedGalleryContainer) || (childAt instanceof RegisterAnniversaryFeedView)) {
                    AbsFeedView absFeedView = (AbsFeedView) childAt;
                    FeedScrollActionReport.getInstance().feedContainerActivitySwitchReported(absFeedView, absFeedView.getMFeedPosition(), true, i3);
                }
            }
        }
    }

    public static void realFriendFeedActivityStop(ViewGroup viewGroup, Adapter adapter, int i3) {
        if (isNeedReport) {
            for (int i16 = 0; i16 < viewGroup.getChildCount(); i16++) {
                View childAt = viewGroup.getChildAt(i16);
                if (childAt instanceof FeedView) {
                    FeedView feedView = (FeedView) childAt;
                    FeedScrollActionReport.getInstance().feedFriendActivitySwitchReport(feedView, feedView.getMFeedPosition(), false, i3);
                } else if ((childAt instanceof FeedContainer) || (childAt instanceof FeedAdvContainer) || (childAt instanceof FunctionGuideFeedView) || (childAt instanceof FriendAnniversaryFeedView) || (childAt instanceof FeedGalleryContainer) || (childAt instanceof QzoneSecretFeedView) || (childAt instanceof RegisterAnniversaryFeedView)) {
                    AbsFeedView absFeedView = (AbsFeedView) childAt;
                    FeedScrollActionReport.getInstance().feedContainerActivitySwitchReported(absFeedView, absFeedView.getMFeedPosition(), false, i3);
                }
            }
            FeedScrollActionReport.getInstance().resetLastReportTime();
        }
    }

    public static void realVideoReport(BusinessFeedData businessFeedData, int i3, int i16, boolean z16, int i17) {
        if (isNeedReport) {
            if (i3 == -2) {
                i3 = floatVideoFeedPos;
                businessFeedData = floatVideoFeedData;
            }
            BusinessFeedData businessFeedData2 = businessFeedData;
            int i18 = i3;
            if (i16 == 1) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", " video start play");
                }
                FeedActionRecorder.getInstance().addAction(businessFeedData2, i18, System.currentTimeMillis(), i17, 14);
                return;
            }
            if (i16 == 2) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", " video stop play");
                }
                FeedActionRecorder.getInstance().addAction(businessFeedData2, i18, System.currentTimeMillis(), i17, 15);
                return;
            }
            if (i16 == 3) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", "click float video play");
                }
                FeedActionRecorder.getInstance().addAction(businessFeedData2, i18, System.currentTimeMillis(), i17, 16);
            } else if (i16 == 4) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", "click float video rePlay");
                }
                FeedActionRecorder.getInstance().addAction(businessFeedData2, i18, System.currentTimeMillis(), i17, 17);
            } else {
                if (i16 != 5) {
                    return;
                }
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", "click float video get more");
                }
                FeedActionRecorder.getInstance().addAction(businessFeedData2, i18, System.currentTimeMillis(), i17, 18);
            }
        }
    }

    static void saveFeedDataAndIndex(BusinessFeedData businessFeedData, int i3) {
        mFeedData = businessFeedData;
        mFeedIndex = i3;
    }

    public static void setReportFlag(boolean z16) {
        isNeedReport = z16;
    }

    public static void userActionReportClickListener(final View view, final FeedElement feedElement, final BusinessFeedData businessFeedData, final int i3, final Object obj, final int i16) {
        boolean z16 = false;
        if (feedElement == FeedElement.COMMENT_PRAISE_BUTTON && obj != null && (obj instanceof ClickedComment)) {
            Comment comment = ((ClickedComment) obj).getComment();
            if (comment != null) {
                z16 = comment.isliked;
            }
        } else if (businessFeedData != null && businessFeedData.getLikeInfo() != null) {
            z16 = businessFeedData.getLikeInfo().isLiked;
        }
        final boolean z17 = z16;
        FeedGlobalEnv.g().postRunnableToTTTThread(new Runnable() { // from class: com.qzone.module.feedcomponent.actionreport.UserActionReportHelper.1
            @Override // java.lang.Runnable
            public void run() {
                UserActionReportHelper.realUserActionReportClickListener(view, feedElement, businessFeedData, i3, obj, z17, i16);
            }
        });
    }

    public static void videoReport(final BusinessFeedData businessFeedData, final int i3, final int i16, final boolean z16, final int i17) {
        FeedGlobalEnv.g().postRunnableToTTTThread(new Runnable() { // from class: com.qzone.module.feedcomponent.actionreport.UserActionReportHelper.3
            @Override // java.lang.Runnable
            public void run() {
                UserActionReportHelper.realVideoReport(BusinessFeedData.this, i3, i16, z16, i17);
            }
        });
    }

    static void addLostScrollFeedLineReport(ViewGroup viewGroup, Adapter adapter, long j3, int i3) {
        View view;
        int i16 = 0;
        while (true) {
            if (i16 >= viewGroup.getChildCount()) {
                view = null;
                break;
            }
            view = viewGroup.getChildAt(i16);
            if ((view instanceof AbsFeedView) || (view instanceof FeedScrollContainerArea)) {
                break;
            } else {
                i16++;
            }
        }
        FeedScrollActionReport.getInstance().setVisibleFirstFeedPosition(getFeedViewPosition(viewGroup, view));
        FeedScrollActionReport.getInstance().setVisibleLastFeedPosition(getFeedViewPosition(viewGroup, viewGroup.getChildAt(viewGroup.getChildCount() - 1)));
        FeedScrollActionReport.getInstance().setCurrentVisibleFirstFeedBottomLineY(view, i3);
        if (FeedScrollActionReport.getInstance().isMovingUp()) {
            FeedScrollActionReport.getInstance().addLostLineReport(adapter, true, j3, viewGroup, i3);
        } else if (FeedScrollActionReport.getInstance().isMovingDown()) {
            FeedScrollActionReport.getInstance().addLostLineReport(adapter, false, j3, viewGroup, i3);
        }
    }

    public static void realUserActionReportClickListener(View view, FeedElement feedElement, BusinessFeedData businessFeedData, int i3, Object obj, boolean z16, int i16) {
        String str;
        if (isNeedReport) {
            switch (AnonymousClass12.$SwitchMap$com$qzone$proxy$feedcomponent$ui$FeedElement[feedElement.ordinal()]) {
                case 1:
                    if (isSuperLike) {
                        isSuperLike = false;
                        return;
                    }
                    if (z16) {
                        if (FeedGlobalEnv.g().isDebug()) {
                            Log.i("FeedClickReport", "praised cancel report");
                            return;
                        }
                        return;
                    } else {
                        if (FeedGlobalEnv.g().isDebug()) {
                            Log.i("FeedClickReport", "praised  report");
                            return;
                        }
                        return;
                    }
                case 2:
                    if (isSuperLike) {
                        return;
                    }
                    isSuperLike = true;
                    FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 2, 1);
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "super like  report");
                        return;
                    }
                    return;
                case 3:
                case 4:
                    CommentActionReport.getInstance().setCommentReportInfo(businessFeedData, i3, 1, i16);
                    CommentActionReport.getInstance().doCommentActionReport(25);
                    return;
                case 5:
                    CommentActionReport.getInstance().setCommentReportInfo(businessFeedData, i3, 2, i16);
                    CommentActionReport.getInstance().doCommentActionReport(25);
                    return;
                case 6:
                    CommentActionReport.getInstance().setCommentReportInfo(businessFeedData, i3, 3, i16);
                    CommentActionReport.getInstance().doCommentActionReport(25);
                    return;
                case 7:
                    CommentActionReport.getInstance().setCommentReportInfo(businessFeedData, i3, 5, i16);
                    CommentActionReport.getInstance().doCommentActionReport(25);
                    return;
                case 8:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "visit list  click report");
                    }
                    FeedActionRecorder.getInstance().addAction(businessFeedData, i3, System.currentTimeMillis(), 37, 1);
                    return;
                case 9:
                    FeedActionRecorder.getInstance().addAction(businessFeedData, i3, System.currentTimeMillis(), 67, 1);
                    return;
                case 10:
                    FeedActionRecorder.getInstance().addAction(businessFeedData, i3, System.currentTimeMillis(), 68, 1);
                    return;
                case 11:
                    CommentActionReport.getInstance().setCommentReportInfo(businessFeedData, i3, 4, i16);
                    CommentActionReport.getInstance().doCommentActionReport(25);
                    return;
                case 12:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "user Avatar button click report");
                        return;
                    }
                    return;
                case 13:
                    if (obj instanceof Integer) {
                        ((Integer) obj).intValue();
                    }
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "container user avatar click report");
                        return;
                    }
                    return;
                case 14:
                case 33:
                case 34:
                default:
                    return;
                case 15:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "content area click report");
                        return;
                    }
                    return;
                case 16:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "photo click report");
                    }
                    if (businessFeedData != null && QZoneAdFeedDataExtKt.isGDTForwardFeed(businessFeedData) && (view instanceof CanvasFeedContentView) && ((CanvasFeedContentView) view).isForward) {
                        FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 69, 1);
                        return;
                    }
                    return;
                case 17:
                case 18:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "nickname click report");
                        return;
                    }
                    return;
                case 19:
                    if (obj instanceof Integer) {
                        ((Integer) obj).intValue();
                    }
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "container nickname click report");
                        return;
                    }
                    return;
                case 20:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "action button click report");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 22, 1);
                    return;
                case 21:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "feedBack click report");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 24, 1);
                    return;
                case 22:
                    videoReport(businessFeedData, i3, 5, true, 20);
                    return;
                case 23:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "left pic click report");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 31, 1);
                    return;
                case 24:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "right text click report");
                    }
                    if (businessFeedData != null && businessFeedData.feedType == 4098) {
                        FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 70, 1);
                        return;
                    } else {
                        FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 32, 1);
                        return;
                    }
                case 25:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "video external url click report");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 33, 1);
                    return;
                case 26:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "content external url click report");
                    }
                    FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 34, 1);
                    return;
                case 27:
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "Video click float play report");
                    }
                    floatVideoFeedPos = i3;
                    floatVideoFeedData = businessFeedData;
                    videoReport(businessFeedData, i3, 3, false, 20);
                    return;
                case 28:
                    FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 36, 1);
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "Praise list click report");
                        return;
                    }
                    return;
                case 29:
                    if (!(obj instanceof Integer) || businessFeedData == null) {
                        return;
                    }
                    int intValue = ((Integer) obj).intValue();
                    if (intValue == 0) {
                        if (FeedGlobalEnv.g().isDebug()) {
                            Log.i("FeedClickReport", "Friend play left picture click report");
                        }
                        FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 27, 1);
                        return;
                    } else {
                        if (intValue == 1) {
                            if (FeedGlobalEnv.g().isDebug()) {
                                Log.i("FeedClickReport", "Friend play right picture click report");
                            }
                            FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 28, 1);
                            return;
                        }
                        return;
                    }
                case 30:
                    FeedActionRecorder.getInstance().addAction(businessFeedData, i3, System.currentTimeMillis(), i16, 85, 1);
                    saveFeedDataAndIndex(businessFeedData, i3);
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedClickReport", "dropdown menu list click report");
                        return;
                    }
                    return;
                case 31:
                    FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 53, 1);
                    return;
                case 32:
                    FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, 86, 1);
                    return;
                case 35:
                    int intValue2 = obj instanceof Integer ? ((Integer) obj).intValue() + 1 : 0;
                    if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
                        return;
                    }
                    boolean z17 = businessFeedData.getFeedCommInfo().isFollowed;
                    int i17 = z17 ? 202 : 201;
                    if (FeedGlobalEnv.g().isDebug()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("container ");
                        if (z17) {
                            str = IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW;
                        } else {
                            str = "follow";
                        }
                        sb5.append(str);
                        sb5.append(" button click report");
                        Log.i("FeedClickReport", sb5.toString());
                    }
                    FeedActionRecorder.getInstance().addAction(businessFeedData, i3, System.currentTimeMillis(), i16, i17, 1, intValue2, false, null, businessFeedData.getFeedCommInfo().isRealTimeTTTReport(), 0L);
                    return;
                case 36:
                    if (businessFeedData == null || businessFeedData.feedType != 4098 || businessFeedData.getMainComment() == null) {
                        return;
                    }
                    FeedActionRecorder.getInstance().addActionPageType(businessFeedData, i3, System.currentTimeMillis(), i16, z16 ? 3 : 210, 1);
                    return;
            }
        }
    }
}
