package com.tencent.qqmini.container.core;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.text.TextUtils;
import com.tencent.qqmini.container.core.aq;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ConfigProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private static aq f346056a;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z16, String str, MiniAppInfo miniAppInfo);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface b {
        void a(boolean z16, String str, ApkgInfo apkgInfo);
    }

    aq() {
    }

    public static synchronized aq e() {
        aq aqVar;
        synchronized (aq.class) {
            if (f346056a == null) {
                f346056a = new aq();
            }
            aqVar = f346056a;
        }
        return aqVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(boolean z16, a aVar, String str, String str2, String str3, boolean z17, JSONObject jSONObject) {
        if (z17 && jSONObject != null) {
            MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
            if (!z16 && aVar != null) {
                aVar.a(true, "", miniAppInfo);
            }
            m(jSONObject.optJSONObject(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_JSON), (byte[]) jSONObject.opt(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_PB), str, str2, str3);
            return;
        }
        if (!z16 && aVar != null) {
            aVar.a(false, "", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(b bVar, boolean z16, String str, MiniAppInfo miniAppInfo) {
        String miniAppInfo2;
        if (miniAppInfo == null) {
            miniAppInfo2 = "null";
        } else {
            miniAppInfo2 = miniAppInfo.toString();
        }
        QMLog.d("Mini-PackageLoader", "loadPackage success:" + z16 + ",appinfo:" + miniAppInfo2);
        if (z16 && miniAppInfo != null) {
            miniAppInfo.setIsLoadByContainer(((ConfigProxy) ProxyManager.get(ConfigProxy.class)).isloadByContainer());
            k(miniAppInfo, bVar);
        } else if (bVar != null) {
            bVar.a(false, str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(b bVar, int i3, ApkgInfo apkgInfo, String str) {
        String apkgBaseInfo;
        if (apkgInfo == null) {
            apkgBaseInfo = "null";
        } else {
            apkgBaseInfo = apkgInfo.toString();
        }
        QMLog.d("Mini-PackageLoader", "loadPackage resCode:" + i3 + ", pageInfo:" + apkgBaseInfo);
        if (i3 == 0 && apkgInfo != null) {
            if (bVar != null) {
                bVar.a(true, str, apkgInfo);
            }
        } else if (bVar != null) {
            bVar.a(false, str, null);
        }
    }

    private void m(JSONObject jSONObject, byte[] bArr, String str, String str2, String str3) {
        MiniAppCacheProxy miniAppCacheProxy = (MiniAppCacheProxy) ProxyManager.get(MiniAppCacheProxy.class);
        if (jSONObject != null) {
            INTERFACE$StApiAppInfo pbFromJSON = MiniAppInfo.pbFromJSON(jSONObject);
            if (pbFromJSON != null) {
                QMLog.d("Mini-PackageLoader", "saveIdInfo cache.");
                if (miniAppCacheProxy.saveIdInfo(str2, str3, pbFromJSON.get().toByteArray(), System.currentTimeMillis())) {
                    QMLog.d("Mini-PackageLoader", "saveIdInfo cache success.");
                    return;
                }
                return;
            }
            return;
        }
        if (bArr != null) {
            QMLog.d("Mini-PackageLoader", "saveIdInfo cache.");
            if (miniAppCacheProxy.saveIdInfo(str2, str3, bArr, System.currentTimeMillis())) {
                QMLog.d("Mini-PackageLoader", "saveIdInfo cache success.");
            }
        }
    }

    public MiniAppInfo d(String str, String str2) {
        byte[] idInfo;
        if (str2 == null) {
            str2 = "";
        }
        MiniAppCacheProxy miniAppCacheProxy = (MiniAppCacheProxy) ProxyManager.get(MiniAppCacheProxy.class);
        if (miniAppCacheProxy != null && (idInfo = miniAppCacheProxy.getIdInfo(str, str2)) != null) {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
            try {
                iNTERFACE$StApiAppInfo.mergeFrom(idInfo);
                return MiniAppInfo.from(iNTERFACE$StApiAppInfo);
            } catch (Throwable th5) {
                QMLog.e("Mini-PackageLoader", "getCacheAppInfo error,", th5);
                return null;
            }
        }
        return null;
    }

    public void i(final String str, final String str2, final String str3, final a aVar) {
        MiniAppInfo d16 = d(str, str2);
        boolean z16 = true;
        if (d16 != null && aVar != null) {
            aVar.a(true, "", d16);
        }
        if (d16 == null) {
            z16 = false;
        }
        final boolean z17 = z16;
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getContainerInfoById(str, str2, str3, new AsyncResult() { // from class: com.tencent.qqmini.container.core.ao
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public final void onReceiveResult(boolean z18, JSONObject jSONObject) {
                aq.this.f(z17, aVar, str3, str, str2, z18, jSONObject);
            }
        });
    }

    public void j(String str, String str2, final b bVar) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "release";
        }
        i(str, "", str2, new a() { // from class: com.tencent.qqmini.container.core.ap
            @Override // com.tencent.qqmini.container.core.aq.a
            public final void a(boolean z16, String str3, MiniAppInfo miniAppInfo) {
                aq.this.g(bVar, z16, str3, miniAppInfo);
            }
        });
    }

    public void k(MiniAppInfo miniAppInfo, final b bVar) {
        ApkgManager.getInstance().getApkgInfoByConfig(miniAppInfo, new ApkgManager.OnInitApkgListener() { // from class: com.tencent.qqmini.container.core.an
            @Override // com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener
            public final void onInitApkgInfo(int i3, ApkgInfo apkgInfo, String str) {
                aq.h(aq.b.this, i3, apkgInfo, str);
            }
        });
    }

    public void l(ApkgInfo apkgInfo, String str, ApkgManager.OnInitApkgListener onInitApkgListener) {
        ApkgManager.getInstance().downloadSubPack(apkgInfo, apkgInfo.mMiniAppInfo, str, onInitApkgListener);
    }
}
