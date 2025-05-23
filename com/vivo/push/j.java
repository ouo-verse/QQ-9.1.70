package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class j implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f387719a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f387719a = iVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message == null) {
            com.vivo.push.util.u.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                atomicInteger2 = this.f387719a.f387714f;
                if (atomicInteger2.get() == 4) {
                    this.f387719a.f();
                }
                this.f387719a.a(1);
            } else {
                com.vivo.push.util.u.b("AidlManager", "unknow msg what [" + message.what + "]");
            }
        } else {
            com.vivo.push.util.u.a("AidlManager", "In connect, bind core service time out");
            atomicInteger = this.f387719a.f387714f;
            if (atomicInteger.get() == 2) {
                this.f387719a.a(1);
            }
        }
        return true;
    }
}
