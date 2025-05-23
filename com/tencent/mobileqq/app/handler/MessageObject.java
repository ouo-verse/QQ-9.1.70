package com.tencent.mobileqq.app.handler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MessageObject {
    static IPatchRedirector $redirector_ = null;
    public static final int MSG_C2C_PB = 1;
    public static final int MSG_DISCUSSION_PB = 3;
    public static final int MSG_DISCUSSION_SEQ = 5;
    public static final int MSG_TROOP_PB = 2;
    public static final int MSG_TROOP_SEQ = 4;
    public Object data;
    public boolean isFirstMsg;
    public ToServiceMsg req;
    public FromServiceMsg resp;
    public int type;

    public MessageObject(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        this(i3, toServiceMsg, fromServiceMsg, obj, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg, obj);
    }

    public MessageObject(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg, obj, Boolean.valueOf(z16));
            return;
        }
        this.type = i3;
        this.req = toServiceMsg;
        this.resp = fromServiceMsg;
        this.data = obj;
        this.isFirstMsg = z16;
    }
}
