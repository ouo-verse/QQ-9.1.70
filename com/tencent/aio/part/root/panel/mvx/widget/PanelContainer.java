package com.tencent.aio.part.root.panel.mvx.widget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u008a\u00012\u00020\u0001:\u0002\u008b\u0001B\u0013\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u0001\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0087\u0001B(\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u0001\u0012\u0007\u0010\u0088\u0001\u001a\u00020\u0007\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0089\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J8\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J3\u0010#\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00072!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020!0\u001eH\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J#\u0010(\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\fH\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0002J\u001c\u00100\u001a\u00020\u00042\u0014\u0010/\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00040\u001eJ$\u00102\u001a\u00020\u00042\u001c\u0010/\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000401J\u0010\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u000103J\u0018\u00108\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0014J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u000209H\u0014J0\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J\u000e\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\fJ\u0010\u0010A\u001a\u00020\f2\b\b\u0002\u0010@\u001a\u00020\fJ\u0006\u0010B\u001a\u00020\u0004J\u0010\u0010C\u001a\u00020\u00042\b\b\u0002\u0010@\u001a\u00020\fJ\u000e\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\fJ\u0006\u0010F\u001a\u00020\u0004J\u0006\u0010G\u001a\u00020\u0004J;\u0010H\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010@\u001a\u00020\f2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020!0\u001eJ\u0010\u0010I\u001a\u00020\u00042\b\b\u0002\u0010@\u001a\u00020\fJ#\u0010K\u001a\u00020\u00042\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010@\u001a\u00020\f\u00a2\u0006\u0004\bK\u0010LJ\u0006\u0010M\u001a\u00020\u0004R\"\u0010S\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010V\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010N\u001a\u0004\bT\u0010P\"\u0004\bU\u0010RR\"\u0010Y\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010N\u001a\u0004\bW\u0010P\"\u0004\bX\u0010RR\u0016\u0010Z\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010NR\u0016\u0010[\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010NR\u0016\u0010\\\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010NR\u0016\u0010]\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010NR\u0016\u0010^\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010NR\u0016\u0010a\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010`R\u0018\u0010f\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010i\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010j\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010NR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010p\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010`R\u0016\u0010r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010`R&\u0010u\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR.\u0010x\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010{\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR%\u0010\u0082\u0001\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001\u00a8\u0006\u008c\u0001"}, d2 = {"Lcom/tencent/aio/part/root/panel/mvx/widget/PanelContainer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", DomainData.DOMAIN_NAME, "o", "", h.F, "i", "e", "normalPanelHeight", "", "d", "height", "change", "g", "keyboardHeight", "isFlow", "v", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "panelViewHeight", "panelShowHeight", "left", "top", "right", "bottom", HippyTKDListViewAdapter.X, "panelId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Landroid/view/View;", "fetcher", "c", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "hidePanel", "showPanel", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "isShowKeyboard", "r", "", "msg", "p", "action", "setKeyBoardStatusObserver", "Lkotlin/Function2;", "setPanelStatusObserver", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "listener", "setPanelAnimUpdateListener", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "changed", "onLayout", "isInMultiWindowMode", "w", "needAnim", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "ignoreKeyboardEvent", "setIgnoreKeyboardEvent", "B", BdhLogUtil.LogTag.Tag_Conn, "D", "y", "expandPanelHeight", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Integer;Z)V", "t", "I", "getOrientation", "()I", "setOrientation", "(I)V", "orientation", "getScreenWidthDp", "setScreenWidthDp", "screenWidthDp", "getScreenHeightDp", "setScreenHeightDp", "screenHeightDp", "mKeyboardHeight", "mNormalPanelHeight", "mNormalPanelHeightInMultiWindow", "mExpandPanelHeight", "mPanelContainerInitHeight", "E", "Z", "mIsKeyboardShow", UserInfo.SEX_FEMALE, "mIsFloatingKeyboardShow", "G", "Landroid/view/View;", "mCurrPanelView", "H", "Ljava/lang/Integer;", "mCurrPanelId", "mStatus", "Lcom/tencent/aio/part/root/panel/mvx/widget/a;", "J", "Lcom/tencent/aio/part/root/panel/mvx/widget/a;", "mChangeIntent", "K", "mIsMultiWindowMode", "L", "mIgnoreKeyboardEvent", "M", "Lkotlin/jvm/functions/Function1;", "keyBoardStatusObserver", "N", "Lkotlin/jvm/functions/Function2;", "panelStatusObserver", "P", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "animUpdateListener", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "getPreLog", "()Ljava/lang/String;", "setPreLog", "(Ljava/lang/String;)V", "preLog", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Req, "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class PanelContainer extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int mExpandPanelHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private int mPanelContainerInitHeight;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsKeyboardShow;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsFloatingKeyboardShow;

    /* renamed from: G, reason: from kotlin metadata */
    private View mCurrPanelView;

    /* renamed from: H, reason: from kotlin metadata */
    private Integer mCurrPanelId;

    /* renamed from: I, reason: from kotlin metadata */
    private int mStatus;

    /* renamed from: J, reason: from kotlin metadata */
    private a mChangeIntent;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mIsMultiWindowMode;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIgnoreKeyboardEvent;

    /* renamed from: M, reason: from kotlin metadata */
    private Function1<? super Boolean, Unit> keyBoardStatusObserver;

    /* renamed from: N, reason: from kotlin metadata */
    private Function2<? super Integer, ? super Integer, Unit> panelStatusObserver;

    /* renamed from: P, reason: from kotlin metadata */
    private ValueAnimator.AnimatorUpdateListener animUpdateListener;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private String preLog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int orientation;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int screenWidthDp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int screenHeightDp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mKeyboardHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mNormalPanelHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mNormalPanelHeightInMultiWindow;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/aio/part/root/panel/mvx/widget/PanelContainer$a;", "", "", "ANIM_DURATION", "J", "", "DEFAULT_PANEL_HEIGHT", "I", "DEFAULT_PANEL_HEIGHT_IN_MULTI_WINDOW", "", "SP_KEY_KEYBOARD_HEIGHT", "Ljava/lang/String;", "STATE_EXPAND_PANEL", "STATE_KEYBOARD", "STATE_NONE", "STATE_NORMAL_PANEL", "TAG", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.mvx.widget.PanelContainer$a, reason: from kotlin metadata */
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) PanelContainer.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                a aVar = PanelContainer.this.mChangeIntent;
                Intrinsics.checkNotNullExpressionValue(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue != null) {
                    aVar.i(((Float) animatedValue).floatValue());
                    PanelContainer.this.requestLayout();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) PanelContainer.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                a aVar = PanelContainer.this.mChangeIntent;
                Intrinsics.checkNotNullExpressionValue(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue != null) {
                    aVar.h(((Float) animatedValue).floatValue());
                    PanelContainer.this.requestLayout();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) PanelContainer.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                a aVar = PanelContainer.this.mChangeIntent;
                Intrinsics.checkNotNullExpressionValue(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue != null) {
                    aVar.j(((Float) animatedValue).floatValue());
                    PanelContainer.this.requestLayout();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) PanelContainer.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                a aVar = PanelContainer.this.mChangeIntent;
                Intrinsics.checkNotNullExpressionValue(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue != null) {
                    aVar.k(((Float) animatedValue).floatValue());
                    PanelContainer.this.requestLayout();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) PanelContainer.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                a aVar = PanelContainer.this.mChangeIntent;
                Intrinsics.checkNotNullExpressionValue(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue != null) {
                    aVar.l(((Float) animatedValue).floatValue());
                    ValueAnimator.AnimatorUpdateListener animatorUpdateListener = PanelContainer.this.animUpdateListener;
                    if (animatorUpdateListener != null) {
                        animatorUpdateListener.onAnimationUpdate(animation);
                    }
                    PanelContainer.this.requestLayout();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animation);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53454);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) context);
            return;
        }
        this.orientation = -1;
        this.screenWidthDp = -1;
        this.screenHeightDp = -1;
        this.mPanelContainerInitHeight = -1;
        this.mStatus = 1;
        this.mChangeIntent = new a(1, 0, 2, null);
        this.preLog = "";
        n(context);
    }

    private final boolean c(int panelId, Function1<? super Integer, ? extends View> fetcher) {
        Integer num;
        View invoke = fetcher.invoke(Integer.valueOf(panelId));
        Integer num2 = this.mCurrPanelId;
        if (num2 != null && (num2 == null || num2.intValue() != panelId)) {
            num = this.mCurrPanelId;
        } else {
            num = null;
        }
        Integer valueOf = Integer.valueOf(panelId);
        this.mCurrPanelId = valueOf;
        s(num, valueOf);
        if (!Intrinsics.areEqual(this.mCurrPanelView, invoke)) {
            View view = this.mCurrPanelView;
            if (view != null) {
                removeView(view);
            }
            this.mCurrPanelView = invoke;
            addView(invoke, new FrameLayout.LayoutParams(-1, 0));
        }
        return true;
    }

    private final boolean d(int normalPanelHeight) {
        int i3 = this.mStatus;
        if ((i3 == 3 || i3 == 4) && this.mCurrPanelView != null && !this.mIsMultiWindowMode && normalPanelHeight < this.mExpandPanelHeight) {
            return true;
        }
        return false;
    }

    private final void e() {
        WindowManager.LayoutParams attributes;
        if (getContext() instanceof Activity) {
            Context context = getContext();
            if (context != null) {
                Window window = ((Activity) context).getWindow();
                if (window != null && (attributes = window.getAttributes()) != null) {
                    int i3 = attributes.softInputMode;
                    if ((i3 & 255) != 18) {
                        int i16 = i3 & (-256);
                        Context context2 = getContext();
                        if (context2 != null) {
                            ((Activity) context2).getWindow().setSoftInputMode(i16 | 18);
                            requestLayout();
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                    }
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
    }

    private final void f() {
        boolean isInMultiWindowMode;
        if (Build.VERSION.SDK_INT >= 24 && (getContext() instanceof Activity)) {
            Context context = getContext();
            if (context != null) {
                isInMultiWindowMode = ((Activity) context).isInMultiWindowMode();
                this.mIsMultiWindowMode = isInMultiWindowMode;
                com.tencent.aio.base.log.a.f69187b.i("PanelContainer", "checkIsMultiWindowModel ,mode=" + this.mIsMultiWindowMode);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
    }

    private final void g(int height, boolean change) {
        boolean z16;
        boolean z17;
        WindowInsetsCompat rootWindowInsets;
        if (height == 0) {
            return;
        }
        int i3 = this.mPanelContainerInitHeight;
        if (i3 <= 0) {
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            Configuration configuration = resources.getConfiguration();
            this.orientation = configuration.orientation;
            this.screenWidthDp = configuration.screenWidthDp;
            this.screenHeightDp = configuration.screenHeightDp;
            this.mPanelContainerInitHeight = height;
        } else if (height > i3) {
            this.mPanelContainerInitHeight = height;
        }
        if (this.mIgnoreKeyboardEvent) {
            return;
        }
        int i16 = this.mPanelContainerInitHeight;
        boolean z18 = true;
        if (i16 > height && i16 - height > i16 * 0.2f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && i16 - height > 0 && (rootWindowInsets = ViewCompat.getRootWindowInsets(this)) != null) {
            z17 = rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime());
        } else {
            z17 = false;
        }
        if (z16 == this.mIsKeyboardShow && this.mIsFloatingKeyboardShow == z17) {
            z18 = false;
        }
        this.mIsKeyboardShow = z16;
        this.mIsFloatingKeyboardShow = z17;
        if (z18) {
            if (!z16 && !z17) {
                u();
            } else {
                v(this.mPanelContainerInitHeight - height, z17);
            }
        }
    }

    private final int h() {
        return 250;
    }

    private final int i() {
        return 190;
    }

    public static /* synthetic */ void k(PanelContainer panelContainer, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        panelContainer.j(z16);
    }

    private final void n(Context context) {
        o(context);
    }

    private final void o(Context context) {
        if (this.mKeyboardHeight == 0) {
            this.mKeyboardHeight = com.tencent.aio.base.sp.a.f69207a.a(context, "sp_key_keyboard_height", 0);
        }
        this.mNormalPanelHeight = this.mKeyboardHeight;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        float f16 = resources.getDisplayMetrics().density;
        if (this.mNormalPanelHeight == 0) {
            this.mNormalPanelHeight = (int) (h() * f16);
        }
        this.mNormalPanelHeightInMultiWindow = (int) (i() * f16);
        int i3 = (int) (r4.heightPixels * 0.6f);
        this.mExpandPanelHeight = i3;
        int i16 = this.mNormalPanelHeight;
        if (i3 < i16) {
            this.mExpandPanelHeight = i16;
        }
    }

    private final void p(String msg2) {
        if (Intrinsics.areEqual(this.preLog, msg2)) {
            return;
        }
        this.preLog = msg2;
        com.tencent.aio.base.log.a.f69187b.i("PanelContainer", msg2);
    }

    private final void q() {
        com.tencent.aio.base.log.a.f69187b.i("PanelContainer", "notifyHideAllPanel");
        Function2<? super Integer, ? super Integer, Unit> function2 = this.panelStatusObserver;
        if (function2 != null) {
            function2.invoke(null, null);
        }
    }

    private final void r(boolean isShowKeyboard) {
        com.tencent.aio.base.log.a.f69187b.i("PanelContainer", "notifyKeyboardChanged isShowKeyboard=" + isShowKeyboard);
        Function1<? super Boolean, Unit> function1 = this.keyBoardStatusObserver;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(isShowKeyboard));
        }
    }

    private final void s(Integer hidePanel, Integer showPanel) {
        com.tencent.aio.base.log.a.f69187b.i("PanelContainer", "notifyPanelChanged hidePanel=" + hidePanel + ",showPanel=" + showPanel);
        Function2<? super Integer, ? super Integer, Unit> function2 = this.panelStatusObserver;
        if (function2 != null) {
            function2.invoke(showPanel, hidePanel);
        }
    }

    private final void u() {
        if (this.mStatus == 2) {
            this.mStatus = 1;
        }
        if (this.mChangeIntent.g() == 2) {
            this.mChangeIntent = new a(1, 0, 2, null);
        }
        r(false);
    }

    private final void v(int keyboardHeight, boolean isFlow) {
        this.mChangeIntent = new a(2, 0, 2, null);
        if (!isFlow) {
            z(keyboardHeight);
        }
        com.tencent.aio.base.log.a.f69187b.i("PanelContainer", "onKeyboardShow: " + keyboardHeight + ", isFlowingKeyboard: " + isFlow);
        r(true);
        q();
    }

    private final void x(int panelViewHeight, int panelShowHeight, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        int i3 = right - left;
        childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec((bottom - top) - panelShowHeight, 1073741824));
        int i16 = bottom - panelShowHeight;
        childAt.layout(left, top, right, i16);
        View view = this.mCurrPanelView;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(panelViewHeight, 1073741824));
        }
        View view2 = this.mCurrPanelView;
        if (view2 != null) {
            view2.layout(left, i16, right, bottom + (panelViewHeight - panelShowHeight));
        }
    }

    private final void z(int keyboardHeight) {
        if (this.mKeyboardHeight != keyboardHeight && !this.mIsMultiWindowMode) {
            com.tencent.aio.base.log.a.f69187b.i("PanelContainer", "saveKeyboardHeight " + keyboardHeight);
            this.mKeyboardHeight = keyboardHeight;
            com.tencent.aio.base.sp.a aVar = com.tencent.aio.base.sp.a.f69207a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            aVar.b(context, "sp_key_keyboard_height", keyboardHeight, true);
        }
        int i3 = this.mNormalPanelHeight;
        int i16 = this.mKeyboardHeight;
        if (i3 != i16) {
            this.mNormalPanelHeight = i16;
        }
    }

    public final void A(@Nullable Integer expandPanelHeight, boolean needAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, expandPanelHeight, Boolean.valueOf(needAnim));
            return;
        }
        if (this.mStatus != 3) {
            return;
        }
        if (expandPanelHeight != null) {
            this.mExpandPanelHeight = expandPanelHeight.intValue();
        }
        f();
        if (needAnim) {
            this.mChangeIntent = new a(4, 5);
            ValueAnimator openAnim = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mChangeIntent.k(0.0f);
            Intrinsics.checkNotNullExpressionValue(openAnim, "openAnim");
            openAnim.setDuration(150L);
            openAnim.addUpdateListener(new e());
            openAnim.start();
            return;
        }
        this.mChangeIntent = new a(4, 0, 2, null);
        requestLayout();
    }

    public final void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.i("PanelContainer", "showKeyboard");
        this.mChangeIntent = new a(2, 0, 2, null);
        this.mCurrPanelId = null;
    }

    public final void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (this.mStatus == 1) {
            B();
        }
    }

    public final void D(int panelId, boolean needAnim, @NotNull Function1<? super Integer, ? extends View> fetcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(panelId), Boolean.valueOf(needAnim), fetcher);
            return;
        }
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        if (!c(panelId, fetcher)) {
            return;
        }
        m();
        f();
        if (needAnim && this.mStatus == 1) {
            this.mChangeIntent = new a(3, 4);
            ValueAnimator openAnim = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mChangeIntent.l(0.0f);
            Intrinsics.checkNotNullExpressionValue(openAnim, "openAnim");
            openAnim.setDuration(150L);
            openAnim.addUpdateListener(new f());
            openAnim.start();
            return;
        }
        this.mChangeIntent = new a(3, 0, 2, null);
        requestLayout();
    }

    public final void j(boolean needAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, needAnim);
            return;
        }
        this.mChangeIntent = new a(1, 0, 2, null);
        if (needAnim && this.mStatus == 3) {
            this.mChangeIntent = new a(1, 2);
            ValueAnimator hideAnim = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.mChangeIntent.i(1.0f);
            Intrinsics.checkNotNullExpressionValue(hideAnim, "hideAnim");
            hideAnim.setDuration(150L);
            hideAnim.addUpdateListener(new b());
            hideAnim.start();
        } else if (needAnim && this.mStatus == 4) {
            this.mChangeIntent = new a(1, 3);
            ValueAnimator hideAnim2 = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.mChangeIntent.h(1.0f);
            Intrinsics.checkNotNullExpressionValue(hideAnim2, "hideAnim");
            hideAnim2.setDuration(150L);
            hideAnim2.addUpdateListener(new c());
            hideAnim2.start();
        } else {
            this.mChangeIntent = new a(1, 0, 2, null);
            requestLayout();
        }
        q();
    }

    public final boolean l(boolean needAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, needAnim)).booleanValue();
        }
        if (this.mStatus == 1) {
            return false;
        }
        m();
        j(needAnim);
        return true;
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 0);
            r(false);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (this.screenWidthDp == newConfig.screenWidthDp && this.screenHeightDp == newConfig.screenHeightDp) {
            if (newConfig.orientation != this.orientation) {
                this.orientation = -1;
                this.mPanelContainerInitHeight = -1;
                k(this, false, 1, null);
                return;
            }
            return;
        }
        this.orientation = -1;
        this.screenWidthDp = -1;
        this.screenHeightDp = -1;
        this.mPanelContainerInitHeight = -1;
        k(this, false, 1, null);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        e();
        int paddingRight = (right - left) - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i3 = bottom - top;
        int paddingBottom = i3 - getPaddingBottom();
        int paddingTop = getPaddingTop();
        g(i3, changed);
        int g16 = this.mChangeIntent.g();
        int a16 = this.mIsMultiWindowMode ? 1 : this.mChangeIntent.a();
        int i16 = this.mIsMultiWindowMode ? this.mNormalPanelHeightInMultiWindow : this.mNormalPanelHeight;
        p("onLayout this=" + hashCode() + ",changed=" + changed + ",left=" + left + ",top=" + top + ",right=" + right + ",bottom=" + bottom + ",initHeight=" + this.mPanelContainerInitHeight + ",isKeyboardShow=" + this.mIsKeyboardShow + ",isFlowKeyboardShow=" + this.mIsFloatingKeyboardShow + ",height=" + i3 + ",keyboardHeight=" + this.mKeyboardHeight + ",mIsMultiScreen=" + this.mIsMultiWindowMode + ",pendingStatus=" + g16 + ",animType=" + a16 + ",normalPanelHeight=" + i16);
        if (g16 == 1) {
            if (a16 == 2) {
                x(i16, (int) (i16 * this.mChangeIntent.c()), paddingLeft, paddingTop, paddingRight, paddingBottom);
            } else if (a16 != 3) {
                x(0, 0, paddingLeft, paddingTop, paddingRight, paddingBottom);
            } else {
                x(this.mExpandPanelHeight, (int) (this.mExpandPanelHeight * this.mChangeIntent.b()), paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            this.mStatus = 1;
            return;
        }
        if (g16 == 2) {
            x(i16, 0, paddingLeft, paddingTop, paddingRight, paddingBottom);
            this.mStatus = 2;
            Function2<? super Integer, ? super Integer, Unit> function2 = this.panelStatusObserver;
            if (function2 != null) {
                function2.invoke(null, this.mCurrPanelId);
                return;
            }
            return;
        }
        if (g16 == 3 && (!this.mIsKeyboardShow || changed)) {
            if (a16 == 4) {
                x(i16, (int) (i16 * this.mChangeIntent.f()), paddingLeft, paddingTop, paddingRight, paddingBottom);
            } else if (a16 != 6) {
                x(i16, i16, paddingLeft, paddingTop, paddingRight, paddingBottom);
            } else {
                int d16 = (int) (i16 + ((this.mExpandPanelHeight - i16) * this.mChangeIntent.d()));
                x(d16, d16, paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            this.mStatus = 3;
            return;
        }
        if (g16 == 4 && d(i16)) {
            x(this.mExpandPanelHeight, a16 == 5 ? i16 + ((int) ((r0 - i16) * this.mChangeIntent.e())) : this.mExpandPanelHeight, paddingLeft, paddingTop, paddingRight, paddingBottom);
            this.mStatus = 4;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
        } else {
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), View.getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
        }
    }

    public final void setIgnoreKeyboardEvent(boolean ignoreKeyboardEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, ignoreKeyboardEvent);
        } else {
            this.mIgnoreKeyboardEvent = ignoreKeyboardEvent;
        }
    }

    public final void setKeyBoardStatusObserver(@NotNull Function1<? super Boolean, Unit> action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            this.keyBoardStatusObserver = action;
        }
    }

    public final void setOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.orientation = i3;
        }
    }

    public final void setPanelAnimUpdateListener(@Nullable ValueAnimator.AnimatorUpdateListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) listener);
        } else {
            this.animUpdateListener = listener;
        }
    }

    public final void setPanelStatusObserver(@NotNull Function2<? super Integer, ? super Integer, Unit> action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            this.panelStatusObserver = action;
        }
    }

    public final void setPreLog(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.preLog = str;
        }
    }

    public final void setScreenHeightDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.screenHeightDp = i3;
        }
    }

    public final void setScreenWidthDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.screenWidthDp = i3;
        }
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        View view = this.mCurrPanelView;
        if (view != null) {
            removeView(view);
            this.mCurrPanelView = null;
        }
        l(false);
    }

    public final void w(boolean isInMultiWindowMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, isInMultiWindowMode);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.i("PanelContainer", "onMultiWindowModeChanged this=" + hashCode() + " isInMultiWindowMode=" + isInMultiWindowMode);
        this.mIsMultiWindowMode = isInMultiWindowMode;
        this.mIsKeyboardShow = false;
        this.mIsFloatingKeyboardShow = false;
        this.mPanelContainerInitHeight = -1;
        l(false);
    }

    public final void y(boolean needAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, needAnim);
            return;
        }
        if (this.mStatus != 4) {
            return;
        }
        if (needAnim) {
            this.mChangeIntent = new a(3, 6);
            ValueAnimator rollbackAnim = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.mChangeIntent.j(1.0f);
            Intrinsics.checkNotNullExpressionValue(rollbackAnim, "rollbackAnim");
            rollbackAnim.setDuration(150L);
            rollbackAnim.addUpdateListener(new d());
            rollbackAnim.start();
            return;
        }
        this.mChangeIntent = new a(3, 0, 2, null);
        requestLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.orientation = -1;
        this.screenWidthDp = -1;
        this.screenHeightDp = -1;
        this.mPanelContainerInitHeight = -1;
        this.mStatus = 1;
        this.mChangeIntent = new a(1, 0, 2, null);
        this.preLog = "";
        n(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.orientation = -1;
        this.screenWidthDp = -1;
        this.screenHeightDp = -1;
        this.mPanelContainerInitHeight = -1;
        this.mStatus = 1;
        this.mChangeIntent = new a(1, 0, 2, null);
        this.preLog = "";
        n(context);
    }
}
