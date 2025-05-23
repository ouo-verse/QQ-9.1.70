package com.qq.e.comm.plugin.tangramsplash.c;

import android.os.Bundle;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.base.ad.e.c;
import com.qq.e.comm.plugin.base.ad.model.l;
import com.qq.e.comm.plugin.k.ai;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private com.qq.e.comm.plugin.tangramsplash.d.e f39831a;

    /* renamed from: b, reason: collision with root package name */
    private String f39832b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f39833c;

    /* renamed from: d, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.b f39834d;

    /* renamed from: e, reason: collision with root package name */
    private String f39835e;

    /* renamed from: f, reason: collision with root package name */
    private LoadAdParams f39836f;

    /* renamed from: g, reason: collision with root package name */
    private String f39837g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f39838h;

    /* renamed from: i, reason: collision with root package name */
    private int f39839i;

    public d(com.qq.e.comm.plugin.base.ad.b bVar, String str, String str2, String str3, LoadAdParams loadAdParams) {
        com.qq.e.comm.plugin.tangramsplash.d.e eVar = new com.qq.e.comm.plugin.tangramsplash.d.e();
        this.f39831a = eVar;
        this.f39838h = false;
        this.f39839i = 0;
        eVar.a(String.valueOf(1310101));
        this.f39833c = com.qq.e.comm.plugin.tangramsplash.d.a.a(loadAdParams);
        GDTLogger.d("set hotStart :" + this.f39833c);
        this.f39834d = bVar;
        this.f39837g = str;
        this.f39835e = str3;
        this.f39836f = loadAdParams;
        this.f39832b = str2;
    }

    static /* synthetic */ int i(d dVar) {
        int i3 = dVar.f39839i;
        dVar.f39839i = i3 + 1;
        return i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.qq.e.comm.plugin.base.ad.model.a aVar = new com.qq.e.comm.plugin.base.ad.model.a(this.f39835e, this.f39834d, this.f39832b);
        com.qq.e.comm.plugin.base.ad.model.b bVar = new com.qq.e.comm.plugin.base.ad.model.b();
        bVar.c(this.f39833c);
        GDTLogger.d("preload is hotStart :" + bVar.K());
        bVar.a(true);
        bVar.a(this.f39832b);
        bVar.a(1);
        bVar.b(GDTADManager.getInstance().getSM().getInteger("splashPreloadAdCount", 5));
        bVar.c(2);
        com.qq.e.comm.plugin.base.ad.b bVar2 = this.f39834d;
        if (bVar2 != null) {
            bVar.f(bVar2.b());
            com.qq.e.comm.plugin.base.ad.definition.a a16 = com.qq.e.comm.plugin.base.ad.a.a(this.f39834d, GDTADManager.getInstance().getDeviceStatus().getDeviceDensity());
            if (a16 != null) {
                bVar.d(a16.a());
                bVar.e(a16.b());
            }
        }
        if (this.f39833c) {
            bVar.j(f.d(this.f39832b));
        } else {
            bVar.j(f.c(this.f39832b));
        }
        bVar.l(1);
        LoadAdParams loadAdParams = this.f39836f;
        if (loadAdParams != null) {
            bVar.c(loadAdParams.getUin());
            bVar.b(this.f39836f.getLoginOpenid());
            bVar.d(this.f39836f.getLoginAppId());
            bVar.a(this.f39836f.getLoginType());
            bVar.i(this.f39836f.getBlockEffectValue());
            if (SDKStatus.getSDKVersionCode() >= 50) {
                bVar.a(this.f39836f.getPassThroughInfo());
            }
            if (SDKStatus.getSDKVersionCode() >= 70) {
                bVar.e(this.f39836f.getUid());
            }
            if (SDKStatus.getSDKVersionCode() >= 90) {
                bVar.a(this.f39836f.getExperimentId());
                bVar.m(this.f39836f.getExperimentType());
            }
        }
        com.qq.e.comm.plugin.base.ad.e.c.a(bVar, aVar, new c.b() { // from class: com.qq.e.comm.plugin.tangramsplash.c.d.1
            @Override // com.qq.e.comm.plugin.base.ad.e.c.b
            public void a(JSONObject jSONObject) {
                GDTLogger.i("Tangram Preloader onADLoadSuccess");
                d.this.f39838h = true;
                long b16 = d.this.f39831a.b(String.valueOf(1310101));
                l lVar = new l(d.this.f39832b, d.this.f39834d, (com.qq.e.comm.plugin.base.ad.definition.a) null);
                JSONArray a17 = com.qq.e.comm.plugin.k.b.a(jSONObject, d.this.f39832b);
                Bundle bundle = new Bundle();
                bundle.putSerializable(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, d.this.f39834d);
                bundle.putString("appId", d.this.f39837g);
                bundle.putString("posId", d.this.f39832b);
                bundle.putString("adThreadId", d.this.f39835e);
                bundle.putLong("costTime", b16);
                bundle.putBoolean("isHotStart", d.this.f39833c);
                if (y.a(a17)) {
                    GDTLogger.e("onADLoadSuccess adList is empty");
                    bundle.putInt("errorCode", 508);
                    e.a().f39854m.obtainMessage(2, 0, 0, bundle).sendToTarget();
                    return;
                }
                for (int i3 = 0; i3 < a17.length(); i3++) {
                    com.qq.e.comm.plugin.base.ad.c.f.a(a17.optJSONObject(i3), lVar, d.this.f39835e);
                }
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310102, d.this.f39832b, com.qq.e.comm.plugin.tangramsplash.report.c.a(b16, Integer.MIN_VALUE, ai.b() ? 1 : 0, Integer.MIN_VALUE, Integer.MIN_VALUE, null, d.this.f39833c, 0, Integer.MIN_VALUE, null, d.this.f39839i, false));
                if (y.a(jSONObject)) {
                    bundle.putString("response", jSONObject.toString());
                }
                e.a().f39854m.obtainMessage(1, 0, 0, bundle).sendToTarget();
            }

            @Override // com.qq.e.comm.plugin.base.ad.e.c.b
            public void a(com.qq.e.comm.plugin.base.ad.e.b.a aVar2) {
                GDTLogger.e("\u9884\u52a0\u8f7d\u5931\u8d25\uff01", aVar2);
                long b16 = d.this.f39831a.b(String.valueOf(1310101));
                GDTLogger.e("preload ad error", aVar2);
                Bundle bundle = new Bundle();
                bundle.putString("posId", d.this.f39832b);
                bundle.putLong("costTime", b16);
                bundle.putBoolean("isHotStart", d.this.f39833c);
                bundle.putInt("errorCode", aVar2.a());
                bundle.putInt("retryTimes", d.this.f39839i);
                e.a().f39854m.obtainMessage(2, 0, 0, bundle).sendToTarget();
                int integer = GDTADManager.getInstance().getSM().getInteger("splash_preload_retry", 1);
                GDTLogger.d("\u9884\u52a0\u8f7d\u5931\u8d25\u91cd\u8bd5\u6b21\u6570 " + integer);
                if (!f.a(GDTADManager.getInstance().getAppContext()) || integer <= 0 || d.this.f39838h || d.this.f39839i >= integer) {
                    return;
                }
                d.i(d.this);
                d.this.f39831a.a(String.valueOf(1310101));
                com.qq.e.comm.plugin.tangramsplash.report.c.a(1310101, d.this.f39832b, com.qq.e.comm.plugin.tangramsplash.report.c.a(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, aVar2.a(), Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, (String) null, com.qq.e.comm.plugin.tangramsplash.d.a.a(d.this.f39836f), d.this.f39839i));
                e.a().f39854m.post(d.this);
            }
        });
    }
}
