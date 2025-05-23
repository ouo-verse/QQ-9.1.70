package com.tencent.qqmini.container.core;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class bh {

    /* renamed from: a, reason: collision with root package name */
    private ax f346094a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f346095b = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements ApkgManager.OnInitApkgListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f346096a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MiniAppInfo f346097b;

        a(c cVar, MiniAppInfo miniAppInfo) {
            this.f346096a = cVar;
            this.f346097b = miniAppInfo;
        }

        @Override // com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener
        public void onInitApkgInfo(int i3, ApkgInfo apkgInfo, String str) {
            QMLog.i("VersionUpdater", "getApkgInfoByConfig end. result=" + i3 + "; msg : " + str);
            if (i3 != 0 || apkgInfo == null) {
                bh.this.r("updatefailed");
                return;
            }
            int i16 = this.f346096a.f346101a;
            if (i16 == 1) {
                bh.this.r("updateready");
            } else if (i16 == 2 && this.f346097b.isContainerLoad()) {
                bh.this.t(this.f346096a, apkgInfo, this.f346097b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public int f346101a = 0;

        /* renamed from: b, reason: collision with root package name */
        public List<SubPkgInfo> f346102b = new ArrayList();

        public c() {
        }

        public boolean a() {
            if (this.f346101a != 0) {
                return true;
            }
            return false;
        }
    }

    public bh(ax axVar) {
        this.f346094a = axVar;
    }

    private void j(MiniAppInfo miniAppInfo, c cVar) {
        ApkgManager.getInstance().getApkgInfoByConfig(miniAppInfo, false, (ApkgManager.OnInitApkgListener) new a(cVar, miniAppInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void m(final MiniAppInfo miniAppInfo) {
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getContainerInfoById(miniAppInfo.appId, "", "", new AsyncResult() { // from class: com.tencent.qqmini.container.core.bf
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public final void onReceiveResult(boolean z16, JSONObject jSONObject) {
                bh.this.n(miniAppInfo, z16, jSONObject);
            }
        });
    }

    private boolean l(ApkgInfo apkgInfo, SubPkgInfo subPkgInfo) {
        File file = new File(apkgInfo.getApkgFolderPath());
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!TextUtils.isEmpty(str) && str.startsWith(subPkgInfo.getPureSubPkgName()) && !str.contains(subPkgInfo.versionId)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(MiniAppInfo miniAppInfo, boolean z16, JSONObject jSONObject) {
        MiniAppInfo miniAppInfo2;
        QMLog.d("VersionUpdater", "getAppInfoById onCmdListener() called with: isSuc = [" + z16 + "], ret = [" + jSONObject + "]");
        c cVar = new c();
        if (jSONObject != null && z16) {
            miniAppInfo2 = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
        } else {
            miniAppInfo2 = null;
        }
        if (miniAppInfo2 != null) {
            cVar = i(miniAppInfo, miniAppInfo2);
            if (!cVar.a()) {
                r("noUpdate");
            } else {
                int i3 = cVar.f346101a;
                if (i3 == 1) {
                    r(IXWebBroadcastListener.STAGE_PROGRESSED);
                } else if (i3 == 2) {
                    for (int i16 = 0; i16 < cVar.f346102b.size(); i16++) {
                        SubPkgInfo subPkgInfo = cVar.f346102b.get(i16);
                        s(IXWebBroadcastListener.STAGE_PROGRESSED, subPkgInfo.subPkgName, subPkgInfo.version);
                    }
                }
            }
        } else {
            QMLog.e("VersionUpdater", "onCmdListener newMiniAppInfo = null");
        }
        QMLog.e("VersionUpdater", "doUpdateMiniAppInfo needUpdate = " + cVar.a());
        if (cVar.a()) {
            p(jSONObject, miniAppInfo2.appId, miniAppInfo2.firstPath);
            j(miniAppInfo2, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(Set set) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(set);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((MiniView) it.next()).w();
        }
    }

    private void p(JSONObject jSONObject, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        JSONObject optJSONObject = jSONObject.optJSONObject(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_JSON);
        byte[] bArr = (byte[]) jSONObject.opt(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_PB);
        MiniAppCacheProxy miniAppCacheProxy = (MiniAppCacheProxy) ProxyManager.get(MiniAppCacheProxy.class);
        if (optJSONObject != null) {
            INTERFACE$StApiAppInfo pbFromJSON = MiniAppInfo.pbFromJSON(optJSONObject);
            if (pbFromJSON != null) {
                QMLog.d("VersionUpdater", "saveIdInfo cache.");
                if (miniAppCacheProxy.saveIdInfo(str, str3, pbFromJSON.get().toByteArray(), System.currentTimeMillis())) {
                    QMLog.d("VersionUpdater", "saveIdInfo cache success.");
                    return;
                }
                return;
            }
            return;
        }
        if (bArr != null) {
            QMLog.d("VersionUpdater", "saveIdInfo cache.");
            if (miniAppCacheProxy.saveIdInfo(str, str3, bArr, System.currentTimeMillis())) {
                QMLog.d("VersionUpdater", "saveIdInfo cache success.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(SubPkgInfo subPkgInfo) {
        final Set<MiniView> t16 = this.f346094a.t(subPkgInfo.subPkgName);
        if (t16 != null && t16.size() != 0) {
            Iterator<MiniView> it = t16.iterator();
            boolean z16 = true;
            while (it.hasNext()) {
                if (it.next().o()) {
                    z16 = false;
                }
            }
            if (z16) {
                this.f346094a.R(subPkgInfo.subPkgName);
                this.f346095b.post(new Runnable() { // from class: com.tencent.qqmini.container.core.bg
                    @Override // java.lang.Runnable
                    public final void run() {
                        bh.o(t16);
                    }
                });
                return;
            } else {
                s("updateready", subPkgInfo.subPkgName, subPkgInfo.version);
                return;
            }
        }
        this.f346094a.R(subPkgInfo.subPkgName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        s(str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2, String str3) {
        ax axVar = this.f346094a;
        if (axVar == null) {
            QMLog.i("VersionUpdater", "sendUpdateStateToJs failed, mRuntime is null ");
            return;
        }
        j jsService = axVar.getJsService();
        if (jsService == null) {
            QMLog.i("VersionUpdater", "sendUpdateStateToJs failed, jsService is null ");
            return;
        }
        try {
            QMLog.i("VersionUpdater", "sendUpdateStateToJs:" + str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", str);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                jSONObject.put("updateSubPkg", str2);
                jSONObject.put("updateSubPkgVersion", str3);
            }
            jsService.evaluateSubscribeJS(EventListener.ON_UPDATE_STATUS_CHANGE, jSONObject.toString(), 0);
        } catch (Exception e16) {
            QMLog.e("VersionUpdater", "updateJSONObject error." + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar, ApkgInfo apkgInfo, MiniAppInfo miniAppInfo) {
        if (cVar.f346101a == 2 && cVar.f346102b.size() > 0) {
            for (SubPkgInfo subPkgInfo : cVar.f346102b) {
                if (l(apkgInfo, subPkgInfo)) {
                    ApkgManager.getInstance().containerDownloadSubPkg(apkgInfo, miniAppInfo, subPkgInfo, new b(subPkgInfo));
                } else {
                    this.f346094a.R(subPkgInfo.subPkgName);
                }
            }
        }
    }

    public void h() {
        if (this.f346094a == null) {
            QMLog.e("VersionUpdater", "checkUpdateBackgroundIfNecessary but runtime is null");
            return;
        }
        QMLog.i("VersionUpdater", "checkUpdateBackgroundIfNecessary");
        final MiniAppInfo miniAppInfo = this.f346094a.getMiniAppInfo();
        if (miniAppInfo == null) {
            QMLog.e("VersionUpdater", "checkUpdateBackgroundIfNecessary but miniAppInfo is null");
        } else {
            eu3.f.g(new Runnable() { // from class: com.tencent.qqmini.container.core.be
                @Override // java.lang.Runnable
                public final void run() {
                    bh.this.m(miniAppInfo);
                }
            });
        }
    }

    public c i(MiniAppInfo miniAppInfo, MiniAppInfo miniAppInfo2) {
        c cVar = new c();
        if (AppBrandUtil.needUpdate(miniAppInfo, miniAppInfo2)) {
            cVar.f346101a = 1;
        } else if (miniAppInfo != null && miniAppInfo2 != null && miniAppInfo.isContainerLoad() && miniAppInfo2.isContainerLoad()) {
            HashMap hashMap = new HashMap();
            for (SubPkgInfo subPkgInfo : miniAppInfo.subpkgs) {
                hashMap.put(subPkgInfo.subPkgName, subPkgInfo);
            }
            for (SubPkgInfo subPkgInfo2 : miniAppInfo2.subpkgs) {
                if (!hashMap.containsKey(subPkgInfo2.subPkgName) || !((SubPkgInfo) hashMap.get(subPkgInfo2.subPkgName)).versionId.equals(subPkgInfo2.versionId) || !((SubPkgInfo) hashMap.get(subPkgInfo2.subPkgName)).subVersionType.equals(subPkgInfo2.subVersionType)) {
                    cVar.f346101a = 2;
                    cVar.f346102b.add(subPkgInfo2);
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements DownloaderProxy.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SubPkgInfo f346099a;

        b(SubPkgInfo subPkgInfo) {
            this.f346099a = subPkgInfo;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadFailed(int i3, String str) {
            QMLog.i("VersionUpdater", "subpkg downloadFailed:" + i3 + ",errorMsg:" + str + ",subpkg:" + this.f346099a.toString());
            bh bhVar = bh.this;
            SubPkgInfo subPkgInfo = this.f346099a;
            bhVar.s("updatefailed", subPkgInfo.subPkgName, subPkgInfo.version);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadSucceed(int i3, String str, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
            QMLog.i("VersionUpdater", "subpkg onDownloadSucceed:" + i3 + ",errorMsg:" + this.f346099a.subPkgName);
            bh.this.q(this.f346099a);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadProgress(float f16, long j3, long j16) {
        }
    }
}
