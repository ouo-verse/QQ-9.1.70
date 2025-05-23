package com.tencent.mobileqq.aio.input;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.AIOInputUIState;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.am;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 E2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001FB\u0013\u0012\n\u0010&\u001a\u0006\u0012\u0002\b\u00030!\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J&\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0017\u0012\u0006\b\u0001\u0012\u00020\u00180\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u001c\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016J\u0016\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001d0\u0016H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0003H\u0016R\u001b\u0010&\u001a\u0006\u0012\u0002\b\u00030!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010/R-\u00106\u001a\u0014\u0012\u0006\b\u0001\u0012\u000201\u0012\u0006\b\u0001\u0012\u000201\u0018\u00010\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R#\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u000208078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u00103\u001a\u0004\b:\u0010;R;\u0010B\u001a\"\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00010=j\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001`>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u00103\u001a\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/aio/input/AIOInputExpandableVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "", "e1", "l1", ICustomDataEditor.NUMBER_PARAM_1, "", OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "j1", OpenHippyInfo.EXTRA_KEY_IS_TRANSPARENT, "isImmersive", "m1", "Landroid/graphics/Bitmap;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Ljava/lang/Class;", "getObserverStates", "state", "k1", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "d", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "f1", "()Lcom/tencent/mobileqq/aio/input/adorn/a;", "inputBarAdornApi", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mInputContainer", "f", "Landroid/view/View;", "divideView", tl.h.F, "Z", "i", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "g1", "()Lcom/tencent/aio/base/mvvm/a;", "mBottomBarVB", "Lcom/tencent/mobileqq/aio/input/inputbar/a;", "Lcom/tencent/mobileqq/aio/input/adorn/e;", BdhLogUtil.LogTag.Tag_Conn, "i1", "()Lcom/tencent/mobileqq/aio/input/inputbar/a;", "mInputBar", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "h1", "()Ljava/util/ArrayList;", "mChildVb", "<init>", "(Lcom/tencent/mobileqq/aio/input/adorn/a;)V", "E", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOInputExpandableVB extends com.tencent.aio.base.mvvm.a<at.a, InputUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mInputBar;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mChildVb;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.input.adorn.a<?> inputBarAdornApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mInputContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View divideView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isTransparent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isImmersive;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBottomBarVB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/AIOInputExpandableVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.AIOInputExpandableVB$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52841);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOInputExpandableVB(@NotNull com.tencent.mobileqq.aio.input.adorn.a<?> inputBarAdornApi) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(inputBarAdornApi, "inputBarAdornApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputBarAdornApi);
            return;
        }
        this.inputBarAdornApi = inputBarAdornApi;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.aio.base.mvvm.a<Object, Object>>() { // from class: com.tencent.mobileqq.aio.input.AIOInputExpandableVB$mBottomBarVB$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOInputExpandableVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final com.tencent.aio.base.mvvm.a<Object, Object> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? AIOInputExpandableVB.this.f1().a() : (com.tencent.aio.base.mvvm.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mBottomBarVB = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.aio.input.inputbar.a<? extends com.tencent.mobileqq.aio.input.adorn.e>>() { // from class: com.tencent.mobileqq.aio.input.AIOInputExpandableVB$mInputBar$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOInputExpandableVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.aio.input.inputbar.a<? extends com.tencent.mobileqq.aio.input.adorn.e> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new com.tencent.mobileqq.aio.input.inputbar.a<>(AIOInputExpandableVB.this.f1()) : (com.tencent.mobileqq.aio.input.inputbar.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mInputBar = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<com.tencent.aio.base.mvvm.a<?, ?>>>() { // from class: com.tencent.mobileqq.aio.input.AIOInputExpandableVB$mChildVb$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOInputExpandableVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<com.tencent.aio.base.mvvm.a<?, ?>> invoke() {
                com.tencent.aio.base.mvvm.a<?, ?> g16;
                com.tencent.mobileqq.aio.input.inputbar.a i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ArrayList) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ArrayList<com.tencent.aio.base.mvvm.a<?, ?>> arrayList = new ArrayList<>();
                AIOInputExpandableVB aIOInputExpandableVB = AIOInputExpandableVB.this;
                g16 = aIOInputExpandableVB.g1();
                if (g16 != null) {
                    arrayList.add(g16);
                }
                i16 = aIOInputExpandableVB.i1();
                arrayList.add(i16);
                return arrayList;
            }
        });
        this.mChildVb = lazy3;
    }

    private final Bitmap d1() {
        Bitmap e16;
        try {
            try {
                Drawable drawable = ResourcesCompat.getDrawable(getMContext().getResources(), com.tencent.mobileqq.aio.input.themecompat.a.f189924a.c(), getMContext().getTheme());
                if (drawable == null) {
                    am amVar = am.f194110a;
                    LinearLayout linearLayout = this.mInputContainer;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
                        linearLayout = null;
                    }
                    e16 = amVar.e(linearLayout, true);
                } else {
                    AIOUtil.f194084a.F(i1().getHostView(), drawable);
                    e16 = am.f194110a.e(i1().getHostView(), true);
                }
                int paddingTop = i1().getHostView().getPaddingTop();
                int paddingLeft = i1().getHostView().getPaddingLeft();
                int paddingRight = i1().getHostView().getPaddingRight();
                int paddingBottom = i1().getHostView().getPaddingBottom();
                i1().getHostView().setBackground(null);
                i1().getHostView().setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                return e16;
            } catch (Exception e17) {
                QLog.e("AIOInputExpandableVB", 1, "LongShot inputBar bitmap exception: " + e17);
                int paddingTop2 = i1().getHostView().getPaddingTop();
                int paddingLeft2 = i1().getHostView().getPaddingLeft();
                int paddingRight2 = i1().getHostView().getPaddingRight();
                int paddingBottom2 = i1().getHostView().getPaddingBottom();
                i1().getHostView().setBackground(null);
                i1().getHostView().setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
                return null;
            }
        } catch (Throwable th5) {
            int paddingTop3 = i1().getHostView().getPaddingTop();
            int paddingLeft3 = i1().getHostView().getPaddingLeft();
            int paddingRight3 = i1().getHostView().getPaddingRight();
            int paddingBottom3 = i1().getHostView().getPaddingBottom();
            i1().getHostView().setBackground(null);
            i1().getHostView().setPadding(paddingLeft3, paddingTop3, paddingRight3, paddingBottom3);
            throw th5;
        }
    }

    private final void e1() {
        ImageView imageView = new ImageView(getMContext());
        this.divideView = imageView;
        imageView.setBackgroundResource(R.drawable.qui_common_border_light_bg);
        View view = this.divideView;
        if (view != null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
        }
        LinearLayout linearLayout = this.mInputContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
            linearLayout = null;
        }
        linearLayout.addView(this.divideView);
        n1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.aio.base.mvvm.a<Object, Object> g1() {
        return (com.tencent.aio.base.mvvm.a) this.mBottomBarVB.getValue();
    }

    private final ArrayList<com.tencent.aio.base.mvvm.a<?, ?>> h1() {
        return (ArrayList) this.mChildVb.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.aio.input.inputbar.a<? extends com.tencent.mobileqq.aio.input.adorn.e> i1() {
        return (com.tencent.mobileqq.aio.input.inputbar.a) this.mInputBar.getValue();
    }

    private final void j1(boolean isFullScreen) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("AIOInputExpandableVB", 1, "handleFullScreenEvent isFullScreen = " + isFullScreen);
        }
        LinearLayout linearLayout = this.mInputContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
            linearLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (isFullScreen) {
            i3 = -1;
        } else {
            i3 = -2;
        }
        layoutParams.height = i3;
    }

    private final void l1() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOInputExpandableVB", 1, "onThemeChange");
        }
        n1();
    }

    private final void m1(boolean isTransparent, boolean isImmersive) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOInputExpandableVB", 1, "updateBackgroundTransparentState isTransparent = " + isTransparent + ", isImmersive = " + isImmersive + "}");
        }
        LinearLayout linearLayout = this.mInputContainer;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
            linearLayout = null;
        }
        linearLayout.setBackground(null);
        this.isTransparent = isTransparent;
        this.isImmersive = isImmersive;
        if (isTransparent) {
            LinearLayout linearLayout3 = this.mInputContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
            } else {
                linearLayout2 = linearLayout3;
            }
            linearLayout2.setBackgroundColor(0);
            return;
        }
        Drawable backgroundDrawable = getMContext().getResources().getDrawable(com.tencent.mobileqq.aio.input.themecompat.a.f189924a.c());
        AIOUtil aIOUtil = AIOUtil.f194084a;
        LinearLayout linearLayout4 = this.mInputContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
        } else {
            linearLayout2 = linearLayout4;
        }
        Intrinsics.checkNotNullExpressionValue(backgroundDrawable, "backgroundDrawable");
        aIOUtil.F(linearLayout2, backgroundDrawable);
    }

    private final void n1() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOInputExpandableVB", 1, "updateDivideLineVisibility QQTheme.isVasTheme() = " + QQTheme.isVasTheme() + ", QQTheme.isNowSimpleUI() = " + QQTheme.isNowSimpleUI());
        }
        if (!QQTheme.isNowSimpleUI() && !QQTheme.isVasTheme()) {
            View view = this.divideView;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.divideView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            sendIntent(f.a.f189561d);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<at.a, InputUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseVM) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new e();
    }

    @NotNull
    public final com.tencent.mobileqq.aio.input.adorn.a<?> f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.inputBarAdornApi;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{AIOInputUIState.PostThemeChanged.class, AIOInputUIState.BeforeFullScreenAnimChanged.class, AIOInputUIState.SetBackgroundTransparent.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        return h1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        Bitmap d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOInputUIState.PostThemeChanged) {
            l1();
            return;
        }
        if (state instanceof AIOInputUIState.BeforeFullScreenAnimChanged) {
            j1(((AIOInputUIState.BeforeFullScreenAnimChanged) state).a());
            return;
        }
        if (state instanceof AIOInputUIState.SetBackgroundTransparent) {
            AIOInputUIState.SetBackgroundTransparent setBackgroundTransparent = (AIOInputUIState.SetBackgroundTransparent) state;
            m1(setBackgroundTransparent.b(), setBackgroundTransparent.a());
        } else if ((state instanceof AIOInputUIState.GetInputBarBitmap) && (d16 = d1()) != null) {
            sendIntent(new f.C7266f(d16));
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        LinearLayout linearLayout = new LinearLayout(createViewParams.a());
        linearLayout.setLayoutParams(com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        this.mInputContainer = linearLayout;
        if (this.inputBarAdornApi.d()) {
            e1();
        }
        LinearLayout linearLayout2 = this.mInputContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputContainer");
            return null;
        }
        return linearLayout2;
    }
}
