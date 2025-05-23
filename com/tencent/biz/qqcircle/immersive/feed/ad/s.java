package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.s;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFullScreenCloseEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002fgB\u0007\u00a2\u0006\u0004\bc\u0010dJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u001a\u0010\u001b\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0012\u0010 \u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010$\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010'\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010(\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0018\u00108\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010*R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010ER\u0018\u0010L\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010*R\u0018\u0010N\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010ER\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010)R\u0016\u0010^\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010WR\u0016\u0010`\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010WR\u0016\u0010b\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010W\u00a8\u0006h"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/s;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "S1", "M1", "O1", "N1", "R1", "L1", "A1", "", NodeProps.VISIBLE, "P1", Constants.BASE_IN_PLUGIN_ID, "v1", "Landroid/view/View;", "view", "u1", "", "url", "Landroid/graphics/drawable/Drawable;", "I1", "K1", "w0", "data", "position", "J1", "K0", "M0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onResumed", "onPaused", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "simpleBaseEvent", "onReceiveEvent", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "event", "C0", "onFeedUnSelected", "I", "Landroid/view/View;", "mAdCardLayout", "J", "Landroid/graphics/drawable/Drawable;", "mBoxApng", "K", "mTipApng", "Landroidx/constraintlayout/widget/ConstraintLayout;", "L", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mAdTipLayout", "M", "mAdBannerLayout", "N", "mAdBoxLayout", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSAdMotiveBannerView;", "P", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSAdMotiveBannerView;", "mMotiveBannerView", "Landroid/widget/ImageView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/ImageView;", "mAdBoxIcon", BdhLogUtil.LogTag.Tag_Req, "mAdTipIcon", "Landroid/widget/TextView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", "mAdTipDesc", "T", "mAdBoxDesc", "U", "mAdBoxDescBottom", "V", "mAdBoxBg", "W", "mAdBannerDesc", "Lcom/tencent/biz/qqcircle/immersive/feed/animwrap/m;", "X", "Lcom/tencent/biz/qqcircle/immersive/feed/animwrap/m;", "mMotiveAnimWrap", "Lcom/tencent/gdtad/aditem/GdtAd;", "Y", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "Z", "Lfeedcloud/FeedCloudMeta$StFeed;", "mAdFeed", "a0", "mAdCardStyle", "", "b0", "mIsInitView", "c0", "mIsFullscreenChange", "d0", "mIsMotive", "<init>", "()V", "e0", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class s extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: e0, reason: collision with root package name */
    @NotNull
    private static final a f85760e0 = new a(null);

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View mAdCardLayout;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Drawable mBoxApng;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Drawable mTipApng;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout mAdTipLayout;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout mAdBannerLayout;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private View mAdBoxLayout;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private QFSAdMotiveBannerView mMotiveBannerView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private ImageView mAdBoxIcon;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ImageView mAdTipIcon;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private TextView mAdTipDesc;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private TextView mAdBoxDesc;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private TextView mAdBoxDescBottom;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private View mAdBoxBg;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private TextView mAdBannerDesc;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.feed.animwrap.m mMotiveAnimWrap;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private GdtAd mAd;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mAdFeed;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int mAdCardStyle;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsInitView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullscreenChange;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsMotive;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/s$a;", "", "", "BANNER_AD_DEFAULT_TEXT", "Ljava/lang/String;", "", "BANNER_AD_TEXT_LENGTH", "I", "BOX_AD_APNG_URL", "BOX_AD_DEFAULT_TEXT", "BOX_AD_TEXT_LENGTH", "TAG", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/s$b;", "", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/ad/s$c", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/s$b;", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements b {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(s this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            af.r0(this$0.mAdBannerLayout, 0);
            af.r0(this$0.mMotiveBannerView, 0);
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.ad.s.b
        public void a() {
            String str;
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final s sVar = s.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.t
                @Override // java.lang.Runnable
                public final void run() {
                    s.c.c(s.this);
                }
            });
            s sVar2 = s.this;
            GdtAd gdtAd = sVar2.mAd;
            if (gdtAd != null) {
                str = gdtAd.getTraceId();
            } else {
                str = null;
            }
            sVar2.T0(new com.tencent.biz.qqcircle.immersive.feed.event.b(str));
        }
    }

    private final void A1() {
        View view;
        ConstraintLayout constraintLayout;
        TextView textView;
        View view2 = this.C;
        if (view2 != null && !this.mIsInitView) {
            this.mIsInitView = true;
            ViewStub viewStub = (ViewStub) view2.findViewById(R.id.v9u);
            if (viewStub != null) {
                viewStub.inflate();
            }
            this.mAdCardLayout = this.C.findViewById(R.id.v9q);
            ViewStub viewStub2 = (ViewStub) this.C.findViewById(R.id.f3814196);
            QFSAdMotiveBannerView qFSAdMotiveBannerView = null;
            if (viewStub2 != null) {
                view = viewStub2.inflate();
            } else {
                view = null;
            }
            this.mAdBoxLayout = view;
            View view3 = this.mAdCardLayout;
            if (view3 != null) {
                constraintLayout = (ConstraintLayout) view3.findViewById(R.id.f3810192);
            } else {
                constraintLayout = null;
            }
            this.mAdBannerLayout = constraintLayout;
            View view4 = this.mAdCardLayout;
            if (view4 != null) {
                textView = (TextView) view4.findViewById(R.id.f3812194);
            } else {
                textView = null;
            }
            this.mAdBannerDesc = textView;
            View view5 = this.mAdCardLayout;
            if (view5 != null) {
                qFSAdMotiveBannerView = (QFSAdMotiveBannerView) view5.findViewById(R.id.f3816198);
            }
            this.mMotiveBannerView = qFSAdMotiveBannerView;
            TextView textView2 = this.mAdBannerDesc;
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view6) {
                        s.B1(s.this, view6);
                    }
                });
            }
            ConstraintLayout constraintLayout2 = this.mAdBannerLayout;
            if (constraintLayout2 != null) {
                constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view6) {
                        s.C1(s.this, view6);
                    }
                });
                return;
            }
            return;
        }
        QLog.w("QFSAdMotiveBoxPresenter", 1, "initAdCard cancel, rootView=" + view2 + ",isInitView=" + this.mIsInitView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D1() {
        TextView textView;
        ViewStub viewStub;
        ConstraintLayout constraintLayout;
        View view = this.mAdCardLayout;
        if (view == null) {
            return;
        }
        ImageView imageView = null;
        if (this.mAdTipLayout == null) {
            if (view != null) {
                viewStub = (ViewStub) view.findViewById(R.id.f3817199);
            } else {
                viewStub = null;
            }
            if (viewStub != null) {
                View inflate = viewStub.inflate();
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                constraintLayout = (ConstraintLayout) inflate;
            } else {
                View view2 = this.mAdCardLayout;
                if (view2 != null) {
                    constraintLayout = (ConstraintLayout) view2.findViewById(R.id.f3809191);
                } else {
                    constraintLayout = null;
                }
            }
            this.mAdTipLayout = constraintLayout;
        }
        ConstraintLayout constraintLayout2 = this.mAdTipLayout;
        if (constraintLayout2 != null) {
            textView = (TextView) constraintLayout2.findViewById(R.id.f38951ac);
        } else {
            textView = null;
        }
        this.mAdTipDesc = textView;
        ConstraintLayout constraintLayout3 = this.mAdTipLayout;
        if (constraintLayout3 != null) {
            imageView = (ImageView) constraintLayout3.findViewById(R.id.f38961ad);
        }
        this.mAdTipIcon = imageView;
        ConstraintLayout constraintLayout4 = this.mAdTipLayout;
        if (constraintLayout4 != null) {
            constraintLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    s.E1(s.this, view3);
                }
            });
        }
        TextView textView2 = this.mAdTipDesc;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    s.F1(s.this, view3);
                }
            });
        }
        ImageView imageView2 = this.mAdTipIcon;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    s.G1(s.this, view3);
                }
            });
        }
        ConstraintLayout constraintLayout5 = this.mAdTipLayout;
        if (constraintLayout5 != null) {
            constraintLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    s.H1(s.this, view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Drawable I1(String url) {
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setUseCache(true);
        return ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(url, apngOptions);
    }

    private final void K1() {
        Float f16;
        View findViewById;
        View view = this.mAdCardLayout;
        if (view != null && (findViewById = view.findViewById(R.id.f3739175)) != null) {
            f16 = Float.valueOf(findViewById.getY());
        } else {
            f16 = null;
        }
        if (f16 != null) {
            float floatValue = f16.floatValue();
            ConstraintLayout constraintLayout = this.mAdTipLayout;
            if (constraintLayout != null) {
                constraintLayout.setY(floatValue - com.tencent.biz.qqcircle.utils.cx.a(10.0f));
            }
        }
    }

    private final void L1() {
        af.r0(this.mAdTipLayout, 0);
        af.r0(this.mAdBoxLayout, 4);
    }

    private final void M1() {
        String str;
        boolean z16;
        GdtAd gdtAd = this.mAd;
        if (gdtAd != null) {
            str = gdtAd.getLabel();
        } else {
            str = null;
        }
        boolean z17 = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str2 = "\u60ca\u559c\u798f\u5229";
        if (z16) {
            str = "\u60ca\u559c\u798f\u5229";
        }
        if (str.length() > 8) {
            str = str.substring(0, 8);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        if (af.Z(this.mAd) && af.z(this.mAd) == 1) {
            String btnText = af.x(this.mAd);
            if (TextUtils.isEmpty(btnText)) {
                btnText = "\u6447\u52a8\u6216\u70b9\u51fb\u67e5\u770b\u8be6\u60c5";
            }
            if (btnText != null && btnText.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                Intrinsics.checkNotNullExpressionValue(btnText, "btnText");
                str2 = btnText;
            }
            if (str2.length() > 8) {
                str2 = str2.substring(0, 8);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            TextView textView = this.mAdBannerDesc;
            if (textView != null) {
                textView.setText(str2);
                return;
            }
            return;
        }
        TextView textView2 = this.mAdBannerDesc;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    private final void N1() {
        View view;
        int q16 = af.q("#804200CF", af.D(this.mAd));
        af.o0(this.mAdTipLayout, q16);
        ConstraintLayout constraintLayout = this.mAdBannerLayout;
        if (constraintLayout != null) {
            view = constraintLayout.findViewById(R.id.f3811193);
        } else {
            view = null;
        }
        af.o0(view, q16);
        af.o0(this.mAdBoxBg, q16);
    }

    private final void O1() {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.PopupPosterInfo popupPosterInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.PopupPosterInfo popupPosterInfo2;
        String str;
        boolean z16;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        GdtAd gdtAd = this.mAd;
        String str2 = null;
        if (gdtAd != null) {
            popupPosterInfo = gdtAd.getMotivePupInfo();
        } else {
            popupPosterInfo = null;
        }
        boolean z17 = true;
        if (popupPosterInfo == null) {
            QLog.d("QFSAdMotiveBoxPresenter", 1, "init PupInfo is null");
            return;
        }
        GdtAd gdtAd2 = this.mAd;
        if (gdtAd2 != null) {
            popupPosterInfo2 = gdtAd2.getMotivePupInfo();
        } else {
            popupPosterInfo2 = null;
        }
        if (popupPosterInfo2 != null && (pBStringField2 = popupPosterInfo2.img) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = "https://amsweb-cdn-gz-1258344696.file.myqcloud.com/PACD_PM/template/gift_box_2.png";
        }
        Drawable I1 = I1(str);
        this.mBoxApng = I1;
        ImageView imageView = this.mAdBoxIcon;
        if (imageView != null) {
            imageView.setImageDrawable(I1);
        }
        if (popupPosterInfo2 != null && (pBStringField = popupPosterInfo2.text) != null) {
            str2 = pBStringField.get();
        }
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        }
        if (z17) {
            str2 = "\u70b9\u51fb\u9886\u53d6\u60ca\u559c\u798f\u5229";
        }
        if (str2.length() > 4) {
            TextView textView = this.mAdBoxDescBottom;
            if (textView != null) {
                textView.setVisibility(0);
            }
            String substring = str2.substring(0, 4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring2 = str2.substring(4);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            TextView textView2 = this.mAdBoxDesc;
            if (textView2 != null) {
                textView2.setText(substring);
            }
            TextView textView3 = this.mAdBoxDescBottom;
            if (textView3 != null) {
                textView3.setText(substring2);
                return;
            }
            return;
        }
        TextView textView4 = this.mAdBoxDesc;
        if (textView4 != null) {
            textView4.setText(str2);
        }
        TextView textView5 = this.mAdBoxDescBottom;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
    }

    private final void P1(final int visible) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.h
            @Override // java.lang.Runnable
            public final void run() {
                s.Q1(s.this, visible);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(s this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        af.r0(this$0.mAdBoxLayout, i3);
        af.r0(this$0.mAdTipLayout, i3);
        af.r0(this$0.mAdBannerLayout, i3);
    }

    private final void R1() {
        int q16 = af.q("#FFFFFF", af.E(this.mAd));
        TextView textView = this.mAdBoxDesc;
        if (textView != null) {
            textView.setTextColor(q16);
        }
        TextView textView2 = this.mAdBoxDescBottom;
        if (textView2 != null) {
            textView2.setTextColor(q16);
        }
        TextView textView3 = this.mAdTipDesc;
        if (textView3 != null) {
            textView3.setTextColor(q16);
        }
        TextView textView4 = this.mAdBannerDesc;
        if (textView4 != null) {
            textView4.setTextColor(q16);
        }
    }

    private final void S1() {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.PopupPosterInfo popupPosterInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.PopupPosterInfo popupPosterInfo2;
        String str;
        boolean z16;
        boolean z17;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        GdtAd gdtAd = this.mAd;
        String str2 = null;
        if (gdtAd != null) {
            popupPosterInfo = gdtAd.getMotivePupInfo();
        } else {
            popupPosterInfo = null;
        }
        boolean z18 = true;
        if (popupPosterInfo == null) {
            QLog.d("QFSAdMotiveBoxPresenter", 1, "init PupInfo is null");
            return;
        }
        GdtAd gdtAd2 = this.mAd;
        if (gdtAd2 != null) {
            popupPosterInfo2 = gdtAd2.getMotivePupInfo();
        } else {
            popupPosterInfo2 = null;
        }
        if (popupPosterInfo2 != null && (pBStringField2 = popupPosterInfo2.img) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = "https://amsweb-cdn-gz-1258344696.file.myqcloud.com/PACD_PM/template/gift_box_2.png";
        }
        Drawable I1 = I1(str);
        this.mTipApng = I1;
        ImageView imageView = this.mAdTipIcon;
        if (imageView != null) {
            imageView.setImageDrawable(I1);
        }
        if (popupPosterInfo2 != null && (pBStringField = popupPosterInfo2.text) != null) {
            str2 = pBStringField.get();
        }
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            str2 = "\u70b9\u51fb\u9886\u53d6\u60ca\u559c\u798f\u5229";
        }
        if (str2.length() > 8) {
            str2 = str2.substring(0, 8);
            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        if (af.Z(this.mAd) && af.z(this.mAd) == 1) {
            String btnText = af.x(this.mAd);
            if (TextUtils.isEmpty(btnText)) {
                btnText = "\u6447\u52a8\u6216\u70b9\u51fb\u67e5\u770b\u8be6\u60c5";
            }
            if (btnText != null && btnText.length() != 0) {
                z18 = false;
            }
            if (z18) {
                btnText = "\u60ca\u559c\u798f\u5229";
            } else {
                Intrinsics.checkNotNullExpressionValue(btnText, "btnText");
            }
            if (btnText.length() > 8) {
                btnText = btnText.substring(0, 8);
                Intrinsics.checkNotNullExpressionValue(btnText, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            TextView textView = this.mAdBannerDesc;
            if (textView != null) {
                textView.setText(btnText);
            }
        } else {
            TextView textView2 = this.mAdBannerDesc;
            if (textView2 != null) {
                textView2.setText(str2);
            }
        }
        TextView textView3 = this.mAdTipDesc;
        if (textView3 != null) {
            textView3.setText(str2);
        }
    }

    private final void u1(View view) {
        int i3;
        if (view == null) {
            return;
        }
        Integer c16 = com.tencent.biz.qqcircle.immersive.feed.ad.a.f85437a.c(Integer.valueOf(view.getId()));
        com.tencent.biz.qqcircle.immersive.utils.j jVar = com.tencent.biz.qqcircle.immersive.utils.j.f90213a;
        GdtAd gdtAd = this.mAd;
        int i16 = this.f85018i;
        QCircleExtraTypeInfo r16 = r();
        if (c16 != null) {
            i3 = c16.intValue();
        } else {
            i3 = 1000;
        }
        jVar.I(gdtAd, view, i16, r16, i3);
    }

    private final void v1() {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        View view = this.mAdBoxLayout;
        if (view == null) {
            return;
        }
        View view2 = null;
        if (view != null) {
            imageView = (ImageView) view.findViewById(R.id.f378518d);
        } else {
            imageView = null;
        }
        this.mAdBoxIcon = imageView;
        View view3 = this.mAdBoxLayout;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.f378318b);
        } else {
            textView = null;
        }
        this.mAdBoxDesc = textView;
        View view4 = this.mAdBoxLayout;
        if (view4 != null) {
            textView2 = (TextView) view4.findViewById(R.id.f378418c);
        } else {
            textView2 = null;
        }
        this.mAdBoxDescBottom = textView2;
        View view5 = this.mAdBoxLayout;
        if (view5 != null) {
            view2 = view5.findViewById(R.id.f378218a);
        }
        this.mAdBoxBg = view2;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    s.x1(s.this, view6);
                }
            });
        }
        TextView textView3 = this.mAdBoxDesc;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    s.y1(s.this, view6);
                }
            });
        }
        TextView textView4 = this.mAdBoxDescBottom;
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    s.z1(s.this, view6);
                }
            });
        }
        ImageView imageView2 = this.mAdBoxIcon;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    s.w1(s.this, view6);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(@Nullable com.tencent.biz.qqcircle.immersive.feed.event.h event) {
        String str;
        super.C0(event);
        if (this.mAd != null && this.mIsMotive) {
            String str2 = null;
            if (event instanceof com.tencent.biz.qqcircle.immersive.feed.event.e) {
                String mTraceId = ((com.tencent.biz.qqcircle.immersive.feed.event.e) event).getMTraceId();
                GdtAd gdtAd = this.mAd;
                if (gdtAd != null) {
                    str = gdtAd.getTraceId();
                } else {
                    str = null;
                }
                if (!TextUtils.equals(mTraceId, str)) {
                    return;
                } else {
                    P1(8);
                }
            }
            if (event instanceof com.tencent.biz.qqcircle.immersive.feed.event.f) {
                String mTraceId2 = ((com.tencent.biz.qqcircle.immersive.feed.event.f) event).getMTraceId();
                GdtAd gdtAd2 = this.mAd;
                if (gdtAd2 != null) {
                    str2 = gdtAd2.getTraceId();
                }
                if (!TextUtils.equals(mTraceId2, str2)) {
                    return;
                }
                P1(0);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: J1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        super.L0(data, position);
        if (data == null) {
            QLog.e("QFSAdMotiveBoxPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        U0(ae.b(this.E.g(), position));
        try {
            FeedCloudMeta$StFeed c16 = u.c(this.E);
            this.mAdFeed = c16;
            this.mAdCardStyle = c16.status.get();
            this.mAd = new GdtAd(u.e(this.E));
        } catch (Throwable th5) {
            QLog.e("QFSAdMotiveBoxPresenter", 1, "[onBindData] failed, error is " + th5);
        }
        boolean h16 = eq.f85700a.h(this.mAd);
        this.mIsMotive = h16;
        if (!h16) {
            return;
        }
        A1();
        D1();
        v1();
        L1();
        e30.b bVar = this.E;
        if (bVar != null) {
            feedCloudMeta$StFeed = bVar.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (af.Y(feedCloudMeta$StFeed, this.mAdFeed, this.mAd)) {
            K1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        if (this.mIsMotive && !this.mIsFullscreenChange) {
            S1();
            M1();
            O1();
            N1();
            R1();
            af.r0(this.mAdBannerLayout, 0);
            af.r0(this.mMotiveBannerView, 0);
            com.tencent.biz.qqcircle.immersive.feed.animwrap.m mVar = new com.tencent.biz.qqcircle.immersive.feed.animwrap.m(this.mAdTipLayout, this.mAdBoxLayout, this.mAd);
            this.mMotiveAnimWrap = mVar;
            mVar.A();
            com.tencent.biz.qqcircle.immersive.feed.animwrap.m mVar2 = this.mMotiveAnimWrap;
            if (mVar2 != null) {
                mVar2.F(new c());
            }
            super.K0();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        com.tencent.biz.qqcircle.immersive.feed.animwrap.m mVar = this.mMotiveAnimWrap;
        if (mVar != null) {
            mVar.B();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedUnSelected(selectInfo);
        ConstraintLayout constraintLayout = this.mAdTipLayout;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        View view = this.mAdBoxLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        ConstraintLayout constraintLayout2 = this.mAdBannerLayout;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
        QFSAdMotiveBannerView qFSAdMotiveBannerView = this.mMotiveBannerView;
        if (qFSAdMotiveBannerView != null) {
            qFSAdMotiveBannerView.setVisibility(8);
        }
        this.mIsFullscreenChange = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onPaused(selectInfo);
        com.tencent.biz.qqcircle.immersive.feed.animwrap.m mVar = this.mMotiveAnimWrap;
        if (mVar != null) {
            mVar.C();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (!(simpleBaseEvent instanceof QFSFullScreenCloseEvent) || !TextUtils.equals(com.tencent.biz.qqcircle.utils.bj.g(this.f85017h), ((QFSFullScreenCloseEvent) simpleBaseEvent).getFeedId())) {
            return;
        }
        this.mIsFullscreenChange = true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        com.tencent.biz.qqcircle.immersive.feed.animwrap.m mVar = this.mMotiveAnimWrap;
        if (mVar != null) {
            mVar.D();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSAdMotiveBoxPresenter";
    }
}
