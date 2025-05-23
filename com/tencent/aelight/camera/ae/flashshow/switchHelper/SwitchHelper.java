package com.tencent.aelight.camera.ae.flashshow.switchHelper;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.aelight.camera.ae.flashshow.switchHelper.a;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import u53.b;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SwitchHelper {

    /* renamed from: c, reason: collision with root package name */
    public static String f64366c = "SwitchHelper";

    /* renamed from: e, reason: collision with root package name */
    private static SwitchHelper f64368e;

    /* renamed from: a, reason: collision with root package name */
    private String f64370a = "";

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.flashshow.switchHelper.a f64371b = null;

    /* renamed from: d, reason: collision with root package name */
    private static final String f64367d = b.f438374e + File.separator + "downloadSwitchConfig.json";

    /* renamed from: f, reason: collision with root package name */
    public static boolean f64369f = false;

    SwitchHelper() {
    }

    private void d(String str, String str2) {
        ms.a.f(f64366c, "downloadSwitchConfig");
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = str2;
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 30000L;
        httpNetReq.mCallback = new a(str);
        try {
            ((IHttpEngineService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            ms.a.c(f64366c, "[downloadEnhance], error=" + e16);
        }
    }

    public static synchronized SwitchHelper e() {
        SwitchHelper switchHelper;
        synchronized (SwitchHelper.class) {
            if (f64368e == null) {
                f64368e = new SwitchHelper();
            }
            switchHelper = f64368e;
        }
        return switchHelper;
    }

    private boolean f(String str) {
        return !this.f64370a.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String c16 = wq.a.c();
        ms.a.a(f64366c, "enhance config url: " + c16);
        if (f(c16)) {
            String str = f64367d;
            q.d(str);
            d(c16, str);
        }
    }

    public void h() {
        List<a.C0553a> list;
        String model = DeviceInfoMonitor.getModel();
        ms.a.a(f64366c, "device config :" + model);
        com.tencent.aelight.camera.ae.flashshow.switchHelper.a aVar = this.f64371b;
        if (aVar != null && (list = aVar.f64374a) != null && !list.isEmpty()) {
            Iterator<a.C0553a> it = list.iterator();
            while (it.hasNext()) {
                if (model.equals(it.next().f64375a)) {
                    f64369f = true;
                    return;
                }
            }
        }
        f64369f = wq.a.b();
    }

    public void j() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.switchHelper.SwitchHelper.1
            @Override // java.lang.Runnable
            public void run() {
                ms.a.f(SwitchHelper.f64366c, "updateSwitchConfigInSubThread");
                SwitchHelper.this.i();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f64372d;

        a(String str) {
            this.f64372d = str;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            boolean z16 = netResp != null && netResp.mResult == 0;
            ms.a.f(SwitchHelper.f64366c, "download :" + z16);
            if (z16) {
                SwitchHelper.this.g();
            }
            SwitchHelper.this.f64370a = this.f64372d;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f64371b = null;
        String str = f64367d;
        if (FileUtils.fileExists(str)) {
            String z16 = QIMPtvTemplateManager.z(new File(str));
            if (TextUtils.isEmpty(z16)) {
                return;
            }
            try {
                this.f64371b = (com.tencent.aelight.camera.ae.flashshow.switchHelper.a) new Gson().fromJson(z16, com.tencent.aelight.camera.ae.flashshow.switchHelper.a.class);
            } catch (JsonSyntaxException e16) {
                ms.a.c(f64366c, "loadLocalConfigJson JsonSyntaxException e: " + e16.getMessage());
            } catch (IllegalStateException e17) {
                ms.a.c(f64366c, "loadLocalConfigJson IllegalStateException e: " + e17.getMessage());
            }
        }
    }
}
