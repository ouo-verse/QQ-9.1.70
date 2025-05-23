package com.tencent.mobileqq.zplan.reshub.impl.shiply.delegate;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.service.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import zj3.b;
import zj3.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0013\u0018\u00010\u0012H\u0014R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/reshub/impl/shiply/delegate/ShiplySSOBusinessHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "", "input", "", "E2", "jsonString", "Lzj3/b;", "observer", "", "F2", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ShiplySSOBusinessHandler extends BusinessHandler {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final String f335128f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AppInterface app;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/reshub/impl/shiply/delegate/ShiplySSOBusinessHandler$a;", "", "", "SHIPLY_SSO_HANDLER", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "SHIPLY_SSO_CMD", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.reshub.impl.shiply.delegate.ShiplySSOBusinessHandler$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return ShiplySSOBusinessHandler.f335128f;
        }

        Companion() {
        }
    }

    static {
        String name = ShiplySSOBusinessHandler.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "ShiplySSOBusinessHandler::class.java.name");
        f335128f = name;
    }

    public ShiplySSOBusinessHandler(AppInterface appInterface) {
        super(appInterface);
        this.app = appInterface;
    }

    private final String E2(byte[] input) {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(input));
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ByteStreamsKt.copyTo$default(gZIPInputStream, byteArrayOutputStream, 0, 2, null);
                String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                Intrinsics.checkNotNullExpressionValue(byteArrayOutputStream2, "outStream.toString()");
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                CloseableKt.closeFinally(gZIPInputStream, null);
                return byteArrayOutputStream2;
            } finally {
            }
        } finally {
        }
    }

    public final void F2(String jsonString, b observer) {
        byte[] bArr;
        QLog.i("ShiplySSOBusinessHandler", 1, "sendSSORequest, app = " + this.app);
        if (!a.c("trpc.rdelivery.config_pull_server.ConfigPullServer.SsoPullV3")) {
            a.g("trpc.rdelivery.config_pull_server.ConfigPullServer.SsoPullV3", new String[]{f335128f});
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("trpc.rdelivery.config_pull_server.ConfigPullServer.SsoPullV3", observer, true);
        if (jsonString != null) {
            bArr = jsonString.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
        } else {
            bArr = null;
        }
        createToServiceMsg.putWupBuffer(bArr);
        createToServiceMsg.addAttribute(MainService.UIN_NOT_MATCH_TAG, "1");
        if (1 == MobileQQ.sProcessId) {
            sendPbReq(createToServiceMsg);
        } else {
            if (this.app != null) {
                NewIntent newIntent = new NewIntent(this.app.getApp(), e.class);
                newIntent.putExtra(ToServiceMsg.class.getSimpleName(), createToServiceMsg);
                this.app.startServlet(newIntent);
                return;
            }
            QLog.e("ShiplySSOBusinessHandler", 1, "sendSSORequest err, app is null");
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
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("ShiplySSOBusinessHandler", 2, "onReceive cmd filter error, " + res.getServiceCmd());
                return;
            }
            return;
        }
        int businessFailCode = res.getBusinessFailCode();
        String businessFailMsg = res.getBusinessFailMsg();
        if (QLog.isColorLevel()) {
            QLog.i("ShiplySSOBusinessHandler", 2, "onReceive cmd[" + serviceCmd + "] fail, failCode:" + businessFailCode + ", failMsg:" + businessFailMsg);
        }
        if (Intrinsics.areEqual("trpc.rdelivery.config_pull_server.ConfigPullServer.SsoPullV3", res.getServiceCmd())) {
            String uin = res.getUin();
            AppInterface appInterface = this.app;
            String str = null;
            String account = appInterface != null ? appInterface.getAccount() : null;
            if (QLog.isColorLevel()) {
                QLog.d("ShiplySSOBusinessHandler", 2, "onReceive ,respUin = " + uin + ", curUin = " + account);
            }
            boolean z16 = false;
            if (!Intrinsics.areEqual(uin, account)) {
                QLog.i("ShiplySSOBusinessHandler", 1, "onReceive account changed");
                notifyUI(req, -1, false, (Object) "account_changed");
                return;
            }
            try {
                if (res.isSuccess()) {
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                    str = E2((byte[]) data);
                    z16 = true;
                }
            } catch (Exception e16) {
                businessFailMsg = e16.getMessage();
                QLog.e("ShiplySSOBusinessHandler", 1, "onReceive exception", e16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ShiplySSOBusinessHandler", 2, "onReceive ret = " + z16);
            }
            if (z16) {
                businessFailMsg = str;
            }
            notifyUI(req, -1, z16, businessFailMsg);
        }
    }
}
