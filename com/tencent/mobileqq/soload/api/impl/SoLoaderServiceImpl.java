package com.tencent.mobileqq.soload.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoLoaderServiceImpl implements ISoLoaderService {
    static IPatchRedirector $redirector_ = null;
    private static final Map<LoadParam, List<OnLoadListener>> LINSTER_IN_LOADING;
    public static final Map<LoadParam, f> LOADER_IN_LOADING;
    private static final String TAG = "SoLoadWidget.SoloadServiceImpl";
    private final Set<LoadParam> mCurDelayTokens;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements OnLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoadParam f288538a;

        a(LoadParam loadParam) {
            this.f288538a = loadParam;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoLoaderServiceImpl.this, (Object) loadParam);
            }
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            List<OnLoadListener> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                synchronized (SoLoaderServiceImpl.LINSTER_IN_LOADING) {
                    list = (List) SoLoaderServiceImpl.LINSTER_IN_LOADING.get(this.f288538a);
                    SoLoaderServiceImpl.LINSTER_IN_LOADING.remove(this.f288538a);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(SoLoaderServiceImpl.TAG, 2, "load resCode=" + i3 + ", loadExtResult=" + loadExtResult + ",loadParam=" + this.f288538a + ",ls=" + list);
                }
                if (list != null) {
                    for (OnLoadListener onLoadListener : list) {
                        if (onLoadListener != null) {
                            onLoadListener.onLoadResult(i3, loadExtResult);
                        }
                    }
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) loadExtResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b implements OnLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f288540a;

        /* renamed from: b, reason: collision with root package name */
        public OnLoadListener f288541b;

        /* renamed from: c, reason: collision with root package name */
        public LoadParam f288542c;

        b(OnLoadListener onLoadListener, long j3, LoadParam loadParam) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, onLoadListener, Long.valueOf(j3), loadParam);
                return;
            }
            this.f288540a = j3;
            this.f288541b = onLoadListener;
            this.f288542c = loadParam;
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SoLoaderServiceImpl.handleLoadResult(i3, loadExtResult, this.f288540a, this.f288541b, this.f288542c);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) loadExtResult);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21615);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            LOADER_IN_LOADING = new HashMap();
            LINSTER_IN_LOADING = new HashMap();
        }
    }

    public SoLoaderServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCurDelayTokens = new HashSet();
        }
    }

    private static void addLoadingLoader(LoadParam loadParam, f fVar) {
        if (loadParam != null && fVar != null) {
            Map<LoadParam, f> map = LOADER_IN_LOADING;
            synchronized (map) {
                map.put(loadParam, fVar);
            }
        }
    }

    private OnLoadListener constructInnerListener(LoadParam loadParam, long j3) {
        return new a(loadParam);
    }

    private LoadParam constructMultiLoadParam(String[] strArr, LoadOptions[] loadOptionsArr) {
        LoadOptions loadOptions;
        LoadParam loadParam = new LoadParam();
        if (strArr != null) {
            for (int i3 = 0; i3 < strArr.length; i3++) {
                String str = strArr[i3];
                if (!TextUtils.isEmpty(str)) {
                    if (loadOptionsArr != null && loadOptionsArr.length > i3) {
                        loadOptions = loadOptionsArr[i3];
                    } else {
                        loadOptions = null;
                    }
                    loadParam.addItem(str, loadOptions);
                }
            }
        }
        return loadParam;
    }

    private LoadParam constructSingleLoadParam(String str, LoadOptions loadOptions) {
        LoadParam loadParam = new LoadParam();
        loadParam.addItem(str, loadOptions);
        return loadParam;
    }

    private LoadOptions[] getDownloadLoadOptions(String[] strArr) {
        int length;
        if (strArr == null) {
            length = 0;
        } else {
            length = strArr.length;
        }
        if (length > 0) {
            LoadOptions[] loadOptionsArr = new LoadOptions[length];
            for (int i3 = 0; i3 < length; i3++) {
                loadOptionsArr[i3] = new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).build();
            }
            return loadOptionsArr;
        }
        return null;
    }

    private LoadOptions getNoNeedLoadOptions() {
        return new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).setIsNoNeedCRC(true).setCloseRetry(true).setCloseReport(true).build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        r1 = new java.util.LinkedList();
        r1.add(r8);
        r7.mLoadTime = com.tencent.mobileqq.msf.core.NetConnInfoCenter.getServerTimeMillis();
        com.tencent.mobileqq.soload.api.impl.SoLoaderServiceImpl.LINSTER_IN_LOADING.put(r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
    
        if (r2 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        r8 = r2.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
    
        if (r8.hasNext() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0081, code lost:
    
        r0 = r8.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0087, code lost:
    
        if (r0 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0089, code lost:
    
        r0.onLoadResult(7, com.tencent.mobileqq.soload.biz.entity.LoadExtResult.create(7, com.tencent.mobileqq.soload.biz.entity.LoadParam.getItemSize(r7)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private LoadParam getSameParamInLoad(LoadParam loadParam, OnLoadListener onLoadListener) {
        List<OnLoadListener> list;
        Map<LoadParam, List<OnLoadListener>> map = LINSTER_IN_LOADING;
        synchronized (map) {
            Iterator<Map.Entry<LoadParam, List<OnLoadListener>>> it = map.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<LoadParam, List<OnLoadListener>> next = it.next();
                    LoadParam key = next.getKey();
                    if (key != null && key.isSame(loadParam)) {
                        if (key.isOverTime()) {
                            list = next.getValue();
                            it.remove();
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, "[getSameParamInLoad] isOverTime:" + list);
                            }
                        } else {
                            next.getValue().add(onLoadListener);
                            return key;
                        }
                    }
                } else {
                    list = null;
                    break;
                }
            }
        }
    }

    private f getSoLoader(LoadParam loadParam) {
        if (loadParam != null) {
            if (loadParam.mClassLoader instanceof DexClassLoader) {
                return new h();
            }
            if (loadParam.mLoadItems.size() > 1) {
                return new g();
            }
            return new n();
        }
        return new n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleLoadResult(int i3, LoadExtResult loadExtResult, long j3, OnLoadListener onLoadListener, LoadParam loadParam) {
        LoadExtResult loadExtResult2;
        List<LoadParam.LoadItem> list;
        if (QLog.isColorLevel()) {
            if (loadParam != null && (list = loadParam.mLoadItems) != null && !list.isEmpty()) {
                Iterator<LoadParam.LoadItem> it = loadParam.mLoadItems.iterator();
                while (it.hasNext()) {
                    QLog.i(TAG, 2, "[LoadResult] soName: " + it.next().soFileName + " resCode\uff1a" + i3 + ",soVer: " + loadExtResult.getVer());
                }
            } else {
                QLog.i(TAG, 2, "[LoadResult] resCode\uff1a" + i3);
            }
        }
        if (loadExtResult == null) {
            loadExtResult2 = new LoadExtResult();
        } else {
            loadExtResult2 = loadExtResult;
        }
        int reportCode = loadExtResult2.getReportCode();
        String reportStr = loadExtResult2.getReportStr();
        if (i3 != 0) {
            com.tencent.mobileqq.soload.util.h.c(loadParam, j3, "load.end", reportStr, reportCode, null);
        }
        if (onLoadListener != null) {
            onLoadListener.onLoadResult(i3, loadExtResult2);
        }
        removeLoadingLoader(loadParam);
        if (!LoadParam.isCloseReport(loadParam)) {
            com.tencent.mobileqq.soload.util.h.e(null, "dc00899", "SoLoad", "", "resStat", "resReport", 0, reportCode, reportStr, "", "", "", loadExtResult2.getResultCode());
        }
    }

    private void handleLoadSyncFail(LoadExtResult loadExtResult, LoadParam loadParam) {
        loadParam.mCallType = LoadParam.CALL_TYPE_ASYNC_BY_SYNC;
        long delayAyncTime = loadExtResult.getDelayAyncTime();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[handleLoadSyncFail]delayTime:" + delayAyncTime);
        }
        if (delayAyncTime <= 0) {
            loadAsync(loadParam, null);
            return;
        }
        synchronized (this.mCurDelayTokens) {
            Iterator<LoadParam> it = this.mCurDelayTokens.iterator();
            while (it.hasNext()) {
                LoadParam next = it.next();
                if (next.isSame(loadParam)) {
                    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(next);
                    it.remove();
                }
            }
            ThreadManager.getSubThreadHandler().postAtTime(new Runnable(loadParam) { // from class: com.tencent.mobileqq.soload.api.impl.SoLoaderServiceImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ LoadParam f288534d;

                {
                    this.f288534d = loadParam;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoLoaderServiceImpl.this, (Object) loadParam);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        SoLoaderServiceImpl.this.loadAsync(this.f288534d, null);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, loadParam, NetConnInfoCenter.getServerTimeMillis() + delayAyncTime);
            this.mCurDelayTokens.add(loadParam);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAsync(LoadParam loadParam, OnLoadListener onLoadListener) {
        ThreadManagerV2.excute(new Runnable(loadParam, onLoadListener) { // from class: com.tencent.mobileqq.soload.api.impl.SoLoaderServiceImpl.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ LoadParam f288535d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ OnLoadListener f288536e;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.soload.api.impl.SoLoaderServiceImpl$2$a */
            /* loaded from: classes18.dex */
            class a implements OnLoadListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                    }
                }

                @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                public void onLoadResult(int i3, LoadExtResult loadExtResult) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) loadExtResult);
                    } else if (AnonymousClass2.this.f288536e != null) {
                        if (loadExtResult == null) {
                            loadExtResult = new LoadExtResult();
                        }
                        AnonymousClass2.this.f288536e.onLoadResult(i3, loadExtResult);
                    }
                }
            }

            {
                this.f288535d = loadParam;
                this.f288536e = onLoadListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SoLoaderServiceImpl.this, loadParam, onLoadListener);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    SoLoaderServiceImpl.this.load(this.f288535d, new a());
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 16, null, false);
    }

    private static void removeLoadingLoader(LoadParam loadParam) {
        Map<LoadParam, f> map = LOADER_IN_LOADING;
        synchronized (map) {
            map.remove(loadParam);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderService
    public void download(String str, OnLoadListener onLoadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            load(str, onLoadListener, new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).build());
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) onLoadListener);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderService
    public List<String> getCurInitSoList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return r.d();
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderService
    public String getInitVer(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return r.e(str);
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderService
    public String getSoVer(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        String ver = loadSync(str, getNoNeedLoadOptions()).getVer();
        if (TextUtils.isEmpty(ver)) {
            return "";
        }
        return ver;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderService
    public void load(String str, OnLoadListener onLoadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            load(str, onLoadListener, null);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) onLoadListener);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderService
    public void loadSequentially(String[] strArr, OnLoadListener onLoadListener, LoadOptions[] loadOptionsArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, strArr, onLoadListener, loadOptionsArr);
        } else {
            loadAsync(constructMultiLoadParam(strArr, loadOptionsArr), onLoadListener);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderService
    public LoadExtResult loadSequentiallySync(String[] strArr, LoadOptions[] loadOptionsArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (LoadExtResult) iPatchRedirector.redirect((short) 12, (Object) this, (Object) strArr, (Object) loadOptionsArr);
        }
        return loadSync(constructMultiLoadParam(strArr, loadOptionsArr));
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderService
    public LoadExtResult loadSync(String str, LoadOptions loadOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? loadSync(constructSingleLoadParam(str, loadOptions)) : (LoadExtResult) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) loadOptions);
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderService
    public void reportRlFolderNotExists(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, Integer.valueOf(i3));
        } else {
            com.tencent.mobileqq.soload.util.h.l(str, str2, i3);
        }
    }

    public void load(String str, OnLoadListener onLoadListener, LoadOptions loadOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            loadAsync(constructSingleLoadParam(str, loadOptions), onLoadListener);
        } else {
            iPatchRedirector.redirect((short) 10, this, str, onLoadListener, loadOptions);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load(LoadParam loadParam, OnLoadListener onLoadListener) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "load loadParam=" + loadParam);
        }
        long n3 = com.tencent.mobileqq.soload.util.h.n(loadParam);
        b bVar = new b(onLoadListener, n3, loadParam);
        if (!LoadParam.isValid(loadParam)) {
            bVar.onLoadResult(1, LoadExtResult.create(1, LoadParam.getItemSize(loadParam)));
            return;
        }
        int i3 = loadParam.mCallType;
        if (i3 != LoadParam.CALL_TYPE_ASYNC && i3 != LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
            loadParam.mCallType = LoadParam.CALL_TYPE_ASYNC;
        }
        LoadParam sameParamInLoad = getSameParamInLoad(loadParam, bVar);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("load isSameParamInLoad=");
            sb5.append(sameParamInLoad != null);
            QLog.i(TAG, 2, sb5.toString());
        }
        if (sameParamInLoad != null) {
            com.tencent.mobileqq.soload.util.h.a(loadParam, n3, null, "load.join.same.queue", "first=" + sameParamInLoad.mReportSeq, 0, null);
            return;
        }
        OnLoadListener constructInnerListener = constructInnerListener(loadParam, n3);
        f soLoader = getSoLoader(loadParam);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "load getSoLoader=" + soLoader);
        }
        addLoadingLoader(loadParam, soLoader);
        soLoader.a(loadParam, constructInnerListener);
    }

    private LoadExtResult loadSync(LoadParam loadParam) {
        LoadExtResult c16;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "loadSync loadParam=" + loadParam);
        }
        long n3 = com.tencent.mobileqq.soload.util.h.n(loadParam);
        if (!LoadParam.isValid(loadParam)) {
            c16 = LoadExtResult.create(1, LoadParam.getItemSize(loadParam));
        } else {
            f soLoader = getSoLoader(loadParam);
            loadParam.mCallType = LoadParam.CALL_TYPE_SYNC;
            addLoadingLoader(loadParam, soLoader);
            c16 = soLoader.c(loadParam);
        }
        if (c16 == null) {
            c16 = new LoadExtResult();
        }
        handleLoadResult(c16.getResultCode(), c16, n3, null, loadParam);
        if (c16.isNeedRetry(loadParam)) {
            handleLoadSyncFail(c16, loadParam);
        }
        return c16;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoaderService
    public void download(String[] strArr, OnLoadListener onLoadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            loadSequentially(strArr, onLoadListener, getDownloadLoadOptions(strArr));
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) strArr, (Object) onLoadListener);
        }
    }
}
