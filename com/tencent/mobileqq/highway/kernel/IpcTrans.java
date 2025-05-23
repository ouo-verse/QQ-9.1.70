package com.tencent.mobileqq.highway.kernel;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class IpcTrans {
    static IPatchRedirector $redirector_ = null;
    static final String IPC_KEY_BIZ_INFO = "IPC_KEY_BIZ_INFO";
    static final String IPC_KEY_COMMAND_ID = "IPC_KEY_COMMAND_ID";
    static final String IPC_KEY_FILE_PATH = "IPC_KEY_FILE_PATH";
    static final String IPC_KEY_KERNEL_TRANS_ID = "IPC_KEY_KERNEL_TRANS_ID";
    static final String IPC_KEY_SUB_PROCESS_NAME = "IPC_KEY_SUB_PROCESS_NAME";
    static final String IPC_KEY_UP_KEY = "IPC_KEY_UP_KEY";
    byte[] bizInfo;
    int commandId;
    String filePath;
    long kernelTransID;
    String processName;
    byte[] upKey;

    public IpcTrans(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        this.kernelTransID = bundle.getLong(IPC_KEY_KERNEL_TRANS_ID);
        this.processName = bundle.getString(IPC_KEY_SUB_PROCESS_NAME);
        this.commandId = bundle.getInt(IPC_KEY_COMMAND_ID);
        this.filePath = bundle.getString(IPC_KEY_FILE_PATH, this.filePath);
        this.bizInfo = bundle.getByteArray(IPC_KEY_BIZ_INFO);
        this.upKey = bundle.getByteArray(IPC_KEY_UP_KEY);
    }
}
