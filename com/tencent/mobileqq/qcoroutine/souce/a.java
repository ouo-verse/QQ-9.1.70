package com.tencent.mobileqq.qcoroutine.souce;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0007\u0010\bR*\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\u000b0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0011\u0010\u0011\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/souce/a;", "", "E", DTConstants.TAG.ELEMENT, "", "a", "(Ljava/lang/Object;)Z", "c", "()Ljava/lang/Object;", "Lkotlinx/atomicfu/AtomicRef;", "Lcom/tencent/mobileqq/qcoroutine/souce/b;", "Lcom/tencent/mobileqq/qcoroutine/souce/Core;", "Lkotlinx/atomicfu/AtomicRef;", "_cur", "", "b", "()I", "size", "singleConsumer", "<init>", "(Z)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public class a<E> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AtomicRef<b<E>> _cur;

    public a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this._cur = AtomicFU.atomic(new b(8, z16));
        }
    }

    public final boolean a(@NotNull E element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) element)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(element, "element");
        AtomicRef<b<E>> atomicRef = this._cur;
        while (true) {
            b<E> value = atomicRef.getValue();
            int a16 = value.a(element);
            if (a16 == 0) {
                return true;
            }
            if (a16 != 1) {
                if (a16 == 2) {
                    return false;
                }
            } else {
                this._cur.compareAndSet(value, value.g());
            }
        }
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this._cur.getValue().e();
    }

    @Nullable
    public final E c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (E) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        AtomicRef<b<E>> atomicRef = this._cur;
        while (true) {
            b<E> value = atomicRef.getValue();
            E e16 = (E) value.h();
            if (e16 != b.f261847g) {
                return e16;
            }
            this._cur.compareAndSet(value, value.g());
        }
    }
}
