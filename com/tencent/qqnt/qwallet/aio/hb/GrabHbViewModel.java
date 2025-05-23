package com.tencent.qqnt.qwallet.aio.hb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.e;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tenpay.sdk.basebl.DecytBean;
import com.tenpay.sdk.basebl.EncryptRequest;
import com.tenpay.sdk.net.NetUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import pl2.p;
import tencent.im.qqwallet.QWalletHbPreGrab$QQHBReply;
import tencent.im.qqwallet.QWalletHbPreGrab$QQHBRequest;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ9\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006J,\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fR\u001b\u0010\u0018\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001c\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/GrabHbViewModel;", "Lcom/tencent/qqnt/qwallet/aio/c;", "Landroid/content/Context;", "context", "Lrx3/b;", "aioModel", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "code", "", "grabCallback", "W1", QQPermissionConstants.Permission.AUIDO_GROUP, "", "", "", "extraArgs", "X1", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "U1", "()I", "keyIndex", "D", "T1", "()Ljava/lang/String;", "hexGuid", "<init>", "()V", "E", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class GrabHbViewModel extends com.tencent.qqnt.qwallet.aio.c {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy keyIndex;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy hexGuid;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/qwallet/aio/hb/GrabHbViewModel$b", "Lcom/tencent/mobileqq/qwallet/e$a;", "", "code", "", "errMsg", "pskey", "", "onFinish", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Integer, Unit> f361750a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx3.b f361751b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GrabHbViewModel f361752c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f361753d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f361754e;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class a implements BusinessObserver {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ pl2.o f361755d;

            public a(pl2.o oVar) {
                this.f361755d = oVar;
            }

            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                int i16;
                String str;
                if (bundle != null) {
                    i16 = bundle.getInt("rsp_code");
                } else {
                    i16 = 1001;
                }
                if (bundle != null) {
                    str = bundle.getString("rsp_msg");
                } else {
                    str = null;
                }
                if (z16) {
                    try {
                        MessageMicro rsp = ((MessageMicro) QWalletHbPreGrab$QQHBReply.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                        pl2.o oVar = this.f361755d;
                        if (oVar != null) {
                            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                            oVar.onSuccess((pl2.o) rsp);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + QWalletHbPreGrab$QQHBReply.class + " failed.");
                        pl2.o oVar2 = this.f361755d;
                        if (oVar2 != null) {
                            oVar2.onFail(i16, pl2.p.INSTANCE.a());
                            return;
                        }
                        return;
                    }
                }
                pl2.o oVar3 = this.f361755d;
                if (oVar3 != null) {
                    if (str == null) {
                        str = "empty bundle";
                    }
                    oVar3.onFail(i16, str);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/qwallet/aio/hb/GrabHbViewModel$b$b", "Lpl2/o;", "Ltencent/im/qqwallet/QWalletHbPreGrab$QQHBReply;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.qwallet.aio.hb.GrabHbViewModel$b$b, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9687b implements pl2.o<QWalletHbPreGrab$QQHBReply> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ GrabHbViewModel f361756a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ rx3.b f361757b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Context f361758c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f361759d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Function1<Integer, Unit> f361760e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f361761f;

            /* JADX WARN: Multi-variable type inference failed */
            C9687b(GrabHbViewModel grabHbViewModel, rx3.b bVar, Context context, String str, Function1<? super Integer, Unit> function1, int i3) {
                this.f361756a = grabHbViewModel;
                this.f361757b = bVar;
                this.f361758c = context;
                this.f361759d = str;
                this.f361760e = function1;
                this.f361761f = i3;
            }

            @Override // pl2.k
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NotNull QWalletHbPreGrab$QQHBReply rsp) {
                boolean z16;
                Map<String, ? extends Object> mapOf;
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                QLog.d(this.f361756a.getTAG(), 2, "onSuccess: listId " + this.f361757b.getBillNo() + ", " + rsp.retCode.get() + " " + rsp.retMsg.get());
                try {
                    DecytBean decypt = new EncryptRequest(this.f361758c).decypt(this.f361759d, "hb_pre_grap", this.f361756a.U1(), rsp.rspText.get());
                    if (decypt != null && decypt.type == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        int U1 = this.f361756a.U1();
                        String str = decypt.decryptStr;
                        if (str == null) {
                            str = rsp.rspText.get();
                        }
                        String jSONObject = NetUtil.getReturnData(U1, str).toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "getReturnData(keyIndex, \u2026rspText.get()).toString()");
                        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("skin_type", Integer.valueOf(this.f361761f)), TuplesKt.to("hb_pre_data", jSONObject));
                        this.f361756a.X1(this.f361758c, null, mapOf);
                        this.f361760e.invoke(0);
                        return;
                    }
                    this.f361760e.invoke(-7);
                } catch (Exception unused) {
                    this.f361760e.invoke(-7);
                }
            }

            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.w(this.f361756a.getTAG(), 1, "onFail: errMsg " + errMsg);
                this.f361760e.invoke(-4);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Integer, Unit> function1, rx3.b bVar, GrabHbViewModel grabHbViewModel, Context context, int i3) {
            this.f361750a = function1;
            this.f361751b = bVar;
            this.f361752c = grabHbViewModel;
            this.f361753d = context;
            this.f361754e = i3;
        }

        @Override // com.tencent.mobileqq.qwallet.e.a
        public void onFinish(int code, @Nullable String errMsg, @Nullable String pskey) {
            boolean z16;
            Map mapOf;
            String joinToString$default;
            boolean z17;
            boolean z18;
            if (pskey != null && pskey.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this.f361750a.invoke(-2);
                return;
            }
            String c16 = com.tencent.mobileqq.base.a.c();
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("listid", this.f361751b.getBillNo()), TuplesKt.to(WadlProxyConsts.CHANNEL, String.valueOf(this.f361751b.getRedChannel())), TuplesKt.to(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.f361751b.getGroupId()), TuplesKt.to("grouptype", String.valueOf(this.f361751b.getGroupType())), TuplesKt.to("groupuin", this.f361751b.getPeerUinStr()), TuplesKt.to("name", ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickNameSync(null, c16)), TuplesKt.to("pay_flag", String.valueOf(this.f361752c.M1().getBodyResv().uint32_pay_flag.get())), TuplesKt.to("authkey", this.f361751b.getAuthkey()), TuplesKt.to("uin", c16), TuplesKt.to("senderuin", this.f361751b.d()), TuplesKt.to("trans_seq", String.valueOf(this.f361752c.U1())), TuplesKt.to("hb_from", String.valueOf(this.f361752c.M1().getElemResv().uint32_hb_from.get())));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : mapOf.entrySet()) {
                if (((String) entry.getValue()).length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                arrayList.add(entry2.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + Uri.encode((String) entry2.getValue()));
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, null, 62, null);
            String str = new EncryptRequest(this.f361753d).encypt(c16, "hb_pre_grapver=2.0&chv=3", this.f361752c.U1(), joinToString$default, pskey, this.f361752c.T1()).encText;
            if (str != null && str.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                this.f361750a.invoke(-3);
                return;
            }
            QWalletHbPreGrab$QQHBRequest qWalletHbPreGrab$QQHBRequest = new QWalletHbPreGrab$QQHBRequest();
            GrabHbViewModel grabHbViewModel = this.f361752c;
            qWalletHbPreGrab$QQHBRequest.cgiName.set("hb_pre_grap");
            qWalletHbPreGrab$QQHBRequest.reqText.set(str);
            qWalletHbPreGrab$QQHBRequest.random.set(String.valueOf(grabHbViewModel.U1()));
            qWalletHbPreGrab$QQHBRequest.enType.set(0);
            C9687b c9687b = new C9687b(this.f361752c, this.f361751b, this.f361753d, c16, this.f361750a, this.f361754e);
            p.Companion companion = pl2.p.INSTANCE;
            QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qqhb.qqhb_proxy.Handler.sso_handle callback: " + c9687b + TokenParser.SP);
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), pl2.p.class);
            newIntent.putExtra("cmd", "trpc.qqhb.qqhb_proxy.Handler.sso_handle");
            newIntent.putExtra("data", fh.b(qWalletHbPreGrab$QQHBRequest.toByteArray()));
            newIntent.putExtra("timeout", 30000L);
            newIntent.setObserver(new a(c9687b));
            waitAppRuntime.startServlet(newIntent);
        }
    }

    public GrabHbViewModel() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.qqnt.qwallet.aio.hb.GrabHbViewModel$keyIndex$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(Math.abs(new Random().nextInt()) % 16);
            }
        });
        this.keyIndex = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qqnt.qwallet.aio.hb.GrabHbViewModel$hexGuid$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).hexGuid();
            }
        });
        this.hexGuid = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String T1() {
        return (String) this.hexGuid.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int U1() {
        return ((Number) this.keyIndex.getValue()).intValue();
    }

    public final void W1(@NotNull Context context, @NotNull rx3.b aioModel, @NotNull Function1<? super Integer, Unit> grabCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioModel, "aioModel");
        Intrinsics.checkNotNullParameter(grabCallback, "grabCallback");
        L1(aioModel);
        com.tencent.mobileqq.qwallet.e.c(false, null, new b(grabCallback, aioModel, this, context, aioModel.getClientExtend().optInt("skin_type", 0)), 3, null);
    }

    public final void X1(@NotNull Context context, @Nullable rx3.b record, @NotNull Map<String, ? extends Object> extraArgs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extraArgs, "extraArgs");
        if (record != null) {
            L1(record);
        }
        JSONObject a16 = sx3.a.a(M1());
        for (Map.Entry<String, ? extends Object> entry : extraArgs.entrySet()) {
            a16.put(entry.getKey(), entry.getValue());
        }
        String jSONObject = a16.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "aioModel.createBasicExtr\u2026e) }\n        }.toString()");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("userId", com.tencent.mobileqq.base.a.c());
        jSONObject2.put(HippyHeaderListViewController.VIEW_TAG, "graphb");
        jSONObject2.put(com.tencent.mobileqq.msf.core.c0.j.T0, "appid#1344242394|bargainor_id#1000030201|channel#msg");
        jSONObject2.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 2);
        jSONObject2.put("extra_data", jSONObject);
        jSONObject2.put("senderuin", M1().getSenderUin());
        Intent intent = new Intent();
        intent.putExtra(ark.ARKMETADATA_JSON, jSONObject2.toString());
        intent.putExtra("callbackSn", "0");
        intent.putExtra("pay_requestcode", 5);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTER_PAY_BRIDGE);
    }
}
