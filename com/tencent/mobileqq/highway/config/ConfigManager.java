package com.tencent.mobileqq.highway.config;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.iplearning.IpLearningImpl;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.highway.utils.PTVUpConfigInfo;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ConfigManager implements IHwManager {
    static IPatchRedirector $redirector_ = null;
    private static final String BDH_FILE_DIR;
    private static final String CUSTOM_ENV_FILE_NAME = "custom_env";
    static final String HW_CONFIG_PUSH_FILENAME = "highway_config_push";
    static final String HW_CONFIG_SSOGET_FILENAME = "highway_config_ssoget";
    private static final String STORE_KEY_ID = "STORE_KEY_ID";
    private static final String STORE_KEY_IP = "STORE_KEY_IP";
    private static final String STORE_KEY_PORT = "STORE_KEY_PORT";
    public static final String TAG = "HWConfigManager";
    private static int mCustomID;
    private static volatile ConfigManager mUniqueInstance;
    public static int mUseHardCodeIp;
    private EndPoint mCustomEnvAddr;
    private boolean mCustomeEnvInit;
    private IpContainer mGetIpContainer;
    private ArrayList<HwNetSegConf> mHCNetSegConfList;
    private HardCodeIpList mHardCodeIpList;
    private CopyOnWriteArrayList<String> mHcDomainCandicateList;
    private Map<Integer, ServiceIpProvider> mIPProviders;
    private boolean mIsGettingConfg;
    private IpContainer mPushIpContainer;

    static {
        File externalFilesDir;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8709);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        mUseHardCodeIp = -1;
        StringBuilder sb5 = new StringBuilder();
        if (BaseApplication.getContext().getExternalFilesDir(null) == null) {
            externalFilesDir = BaseApplication.getContext().getFilesDir();
        } else {
            externalFilesDir = BaseApplication.getContext().getExternalFilesDir(null);
        }
        sb5.append(externalFilesDir.getAbsolutePath());
        sb5.append("/tencent/MobileQQ/bdh/");
        BDH_FILE_DIR = sb5.toString();
    }

    ConfigManager(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            return;
        }
        this.mIsGettingConfg = false;
        this.mIPProviders = new HashMap();
        ArrayList<HwNetSegConf> arrayList = new ArrayList<>();
        this.mHCNetSegConfList = arrayList;
        arrayList.add(new HwNetSegConf(0L, 8192L, 8L, 1L));
        this.mHCNetSegConfList.add(new HwNetSegConf(1L, 32768L, 8L, 2L));
        this.mHCNetSegConfList.add(new HwNetSegConf(2L, 8192L, 2L, 1L));
        this.mHCNetSegConfList.add(new HwNetSegConf(3L, 16384L, 6L, 2L));
        this.mHCNetSegConfList.add(new HwNetSegConf(4L, 32768L, 8L, 2L));
        initIpConfig(context);
    }

    public static int getCustomEnvId() {
        return mCustomID;
    }

    public static ConfigManager getInstance(Context context, HwEngine hwEngine) {
        if (mUniqueInstance == null) {
            if (context != null && hwEngine != null && hwEngine.currentUin != null) {
                synchronized (ConfigManager.class) {
                    if (mUniqueInstance == null) {
                        mUniqueInstance = new ConfigManager(context, hwEngine.currentUin);
                    }
                }
            } else {
                return null;
            }
        }
        return mUniqueInstance;
    }

    private HwNetSegConf getNetSegConfByType(ArrayList<HwNetSegConf> arrayList, int i3) {
        Iterator<HwNetSegConf> it = arrayList.iterator();
        while (it.hasNext()) {
            HwNetSegConf next = it.next();
            if (next.netType == i3) {
                return next;
            }
        }
        return null;
    }

    private void handleIpv6Cfg(Context context, HwConfig hwConfig) {
        int i3;
        boolean z16;
        int i16;
        PBUInt32Field pBUInt32Field = hwConfig.fmtIpv6Policy;
        boolean z17 = true;
        int i17 = 0;
        if (pBUInt32Field != null) {
            i3 = pBUInt32Field.get();
            z16 = true;
        } else {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onSrvAddrPush : hwConfig.fmtIpv6Policy is null ");
            i3 = 0;
            z16 = false;
        }
        PBUInt32Field pBUInt32Field2 = hwConfig.bdhIpv6Policy;
        if (pBUInt32Field2 != null) {
            i16 = pBUInt32Field2.get();
            z16 = true;
        } else {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onSrvAddrPush : hwConfig.bdhIpv6Policy is null ");
            i16 = 0;
        }
        PBUInt32Field pBUInt32Field3 = hwConfig.connAttemptDelay;
        if (pBUInt32Field3 != null) {
            i17 = pBUInt32Field3.get();
        } else {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onSrvAddrPush : hwConfig.connAttemptDelay is null ");
            z17 = z16;
        }
        if (z17) {
            Ipv6Config.updateCfgFromSrv(context, i3, i16, i17);
        }
    }

    private synchronized void initCustomEnv() {
        String str;
        String str2;
        FileInputStream fileInputStream;
        if (!this.mCustomeEnvInit) {
            File file = new File(BDH_FILE_DIR, CUSTOM_ENV_FILE_NAME);
            if (file.exists()) {
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            Properties properties = new Properties();
                            properties.load(fileInputStream);
                            String property = properties.getProperty(STORE_KEY_ID);
                            if (property != null) {
                                mCustomID = Integer.parseInt(property);
                            }
                            String property2 = properties.getProperty(STORE_KEY_IP);
                            String property3 = properties.getProperty(STORE_KEY_PORT);
                            if (property2 != null && property3 != null) {
                                this.mCustomEnvAddr = new EndPoint(property2, Integer.valueOf(property3).intValue());
                            }
                        } catch (Exception e16) {
                            e = e16;
                            fileInputStream2 = fileInputStream;
                            BdhLogUtil.LogException("E", "initCustomEnv err 1", e);
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e17) {
                                    e = e17;
                                    str = "E";
                                    str2 = "initCustomEnv err 2";
                                    BdhLogUtil.LogException(str, str2, e);
                                    this.mCustomeEnvInit = true;
                                }
                            }
                            this.mCustomeEnvInit = true;
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e18) {
                                    BdhLogUtil.LogException("E", "initCustomEnv err 2", e18);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e19) {
                    e = e19;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e26) {
                    e = e26;
                    str = "E";
                    str2 = "initCustomEnv err 2";
                    BdhLogUtil.LogException(str, str2, e);
                    this.mCustomeEnvInit = true;
                }
            }
            this.mCustomeEnvInit = true;
        }
    }

    private void initIpConfig(Context context) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.mHcDomainCandicateList = copyOnWriteArrayList;
        copyOnWriteArrayList.add("v6.htdata.qq.com");
        this.mHardCodeIpList = new HardCodeIpList();
        this.mPushIpContainer = new IpContainer(context, HW_CONFIG_PUSH_FILENAME);
        this.mGetIpContainer = new IpContainer(context, HW_CONFIG_SSOGET_FILENAME);
        this.mIPProviders.put(21, new ServiceIpProvider(context, 21));
    }

    private void onSvrConnFailed(EndPoint endPoint) {
        this.mPushIpContainer.onConnFailed(endPoint);
        this.mGetIpContainer.onConnFailed(endPoint);
    }

    private void onSvrConnSuccess(EndPoint endPoint) {
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onSvrConnSuccess() IP = " + endPoint.host);
        this.mPushIpContainer.onConnSuccess(endPoint);
        this.mGetIpContainer.onConnSuccess(endPoint);
    }

    private void processHwConfigPush(Context context, HwConfig hwConfig, AppRuntime appRuntime) {
        if (hwConfig == null) {
            return;
        }
        subcmd0x501.SubCmd0x501Rspbody.IpLearnConf ipLearnConf = hwConfig.ipConf;
        if (ipLearnConf != null && ipLearnConf.uint32_refresh_cached_ip.get() == 1) {
            IpContainer.refreshIpLearning();
        }
        subcmd0x501.SubCmd0x501Rspbody.IpLearnConf ipLearnConf2 = hwConfig.ipConf;
        if (ipLearnConf2 != null && ipLearnConf2.uint32_enable_ip_learn.get() == 1) {
            IpLearningImpl.sEnableIpLearning = 1;
        } else {
            IpLearningImpl.sEnableIpLearning = 0;
        }
        subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf dynTimeOutConf = hwConfig.dtConf;
        if (dynTimeOutConf != null) {
            BdhSegTimeoutUtil.updateFromSrv(dynTimeOutConf);
        }
        subcmd0x501.SubCmd0x501Rspbody.OpenUpConf openUpConf = hwConfig.openUpConf;
        if (openUpConf != null) {
            OpenUpConfig.updateFromSrv(openUpConf);
        }
        subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf shortVideoConf = hwConfig.videoConf;
        if (shortVideoConf != null) {
            VideoUpConfigInfo.updateFromSrc(shortVideoConf);
        } else {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onSrvAddrPush : hwConfig.videoConf is null ");
        }
        subcmd0x501.SubCmd0x501Rspbody.PTVConf pTVConf = hwConfig.ptvCof;
        if (pTVConf != null) {
            PTVUpConfigInfo.updateFromSrc(pTVConf);
        } else {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onSrvAddrPush : hwConfig.ptvCof is null ");
        }
        handleIpv6Cfg(context, hwConfig);
        this.mPushIpContainer.addNew(context, hwConfig, this);
    }

    private void processOtherTypeConfigPush(Map<Integer, HwConfig> map, AppRuntime appRuntime) {
        HwConfig hwConfig = map.get(21);
        if (hwConfig != null) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "processOtherTypeConfigPush() " + ((Object) 21));
            ServiceIpProvider serviceIpProvider = this.mIPProviders.get(21);
            if (serviceIpProvider != null) {
                serviceIpProvider.addPushIp(hwConfig);
            }
        }
    }

    public static void saveCustomEnv(String str, String str2, String str3) {
        File file = new File(BDH_FILE_DIR);
        File file2 = new File(file, CUSTOM_ENV_FILE_NAME);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            if (file2.exists()) {
                file2.delete();
                return;
            }
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                file.mkdirs();
                file2.delete();
                if (file2.createNewFile()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        Properties properties = new Properties();
                        if (!TextUtils.isEmpty(str)) {
                            properties.setProperty(STORE_KEY_IP, str);
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            properties.setProperty(STORE_KEY_PORT, str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            try {
                                if (Integer.parseInt(str3) > 0) {
                                    properties.setProperty(STORE_KEY_ID, str3);
                                }
                            } catch (NumberFormatException e16) {
                                e16.printStackTrace();
                            }
                        }
                        properties.store(fileOutputStream2, "");
                        fileOutputStream = fileOutputStream2;
                    } catch (IOException e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        file2.delete();
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                }
                if (fileOutputStream == null) {
                    return;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e18) {
            e = e18;
        }
        try {
            fileOutputStream.close();
        } catch (Exception unused2) {
        }
    }

    public void clearIpv6Cfg(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        } else {
            this.mPushIpContainer.cleanIpv6Cfg(context);
            this.mGetIpContainer.cleanIpv6Cfg(context);
        }
    }

    public SparseArray<HwNetSegConf> getAllBuzSegConfs(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (SparseArray) iPatchRedirector.redirect((short) 14, (Object) this, (Object) context);
        }
        SparseArray<HwNetSegConf> sparseArray = new SparseArray<>();
        sparseArray.put(1, getNetSegConf(context, 1));
        sparseArray.put(0, getNetSegConf(context, 0));
        sparseArray.put(0, getNetSegConf(context, 0));
        return sparseArray;
    }

    public EndPoint getCustomEnvAddr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EndPoint) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        initCustomEnv();
        return this.mCustomEnvAddr;
    }

    public List<EndPoint> getIpList(Context context, boolean z16) {
        ArrayList<EndPoint> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(z16));
        }
        ArrayList arrayList2 = new ArrayList();
        IpContainer ipContainer = this.mPushIpContainer;
        if (ipContainer != null) {
            arrayList = ipContainer.findIpCurNetList(context, z16);
        } else {
            arrayList = null;
        }
        IpContainer ipContainer2 = this.mGetIpContainer;
        if (ipContainer2 != null && arrayList == null) {
            arrayList = ipContainer2.findIpCurNetList(context, z16);
        }
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        return arrayList2;
    }

    public HwNetSegConf getNetSegConf(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? getNetSegConf(context, 0) : (HwNetSegConf) iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
    }

    public EndPoint getNextSrvAddr(Context context, AppRuntime appRuntime, String str, boolean z16) {
        EndPoint endPoint;
        EndPoint endPoint2;
        EndPoint nextIp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EndPoint) iPatchRedirector.redirect((short) 3, this, context, appRuntime, str, Boolean.valueOf(z16));
        }
        EndPoint customEnvAddr = getCustomEnvAddr();
        if (customEnvAddr != null) {
            return customEnvAddr;
        }
        IpContainer ipContainer = this.mPushIpContainer;
        if (ipContainer != null) {
            endPoint = ipContainer.findIpCurNet(context, z16);
            if (endPoint != null) {
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "getNextSrvAddr, mPushIpContainer.findIpCurNet, epFromPush = " + endPoint.toString() + " with key= " + endPoint.keyOfAPN + ", timestamp = " + endPoint.timestamp);
            }
        } else {
            endPoint = null;
        }
        IpContainer ipContainer2 = this.mGetIpContainer;
        if (ipContainer2 != null) {
            endPoint2 = ipContainer2.findIpCurNet(context, z16);
            if (endPoint2 != null) {
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "getNextSrvAddr, mGetIpContainer.findIpCurNet, epFromGet =  " + endPoint2.toString() + " with key= " + endPoint2.keyOfAPN + ", timestamp = " + endPoint2.timestamp);
            }
        } else {
            endPoint2 = null;
        }
        if (endPoint != null && endPoint2 != null) {
            if (endPoint.timestamp <= endPoint2.timestamp) {
                return endPoint2;
            }
            return endPoint;
        }
        if (endPoint != null) {
            return endPoint;
        }
        if (endPoint2 != null) {
            return endPoint2;
        }
        if (!this.mIsGettingConfg) {
            HwServlet.getConfig(appRuntime, str);
        }
        IpContainer ipContainer3 = this.mPushIpContainer;
        if (ipContainer3 != null && (endPoint = ipContainer3.findIpRecent(context, z16)) != null) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "getNextSrvAddr, mPushIpContainer.findIpRecent, epFromPush = " + endPoint.toString() + " with key= " + endPoint.keyOfAPN + ", timestamp = " + endPoint.timestamp);
        }
        IpContainer ipContainer4 = this.mGetIpContainer;
        if (ipContainer4 != null && (endPoint2 = ipContainer4.findIpRecent(context, z16)) != null) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "getNextSrvAddr, mGetIpContainer.findIpRecent, epFromGet =  " + endPoint2.toString() + " with key= " + endPoint2.keyOfAPN + ", timestamp = " + endPoint2.timestamp);
        }
        if (endPoint != null && endPoint2 != null) {
            if (endPoint.timestamp <= endPoint2.timestamp) {
                return endPoint2;
            }
            return endPoint;
        }
        if (endPoint != null) {
            return endPoint;
        }
        if (endPoint2 != null) {
            return endPoint2;
        }
        if (mUseHardCodeIp == -1) {
            mUseHardCodeIp = 1;
        }
        EndPoint randomFromCandicate4HardCode = this.mHardCodeIpList.getRandomFromCandicate4HardCode(this.mHcDomainCandicateList);
        if (randomFromCandicate4HardCode != null) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "getNextSrvAddr(), mHardCodeIpList.getRandomFromCandicate4HardCode, epDomain =  " + randomFromCandicate4HardCode.host + " port=" + randomFromCandicate4HardCode.port);
            return randomFromCandicate4HardCode;
        }
        if (!z16 && (nextIp = this.mHardCodeIpList.getNextIp(context)) != null) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "getNextSrvAddr(), mHardCodeIpList.getNextIp, epHardCode =  " + nextIp.host + " port=" + nextIp.port);
            return nextIp;
        }
        initIpConfig(context);
        return null;
    }

    public List<EndPoint> getOtherTypeIp(Context context, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, this, context, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        ServiceIpProvider serviceIpProvider = this.mIPProviders.get(Integer.valueOf(i3));
        if (serviceIpProvider != null) {
            return serviceIpProvider.getIpList(context, z16);
        }
        return null;
    }

    public boolean hasIpv6List(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) context)).booleanValue();
        }
        IpContainer ipContainer = this.mPushIpContainer;
        if (ipContainer != null && ipContainer.findIpCurNet(context, true) != null) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "hasIpv6List: mPushIpContainer has ipv6 list ");
            return true;
        }
        IpContainer ipContainer2 = this.mGetIpContainer;
        if (ipContainer2 != null && ipContainer2.findIpCurNet(context, true) != null) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "hasIpv6List: mGetIpContainer has ipv6 list ");
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.highway.IHwManager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            synchronized (ConfigManager.class) {
                mUniqueInstance = null;
            }
        }
    }

    @Override // com.tencent.mobileqq.highway.IHwManager
    public void onInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    public void onOtherTypeSrvAddrGet(HwConfig hwConfig, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) hwConfig, i3);
            return;
        }
        if (hwConfig != null && !hwConfig.ipList.isEmpty()) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onOtherTypeSrvAddrGet() " + i3);
            ServiceIpProvider serviceIpProvider = this.mIPProviders.get(Integer.valueOf(i3));
            if (serviceIpProvider != null) {
                serviceIpProvider.addSSOGetIp(hwConfig);
            }
        }
    }

    public void onSrvAddrPush(Context context, AppRuntime appRuntime, Map<Integer, HwConfig> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, appRuntime, map);
        } else if (map != null) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onSrvAddrPush() ");
            processHwConfigPush(context, map.get(10), appRuntime);
            processOtherTypeConfigPush(map, appRuntime);
        }
    }

    public void onSrvAddrSsoGet(HwConfig hwConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) hwConfig);
        } else {
            if (hwConfig == null) {
                return;
            }
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onSrvAddrHttpGet() ");
            this.mGetIpContainer.addNew(BaseApplication.getContext(), hwConfig, this);
            this.mIsGettingConfg = false;
        }
    }

    public void onSrvAddrUnavailable(Context context, String str, String str2, int i3, boolean z16) {
        HardCodeIpList hardCodeIpList;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, str, str2, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (i3 == 3) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onSrvAddrUnavailable() connError_unreachable");
            return;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onSrvAddrUnavailable() IP = " + str2);
        boolean fail = this.mPushIpContainer.fail(str2, z16);
        boolean fail2 = this.mGetIpContainer.fail(str2, z16);
        if (!fail && !fail2 && (copyOnWriteArrayList = this.mHcDomainCandicateList) != null) {
            z17 = HardCodeIpList.foundNRemoveIP(copyOnWriteArrayList, str2);
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onSrvAddrUnavailable, remove from mHcDomainCandicateList ");
        }
        if (!z17 && (hardCodeIpList = this.mHardCodeIpList) != null) {
            hardCodeIpList.foundNRemove(str2);
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onSrvAddrUnavailable, remove from mHardCodeIpList ");
        }
    }

    public void onSvrConnFinish(EndPoint endPoint, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) endPoint, i3);
            return;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, " onSvrConnFinish IP = " + endPoint.host + " err:" + i3);
        if (i3 == 0) {
            onSvrConnSuccess(endPoint);
        } else if (i3 != 3) {
            onSvrConnFailed(endPoint);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r4 != 5) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HwNetSegConf getNetSegConf(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (HwNetSegConf) iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, i3);
        }
        ArrayList<HwNetSegConf> arrayList = this.mHCNetSegConfList;
        ArrayList<HwNetSegConf> netSegConf = this.mPushIpContainer.getNetSegConf(i3);
        if (netSegConf == null || netSegConf.isEmpty()) {
            ArrayList<HwNetSegConf> netSegConf2 = this.mGetIpContainer.getNetSegConf(i3);
            if (netSegConf2 != null && !netSegConf2.isEmpty()) {
                arrayList = netSegConf2;
            }
        } else {
            arrayList = netSegConf;
        }
        int systemNetwork = HwNetworkUtil.getSystemNetwork(context);
        int i16 = 0;
        if (systemNetwork != 0) {
            if (systemNetwork != 1) {
                int i17 = 2;
                if (systemNetwork != 2) {
                    i17 = 3;
                    if (systemNetwork != 3) {
                        i17 = 4;
                        if (systemNetwork != 4) {
                        }
                    }
                }
                i16 = i17;
            }
            i16 = 1;
        }
        HwNetSegConf netSegConfByType = getNetSegConfByType(arrayList, i16);
        if (netSegConfByType != null) {
            return netSegConfByType;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "getNetSegConf() cannot find segment config from PUSH or HTTP GET");
        return getNetSegConfByType(this.mHCNetSegConfList, i16);
    }
}
