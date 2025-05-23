package com.tencent.aelight.camera.ae.report;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBodyProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEFilterProviderView;
import com.tencent.aelight.camera.ae.camera.ui.panel.aa;
import com.tencent.aelight.camera.ae.camera.ui.panel.bj;
import com.tencent.aelight.camera.ae.n;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static e f65707b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f65708a;

    public static e b() {
        if (f65707b == null) {
            f65707b = new e();
        }
        return f65707b;
    }

    private void c(AEBeautyProviderViewModel aEBeautyProviderViewModel, Map<String, String> map) {
        map.put("is_ai_btn", "" + AEBaseReportParam.U().i());
        map.put("face_info", "" + AEBaseReportParam.U().h());
        if (aEBeautyProviderViewModel != null) {
            JSONObject jSONObject = new JSONObject();
            for (com.tencent.aelight.camera.ae.camera.ui.panel.b bVar : aEBeautyProviderViewModel.c2()) {
                String key = bVar.getKey();
                com.tencent.aelight.camera.ae.camera.ui.panel.f D2 = AEProviderViewModel.D2(bVar);
                if (D2 != null) {
                    key = key + "_" + D2.getName();
                }
                try {
                    jSONObject.put(key, "" + AEProviderViewModel.t2(bVar));
                } catch (Exception unused) {
                }
            }
            map.put("beauty_params", jSONObject.toString());
        }
    }

    private void h(Map<String, String> map) {
        String L = DYAEFilterProviderView.L();
        if (L != null) {
            int w26 = AEProviderViewModel.w2(L);
            map.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, L);
            map.put("filter_value", String.valueOf(w26));
        }
    }

    private void i(Map<String, String> map) {
        map.put("face_id", AEBaseReportParam.U().o0());
        AEBaseReportParam.U().w0(map);
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        if (AEDashboardUtil.q()) {
            Map<String, String> map = this.f65708a;
            if (map != null) {
                hashMap.putAll(map);
            }
            h(hashMap);
        }
        return hashMap;
    }

    public void e(AEPituCameraUnit aEPituCameraUnit) {
        HashMap hashMap = new HashMap();
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, "none");
        hashMap.put("filter_value", "-1");
        hashMap.put("makeup_name", "none");
        hashMap.put("makeup_value", "-1");
        h(hashMap);
        g((aa) n.a(aEPituCameraUnit).get(aa.class), hashMap);
        c((AEBeautyProviderViewModel) n.a(aEPituCameraUnit).get(AEBeautyProviderViewModel.class), hashMap);
        d((AEBodyProviderViewModel) n.a(aEPituCameraUnit).get(AEBodyProviderViewModel.class), hashMap);
        i(hashMap);
        this.f65708a = hashMap;
    }

    public void f(AEPituCameraUnit aEPituCameraUnit, long j3) {
        String str;
        b().e(aEPituCameraUnit);
        long s16 = AEBaseReportParam.U().s();
        this.f65708a.put("content_type", "" + s16);
        Map<String, String> map = this.f65708a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        sb5.append(j3 != -1 ? j3 / 1000 : -1L);
        map.put("duration", sb5.toString());
        this.f65708a.put("face_index", "" + AEBaseReportParam.U().A());
        this.f65708a.put("face_tab", "" + AEBaseReportParam.U().F());
        if (s16 == 1) {
            Map<String, String> map2 = this.f65708a;
            if (AEDashboardUtil.f62611d.f62646p) {
                str = "screenshot";
            } else {
                str = "camera";
            }
            map2.put("photo_capture_mode", str);
        } else {
            this.f65708a.put("photo_capture_mode", "none");
        }
        if (s16 == 1) {
            this.f65708a.put("resolution", AEDashboardUtil.f62611d.e());
        } else if (s16 == 2) {
            this.f65708a.put("resolution", AEDashboardUtil.f62611d.j());
        } else {
            this.f65708a.put("resolution", "none");
        }
    }

    private void d(AEBodyProviderViewModel aEBodyProviderViewModel, Map<String, String> map) {
        if (aEBodyProviderViewModel != null) {
            JSONObject jSONObject = new JSONObject();
            for (com.tencent.aelight.camera.ae.camera.ui.panel.b bVar : aEBodyProviderViewModel.W1()) {
                try {
                    jSONObject.put(bVar.getKey(), "" + AEProviderViewModel.t2(bVar));
                } catch (Exception unused) {
                }
            }
            map.put("body_params", jSONObject.toString());
        }
    }

    private void g(aa aaVar, Map<String, String> map) {
        bj value;
        if (aaVar == null || (value = aaVar.N1().getValue()) == null || TextUtils.isEmpty(value.getName())) {
            return;
        }
        map.put("makeup_name", value.getName());
        map.put("makeup_value", "" + AEProviderViewModel.t2(value));
    }
}
