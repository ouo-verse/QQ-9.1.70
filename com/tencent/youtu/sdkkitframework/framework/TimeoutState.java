package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon;
import java.util.HashMap;
import org.apache.httpcore.HttpHeaders;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TimeoutState extends YtFSMBaseState {
    static IPatchRedirector $redirector_;

    public TimeoutState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.enter();
        YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() { // from class: com.tencent.youtu.sdkkitframework.framework.TimeoutState.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TimeoutState.this);
                    return;
                }
                put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.PROCESS_FIN);
                put(StateEvent.Name.UI_TIPS, StringCode.RST_FAILED);
                put(StateEvent.Name.PROCESS_RESULT, "failed");
                put("error_code", Integer.valueOf(ErrorCode.YT_SDK_VERIFY_TIMEOUT));
                put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_VERIFY_TIMEOUT, StringCode.MSG_TIMEOUT_ERROR, HttpHeaders.TIMEOUT));
            }
        });
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
