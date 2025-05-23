package com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.repository;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.api.f;
import com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.repository.a;
import com.tencent.protofile.TroopMemberDetectSvr$QueryDuplicateMembersReq;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0082\u0001\u0010\u0019\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\rj\u0002`\u00112:\u0010\u0018\u001a6\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\t0\u0013j\u0002`\u0017H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/repository/a;", "", "", "service", "method", "", "data", "Lcom/tencent/mobileqq/troop/api/f;", "callback", "", "b", "", "groupIds", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rspData", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/repository/DuplicateMembersSuccessBlock;", "successBlock", "Lkotlin/Function2;", "", "errorCode", "errorMsg", "Lcom/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/repository/TroopQueryErrorBlock;", "errorBlock", "a", "([Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f300571a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/repository/a$a", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "rsp", "", "b", "error", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.repository.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8819a implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f300572a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<byte[], Unit> f300573b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f300574c;

        /* JADX WARN: Multi-variable type inference failed */
        C8819a(String[] strArr, Function1<? super byte[], Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
            this.f300572a = strArr;
            this.f300573b = function1;
            this.f300574c = function2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, strArr, function1, function2);
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
            QLog.e("TroopMemberDistinct", 1, "rsp QueryDuplicateMembers error, [reqGroupCount:" + this.f300572a.length + " code:" + error.code + " msg:" + error.f293941msg + "]");
            Function2<Integer, String, Unit> function2 = this.f300574c;
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
            QLog.i("TroopMemberDistinct", 1, "rsp QueryDuplicateMembers success, [reqGroupCount:" + this.f300572a.length + "]");
            this.f300573b.invoke(rsp.data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopmanager/modules/memberdistinct/repository/a$b", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "rsp", "", "b", "error", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f300575a;

        b(f fVar) {
            this.f300575a = fVar;
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
            final f fVar = this.f300575a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.repository.c
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.e(f.this, error);
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
            final f fVar = this.f300575a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.repository.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.f(f.this, rsp);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58361);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f300571a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(String service, String method, byte[] data, f callback) {
        ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest(service, method, data, 1, null, new b(callback));
    }

    public void a(@NotNull String[] groupIds, @NotNull Function1<? super byte[], Unit> successBlock, @NotNull Function2<? super Integer, ? super String, Unit> errorBlock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, groupIds, successBlock, errorBlock);
            return;
        }
        Intrinsics.checkNotNullParameter(groupIds, "groupIds");
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        Intrinsics.checkNotNullParameter(errorBlock, "errorBlock");
        TroopMemberDetectSvr$QueryDuplicateMembersReq troopMemberDetectSvr$QueryDuplicateMembersReq = new TroopMemberDetectSvr$QueryDuplicateMembersReq();
        for (String str : groupIds) {
            troopMemberDetectSvr$QueryDuplicateMembersReq.group_ids.add(Long.valueOf(Long.parseLong(str)));
        }
        b("trpc.iqun.qun_detect_svr.QunDetectSvr", "/trpc.iqun.qun_detect_svr.QunDetectSvr/QueryDuplicateMembers", troopMemberDetectSvr$QueryDuplicateMembersReq.toByteArray(), new C8819a(groupIds, successBlock, errorBlock));
        QLog.i("TroopMemberDistinct", 1, "req QueryDuplicateMembers, [reqGroupCount:" + groupIds.length + "]");
    }
}
