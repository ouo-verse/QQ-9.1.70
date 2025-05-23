package com.tencent.input.base.panelcontainer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.view.FilterEnum;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002ANB\u0010\u0012\u0006\u0010S\u001a\u00020Q\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J(\u0010\u0015\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J \u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J(\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J,\u0010 \u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\fH\u0002J \u0010!\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\fH\u0002J \u0010\"\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\fH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0018\u0010'\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H\u0002J\u0014\u0010)\u001a\u00020\t*\u00020(2\u0006\u0010$\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020\tH\u0002J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0006H\u0002J\u0019\u0010/\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b/\u00100J\u0010\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020%H\u0002J\u0012\u00104\u001a\u00020\t2\b\b\u0002\u00103\u001a\u00020\fH\u0002J\b\u00105\u001a\u00020\tH\u0002J(\u0010;\u001a\u00020\t2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020%H\u0002J\u0018\u0010@\u001a\u00020(2\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>H\u0016J\b\u0010A\u001a\u00020\tH\u0016J\u0010\u0010B\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010D\u001a\u00020\t2\u0006\u0010C\u001a\u00020\fH\u0016J \u0010E\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010F\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010G\u001a\u00020\t2\u0006\u00101\u001a\u00020%2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010J\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\fH\u0016J\u0018\u0010L\u001a\u00020\t2\u0006\u0010K\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0006H\u0016J\b\u0010M\u001a\u00020\u0006H\u0016J\b\u0010N\u001a\u00020\u0006H\u0016J\b\u0010O\u001a\u00020\u0006H\u0016J\b\u0010P\u001a\u00020\tH\u0016R\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010RR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010ZR\u0016\u0010^\u001a\u00020\\8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010]R\u0016\u0010a\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010bR\u0016\u0010d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010\"R\u0016\u0010e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010\"R\u0016\u0010g\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010fR\u0016\u0010h\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010\"R\u0016\u0010j\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010\"R\u0016\u0010l\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010\"R\u0016\u0010n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010\"R\u0016\u0010p\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010\"R\u0016\u0010r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010\"R\u001e\u0010v\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010z\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b|\u0010}\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/input/base/panelcontainer/PanelContainerLayoutWrapper;", "Lcom/tencent/input/base/panelcontainer/e;", "", "density", "Landroid/content/res/Configuration;", "configuration", "", "M", "newConfig", "", "Y", "panelId", "", "needAnim", "delayTime", "W", "P", "y", "G", "targetHeight", "keyboardWillHide", "T", "initialHeight", "U", "V", HippyTKDListViewAdapter.X, "Landroid/animation/Animator$AnimatorListener;", "listener", "Landroid/animation/ValueAnimator;", "v", "keyboardFutureHeight", "needRemoveCurrentPanelView", "K", "O", "I", "J", "height", "", "methodTag", "E", "Landroid/view/View;", ExifInterface.LATITUDE_SOUTH, "X", "heightOffset", "D", "keyboardHeight", BdhLogUtil.LogTag.Tag_Req, UserInfo.SEX_FEMALE, "(I)Ljava/lang/Integer;", "source", "H", "requestLayout", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/ViewTreeObserver;", "viewTreeObserver", "addCounter", "removeCounter", "invokeTag", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Lcom/tencent/mvi/runtime/strategy/b;", "strategyService", "d", "a", "onConfigurationChanged", "isInMultiWindowMode", "onMultiWindowModeChanged", "g", tl.h.F, "e", "j", "needInfluenceCurPanel", "k", "isShowKeyboard", "f", "i", "b", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/input/base/panelcontainer/d;", "Lcom/tencent/input/base/panelcontainer/d;", "mWrapperConnApi", "", "[F", "mAnimationKeyframeFractions", "Landroid/animation/TimeInterpolator;", "Landroid/animation/TimeInterpolator;", "mInterpolator", "Landroid/animation/ValueAnimator;", "mValueAnimator", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Lcom/tencent/input/base/panelcontainer/PanelFrameLayout;", "Lcom/tencent/input/base/panelcontainer/PanelFrameLayout;", "mPanelLayout", "Landroid/view/View;", "mCurPanelView", "mNormalPanelHeight", "mMultiWindowPanelHeight", "Z", "mIsInMultiWindowMode", "mOrientation", "l", "mScreenWidthDp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mScreenHeightDp", DomainData.DOMAIN_NAME, "mCurPanelId", "o", "mCurPanelHeight", "p", "mState", "Lkotlin/Function0;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/jvm/functions/Function0;", "mOnKeyboardHideHandler", "Lcom/tencent/mvi/log/b;", "r", "Lcom/tencent/mvi/log/b;", "mLogger", "Lcom/tencent/input/base/panelcontainer/PanelContainerLayoutWrapper$b;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/input/base/panelcontainer/PanelContainerLayoutWrapper$b;", "mGlobalLayoutListener", "<init>", "(Lcom/tencent/input/base/panelcontainer/d;)V", "t", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class PanelContainerLayoutWrapper implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: u, reason: collision with root package name */
    private static int f116779u;

    /* renamed from: v, reason: collision with root package name */
    private static int f116780v;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.input.base.panelcontainer.d mWrapperConnApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] mAnimationKeyframeFractions;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TimeInterpolator mInterpolator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mValueAnimator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private PanelFrameLayout mPanelLayout;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mCurPanelView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mNormalPanelHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mMultiWindowPanelHeight;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean mIsInMultiWindowMode;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int mOrientation;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int mScreenWidthDp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mScreenHeightDp;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int mCurPanelId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int mCurPanelHeight;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int mState;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> mOnKeyboardHideHandler;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mvi.log.b mLogger;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private b mGlobalLayoutListener;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/input/base/panelcontainer/PanelContainerLayoutWrapper$a;", "", "", "ANIM_TIME", "J", "", "DEFAULT_PANEL_HEIGHT", "I", "", "ENABLE_TRACE", "Z", "MULTI_WINDOW_PANEL_HEIGHT", "", "TAG", "Ljava/lang/String;", "sAddCount", "sRemoveCount", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.input.base.panelcontainer.PanelContainerLayoutWrapper$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/input/base/panelcontainer/PanelContainerLayoutWrapper$b;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/input/base/panelcontainer/PanelContainerLayoutWrapper;", "d", "Ljava/lang/ref/WeakReference;", "getWrapperRef", "()Ljava/lang/ref/WeakReference;", "wrapperRef", "<init>", "(Ljava/lang/ref/WeakReference;)V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<PanelContainerLayoutWrapper> wrapperRef;

        public b(@NotNull WeakReference<PanelContainerLayoutWrapper> wrapperRef) {
            Intrinsics.checkNotNullParameter(wrapperRef, "wrapperRef");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) wrapperRef);
            } else {
                this.wrapperRef = wrapperRef;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            PanelContainerLayoutWrapper panelContainerLayoutWrapper = this.wrapperRef.get();
            if (panelContainerLayoutWrapper != null) {
                int i3 = panelContainerLayoutWrapper.mCurPanelHeight;
                PanelFrameLayout panelFrameLayout = panelContainerLayoutWrapper.mPanelLayout;
                if (panelFrameLayout != null) {
                    if (i3 != panelFrameLayout.getHeight()) {
                        PanelFrameLayout panelFrameLayout2 = panelContainerLayoutWrapper.mPanelLayout;
                        if (panelFrameLayout2 != null) {
                            panelContainerLayoutWrapper.mCurPanelHeight = panelFrameLayout2.getHeight();
                            panelContainerLayoutWrapper.mWrapperConnApi.d(panelContainerLayoutWrapper.mCurPanelHeight);
                            return;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                            throw null;
                        }
                    }
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                throw null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/input/base/panelcontainer/PanelContainerLayoutWrapper$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationEnd", "", "d", "Z", "mIsCanceled", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean mIsCanceled;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PanelContainerLayoutWrapper.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                this.mIsCanceled = true;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else if (!this.mIsCanceled && PanelContainerLayoutWrapper.this.mState == 5) {
                PanelContainerLayoutWrapper.this.mState = 1;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/input/base/panelcontainer/PanelContainerLayoutWrapper$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "", "d", "Z", "mIsCanceled", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean mIsCanceled;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PanelContainerLayoutWrapper.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                com.tencent.mvi.log.b bVar = PanelContainerLayoutWrapper.this.mLogger;
                if (bVar != null) {
                    bVar.d("PanelContainerLayoutWrapper", "showPanelAnimatedly on animation cancel");
                }
                this.mIsCanceled = true;
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                com.tencent.mvi.log.b bVar = PanelContainerLayoutWrapper.this.mLogger;
                if (bVar != null) {
                    bVar.d("PanelContainerLayoutWrapper", "showPanelAnimatedly on animation end");
                }
                if (!this.mIsCanceled && PanelContainerLayoutWrapper.this.mState == 4) {
                    PanelContainerLayoutWrapper.this.mState = 3;
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            super.onAnimationStart(animation);
            com.tencent.mvi.log.b bVar = PanelContainerLayoutWrapper.this.mLogger;
            if (bVar != null) {
                bVar.d("PanelContainerLayoutWrapper", "showPanelAnimatedly on animation start");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21135);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PanelContainerLayoutWrapper(@NotNull com.tencent.input.base.panelcontainer.d mWrapperConnApi) {
        Intrinsics.checkNotNullParameter(mWrapperConnApi, "mWrapperConnApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mWrapperConnApi);
            return;
        }
        this.mWrapperConnApi = mWrapperConnApi;
        this.mAnimationKeyframeFractions = new float[]{0.0f, 1.0f};
        this.mInterpolator = new TimeInterpolator() { // from class: com.tencent.input.base.panelcontainer.g
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f16) {
                float N;
                N = PanelContainerLayoutWrapper.N(f16);
                return N;
            }
        };
        this.mCurPanelId = -1;
        this.mState = 1;
    }

    private final void A() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        E(0, "cleanPanelContainerState");
        this.mCurPanelId = -1;
        this.mState = 1;
        this.mCurPanelHeight = 0;
        PanelFrameLayout panelFrameLayout = this.mPanelLayout;
        if (panelFrameLayout != null) {
            ViewTreeObserver viewTreeObserver = panelFrameLayout.getViewTreeObserver();
            b bVar = this.mGlobalLayoutListener;
            if (bVar != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(bVar);
                Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "viewTreeObserver");
                int i3 = f116779u;
                int i16 = f116780v + 1;
                f116780v = i16;
                Q(viewTreeObserver, i3, i16, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mGlobalLayoutListener");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
        throw null;
    }

    private final void B(boolean requestLayout) {
        View view = this.mCurPanelView;
        if (view != null) {
            PanelFrameLayout panelFrameLayout = this.mPanelLayout;
            if (panelFrameLayout != null) {
                Intrinsics.checkNotNull(view);
                panelFrameLayout.removeViewInLayout(view);
                this.mCurPanelView = null;
                if (requestLayout) {
                    PanelFrameLayout panelFrameLayout2 = this.mPanelLayout;
                    if (panelFrameLayout2 != null) {
                        panelFrameLayout2.requestLayout();
                        return;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                        throw null;
                    }
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
            throw null;
        }
    }

    static /* synthetic */ void C(PanelContainerLayoutWrapper panelContainerLayoutWrapper, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        panelContainerLayoutWrapper.B(z16);
    }

    private final int D(int heightOffset) {
        if (this.mState == 3) {
            return heightOffset + z(this, 0, 1, null);
        }
        return heightOffset;
    }

    private final void E(int height, String methodTag) {
        PanelFrameLayout panelFrameLayout = this.mPanelLayout;
        if (panelFrameLayout != null) {
            S(panelFrameLayout, height);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
            throw null;
        }
    }

    private final Integer F(int panelId) {
        Integer Y;
        int coerceAtLeast;
        pz0.b c16 = this.mWrapperConnApi.c(panelId);
        if (c16 != null && (Y = c16.Y(this.mIsInMultiWindowMode)) != null) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Y.intValue(), 0);
            return Integer.valueOf(coerceAtLeast);
        }
        return null;
    }

    private final int G() {
        if (this.mIsInMultiWindowMode) {
            return this.mMultiWindowPanelHeight;
        }
        return this.mNormalPanelHeight;
    }

    private final void H(String source) {
        Context context = this.mContext;
        if (context != null) {
            Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                PanelFrameLayout panelFrameLayout = this.mPanelLayout;
                if (panelFrameLayout != null) {
                    inputMethodManager.hideSoftInputFromWindow(panelFrameLayout.getWindowToken(), 0);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                    throw null;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        throw null;
    }

    private final void I(boolean needAnim, int keyboardFutureHeight, boolean needRemoveCurrentPanelView) {
        if (needRemoveCurrentPanelView) {
            C(this, false, 1, null);
        }
        if (needAnim) {
            PanelFrameLayout panelFrameLayout = this.mPanelLayout;
            if (panelFrameLayout != null) {
                J(panelFrameLayout.getLayoutParams().height - keyboardFutureHeight);
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                throw null;
            }
        }
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        E(0, "hidePanelAndChangeState");
        this.mState = 1;
    }

    private final void J(int initialHeight) {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        PanelFrameLayout panelFrameLayout = this.mPanelLayout;
        if (panelFrameLayout != null) {
            if (panelFrameLayout.getLayoutParams().height == 0) {
                this.mState = 1;
                return;
            }
            com.tencent.mvi.log.b bVar = this.mLogger;
            if (bVar != null) {
                bVar.i("PanelContainerLayoutWrapper", "hidePanelAnimatedly | mState=" + this.mState + ", initialHeight=" + initialHeight);
            }
            E(initialHeight, "hidePanelAnimatedly");
            ValueAnimator v3 = v(initialHeight, 0, 0, new c());
            this.mValueAnimator = v3;
            Intrinsics.checkNotNull(v3);
            v3.start();
            this.mState = 5;
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
        throw null;
    }

    private final void K(int panelId, boolean needAnim, int keyboardFutureHeight, boolean needRemoveCurrentPanelView) {
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerLayoutWrapper", "hidePanel panelId=" + panelId + " mCurPanelId=" + this.mCurPanelId + " anim=" + needAnim + " mState=" + this.mState + ", needRemoveView=" + needRemoveCurrentPanelView);
        }
        int i3 = this.mCurPanelId;
        if (panelId == i3 && i3 != -1) {
            this.mCurPanelId = -1;
            O(needAnim, keyboardFutureHeight, needRemoveCurrentPanelView);
            this.mWrapperConnApi.e(false, panelId);
        }
    }

    static /* synthetic */ void L(PanelContainerLayoutWrapper panelContainerLayoutWrapper, int i3, boolean z16, int i16, boolean z17, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        if ((i17 & 8) != 0) {
            z17 = false;
        }
        panelContainerLayoutWrapper.K(i3, z16, i16, z17);
    }

    private final int M(float density, Configuration configuration) {
        int coerceAtLeast;
        int a16 = com.tencent.input.base.panelcontainer.keyboard.e.f116886a.a(this.mWrapperConnApi.b(), configuration.orientation);
        int i3 = (int) (density * FilterEnum.MIC_PTU_TRANS_XINXIAN);
        int i16 = configuration.screenHeightDp;
        int i17 = this.mScreenHeightDp;
        if (i16 != i17 && i17 > 0) {
            a16 = i3;
        }
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerLayoutWrapper", "initNormalPanelHeight panelHeight = " + a16 + " defaultPanelHeight = " + i3);
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(a16, i3);
        return coerceAtLeast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float N(float f16) {
        return (float) ((Math.cos((f16 + 1) * 3.141592653589793d) / 2.0f) + 0.5f);
    }

    private final void O(boolean needAnim, int keyboardFutureHeight, boolean needRemoveCurrentPanelView) {
        int i3 = this.mState;
        if (i3 != 2) {
            if (i3 != 6) {
                I(needAnim, keyboardFutureHeight, needRemoveCurrentPanelView);
                return;
            } else {
                this.mState = 1;
                x();
                return;
            }
        }
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.e("PanelContainerLayoutWrapper", "mState is Keyboard, but mCurPanelId is still valid");
        }
    }

    private final void P(final boolean needAnim, final int delayTime) {
        final int z16 = z(this, 0, 1, null);
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerLayoutWrapper", "moveStateWhenShowPanel targetHeight=" + z16 + ", mState=" + this.mState);
        }
        if (this.mState == 2) {
            this.mState = 6;
            ValueAnimator valueAnimator = this.mValueAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            E(0, "moveStateWhenShowPanel");
            this.mOnKeyboardHideHandler = new Function0<Unit>(needAnim, z16, delayTime) { // from class: com.tencent.input.base.panelcontainer.PanelContainerLayoutWrapper$moveStateWhenShowPanel$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $delayTime;
                final /* synthetic */ boolean $needAnim;
                final /* synthetic */ int $targetHeight;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$needAnim = needAnim;
                    this.$targetHeight = z16;
                    this.$delayTime = delayTime;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, PanelContainerLayoutWrapper.this, Boolean.valueOf(needAnim), Integer.valueOf(z16), Integer.valueOf(delayTime));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        PanelContainerLayoutWrapper.this.T(this.$needAnim, this.$targetHeight, true, this.$delayTime);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            };
            return;
        }
        T(needAnim, z16, false, delayTime);
    }

    private final void Q(ViewTreeObserver viewTreeObserver, int addCounter, int removeCounter, String invokeTag) {
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("debug[");
            sb5.append(invokeTag);
            sb5.append("], addCount=");
            sb5.append(addCounter);
            sb5.append(", removeCount=");
            sb5.append(removeCounter);
            sb5.append(" viewTreeObserver=");
            sb5.append(viewTreeObserver.hashCode());
            sb5.append(", mPanelLayout=");
            PanelFrameLayout panelFrameLayout = this.mPanelLayout;
            if (panelFrameLayout != null) {
                sb5.append(panelFrameLayout.hashCode());
                bVar.i("PanelContainerLayoutWrapper", sb5.toString());
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                throw null;
            }
        }
    }

    private final void R(int keyboardHeight) {
        int coerceAtLeast;
        Context context = this.mContext;
        if (context != null) {
            float f16 = context.getResources().getDisplayMetrics().density;
            int i3 = (int) (FilterEnum.MIC_PTU_TRANS_XINXIAN * f16);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(keyboardHeight, i3);
            if (this.mNormalPanelHeight != coerceAtLeast) {
                com.tencent.mvi.log.b bVar = this.mLogger;
                if (bVar != null) {
                    bVar.i("PanelContainerLayoutWrapper", "saveKeyboardHeight density = " + f16 + " defaultPanelHeight = " + i3 + " newHeight = " + coerceAtLeast + " mNormalPanelHeight = " + this.mNormalPanelHeight + " mOrientation = " + this.mOrientation);
                }
                this.mNormalPanelHeight = coerceAtLeast;
                com.tencent.input.base.panelcontainer.keyboard.e.f116886a.d(this.mWrapperConnApi.b(), this.mNormalPanelHeight, this.mOrientation);
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        throw null;
    }

    private final void S(View view, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            com.tencent.mvi.log.b bVar = this.mLogger;
            if (bVar != null) {
                bVar.e("PanelContainerLayoutWrapper", "view[" + view.getId() + "] param is null");
                return;
            }
            return;
        }
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(boolean needAnim, int targetHeight, boolean keyboardWillHide, int delayTime) {
        int i3;
        if (needAnim) {
            if (keyboardWillHide) {
                i3 = G();
            } else {
                PanelFrameLayout panelFrameLayout = this.mPanelLayout;
                if (panelFrameLayout != null) {
                    i3 = panelFrameLayout.getLayoutParams().height;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                    throw null;
                }
            }
            U(i3, targetHeight, delayTime);
            return;
        }
        V(targetHeight);
        this.mState = 3;
    }

    private final void U(int initialHeight, int targetHeight, int delayTime) {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        PanelFrameLayout panelFrameLayout = this.mPanelLayout;
        if (panelFrameLayout != null) {
            if (panelFrameLayout.getLayoutParams().height == targetHeight) {
                com.tencent.mvi.log.b bVar = this.mLogger;
                if (bVar != null) {
                    bVar.i("PanelContainerLayoutWrapper", Intrinsics.stringPlus("showPanelAnimatedly height == targetHeight targetHeight = ", Integer.valueOf(targetHeight)));
                }
                this.mState = 3;
                return;
            }
            com.tencent.mvi.log.b bVar2 = this.mLogger;
            if (bVar2 != null) {
                bVar2.i("PanelContainerLayoutWrapper", "showPanelAnimatedly | mState=" + this.mState + ", initialHeight=" + initialHeight);
            }
            E(initialHeight, "showPanelAnimatedly");
            ValueAnimator v3 = v(initialHeight, targetHeight, delayTime, new d());
            this.mValueAnimator = v3;
            Intrinsics.checkNotNull(v3);
            v3.start();
            this.mState = 4;
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
        throw null;
    }

    private final void V(int targetHeight) {
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerLayoutWrapper", "showPanelDirectly | targetHeight=" + targetHeight + ", mState=" + this.mState);
        }
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        x();
        E(targetHeight, "showPanelDirectly");
    }

    private final void W(int panelId, boolean needAnim, int delayTime) {
        View a16 = this.mWrapperConnApi.a(panelId);
        if (!Intrinsics.areEqual(this.mCurPanelView, a16)) {
            C(this, false, 1, null);
            PanelFrameLayout panelFrameLayout = this.mPanelLayout;
            if (panelFrameLayout != null) {
                panelFrameLayout.addView(a16, new FrameLayout.LayoutParams(-1, -1));
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                throw null;
            }
        }
        S(a16, y(panelId));
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerLayoutWrapper", "showPanelInternal | mCurPanelId=" + this.mCurPanelId + " panelId=" + panelId + "mState=" + this.mState + " panelView.layoutParam.height=" + a16.getLayoutParams().height);
        }
        H("showPanelInternal");
        this.mCurPanelId = panelId;
        this.mCurPanelView = a16;
        this.mWrapperConnApi.e(true, panelId);
        P(needAnim, delayTime);
    }

    private final void X() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        boolean z16 = false;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            z16 = true;
        }
        if (z16) {
            ValueAnimator valueAnimator2 = this.mValueAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.end();
            }
            this.mValueAnimator = null;
            com.tencent.mvi.log.b bVar = this.mLogger;
            if (bVar != null) {
                bVar.i("PanelContainerLayoutWrapper", "stopAnimationInAdvance");
            }
        }
    }

    private final void Y(Configuration newConfig) {
        this.mOrientation = newConfig.orientation;
        this.mScreenWidthDp = newConfig.screenWidthDp;
        this.mScreenHeightDp = newConfig.screenHeightDp;
    }

    private final ValueAnimator v(int initialHeight, int targetHeight, int delayTime, Animator.AnimatorListener listener) {
        int coerceAtLeast;
        final int coerceAtLeast2;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(targetHeight, 0);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(initialHeight, 0);
        final int i3 = coerceAtLeast - coerceAtLeast2;
        PanelFrameLayout panelFrameLayout = this.mPanelLayout;
        if (panelFrameLayout != null) {
            DelayStartValueAnimator delayStartValueAnimator = new DelayStartValueAnimator(panelFrameLayout, this.mLogger, delayTime);
            float[] fArr = this.mAnimationKeyframeFractions;
            delayStartValueAnimator.setFloatValues(Arrays.copyOf(fArr, fArr.length));
            delayStartValueAnimator.setDuration(150L);
            delayStartValueAnimator.setInterpolator(this.mInterpolator);
            delayStartValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.input.base.panelcontainer.f
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PanelContainerLayoutWrapper.w(PanelContainerLayoutWrapper.this, coerceAtLeast2, i3, valueAnimator);
                }
            });
            delayStartValueAnimator.addListener(listener);
            return delayStartValueAnimator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(PanelContainerLayoutWrapper this$0, int i3, int i16, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float f16 = i3;
        float f17 = i16;
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            this$0.E((int) (f16 + (f17 * ((Float) animatedValue).floatValue())), "animatePanel");
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final void x() {
        this.mOnKeyboardHideHandler = null;
    }

    private final int y(int panelId) {
        Integer F = F(panelId);
        if (F == null) {
            return G();
        }
        return F.intValue();
    }

    static /* synthetic */ int z(PanelContainerLayoutWrapper panelContainerLayoutWrapper, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = panelContainerLayoutWrapper.mCurPanelId;
        }
        return panelContainerLayoutWrapper.y(i3);
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public void a() {
        boolean isInMultiWindowMode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerLayoutWrapper", "bindViewAndData");
        }
        Context context = this.mContext;
        if (context != null) {
            Configuration configuration = context.getResources().getConfiguration();
            Context context2 = this.mContext;
            if (context2 != null) {
                float f16 = context2.getResources().getDisplayMetrics().density;
                Intrinsics.checkNotNullExpressionValue(configuration, "configuration");
                this.mNormalPanelHeight = M(f16, configuration);
                Y(configuration);
                this.mMultiWindowPanelHeight = (int) (f16 * 204);
                if (Build.VERSION.SDK_INT >= 24) {
                    Context context3 = this.mContext;
                    if (context3 != null) {
                        if (context3 instanceof Activity) {
                            if (context3 != null) {
                                isInMultiWindowMode = ((Activity) context3).isInMultiWindowMode();
                                this.mIsInMultiWindowMode = isInMultiWindowMode;
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                throw null;
                            }
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        throw null;
                    }
                }
                this.mGlobalLayoutListener = new b(new WeakReference(this));
                PanelFrameLayout panelFrameLayout = this.mPanelLayout;
                if (panelFrameLayout != null) {
                    ViewTreeObserver viewTreeObserver = panelFrameLayout.getViewTreeObserver();
                    b bVar2 = this.mGlobalLayoutListener;
                    if (bVar2 != null) {
                        viewTreeObserver.addOnGlobalLayoutListener(bVar2);
                        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "viewTreeObserver");
                        int i3 = f116779u + 1;
                        f116779u = i3;
                        Q(viewTreeObserver, i3, f116780v, "bindViewAndData");
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("mGlobalLayoutListener");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mPanelLayout");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        throw null;
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return z(this, 0, 1, null);
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mCurPanelHeight;
    }

    @Override // com.tencent.input.base.panelcontainer.e
    @NotNull
    public View d(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull com.tencent.mvi.runtime.strategy.b strategyService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams, (Object) strategyService);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Intrinsics.checkNotNullParameter(strategyService, "strategyService");
        this.mLogger = (com.tencent.mvi.log.b) strategyService.b(com.tencent.mvi.log.b.class);
        this.mContext = createViewParams.a();
        PanelFrameLayout panelFrameLayout = new PanelFrameLayout(createViewParams.a());
        panelFrameLayout.setId(R.id.f2225038);
        Unit unit = Unit.INSTANCE;
        this.mPanelLayout = panelFrameLayout;
        return panelFrameLayout;
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public void e(@NotNull String source, boolean needAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, source, Boolean.valueOf(needAnim));
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        j(needAnim);
        H(Intrinsics.stringPlus("hideAllPanelAndKeyboard source = ", source));
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public void f(boolean isShowKeyboard, int keyboardHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(isShowKeyboard), Integer.valueOf(keyboardHeight));
            return;
        }
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerLayoutWrapper", "onKeyboardShowStateChanged| isShowKeyboard=" + isShowKeyboard + " keyboardHeight=" + keyboardHeight + " mState=" + this.mState + " mCurPanelId=" + this.mCurPanelId);
        }
        if (isShowKeyboard) {
            K(this.mCurPanelId, true, keyboardHeight, true);
            this.mState = 2;
            R(keyboardHeight);
            return;
        }
        Function0<Unit> function0 = this.mOnKeyboardHideHandler;
        if (function0 != null) {
            Intrinsics.checkNotNull(function0);
            function0.invoke();
            this.mOnKeyboardHideHandler = null;
        } else if (this.mState == 2) {
            this.mState = 1;
        }
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public void g(int panelId, boolean needAnim, int delayTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(panelId), Boolean.valueOf(needAnim), Integer.valueOf(delayTime));
            return;
        }
        if (panelId == -1) {
            com.tencent.mvi.log.b bVar = this.mLogger;
            if (bVar != null) {
                bVar.e("PanelContainerLayoutWrapper", "show panel uses invalid panel id!");
                return;
            }
            return;
        }
        W(panelId, needAnim, delayTime);
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public void h(int panelId, boolean needAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(panelId), Boolean.valueOf(needAnim));
        } else {
            L(this, panelId, needAnim, 0, false, 12, null);
        }
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mCurPanelId;
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public void j(boolean needAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, needAnim);
        } else {
            L(this, this.mCurPanelId, needAnim, 0, false, 12, null);
        }
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public void k(int heightOffset, boolean needInfluenceCurPanel) {
        int coerceAtLeast;
        com.tencent.mvi.log.b bVar;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(heightOffset), Boolean.valueOf(needInfluenceCurPanel));
            return;
        }
        X();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(D(heightOffset), 0);
        if (needInfluenceCurPanel && this.mState == 3 && this.mCurPanelId != -1 && (view = this.mCurPanelView) != null) {
            S(view, coerceAtLeast);
        }
        if (heightOffset == 0 && (bVar = this.mLogger) != null) {
            bVar.i("PanelContainerLayoutWrapper", "needInfluenceCurPanel = " + needInfluenceCurPanel + " mState = " + this.mState + " mCurPanelId = " + this.mCurPanelId + " panelHeightWithOffset = " + coerceAtLeast);
        }
        E(coerceAtLeast, "handlePanelPlusHeightUIState");
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (newConfig.screenWidthDp != this.mScreenWidthDp || newConfig.screenHeightDp != this.mScreenHeightDp || newConfig.orientation != this.mOrientation) {
            com.tencent.mvi.log.b bVar = this.mLogger;
            if (bVar != null) {
                bVar.i("PanelContainerLayoutWrapper", "onConfigurationChanged screenWidthDp = " + newConfig.screenWidthDp + " screenHeightDp = " + newConfig.screenHeightDp + " orientation = " + newConfig.orientation);
            }
            Context context = this.mContext;
            if (context != null) {
                this.mNormalPanelHeight = M(context.getResources().getDisplayMetrics().density, newConfig);
                Y(newConfig);
                e("onConfigurationChanged", false);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            throw null;
        }
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        com.tencent.mvi.log.b bVar = this.mLogger;
        if (bVar != null) {
            bVar.i("PanelContainerLayoutWrapper", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        C(this, false, 1, null);
        A();
    }

    @Override // com.tencent.input.base.panelcontainer.e
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isInMultiWindowMode);
            return;
        }
        if (this.mIsInMultiWindowMode != isInMultiWindowMode) {
            com.tencent.mvi.log.b bVar = this.mLogger;
            if (bVar != null) {
                bVar.i("PanelContainerLayoutWrapper", Intrinsics.stringPlus("onMultiWindowModeChanged mIsInMultiWindowMode = ", Boolean.valueOf(isInMultiWindowMode)));
            }
            this.mIsInMultiWindowMode = isInMultiWindowMode;
            e("onMultiWindowModeChanged", false);
        }
    }
}
