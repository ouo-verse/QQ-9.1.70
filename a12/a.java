package a12;

import ADV_REPORT.mobile_adv_report_req;
import android.os.SystemClock;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"La12/a;", "", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011JR\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u001e\b\u0002\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0007R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"La12/a$a;", "", "V", "", "Ljava/util/concurrent/Future;", "futures", "", "timeoutMills", "Lkotlin/Function2;", "", "", "func", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: a12.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final <V> List<V> a(@NotNull List<? extends Future<V>> futures, long timeoutMills, @Nullable Function2<? super Integer, ? super V, Unit> func) {
            Object obj;
            long j3;
            IntRange until;
            List mutableList;
            Object m476constructorimpl;
            boolean z16;
            boolean z17;
            List<V> emptyList;
            Intrinsics.checkNotNullParameter(futures, "futures");
            if (futures.isEmpty()) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int size = futures.size();
            int i3 = 0;
            while (true) {
                obj = null;
                if (i3 >= size) {
                    break;
                }
                arrayList.add(null);
                i3++;
            }
            if (timeoutMills >= 0) {
                j3 = timeoutMills;
            } else {
                j3 = Long.MAX_VALUE;
            }
            until = RangesKt___RangesKt.until(0, size);
            mutableList = CollectionsKt___CollectionsKt.toMutableList(until);
            while (!mutableList.isEmpty()) {
                Iterator it = mutableList.iterator();
                long uptimeMillis = SystemClock.uptimeMillis();
                while (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    Future<V> future = futures.get(intValue);
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(TuplesKt.to(future.get(0L, TimeUnit.MILLISECONDS), obj));
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                    if (m479exceptionOrNullimpl != null) {
                        m476constructorimpl = TuplesKt.to(obj, m479exceptionOrNullimpl);
                    }
                    Pair pair = (Pair) m476constructorimpl;
                    mobile_adv_report_req mobile_adv_report_reqVar = (Object) pair.component1();
                    Throwable th6 = (Throwable) pair.component2();
                    if (th6 == null) {
                        z16 = true;
                    } else {
                        z16 = th6 instanceof ExecutionException;
                    }
                    if (z16) {
                        z17 = true;
                    } else {
                        z17 = th6 instanceof InterruptedException;
                    }
                    if (z17) {
                        arrayList.set(intValue, mobile_adv_report_reqVar);
                        if (func != null) {
                            func.invoke(Integer.valueOf(intValue), mobile_adv_report_reqVar);
                        }
                        it.remove();
                    } else {
                        boolean z18 = th6 instanceof TimeoutException;
                    }
                    obj = null;
                }
                if (!mutableList.isEmpty()) {
                    if (j3 <= 0) {
                        break;
                    }
                    try {
                        LockMethodProxy.sleep(200L);
                        j3 -= SystemClock.uptimeMillis() - uptimeMillis;
                    } catch (Exception e16) {
                        Logger.f235387a.d().i("FutureUtils", 1, "sleep with error: " + e16);
                    }
                }
                obj = null;
            }
            Iterator it5 = mutableList.iterator();
            while (it5.hasNext()) {
                if (func != null) {
                    func.invoke(it5.next(), null);
                }
            }
            return arrayList;
        }

        Companion() {
        }
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final <V> List<V> a(@NotNull List<? extends Future<V>> list, long j3, @Nullable Function2<? super Integer, ? super V, Unit> function2) {
        return INSTANCE.a(list, j3, function2);
    }
}
