package com.tencent.biz.qqcircle.immersive.utils.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdVideoView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001NB1\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010J\u001a\u00020\u001b\u0012\b\b\u0002\u0010K\u001a\u00020\u001b\u00a2\u0006\u0004\bL\u0010MJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0014J\b\u0010\u001a\u001a\u00020\u0006H\u0014J\b\u0010\u001c\u001a\u00020\u001bH%R\u001a\u0010\"\u001a\u00020\u001d8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010(\u001a\u00020#8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010-\u001a\u00020\u00118\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010\u001fR\u0014\u00101\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010%R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R$\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006O"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdBaseView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Landroid/content/Context;", "context", "", "C0", "Lcom/tencent/gdtad/aditem/GdtHandler$Params;", "clickParams", "J0", "", "picUrl", "", "N0", "O0", "L0", "Landroid/view/View;", "layoutContent", "", "bgRadius", "Q0", "", "position", "duration", "K0", NodeProps.ON_DETACHED_FROM_WINDOW, "", "F0", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "G0", "()Landroid/widget/ImageView;", "mediaImage", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "I0", "()Landroid/widget/RelativeLayout;", "videoLayout", "f", "Landroid/view/View;", "H0", "()Landroid/view/View;", "negativeFeedback", tl.h.F, "muteBtn", "i", "mediaContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/gdtad/aditem/GdtAd;", "Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdBaseView$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdBaseView$a;", "E0", "()Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdBaseView$a;", "setDismissCallback", "(Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdBaseView$a;)V", "dismissCallback", "Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdVideoView;", "D", "Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdVideoView;", "gdtVideoWrapper", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "E", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "exposureChecker", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", UserInfo.SEX_FEMALE, "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "exposureCheckerCallback", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class QFSPauseAdBaseView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a dismissCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QFSPauseAdVideoView gdtVideoWrapper;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private AdExposureChecker exposureChecker;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private AdExposureChecker.ExposureCallback exposureCheckerCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView mediaImage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout videoLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View negativeFeedback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView muteBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout mediaContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtAd gdtAd;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdBaseView$a;", "", "", "restartVideo", "", "onDismiss", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface a {
        void onDismiss(boolean restartVideo);
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdBaseView$b", "Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdVideoView$a;", "", "position", "duration", "", "onPlayProgress", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements QFSPauseAdVideoView.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdVideoView.a
        public void onPlayProgress(long position, long duration) {
            QFSPauseAdBaseView.this.K0(position, duration);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdBaseView$c", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f90072a;

        c(float f16) {
            this.f90072a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), cx.a(this.f90072a));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPauseAdBaseView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void C0(final GdtAd gdtAd, Context context) {
        GdtOriginalExposureReporter.reportOriginalExposure(gdtAd, context);
        this.exposureCheckerCallback = new AdExposureChecker.ExposureCallback() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.k
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                QFSPauseAdBaseView.D0(GdtAd.this, weakReference);
            }
        };
        AdExposureChecker adExposureChecker = new AdExposureChecker(gdtAd, new mqq.util.WeakReference(this));
        this.exposureChecker = adExposureChecker;
        adExposureChecker.setCallback(new mqq.util.WeakReference(this.exposureCheckerCallback));
        AdExposureChecker adExposureChecker2 = this.exposureChecker;
        if (adExposureChecker2 != null) {
            adExposureChecker2.startCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(GdtAd gdtAd, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(gdtAd, "$gdtAd");
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).doCgiReport(gdtAd.getUrlForImpression());
    }

    private final void J0(GdtHandler.Params clickParams) {
        QFSPauseAdVideoView qFSPauseAdVideoView = this.gdtVideoWrapper;
        if (qFSPauseAdVideoView != null) {
            qFSPauseAdVideoView.r();
        }
        AdExposureChecker.onClick(getContext(), this.gdtAd, new mqq.util.WeakReference(this.exposureCheckerCallback));
        clickParams.videoCeilingSupportedIfNotInstalled = true;
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(clickParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(QFSPauseAdBaseView this$0, GdtHandler.Params clickParams, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clickParams, "$clickParams");
        this$0.J0(clickParams);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean N0(String picUrl) {
        boolean z16;
        boolean isBlank;
        if (picUrl != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(picUrl);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                this.mediaImage.setImageDrawable(com.tencent.biz.qqcircle.immersive.utils.ad.b.a(picUrl));
                return true;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean O0(GdtAd gdtAd) {
        boolean z16;
        boolean isBlank;
        String videoUrl = gdtAd.getVideoUrl();
        if (videoUrl != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(videoUrl);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                this.videoLayout.setVisibility(0);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                final QFSPauseAdVideoView qFSPauseAdVideoView = new QFSPauseAdVideoView(context, this.mediaContainer, gdtAd);
                this.muteBtn.setSelected(qFSPauseAdVideoView.getIsVideoMute());
                this.muteBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QFSPauseAdBaseView.P0(QFSPauseAdVideoView.this, view);
                    }
                });
                this.gdtVideoWrapper = qFSPauseAdVideoView;
                qFSPauseAdVideoView.u(new b());
                return true;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(QFSPauseAdVideoView this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.v(!this_apply.getIsVideoMute());
        view.setSelected(this_apply.getIsVideoMute());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Nullable
    /* renamed from: E0, reason: from getter */
    public final a getDismissCallback() {
        return this.dismissCallback;
    }

    @LayoutRes
    protected abstract int F0();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: G0, reason: from getter */
    public final ImageView getMediaImage() {
        return this.mediaImage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: H0, reason: from getter */
    public final View getNegativeFeedback() {
        return this.negativeFeedback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: I0, reason: from getter */
    public final RelativeLayout getVideoLayout() {
        return this.videoLayout;
    }

    public boolean L0(@NotNull GdtAd gdtAd) {
        boolean N0;
        Activity activity;
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        if (gdtAd.getInnerShowType() == 3) {
            N0 = O0(gdtAd);
        } else {
            N0 = N0(gdtAd.getBasic_img());
        }
        if (!N0) {
            return false;
        }
        final GdtHandler.Params params = new GdtHandler.Params();
        params.processId = MobileQQ.sProcessId;
        params.f108486ad = gdtAd;
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        params.activity = new mqq.util.WeakReference(activity);
        Bundle bundle = new Bundle();
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_ads_xsj");
        params.extra = bundle;
        this.mediaImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPauseAdBaseView.M0(QFSPauseAdBaseView.this, params, view);
            }
        });
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        C0(gdtAd, context2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q0(@NotNull View layoutContent, float bgRadius) {
        Intrinsics.checkNotNullParameter(layoutContent, "layoutContent");
        layoutContent.setOutlineProvider(new c(bgRadius));
        layoutContent.setClipToOutline(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QFSPauseAdVideoView qFSPauseAdVideoView = this.gdtVideoWrapper;
        if (qFSPauseAdVideoView != null) {
            qFSPauseAdVideoView.s();
        }
    }

    public final void setDismissCallback(@Nullable a aVar) {
        this.dismissCallback = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPauseAdBaseView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPauseAdBaseView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QFSPauseAdBaseView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPauseAdBaseView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, F0(), this);
        View findViewById = findViewById(R.id.sbh);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_card_image)");
        this.mediaImage = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f42521k0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_full_screen_pause_ad_mute)");
        this.muteBtn = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.krz);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.video_layout)");
        this.videoLayout = (RelativeLayout) findViewById3;
        View findViewById4 = findViewById(R.id.f167092kq3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.video_container)");
        this.mediaContainer = (RelativeLayout) findViewById4;
        View findViewById5 = findViewById(R.id.sb7);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ad_card_ad_source_layout)");
        this.negativeFeedback = findViewById5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K0(long position, long duration) {
    }
}
