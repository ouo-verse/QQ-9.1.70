package com.tencent.mobileqq.qqlive.widget.floatwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001C\u0018\u0000 Q2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001RB\u0011\u0012\b\b\u0002\u0010N\u001a\u00020M\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0006\u0010\u001b\u001a\u00020\fJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001e\u001a\u00020\fJ\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!J\u0012\u0010$\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J*\u0010.\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010/\u001a\u00020\u0006H\u0014R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00102R\u0018\u0010:\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00102R\u0018\u0010=\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010>R\u0016\u0010B\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010K\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/floatwindow/QQLiveFloatWindowView2;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "Lmi2/c;", "Lmi2/g;", "", "r", "B", "Landroid/view/View;", "videoView", "w", "", "isVideoLandscape", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "coverUrl", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "j", "mute", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "g", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "k", "i", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/qqlive/widget/floatwindow/b;", "params", "t", NodeProps.ON_CLICK, "Lfp4/c;", "msgInfo", "onPush", "onVideoPrepared", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "extraInfo", "onError", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "coverImage", "e", "Landroid/widget/FrameLayout;", "videoContainer", "f", "volumeBtn", h.F, "closeBtn", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "endTipTextView", "Lcom/tencent/mobileqq/qqlive/widget/floatwindow/b;", "showParams", BdhLogUtil.LogTag.Tag_Conn, "Z", "currentIsMute", "com/tencent/mobileqq/qqlive/widget/floatwindow/QQLiveFloatWindowView2$b", "D", "Lcom/tencent/mobileqq/qqlive/widget/floatwindow/QQLiveFloatWindowView2$b;", "netInfoHandler", "", "l", "()J", "roomId", "()Z", "canPlay", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveFloatWindowView2 extends FrameLayout implements View.OnClickListener, com.tencent.mobileqq.qqlive.sail.room.g, mi2.c, mi2.g {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean currentIsMute;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b netInfoHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView coverImage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout videoContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView volumeBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView closeBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView endTipTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.widget.floatwindow.b showParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/floatwindow/QQLiveFloatWindowView2$a;", "", "", "MMKV_KEY_CAN_PLAY_IN_MOBILE_NETWORK", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.floatwindow.QQLiveFloatWindowView2$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqlive/widget/floatwindow/QQLiveFloatWindowView2$b", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "", "p0", "", "onNetNone2Wifi", "onNetMobile2None", "onNetWifi2None", "onNetNone2Mobile", "onNetWifi2Mobile", "onNetMobile2Wifi", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements INetInfoHandler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveFloatWindowView2.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowView2", "onNetMobile2None", "roomId=" + QQLiveFloatWindowView2.this.l());
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(@Nullable String p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) p06);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowView2", "onNetMobile2Wifi", "roomId=" + QQLiveFloatWindowView2.this.l() + ", canPlay=" + QQLiveFloatWindowView2.this.h() + ", p0=" + p06);
            if (QQLiveFloatWindowView2.this.h()) {
                QQLiveFloatWindowView2.this.q();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(@Nullable String p06) {
            com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar;
            com.tencent.mobileqq.qqlive.sail.room.e e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) p06);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowView2", "onNetNone2Mobile", "roomId=" + QQLiveFloatWindowView2.this.l() + ", canPlay=" + QQLiveFloatWindowView2.this.h() + ", p0=" + p06);
            if (!QQLiveFloatWindowView2.this.h() && (bVar = QQLiveFloatWindowView2.this.showParams) != null && (e16 = bVar.e()) != null) {
                e16.pauseVideo();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(@Nullable String p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowView2", "onNetNone2Wifi", "roomId=" + QQLiveFloatWindowView2.this.l() + ", canPlay=" + QQLiveFloatWindowView2.this.h() + ", p0=" + p06);
            if (QQLiveFloatWindowView2.this.h()) {
                QQLiveFloatWindowView2.this.q();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(@Nullable String p06) {
            com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar;
            com.tencent.mobileqq.qqlive.sail.room.e e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) p06);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowView2", "onNetWifi2Mobile", "roomId=" + QQLiveFloatWindowView2.this.l() + ", canPlay=" + QQLiveFloatWindowView2.this.h() + ", p0=" + p06);
            if (!QQLiveFloatWindowView2.this.h() && (bVar = QQLiveFloatWindowView2.this.showParams) != null && (e16 = bVar.e()) != null) {
                e16.pauseVideo();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowView2", "onNetWifi2None", "roomId=" + QQLiveFloatWindowView2.this.l());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34989);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveFloatWindowView2() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this);
    }

    private final void A(String coverUrl) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(coverUrl);
        if (!isBlank) {
            try {
                URLDrawable drawable = URLDrawable.getDrawable(coverUrl, j());
                ImageView imageView = this.coverImage;
                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                }
                ImageView imageView2 = this.coverImage;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    return;
                }
                return;
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e("Audience|QQLiveFloatWindowView2", "tryShowCover", "show cover error, ", e16);
                return;
            }
        }
        ImageView imageView3 = this.coverImage;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
    }

    private final void B() {
        com.tencent.mobileqq.qqlive.sail.room.e e16;
        AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowView2", "unregisterCallbacks");
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar = this.showParams;
        if (bVar != null && (e16 = bVar.e()) != null) {
            e16.e(this);
            e16.r(this);
            e16.z(this);
        }
        AppNetConnInfo.unregisterNetInfoHandler(this.netInfoHandler);
    }

    private final void g() {
        com.tencent.mobileqq.qqlive.sail.room.e e16;
        s();
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar = this.showParams;
        if (bVar != null && (e16 = bVar.e()) != null) {
            e16.destroy();
        }
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h() {
        boolean e16 = ct3.a.e("can_play_in_mobile_network", false);
        if (AppNetConnInfo.isMobileConn() && e16) {
            return false;
        }
        return true;
    }

    private final URLDrawable.URLDrawableOptions j() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026sparentDrawable\n        }");
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long l() {
        com.tencent.mobileqq.qqlive.sail.room.e e16;
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar = this.showParams;
        if (bVar != null && (e16 = bVar.e()) != null) {
            return e16.getRoomId();
        }
        return 0L;
    }

    private final void m() {
        B();
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(g.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QQLiveFloatWindowView2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
        this$0.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(QQLiveFloatWindowView2 this$0) {
        View view;
        com.tencent.mobileqq.qqlive.sail.room.e e16;
        com.tencent.mobileqq.qqlive.sail.room.e e17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar = this$0.showParams;
        if (bVar != null && (e17 = bVar.e()) != null) {
            e17.y(this$0.currentIsMute);
        }
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar2 = this$0.showParams;
        if (bVar2 != null && (e16 = bVar2.e()) != null) {
            view = e16.getVideoView();
        } else {
            view = null;
        }
        this$0.w(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar;
        com.tencent.mobileqq.qqlive.sail.room.e e16;
        String str;
        com.tencent.mobileqq.qqlive.sail.room.e e17;
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar2 = this.showParams;
        boolean z16 = false;
        if (bVar2 != null && (e17 = bVar2.e()) != null && e17.isPlaying()) {
            z16 = true;
        }
        if (!z16 && (bVar = this.showParams) != null && (e16 = bVar.e()) != null) {
            com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar3 = this.showParams;
            if (bVar3 != null) {
                str = bVar3.d();
            } else {
                str = null;
            }
            e16.k(str);
        }
    }

    private final void r() {
        com.tencent.mobileqq.qqlive.sail.room.e e16;
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar = this.showParams;
        if (bVar != null && (e16 = bVar.e()) != null) {
            e16.p(75, this);
            e16.x(this);
            e16.registerVideoPreparedListener(this);
            AppNetConnInfo.registerConnectionChangeReceiver(getContext(), this.netInfoHandler);
        }
    }

    private final void s() {
        final com.tencent.mobileqq.qqlive.sail.room.e e16;
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar = this.showParams;
        if (bVar == null || (e16 = bVar.e()) == null || e16.isDestroyed()) {
            return;
        }
        com.tencent.mobileqq.qqlive.report.h.b(new Function0<QQLiveQualityReportData.Builder>() { // from class: com.tencent.mobileqq.qqlive.widget.floatwindow.QQLiveFloatWindowView2$reportExitRoom$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.qqlive.sail.room.e.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final QQLiveQualityReportData.Builder invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (QQLiveQualityReportData.Builder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                com.tencent.mobileqq.qqlive.sail.model.player.a playerQuality = com.tencent.mobileqq.qqlive.sail.room.e.this.getPlayerQuality();
                QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
                QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
                return builder.traceId(c16 != null ? c16.n() : null).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_STEP).roomId(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.getRoomId())).roomType(String.valueOf(com.tencent.mobileqq.qqlive.sail.room.e.this.b().getRoomType())).desc("exit").ext6(com.tencent.mobileqq.qqlive.sail.room.e.this.b().v().toString()).ext7(com.tencent.mobileqq.qqlive.sail.room.e.this.b().w()).ext8(String.valueOf(System.currentTimeMillis())).ext19(playerQuality != null ? playerQuality.f() : null);
            }
        });
    }

    private final void u() {
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.nni, null);
        if (drawable != null) {
            drawable.setBounds(0, 0, wi2.c.b(12), wi2.c.b(12));
            TextView textView = this.endTipTextView;
            if (textView != null) {
                textView.setCompoundDrawables(drawable, null, null, null);
            }
            TextView textView2 = this.endTipTextView;
            if (textView2 != null) {
                textView2.setCompoundDrawablePadding(wi2.c.b(4));
            }
        }
        TextView textView3 = this.endTipTextView;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        ImageView imageView = this.coverImage;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        FrameLayout frameLayout = this.videoContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        ImageView imageView2 = this.volumeBtn;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    private final boolean v(boolean isVideoLandscape) {
        int i3;
        if (isVideoLandscape) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        int enterCustomFloatingScreen = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).enterCustomFloatingScreen(BaseApplication.getContext(), this, new FloatingScreenParams.FloatingBuilder().setShapeType(i3).setCanMove(true).setCanZoom(true).build(), g.class.getName(), 57);
        AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowView2", "showFloatWindow", "enterResult=" + enterCustomFloatingScreen);
        if (enterCustomFloatingScreen == 0) {
            return true;
        }
        return false;
    }

    private final void w(View videoView) {
        ViewGroup viewGroup;
        if (videoView != null) {
            ViewParent parent = videoView.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(videoView);
            }
            FrameLayout frameLayout = this.videoContainer;
            if (frameLayout != null) {
                frameLayout.addView(videoView, -1, -1);
            }
            ImageView imageView = this.coverImage;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    private final void x(boolean mute) {
        int i3;
        ImageView imageView = this.volumeBtn;
        if (imageView != null) {
            if (mute) {
                i3 = R.drawable.nnl;
            } else {
                i3 = R.drawable.nnm;
            }
            imageView.setImageResource(i3);
        }
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.currentIsMute;
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.sail.room.e k() {
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (!n() || (bVar = this.showParams) == null) {
            return null;
        }
        return bVar.e();
    }

    public final boolean n() {
        long j3;
        com.tencent.mobileqq.qqlive.sail.room.e e16;
        AudienceRoomInfo b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar = this.showParams;
        if (bVar != null && (e16 = bVar.e()) != null && (b16 = e16.b()) != null) {
            j3 = b16.e();
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        com.tencent.mobileqq.qqlive.sail.room.e e16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f60692w4) {
                com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar = this.showParams;
                if (bVar != null) {
                    if (ht3.a.e("qqlive_float_window_use_opaque_activity", true)) {
                        bVar.b().setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.qqlive.room.frame.activity.QQliveRoomActivity");
                    }
                    BaseApplication.context.startActivity(bVar.b());
                }
            } else if (num != null && num.intValue() == R.id.f60702w5) {
                boolean z16 = !this.currentIsMute;
                this.currentIsMute = z16;
                x(z16);
                com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar2 = this.showParams;
                if (bVar2 != null && (e16 = bVar2.e()) != null) {
                    e16.y(this.currentIsMute);
                }
            } else if (num != null && num.intValue() == R.id.f60662w1) {
                g();
                m();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowView2", NodeProps.ON_DETACHED_FROM_WINDOW);
        B();
    }

    @Override // mi2.c
    public void onError(int module, int errorType, int errorCode, @Nullable String extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(module), Integer.valueOf(errorType), Integer.valueOf(errorCode), extraInfo);
            return;
        }
        AegisLogger.INSTANCE.w("Audience|QQLiveFloatWindowView2", "onError", "roomId=" + l() + ", module=" + module + ", errorType=" + errorType + ", errorCode=" + errorCode);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.floatwindow.d
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveFloatWindowView2.o(QQLiveFloatWindowView2.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        qt3.a v3 = com.tencent.mobileqq.qqlive.sail.push.a.v(msgInfo);
        if (v3 != null && v3.f429496d == 0 && v3.f429494b == l()) {
            AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowView2", "onPush", "roomId=" + l() + ", video closed");
            u();
            g();
        }
    }

    @Override // mi2.g
    public void onVideoPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowView2", "onVideoPrepared", "roomId=" + l());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.floatwindow.c
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveFloatWindowView2.p(QQLiveFloatWindowView2.this);
            }
        });
    }

    public final boolean t(@NotNull com.tencent.mobileqq.qqlive.widget.floatwindow.b params) {
        boolean z16;
        com.tencent.mobileqq.qqlive.sail.room.e e16;
        com.tencent.mobileqq.qqlive.sail.room.e e17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        boolean z17 = false;
        if (params.e() == null) {
            AegisLogger.INSTANCE.e("Audience|QQLiveFloatWindowView2", "show", "invalid room");
            return false;
        }
        this.showParams = params;
        this.currentIsMute = params.g();
        AegisLogger.INSTANCE.i("Audience|QQLiveFloatWindowView2", "show", "room=" + l() + ", mute=" + params.g() + ", changePlayer=" + params.c() + ", url=" + params.d());
        if (params.f().getWidth() > params.f().getHeight()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!v(z16)) {
            return false;
        }
        A(params.e().b().getCover());
        x(params.g());
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar = this.showParams;
        if (bVar != null && bVar.c()) {
            z17 = true;
        }
        if (z17) {
            com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar2 = this.showParams;
            if (bVar2 != null && (e17 = bVar2.e()) != null) {
                e17.n(null);
            }
            r();
            if (h()) {
                q();
            }
        } else {
            com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar3 = this.showParams;
            if (bVar3 != null && (e16 = bVar3.e()) != null) {
                e16.y(this.currentIsMute);
            }
            w(params.e().getVideoView());
            r();
        }
        return true;
    }

    public final void y() {
        a a16;
        com.tencent.mobileqq.qqlive.sail.room.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (n()) {
            com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar = this.showParams;
            if (bVar != null && (a16 = bVar.a()) != null) {
                com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar2 = this.showParams;
                if (bVar2 != null) {
                    eVar = bVar2.e();
                } else {
                    eVar = null;
                }
                a16.a(eVar);
                return;
            }
            return;
        }
        AegisLogger.INSTANCE.w("Audience|QQLiveFloatWindowView2", "startHeartBeat", "roomId=" + l() + ", no enter room");
    }

    public final void z() {
        a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.widget.floatwindow.b bVar = this.showParams;
        if (bVar != null && (a16 = bVar.a()) != null) {
            a16.stop();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ QQLiveFloatWindowView2(Context context, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
        Context context2;
        if ((i3 & 1) != 0) {
            context2 = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
        } else {
            context2 = context;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveFloatWindowView2(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        View.inflate(context, R.layout.h_j, this);
        this.coverImage = (ImageView) findViewById(R.id.f60672w2);
        this.endTipTextView = (TextView) findViewById(R.id.f60682w3);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.f60692w4);
        ImageView imageView = null;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(this);
        } else {
            frameLayout = null;
        }
        this.videoContainer = frameLayout;
        ImageView imageView2 = (ImageView) findViewById(R.id.f60702w5);
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        } else {
            imageView2 = null;
        }
        this.volumeBtn = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.f60662w1);
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
            imageView = imageView3;
        }
        this.closeBtn = imageView;
        this.netInfoHandler = new b();
    }
}
