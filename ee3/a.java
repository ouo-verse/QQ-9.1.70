package ee3;

import com.tencent.state.data.SquareJSConst;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\f\u0004B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J \u0010\u0015\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0013J\u0010\u0010\u0016\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001c\u00a8\u0006 "}, d2 = {"Lee3/a;", "", "", "e", "b", "", "selfUin", "c", "d", "", "oldId", "newId", "a", "oldPanel", "newPanel", "g", "", "isShown", "i", "", SquareJSConst.Params.PARAMS_UIN_LIST, "f", h.F, "Lee3/a$b;", "Lee3/a$b;", "status", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lee3/a$a;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "listeners", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZPlanAIOStatus status = new ZPlanAIOStatus(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentLinkedQueue<InterfaceC10233a> listeners = new ConcurrentLinkedQueue<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lee3/a$a;", "", "", "a", "b", "", "selfUin", "d", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ee3.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public interface InterfaceC10233a {
        void a();

        void b();

        void c(String selfUin);

        void d(String selfUin);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lee3/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/concurrent/atomic/AtomicInteger;", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "()Ljava/util/concurrent/atomic/AtomicInteger;", "currentPanelId", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "zplanMemeTabShown", "<init>", "(Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicBoolean;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ee3.a$b, reason: from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class ZPlanAIOStatus {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final AtomicInteger currentPanelId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final AtomicBoolean zplanMemeTabShown;

        public ZPlanAIOStatus() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* renamed from: a, reason: from getter */
        public final AtomicInteger getCurrentPanelId() {
            return this.currentPanelId;
        }

        /* renamed from: b, reason: from getter */
        public final AtomicBoolean getZplanMemeTabShown() {
            return this.zplanMemeTabShown;
        }

        public int hashCode() {
            return (this.currentPanelId.hashCode() * 31) + this.zplanMemeTabShown.hashCode();
        }

        public String toString() {
            return "ZPlanAIOStatus(currentPanelId=" + this.currentPanelId + ", zplanMemeTabShown=" + this.zplanMemeTabShown + ")";
        }

        public ZPlanAIOStatus(AtomicInteger currentPanelId, AtomicBoolean zplanMemeTabShown) {
            Intrinsics.checkNotNullParameter(currentPanelId, "currentPanelId");
            Intrinsics.checkNotNullParameter(zplanMemeTabShown, "zplanMemeTabShown");
            this.currentPanelId = currentPanelId;
            this.zplanMemeTabShown = zplanMemeTabShown;
        }

        public /* synthetic */ ZPlanAIOStatus(AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new AtomicInteger(0) : atomicInteger, (i3 & 2) != 0 ? new AtomicBoolean(false) : atomicBoolean);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ZPlanAIOStatus)) {
                return false;
            }
            ZPlanAIOStatus zPlanAIOStatus = (ZPlanAIOStatus) other;
            return Intrinsics.areEqual(this.currentPanelId, zPlanAIOStatus.currentPanelId) && Intrinsics.areEqual(this.zplanMemeTabShown, zPlanAIOStatus.zplanMemeTabShown);
        }
    }

    private final void b() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC10233a) it.next()).b();
        }
    }

    private final void c(String selfUin) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC10233a) it.next()).d(selfUin);
        }
    }

    private final void d(String selfUin) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC10233a) it.next()).c(selfUin);
        }
    }

    private final void e() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC10233a) it.next()).a();
        }
    }

    public final void f(String selfUin, List<String> uinList) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        if (selfUin == null || !uinList.contains(selfUin)) {
            return;
        }
        c(selfUin);
    }

    public final void g(int oldPanel, int newPanel) {
        this.status.getCurrentPanelId().getAndSet(newPanel);
        if (oldPanel == 3 && this.status.getZplanMemeTabShown().get()) {
            b();
        }
    }

    public final void i(boolean isShown) {
        if (this.status.getZplanMemeTabShown().compareAndSet(!isShown, isShown)) {
            if (this.status.getZplanMemeTabShown().get() && this.status.getCurrentPanelId().get() == 3) {
                e();
            } else {
                b();
            }
        }
    }

    public final void h(String selfUin) {
        if (selfUin != null) {
            d(selfUin);
        }
    }

    public final void a(int oldId, int newId) {
        if (newId == 3 && this.status.getZplanMemeTabShown().get()) {
            e();
        }
    }
}
