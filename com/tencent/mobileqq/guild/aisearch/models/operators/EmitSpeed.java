package com.tencent.mobileqq.guild.aisearch.models.operators;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/operators/b;", "", "", "toString", "", "b", "", "c", "", "hashCode", "other", "", "equals", "a", "J", "d", "()J", WidgetCacheConstellationData.INTERVAL, UserInfo.SEX_FEMALE, "f", "()F", "stepLength", "e", "speed", "<init>", "(JF)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.aisearch.models.operators.b, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class EmitSpeed {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final List<EmitSpeed> f214167e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long interval;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float stepLength;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float speed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/operators/b$a;", "", "", "Lcom/tencent/mobileqq/guild/aisearch/models/operators/b;", "", "speed", "a", "default", "Ljava/util/List;", "b", "()Ljava/util/List;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.aisearch.models.operators.b$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EmitSpeed a(@NotNull List<EmitSpeed> list, float f16) {
            float f17;
            float f18;
            Object obj;
            Object first;
            Intrinsics.checkNotNullParameter(list, "<this>");
            Iterator<T> it = list.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                Object next = it.next();
                if (it.hasNext()) {
                    EmitSpeed emitSpeed = (EmitSpeed) next;
                    if (emitSpeed.getSpeed() * 1.2f <= f16) {
                        f17 = f16 - (emitSpeed.getSpeed() * 1.2f);
                    } else {
                        f17 = Float.MAX_VALUE;
                    }
                    do {
                        Object next2 = it.next();
                        EmitSpeed emitSpeed2 = (EmitSpeed) next2;
                        if (emitSpeed2.getSpeed() * 1.2f <= f16) {
                            f18 = f16 - (emitSpeed2.getSpeed() * 1.2f);
                        } else {
                            f18 = Float.MAX_VALUE;
                        }
                        if (Float.compare(f17, f18) > 0) {
                            next = next2;
                            f17 = f18;
                        }
                    } while (it.hasNext());
                }
                obj = next;
            }
            EmitSpeed emitSpeed3 = (EmitSpeed) obj;
            if (emitSpeed3 == null) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                return (EmitSpeed) first;
            }
            return emitSpeed3;
        }

        @NotNull
        public final List<EmitSpeed> b() {
            return EmitSpeed.f214167e;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.aisearch.models.operators.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C7669b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(((EmitSpeed) t16).getSpeed()), Float.valueOf(((EmitSpeed) t17).getSpeed()));
            return compareValues;
        }
    }

    static {
        List<EmitSpeed> sortedWith;
        ArrayList arrayList = new ArrayList();
        for (float f16 = 0.25f; f16 <= 5.0f; f16 += 0.25f) {
            arrayList.add(new EmitSpeed(50L, f16));
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new C7669b());
        f214167e = sortedWith;
    }

    public EmitSpeed(long j3, float f16) {
        this.interval = j3;
        this.stepLength = f16;
        this.speed = f16 * (1000 / ((float) j3));
    }

    /* renamed from: b, reason: from getter */
    public final long getInterval() {
        return this.interval;
    }

    /* renamed from: c, reason: from getter */
    public final float getStepLength() {
        return this.stepLength;
    }

    public final long d() {
        return this.interval;
    }

    /* renamed from: e, reason: from getter */
    public final float getSpeed() {
        return this.speed;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmitSpeed)) {
            return false;
        }
        EmitSpeed emitSpeed = (EmitSpeed) other;
        if (this.interval == emitSpeed.interval && Float.compare(this.stepLength, emitSpeed.stepLength) == 0) {
            return true;
        }
        return false;
    }

    public final float f() {
        return this.stepLength;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.interval) * 31) + Float.floatToIntBits(this.stepLength);
    }

    @NotNull
    public String toString() {
        return "EmitSpeed(interval=" + this.interval + ", stepLength=" + this.stepLength + ", speed=" + this.speed + ")";
    }
}
