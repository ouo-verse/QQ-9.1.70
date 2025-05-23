package com.tencent.mobileqq.troop.troopsquare.home.part;

import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopsquare.home.view.GestureDetectorRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/part/b;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", "root", "", "onInitView", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "dismiss", "e", "undoDismiss", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> dismiss;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> undoDismiss;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J(\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/home/part/b$a", "Lcom/tencent/mobileqq/troop/troopsquare/home/a;", "Lcom/tencent/mobileqq/troop/troopsquare/home/e;", "Landroid/view/MotionEvent;", "startEvent", "nowEvent", "", "b", "", "velocityX", "velocityY", "onFling", "onCancel", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends com.tencent.mobileqq.troop.troopsquare.home.a implements com.tencent.mobileqq.troop.troopsquare.home.e {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f301630b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f301631c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f301632d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(RelativeLayout relativeLayout, int i3, b bVar, com.tencent.mobileqq.troop.troopsquare.home.d[] dVarArr) {
            super(dVarArr);
            this.f301630b = relativeLayout;
            this.f301631c = i3;
            this.f301632d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, relativeLayout, Integer.valueOf(i3), bVar, dVarArr);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopsquare.home.f
        public void b(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) startEvent, (Object) nowEvent);
                return;
            }
            Intrinsics.checkNotNullParameter(startEvent, "startEvent");
            Intrinsics.checkNotNullParameter(nowEvent, "nowEvent");
            this.f301630b.setTranslationY(Math.max(nowEvent.getY() - startEvent.getY(), 0.0f));
        }

        @Override // com.tencent.mobileqq.troop.troopsquare.home.f
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f301632d.undoDismiss.invoke();
            }
        }

        @Override // com.tencent.mobileqq.troop.troopsquare.home.f
        public void onFling(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent, float velocityX, float velocityY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, startEvent, nowEvent, Float.valueOf(velocityX), Float.valueOf(velocityY));
                return;
            }
            Intrinsics.checkNotNullParameter(startEvent, "startEvent");
            Intrinsics.checkNotNullParameter(nowEvent, "nowEvent");
            if (this.f301630b.getTranslationY() > this.f301631c / 4) {
                this.f301632d.dismiss.invoke();
            } else {
                this.f301632d.undoDismiss.invoke();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J(\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/home/part/b$b", "Lcom/tencent/mobileqq/troop/troopsquare/home/a;", "Lcom/tencent/mobileqq/troop/troopsquare/home/e;", "Landroid/view/MotionEvent;", "startEvent", "nowEvent", "", "b", "", "velocityX", "velocityY", "onFling", "onCancel", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.home.part.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8828b extends com.tencent.mobileqq.troop.troopsquare.home.a implements com.tencent.mobileqq.troop.troopsquare.home.e {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f301633b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f301634c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f301635d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f301636e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C8828b(RelativeLayout relativeLayout, int i3, int i16, b bVar, com.tencent.mobileqq.troop.troopsquare.home.d[] dVarArr) {
            super(dVarArr);
            this.f301633b = relativeLayout;
            this.f301634c = i3;
            this.f301635d = i16;
            this.f301636e = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, relativeLayout, Integer.valueOf(i3), Integer.valueOf(i16), bVar, dVarArr);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopsquare.home.f
        public void b(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) startEvent, (Object) nowEvent);
                return;
            }
            Intrinsics.checkNotNullParameter(startEvent, "startEvent");
            Intrinsics.checkNotNullParameter(nowEvent, "nowEvent");
            this.f301633b.setTranslationY(Math.max(((Math.max(nowEvent.getX() - startEvent.getX(), 0.0f) / this.f301634c) * this.f301635d) + Math.max(nowEvent.getY() - startEvent.getY(), 0.0f), 0.0f));
        }

        @Override // com.tencent.mobileqq.troop.troopsquare.home.f
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f301636e.undoDismiss.invoke();
            }
        }

        @Override // com.tencent.mobileqq.troop.troopsquare.home.f
        public void onFling(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent, float velocityX, float velocityY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, startEvent, nowEvent, Float.valueOf(velocityX), Float.valueOf(velocityY));
                return;
            }
            Intrinsics.checkNotNullParameter(startEvent, "startEvent");
            Intrinsics.checkNotNullParameter(nowEvent, "nowEvent");
            if (this.f301633b.getTranslationY() > this.f301635d / 4) {
                this.f301636e.dismiss.invoke();
            } else {
                this.f301636e.undoDismiss.invoke();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/home/part/b$c", "Lcom/tencent/mobileqq/troop/troopsquare/home/d;", "Landroid/view/MotionEvent;", "startEvent", "nowEvent", "", "velocityX", "velocityY", "", "c", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements com.tencent.mobileqq.troop.troopsquare.home.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppBarLayout f301637a;

        c(AppBarLayout appBarLayout) {
            this.f301637a = appBarLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appBarLayout);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopsquare.home.d
        public boolean a(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent) {
            CoordinatorLayout.LayoutParams layoutParams;
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) startEvent, (Object) nowEvent)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(startEvent, "startEvent");
            Intrinsics.checkNotNullParameter(nowEvent, "nowEvent");
            ViewGroup.LayoutParams layoutParams2 = this.f301637a.getLayoutParams();
            AppBarLayout.Behavior behavior = null;
            if (layoutParams2 instanceof CoordinatorLayout.LayoutParams) {
                layoutParams = (CoordinatorLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                obj = layoutParams.getBehavior();
            } else {
                obj = null;
            }
            if (obj instanceof AppBarLayout.Behavior) {
                behavior = (AppBarLayout.Behavior) obj;
            }
            if (behavior == null || behavior.getTopAndBottomOffset() != 0) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.troop.troopsquare.home.d
        public boolean c(@NotNull MotionEvent startEvent, @NotNull MotionEvent nowEvent, float velocityX, float velocityY) {
            CoordinatorLayout.LayoutParams layoutParams;
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, startEvent, nowEvent, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
            }
            Intrinsics.checkNotNullParameter(startEvent, "startEvent");
            Intrinsics.checkNotNullParameter(nowEvent, "nowEvent");
            ViewGroup.LayoutParams layoutParams2 = this.f301637a.getLayoutParams();
            AppBarLayout.Behavior behavior = null;
            if (layoutParams2 instanceof CoordinatorLayout.LayoutParams) {
                layoutParams = (CoordinatorLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                obj = layoutParams.getBehavior();
            } else {
                obj = null;
            }
            if (obj instanceof AppBarLayout.Behavior) {
                behavior = (AppBarLayout.Behavior) obj;
            }
            if (behavior != null && behavior.getTopAndBottomOffset() == 0) {
                return true;
            }
            return false;
        }
    }

    public b(@NotNull Function0<Unit> dismiss, @NotNull Function0<Unit> undoDismiss) {
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        Intrinsics.checkNotNullParameter(undoDismiss, "undoDismiss");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dismiss, (Object) undoDismiss);
        } else {
            this.dismiss = dismiss;
            this.undoDismiss = undoDismiss;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View root) {
        List<? extends com.tencent.mobileqq.troop.troopsquare.home.e> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) root);
            return;
        }
        Intrinsics.checkNotNullParameter(root, "root");
        super.onInitView(root);
        int screenWidth = ImmersiveUtils.getScreenWidth();
        int screenHeight = ImmersiveUtils.getScreenHeight();
        View findViewById = root.findViewById(R.id.uln);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.draggable_layout)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        View findViewById2 = root.findViewById(R.id.sqk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.app_bar_layout)");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById2;
        appBarLayout.setOutlineProvider(null);
        appBarLayout.setBackground(new ColorDrawable(0));
        View findViewById3 = root.findViewById(R.id.vnn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.gesture_detector)");
        GestureDetectorRelativeLayout gestureDetectorRelativeLayout = (GestureDetectorRelativeLayout) findViewById3;
        View findViewById4 = gestureDetectorRelativeLayout.findViewById(R.id.uoj);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "gestureDetectorLayout.fi\u2026Id(R.id.drop_right_start)");
        View findViewById5 = gestureDetectorRelativeLayout.findViewById(R.id.uoi);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "gestureDetectorLayout.fi\u2026yId(R.id.drop_down_start)");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.troop.troopsquare.home.e[]{new a(relativeLayout, screenHeight, this, new com.tencent.mobileqq.troop.troopsquare.home.d[]{new com.tencent.mobileqq.troop.troopsquare.home.b(new com.tencent.mobileqq.troop.troopsquare.home.g(findViewById5), new c(appBarLayout)), new com.tencent.mobileqq.troop.troopsquare.home.c(90.0d)}), new C8828b(relativeLayout, screenWidth, screenHeight, this, new com.tencent.mobileqq.troop.troopsquare.home.d[]{new com.tencent.mobileqq.troop.troopsquare.home.g(findViewById4), new com.tencent.mobileqq.troop.troopsquare.home.c(0.0d)})});
        gestureDetectorRelativeLayout.setGestureHandlers(listOf);
        View findViewById6 = root.findViewById(R.id.a47);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.back_btn)");
        findViewById6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.B9(b.this, view);
            }
        });
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getActivity());
        View findViewById7 = root.findViewById(R.id.jp7);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById<View>(R.id.title_layout)");
        findViewById7.setPadding(findViewById7.getPaddingLeft(), statusBarHeight, findViewById7.getPaddingRight(), findViewById7.getPaddingBottom());
        ViewGroup.LayoutParams layoutParams = findViewById5.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = statusBarHeight;
            findViewById5.setLayoutParams(marginLayoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
