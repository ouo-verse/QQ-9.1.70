package com.tencent.mobileqq.troop.troopownertask.api.impl;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.api.f;
import com.tencent.protofile.QunOwnerTaskSvrPB$GetMsgReq;
import com.tencent.protofile.QunOwnerTaskSvrPB$GetMsgRsp;
import com.tencent.protofile.QunOwnerTaskSvrPB$ReportMsgReq;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015JH\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000228\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004J\u001c\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/troopownertask/api/impl/e;", "", "", "groupUin", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/protofile/QunOwnerTaskSvrPB$GetMsgRsp;", "rsp", "", "callback", "b", "", "", "subTaskId", "", GdtGetUserInfoHandler.KEY_AREA, "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f300991a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopownertask/api/impl/e$a", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "successResponse", "", "b", "errorResponse", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse errorResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            if (QLog.isColorLevel()) {
                QLog.d("TroopOwnerTaskNetRepo", 2, "onError: code:" + Integer.valueOf(errorResponse.code) + ", msg:" + errorResponse.f293941msg);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse successResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) successResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            if (QLog.isColorLevel()) {
                QLog.d("TroopOwnerTaskNetRepo", 2, "onSuccess: code:" + Integer.valueOf(successResponse.code) + ", msg:" + successResponse.f293941msg);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopownertask/api/impl/e$b", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "successResponse", "", "b", "errorResponse", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, QunOwnerTaskSvrPB$GetMsgRsp, Unit> f300992a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super QunOwnerTaskSvrPB$GetMsgRsp, Unit> function2) {
            this.f300992a = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse errorResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            QLog.e("TroopOwnerTaskNetRepo", 1, "/trpc.iqun.qun_owner_task_svr.QunOwnerTaskSvr/GetMsg onError code:" + Integer.valueOf(errorResponse.code) + ", msg:" + errorResponse.f293941msg);
            this.f300992a.invoke(Boolean.FALSE, null);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse successResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) successResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            QLog.i("TroopOwnerTaskNetRepo", 1, "/trpc.iqun.qun_owner_task_svr.QunOwnerTaskSvr/GetMsg onSuccess code:" + Integer.valueOf(successResponse.code) + ", msg:" + successResponse.f293941msg);
            Function2<Boolean, QunOwnerTaskSvrPB$GetMsgRsp, Unit> function2 = this.f300992a;
            try {
                QunOwnerTaskSvrPB$GetMsgRsp qunOwnerTaskSvrPB$GetMsgRsp = new QunOwnerTaskSvrPB$GetMsgRsp();
                qunOwnerTaskSvrPB$GetMsgRsp.mergeFrom(successResponse.data);
                function2.invoke(Boolean.TRUE, qunOwnerTaskSvrPB$GetMsgRsp);
            } catch (Throwable th5) {
                QLog.e("TroopOwnerTaskNetRepo", 1, "/trpc.iqun.qun_owner_task_svr.QunOwnerTaskSvr/GetMsg onSuccess exception:" + th5);
                function2.invoke(Boolean.FALSE, null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60048);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f300991a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull List<String> subTaskId, int area) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) subTaskId, area);
            return;
        }
        Intrinsics.checkNotNullParameter(subTaskId, "subTaskId");
        if (QLog.isColorLevel()) {
            QLog.d("TroopOwnerTaskNetRepo", 2, "reportMsgRead subTaskIdSize:" + subTaskId.size() + ", subTaskId0:" + ((Object) subTaskId.get(0)) + ", area:" + area);
        }
        QunOwnerTaskSvrPB$ReportMsgReq qunOwnerTaskSvrPB$ReportMsgReq = new QunOwnerTaskSvrPB$ReportMsgReq();
        qunOwnerTaskSvrPB$ReportMsgReq.sub_task_ids.set(subTaskId);
        ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.iqun.qun_owner_task_svr.QunOwnerTaskSvr", "/trpc.iqun.qun_owner_task_svr.QunOwnerTaskSvr/ReportMsg", qunOwnerTaskSvrPB$ReportMsgReq.toByteArray(), 1, null, new a());
    }

    public final void b(long groupUin, @NotNull Function2<? super Boolean, ? super QunOwnerTaskSvrPB$GetMsgRsp, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(groupUin), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (QLog.isColorLevel()) {
            QLog.d("TroopOwnerTaskNetRepo", 2, "requestTask groupUin:" + groupUin);
        }
        QunOwnerTaskSvrPB$GetMsgReq qunOwnerTaskSvrPB$GetMsgReq = new QunOwnerTaskSvrPB$GetMsgReq();
        qunOwnerTaskSvrPB$GetMsgReq.group_id.set(groupUin);
        ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.iqun.qun_owner_task_svr.QunOwnerTaskSvr", "/trpc.iqun.qun_owner_task_svr.QunOwnerTaskSvr/GetMsg", qunOwnerTaskSvrPB$GetMsgReq.toByteArray(), 1, null, new b(callback));
    }
}
