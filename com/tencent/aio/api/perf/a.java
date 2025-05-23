package com.tencent.aio.api.perf;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/api/perf/a;", "", "", "time", "", "c", "Lcom/tencent/aio/api/perf/a$b;", "perfData", "a", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\t\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/aio/api/perf/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "costTime", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "frameCost", "c", "gcData", "<init>", "(JLjava/util/List;Ljava/util/List;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long costTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Long> frameCost;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Long> gcData;

        public b(long j3, @NotNull List<Long> frameCost, @NotNull List<Long> gcData) {
            Intrinsics.checkNotNullParameter(frameCost, "frameCost");
            Intrinsics.checkNotNullParameter(gcData, "gcData");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), frameCost, gcData);
                return;
            }
            this.costTime = j3;
            this.frameCost = frameCost;
            this.gcData = gcData;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Long) iPatchRedirector.redirect((short) 1, (Object) this)).longValue();
            }
            return this.costTime;
        }

        @NotNull
        public final List<Long> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.frameCost;
        }

        @NotNull
        public final List<Long> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.gcData;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this != other) {
                if (other instanceof b) {
                    b bVar = (b) other;
                    if (this.costTime != bVar.costTime || !Intrinsics.areEqual(this.frameCost, bVar.frameCost) || !Intrinsics.areEqual(this.gcData, bVar.gcData)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            int a16 = androidx.fragment.app.a.a(this.costTime) * 31;
            List<Long> list = this.frameCost;
            int i16 = 0;
            if (list != null) {
                i3 = list.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = (a16 + i3) * 31;
            List<Long> list2 = this.gcData;
            if (list2 != null) {
                i16 = list2.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "PerfData(costTime=" + this.costTime + ", frameCost=" + this.frameCost + ", gcData=" + this.gcData + ")";
        }
    }

    void a(@NotNull b perfData);

    void c(long time);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.api.perf.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0622a {
        public static void a(@NotNull a aVar, @NotNull b perfData) {
            Intrinsics.checkNotNullParameter(perfData, "perfData");
        }

        public static void b(@NotNull a aVar, long j3) {
        }
    }
}
