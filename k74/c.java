package k74;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 .*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001!B\u001d\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000 \u0012\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0004\b,\u0010-J9\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\f\u0010\rJA\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J)\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002J2\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0096\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010*\u00a8\u0006/"}, d2 = {"Lk74/c;", "T", "Ljava/lang/reflect/InvocationHandler;", "Lk74/e;", "methodToken", "", "actionName", "Landroid/os/Bundle;", "ipcParams", "", "", "args", "e", "(Lk74/e;Ljava/lang/String;Landroid/os/Bundle;[Ljava/lang/Object;)Ljava/lang/Object;", "process", "c", "(Lk74/e;Ljava/lang/String;Landroid/os/Bundle;[Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "Leipc/EIPCResult;", "result", "i", "g", "(Lk74/e;[Ljava/lang/Object;)Ljava/lang/Object;", "Lk74/h;", "callbackToken", "callback", "", tl.h.F, "proxy", "Ljava/lang/reflect/Method;", "method", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "getProxyInterface", "()Ljava/lang/Class;", "proxyInterface", "b", "Ljava/lang/String;", "getProcess", "()Ljava/lang/String;", "Lk74/h;", "token", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "d", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c<T> implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Class<T> proxyInterface;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String process;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final h token;

    public c(Class<T> proxyInterface, String process) {
        Intrinsics.checkNotNullParameter(proxyInterface, "proxyInterface");
        Intrinsics.checkNotNullParameter(process, "process");
        this.proxyInterface = proxyInterface;
        this.process = process;
        this.token = h.INSTANCE.a(proxyInterface);
    }

    private final Object c(e methodToken, String actionName, Bundle ipcParams, Object[] args, String process) {
        if (methodToken.getIsSync()) {
            return i(methodToken, QIPCServerHelper.getInstance().getServer().callClient(process, 1, IZPlanIPCHelper.MODULE_NAME, actionName, ipcParams));
        }
        final Object g16 = g(methodToken, args);
        final h callback = methodToken.getCallback();
        QIPCServerHelper.getInstance().callClient(process, IZPlanIPCHelper.MODULE_NAME, actionName, ipcParams, new EIPCResultCallback() { // from class: k74.a
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                c.d(c.this, callback, g16, eIPCResult);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c this$0, h hVar, Object obj, EIPCResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        this$0.h(result, hVar, obj);
    }

    private final Object e(e methodToken, String actionName, Bundle ipcParams, Object[] args) {
        if (methodToken.getIsSync()) {
            return i(methodToken, QIPCClientHelper.getInstance().callServer(IZPlanIPCHelper.MODULE_NAME, actionName, ipcParams));
        }
        final Object g16 = g(methodToken, args);
        final h callback = methodToken.getCallback();
        QIPCClientHelper.getInstance().callServer(IZPlanIPCHelper.MODULE_NAME, actionName, ipcParams, new EIPCResultCallback() { // from class: k74.b
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                c.f(c.this, callback, g16, eIPCResult);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(c this$0, h hVar, Object obj, EIPCResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        this$0.h(result, hVar, obj);
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
        if (t74.h.c(this.process)) {
            return e(eVar, str, g16, args);
        }
        return c(eVar, str, g16, args, this.process);
    }

    private final Object i(e methodToken, EIPCResult result) {
        boolean z16 = false;
        if (result != null && result.isSuccess()) {
            z16 = true;
        }
        if (!z16) {
            return null;
        }
        Class<?> type = l74.a.l(methodToken.g());
        f fVar = f.f411829a;
        Intrinsics.checkNotNullExpressionValue(type, "type");
        Bundle bundle = result.data;
        Intrinsics.checkNotNullExpressionValue(bundle, "result.data");
        return fVar.b(type, -100, bundle, "ipc_ret_data");
    }

    private final Object g(e methodToken, Object[] args) {
        if (args != null && methodToken.getCallbackIndex() >= 0) {
            return args[methodToken.getCallbackIndex()];
        }
        return null;
    }

    private final void h(EIPCResult result, h callbackToken, Object callback) {
        List split$default;
        if (callback == null || callbackToken == null) {
            return;
        }
        Bundle bundle = result.data;
        if (bundle == null) {
            QLog.w("CallHandler", 1, "onCallback error: " + result.code);
            return;
        }
        String string = bundle.getString("ipc_callback_");
        if (string == null) {
            return;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) string, new char[]{';'}, false, 0, 6, (Object) null);
        String substring = string.substring(((String) split$default.get(0)).length() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        e c16 = callbackToken.c(substring);
        if (c16 == null) {
            return;
        }
        Bundle bundle2 = result.data;
        Intrinsics.checkNotNullExpressionValue(bundle2, "result.data");
        Object[] a16 = f.a(c16, bundle2);
        l74.a.g(callback).b(c16.e(), Arrays.copyOf(a16, a16.length));
    }
}
