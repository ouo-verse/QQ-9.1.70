package hu2;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kt3.b;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\u0006B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lhu2/i;", "", "", "event", "", "e", "a", "c", "d", "b", "Lkt3/b$b;", "Lkt3/b$b;", "getCallback", "()Lkt3/b$b;", "callback", "<init>", "(Lkt3/b$b;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b.InterfaceC10678b callback;

    public i(@Nullable b.InterfaceC10678b interfaceC10678b) {
        this.callback = interfaceC10678b;
    }

    private final void e(int event) {
        b.InterfaceC10678b interfaceC10678b = this.callback;
        if (interfaceC10678b != null) {
            interfaceC10678b.onEvent(event, 0, 0, null);
        }
    }

    public final void a() {
        QLog.i("MidAdPlayerCallback", 1, "notifyComplete");
        e(0);
    }

    public final void b() {
        QLog.i("MidAdPlayerCallback", 1, "notifyError");
        e(3);
    }

    public final void c() {
        QLog.i("MidAdPlayerCallback", 1, "notifyPrepared");
        e(1);
    }

    public final void d() {
        QLog.i("MidAdPlayerCallback", 1, "notifyStuck");
        e(2);
    }
}
