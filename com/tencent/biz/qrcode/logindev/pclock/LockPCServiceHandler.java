package com.tencent.biz.qrcode.logindev.pclock;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\nH\u0014J\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qrcode/logindev/pclock/LockPCServiceHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "", "isLocked", "", "instanceID", "Lcom/tencent/biz/qrcode/logindev/pclock/g;", "callback", Constants.BASE_IN_PLUGIN_VERSION, "", "", "getCommandList", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "d", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class LockPCServiceHandler extends BusinessHandler {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qrcode/logindev/pclock/LockPCServiceHandler$b;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "Lcom/tencent/biz/qrcode/logindev/pclock/g;", "d", "Lcom/tencent/biz/qrcode/logindev/pclock/g;", "callback", "<init>", "(Lcom/tencent/biz/qrcode/logindev/pclock/g;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    private static final class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final g callback;

        public b(@NotNull g callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
            if ((data instanceof String) && isSuccess) {
                this.callback.onResult(0, (String) data);
            } else {
                this.callback.onResult(-1, "update lock status failed");
            }
        }
    }

    public LockPCServiceHandler(@Nullable AppInterface appInterface) {
        super(appInterface);
    }

    public final void D2(boolean isLocked, int instanceID, @NotNull g callback) {
        int i3;
        Intrinsics.checkNotNullParameter(callback, "callback");
        StatusService$ChangeLockStatusReq statusService$ChangeLockStatusReq = new StatusService$ChangeLockStatusReq();
        if (isLocked) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        statusService$ChangeLockStatusReq.lock_status.set(i3);
        statusService$ChangeLockStatusReq.instance_id.set(instanceID);
        ToServiceMsg createToServiceMsg = createToServiceMsg("trpc.qq_new_tech.status_svc.StatusService.SsoChangeLockStatus");
        createToServiceMsg.putWupBuffer(statusService$ChangeLockStatusReq.toByteArray());
        addBusinessObserver(createToServiceMsg, new b(callback), false);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.qq_new_tech.status_svc.StatusService.SsoChangeLockStatus");
        }
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @Nullable
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        String str;
        boolean z16;
        if (res != null) {
            str = res.getServiceCmd();
        } else {
            str = null;
        }
        if (res != null && Intrinsics.areEqual(str, "trpc.qq_new_tech.status_svc.StatusService.SsoChangeLockStatus")) {
            if (!res.isSuccess()) {
                notifyUI(req, 0, false, (Object) null);
                QLog.e("LockPCServlet", 1, "onReceive failed!!");
                return;
            }
            try {
                StatusService$ChangeLockStatusResp statusService$ChangeLockStatusResp = new StatusService$ChangeLockStatusResp();
                statusService$ChangeLockStatusResp.mergeFrom(res.getWupBuffer());
                int i3 = statusService$ChangeLockStatusResp.reply_code.get();
                String obj = statusService$ChangeLockStatusResp.reply_string.get().toString();
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                notifyUI(req, 0, z16, obj);
                QLog.d("LockPCServlet", 1, "onReceive code: " + i3 + ", errorMsg: " + obj);
            } catch (Exception e16) {
                QLog.e("LockPCServlet", 1, "onReceive failed error: " + e16);
            }
        }
    }
}
