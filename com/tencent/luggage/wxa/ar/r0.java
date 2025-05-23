package com.tencent.luggage.wxa.ar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.a0;
import com.tencent.luggage.wxa.qq.l;
import com.tencent.mobileqq.mini.push.MiniAppPushControl;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.WebStorage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebChildProcessMonitor;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import com.tencent.xweb.xwalk.plugin.XWalkPluginUpdater;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class r0 {

    /* renamed from: a, reason: collision with root package name */
    public static HashSet f121769a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            boolean z16;
            String queryParameter = uri.getQueryParameter("check_plugin_update");
            if (bVar != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!com.tencent.luggage.wxa.qq.m.a(context, queryParameter, "1", z16)) {
                return com.tencent.luggage.wxa.qq.a.a();
            }
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            try {
                com.tencent.luggage.wxa.ar.k a16 = com.tencent.luggage.wxa.ar.r.a(com.tencent.luggage.wxa.ar.u0.f());
                if (a16 == null) {
                    com.tencent.luggage.wxa.ar.x0.d("XWebCommandHandler", "recheck cmds ConfigParser failed");
                    return com.tencent.luggage.wxa.qq.a.a();
                }
                CommandCfg.getInstance().applyCommand(a16.f121703e, a16.f121701c, true);
                com.tencent.luggage.wxa.ar.n0.a(68L, 1);
                return com.tencent.luggage.wxa.qq.a.b();
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.ar.x0.d("XWebCommandHandler", "recheck cmds failed, error:" + th5);
                return com.tencent.luggage.wxa.qq.a.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a1 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg.getInst().setDisableFileReaderCache(uri.getBooleanQueryParameter("disable_file_reader_cache", false));
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            String queryParameter = uri.getQueryParameter("set_gray_value");
            if (uri.toString().contains("set_grayvalue")) {
                queryParameter = uri.getQueryParameter("set_grayvalue");
            }
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    com.tencent.luggage.wxa.ar.v0.b(Integer.parseInt(queryParameter));
                    return com.tencent.luggage.wxa.qq.a.b();
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, set gray value error:" + e16.getMessage());
                    return com.tencent.luggage.wxa.qq.a.a();
                }
            }
            return com.tencent.luggage.wxa.qq.a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            com.tencent.luggage.wxa.ar.e0.c(context);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b1 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg.getInst().setDisableFileReaderCrashDetect(uri.getBooleanQueryParameter("disable_file_reader_crash_detect", false));
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            String queryParameter = uri.getQueryParameter("set_config_url");
            if (!com.tencent.luggage.wxa.ar.z0.a(queryParameter) && !WebDebugCfg.getInst().getEnableLocalDebug()) {
                com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, set config url error, config url:" + queryParameter);
                return com.tencent.luggage.wxa.qq.a.a();
            }
            com.tencent.luggage.wxa.ar.z0.d(queryParameter);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            com.tencent.luggage.wxa.ar.e0.d(context);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c1 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            XWebChildProcessMonitor.resetCrashCount();
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            String queryParameter = uri.getQueryParameter("set_plugin_config_url");
            if (!com.tencent.luggage.wxa.ar.z0.a(queryParameter) && !WebDebugCfg.getInst().getEnableLocalDebug()) {
                com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, set plugin config url error, config url:" + queryParameter);
                return com.tencent.luggage.wxa.qq.a.a();
            }
            com.tencent.luggage.wxa.ar.z0.e(queryParameter);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            XWebSdk.forceKillChildProcess();
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d1 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            XWebSdk.clearAllWebViewCache(true);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            com.tencent.luggage.wxa.yq.m.f().resetLastFetchConfigTime();
            XWalkPluginUpdater.setLastCheckPluginUpdateTime(0L);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            com.tencent.luggage.wxa.ar.e0.e(context);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e1 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            com.tencent.luggage.wxa.ar.q0.a(context, true);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            com.tencent.luggage.wxa.yq.l.g().abandonCurrentScheduler();
            com.tencent.luggage.wxa.yq.m.f().abandonCurrentScheduler();
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            com.tencent.luggage.wxa.ar.e0.b(context);
            return new com.tencent.luggage.wxa.qq.a(true, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f1 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            com.tencent.luggage.wxa.ar.q0.b(context);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            com.tencent.luggage.wxa.ar.q0.b(context, true);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            if (bVar != null) {
                bVar.b();
                return com.tencent.luggage.wxa.qq.a.b();
            }
            return com.tencent.luggage.wxa.qq.a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g1 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            boolean z16;
            if (bVar != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.luggage.wxa.qq.n.a(context, z16);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            boolean booleanQueryParameter = uri.getBooleanQueryParameter("enable_check_storage", false);
            WebDebugCfg.getInst().setEnableCheckStorage(booleanQueryParameter);
            if (booleanQueryParameter) {
                com.tencent.luggage.wxa.ar.q0.a(context);
            }
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            try {
                com.tencent.luggage.wxa.ar.x0.d("XWebCommandHandler", "handleCommand, revertToApkVer, version:" + com.tencent.luggage.wxa.yq.g.a(context, Integer.parseInt(uri.getQueryParameter("revert_to_apk"))));
                return com.tencent.luggage.wxa.qq.a.b();
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, revertToApkVer error:" + th5.getMessage());
                return com.tencent.luggage.wxa.qq.a.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg inst = WebDebugCfg.getInst();
            WebView.WebViewKind webViewKind = WebView.WebViewKind.WV_KIND_NONE;
            inst.setHardCodeWebViewKind("mm", webViewKind);
            WebDebugCfg.getInst().setHardCodeWebViewKind("tools", webViewKind);
            WebDebugCfg.getInst().setHardCodeWebViewKind("appbrand", webViewKind);
            return new com.tencent.luggage.wxa.qq.a(true, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            String queryParameter = uri.getQueryParameter("set_apk_version");
            if (uri.toString().contains("set_apkver")) {
                queryParameter = uri.getQueryParameter("set_apkver");
            }
            try {
                int parseInt = Integer.parseInt(queryParameter);
                XWalkEnvironment.setCoreVersionInfo(parseInt, "1.0." + queryParameter, com.tencent.luggage.wxa.ar.b.b());
                com.tencent.luggage.wxa.ar.x0.d("XWebCommandHandler", "handleCommand, setApkVersion, version:" + parseInt);
                return com.tencent.luggage.wxa.qq.a.b();
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, setApkVersion error:" + th5.getMessage());
                return com.tencent.luggage.wxa.qq.a.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg inst = WebDebugCfg.getInst();
            WebView.WebViewKind webViewKind = WebView.WebViewKind.WV_KIND_SYS;
            inst.setHardCodeWebViewKind("mm", webViewKind);
            WebDebugCfg.getInst().setHardCodeWebViewKind("tools", webViewKind);
            WebDebugCfg.getInst().setHardCodeWebViewKind("appbrand", webViewKind);
            return new com.tencent.luggage.wxa.qq.a(true, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            boolean z16;
            if (bVar != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            try {
                if (!com.tencent.luggage.wxa.ar.w0.a(context, z16)) {
                    return com.tencent.luggage.wxa.qq.a.a();
                }
                return com.tencent.luggage.wxa.qq.a.b();
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, loadCachePackage error:" + th5.getMessage());
                return com.tencent.luggage.wxa.qq.a.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            l.a b16 = com.tencent.luggage.wxa.qq.l.b(uri.getQueryParameter("cmd"));
            if (!b16.f138988a) {
                com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, link invalid");
                return com.tencent.luggage.wxa.qq.a.a();
            }
            String a16 = com.tencent.luggage.wxa.qq.l.a(b16.f138989b);
            if (a16 == null) {
                com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, url invalid");
                return com.tencent.luggage.wxa.qq.a.b();
            }
            com.tencent.luggage.wxa.ar.x0.d("XWebCommandHandler", "handleCommand, new debug url:" + a16);
            boolean enableLocalDebug = WebDebugCfg.getInst().getEnableLocalDebug();
            WebDebugCfg.getInst().setEnableLocalDebug(true);
            Bundle bundle = new Bundle();
            bundle.putInt("source", com.tencent.luggage.wxa.qq.b.DEBUG_URL.ordinal());
            bundle.putString("command", a16);
            com.tencent.luggage.wxa.qq.a a17 = r0.a(bundle, bVar);
            WebDebugCfg.getInst().setEnableLocalDebug(enableLocalDebug);
            return a17;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            boolean z16;
            if (bVar != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            try {
                if (!com.tencent.luggage.wxa.ar.w0.b(context, z16)) {
                    return com.tencent.luggage.wxa.qq.a.a();
                }
                return com.tencent.luggage.wxa.qq.a.b();
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, loadSdcardPackage error:" + th5.getMessage());
                return com.tencent.luggage.wxa.qq.a.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg inst = WebDebugCfg.getInst();
            WebView.WebViewKind webViewKind = WebView.WebViewKind.WV_KIND_PINUS;
            inst.setHardCodeWebViewKind("mm", webViewKind);
            WebDebugCfg.getInst().setHardCodeWebViewKind("tools", webViewKind);
            WebDebugCfg.getInst().setHardCodeWebViewKind("appbrand", webViewKind);
            return new com.tencent.luggage.wxa.qq.a(true, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            if (XWalkEnvironment.getBuildConfigNeedTurnOffDynamicCode()) {
                com.tencent.luggage.wxa.ar.x0.d("XWebCommandHandler", "handleCommand, enableForbidDownloadCode, not support");
                return com.tencent.luggage.wxa.qq.a.a();
            }
            XWebSdk.setForbidDownloadCode(uri.getBooleanQueryParameter("enable_forbid_download_code", false));
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            String queryParameter = uri.getQueryParameter("set_mm_config");
            if (!TextUtils.isEmpty(queryParameter)) {
                WebDebugCfg.getInst().setHardCodeWebViewKind("mm", WebView.WebViewKind.valueOf(queryParameter));
                return new com.tencent.luggage.wxa.qq.a(true, true);
            }
            com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, set mm config error, config:" + queryParameter);
            return com.tencent.luggage.wxa.qq.a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg.getInst().setEnableCheckThread(uri.getBooleanQueryParameter("enable_check_thread", false));
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            String queryParameter = uri.getQueryParameter("set_tools_config");
            if (uri.toString().contains("set_web_config")) {
                queryParameter = uri.getQueryParameter("set_web_config");
            }
            if (!TextUtils.isEmpty(queryParameter)) {
                WebDebugCfg.getInst().setHardCodeWebViewKind("tools", WebView.WebViewKind.valueOf(queryParameter));
                return com.tencent.luggage.wxa.qq.a.b();
            }
            com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, set tools config error, config:" + queryParameter);
            return com.tencent.luggage.wxa.qq.a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            String queryParameter = uri.getQueryParameter("delete_origin");
            if (TextUtils.isEmpty(queryParameter)) {
                return com.tencent.luggage.wxa.qq.a.a();
            }
            WebStorage.getInstance().deleteOrigin(queryParameter);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            String queryParameter = uri.getQueryParameter("set_appbrand_config");
            if (!TextUtils.isEmpty(queryParameter)) {
                WebDebugCfg.getInst().setHardCodeWebViewKind("appbrand", WebView.WebViewKind.valueOf(queryParameter));
                return com.tencent.luggage.wxa.qq.a.b();
            }
            com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, set appbrand config error, config:" + queryParameter);
            return com.tencent.luggage.wxa.qq.a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            if (bVar != null && bVar.d() != null) {
                bVar.d().loadUrl("chrome://gpucrash/");
                return com.tencent.luggage.wxa.qq.a.b();
            }
            return com.tencent.luggage.wxa.qq.a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class p implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            String queryParameter = uri.getQueryParameter("mm_webview_mode");
            a0.a c16 = com.tencent.luggage.wxa.ar.a0.c(queryParameter);
            if (c16.f121611a) {
                WebDebugCfg.getInst().setWebViewModeForMM(c16.b());
                return new com.tencent.luggage.wxa.qq.a(true, true);
            }
            com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, set mm webview mode error, config:" + queryParameter);
            return com.tencent.luggage.wxa.qq.a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class p0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            if (bVar != null && bVar.d() != null) {
                bVar.d().loadUrl("chrome://gpu-java-crash/");
                return com.tencent.luggage.wxa.qq.a.b();
            }
            return com.tencent.luggage.wxa.qq.a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class q implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            com.tencent.luggage.wxa.ar.q0.b(true);
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class q0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            if (bVar != null && bVar.d() != null) {
                bVar.d().loadUrl("chrome://crash");
                return com.tencent.luggage.wxa.qq.a.b();
            }
            return com.tencent.luggage.wxa.qq.a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class r implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg.getInst().setEnableNewDebugPage(uri.getBooleanQueryParameter("enable_new_debug_page", false));
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ar.r0$r0, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6023r0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg.getInst().setIgnoreCrashWatch(uri.getBooleanQueryParameter("ignore_crashwatch", uri.getBooleanQueryParameter("ignore_crash_watch", false)));
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class s implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg.getInst().setEnableShowVersion(uri.getBooleanQueryParameter("enable_show_version", false));
            if (bVar != null) {
                bVar.c();
            }
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class s0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            if (bVar != null && bVar.d() != null) {
                bVar.d().loadUrl("chrome://inducebrowsercrashforrealz/");
                return com.tencent.luggage.wxa.qq.a.b();
            }
            return com.tencent.luggage.wxa.qq.a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class t implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg.getInst().setEnableTestBaseConfig(uri.getBooleanQueryParameter("enable_test_base_config", false));
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class t0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            String queryParameter = uri.getQueryParameter("set_dark_mode");
            if (!TextUtils.isEmpty(queryParameter)) {
                if (!r0.b(context, bVar, queryParameter)) {
                    return com.tencent.luggage.wxa.qq.a.a();
                }
                return com.tencent.luggage.wxa.qq.a.b();
            }
            com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, set dark mode error, config:" + queryParameter);
            return com.tencent.luggage.wxa.qq.a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class u implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg.getInst().setEnableShowFps(uri.getBooleanQueryParameter("show_fps", uri.getBooleanQueryParameter("enable_show_fps", false)));
            if (bVar != null) {
                bVar.f();
            }
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class u0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg.getInst().setEnableDebugPackage(uri.getBooleanQueryParameter("enable_debug_package", false));
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class v implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            boolean booleanQueryParameter = uri.getBooleanQueryParameter("inspector", uri.getBooleanQueryParameter("enable_remote_debug", false));
            WebDebugCfg.getInst().setEnableRemoteDebug(booleanQueryParameter);
            if (!XWebSdk.setEnableRemoteDebug(booleanQueryParameter)) {
                return com.tencent.luggage.wxa.qq.a.a();
            }
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class v0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            com.tencent.luggage.wxa.yq.i.a(uri.getBooleanQueryParameter("enable_auto_check_update", false));
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class w implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            WebDebugCfg.getInst().setEnableShowSavePage(uri.getBooleanQueryParameter("save_page", uri.getBooleanQueryParameter("enable_show_save_page", false)));
            if (bVar != null) {
                bVar.a();
            }
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class w0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            com.tencent.luggage.wxa.tq.g.a(ConstValue.INVOKE_RUNTIME_ID_SET_RUNTIME_CONFIG, new Object[]{uri.getQueryParameter("set_runtime_config")});
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class x implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            if (bVar != null && bVar.d() != null && com.tencent.luggage.wxa.qq.o.a(context, bVar.d(), true)) {
                return com.tencent.luggage.wxa.qq.a.b();
            }
            return com.tencent.luggage.wxa.qq.a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class x0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            if (!com.tencent.luggage.wxa.qq.m.a()) {
                return com.tencent.luggage.wxa.qq.a.a();
            }
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class y implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            boolean z16;
            if (bVar != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!com.tencent.luggage.wxa.qq.o.a(context, z16)) {
                return com.tencent.luggage.wxa.qq.a.a();
            }
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class y0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            boolean z16;
            if (bVar != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!com.tencent.luggage.wxa.qq.m.a(context, null, "6", z16)) {
                return com.tencent.luggage.wxa.qq.a.a();
            }
            return com.tencent.luggage.wxa.qq.a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class z implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            try {
                CommandCfg.getInstance().applyCommand(null, "0");
                com.tencent.luggage.wxa.yq.s.a(IXWebBroadcastListener.STAGE_MAINCFG_UPDATE, 0, 0);
                return com.tencent.luggage.wxa.qq.a.b();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, clear config commands error:" + e16.getMessage());
                return com.tencent.luggage.wxa.qq.a.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class z0 implements com.tencent.luggage.wxa.qq.j {
        @Override // com.tencent.luggage.wxa.qq.j
        public com.tencent.luggage.wxa.qq.a a(Context context, Uri uri, com.tencent.xweb.debug.b bVar) {
            return com.tencent.luggage.wxa.qq.m.a(context, uri.getQueryParameter("set_force_use_office_reader"));
        }
    }

    static {
        a("cmd", false, (com.tencent.luggage.wxa.qq.j) new k());
        a("enable_remote_debug", "inspector", false, new v());
        a("show_webview_version", false, (com.tencent.luggage.wxa.qq.j) new g0());
        a("ignore_crash_watch", "ignore_crashwatch", true, new C6023r0());
        a("reset_crash_count", true, (com.tencent.luggage.wxa.qq.j) new c1());
        a(MiniAppPushControl.KEY_CTRL_CMD_CLEAR_CACHE, false, (com.tencent.luggage.wxa.qq.j) new d1());
        a("clear_old_version", false, (com.tencent.luggage.wxa.qq.j) new e1());
        a("clear_all_version", false, (com.tencent.luggage.wxa.qq.j) new f1());
        a("check_update", "check_xwalk_update", false, new g1());
        a("check_plugin_update", false, (com.tencent.luggage.wxa.qq.j) new a());
        a("set_gray_value", "set_grayvalue", false, new b());
        a("set_config_url", false, (com.tencent.luggage.wxa.qq.j) new c());
        a("set_plugin_config_url", false, (com.tencent.luggage.wxa.qq.j) new d());
        a("clear_config_timestamp", "clear_config_time_stamp", false, new e());
        a("clear_schedule", false, (com.tencent.luggage.wxa.qq.j) new f());
        a("clear_test_setting", false, (com.tencent.luggage.wxa.qq.j) new g());
        a("enable_check_storage", false, (com.tencent.luggage.wxa.qq.j) new h());
        a("reset_webview_kind", false, (com.tencent.luggage.wxa.qq.j) new i());
        a("reset_webview_kind_sys", false, (com.tencent.luggage.wxa.qq.j) new j());
        a("reset_webview_kind_xweb", false, (com.tencent.luggage.wxa.qq.j) new l());
        a("set_mm_config", false, (com.tencent.luggage.wxa.qq.j) new m());
        a("set_tools_config", "set_web_config", false, new n());
        a("set_appbrand_config", false, (com.tencent.luggage.wxa.qq.j) new o());
        a("mm_webview_mode", false, (com.tencent.luggage.wxa.qq.j) new p());
        a("check_files", false, (com.tencent.luggage.wxa.qq.j) new q());
        a("enable_new_debug_page", true, (com.tencent.luggage.wxa.qq.j) new r());
        a("enable_show_version", true, (com.tencent.luggage.wxa.qq.j) new s());
        a("enable_test_base_config", true, (com.tencent.luggage.wxa.qq.j) new t());
        a("enable_show_fps", "show_fps", true, new u());
        a("enable_show_save_page", "save_page", true, new w());
        a("load_saved_page", true, (com.tencent.luggage.wxa.qq.j) new x());
        a("clear_saved_page", true, (com.tencent.luggage.wxa.qq.j) new y());
        a("clear_config_commands", true, (com.tencent.luggage.wxa.qq.j) new z());
        a("recheck_config_commands", true, (com.tencent.luggage.wxa.qq.j) new a0());
        a("kill_gpu_process", true, (com.tencent.luggage.wxa.qq.j) new b0());
        a("kill_render_process", true, (com.tencent.luggage.wxa.qq.j) new c0());
        a("kill_child_process", true, (com.tencent.luggage.wxa.qq.j) new d0());
        a("kill_tools_process", true, (com.tencent.luggage.wxa.qq.j) new e0());
        a("kill_all_process", true, (com.tencent.luggage.wxa.qq.j) new f0());
        a("revert_to_apk", true, (com.tencent.luggage.wxa.qq.j) new h0());
        a("set_apk_version", "set_apkver", true, new i0());
        a("load_cache_package", "load_local_xwalk", true, new j0());
        a("load_sdcard_package", true, (com.tencent.luggage.wxa.qq.j) new k0());
        a("enable_forbid_download_code", true, (com.tencent.luggage.wxa.qq.j) new l0());
        a("enable_check_thread", true, (com.tencent.luggage.wxa.qq.j) new m0());
        a("delete_origin", true, (com.tencent.luggage.wxa.qq.j) new n0());
        a("gpu_native_crash", true, (com.tencent.luggage.wxa.qq.j) new o0());
        a("gpu_java_crash", true, (com.tencent.luggage.wxa.qq.j) new p0());
        a("render_native_crash", true, (com.tencent.luggage.wxa.qq.j) new q0());
        a("browser_native_crash", true, (com.tencent.luggage.wxa.qq.j) new s0());
        a("set_dark_mode", true, (com.tencent.luggage.wxa.qq.j) new t0());
        a("enable_debug_package", true, (com.tencent.luggage.wxa.qq.j) new u0());
        a("enable_auto_check_update", true, (com.tencent.luggage.wxa.qq.j) new v0());
        a("set_runtime_config", true, (com.tencent.luggage.wxa.qq.j) new w0());
        a("clear_all_plugin", true, (com.tencent.luggage.wxa.qq.j) new x0());
        a("install_embed_plugin", true, (com.tencent.luggage.wxa.qq.j) new y0());
        a("set_force_use_office_reader", true, (com.tencent.luggage.wxa.qq.j) new z0());
        a("disable_file_reader_cache", true, (com.tencent.luggage.wxa.qq.j) new a1());
        a("disable_file_reader_crash_detect", true, (com.tencent.luggage.wxa.qq.j) new b1());
    }

    public static boolean b(Context context, com.tencent.xweb.debug.b bVar, String str) {
        WebView d16 = bVar != null ? bVar.d() : null;
        if (d16 == null) {
            com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "setDarkMode, no webview");
            return false;
        }
        com.tencent.luggage.wxa.ar.x0.d("XWebCommandHandler", "setDarkMode, config:" + str);
        if (TextUtils.equals(str, "1")) {
            d16.getSettings().setForceDarkMode(2);
            d16.getSettings().setForceDarkBehavior(2);
        } else if (TextUtils.equals(str, "2")) {
            d16.getSettings().setForceDarkMode(2);
            d16.getSettings().setForceDarkBehavior(1);
        } else if (TextUtils.equals(str, "3")) {
            d16.getSettings().setForceDarkMode(0);
        } else if (!TextUtils.equals(str, "4")) {
            com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "setDarkMode, config error:" + str);
            return false;
        }
        return true;
    }

    public static void a(String str, String str2, boolean z16, com.tencent.luggage.wxa.qq.j jVar) {
        if (f121769a == null) {
            f121769a = new HashSet();
        }
        if (a(str) != null) {
            com.tencent.luggage.wxa.ar.x0.c("XWebCommandHandler", "registerDebugCommand, name:" + str + " has been registered");
        }
        f121769a.add(new com.tencent.luggage.wxa.qq.c(str, str2, z16, jVar));
    }

    public static void a(String str, boolean z16, com.tencent.luggage.wxa.qq.j jVar) {
        if (f121769a == null) {
            f121769a = new HashSet();
        }
        if (a(str) != null) {
            com.tencent.luggage.wxa.ar.x0.c("XWebCommandHandler", "registerDebugCommand, name:" + str + " has been registered");
        }
        f121769a.add(new com.tencent.luggage.wxa.qq.c(str, z16, jVar));
    }

    public static com.tencent.luggage.wxa.qq.a a(Bundle bundle, com.tencent.xweb.debug.b bVar) {
        int i3 = bundle.getInt("source", com.tencent.luggage.wxa.qq.b.UNKNOWN.ordinal());
        String string = bundle.getString("command", null);
        if (!b(string)) {
            com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, no need handle, source:" + com.tencent.luggage.wxa.qq.b.values()[i3] + ", command:" + string);
            return com.tencent.luggage.wxa.qq.a.a();
        }
        Context context = bVar != null ? bVar.getContext() : XWalkEnvironment.getApplicationContext();
        boolean enableLocalDebug = WebDebugCfg.getInst().getEnableLocalDebug();
        com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, source:" + com.tencent.luggage.wxa.qq.b.values()[i3] + ", command:" + string + ", enableLocalDebug:" + enableLocalDebug);
        com.tencent.luggage.wxa.qq.a b16 = com.tencent.luggage.wxa.qq.a.b();
        Uri parse = Uri.parse(string);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() != 0) {
            for (String str : queryParameterNames) {
                com.tencent.luggage.wxa.qq.c a16 = a(str);
                if (a16 == null) {
                    com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, unknown command:" + str);
                } else {
                    com.tencent.luggage.wxa.qq.j a17 = a16.a();
                    if (a17 == null) {
                        com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, commandHandler is null, command:" + str);
                    } else if (!a16.d() || enableLocalDebug) {
                        com.tencent.luggage.wxa.qq.a a18 = a17.a(context, parse, bVar);
                        if (!a18.f138959a) {
                            com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, failed command:" + a16.b());
                            b16.f138959a = false;
                        }
                        if (a18.f138959a && a18.f138960b) {
                            b16.f138960b = true;
                        }
                    }
                }
            }
        } else if (enableLocalDebug && bVar != null) {
            bVar.e();
        }
        com.tencent.luggage.wxa.ar.x0.f("XWebCommandHandler", "handleCommand, commandResult:" + b16);
        return b16;
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("debugxweb.qq.com");
    }

    public static com.tencent.luggage.wxa.qq.c a(String str) {
        if (f121769a == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator it = f121769a.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.qq.c cVar = (com.tencent.luggage.wxa.qq.c) it.next();
            if (cVar.b().equals(str) || str.equals(cVar.c())) {
                return cVar;
            }
        }
        return null;
    }
}
