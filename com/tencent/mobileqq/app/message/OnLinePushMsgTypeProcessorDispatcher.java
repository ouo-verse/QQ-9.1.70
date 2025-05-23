package com.tencent.mobileqq.app.message;

import android.annotation.SuppressLint;
import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public class OnLinePushMsgTypeProcessorDispatcher implements ProcessorDispatcherInterface {
    static IPatchRedirector $redirector_;
    private static Map<Integer, Pair<String, Integer>> msgTypeProcessorMap;
    private static Object msgTypemapLock;

    /* loaded from: classes11.dex */
    public interface OnLinePushProcessor {
        public static final int PROCESS_MSG_TYPE_DISCUSS_UPDATE = 9010;
        public static final int PROCESS_MSG_TYPE_GROUPTMP = 9005;
        public static final int PROCESS_MSG_TYPE_INFO_UPDATE = 9011;
        public static final int PROCESS_MSG_TYPE_OFFLINE_FILE = 9001;
        public static final int PROCESS_MSG_TYPE_PTT = 9004;
        public static final int PROCESS_MSG_TYPE_SHARP_VIDEO = 9003;
        public static final int PROCESS_MSG_TYPE_SLAVE_MASTER_MSG = 9012;
        public static final int PROCESS_MSG_TYPE_SYSTEM_FRIEND = 9008;
        public static final int PROCESS_MSG_TYPE_SYSTEM_TROOP = 9009;
        public static final int PROCESS_MSG_TYPE_VIDEO = 9002;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38600);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            msgTypemapLock = new Object();
        }
    }

    public OnLinePushMsgTypeProcessorDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getProcessType(int i3) {
        return ((Integer) msgTypeProcessorMap.get(Integer.valueOf(i3)).second).intValue();
    }

    public static String getProcessorKey(int i3) {
        return (String) msgTypeProcessorMap.get(Integer.valueOf(i3)).first;
    }

    public static Map<Integer, Pair<String, Integer>> getProcessorMap() {
        if (msgTypeProcessorMap == null) {
            synchronized (msgTypemapLock) {
                if (msgTypeProcessorMap == null) {
                    initMsgTypeProcessorMap();
                }
            }
        }
        return msgTypeProcessorMap;
    }

    @SuppressLint({"UseSparseArrays"})
    private static void initMsgTypeProcessorMap() {
        HashMap hashMap = new HashMap();
        msgTypeProcessorMap = hashMap;
        hashMap.put(193, Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_VIDEO, 9002));
        msgTypeProcessorMap.put(Integer.valueOf(com.tencent.luggage.wxa.ci.a.CTRL_INDEX), Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_VIDEO, 9003));
        msgTypeProcessorMap.put(524, Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_DISCUSS_UPDATE, 9010));
        msgTypeProcessorMap.put(Integer.valueOf(com.tencent.luggage.wxa.wh.b.CTRL_INDEX), Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_INFO_UPDATE, 9011));
        msgTypeProcessorMap.put(526, Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_SLAVE_MASTER_MSG, 9012));
    }
}
