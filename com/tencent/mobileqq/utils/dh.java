package com.tencent.mobileqq.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/utils/dh;", "", "Lcom/tencent/mobileqq/utils/fa;", "listener", "", "b", "a", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "listenerRef", "<init>", "()V", "drawer-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class dh {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final dh f307632a = new dh();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<fa> listenerRef;

    dh() {
    }

    @Nullable
    public final fa a() {
        WeakReference<fa> weakReference = listenerRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void b(@NotNull fa listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listenerRef = new WeakReference<>(listener);
    }
}
