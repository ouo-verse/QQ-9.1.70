package com.tencent.mobileqq.tux.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB!\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/tux/ui/a;", "Landroid/app/Dialog;", "Landroid/view/MotionEvent;", "event", "", BdhLogUtil.LogTag.Tag_Req, "", "initWindow", "onTouchEvent", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "qusHalfScreenFloatingView", "Landroid/widget/FrameLayout;", "D", "Landroid/widget/FrameLayout;", "mContainer", "Landroid/widget/ScrollView;", "E", "Landroid/widget/ScrollView;", "mScrollView", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$l;", "dismissListener", "<init>", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$l;)V", UserInfo.SEX_FEMALE, "b", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends ReportDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final QUSHalfScreenFloatingView qusHalfScreenFloatingView;

    /* renamed from: D, reason: from kotlin metadata */
    private FrameLayout mContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private ScrollView mScrollView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/tux/ui/a$a", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MIN_HEIGHT, NodeProps.MAX_HEIGHT, "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tux.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8853a extends e {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f303471e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f303472f;

        C8853a(Context context, View view) {
            this.f303471e = context;
            this.f303472f = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, context, view);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        /* renamed from: createContentView */
        public View getF57179d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            a aVar = a.this;
            FrameLayout frameLayout = new FrameLayout(a.this.getContext());
            Context context = this.f303471e;
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.setBackground(context.getResources().getDrawable(R.drawable.qui_common_bg_top_light_bg));
            aVar.mContainer = frameLayout;
            a aVar2 = a.this;
            ScrollView scrollView = new ScrollView(this.f303471e);
            View view = this.f303472f;
            scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            ViewParent parent = view.getParent();
            if (parent != null) {
                Intrinsics.checkNotNullExpressionValue(parent, "parent");
                ((ViewGroup) parent).removeView(view);
            }
            scrollView.addView(view);
            aVar2.mScrollView = scrollView;
            FrameLayout frameLayout2 = a.this.mContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                frameLayout2 = null;
            }
            ScrollView scrollView2 = a.this.mScrollView;
            if (scrollView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mScrollView");
                scrollView2 = null;
            }
            frameLayout2.addView(scrollView2);
            FrameLayout frameLayout3 = a.this.mContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                return null;
            }
            return frameLayout3;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return (this.f303471e.getResources().getDisplayMetrics().heightPixels * 4) / 5;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int minHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return (this.f303471e.getResources().getDisplayMetrics().heightPixels * 1) / 5;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/tux/ui/a$b;", "", "Landroid/content/Context;", "context", "Landroid/app/Activity;", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tux.ui.a$b, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final Activity b(Context context) {
            if (context == null) {
                return null;
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            return b(((ContextWrapper) context).getBaseContext());
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34716);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @NotNull View view, @Nullable QUSBaseHalfScreenFloatingView.l lVar) {
        super(context, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, view, lVar);
            return;
        }
        initWindow();
        setContentView(R.layout.e3i);
        View findViewById = findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        this.qusHalfScreenFloatingView = qUSHalfScreenFloatingView;
        qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        qUSHalfScreenFloatingView.setIsContentDraggable(false);
        qUSHalfScreenFloatingView.setQUSDragFloatController(new C8853a(context, view));
        if (lVar != null) {
            qUSHalfScreenFloatingView.setOnDismissListener(lVar);
        }
    }

    private final boolean R(MotionEvent event) {
        Activity b16 = INSTANCE.b(getContext());
        if (b16 != null && b16.dispatchTouchEvent(event)) {
            return true;
        }
        return false;
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        window.setSoftInputMode(32);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("TuxPopupDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (!super.onTouchEvent(event) && !R(event)) {
            return false;
        }
        return true;
    }
}
