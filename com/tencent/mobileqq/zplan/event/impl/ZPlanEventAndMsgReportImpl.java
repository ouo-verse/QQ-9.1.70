package com.tencent.mobileqq.zplan.event.impl;

import av4.d;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.event.api.Event;
import com.tencent.mobileqq.zplan.report.ReportMsgProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.report.ReportMsgBean;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/event/impl/ZPlanEventAndMsgReportImpl;", "Lrh3/a;", "Lcom/tencent/mobileqq/zplan/event/api/Event;", "event", "Lrh3/b;", "cb", "", "report", "", "eventList", "", "reqString", "reportMsg", "Lcom/tencent/sqshow/zootopia/report/ReportMsgBean;", "Lav4/d;", "msgInfo", "initRegisterDatabaseModelClass", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEventAndMsgReportImpl implements rh3.a {
    private static final String TAG = "ZPlanEventReportImpl_";
    private static final Lazy<com.tencent.mobileqq.zootopia.service.a> service$delegate;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/event/impl/ZPlanEventAndMsgReportImpl$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lvu4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements e<vu4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Event f333437d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ rh3.b f333438e;

        b(Event event, rh3.b bVar) {
            this.f333437d = event;
            this.f333438e = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(vu4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i(ZPlanEventAndMsgReportImpl.TAG, 1, "ZPlanEventReportImpl report onResultSuccess " + result.f443552a + " " + result.f443553b + ", event:" + this.f333437d);
            this.f333438e.onSuccess();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i(ZPlanEventAndMsgReportImpl.TAG, 1, "ZPlanEventReportImpl report onResultFailure " + error + " " + message + ", event:" + this.f333437d);
            rh3.b bVar = this.f333438e;
            if (message == null) {
                message = "";
            }
            bVar.onFailed(error, message);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/event/impl/ZPlanEventAndMsgReportImpl$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lvu4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements e<vu4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<Event> f333439d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ rh3.b f333440e;

        c(List<Event> list, rh3.b bVar) {
            this.f333439d = list;
            this.f333440e = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(vu4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i(ZPlanEventAndMsgReportImpl.TAG, 1, "ZPlanEventReportImpl report onResultSuccess " + result.f443552a + " " + result.f443553b + ", eventList:" + this.f333439d);
            this.f333440e.onSuccess();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i(ZPlanEventAndMsgReportImpl.TAG, 1, "ZPlanEventReportImpl report onResultFailure " + error + " " + message + ", eventList:" + this.f333439d);
            rh3.b bVar = this.f333440e;
            if (message == null) {
                message = "";
            }
            bVar.onFailed(error, message);
        }
    }

    static {
        Lazy<com.tencent.mobileqq.zootopia.service.a> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zootopia.service.a>() { // from class: com.tencent.mobileqq.zplan.event.impl.ZPlanEventAndMsgReportImpl$Companion$service$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.zootopia.service.a invoke() {
                return new com.tencent.mobileqq.zootopia.service.a();
            }
        });
        service$delegate = lazy;
    }

    @Override // rh3.a
    public void initRegisterDatabaseModelClass() {
        com.tencent.mobileqq.zplan.event.impl.b.f333443a.a();
    }

    @Override // rh3.a
    public void report(Event event, rh3.b cb5) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        com.tencent.mobileqq.zplan.event.impl.b.f333443a.b(event, new b(event, cb5));
    }

    @Override // rh3.a
    public void reportMsg(String reqString, rh3.b cb5) {
        Intrinsics.checkNotNullParameter(reqString, "reqString");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ReportMsgProxy.f335040a.d(reqString, cb5);
    }

    public void report(List<Event> eventList, rh3.b cb5) {
        Intrinsics.checkNotNullParameter(eventList, "eventList");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        com.tencent.mobileqq.zplan.event.impl.b.f333443a.c(eventList, new c(eventList, cb5));
    }

    @Override // rh3.a
    public void reportMsg(ReportMsgBean reqString, rh3.b cb5) {
        Intrinsics.checkNotNullParameter(reqString, "reqString");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ReportMsgProxy.f335040a.c(reqString, cb5);
    }

    @Override // rh3.a
    public void reportMsg(d msgInfo, rh3.b cb5) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ReportMsgProxy.f335040a.b(msgInfo, cb5);
    }
}
