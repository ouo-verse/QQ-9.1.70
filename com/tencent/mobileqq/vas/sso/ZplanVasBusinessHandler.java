package com.tencent.mobileqq.vas.sso;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.vas.sso.ZplanVasBusinessHandler;
import com.tencent.mobileqq.zplan.utils.i;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import d33.d;
import fw4.a;
import fw4.c;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0001(B\u0011\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b%\u0010&J>\u0010\u000b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J,\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\"\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0019\u0018\u00010\u0018H\u0014JL\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cR\u0019\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/vas/sso/ZplanVasBusinessHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "", "reqData", "", "service", "method", "", "extData", "", "source", Constants.MMCCID, "Ljava/util/ArrayList;", "Lfw4/c;", "Lkotlin/collections/ArrayList;", "F2", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "timeout", "Ld33/c;", "observer", "H2", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanVasBusinessHandler extends BusinessHandler {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final String f310872f = ZplanVasBusinessHandler.class.getName();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AppInterface app;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/sso/ZplanVasBusinessHandler$a;", "", "", "kotlin.jvm.PlatformType", "VAS_HANDLER", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.sso.ZplanVasBusinessHandler$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return ZplanVasBusinessHandler.f310872f;
        }

        Companion() {
        }
    }

    public ZplanVasBusinessHandler(AppInterface appInterface) {
        super(appInterface);
        this.app = appInterface;
    }

    private final ArrayList<c> F2(Map<String, String> extData) {
        ArrayList<c> arrayList = new ArrayList<>();
        if (!extData.isEmpty()) {
            for (Map.Entry<String, String> entry : extData.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                c cVar = new c();
                cVar.f400912a = key;
                cVar.f400913b = value;
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    private final byte[] G2(byte[] reqData, String service, String method, Map<String, String> extData, int source) {
        a aVar = new a();
        aVar.f400896a = String.valueOf(System.currentTimeMillis());
        String str = AppSetting.f99551k;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        aVar.f400897b = str;
        aVar.f400898c = 109;
        aVar.f400899d = service;
        aVar.f400900e = method;
        aVar.f400901f = reqData;
        aVar.f400902g = (c[]) F2(extData).toArray(new c[0]);
        aVar.f400903h = source;
        try {
            String b16 = i.b();
            byte[] bytes = b16.toString().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            aVar.f400904i = bytes;
            QLog.i("ZplanVasBusinessHandler", 4, "packSendBuffer hardwareInfoJson:" + b16);
            QLog.i("ZplanVasBusinessHandler", 4, "packSendBuffer req.hardwareInfo:" + aVar.f400904i.length);
        } catch (Exception e16) {
            QLog.e("ZplanVasBusinessHandler", 1, "packSendBuffer e:" + e16);
        }
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(ZplanVasBusinessHandler this$0, d33.c observer, String service, String method, byte[] bArr, Map extData, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        Intrinsics.checkNotNullParameter(service, "$service");
        Intrinsics.checkNotNullParameter(method, "$method");
        Intrinsics.checkNotNullParameter(extData, "$extData");
        ToServiceMsg createToServiceMsg = super.createToServiceMsg("trpc.qmeta.mob_proxy_svr.MobProxy.SsoHandle", observer);
        String str = service + "." + method;
        createToServiceMsg.addAttribute("vas_cmd", str);
        createToServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        createToServiceMsg.putWupBuffer(this$0.G2(bArr, service, method, extData, i3));
        if (i16 > 0) {
            long j3 = i16;
            createToServiceMsg.setTimeout(j3);
            createToServiceMsg.setSendTimeout(j3);
        }
        if (!com.tencent.mobileqq.service.a.c("trpc.qmeta.mob_proxy_svr.MobProxy.SsoHandle")) {
            com.tencent.mobileqq.service.a.g("trpc.qmeta.mob_proxy_svr.MobProxy.SsoHandle", new String[]{f310872f});
        }
        if (this$0.app == null) {
            QLog.e("ZplanVasBusinessHandler", 1, "[sendZPlanRequest] appInterface is null");
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof ToolRuntimePeak) {
                NewIntent newIntent = new NewIntent(this$0.app.getApp(), d33.a.class);
                newIntent.putExtra(ToServiceMsg.class.getSimpleName(), createToServiceMsg);
                this$0.app.startServlet(newIntent);
            } else if (peekAppRuntime instanceof VideoAppInterface) {
                NewIntent newIntent2 = new NewIntent(this$0.app.getApp(), d33.a.class);
                newIntent2.putExtra(ToServiceMsg.class.getSimpleName(), createToServiceMsg);
                this$0.app.startServlet(newIntent2);
            } else {
                this$0.app.sendToService(createToServiceMsg);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("ZplanVasBusinessHandler", 2, "[ZPlan SSO] onSend cmd:[" + str + "]");
        }
    }

    public final void H2(final String service, final String method, final byte[] reqData, final int timeout, final Map<String, String> extData, final int source, final d33.c observer) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(extData, "extData");
        Intrinsics.checkNotNullParameter(observer, "observer");
        ThreadManagerV2.excute(new Runnable() { // from class: d33.b
            @Override // java.lang.Runnable
            public final void run() {
                ZplanVasBusinessHandler.I2(ZplanVasBusinessHandler.this, observer, service, method, reqData, extData, source, timeout);
            }
        }, 128, null, false);
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
        Object attribute = req.getAttribute("vas_cmd");
        Intrinsics.checkNotNull(attribute, "null cannot be cast to non-null type kotlin.String");
        String str = (String) attribute;
        if (msgCmdFilter(serviceCmd)) {
            return;
        }
        boolean isSuccess = res.isSuccess();
        if (isSuccess) {
            if (QLog.isColorLevel()) {
                QLog.i("ZplanVasBusinessHandler", 2, "[ZPlan SSO] onReceive cmd[" + str + "] success");
            }
        } else {
            int businessFailCode = res.getBusinessFailCode();
            String businessFailMsg = res.getBusinessFailMsg();
            if (QLog.isColorLevel()) {
                QLog.i("ZplanVasBusinessHandler", 2, "[ZPlan SSO] onReceive cmd[" + str + "] fail, failCode:" + businessFailCode + ", failMsg:" + businessFailMsg);
            }
        }
        if (data == null) {
            QLog.e("ZplanVasBusinessHandler", 1, "[ZPlan SSO] onReceive data is null, cmd:" + serviceCmd + ", trulyCmd:[" + str + "]");
            notifyUI(req, 0, isSuccess, new d(res, (byte[]) data, str));
            return;
        }
        notifyUI(req, 0, isSuccess, new d(res, (byte[]) data, str));
    }
}
