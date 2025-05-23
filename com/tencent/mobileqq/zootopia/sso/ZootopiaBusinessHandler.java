package com.tencent.mobileqq.zootopia.sso;

import com.epicgames.ue4.ZPlanVersion;
import com.google.protobuf.nano.MessageNano;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.zplan.utils.i;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ab;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import qu4.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u00020\u0001:\u0001*B\u0011\u0012\b\u0010&\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b'\u0010(JF\u0010\r\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\"\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\u001aH\u0014JT\u0010 \u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eR\u0019\u0010&\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zootopia/sso/ZootopiaBusinessHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "", "reqData", "", "service", "method", "", "extData", "", "source", "", "isJsonRequest", Constants.MMCCID, "Ljava/util/ArrayList;", "Lyu4/c;", "Lkotlin/collections/ArrayList;", "F2", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "timeout", "Lcom/tencent/mobileqq/zootopia/sso/b;", "observer", "H2", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaBusinessHandler extends BusinessHandler {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final String f329281f = ZootopiaBusinessHandler.class.getName();

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy<byte[]> f329282h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AppInterface app;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0005\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zootopia/sso/ZootopiaBusinessHandler$a;", "", "", "kotlin.jvm.PlatformType", "ZPLAN_HANDLER", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "HARDWARE_INFO$delegate", "Lkotlin/Lazy;", "a", "()[B", "HARDWARE_INFO", "", "REQUEST_TYPE_JSON", "I", "REQUEST_TYPE_PB", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.sso.ZootopiaBusinessHandler$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final byte[] a() {
            return (byte[]) ZootopiaBusinessHandler.f329282h.getValue();
        }

        public final String b() {
            return ZootopiaBusinessHandler.f329281f;
        }

        Companion() {
        }
    }

    static {
        Lazy<byte[]> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<byte[]>() { // from class: com.tencent.mobileqq.zootopia.sso.ZootopiaBusinessHandler$Companion$HARDWARE_INFO$2
            @Override // kotlin.jvm.functions.Function0
            public final byte[] invoke() {
                byte[] bytes = i.b().toString().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                return bytes;
            }
        });
        f329282h = lazy;
    }

    public ZootopiaBusinessHandler(AppInterface appInterface) {
        super(appInterface);
        this.app = appInterface;
    }

    private final ArrayList<yu4.c> F2(Map<String, String> extData) {
        ArrayList<yu4.c> arrayList = new ArrayList<>();
        if (!extData.isEmpty()) {
            for (Map.Entry<String, String> entry : extData.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                yu4.c cVar = new yu4.c();
                cVar.f451276a = key;
                cVar.f451277b = value;
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    private final byte[] G2(byte[] reqData, String service, String method, Map<String, String> extData, int source, boolean isJsonRequest) {
        yu4.a aVar = new yu4.a();
        aVar.f451255a = String.valueOf(System.currentTimeMillis());
        aVar.f451256b = ab.INSTANCE.a();
        aVar.f451257c = 109;
        aVar.f451258d = service;
        aVar.f451259e = method;
        aVar.f451260f = reqData;
        aVar.f451261g = (yu4.c[]) F2(extData).toArray(new yu4.c[0]);
        aVar.f451262h = source;
        aVar.f451264j = DeviceInfoMonitor.getModel();
        if (isJsonRequest) {
            aVar.f451265k = 2;
        } else {
            aVar.f451265k = 0;
        }
        try {
            Companion companion = INSTANCE;
            aVar.f451263i = companion.a();
            QLog.i("ZPlanBusinessHandler", 4, "packSendBuffer hardwareInfoJson:" + companion.a());
            QLog.i("ZPlanBusinessHandler", 4, "packSendBuffer req.hardwareInfo:" + aVar.f451263i.length);
        } catch (Exception e16) {
            QLog.e("ZPlanBusinessHandler", 1, "packSendBuffer e:" + e16);
        }
        n nVar = new n();
        nVar.f429622a = ZPlanVersion.ZPlanVersion;
        aVar.f451267m = nVar;
        aVar.f451268n = 1;
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        return byteArray;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg req, FromServiceMsg res, Object data) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        String serviceCmd = res.getServiceCmd();
        Object attribute = req.getAttribute("zplan_cmd");
        Intrinsics.checkNotNull(attribute, "null cannot be cast to non-null type kotlin.String");
        String str = (String) attribute;
        if (msgCmdFilter(serviceCmd)) {
            return;
        }
        boolean isSuccess = res.isSuccess();
        if (isSuccess) {
            QLog.i("ZPlanBusinessHandler", 1, "[ZPlan SSO] onReceive cmd[" + str + "] success");
        } else {
            QLog.w("ZPlanBusinessHandler", 1, "[ZPlan SSO] onReceive cmd[" + str + "] fail, failCode:" + res.getBusinessFailCode() + ", failMsg:" + res.getBusinessFailMsg());
        }
        if (data == null) {
            QLog.e("ZPlanBusinessHandler", 1, "[ZPlan SSO] onReceive data is null, cmd:" + serviceCmd + ", trulyCmd:[" + str + "]");
            notifyUI(req, 0, isSuccess, new d(res, (byte[]) data, str));
            return;
        }
        notifyUI(req, 0, isSuccess, new d(res, (byte[]) data, str));
    }

    public final void H2(String service, String method, byte[] reqData, int timeout, Map<String, String> extData, int source, boolean isJsonRequest, b observer) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(extData, "extData");
        Intrinsics.checkNotNullParameter(observer, "observer");
        ToServiceMsg createToServiceMsg = super.createToServiceMsg("trpc.metaverse.mob_proxy_svr.MobProxy.SsoHandle", observer);
        String str = service + "." + method;
        createToServiceMsg.addAttribute("zplan_cmd", str);
        createToServiceMsg.putWupBuffer(G2(reqData, service, method, extData, source, isJsonRequest));
        createToServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        if (timeout > 0) {
            long j3 = timeout;
            createToServiceMsg.setTimeout(j3);
            createToServiceMsg.setSendTimeout(j3);
        }
        if (!com.tencent.mobileqq.service.a.c("trpc.metaverse.mob_proxy_svr.MobProxy.SsoHandle")) {
            com.tencent.mobileqq.service.a.g("trpc.metaverse.mob_proxy_svr.MobProxy.SsoHandle", new String[]{f329281f});
        }
        if (this.app == null) {
            QLog.e("ZPlanBusinessHandler", 1, "[sendZPlanRequest] appInterface is null");
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof ToolRuntimePeak) && !(peekAppRuntime instanceof ToolAppRuntime)) {
                if (peekAppRuntime instanceof VideoAppInterface) {
                    NewIntent newIntent = new NewIntent(this.app.getApp(), e.class);
                    newIntent.putExtra(ToServiceMsg.class.getSimpleName(), createToServiceMsg);
                    this.app.startServlet(newIntent);
                } else {
                    this.app.sendToService(createToServiceMsg);
                }
            } else {
                NewIntent newIntent2 = new NewIntent(this.app.getApp(), e.class);
                newIntent2.putExtra(ToServiceMsg.class.getSimpleName(), createToServiceMsg);
                this.app.startServlet(newIntent2);
            }
        }
        QLog.i("ZPlanBusinessHandler", 1, "[ZPlan SSO] onSend cmd:[" + str + "] server:" + service + " method:" + method + " req.appSeq:" + createToServiceMsg.getAppSeq() + " reqservice.Cmd:" + createToServiceMsg.getServiceCmd() + " req.serviceCmd:" + createToServiceMsg.getServiceCmd() + " req.requestSsoSeq:" + createToServiceMsg.getRequestSsoSeq() + " timeout:" + timeout);
    }
}
