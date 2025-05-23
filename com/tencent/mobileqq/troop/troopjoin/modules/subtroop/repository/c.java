package com.tencent.mobileqq.troop.troopjoin.modules.subtroop.repository;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.api.f;
import com.tencent.mobileqq.troop.troopjoin.modules.subtroop.repository.c;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$RetrieveSubGroupReq;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J{\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022%\u0010\u000b\u001a!\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\n2:\u0010\u0011\u001a6\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t0\fj\u0002`\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/troopjoin/modules/subtroop/repository/c;", "", "", "troopId", "Lkotlin/Function1;", "Ltencent/trpcprotocol/TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;", "Lkotlin/ParameterName;", "name", "subTroopInfo", "", "Lcom/tencent/mobileqq/troop/troopjoin/modules/subtroop/repository/SubTroopSuccessBlock;", "successBlock", "Lkotlin/Function2;", "", "errorCode", "errorMsg", "Lcom/tencent/mobileqq/troop/troopjoin/modules/subtroop/repository/SubTroopErrorBlock;", "errorBlock", "", "isFromTroopCard", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f300484a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopjoin/modules/subtroop/repository/c$a", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "rsp", "", "b", "error", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f300485a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit> f300486b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f300487c;

        /* JADX WARN: Multi-variable type inference failed */
        a(String str, Function1<? super TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
            this.f300485a = str;
            this.f300486b = function1;
            this.f300487c = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, function1, function2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(Function2 errorBlock, TroopTrpcRemoteResponse error) {
            Intrinsics.checkNotNullParameter(errorBlock, "$errorBlock");
            Intrinsics.checkNotNullParameter(error, "$error");
            Integer valueOf = Integer.valueOf(error.code);
            String str = error.f293941msg;
            if (str == null) {
                str = "";
            }
            errorBlock.invoke(valueOf, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(Function1 successBlock, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp rspModel) {
            Intrinsics.checkNotNullParameter(successBlock, "$successBlock");
            Intrinsics.checkNotNullParameter(rspModel, "$rspModel");
            successBlock.invoke(rspModel);
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
            final Function2<Integer, String, Unit> function2 = this.f300487c;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopjoin.modules.subtroop.repository.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.a.e(Function2.this, error);
                }
            });
            String str = this.f300485a;
            int i3 = error.code;
            String str2 = error.f293941msg;
            if (str2 == null) {
                str2 = "";
            }
            QLog.e("TroopSubTroop", 1, "req sub troop failure, [troopId:" + str + " code:" + i3 + " msg:" + str2 + "]");
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse rsp) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            final TroopJoinQunAutoSwitch$RetrieveSubGroupRsp troopJoinQunAutoSwitch$RetrieveSubGroupRsp = new TroopJoinQunAutoSwitch$RetrieveSubGroupRsp();
            byte[] bArr = rsp.data;
            if (bArr != null) {
                try {
                    troopJoinQunAutoSwitch$RetrieveSubGroupRsp.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("TroopSubTroop", 1, "parse sub troop protoc error:", e16);
                }
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function1<TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit> function1 = this.f300486b;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopjoin.modules.subtroop.repository.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.a.f(Function1.this, troopJoinQunAutoSwitch$RetrieveSubGroupRsp);
                }
            });
            String str2 = this.f300485a;
            PBStringField pBStringField = troopJoinQunAutoSwitch$RetrieveSubGroupRsp.group_id;
            if (pBStringField != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            QLog.i("TroopSubTroop", 1, "req sub troop success, [troopId:" + str2 + " subTroopId:" + str + "]");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57933);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f300484a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(@NotNull String troopId, @NotNull Function1<? super TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit> successBlock, @NotNull Function2<? super Integer, ? super String, Unit> errorBlock, boolean isFromTroopCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopId, successBlock, errorBlock, Boolean.valueOf(isFromTroopCard));
            return;
        }
        Intrinsics.checkNotNullParameter(troopId, "troopId");
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        Intrinsics.checkNotNullParameter(errorBlock, "errorBlock");
        TroopJoinQunAutoSwitch$RetrieveSubGroupReq troopJoinQunAutoSwitch$RetrieveSubGroupReq = new TroopJoinQunAutoSwitch$RetrieveSubGroupReq();
        troopJoinQunAutoSwitch$RetrieveSubGroupReq.group_id.set(troopId);
        if (isFromTroopCard) {
            troopJoinQunAutoSwitch$RetrieveSubGroupReq.scene.set(1);
        }
        ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.iqun.join_qun_auto_switch.JoinQunAutoSwitch", "/trpc.iqun.join_qun_auto_switch.JoinQunAutoSwitch/RetrieveSubGroup", troopJoinQunAutoSwitch$RetrieveSubGroupReq.toByteArray(), 1, null, new a(troopId, successBlock, errorBlock));
        QLog.i("TroopSubTroop", 1, "req sub troop, [troopId:" + troopId + "]");
    }
}
