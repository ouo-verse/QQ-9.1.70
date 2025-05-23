package com.tencent.ams.dynamicwidget.landingpage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.tencent.ams.dynamicwidget.data.AdInfo;
import com.tencent.ams.dynamicwidget.data.LandingPageData;
import com.tencent.ams.dynamicwidget.view.NetworkImageView;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \\2\u00020\u0001:\u0001]B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010Y\u001a\u00020\b\u00a2\u0006\u0004\bZ\u0010[J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0014J\b\u0010 \u001a\u00020\u0004H\u0014J\b\u0010!\u001a\u00020\u0004H\u0014J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\bH\u0014J\b\u0010#\u001a\u00020\u0004H\u0014J \u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\bH\u0016J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0016J\u0012\u0010+\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016R\u0014\u0010.\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00103\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00105R\u0016\u0010D\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010CR\u0016\u0010E\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010F\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010 R\u0016\u0010H\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010GR*\u0010K\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010C\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001d\u0010S\u001a\u0004\u0018\u00010O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u00100\u001a\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010Y\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010G\u00a8\u0006^"}, d2 = {"Lcom/tencent/ams/dynamicwidget/landingpage/DefaultLandingPageView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "H", "", "o", "v", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/LinearLayout;", "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "Landroid/view/View;", "j", "E", "closeClickArea", "l", "", "upX", "upY", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", NodeProps.ON_ATTACHED_TO_WINDOW, UserInfo.SEX_FEMALE, "G", "w", HippyTKDListViewAdapter.X, "downX", "downY", "clickArea", BdhLogUtil.LogTag.Tag_Conn, "B", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "d", "Ljava/lang/String;", "defaultTitle", "e", "Lkotlin/Lazy;", "p", "()F", "cardViewHeight", "f", "Landroid/view/View;", "shadowView", "Landroid/view/ViewGroup;", h.F, "Landroid/view/ViewGroup;", "cardView", "i", "actionButtonView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleView", "subTitleView", "descriptorView", "closeView", "Z", "isShowing", "touchDownX", "touchDownY", "I", "touchArea", "value", "J", "isDarkMode", "()Z", "setDarkMode", "(Z)V", "Lorg/json/JSONObject;", "K", DomainData.DOMAIN_NAME, "()Lorg/json/JSONObject;", "adInfoJson", "Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "L", "Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "adInfo", "M", "chid", "<init>", "(Landroid/content/Context;Lcom/tencent/ams/dynamicwidget/data/AdInfo;I)V", "N", "a", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public class DefaultLandingPageView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView subTitleView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView descriptorView;

    /* renamed from: E, reason: from kotlin metadata */
    private View closeView;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isShowing;

    /* renamed from: G, reason: from kotlin metadata */
    private float touchDownX;

    /* renamed from: H, reason: from kotlin metadata */
    private float touchDownY;

    /* renamed from: I, reason: from kotlin metadata */
    private int touchArea;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isDarkMode;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy adInfoJson;

    /* renamed from: L, reason: from kotlin metadata */
    private final AdInfo adInfo;

    /* renamed from: M, reason: from kotlin metadata */
    private final int chid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String defaultTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy cardViewHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View shadowView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup cardView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View actionButtonView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView titleView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ams/dynamicwidget/landingpage/DefaultLandingPageView$a;", "", "", "CLOSE_IMAGE", "Ljava/lang/String;", "DEFAULT_AVATAR_BASE64", "TAG", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.ams.dynamicwidget.landingpage.DefaultLandingPageView$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) DefaultLandingPageView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                DefaultLandingPageView defaultLandingPageView = DefaultLandingPageView.this;
                defaultLandingPageView.B(defaultLandingPageView.touchDownX, DefaultLandingPageView.this.touchDownY);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b\u00b8\u0006\u0000"}, d2 = {"com/tencent/ams/dynamicwidget/landingpage/DefaultLandingPageView$hideCardView$1$1", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f70199e;

        c(int i3) {
            this.f70199e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DefaultLandingPageView.this, i3);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkParameterIsNotNull(animation, "animation");
            DefaultLandingPageView defaultLandingPageView = DefaultLandingPageView.this;
            defaultLandingPageView.C(defaultLandingPageView.touchDownX, DefaultLandingPageView.this.touchDownY, this.f70199e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ams/dynamicwidget/landingpage/DefaultLandingPageView$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f70200d;

        d(ViewGroup viewGroup) {
            this.f70200d = viewGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                this.f70200d.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                this.f70200d.setVisibility(4);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16324);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultLandingPageView(@NotNull Context context, @NotNull AdInfo adInfo, int i3) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(adInfo, "adInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, context, adInfo, Integer.valueOf(i3));
            return;
        }
        this.adInfo = adInfo;
        this.chid = i3;
        this.defaultTitle = "\u4e13\u5c5e\u54a8\u8be2\u987e\u95ee";
        lazy = LazyKt__LazyJVMKt.lazy(DefaultLandingPageView$cardViewHeight$2.INSTANCE);
        this.cardViewHeight = lazy;
        this.isDarkMode = com.tencent.ams.dynamicwidget.c.f70185s.h();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<JSONObject>() { // from class: com.tencent.ams.dynamicwidget.landingpage.DefaultLandingPageView$adInfoJson$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) DefaultLandingPageView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final JSONObject invoke() {
                AdInfo adInfo2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (JSONObject) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                try {
                    adInfo2 = DefaultLandingPageView.this.adInfo;
                    return new JSONObject(adInfo2.getOrderJson());
                } catch (Throwable th5) {
                    com.tencent.ams.dynamicwidget.utils.b.f70218a.b("DefaultLandingPageView", "parse order json failed", th5);
                    return null;
                }
            }
        });
        this.adInfoJson = lazy2;
        y(context);
        z(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0095, code lost:
    
        r12 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b3, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean A(float upX, float upY) {
        Map<String, Map<String, String>> map;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        Map<String, String> map2;
        Integer intOrNull;
        Map<String, String> map3;
        Integer intOrNull2;
        int width;
        Map<String, String> map4;
        Integer intOrNull3;
        Map<String, String> map5;
        Integer intOrNull4;
        com.tencent.ams.dynamicwidget.a a16 = com.tencent.ams.dynamicwidget.c.f70185s.a();
        if (a16 != null) {
            map = a16.a(new String[]{"ad_halfcard_close_slide_down", "ad_halfcard_close_slide_right"});
        } else {
            map = null;
        }
        if (map != null && (map5 = map.get("ad_halfcard_close_slide_right")) != null && (r5 = map5.get(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)) != null && intOrNull4 != null) {
            i3 = intOrNull4.intValue();
        } else {
            i3 = 0;
        }
        if (map != null && (map4 = map.get("ad_halfcard_close_slide_right")) != null && (r2 = map4.get("value")) != null && intOrNull3 != null) {
            i16 = intOrNull3.intValue();
        } else {
            i16 = 0;
        }
        if (i3 > 0 && i16 > 0 && (width = getWidth()) > 0 && (upX - this.touchDownX) / width >= i16 / 100.0f) {
            com.tencent.ams.dynamicwidget.utils.b.f70218a.a("DefaultLandingPageView", "isSlideClose, slide close right");
            l(3);
            return true;
        }
        if (map != null && (map3 = map.get("ad_halfcard_close_slide_down")) != null && (r12 = map3.get(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)) != null && intOrNull2 != null) {
            i17 = intOrNull2.intValue();
        } else {
            i17 = 0;
        }
        if (map != null && (map2 = map.get("ad_halfcard_close_slide_down")) != null && (r0 = map2.get("value")) != null && intOrNull != null) {
            i18 = intOrNull.intValue();
        } else {
            i18 = 0;
        }
        if (i17 > 0 && i17 > 0) {
            Object parent = getParent();
            if (parent instanceof View) {
                i19 = ((View) parent).getHeight();
            } else {
                i19 = 0;
            }
            if (i19 > 0 && (upY - this.touchDownY) / i19 >= i18 / 100.0f) {
                com.tencent.ams.dynamicwidget.utils.b.f70218a.a("DefaultLandingPageView", "isSlideClose, slide close down");
                l(2);
                return true;
            }
        }
        return false;
    }

    private final void D() {
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.dynamicwidget.landingpage.DefaultLandingPageView$onDarkModeChanged$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) DefaultLandingPageView.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                TextView textView;
                TextView textView2;
                TextView textView3;
                int s16;
                int s17;
                int v3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    DefaultLandingPageView.this.H();
                    textView = DefaultLandingPageView.this.titleView;
                    if (textView != null) {
                        v3 = DefaultLandingPageView.this.v();
                        textView.setTextColor(v3);
                    }
                    textView2 = DefaultLandingPageView.this.subTitleView;
                    if (textView2 != null) {
                        s17 = DefaultLandingPageView.this.s();
                        textView2.setTextColor(s17);
                    }
                    textView3 = DefaultLandingPageView.this.descriptorView;
                    if (textView3 != null) {
                        s16 = DefaultLandingPageView.this.s();
                        textView3.setTextColor(s16);
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        });
    }

    private final void E() {
        if (this.isShowing) {
            return;
        }
        this.isShowing = true;
        F();
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float dp2px = Utils.dp2px(12.0f);
        gradientDrawable.setColor(o());
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, dp2px, dp2px, 0.0f, 0.0f, 0.0f, 0.0f});
        ViewGroup viewGroup = this.cardView;
        if (viewGroup != null) {
            viewGroup.setBackground(gradientDrawable);
        }
    }

    private final View j(Context context) {
        ImageView imageView = new ImageView(context);
        com.tencent.ams.dynamicwidget.utils.d dVar = com.tencent.ams.dynamicwidget.utils.d.f70220a;
        int a16 = (int) dVar.a(20.0f);
        int a17 = (int) dVar.a(16.0f);
        int a18 = (int) dVar.a(13.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a16, a16);
        layoutParams.gravity = 5;
        layoutParams.topMargin = a17;
        layoutParams.rightMargin = a17;
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageBitmap(Utils.bitmapFromBase64StringSafe("iVBORw0KGgoAAAANSUhEUgAAABwAAAAcCAYAAAByDd+UAAAKpGlDQ1BJQ0MgUHJvZmlsZQAASImVlwdQU+kWx7970xsBEiKd0JsgnQBSQg9FkA6iEpIAocQYCAqiIrK4gmtBRATLiqyKKFgBWSsWLCyCvW+QRUBZFws2VN4NDMHdN++9eWfmy/nNyfnOOd+d+838LwAUNFcszoSVAcgS5UgiAryZcfEJTNwAwAESUANaQIfLyxazw8NDAGJT/u/2/i6A5P6WlbzWv///X02FL8jmAQCFI5zMz+ZlIXwcWTKeWJIDAKoCiRsuyRHLuRVhugQZEOFOOadOskzOyZP8biInKsIHADQeADyZy5WkAkCmI3FmLi8VqUN2QNhGxBeKEOYj7JGVtQjx5DqEzZAcMcLy+qzk7+qk/q1msqIml5uq4MmzTBjeV5gtzuTm/Z+P439bVqZ0qocJsshpksAIeT/kmd3PWBSsYFHynLApFvInZ5JzmjQweop52T4JU8zn+gYr9mbOCZniFKE/R1EnhxM1xYJsv8gpliyKUPRKkfiwp5grme4rzYhWxNMEHEX9/LSo2CnOFcbMmeLsjMjg6RwfRVwijVDMLxAFeE/39VecPSv7u/MKOYq9OWlRgYqzc6fnF4jY0zWz4xSz8QW+ftM50Yp8cY63opc4M1yRL8gMUMSzcyMVe3OQF3J6b7jiGaZzg8KnGAhBKOACXo5gaY58eJ9F4jyJMDUth8lGbpWAyRHxrGcy7Wzs7AGQ39HJV+AtY+LuQYxr07E1pgB4Jo6Pj7dNxwIOAnBkOQDEuumYGQoAKpJ7pZsnleROxtDyHwwgAiqgAw2gCwyBGbACdsAJuAEv4AeCQBiIAvFgAeCBNJAFJGAJKACrQAkoAxvBFlANdoE9YD84BI6CFnAKnAeXwXXQDe6AR0AG+sFLMALegzEIgnAQBaJBGpAeZAxZQnYQC/KA/KAQKAKKh5KgVEgESaECaDVUBpVD1dBuqB46Ap2EzkNXoR7oAdQLDUFvoM8wCibDdFgHNoFnwSyYDQfDUfB8OBVeDOfDxfB6uAquhQ/CzfB5+Dp8B5bBL+FRFECRUAyUPsoKxUL5oMJQCagUlAS1AlWKqkTVohpRbagO1C2UDDWM+oTGomloJtoK7YYOREejeejF6BXodehq9H50M/oi+ha6Fz2C/oahYLQxlhhXDAcTh0nFLMGUYCoxezEnMJcwdzD9mPdYLJaBNcU6YwOx8dh07DLsOuwObBP2HLYH24cdxeFwGjhLnDsuDMfF5eBKcNtwB3FncTdx/biPeBJeD2+H98cn4EX4Inwl/gD+DP4mfgA/RlAmGBNcCWEEPiGPsIFQR2gj3CD0E8aIKkRTojsxiphOXEWsIjYSLxEfE9+SSCQDkgtpLklIKiRVkQ6TrpB6SZ/IqmQLsg85kSwlryfvI58jPyC/pVAoJhQvSgIlh7KeUk+5QHlK+ahEU7JW4ijxlVYq1Sg1K91UekUlUI2pbOoCaj61knqMeoM6rExQNlH2UeYqr1CuUT6pfE95VIWmYqsSppKlsk7lgMpVlUFVnKqJqp8qX7VYdY/qBdU+GopmSPOh8WiraXW0S7R+OpZuSufQ0+ll9EP0LvqImqqag1qM2lK1GrXTajIGimHC4DAyGRsYRxl3GZ9n6MxgzxDMWDujccbNGR/UtdS91AXqpepN6nfUP2swNfw0MjQ2abRoPNFEa1poztVcorlT85LmsBZdy02Lp1WqdVTroTasbaEdob1Me492p/aojq5OgI5YZ5vOBZ1hXYaul266boXuGd0hPZqeh55Qr0LvrN4LphqTzcxkVjEvMkf0tfUD9aX6u/W79McMTA2iDYoMmgyeGBINWYYphhWG7YYjRnpGoUYFRg1GD40JxizjNOOtxh3GH0xMTWJN1pi0mAyaqptyTPNNG0wfm1HMPM0Wm9Wa3TbHmrPMM8x3mHdbwBaOFmkWNRY3LGFLJ0uh5Q7LnpmYmS4zRTNrZ96zIluxrXKtGqx6rRnWIdZF1i3Wr2YZzUqYtWlWx6xvNo42mTZ1No9sVW2DbIts22zf2FnY8exq7G7bU+z97Vfat9q/drB0EDjsdLjvSHMMdVzj2O741cnZSeLU6DTkbOSc5Lzd+R6LzgpnrWNdccG4eLusdDnl8snVyTXH9ajrX25WbhluB9wGZ5vOFsyum93nbuDOdd/tLvNgeiR5/Owh89T35HrWej7zMvTie+31GmCbs9PZB9mvvG28Jd4nvD/4uPos9znni/IN8C317fJT9Yv2q/Z76m/gn+rf4D8S4BiwLOBcICYwOHBT4D2ODofHqeeMBDkHLQ+6GEwOjgyuDn4WYhEiCWkLhUODQjeHPp5jPEc0pyUMhHHCNoc9CTcNXxz+61zs3PC5NXOfR9hGFER0RNIiF0YeiHwf5R21IepRtFm0NLo9hhqTGFMf8yHWN7Y8VhY3K2553PV4zXhhfGsCLiEmYW/C6Dy/eVvm9Sc6JpYk3p1vOn/p/KsLNBdkLji9kLqQu/BYEiYpNulA0hduGLeWO5rMSd6ePMLz4W3lveR78Sv4QwJ3QblgIMU9pTxlMNU9dXPqUJpnWmXasNBHWC18nR6Yviv9Q0ZYxr6M8czYzKYsfFZS1kmRqihDdHGR7qKli3rEluISsWyx6+Iti0ckwZK92VD2/OzWHDoihjqlZtIfpL25Hrk1uR+XxCw5tlRlqWhpZ55F3tq8gXz//F+WoZfxlrUX6BesKuhdzl6+ewW0InlF+0rDlcUr+wsDCvevIq7KWPVbkU1RedG71bGr24p1iguL+34I+KGhRKlEUnJvjduaXT+ifxT+2LXWfu22td9K+aXXymzKKsu+rOOtu/aT7U9VP42vT1nftcFpw86N2I2ijXc3eW7aX65Snl/etzl0c3MFs6K04t2WhVuuVjpU7tpK3CrdKqsKqWrdZrRt47Yv1WnVd2q8a5q2a29fu/3DDv6Omzu9djbu0tlVtuvzz8Kf7+8O2N1ca1JbuQe7J3fP87qYuo5fWL/U79XcW7b36z7RPtn+iP0X653r6w9oH9jQADdIG4YOJh7sPuR7qLXRqnF3E6Op7DA4LD384kjSkbtHg4+2H2MdazxufHz7CdqJ0maoOa95pCWtRdYa39pzMuhke5tb24lfrX/dd0r/VM1ptdMbzhDPFJ8ZP5t/dvSc+Nzw+dTzfe0L2x9diLtw++Lci12Xgi9duex/+UIHu+PsFfcrp666Xj15jXWt5brT9eZOx84Tvzn+dqLLqav5hvON1m6X7rae2T1nbnrePH/L99bl25zb1+/MudNzN/ru/XuJ92T3+fcHH2Q+eP0w9+HYo8LHmMelT5SfVD7Vflr7u/nvTTIn2ele397OZ5HPHvXx+l7+kf3Hl/7i55TnlQN6A/WDdoOnhvyHul/Me9H/UvxybLjkT5U/t78ye3X8L6+/OkfiRvpfS16Pv1n3VuPtvncO79pHw0efvs96P/ah9KPGx/2fWJ86Psd+Hhhb8gX3peqr+de2b8HfHo9njY+LuRLuhBRA1AGAU1IAeLMPAEo8ALRuRD/Mm9TQEwZN6v4JAv+JJ3X2hDkB0Ig4uRRiFwJwTC5hEa+EeLkMivICsL29Yk3p3QltLjcs8pXSaE99a6P1QNWiEPzDJnX7d3P/0wN5Vbn0/7v/F+AEAn13FEtjAAAAOGVYSWZNTQAqAAAACAABh2kABAAAAAEAAAAaAAAAAAACoAIABAAAAAEAAAAcoAMABAAAAAEAAAAcAAAAAEd11pgAAAGvSURBVEgNrdbPbcIwFAbw2hJwQVW7QMUI7QhlgvbMpUxQwQJlg/TGEfWQMxvACLBCJwCh5ABI0O9DdWTAcZ6DLZnE1vP75Y9tosbjcUdrnSil1o1GY9Dv99d3EctkMnnYbrcjpHw6Ho9DWDpB4w2Nj/1+P2dALC9N00fmxM18or6jJhrQrwFw/hwLJZbn+Yw5TX6AK91qtUboWJrOGKgLQ/5Fs9kcKkJ8jLvdbo5T+2qWeKevoe/Ug3WZ6wTGQqswOgV4KyrBrsC6qBRzgqFoCFYKStFQzAtWoZji6nKdYQyn/mk2cryrnE0aV0DZkmGsvajRrMQ4phJkkAtlv1VEGONFIAM9qBhjHs0facFeKA0tjROBnI3c1C/emUn6gm1xxidgOnzHStA19XGn3OyLDR/nYtQLujAkX3BTb7fb3Tpo6Uspw+x1xpgsy2aAi38ZXpAdg/ZZcYISzGQJRa/AEKwOegbWwULRArwFC0FPYAxMiqqYmATVm80mudhBvNPaJPUde73eyrVO8UH8pbFr3FuDb8ZMrhK0ww/hIeoU9du3YE2ikKNBD4fDz78x+APKk+rJaN+afgAAAABJRU5ErkJggg==", a18, a18));
        this.closeView = imageView;
        return imageView;
    }

    private final LinearLayout k(Context context) {
        Object m476constructorimpl;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        com.tencent.ams.dynamicwidget.utils.d dVar = com.tencent.ams.dynamicwidget.utils.d.f70220a;
        int a16 = (int) dVar.a(70.0f);
        NetworkImageView networkImageView = new NetworkImageView(context);
        float f16 = a16;
        networkImageView.setErrorBitmap(MosaicUtils.d("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", f16, f16));
        networkImageView.setRadius(dVar.a(10.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a16, a16);
        layoutParams.topMargin = (int) dVar.a(30.0f);
        networkImageView.setSrc(q());
        linearLayout.addView(networkImageView, layoutParams);
        TextView textView = new TextView(context);
        textView.setTextSize(0, dVar.a(18.0f));
        textView.setTextColor(v());
        TextPaint paint = textView.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        textView.setText(u());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, (int) dVar.a(24.0f));
        layoutParams2.topMargin = (int) dVar.a(10.0f);
        linearLayout.addView(textView, layoutParams2);
        this.titleView = textView;
        TextView textView2 = new TextView(context);
        textView2.setTextSize(0, dVar.a(13.0f));
        textView2.setTextColor(s());
        textView2.setSingleLine(true);
        textView2.setText(r());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = (int) dVar.a(8.0f);
        linearLayout.addView(textView2, layoutParams3);
        this.subTitleView = textView2;
        TextView textView3 = new TextView(context);
        textView3.setTextSize(0, dVar.a(16.0f));
        textView3.setTextColor(-1);
        textView3.setSingleLine(true);
        TextPaint paint2 = textView3.getPaint();
        if (paint2 != null) {
            paint2.setFakeBoldText(true);
        }
        textView3.setText(m());
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(Integer.valueOf(Color.parseColor(com.tencent.ams.dynamicwidget.c.f70185s.f())));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            m476constructorimpl = Integer.valueOf(Color.parseColor("#FF3377FF"));
        }
        gradientDrawable.setColor(((Number) m476constructorimpl).intValue());
        com.tencent.ams.dynamicwidget.utils.d dVar2 = com.tencent.ams.dynamicwidget.utils.d.f70220a;
        gradientDrawable.setCornerRadius(dVar2.a(40.0f));
        textView3.setBackground(gradientDrawable);
        textView3.setGravity(17);
        textView3.setOnClickListener(new b());
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, (int) dVar2.a(48.0f));
        int a17 = (int) dVar2.a(57.0f);
        layoutParams4.leftMargin = a17;
        layoutParams4.rightMargin = a17;
        layoutParams4.topMargin = (int) dVar2.a(29.0f);
        linearLayout.addView(textView3, layoutParams4);
        this.actionButtonView = textView3;
        TextView textView4 = new TextView(context);
        textView4.setTextSize(0, dVar2.a(13.0f));
        textView4.setTextColor(s());
        textView4.setSingleLine(true);
        textView4.setVisibility(0);
        textView4.setText(t());
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = (int) dVar2.a(10.0f);
        linearLayout.addView(textView4, layoutParams5);
        this.descriptorView = textView4;
        return linearLayout;
    }

    private final void l(int closeClickArea) {
        if (this.isShowing) {
            this.isShowing = false;
            w(closeClickArea);
            x();
        }
    }

    private final String m() {
        JSONObject n3;
        JSONObject optJSONObject;
        String actionButtonTitle;
        boolean z16;
        LandingPageData landingPageData = this.adInfo.getLandingPageData();
        if (landingPageData != null && (actionButtonTitle = landingPageData.getActionButtonTitle()) != null) {
            if (actionButtonTitle.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return actionButtonTitle;
            }
        }
        int i3 = this.chid;
        if (i3 == 2) {
            JSONObject n16 = n();
            if (n16 == null || (optJSONObject = n16.optJSONObject("action_btn")) == null) {
                return null;
            }
            return optJSONObject.optString("text");
        }
        if (i3 != 6 || (n3 = n()) == null) {
            return null;
        }
        return n3.optString(AppDownloadCallback.BUTTON_TXT);
    }

    private final JSONObject n() {
        return (JSONObject) this.adInfoJson.getValue();
    }

    private final int o() {
        if (this.isDarkMode) {
            return Color.parseColor("#1F1F1F");
        }
        return -1;
    }

    private final float p() {
        return ((Number) this.cardViewHeight.getValue()).floatValue();
    }

    private final String q() {
        JSONObject n3;
        String iconUrl;
        boolean z16;
        LandingPageData landingPageData = this.adInfo.getLandingPageData();
        if (landingPageData != null && (iconUrl = landingPageData.getIconUrl()) != null) {
            if (iconUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return iconUrl;
            }
        }
        int i3 = this.chid;
        if (i3 == 2) {
            JSONObject n16 = n();
            if (n16 == null) {
                return null;
            }
            return n16.optString("icon_url");
        }
        if (i3 != 6 || (n3 = n()) == null) {
            return null;
        }
        return n3.optString("corporate_logo");
    }

    private final String r() {
        JSONObject n3;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        String subTitle;
        boolean z16;
        LandingPageData landingPageData = this.adInfo.getLandingPageData();
        if (landingPageData != null && (subTitle = landingPageData.getSubTitle()) != null) {
            if (subTitle.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return subTitle;
            }
        }
        int i3 = this.chid;
        if (i3 == 2) {
            JSONObject n16 = n();
            if (n16 == null || (optJSONObject = n16.optJSONObject("landing_page_info")) == null || (optJSONObject2 = optJSONObject.optJSONObject("half_screen_card_info")) == null) {
                return null;
            }
            return optJSONObject2.optString("consulting_text");
        }
        if (i3 != 6 || (n3 = n()) == null) {
            return null;
        }
        return n3.optString("conversion_desc");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s() {
        if (this.isDarkMode) {
            return Color.parseColor("#696969");
        }
        return Color.parseColor("#999999");
    }

    private final String t() {
        JSONObject n3;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        String tipsTitle;
        boolean z16;
        LandingPageData landingPageData = this.adInfo.getLandingPageData();
        if (landingPageData != null && (tipsTitle = landingPageData.getTipsTitle()) != null) {
            if (tipsTitle.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return tipsTitle;
            }
        }
        int i3 = this.chid;
        if (i3 == 2) {
            JSONObject n16 = n();
            if (n16 == null || (optJSONObject2 = n16.optJSONObject("landing_page_info")) == null || (optJSONObject3 = optJSONObject2.optJSONObject("half_screen_card_info")) == null) {
                return null;
            }
            return optJSONObject3.optString("additional_text");
        }
        if (i3 != 6 || (n3 = n()) == null || (optJSONObject = n3.optJSONObject("half_screen_card_config")) == null) {
            return null;
        }
        return optJSONObject.optString("additional_txt");
    }

    private final String u() {
        JSONObject n3;
        String title;
        boolean z16;
        LandingPageData landingPageData = this.adInfo.getLandingPageData();
        boolean z17 = true;
        if (landingPageData != null && (title = landingPageData.getTitle()) != null) {
            if (title.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return title;
            }
        }
        int i3 = this.chid;
        String str = null;
        if (i3 == 2) {
            JSONObject n16 = n();
            if (n16 != null) {
                str = n16.optString("navTitle");
            }
        } else if (i3 == 6 && (n3 = n()) != null) {
            str = n3.optString("corporate_image_name");
        }
        if (str != null && str.length() != 0) {
            z17 = false;
        }
        if (z17) {
            return this.defaultTitle;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int v() {
        if (this.isDarkMode) {
            return -1;
        }
        return Color.parseColor("#333333");
    }

    private final void y(Context context) {
        View view = new View(context);
        view.setBackgroundColor(TextNode.DEFAULT_TEXT_SHADOW_COLOR);
        addView(view, new FrameLayout.LayoutParams(-1, -1));
        this.shadowView = view;
    }

    private final void z(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(k(context));
        frameLayout.addView(j(context));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) p());
        layoutParams.gravity = 80;
        addView(frameLayout, layoutParams);
        this.cardView = frameLayout;
        H();
    }

    public void B(float downX, float downY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(downX), Float.valueOf(downY));
        }
    }

    public void C(float downX, float downY, int clickArea) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(downX), Float.valueOf(downY), Integer.valueOf(clickArea));
        }
    }

    protected void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ViewGroup viewGroup = this.cardView;
        if (viewGroup != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, "translationY", p(), 0.0f);
            Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(i\u2026onY\", cardViewHeight, 0f)");
            try {
                ofFloat.setInterpolator(new PathInterpolator(0.04f, 0.75f, 0.63f, 1.0f));
            } catch (Throwable unused) {
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewGroup, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.setDuration(270L);
            animatorSet.start();
            animatorSet.addListener(new d(viewGroup));
        }
    }

    protected void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        View view = this.shadowView;
        if (view != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat.setDuration(270L);
            ofFloat.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) ev5)).booleanValue();
        }
        if (ev5 != null && ev5.getAction() == 0) {
            this.touchDownX = ev5.getX();
            this.touchDownY = ev5.getY();
            com.tencent.ams.dynamicwidget.utils.d dVar = com.tencent.ams.dynamicwidget.utils.d.f70220a;
            float a16 = dVar.a(10.0f);
            if (dVar.f(this.actionButtonView, ev5.getX(), ev5.getY(), this)) {
                this.touchArea = 1;
            } else if (dVar.e(this.closeView, ev5.getX(), ev5.getY(), a16, a16, this)) {
                this.touchArea = 2;
            } else if (dVar.f(this.cardView, ev5.getX(), ev5.getY(), this)) {
                this.touchArea = 3;
            }
            com.tencent.ams.dynamicwidget.utils.b.f70218a.c("DefaultLandingPageView", "touch down area:" + this.touchArea);
            return true;
        }
        if (ev5 != null && ev5.getAction() == 1) {
            if (A(ev5.getX(), ev5.getY())) {
                com.tencent.ams.dynamicwidget.utils.b.f70218a.c("DefaultLandingPageView", "isSlideClose, slide close");
            } else {
                int i3 = this.touchArea;
                if (i3 == 1) {
                    B(this.touchDownX, this.touchDownY);
                } else if (i3 == 2) {
                    l(0);
                } else if (i3 != 3) {
                    l(1);
                }
            }
            this.touchArea = 0;
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onAttachedToWindow();
            E();
        }
    }

    public final void setDarkMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.isDarkMode = z16;
            D();
        }
    }

    protected void w(int closeClickArea) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, closeClickArea);
            return;
        }
        ViewGroup viewGroup = this.cardView;
        if (viewGroup != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, "translationY", 0.0f, p());
            Intrinsics.checkExpressionValueIsNotNull(ofFloat, "ObjectAnimator.ofFloat(i\u2026onY\", 0f, cardViewHeight)");
            try {
                ofFloat.setInterpolator(new PathInterpolator(0.39f, 0.0f, 0.95f, 0.44f));
            } catch (Throwable unused) {
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewGroup, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.setDuration(200L);
            animatorSet.addListener(new c(closeClickArea));
            animatorSet.start();
        }
    }

    protected void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        View view = this.shadowView;
        if (view != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.start();
        }
    }
}
