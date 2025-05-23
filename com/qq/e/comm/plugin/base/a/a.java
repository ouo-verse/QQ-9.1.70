package com.qq.e.comm.plugin.base.a;

import android.text.TextUtils;
import com.qq.e.comm.StubVisitor;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.pi.CustomWXLuggageListener;
import com.qq.e.comm.pi.WXLuggageListener;
import com.qq.e.comm.plugin.base.ad.model.d;
import com.qq.e.comm.plugin.ipc.C2SMethod;
import com.qq.e.comm.plugin.ipc.IPCClass;
import com.qq.e.comm.plugin.ipc.business.BusinessAction;
import com.qq.e.comm.plugin.ipc.business.BusinessModuleName;
import com.qq.e.comm.plugin.ipc.business.BusinessResultKey;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.b;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SharedPreferencedUtil;
import java.util.Map;

/* compiled from: P */
@IPCClass
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f38339a;

    a() {
    }

    public static a a() {
        if (f38339a == null) {
            synchronized (a.class) {
                if (f38339a == null) {
                    f38339a = new a();
                }
            }
        }
        return f38339a;
    }

    public String b() {
        if (SDKStatus.getSDKVersionCode() >= 100) {
            return StubVisitor.getInstance().getCustomFileProviderClassName();
        }
        return null;
    }

    @C2SMethod(action = BusinessAction.ACTION_GET_LPS_OPTIONS, module = BusinessModuleName.IPC_MODULE_STUB_VISITOR_PROXY, results = {BusinessResultKey.KEY_GET_LPS_OPTIONS})
    public int c() {
        if (SDKStatus.getSDKVersionCode() >= 180) {
            try {
                return StubVisitor.getInstance().getLandingPageShareOptions();
            } catch (Throwable th5) {
                th5.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public WXLuggageListener d() {
        if (SDKStatus.getSDKVersionCode() >= 190) {
            return StubVisitor.getInstance().getWXLuggageListener();
        }
        return null;
    }

    public CustomWXLuggageListener e() {
        if (SDKStatus.getSDKVersionCode() >= 200) {
            return StubVisitor.getInstance().getCustomWXLuggageListener();
        }
        return null;
    }

    public boolean a(CustomLandingPageListener.Params params) {
        if (SDKStatus.getSDKVersionCode() < 20) {
            return false;
        }
        try {
            return StubVisitor.getInstance().jumpToCustomLandingPage(params);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public void a(d dVar) {
        AppDownloadCallback appDownloadCallback;
        try {
            if (SDKStatus.getSDKVersionCode() < 180 || (appDownloadCallback = StubVisitor.getInstance().getAppDownloadCallback()) == null || dVar == null) {
                return;
            }
            String string = SharedPreferencedUtil.getString(SharedPreferencedUtil.KEY_PREODER_APP_INFO_PREFIX + dVar.e(), "");
            appDownloadCallback.onDownloadComplete(dVar.k(), dVar.c(), dVar.e(), !TextUtils.isEmpty(string) ? AppDownloadCallback.TGAppNoticeInfo.createFromJsonStr(string) : null);
            String str = SharedPreferencedUtil.KEY_PREODER_APP_CALLBACK_NUM_PREFIX + dVar.e();
            String str2 = SharedPreferencedUtil.KEY_PREODER_APP_CALLBACK_TIME_PREFIX + dVar.e();
            StatTracer.trackEvent(1600002, SharedPreferencedUtil.getInt(str, 0), new b());
            SharedPreferencedUtil.putInt(str, SharedPreferencedUtil.getInt(str, 0) + 1);
            SharedPreferencedUtil.putLong(str2, System.currentTimeMillis());
            if (SharedPreferencedUtil.getInt(str, 0) >= 3) {
                SharedPreferencedUtil.remove(SharedPreferencedUtil.KEY_PREODER_APP_INFO_PREFIX + dVar.e());
            }
        } catch (Exception e16) {
            GDTLogger.e("callbackAppDownloadComplete error:" + e16);
        }
    }

    public void a(int i3, String str, String str2, String str3, String str4) {
        if (SDKStatus.getSDKVersionCode() >= 180) {
            try {
                StubVisitor.getInstance().onWebViewShare(i3, str, str2, str3, str4);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public void a(Map<Integer, String> map) {
        if (SDKStatus.getSDKVersionCode() >= 282) {
            StubVisitor.getInstance().onDataUsed(map);
        }
    }
}
