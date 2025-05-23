package com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.repo;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.api.f;
import com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.TroopMultiGroupManageDataFrom;
import com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.TroopMultiGroupManageItemType;
import com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.d;
import com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.e;
import com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.repo.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.trpcprotocol.TroopMultiGroupManageSvr$AddMethod;
import tencent.trpcprotocol.TroopMultiGroupManageSvr$GetHomeReq;
import tencent.trpcprotocol.TroopMultiGroupManageSvr$GetHomeRsp;
import tencent.trpcprotocol.TroopMultiGroupManageSvr$InviteMethod;
import tencent.trpcprotocol.TroopMultiGroupManageSvr$SetAddMethodReq;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002Jy\u0010\u001b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2+\u0010\u0014\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\rj\u0002`\u00132:\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u0019H\u0016Jt\u0010#\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\t0!j\u0002`\"2:\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u0019H\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/repo/a;", "", "", "service", "method", "", "data", "Lcom/tencent/mobileqq/troop/api/f;", "callback", "", "c", "", "groupId", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/f;", "Lkotlin/ParameterName;", "name", "dataList", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/repo/MultiGroupHomeDataSuccessBlock;", "successBlock", "Lkotlin/Function2;", "", "errorCode", "errorMsg", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/repo/TroopMultiGroupManageErrorBlock;", "errorBlock", "a", "groupIds", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/e;", "addMethod", "Ltencent/trpcprotocol/TroopMultiGroupManageSvr$InviteMethod;", "inviteMethod", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/repo/MultiGroupSetAddMethodSuccessBlock;", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f297668a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/jointype/troopmanage/multigroup/repo/a$a", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "rsp", "", "b", "error", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.repo.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8758a implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<List<com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f>, Unit> f297669a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f297670b;

        /* JADX WARN: Multi-variable type inference failed */
        C8758a(Function1<? super List<com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f>, Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
            this.f297669a = function1;
            this.f297670b = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1, (Object) function2);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            Intrinsics.checkNotNullParameter(error, "error");
            QLog.e("TroopMultiGroupManageRepository", 1, "rsp reqQueryMultiGroupManageHome error, code:" + error.code + " msg:" + error.f293941msg + "]");
            Function2<Integer, String, Unit> function2 = this.f297670b;
            Integer valueOf = Integer.valueOf(error.code);
            String str = error.f293941msg;
            Intrinsics.checkNotNullExpressionValue(str, "error.msg");
            function2.invoke(valueOf, str);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.i("TroopMultiGroupManageRepository", 1, "rsp reqQueryMultiGroupManageHome success");
            ArrayList arrayList = new ArrayList();
            try {
                TroopMultiGroupManageSvr$GetHomeRsp troopMultiGroupManageSvr$GetHomeRsp = new TroopMultiGroupManageSvr$GetHomeRsp();
                troopMultiGroupManageSvr$GetHomeRsp.mergeFrom(rsp.data);
                com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.a aVar = new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.a(troopMultiGroupManageSvr$GetHomeRsp.total_member.num.get(), troopMultiGroupManageSvr$GetHomeRsp.total_member.change.get());
                com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.a aVar2 = new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.a(troopMultiGroupManageSvr$GetHomeRsp.avg_member.num.get(), troopMultiGroupManageSvr$GetHomeRsp.avg_member.change.get());
                com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.a aVar3 = new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.a(troopMultiGroupManageSvr$GetHomeRsp.total_manager.num.get(), troopMultiGroupManageSvr$GetHomeRsp.total_manager.change.get());
                long j3 = troopMultiGroupManageSvr$GetHomeRsp.total_group_num.get();
                String str = troopMultiGroupManageSvr$GetHomeRsp.jump_info.data_center.get();
                Intrinsics.checkNotNullExpressionValue(str, "homeRsp.jump_info.data_center.get()");
                String str2 = troopMultiGroupManageSvr$GetHomeRsp.jump_info.member_manage.get();
                Intrinsics.checkNotNullExpressionValue(str2, "homeRsp.jump_info.member_manage.get()");
                String str3 = troopMultiGroupManageSvr$GetHomeRsp.jump_info.add_manage.get();
                Intrinsics.checkNotNullExpressionValue(str3, "homeRsp.jump_info.add_manage.get()");
                String str4 = troopMultiGroupManageSvr$GetHomeRsp.jump_info.batch_manage.get();
                Intrinsics.checkNotNullExpressionValue(str4, "homeRsp.jump_info.batch_manage.get()");
                d dVar = new d(str, str2, str3, str4);
                String str5 = troopMultiGroupManageSvr$GetHomeRsp.group_wording.get();
                Intrinsics.checkNotNullExpressionValue(str5, "homeRsp.group_wording.get()");
                com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b bVar = new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.b(aVar, aVar2, aVar3, j3, dVar, str5);
                TroopMultiGroupManageItemType troopMultiGroupManageItemType = TroopMultiGroupManageItemType.MULTI_GROUP_MANAGE_DATA;
                TroopMultiGroupManageDataFrom troopMultiGroupManageDataFrom = TroopMultiGroupManageDataFrom.MULTI_GROUP_MANAGE_DATA_FROM_SERVER;
                arrayList.add(new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f(troopMultiGroupManageItemType, bVar, null, troopMultiGroupManageDataFrom, 4, null));
                arrayList.add(new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f(TroopMultiGroupManageItemType.MULTI_GROUP_MANAGE_OPERATION, bVar, null, troopMultiGroupManageDataFrom, 4, null));
            } catch (Throwable th5) {
                QLog.e("TroopMultiGroupManageRepository", 1, "reqQueryMultiGroupManageHome onSuccess exception:" + th5);
            }
            this.f297669a.invoke(arrayList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/jointype/troopmanage/multigroup/repo/a$b", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "rsp", "", "b", "error", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f297671a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f297672b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function0<Unit> function0, Function2<? super Integer, ? super String, Unit> function2) {
            this.f297671a = function0;
            this.f297672b = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0, (Object) function2);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            Intrinsics.checkNotNullParameter(error, "error");
            QLog.e("TroopMultiGroupManageRepository", 1, "rsp reqSetAddMethod error, code:" + error.code + " msg:" + error.f293941msg + "]");
            Function2<Integer, String, Unit> function2 = this.f297672b;
            Integer valueOf = Integer.valueOf(error.code);
            String str = error.f293941msg;
            Intrinsics.checkNotNullExpressionValue(str, "error.msg");
            function2.invoke(valueOf, str);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.i("TroopMultiGroupManageRepository", 1, "rsp reqSetAddMethod success");
            this.f297671a.invoke();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/jointype/troopmanage/multigroup/repo/a$c", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "rsp", "", "b", "error", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f297673a;

        c(f fVar) {
            this.f297673a = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(f callback, TroopTrpcRemoteResponse error) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(error, "$error");
            callback.a(error);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(f callback, TroopTrpcRemoteResponse rsp) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(rsp, "$rsp");
            callback.b(rsp);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull final TroopTrpcRemoteResponse error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            Intrinsics.checkNotNullParameter(error, "error");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final f fVar = this.f297673a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.repo.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.c.e(f.this, error);
                }
            });
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull final TroopTrpcRemoteResponse rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final f fVar = this.f297673a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.repo.c
                @Override // java.lang.Runnable
                public final void run() {
                    a.c.f(f.this, rsp);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54410);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f297668a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(String service, String method, byte[] data, f callback) {
        ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest(service, method, data, 1, null, new c(callback));
    }

    public void a(long groupId, @NotNull Function1<? super List<com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.f>, Unit> successBlock, @NotNull Function2<? super Integer, ? super String, Unit> errorBlock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(groupId), successBlock, errorBlock);
            return;
        }
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        Intrinsics.checkNotNullParameter(errorBlock, "errorBlock");
        TroopMultiGroupManageSvr$GetHomeReq troopMultiGroupManageSvr$GetHomeReq = new TroopMultiGroupManageSvr$GetHomeReq();
        troopMultiGroupManageSvr$GetHomeReq.group_id.set(groupId);
        c("trpc.iqun.multi_group_manage_svr.MultiGroupManageSvr", "/trpc.iqun.multi_group_manage_svr.MultiGroupManageSvr/GetHome", troopMultiGroupManageSvr$GetHomeReq.toByteArray(), new C8758a(successBlock, errorBlock));
        QLog.i("TroopMultiGroupManageRepository", 1, "req QueryMultiGroupManageHome");
    }

    public void b(@NotNull List<Long> groupIds, @NotNull e addMethod, @NotNull TroopMultiGroupManageSvr$InviteMethod inviteMethod, @NotNull Function0<Unit> successBlock, @NotNull Function2<? super Integer, ? super String, Unit> errorBlock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, groupIds, addMethod, inviteMethod, successBlock, errorBlock);
            return;
        }
        Intrinsics.checkNotNullParameter(groupIds, "groupIds");
        Intrinsics.checkNotNullParameter(addMethod, "addMethod");
        Intrinsics.checkNotNullParameter(inviteMethod, "inviteMethod");
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        Intrinsics.checkNotNullParameter(errorBlock, "errorBlock");
        TroopMultiGroupManageSvr$SetAddMethodReq troopMultiGroupManageSvr$SetAddMethodReq = new TroopMultiGroupManageSvr$SetAddMethodReq();
        troopMultiGroupManageSvr$SetAddMethodReq.group_ids.set(groupIds);
        TroopMultiGroupManageSvr$AddMethod troopMultiGroupManageSvr$AddMethod = new TroopMultiGroupManageSvr$AddMethod();
        troopMultiGroupManageSvr$AddMethod.add_option.set(addMethod.a());
        troopMultiGroupManageSvr$AddMethod.question.set(addMethod.c());
        troopMultiGroupManageSvr$AddMethod.answer.set(addMethod.b());
        troopMultiGroupManageSvr$SetAddMethodReq.method.set(troopMultiGroupManageSvr$AddMethod);
        troopMultiGroupManageSvr$SetAddMethodReq.invite_method.set(inviteMethod);
        c("trpc.iqun.multi_group_manage_svr.MultiGroupManageSvr", "/trpc.iqun.multi_group_manage_svr.MultiGroupManageSvr/SetAddMethod", troopMultiGroupManageSvr$SetAddMethodReq.toByteArray(), new b(successBlock, errorBlock));
        QLog.i("TroopMultiGroupManageRepository", 1, "req reqSetAddMethod");
    }
}
