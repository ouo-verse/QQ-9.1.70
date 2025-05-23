package com.tencent.ntcompose.animation;

import com.tencent.kuikly.core.base.AnimationType;
import com.tencent.kuikly.core.base.TimingFuncType;
import com.tencent.kuikly.core.base.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u00a2\u0006\u0004\b$\u0010%J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u001b\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0011\u0010\u0019R$\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\f\u0010\u0014R\"\u0010#\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/ntcompose/animation/d;", "", "Lcom/tencent/kuikly/core/base/b;", "d", "Lcom/tencent/ntcompose/animation/h;", "easing", "Lcom/tencent/kuikly/core/base/TimingFuncType;", "timingFuncType", "e", "", "toString", "Lcom/tencent/ntcompose/animation/a;", "a", "Lcom/tencent/ntcompose/animation/a;", "getAnimationSpec", "()Lcom/tencent/ntcompose/animation/a;", "animationSpec", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "lazyAnimationKey", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "finishedListener", "<set-?>", "animationKey", "", "I", "getMaxTimeout$ntcompose_release", "()I", "setMaxTimeout$ntcompose_release", "(I)V", "maxTimeout", "<init>", "(Lcom/tencent/ntcompose/animation/a;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a<?> animationSpec;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String lazyAnimationKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> finishedListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String animationKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int maxTimeout;

    public d(a<?> animationSpec, String str, Function0<Unit> function0) {
        int i3;
        int i16;
        int i17;
        int delay;
        int durationMillis;
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.animationSpec = animationSpec;
        this.lazyAnimationKey = str;
        this.finishedListener = function0;
        this.animationKey = "";
        i3 = e.f339163a;
        e.f339163a = i3 + 1;
        i16 = e.f339163a;
        this.animationKey = String.valueOf(i16);
        animationSpec = animationSpec instanceof j ? ((j) animationSpec).a() : animationSpec;
        if (animationSpec instanceof l) {
            l lVar = (l) animationSpec;
            delay = lVar.getDelayMillis();
            durationMillis = lVar.getDurationMillis();
        } else if (animationSpec instanceof m) {
            m mVar = (m) animationSpec;
            delay = mVar.getDelay();
            durationMillis = mVar.getDurationMillis();
        } else {
            i17 = 0;
            this.maxTimeout = i17;
        }
        i17 = (delay + durationMillis) * 5;
        this.maxTimeout = i17;
    }

    private final com.tencent.kuikly.core.base.b d() {
        Boolean bool;
        boolean repeatForever;
        boolean repeatForever2;
        Object obj = this.animationSpec;
        if (obj instanceof j) {
            j jVar = (j) obj;
            bool = Boolean.valueOf(jVar.getRepeatMode() == RepeatMode.Restart);
            obj = jVar.a();
        } else {
            bool = null;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            TimingFuncType f16 = f(this, lVar.getEasing(), null, 2, null);
            b.Companion companion = com.tencent.kuikly.core.base.b.INSTANCE;
            float durationMillis = lVar.getDurationMillis() / 1000.0f;
            float dampingRatio = lVar.getDampingRatio();
            float velocity = lVar.getVelocity();
            float delayMillis = lVar.getDelayMillis() / 1000.0f;
            if (bool != null) {
                repeatForever2 = bool.booleanValue();
            } else {
                repeatForever2 = lVar.getRepeatForever();
            }
            return companion.c(f16, durationMillis, dampingRatio, velocity, delayMillis, repeatForever2, this.animationKey);
        }
        if (!(obj instanceof m)) {
            return null;
        }
        m mVar = (m) obj;
        TimingFuncType e16 = e(mVar.getEasing(), mVar.getTimingFuncType());
        b.Companion companion2 = com.tencent.kuikly.core.base.b.INSTANCE;
        AnimationType animationType = AnimationType.PLAIN;
        float durationMillis2 = mVar.getDurationMillis() / 1000.0f;
        float delay = mVar.getDelay() / 1000.0f;
        if (bool != null) {
            repeatForever = bool.booleanValue();
        } else {
            repeatForever = mVar.getRepeatForever();
        }
        return companion2.a(animationType, e16, durationMillis2, delay, repeatForever, this.animationKey);
    }

    /* renamed from: a, reason: from getter */
    public final String getAnimationKey() {
        return this.animationKey;
    }

    public final Function0<Unit> b() {
        return this.finishedListener;
    }

    /* renamed from: c, reason: from getter */
    public final String getLazyAnimationKey() {
        return this.lazyAnimationKey;
    }

    public String toString() {
        String bVar;
        com.tencent.kuikly.core.base.b d16 = d();
        return (d16 == null || (bVar = d16.toString()) == null) ? "" : bVar;
    }

    private final TimingFuncType e(h easing, TimingFuncType timingFuncType) {
        if (timingFuncType != null) {
            return timingFuncType;
        }
        if (Intrinsics.areEqual(easing, i.b())) {
            return TimingFuncType.EASEINOUT;
        }
        if (Intrinsics.areEqual(easing, i.d())) {
            return TimingFuncType.EASEIN;
        }
        if (Intrinsics.areEqual(easing, i.a())) {
            return TimingFuncType.EASEOUT;
        }
        return TimingFuncType.LINEAR;
    }

    static /* synthetic */ TimingFuncType f(d dVar, h hVar, TimingFuncType timingFuncType, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            timingFuncType = null;
        }
        return dVar.e(hVar, timingFuncType);
    }
}
