package k74;

import android.os.Bundle;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J2\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bH\u0096\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lk74/d;", "T", "Ljava/lang/reflect/InvocationHandler;", "Landroid/os/Bundle;", "ipcParams", "", "a", "", "proxy", "Ljava/lang/reflect/Method;", "method", "", "args", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/Class;", "Ljava/lang/Class;", "proxyInterface", "Leipc/EIPCModule;", "b", "Leipc/EIPCModule;", "ipcModule", "", "c", "I", "getCallbackId", "()I", "callbackId", "Lk74/h;", "d", "Lk74/h;", "token", "<init>", "(Ljava/lang/Class;Leipc/EIPCModule;I)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d<T> implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Class<T> proxyInterface;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final EIPCModule ipcModule;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int callbackId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final h token;

    public d(Class<T> proxyInterface, EIPCModule ipcModule, int i3) {
        Intrinsics.checkNotNullParameter(proxyInterface, "proxyInterface");
        Intrinsics.checkNotNullParameter(ipcModule, "ipcModule");
        this.proxyInterface = proxyInterface;
        this.ipcModule = ipcModule;
        this.callbackId = i3;
        this.token = h.INSTANCE.a(proxyInterface);
    }

    private final void a(Bundle ipcParams) {
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.data = ipcParams;
        this.ipcModule.callbackResult(this.callbackId, eIPCResult);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(method, "method");
        e eVar = this.token.a().get(method);
        if (eVar == null) {
            return null;
        }
        String str = this.token.getName() + ';' + eVar.c();
        Bundle g16 = g.f411830a.g(eVar, args);
        g16.putString("ipc_callback_", str);
        a(g16);
        return null;
    }
}
