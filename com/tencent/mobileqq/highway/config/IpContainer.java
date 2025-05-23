package com.tencent.mobileqq.highway.config;

import android.content.Context;
import com.tencent.mobileqq.highway.iplearning.IpLearning;
import com.tencent.mobileqq.highway.iplearning.IpLearningImpl;
import com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class IpContainer {
    static IPatchRedirector $redirector_ = null;
    private static final String SUB_TAG = "IpContainer";
    public static ConcurrentHashMap<String, IpLearning> mIpLearners;
    private PersistentConfig mCfg;
    private String mFileName;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class PersistentConfig {
        static IPatchRedirector $redirector_;
        public ConcurrentHashMap<String, ArrayList<EndPoint>> mIpList;
        public ConcurrentHashMap<String, ArrayList<EndPoint>> mIpv6List;
        public ArrayList<HwNetSegConf> mSegConf;
        public ArrayList<HwNetSegConf> mShortVideoSegConf;

        PersistentConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) IpContainer.this);
        }

        /* synthetic */ PersistentConfig(IpContainer ipContainer, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ipContainer, (Object) anonymousClass1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9482);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            mIpLearners = new ConcurrentHashMap<>();
        }
    }

    public IpContainer(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        } else {
            this.mFileName = str;
            this.mCfg = readDiskOrCreateNew(context, str);
        }
    }

    private synchronized boolean findNRemove(ArrayList<EndPoint> arrayList, String str) {
        boolean z16 = false;
        if (arrayList == null) {
            return false;
        }
        EndPoint endPoint = null;
        int i3 = 0;
        while (true) {
            if (i3 >= arrayList.size()) {
                break;
            }
            endPoint = arrayList.get(i3);
            if (endPoint.host.equalsIgnoreCase(str)) {
                if (arrayList.size() > i3) {
                    arrayList.remove(i3);
                }
                z16 = true;
            } else {
                i3++;
            }
        }
        if (z16 && endPoint.protoType == 1) {
            endPoint.protoType = 2;
            arrayList.add(arrayList.size(), endPoint);
        }
        return z16;
    }

    private IpLearning getOrCreateIpLearnerByKey(String str) {
        if (IpLearningImpl.sEnableIpLearning == 1) {
            IpLearningImpl ipLearningImpl = new IpLearningImpl();
            IpLearning putIfAbsent = mIpLearners.putIfAbsent(str, ipLearningImpl);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return ipLearningImpl;
        }
        return null;
    }

    private void insertOrReplace(Context context, ConcurrentHashMap<String, ArrayList<EndPoint>> concurrentHashMap, ArrayList<EndPoint> arrayList, boolean z16) {
        Iterator<String> it = BdhUtils.getCurNetKey(context).iterator();
        while (it.hasNext()) {
            String next = it.next();
            ArrayList<EndPoint> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                Iterator<EndPoint> it5 = arrayList.iterator();
                int i3 = 0;
                while (it5.hasNext()) {
                    EndPoint next2 = it5.next();
                    EndPoint endPoint = new EndPoint(next2.host, next2.port, next2.type);
                    endPoint.ipIndex = i3;
                    endPoint.keyOfAPN = next;
                    endPoint.isSameIsp = next2.isSameIsp;
                    endPoint.timestamp = next2.timestamp;
                    arrayList2.add(endPoint);
                    BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, insert() key= " + next + "   value= " + endPoint.toString());
                    i3++;
                }
            }
            if (z16) {
                IpLearning orCreateIpLearnerByKey = getOrCreateIpLearnerByKey(next);
                if (orCreateIpLearnerByKey != null) {
                    concurrentHashMap.put(next, orCreateIpLearnerByKey.adjustNewIpList(arrayList2));
                }
            } else {
                concurrentHashMap.put(next, arrayList2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x01e0 A[Catch: IOException -> 0x01b2, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x01b2, blocks: (B:55:0x01ae, B:69:0x01e0), top: B:7:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x01b3 -> B:50:0x01e3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private PersistentConfig loadFromDisk(Context context, String str) {
        PersistentConfig persistentConfig;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream = null;
        byte b16 = 0;
        if (!new File(context.getFilesDir().getAbsolutePath(), str).exists()) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "PersistentConfigList.loadFromDisk() cannot find file " + str);
            return null;
        }
        HwConfigPersistentPB.HwConfigPB hwConfigPB = new HwConfigPersistentPB.HwConfigPB();
        try {
            try {
                FileInputStream openFileInput = context.openFileInput(str);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = openFileInput.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        hwConfigPB.mergeFrom(byteArrayOutputStream.toByteArray());
                    } catch (Throwable th5) {
                        th = th5;
                    }
                    try {
                        persistentConfig = new PersistentConfig(this, b16 == true ? 1 : 0);
                    } catch (Throwable th6) {
                        th = th6;
                        persistentConfig = null;
                        fileInputStream = openFileInput;
                        try {
                            BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "PersistentConfigList.loadFromDisk() InvalidProtocolBufferMicroException", th);
                            if (fileInputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            return persistentConfig;
                        } finally {
                        }
                    }
                    try {
                        persistentConfig.mIpList = new ConcurrentHashMap<>();
                        persistentConfig.mIpv6List = new ConcurrentHashMap<>();
                        persistentConfig.mSegConf = new ArrayList<>();
                        persistentConfig.mShortVideoSegConf = new ArrayList<>();
                        for (HwConfigPersistentPB.HwConfigItemPB hwConfigItemPB : hwConfigPB.rpt_config_item_list.get()) {
                            String str2 = hwConfigItemPB.string_key.get();
                            ArrayList arrayList = (ArrayList) hwConfigItemPB.rpt_end_point_list.get();
                            ArrayList<EndPoint> arrayList2 = new ArrayList<>();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                HwConfigPersistentPB.HwEndPointPB hwEndPointPB = (HwConfigPersistentPB.HwEndPointPB) it.next();
                                arrayList2.add(new EndPoint(hwEndPointPB.string_host.get(), hwEndPointPB.int32_port.get(), hwEndPointPB.int64_timestampe.get()));
                            }
                            persistentConfig.mIpList.put(str2, arrayList2);
                        }
                        for (HwConfigPersistentPB.HwConfigItemPB hwConfigItemPB2 : hwConfigPB.rpt_config_item_list_ip6.get()) {
                            String str3 = hwConfigItemPB2.string_key.get();
                            ArrayList arrayList3 = (ArrayList) hwConfigItemPB2.rpt_end_point_list.get();
                            ArrayList<EndPoint> arrayList4 = new ArrayList<>();
                            Iterator it5 = arrayList3.iterator();
                            while (it5.hasNext()) {
                                HwConfigPersistentPB.HwEndPointPB hwEndPointPB2 = (HwConfigPersistentPB.HwEndPointPB) it5.next();
                                arrayList4.add(new EndPoint(hwEndPointPB2.string_host.get(), hwEndPointPB2.int32_port.get(), hwEndPointPB2.int64_timestampe.get()));
                            }
                            persistentConfig.mIpv6List.put(str3, arrayList4);
                        }
                        for (HwConfigPersistentPB.HwNetSegConfPB hwNetSegConfPB : hwConfigPB.rpt_net_seg_conf_list.get()) {
                            persistentConfig.mSegConf.add(new HwNetSegConf(hwNetSegConfPB.int64_net_type.get(), hwNetSegConfPB.int64_seg_size.get(), hwNetSegConfPB.int64_seg_num.get(), hwNetSegConfPB.int64_cur_conn_num.get()));
                        }
                        for (HwConfigPersistentPB.HwNetSegConfPB hwNetSegConfPB2 : hwConfigPB.rpt_short_video_net_conf.get()) {
                            persistentConfig.mShortVideoSegConf.add(new HwNetSegConf(hwNetSegConfPB2.int64_net_type.get(), hwNetSegConfPB2.int64_seg_size.get(), hwNetSegConfPB2.int64_seg_num.get(), hwNetSegConfPB2.int64_cur_conn_num.get()));
                        }
                        try {
                            openFileInput.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                        byteArrayOutputStream.close();
                    } catch (Throwable th7) {
                        th = th7;
                        fileInputStream = openFileInput;
                        BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "PersistentConfigList.loadFromDisk() InvalidProtocolBufferMicroException", th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return persistentConfig;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    byteArrayOutputStream = null;
                    persistentConfig = null;
                }
            } catch (Throwable th9) {
                th = th9;
                byteArrayOutputStream = null;
                persistentConfig = null;
            }
        } catch (IOException e18) {
            e18.printStackTrace();
        }
        return persistentConfig;
    }

    private PersistentConfig readDiskOrCreateNew(Context context, String str) {
        PersistentConfig loadFromDisk = loadFromDisk(context, str);
        if (loadFromDisk == null) {
            PersistentConfig persistentConfig = new PersistentConfig(this, null);
            persistentConfig.mIpList = new ConcurrentHashMap<>();
            persistentConfig.mIpv6List = new ConcurrentHashMap<>();
            persistentConfig.mSegConf = new ArrayList<>();
            persistentConfig.mShortVideoSegConf = new ArrayList<>();
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, " + str + " does NOT exists.");
            return persistentConfig;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, " + str + " does exists.");
        return loadFromDisk;
    }

    public static void refreshIpLearning() {
        ConcurrentHashMap<String, IpLearning> concurrentHashMap = mIpLearners;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.FileOutputStream] */
    private void write2disk(Context context, String str, PersistentConfig persistentConfig) {
        IOException e16;
        FileNotFoundException e17;
        HwConfigPersistentPB.HwConfigPB hwConfigPB = new HwConfigPersistentPB.HwConfigPB();
        for (Map.Entry<String, ArrayList<EndPoint>> entry : persistentConfig.mIpList.entrySet()) {
            String key = entry.getKey();
            ArrayList<EndPoint> value = entry.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator<EndPoint> it = value.iterator();
            while (it.hasNext()) {
                EndPoint next = it.next();
                HwConfigPersistentPB.HwEndPointPB hwEndPointPB = new HwConfigPersistentPB.HwEndPointPB();
                hwEndPointPB.string_host.set(next.host);
                hwEndPointPB.int32_port.set(next.port);
                hwEndPointPB.int64_timestampe.set(next.timestamp);
                arrayList.add(hwEndPointPB);
            }
            HwConfigPersistentPB.HwConfigItemPB hwConfigItemPB = new HwConfigPersistentPB.HwConfigItemPB();
            hwConfigItemPB.string_key.set(key);
            hwConfigItemPB.rpt_end_point_list.set(arrayList);
            hwConfigPB.rpt_config_item_list.add(hwConfigItemPB);
        }
        for (Map.Entry<String, ArrayList<EndPoint>> entry2 : persistentConfig.mIpv6List.entrySet()) {
            String key2 = entry2.getKey();
            ArrayList<EndPoint> value2 = entry2.getValue();
            ArrayList arrayList2 = new ArrayList();
            Iterator<EndPoint> it5 = value2.iterator();
            while (it5.hasNext()) {
                EndPoint next2 = it5.next();
                HwConfigPersistentPB.HwEndPointPB hwEndPointPB2 = new HwConfigPersistentPB.HwEndPointPB();
                hwEndPointPB2.string_host.set(next2.host);
                hwEndPointPB2.int32_port.set(next2.port);
                hwEndPointPB2.int64_timestampe.set(next2.timestamp);
                arrayList2.add(hwEndPointPB2);
            }
            HwConfigPersistentPB.HwConfigItemPB hwConfigItemPB2 = new HwConfigPersistentPB.HwConfigItemPB();
            hwConfigItemPB2.string_key.set(key2);
            hwConfigItemPB2.rpt_end_point_list.set(arrayList2);
            hwConfigPB.rpt_config_item_list_ip6.add(hwConfigItemPB2);
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<HwNetSegConf> it6 = persistentConfig.mSegConf.iterator();
        while (it6.hasNext()) {
            HwNetSegConf next3 = it6.next();
            HwConfigPersistentPB.HwNetSegConfPB hwNetSegConfPB = new HwConfigPersistentPB.HwNetSegConfPB();
            hwNetSegConfPB.int64_net_type.set(next3.netType);
            hwNetSegConfPB.int64_seg_size.set(next3.segSize);
            hwNetSegConfPB.int64_seg_num.set(next3.segNum);
            hwNetSegConfPB.int64_cur_conn_num.set(next3.curConnNum);
            arrayList3.add(hwNetSegConfPB);
        }
        hwConfigPB.rpt_net_seg_conf_list.set(arrayList3);
        ?? arrayList4 = new ArrayList();
        Iterator<HwNetSegConf> it7 = persistentConfig.mSegConf.iterator();
        while (it7.hasNext()) {
            HwNetSegConf next4 = it7.next();
            HwConfigPersistentPB.HwNetSegConfPB hwNetSegConfPB2 = new HwConfigPersistentPB.HwNetSegConfPB();
            hwNetSegConfPB2.int64_net_type.set(next4.netType);
            hwNetSegConfPB2.int64_seg_size.set(next4.segSize);
            hwNetSegConfPB2.int64_seg_num.set(next4.segNum);
            hwNetSegConfPB2.int64_cur_conn_num.set(next4.curConnNum);
            arrayList4.add(hwNetSegConfPB2);
        }
        hwConfigPB.rpt_short_video_net_conf.set(arrayList4);
        try {
            try {
                try {
                    arrayList4 = new FileOutputStream(new File(context.getFilesDir().getAbsolutePath(), str));
                } catch (FileNotFoundException e18) {
                    arrayList4 = 0;
                    e17 = e18;
                } catch (IOException e19) {
                    arrayList4 = 0;
                    e16 = e19;
                } catch (Throwable th5) {
                    arrayList4 = 0;
                    th = th5;
                    if (arrayList4 != 0) {
                        try {
                            arrayList4.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    arrayList4.write(hwConfigPB.toByteArray());
                    BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, write2disk() write successful " + str);
                    arrayList4.close();
                    arrayList4 = arrayList4;
                } catch (FileNotFoundException e27) {
                    e17 = e27;
                    BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, write2disk() fail, cannot find file" + str, e17);
                    if (arrayList4 != 0) {
                        arrayList4.close();
                        arrayList4 = arrayList4;
                    }
                } catch (IOException e28) {
                    e16 = e28;
                    BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, write2disk() failed, due to IOException", e16);
                    if (arrayList4 != 0) {
                        arrayList4.close();
                        arrayList4 = arrayList4;
                    }
                }
            } catch (IOException e29) {
                e29.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public synchronized boolean addNew(Context context, HwConfig hwConfig, ConfigManager configManager) {
        boolean z16;
        ArrayList<EndPoint> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, context, hwConfig, configManager)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<EndPoint> it = hwConfig.ipList.iterator();
        while (it.hasNext()) {
            it.next().timestamp = currentTimeMillis;
        }
        Iterator<EndPoint> it5 = hwConfig.ipv6List.iterator();
        while (it5.hasNext()) {
            it5.next().timestamp = currentTimeMillis;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, addNew() " + hwConfig.ipList2String());
        PersistentConfig readDiskOrCreateNew = readDiskOrCreateNew(context, this.mFileName);
        ArrayList<EndPoint> arrayList2 = hwConfig.ipList;
        boolean z17 = true;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            insertOrReplace(context, readDiskOrCreateNew.mIpList, hwConfig.ipList, false);
            insertOrReplace(context, this.mCfg.mIpList, hwConfig.ipList, true);
            z16 = true;
        } else {
            z16 = false;
        }
        ArrayList<EndPoint> arrayList3 = hwConfig.ipv6List;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            insertOrReplace(context, readDiskOrCreateNew.mIpv6List, hwConfig.ipv6List, false);
            insertOrReplace(context, this.mCfg.mIpv6List, hwConfig.ipv6List, true);
            z16 = true;
        }
        ArrayList<EndPoint> arrayList4 = hwConfig.ipList;
        if (arrayList4 != null && !arrayList4.isEmpty() && ((arrayList = hwConfig.ipv6List) == null || arrayList.isEmpty())) {
            insertOrReplace(context, readDiskOrCreateNew.mIpv6List, hwConfig.ipv6List, false);
            insertOrReplace(context, this.mCfg.mIpv6List, hwConfig.ipv6List, true);
            z16 = true;
        }
        ArrayList<HwNetSegConf> arrayList5 = hwConfig.netSegConfList;
        if (arrayList5 != null && !arrayList5.isEmpty()) {
            ArrayList<HwNetSegConf> arrayList6 = hwConfig.netSegConfList;
            readDiskOrCreateNew.mSegConf = arrayList6;
            ArrayList<HwNetSegConf> arrayList7 = hwConfig.shortVideoSegConfList;
            readDiskOrCreateNew.mShortVideoSegConf = arrayList7;
            PersistentConfig persistentConfig = this.mCfg;
            persistentConfig.mSegConf = arrayList6;
            persistentConfig.mShortVideoSegConf = arrayList7;
        } else {
            z17 = z16;
        }
        if (z17) {
            write2disk(context, this.mFileName, readDiskOrCreateNew);
        }
        return z17;
    }

    public void cleanIpv6Cfg(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) context);
        } else {
            this.mCfg.mIpv6List.clear();
            write2disk(context, this.mFileName, this.mCfg);
        }
    }

    public synchronized boolean fail(String str, boolean z16) {
        Iterator<String> it;
        ArrayList<EndPoint> arrayList;
        ConcurrentHashMap<String, ArrayList<EndPoint>> concurrentHashMap;
        ConcurrentHashMap<String, ArrayList<EndPoint>> concurrentHashMap2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        PersistentConfig persistentConfig = this.mCfg;
        if (persistentConfig == null) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, fail() found due to mCfg == null");
            return false;
        }
        if (z16 && ((concurrentHashMap2 = persistentConfig.mIpv6List) == null || concurrentHashMap2.isEmpty())) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, fail() found due to mCfg.mIpv6List == null || mCfg.mIpv6List.isEmpty()");
            return false;
        }
        if (!z16 && ((concurrentHashMap = this.mCfg.mIpList) == null || concurrentHashMap.isEmpty())) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, fail() found due to mCfg.mIpList == null || mCfg.mIpList.isEmpty()");
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        if (z16) {
            it = this.mCfg.mIpv6List.keySet().iterator();
        } else {
            it = this.mCfg.mIpList.keySet().iterator();
        }
        while (it.hasNext()) {
            String next = it.next();
            if (z16) {
                arrayList = this.mCfg.mIpv6List.get(next);
            } else {
                arrayList = this.mCfg.mIpList.get(next);
            }
            if (findNRemove(arrayList, str)) {
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, fail() remove ip " + str + " in " + next + " which has " + (arrayList.size() + 1) + " IPs");
                z17 = true;
            }
            if (arrayList.isEmpty()) {
                arrayList2.add(next);
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            String str2 = (String) it5.next();
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, fail() " + str2 + " is empty, remove it");
            if (z16) {
                this.mCfg.mIpv6List.remove(str2);
            } else {
                this.mCfg.mIpList.remove(str2);
            }
        }
        if (!z17) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainer, fail() found NONE");
        }
        return z17;
    }

    public synchronized EndPoint findIpCurNet(Context context, boolean z16) {
        ArrayList<EndPoint> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EndPoint) iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16));
        }
        Iterator<String> it = BdhUtils.getCurNetKey(context).iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (z16) {
                arrayList = this.mCfg.mIpv6List.get(next);
            } else {
                arrayList = this.mCfg.mIpList.get(next);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                EndPoint endPoint = arrayList.get(0);
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainerfindIpCurNet, key= " + next + "   isIpv6= " + z16);
                return endPoint;
            }
        }
        return null;
    }

    public synchronized ArrayList<EndPoint> findIpCurNetList(Context context, boolean z16) {
        ArrayList<EndPoint> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(z16));
        }
        Iterator<String> it = BdhUtils.getCurNetKey(context).iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (z16) {
                arrayList = this.mCfg.mIpv6List.get(next);
            } else {
                arrayList = this.mCfg.mIpList.get(next);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "IpContainerfindIpCurNetList, key= " + next + "   isIpv6= " + z16);
                return arrayList;
            }
        }
        return null;
    }

    public synchronized EndPoint findIpRecent(Context context, boolean z16) {
        Iterator<Map.Entry<String, ArrayList<EndPoint>>> it;
        EndPoint endPoint;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EndPoint) iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(z16));
        }
        long j3 = -1;
        EndPoint endPoint2 = null;
        if (z16) {
            it = this.mCfg.mIpv6List.entrySet().iterator();
        } else {
            it = this.mCfg.mIpList.entrySet().iterator();
        }
        while (it.hasNext()) {
            ArrayList<EndPoint> value = it.next().getValue();
            if (value != null && !value.isEmpty() && (endPoint = value.get(0)) != null) {
                long j16 = endPoint.timestamp;
                if (j16 > j3) {
                    endPoint2 = endPoint;
                    j3 = j16;
                }
            }
        }
        return endPoint2;
    }

    public ArrayList<HwNetSegConf> getNetSegConf(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? getNetSegConf(0) : (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
    }

    public boolean isEmpty(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, z16)).booleanValue();
        }
        PersistentConfig persistentConfig = this.mCfg;
        if (persistentConfig == null) {
            return true;
        }
        if (z16) {
            ConcurrentHashMap<String, ArrayList<EndPoint>> concurrentHashMap = persistentConfig.mIpv6List;
            return concurrentHashMap == null || concurrentHashMap.isEmpty();
        }
        ConcurrentHashMap<String, ArrayList<EndPoint>> concurrentHashMap2 = persistentConfig.mIpList;
        return concurrentHashMap2 == null || concurrentHashMap2.isEmpty();
    }

    public void onConnFailed(EndPoint endPoint) {
        IpLearning orCreateIpLearnerByKey;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) endPoint);
        } else if (endPoint != null && !"".equalsIgnoreCase(endPoint.keyOfAPN) && (orCreateIpLearnerByKey = getOrCreateIpLearnerByKey(endPoint.keyOfAPN)) != null) {
            orCreateIpLearnerByKey.onIpConnFail(endPoint.host, endPoint.port);
        }
    }

    public void onConnSuccess(EndPoint endPoint) {
        IpLearning orCreateIpLearnerByKey;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) endPoint);
        } else if (endPoint != null && !"".equalsIgnoreCase(endPoint.keyOfAPN) && (orCreateIpLearnerByKey = getOrCreateIpLearnerByKey(endPoint.keyOfAPN)) != null) {
            orCreateIpLearnerByKey.onIpConnSucc(endPoint.host, endPoint.port, endPoint.isSameIsp);
        }
    }

    public ArrayList<HwNetSegConf> getNetSegConf(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        if (i3 == 0) {
            return this.mCfg.mSegConf;
        }
        if (i3 != 1) {
            return this.mCfg.mSegConf;
        }
        return this.mCfg.mShortVideoSegConf;
    }

    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        PersistentConfig persistentConfig = this.mCfg;
        if (persistentConfig == null) {
            return true;
        }
        ConcurrentHashMap<String, ArrayList<EndPoint>> concurrentHashMap = persistentConfig.mIpv6List;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            return false;
        }
        ConcurrentHashMap<String, ArrayList<EndPoint>> concurrentHashMap2 = this.mCfg.mIpList;
        return concurrentHashMap2 == null || concurrentHashMap2.isEmpty();
    }
}
