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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B|\u0012S\u0010\u0017\u001aO\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\tj\u0002`\u0012\u0012\u001e\u0010\u001e\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u0019\u0012\f\u0012\n\u0012\u0002\b\u00030\u001aj\u0002`\u001b0\u0018\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003Rd\u0010\u0017\u001aO\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\tj\u0002`\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R/\u0010\u001e\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u0019\u0012\f\u0012\n\u0012\u0002\b\u00030\u001aj\u0002`\u001b0\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u0013\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/filament/zplanservice/channel/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", AdMetricTag.EVENT_NAME, "Lcom/tencent/mobileqq/pb/MessageMicro;", "pbField", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "Lcom/tencent/filament/zplanservice/channel/SceneHandler;", "a", "Lkotlin/jvm/functions/Function3;", "b", "()Lkotlin/jvm/functions/Function3;", "handleFun", "", "Lcom/tencent/filament/zplanservice/channel/EventName;", "Ljava/lang/Class;", "Lcom/tencent/filament/zplanservice/channel/EventPbJavaClass;", "Ljava/util/Map;", "()Ljava/util/Map;", "handleEventMap", "<init>", "(Lkotlin/jvm/functions/Function3;Ljava/util/Map;)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplanservice.channel.e, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class SceneEventConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function3<String, MessageMicro<?>, a, Unit> handleFun;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<String, Class<?>> handleEventMap;

    /* JADX WARN: Multi-variable type inference failed */
    public SceneEventConfig(@NotNull Function3<? super String, ? super MessageMicro<?>, ? super a, Unit> handleFun, @NotNull Map<String, ? extends Class<?>> handleEventMap) {
        Intrinsics.checkNotNullParameter(handleFun, "handleFun");
        Intrinsics.checkNotNullParameter(handleEventMap, "handleEventMap");
        this.handleFun = handleFun;
        this.handleEventMap = handleEventMap;
    }

    @NotNull
    public final Map<String, Class<?>> a() {
        return this.handleEventMap;
    }

    @NotNull
    public final Function3<String, MessageMicro<?>, a, Unit> b() {
        return this.handleFun;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SceneEventConfig) {
                SceneEventConfig sceneEventConfig = (SceneEventConfig) other;
                if (!Intrinsics.areEqual(this.handleFun, sceneEventConfig.handleFun) || !Intrinsics.areEqual(this.handleEventMap, sceneEventConfig.handleEventMap)) {
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
        Function3<String, MessageMicro<?>, a, Unit> function3 = this.handleFun;
        int i16 = 0;
        if (function3 != null) {
            i3 = function3.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        Map<String, Class<?>> map = this.handleEventMap;
        if (map != null) {
            i16 = map.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "SceneEventConfig(handleFun=" + this.handleFun + ", handleEventMap=" + this.handleEventMap + ")";
    }
}
