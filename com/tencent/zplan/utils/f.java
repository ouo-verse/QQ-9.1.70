package com.tencent.zplan.utils;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J/\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\b\u0010\tJ/\u0010\n\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\n\u0010\tJI\u0010\u0010\u001a\u00020\u00072\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/zplan/utils/f;", "", "Landroid/os/IInterface;", "T", "Landroid/os/RemoteCallbackList;", "remoteCallbackList", "value", "", "c", "(Landroid/os/RemoteCallbackList;Landroid/os/IInterface;)V", "d", "Ljava/lang/reflect/Method;", "method", "callback", "", "args", "a", "(Landroid/os/RemoteCallbackList;Ljava/lang/reflect/Method;Landroid/os/IInterface;[Ljava/lang/Object;)V", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f386206a = new f();

    f() {
    }

    public static /* synthetic */ void b(f fVar, RemoteCallbackList remoteCallbackList, Method method, IInterface iInterface, Object[] objArr, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            iInterface = null;
        }
        fVar.a(remoteCallbackList, method, iInterface, objArr);
    }

    public final void a(@NotNull RemoteCallbackList<? extends IInterface> remoteCallbackList, @NotNull Method method, @Nullable IInterface callback, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(remoteCallbackList, "remoteCallbackList");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        synchronized (remoteCallbackList) {
            int beginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                try {
                    IInterface broadcastItem = remoteCallbackList.getBroadcastItem(i3);
                    Intrinsics.checkNotNullExpressionValue(broadcastItem, "remoteCallbackList.getBroadcastItem(i)");
                    if (callback == null || Intrinsics.areEqual(callback, broadcastItem)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        method.invoke(broadcastItem, Arrays.copyOf(args, args.length));
                        ZLog.f386189b.k("ZPlanRemoteCallbackUtil", "handleRemoteCallback cost: " + (System.currentTimeMillis() - currentTimeMillis) + ", " + broadcastItem);
                    }
                } catch (Exception e16) {
                    ZLog.f386189b.f("ZPlanRemoteCallbackUtil", "doRemoteCallback error, " + e16);
                }
            }
            remoteCallbackList.finishBroadcast();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final <T extends IInterface> void c(@NotNull RemoteCallbackList<T> remoteCallbackList, @Nullable T value) {
        Intrinsics.checkNotNullParameter(remoteCallbackList, "remoteCallbackList");
        synchronized (remoteCallbackList) {
            remoteCallbackList.register(value);
        }
    }

    public final <T extends IInterface> void d(@NotNull RemoteCallbackList<T> remoteCallbackList, @Nullable T value) {
        Intrinsics.checkNotNullParameter(remoteCallbackList, "remoteCallbackList");
        synchronized (remoteCallbackList) {
            remoteCallbackList.unregister(value);
        }
    }
}
