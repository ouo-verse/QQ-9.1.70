package op;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR$\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0016j\b\u0012\u0004\u0012\u00020\u0005`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lop/h;", "", "", "a", "()[Ljava/lang/Object;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "callback", "", "j", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "e", "b", tl.h.F, "f", "d", "i", "outState", "g", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mActivityLifecycleCallbacks", "<init>", "()V", "fg_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final h f423289b = new h();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<Application.ActivityLifecycleCallbacks> mActivityLifecycleCallbacks = new ArrayList<>();

    h() {
    }

    private final Object[] a() {
        Object[] objArr;
        ArrayList<Application.ActivityLifecycleCallbacks> arrayList = mActivityLifecycleCallbacks;
        synchronized (arrayList) {
            if (arrayList.size() > 0) {
                objArr = arrayList.toArray();
            } else {
                objArr = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        return objArr;
    }

    public final void b(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                if (obj != null) {
                    ((Application.ActivityLifecycleCallbacks) obj).onActivityCreated(activity, savedInstanceState);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
                }
            }
        }
    }

    public final void c(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                if (obj != null) {
                    ((Application.ActivityLifecycleCallbacks) obj).onActivityDestroyed(activity);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
                }
            }
        }
    }

    public final void d(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                if (obj != null) {
                    ((Application.ActivityLifecycleCallbacks) obj).onActivityPaused(activity);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
                }
            }
        }
    }

    public final void e(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Object[] a16 = a();
        if (a16 != null && Build.VERSION.SDK_INT >= 29) {
            for (Object obj : a16) {
                if (obj != null) {
                    ((Application.ActivityLifecycleCallbacks) obj).onActivityPreCreated(activity, savedInstanceState);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
                }
            }
        }
    }

    public final void f(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                if (obj != null) {
                    ((Application.ActivityLifecycleCallbacks) obj).onActivityResumed(activity);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
                }
            }
        }
    }

    public final void g(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(outState, "outState");
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                if (obj != null) {
                    ((Application.ActivityLifecycleCallbacks) obj).onActivitySaveInstanceState(activity, outState);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
                }
            }
        }
    }

    public final void h(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                if (obj != null) {
                    ((Application.ActivityLifecycleCallbacks) obj).onActivityStarted(activity);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
                }
            }
        }
    }

    public final void i(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                if (obj != null) {
                    ((Application.ActivityLifecycleCallbacks) obj).onActivityStopped(activity);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
                }
            }
        }
    }

    public final void j(@NotNull Application.ActivityLifecycleCallbacks callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        ArrayList<Application.ActivityLifecycleCallbacks> arrayList = mActivityLifecycleCallbacks;
        synchronized (arrayList) {
            arrayList.add(callback);
        }
    }
}
