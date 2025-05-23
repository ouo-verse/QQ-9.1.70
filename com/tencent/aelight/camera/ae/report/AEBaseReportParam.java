package com.tencent.aelight.camera.ae.report;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.maxvideo.MaxVideoConst;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.o;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.g;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.report.capability.decode.TVKDeviceDecodeCapabilityReportConstant;
import com.tencent.qqlive.tvkplayer.report.capability.postprocess.TVKDevicePostProcessCapabilityReportConstant;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class AEBaseReportParam {
    private static Long S = -1L;
    public static final Long T = -1L;
    public static final Long U = 1L;
    public static final Long V = 2L;
    public static final Long W = 3L;
    public static final Long X = 4L;
    public static final Long Y = 5L;
    public static final Long Z = 6L;
    private boolean F;

    /* renamed from: b, reason: collision with root package name */
    private String f65676b;

    /* renamed from: d, reason: collision with root package name */
    private String f65678d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f65679e;

    /* renamed from: g, reason: collision with root package name */
    private String f65681g;

    /* renamed from: j, reason: collision with root package name */
    private int f65684j;

    /* renamed from: k, reason: collision with root package name */
    private long f65685k;

    /* renamed from: o, reason: collision with root package name */
    public String f65689o;

    /* renamed from: p, reason: collision with root package name */
    public String f65690p;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f65675a = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private boolean f65677c = false;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, String> f65680f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private String f65682h = "";

    /* renamed from: i, reason: collision with root package name */
    private int f65683i = -1;

    /* renamed from: l, reason: collision with root package name */
    private long f65686l = -1;

    /* renamed from: m, reason: collision with root package name */
    private String f65687m = "none";

    /* renamed from: n, reason: collision with root package name */
    private String f65688n = "none";

    /* renamed from: q, reason: collision with root package name */
    private int f65691q = -1;

    /* renamed from: r, reason: collision with root package name */
    private String f65692r = "-1";

    /* renamed from: s, reason: collision with root package name */
    private String f65693s = "none";

    /* renamed from: t, reason: collision with root package name */
    private int f65694t = 0;

    /* renamed from: u, reason: collision with root package name */
    private int f65695u = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f65696v = 0;

    /* renamed from: w, reason: collision with root package name */
    private f f65697w = new f();

    /* renamed from: x, reason: collision with root package name */
    private int f65698x = -1;

    /* renamed from: y, reason: collision with root package name */
    private String f65699y = "none";

    /* renamed from: z, reason: collision with root package name */
    private String f65700z = null;
    private String A = null;
    private long B = 0;
    private long C = 0;
    private long D = 0;
    private long E = 0;
    private boolean G = true;
    private long H = -1;
    private long I = -1;
    private String J = "none";
    private long K = 0;
    private long L = 1;
    private long M = 1;
    private String N = "none";
    private String O = "none";
    private String P = TipsElementData.DEFAULT_COLOR;
    private String Q = "";
    private String R = "none";

    /* loaded from: classes32.dex */
    @interface EditPicFrom {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static AEBaseReportParam f65701a = new AEBaseReportParam();
    }

    AEBaseReportParam() {
    }

    private HashMap<String, String> E(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>(6);
        hashMap.put("face_id", str);
        hashMap.put("face_tab", this.f65693s);
        hashMap.put("face_type", this.f65698x + "");
        hashMap.put("face_index", String.valueOf(this.f65691q));
        hashMap.put("face_from", str2);
        hashMap.put("face_uin", str + o.b());
        w0(hashMap);
        return hashMap;
    }

    public static AEBaseReportParam U() {
        return a.f65701a;
    }

    private HashMap<String, String> f0(String str, int i3, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        int i16 = this.f65698x;
        if (i16 != 4 && i16 != 5 && i16 != 6 && i16 != 7 && i16 != 2) {
            hashMap.put("face_id", this.f65687m);
        } else {
            hashMap.put("face_id", this.f65688n);
        }
        w0(hashMap);
        hashMap.put("content_type", S.toString());
        hashMap.put(KeyPropertiesCompact.DIGEST_MD5, str);
        String format = new DecimalFormat("0.00").format(this.f65694t / 100.0f);
        String format2 = new DecimalFormat("0.00").format(this.f65695u / 100.0f);
        hashMap.put("beauty_value", format);
        hashMap.put("facial_value", format2);
        if (!TextUtils.isEmpty(this.f65678d)) {
            hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, this.f65678d);
        } else {
            hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, "none");
        }
        hashMap.put("duration", "" + this.f65685k);
        hashMap.put("cameraId", c.b(AECameraConstants.sCurrentCamera));
        if (S.longValue() == 1) {
            hashMap.put("resolution", AEDashboardUtil.f62611d.e());
        } else if (S.longValue() == 2) {
            hashMap.put("resolution", AEDashboardUtil.f62611d.j());
        } else {
            hashMap.put("resolution", "none");
        }
        hashMap.put("pic_from", this.f65684j + "");
        hashMap.put(TVKDevicePostProcessCapabilityReportConstant.POST_PROCESS_TYPE, String.valueOf(i3));
        hashMap.put("receive_type", str2);
        hashMap.put("face_index", String.valueOf(this.f65691q));
        hashMap.put("face_from", this.f65692r);
        hashMap.put("face_tab", this.f65693s);
        hashMap.put("face_type", this.f65698x + "");
        int i17 = this.f65698x;
        if (i17 != 4 && i17 != 5 && i17 != 6 && i17 != 7) {
            hashMap.put("face_uin", this.f65687m + o.b());
        } else {
            hashMap.put("face_uin", this.f65688n + o.b());
        }
        String jSONObject = new JSONObject(this.f65680f).toString();
        QLog.d("AEBaseReportParam", 1, "getPostBtnParam---editJsonStr=" + jSONObject);
        hashMap.put("edit_json", jSONObject);
        return hashMap;
    }

    private long k0() {
        return System.currentTimeMillis() - this.f65686l;
    }

    public int A() {
        return this.f65691q;
    }

    public void A0(String str) {
        this.f65682h = str;
    }

    public HashMap<String, String> B(String str) {
        return E(str, this.f65692r);
    }

    public void B0(int i3) {
        this.f65683i = i3;
    }

    public HashMap<String, String> C(String str) {
        HashMap<String, String> hashMap = new HashMap<>(2);
        hashMap.put("face_id", str);
        hashMap.put("face_uin", str + o.b());
        return hashMap;
    }

    public void C0(int i3) {
        this.f65694t = i3;
    }

    public HashMap<String, String> D(String str, String str2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>(2);
        hashMap.put("face_id", str);
        hashMap.put("face_uin", str + o.b());
        hashMap.put("sys_race_id", str2);
        hashMap.put("sys_race_level", str3);
        return hashMap;
    }

    public void D0(long j3) {
        S = Long.valueOf(j3);
    }

    public void E0(int i3) {
        QLog.d("AEBaseReportParam", 4, "[setDeviceLevel] level= " + i3);
        this.f65675a.put("device_level", "" + i3);
    }

    public String F() {
        return this.f65693s;
    }

    public void F0(boolean z16) {
        ms.a.a("AEBaseReportParam", "EditJson--enhanced=" + z16);
        if (z16) {
            this.f65680f.put("is_enhance", "1");
        } else {
            this.f65680f.remove("is_enhance");
        }
    }

    public HashMap<String, String> G(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, "none");
        } else {
            hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, str);
        }
        return hashMap;
    }

    public void G0(boolean z16) {
        ms.a.a("AEBaseReportParam", "EditJson--HasCut=" + z16);
        if (z16) {
            this.f65680f.put("cut", "1");
        } else {
            this.f65680f.remove("cut");
        }
    }

    public HashMap<String, String> H(boolean z16) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("base_res_ready", str);
        return hashMap;
    }

    public void H0(String str) {
        ms.a.a("AEBaseReportParam", "EditJson--music=" + str);
        if (!TextUtils.isEmpty(str)) {
            this.f65680f.put("music", str);
        } else {
            this.f65680f.remove("music");
        }
    }

    public HashMap<String, String> I(String str, boolean z16, float f16, double d16, double d17, String str2) {
        String str3;
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        hashMap.put("cameraId", str3);
        hashMap.put(TVKDeviceDecodeCapabilityReportConstant.DECODING_CAPABILITY_PARAM_FRAME_RATE, String.format("%.2f", Float.valueOf(f16)));
        hashMap.put("face_id", str);
        return hashMap;
    }

    public void I0(int i3) {
        this.f65684j = i3;
    }

    public HashMap<String, String> J() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("duration", c.e(Long.valueOf(this.K)));
        hashMap.put("cutout_type", Long.toString(this.L));
        hashMap.put("countdown_type", Long.toString(this.M));
        String format = new DecimalFormat("0.00").format(this.f65694t / 100.0f);
        String format2 = new DecimalFormat("0.00").format(this.f65695u / 100.0f);
        hashMap.put("beauty_value", format);
        hashMap.put("facial_value", format2);
        QIMFilterCategoryItem i3 = m.n().i(0);
        if (i3 != null) {
            this.N = i3.f66697d;
        } else {
            this.N = "none";
        }
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, this.N);
        hashMap.put("cameraId", c.b(AECameraConstants.sCurrentCamera));
        hashMap.put("emoticon_id", this.J);
        if (TextUtils.isEmpty(this.R)) {
            hashMap.put("emo_sort_id", "none");
        } else {
            hashMap.put("emo_sort_id", this.R);
        }
        return hashMap;
    }

    public void J0(boolean z16) {
        ms.a.a("AEBaseReportParam", "EditJson--speedChanged=" + z16);
        if (z16) {
            this.f65680f.put("swipe", "1");
        } else {
            this.f65680f.remove("swipe");
        }
    }

    public HashMap<String, String> K() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("emoticon_id", this.J);
        if (TextUtils.isEmpty(this.R)) {
            hashMap.put("emo_sort_id", "none");
        } else {
            hashMap.put("emo_sort_id", this.R);
        }
        return hashMap;
    }

    public void K0(String str) {
        ms.a.a("AEBaseReportParam", "EditJson--sticker=" + str);
        if (!TextUtils.isEmpty(str)) {
            this.f65680f.put("sticker", str);
        } else {
            this.f65680f.remove("sticker");
        }
    }

    public HashMap<String, String> L() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("duration", c.e(Long.valueOf(this.K)));
        hashMap.put("cutout_type", Long.toString(this.L));
        hashMap.put("countdown_type", Long.toString(this.M));
        String format = new DecimalFormat("0.00").format(this.f65694t / 100.0f);
        String format2 = new DecimalFormat("0.00").format(this.f65695u / 100.0f);
        hashMap.put("beauty_value", format);
        hashMap.put("facial_value", format2);
        hashMap.put("cameraId", c.b(AECameraConstants.sCurrentCamera));
        hashMap.put("emoticon_id", this.J);
        hashMap.put("text_content", this.O);
        if (this.O.equals("none")) {
            hashMap.put("text_color", "none");
        } else {
            hashMap.put("text_color", this.P);
        }
        QIMFilterCategoryItem i3 = m.n().i(0);
        if (i3 != null) {
            this.N = i3.f66697d;
        } else {
            this.N = "none";
        }
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, this.N);
        if (this.Q.equals("")) {
            e1();
        }
        hashMap.put(KeyPropertiesCompact.DIGEST_MD5, this.Q);
        if (TextUtils.isEmpty(this.R)) {
            hashMap.put("emo_sort_id", "none");
        } else {
            hashMap.put("emo_sort_id", this.R);
        }
        return hashMap;
    }

    public void L0(String str) {
        ms.a.a("AEBaseReportParam", "EditJson--text=" + str);
        if (!TextUtils.isEmpty(str)) {
            this.f65680f.put("text", str);
        } else {
            this.f65680f.remove("text");
        }
    }

    public HashMap<String, String> M() {
        long currentTimeMillis = System.currentTimeMillis() - this.I;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("duration", c.e(Long.valueOf(currentTimeMillis)));
        return hashMap;
    }

    public void M0(String str) {
        this.R = str;
    }

    public HashMap<String, String> N(int i3, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("emoticon_id", str);
        hashMap.put("emo_num", String.valueOf(i3));
        if (TextUtils.isEmpty(this.R)) {
            hashMap.put("emo_sort_id", "none");
        } else {
            hashMap.put("emo_sort_id", this.R);
        }
        return hashMap;
    }

    public void N0(String str) {
        this.J = str;
    }

    public boolean O() {
        return this.f65679e;
    }

    public void O0(int i3, String str) {
        this.f65675a.put("op_in", String.valueOf(i3));
        if (str != null && !TextUtils.isEmpty(str)) {
            this.f65675a.put("activity_id", str);
        } else {
            this.f65675a.put("activity_id", "none");
        }
    }

    public HashMap<String, String> P() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(this.R)) {
            hashMap.put("emo_sort_id", "none");
        } else {
            hashMap.put("emo_sort_id", this.R);
        }
        return hashMap;
    }

    public void P0(String str) {
        QLog.d("AEBaseReportParam", 4, "[setExperimentID] experimentID = " + str);
        if (str != null && !TextUtils.isEmpty(str)) {
            this.f65675a.put("expirement_id", str);
        } else {
            this.f65675a.put("expirement_id", "none");
        }
    }

    public HashMap<String, String> Q() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("emoticon_id", this.J);
        return hashMap;
    }

    public void Q0(String str) {
        this.f65692r = str;
    }

    public HashMap<String, String> R(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("emoticon_id", this.J);
        if (TextUtils.isEmpty(str)) {
            hashMap.put("word_source", "none");
        } else {
            hashMap.put("word_source", str);
        }
        return hashMap;
    }

    public void R0(int i3) {
        this.f65691q = i3;
    }

    public HashMap<String, String> S() {
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("face_id", AECameraPrefsUtil.f().j(AECameraConstants.CAMERA_AD_OP_ID, "", 4));
        return hashMap;
    }

    public void S0(String str) {
        this.f65693s = str;
    }

    public HashMap<String, String> T(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("content_type", this.f65697w.f65729u + "");
        hashMap.put(KeyPropertiesCompact.DIGEST_MD5, this.f65697w.f65712d);
        hashMap.put("pic_count", i3 + "");
        if (Z.equals(Long.valueOf(this.f65697w.f65729u))) {
            hashMap.put("video_num", this.f65697w.f65730v + "");
            hashMap.put("video_duration", this.f65697w.f65731w + "");
        }
        return hashMap;
    }

    public void T0(int i3) {
        this.f65698x = i3;
    }

    public void U0(String str) {
        this.f65678d = str;
    }

    public boolean V() {
        return this.f65677c;
    }

    public void V0(long j3) {
        this.K = j3;
    }

    public HashMap<String, String> W() {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("duration_first_frame", c.e(Long.valueOf(this.C - this.B)));
        hashMap.put("duration_bottom_bar", c.e(Long.valueOf(this.D - this.B)));
        hashMap.put("duration_photo_btn", c.e(Long.valueOf(this.E - this.B)));
        if (c.d()) {
            str = "first_launch";
        } else if (this.F) {
            str = StartupReportKey.COLD_LAUNCH;
        } else {
            str = "warm_launch";
        }
        hashMap.put("launch_type", str);
        return hashMap;
    }

    public String X() {
        if (this.f65676b == null) {
            this.f65676b = "none";
        }
        StringBuilder sb5 = new StringBuilder(this.f65676b);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
        sb5.append(" ");
        sb5.append(format);
        return g.d(sb5.toString());
    }

    public HashMap<String, String> Y(String str, int i3, long j3, long j16, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("material_id", str);
        hashMap.put("ret", String.valueOf(i3));
        hashMap.put("consume_time", String.valueOf(j3));
        hashMap.put("zip_size", String.valueOf(j16));
        hashMap.put(KeyPropertiesCompact.DIGEST_MD5, str2);
        return hashMap;
    }

    public void Y0(String str) {
        this.N = str;
    }

    public HashMap<String, String> Z(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("emoticon_id", str);
        return hashMap;
    }

    public void Z0(String str) {
        this.O = str;
    }

    public void a(String str) {
        String str2 = this.f65681g;
        if (str2 == null || str2.equals(str)) {
            return;
        }
        this.f65681g = null;
        this.f65675a.put("activity_id", "none");
    }

    public HashMap<String, String> a0(long j3) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        int i3 = this.f65698x;
        if (i3 != 4 && i3 != 5 && i3 != 6 && i3 != 7 && i3 != 2) {
            hashMap.put("face_id", this.f65687m);
        } else {
            hashMap.put("face_id", this.f65688n);
        }
        w0(hashMap);
        hashMap.put("content_type", S.toString());
        String format = new DecimalFormat("0.00").format(this.f65694t / 100.0f);
        String format2 = new DecimalFormat("0.00").format(this.f65695u / 100.0f);
        hashMap.put("beauty_value", format);
        hashMap.put("facial_value", format2);
        String str2 = "none";
        if (!TextUtils.isEmpty(this.f65678d)) {
            hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, this.f65678d);
        } else {
            hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, "none");
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        sb5.append(j3 != -1 ? j3 / 1000 : -1L);
        hashMap.put("duration", sb5.toString());
        hashMap.put("cameraId", c.b(AECameraConstants.sCurrentCamera));
        hashMap.put("face_index", String.valueOf(this.f65691q));
        hashMap.put("face_from", this.f65692r);
        hashMap.put("face_tab", this.f65693s);
        hashMap.put("face_type", this.f65698x + "");
        if (this.f65698x == 7) {
            hashMap.put("face_uin", this.f65688n + o.b());
        } else {
            hashMap.put("face_uin", this.f65687m + o.b());
        }
        AEDashboardUtil.e eVar = AEDashboardUtil.f62611d;
        hashMap.put("preview_view_size", eVar.f());
        hashMap.put("configed_preview_resolution", eVar.d());
        hashMap.put("configed_capture_resolution", eVar.c());
        hashMap.put("render_resolution", eVar.h());
        if (S.longValue() == 1) {
            hashMap.put("resolution", eVar.e());
        } else if (S.longValue() == 2) {
            hashMap.put("resolution", eVar.j());
        } else {
            hashMap.put("resolution", "none");
        }
        if (S.longValue() == 1) {
            if (eVar.f62646p) {
                str = "screenshot";
            } else {
                str = "camera";
            }
            hashMap.put("photo_capture_mode", str);
        } else {
            hashMap.put("photo_capture_mode", "none");
        }
        AEMaterialMetaData J = AEMaterialManager.J();
        if (J != null) {
            str2 = J.f69050id;
        }
        hashMap.put(MaxVideoConst.INTENT_PARAM_WATERMARK_ID, str2);
        hashMap.put("is_ai_btn", U().i() + "");
        hashMap.put("face_info", U().h());
        return hashMap;
    }

    public void a1(boolean z16) {
        this.f65679e = z16;
    }

    public void b() {
        this.f65682h = "";
    }

    public HashMap<String, String> b0() {
        return E(this.f65688n, this.f65692r);
    }

    public void b1(String str) {
        ms.a.a("AEBaseReportParam", "EditJson--graffiti=" + str);
        if (!TextUtils.isEmpty(str)) {
            this.f65680f.put("graffiti", str);
        } else {
            this.f65680f.remove("graffiti");
        }
    }

    public HashMap<String, String> c0(String str) {
        return E(str, "3");
    }

    public HashMap<String, String> d0() {
        String str;
        if (TextUtils.isEmpty(this.A)) {
            str = MD5Utils.toMD5(QQStoryContext.a().getAccount() + c.a());
        } else {
            str = this.A;
        }
        return f0(str, 1, "-1");
    }

    public void d1(boolean z16) {
        this.f65677c = z16;
    }

    public void e1() {
        StringBuilder sb5 = new StringBuilder(this.f65676b);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date());
        sb5.append(" ");
        sb5.append(format);
        this.Q = g.d(sb5.toString());
    }

    public f f() {
        return this.f65697w;
    }

    public void f1(String str) {
        ms.a.a("AEBaseReportParam", "EditJson--mark=" + str);
        if (!TextUtils.isEmpty(str)) {
            this.f65680f.put("mark", str);
        } else {
            this.f65680f.remove("mark");
        }
    }

    public HashMap<String, String> g(boolean z16, int i3, String str, String str2, long j3, long j16) {
        String str3;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("packageId", String.valueOf(i3));
        String str4 = "0";
        if (!z16) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        hashMap.put("ret_code", str3);
        hashMap.put("packageName", str);
        hashMap.put("packageSubName", str2);
        hashMap.put("cost_time", String.valueOf(j16));
        if (!z16) {
            str4 = String.valueOf(j3);
        }
        hashMap.put("error_code", str4);
        return hashMap;
    }

    public HashMap<String, String> g0() {
        return E(this.f65688n, "3");
    }

    public void g1() {
        int i3 = 1;
        if (!AppNetConnInfo.isWifiConn()) {
            int mobileInfo = AppNetConnInfo.getMobileInfo();
            if (mobileInfo != 0) {
                int i16 = 2;
                if (mobileInfo != 1) {
                    i3 = 3;
                    if (mobileInfo != 2) {
                        i16 = 4;
                        if (mobileInfo != 3) {
                            if (mobileInfo == 4) {
                                i3 = 5;
                            }
                        }
                    }
                }
                i3 = i16;
            }
            i3 = -1;
        }
        this.f65675a.put("network_type", String.valueOf(i3));
        UserAction.setLogAble(false, false);
    }

    public String h() {
        return this.f65682h;
    }

    public HashMap<String, String> h0(String str) {
        return c.g(d0(), E(str, "3"));
    }

    public void h1() {
        String a16 = c.a();
        this.f65675a.put("operation_time", a16);
        ms.a.f("AEBaseReportParam", "\u3010operation_time\u3011:" + a16);
    }

    public int i() {
        return this.f65683i;
    }

    public HashMap<String, String> i0(Long l3) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (l3.longValue() == -1 || l3.longValue() == 3) {
            hashMap.put("receive_type", l3.toString());
        } else if (l3.longValue() != 3000 && l3.longValue() != 1) {
            hashMap.put("receive_type", "1");
        } else {
            hashMap.put("receive_type", "2");
        }
        hashMap.put("content_type", S.toString());
        hashMap.put("face_id", this.f65687m);
        w0(hashMap);
        return hashMap;
    }

    public void i1(String str) {
        this.f65688n = str;
    }

    public HashMap<String, String> j(int i3) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        if (i3 >= 1 && i3 <= 2) {
            str = String.valueOf(i3);
        } else {
            str = "none";
        }
        hashMap.put("api_level", str);
        return hashMap;
    }

    public HashMap<String, String> j0() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("duration", c.e(Long.valueOf(this.K)));
        hashMap.put("cutout_type", Long.toString(this.L));
        hashMap.put("countdown_type", Long.toString(this.M));
        String format = new DecimalFormat("0.00").format(this.f65694t / 100.0f);
        String format2 = new DecimalFormat("0.00").format(this.f65695u / 100.0f);
        hashMap.put("beauty_value", format);
        hashMap.put("facial_value", format2);
        hashMap.put("cameraId", c.b(AECameraConstants.sCurrentCamera));
        hashMap.put("text_content", this.O);
        if (!hashMap.containsKey("emoticon_id")) {
            hashMap.put("emoticon_id", this.J);
        }
        QIMFilterCategoryItem i3 = m.n().i(0);
        if (i3 != null) {
            this.N = i3.f66697d;
        } else {
            this.N = "none";
        }
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, this.N);
        if (!hashMap.containsKey("text_color")) {
            if (this.O.equals("none")) {
                hashMap.put("text_color", "none");
            } else {
                hashMap.put("text_color", this.P);
            }
        }
        if (this.Q.equals("")) {
            e1();
        }
        hashMap.put(KeyPropertiesCompact.DIGEST_MD5, this.Q);
        if (TextUtils.isEmpty(this.R)) {
            hashMap.put("emo_sort_id", "none");
        } else {
            hashMap.put("emo_sort_id", this.R);
        }
        return hashMap;
    }

    public void j1(String str) {
        this.f65675a.put(QCircleSchemeAttr.Detail.RECOM_REASON, str);
        ms.a.f("AEBaseReportParam", " \u3010recom_reason\u3011:" + str);
    }

    public HashMap<String, String> k(int i3, String str, String str2, int i16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ret_code", "" + i3);
        hashMap.put("req_cost", str);
        hashMap.put("cmd_id", str2);
        hashMap.put("res_code", String.valueOf(i16));
        return hashMap;
    }

    public HashMap<String, String> l() {
        HashMap<String, String> hashMap = new HashMap<>(2);
        hashMap.put("face_id", this.f65687m);
        hashMap.put("is_sort_icon", this.f65696v + "");
        w0(hashMap);
        return hashMap;
    }

    public HashMap<String, String> l0() {
        return E(this.f65688n, this.f65692r);
    }

    public void l1(int i3) {
        this.f65695u = i3;
    }

    public HashMap<String, String> m(long j3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("duration", c.e(Long.valueOf(j3)));
        return hashMap;
    }

    public HashMap<String, String> m0(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("text_content", str);
        Z0(str);
        return hashMap;
    }

    public void m1() {
        this.f65686l = System.currentTimeMillis();
    }

    public HashMap<String, String> n(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pic_scale", String.valueOf(i3));
        return hashMap;
    }

    public HashMap<String, String> n0() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("content_type", S.toString());
        return hashMap;
    }

    public void n1(String str) {
        this.f65689o = str;
    }

    public HashMap<String, String> o() {
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("face_id", this.f65687m);
        w0(hashMap);
        return hashMap;
    }

    public String o0() {
        return this.f65687m;
    }

    public void o1(String str) {
        this.f65690p = str;
    }

    public HashMap<String, String> p(LocalMediaInfo localMediaInfo) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("originVideoWidth", String.valueOf(localMediaInfo.mediaOriginWidth));
        hashMap.put("originVideoHeight", String.valueOf(localMediaInfo.mediaOriginHeight));
        hashMap.put("originVideoBitRate", String.valueOf(localMediaInfo.mediaOriginBitrate));
        hashMap.put("originVideoSize", String.valueOf(localMediaInfo.mediaOriginSize));
        hashMap.put("exportVideoWidth", String.valueOf(localMediaInfo.mediaWidth));
        hashMap.put("exportVideoHeight", String.valueOf(localMediaInfo.mediaHeight));
        hashMap.put("exportVideoBitRate", String.valueOf(localMediaInfo.mediaBitrate));
        hashMap.put("exportVideoDuration", String.valueOf(localMediaInfo.mDuration));
        return hashMap;
    }

    public HashMap<String, String> p0(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(MaxVideoConst.INTENT_PARAM_WATERMARK_ID, str);
        return hashMap;
    }

    public void p1(String str) {
        QLog.d("AEBaseReportParam", 4, "[setTabExperimentID] experimentID = " + str);
        if (TextUtils.isEmpty(str)) {
            this.f65675a.put("tab_expirement_id", "none");
        } else {
            this.f65675a.put("tab_expirement_id", str);
        }
    }

    public HashMap<String, String> q(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, str);
        return hashMap;
    }

    public HashMap<String, String> q0(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("gps", str);
        return hashMap;
    }

    public void q1(int i3) {
        this.f65696v = i3;
    }

    public HashMap<String, String> r() {
        this.f65675a.put("cameraId", c.b(AECameraConstants.sCurrentCamera));
        return this.f65675a;
    }

    public boolean r0() {
        long j3 = this.B;
        if (j3 > 0) {
            long j16 = this.C;
            if (j16 > 0) {
                long j17 = this.D;
                if (j17 > 0) {
                    long j18 = this.E;
                    return j18 > 0 && j16 - j3 <= 120000 && j17 - j3 <= 120000 && j18 - j3 <= 120000;
                }
            }
        }
        return false;
    }

    public void r1(String str) {
        this.P = str;
    }

    public long s() {
        return S.longValue();
    }

    public void s0() {
        if (this.D == 0) {
            this.D = System.currentTimeMillis();
        }
    }

    public void s1(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f65676b = str;
        } else {
            this.f65676b = "none";
        }
        this.f65675a.put("fromuin", this.f65676b);
    }

    public HashMap<String, String> t() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("face_id", this.f65687m);
        hashMap.put("face_tab", this.f65693s);
        hashMap.put("face_index", String.valueOf(this.f65691q));
        hashMap.put("face_uin", this.f65699y);
        w0(hashMap);
        hashMap.put("pic_from", this.f65684j + "");
        String jSONObject = new JSONObject(this.f65680f).toString();
        QLog.d("AEBaseReportParam", 1, "getDownloadBtnParam---editJsonStr=" + jSONObject);
        hashMap.put("edit_json", jSONObject);
        return hashMap;
    }

    public void t0() {
        if (this.C == 0) {
            this.C = System.currentTimeMillis();
        }
    }

    public void t1(long j3) {
        this.f65685k = j3;
    }

    public HashMap<String, String> u() {
        HashMap<String, String> d06 = U().d0();
        if (d06 != null) {
            d06.remove("edit_json");
        }
        return d06;
    }

    public void u0(long j3) {
        y0();
        this.B = j3;
        this.F = this.G;
        this.G = false;
    }

    public void u1(String str) {
        this.f65687m = str;
    }

    public HashMap<String, String> v() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("duration", c.e(Long.valueOf(k0())));
        return hashMap;
    }

    public void v0() {
        if (this.E == 0) {
            this.E = System.currentTimeMillis();
        }
    }

    public void v1() {
        this.I = System.currentTimeMillis();
    }

    public HashMap<String, String> w() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("content_type", S.toString());
        hashMap.put("pic_from", this.f65684j + "");
        return hashMap;
    }

    public void w0(Map<String, String> map) {
        map.put("sys_race_id", this.f65689o);
        map.put("sys_race_level", this.f65690p);
    }

    public HashMap<String, String> x(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, str);
        return hashMap;
    }

    public void x0() {
        ms.a.a("AEBaseReportParam", "EditJson--resetEditInfo");
        this.f65680f.clear();
    }

    public HashMap<String, String> y(long j3) {
        HashMap<String, String> hashMap = new HashMap<>();
        int i3 = this.f65698x;
        if (i3 != 4 && i3 != 5 && i3 != 6 && i3 != 7 && i3 != 2) {
            hashMap.put("face_id", this.f65687m);
        } else {
            hashMap.put("face_id", this.f65688n);
        }
        hashMap.put("content_type", S.toString());
        String format = new DecimalFormat("0.00").format(this.f65694t / 100.0f);
        String format2 = new DecimalFormat("0.00").format(this.f65695u / 100.0f);
        hashMap.put("beauty_value", format);
        hashMap.put("facial_value", format2);
        if (!TextUtils.isEmpty(this.f65678d)) {
            hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, this.f65678d);
        } else {
            hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, "none");
        }
        hashMap.put("duration", c.e(Long.valueOf(System.currentTimeMillis() - j3)));
        hashMap.put("cameraId", c.b(AECameraConstants.sCurrentCamera));
        if (S.longValue() == 1) {
            hashMap.put("resolution", AEDashboardUtil.f62611d.e());
        } else if (S.longValue() == 2) {
            hashMap.put("resolution", AEDashboardUtil.f62611d.j());
        } else {
            hashMap.put("resolution", "none");
        }
        return hashMap;
    }

    public HashMap<String, String> z() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("face_id", this.f65687m);
        return hashMap;
    }

    public void z0(String str, String str2) {
        this.f65681g = str;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            this.f65675a.put("activity_id", str2);
        } else {
            this.f65675a.put("activity_id", "none");
        }
    }

    public void c() {
        this.f65684j = 0;
    }

    public void e() {
        this.f65700z = null;
        this.A = null;
    }

    public void c1(boolean z16) {
        if (z16) {
            return;
        }
        this.f65675a.put("is_debug", "1");
    }

    public void d() {
        this.L = 1L;
        this.M = 1L;
    }

    public void y0() {
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = false;
    }

    public HashMap<String, String> e0(String str, int i3) {
        String str2;
        if (i3 == 1) {
            str2 = "2";
        } else if (i3 == 0) {
            str2 = "1";
        } else {
            str2 = "3";
        }
        String str3 = this.f65700z;
        if (str3 == null || !str3.equals(str)) {
            this.f65700z = str;
            this.A = MD5Utils.toMD5(QQStoryContext.a().getAccount() + c.a());
        }
        return f0(str, 2, str2);
    }

    public void W0(boolean z16) {
        if (z16) {
            this.M = 2L;
        } else {
            this.M = 1L;
        }
    }

    public void X0(boolean z16) {
        if (z16) {
            this.L = 2L;
        } else {
            this.L = 1L;
        }
    }

    public void k1(int i3) {
        if (i3 > 3 || i3 < -1) {
            i3 = -1;
        }
        this.f65675a.put("sex", "" + i3);
    }
}
