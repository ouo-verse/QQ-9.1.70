package com.tencent.mobileqq.soload.biz.entity;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class LoadExtResult implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final int ERROR_EXCEPTION_IO = -111;
    private static final int ERROR_EXCEPTION_SOCKET = -114;
    private static final int NONE_NET = -104;
    private static final String TAG = "LoadExtResult";
    private static final long TIME_INTERVAL_NETWORK_ERROR = 300000;
    private static final long TIME_INTERVAL_OTHER_ERROR = 600000;
    private int downloadSoNum;
    private int failIndex;
    public AsyncFailInfo failInfo;
    private boolean isFirstlyLoad;
    private boolean isNeedRetry;
    private Map<String, SoRecord> mPathsMap;
    private String reportStr;
    int resCode;
    private int soNum;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class SoRecord {
        static IPatchRedirector $redirector_;
        String rFileFolder;
        String soPath;
        String soVer;

        public SoRecord(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3);
                return;
            }
            this.soPath = str;
            this.rFileFolder = str2;
            this.soVer = str3;
        }
    }

    public LoadExtResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.failIndex = 0;
        this.downloadSoNum = 0;
        this.isFirstlyLoad = true;
        this.reportStr = "";
        this.isNeedRetry = false;
        this.mPathsMap = new HashMap();
    }

    public static LoadExtResult create(int i3, int i16) {
        return create(i3, i16, null, SoLoadInfo.sDefault, LoadOptions.sDefault);
    }

    private boolean isDownloadNetworkErr(int i3, int i16) {
        if (i3 == 3 && (i16 == -104 || i16 == -111 || i16 == -114)) {
            return true;
        }
        return false;
    }

    private boolean isGetConfigNetworkErr(int i3, int i16) {
        if (i3 == 2 && i16 == -2) {
            return true;
        }
        return false;
    }

    private LoadExtResult merge(LoadExtResult loadExtResult) {
        boolean z16;
        if (loadExtResult == null) {
            return this;
        }
        this.soNum += loadExtResult.soNum;
        this.resCode = loadExtResult.resCode;
        this.downloadSoNum += loadExtResult.downloadSoNum;
        boolean z17 = false;
        if (!this.isFirstlyLoad && !loadExtResult.isFirstlyLoad) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.isFirstlyLoad = z16;
        if (!TextUtils.isEmpty(loadExtResult.reportStr)) {
            if (!TextUtils.isEmpty(this.reportStr)) {
                this.reportStr += ContainerUtils.FIELD_DELIMITER;
            }
            this.reportStr += loadExtResult.reportStr;
        }
        if (loadExtResult.mPathsMap.size() > 0) {
            for (Map.Entry<String, SoRecord> entry : loadExtResult.mPathsMap.entrySet()) {
                this.mPathsMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.failInfo = loadExtResult.failInfo;
        if (this.isNeedRetry && loadExtResult.isNeedRetry) {
            z17 = true;
        }
        this.isNeedRetry = z17;
        return this;
    }

    public static LoadExtResult mergeExtResult(LoadExtResult loadExtResult, LoadExtResult loadExtResult2) {
        if (loadExtResult2 == null) {
            return loadExtResult;
        }
        return loadExtResult2.merge(loadExtResult);
    }

    public long getDelayAyncTime() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        AsyncFailInfo asyncFailInfo = this.failInfo;
        if (asyncFailInfo == null || asyncFailInfo.lastFailTime == 0) {
            return 0L;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[getDelayAyncTime]FailInfo:" + this.failInfo);
        }
        AsyncFailInfo asyncFailInfo2 = this.failInfo;
        if (!isDownloadNetworkErr(asyncFailInfo2.lastFailCode, asyncFailInfo2.lastSubFailCode)) {
            AsyncFailInfo asyncFailInfo3 = this.failInfo;
            if (!isGetConfigNetworkErr(asyncFailInfo3.lastFailCode, asyncFailInfo3.lastSubFailCode)) {
                j3 = 600000;
                return (this.failInfo.lastFailTime + j3) - NetConnInfoCenter.getServerTimeMillis();
            }
        }
        int networkType = NetworkUtil.getNetworkType(MobileQQ.sMobileQQ);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[getDelayAyncTime]curNetType:" + networkType);
        }
        if (this.failInfo.netType != networkType) {
            return 0L;
        }
        j3 = 300000;
        return (this.failInfo.lastFailTime + j3) - NetConnInfoCenter.getServerTimeMillis();
    }

    public String getRelatedFilesFolder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        SoRecord soRecord = this.mPathsMap.get(str);
        String str2 = soRecord == null ? "" : soRecord.rFileFolder;
        if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
            QLog.i(TAG, 1, "[getRelatedFilesFolder] is not exists:" + str2);
        }
        return str2;
    }

    public int getReportCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return (this.soNum * 100000) + (this.resCode * 1000) + (this.failIndex * 100) + (this.downloadSoNum * 10) + (!this.isFirstlyLoad ? 1 : 0);
    }

    public String getReportStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.reportStr;
    }

    public int getResultCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.resCode;
    }

    public String getSoLoadPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        SoRecord soRecord = this.mPathsMap.get(str);
        return soRecord == null ? "" : soRecord.soPath;
    }

    public String getVer(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        SoRecord soRecord = this.mPathsMap.get(str);
        return soRecord == null ? "" : soRecord.soVer;
    }

    public boolean isNeedRetry(LoadParam loadParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) loadParam)).booleanValue();
        }
        if (LoadParam.isCloseRetry(loadParam)) {
            return false;
        }
        if (isSucc() && !this.isNeedRetry) {
            return false;
        }
        return true;
    }

    public boolean isSucc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.resCode == 0) {
            return true;
        }
        return false;
    }

    public void setFailIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.failIndex = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "LRes{rCode=" + this.resCode + ",isSucc=" + isSucc() + '}';
    }

    public static LoadExtResult create(int i3, int i16, String str, @NonNull SoLoadInfo soLoadInfo, LoadOptions loadOptions) {
        LoadExtResult loadExtResult = new LoadExtResult();
        loadExtResult.soNum = i16;
        loadExtResult.resCode = i3;
        loadExtResult.downloadSoNum = soLoadInfo.isFinishDownload ? 1 : 0;
        loadExtResult.isFirstlyLoad = soLoadInfo.isFirstlyLoad;
        boolean z16 = false;
        loadExtResult.failIndex = i3 == 0 ? 0 : 1;
        if ((loadOptions.flag & 4) != 0 && soLoadInfo.soDetailInfo.relatedFileInfo != null && TextUtils.isEmpty(soLoadInfo.rFileFolder)) {
            z16 = true;
        }
        loadExtResult.isNeedRetry = z16;
        if (!TextUtils.isEmpty(str)) {
            loadExtResult.reportStr = str + ContainerUtils.KEY_VALUE_DELIMITER + i3;
            loadExtResult.mPathsMap.put(str, new SoRecord((i3 != 0 || (loadOptions.flag & 2) == 0) ? null : soLoadInfo.soPathToLoad, soLoadInfo.rFileFolder, soLoadInfo.getVer()));
        }
        return loadExtResult;
    }

    public String getSoLoadPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Iterator<SoRecord> it = this.mPathsMap.values().iterator();
        return it.hasNext() ? it.next().soPath : "";
    }

    public String getVer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Iterator<SoRecord> it = this.mPathsMap.values().iterator();
        return it.hasNext() ? it.next().soVer : "";
    }

    public String getRelatedFilesFolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Iterator<SoRecord> it = this.mPathsMap.values().iterator();
        return it.hasNext() ? it.next().rFileFolder : "";
    }
}
