package com.tencent.mobileqq.hermes.task;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hermes.task.CountManagerPB;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00170\u0016H\u0014J \u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/hermes/task/TaskCountHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "app", "Lcom/tencent/common/app/AppInterface;", "(Lcom/tencent/common/app/AppInterface;)V", "getCommandList", "", "", "getTaskCount", "", "context", "", "targetTaskId", "", "handlerGetCountResult", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "resp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "observerClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "onReceive", "Companion", "hermes-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public class TaskCountHandler extends BusinessHandler {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String CMD_GET_COUNT = "trpc.qq_operation.count_svr.CountManager.SsoGetCountRes";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String KEY_REQUEST_CONTEXT = "key_request_context";

    @NotNull
    private static final String TAG = "TaskCountHandler";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/hermes/task/TaskCountHandler$Companion;", "", "()V", "CMD_GET_COUNT", "", "KEY_REQUEST_CONTEXT", "TAG", "hermes-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25472);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskCountHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handlerGetCountResult(ToServiceMsg req, FromServiceMsg resp, Object data) {
        Integer num;
        int i3;
        int resultCode = resp.getResultCode();
        boolean isSuccess = resp.isSuccess();
        if (isSuccess) {
            try {
                CountManagerPB.GetCountResRsp.Builder builder = (CountManagerPB.GetCountResRsp.Builder) CountManagerPB.GetCountResRsp.newBuilder().mergeFrom((byte[]) data);
                if (isSuccess) {
                    notifyUI(1001, isSuccess, Long.valueOf(builder.getCount()));
                    Object attribute = req.getAttribute(KEY_REQUEST_CONTEXT);
                    if (attribute instanceof Integer) {
                        num = (Integer) attribute;
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        i3 = num.intValue();
                    } else {
                        i3 = 0;
                    }
                    SimpleEventBus.getInstance().dispatchEvent(new TaskRankingEvent(i3, isSuccess, builder.getCount()));
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "handlerGetCountResult fail.", e16);
                isSuccess = false;
            }
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("handlerGetCountResult success=%s resultCode=%s", Arrays.copyOf(new Object[]{Boolean.valueOf(isSuccess), Integer.valueOf(resultCode)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d(TAG, 2, format);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(CMD_GET_COUNT);
        }
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    public final void getTaskCount(int context, long targetTaskId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(context), Long.valueOf(targetTaskId));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getTaskCount targetTaskId=" + targetTaskId);
        }
        CountManagerPB.GetCountResReq build = CountManagerPB.GetCountResReq.newBuilder().setBizType(targetTaskId).build();
        ToServiceMsg createToServiceMsg = createToServiceMsg(CMD_GET_COUNT);
        createToServiceMsg.putWupBuffer(build.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        createToServiceMsg.addAttribute(KEY_REQUEST_CONTEXT, Integer.valueOf(context));
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TaskCountObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@NotNull ToServiceMsg req, @NotNull FromServiceMsg resp, @NotNull Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, req, resp, data);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(resp, "resp");
        Intrinsics.checkNotNullParameter(data, "data");
        String serviceCmd = resp.getServiceCmd();
        if (!msgCmdFilter(serviceCmd) && Intrinsics.areEqual(CMD_GET_COUNT, serviceCmd)) {
            handlerGetCountResult(req, resp, data);
        }
    }
}
