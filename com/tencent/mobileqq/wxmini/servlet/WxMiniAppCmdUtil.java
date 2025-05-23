package com.tencent.mobileqq.wxmini.servlet;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.Servlet;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class WxMiniAppCmdUtil {

    /* renamed from: d, reason: collision with root package name */
    public static String f327805d = "WxAppCmdUtil";

    /* renamed from: e, reason: collision with root package name */
    private static volatile WxMiniAppCmdUtil f327806e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile AtomicInteger f327807f = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    private WxMiniAppObserver f327808a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Integer, MiniAppCmdInterface> f327809b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Integer, MiniAppProxy.SenderListener> f327810c;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class NewIntent extends mqq.app.NewIntent {
        public NewIntent(Context context, Class<? extends Servlet> cls, MiniAppCmdInterface miniAppCmdInterface, String str) {
            super(context, cls);
            putExtra(MiniAppCmdUtil.KEY_INDEX, WxMiniAppCmdUtil.this.d(miniAppCmdInterface, str));
            setObserver(WxMiniAppCmdUtil.this.f327808a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends WxMiniAppObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.wxmini.servlet.WxMiniAppObserver
        public void c(int i3, boolean z16, Bundle bundle) {
            super.c(i3, z16, bundle);
            QLog.e("WxAppObserver", 1, "onGetTeenagerConfig index.", i3 + " isSuc = " + z16);
            if (WxMiniAppCmdUtil.this.f327809b != null && WxMiniAppCmdUtil.this.f327809b.containsKey(Integer.valueOf(i3))) {
                MiniAppCmdInterface miniAppCmdInterface = (MiniAppCmdInterface) WxMiniAppCmdUtil.this.f327809b.remove(Integer.valueOf(i3));
                JSONObject jSONObject = new JSONObject();
                if (z16) {
                    try {
                        String string = bundle.getString(MiniAppGetTeenagerConfigServlet.KEY_APPID_LIST);
                        int i16 = bundle.getInt(MiniAppGetTeenagerConfigServlet.KEY_FREQUENCY_SWITCH, -1);
                        int i17 = bundle.getInt(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, -1);
                        jSONObject.put(MiniAppGetTeenagerConfigServlet.KEY_APPID_LIST, string);
                        jSONObject.put(MiniAppGetTeenagerConfigServlet.KEY_FREQUENCY_SWITCH, i16);
                        jSONObject.put(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, i17);
                    } catch (JSONException e16) {
                        QLog.e("WxAppObserver", 1, "onGetTeenagerConfig error.", e16);
                    }
                }
                if (miniAppCmdInterface != null) {
                    miniAppCmdInterface.onCmdListener(z16, jSONObject);
                    return;
                }
                return;
            }
            QLog.e("WxAppObserver", 1, "onGetTeenagerConfig can not found listener. " + i3);
        }
    }

    WxMiniAppCmdUtil() {
        if (this.f327809b == null) {
            this.f327809b = new ConcurrentHashMap<>();
        }
        if (this.f327810c == null) {
            this.f327810c = new ConcurrentHashMap<>();
        }
        if (this.f327808a == null) {
            this.f327808a = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(MiniAppCmdInterface miniAppCmdInterface, String str) {
        int incrementAndGet = f327807f.incrementAndGet();
        ConcurrentHashMap<Integer, MiniAppCmdInterface> concurrentHashMap = this.f327809b;
        if (concurrentHashMap != null && !concurrentHashMap.containsKey(Integer.valueOf(incrementAndGet)) && miniAppCmdInterface != null) {
            this.f327809b.put(Integer.valueOf(incrementAndGet), miniAppCmdInterface);
        } else {
            QLog.e(f327805d, 1, str + " index error");
        }
        return incrementAndGet;
    }

    public static WxMiniAppCmdUtil e() {
        if (f327806e == null) {
            synchronized (WxMiniAppCmdUtil.class) {
                if (f327806e == null) {
                    f327806e = new WxMiniAppCmdUtil();
                }
            }
        }
        return f327806e;
    }

    public void f(String str, MiniAppCmdInterface miniAppCmdInterface) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), d.class, miniAppCmdInterface, "getTeenagerConfig");
        newIntent.putExtra(MiniAppGetTeenagerConfigServlet.KEY_REQUEST_EXT_INFO, str);
        newIntent.setObserver(this.f327808a);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }
}
