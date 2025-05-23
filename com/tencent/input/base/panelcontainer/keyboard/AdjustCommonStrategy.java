package com.tencent.input.base.panelcontainer.keyboard;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.view.FilterEnum;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001'\u0018\u0000 -2\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R&\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/input/base/panelcontainer/keyboard/AdjustCommonStrategy;", "Lcom/tencent/input/base/panelcontainer/keyboard/c;", "", "i", "Landroid/view/View;", "view", "", "k", "keyboardHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "j", "Lcom/tencent/input/base/panelcontainer/keyboard/b;", "listener", "", "b", "a", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mvi/api/runtime/b;", "mContext", "Lcom/tencent/input/base/panelcontainer/keyboard/g;", "Lcom/tencent/input/base/panelcontainer/keyboard/g;", "mStrategyLoadData", "c", "I", "mKeyboardHeight", "d", "Lcom/tencent/input/base/panelcontainer/keyboard/b;", "mKeyboardHeightListener", "Lcom/tencent/mvi/log/b;", "e", "Lcom/tencent/mvi/log/b;", "mLogger", "Lkotlin/Function2;", "Landroidx/core/view/WindowInsetsCompat;", "f", "Lkotlin/jvm/functions/Function2;", "mOnApplyWindowInsetsListener", "com/tencent/input/base/panelcontainer/keyboard/AdjustCommonStrategy$b", "g", "Lcom/tencent/input/base/panelcontainer/keyboard/AdjustCommonStrategy$b;", "insetInfo", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Lcom/tencent/input/base/panelcontainer/keyboard/g;)V", h.F, "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class AdjustCommonStrategy implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.api.runtime.b mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g mStrategyLoadData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mKeyboardHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.input.base.panelcontainer.keyboard.b mKeyboardHeightListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mvi.log.b mLogger;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<View, WindowInsetsCompat, WindowInsetsCompat> mOnApplyWindowInsetsListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b insetInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/input/base/panelcontainer/keyboard/AdjustCommonStrategy$a;", "", "", "KEYBOARD_VALID_HEIGHT_SCALE_T", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.input.base.panelcontainer.keyboard.AdjustCommonStrategy$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\u0005\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\u000b\u0010\t\u00a8\u0006\u000e"}, d2 = {"com/tencent/input/base/panelcontainer/keyboard/AdjustCommonStrategy$b", "", "", "toString", "", "a", "Ljava/lang/Integer;", "getImmBottom", "()Ljava/lang/Integer;", "(Ljava/lang/Integer;)V", "immBottom", "b", "getNavBottom", "navBottom", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer immBottom;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer navBottom;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final void a(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) num);
            } else {
                this.immBottom = num;
            }
        }

        public final void b(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) num);
            } else {
                this.navBottom = num;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return "[immBottom: " + this.immBottom + "], [navBottom: " + this.navBottom + ']';
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33399);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AdjustCommonStrategy(@NotNull com.tencent.mvi.api.runtime.b mContext, @NotNull g mStrategyLoadData) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mStrategyLoadData, "mStrategyLoadData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext, (Object) mStrategyLoadData);
            return;
        }
        this.mContext = mContext;
        this.mStrategyLoadData = mStrategyLoadData;
        this.mLogger = mStrategyLoadData.a();
        this.mOnApplyWindowInsetsListener = new Function2<View, WindowInsetsCompat, WindowInsetsCompat>() { // from class: com.tencent.input.base.panelcontainer.keyboard.AdjustCommonStrategy$mOnApplyWindowInsetsListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AdjustCommonStrategy.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final WindowInsetsCompat invoke(@NotNull View view, @NotNull WindowInsetsCompat insets) {
                boolean i3;
                int k3;
                int i16;
                b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (WindowInsetsCompat) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) insets);
                }
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(insets, "insets");
                i3 = AdjustCommonStrategy.this.i();
                if (i3) {
                    k3 = AdjustCommonStrategy.this.k(view);
                    i16 = AdjustCommonStrategy.this.mKeyboardHeight;
                    if (i16 != k3) {
                        bVar = AdjustCommonStrategy.this.mKeyboardHeightListener;
                        if (bVar != null) {
                            bVar.a(k3);
                        }
                        AdjustCommonStrategy.this.mKeyboardHeight = k3;
                    }
                }
                return insets;
            }
        };
        this.insetInfo = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i() {
        com.tencent.mvi.log.b bVar;
        FragmentActivity activity;
        Window window;
        WindowManager.LayoutParams attributes;
        Fragment c16 = this.mContext.c();
        Integer num = null;
        if (c16 != null && (activity = c16.getActivity()) != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            num = Integer.valueOf(attributes.softInputMode);
        }
        boolean z16 = false;
        if (num == null) {
            return false;
        }
        int intValue = num.intValue();
        if ((intValue & 240) == 16) {
            z16 = true;
        }
        if (!z16 && (bVar = this.mLogger) != null) {
            bVar.i("AdjustCommonStrategy", "checkSoftInputMode softInputMode = " + intValue + " isResizeMode = false");
        }
        return z16;
    }

    private final int j(Context context) {
        Resources resources = context.getResources();
        int a16 = e.f116886a.a(this.mStrategyLoadData.b(), resources.getConfiguration().orientation);
        if (a16 <= 0) {
            return (int) (resources.getDisplayMetrics().density * FilterEnum.MIC_PTU_TRANS_XINXIAN);
        }
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k(View view) {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        int i3 = 0;
        if (rootWindowInsets == null) {
            return 0;
        }
        if (rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) {
            int i16 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
            int i17 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
            b bVar = this.insetInfo;
            bVar.a(Integer.valueOf(i16));
            bVar.b(Integer.valueOf(i17));
            i3 = i16 - i17;
        } else {
            com.tencent.mvi.log.b bVar2 = this.mLogger;
            if (bVar2 != null) {
                bVar2.i("AdjustCommonStrategy", "imm isVisible false keyboardHeight 0");
            }
        }
        return m(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat l(Function2 tmp0, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (WindowInsetsCompat) tmp0.invoke(view, windowInsetsCompat);
    }

    private final int m(int keyboardHeight) {
        if (keyboardHeight < 0) {
            com.tencent.mvi.log.b bVar = this.mLogger;
            if (bVar != null) {
                bVar.i("AdjustCommonStrategy", Intrinsics.stringPlus("tryToFixKeyBoardHeight , keyboardHeight < 0 keyboardHeight = ", Integer.valueOf(keyboardHeight)));
            }
            return 0;
        }
        Context context = this.mContext.c().getContext();
        if (context == null) {
            return 0;
        }
        int i3 = context.getResources().getDisplayMetrics().heightPixels;
        if (keyboardHeight > i3 * 0.8f) {
            int j3 = j(context);
            com.tencent.mvi.log.b bVar2 = this.mLogger;
            if (bVar2 != null) {
                bVar2.i("AdjustCommonStrategy", "tryToFixKeyBoardHeight err, keyboardHeight = " + keyboardHeight + "  screenHeight = " + i3 + " defaultKeyboardHeight = " + j3);
            }
            return j3;
        }
        return keyboardHeight;
    }

    @Override // com.tencent.input.base.panelcontainer.keyboard.c
    public void a() {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mKeyboardHeightListener = null;
        FragmentActivity activity = this.mContext.c().getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            ViewCompat.setOnApplyWindowInsetsListener((FrameLayout) window.findViewById(R.id.content), null);
        }
    }

    @Override // com.tencent.input.base.panelcontainer.keyboard.c
    public void b(@NotNull com.tencent.input.base.panelcontainer.keyboard.b listener) {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mKeyboardHeightListener = listener;
        FragmentActivity activity = this.mContext.c().getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            if ((window.getAttributes().flags & 512) != 0) {
                window.clearFlags(512);
            }
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.content);
            final Function2<View, WindowInsetsCompat, WindowInsetsCompat> function2 = this.mOnApplyWindowInsetsListener;
            ViewCompat.setOnApplyWindowInsetsListener(frameLayout, new OnApplyWindowInsetsListener() { // from class: com.tencent.input.base.panelcontainer.keyboard.a
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    WindowInsetsCompat l3;
                    l3 = AdjustCommonStrategy.l(Function2.this, view, windowInsetsCompat);
                    return l3;
                }
            });
        }
    }
}
