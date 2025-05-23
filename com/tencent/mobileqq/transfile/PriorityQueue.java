package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes19.dex */
public class PriorityQueue {
    static IPatchRedirector $redirector_ = null;
    public static final int PRIORITY_BASE = 200;
    public static final int PRIORITY_HIGH = 200;
    public static final int PRIORITY_LOW = 202;
    public static final int PRIORITY_NOMRAL = 201;
    public static final int PRIORITY_NUMBER = 3;
    public int mInQueueMsgNums;
    private ArrayList<LinkedList<HttpMsg>> mSendQueues;

    public PriorityQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mInQueueMsgNums = 0;
        this.mSendQueues = new ArrayList<>();
        for (int i3 = 0; i3 < 3; i3++) {
            this.mSendQueues.add(new LinkedList<>());
        }
    }

    public void addMsg(HttpMsg httpMsg) {
        int priority;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) httpMsg);
        } else if (httpMsg != null && httpMsg.getPriority() - 200 >= 0 && priority < this.mSendQueues.size()) {
            this.mSendQueues.get(priority).add(httpMsg);
            this.mInQueueMsgNums++;
        }
    }

    public void clearMsgs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < this.mSendQueues.size(); i3++) {
            this.mSendQueues.get(i3).clear();
        }
        this.mInQueueMsgNums = 0;
    }

    public String getFullSendQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.mSendQueues.size(); i3++) {
            for (int i16 = 0; i16 < this.mSendQueues.get(i3).size(); i16++) {
                sb5.append(this.mSendQueues.get(i3).get(i16).getRealUrl());
                sb5.append("\r\n");
            }
        }
        return sb5.toString();
    }

    public HttpMsg getMaxPriortyMsg(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HttpMsg) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        for (int i3 = 0; i3 < this.mSendQueues.size(); i3++) {
            if (this.mSendQueues.get(i3).size() != 0) {
                if (z16) {
                    this.mInQueueMsgNums--;
                    return this.mSendQueues.get(i3).remove(0);
                }
                return this.mSendQueues.get(i3).get(0);
            }
        }
        return null;
    }

    public int getQueueMsgNums() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.mInQueueMsgNums;
    }

    public boolean removeHttpMsg(HttpMsg httpMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) httpMsg)).booleanValue();
        }
        for (int i3 = 0; i3 < this.mSendQueues.size(); i3++) {
            if (this.mSendQueues.get(i3).remove(httpMsg)) {
                this.mInQueueMsgNums--;
                return true;
            }
        }
        return false;
    }
}
