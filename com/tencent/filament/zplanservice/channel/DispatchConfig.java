package com.tencent.filament.zplanservice.channel;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.pb.MessageMicro;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B|\u0012\u000e\u0010\u000f\u001a\n\u0012\u0002\b\u00030\tj\u0002`\n\u0012c\u0010\u001f\u001a_\u0012\b\u0012\u00060\u0011j\u0002`\u0012\u0012Q\u0012O\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0017\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0013j\u0002`\u001c0\u0010\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\u000f\u001a\n\u0012\u0002\b\u00030\tj\u0002`\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eRt\u0010\u001f\u001a_\u0012\b\u0012\u00060\u0011j\u0002`\u0012\u0012Q\u0012O\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0017\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0013j\u0002`\u001c0\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u000b\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/filament/zplanservice/channel/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Class;", "Lcom/tencent/filament/zplanservice/channel/EventPbJavaClass;", "a", "Ljava/lang/Class;", "b", "()Ljava/lang/Class;", "eventPbJavaClass", "", "", "Lcom/tencent/filament/zplanservice/channel/SceneId;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", AdMetricTag.EVENT_NAME, "Lcom/tencent/mobileqq/pb/MessageMicro;", "pbField", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "Lcom/tencent/filament/zplanservice/channel/SceneHandler;", "Ljava/util/Map;", "()Ljava/util/Map;", "dispatchMap", "<init>", "(Ljava/lang/Class;Ljava/util/Map;)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplanservice.channel.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class DispatchConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Class<?> eventPbJavaClass;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<Long, Function3<String, MessageMicro<?>, a, Unit>> dispatchMap;

    public DispatchConfig(@NotNull Class<?> eventPbJavaClass, @NotNull Map<Long, Function3<String, MessageMicro<?>, a, Unit>> dispatchMap) {
        Intrinsics.checkNotNullParameter(eventPbJavaClass, "eventPbJavaClass");
        Intrinsics.checkNotNullParameter(dispatchMap, "dispatchMap");
        this.eventPbJavaClass = eventPbJavaClass;
        this.dispatchMap = dispatchMap;
    }

    @NotNull
    public final Map<Long, Function3<String, MessageMicro<?>, a, Unit>> a() {
        return this.dispatchMap;
    }

    @NotNull
    public final Class<?> b() {
        return this.eventPbJavaClass;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof DispatchConfig) {
                DispatchConfig dispatchConfig = (DispatchConfig) other;
                if (!Intrinsics.areEqual(this.eventPbJavaClass, dispatchConfig.eventPbJavaClass) || !Intrinsics.areEqual(this.dispatchMap, dispatchConfig.dispatchMap)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        Class<?> cls = this.eventPbJavaClass;
        int i16 = 0;
        if (cls != null) {
            i3 = cls.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        Map<Long, Function3<String, MessageMicro<?>, a, Unit>> map = this.dispatchMap;
        if (map != null) {
            i16 = map.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "DispatchConfig(eventPbJavaClass=" + this.eventPbJavaClass + ", dispatchMap=" + this.dispatchMap + ")";
    }
}
