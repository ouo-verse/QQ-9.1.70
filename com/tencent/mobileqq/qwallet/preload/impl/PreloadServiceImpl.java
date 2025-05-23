package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.DownloadChooseReq;
import Wallet.DownloadChooseRsp;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.impl.servlet.request.DownloadChooseRequest;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;
import kl2.PreloadConfBean;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;
import qk2.PreloadAdditionConfig;

/* loaded from: classes16.dex */
public class PreloadServiceImpl extends PreloadManagerAbs implements IPreloadService, INetInfoHandler {
    private static final int PRELOAD_DELAYS_MAX = 1800;
    private static final int PRELOAD_DELAYS_MIN = 5;
    private static final int SAFE_FREE_SPACE = 104857600;
    private PreloadBackControlConfig mBackControlConfig;
    private Handler mFlowControlHandler;
    private HandlerThread mFlowControlThread;
    private PreloadConfig mPreloadConfig;
    public boolean mIsOnDestroy = false;
    private int mPreloadDelays = 30;
    private int mNeedWaitSize = 1024;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadParam f279066a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IPreloadService.c f279067b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f279068c;

        a(DownloadParam downloadParam, IPreloadService.c cVar, WeakReference weakReference) {
            this.f279066a = downloadParam;
            this.f279067b = cVar;
            this.f279068c = weakReference;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(g gVar) {
            String absolutePath;
            super.onDoneFile(gVar);
            if (QLog.isColorLevel()) {
                QLog.d(IPreloadService.TAG, 2, "RealTime onDoneFile|" + gVar.f313006d + "|" + gVar.f313004c + "|" + gVar.f313010h.get(gVar.f313004c).getAbsolutePath());
            }
            if (gVar.f313006d == 0 && gVar.f313010h != null && !TextUtils.isEmpty(gVar.f313004c)) {
                File file = gVar.f313010h.get(gVar.f313004c);
                if (file == null) {
                    absolutePath = "";
                } else {
                    absolutePath = file.getAbsolutePath();
                }
                String encodeFile2HexStr = MD5Coding.encodeFile2HexStr(absolutePath);
                if (file != null && file.exists() && !TextUtils.isEmpty(encodeFile2HexStr)) {
                    if (!TextUtils.isEmpty(this.f279066a.md5ForChecked) && !this.f279066a.md5ForChecked.equalsIgnoreCase(encodeFile2HexStr)) {
                        IPreloadService.c cVar = this.f279067b;
                        if (cVar != null) {
                            cVar.onResult(2, IPreloadService.PathResult.getFailRes(gVar.f313004c));
                        }
                        com.tencent.mobileqq.qwallet.preload.a.a(gVar.f313004c, false, this.f279066a.filePos);
                        ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).reportResRealTimeDownload("RESULT_RES_PRELOAD_FAIL_MD5_CHECK", gVar.f313011i, gVar.f313006d);
                        return;
                    }
                    com.tencent.mobileqq.qwallet.preload.impl.c.o(gVar.f313004c, encodeFile2HexStr, NetConnInfoCenter.getServerTimeMillis(), this.f279066a.filePos);
                    ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).reportResRealTimeDownload("RESULT_RES_PRELOAD_SUCC", gVar.f313011i, gVar.f313006d);
                }
            } else {
                ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).reportResRealTimeDownload("RESULT_RES_PRELOAD_FAIL_DOWNLOAD", gVar.f313011i, gVar.f313006d);
            }
            if (!PreloadServiceImpl.isManagerValid((PreloadServiceImpl) this.f279068c.get())) {
                return;
            }
            int i3 = gVar.f313006d;
            if (i3 == 0) {
                String str = gVar.f313004c;
                DownloadParam downloadParam = this.f279066a;
                ResourceInfo f16 = com.tencent.mobileqq.qwallet.preload.impl.c.f(str, downloadParam.isForceUnzip, 0, downloadParam.filePos);
                IPreloadService.PathResult pathResult = new IPreloadService.PathResult();
                pathResult.url = gVar.f313004c;
                pathResult.filePath = f16.filePath;
                pathResult.folderPath = f16.folderPath;
                IPreloadService.c cVar2 = this.f279067b;
                if (cVar2 != null) {
                    cVar2.onResult(0, pathResult);
                    return;
                }
                return;
            }
            IPreloadService.c cVar3 = this.f279067b;
            if (cVar3 != null) {
                cVar3.onResult(1, IPreloadService.PathResult.getFailRes(gVar.f313004c, i3));
            }
        }
    }

    /* loaded from: classes16.dex */
    class b extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPreloadService.a f279070a;

        b(IPreloadService.a aVar) {
            this.f279070a = aVar;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(g gVar) {
            int i3;
            ResourceInfo resInfo;
            super.onDoneFile(gVar);
            if (QLog.isColorLevel()) {
                QLog.d(IPreloadService.TAG, 2, "downloadRes|done" + gVar.f313004c + "|" + gVar.f313006d);
            }
            Bundle h16 = gVar.h();
            PreloadModuleImpl preloadModuleImpl = (PreloadModuleImpl) h16.getSerializable("module");
            PreloadResourceImpl preloadResourceImpl = (PreloadResourceImpl) h16.getSerializable("resource");
            int i16 = gVar.f313006d;
            if (i16 == 0) {
                i3 = 0;
            } else if (i16 == -5) {
                i3 = -5;
            } else {
                i3 = -6;
            }
            if (preloadResourceImpl == null) {
                resInfo = null;
            } else {
                resInfo = preloadResourceImpl.getResInfo(preloadModuleImpl);
            }
            this.f279070a.onDownloadResFinished(preloadModuleImpl.mid, i3, gVar.f313010h.get(gVar.f313004c).getAbsolutePath(), resInfo);
        }
    }

    /* loaded from: classes16.dex */
    class c extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f279072a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IPreloadService.a f279073b;

        c(String str, IPreloadService.a aVar) {
            this.f279072a = str;
            this.f279073b = aVar;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(g gVar) {
            int i3;
            ResourceInfo resInfo;
            super.onDoneFile(gVar);
            if (QLog.isColorLevel()) {
                QLog.d(IPreloadService.TAG, 2, "downloadModule|done" + gVar.f313004c);
            }
            Bundle h16 = gVar.h();
            PreloadModuleImpl preloadModuleImpl = (PreloadModuleImpl) h16.getSerializable("module");
            PreloadResourceImpl preloadResourceImpl = (PreloadResourceImpl) h16.getSerializable("resource");
            if (com.tencent.mobileqq.qwallet.impl.d.r(preloadModuleImpl.mid, this.f279072a)) {
                if (QLog.isColorLevel()) {
                    QLog.d(IPreloadService.TAG, 2, "downloadModule|done code" + gVar.f313006d);
                }
                int i16 = gVar.f313006d;
                if (i16 == 0) {
                    i3 = 0;
                } else if (i16 == -5) {
                    i3 = -5;
                } else {
                    i3 = -6;
                }
                if (preloadResourceImpl == null) {
                    resInfo = null;
                } else {
                    resInfo = preloadResourceImpl.getResInfo(preloadModuleImpl);
                }
                this.f279073b.onDownloadResFinished(preloadModuleImpl.mid, i3, gVar.f313010h.get(gVar.f313004c).getAbsolutePath(), resInfo);
            }
        }
    }

    /* loaded from: classes16.dex */
    public static class d extends IPreloadService.b {

        /* renamed from: a, reason: collision with root package name */
        PreloadResourceImpl f279075a;

        /* renamed from: b, reason: collision with root package name */
        PreloadModuleImpl f279076b;

        /* renamed from: c, reason: collision with root package name */
        f f279077c;

        public d(PreloadResourceImpl preloadResourceImpl, PreloadModuleImpl preloadModuleImpl, f fVar) {
            this.f279075a = preloadResourceImpl;
            this.f279076b = preloadModuleImpl;
            this.f279077c = fVar;
        }

        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.b
        public void a(IPreloadService iPreloadService) {
            PreloadResourceImpl preloadResourceImpl = this.f279075a;
            if (preloadResourceImpl != null) {
                preloadResourceImpl.handleFlowConfig(iPreloadService, this.f279076b, this.f279077c);
            }
        }
    }

    /* loaded from: classes16.dex */
    private class e {

        /* renamed from: a, reason: collision with root package name */
        List<DownloadParam> f279078a;

        /* renamed from: b, reason: collision with root package name */
        IPreloadService.d f279079b;

        /* renamed from: c, reason: collision with root package name */
        HashMap<String, IPreloadService.PathResult> f279080c = new HashMap<>();

        /* renamed from: d, reason: collision with root package name */
        boolean f279081d = false;

        /* renamed from: e, reason: collision with root package name */
        int f279082e = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes16.dex */
        public class a implements IPreloadService.c {
            a() {
            }

            @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
            public void onResult(int i3, IPreloadService.PathResult pathResult) {
                e eVar;
                IPreloadService.d dVar;
                e eVar2 = e.this;
                eVar2.f279082e++;
                if (i3 == 0) {
                    eVar2.f279080c.put(pathResult.url, pathResult);
                } else {
                    eVar2.f279081d = true;
                }
                e eVar3 = e.this;
                if (eVar3.f279082e >= eVar3.f279078a.size() && (dVar = (eVar = e.this).f279079b) != null) {
                    dVar.onResult(eVar.f279081d ? 1 : 0, eVar.f279080c);
                }
            }
        }

        public e(List<DownloadParam> list, IPreloadService.d dVar) {
            this.f279078a = list;
            this.f279079b = dVar;
        }

        public void a() {
            Iterator<DownloadParam> it = this.f279078a.iterator();
            while (it.hasNext()) {
                PreloadServiceImpl.this.getResPath(it.next(), new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void checkAndDownload(boolean z16) {
        try {
            checkAndDownload(null, z16);
        } catch (Throwable th5) {
            QLog.d(IPreloadService.TAG, 1, "checkAndDownload is error msg= " + th5.getMessage());
        }
    }

    private List<PreloadModuleImpl> delayLargerModulesAndReturnSmallerModules(List<PreloadModuleImpl> list, final f fVar) {
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        PreloadConfig.splitModulesBySize(this.mNeedWaitSize, list, arrayList, arrayList2);
        if (arrayList2.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d(IPreloadService.TAG, 2, "delayLargerModulesAndReturnSmallerModules|begin delay download:" + this.mPreloadDelays + "|" + this.mNeedWaitSize + "|" + arrayList2);
            }
            final WeakReference weakReference = new WeakReference(this);
            ThreadManagerV2.getTimer().schedule(new TimerTask() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    PreloadServiceImpl preloadServiceImpl = (PreloadServiceImpl) weakReference.get();
                    if (PreloadServiceImpl.isManagerValid(preloadServiceImpl)) {
                        preloadServiceImpl.downloadModules(arrayList2, fVar);
                    }
                }
            }, this.mPreloadDelays * 1000);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadBackControlModules(final List<PreloadModuleImpl> list, final f fVar, final boolean z16) {
        PreloadBackControlConfig preloadBackControlConfig = this.mBackControlConfig;
        if (preloadBackControlConfig == null) {
            return;
        }
        if (!preloadBackControlConfig.isLocalResNewest()) {
            DownloadChooseReq downloadChooseReq = new DownloadChooseReq();
            downloadChooseReq.iUin = com.tencent.mobileqq.base.a.a();
            downloadChooseReq.vecResInfo = PreloadConfig.modulesToResInfos(list);
            com.tencent.mobileqq.qwallet.impl.servlet.c.c(new DownloadChooseRequest(downloadChooseReq), new BusinessObserver() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.2
                @Override // mqq.observer.BusinessObserver
                public void onReceive(int i3, boolean z17, Bundle bundle) {
                    if (z17 && i3 == 3) {
                        try {
                            DownloadChooseRsp downloadChooseRsp = (DownloadChooseRsp) bundle.getSerializable("rsp");
                            if (downloadChooseRsp == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(IPreloadService.TAG, 2, "download choose rsp is null:" + downloadChooseRsp);
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(IPreloadService.TAG, 2, "download choose rsp:" + downloadChooseRsp.vecResInfo);
                            }
                            PreloadServiceImpl.this.mBackControlConfig.update(downloadChooseRsp.vecResInfo);
                            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    PreloadServiceImpl.this.downloadBackControlModules(list, fVar, z16);
                                }
                            }, 5, null, true);
                        } catch (Throwable th5) {
                            if (QLog.isColorLevel()) {
                                QLog.d(IPreloadService.TAG, 2, "downloadBackControlModules onReceive exception:" + th5);
                            }
                        }
                    }
                }
            });
            return;
        }
        List<PreloadModuleImpl> resInfosToModules = this.mPreloadConfig.resInfosToModules(this.mBackControlConfig.getLastBackResInfos());
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "downloadBackControlModules|choose res:" + resInfosToModules);
        }
        downloadModules(resInfosToModules, fVar, z16);
    }

    private void downloadModules(List<PreloadModuleImpl> list, f fVar, boolean z16) {
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d(IPreloadService.TAG, 2, "downloadModules|afterGetConfig");
            }
            list = delayLargerModulesAndReturnSmallerModules(list, fVar);
        }
        downloadModules(list, fVar);
    }

    private void initFlowControlHandler() {
        if (this.mFlowControlHandler == null) {
            this.mFlowControlHandler = new Handler(ThreadManagerV2.getSubThreadLooper()) { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.7

                /* renamed from: a, reason: collision with root package name */
                private LinkedList<IPreloadService.b> f279060a = new LinkedList<>();

                /* renamed from: b, reason: collision with root package name */
                private boolean f279061b = false;

                private void a() {
                    final WeakReference weakReference = new WeakReference(PreloadServiceImpl.this);
                    final IPreloadService.b first = this.f279060a.getFirst();
                    this.f279060a.removeFirst();
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PreloadServiceImpl preloadServiceImpl = (PreloadServiceImpl) weakReference.get();
                            if (PreloadServiceImpl.isManagerValid(preloadServiceImpl)) {
                                first.a(preloadServiceImpl);
                            }
                        }
                    }, 64, null, false);
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (PreloadServiceImpl.this.mIsOnDestroy) {
                        return;
                    }
                    int i3 = message.what;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            if (this.f279060a.size() > 0) {
                                a();
                                return;
                            } else {
                                this.f279061b = false;
                                return;
                            }
                        }
                        return;
                    }
                    this.f279060a.addLast((IPreloadService.b) message.obj);
                    if (!this.f279061b) {
                        this.f279061b = true;
                        sendEmptyMessage(2);
                    }
                }
            };
        }
    }

    private void initPreloadHelpConfig() {
        PreloadAdditionConfig preloadAdditionConfig = (PreloadAdditionConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_PRELOAD_ADDITION_CONFIG, new PreloadAdditionConfig());
        int delayInterval = preloadAdditionConfig.getContent().getDelayInterval();
        int needWaitSize = preloadAdditionConfig.getContent().getNeedWaitSize();
        setPreloadHelpConfig(delayInterval, needWaitSize);
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "initPreloadHelpConfig|" + delayInterval + "|" + needWaitSize + "|" + this.mPreloadDelays + "|" + this.mNeedWaitSize);
        }
    }

    private boolean isDiskEnoughToDownload() {
        long j3;
        String k3 = com.tencent.mobileqq.qwallet.preload.a.k();
        File file = new File(k3);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!TextUtils.isEmpty(k3)) {
            j3 = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getFreeSpace(k3);
            if (j3 > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                if (QLog.isColorLevel()) {
                    QLog.d(IPreloadService.TAG, 2, "isDiskEnoughToDownload|true|" + k3 + "|" + j3);
                    return true;
                }
                return true;
            }
        } else {
            j3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "isDiskEnoughToDownload|false|" + k3 + "|" + j3);
            return false;
        }
        return false;
    }

    public static boolean isManagerValid(PreloadServiceImpl preloadServiceImpl) {
        if (preloadServiceImpl != null && !preloadServiceImpl.mIsOnDestroy) {
            return true;
        }
        return false;
    }

    private void saveConfigFromQQToSp(String str) {
        SharedPreferences sharedPreferences;
        BaseApplication context = BaseApplication.getContext();
        if (context != null && (sharedPreferences = context.getSharedPreferences(IPreloadService.PREF_NAME_QWALLET_PRELOAD_CONFIG, 4)) != null) {
            sharedPreferences.edit().putString(IPreloadService.KEY_CONFIG_FROM_QQ + com.tencent.mobileqq.base.a.c(), str).apply();
        }
    }

    private void toReportCrash(Throwable th5) {
        if (th5 != null) {
            StringBuilder sb5 = new StringBuilder(256);
            sb5.append(th5.toString());
            if (th5.getStackTrace() != null) {
                StackTraceElement[] stackTrace = th5.getStackTrace();
                for (int i3 = 0; i3 < stackTrace.length && i3 < 16; i3++) {
                    sb5.append("\n ");
                    sb5.append(stackTrace[i3].toString());
                }
            }
            VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "crash", "Catch", null, 668814, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public void addResToFlowControlCheck(IPreloadService.b bVar) {
        if (this.mFlowControlHandler == null) {
            initFlowControlHandler();
        }
        Message obtainMessage = this.mFlowControlHandler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = bVar;
        this.mFlowControlHandler.sendMessage(obtainMessage);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public synchronized void downloadModule(String str, boolean z16) {
        PreloadModuleImpl moduleByName = getModuleByName(str);
        if (moduleByName != null) {
            moduleByName.downloadModule(z16, null, this, false);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    @Deprecated
    public synchronized void downloadRes(String str, String str2, IPreloadService.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "downloadRes|" + str + "|" + str2);
        }
        if (!TextUtils.isEmpty(str2)) {
            mergeConfig(str2);
            this.mPreloadConfig.savePreloadConfig();
        }
        PreloadModuleImpl preloadModuleImpl = null;
        PreloadResourceImpl preloadResourceImpl = null;
        for (PreloadModuleImpl preloadModuleImpl2 : this.mPreloadConfig.getModules()) {
            for (PreloadResourceImpl preloadResourceImpl2 : preloadModuleImpl2.getResList()) {
                if (com.tencent.mobileqq.qwallet.impl.d.r(str, preloadResourceImpl2.mResId)) {
                    preloadModuleImpl = preloadModuleImpl2;
                    preloadResourceImpl = preloadResourceImpl2;
                }
            }
        }
        if (preloadModuleImpl != null && preloadResourceImpl != null) {
            if (!isDiskEnoughToDownload()) {
                if (QLog.isColorLevel()) {
                    QLog.d(IPreloadService.TAG, 2, "downloadRes|disk space not enough");
                }
                aVar.onDownloadResFinished(null, -4, null, null);
                return;
            }
            preloadResourceImpl.startDownload(this, preloadModuleImpl, new b(aVar), false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "downloadRes ERR_CONFIG_NOT_EXIST");
        }
        aVar.onDownloadResFinished(null, -7, null, null);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public void downloadUrls(List<String> list, IPreloadService.c cVar) {
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                getResPath(it.next(), cVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public void getFilePath(String str, IPreloadService.c cVar) {
        getFilePath(str, "", cVar);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public synchronized void getFilePathByResID(String str, ResultReceiver resultReceiver) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            for (PreloadModuleImpl preloadModuleImpl : this.mPreloadConfig.getModules()) {
                for (PreloadResourceImpl preloadResourceImpl : preloadModuleImpl.getResList()) {
                    if (com.tencent.mobileqq.qwallet.impl.d.r(str, preloadResourceImpl.mResId)) {
                        str2 = com.tencent.mobileqq.qwallet.preload.a.o(preloadResourceImpl.getResDownloadUrl(preloadModuleImpl), preloadResourceImpl.getFilePos());
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "getFilePathByResID|" + str + "|" + this.mPreloadConfig + "|" + str2);
        }
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putString("path", str2);
            resultReceiver.send(0, bundle);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public String getResIdByUrl(String str) {
        return this.mPreloadConfig.getResIdByUrl(str);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public ResourceInfo getResInfoByResId(String str) {
        ResourceInfo resInfoByResId = this.mPreloadConfig.getResInfoByResId(str);
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "getResInfoByResId :" + str + "|" + resInfoByResId);
        }
        return resInfoByResId;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public void getResPath(LinkedList<DownloadParam> linkedList, IPreloadService.d dVar) {
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "getResPath: params" + linkedList + ",OnGetPathsListener=" + dVar);
        }
        if (linkedList != null) {
            new e(linkedList, dVar).a();
        } else if (dVar != null) {
            dVar.onResult(1, null);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public void getUnzipFolderPath(String str, IPreloadService.c cVar) {
        getUnzipFolderPath(str, "", cVar);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public String getUnzipFolderPathByResId(String str) {
        ResourceInfo resInfoByResId = getResInfoByResId(str);
        if (resInfoByResId != null) {
            return resInfoByResId.folderPath;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.impl.PreloadManagerAbs, com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public synchronized String getVideoResPathByID(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "getVideoResPathByID|" + str + "|" + this.mPreloadConfig);
        }
        PreloadModuleImpl moduleByID = this.mPreloadConfig.getModuleByID(str);
        if (moduleByID != null) {
            for (PreloadResourceImpl preloadResourceImpl : moduleByID.getResList()) {
                if (preloadResourceImpl.type == 5 && (!TextUtils.isEmpty(preloadResourceImpl.url) || !TextUtils.isEmpty(preloadResourceImpl.urlPath))) {
                    return com.tencent.mobileqq.qwallet.preload.a.o(preloadResourceImpl.getResDownloadUrl(moduleByID), preloadResourceImpl.getFilePos());
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "getVideoResPathByID no valid path");
        }
        return null;
    }

    public boolean isResInConfig(PreloadResourceImpl preloadResourceImpl) {
        return this.mPreloadConfig.isResInConfig(preloadResourceImpl);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public synchronized void mergeConfig(String str) {
        this.mPreloadConfig.mergeConfig(str, this);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public void notifyResFlowCheckNext() {
        if (this.mFlowControlHandler == null) {
            initFlowControlHandler();
        }
        this.mFlowControlHandler.sendEmptyMessage(2);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.impl.PreloadManagerAbs, mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        super.onCreate(appRuntime);
        this.mPreloadConfig = PreloadConfig.readConfig(IPreloadService.CONIFG_FILE_NAME);
        this.mBackControlConfig = PreloadBackControlConfig.readBackControlConfig();
        initPreloadHelpConfig();
        try {
            AppNetConnInfo.registerConnectionChangeReceiver(appRuntime.getApplication(), this);
        } catch (Throwable th5) {
            QLog.d(IPreloadService.TAG, 1, "AppNetConnInfo.registerConnectionChangeReceiver is error msg=" + th5.getMessage());
            toReportCrash(th5);
        }
        PreloadResConfigPrinter.f279031a.a(this.mPreloadConfig.getModules());
    }

    @Override // com.tencent.mobileqq.qwallet.preload.impl.PreloadManagerAbs, mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mIsOnDestroy = true;
        AppNetConnInfo.unregisterNetInfoHandler(this);
        Handler handler = this.mFlowControlHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mBackControlConfig = null;
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "onNetMobile2Wifi");
        }
        startCheckConfig();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "onNetNone2Mobile");
        }
        startCheckConfig();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "onNetNone2Wifi");
        }
        startCheckConfig();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "onNetWifi2Mobile");
        }
        startCheckConfig();
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public void preCheck() {
        if (!com.tencent.mobileqq.qwallet.preload.a.f278999a) {
            com.tencent.mobileqq.qwallet.preload.impl.c.l(0, this.mPreloadConfig);
        }
        com.tencent.mobileqq.qwallet.preload.impl.c.l(1, this.mPreloadConfig);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public void realTimeDownload(DownloadParam downloadParam, IPreloadService.c cVar) {
        a aVar = new a(downloadParam, cVar, new WeakReference(this));
        if (TextUtils.isEmpty(downloadParam.filePath)) {
            downloadParam.filePath = com.tencent.mobileqq.qwallet.preload.a.g(downloadParam.url, downloadParam.filePos);
        }
        if (downloadParam.isFlowControl) {
            addResToFlowControlCheck(new com.tencent.mobileqq.qwallet.preload.impl.a(downloadParam, aVar));
        } else {
            PreloadComDownloader.c().e(downloadParam, aVar, null);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public synchronized void replaceConfig(PreloadConfBean preloadConfBean) {
        JSONArray jSONArray = new JSONArray();
        for (JsonObject jsonObject : preloadConfBean.a()) {
            if (QLog.isColorLevel()) {
                QLog.d(IPreloadService.TAG, 2, "receiveAllConfigs|type: 68,content: " + jsonObject);
            }
            if (jsonObject != null) {
                try {
                    jSONArray.mo162put(new JSONObject(jsonObject.toString()));
                } catch (Throwable th5) {
                    QLog.e(IPreloadService.TAG, 1, "error msg in qqpay-impl module: ", th5);
                }
            }
        }
        saveConfigFromQQToSp(jSONArray.toString());
        this.mPreloadConfig.innerReplaceConfig(jSONArray, this, 0);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public synchronized void savePreloadConfig() {
        this.mPreloadConfig.savePreloadConfig();
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public void setPreloadHelpConfig(int i3, int i16) {
        if (i3 < 5) {
            this.mPreloadDelays = 5;
        } else if (i3 > 1800) {
            this.mPreloadDelays = 1800;
        } else {
            this.mPreloadDelays = i3;
        }
        if (i16 <= 0) {
            this.mNeedWaitSize = 1024;
        } else {
            this.mNeedWaitSize = i16;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public void startCheckConfig(final boolean z16) {
        if (this.mIsOnDestroy) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.4
            @Override // java.lang.Runnable
            public void run() {
                PreloadServiceImpl preloadServiceImpl;
                WeakReference weakReference2 = weakReference;
                if (weakReference2 != null && (preloadServiceImpl = (PreloadServiceImpl) weakReference2.get()) != null && !preloadServiceImpl.mIsOnDestroy) {
                    preloadServiceImpl.checkAndDownload(z16);
                }
            }
        }, 5, null, true);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public void getFilePath(String str, String str2, IPreloadService.c cVar) {
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.url = str;
        downloadParam.md5 = str2;
        downloadParam.isForceUnzip = false;
        downloadParam.useQWalletConfig = true;
        getResPath(downloadParam, cVar);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public synchronized PreloadModuleImpl getModuleByMID(String str) {
        return this.mPreloadConfig.getModuleByID(str);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public synchronized PreloadModuleImpl getModuleByName(String str) {
        return this.mPreloadConfig.getModuleByName(str);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public PreloadResourceImpl getResourceByResID(String str) {
        PreloadResourceImpl preloadResourceImpl = null;
        if (!TextUtils.isEmpty(str)) {
            Iterator<PreloadModuleImpl> it = this.mPreloadConfig.getModules().iterator();
            while (it.hasNext()) {
                for (PreloadResourceImpl preloadResourceImpl2 : it.next().getResList()) {
                    if (com.tencent.mobileqq.qwallet.impl.d.r(str, preloadResourceImpl2.mResId)) {
                        preloadResourceImpl = preloadResourceImpl2;
                    }
                }
            }
        }
        return preloadResourceImpl;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public void getUnzipFolderPath(String str, String str2, IPreloadService.c cVar) {
        DownloadParam downloadParam = new DownloadParam();
        downloadParam.url = str;
        downloadParam.md5 = str2;
        downloadParam.isForceUnzip = true;
        downloadParam.useQWalletConfig = true;
        getResPath(downloadParam, cVar);
    }

    private synchronized void checkAndDownload(f fVar, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "checkAndDownload|" + z16 + "|" + this.mPreloadConfig);
        }
        preCheck();
        if (this.mPreloadConfig.getModuleNum() > 0 && isDiskEnoughToDownload()) {
            this.mPreloadConfig.filterInvalidModules(this);
            List<PreloadModuleImpl> modules = this.mPreloadConfig.getModules();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            PreloadConfig.splitModulesByBackControl(modules, arrayList, arrayList2);
            if (arrayList2.size() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(IPreloadService.TAG, 2, "checkAndDownload|noBackControlMods" + arrayList2);
                }
                downloadModules(arrayList2, fVar, z16);
            }
            if (arrayList.size() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(IPreloadService.TAG, 2, "checkAndDownload|backControlMods" + arrayList);
                }
                downloadBackControlModules(arrayList, fVar, z16);
            }
            this.mPreloadConfig.savePreloadConfig();
        }
    }

    private void startCheckConfig() {
        startCheckConfig(false);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public synchronized void downloadModule(String str) {
        PreloadModuleImpl moduleByMID = getModuleByMID(str);
        if (moduleByMID != null) {
            moduleByMID.downloadModule(true, null, this, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadModules(List<PreloadModuleImpl> list, f fVar) {
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<PreloadModuleImpl> it = list.iterator();
        while (it.hasNext()) {
            it.next().downloadModule(false, fVar, this, true);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    public void getResPath(DownloadParam downloadParam, IPreloadService.c cVar) {
        if (downloadParam == null || TextUtils.isEmpty(downloadParam.url)) {
            if (cVar != null) {
                cVar.onResult(1, IPreloadService.PathResult.getFailRes(null));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "getResPath: param" + downloadParam);
        }
        downloadParam.standardlize();
        ResourceInfo j3 = com.tencent.mobileqq.qwallet.preload.a.j(downloadParam.url, downloadParam.isForceUnzip, downloadParam.filePos);
        boolean r16 = com.tencent.mobileqq.qwallet.preload.a.r(j3, downloadParam);
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "getResPath: isValidFileExist" + r16 + "|" + j3);
        }
        if (!r16) {
            if (j3 != null) {
                com.tencent.mobileqq.qwallet.preload.impl.c.k(downloadParam.url, downloadParam.filePos);
                com.tencent.mobileqq.qwallet.impl.d.d(j3.filePath);
                com.tencent.mobileqq.qwallet.impl.d.d(j3.folderPath);
            }
            realTimeDownload(downloadParam, cVar);
            return;
        }
        if (cVar != null) {
            IPreloadService.PathResult pathResult = new IPreloadService.PathResult();
            pathResult.url = downloadParam.url;
            pathResult.filePath = j3.filePath;
            pathResult.folderPath = j3.folderPath;
            pathResult.isAlreadyExist = true;
            cVar.onResult(0, pathResult);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    @Deprecated
    public synchronized void downloadModule(String str, String str2, IPreloadService.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(IPreloadService.TAG, 2, "downloadModule|" + str + APLogFileUtil.SEPARATOR_LOG + str2);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && aVar != null) {
            mergeConfig(str2);
            this.mPreloadConfig.savePreloadConfig();
            PreloadModuleImpl moduleByID = this.mPreloadConfig.getModuleByID(str);
            if (moduleByID != null && moduleByID.getResNum() != 0) {
                if (!isDiskEnoughToDownload()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(IPreloadService.TAG, 2, "downloadModule|disk space not enough");
                    }
                    aVar.onDownloadResFinished(str, -4, null, null);
                    return;
                }
                moduleByID.downloadModule(true, new c(str, aVar), this, false);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(IPreloadService.TAG, 2, "downloadModule|json wrong");
            }
            aVar.onDownloadResFinished(str, -7, null, null);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService
    public synchronized void replaceConfig(JSONArray jSONArray, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(IPreloadService.TAG, 2, "[replaceConfig] fromType=" + i3 + "configJa=" + jSONArray);
        }
        this.mPreloadConfig.innerReplaceConfig(jSONArray, this, i3);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
    }
}
