package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QFSVideoControlEvent;
import com.tencent.biz.qqcircle.immersive.gallery.view.QFSGalleryProgressViewNoAnim;
import com.tencent.biz.qqcircle.immersive.report.QFSImageBannerReport;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.qqcircle.widgets.multitouchimg.QCircleMultiTouchImageView;
import com.tencent.biz.richframework.animation.transition.TransitionDragLayout;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u001b\b\u0007\u0012\u0006\u0010)\u001a\u00020&\u0012\b\b\u0002\u0010,\u001a\u00020\u0017\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u0005H\u0002J\u001a\u0010$\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\tH\u0002R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010+R\u0016\u0010I\u001a\u0004\u0018\u00010F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u0004\u0018\u00010F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010U\u00a8\u0006Y"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/bj;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/Observer;", "Le30/b;", "", "getLogTag", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartStop", "onPartDestroy", "feedBlockData", "R9", "X9", "W9", "V9", "", "isPlaying", "aa", "show", "Y9", "L9", "initBanner", "", com.tencent.luggage.wxa.c8.c.G, "Z9", "N9", "O9", "view", "M9", "U9", "Lfeedcloud/FeedCloudMeta$StFeed;", "d", "Lfeedcloud/FeedCloudMeta$StFeed;", "mFeed", "e", "Z", "mFromPicFeed", "Lcom/tencent/biz/qqcircle/immersive/views/banner/QFSImageBanner;", "f", "Lcom/tencent/biz/qqcircle/immersive/views/banner/QFSImageBanner;", "mBanner", tl.h.F, "Landroid/view/View;", "mIvClose", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mPlayOrPauseView", "Lcom/tencent/biz/qqcircle/immersive/gallery/view/QFSGalleryProgressViewNoAnim;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/gallery/view/QFSGalleryProgressViewNoAnim;", "mProgressView", "Lcom/tencent/biz/qqcircle/immersive/report/QFSImageBannerReport;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/report/QFSImageBannerReport;", "mBannerReport", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mTvPosition", "E", "mAutoPlay", "Landroid/graphics/drawable/Drawable;", UserInfo.SEX_FEMALE, "Landroid/graphics/drawable/Drawable;", "mPauseDrawable", "G", "mPlayDrawable", "", "H", "J", "mStartTime", "Lcom/tencent/biz/qqcircle/immersive/views/banner/f;", "I", "Lcom/tencent/biz/qqcircle/immersive/views/banner/f;", "mBannerAdapter", "Lcom/tencent/biz/qqcircle/widgets/multitouchimg/QCircleMultiTouchImageView;", "Lcom/tencent/biz/qqcircle/widgets/multitouchimg/QCircleMultiTouchImageView;", "mCurrentImageView", "<init>", "(Lfeedcloud/FeedCloudMeta$StFeed;Z)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class bj extends u implements View.OnClickListener, Observer<e30.b> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QFSImageBannerReport mBannerReport;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mTvPosition;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mAutoPlay;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final Drawable mPauseDrawable;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private final Drawable mPlayDrawable;

    /* renamed from: H, reason: from kotlin metadata */
    private long mStartTime;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.biz.qqcircle.immersive.views.banner.f mBannerAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private QCircleMultiTouchImageView mCurrentImageView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FeedCloudMeta$StFeed mFeed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean mFromPicFeed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QFSImageBanner mBanner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mIvClose;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mPlayOrPauseView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QFSGalleryProgressViewNoAnim mProgressView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/bj$a", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            RFWLog.i(bj.this.getTAG(), RFWLog.USR, "[onPageSelected] -> position = " + position);
            w20.a.j().t(bj.this.mFeed.f398449id.get(), position);
            bj bjVar = bj.this;
            bjVar.M9(bjVar.mBannerAdapter.w0(), position);
            bj.this.Z9(position);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/bj$c", "Lcom/tencent/biz/richframework/animation/transition/TransitionDragLayout$OnDragListener;", "", "onStartDrag", "onDragging", "", "isDragToClose", "onEndDrag", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements TransitionDragLayout.OnDragListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TransitionDragLayout f87763b;

        c(TransitionDragLayout transitionDragLayout) {
            this.f87763b = transitionDragLayout;
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionDragLayout.OnDragListener
        public void onDragging() {
            this.f87763b.setBackgroundColor(0);
            bj.this.Y9(false);
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionDragLayout.OnDragListener
        public void onEndDrag(boolean isDragToClose) {
            if (isDragToClose) {
                bj.this.L9();
            } else {
                this.f87763b.setBackgroundColor(-16777216);
                bj.this.Y9(true);
            }
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionDragLayout.OnDragListener
        public void onStartDrag() {
            bj bjVar = bj.this;
            bjVar.mCurrentImageView = bjVar.mBannerAdapter.w0();
            QLog.d(bj.this.getTAG(), 1, "onStartDrag " + bj.this.mCurrentImageView);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/bj$d", "Lcom/tencent/biz/richframework/animation/transition/TransitionDragLayout$DragInterceptDelegate;", "Landroid/view/MotionEvent;", "motionEvent", "", "deltaX", "deltaY", "", IGuildSpeechApi.KEY_NEED_INTERCEPT, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d implements TransitionDragLayout.DragInterceptDelegate {
        d() {
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionDragLayout.DragInterceptDelegate
        public boolean needIntercept(@Nullable MotionEvent motionEvent, float deltaX, float deltaY) {
            if ((bj.this.mCurrentImageView != null && Math.abs(r6.getScale() - 1.0f) > 0.0010000000474974513d) || Math.abs(deltaX) > deltaY) {
                return false;
            }
            return true;
        }
    }

    public /* synthetic */ bj(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(feedCloudMeta$StFeed, (i3 & 2) != 0 ? true : z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(View view, int pos) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SLIDE_PIC_NUM, Integer.valueOf(pos + 1));
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.reportEvent("ev_xsj_left_right_slide", view, buildElementParams);
    }

    private final int N9() {
        if (this.mFromPicFeed) {
            return 2;
        }
        return 1;
    }

    private final String O9() {
        return QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(bj this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(bj this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.getTAG(), 1, "[setOnItemLongClickListener] -> position = " + i3);
        QCircleShareInfo c16 = com.tencent.biz.qqcircle.immersive.utils.au.c(this$0.mFeed);
        c16.isEnableShareToMutual = com.tencent.biz.qqcircle.immersive.utils.a.c();
        c16.type = 15;
        c16.isShowBarrageSwitch = false;
        c16.isShareBottomBarrageSwitch = com.tencent.biz.qqcircle.immersive.utils.o.e(this$0.mFeed);
        c16.feedBlockData = new e30.b(this$0.mFeed);
        c16.mReportBean = this$0.getReportBean();
        c16.picDownPos = i3;
        this$0.broadcastMessage("share_action_show_share_sheet", c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(bj this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(bj this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void U9() {
        long P2;
        if (this.mStartTime == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        int size = this.mFeed.images.size();
        if (this.mFeed.images.size() == 1) {
            P2 = 5000;
        } else {
            P2 = (size * uq3.c.P2()) + ((size - 1) * uq3.c.O2());
        }
        QLog.i(getTAG(), 1, "[reportEndExposure] -> videoPlayTime = " + currentTimeMillis + " , picSize = " + size + " , videoTotalTime = " + P2);
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(this.mFeed));
        QCircleLpReportDc05507.DataBuilder ext1 = dataBuilder.setActionType(1).setSubActionType(8).setfpageid(getReportBean().getFromPageId()).setFirstFeedId(w20.a.j().h()).setExt1("1");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(size);
        ext1.setExt3(sb5.toString()).setVideoPlayTime(currentTimeMillis).setVideoTotalTime((int) P2).setPageId(getPageId());
        QCircleLpReportDc05507.report(dataBuilder);
    }

    private final void V9() {
        QFSImageBanner qFSImageBanner = this.mBanner;
        if (qFSImageBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner = null;
        }
        qFSImageBanner.v0();
        this.mAutoPlay = true;
        w20.a.j().r(this.mFeed.f398449id.get(), this.mAutoPlay);
        aa(this.mAutoPlay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9() {
        QFSImageBanner qFSImageBanner = this.mBanner;
        if (qFSImageBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner = null;
        }
        qFSImageBanner.y0();
        this.mAutoPlay = false;
        w20.a.j().r(this.mFeed.f398449id.get(), this.mAutoPlay);
        aa(this.mAutoPlay);
    }

    private final void X9() {
        if (this.mAutoPlay) {
            W9();
        } else {
            V9();
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSVideoControlEvent(this.mFeed.f398449id.get(), this.mAutoPlay));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9(boolean show) {
        int i3;
        int i16 = 8;
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        QFSGalleryProgressViewNoAnim qFSGalleryProgressViewNoAnim = this.mProgressView;
        ImageView imageView = null;
        if (qFSGalleryProgressViewNoAnim == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressView");
            qFSGalleryProgressViewNoAnim = null;
        }
        if (this.mFeed.images.size() > 1) {
            i16 = i3;
        }
        qFSGalleryProgressViewNoAnim.setVisibility(i16);
        View view = this.mIvClose;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvClose");
            view = null;
        }
        view.setVisibility(i3);
        ImageView imageView2 = this.mPlayOrPauseView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayOrPauseView");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(int pos) {
        TextView textView = this.mTvPosition;
        QFSGalleryProgressViewNoAnim qFSGalleryProgressViewNoAnim = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvPosition");
            textView = null;
        }
        textView.setText((pos + 1) + "/" + this.mFeed.images.size());
        QFSGalleryProgressViewNoAnim qFSGalleryProgressViewNoAnim2 = this.mProgressView;
        if (qFSGalleryProgressViewNoAnim2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressView");
            qFSGalleryProgressViewNoAnim2 = null;
        }
        qFSGalleryProgressViewNoAnim2.setTotalCount(this.mFeed.images.size());
        QFSGalleryProgressViewNoAnim qFSGalleryProgressViewNoAnim3 = this.mProgressView;
        if (qFSGalleryProgressViewNoAnim3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressView");
        } else {
            qFSGalleryProgressViewNoAnim = qFSGalleryProgressViewNoAnim3;
        }
        qFSGalleryProgressViewNoAnim.f(pos);
    }

    private final void aa(boolean isPlaying) {
        int i3;
        Drawable drawable;
        TextView textView = this.mTvPosition;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvPosition");
            textView = null;
        }
        if (isPlaying) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
        ImageView imageView2 = this.mPlayOrPauseView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayOrPauseView");
        } else {
            imageView = imageView2;
        }
        if (isPlaying) {
            drawable = this.mPauseDrawable;
        } else {
            drawable = this.mPlayDrawable;
        }
        imageView.setImageDrawable(drawable);
    }

    private final void initBanner() {
        this.mBannerAdapter.s0(uq3.c.P2());
        this.mBannerAdapter.q0(uq3.c.O2());
        this.mBannerAdapter.setEnableLoop(true);
        this.mBannerAdapter.z0(this.mFeed);
        this.mBannerAdapter.notifyDataSetChanged();
        QFSImageBanner qFSImageBanner = this.mBanner;
        QFSImageBanner qFSImageBanner2 = null;
        if (qFSImageBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner = null;
        }
        qFSImageBanner.setAdapter(this.mBannerAdapter);
        QFSImageBanner qFSImageBanner3 = this.mBanner;
        if (qFSImageBanner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner3 = null;
        }
        qFSImageBanner3.setEnableOperate(true);
        QFSImageBanner qFSImageBanner4 = this.mBanner;
        if (qFSImageBanner4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner4 = null;
        }
        qFSImageBanner4.setStopBanner(false);
        QFSImageBanner qFSImageBanner5 = this.mBanner;
        if (qFSImageBanner5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner5 = null;
        }
        qFSImageBanner5.X().setOffscreenPageLimit(1);
        if (this.mBannerReport == null) {
            this.mBannerReport = new QFSImageBannerReport(getPageId()).q(false).p(N9());
            QFSImageBanner qFSImageBanner6 = this.mBanner;
            if (qFSImageBanner6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBanner");
                qFSImageBanner6 = null;
            }
            VideoReport.setElementId(qFSImageBanner6, O9());
            QFSImageBanner qFSImageBanner7 = this.mBanner;
            if (qFSImageBanner7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBanner");
                qFSImageBanner7 = null;
            }
            qFSImageBanner7.setStatusListener(this.mBannerReport);
        }
        QFSImageBannerReport qFSImageBannerReport = this.mBannerReport;
        if (qFSImageBannerReport != null) {
            qFSImageBannerReport.o(this.mFeed);
        }
        int f16 = w20.a.j().f(this.mFeed.f398449id.get());
        QLog.d(getTAG(), 1, "startBanner " + f16);
        Z9(f16);
        QFSImageBanner qFSImageBanner8 = this.mBanner;
        if (qFSImageBanner8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner8 = null;
        }
        qFSImageBanner8.w0(f16);
        if (this.mAutoPlay && this.mFeed.images.size() > 1) {
            V9();
        }
        QFSImageBanner qFSImageBanner9 = this.mBanner;
        if (qFSImageBanner9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner9 = null;
        }
        qFSImageBanner9.q0(new a());
        QFSImageBanner qFSImageBanner10 = this.mBanner;
        if (qFSImageBanner10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner10 = null;
        }
        qFSImageBanner10.setOnItemClickListener(new QFSImageBanner.c() { // from class: com.tencent.biz.qqcircle.immersive.part.bh
            @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.c
            public final void onItemClick(int i3) {
                bj.P9(bj.this, i3);
            }
        });
        QFSImageBanner qFSImageBanner11 = this.mBanner;
        if (qFSImageBanner11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner11 = null;
        }
        qFSImageBanner11.setOnSwitchListener(new b());
        QFSImageBanner qFSImageBanner12 = this.mBanner;
        if (qFSImageBanner12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
        } else {
            qFSImageBanner2 = qFSImageBanner12;
        }
        qFSImageBanner2.setOnItemLongClickListener(new QFSImageBanner.e() { // from class: com.tencent.biz.qqcircle.immersive.part.bi
            @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.e
            public final void onItemLongClick(int i3) {
                bj.Q9(bj.this, i3);
            }
        });
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: R9, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable e30.b feedBlockData) {
        if (feedBlockData != null) {
            FeedCloudMeta$StFeed g16 = feedBlockData.g();
            Intrinsics.checkNotNullExpressionValue(g16, "it.sourceData");
            this.mFeed = g16;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFeedGalleryPagePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        ImageView imageView = this.mPlayOrPauseView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayOrPauseView");
            imageView = null;
        }
        if (Intrinsics.areEqual(v3, imageView)) {
            if (this.mAutoPlay) {
                W9();
            } else {
                V9();
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSVideoControlEvent(this.mFeed.f398449id.get(), this.mAutoPlay));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f43991nz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<QF\u2026?>(R.id.qfs_image_banner)");
        this.mBanner = (QFSImageBanner) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f44171og);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.bf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bj.S9(bj.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Vi\u2026)\n            }\n        }");
        this.mIvClose = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f40941fq);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026s_feed_pic_progress_view)");
        this.mProgressView = (QFSGalleryProgressViewNoAnim) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f52362_l);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById<Im\u2026ontrol_play_or_pause_btn)");
        ImageView imageView = (ImageView) findViewById4;
        this.mPlayOrPauseView = imageView;
        QFSGalleryProgressViewNoAnim qFSGalleryProgressViewNoAnim = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayOrPauseView");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        QFSGalleryProgressViewNoAnim qFSGalleryProgressViewNoAnim2 = this.mProgressView;
        if (qFSGalleryProgressViewNoAnim2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressView");
        } else {
            qFSGalleryProgressViewNoAnim = qFSGalleryProgressViewNoAnim2;
        }
        qFSGalleryProgressViewNoAnim.setTotalCount(this.mFeed.images.size());
        rootView.findViewById(R.id.f4889218).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.bg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bj.T9(bj.this, view);
            }
        });
        View findViewById5 = rootView.findViewById(R.id.f56552kx);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById<Te\u2026ew>(R.id.qfs_tv_position)");
        this.mTvPosition = (TextView) findViewById5;
        aa(this.mAutoPlay);
        initBanner();
        TransitionDragLayout transitionDragLayout = (TransitionDragLayout) rootView.findViewById(R.id.f3662152);
        if (transitionDragLayout != null) {
            transitionDragLayout.setFeatureEnable(true);
            transitionDragLayout.setEnableDragHorizontal(true);
            transitionDragLayout.setEnableDragVertical(true);
            transitionDragLayout.setOnDragListener(new c(transitionDragLayout));
            transitionDragLayout.setDragInterceptDelegate(new d());
        }
        w20.a.j().observerGlobalState(e30.b.class, this.mFeed.f398449id.get(), this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        QFSImageBanner qFSImageBanner = this.mBanner;
        if (qFSImageBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBanner");
            qFSImageBanner = null;
        }
        qFSImageBanner.z0(true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        this.mStartTime = System.currentTimeMillis();
        QLog.d(getTAG(), 4, "[onPartResume] mAutoPlay = " + this.mAutoPlay);
        SimpleEventBus.getInstance().dispatchEvent(new QFSVideoControlEvent(this.mFeed.f398449id.get(), this.mAutoPlay));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        super.onPartStop(activity);
        U9();
    }

    @JvmOverloads
    public bj(@NotNull FeedCloudMeta$StFeed mFeed, boolean z16) {
        Intrinsics.checkNotNullParameter(mFeed, "mFeed");
        this.mFeed = mFeed;
        this.mFromPicFeed = z16;
        this.mAutoPlay = w20.a.j().d(this.mFeed.f398449id.get());
        this.mPauseDrawable = ContextCompat.getDrawable(RFWApplication.getApplication(), R.drawable.qui_pause_filled_white);
        this.mPlayDrawable = ContextCompat.getDrawable(RFWApplication.getApplication(), R.drawable.qui_play_filled_icon_white);
        this.mBannerAdapter = new com.tencent.biz.qqcircle.immersive.views.banner.f();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/bj$b", "Lcom/tencent/biz/qqcircle/immersive/views/banner/QFSImageBanner$h;", "", "targetPos", "", "a", "b", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements QFSImageBanner.h {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.h
        public void c() {
            bj.this.W9();
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.h
        public void a(int targetPos) {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.h
        public void b(int targetPos) {
        }
    }
}
