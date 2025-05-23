package com.tencent.mobileqq.zplan.event.impl.report.reportMsg;

import av4.f;
import av4.g;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.event.impl.db.reportMsg.ZPlanReportMsgEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uh3.a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/event/impl/report/reportMsg/ZPlanReportMsgCacheHandler;", "Luh3/a;", "", "a", "", "Ljava/lang/String;", "TAG", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mRequestingFlag", "<init>", "()V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanReportMsgCacheHandler implements a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy<com.tencent.mobileqq.zootopia.service.a> f333445d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "ZPlanReportMsgCacheHandler";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean mRequestingFlag = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/event/impl/report/reportMsg/ZPlanReportMsgCacheHandler$a;", "", "Lcom/tencent/mobileqq/zootopia/service/a;", "service$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/service/a;", "service", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.event.impl.report.reportMsg.ZPlanReportMsgCacheHandler$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.tencent.mobileqq.zootopia.service.a a() {
            return (com.tencent.mobileqq.zootopia.service.a) ZPlanReportMsgCacheHandler.f333445d.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/event/impl/report/reportMsg/ZPlanReportMsgCacheHandler$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lav4/g;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements e<g> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<ZPlanReportMsgEntity> f333448d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanReportMsgCacheHandler f333449e;

        b(List<ZPlanReportMsgEntity> list, ZPlanReportMsgCacheHandler zPlanReportMsgCacheHandler) {
            this.f333448d = list;
            this.f333449e = zPlanReportMsgCacheHandler;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(g result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("ZPlanReportMsgPlugin", 1, "result:" + result);
            th3.a.f436337b.c(this.f333448d);
            this.f333449e.mRequestingFlag.set(false);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.d("ZPlanReportMsgPlugin", 1, "error:" + error + ", message" + message);
            this.f333449e.mRequestingFlag.set(false);
        }
    }

    static {
        Lazy<com.tencent.mobileqq.zootopia.service.a> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zootopia.service.a>() { // from class: com.tencent.mobileqq.zplan.event.impl.report.reportMsg.ZPlanReportMsgCacheHandler$Companion$service$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.zootopia.service.a invoke() {
                return new com.tencent.mobileqq.zootopia.service.a();
            }
        });
        f333445d = lazy;
    }

    @Override // uh3.a
    public boolean a() {
        th3.a aVar = th3.a.f436337b;
        List<ZPlanReportMsgEntity> e16 = aVar.e();
        if (e16.isEmpty()) {
            QLog.w(this.TAG, 1, "handleCacheData empty!");
            return false;
        }
        if (this.mRequestingFlag.get()) {
            QLog.w(this.TAG, 1, "handleCacheData mRequestingFlag is true!");
            return true;
        }
        this.mRequestingFlag.set(true);
        f fVar = new f();
        fVar.f27019a = aVar.m(e16);
        INSTANCE.a().e(fVar, new b(e16, this));
        return true;
    }
}
