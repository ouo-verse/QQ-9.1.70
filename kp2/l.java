package kp2;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.List;
import yx3.a;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l implements a.InterfaceC11637a {

    /* renamed from: d, reason: collision with root package name */
    private a.InterfaceC11637a f412844d;

    public l(a.InterfaceC11637a interfaceC11637a) {
        this.f412844d = interfaceC11637a;
    }

    @Override // yx3.a.InterfaceC11637a
    public void a(final List<com.tencent.mobileqq.search.j> list) {
        final a.InterfaceC11637a interfaceC11637a = this.f412844d;
        if (interfaceC11637a == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            interfaceC11637a.a(list);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: kp2.j
                @Override // java.lang.Runnable
                public final void run() {
                    a.InterfaceC11637a.this.a(list);
                }
            });
        }
    }

    @Override // yx3.a.InterfaceC11637a
    public void j(final boolean z16, @Nullable final com.tencent.mobileqq.search.j jVar) {
        final a.InterfaceC11637a interfaceC11637a = this.f412844d;
        if (interfaceC11637a == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            interfaceC11637a.j(z16, jVar);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: kp2.k
                @Override // java.lang.Runnable
                public final void run() {
                    a.InterfaceC11637a.this.j(z16, jVar);
                }
            });
        }
    }
}
