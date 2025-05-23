package com.tencent.mobileqq.sharepanel.input;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.sharepanel.input.SharePanelKeyboardAnimationHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u0001V\u0018\u0000 \\2\u00020\u0001:\u0002]^B3\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0-\u00a2\u0006\u0004\bZ\u0010[J2\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J2\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\u0012\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000eJ\u001a\u0010#\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00105\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010)R\u0014\u00107\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u00102R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u00102R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001dR\u0016\u0010;\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00102R\u0016\u0010=\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\u001dR\u0016\u0010?\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010>R\u0016\u0010@\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010>R\u0016\u0010A\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010>R\u0016\u0010B\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010>R\u0016\u0010D\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010>R$\u0010J\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010F\u001a\u0004\bG\u0010H\"\u0004\b<\u0010IR$\u0010Q\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\b2\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010SR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010SR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010X\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View;", "targetView", "", "start", "end", "Lkotlin/Function0;", "", "onStart", "N", "onEnd", BdhLogUtil.LogTag.Tag_Req, "to", "", "needAnimation", "L", "y", "K", "animateContainer", "E", "target", "J", "Landroidx/core/view/WindowInsetsCompat;", "insets", BdhLogUtil.LogTag.Tag_Conn, "G", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", UserInfo.SEX_FEMALE, "iconView", "w", "show", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "v", "onApplyWindowInsets", "Landroid/widget/EditText;", "d", "Landroid/widget/EditText;", "editText", "e", "Landroid/view/View;", "panelOrKeyboardContainer", "f", "emojiPanelView", "Lkotlin/Function1;", h.F, "Lkotlin/jvm/functions/Function1;", "panelOrKeyboardContainerHeightCallback", "i", "I", "persistentInsetTypes", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "deferredInsetTypes", "emojiIconView", "emojiContainerMinHeight", "keyboardRealHeight", "", "keyboardCurrentHeight", "currentState", "H", "keyboardHeight", "Z", "isStartAnimation", "isDismiss", "isEmojiPanelShow", "isKeyboardShow", "M", "interceptWindowInsetsProcess", "Lcom/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$c;", "Lcom/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$c;", "B", "()Lcom/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$c;", "(Lcom/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$c;)V", "containerListener", "Landroid/view/View$OnClickListener;", "P", "Landroid/view/View$OnClickListener;", "getOnEmojiIconClickListener", "()Landroid/view/View$OnClickListener;", "(Landroid/view/View$OnClickListener;)V", "onEmojiIconClickListener", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "dropRunnable", "upRunnable", "com/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$f", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$f;", "windowInsetsAnimation", "<init>", "(Landroid/widget/EditText;Landroid/view/View;Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "T", "b", "c", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelKeyboardAnimationHelper implements OnApplyWindowInsetsListener {
    static IPatchRedirector $redirector_;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final boolean U;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View emojiIconView;

    /* renamed from: D, reason: from kotlin metadata */
    private final int emojiContainerMinHeight;

    /* renamed from: E, reason: from kotlin metadata */
    private int keyboardRealHeight;

    /* renamed from: F, reason: from kotlin metadata */
    private float keyboardCurrentHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private int currentState;

    /* renamed from: H, reason: from kotlin metadata */
    private float keyboardHeight;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isStartAnimation;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isDismiss;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isEmojiPanelShow;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isKeyboardShow;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean interceptWindowInsetsProcess;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private c containerListener;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener onEmojiIconClickListener;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Runnable dropRunnable;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Runnable upRunnable;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final f windowInsetsAnimation;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditText editText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View panelOrKeyboardContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View emojiPanelView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> panelOrKeyboardContainerHeightCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int persistentInsetTypes;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int deferredInsetTypes;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelKeyboardAnimationHelper.this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else {
                ViewCompat.setWindowInsetsAnimationCallback(SharePanelKeyboardAnimationHelper.this.panelOrKeyboardContainer.getRootView(), SharePanelKeyboardAnimationHelper.this.windowInsetsAnimation);
                ViewCompat.setOnApplyWindowInsetsListener(SharePanelKeyboardAnimationHelper.this.panelOrKeyboardContainer, SharePanelKeyboardAnimationHelper.this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\bR\u001d\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$b;", "", "", "useSystemWindowInsetAnimation", "Z", "a", "()Z", "getUseSystemWindowInsetAnimation$annotations", "()V", "", "KEY_KEYBOARD_HEIGHT", "Ljava/lang/String;", "", "PANEL_OR_KEYBOARD_MIN_HEIGHT", UserInfo.SEX_FEMALE, "", "STATE_COLLAPSE", "I", "STATE_EXPEND", "STATE_OVER", "TAG", "<init>", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.input.SharePanelKeyboardAnimationHelper$b, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return SharePanelKeyboardAnimationHelper.U;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$c;", "", "", "b", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface c {
        void a();

        void b();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f287331d;

        d(Function0<Unit> function0) {
            this.f287331d = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Function0<Unit> function0 = this.f287331d;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f287332d;

        e(Function0<Unit> function0) {
            this.f287332d = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Function0<Unit> function0 = this.f287332d;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/sharepanel/input/SharePanelKeyboardAnimationHelper$f", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Landroidx/core/view/WindowInsetsAnimationCompat;", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "onStart", "Landroidx/core/view/WindowInsetsCompat;", "insets", "", "runningAnimations", "onProgress", "", "onEnd", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f extends WindowInsetsAnimationCompat.Callback {
        static IPatchRedirector $redirector_;

        f() {
            super(0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelKeyboardAnimationHelper.this);
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onEnd(@NotNull WindowInsetsAnimationCompat animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onEnd(animation);
            QLog.d("SharePanelKeyboardAnimationHelper", 1, "onEnd");
            SharePanelKeyboardAnimationHelper.this.isStartAnimation = false;
            SharePanelKeyboardAnimationHelper.this.interceptWindowInsetsProcess = false;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        @NotNull
        public WindowInsetsCompat onProgress(@NotNull WindowInsetsCompat insets, @NotNull List<WindowInsetsAnimationCompat> runningAnimations) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (WindowInsetsCompat) iPatchRedirector.redirect((short) 3, (Object) this, (Object) insets, (Object) runningAnimations);
            }
            Intrinsics.checkNotNullParameter(insets, "insets");
            Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
            if (SharePanelKeyboardAnimationHelper.this.isEmojiPanelShow) {
                return insets;
            }
            if (SharePanelKeyboardAnimationHelper.this.interceptWindowInsetsProcess) {
                return insets;
            }
            if (!SharePanelKeyboardAnimationHelper.this.isStartAnimation) {
                return insets;
            }
            SharePanelKeyboardAnimationHelper.this.keyboardCurrentHeight = r5.C(insets);
            if (SharePanelKeyboardAnimationHelper.this.isKeyboardShow) {
                if (SharePanelKeyboardAnimationHelper.this.keyboardCurrentHeight > SharePanelKeyboardAnimationHelper.this.keyboardHeight) {
                    SharePanelKeyboardAnimationHelper sharePanelKeyboardAnimationHelper = SharePanelKeyboardAnimationHelper.this;
                    sharePanelKeyboardAnimationHelper.keyboardCurrentHeight = sharePanelKeyboardAnimationHelper.keyboardHeight;
                }
                if (SharePanelKeyboardAnimationHelper.this.keyboardCurrentHeight > SharePanelKeyboardAnimationHelper.this.panelOrKeyboardContainer.getHeight()) {
                    SharePanelKeyboardAnimationHelper sharePanelKeyboardAnimationHelper2 = SharePanelKeyboardAnimationHelper.this;
                    sharePanelKeyboardAnimationHelper2.J((int) sharePanelKeyboardAnimationHelper2.keyboardCurrentHeight);
                }
            } else if (SharePanelKeyboardAnimationHelper.this.keyboardCurrentHeight < SharePanelKeyboardAnimationHelper.this.panelOrKeyboardContainer.getHeight()) {
                SharePanelKeyboardAnimationHelper sharePanelKeyboardAnimationHelper3 = SharePanelKeyboardAnimationHelper.this;
                sharePanelKeyboardAnimationHelper3.J((int) sharePanelKeyboardAnimationHelper3.keyboardCurrentHeight);
            }
            return insets;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        @NotNull
        public WindowInsetsAnimationCompat.BoundsCompat onStart(@NotNull WindowInsetsAnimationCompat animation, @NotNull WindowInsetsAnimationCompat.BoundsCompat bounds) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WindowInsetsAnimationCompat.BoundsCompat) iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation, (Object) bounds);
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            if (!SharePanelKeyboardAnimationHelper.this.isKeyboardShow || ((int) SharePanelKeyboardAnimationHelper.this.keyboardHeight) != 0) {
                SharePanelKeyboardAnimationHelper.this.isStartAnimation = true;
                QLog.i("SharePanelKeyboardAnimationHelper", 1, "onStart:isDrop:" + SharePanelKeyboardAnimationHelper.this.isDismiss + ", isKeyboardShow=" + SharePanelKeyboardAnimationHelper.this.isKeyboardShow + ", isEmojiPanelShow=" + SharePanelKeyboardAnimationHelper.this.isEmojiPanelShow);
                if (SharePanelKeyboardAnimationHelper.this.isKeyboardShow) {
                    SharePanelKeyboardAnimationHelper.this.L(1, false);
                } else if (!SharePanelKeyboardAnimationHelper.this.isEmojiPanelShow) {
                    SharePanelKeyboardAnimationHelper.this.L(0, false);
                }
                WindowInsetsAnimationCompat.BoundsCompat onStart = super.onStart(animation, bounds);
                Intrinsics.checkNotNullExpressionValue(onStart, "super.onStart(animation, bounds)");
                return onStart;
            }
            WindowInsetsAnimationCompat.BoundsCompat onStart2 = super.onStart(animation, bounds);
            Intrinsics.checkNotNullExpressionValue(onStart2, "super.onStart(animation, bounds)");
            return onStart2;
        }
    }

    static {
        boolean z16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37365);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        INSTANCE = new Companion(null);
        if (Build.VERSION.SDK_INT >= 30) {
            z16 = true;
        } else {
            z16 = false;
        }
        U = z16;
    }

    public SharePanelKeyboardAnimationHelper(@NotNull EditText editText, @NotNull View panelOrKeyboardContainer, @NotNull View emojiPanelView, @NotNull Function1<? super Integer, Unit> panelOrKeyboardContainerHeightCallback) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(panelOrKeyboardContainer, "panelOrKeyboardContainer");
        Intrinsics.checkNotNullParameter(emojiPanelView, "emojiPanelView");
        Intrinsics.checkNotNullParameter(panelOrKeyboardContainerHeightCallback, "panelOrKeyboardContainerHeightCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, editText, panelOrKeyboardContainer, emojiPanelView, panelOrKeyboardContainerHeightCallback);
            return;
        }
        this.editText = editText;
        this.panelOrKeyboardContainer = panelOrKeyboardContainer;
        this.emojiPanelView = emojiPanelView;
        this.panelOrKeyboardContainerHeightCallback = panelOrKeyboardContainerHeightCallback;
        this.persistentInsetTypes = WindowInsetsCompat.Type.navigationBars();
        this.deferredInsetTypes = WindowInsetsCompat.Type.ime();
        this.emojiContainerMinHeight = ViewUtils.dpToPx(78.0f);
        this.keyboardRealHeight = A();
        panelOrKeyboardContainer.addOnAttachStateChangeListener(new a());
        this.dropRunnable = new Runnable() { // from class: com.tencent.mobileqq.sharepanel.input.c
            @Override // java.lang.Runnable
            public final void run() {
                SharePanelKeyboardAnimationHelper.z(SharePanelKeyboardAnimationHelper.this);
            }
        };
        this.upRunnable = new Runnable() { // from class: com.tencent.mobileqq.sharepanel.input.d
            @Override // java.lang.Runnable
            public final void run() {
                SharePanelKeyboardAnimationHelper.U(SharePanelKeyboardAnimationHelper.this);
            }
        };
        this.windowInsetsAnimation = new f();
    }

    private final int A() {
        return QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getInt("key_keyboard_height", ViewUtils.dpToPx(280.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int C(WindowInsetsCompat insets) {
        Insets insets2 = insets.getInsets(this.deferredInsetTypes);
        Intrinsics.checkNotNullExpressionValue(insets2, "insets.getInsets(deferredInsetTypes)");
        Insets insets3 = insets.getInsets(this.persistentInsetTypes);
        Intrinsics.checkNotNullExpressionValue(insets3, "insets.getInsets(persistentInsetTypes)");
        Insets max = Insets.max(Insets.subtract(insets2, insets3), Insets.NONE);
        Intrinsics.checkNotNullExpressionValue(max, "subtract(typesInset, oth\u2026t, Insets.NONE)\n        }");
        return max.bottom - max.top;
    }

    private final void E(boolean animateContainer) {
        if (animateContainer) {
            M(this, 0, false, 2, null);
        }
        if (this.emojiPanelView.getVisibility() == 0) {
            R(this.emojiPanelView, 0, this.emojiContainerMinHeight, new Function0<Unit>() { // from class: com.tencent.mobileqq.sharepanel.input.SharePanelKeyboardAnimationHelper$hideEmojiPanel$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelKeyboardAnimationHelper.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    View view;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        view = SharePanelKeyboardAnimationHelper.this.emojiPanelView;
                        view.setVisibility(8);
                    }
                }
            });
        } else {
            this.emojiPanelView.setVisibility(8);
        }
        this.isEmojiPanelShow = false;
        View view = this.emojiIconView;
        if (view != null) {
            view.setSelected(false);
        }
    }

    private final void G() {
        this.panelOrKeyboardContainer.removeCallbacks(this.dropRunnable);
        this.panelOrKeyboardContainer.removeCallbacks(this.upRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(int target) {
        if (QLog.isDevelopLevel()) {
            QLog.i("SharePanelKeyboardAnimationHelper", 1, "setPanelHeight target=" + target);
        }
        int i3 = this.emojiContainerMinHeight;
        if (target < i3) {
            target = i3;
        }
        View view = this.panelOrKeyboardContainer;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = target;
        view.setLayoutParams(layoutParams);
        this.panelOrKeyboardContainerHeightCallback.invoke(Integer.valueOf(target));
    }

    private final void K() {
        this.isEmojiPanelShow = true;
        View view = this.emojiIconView;
        if (view != null) {
            view.setSelected(true);
        }
        M(this, 1, false, 2, null);
        S(this, this.emojiPanelView, this.emojiContainerMinHeight, 0, null, 8, null);
        this.emojiPanelView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(int to5, boolean needAnimation) {
        c cVar;
        QLog.i("SharePanelKeyboardAnimationHelper", 1, "switchContainerStatus to=" + to5 + ", current=" + this.currentState + ", needAnimation=" + needAnimation);
        if (this.currentState == to5) {
            y();
            return;
        }
        if (needAnimation) {
            if (to5 != 0) {
                if (to5 == 1) {
                    View view = this.panelOrKeyboardContainer;
                    N(view, view.getHeight(), this.keyboardRealHeight, new Function0<Unit>() { // from class: com.tencent.mobileqq.sharepanel.input.SharePanelKeyboardAnimationHelper$switchContainerStatus$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelKeyboardAnimationHelper.this);
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
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            SharePanelKeyboardAnimationHelper.c B = SharePanelKeyboardAnimationHelper.this.B();
                            if (B != null) {
                                B.b();
                            }
                        }
                    });
                }
            } else {
                View view2 = this.panelOrKeyboardContainer;
                N(view2, view2.getHeight(), this.emojiContainerMinHeight, new Function0<Unit>() { // from class: com.tencent.mobileqq.sharepanel.input.SharePanelKeyboardAnimationHelper$switchContainerStatus$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelKeyboardAnimationHelper.this);
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
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        SharePanelKeyboardAnimationHelper.c B = SharePanelKeyboardAnimationHelper.this.B();
                        if (B != null) {
                            B.a();
                        }
                    }
                });
            }
        } else if (to5 != 0) {
            if (to5 == 1 && (cVar = this.containerListener) != null) {
                cVar.b();
            }
        } else {
            c cVar2 = this.containerListener;
            if (cVar2 != null) {
                cVar2.a();
            }
        }
        this.currentState = to5;
    }

    static /* synthetic */ void M(SharePanelKeyboardAnimationHelper sharePanelKeyboardAnimationHelper, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        sharePanelKeyboardAnimationHelper.L(i3, z16);
    }

    private final void N(final View targetView, int start, int end, Function0<Unit> onStart) {
        QLog.i("SharePanelKeyboardAnimationHelper", 1, "[switchHeightAnimation] startHeight=" + start + ", endHeight=" + end);
        if (start == end) {
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(start, end);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.sharepanel.input.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SharePanelKeyboardAnimationHelper.P(SharePanelKeyboardAnimationHelper.this, targetView, valueAnimator);
            }
        });
        ofInt.addListener(new d(onStart));
        he0.b.l(ofInt, R.anim.f154977uk);
        ofInt.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void O(SharePanelKeyboardAnimationHelper sharePanelKeyboardAnimationHelper, View view, int i3, int i16, Function0 function0, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            function0 = null;
        }
        sharePanelKeyboardAnimationHelper.N(view, i3, i16, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(SharePanelKeyboardAnimationHelper this$0, View targetView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        this$0.panelOrKeyboardContainerHeightCallback.invoke(Integer.valueOf(intValue));
        ViewGroup.LayoutParams layoutParams = targetView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = intValue;
        }
        targetView.requestLayout();
    }

    private final void R(final View targetView, int start, int end, Function0<Unit> onEnd) {
        QLog.i("SharePanelKeyboardAnimationHelper", 1, "[translateYAnimation] startHeight=" + start + ", endHeight=" + end);
        if (start == end) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(start, end);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.sharepanel.input.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SharePanelKeyboardAnimationHelper.T(targetView, valueAnimator);
            }
        });
        ofFloat.addListener(new e(onEnd));
        he0.b.l(ofFloat, R.anim.f154978ul);
        ofFloat.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void S(SharePanelKeyboardAnimationHelper sharePanelKeyboardAnimationHelper, View view, int i3, int i16, Function0 function0, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            function0 = null;
        }
        sharePanelKeyboardAnimationHelper.R(view, i3, i16, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(View targetView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        targetView.setTranslationY(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(SharePanelKeyboardAnimationHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isStartAnimation) {
            return;
        }
        float f16 = this$0.keyboardHeight;
        if (f16 <= 0.0f) {
            QLog.i("SharePanelKeyboardAnimationHelper", 1, "upRunnable cancel, keyboardCurrentY:" + this$0.keyboardCurrentHeight);
            return;
        }
        this$0.keyboardCurrentHeight = f16;
        QLog.i("SharePanelKeyboardAnimationHelper", 1, "upRunnable, keyboardCurrentY:" + f16);
        this$0.J((int) this$0.keyboardCurrentHeight);
        this$0.L(1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(SharePanelKeyboardAnimationHelper this$0, View iconView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(iconView, "$iconView");
        if (!this$0.isStartAnimation) {
            View.OnClickListener onClickListener = this$0.onEmojiIconClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(iconView);
            }
            if (iconView.isSelected()) {
                this$0.Q(true);
            } else {
                this$0.K();
                this$0.Q(false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y() {
        if (this.currentState == 1 && this.panelOrKeyboardContainer.getHeight() == this.emojiContainerMinHeight) {
            View view = this.panelOrKeyboardContainer;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.keyboardRealHeight;
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(SharePanelKeyboardAnimationHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isStartAnimation || this$0.isEmojiPanelShow) {
            return;
        }
        this$0.keyboardCurrentHeight = 0.0f;
        this$0.J((int) 0.0f);
        this$0.L(0, false);
    }

    @Nullable
    public final c B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.containerListener;
    }

    public final void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            E(this.isEmojiPanelShow);
            Q(false);
        }
    }

    public final boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!this.isKeyboardShow && !this.isEmojiPanelShow) {
            return false;
        }
        return true;
    }

    public final void H(@Nullable c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.containerListener = cVar;
        }
    }

    public final void I(@Nullable View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onClickListener);
        } else {
            this.onEmojiIconClickListener = onClickListener;
        }
    }

    public final void Q(boolean show) {
        InputMethodManager inputMethodManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, show);
            return;
        }
        EditText editText = this.editText;
        Object systemService = editText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (systemService instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) systemService;
        } else {
            inputMethodManager = null;
        }
        if (show) {
            editText.requestFocus();
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 0);
                return;
            }
            return;
        }
        editText.clearFocus();
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    @NotNull
    public WindowInsetsCompat onApplyWindowInsets(@Nullable View v3, @NotNull WindowInsetsCompat insets) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (WindowInsetsCompat) iPatchRedirector.redirect((short) 10, (Object) this, (Object) v3, (Object) insets);
        }
        Intrinsics.checkNotNullParameter(insets, "insets");
        this.keyboardHeight = C(insets);
        boolean isVisible = insets.isVisible(this.deferredInsetTypes);
        QLog.d("SharePanelKeyboardAnimationHelper", 1, "onApplyWindowInsets, keyboardHeight:" + this.keyboardHeight + ", imeVisible:" + isVisible);
        G();
        boolean z16 = isVisible ^ true;
        this.isDismiss = z16;
        if (this.isStartAnimation) {
            return insets;
        }
        if (z16) {
            if (v3 != null) {
                v3.postDelayed(this.dropRunnable, 200L);
            }
            this.isKeyboardShow = false;
        } else {
            if (!this.isKeyboardShow) {
                float f16 = this.keyboardHeight;
                if (f16 > 0.0f && (i3 = this.keyboardRealHeight) != ((int) f16)) {
                    QLog.i("SharePanelKeyboardAnimationHelper", 1, "keyboardRealHeight change, old=" + i3 + " new=" + f16);
                    this.keyboardRealHeight = (int) this.keyboardHeight;
                    QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putInt("key_keyboard_height", this.keyboardRealHeight);
                }
                if (this.panelOrKeyboardContainer.getHeight() > this.keyboardRealHeight) {
                    QLog.i("SharePanelKeyboardAnimationHelper", 1, "interceptWindowInsetsProcess");
                    this.interceptWindowInsetsProcess = true;
                    View view = this.panelOrKeyboardContainer;
                    O(this, view, view.getHeight(), this.keyboardRealHeight, null, 8, null);
                }
            }
            this.isKeyboardShow = true;
            E(false);
            if (v3 != null) {
                v3.postDelayed(this.upRunnable, 200L);
            }
        }
        return insets;
    }

    public final void w(@NotNull final View iconView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iconView);
            return;
        }
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        this.emojiIconView = iconView;
        iconView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.input.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SharePanelKeyboardAnimationHelper.x(SharePanelKeyboardAnimationHelper.this, iconView, view);
            }
        });
    }
}
