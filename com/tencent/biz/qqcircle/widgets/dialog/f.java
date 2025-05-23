package com.tencent.biz.qqcircle.widgets.dialog;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSQZoneVideoGuideAuthInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSQZoneVideoWindowStatusSetSuccessEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleQZoneVideoWindowStatusSetRequest;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qzone.QZQQVideoSwitch$SetRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u000245B)\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u0005R\u001a\u0010.\u001a\u00060+R\u00020\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00066"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/dialog/f;", "Landroid/app/Dialog;", "", "g0", "e0", "Z", "a0", "b0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", DKHippyEvent.EVENT_STOP, "show", "dismiss", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "recommendWrapperView", "Lcom/tencent/biz/qqcircle/beans/QFSQZoneVideoGuideAuthInfo;", "D", "Lcom/tencent/biz/qqcircle/beans/QFSQZoneVideoGuideAuthInfo;", "authInfo", "Lfeedcloud/FeedCloudMeta$StFeed;", "E", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mHalfScreenFloatingView", "G", "mContainer", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "mImageView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "I", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mBtn", "", "J", "mIsLandscape", "Lcom/tencent/biz/qqcircle/widgets/dialog/f$b;", "K", "Lcom/tencent/biz/qqcircle/widgets/dialog/f$b;", "mConfigurationListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/biz/qqcircle/beans/QFSQZoneVideoGuideAuthInfo;Lfeedcloud/FeedCloudMeta$StFeed;)V", "L", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class f extends ReportDialog {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View recommendWrapperView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final QFSQZoneVideoGuideAuthInfo authInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final FeedCloudMeta$StFeed feed;

    /* renamed from: F, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView mHalfScreenFloatingView;

    /* renamed from: G, reason: from kotlin metadata */
    private View mContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView mImageView;

    /* renamed from: I, reason: from kotlin metadata */
    private QUIButton mBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsLandscape;

    /* renamed from: K, reason: from kotlin metadata */
    private b mConfigurationListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/dialog/f$a;", "", "", "picUrl", "", "b", "Lcom/tencent/libra/request/Option;", "a", "", "RATIO_DIALOG_HEIGHT_SCREEN_HEIGHT_LANDSCAPE", "D", "RATIO_DIALOG_HEIGHT_SCREEN_HEIGHT_NOT_LANDSCAPE", "RATIO_PIC_HEIGHT_SCREEN_HEIGHT", "RATIO_PIC_WIDTH_HEIGHT", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.widgets.dialog.f$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Option a(@Nullable String picUrl) {
            int screenHeight;
            Context applicationContext = QCircleApplication.getAPP().getApplicationContext();
            if (applicationContext != null) {
                screenHeight = DisplayUtil.getRealHeight(applicationContext);
            } else {
                screenHeight = DisplayUtil.getScreenHeight();
            }
            double d16 = screenHeight * 0.44d;
            Option requestHeight = Option.obtain().setUrl(picUrl).setRequestWidth((int) (1.1d * d16)).setRequestHeight((int) d16);
            Intrinsics.checkNotNullExpressionValue(requestHeight, "obtain().setUrl(picUrl).\u2026tHeight(ivHeight.toInt())");
            return requestHeight;
        }

        @JvmStatic
        public final void b(@Nullable String picUrl) {
            QCircleFeedPicLoader.g().loadImage(a(picUrl));
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/biz/qqcircle/widgets/dialog/f$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "d", "I", "getMHeight", "()I", "setMHeight", "(I)V", "mHeight", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int mHeight;

        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        /* renamed from: createContentView */
        public View getF57419d() {
            f fVar = f.this;
            View inflate = LayoutInflater.from(fVar.getContext()).inflate(R.layout.gpu, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026log_content_layout, null)");
            fVar.mContainer = inflate;
            f.this.e0();
            View view = f.this.mContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                return null;
            }
            return view;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            double d16;
            if (this.mHeight == 0) {
                double realHeight = DisplayUtil.getRealHeight(f.this.getContext());
                if (bz.k() && bz.o()) {
                    d16 = 0.65d;
                } else {
                    d16 = 0.6d;
                }
                this.mHeight = (int) (realHeight * d16);
            }
            return this.mHeight;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull Context context, @NotNull View recommendWrapperView, @NotNull QFSQZoneVideoGuideAuthInfo authInfo, @Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        super(context, R.style.MenuDialogStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recommendWrapperView, "recommendWrapperView");
        Intrinsics.checkNotNullParameter(authInfo, "authInfo");
        this.recommendWrapperView = recommendWrapperView;
        this.authInfo = authInfo;
        this.feed = feedCloudMeta$StFeed;
    }

    private final void Z() {
        int coerceAtMost;
        int i3;
        if (bz.k()) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(cx.g(), cx.f());
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mHalfScreenFloatingView;
            if (qUSHalfScreenFloatingView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenFloatingView");
                qUSHalfScreenFloatingView = null;
            }
            if (bz.o()) {
                i3 = cx.j(coerceAtMost);
            } else {
                i3 = 0;
            }
            qUSHalfScreenFloatingView.setMaxWidthDp(i3);
        }
    }

    private final void a0() {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        View view = this.mContainer;
        QUIButton qUIButton = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        VideoReport.setLogicParent(view, this.recommendWrapperView);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null) {
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_QQ_FRI, Integer.valueOf(QCirclePluginUtil.isFriend(feedCloudMeta$StUser.f398463id.get()) ? 1 : 0));
        }
        View view2 = this.mContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view2 = null;
        }
        VideoReport.setElementId(view2, QCircleDaTongConstant.ElementId.EM_XSJ_VIDEO_UNITE_GUIDE_POP);
        View view3 = this.mContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view3 = null;
        }
        VideoReport.setElementParams(view3, params);
        View view4 = this.mContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view4 = null;
        }
        VideoReport.setElementClickPolicy(view4, ClickPolicy.REPORT_NONE);
        QUIButton qUIButton2 = this.mBtn;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtn");
            qUIButton2 = null;
        }
        VideoReport.setElementId(qUIButton2, QCircleDaTongConstant.ElementId.EM_XSJ_VIDEO_UNITE_OPEN_BUTTON);
        QUIButton qUIButton3 = this.mBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtn");
            qUIButton3 = null;
        }
        VideoReport.setElementParams(qUIButton3, params);
        QUIButton qUIButton4 = this.mBtn;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtn");
        } else {
            qUIButton = qUIButton4;
        }
        VideoReport.setElementExposePolicy(qUIButton, ExposurePolicy.REPORT_NONE);
    }

    private final void b0() {
        QLog.d("QFSQZoneVideoGuideAuthDialog", 1, "handleBtnClick");
        VSNetworkHelper.getInstance().sendRequest(new QCircleQZoneVideoWindowStatusSetRequest(2), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.widgets.dialog.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                f.c0(f.this, baseRequest, z16, j3, str, (QZQQVideoSwitch$SetRsp) obj);
            }
        });
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(final f this$0, BaseRequest req, final boolean z16, final long j3, final String str, QZQQVideoSwitch$SetRsp qZQQVideoSwitch$SetRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QFSQZoneVideoGuideAuthDialog", 1, "qzoneVideoWindowStatusSetRequest onReceive, ", " | isSuccess: " + z16, " | traceId: " + req.getTraceId(), " | cmdName: " + req.getCmd(), " | retCode: " + j3, " | retMessage: " + str);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.dialog.e
            @Override // java.lang.Runnable
            public final void run() {
                f.d0(z16, j3, this$0, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(boolean z16, long j3, f this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && j3 == 0) {
            QCircleToast.l(QCircleToast.f91644d, this$0.authInfo.getToastTxt(), 0, true, true);
            SimpleEventBus.getInstance().dispatchEvent(new QFSQZoneVideoWindowStatusSetSuccessEvent());
        } else if (!TextUtils.isEmpty(str)) {
            cj.b(false, j3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        View view = this.mContainer;
        QUIButton qUIButton = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        View findViewById = view.findViewById(R.id.f5146286);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContainer.findViewById(\u2026one_video_auth_dialog_iv)");
        this.mImageView = (ImageView) findViewById;
        View view2 = this.mContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.f5145285);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContainer.findViewById(\u2026ne_video_auth_dialog_btn)");
        this.mBtn = (QUIButton) findViewById2;
        Option a16 = INSTANCE.a(this.authInfo.getPicUrl());
        ImageView imageView = this.mImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            imageView = null;
        }
        a16.setTargetView(imageView);
        ImageView imageView2 = this.mImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mImageView");
            imageView2 = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = a16.getRequestWidth();
            layoutParams.height = a16.getRequestHeight();
        }
        QCircleFeedPicLoader.g().loadImage(a16);
        QUIButton qUIButton2 = this.mBtn;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtn");
            qUIButton2 = null;
        }
        qUIButton2.setText(this.authInfo.getBtnTxt());
        QUIButton qUIButton3 = this.mBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtn");
        } else {
            qUIButton = qUIButton3;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                f.f0(f.this, view3);
            }
        });
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g0() {
        View findViewById = findViewById(R.id.f41921id);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        this.mHalfScreenFloatingView = qUSHalfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.setDraggable(true);
        Z();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenFloatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.setQUSDragFloatController(new c());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.mHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView4;
        }
        qUSHalfScreenFloatingView2.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.biz.qqcircle.widgets.dialog.b
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                f.i0(f.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @JvmStatic
    public static final void j0(@Nullable String str) {
        INSTANCE.b(str);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        QLog.d("QFSQZoneVideoGuideAuthDialog", 1, "dismiss");
        super.dismiss();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(20, feedCloudMeta$StFeed.f398449id.get(), false));
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        QLog.d("QFSQZoneVideoGuideAuthDialog", 1, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f168678gc3);
        this.mIsLandscape = bz.o();
        this.mConfigurationListener = new b();
        Context context = getContext();
        b bVar = this.mConfigurationListener;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfigurationListener");
            bVar = null;
        }
        context.registerComponentCallbacks(bVar);
        g0();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        QLog.d("QFSQZoneVideoGuideAuthDialog", 1, DKHippyEvent.EVENT_STOP);
        super.onStop();
        Context context = getContext();
        b bVar = this.mConfigurationListener;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConfigurationListener");
            bVar = null;
        }
        context.unregisterComponentCallbacks(bVar);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        QLog.d("QFSQZoneVideoGuideAuthDialog", 1, "show");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(20, feedCloudMeta$StFeed.f398449id.get(), true));
        }
        super.show();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/dialog/f$b;", "Landroid/content/ComponentCallbacks;", "Landroid/content/res/Configuration;", "newConfig", "", "onConfigurationChanged", "onLowMemory", "<init>", "(Lcom/tencent/biz/qqcircle/widgets/dialog/f;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    private final class b implements ComponentCallbacks {
        public b() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NotNull Configuration newConfig) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            boolean o16 = bz.o();
            QLog.d("QFSQZoneVideoGuideAuthDialog", 1, "onConfigurationChanged oldLandscape = " + f.this.mIsLandscape + ", newLandscape = " + o16);
            if (f.this.mIsLandscape != o16) {
                QUSHalfScreenFloatingView qUSHalfScreenFloatingView = f.this.mHalfScreenFloatingView;
                if (qUSHalfScreenFloatingView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenFloatingView");
                    qUSHalfScreenFloatingView = null;
                }
                qUSHalfScreenFloatingView.t();
                f.this.mIsLandscape = o16;
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }
}
