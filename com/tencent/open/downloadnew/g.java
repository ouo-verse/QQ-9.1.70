package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g {

    /* renamed from: d, reason: collision with root package name */
    private static g f341518d;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Bundle> f341520b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c, reason: collision with root package name */
    private QIPCModule f341521c = new a("Module_DownloaderGetCodeServer");

    /* renamed from: a, reason: collision with root package name */
    private b f341519a = new b();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends QIPCModule {
        a(String str) {
            super(str);
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            com.tencent.open.base.f.a("DownloaderWriteCodeIPC", "onCall action|" + str + " params|" + bundle + " callbackId|" + i3);
            QQAppInterface e16 = g.this.e();
            if (e16 == null) {
                com.tencent.open.base.f.a("DownloaderWriteCodeIPC", "onCall action but appInterface is null");
                return null;
            }
            if ("DownloaderWriteCodeIPC_Action__GetCode".equals(str) && bundle != null) {
                String string = bundle.getString("PackageName");
                int i16 = bundle.getInt("VersionCode");
                com.tencent.open.base.f.a("DownloaderWriteCodeIPC", "onCall action|" + str + " packageName|" + string + " versionCode|" + i16);
                if (string != null) {
                    e16.addDefaultObservers(g.this.f341519a);
                    ConfigHandler configHandler = (ConfigHandler) e16.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
                    String str2 = string + "_" + i16;
                    bundle.putInt("CallbackId", i3);
                    g.this.f341520b.put(str2, new Bundle(bundle));
                    configHandler.I2(string, i16, str2);
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class b extends com.tencent.mobileqq.app.h {
        b() {
        }

        @Override // com.tencent.mobileqq.app.h
        protected void d(boolean z16, String str, String str2) {
            com.tencent.open.base.f.a("DownloaderWriteCodeIPC", "GetAuthCodeObserver onGetAuthCode isSuccess|" + z16 + " code|" + str + " reqId|" + str2);
            if (str2 == null) {
                return;
            }
            Bundle bundle = (Bundle) g.this.f341520b.get(str2);
            if (bundle == null) {
                com.tencent.open.base.f.a("DownloaderWriteCodeIPC", "GetAuthCodeObserver reqId|" + str2 + "  but params context is null");
                return;
            }
            int i3 = bundle.getInt("CallbackId");
            Bundle bundle2 = new Bundle();
            bundle2.putString("PackageName", bundle.getString("PackageName"));
            bundle2.putInt("VersionCode", bundle.getInt("VersionCode"));
            if (z16) {
                bundle2.putBoolean("IsSuccess", true);
                bundle2.putString("Code", str);
            } else {
                bundle2.putBoolean("IsSuccess", false);
            }
            com.tencent.open.base.f.a("DownloaderWriteCodeIPC", "GetAuthCodeObserver callbackId|" + i3 + " result|" + bundle2);
            g.this.f341521c.callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
        }
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface e() {
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        }
        return null;
    }

    public static g g() {
        if (f341518d == null) {
            synchronized (g.class) {
                f341518d = new g();
            }
        }
        return f341518d;
    }

    public QIPCModule f() {
        return this.f341521c;
    }
}
