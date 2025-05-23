package com.tencent.robot.adelie.homepage.create.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.robot.adelie.homepage.create.ak;
import com.tencent.robot.adelie.homepage.create.view.AdelieLabelListView;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.robot.qqmc.RobotQQMC;
import com.tencent.widget.immersive.SystemBarTintManager;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u00012\u00020\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u0010`\u001a\u00020_\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010a\u0012\b\b\u0002\u0010c\u001a\u00020\u0003\u00a2\u0006\u0004\bd\u0010eJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J \u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0014J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0014J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0006\u0010\u0015\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003J\u0010\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u0016\u0010\u001f\u001a\u00020\t2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dJ\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\tH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0005H\u0002J\b\u0010&\u001a\u00020\tH\u0002J\b\u0010'\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020\tH\u0002J\u0012\u0010,\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u0003H\u0002J\b\u0010-\u001a\u00020\u0003H\u0002J\b\u0010.\u001a\u00020\u0003H\u0002J\u0010\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0003H\u0002R#\u00107\u001a\n 2*\u0004\u0018\u000101018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R#\u0010:\u001a\n 2*\u0004\u0018\u000101018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u00106R\u001b\u0010>\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00104\u001a\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010VR\u0016\u0010Z\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010VR\u0016\u0010\\\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010VR\u0016\u0010^\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010V\u00a8\u0006f"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieSettingEditView;", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieEditTextView;", "Lcom/tencent/robot/adelie/homepage/create/ak$b;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "title", "hint", "count", "", UserInfo.SEX_FEMALE, "", "enable", "setEditEnabled", "E", "keyboardHeightInPx", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "a", "height", "b", "v0", "setRootViewHeight", "Lcom/tencent/robot/adelie/homepage/create/view/u;", "listener", "setOnEditStateChangeListener", "Lcom/tencent/robot/adelie/homepage/create/view/v;", "controller", "setScrollController", "", "list", "setLabelList", "r0", "t0", "newState", "a0", "labelName", "u0", "b0", "c0", "showKeyboard", "d0", "h0", "inputKeyboardHeight", "n0", "q0", "p0", "keyboardHeight", "w0", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "T", "Lkotlin/Lazy;", "l0", "()Landroid/graphics/drawable/Drawable;", "drawableFullScreen", "U", "m0", "drawableNormal", "V", "o0", "()I", "navBarHeight", "Landroid/view/View;", "W", "Landroid/view/View;", "settingOperationContainer", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "rightOperationTextView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "rightOperationIcon", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieLabelListView;", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieLabelListView;", "labelView", "Lcom/tencent/robot/adelie/homepage/create/view/u;", "stateChangeListener", "e0", "Lcom/tencent/robot/adelie/homepage/create/view/v;", "settingAnimController", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieWrapperSettingWatcher;", "f0", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieWrapperSettingWatcher;", "settingWatcher", "g0", "I", "state", "screenHeight", "i0", "rootViewHeight", "j0", "editTextNormalTop", "k0", "currentKeyboardHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieSettingEditView extends AdelieEditTextView implements ak.b {

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m0, reason: collision with root package name */
    private static final int f366220m0 = c24.a.a(5);

    /* renamed from: n0, reason: collision with root package name */
    private static final int f366221n0 = c24.a.a(87);

    /* renamed from: o0, reason: collision with root package name */
    @NotNull
    private static final Lazy<Integer> f366222o0;

    /* renamed from: p0, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f366223p0;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy drawableFullScreen;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy drawableNormal;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy navBarHeight;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private View settingOperationContainer;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView rightOperationTextView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView rightOperationIcon;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieLabelListView labelView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private u stateChangeListener;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private v settingAnimController;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieWrapperSettingWatcher settingWatcher;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private int screenHeight;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private int rootViewHeight;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private int editTextNormalTop;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private int currentKeyboardHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieSettingEditView$a;", "", "", "height", "", "d", "cacheKeyboardHeight$delegate", "Lkotlin/Lazy;", "b", "()I", "cacheKeyboardHeight", "", "enableHighLight$delegate", "c", "()Z", "enableHighLight", "", "ADELIE_KEYBOARD_KEY", "Ljava/lang/String;", "", "ANIMATION_DURATION", "J", "BASE_HEIGHT", "I", "MAX_LINE", "MIN_LINE", "TAG", "fullScreenTopExt", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.create.view.AdelieSettingEditView$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(int height) {
            QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putInt("adelie_keyboard_height_key", height);
        }

        public final int b() {
            return ((Number) AdelieSettingEditView.f366222o0.getValue()).intValue();
        }

        public final boolean c() {
            return ((Boolean) AdelieSettingEditView.f366223p0.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f366236e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f366237f;

        public b(int i3, boolean z16) {
            this.f366236e = i3;
            this.f366237f = z16;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            View view;
            Intrinsics.checkNotNullParameter(animator, "animator");
            v vVar = AdelieSettingEditView.this.settingAnimController;
            if (vVar != null) {
                view = vVar.getTitleBarView();
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(4);
            }
            QLog.i("AdelieSettingEditView", 1, "keyboardHeight=" + this.f366236e + ", currentKeyboardHeight=" + AdelieSettingEditView.this.currentKeyboardHeight);
            if (this.f366237f && this.f366236e == 0 && AdelieSettingEditView.this.currentKeyboardHeight > 0) {
                AdelieSettingEditView adelieSettingEditView = AdelieSettingEditView.this;
                adelieSettingEditView.w0(adelieSettingEditView.currentKeyboardHeight);
            }
            u uVar = AdelieSettingEditView.this.stateChangeListener;
            if (uVar != null) {
                uVar.onChange(2);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InterceptTouchEditText f366238d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AdelieSettingEditView f366239e;

        public c(InterceptTouchEditText interceptTouchEditText, AdelieSettingEditView adelieSettingEditView, AdelieSettingEditView adelieSettingEditView2) {
            this.f366238d = interceptTouchEditText;
            this.f366239e = adelieSettingEditView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            ViewGroup.LayoutParams layoutParams = this.f366238d.getLayoutParams();
            layoutParams.height = -2;
            this.f366238d.setLayoutParams(layoutParams);
            u uVar = this.f366239e.stateChangeListener;
            if (uVar != null) {
                uVar.onChange(1);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            View view;
            Intrinsics.checkNotNullParameter(animator, "animator");
            v vVar = this.f366239e.settingAnimController;
            if (vVar != null) {
                view = vVar.getTitleBarView();
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/adelie/homepage/create/view/AdelieSettingEditView$d", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieLabelListView$a$a;", "Landroid/view/View;", "v", "", "text", "", "H", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements AdelieLabelListView.Companion.InterfaceC9754a {
        d() {
        }

        @Override // com.tencent.robot.adelie.homepage.create.view.AdelieLabelListView.Companion.InterfaceC9754a
        public void H(@NotNull View v3, @NotNull String text) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(text, "text");
            AdelieSettingEditView.this.u0(text);
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("tag_text", text));
            VideoReport.reportEvent("clck", v3, mapOf);
        }
    }

    static {
        Lazy<Integer> lazy;
        Lazy<Boolean> lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.robot.adelie.homepage.create.view.AdelieSettingEditView$Companion$cacheKeyboardHeight$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getInt("adelie_keyboard_height_key", 0));
            }
        });
        f366222o0 = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.robot.adelie.homepage.create.view.AdelieSettingEditView$Companion$enableHighLight$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(RobotQQMC.INSTANCE.enableSettingHighLight());
            }
        });
        f366223p0 = lazy2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieSettingEditView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a0(int newState) {
        if (this.state == newState) {
            return;
        }
        if (newState == 1) {
            c0();
        } else {
            b0();
            VideoReport.reportEvent("clck", this.settingOperationContainer, null);
        }
        this.state = newState;
    }

    private final void b0() {
        boolean z16;
        AdelieLabelListView adelieLabelListView;
        InterceptTouchEditText editTextView = getEditTextView();
        if (editTextView != null && !getAiGenerating()) {
            if (editTextView.hasFocus()) {
                editTextView.t(editTextView.getSelectionStart());
            } else {
                InterceptTouchEditText.u(editTextView, 0, 1, null);
            }
        }
        InterceptTouchEditText editTextView2 = getEditTextView();
        if (editTextView2 != null) {
            editTextView2.setMaxLines(Integer.MAX_VALUE);
        }
        ImageView imageView = this.rightOperationIcon;
        if (imageView != null) {
            imageView.setImageDrawable(m0());
        }
        TextView textView = this.rightOperationTextView;
        if (textView != null) {
            textView.setText(getContext().getText(R.string.zp_));
        }
        TextView textView2 = this.rightOperationTextView;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(R.color.qui_common_brand_standard));
        }
        AdelieLabelListView adelieLabelListView2 = this.labelView;
        if (adelieLabelListView2 != null && adelieLabelListView2.l()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (adelieLabelListView = this.labelView) != null) {
            adelieLabelListView.p();
        }
        d0(!getAiGenerating());
        v vVar = this.settingAnimController;
        if (vVar != null) {
            vVar.a(false);
        }
        v vVar2 = this.settingAnimController;
        if (vVar2 != null) {
            vVar2.b(4);
        }
    }

    private final void c0() {
        InterceptTouchEditText editTextView = getEditTextView();
        if (editTextView != null) {
            editTextView.r();
        }
        InterceptTouchEditText editTextView2 = getEditTextView();
        if (editTextView2 != null) {
            editTextView2.setMaxLines(8);
        }
        ImageView imageView = this.rightOperationIcon;
        if (imageView != null) {
            imageView.setImageDrawable(l0());
        }
        TextView textView = this.rightOperationTextView;
        if (textView != null) {
            textView.setText(getContext().getText(R.string.zp9));
        }
        TextView textView2 = this.rightOperationTextView;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        }
        AdelieLabelListView adelieLabelListView = this.labelView;
        if (adelieLabelListView != null) {
            adelieLabelListView.j();
        }
        h0();
        v vVar = this.settingAnimController;
        if (vVar != null) {
            vVar.a(true);
        }
        v vVar2 = this.settingAnimController;
        if (vVar2 != null) {
            vVar2.b(0);
        }
    }

    private final void d0(boolean showKeyboard) {
        int i3;
        ViewGroup viewGroup;
        View view;
        View view2;
        View view3;
        final InterceptTouchEditText editTextView = getEditTextView();
        if (editTextView == null) {
            return;
        }
        int height = editTextView.getHeight();
        if (showKeyboard) {
            i3 = this.currentKeyboardHeight;
        } else {
            i3 = 0;
        }
        int n06 = n0(i3);
        int q06 = (q0() - RFWImmersiveUtils.getStatusBarHeight()) - f366220m0;
        this.editTextNormalTop = q06;
        QLog.i("AdelieSettingEditView", 1, "editTextNormalTop=" + q06 + ", expandEditTextHeight=" + n06);
        int i16 = this.rootViewHeight;
        ValueAnimator ofInt = ValueAnimator.ofInt(i16, i16 * 2);
        ofInt.setDuration(0L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.adelie.homepage.create.view.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AdelieSettingEditView.f0(AdelieSettingEditView.this, valueAnimator);
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(height, n06);
        ofInt2.setDuration(200L);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.adelie.homepage.create.view.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AdelieSettingEditView.g0(InterceptTouchEditText.this, valueAnimator);
            }
        });
        v vVar = this.settingAnimController;
        if (vVar != null) {
            viewGroup = vVar.getContentView();
        } else {
            viewGroup = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, "translationY", 0.0f, -this.editTextNormalTop);
        ValueAnimator ofInt3 = ValueAnimator.ofInt(c24.a.a(16), 0);
        ofInt3.setDuration(200L);
        ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.adelie.homepage.create.view.o
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AdelieSettingEditView.e0(AdelieSettingEditView.this, valueAnimator);
            }
        });
        v vVar2 = this.settingAnimController;
        if (vVar2 != null) {
            view = vVar2.getTitleBarView();
        } else {
            view = null;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        v vVar3 = this.settingAnimController;
        if (vVar3 != null) {
            view2 = vVar3.c();
        } else {
            view2 = null;
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        v vVar4 = this.settingAnimController;
        if (vVar4 != null) {
            view3 = vVar4.d();
        } else {
            view3 = null;
        }
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view3, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new b(i3, showKeyboard));
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofInt, ofInt2, ofFloat, ofFloat2, ofFloat3, ofFloat4, ofInt3);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(AdelieSettingEditView this$0, ValueAnimator valueAnimator) {
        ViewGroup contentView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        v vVar = this$0.settingAnimController;
        if (vVar != null && (contentView = vVar.getContentView()) != null) {
            contentView.setPadding(intValue, 0, intValue, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(AdelieSettingEditView this$0, ValueAnimator valueAnimator) {
        ViewGroup rootView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        v vVar = this$0.settingAnimController;
        if (vVar != null && (rootView = vVar.getRootView()) != null) {
            ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
            layoutParams.height = intValue;
            rootView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(InterceptTouchEditText editText, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = editText.getLayoutParams();
        layoutParams.height = intValue;
        editText.setLayoutParams(layoutParams);
    }

    private final void h0() {
        int o06;
        int i3;
        ViewGroup viewGroup;
        float f16;
        View view;
        View view2;
        ViewGroup contentView;
        ViewGroup rootView;
        final InterceptTouchEditText editTextView = getEditTextView();
        if (editTextView == null) {
            return;
        }
        int height = editTextView.getHeight();
        if (PadUtil.a(getContext()) == DeviceType.PHONE) {
            o06 = this.rootViewHeight;
        } else {
            o06 = this.screenHeight - o0();
        }
        int[] iArr = new int[2];
        v vVar = this.settingAnimController;
        if (vVar != null && (rootView = vVar.getRootView()) != null) {
            i3 = rootView.getHeight();
        } else {
            i3 = 0;
        }
        iArr[0] = i3;
        iArr[1] = o06;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.adelie.homepage.create.view.p
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AdelieSettingEditView.i0(AdelieSettingEditView.this, valueAnimator);
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(height, p0());
        ofInt2.setDuration(200L);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.adelie.homepage.create.view.q
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AdelieSettingEditView.j0(InterceptTouchEditText.this, valueAnimator);
            }
        });
        v vVar2 = this.settingAnimController;
        View view3 = null;
        if (vVar2 != null) {
            viewGroup = vVar2.getContentView();
        } else {
            viewGroup = null;
        }
        float[] fArr = new float[2];
        v vVar3 = this.settingAnimController;
        if (vVar3 != null && (contentView = vVar3.getContentView()) != null) {
            f16 = contentView.getTranslationY();
        } else {
            f16 = 0.0f;
        }
        fArr[0] = f16;
        fArr[1] = 0.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, "translationY", fArr);
        ValueAnimator ofInt3 = ValueAnimator.ofInt(0, c24.a.a(16));
        ofInt3.setDuration(200L);
        ofInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.adelie.homepage.create.view.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AdelieSettingEditView.k0(AdelieSettingEditView.this, valueAnimator);
            }
        });
        v vVar4 = this.settingAnimController;
        if (vVar4 != null) {
            view = vVar4.getTitleBarView();
        } else {
            view = null;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        v vVar5 = this.settingAnimController;
        if (vVar5 != null) {
            view2 = vVar5.c();
        } else {
            view2 = null;
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        v vVar6 = this.settingAnimController;
        if (vVar6 != null) {
            view3 = vVar6.d();
        }
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view3, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new c(editTextView, this, this));
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofInt, ofInt2, ofFloat, ofFloat2, ofFloat3, ofFloat4, ofInt3);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(AdelieSettingEditView this$0, ValueAnimator valueAnimator) {
        ViewGroup rootView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        v vVar = this$0.settingAnimController;
        if (vVar != null && (rootView = vVar.getRootView()) != null) {
            ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
            layoutParams.height = intValue;
            rootView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(InterceptTouchEditText editText, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = editText.getLayoutParams();
        layoutParams.height = intValue;
        editText.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(AdelieSettingEditView this$0, ValueAnimator valueAnimator) {
        ViewGroup contentView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        v vVar = this$0.settingAnimController;
        if (vVar != null && (contentView = vVar.getContentView()) != null) {
            contentView.setPadding(intValue, 0, intValue, 0);
        }
    }

    private final Drawable l0() {
        return (Drawable) this.drawableFullScreen.getValue();
    }

    private final Drawable m0() {
        return (Drawable) this.drawableNormal.getValue();
    }

    private final int n0(int inputKeyboardHeight) {
        int a16;
        int i3;
        List<String> i16;
        int statusBarHeight = RFWImmersiveUtils.getStatusBarHeight();
        int a17 = c24.a.a(27);
        AdelieLabelListView adelieLabelListView = this.labelView;
        boolean z16 = false;
        if (adelieLabelListView != null && (i16 = adelieLabelListView.i()) != null && (!i16.isEmpty())) {
            z16 = true;
        }
        if (z16) {
            a16 = AdelieLabelListView.INSTANCE.a();
        } else {
            a16 = c24.a.a(16);
        }
        if (inputKeyboardHeight > 0) {
            i3 = 2;
        } else {
            i3 = 28;
        }
        return (((((this.screenHeight - statusBarHeight) - a17) - com.tencent.biz.qui.quisecnavbar.f.g()) - a16) - c24.a.a(i3)) - inputKeyboardHeight;
    }

    private final int o0() {
        return ((Number) this.navBarHeight.getValue()).intValue();
    }

    private final int p0() {
        int i3;
        int i16;
        int i17;
        InterceptTouchEditText editTextView = getEditTextView();
        if (editTextView != null) {
            i3 = editTextView.getLineCount();
        } else {
            i3 = f366221n0;
        }
        InterceptTouchEditText editTextView2 = getEditTextView();
        if (editTextView2 != null) {
            i16 = editTextView2.getLineHeight();
        } else {
            i16 = f366221n0;
        }
        int i18 = f366221n0;
        if (i3 <= 3) {
            i17 = 0;
        } else if (i3 > 8) {
            i17 = i16 * 5;
        } else {
            i17 = (i3 - 3) * i16;
        }
        return i18 + i17;
    }

    private final int q0() {
        int[] iArr = new int[2];
        View contentView = getContentView();
        if (contentView != null) {
            contentView.getLocationOnScreen(iArr);
        }
        return iArr[1];
    }

    private final void r0() {
        View view = this.settingOperationContainer;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.view.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AdelieSettingEditView.s0(AdelieSettingEditView.this, view2);
                }
            });
        }
        AdelieLabelListView adelieLabelListView = this.labelView;
        if (adelieLabelListView != null) {
            adelieLabelListView.setOnItemClickListener(new d());
        }
        AdelieWrapperSettingWatcher adelieWrapperSettingWatcher = this.settingWatcher;
        if (adelieWrapperSettingWatcher != null) {
            adelieWrapperSettingWatcher.i(this.labelView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(AdelieSettingEditView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g()) {
            if (this$0.state == 1) {
                this$0.a0(2);
                InterceptTouchEditText editTextView = this$0.getEditTextView();
                if (editTextView != null) {
                    editTextView.setDisallowParentInterceptTouchEvent(true);
                }
            } else {
                this$0.a0(1);
                InterceptTouchEditText editTextView2 = this$0.getEditTextView();
                if (editTextView2 != null) {
                    editTextView2.setDisallowParentInterceptTouchEvent(false);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void t0() {
        View view = this.settingOperationContainer;
        if (view != null) {
            com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, view, "em_bas_expand_full_screen", null, null, null, null, null, 124, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(String labelName) {
        int lastIndexOf$default;
        int indexOf$default;
        InterceptTouchEditText editTextView = getEditTextView();
        if (editTextView == null) {
            return;
        }
        Editable editable = editTextView.getEditableText();
        StringBuilder sb5 = new StringBuilder("## " + labelName + "\n");
        int selectionStart = editTextView.getSelectionStart();
        int selectionStart2 = editTextView.getSelectionStart();
        Intrinsics.checkNotNullExpressionValue(editable, "editable");
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) editable, '\n', selectionStart + (-1), false, 4, (Object) null);
        boolean z16 = true;
        int i3 = lastIndexOf$default + 1;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) editable, '\n', selectionStart, false, 4, (Object) null);
        if (indexOf$default == -1) {
            indexOf$default = editable.length();
        }
        if (selectionStart != 0 && selectionStart != i3) {
            if (selectionStart != editable.length() && selectionStart != indexOf$default) {
                sb5.insert(0, "\n");
                selectionStart2 = indexOf$default;
            } else {
                sb5.insert(0, "\n");
            }
        }
        if (editTextView.getCurrentCount() + sb5.length() > editTextView.getCharacterLimitCount()) {
            QQToast.makeText(getContext(), 0, getResources().getString(R.string.f160791vz), 0).show();
            return;
        }
        AdelieLabelListView adelieLabelListView = this.labelView;
        if (adelieLabelListView == null || !adelieLabelListView.k(labelName)) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        editable.insert(selectionStart2, sb5);
        editTextView.setSelection(selectionStart2 + sb5.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(int keyboardHeight) {
        ViewGroup.LayoutParams layoutParams;
        InterceptTouchEditText editTextView = getEditTextView();
        Integer num = null;
        if (editTextView != null) {
            layoutParams = editTextView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.height = n0(keyboardHeight);
        }
        InterceptTouchEditText editTextView2 = getEditTextView();
        if (editTextView2 != null) {
            editTextView2.setLayoutParams(layoutParams);
        }
        if (layoutParams != null) {
            num = Integer.valueOf(layoutParams.height);
        }
        QLog.i("AdelieSettingEditView", 1, "resetEditTextHeight, keyboardHeight=" + keyboardHeight + ", layoutParams?.height=" + num);
    }

    @Override // com.tencent.robot.adelie.homepage.create.view.AdelieEditTextView
    protected int A() {
        return R.layout.dsx;
    }

    @Override // com.tencent.robot.adelie.homepage.create.view.AdelieEditTextView
    protected void E() {
        InterceptTouchEditText editTextView = getEditTextView();
        if (editTextView != null) {
            AdelieWrapperSettingWatcher adelieWrapperSettingWatcher = new AdelieWrapperSettingWatcher(editTextView, getWatcher());
            adelieWrapperSettingWatcher.h(INSTANCE.c());
            this.settingWatcher = adelieWrapperSettingWatcher;
            editTextView.setInputViewWatcher(adelieWrapperSettingWatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.robot.adelie.homepage.create.view.AdelieEditTextView
    public void F(@NotNull String title, @NotNull String hint, int count) {
        View view;
        TextView textView;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(hint, "hint");
        super.F(title, hint, count);
        View contentView = getContentView();
        AdelieLabelListView adelieLabelListView = null;
        if (contentView != null) {
            view = contentView.findViewById(R.id.f83794ki);
        } else {
            view = null;
        }
        this.settingOperationContainer = view;
        View contentView2 = getContentView();
        if (contentView2 != null) {
            textView = (TextView) contentView2.findViewById(R.id.f83814kk);
        } else {
            textView = null;
        }
        this.rightOperationTextView = textView;
        View contentView3 = getContentView();
        if (contentView3 != null) {
            imageView = (ImageView) contentView3.findViewById(R.id.f83804kj);
        } else {
            imageView = null;
        }
        this.rightOperationIcon = imageView;
        View contentView4 = getContentView();
        if (contentView4 != null) {
            adelieLabelListView = (AdelieLabelListView) contentView4.findViewById(R.id.f83784kh);
        }
        this.labelView = adelieLabelListView;
        ImageView imageView2 = this.rightOperationIcon;
        if (imageView2 != null) {
            imageView2.setImageDrawable(l0());
        }
        View view2 = this.settingOperationContainer;
        if (view2 != null) {
            CommonExKt.c(view2, c24.a.a(15));
        }
        r0();
        t0();
    }

    @Override // com.tencent.robot.adelie.homepage.create.ak.b
    public void a(int keyboardHeightInPx) {
        QLog.i("AdelieSettingEditView", 1, "onSoftKeyboardHeightChanged, keyboardHeightInPx=" + keyboardHeightInPx);
        if (this.state == 1) {
            return;
        }
        w0(keyboardHeightInPx);
    }

    @Override // com.tencent.robot.adelie.homepage.create.ak.b
    public void b(int height) {
        ViewGroup rootView;
        ViewGroup viewGroup;
        QLog.i("AdelieSettingEditView", 1, "onScreenHeightChange, currentHeight=" + this.screenHeight + ", newHeight=" + height);
        this.screenHeight = height;
        if (PadUtil.a(getContext()) != DeviceType.PHONE) {
            v vVar = this.settingAnimController;
            if (vVar != null && (rootView = vVar.getRootView()) != null && rootView.getHeight() != height) {
                v vVar2 = this.settingAnimController;
                ViewGroup.LayoutParams layoutParams = null;
                if (vVar2 != null) {
                    viewGroup = vVar2.getRootView();
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    layoutParams = viewGroup.getLayoutParams();
                }
                if (this.state == 1) {
                    if (layoutParams != null) {
                        layoutParams.height = height - o0();
                    }
                } else if (layoutParams != null) {
                    layoutParams.height = (height - o0()) * 2;
                }
                if (viewGroup != null) {
                    viewGroup.setLayoutParams(layoutParams);
                }
            }
            if (this.state == 2) {
                AdelieUtils adelieUtils = AdelieUtils.f365929a;
                if (adelieUtils.S(this)) {
                    if (PadUtil.a(getContext()) == DeviceType.FOLD) {
                        w0(adelieUtils.N(this));
                        return;
                    } else {
                        w0(this.currentKeyboardHeight);
                        return;
                    }
                }
                w0(0);
            }
        }
    }

    @Override // com.tencent.robot.adelie.homepage.create.ak.b
    public void onSoftKeyboardClosed() {
        QLog.i("AdelieSettingEditView", 1, "onSoftKeyboardClosed");
    }

    @Override // com.tencent.robot.adelie.homepage.create.ak.b
    public void onSoftKeyboardOpened(int keyboardHeightInPx) {
        QLog.i("AdelieSettingEditView", 1, "onSoftKeyboardOpened, keyboardHeightInPx=" + keyboardHeightInPx);
        int i3 = this.currentKeyboardHeight;
        Companion companion = INSTANCE;
        if (i3 != companion.b()) {
            companion.d(keyboardHeightInPx);
        }
        this.currentKeyboardHeight = keyboardHeightInPx;
    }

    @Override // com.tencent.robot.adelie.homepage.create.view.AdelieEditTextView
    public void setEditEnabled(boolean enable) {
        super.setEditEnabled(enable);
        View view = this.settingOperationContainer;
        if (view != null) {
            view.setEnabled(enable);
        }
    }

    public final void setLabelList(@Nullable List<String> list) {
        AdelieLabelListView adelieLabelListView = this.labelView;
        if (adelieLabelListView != null) {
            adelieLabelListView.setLabelList(list);
        }
    }

    public final void setOnEditStateChangeListener(@Nullable u listener) {
        this.stateChangeListener = listener;
    }

    public final void setRootViewHeight(int height) {
        QLog.i("AdelieSettingEditView", 1, "setScreenHeight, height=" + height + ", rootViewHeight=" + this.rootViewHeight + ", screenHeight=" + this.screenHeight);
        this.screenHeight = height;
        if (this.rootViewHeight == height) {
            return;
        }
        this.rootViewHeight = height;
    }

    public final void setScrollController(@Nullable v controller) {
        this.settingAnimController = controller;
    }

    public final boolean v0() {
        if (this.state == 2) {
            a0(1);
            return true;
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieSettingEditView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieSettingEditView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieSettingEditView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.robot.adelie.homepage.create.view.AdelieSettingEditView$drawableFullScreen$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                return ie0.a.f().o(context, R.drawable.qui_zoom_out, R.color.qui_common_icon_secondary, 1001);
            }
        });
        this.drawableFullScreen = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.robot.adelie.homepage.create.view.AdelieSettingEditView$drawableNormal$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                return ie0.a.f().o(context, R.drawable.qui_zoom_in, R.color.qui_common_brand_standard, 1001);
            }
        });
        this.drawableNormal = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.robot.adelie.homepage.create.view.AdelieSettingEditView$navBarHeight$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(SystemBarTintManager.hasNavBar(context) ? SystemBarTintManager.getNavigationBarHeight(context) : 0);
            }
        });
        this.navBarHeight = lazy3;
        this.state = 1;
        this.screenHeight = ViewUtils.getScreenHeight();
        this.rootViewHeight = ViewUtils.getScreenHeight();
        this.currentKeyboardHeight = INSTANCE.b();
    }
}
