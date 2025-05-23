package com.tencent.mobileqq.soload.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoadResService;
import com.tencent.mobileqq.soload.api.ISoLoaderCommonetService;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;
import com.tencent.mobileqq.soload.biz.SoLoadIPCModule;
import com.tencent.mobileqq.soload.download.DownloadParam;
import com.tencent.mobileqq.soload.download.SoPriorityInjection;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoLoaderCommonetServiceImpl implements ISoLoaderCommonetService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SoLoadWidget.SoLoaderCommonetServiceImpl";
    private static final Object sLock;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f288530a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f288531b;

        /* renamed from: c, reason: collision with root package name */
        private ISoLoadResService.PathResult f288532c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f288533d;

        public a(ISoLoadResService.PathResult pathResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) pathResult);
                return;
            }
            this.f288530a = -1L;
            this.f288531b = false;
            ISoLoadResService.PathResult pathResult2 = this.f288532c;
            this.f288533d = pathResult2 != null && SoLoaderCommonetServiceImpl.retryUnzip(pathResult2);
            this.f288532c = pathResult;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21325);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            sLock = new Object();
        }
    }

    public SoLoaderCommonetServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean checkMd5(a aVar, ISoLoadResService.PathResult pathResult, String str, String str2) {
        String str3;
        if (aVar.f288531b) {
            if (pathResult != null && !TextUtils.isEmpty(pathResult.filePath)) {
                str3 = MD5Coding.encodeFile2HexStr(pathResult.filePath);
            } else {
                str3 = null;
            }
            if (!TextUtils.isEmpty(str2) && !str2.equalsIgnoreCase(str3)) {
                ((ISoLoadResService) QRoute.api(ISoLoadResService.class)).deleteRes(str, false);
                return false;
            }
        }
        return true;
    }

    private ISoLoadResService.PathResult getResPathResult(String str, String str2) {
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.url = str;
        downloadParam.md5ForChecked = str2;
        return ((ISoLoadResService) QRoute.api(ISoLoadResService.class)).getResPathSync(downloadParam);
    }

    private long getRetryUnzipCrc(ISoLoadResService.PathResult pathResult, String str, boolean z16) {
        String str2;
        if (z16) {
            if (pathResult != null && !TextUtils.isEmpty(pathResult.folderPath)) {
                str2 = new File(pathResult.folderPath, str).getAbsolutePath();
            } else {
                str2 = "";
            }
            return IOUtil.getCRC32Value(new File(str2));
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getResPathAsync$0(OnSoGetPathListener onSoGetPathListener, int i3, int i16, int i17, ISoLoadResService.PathResult pathResult) {
        if (pathResult == null) {
            QLog.e(TAG, 1, "[onResult] pathRes is null");
            return;
        }
        if (onSoGetPathListener != null) {
            onSoGetPathListener.onResult(i17, pathResult.filePath, pathResult.folderPath, pathResult.url, pathResult.isAlreadyExist, pathResult.subErrCode);
        }
        com.tencent.mobileqq.soload.util.h.g(i17, pathResult.subErrCode, pathResult.downloadCost, pathResult.url, i3, 1, i16, pathResult.fileSize);
    }

    public static boolean retryUnzip(ISoLoadResService.PathResult pathResult) {
        boolean unzipAtomically;
        if (TextUtils.isEmpty(pathResult.filePath) || TextUtils.isEmpty(pathResult.folderPath)) {
            return false;
        }
        Object obj = sLock;
        synchronized (obj) {
            FileUtils.delete(pathResult.folderPath, false);
            synchronized (obj) {
                unzipAtomically = ((ISoLoadResService) QRoute.api(ISoLoadResService.class)).unzipAtomically(pathResult.filePath, pathResult.folderPath);
            }
            return unzipAtomically;
        }
        return unzipAtomically;
    }

    private boolean validateCRC(boolean z16, boolean z17, long j3, a aVar) {
        if (!z16) {
            return false;
        }
        if (z17 && aVar.f288530a != j3) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService
    public void addReportItem(long j3, String str, String str2, String str3, int i3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), str, str2, str3, Integer.valueOf(i3), str4);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService
    public void endReport(long j3, String str, String str2, int i3, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), str, str2, Integer.valueOf(i3), str3);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService
    public int getFileExistStatusInMainProcess(String str) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).intValue();
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof BaseQQAppInterface) {
            try {
                if (!new File(str).exists()) {
                    return 1;
                }
                return 2;
            } catch (Throwable th5) {
                QLog.e("getFileExistStatus", 1, th5, new Object[0]);
                return 3;
            }
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("oper_type", 18);
        bundle2.putString("path", str);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), SoLoadIPCModule.NAME, SoLoadIPCModule.ACTION_COM_IPC_UTILS, bundle2);
        if (callServer != null && callServer.isSuccess() && (bundle = callServer.data) != null) {
            try {
                if (bundle.containsKey("res")) {
                    return callServer.data.getInt("res");
                }
                return 4;
            } catch (Throwable th6) {
                QLog.e("getFileExistStatus IPC", 1, th6, new Object[0]);
                return 5;
            }
        }
        return 6;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService
    public String getResFolderPathSync(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
        QLog.i(TAG, 2, "[getResFolderPathSync] url:" + str + ",md5:" + str2);
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.url = str;
        downloadParam.md5ForChecked = str2;
        ISoLoadResService.PathResult resPathSync = ((ISoLoadResService) QRoute.api(ISoLoadResService.class)).getResPathSync(downloadParam);
        if (resPathSync != null && !TextUtils.isEmpty(resPathSync.folderPath)) {
            return resPathSync.folderPath;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService
    public void getResPathAsync(String str, String str2, String str3, boolean z16, final OnSoGetPathListener onSoGetPathListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        final int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, str3, Boolean.valueOf(z16), onSoGetPathListener);
            return;
        }
        QLog.i(TAG, 2, "[getResFolderPathSync] url:" + str + ",md5:" + str2 + ",relativeSoName:" + str3);
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.url = str;
        downloadParam.md5ForChecked = str2;
        if (SoPriorityInjection.c(str3) && com.tencent.mobileqq.soload.util.f.G()) {
            downloadParam.downloaderType = 6;
            downloadParam.downloadPriority = SoPriorityInjection.b(str3);
        } else {
            i3 = 0;
        }
        boolean z17 = com.tencent.mobileqq.soload.util.f.z(MobileQQ.sMobileQQ);
        ISoLoadResService iSoLoadResService = (ISoLoadResService) QRoute.api(ISoLoadResService.class);
        final int i16 = z17 ? 1 : 0;
        iSoLoadResService.getResPath(downloadParam, new ISoLoadResService.OnGetPathListener() { // from class: com.tencent.mobileqq.soload.api.impl.q
            @Override // com.tencent.mobileqq.soload.api.ISoLoadResService.OnGetPathListener
            public final void onResult(int i17, ISoLoadResService.PathResult pathResult) {
                SoLoaderCommonetServiceImpl.lambda$getResPathAsync$0(OnSoGetPathListener.this, i3, i16, i17, pathResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService
    public String getResPathSync(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, str, str2, str3);
        }
        QLog.i(TAG, 2, "[getResPathSync] fileName:" + str + ",url:" + str2);
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.url = str2;
        downloadParam.md5ForChecked = str3;
        ISoLoadResService.PathResult resPathSync = ((ISoLoadResService) QRoute.api(ISoLoadResService.class)).getResPathSync(downloadParam);
        if (resPathSync != null && resPathSync.folderPath != null) {
            return new File(resPathSync.folderPath, str).getAbsolutePath();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService
    public boolean getResPathSyncWithUnZip(String str, String str2, String str3, boolean z16, long j3, long j16, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, str, str2, str3, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), str4, Integer.valueOf(i3))).booleanValue();
        }
        ISoLoadResService.PathResult resPathResult = getResPathResult(str2, str3);
        a aVar = new a(resPathResult);
        boolean z17 = aVar.f288533d;
        aVar.f288530a = getRetryUnzipCrc(resPathResult, str, z17);
        boolean validateCRC = validateCRC(z17, z16, j3, aVar);
        aVar.f288531b = !validateCRC;
        com.tencent.mobileqq.soload.util.h.f(validateCRC, str, z16, j3, j16, checkMd5(aVar, resPathResult, str2, str3), str2, 1);
        QLog.i(TAG, 1, "crc failed,getResPathSyncWithUnZip,unzip success:" + z17 + ",crc success:" + validateCRC + "correctCRC:" + j3 + ",retryUnzipCRC:" + aVar.f288530a);
        return validateCRC;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService
    public void singleReport(String str, String str2, String str3, String str4, String str5, int i3, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, str4, str5, Integer.valueOf(i3), str6);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderBaseCommonetService
    public long startReport(String str, String str2, String str3, String str4, String str5, int i3, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, Integer.valueOf(i3), str6)).longValue();
        }
        return 0L;
    }
}
