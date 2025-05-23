package com.tencent.mobileqq.onlinestatus.manager;

import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/manager/t;", "", "Lec2/d;", "listener", "", "e", "k", "", "from", "i", "g", "", "b", "Ljava/util/List;", "_configUpdateListeners", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t f255980a = new t();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<ec2.d> _configUpdateListeners = new ArrayList();

    t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ec2.d listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        List<ec2.d> list = _configUpdateListeners;
        if (!list.contains(listener)) {
            list.add(listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        _configUpdateListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(String from) {
        Intrinsics.checkNotNullParameter(from, "$from");
        Iterator it = new ArrayList(_configUpdateListeners).iterator();
        while (it.hasNext()) {
            ((ec2.d) it.next()).a(from);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ec2.d listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        _configUpdateListeners.remove(listener);
    }

    public final void e(@NotNull final ec2.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.manager.r
            @Override // java.lang.Runnable
            public final void run() {
                t.f(ec2.d.this);
            }
        });
    }

    public final void g() {
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.manager.q
            @Override // java.lang.Runnable
            public final void run() {
                t.h();
            }
        });
    }

    public final void i(@NotNull final String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.manager.s
            @Override // java.lang.Runnable
            public final void run() {
                t.j(from);
            }
        });
    }

    public final void k(@NotNull final ec2.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.manager.p
            @Override // java.lang.Runnable
            public final void run() {
                t.l(ec2.d.this);
            }
        });
    }
}
