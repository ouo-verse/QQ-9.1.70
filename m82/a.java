package m82;

import com.tencent.biz.richframework.order.RFWOrderElementFactory;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.mobileqq.matchfriend.reborn.guide.manager.util.ScheduleManager;
import com.tencent.mobileqq.matchfriend.reborn.guide.manager.util.ScheduleManagerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lm82/a;", "", "Lcom/tencent/biz/richframework/order/RFWOrderElementManager;", "b", "Lcom/tencent/mobileqq/matchfriend/reborn/guide/manager/util/ScheduleManager;", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f416439a = new a();

    a() {
    }

    public final ScheduleManager a() {
        return ScheduleManagerFactory.INSTANCE.a("qqstranger");
    }

    public final RFWOrderElementManager b() {
        RFWOrderElementManager orderElementManager = RFWOrderElementFactory.getOrderElementManager("qqstranger");
        Intrinsics.checkNotNullExpressionValue(orderElementManager, "getOrderElementManager(BUSINESS_TAG)");
        return orderElementManager;
    }
}
