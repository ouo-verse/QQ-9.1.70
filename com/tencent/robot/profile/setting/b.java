package com.tencent.robot.profile.setting;

import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\f\u001a\u00020\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/profile/setting/b;", "", "Lcom/tencent/robot/profile/setting/b$a;", "listener", "", "a", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "profile", "d", "f", "c", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "", "Lmqq/util/WeakReference;", "Ljava/util/List;", "listenerList", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static GroupRobotProfile robotProfile;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f368096a = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WeakReference<a>> listenerList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/profile/setting/b$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a {
        void a(@Nullable GroupRobotProfile robotProfile);
    }

    b() {
    }

    public final void a(@Nullable a listener) {
        Object obj;
        if (listener == null) {
            return;
        }
        Iterator<T> it = listenerList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((WeakReference) obj).get(), listener)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((WeakReference) obj) != null) {
            return;
        }
        listenerList.add(new WeakReference<>(listener));
    }

    public final void b() {
        robotProfile = null;
        listenerList.clear();
    }

    @Nullable
    public final GroupRobotProfile c() {
        return robotProfile;
    }

    public final void d(@Nullable GroupRobotProfile profile) {
        int collectionSizeOrDefault;
        Unit unit;
        f(profile);
        List<WeakReference<a>> list = listenerList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                aVar.a(profile);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            arrayList.add(unit);
        }
    }

    public final void e(@Nullable a listener) {
        Object obj;
        Iterator<T> it = listenerList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((WeakReference) obj).get(), listener)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null) {
            return;
        }
        listenerList.remove(weakReference);
    }

    public final void f(@Nullable GroupRobotProfile profile) {
        robotProfile = profile;
    }
}
