package com.tencent.kuikly.core.render.android.css.animation;

import android.util.ArrayMap;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\u001dB!\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010A\u001a\u00020)\u0012\b\u0010B\u001a\u0004\u0018\u00010?\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0001J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u000bJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012J\u0018\u0010\u0015\u001a\u00020\u00042\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012J\u0006\u0010\u0016\u001a\u00020\u0004R~\u0010#\u001a^\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\"\u0010-\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010/R\u0016\u00101\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010&R\u0016\u0010\r\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010&R\u0016\u00103\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010/R\u0016\u00104\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010/R\u0016\u00105\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010/R\u0016\u00107\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00106R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00108R&\u0010<\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020:098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010;R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010;R\u0016\u0010>\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00106R\u001c\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010,\u00a8\u0006E"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/KRCSSAnimation;", "", "Lcom/tencent/kuikly/core/render/android/css/animation/c;", "handler", "", "i", "", "animation", "l", "o", "propKey", "", "p", "animationType", "finalValue", "d", tl.h.F, "k", "", "e", "cancelAnimationKeys", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "hrAnimation", IXWebBroadcastListener.STAGE_FINISHED, "animationKey", "a", "Lkotlin/jvm/functions/Function4;", "j", "()Lkotlin/jvm/functions/Function4;", DomainData.DOMAIN_NAME, "(Lkotlin/jvm/functions/Function4;)V", "onAnimationEndBlock", "", "b", "I", "animationRunningCount", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "c", "Ljava/lang/ref/WeakReference;", "weakView", "", UserInfo.SEX_FEMALE, "duration", "timingFuncType", "g", "damping", "velocity", "delay", "Z", "repeatForever", "Ljava/lang/String;", "Landroid/util/ArrayMap;", "Lkotlin/Function0;", "Landroid/util/ArrayMap;", "supportAnimationHandlerCreator", "animationOperationMap", "animationCommit", "Lcom/tencent/kuikly/core/render/android/a;", "contextWeakRef", "view", "context", "<init>", "(Ljava/lang/String;Landroid/view/View;Lcom/tencent/kuikly/core/render/android/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRCSSAnimation {

    /* renamed from: p, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    @Nullable
    private Function4<? super KRCSSAnimation, ? super Boolean, ? super String, ? super String, Unit> onAnimationEndBlock;

    /* renamed from: b, reason: from kotlin metadata */
    private int animationRunningCount;

    /* renamed from: c, reason: from kotlin metadata */
    private final WeakReference<View> weakView;

    /* renamed from: d */
    private float duration;

    /* renamed from: e, reason: from kotlin metadata */
    private int timingFuncType;

    /* renamed from: f, reason: from kotlin metadata */
    private int animationType;

    /* renamed from: g */
    private float damping;

    /* renamed from: h */
    private float velocity;

    /* renamed from: i */
    private float delay;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean repeatForever;

    /* renamed from: k, reason: from kotlin metadata */
    private String animationKey;

    /* renamed from: l, reason: from kotlin metadata */
    private final ArrayMap<String, Function0<c>> supportAnimationHandlerCreator;

    /* renamed from: m */
    private final ArrayMap<String, c> animationOperationMap;

    /* renamed from: n */
    private boolean animationCommit;

    /* renamed from: o, reason: from kotlin metadata */
    private final WeakReference<com.tencent.kuikly.core.render.android.a> contextWeakRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/animation/KRCSSAnimation$a;", "", "", "ANIMATION_KEY_INDEX", "I", "ANIMATION_TYPE_INDEX", "DAMPING_INDEX", "DELAY_INDEX", "DURATION_INDEX", "REPEAT_INDEX", "SPRING_ANIMATION_TYPE", "TIMING_FUNC_TYPE_INDEX", "VELOCITY_INDEX", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.css.animation.KRCSSAnimation$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KRCSSAnimation(@NotNull String animation, @NotNull View view, @Nullable com.tencent.kuikly.core.render.android.a aVar) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(view, "view");
        this.weakView = new WeakReference<>(view);
        this.animationKey = "";
        this.supportAnimationHandlerCreator = new ArrayMap<>();
        this.animationOperationMap = new ArrayMap<>();
        this.contextWeakRef = new WeakReference<>(aVar);
        l(animation);
        o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(KRCSSAnimation kRCSSAnimation, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = null;
        }
        kRCSSAnimation.f(list);
    }

    private final void i(c handler) {
        handler.j(this.duration);
        handler.i(this.delay);
        handler.n(this.repeatForever);
        if (handler instanceof KRCSSSpringAnimationHandler) {
            KRCSSSpringAnimationHandler kRCSSSpringAnimationHandler = (KRCSSSpringAnimationHandler) handler;
            kRCSSSpringAnimationHandler.s(this.damping);
            kRCSSSpringAnimationHandler.t(this.velocity);
        } else if (handler instanceof e) {
            handler.j(this.duration);
            ((e) handler).u(this.timingFuncType);
        }
    }

    private final void l(String animation) {
        List split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) animation, new String[]{" "}, false, 0, 6, (Object) null);
        boolean z16 = false;
        this.animationType = Integer.parseInt((String) split$default.get(0));
        this.timingFuncType = Integer.parseInt((String) split$default.get(1));
        this.duration = Float.parseFloat((String) split$default.get(2));
        this.damping = Float.parseFloat((String) split$default.get(3));
        this.velocity = com.tencent.kuikly.core.render.android.css.ktx.b.I(this.contextWeakRef.get(), Float.parseFloat((String) split$default.get(4)));
        if (split$default.size() > 5) {
            this.delay = Float.parseFloat((String) split$default.get(5));
        }
        if (split$default.size() > 6) {
            if (Integer.parseInt((String) split$default.get(6)) == 1) {
                z16 = true;
            }
            this.repeatForever = z16;
        }
        if (split$default.size() > 7) {
            this.animationKey = (String) split$default.get(7);
        }
    }

    private final void o() {
        final boolean z16 = true;
        if (this.animationType != 1) {
            z16 = false;
        }
        this.supportAnimationHandlerCreator.put("opacity", new Function0<c>() { // from class: com.tencent.kuikly.core.render.android.css.animation.KRCSSAnimation$setupAnimationHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                return z16 ? new l() : new h();
            }
        });
        this.supportAnimationHandlerCreator.put("transform", new Function0<c>() { // from class: com.tencent.kuikly.core.render.android.css.animation.KRCSSAnimation$setupAnimationHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                return z16 ? new m() : new i();
            }
        });
        this.supportAnimationHandlerCreator.put("backgroundColor", new Function0<c>() { // from class: com.tencent.kuikly.core.render.android.css.animation.KRCSSAnimation$setupAnimationHandler$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                return z16 ? new j() : new f();
            }
        });
        this.supportAnimationHandlerCreator.put(AIInput.KEY_FRAME, new Function0<c>() { // from class: com.tencent.kuikly.core.render.android.css.animation.KRCSSAnimation$setupAnimationHandler$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                return z16 ? new k() : new g();
            }
        });
    }

    public final void d(@NotNull String animationType, @NotNull Object finalValue) {
        c invoke;
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        Intrinsics.checkNotNullParameter(finalValue, "finalValue");
        Function0<c> function0 = this.supportAnimationHandlerCreator.get(animationType);
        if (function0 != null && (invoke = function0.invoke()) != null) {
            invoke.k(finalValue);
            invoke.m(animationType);
            this.animationOperationMap.put(animationType, invoke);
        }
    }

    @NotNull
    public final List<String> e() {
        ArrayMap<String, c> arrayMap = this.animationOperationMap;
        ArrayList arrayList = new ArrayList(arrayMap.size());
        Iterator<Map.Entry<String, c>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue().getPropKey());
        }
        return arrayList;
    }

    public final void f(@Nullable List<String> cancelAnimationKeys) {
        Collection<c> values = this.animationOperationMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "animationOperationMap.values");
        for (c cVar : values) {
            if (cancelAnimationKeys != null) {
                if (cVar.f() && cancelAnimationKeys.contains(cVar.getPropKey())) {
                    cVar.l(true);
                    cVar.a();
                }
            } else {
                cVar.a();
            }
        }
    }

    public final void h() {
        if (this.animationCommit) {
            return;
        }
        this.animationCommit = true;
        View view = this.weakView.get();
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(view, "weakView.get() ?: return");
            Collection<c> values = this.animationOperationMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "animationOperationMap.values");
            for (c value : values) {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                i(value);
                value.o(view, new Function2<Boolean, String, Unit>() { // from class: com.tencent.kuikly.core.render.android.css.animation.KRCSSAnimation$commitAnimation$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                        invoke(bool.booleanValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, @NotNull String propKey) {
                        int i3;
                        String str;
                        Intrinsics.checkNotNullParameter(propKey, "propKey");
                        KRCSSAnimation kRCSSAnimation = KRCSSAnimation.this;
                        i3 = kRCSSAnimation.animationRunningCount;
                        kRCSSAnimation.animationRunningCount = i3 - 1;
                        Function4<KRCSSAnimation, Boolean, String, String, Unit> j3 = KRCSSAnimation.this.j();
                        if (j3 != null) {
                            KRCSSAnimation kRCSSAnimation2 = KRCSSAnimation.this;
                            Boolean valueOf = Boolean.valueOf(z16);
                            str = KRCSSAnimation.this.animationKey;
                            j3.invoke(kRCSSAnimation2, valueOf, propKey, str);
                        }
                    }
                });
                this.animationRunningCount++;
            }
        }
    }

    @Nullable
    public final Function4<KRCSSAnimation, Boolean, String, String, Unit> j() {
        return this.onAnimationEndBlock;
    }

    public final boolean k() {
        if (this.animationRunningCount > 0) {
            return true;
        }
        return false;
    }

    public final void m() {
        View view = this.weakView.get();
        if (view != null) {
            KRCSSViewExtensionKt.E(view, this);
        }
    }

    public final void n(@Nullable Function4<? super KRCSSAnimation, ? super Boolean, ? super String, ? super String, Unit> function4) {
        this.onAnimationEndBlock = function4;
    }

    public final boolean p(@NotNull String propKey) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        return this.supportAnimationHandlerCreator.containsKey(propKey);
    }
}
