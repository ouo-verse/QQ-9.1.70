package com.tencent.mobileqq.partner.signin;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$BusSigninDetail;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$BusSigninDetailEntity;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$SigninReq;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$SigninRsp;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$TodayReq;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$TodayRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002,-B\u000f\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J9\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u000fJA\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000b2!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u000fJ&\u0010\u0019\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0018H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016J\u0012\u0010\u001e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001d\u0018\u00010\u001cH\u0014R\u001b\u0010#\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010&\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/partner/signin/PartnerSignInHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "F2", Constants.MMCCID, "", "friendUin", "", "markId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/partner/signin/k;", "Lkotlin/ParameterName;", "name", "signInResult", "callback", "H2", "src", "I2", "", "onReceive", "", "getCommandList", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "d", "Lkotlin/Lazy;", Constants.BASE_IN_PLUGIN_VERSION, "()Ljava/lang/String;", "cmdQueryToday", "e", "E2", "cmdSignIn", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "f", "a", "b", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PartnerSignInHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy cmdQueryToday;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy cmdSignIn;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\"\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/PartnerSignInHandler$b;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "Lcom/tencent/mobileqq/partner/signin/k;", "signInResult", "a", "b", "<init>", "()V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    private static abstract class b implements BusinessObserver {
        public void a(k signInResult) {
            Intrinsics.checkNotNullParameter(signInResult, "signInResult");
        }

        public void b(k signInResult) {
            Intrinsics.checkNotNullParameter(signInResult, "signInResult");
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public final void onUpdate(int type, boolean isSuccess, Object data) {
            if (type == 1) {
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.tencent.mobileqq.partner.signin.SignInResult");
                a((k) data);
            } else {
                if (type != 2) {
                    return;
                }
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.tencent.mobileqq.partner.signin.SignInResult");
                b((k) data);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/partner/signin/PartnerSignInHandler$c", "Lcom/tencent/mobileqq/partner/signin/PartnerSignInHandler$b;", "Lcom/tencent/mobileqq/partner/signin/k;", "signInResult", "", "a", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c extends b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<k, Unit> f257208d;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super k, Unit> function1) {
            this.f257208d = function1;
        }

        @Override // com.tencent.mobileqq.partner.signin.PartnerSignInHandler.b
        public void a(k signInResult) {
            Intrinsics.checkNotNullParameter(signInResult, "signInResult");
            this.f257208d.invoke(signInResult);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/partner/signin/PartnerSignInHandler$d", "Lcom/tencent/mobileqq/partner/signin/PartnerSignInHandler$b;", "Lcom/tencent/mobileqq/partner/signin/k;", "signInResult", "", "b", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d extends b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<k, Unit> f257209d;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super k, Unit> function1) {
            this.f257209d = function1;
        }

        @Override // com.tencent.mobileqq.partner.signin.PartnerSignInHandler.b
        public void b(k signInResult) {
            Intrinsics.checkNotNullParameter(signInResult, "signInResult");
            this.f257209d.invoke(signInResult);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PartnerSignInHandler(AppInterface app) {
        super(app);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(app, "app");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.partner.signin.PartnerSignInHandler$cmdQueryToday$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                int checkRadix;
                checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                String num = Integer.toString(37190, checkRadix);
                Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                return "OidbSvcTrpcTcp.0x" + num + "_1";
            }
        });
        this.cmdQueryToday = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.partner.signin.PartnerSignInHandler$cmdSignIn$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                int checkRadix;
                checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                String num = Integer.toString(37188, checkRadix);
                Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                return "OidbSvcTrpcTcp.0x" + num + "_1";
            }
        });
        this.cmdSignIn = lazy2;
    }

    private final String D2() {
        return (String) this.cmdQueryToday.getValue();
    }

    private final String E2() {
        return (String) this.cmdSignIn.getValue();
    }

    public final void H2(String friendUin, long markId, Function1<? super k, Unit> callback) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("PartnerSignInHandler", 1, "queryTodaySignIn friendUin=" + StringUtil.getSimpleUinForPrint(friendUin) + " markId=" + markId);
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.w("PartnerSignInHandler", 1, "queryTodaySignIn network not available");
            callback.invoke(new k(-1, null));
            return;
        }
        GeneralSigninPB$TodayReq generalSigninPB$TodayReq = new GeneralSigninPB$TodayReq();
        generalSigninPB$TodayReq.bus_id.set("partner");
        generalSigninPB$TodayReq.target.set(friendUin);
        PBRepeatField<String> pBRepeatField = generalSigninPB$TodayReq.sub_bus_id;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(String.valueOf(markId));
        pBRepeatField.set(listOf);
        generalSigninPB$TodayReq.source.set("aio");
        ToServiceMsg makeOIDBPkg = makeOIDBPkg(D2(), 37190, 1, generalSigninPB$TodayReq.toByteArray());
        addBusinessObserver(makeOIDBPkg, new c(callback), true);
        sendPbReq(makeOIDBPkg);
    }

    public final void I2(String friendUin, long markId, String src, Function1<? super k, Unit> callback) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("PartnerSignInHandler", 1, "signIn friendUin=" + StringUtil.getSimpleUinForPrint(friendUin) + " markId=" + markId);
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.w("PartnerSignInHandler", 1, "signIn network not available");
            callback.invoke(new k(-1, null));
            return;
        }
        GeneralSigninPB$SigninReq generalSigninPB$SigninReq = new GeneralSigninPB$SigninReq();
        generalSigninPB$SigninReq.bus_id.set("partner");
        generalSigninPB$SigninReq.target.set(friendUin);
        generalSigninPB$SigninReq.sub_bus_id.set(String.valueOf(markId));
        generalSigninPB$SigninReq.source.set(src);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg(E2(), 37188, 1, generalSigninPB$SigninReq.toByteArray());
        addBusinessObserver(makeOIDBPkg, new d(callback), true);
        sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    private final void F2(ToServiceMsg req, FromServiceMsg res, byte[] data) {
        Object orNull;
        int i3 = -1;
        if (data == null) {
            QLog.e("PartnerSignInHandler", 1, "handleQueryTodayRsp data is null");
            notifyUI(req, 1, res.isSuccess(), new k(-1, null, 2, null));
            return;
        }
        try {
            GeneralSigninPB$TodayRsp generalSigninPB$TodayRsp = new GeneralSigninPB$TodayRsp();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(res, data, generalSigninPB$TodayRsp);
            if (parseOIDBPkg != 0) {
                QLog.e("PartnerSignInHandler", 1, "handleQueryTodayRsp oidb errCode " + parseOIDBPkg);
            } else {
                List<GeneralSigninPB$BusSigninDetailEntity> list = generalSigninPB$TodayRsp.bus_detail.get();
                Intrinsics.checkNotNullExpressionValue(list, "rsp.bus_detail.get()");
                orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
                GeneralSigninPB$BusSigninDetailEntity generalSigninPB$BusSigninDetailEntity = (GeneralSigninPB$BusSigninDetailEntity) orNull;
                r2 = generalSigninPB$BusSigninDetailEntity != null ? generalSigninPB$BusSigninDetailEntity.value : null;
                if (r2 == null) {
                    QLog.e("PartnerSignInHandler", 1, "handleQueryTodayRsp signInDetail is null");
                }
            }
            i3 = parseOIDBPkg;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("PartnerSignInHandler", 1, "handleQueryTodayRsp mergeFrom error: ", e16);
        }
        notifyUI(req, 1, res.isSuccess(), new k(i3, r2));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        Set<String> mutableSetOf;
        mutableSetOf = SetsKt__SetsKt.mutableSetOf(D2(), E2());
        return mutableSetOf;
    }

    private final void G2(ToServiceMsg req, FromServiceMsg res, byte[] data) {
        int i3 = -1;
        GeneralSigninPB$BusSigninDetail generalSigninPB$BusSigninDetail = null;
        if (data == null) {
            QLog.e("PartnerSignInHandler", 1, "handleSignInRsp data is null");
            notifyUI(req, 2, res.isSuccess(), new k(-1, null, 2, null));
            return;
        }
        try {
            GeneralSigninPB$SigninRsp generalSigninPB$SigninRsp = new GeneralSigninPB$SigninRsp();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(res, data, generalSigninPB$SigninRsp);
            if (parseOIDBPkg != 0) {
                QLog.e("PartnerSignInHandler", 1, "handleSignInRsp oidb errCode " + parseOIDBPkg);
            } else {
                generalSigninPB$BusSigninDetail = generalSigninPB$SigninRsp.bus_detail;
                if (generalSigninPB$BusSigninDetail == null) {
                    QLog.e("PartnerSignInHandler", 1, "handleSignInRsp signInDetail is null");
                }
            }
            i3 = parseOIDBPkg;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("PartnerSignInHandler", 1, "handleSignInRsp mergeFrom error: ", e16);
        }
        notifyUI(req, 2, res.isSuccess(), new k(i3, generalSigninPB$BusSigninDetail));
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg req, FromServiceMsg res, Object data) {
        if (req == null || res == null) {
            return;
        }
        String serviceCmd = req.getServiceCmd();
        if (serviceCmd == null) {
            serviceCmd = "";
        }
        QLog.d("PartnerSignInHandler", 1, "onReceive cmd=" + serviceCmd + " resultCode=" + res.getResultCode());
        if (Intrinsics.areEqual(serviceCmd, D2())) {
            F2(req, res, data instanceof byte[] ? (byte[]) data : null);
        } else if (Intrinsics.areEqual(serviceCmd, E2())) {
            G2(req, res, data instanceof byte[] ? (byte[]) data : null);
        }
    }
}
