package jc4;

import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.push.ZPlanOIDBPushHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0006\u001a\u00020\u0003R*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Ljc4/e;", "", "Lkotlin/Function0;", "", "action", "a", "c", "Lkotlin/jvm/functions/Function0;", "b", "()Lkotlin/jvm/functions/Function0;", "setTriggerRefreshAction", "(Lkotlin/jvm/functions/Function0;)V", "triggerRefreshAction", "Lcom/tencent/mobileqq/zplan/push/i;", "Lcom/tencent/mobileqq/zplan/push/i;", "getObserver", "()Lcom/tencent/mobileqq/zplan/push/i;", "observer", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> triggerRefreshAction;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zplan.push.i observer = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"jc4/e$b", "Lcom/tencent/mobileqq/zplan/push/i;", "", "buf", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b extends com.tencent.mobileqq.zplan.push.i {
        b() {
            super(337);
        }

        @Override // com.tencent.mobileqq.zplan.push.i
        public void b(byte[] buf) {
            Function0<Unit> b16;
            Intrinsics.checkNotNullParameter(buf, "buf");
            mv4.e c16 = mv4.e.c(buf);
            QLog.d("UserCenterReddotManager", 1, "xxx- > push " + c16.f417675a);
            if (c16.f417675a != 3 || (b16 = e.this.b()) == null) {
                return;
            }
            b16.invoke();
        }
    }

    public final void a(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.triggerRefreshAction = action;
        ZPlanOIDBPushHandler a16 = ZPlanOIDBPushHandler.INSTANCE.a();
        if (a16 != null) {
            a16.F2(this.observer);
        }
    }

    public final Function0<Unit> b() {
        return this.triggerRefreshAction;
    }

    public final void c() {
        this.triggerRefreshAction = null;
        ZPlanOIDBPushHandler a16 = ZPlanOIDBPushHandler.INSTANCE.a();
        if (a16 != null) {
            a16.G2(this.observer);
        }
    }
}
