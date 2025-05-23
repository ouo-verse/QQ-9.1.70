package com.tencent.mobileqq.aio.shortcurtbar;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.ShortcutEventIntent;
import com.tencent.mobileqq.aio.event.f;
import com.tencent.mobileqq.aio.event.g;
import com.tencent.mobileqq.aio.event.j;
import com.tencent.mobileqq.aio.shortcurtbar.AIOShortcutBarUIState;
import com.tencent.mobileqq.aio.shortcurtbar.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.am;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOImmersiveApi;
import com.tencent.qqnt.aio.shortcutbar.PanelIconLinearLayout;
import com.tencent.qqnt.aio.shortcutbar.i;
import com.tencent.qqnt.aio.utils.ae;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u001e*\u0001G\u0018\u0000 b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001cB\u0007\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0002J#\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\nH\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0002J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\nH\u0002J\u0010\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\u000eH\u0016J$\u00101\u001a\u00020\u000e2\u001a\u00100\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0016J\b\u00103\u001a\u000202H\u0016J\b\u00104\u001a\u00020\u000eH\u0016J\u0010\u00106\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u0003H\u0016J\u0010\u00108\u001a\u00020\n2\u0006\u00107\u001a\u00020(H\u0016J\u0010\u00109\u001a\u00020\u000e2\u0006\u00107\u001a\u00020(H\u0016J\u0006\u0010:\u001a\u00020\fJ\b\u0010;\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020\fH\u0016R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010NR\u0016\u0010R\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010TR\u0016\u0010[\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010LR\u001b\u0010_\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\\\u0010?\u001a\u0004\b]\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/shortcurtbar/a;", "Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarUIState;", "Lcom/tencent/qqnt/aio/shortcutbar/d;", "Lcom/tencent/qqnt/aio/shortcutbar/h;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "h1", "", "isShowPanel", "", "panelId", "", "p1", "count", ICustomDataEditor.STRING_PARAM_1, "curPanelId", "keyboardShow", "v1", "(Ljava/lang/Integer;Ljava/lang/Boolean;)V", "l1", "isAnonymous", "needTransparent", "m1", "q1", "isShotMode", "j1", "isPlusIconSelect", "i1", "chatType", "", "peerUid", "u1", ICustomDataEditor.NUMBER_PARAM_1, "isEnable", "o1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "bindViewAndData", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "mUIModel", "afterCreateVM", "Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVM;", "d1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "k1", "view", "c0", "l0", "g1", "getVisibility", "getMeasuredHeight", "Lcom/tencent/qqnt/aio/shortcutbar/PanelIconLinearLayout;", "d", "Lkotlin/Lazy;", "f1", "()Lcom/tencent/qqnt/aio/shortcutbar/PanelIconLinearLayout;", "mPanelIconLayout", "Lcom/tencent/qqnt/aio/shortcutbar/i;", "e", "Lcom/tencent/qqnt/aio/shortcutbar/i;", "mPanelClickListener", "com/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVB$b", "f", "Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVB$b;", "mActionR", h.F, "Z", "mIsFromHotPic", "Ljava/lang/String;", "mPeerUid", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mChatType", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mPlusRedView", "D", "mEmoRedView", "E", "mPlusIcon", UserInfo.SEX_FEMALE, "mIsGagMode", "G", "e1", "()Z", "mNavBarSwitch", "<init>", "()V", "H", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOShortcutBarVB extends com.tencent.aio.base.mvvm.a<a, AIOShortcutBarUIState> implements com.tencent.qqnt.aio.shortcutbar.d, com.tencent.qqnt.aio.shortcutbar.h {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View mPlusRedView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View mEmoRedView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View mPlusIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsGagMode;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy mNavBarSwitch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mPanelIconLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i mPanelClickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mActionR;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFromHotPic;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mPeerUid;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mChatType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVB$a;", "", "", "ROTATION_ANIM_DEGREE", UserInfo.SEX_FEMALE, "", "ROTATION_ANIM_DURATION", "J", "", "ROTATION_PROPERTY_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.shortcurtbar.AIOShortcutBarVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVB$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOShortcutBarVB.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return AIOShortcutBarVB.this.h1(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64957);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOShortcutBarVB() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<PanelIconLinearLayout>() { // from class: com.tencent.mobileqq.aio.shortcurtbar.AIOShortcutBarVB$mPanelIconLayout$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOShortcutBarVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final PanelIconLinearLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (PanelIconLinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    PanelIconLinearLayout panelIconLinearLayout = new PanelIconLinearLayout(AIOShortcutBarVB.this.getMContext());
                    AIOShortcutBarVB aIOShortcutBarVB = AIOShortcutBarVB.this;
                    panelIconLinearLayout.setClickable(true);
                    panelIconLinearLayout.setFocusable(true);
                    panelIconLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) aIOShortcutBarVB.getMContext().getResources().getDimension(R.dimen.f158195bz2)));
                    panelIconLinearLayout.setPadding(panelIconLinearLayout.getPaddingLeft(), panelIconLinearLayout.getPaddingTop(), panelIconLinearLayout.getPaddingRight(), l.b(8));
                    return panelIconLinearLayout;
                }
            });
            this.mPanelIconLayout = lazy;
            this.mActionR = new b();
            this.mPeerUid = "";
            lazy2 = LazyKt__LazyJVMKt.lazy(AIOShortcutBarVB$mNavBarSwitch$2.INSTANCE);
            this.mNavBarSwitch = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final boolean e1() {
        return ((Boolean) this.mNavBarSwitch.getValue()).booleanValue();
    }

    private final PanelIconLinearLayout f1() {
        return (PanelIconLinearLayout) this.mPanelIconLayout.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k h1(MsgIntent i3) {
        f fVar;
        if (i3 instanceof ShortcutEventIntent.OnGetPlusIconPosIntent) {
            Pair<Integer, Integer> a16 = f1().a();
            if (a16 != null) {
                return new com.tencent.mobileqq.aio.event.i(a16);
            }
            return new f();
        }
        if (i3 instanceof ShortcutEventIntent.OnGetPlusIconViewIntent) {
            View c16 = f1().c(1006);
            if (c16 != null) {
                return new j(c16);
            }
            fVar = new f();
        } else {
            if (i3 instanceof ShortcutEventIntent.OnGetIconBarHeightIntent) {
                return new com.tencent.mobileqq.aio.event.h(g1());
            }
            if (i3 instanceof ShortcutEventIntent.OnGetEmoIconViewIntent) {
                View c17 = f1().c(1001);
                if (c17 != null) {
                    return new g(c17);
                }
                fVar = new f();
            } else {
                if (i3 instanceof ShortcutEventIntent.OnGetShortCutLayoutViewIntent) {
                    return new com.tencent.mobileqq.aio.event.k(f1());
                }
                return new f();
            }
        }
        return fVar;
    }

    private final void i1(boolean isPlusIconSelect) {
        float f16;
        boolean z16;
        View view = this.mPlusIcon;
        if (view == null) {
            return;
        }
        if (isPlusIconSelect) {
            f16 = 45.0f;
        } else {
            f16 = 0.0f;
        }
        Intrinsics.checkNotNull(view);
        if (view.getRotation() == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        View view2 = this.mPlusIcon;
        Intrinsics.checkNotNull(view2);
        View view3 = this.mPlusIcon;
        Intrinsics.checkNotNull(view3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, BasicAnimation.KeyPath.ROTATION, view3.getRotation(), f16);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    private final void j1(boolean isShotMode) {
        if (com.tencent.mobileqq.aio.utils.f.f194152a.b(this.mChatType)) {
            return;
        }
        if (!isShotMode) {
            f1().setVisibility(0);
            return;
        }
        try {
            sendIntent(new a.d(am.f194110a.e(f1(), true)));
        } catch (Exception e16) {
            QLog.e("AIOShortcutBarVB", 1, "LongShot shortCutBar bitmap exception: " + e16);
        }
        f1().setVisibility(8);
    }

    private final boolean l1() {
        GroupAnonymousInfo anonymousInfo;
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null && (anonymousInfo = e16.getAnonymousInfo(this.mPeerUid)) != null) {
            return anonymousInfo.isAnonymousChat;
        }
        return false;
    }

    private final void m1(boolean isAnonymous, boolean needTransparent) {
        f1().f(2, this.mPeerUid, this);
        q1(isAnonymous, needTransparent);
        f1().setSelected(1006);
        this.mPlusIcon = f1().c(1006);
        i1(true);
    }

    private final void n1(int chatType, String peerUid) {
        View c16;
        if (com.tencent.mobileqq.aio.utils.f.f194152a.b(this.mChatType)) {
            return;
        }
        if ((chatType != 2 && chatType != 1) || (c16 = f1().c(1001)) == null) {
            return;
        }
        if (this.mEmoRedView == null) {
            this.mEmoRedView = ae.f352281b.f(getMContext(), c16);
        }
        if (QLog.isColorLevel()) {
            QLog.i("AIOShortcutBarVB", 1, "fetch normal emo icon red dot");
        }
        View view = this.mEmoRedView;
        if (view != null) {
            view.setTag(1001);
            view.setSelected(c16.isSelected());
            ae.f352281b.e(peerUid, chatType, view);
        }
    }

    private final void o1(boolean isEnable) {
        this.mIsGagMode = !isEnable;
    }

    private final void p1(boolean isShowPanel, int panelId) {
        if (!isShowPanel) {
            f1().e();
            i1(false);
        } else if (panelId == 1009) {
            this.mIsFromHotPic = true;
            f1().setSelected(1006);
            i1(true);
        } else {
            f1().setSelected(panelId);
            i1(false);
        }
    }

    private final void q1(boolean isAnonymous, boolean needTransparent) {
        int i3;
        if (isAnonymous) {
            f1().setBackground(ResourcesCompat.getDrawable(getMContext().getResources(), R.drawable.a5t, null));
            return;
        }
        if (needTransparent) {
            f1().setBackgroundColor(0);
            return;
        }
        if (QQTheme.isVasTheme() && e1()) {
            f1().post(new Runnable() { // from class: com.tencent.mobileqq.aio.shortcurtbar.b
                @Override // java.lang.Runnable
                public final void run() {
                    AIOShortcutBarVB.r1(AIOShortcutBarVB.this);
                }
            });
            return;
        }
        AIOUtil aIOUtil = AIOUtil.f194084a;
        PanelIconLinearLayout f16 = f1();
        if (QQTheme.isVasTheme()) {
            i3 = R.drawable.skin_aio_panel_icon_bg;
        } else {
            i3 = R.drawable.qui_common_bg_nav_bottom_aio_bg;
        }
        aIOUtil.G(f16, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(AIOShortcutBarVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Drawable drawable = ContextCompat.getDrawable(this$0.getMContext(), R.drawable.skin_aio_panel_icon_bg);
        if (drawable != null) {
            Pair<Drawable, Drawable> immersiveDrawable = ((IAIOImmersiveApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOImmersiveApi.class)).getImmersiveDrawable(this$0.getMContext(), drawable, this$0.g1());
            AIOUtil.f194084a.F(this$0.f1(), immersiveDrawable.getFirst());
            this$0.sendIntent(new a.e(immersiveDrawable.getSecond()));
        }
    }

    private final void s1(int count) {
        f1().g(count);
    }

    private final void u1(int chatType, String peerUid) {
        View c16;
        if (com.tencent.mobileqq.aio.utils.f.f194152a.b(this.mChatType)) {
            return;
        }
        if ((chatType != 2 && chatType != 1) || (c16 = f1().c(1006)) == null) {
            return;
        }
        if (this.mPlusRedView == null) {
            this.mPlusRedView = ae.f352281b.f(getMContext(), c16);
        }
        if (QLog.isColorLevel()) {
            QLog.i("AIOShortcutBarVB", 1, "fetch normal plus icon red dot");
        }
        View view = this.mPlusRedView;
        if (view != null) {
            view.setTag(1006);
            view.setSelected(c16.isSelected());
            ae.f352281b.g(peerUid, chatType, view);
        }
    }

    private final void v1(Integer curPanelId, Boolean keyboardShow) {
        if (keyboardShow != null && keyboardShow.booleanValue()) {
            if (curPanelId == null) {
                f1().e();
            }
        } else if (curPanelId == null) {
            f1().e();
        } else {
            f1().setSelected(curPanelId.intValue());
        }
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void afterCreateVM(@Nullable BaseVM<a, AIOShortcutBarUIState, com.tencent.aio.api.runtime.a> mUIModel) {
        com.tencent.aio.api.runtime.a mContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) mUIModel);
            return;
        }
        super.afterCreateVM(mUIModel);
        if (mUIModel != null && (mContext = mUIModel.getMContext()) != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AIOShortcutBarVB", 4, "afterCreateVM");
            }
            com.tencent.mvi.base.route.j e16 = mContext.e();
            com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
            String a16 = jVar.a(Reflection.getOrCreateKotlinClass(ShortcutEventIntent.OnGetPlusIconViewIntent.class));
            b bVar = this.mActionR;
            LifecycleOwner d16 = mContext.d();
            Intrinsics.checkNotNullExpressionValue(d16, "it.lifecycleOwner");
            e16.g(a16, bVar, d16);
            com.tencent.mvi.base.route.j e17 = mContext.e();
            String a17 = jVar.a(Reflection.getOrCreateKotlinClass(ShortcutEventIntent.OnGetPlusIconPosIntent.class));
            b bVar2 = this.mActionR;
            LifecycleOwner d17 = mContext.d();
            Intrinsics.checkNotNullExpressionValue(d17, "it.lifecycleOwner");
            e17.g(a17, bVar2, d17);
            com.tencent.mvi.base.route.j e18 = mContext.e();
            String a18 = jVar.a(Reflection.getOrCreateKotlinClass(ShortcutEventIntent.OnGetIconBarHeightIntent.class));
            b bVar3 = this.mActionR;
            LifecycleOwner d18 = mContext.d();
            Intrinsics.checkNotNullExpressionValue(d18, "it.lifecycleOwner");
            e18.g(a18, bVar3, d18);
            com.tencent.mvi.base.route.j e19 = mContext.e();
            String a19 = jVar.a(Reflection.getOrCreateKotlinClass(ShortcutEventIntent.OnGetShortCutLayoutViewIntent.class));
            b bVar4 = this.mActionR;
            LifecycleOwner d19 = mContext.d();
            Intrinsics.checkNotNullExpressionValue(d19, "it.lifecycleOwner");
            e19.g(a19, bVar4, d19);
            com.tencent.mvi.base.route.j e26 = mContext.e();
            String a26 = jVar.a(Reflection.getOrCreateKotlinClass(ShortcutEventIntent.OnGetEmoIconViewIntent.class));
            b bVar5 = this.mActionR;
            LifecycleOwner d26 = mContext.d();
            Intrinsics.checkNotNullExpressionValue(d26, "it.lifecycleOwner");
            e26.g(a26, bVar5, d26);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.bindViewAndData();
        a.b bVar = new a.b(0, null, false, 7, null);
        sendIntent(bVar);
        f1().f(bVar.a(), bVar.c(), this);
        this.mPeerUid = bVar.c();
        this.mChatType = bVar.a();
        PanelIconLinearLayout f16 = f1();
        Boolean valueOf = Boolean.valueOf(com.tencent.mobileqq.aio.utils.f.f194152a.b(this.mChatType));
        f16.setVisibility(8);
        if (((View) au.a(valueOf, f16)) == null) {
            f16.setVisibility(0);
        }
        q1(l1(), bVar.b());
        this.mPlusIcon = f1().c(1006);
    }

    @Override // com.tencent.qqnt.aio.shortcutbar.h
    public boolean c0(@NotNull View view) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) view)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag();
        if (!(tag instanceof Integer)) {
            return false;
        }
        if (this.mIsGagMode) {
            QLog.i("AIOShortcutBarVB", 1, "[onPanelIconLongClick]: isGagMode");
            return false;
        }
        i iVar = this.mPanelClickListener;
        if (iVar != null && iVar.a(((Number) tag).intValue(), view.isSelected())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AIOShortcutBarVB", 4, "onPanelIconLongClick event is consumed by:" + this.mPanelClickListener);
            }
            return false;
        }
        sendIntent(new a.c(((Number) tag).intValue(), view.isSelected()));
        return true;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public AIOShortcutBarVM createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AIOShortcutBarVM) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new AIOShortcutBarVM();
    }

    public final int g1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return f1().getMeasuredHeight();
    }

    @Override // com.tencent.qqnt.aio.shortcutbar.d
    public int getMeasuredHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return getHostView().getMeasuredHeight();
    }

    @Override // com.tencent.qqnt.aio.shortcutbar.d
    public int getVisibility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return f1().getVisibility();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AIOShortcutBarUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOShortcutBarUIState.UpdateIconSelect) {
            AIOShortcutBarUIState.UpdateIconSelect updateIconSelect = (AIOShortcutBarUIState.UpdateIconSelect) state;
            v1(updateIconSelect.b(), updateIconSelect.a());
            return;
        }
        if (state instanceof AIOShortcutBarUIState.SetVisibility) {
            f1().setVisibility(((AIOShortcutBarUIState.SetVisibility) state).a());
            return;
        }
        if (state instanceof AIOShortcutBarUIState.ShotShortcutBar) {
            j1(((AIOShortcutBarUIState.ShotShortcutBar) state).a());
            return;
        }
        if (state instanceof AIOShortcutBarUIState.UpdateIconSelectUIState) {
            AIOShortcutBarUIState.UpdateIconSelectUIState updateIconSelectUIState = (AIOShortcutBarUIState.UpdateIconSelectUIState) state;
            p1(updateIconSelectUIState.b(), updateIconSelectUIState.a());
            return;
        }
        if (state instanceof AIOShortcutBarUIState.PhotoPanelMediaSelected) {
            s1(((AIOShortcutBarUIState.PhotoPanelMediaSelected) state).a());
            return;
        }
        if (state instanceof AIOShortcutBarUIState.UpdatePanelIcon) {
            AIOShortcutBarUIState.UpdatePanelIcon updatePanelIcon = (AIOShortcutBarUIState.UpdatePanelIcon) state;
            m1(updatePanelIcon.b(), updatePanelIcon.a());
            return;
        }
        if (state instanceof AIOShortcutBarUIState.SetInterceptListener) {
            f1().setInterceptListener(((AIOShortcutBarUIState.SetInterceptListener) state).a());
            return;
        }
        if (state instanceof AIOShortcutBarUIState.SetPanelClickListener) {
            this.mPanelClickListener = ((AIOShortcutBarUIState.SetPanelClickListener) state).a();
            return;
        }
        if (state instanceof AIOShortcutBarUIState.FetchPlusIconRedDot) {
            u1(this.mChatType, this.mPeerUid);
            return;
        }
        if (state instanceof AIOShortcutBarUIState.FetchEmoIconRedDot) {
            n1(this.mChatType, this.mPeerUid);
        } else if (state instanceof AIOShortcutBarUIState.IconEnableState) {
            o1(((AIOShortcutBarUIState.IconEnableState) state).a());
        } else if (state instanceof AIOShortcutBarUIState.PostThemeChanged) {
            q1(l1(), ((AIOShortcutBarUIState.PostThemeChanged) state).a());
        }
    }

    @Override // com.tencent.qqnt.aio.shortcutbar.h
    public void l0(@NotNull View view) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag();
        if (!(tag instanceof Integer)) {
            QLog.i("AIOShortcutBarVB", 1, "[onPanelIconClick]: tag is not int");
            return;
        }
        if (this.mIsGagMode) {
            QLog.i("AIOShortcutBarVB", 1, "[onPanelIconClick]: isGagMode");
            return;
        }
        HashMap hashMap = new HashMap();
        ae aeVar = ae.f352281b;
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        if (aeVar.d((View) parent)) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_red_tips", str);
        Number number = (Number) tag;
        hashMap.put("operation_entry", com.tencent.mobileqq.aio.utils.b.f194119a.f(number.intValue()));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_input_box_shortcut_bar", hashMap);
        i iVar = this.mPanelClickListener;
        boolean z17 = false;
        if (iVar != null && iVar.b(number.intValue(), view.isSelected())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AIOShortcutBarVB", 4, "onPanelIconClick event is consumed by:" + this.mPanelClickListener);
                return;
            }
            return;
        }
        if (this.mIsFromHotPic) {
            sendIntent(new a.C7358a(number.intValue(), false));
            this.mIsFromHotPic = false;
        } else {
            sendIntent(new a.C7358a(number.intValue(), view.isSelected()));
        }
        if (Intrinsics.areEqual(tag, (Object) 1006)) {
            z17 = view.isSelected();
        }
        i1(z17);
        View view2 = this.mPlusRedView;
        if (view2 != null && Intrinsics.areEqual(tag, (Object) 1006) && aeVar.d(view2) && !view.isSelected()) {
            QLog.i("AIOShortcutBarVB", 1, "close plus panel");
            u1(this.mChatType, this.mPeerUid);
        }
        View view3 = this.mEmoRedView;
        if (view3 != null && Intrinsics.areEqual(tag, (Object) 1001) && aeVar.d(view3)) {
            aeVar.b(view3);
            if (!view.isSelected()) {
                QLog.i("AIOShortcutBarVB", 1, "close emo panel");
                n1(this.mChatType, this.mPeerUid);
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return f1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        this.mPlusRedView = null;
        this.mEmoRedView = null;
        this.mIsGagMode = false;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) reuseParam);
        } else {
            Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
            o1(true);
        }
    }
}
