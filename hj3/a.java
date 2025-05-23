package hj3;

import com.tencent.mobileqq.zplan.ZPlanAppInterface;
import java.util.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\rJ\u001f\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lhj3/a;", "Ljava/util/Observable;", "", "", "data", "", "a", "([Ljava/lang/Object;)V", "Lcom/tencent/mobileqq/zplan/ZPlanAppInterface;", "Lcom/tencent/mobileqq/zplan/ZPlanAppInterface;", "getMApp", "()Lcom/tencent/mobileqq/zplan/ZPlanAppInterface;", "setMApp", "(Lcom/tencent/mobileqq/zplan/ZPlanAppInterface;)V", "mApp", "appInterface", "<init>", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends Observable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ZPlanAppInterface mApp;

    public a(ZPlanAppInterface appInterface) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        this.mApp = appInterface;
    }

    public final synchronized void a(Object[] data) {
        super.setChanged();
        super.notifyObservers(data);
    }
}
