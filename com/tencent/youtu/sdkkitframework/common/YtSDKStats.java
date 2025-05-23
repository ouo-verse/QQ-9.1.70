package com.tencent.youtu.sdkkitframework.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YtSDKStats extends YtFSMBaseState {
    static IPatchRedirector $redirector_;
    private static YtSDKStats ytSDKStats;
    private String currentAction;
    private long currentEnterTimeStampMS;
    private String currentState;
    private String preInfo;
    private String preUpdateState;
    private HashMap<String, Object> stateNameMap;

    public YtSDKStats() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.stateNameMap = new HashMap<>();
        }
    }

    public static synchronized void clearInstance() {
        synchronized (YtSDKStats.class) {
            if (ytSDKStats != null) {
                ytSDKStats = null;
            }
        }
    }

    public static synchronized YtSDKStats getInstance() {
        synchronized (YtSDKStats.class) {
            YtSDKStats ytSDKStats2 = ytSDKStats;
            if (ytSDKStats2 == null) {
                YtSDKStats ytSDKStats3 = new YtSDKStats();
                ytSDKStats = ytSDKStats3;
                return ytSDKStats3;
            }
            return ytSDKStats2;
        }
    }

    public static String getNowTimeStamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    private void makeReport(String str, String str2, HashMap<String, Object> hashMap, String str3, String str4) {
        HashMap<String, Object> hashMap2 = new HashMap<>();
        HashMap hashMap3 = new HashMap();
        hashMap3.put("state_id", str);
        hashMap3.put("state_action", str2);
        if (hashMap != null) {
            hashMap3.put("state_error", hashMap);
        }
        if (str3 != null) {
            hashMap3.put("state_cost", str3);
        }
        if (str4 != null) {
            hashMap3.put("state_info", str4);
        }
        hashMap2.put(StateEvent.Name.STATE_STATS, hashMap3);
        sendStateEvent(hashMap2);
    }

    private void sendStateEvent(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            YtFSM.getInstance().sendFSMEvent(hashMap);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void enterFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public void enterState(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        Object obj = this.stateNameMap.get(str);
        if (obj == null) {
            return;
        }
        this.currentAction = BaseConstants.BROADCAST_USERSYNC_ENTER;
        int intValue = ((Integer) obj).intValue();
        if (intValue == 0) {
            exitState();
            if (this.currentAction != null) {
                this.currentEnterTimeStampMS = System.currentTimeMillis();
                this.currentState = str;
                makeReport(str, this.currentAction, null, null, null);
            }
        }
        this.stateNameMap.put(str, Integer.valueOf(intValue + 1));
    }

    public void exitState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.currentState != null) {
            makeReport(this.currentState, "exit", null, Long.toString(System.currentTimeMillis() - this.currentEnterTimeStampMS), null);
        }
    }

    public void registerStateName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.stateNameMap.put(str, 0);
        }
    }

    public void reportError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str);
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("error_code", Integer.valueOf(i3));
        hashMap.put("error_msg", str);
        makeReport(this.currentState, this.currentAction, hashMap, null, null);
    }

    public void reportEvent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_type", Integer.valueOf(i3));
        hashMap.put(StateEvent.Name.STATE_STATS, hashMap2);
        sendStateEvent(hashMap);
    }

    public void reportInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        String str2 = this.preInfo;
        if (str2 == null || !str2.equals(str)) {
            this.preInfo = str;
        }
        makeReport(this.currentState, this.currentAction, null, null, str);
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Iterator<String> it = this.stateNameMap.keySet().iterator();
        while (it.hasNext()) {
            this.stateNameMap.put(it.next(), 0);
        }
        this.currentState = null;
        this.preUpdateState = null;
        this.preInfo = null;
    }

    public void updateState(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.currentAction = "update";
        String str2 = this.preUpdateState;
        if (str2 == null || !str2.equals(this.currentState)) {
            String str3 = this.currentState;
            this.preUpdateState = str3;
            makeReport(str3, this.currentAction, null, null, null);
        }
    }
}
