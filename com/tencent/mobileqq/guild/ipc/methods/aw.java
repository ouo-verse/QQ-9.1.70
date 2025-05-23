package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import eipc.EIPCResult;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ5\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/aw;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "context", "", "method", "", "", "arguments", "Leipc/EIPCResult;", "a", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class aw extends AbsIpcMethod {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/aw$a;", "", "", "result", "", "message", "Landroid/os/Bundle;", "b", "TAG", "Ljava/lang/String;", "", "TIMEOUT_DURATION", "J", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.ipc.methods.aw$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle b(int result, String message) {
            Bundle bundle = new Bundle();
            bundle.putInt("result", result);
            if (message == null) {
                message = "";
            }
            bundle.putString("message", message);
            return bundle;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/ipc/methods/aw$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "result", "", "errMsg", "", "onGuildListRefreshed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f226333d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AbsIpcMethod.a f226334e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IGPSService f226335f;

        b(AtomicBoolean atomicBoolean, AbsIpcMethod.a aVar, IGPSService iGPSService) {
            this.f226333d = atomicBoolean;
            this.f226334e = aVar;
            this.f226335f = iGPSService;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGuildListRefreshed(int result, @Nullable String errMsg) {
            if (this.f226333d.compareAndSet(false, true)) {
                this.f226334e.b(aw.INSTANCE.b(result, errMsg));
                this.f226335f.deleteObserver(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AtomicBoolean resultFlag, AbsIpcMethod.a context, IGPSService gproService, b observer) {
        Intrinsics.checkNotNullParameter(resultFlag, "$resultFlag");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(gproService, "$gproService");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        if (!resultFlag.compareAndSet(false, true)) {
            return;
        }
        context.b(INSTANCE.b(1002, "\u8bf7\u6c42\u8d85\u65f6"));
        gproService.deleteObserver(observer);
    }

    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    @Nullable
    public EIPCResult a(@NotNull final AbsIpcMethod.a context, @NotNull String method, @NotNull Object... arguments) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        final IGPSService iGPSService = (IGPSService) S0;
        final b bVar = new b(atomicBoolean, context, iGPSService);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.ipc.methods.av
            @Override // java.lang.Runnable
            public final void run() {
                aw.e(atomicBoolean, context, iGPSService, bVar);
            }
        }, 15000L);
        iGPSService.addObserver(bVar);
        iGPSService.refreshGuildList(true);
        return null;
    }
}
