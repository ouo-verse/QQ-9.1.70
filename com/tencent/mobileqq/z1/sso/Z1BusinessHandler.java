package com.tencent.mobileqq.z1.sso;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.zplan.utils.i;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
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
import rb3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0001(B\u0011\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b%\u0010&J>\u0010\u000b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J,\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\"\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0019\u0018\u00010\u0018H\u0014JL\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cR\u0019\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/z1/sso/Z1BusinessHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "", "reqData", "", "service", "method", "", "extData", "", "source", "F2", "Ljava/util/ArrayList;", "Lfw4/c;", "Lkotlin/collections/ArrayList;", "E2", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "timeout", "Lrb3/a;", "observer", Constants.MMCCID, "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class Z1BusinessHandler extends BusinessHandler {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final String f327876f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AppInterface app;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/z1/sso/Z1BusinessHandler$a;", "", "", "Z1_HANDLER", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.z1.sso.Z1BusinessHandler$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return Z1BusinessHandler.f327876f;
        }

        Companion() {
        }
    }

    static {
        String name = Z1BusinessHandler.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "Z1BusinessHandler::class.java.name");
        f327876f = name;
    }

    public Z1BusinessHandler(AppInterface appInterface) {
        super(appInterface);
        this.app = appInterface;
    }

    private final ArrayList<c> E2(Map<String, String> extData) {
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

    private final byte[] F2(byte[] reqData, String service, String method, Map<String, String> extData, int source) {
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
        aVar.f400902g = (c[]) E2(extData).toArray(new c[0]);
        aVar.f400903h = source;
        try {
            String b16 = i.b();
            byte[] bytes = b16.toString().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            aVar.f400904i = bytes;
            QLog.i("Z1BusinessHandler", 4, "packSendBuffer hardwareInfoJson:" + b16);
            QLog.i("Z1BusinessHandler", 4, "packSendBuffer req.hardwareInfo:" + aVar.f400904i.length);
        } catch (Exception e16) {
            QLog.e("Z1BusinessHandler", 1, "packSendBuffer e:" + e16);
        }
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        return byteArray;
    }

    public final void G2(String service, String method, byte[] reqData, int timeout, Map<String, String> extData, int source, rb3.a observer) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(extData, "extData");
        Intrinsics.checkNotNullParameter(observer, "observer");
        ToServiceMsg createToServiceMsg = super.createToServiceMsg("trpc.zmeta.mob_proxy_svr.MobProxy.SsoHandle", observer);
        String str = service + "." + method;
        createToServiceMsg.addAttribute("z1_cmd", str);
        createToServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        createToServiceMsg.putWupBuffer(F2(reqData, service, method, extData, source));
        if (timeout > 0) {
            long j3 = timeout;
            createToServiceMsg.setTimeout(j3);
            createToServiceMsg.setSendTimeout(j3);
        }
        if (!com.tencent.mobileqq.service.a.c("trpc.zmeta.mob_proxy_svr.MobProxy.SsoHandle")) {
            com.tencent.mobileqq.service.a.g("trpc.zmeta.mob_proxy_svr.MobProxy.SsoHandle", new String[]{f327876f});
        }
        if (this.app == null) {
            QLog.e("Z1BusinessHandler", 1, "[sendZPlanRequest] appInterface is null");
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof ToolRuntimePeak) {
                NewIntent newIntent = new NewIntent(this.app.getApp(), b.class);
                newIntent.putExtra(ToServiceMsg.class.getSimpleName(), createToServiceMsg);
                this.app.startServlet(newIntent);
            } else if (peekAppRuntime instanceof VideoAppInterface) {
                NewIntent newIntent2 = new NewIntent(this.app.getApp(), b.class);
                newIntent2.putExtra(ToServiceMsg.class.getSimpleName(), createToServiceMsg);
                this.app.startServlet(newIntent2);
            } else {
                this.app.sendToService(createToServiceMsg);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("Z1BusinessHandler", 2, "[Z1 SSO] onSend cmd:[" + str + "]");
        }
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
        Object attribute = req.getAttribute("z1_cmd");
        Intrinsics.checkNotNull(attribute, "null cannot be cast to non-null type kotlin.String");
        String str = (String) attribute;
        if (msgCmdFilter(serviceCmd)) {
            return;
        }
        boolean isSuccess = res.isSuccess();
        if (isSuccess) {
            if (QLog.isColorLevel()) {
                QLog.i("Z1BusinessHandler", 2, "[Z1 SSO] onReceive cmd[" + str + "] success");
            }
        } else {
            int businessFailCode = res.getBusinessFailCode();
            String businessFailMsg = res.getBusinessFailMsg();
            if (QLog.isColorLevel()) {
                QLog.i("Z1BusinessHandler", 2, "[Z1 SSO] onReceive cmd[" + str + "] fail, failCode:" + businessFailCode + ", failMsg:" + businessFailMsg);
            }
        }
        if (data == null) {
            QLog.e("Z1BusinessHandler", 1, "[Z1 SSO] onReceive data is null, cmd:" + serviceCmd + ", trulyCmd:[" + str + "]");
            notifyUI(req, 0, isSuccess, new rb3.c(res, (byte[]) data, str));
            return;
        }
        notifyUI(req, 0, isSuccess, new rb3.c(res, (byte[]) data, str));
    }
}
