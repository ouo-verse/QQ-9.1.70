package com.tencent.upload.utils.watcher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.task.BaseTask;
import com.tencent.upload.uinterface.AbstractUploadTask;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadFlowTracker {
    static IPatchRedirector $redirector_;

    public UploadFlowTracker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static StringBuffer appendMessage(StringBuffer stringBuffer, String str) {
        if (stringBuffer == null) {
            return stringBuffer;
        }
        try {
            stringBuffer.append(str);
        } catch (Exception unused) {
        }
        return stringBuffer;
    }

    public static void trackCancel(AbstractUploadTask abstractUploadTask) {
        if (abstractUploadTask == null) {
            return;
        }
        StringBuffer flowRecoder = abstractUploadTask.getFlowRecoder();
        appendMessage(flowRecoder, "\u4efb\u52a1\u53d6\u6d88");
        appendMessage(flowRecoder, "\n");
    }

    public static void trackException(BaseTask baseTask, Throwable th5) {
        if ((baseTask instanceof AbstractUploadTask) && th5 != null) {
            StringBuffer flowRecoder = ((AbstractUploadTask) baseTask).getFlowRecoder();
            appendMessage(flowRecoder, "\u5f02\u5e38");
            appendMessage(flowRecoder, th5.getMessage());
            appendMessage(flowRecoder, "\n");
        }
    }

    public static void trackFlow(BaseTask baseTask, String str) {
        if ((baseTask instanceof AbstractUploadTask) && str != null) {
            StringBuffer flowRecoder = ((AbstractUploadTask) baseTask).getFlowRecoder();
            flowRecoder.append(str);
            flowRecoder.append("\n");
        }
    }

    public static void trackRoute(BaseTask baseTask, IUploadSession iUploadSession) {
        if ((baseTask instanceof AbstractUploadTask) && iUploadSession != null) {
            StringBuffer flowRecoder = ((AbstractUploadTask) baseTask).getFlowRecoder();
            String connectedIp = iUploadSession.getConnectedIp();
            UploadRoute uploadRoute = iUploadSession.getUploadRoute();
            if (connectedIp != null) {
                appendMessage(flowRecoder, "connect ip:");
                appendMessage(flowRecoder, connectedIp);
            }
            if (uploadRoute != null) {
                appendMessage(flowRecoder, " route :");
                appendMessage(flowRecoder, uploadRoute.toString());
            }
            flowRecoder.append("\n");
        }
    }

    public static void trackStart(AbstractUploadTask abstractUploadTask) {
        if (abstractUploadTask == null) {
            return;
        }
        StringBuffer flowRecoder = abstractUploadTask.getFlowRecoder();
        appendMessage(flowRecoder, "flow id :");
        appendMessage(flowRecoder, String.valueOf(abstractUploadTask.flowId));
        appendMessage(flowRecoder, "\n");
    }
}
