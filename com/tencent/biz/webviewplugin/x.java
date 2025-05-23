package com.tencent.biz.webviewplugin;

import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.thirdsig.api.IThirdSigService;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class x extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private AuthorizeConfig f97647d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.mobileqq.thirdsig.api.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f97648a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f97649b;

        a(String[] strArr, CountDownLatch countDownLatch) {
            this.f97648a = strArr;
            this.f97649b = countDownLatch;
        }

        @Override // com.tencent.mobileqq.thirdsig.api.d
        public void a(com.tencent.mobileqq.thirdsig.api.g gVar) {
            this.f97648a[0] = HexUtil.bytes2HexStr(gVar.a());
            this.f97649b.countDown();
        }

        @Override // com.tencent.mobileqq.thirdsig.api.d
        public void onFail(int i3, String str) {
            this.f97649b.countDown();
        }
    }

    private String p(AppRuntime appRuntime) {
        new HashMap();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String[] strArr = {""};
        ((IThirdSigService) appRuntime.getRuntimeService(IThirdSigService.class, "all")).getStWeb(appRuntime.getLongAccountUin(), 0, 16, new a(strArr, countDownLatch));
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (Exception e16) {
            QLog.e("PtloginPlugin", 1, e16, new Object[0]);
        }
        if (TextUtils.isEmpty(strArr[0])) {
            return null;
        }
        return strArr[0];
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return getClass().getSimpleName();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 3L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fd  */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleSchemaRequest(String str, String str2) {
        Set<String> v3;
        WebViewPlugin.b bVar;
        boolean z16;
        String str3;
        if ((!"http".equals(str2) && !"https".equals(str2)) || TextUtils.isEmpty(str)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("PtloginPlugin", 2, "handleSchemaRequest, originUrl=" + str);
        }
        AuthorizeConfig authorizeConfig = this.f97647d;
        if (authorizeConfig == null || (v3 = authorizeConfig.v("ptlogin2")) == null || v3.isEmpty() || (bVar = this.mRuntime) == null) {
            return false;
        }
        AppRuntime c16 = bVar.c();
        Iterator<String> it = v3.iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            }
            if (str.startsWith(it.next() + "/jump?")) {
                if (str.contains("clientuin=$UIN$")) {
                    str3 = str.replace("clientuin=$UIN$", "clientuin=" + c16.getAccount());
                } else if (str.contains("clientuin=$UIN")) {
                    str3 = str.replace("clientuin=$UIN", "clientuin=" + c16.getAccount());
                } else {
                    str3 = str;
                    z16 = false;
                    if (!str.contains("clientkey=$KEY$")) {
                        String p16 = p(c16);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("clientkey=");
                        sb5.append(TextUtils.isEmpty(p16) ? "" : p16);
                        str3 = str3.replace("clientkey=$KEY$", sb5.toString());
                    } else {
                        if (str.contains("clientkey=$KEY")) {
                            String p17 = p(c16);
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("clientkey=");
                            sb6.append(TextUtils.isEmpty(p17) ? "" : p17);
                            str3 = str3.replace("clientkey=$KEY", sb6.toString());
                        }
                        if (str.contains("keyindex=$KEYINDEX$")) {
                            str = str3.replace("keyindex=$KEYINDEX$", "keyindex=19");
                        } else if (str.contains("keyindex=$KEYINDEX")) {
                            str = str3.replace("keyindex=$KEYINDEX", "keyindex=19");
                        } else {
                            str = str3;
                        }
                        z16 = true;
                    }
                    z16 = true;
                    if (str.contains("keyindex=$KEYINDEX$")) {
                    }
                    z16 = true;
                }
                z16 = true;
                if (!str.contains("clientkey=$KEY$")) {
                }
                z16 = true;
                if (str.contains("keyindex=$KEYINDEX$")) {
                }
                z16 = true;
            }
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("PtloginPlugin", 2, String.format("handleSchemaRequest, replacePtloginUrl %s", new StringBuilder()));
            }
            CustomWebView e16 = this.mRuntime.e();
            if (e16 != null) {
                e16.loadUrlOriginal(str);
            }
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("PtloginPlugin", 2, "handleSchemaRequest, not replaced, duration=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f97647d = AuthorizeConfig.y();
    }
}
