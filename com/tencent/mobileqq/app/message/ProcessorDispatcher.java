package com.tencent.mobileqq.app.message;

import android.util.Pair;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public class ProcessorDispatcher implements ProcessorDispatcherInterface {
    static IPatchRedirector $redirector_;
    private static Map<String, Pair<String, Integer>> cmdProcessorMap;
    private static Object cmdmapLock;

    /* loaded from: classes11.dex */
    public interface AccostProcessor {
        public static final int PROCESS_ACCOST_OFFLINE = 5002;
        public static final int PROCESS_ACCOST_PUSH = 5001;
    }

    /* loaded from: classes11.dex */
    public interface BaseProcessor {
        public static final int PROCESS_OFFLINE = 1002;
        public static final int PROCESS_PUSH = 1001;
        public static final int PROCESS_REFRESH_HEAD = 1003;
    }

    /* loaded from: classes11.dex */
    public interface BusinessProcessor {
        public static final int PROCESS_ONLINEPUSH = 3001;
    }

    /* loaded from: classes11.dex */
    public interface C2CProcessor {
        public static final int PROCESS_ROAM_BY_TIME = 2001;
        public static final int PROCESS_ROAM_MESSAGE_SEARCH_IN_CLOUD = 2005;
        public static final int PROCESS_SLAVE_MASTER = 2003;
        public static final int PROCESS_SUB_ACCOUNT = 2002;
    }

    /* loaded from: classes11.dex */
    public interface DiscProcessor {
    }

    /* loaded from: classes11.dex */
    public interface OfflineFileProcessor {
        public static final int PROCESS_OFFLINEFILE_RESP = 7001;
        public static final int PROCESS_SEND_FILE_EX_RESP = 7003;
        public static final int PROCESS_SEND_FILE_RESP = 7002;
    }

    /* loaded from: classes11.dex */
    public interface SubAccountProcessor {
        public static final int PROCESS_SUB_ACCOUNT = 4001;
        public static final int PROCESS_SUB_ACCOUNT_MSG_NUM_CONFIRM = 4002;
        public static final int PROCESS_SUB_ACCOUNT_SPECIAL_CARE = 4003;
        public static final int PROCESS_SUB_ACCOUNT_TROOP = 4004;
    }

    /* loaded from: classes11.dex */
    public interface SystemProcessor {
        public static final int PROCESS_DEL_ALL_SYSTEM_MSG = 6009;
        public static final int PROCESS_DEL_SINGLE_SYSTEM_MSG = 6008;
        public static final int PROCESS_SYSTEM_ACTION = 6007;
        public static final int PROCESS_SYSTEM_MSG = 6002;
        public static final int PROCESS_SYSTEM_MSG_FRIEND = 6001;
        public static final int PROCESS_SYSTEM_READ = 6006;
    }

    /* loaded from: classes11.dex */
    public interface TroopProcessor {
    }

    /* loaded from: classes11.dex */
    public interface UncommonMsgProcessor {
        public static final int PROCESS_BLESS_MSG = 8001;
        public static final int PROCESS_BLESS_TEXT_DIRTY_CHECK = 8004;
        public static final int PROCESS_DEL_MSG = 8003;
        public static final int PROCESS_REVOKE_OR_DELMULTI = 8002;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38665);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            cmdmapLock = new Object();
        }
    }

    public ProcessorDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getProcessType(int i3) {
        return i3 == 1 ? ProcessorDispatcherInterface.PROCESSOR_KEY_TROOP : i3 == 1026 ? ProcessorDispatcherInterface.PROCESSOR_KEY_HOTCHAT_TOPIC : i3 == 3000 ? ProcessorDispatcherInterface.PROCESSOR_KEY_DISC : ProcessorDispatcherInterface.PROCESSOR_KEY_C2C;
    }

    public static String getProcessorKey(String str) {
        return (String) cmdProcessorMap.get(str).first;
    }

    public static Map<String, Pair<String, Integer>> getProcessorMap() {
        if (cmdProcessorMap == null) {
            synchronized (cmdmapLock) {
                if (cmdProcessorMap == null) {
                    initCmdProcessorMap();
                }
            }
        }
        return cmdProcessorMap;
    }

    private static void initCmdProcessorMap() {
        HashMap hashMap = new HashMap();
        cmdProcessorMap = hashMap;
        hashMap.put("MessageSvc.GetMsgV4", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_ACCOST, 5002));
        cmdProcessorMap.put("AccostSvc.SvrMsg", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_ACCOST, 5001));
        cmdProcessorMap.put("ProfileService.Pb.ReqSystemMsgNew", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_SYSTEM, 6002));
        cmdProcessorMap.put("ProfileService.Pb.ReqSystemMsgNew.Friend", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_SYSTEM, 6001));
        cmdProcessorMap.put("ProfileService.Pb.ReqSystemMsgRead", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_SYSTEM, 6006));
        cmdProcessorMap.put("ProfileService.Pb.ReqSystemMsgAction", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_SYSTEM, 6007));
        cmdProcessorMap.put("OidbSvc.0x5cf_0", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_SYSTEM, 6008));
        cmdProcessorMap.put("OidbSvc.0x5cf_1", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_SYSTEM, 6009));
        cmdProcessorMap.put("MessageSvc.PbGetOneDayRoamMsg", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C, 1003));
        cmdProcessorMap.put("MessageSvc.PbGetRoamMsg", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C, 2001));
        cmdProcessorMap.put("PbMessageSvc.PbSearchRoamMsgInCloud", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C, 2005));
        cmdProcessorMap.put("TransService.ReqOffFilePack", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_OFFLINEFILE, 7001));
        cmdProcessorMap.put(MiniConst.Spark.CMD_PUSH_SPARK_REWARD, Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_BUSINESSBASE, 3001));
        cmdProcessorMap.put("MessageSvc.PbBindUinGetMsg", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_SUB, 4001));
        cmdProcessorMap.put("PbMessageSvc.PbBindUinMsgReadedConfirm", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_SUB, 4002));
        cmdProcessorMap.put("OidbSvc.0x5d0_1", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_SUB, 4003));
        cmdProcessorMap.put("MessageSvc.PbMultiMsgSend", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_UNCOMMON_MSG, 8001));
        cmdProcessorMap.put("PbMessageSvc.PbMsgWithDraw", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_UNCOMMON_MSG, 8002));
        cmdProcessorMap.put("PbMessageSvc.PbDelOneRoamMsg", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_UNCOMMON_MSG, 8003));
        cmdProcessorMap.put("SecSvcBlessingHelper.blessing_helper", Pair.create(ProcessorDispatcherInterface.PROCESSOR_KEY_UNCOMMON_MSG, 8004));
    }

    public static int getProcessType(String str) {
        return ((Integer) cmdProcessorMap.get(str).second).intValue();
    }
}
