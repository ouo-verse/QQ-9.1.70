package com.tencent.frame.panelcontainer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001HB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b@\u0010AB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010C\u001a\u0004\u0018\u00010B\u00a2\u0006\u0004\b@\u0010DB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010C\u001a\u0004\u0018\u00010B\u0012\u0006\u0010E\u001a\u00020\t\u00a2\u0006\u0004\b@\u0010FJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\u0004H\u0014J\b\u0010\u0013\u001a\u00020\u0004H\u0014J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0004J\u0010\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0006R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001bR\u0018\u00102\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001bR \u00107\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\u00a8\u0006I"}, d2 = {"Lcom/tencent/frame/panelcontainer/PanelContainerLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "f", "", ViewStickEventHelper.IS_SHOW, "i", "", "curKeyboardHeight", h.F, "Lcom/tencent/frame/panelcontainer/c;", "panelContainerApi", "setPanelContainerApi", "Lcom/tencent/frame/panelcontainer/d;", "listener", "setPanelContainerListener", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "needAnim", "e", "d", "c", "I", "mNormalKeyboardHeight", "mNormalPanelHeight", "mInMultiWindowModePanelHeight", "mOrientation", "mScreenWidthDp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mScreenHeightDp", BdhLogUtil.LogTag.Tag_Conn, "mCurStatus", "Lcom/tencent/frame/panelcontainer/b;", "D", "Lcom/tencent/frame/panelcontainer/b;", "mKeyboardHeightApi", "E", "Z", "mIsInMultiWindowMode", UserInfo.SEX_FEMALE, "mIsShowKeyboard", "G", "mCurKeyboardHeight", "H", "Ljava/lang/Integer;", "mCurPanelId", "mCurPanelHeight", "Lkotlin/Function1;", "J", "Lkotlin/jvm/functions/Function1;", "mKeyboardHeightChangedListener", "Lpz0/a;", "K", "Lpz0/a;", "getMmkvAdapter", "()Lpz0/a;", "setMmkvAdapter", "(Lpz0/a;)V", "mmkvAdapter", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "input-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class PanelContainerLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int mCurStatus;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b mKeyboardHeightApi;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsInMultiWindowMode;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsShowKeyboard;

    /* renamed from: G, reason: from kotlin metadata */
    private int mCurKeyboardHeight;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Integer mCurPanelId;

    /* renamed from: I, reason: from kotlin metadata */
    private int mCurPanelHeight;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> mKeyboardHeightChangedListener;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private pz0.a mmkvAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mNormalKeyboardHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mNormalPanelHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mInMultiWindowModePanelHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mOrientation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mScreenWidthDp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mScreenHeightDp;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/frame/panelcontainer/PanelContainerLayout$a;", "", "", "DEFAULT_IN_MULTI_WINDOW_MODE_PANEL_HEIGHT", "I", "DEFAULT_KEYBOARD_HEIGHT", "STATUS_KEYBOARD", "STATUS_NONE", "STATUS_PANEL", "<init>", "()V", "input-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.frame.panelcontainer.PanelContainerLayout$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43934);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelContainerLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.mKeyboardHeightApi = new b();
        this.mKeyboardHeightChangedListener = new Function1<Integer, Unit>() { // from class: com.tencent.frame.panelcontainer.PanelContainerLayout$mKeyboardHeightChangedListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PanelContainerLayout.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    PanelContainerLayout.this.h(i3);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
            }
        };
        f(context);
    }

    private final void f(Context context) {
        boolean isInMultiWindowMode;
        float f16 = context.getResources().getDisplayMetrics().density;
        int b16 = com.tencent.input.base.panelcontainer.keyboard.e.b(com.tencent.input.base.panelcontainer.keyboard.e.f116886a, this.mmkvAdapter, 0, 2, null);
        this.mNormalKeyboardHeight = b16;
        if (b16 == 0) {
            this.mNormalKeyboardHeight = (int) (250 * f16);
        }
        this.mNormalPanelHeight = this.mNormalKeyboardHeight;
        if (Build.VERSION.SDK_INT >= 24 && (context instanceof Activity)) {
            isInMultiWindowMode = ((Activity) context).isInMultiWindowMode();
            this.mIsInMultiWindowMode = isInMultiWindowMode;
        }
        this.mInMultiWindowModePanelHeight = (int) (f16 * 190);
        this.mOrientation = context.getResources().getConfiguration().orientation;
        this.mScreenWidthDp = context.getResources().getConfiguration().screenWidthDp;
        this.mScreenHeightDp = context.getResources().getConfiguration().screenHeightDp;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.frame.panelcontainer.e
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                PanelContainerLayout.g(PanelContainerLayout.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(PanelContainerLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mCurPanelHeight != this$0.getHeight()) {
            this$0.mCurPanelHeight = this$0.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int curKeyboardHeight) {
        boolean z16;
        if (this.mCurKeyboardHeight == curKeyboardHeight) {
            return;
        }
        if (curKeyboardHeight > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsShowKeyboard = z16;
        this.mCurKeyboardHeight = curKeyboardHeight;
        if (z16) {
            e(false);
            this.mCurStatus = 1;
            if (!this.mIsInMultiWindowMode) {
                int i3 = this.mCurKeyboardHeight;
                this.mNormalPanelHeight = i3;
                this.mNormalKeyboardHeight = i3;
                com.tencent.input.base.panelcontainer.keyboard.e.e(com.tencent.input.base.panelcontainer.keyboard.e.f116886a, this.mmkvAdapter, i3, 0, 4, null);
                return;
            }
            return;
        }
        if (this.mCurStatus == 1) {
            this.mCurStatus = 0;
        }
    }

    public final void c(boolean needAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, needAnim);
        } else {
            d();
            e(needAnim);
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public final void e(boolean needAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, needAnim);
            return;
        }
        if (this.mCurStatus == 2 && this.mCurPanelId != null) {
            if (needAnim) {
                i(false);
            } else {
                getLayoutParams().height = 0;
                requestLayout();
            }
            this.mCurStatus = 0;
            this.mCurPanelId = -1;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Activity activity;
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (window = activity.getWindow()) != null) {
            b bVar = this.mKeyboardHeightApi;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            bVar.e(window, context2, this.mKeyboardHeightChangedListener);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) newConfig);
            return;
        }
        super.onConfigurationChanged(newConfig);
        if (newConfig != null) {
            int i3 = newConfig.screenWidthDp;
            if (i3 != this.mScreenWidthDp || newConfig.screenHeightDp != this.mScreenHeightDp || newConfig.orientation != this.mOrientation) {
                this.mOrientation = newConfig.orientation;
                this.mScreenWidthDp = i3;
                this.mScreenHeightDp = newConfig.screenHeightDp;
                c(false);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Activity activity;
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (window = activity.getWindow()) != null) {
            this.mKeyboardHeightApi.g(window);
        }
    }

    public final void setMmkvAdapter(@Nullable pz0.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.mmkvAdapter = aVar;
        }
    }

    public final void setPanelContainerApi(@NotNull c panelContainerApi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) panelContainerApi);
        } else {
            Intrinsics.checkNotNullParameter(panelContainerApi, "panelContainerApi");
        }
    }

    public final void setPanelContainerListener(@NotNull d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelContainerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mKeyboardHeightApi = new b();
        this.mKeyboardHeightChangedListener = new Function1<Integer, Unit>() { // from class: com.tencent.frame.panelcontainer.PanelContainerLayout$mKeyboardHeightChangedListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PanelContainerLayout.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    PanelContainerLayout.this.h(i3);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
            }
        };
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelContainerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mKeyboardHeightApi = new b();
        this.mKeyboardHeightChangedListener = new Function1<Integer, Unit>() { // from class: com.tencent.frame.panelcontainer.PanelContainerLayout$mKeyboardHeightChangedListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PanelContainerLayout.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i36) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    PanelContainerLayout.this.h(i36);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i36);
                }
            }
        };
        f(context);
    }

    private final void i(boolean isShow) {
    }
}
