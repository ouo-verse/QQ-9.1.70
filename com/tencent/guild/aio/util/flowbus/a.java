package com.tencent.guild.aio.util.flowbus;

import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\fB\u0011\b\u0012\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J&\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR(\u0010\u0011\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/util/flowbus/a;", "", "T", "event", "", "c", "(Ljava/lang/Object;)V", "Ljava/lang/Class;", "clazz", "Lkotlinx/coroutines/flow/MutableStateFlow;", "b", "", "a", "Ljava/lang/String;", "busName", "", "Ljava/util/Map;", "flows", "<init>", "(Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f112395d = new a("Default");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String busName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Class<?>, MutableStateFlow<?>> flows = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/util/flowbus/a$a;", "", "T", "event", "", "b", "(Ljava/lang/Object;)V", "Lcom/tencent/guild/aio/util/flowbus/a;", "defaultBus", "Lcom/tencent/guild/aio/util/flowbus/a;", "a", "()Lcom/tencent/guild/aio/util/flowbus/a;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.util.flowbus.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a() {
            return a.f112395d;
        }

        public final <T> void b(@NotNull T event) {
            Intrinsics.checkNotNullParameter(event, "event");
            a().c(event);
        }

        Companion() {
        }
    }

    a(String str) {
        this.busName = "";
        this.busName = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <T> MutableStateFlow<T> b(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Map<Class<?>, MutableStateFlow<?>> map = this.flows;
        Object obj = map.get(clazz);
        if (obj == null) {
            obj = StateFlowKt.MutableStateFlow(null);
            map.put(clazz, obj);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.flow.MutableStateFlow<T of com.tencent.guild.aio.util.flowbus.FlowBus.forEvent?>");
        MutableStateFlow<T> mutableStateFlow = (MutableStateFlow) obj;
        QLog.i("FlowBus", 4, "post Flow=" + mutableStateFlow.hashCode());
        return mutableStateFlow;
    }

    @JvmOverloads
    public final <T> void c(@NotNull T event) {
        Intrinsics.checkNotNullParameter(event, "event");
        MutableStateFlow<T> b16 = b(event.getClass());
        QLog.i("FlowBus", 4, "post bus=" + hashCode() + " event=" + event.hashCode());
        if (b16.tryEmit(event)) {
        } else {
            throw new IllegalStateException("emit event error");
        }
    }
}
