package com.tencent.filament.zplanservice.channel;

import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\t\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003J1\u0010\u000f\u001a\u00028\u0000\"\b\b\u0000\u0010\n*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R$\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u00178@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/filament/zplanservice/channel/f;", "", "", "Lcom/tencent/filament/zplanservice/channel/SceneId;", WadlProxyConsts.SCENE_ID, "Lcom/tencent/filament/zplanservice/channel/e;", "sceneEventConfig", "", "c", "d", "T", "", "eventData", "Ljava/lang/Class;", "eventClass", "a", "([BLjava/lang/Class;)Ljava/lang/Object;", "", "", "Lcom/tencent/filament/zplanservice/channel/EventName;", "Lcom/tencent/filament/zplanservice/channel/b;", "Ljava/util/Map;", "_sceneEventDispatchConfig", "", "b", "()Ljava/util/Map;", "sceneEventDispatchConfig", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f f106360b = new f();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, DispatchConfig> _sceneEventDispatchConfig = new LinkedHashMap();

    f() {
    }

    @NotNull
    public final <T> T a(@Nullable byte[] eventData, @NotNull Class<T> eventClass) {
        Intrinsics.checkNotNullParameter(eventClass, "eventClass");
        T eventInstance = eventClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        eventClass.getMethod("mergeFrom", byte[].class).invoke(eventInstance, eventData);
        Intrinsics.checkNotNullExpressionValue(eventInstance, "eventInstance");
        return eventInstance;
    }

    @NotNull
    public final Map<String, DispatchConfig> b() {
        return _sceneEventDispatchConfig;
    }

    public final synchronized void c(long sceneId, @NotNull SceneEventConfig sceneEventConfig) {
        Intrinsics.checkNotNullParameter(sceneEventConfig, "sceneEventConfig");
        Map<String, Class<?>> a16 = sceneEventConfig.a();
        FLog.INSTANCE.i("SceneEventHandler", "registerSceneEventConfig sceneId: " + sceneId);
        for (Map.Entry<String, Class<?>> entry : a16.entrySet()) {
            String key = entry.getKey();
            Class<?> value = entry.getValue();
            Map<String, DispatchConfig> map = _sceneEventDispatchConfig;
            DispatchConfig dispatchConfig = map.get(key);
            if (dispatchConfig == null) {
                dispatchConfig = new DispatchConfig(value, new LinkedHashMap());
                map.put(key, dispatchConfig);
            }
            DispatchConfig dispatchConfig2 = dispatchConfig;
            if (Intrinsics.areEqual(dispatchConfig2.b(), value)) {
                dispatchConfig2.a().put(Long.valueOf(sceneId), sceneEventConfig.b());
            } else {
                throw new IllegalArgumentException(("Different event message types with the same event name: " + key).toString());
            }
        }
    }

    public final synchronized void d(long sceneId) {
        FLog.INSTANCE.i("SceneEventHandler", "unregisterSceneEventConfig sceneId: " + sceneId);
        Iterator<T> it = _sceneEventDispatchConfig.values().iterator();
        while (it.hasNext()) {
            ((DispatchConfig) it.next()).a().remove(Long.valueOf(sceneId));
        }
    }
}
