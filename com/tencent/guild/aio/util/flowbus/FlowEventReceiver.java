package com.tencent.guild.aio.util.flowbus;

import com.tencent.guild.aio.util.flowbus.dispatcher.DispatcherProvider;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001d\u0010\u001eJg\u0010\u000e\u001a\u00020\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u000521\u0010\r\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0019\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "", "T", "Ljava/lang/Class;", "clazz", "", "skipRetained", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "event", "Lkotlin/coroutines/Continuation;", "", "callback", "c", "(Ljava/lang/Class;ZLkotlin/jvm/functions/Function2;)Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "d", "Lcom/tencent/guild/aio/util/flowbus/a;", "a", "Lcom/tencent/guild/aio/util/flowbus/a;", "bus", "", "Lkotlinx/coroutines/Job;", "b", "Ljava/util/Map;", "jobs", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "returnDispatcher", "<init>", "(Lcom/tencent/guild/aio/util/flowbus/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class FlowEventReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.util.flowbus.a bus;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Class<?>, Job> jobs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CoroutineDispatcher returnDispatcher;

    @JvmOverloads
    public FlowEventReceiver(@NotNull com.tencent.guild.aio.util.flowbus.a bus) {
        Intrinsics.checkNotNullParameter(bus, "bus");
        this.bus = bus;
        this.jobs = new LinkedHashMap();
        this.returnDispatcher = DispatcherProvider.f112398a.a();
    }

    @JvmOverloads
    @NotNull
    public final <T> FlowEventReceiver c(@NotNull Class<T> clazz, boolean skipRetained, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> callback) {
        CompletableJob Job$default;
        Job launch$default;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.jobs.containsKey(clazz)) {
            a aVar = new a(CoroutineExceptionHandler.INSTANCE);
            QLog.i("FileUtil", 4, "bus=" + this.bus.hashCode());
            Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Job$default.plus(Dispatchers.getDefault()).plus(aVar)), null, null, new FlowEventReceiver$subscribeTo$job$1(this, clazz, skipRetained, callback, null), 3, null);
            this.jobs.put(clazz, launch$default);
            return this;
        }
        throw new IllegalArgumentException("\u8be5\u7c7b\u578b\u6d88\u606f\u91cd\u590d\u8ba2\u9605: " + clazz);
    }

    public final void d() {
        Iterator<T> it = this.jobs.values().iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
        }
        this.jobs.clear();
    }

    public /* synthetic */ FlowEventReceiver(com.tencent.guild.aio.util.flowbus.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? com.tencent.guild.aio.util.flowbus.a.INSTANCE.a() : aVar);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            throw exception;
        }
    }
}
