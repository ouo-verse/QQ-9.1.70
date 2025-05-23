package com.tencent.kuikly.core.base.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/kuikly/core/base/event/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "finish", "Ljava/lang/String;", "getAttr", "()Ljava/lang/String;", "attr", "c", "animationKey", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "d", "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.base.event.a, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class AnimationCompletionParams {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int finish;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String attr;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String animationKey;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/base/event/a$a;", "", "params", "Lcom/tencent/kuikly/core/base/event/a;", "a", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.event.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AnimationCompletionParams a(Object params) {
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = params instanceof com.tencent.kuikly.core.nvi.serialization.json.e ? (com.tencent.kuikly.core.nvi.serialization.json.e) params : null;
            if (eVar == null) {
                eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            }
            return new AnimationCompletionParams(eVar.j("finish"), eVar.p("attr"), eVar.p("animationKey"));
        }

        Companion() {
        }
    }

    public AnimationCompletionParams(int i3, String attr, String animationKey) {
        Intrinsics.checkNotNullParameter(attr, "attr");
        Intrinsics.checkNotNullParameter(animationKey, "animationKey");
        this.finish = i3;
        this.attr = attr;
        this.animationKey = animationKey;
    }

    /* renamed from: a, reason: from getter */
    public final String getAnimationKey() {
        return this.animationKey;
    }

    /* renamed from: b, reason: from getter */
    public final int getFinish() {
        return this.finish;
    }

    public int hashCode() {
        return (((this.finish * 31) + this.attr.hashCode()) * 31) + this.animationKey.hashCode();
    }

    public String toString() {
        return "AnimationCompletionParams(finish=" + this.finish + ", attr=" + this.attr + ", animationKey=" + this.animationKey + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimationCompletionParams)) {
            return false;
        }
        AnimationCompletionParams animationCompletionParams = (AnimationCompletionParams) other;
        return this.finish == animationCompletionParams.finish && Intrinsics.areEqual(this.attr, animationCompletionParams.attr) && Intrinsics.areEqual(this.animationKey, animationCompletionParams.animationKey);
    }
}
