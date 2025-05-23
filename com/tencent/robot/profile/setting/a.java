package com.tencent.robot.profile.setting;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0002R$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\tj\b\u0012\u0004\u0012\u00020\u0004`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/profile/setting/a;", "", "", "b", "Lcom/tencent/robot/profile/setting/a$a;", "listener", "a", "d", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "listeners", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f368094a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<InterfaceC9777a> listeners = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/robot/profile/setting/a$a;", "", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.setting.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC9777a {
        void a();
    }

    a() {
    }

    public final void a(@NotNull InterfaceC9777a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList<InterfaceC9777a> arrayList = listeners;
        if (!arrayList.contains(listener)) {
            arrayList.add(listener);
        }
    }

    public final void b() {
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC9777a) it.next()).a();
        }
    }

    public final void c() {
        listeners.clear();
    }

    public final void d(@NotNull InterfaceC9777a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList<InterfaceC9777a> arrayList = listeners;
        if (arrayList.contains(listener)) {
            arrayList.remove(listener);
        }
    }
}
