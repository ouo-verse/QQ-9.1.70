package com.tencent.mobileqq.guild.util.trace;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u00029:B\u0017\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u0010+\u001a\u00020\u0006\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u001b\u00100\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b,\u0010-*\u0004\b.\u0010/R\u0014\u00103\u001a\u00020#8CX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/util/trace/GuildTraceSwitchFloat;", "Landroid/widget/LinearLayout;", "", "t", "Landroid/animation/ValueAnimator;", DomainData.DOMAIN_NAME, "", "p", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "d", "Landroid/view/View;", "menuIconView", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "menuContainer", "Lkotlin/Lazy;", "f", "Lkotlin/Lazy;", "animatorDelegate", "Landroid/view/animation/Interpolator;", tl.h.F, "Landroid/view/animation/Interpolator;", "defaultInterpolator", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/util/trace/l;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "menuInfos", "Landroid/view/WindowManager;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/WindowManager;", "windowManager", "Landroid/view/WindowManager$LayoutParams;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/WindowManager$LayoutParams;", "params", "D", "I", "touchSlop", "E", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/animation/ValueAnimator;", "getAnimator$delegate", "(Lcom/tencent/mobileqq/guild/util/trace/GuildTraceSwitchFloat;)Ljava/lang/Object;", "animator", "r", "()Landroid/view/WindowManager$LayoutParams;", "windowLayoutParams", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I)V", UserInfo.SEX_FEMALE, "b", "c", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildTraceSwitchFloat extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final WindowManager.LayoutParams params;

    /* renamed from: D, reason: from kotlin metadata */
    private final int touchSlop;

    /* renamed from: E, reason: from kotlin metadata */
    private final int y;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View menuIconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup menuContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<ValueAnimator> animatorDelegate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Interpolator defaultInterpolator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<l> menuInfos;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WindowManager windowManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/util/trace/GuildTraceSwitchFloat$a", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "", "d", UserInfo.SEX_FEMALE, "downX", "e", "downY", "f", "lastY", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float downX;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float downY;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float lastY;

        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
            int coerceAtLeast;
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            int action = event.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        GuildTraceSwitchFloat.this.params.y = (int) (r5.y + (event.getRawY() - this.lastY));
                        WindowManager.LayoutParams layoutParams = GuildTraceSwitchFloat.this.params;
                        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, GuildTraceSwitchFloat.this.params.y);
                        layoutParams.y = coerceAtLeast;
                        WindowManager windowManager = GuildTraceSwitchFloat.this.windowManager;
                        GuildTraceSwitchFloat guildTraceSwitchFloat = GuildTraceSwitchFloat.this;
                        windowManager.updateViewLayout(guildTraceSwitchFloat, guildTraceSwitchFloat.params);
                        this.lastY = event.getRawY();
                    }
                } else if (Math.abs(event.getRawX() - this.downX) < GuildTraceSwitchFloat.this.touchSlop && Math.abs(event.getRawY() - this.downY) < GuildTraceSwitchFloat.this.touchSlop) {
                    try {
                        Field declaredField = View.class.getDeclaredField("mListenerInfo");
                        GuildTraceSwitchFloat guildTraceSwitchFloat2 = GuildTraceSwitchFloat.this;
                        declaredField.setAccessible(true);
                        Object obj = declaredField.get(guildTraceSwitchFloat2.menuIconView);
                        Intrinsics.checkNotNull(obj);
                        Field declaredField2 = obj.getClass().getDeclaredField("mOnClickListener");
                        declaredField2.setAccessible(true);
                        Object obj2 = declaredField2.get(obj);
                        if (obj2 instanceof View.OnClickListener) {
                            ((View.OnClickListener) obj2).onClick(guildTraceSwitchFloat2.menuIconView);
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            } else {
                this.downX = event.getRawX();
                float rawY = event.getRawY();
                this.downY = rawY;
                this.lastY = rawY;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/util/trace/GuildTraceSwitchFloat$c;", "Landroid/animation/TimeInterpolator;", "", "input", "getInterpolation", "a", "Landroid/animation/TimeInterpolator;", "mWrappedInterpolator", "<init>", "(Landroid/animation/TimeInterpolator;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements TimeInterpolator {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TimeInterpolator mWrappedInterpolator;

        public c(@NotNull TimeInterpolator mWrappedInterpolator) {
            Intrinsics.checkNotNullParameter(mWrappedInterpolator, "mWrappedInterpolator");
            this.mWrappedInterpolator = mWrappedInterpolator;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            return this.mWrappedInterpolator.getInterpolation(Math.abs(input - 1.0f));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/util/trace/GuildTraceSwitchFloat$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f235670e;

        d(boolean z16) {
            this.f235670e = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (!this.f235670e) {
                GuildTraceSwitchFloat.this.menuContainer.setVisibility(8);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            GuildTraceSwitchFloat.this.menuContainer.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTraceSwitchFloat(@NotNull final Context context, int i3) {
        super(context);
        Lazy<ValueAnimator> lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ValueAnimator>() { // from class: com.tencent.mobileqq.guild.util.trace.GuildTraceSwitchFloat$animatorDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ValueAnimator invoke() {
                ValueAnimator n3;
                n3 = GuildTraceSwitchFloat.this.n();
                return n3;
            }
        });
        this.animatorDelegate = lazy;
        this.defaultInterpolator = new AccelerateDecelerateInterpolator();
        ArrayList<l> arrayList = new ArrayList<>();
        this.menuInfos = arrayList;
        this.params = new WindowManager.LayoutParams();
        View.inflate(context, R.layout.f_6, this);
        setGravity(16);
        this.y = i3;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        View findViewById = findViewById(R.id.eq5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.menu_icon)");
        this.menuIconView = findViewById;
        View findViewById2 = findViewById(R.id.epy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.menu_container)");
        this.menuContainer = (ViewGroup) findViewById2;
        arrayList.add(new l("\u5f00\u59cb\u91c7\u6837", R.drawable.coo, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.util.trace.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildTraceSwitchFloat.e(context, view);
            }
        }));
        arrayList.add(new l("\u7ed3\u675f\u91c7\u6837", R.drawable.coo, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.util.trace.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildTraceSwitchFloat.f(context, view);
            }
        }));
        for (l lVar : arrayList) {
            MenuItem menuItem = new MenuItem(context, null, 0, 6, null);
            menuItem.b(lVar);
            this.menuContainer.addView(menuItem);
        }
        this.menuIconView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.util.trace.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildTraceSwitchFloat.g(GuildTraceSwitchFloat.this, view);
            }
        });
        this.menuIconView.setOnTouchListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("startMethodTracingSampling");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.comm.GuildTraceSwitchFloat", 1, (String) it.next(), null);
        }
        QQToast.makeText(context, "\u5f00\u59cb\u91c7\u6837", 0).show();
        TraceUtils.f235403a.q("channellist", 1000);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("stopMethodTrace");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.comm.GuildTraceSwitchFloat", 1, (String) it.next(), null);
        }
        QQToast.makeText(context, "\u7ed3\u675f\u91c7\u6837", 0).show();
        TraceUtils.f235403a.r();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GuildTraceSwitchFloat this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ValueAnimator n() {
        ValueAnimator animator = ValueAnimator.ofInt(-this.menuContainer.getWidth(), 0);
        animator.setDuration(400L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.util.trace.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuildTraceSwitchFloat.o(GuildTraceSwitchFloat.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return animator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(GuildTraceSwitchFloat this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        ViewGroup viewGroup = this$0.menuContainer;
        Intrinsics.checkNotNull(animation.getAnimatedValue(), "null cannot be cast to non-null type kotlin.Int");
        viewGroup.setTranslationX(((Integer) r2).intValue());
    }

    private final ValueAnimator q() {
        return this.animatorDelegate.getValue();
    }

    @SuppressLint({"WrongConstant"})
    private final WindowManager.LayoutParams r() {
        WindowManager.LayoutParams layoutParams = this.params;
        layoutParams.width = -2;
        layoutParams.height = -2;
        if (Build.VERSION.SDK_INT < 26) {
            layoutParams.type = 2003;
        } else {
            layoutParams.type = 2038;
        }
        layoutParams.flags = 8;
        layoutParams.format = -3;
        layoutParams.gravity = 51;
        layoutParams.x = 10;
        layoutParams.y = this.y;
        return layoutParams;
    }

    private final void t() {
        boolean z16;
        TimeInterpolator cVar;
        if (this.menuContainer.getTranslationX() <= (-this.menuContainer.getWidth())) {
            z16 = true;
        } else {
            z16 = false;
        }
        ValueAnimator q16 = q();
        if (z16) {
            cVar = this.defaultInterpolator;
        } else {
            cVar = new c(this.defaultInterpolator);
        }
        q16.setInterpolator(cVar);
        q().removeAllListeners();
        q().addListener(new d(z16));
        q().start();
    }

    public final int p() {
        try {
            this.windowManager.removeView(this);
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "dismiss exception:" + e16.getMessage();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.comm.GuildTraceSwitchFloat", 1, (String) it.next(), null);
            }
        }
        return this.params.y;
    }

    public final void s() {
        try {
            this.windowManager.addView(this, r());
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "show exception:" + e16.getMessage();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.comm.GuildTraceSwitchFloat", 1, (String) it.next(), null);
            }
        }
    }
}
