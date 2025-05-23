package com.qzone.component.banner.general.builder.bigcard;

import TianShuJce.AdItem;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.qzone.component.banner.general.builder.GeneralModelBaseCardView;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GeneralKuiklyCardView extends GeneralModelBaseCardView implements h, jh2.b {
    private i6.a C;
    BroadcastReceiver D;

    /* renamed from: h, reason: collision with root package name */
    private g f46579h;

    /* renamed from: i, reason: collision with root package name */
    private View f46580i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f46581m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(AdMetricTag.EVENT_NAME);
            if ("QQGameCenter_QzoneAd_QzoneReport".equals(stringExtra)) {
                String stringExtra2 = intent.getStringExtra("data");
                QLog.d("GeneralKuiklyCardView", 1, "onReceive eventName=" + stringExtra + ",jsonData=" + stringExtra2);
                try {
                    if (TextUtils.isEmpty(stringExtra2)) {
                        return;
                    }
                    GeneralKuiklyCardView.this.t(new JSONObject(stringExtra2).optInt("actionType", 0));
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public GeneralKuiklyCardView(Context context) {
        super(context);
        this.C = null;
        this.D = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        onClose();
        i6.d dVar = this.f46575f;
        if (dVar != null) {
            dVar.b();
        }
        onDestroy();
    }

    private Map<String, Object> s(i6.a aVar) {
        JSONObject jSONObject = new JSONObject();
        o(aVar, jSONObject);
        q(aVar, jSONObject);
        p(aVar, jSONObject);
        return KuiklyLaunchParams.INSTANCE.m(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3) {
        QLog.i("GeneralKuiklyCardView", 1, "reportQzone actionType=" + i3);
        LpReportInfo_pf00064.allReport(619, 18, i3, "", "1");
        i6.a aVar = this.C;
        if (aVar != null) {
            if (i3 == 1) {
                l6.d.k(aVar.d(), 101, "tianshu.289");
                return;
            }
            if (i3 == 2 || i3 == 3) {
                l6.d.k(aVar.d(), 102, "tianshu.289");
            } else {
                if (i3 != 4) {
                    return;
                }
                l6.d.k(aVar.d(), 122, "tianshu.289");
            }
        }
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView
    protected int g() {
        return R.layout.co5;
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView
    protected String h() {
        return "GeneralKuiklyCardView";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView
    public void j(i6.a aVar) {
        QLog.d("GeneralKuiklyCardView", 1, "onBindData data=" + aVar);
        this.C = aVar;
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.ecommerce.broadcast.hr.notify");
            MobileQQ.sMobileQQ.registerReceiver(this.D, intentFilter);
        } catch (Exception e16) {
            QLog.e("GeneralKuiklyCardView", 1, "onDestroy registerReceiver fail.", e16);
        }
        Map<String, Object> s16 = s(aVar);
        s16.put("bundle_name", "gamecenter_qzone");
        g createKuiklyRenderView = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(BaseApplication.getContext(), this);
        this.f46579h = createKuiklyRenderView;
        this.f46581m.addView((View) createKuiklyRenderView, new FrameLayout.LayoutParams(-1, -2));
        this.f46579h.b("QZoneFeedsGameAdPage", s16, null);
        this.f46579h.onResume();
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView
    protected void k() {
        QLog.d("GeneralKuiklyCardView", 1, "onInitView renderLogicView=" + this.f46579h);
        if (this.f46579h != null) {
            return;
        }
        this.f46581m = (LinearLayout) findViewById(R.id.m1b);
        this.f46580i = findViewById(R.id.f20458f);
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView, i6.e
    public void onClose() {
        super.onClose();
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView, i6.e
    public void onDestroy() {
        LinearLayout linearLayout;
        super.onDestroy();
        QLog.i("GeneralKuiklyCardView", 1, "onDestroy renderLogicView=" + this.f46579h + ",kuiklyRoot=" + this.f46581m);
        try {
            Object obj = this.f46579h;
            if (obj != null && (linearLayout = this.f46581m) != null) {
                linearLayout.removeView((View) obj);
                this.f46579h.onDetach();
            }
        } catch (Exception e16) {
            QLog.e("GeneralKuiklyCardView", 1, e16, new Object[0]);
        }
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(this.D);
        } catch (Exception e17) {
            QLog.e("GeneralKuiklyCardView", 1, "release unregisterReceiver fail.", e17);
        }
        this.D = null;
        this.f46579h = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        QLog.i("GeneralKuiklyCardView", 1, "onDetachedFromWindow renderLogicView=" + this.f46579h);
        super.onDetachedFromWindow();
        g gVar = this.f46579h;
        if (gVar != null) {
            gVar.sentEvent("EVENT_ON_SLIDE_VIEW_HIDE", new HashMap());
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean z16, ErrorReason errorReason, KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onPageLoadComplete isSucceed=");
        sb5.append(z16);
        sb5.append(",errorReason=");
        if (errorReason != null) {
            str = errorReason.name();
        } else {
            str = "";
        }
        sb5.append(str);
        QLog.i("GeneralKuiklyCardView", 1, sb5.toString());
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView, i6.e
    public void onPause() {
        super.onPause();
        g gVar = this.f46579h;
        if (gVar != null) {
            gVar.onPause();
        }
        QLog.i("GeneralKuiklyCardView", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView, i6.e
    public void onResume() {
        super.onResume();
        g gVar = this.f46579h;
        if (gVar != null) {
            gVar.onResume();
        }
        QLog.i("GeneralKuiklyCardView", 1, "onResume");
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView
    public void setDividerLineVisible(boolean z16) {
        View view = this.f46580i;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
        }
    }

    private void q(i6.a aVar, JSONObject jSONObject) {
        try {
            Map<String, String> y16 = aVar.y();
            if (y16 == null) {
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 1; i3 <= 3; i3++) {
                String str = y16.get("video_type_" + i3);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                int parseInt = Integer.parseInt(str);
                if (parseInt == 1 || parseInt == 2) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("videoType", parseInt);
                    jSONObject2.put("videoTitle", y16.get("subtitle_" + i3));
                    jSONObject2.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, y16.get("video_url_" + i3));
                    if (parseInt == 1) {
                        jSONObject2.put("picUrl", y16.get("video_cover_" + i3));
                    } else {
                        jSONObject2.put("picUrl", y16.get("picture_" + i3));
                    }
                    jSONArray.mo162put(jSONObject2);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("videoInfos", jSONArray.toString());
            }
        } catch (JSONException e16) {
            QLog.e("GeneralKuiklyCardView", 1, "genVideoData exception", e16);
        }
    }

    @Override // jh2.b
    public void b() {
        QLog.i("GeneralKuiklyCardView", 1, "onViewClick");
        post(new Runnable() { // from class: com.qzone.component.banner.general.builder.bigcard.f
            @Override // java.lang.Runnable
            public final void run() {
                GeneralKuiklyCardView.this.r();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void o(i6.a aVar, JSONObject jSONObject) {
        String optString;
        Object e16;
        Object g16;
        Object q16;
        Object x16;
        Object h16;
        Object n3;
        Object j3;
        Object k3;
        Object v3;
        Object w3;
        AdItem d16 = aVar.d();
        String str = d16 != null ? d16.traceinfo : null;
        QLog.d("GeneralKuiklyCardView", 1, "genBaseData traceInfo=" + str);
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    optString = new JSONObject(str).optString("tianshu_footageid", "");
                } catch (JSONException e17) {
                    QLog.e("GeneralKuiklyCardView", 1, "genBaseData find sourceId exception", e17);
                }
                QLog.d("GeneralKuiklyCardView", 1, "genBaseData sourceId=" + optString);
                e16 = aVar.e();
                g16 = aVar.g();
                q16 = aVar.q();
                x16 = aVar.x();
                h16 = aVar.h();
                n3 = aVar.n();
                j3 = aVar.j();
                k3 = aVar.k();
                Object i3 = aVar.i();
                v3 = aVar.v();
                w3 = aVar.w();
                if (v3 == null) {
                    v3 = "";
                }
                if (w3 == null) {
                    w3 = "";
                }
                if (e16 != null) {
                    e16 = "";
                }
                jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, e16);
                jSONObject.put("adId", String.valueOf(aVar.c()));
                jSONObject.put("sourceId", optString);
                if (g16 != null) {
                    g16 = "";
                }
                jSONObject.put("gameAppId", g16);
                if (q16 != null) {
                    q16 = "";
                }
                jSONObject.put("title", q16);
                if (x16 != null) {
                    x16 = "";
                }
                jSONObject.put("contentText", x16);
                if (h16 != null) {
                    h16 = "";
                }
                jSONObject.put("iconUrl", h16);
                if (n3 != null) {
                    n3 = "";
                }
                jSONObject.put(WadlProxyConsts.KEY_JUMP_URL, n3);
                if (j3 != null) {
                    j3 = "";
                }
                jSONObject.put("btnJumpUrl", j3);
                if (k3 != null) {
                    k3 = "";
                }
                jSONObject.put(TuxUIConstants.POP_BTN_TEXT, k3);
                jSONObject.put("layoutClickEnable", aVar.a());
                jSONObject.put("bgUrl", i3 != null ? i3 : "");
                jSONObject.put("subTitleFull", v3);
                jSONObject.put("subUrl", w3);
                return;
            }
            jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, e16);
            jSONObject.put("adId", String.valueOf(aVar.c()));
            jSONObject.put("sourceId", optString);
            if (g16 != null) {
            }
            jSONObject.put("gameAppId", g16);
            if (q16 != null) {
            }
            jSONObject.put("title", q16);
            if (x16 != null) {
            }
            jSONObject.put("contentText", x16);
            if (h16 != null) {
            }
            jSONObject.put("iconUrl", h16);
            if (n3 != null) {
            }
            jSONObject.put(WadlProxyConsts.KEY_JUMP_URL, n3);
            if (j3 != null) {
            }
            jSONObject.put("btnJumpUrl", j3);
            if (k3 != null) {
            }
            jSONObject.put(TuxUIConstants.POP_BTN_TEXT, k3);
            jSONObject.put("layoutClickEnable", aVar.a());
            jSONObject.put("bgUrl", i3 != null ? i3 : "");
            jSONObject.put("subTitleFull", v3);
            jSONObject.put("subUrl", w3);
            return;
        } catch (JSONException e18) {
            QLog.e("GeneralKuiklyCardView", 1, "genBaseData exception", e18);
            return;
        }
        optString = "";
        QLog.d("GeneralKuiklyCardView", 1, "genBaseData sourceId=" + optString);
        e16 = aVar.e();
        g16 = aVar.g();
        q16 = aVar.q();
        x16 = aVar.x();
        h16 = aVar.h();
        n3 = aVar.n();
        j3 = aVar.j();
        k3 = aVar.k();
        Object i36 = aVar.i();
        v3 = aVar.v();
        w3 = aVar.w();
        if (v3 == null) {
        }
        if (w3 == null) {
        }
        if (e16 != null) {
        }
    }

    private void p(i6.a aVar, JSONObject jSONObject) {
        JSONObject optJSONObject;
        String e16 = aVar.e();
        String v3 = aVar.v();
        if (v3 == null) {
            v3 = "";
        }
        try {
            String l3 = aVar.l();
            String m3 = aVar.m();
            if (!TextUtils.isEmpty(m3)) {
                QLog.i("GeneralKuiklyCardView", 1, "genCustomData extraInfo2=" + m3);
                jSONObject.put("extraInfo2", m3);
            }
            if (TextUtils.isEmpty(l3)) {
                return;
            }
            QLog.i("GeneralKuiklyCardView", 1, "genCustomData extraInfo=" + l3);
            JSONObject jSONObject2 = new JSONObject(l3);
            if (!"1".equals(e16) && !"2".equals(e16) && !"3".equals(e16)) {
                if (!"4".equals(e16) || (optJSONObject = jSONObject2.optJSONObject(TuxTimeView.TUX_TIME_STYLE)) == null) {
                    return;
                }
                long serverTime = NetConnInfoCenter.getServerTime();
                long optLong = optJSONObject.optLong("online_ts", 0L);
                long optLong2 = optJSONObject.optLong("count_down_sec", 0L);
                QLog.i("GeneralKuiklyCardView", 1, "genCustomData currTime=" + serverTime + ",onlineTime=" + optLong + ",countDownSec=" + optLong2);
                if (serverTime > 0 && optLong > serverTime) {
                    long j3 = optLong - serverTime;
                    optLong2 = Math.min(optLong2, j3);
                    QLog.i("GeneralKuiklyCardView", 1, "genCustomData tempTime=" + j3 + ",countDownSec=" + optLong2);
                }
                jSONObject.put("countDownTime", optLong2);
                jSONObject.put("countDownText", optJSONObject.optString("text", ""));
                jSONObject.put("onlineTime", optJSONObject.optLong("online_ts", 0L));
                return;
            }
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("icon_style");
            if (optJSONObject2 == null) {
                return;
            }
            jSONObject.put("subTitleFull", optJSONObject2.optString("text", v3));
            jSONObject.put("subTitleLight", optJSONObject2.optString("highlight_text", ""));
            JSONArray optJSONArray = optJSONObject2.optJSONArray("icons");
            if (optJSONArray != null && optJSONArray.length() >= 1) {
                jSONObject.put("subIcons", optJSONArray.toString());
            }
        } catch (JSONException e17) {
            QLog.e("GeneralKuiklyCardView", 1, "genCustomData exception", e17);
        }
    }

    public GeneralKuiklyCardView(Context context, AttributeSet attributeSet) {
        super(context);
        this.C = null;
        this.D = new a();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
    }
}
