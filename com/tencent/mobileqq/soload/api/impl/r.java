package com.tencent.mobileqq.soload.api.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.AsyncFailInfo;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class r {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static final ConcurrentHashMap<String, SoLoadInfo> f288627h;

    /* renamed from: i, reason: collision with root package name */
    private static Map<String, AsyncFailInfo> f288628i;

    /* renamed from: a, reason: collision with root package name */
    private LoadParam f288629a;

    /* renamed from: b, reason: collision with root package name */
    private LoadParam.LoadItem f288630b;

    /* renamed from: c, reason: collision with root package name */
    private OnLoadListener f288631c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f288632d;

    /* renamed from: e, reason: collision with root package name */
    private String f288633e;

    /* renamed from: f, reason: collision with root package name */
    private long f288634f;

    /* renamed from: g, reason: collision with root package name */
    private SoLoadInfo f288635g;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements OnGetSoLoadInfoListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
            }
        }

        @Override // com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener
        public void onGetLoadInfo(@NonNull SoLoadInfo soLoadInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                r.this.s(r.this.c(soLoadInfo));
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) soLoadInfo);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21586);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f288627h = new ConcurrentHashMap<>();
            f288628i = new HashMap();
        }
    }

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f288632d = false;
            this.f288635g = SoLoadInfo.sDefault;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(@NonNull SoLoadInfo soLoadInfo) {
        v(soLoadInfo);
        SoLoadInfo soLoadInfo2 = this.f288635g;
        int i3 = soLoadInfo2.curCode;
        if (i3 == 0) {
            return n(this.f288630b, soLoadInfo2);
        }
        if (i3 == 2 && p(this.f288630b)) {
            return 0;
        }
        return i3;
    }

    @Deprecated
    public static List<String> d() {
        return new LinkedList(f288627h.keySet());
    }

    public static String e(String str) {
        SoLoadInfo soLoadInfo = f288627h.get(str);
        if (soLoadInfo == null) {
            return "";
        }
        return soLoadInfo.getVer();
    }

    private LoadExtResult f(int i3) {
        LoadParam.LoadItem loadItem = this.f288630b;
        LoadExtResult create = LoadExtResult.create(i3, 1, loadItem.name, this.f288635g, loadItem.lops);
        if (this.f288629a.mCallType == LoadParam.CALL_TYPE_SYNC) {
            create.failInfo = f288628i.get(this.f288630b.name);
        }
        return create;
    }

    private int g() {
        SoLoadInfo soLoadInfo = this.f288635g;
        if (!soLoadInfo.isFirstlyLoad) {
            return 3;
        }
        if (soLoadInfo.isNeedDownload) {
            return 1;
        }
        return 2;
    }

    private void h(LoadParam loadParam, OnLoadListener onLoadListener) {
        this.f288629a = loadParam;
        this.f288631c = onLoadListener;
        this.f288634f = NetConnInfoCenter.getServerTimeMillis();
        LoadParam.LoadItem loadItem = loadParam.mLoadItems.get(0);
        this.f288630b = loadItem;
        LoadParam loadParam2 = this.f288629a;
        com.tencent.mobileqq.soload.util.h.a(loadParam2, loadParam2.mReportSeq, null, "load.item.start", loadItem.name, 0, null);
    }

    private boolean i() {
        ConcurrentHashMap<String, SoLoadInfo> concurrentHashMap = f288627h;
        if (!concurrentHashMap.containsKey(this.f288630b.name)) {
            return false;
        }
        SoLoadInfo v3 = v(concurrentHashMap.get(this.f288630b.name));
        this.f288635g = v3;
        if (v3 != null) {
            v3.isFirstlyLoad = false;
        }
        this.f288630b.lops.flag |= 2;
        return true;
    }

    private boolean k() {
        SoLoadInfo soLoadInfo = this.f288635g;
        if (soLoadInfo.soDetailInfo.relatedFileInfo == null || !TextUtils.isEmpty(soLoadInfo.rFileFolder)) {
            return true;
        }
        return false;
    }

    private int l(String str, LoadParam.LoadItem loadItem) {
        boolean exists = new File(str).exists();
        if (!exists) {
            return 5;
        }
        LoadOptions loadOptions = loadItem.lops;
        int i3 = loadOptions.flag;
        if ((i3 & 1) != 0) {
            loadOptions.flag = i3 | 2;
            return 0;
        }
        try {
            QLog.i("SoLoadWidget.SoLoaderLogic", 1, "[System.load] loadItem:" + loadItem + ",exists:" + exists + ", soFilePath = " + str);
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
                QLog.i("SoLoadWidget.SoLoaderLogic", 1, "[System.load] loadItem:" + loadItem + ",exists:" + exists + ",real soFilePath = " + str);
            }
            com.tencent.mobileqq.soload.traces.base.a a16 = com.tencent.mobileqq.soload.traces.base.b.INSTANCE.a(loadItem.name);
            if (a16 != null) {
                a16.load(str);
            } else {
                System.load(str);
            }
            loadItem.lops.flag |= 2;
            if (k()) {
                f288627h.put(loadItem.name, this.f288635g);
                if (QLog.isColorLevel()) {
                    QLog.d("SoLoadWidget.SoLoaderLogic", 2, "mark isAlReadyLoad, loadItem.name:" + loadItem.name + ", soFilePath = " + str);
                }
            }
            return 0;
        } catch (Throwable th5) {
            String c16 = com.tencent.mobileqq.soload.util.e.c(th5);
            this.f288633e = c16;
            QLog.e("SoLoadWidget.SoLoaderLogic", 1, c16);
            return 6;
        }
    }

    private int n(LoadParam.LoadItem loadItem, @NonNull SoLoadInfo soLoadInfo) {
        if (loadItem != null) {
            QLog.i("SoLoadWidget.SoLoaderLogic", 1, "[loadConfigSo] appid: " + AppSetting.f() + ",soversion: " + soLoadInfo.getVer() + ",soname: " + loadItem.name);
        }
        if (loadItem == null) {
            QLog.i("SoLoadWidget.SoLoaderLogic", 2, "[loadConfigSo] so load param invalid!!!");
            return 1;
        }
        int l3 = l(soLoadInfo.soPathToLoad, loadItem);
        if (QLog.isColorLevel()) {
            QLog.d("SoLoadWidget.SoLoaderLogic", 2, "[loadConfigSo] res=" + l3 + ",filePath=" + soLoadInfo.soPathToLoad);
        }
        if (l3 == 0) {
            com.tencent.mobileqq.soload.util.f.N(loadItem, soLoadInfo.soPathToLoad);
            com.tencent.mobileqq.soload.util.f.O(loadItem, soLoadInfo);
            com.tencent.mobileqq.soload.util.f.c(loadItem.name);
            if (!m.f288614a.d(loadItem.name)) {
                com.tencent.mobileqq.soload.util.f.a(loadItem.soFileName, soLoadInfo.soPathToLoad);
            }
            return l3;
        }
        if (o(loadItem)) {
            return 0;
        }
        return l3;
    }

    private boolean o(LoadParam.LoadItem loadItem) {
        if (!loadItem.lops.isLoadLastSuccWhenFail) {
            return false;
        }
        String k3 = com.tencent.mobileqq.soload.util.f.k(loadItem);
        if (TextUtils.isEmpty(k3)) {
            return false;
        }
        int l3 = l(k3, loadItem);
        LoadParam loadParam = this.f288629a;
        com.tencent.mobileqq.soload.util.h.a(loadParam, loadParam.mReportSeq, null, "load.item.load.last", null, l3, null);
        if (l3 != 0) {
            return false;
        }
        return true;
    }

    private boolean p(LoadParam.LoadItem loadItem) {
        String oldSoPath = loadItem.lops.getOldSoPath();
        if (TextUtils.isEmpty(oldSoPath) || !new File(oldSoPath).exists()) {
            return false;
        }
        int l3 = l(oldSoPath, loadItem);
        LoadParam loadParam = this.f288629a;
        com.tencent.mobileqq.soload.util.h.a(loadParam, loadParam.mReportSeq, null, "load.item.load.oldpath", null, l3, null);
        if (l3 != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LoadExtResult s(int i3) {
        String str;
        if (i3 == 6) {
            str = this.f288633e;
        } else if (!TextUtils.isEmpty(this.f288635g.failDetail)) {
            str = this.f288635g.failDetail;
        } else {
            str = null;
        }
        return t(i3, str);
    }

    private LoadExtResult t(int i3, String str) {
        this.f288632d = true;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - this.f288634f;
        LoadParam loadParam = this.f288629a;
        com.tencent.mobileqq.soload.util.h.a(loadParam, loadParam.mReportSeq, "ver=" + this.f288635g.getVer(), "load.item.load", this.f288630b.name, i3, str);
        if (i3 != 0) {
            u(i3);
        }
        LoadExtResult f16 = f(i3);
        OnLoadListener onLoadListener = this.f288631c;
        if (onLoadListener != null) {
            onLoadListener.onLoadResult(i3, f16);
        }
        if (!LoadParam.isCloseReport(this.f288629a)) {
            String str2 = this.f288630b.name;
            if (m.f288614a.d(str2)) {
                str2 = this.f288630b.name + "_shiply";
            }
            ReportController.o(null, "dc00899", "SoLoad", "", "resSingle", str2, this.f288629a.mCallType, i3, this.f288635g.getVer(), g() + "", serverTimeMillis + "", this.f288635g.subErrCode + "");
        }
        return f16;
    }

    private void u(int i3) {
        if (this.f288629a.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
            AsyncFailInfo asyncFailInfo = f288628i.get(this.f288630b.name);
            if (asyncFailInfo == null) {
                asyncFailInfo = new AsyncFailInfo();
            }
            boolean isNetSupport = NetworkUtil.isNetSupport(MobileQQ.sMobileQQ);
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            int systemNetwork = NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ);
            if (QLog.isColorLevel()) {
                QLog.i("SoLoadWidget.SoLoaderLogic", 2, "[onLoadResult]AsyncFailInfo:" + asyncFailInfo + ",name:" + this.f288630b.name + ",isNetSupport:" + isNetSupport + ",curTime=" + serverTimeMillis + ",netType=" + systemNetwork);
            }
            if (isNetSupport) {
                asyncFailInfo.lastFailCode = i3;
                asyncFailInfo.netType = systemNetwork;
                asyncFailInfo.lastFailTime = serverTimeMillis;
                asyncFailInfo.lastSubFailCode = this.f288635g.subErrCode;
                f288628i.put(this.f288630b.name, asyncFailInfo);
            }
        }
    }

    private SoLoadInfo v(SoLoadInfo soLoadInfo) {
        if (soLoadInfo == null) {
            soLoadInfo = SoLoadInfo.sDefault;
            if (QLog.isColorLevel()) {
                QLog.e("SoLoadWidget.SoLoaderLogic", 2, "setSoLoadInfo is null" + new Exception());
            }
        }
        this.f288635g = soLoadInfo;
        return soLoadInfo;
    }

    public boolean j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        LoadParam.LoadItem loadItem = this.f288630b;
        String str2 = loadItem.name;
        String str3 = loadItem.soFileName;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !str.contains(str3)) {
            return false;
        }
        return true;
    }

    public void m(LoadParam loadParam, OnLoadListener onLoadListener) {
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) loadParam, (Object) onLoadListener);
            return;
        }
        h(loadParam, onLoadListener);
        boolean d16 = m.f288614a.d(this.f288630b.name);
        if (d16 && QLog.isColorLevel()) {
            QLog.d("SoLoadWidget.SoLoaderLogic", 2, "load useShiplyChannel,so name = " + this.f288630b.name);
        }
        if (i()) {
            if (QLog.isColorLevel()) {
                QLog.d("SoLoadWidget.SoLoaderLogic", 2, "load isAlreadyLoad,so name = " + this.f288630b.name);
            }
            s(0);
            return;
        }
        if (d16) {
            dVar = new j(this.f288629a, this.f288630b);
        } else {
            dVar = new d(this.f288629a, this.f288630b);
        }
        dVar.u(new a());
    }

    public LoadExtResult q(LoadParam loadParam) {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LoadExtResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) loadParam);
        }
        h(loadParam, null);
        boolean d16 = m.f288614a.d(this.f288630b.name);
        if (d16 && QLog.isColorLevel()) {
            QLog.d("SoLoadWidget.SoLoaderLogic", 2, "loadSync useShiplyChannel,so name = " + this.f288630b.name);
        }
        if (i()) {
            if (QLog.isColorLevel()) {
                QLog.d("SoLoadWidget.SoLoaderLogic", 2, "loadSync isAlreadyLoad,so name = " + this.f288630b.name);
            }
            return s(0);
        }
        if (d16) {
            eVar = new l(this.f288629a, this.f288630b);
        } else {
            eVar = new e(this.f288629a, this.f288630b);
        }
        return s(c(eVar.i()));
    }

    public void r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (!this.f288632d && this.f288629a.mCallType != LoadParam.CALL_TYPE_SYNC) {
            t(8, str);
        } else {
            com.tencent.mobileqq.soload.util.h.o(null, "ver=" + this.f288635g.getVer(), "SoLoadModule", "SoLoadSingle", "Exception", this.f288630b.name, 2, str);
        }
        com.tencent.mobileqq.soload.entity.a.c(this.f288630b.name, this.f288635g.getVer(), 0);
    }
}
