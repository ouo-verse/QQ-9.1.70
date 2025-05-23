package com.qq.e.comm.plugin.base.ad.clickcomponent.chain.interceptor;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.c.c;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.base.ad.model.m;
import com.qq.e.comm.plugin.k.ao;
import com.qq.e.comm.plugin.k.ax;
import com.qq.e.comm.plugin.k.b;
import com.qq.e.comm.plugin.k.d;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class APKDownloadInterceptor extends AbsJumpNode {

    /* loaded from: classes3.dex */
    private static class ErrorCode {
        ErrorCode() {
        }
    }

    public APKDownloadInterceptor(ClickInfo clickInfo) {
        super(clickInfo);
    }

    private String c() {
        String str;
        if (this.f38544b.d() != null) {
            str = this.f38544b.d().W();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            c.a(this.f38544b, -6, "APKDownloadInterceptor", 128);
            return null;
        }
        if (this.f38544b.o() == null) {
            this.f38544b.a(new com.qq.e.comm.plugin.base.ad.clickcomponent.a.c(str));
        }
        return this.f38544b.o().a(this.f38544b);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected boolean a() {
        GDTLogger.i("APKDownloadInterceptorisAppAd" + com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.a(this.f38545c));
        return com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.a(this.f38545c);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    public int b(AbsJumpNode.a aVar) {
        String b16 = d.c(this.f38545c).b();
        boolean z16 = false;
        int status = !TextUtils.isEmpty(b16) ? ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getStatus(b16) : 0;
        boolean b17 = ao.b(status);
        boolean e16 = ao.e(status);
        boolean f16 = ao.f(status);
        boolean c16 = ao.c(status);
        boolean a16 = ao.a(status);
        boolean z17 = ao.d(status) && com.qq.e.comm.plugin.j.c.a("resumeDownloadFailStatus", 1, 1);
        com.qq.e.comm.plugin.base.ad.model.d a17 = b.a(b16);
        if (b17 || e16 || z17) {
            if ((com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.a(this.f38544b) || com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.b(this.f38544b)) && a17 != null) {
                if (b17) {
                    if (b()) {
                        m mVar = new m();
                        mVar.a(1);
                        mVar.b(103);
                        ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).pauseTask(a17.k(), mVar);
                    } else {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.chain.interceptor.APKDownloadInterceptor.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    ax.a("\u6b63\u5728\u52aa\u529b\u4e0b\u8f7d\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85");
                                } catch (Throwable th5) {
                                    th5.printStackTrace();
                                    GDTLogger.report("Show Toast Error In NoClickReportInterceptor", th5);
                                }
                            }
                        });
                    }
                } else {
                    m mVar2 = new m();
                    mVar2.a(1);
                    mVar2.b(103);
                    ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).resumeTask(a17.k(), mVar2);
                }
                z16 = true;
            }
        } else if (f16) {
            if (com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.b(this.f38544b) && !com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.f(this.f38544b)) {
                a(this.f38544b, b16);
            }
        } else if (c16) {
            if (com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.b(this.f38544b)) {
                a(b16);
                z16 = true;
            }
        } else if (a16 && com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.b(this.f38544b)) {
            c.a(this.f38544b, -3, this.f38543a, 16);
            z16 = true;
        }
        return z16 ? 1 : 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.qq.e.comm.plugin.router.PublicApi$DownloadManagerApi] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.qq.e.comm.plugin.router.PublicApi$DownloadManagerApi] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v4, types: [int] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    private void a(ClickInfo clickInfo, String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        String c16 = c();
        boolean z16 = isEmpty;
        if (TextUtils.isEmpty(c16)) {
            z16 = (isEmpty ? 1 : 0) | 2;
        }
        JSONObject b16 = d.b(clickInfo.j());
        boolean z17 = z16;
        if (b16 == null) {
            z17 = (z16 ? 1 : 0) | 4;
        }
        ?? r75 = z17;
        if (TextUtils.isEmpty(clickInfo.e())) {
            r75 = (z17 ? 1 : 0) | 8;
        }
        if (r75 == 0) {
            com.qq.e.comm.plugin.a.b a16 = com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.a(clickInfo, b16, 2, 2, c16);
            ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).start(a16);
            ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).traceCheckingPhaseStatus(a16, r75, null);
        } else {
            c.a(clickInfo, -3, this.f38543a, (int) r75);
            ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).traceCheckingPhaseStatus(null, r75, null);
            GDTLogger.i("APKDownloadInterceptordownload failed:" + r75);
        }
    }

    private void a(String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        if (!isEmpty) {
            com.qq.e.comm.plugin.base.ad.model.d task = ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getTask(str);
            task.a(VirtualAppProxy.KEY_DOWNLOAD_SCENE, 2);
            task.a(LinkReportConstant$BizKey.ACTOR, 1);
            ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).installApp(GDTADManager.getInstance().getAppContext(), task.k());
            ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).traceCheckingPhaseStatus(task, isEmpty ? 1 : 0, null);
            return;
        }
        c.a(this.f38544b, -3, this.f38543a, isEmpty ? 1 : 0);
        ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).traceCheckingPhaseStatus(null, isEmpty ? 1 : 0, null);
        GDTLogger.i("APKDownloadInterceptorinstall failed:" + (isEmpty ? 1 : 0));
    }

    private boolean b() {
        return com.qq.e.comm.plugin.j.c.a(this.f38544b.c().f38511c, "canDownloadStopInNewClick", 1, 1);
    }
}
