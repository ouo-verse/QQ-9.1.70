package com.tencent.mobileqq.troop.base.handler;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopAvatarLoaderApi;
import com.tencent.mobileqq.troop.api.ITroopQIPCModuleApi;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopMemberOperationRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import eipc.EIPCResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0013\b\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/base/handler/j;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "bundle", "", "callbackId", "", "w", "u", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "j", "l", "", "action", "data", "Leipc/EIPCResult;", "onCall", "name", "<init>", "(Ljava/lang/String;)V", "d", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class j extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final j f294606e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/base/handler/j$a;", "", "Lcom/tencent/mobileqq/troop/base/handler/j;", "a", "INSTANCE", "Lcom/tencent/mobileqq/troop/base/handler/j;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.base.handler.j$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final j a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return j.f294606e;
            }
            return (j) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/base/handler/j$b", "Lcom/tencent/qqnt/troopmemberlist/g;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.qqnt.troopmemberlist.g {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f294608b;

        b(int i3) {
            this.f294608b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this, i3);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.g
        public void a(@Nullable TroopMemberInfo troopMemberInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("TroopTrpcIPCModule", 4, "handleRequestLocalTroopMemberInfo onFetchDataBySubThread");
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable(GetCMShowInfoServlet.EXTRA_RESULT_DATA, troopMemberInfo);
            j.this.callbackResult(this.f294608b, EIPCResult.createSuccessResult(bundle));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/base/handler/j$c", "Lcom/tencent/mobileqq/troop/api/b;", "", "uin", "Landroid/graphics/Bitmap;", "head", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements com.tencent.mobileqq.troop.api.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f294610b;

        c(int i3) {
            this.f294610b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.b
        public void a(@NotNull String uin, @NotNull Bitmap head) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin, (Object) head);
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(head, "head");
            Bundle bundle = new Bundle();
            bundle.putString("troop_uin", uin);
            bundle.putParcelable("troop_head", head);
            j.this.callbackResult(this.f294610b, EIPCResult.createSuccessResult(bundle));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/base/handler/j$d", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "successResponse", "", "b", "errorResponse", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d implements com.tencent.mobileqq.troop.api.f {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f294612b;

        d(int i3) {
            this.f294612b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this, i3);
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
            QLog.e("TroopTrpcIPCModule", 1, "callbackResult onFail");
            Bundle bundle = new Bundle();
            if (errorResponse.data == null) {
                errorResponse.data = new byte[0];
            }
            bundle.putSerializable(GetCMShowInfoServlet.EXTRA_RESULT_DATA, errorResponse);
            j.this.callbackResult(this.f294612b, EIPCResult.createSuccessResult(bundle));
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse successResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) successResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            if (QLog.isDevelopLevel()) {
                QLog.i("TroopTrpcIPCModule", 4, "callbackResult onSuccess");
            }
            Bundle bundle = new Bundle();
            if (successResponse.data == null) {
                successResponse.data = new byte[0];
            }
            bundle.putSerializable(GetCMShowInfoServlet.EXTRA_RESULT_DATA, successResponse);
            j.this.callbackResult(this.f294612b, EIPCResult.createSuccessResult(bundle));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28280);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f294606e = new j(ITroopQIPCModuleApi.NAME);
        }
    }

    j(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    private final void j(Bundle bundle, final int callbackId) {
        String string = bundle.getString("troop_uin", "");
        String uin = bundle.getString("troop_member_uin", "");
        String string2 = bundle.getString("troop_member_uid", "");
        boolean z16 = bundle.getBoolean("troop_is_black");
        String from = bundle.getString("from", "TroopTrpcIPCModule");
        QLog.i("TroopTrpcIPCModule", 1, "[handleRequestDeleteMember] troopUin:" + string + ",uin:" + uin + ",uid:" + string2 + ",isBlack:" + z16 + ",from:" + from);
        com.tencent.qqnt.bean.b bVar = new com.tencent.qqnt.bean.b();
        if (!TextUtils.isEmpty(string2)) {
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            bVar.a(string2, uin);
        } else {
            bVar.b(uin);
        }
        bVar.troopUin = string;
        bVar.isBlack = z16;
        ITroopMemberOperationRepoApi iTroopMemberOperationRepoApi = (ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class);
        Intrinsics.checkNotNullExpressionValue(from, "from");
        iTroopMemberOperationRepoApi.deleteTroopMember(bVar, null, from, new com.tencent.qqnt.troop.c() { // from class: com.tencent.mobileqq.troop.base.handler.f
            @Override // com.tencent.qqnt.troop.c
            public final void a(boolean z17, int i3, ArrayList arrayList) {
                j.k(j.this, callbackId, z17, i3, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(j this$0, int i3, boolean z16, int i16, ArrayList deleteUins) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(deleteUins, "deleteUins");
        Bundle bundle = new Bundle();
        bundle.putBoolean("result_success", z16);
        bundle.putInt("result_code", i16);
        bundle.putStringArrayList(GetCMShowInfoServlet.EXTRA_RESULT_DATA, deleteUins);
        this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
    }

    private final void l(Bundle bundle, int callbackId) {
        boolean z16;
        String string = bundle.getString("troop_uin", "");
        QLog.i("TroopTrpcIPCModule", 1, "[handleRequestGetTroopInfo] troopUin:" + string + ",from:" + bundle.getString("from", "TroopTrpcIPCModule"));
        Bundle bundle2 = new Bundle();
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            bundle2.putBoolean("result_success", false);
        } else {
            TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(string);
            bundle2.putBoolean("result_success", true);
            bundle2.putSerializable("result_troop_info", troopInfoFromCache);
        }
        callbackResult(callbackId, EIPCResult.createSuccessResult(bundle2));
    }

    private final void m(Bundle bundle, final int callbackId) {
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopTrpcIPCModule", 4, "handleRequestLocalTroopMemberInfo");
        }
        final String string = bundle.getString("troop_uin", "");
        final String string2 = bundle.getString("troop_member_uin", "");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.base.handler.d
            @Override // java.lang.Runnable
            public final void run() {
                j.n(string, string2, this, callbackId);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String str, String str2, j this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(str, str2, false, null, "TroopTrpcIPCModule", new b(i3));
    }

    private final void o(Bundle bundle, final int callbackId) {
        final String string = bundle.getString("troop_uin", "");
        String string2 = bundle.getString("troop_member_uin", "");
        String string3 = bundle.getString("troop_member_uid", "");
        final long j3 = bundle.getLong("shut_up_timestamp");
        final String from = bundle.getString("from", "TroopTrpcIPCModule");
        QLog.i("TroopTrpcIPCModule", 1, "[handleRequestShutUpMember] troopUin:" + string + ",uin:" + string2 + ",uid:" + string3 + ",gagTimeStamp:" + j3 + ",from:" + from);
        if (!TextUtils.isEmpty(string3)) {
            ITroopMemberOperationRepoApi iTroopMemberOperationRepoApi = (ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class);
            Intrinsics.checkNotNullExpressionValue(from, "from");
            iTroopMemberOperationRepoApi.setMemberShutUp(string, string3, j3, null, from, new com.tencent.qqnt.troop.i() { // from class: com.tencent.mobileqq.troop.base.handler.g
                @Override // com.tencent.qqnt.troop.i
                public final void onResult(boolean z16, int i3, String str) {
                    j.p(j.this, callbackId, z16, i3, str);
                }
            });
            return;
        }
        ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(string2, true, true, new IRelationNTUinAndUidApi.d() { // from class: com.tencent.mobileqq.troop.base.handler.h
            @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi.d
            public final void a(String str) {
                j.q(string, j3, from, this, callbackId, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(j this$0, int i3, boolean z16, int i16, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
        Bundle bundle = new Bundle();
        bundle.putBoolean("result_success", z16);
        this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String str, long j3, String from, final j this$0, final int i3, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ITroopMemberOperationRepoApi iTroopMemberOperationRepoApi = (ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class);
        Intrinsics.checkNotNullExpressionValue(from, "from");
        iTroopMemberOperationRepoApi.setMemberShutUp(str, str2, j3, null, from, new com.tencent.qqnt.troop.i() { // from class: com.tencent.mobileqq.troop.base.handler.i
            @Override // com.tencent.qqnt.troop.i
            public final void onResult(boolean z16, int i16, String str3) {
                j.r(j.this, i3, z16, i16, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(j this$0, int i3, boolean z16, int i16, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
        Bundle bundle = new Bundle();
        bundle.putBoolean("result_success", z16);
        this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
    }

    private final void s(Bundle bundle, final int callbackId) {
        final AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        final String string = bundle.getString("troop_uin", "");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.base.handler.e
            @Override // java.lang.Runnable
            public final void run() {
                j.t(AppInterface.this, string, this, callbackId);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(AppInterface appRuntime, String troopUin, j this$0, int i3) {
        Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ITroopAvatarLoaderApi iTroopAvatarLoaderApi = (ITroopAvatarLoaderApi) QRoute.api(ITroopAvatarLoaderApi.class);
        BaseApplication app = appRuntime.getApp();
        Intrinsics.checkNotNullExpressionValue(app, "appRuntime.app");
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
        iTroopAvatarLoaderApi.loadAvatar(app, 4, troopUin, new c(i3));
    }

    private final void u(Bundle bundle, final int callbackId) {
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getCreatedTroopListAsync(false, new Consumer() { // from class: com.tencent.mobileqq.troop.base.handler.c
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                j.v(j.this, callbackId, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(j this$0, int i3, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.io.Serializable");
        bundle.putSerializable(GetCMShowInfoServlet.EXTRA_RESULT_DATA, (Serializable) list);
        this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
    }

    private final void w(Bundle bundle, int callbackId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(TroopTrpcHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.base.handler.TroopTrpcHandler");
        TroopTrpcHandler troopTrpcHandler = (TroopTrpcHandler) businessHandler;
        String service = bundle.getString("service", "");
        String method = bundle.getString("method", "");
        byte[] byteArray = bundle.getByteArray("data");
        int i3 = bundle.getInt("serializationType");
        String string = bundle.getString("refer");
        if (byteArray != null) {
            Intrinsics.checkNotNullExpressionValue(service, "service");
            Intrinsics.checkNotNullExpressionValue(method, "method");
            TroopTrpcHandler.K2(troopTrpcHandler, service, method, byteArray, i3, null, string, new d(callbackId), 16, null);
        }
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@NotNull String action, @NotNull Bundle data, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, data, Integer.valueOf(callbackId));
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual("action_send_trpc_request", action)) {
            w(data, callbackId);
            return null;
        }
        if (Intrinsics.areEqual("action_request_troop_list", action)) {
            u(data, callbackId);
            return null;
        }
        if (Intrinsics.areEqual("action_request_troop_avatar", action)) {
            s(data, callbackId);
            return null;
        }
        if (Intrinsics.areEqual("action_request_local_troop_member_info", action)) {
            m(data, callbackId);
            return null;
        }
        if (Intrinsics.areEqual("action_request_shut_up_member", action)) {
            o(data, callbackId);
            return null;
        }
        if (Intrinsics.areEqual("action_request_delete_member", action)) {
            j(data, callbackId);
            return null;
        }
        if (Intrinsics.areEqual("action_request_get_troop_info", action)) {
            l(data, callbackId);
            return null;
        }
        return null;
    }
}
