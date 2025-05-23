package na4;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.f;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import na4.d;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0002\u000f\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J*\u0010\f\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R$\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lna4/d;", "", "Lcom/tencent/sqshow/zootopia/player/f;", "options", "Lna4/d$b;", "callBack", "", "g", "Ljava/util/LinkedList;", "", "processOrder", "i", "j", "Ljava/util/LinkedHashMap;", "Lna4/a;", "a", "Ljava/util/LinkedHashMap;", "mProcessMap", "<init>", "()V", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static int f419580c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static int f419581d;

    /* renamed from: e, reason: collision with root package name */
    private static int f419582e;

    /* renamed from: f, reason: collision with root package name */
    private static int f419583f;

    /* renamed from: g, reason: collision with root package name */
    private static int f419584g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile d f419585h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LinkedHashMap<Integer, a> mProcessMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lna4/d$a;", "", "Lna4/d;", "a", "", "PROCESS_URL_SELECTED", "I", "b", "()I", "setPROCESS_URL_SELECTED", "(I)V", "", "TAG", "Ljava/lang/String;", "sInstance", "Lna4/d;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: na4.d$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            if (d.f419585h == null) {
                synchronized (d.class) {
                    if (d.f419585h == null) {
                        d.f419585h = new d(null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            d dVar = d.f419585h;
            Intrinsics.checkNotNull(dVar);
            return dVar;
        }

        public final int b() {
            return d.f419583f;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lna4/d$b;", "", "Lcom/tencent/sqshow/zootopia/player/f;", "options", "", "continueNextProcess", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface b {
        void a(f options, boolean continueNextProcess);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"na4/d$c", "Lna4/d$b;", "Lcom/tencent/sqshow/zootopia/player/f;", "options", "", "continueNext", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LinkedList<Integer> f419588b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f419589c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f419590d;

        c(LinkedList<Integer> linkedList, b bVar, int i3) {
            this.f419588b = linkedList;
            this.f419589c = bVar;
            this.f419590d = i3;
        }

        @Override // na4.d.b
        public void a(f options, boolean continueNext) {
            Intrinsics.checkNotNullParameter(options, "options");
            if (continueNext) {
                d dVar = d.this;
                dVar.j(dVar.i(this.f419588b), options, this.f419589c);
                return;
            }
            QLog.d("QFSPlayerOptionsProcessManager", 1, "startProcess()| end by startKey:" + this.f419590d + "currentOption:" + options);
            d.this.g(options, this.f419589c);
        }
    }

    static {
        int i3 = 1 + 1;
        f419581d = i3;
        int i16 = i3 + 1;
        f419582e = i16;
        int i17 = i16 + 1;
        f419583f = i17;
        f419584g = i17 + 1;
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(b bVar, f options) {
        Intrinsics.checkNotNullParameter(options, "$options");
        bVar.a(options, false);
    }

    d() {
        LinkedHashMap<Integer, a> linkedHashMap = new LinkedHashMap<>();
        this.mProcessMap = linkedHashMap;
        linkedHashMap.put(Integer.valueOf(f419583f), new na4.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinkedList<Integer> i(LinkedList<Integer> processOrder) {
        if (processOrder != null && processOrder.size() != 0) {
            processOrder.remove(0);
            return processOrder;
        }
        return new LinkedList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(final f options, final b callBack) {
        if (callBack == null) {
            return;
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            callBack.a(options, false);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: na4.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.h(d.b.this, options);
                }
            });
        }
    }

    public final void j(LinkedList<Integer> processOrder, f options, b callBack) {
        if (options == null || processOrder == null || callBack == null) {
            return;
        }
        if (processOrder.size() == 0) {
            QLog.d("QFSPlayerOptionsProcessManager", 1, "startProcess()| end order empty| current option" + options);
            g(options, callBack);
            return;
        }
        Integer num = processOrder.get(0);
        Intrinsics.checkNotNullExpressionValue(num, "processOrder[0]");
        int intValue = num.intValue();
        a aVar = this.mProcessMap.get(Integer.valueOf(intValue));
        if (aVar == null) {
            QLog.d("QFSPlayerOptionsProcessManager", 1, "startProcess()|  edn error key");
            g(options, callBack);
        } else {
            aVar.b(options, new c(processOrder, callBack, intValue));
        }
    }
}
