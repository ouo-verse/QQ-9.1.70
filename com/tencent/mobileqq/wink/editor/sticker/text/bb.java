package com.tencent.mobileqq.wink.editor.sticker.text;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContent;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContentWrapper;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes21.dex */
public class bb extends BaseViewModel {

    /* renamed from: n0, reason: collision with root package name */
    private static final String f322030n0 = "bb";

    /* renamed from: o0, reason: collision with root package name */
    public static final String f322031o0 = RFWApplication.getApplication().getString(R.string.yma);

    /* renamed from: p0, reason: collision with root package name */
    public static final int f322032p0;

    /* renamed from: q0, reason: collision with root package name */
    public static final int f322033q0;

    /* renamed from: r0, reason: collision with root package name */
    public static final List<Integer> f322034r0;

    /* renamed from: s0, reason: collision with root package name */
    public static final List<Integer> f322035s0;

    /* renamed from: t0, reason: collision with root package name */
    private static final List<String> f322036t0;
    private final MutableLiveData<List<MetaMaterial>> C;
    private final MutableLiveData<MetaMaterial> D;
    private final MutableLiveData<Integer> E;
    private final MutableLiveData<Integer> F;
    private final MutableLiveData<Integer> G;
    private final MutableLiveData<Integer> H;
    private final MutableLiveData<Pair<WinkStickerModel, Integer>> I;
    private final MutableLiveData<WinkStickerModel> J;
    private final MutableLiveData<MetaMaterial> K;
    private final MutableLiveData<Map<WinkStickerModel, MetaMaterial>> M;
    protected List<MetaMaterial> N;
    private final List<MetaMaterial> P;
    private final List<MetaMaterial> Q;
    private final List<MetaMaterial> R;
    private String S;
    private String T;
    private MetaMaterial U;

    @Nullable
    private WinkStickerModel V;

    @Nullable
    private WinkStickerModel W;
    private Map<String, WinkStickerModel> X;
    private Map<String, WinkStickerModel> Y;

    /* renamed from: d0, reason: collision with root package name */
    private String f322040d0;

    /* renamed from: f0, reason: collision with root package name */
    private String f322042f0;

    /* renamed from: h0, reason: collision with root package name */
    private String f322044h0;

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<String> f322045i;

    /* renamed from: k0, reason: collision with root package name */
    private MetaMaterialContentWrapper f322048k0;

    /* renamed from: l0, reason: collision with root package name */
    private Boolean f322049l0;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<List<MetaMaterial>> f322050m;

    /* renamed from: m0, reason: collision with root package name */
    private Boolean f322051m0;
    private final MutableLiveData<t73.a<Pair<String, Boolean>>> L = new MutableLiveData<>();
    private int Z = Color.parseColor("#EFEFEF");

    /* renamed from: a0, reason: collision with root package name */
    public int f322037a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    public int f322038b0 = -1;

    /* renamed from: c0, reason: collision with root package name */
    public int f322039c0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    private HashMap<Integer, String> f322041e0 = new HashMap<>();

    /* renamed from: g0, reason: collision with root package name */
    private HashMap<Integer, String> f322043g0 = new HashMap<>();

    /* renamed from: i0, reason: collision with root package name */
    private Float f322046i0 = Float.valueOf(0.0f);

    /* renamed from: j0, reason: collision with root package name */
    private HashMap<Integer, String> f322047j0 = new HashMap<>();

    static {
        int parseColor = Color.parseColor("#000000");
        f322032p0 = parseColor;
        int parseColor2 = Color.parseColor("#EFEFEF");
        f322033q0 = parseColor2;
        f322034r0 = Arrays.asList(Integer.valueOf(parseColor2), Integer.valueOf(Color.parseColor("#9F9F9F")), Integer.valueOf(parseColor), Integer.valueOf(Color.parseColor("#FF5A4D")), Integer.valueOf(Color.parseColor("#FF9243")), Integer.valueOf(Color.parseColor("#FFEE50")), Integer.valueOf(Color.parseColor("#27AA4C")), Integer.valueOf(Color.parseColor("#70D5FB")), Integer.valueOf(Color.parseColor("#5596FF")), Integer.valueOf(Color.parseColor("#8F5BF6")), Integer.valueOf(Color.parseColor("#FF94B9")));
        f322035s0 = Arrays.asList(Integer.valueOf(Color.parseColor("#FFFFFF")), Integer.valueOf(parseColor), Integer.valueOf(Color.parseColor("#FF5A4D")), Integer.valueOf(Color.parseColor("#FF9243")), Integer.valueOf(Color.parseColor("#FFEE50")), Integer.valueOf(Color.parseColor("#75DC5D")), Integer.valueOf(Color.parseColor("#27AA4C")), Integer.valueOf(Color.parseColor("#70D5FB")), Integer.valueOf(Color.parseColor("#5596FF")), Integer.valueOf(Color.parseColor("#8F5BF6")), Integer.valueOf(Color.parseColor("#FF94B9")), Integer.valueOf(Color.parseColor("#9F9F9F")));
        f322036t0 = Arrays.asList("style_renjianmeiwei");
    }

    public bb() {
        Boolean bool = Boolean.FALSE;
        this.f322049l0 = bool;
        this.f322051m0 = bool;
        this.P = new ArrayList();
        this.Q = new ArrayList();
        this.R = new ArrayList();
        this.f322045i = new MutableLiveData<>();
        this.f322050m = new MutableLiveData<>();
        this.C = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>();
        this.H = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
        this.G = new MutableLiveData<>();
        this.J = new MutableLiveData<>();
        this.K = new MutableLiveData<>();
        this.M = new MutableLiveData<>();
        this.I = new MutableLiveData<>();
    }

    private JSONObject A2() {
        JSONObject jSONObject = new JSONObject();
        try {
            return new JSONObject(com.tencent.mobileqq.wink.edit.manager.h.m(u53.f.f438412y));
        } catch (Exception e16) {
            e16.printStackTrace();
            return jSONObject;
        }
    }

    private void B2(String str) {
        String str2;
        MetaMaterial metaMaterial = this.U;
        if (metaMaterial != null) {
            str2 = com.tencent.mobileqq.wink.editor.sticker.m.l(metaMaterial);
        } else {
            str2 = null;
        }
        this.U = com.tencent.mobileqq.wink.editor.sticker.m.a0();
        if (!TextUtils.isEmpty(str2)) {
            com.tencent.mobileqq.wink.editor.sticker.m.n0(this.U, str2);
        }
        w2();
        z2(0);
    }

    private void J2() {
        int i3;
        if (this.U != null) {
            int i16 = this.f322039c0;
            if (i16 != 2 && i16 != 3) {
                if (this.f322051m0.booleanValue()) {
                    i3 = f322035s0.indexOf(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.F(this.U)));
                } else {
                    i3 = f322034r0.indexOf(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.F(this.U)));
                }
            } else if (this.f322051m0.booleanValue()) {
                i3 = f322035s0.indexOf(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.g(this.U)));
            } else {
                i3 = f322034r0.indexOf(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.g(this.U)));
            }
        } else {
            i3 = -1;
        }
        this.f322038b0 = i3;
    }

    private void K2() {
        int i3;
        if ("CATEGORY_TEXT_STYLE".equals(this.S) && this.U != null) {
            int i16 = this.f322039c0;
            if (i16 != 2 && i16 != 3) {
                if (this.f322051m0.booleanValue()) {
                    i3 = f322035s0.indexOf(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.F(this.U)));
                } else {
                    i3 = f322034r0.indexOf(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.F(this.U)));
                }
            } else if (this.f322051m0.booleanValue()) {
                i3 = f322035s0.indexOf(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.g(this.U)));
            } else {
                i3 = f322034r0.indexOf(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.g(this.U)));
            }
        } else {
            i3 = -1;
        }
        this.G.postValue(Integer.valueOf(i3));
    }

    private void L2() {
        String q16 = com.tencent.mobileqq.wink.editor.sticker.m.q(this.U);
        int i3 = 0;
        if (this.P != null) {
            int i16 = 0;
            while (true) {
                if (i16 >= this.P.size()) {
                    break;
                }
                if (q16.equals(com.tencent.mobileqq.wink.editor.sticker.m.q(this.P.get(i16)))) {
                    i3 = i16;
                    break;
                }
                i16++;
            }
        }
        this.f322037a0 = i3;
    }

    private void M2(MetaMaterial metaMaterial, Float f16, Float f17, Float f18, Float f19) {
        com.tencent.mobileqq.wink.editor.sticker.m.k0(metaMaterial, f16.floatValue());
        com.tencent.mobileqq.wink.editor.sticker.m.l0(metaMaterial, f17.floatValue());
        com.tencent.mobileqq.wink.editor.sticker.m.d0(metaMaterial, f18.floatValue());
        com.tencent.mobileqq.wink.editor.sticker.m.G0(metaMaterial, f19.floatValue());
    }

    private void N2(WinkStickerModel winkStickerModel, MetaMaterial metaMaterial) {
        if (winkStickerModel != null && winkStickerModel.getMaterial() != null && winkStickerModel.getMaterial().additionalObjectFields != null) {
            try {
                MetaMaterialContentWrapper metaMaterialContentWrapper = (MetaMaterialContentWrapper) winkStickerModel.getMaterial().additionalObjectFields.get("contents");
                if (metaMaterialContentWrapper != null && metaMaterialContentWrapper.getMetaMaterialContent() != null) {
                    for (int i3 = 0; i3 < metaMaterialContentWrapper.getMetaMaterialContent().size(); i3++) {
                        MetaMaterialContent metaMaterialContent = metaMaterialContentWrapper.getMetaMaterialContent().get(i3);
                        metaMaterialContent.setTextColor(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.F(this.U)));
                        metaMaterialContent.setStrokeColor(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.B(this.U)));
                        metaMaterialContent.setApplyStroke(Boolean.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.e(this.U)));
                        metaMaterialContent.setStokeWidth(Float.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.C(this.U)));
                        metaMaterialContent.setBackgroundAlpha(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.f(this.U)));
                        metaMaterialContent.setBackgroundColor(Integer.valueOf(com.tencent.mobileqq.wink.editor.sticker.m.g(this.U)));
                        metaMaterialContent.setFontFamily(com.tencent.mobileqq.wink.editor.sticker.m.p(this.U));
                        metaMaterialContent.setFontPath(com.tencent.mobileqq.wink.editor.sticker.m.r(this.U));
                    }
                }
            } catch (Exception e16) {
                ms.a.c(f322030n0, "exception:" + e16);
            }
        }
    }

    private void O1() {
        MetaMaterial metaMaterial = this.U;
        if (metaMaterial == null) {
            return;
        }
        String o16 = com.tencent.mobileqq.wink.editor.c.o(metaMaterial);
        int i3 = 0;
        if (!r2(o16, this.S) && (!"CATEGORY_TEXT_STYLE".equals(o16) || !"CATEGORY_TEXT_STYLE".equals(this.S))) {
            if (this.N != null) {
                int i16 = 0;
                while (true) {
                    if (i16 >= this.N.size()) {
                        break;
                    }
                    if (this.N.get(i16) != null && this.U.f30533id.equals(this.N.get(i16).f30533id)) {
                        i3 = i16;
                        break;
                    }
                    i16++;
                }
                this.F.postValue(Integer.valueOf(i3));
                return;
            }
            return;
        }
        String q16 = com.tencent.mobileqq.wink.editor.sticker.m.q(this.U);
        if (this.P != null) {
            int i17 = 0;
            while (true) {
                if (i17 >= this.P.size()) {
                    break;
                }
                if (q16.equals(com.tencent.mobileqq.wink.editor.sticker.m.q(this.P.get(i17)))) {
                    i3 = i17;
                    break;
                }
                i17++;
            }
        }
        this.E.postValue(Integer.valueOf(i3));
    }

    private void O2(@NonNull MetaMaterial metaMaterial) {
        if (!"CATEGORY_TEXT_STYLE".equals(com.tencent.mobileqq.wink.editor.c.o(metaMaterial))) {
            this.U.f30533id = metaMaterial.f30533id;
        }
        MetaMaterial metaMaterial2 = this.U;
        metaMaterial2.packageUrl = metaMaterial.packageUrl;
        metaMaterial2.packageMd5 = metaMaterial.packageMd5;
        com.tencent.mobileqq.wink.editor.sticker.m.v0(metaMaterial2, com.tencent.mobileqq.wink.editor.sticker.m.q(metaMaterial));
        com.tencent.mobileqq.wink.editor.sticker.m.w0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.r(metaMaterial));
        com.tencent.mobileqq.wink.editor.sticker.m.u0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.p(metaMaterial));
        com.tencent.mobileqq.wink.editor.sticker.m.y0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.t(metaMaterial));
        com.tencent.mobileqq.wink.editor.sticker.m.t0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.o(metaMaterial));
        com.tencent.mobileqq.wink.editor.sticker.m.x0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.s(metaMaterial));
        com.tencent.mobileqq.wink.editor.c.A1(this.U, com.tencent.mobileqq.wink.editor.c.Y(metaMaterial));
        String T1 = T1(this.U.f30533id);
        if (t2(T1, com.tencent.mobileqq.wink.editor.c.o(metaMaterial)) || s2(T1, com.tencent.mobileqq.wink.editor.c.o(metaMaterial))) {
            com.tencent.mobileqq.wink.editor.sticker.m.G0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.A(metaMaterial));
        }
        if ("CATEGORY_TEXT_PATTERN".equals(com.tencent.mobileqq.wink.editor.c.o(metaMaterial)) || "CATEGORY_TEXT_DECOR".equals(com.tencent.mobileqq.wink.editor.c.o(metaMaterial))) {
            z2(0);
            com.tencent.mobileqq.wink.editor.c.o1(this.U, com.tencent.mobileqq.wink.editor.c.o(metaMaterial));
            com.tencent.mobileqq.wink.editor.sticker.m.F0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.y(metaMaterial));
            com.tencent.mobileqq.wink.editor.sticker.m.N0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.F(metaMaterial));
            com.tencent.mobileqq.wink.editor.sticker.m.g0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.g(metaMaterial));
            com.tencent.mobileqq.wink.editor.sticker.m.f0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.f(metaMaterial));
            if (com.tencent.mobileqq.wink.editor.c.W0(metaMaterial, "applyStroke")) {
                com.tencent.mobileqq.wink.editor.sticker.m.e0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.e(metaMaterial));
            } else {
                com.tencent.mobileqq.wink.editor.c.l1(this.U, "applyStroke");
            }
            if (com.tencent.mobileqq.wink.editor.c.W0(metaMaterial, "strokeColor")) {
                com.tencent.mobileqq.wink.editor.sticker.m.H0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.B(metaMaterial));
            } else {
                com.tencent.mobileqq.wink.editor.c.l1(this.U, "strokeColor");
            }
            if (com.tencent.mobileqq.wink.editor.c.W0(metaMaterial, "strokeWidth")) {
                com.tencent.mobileqq.wink.editor.sticker.m.I0(this.U, com.tencent.mobileqq.wink.editor.sticker.m.C(metaMaterial));
            } else {
                com.tencent.mobileqq.wink.editor.c.l1(this.U, "strokeWidth");
            }
            int n26 = n2(metaMaterial);
            if (n26 != 0) {
                z2(n26);
            }
        }
        w2();
    }

    private void R1(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(map);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, map);
    }

    private String T1(String str) {
        if (Z1(str, this.P) != null) {
            return "CATEGORY_TEXT_STYLE";
        }
        if (Z1(str, this.Q) != null) {
            return "CATEGORY_TEXT_PATTERN";
        }
        if (Z1(str, this.R) != null) {
            return "CATEGORY_TEXT_DECOR";
        }
        return null;
    }

    private void U2(int i3) {
        if (!f322036t0.contains(this.U.f30533id)) {
            if (i3 == f322033q0) {
                com.tencent.mobileqq.wink.editor.sticker.m.I0(this.U, 10.0f);
            } else {
                com.tencent.mobileqq.wink.editor.sticker.m.I0(this.U, 12.0f);
            }
        }
    }

    private MetaMaterial Z1(String str, List<MetaMaterial> list) {
        int a26;
        if (list == null || (a26 = a2(str, list)) == -1) {
            return null;
        }
        return list.get(a26);
    }

    private int a2(String str, List<MetaMaterial> list) {
        if (list != null && str != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (str.equals(list.get(i3).f30533id)) {
                    return i3;
                }
            }
            return -1;
        }
        return -1;
    }

    private boolean r2(String str, String str2) {
        if (("CATEGORY_TEXT_PATTERN".equals(str) || "CATEGORY_TEXT_DECOR".equals(str)) && "CATEGORY_TEXT_STYLE".equals(str2)) {
            return true;
        }
        return false;
    }

    private boolean s2(String str, String str2) {
        if ("CATEGORY_TEXT_DECOR".equals(str) && !"CATEGORY_TEXT_DECOR".equals(str2)) {
            return true;
        }
        return false;
    }

    private boolean t2(String str, String str2) {
        if (!"CATEGORY_TEXT_DECOR".equals(str) && "CATEGORY_TEXT_DECOR".equals(str2)) {
            return true;
        }
        return false;
    }

    private boolean u2() {
        WinkStickerModel winkStickerModel = this.V;
        if (winkStickerModel != null) {
            return winkStickerModel.isSubtitleSticker();
        }
        return false;
    }

    private void v2(WinkStickerModel winkStickerModel, MetaMaterial metaMaterial) {
        this.J.postValue(com.tencent.mobileqq.wink.editor.sticker.m.b(metaMaterial, winkStickerModel, 0, true, false));
    }

    private void x2(boolean z16) {
        HashMap hashMap = new HashMap();
        for (WinkStickerModel winkStickerModel : this.X.values()) {
            if (winkStickerModel.isSubtitleSticker()) {
                if (z16) {
                    if (winkStickerModel.id == this.V.id) {
                        if (com.tencent.mobileqq.wink.editor.sticker.m.M(this.U)) {
                            MetaMaterialContentWrapper m3 = com.tencent.mobileqq.wink.editor.sticker.m.m(this.U);
                            if (m3 != null && m3.getMetaMaterialContent() != null && m3.getMetaMaterialContent().size() == 2 && m3.getMetaMaterialContent().get(0).getContent() != null && !m3.getMetaMaterialContent().get(0).getContent().isEmpty()) {
                                hashMap.put(winkStickerModel, this.U);
                            }
                        } else {
                            com.tencent.mobileqq.wink.editor.sticker.m.n0(winkStickerModel.getMaterial(), com.tencent.mobileqq.wink.editor.sticker.m.l(this.U));
                            if (!com.tencent.mobileqq.wink.editor.sticker.m.l(this.U).isEmpty()) {
                                hashMap.put(winkStickerModel, this.U);
                            }
                        }
                    } else {
                        hashMap.put(winkStickerModel, this.U);
                    }
                } else {
                    N2(winkStickerModel, this.U);
                    hashMap.put(winkStickerModel, this.U);
                }
            } else {
                hashMap.put(winkStickerModel, null);
            }
        }
        this.M.postValue(hashMap);
        this.J.postValue(this.V);
    }

    public void C2(Boolean bool) {
        this.f322049l0 = bool;
    }

    public void D2(WinkStickerModel winkStickerModel) {
        this.W = winkStickerModel;
    }

    public void E2(int i3) {
        this.Z = i3;
    }

    public void F2(WinkStickerModel winkStickerModel) {
        this.U = winkStickerModel.getMaterial().copy();
        w53.b.a(getLogTag(), "setSticker " + this.U.f30533id);
        this.V = winkStickerModel;
        this.W = winkStickerModel;
    }

    public void G2(@Nullable Map<String, WinkStickerModel> map, @Nullable WinkStickerModel winkStickerModel) {
        if (winkStickerModel == null) {
            winkStickerModel = com.tencent.mobileqq.wink.editor.subtitle.a.f322144a.f(map);
        }
        if (winkStickerModel != null) {
            MetaMaterial copy = winkStickerModel.getMaterial().copy();
            this.U = copy;
            this.V = winkStickerModel;
            this.f322048k0 = com.tencent.mobileqq.wink.editor.sticker.c.f321565a.a(com.tencent.mobileqq.wink.editor.sticker.m.m(copy));
        }
        this.Y = map;
        this.X = new HashMap();
        if (map != null) {
            for (WinkStickerModel winkStickerModel2 : map.values()) {
                this.X.put(winkStickerModel2.id, winkStickerModel2.copy());
            }
        }
        w2();
    }

    public void H2(List<MetaCategory> list) {
        if (list.size() >= 3) {
            if (list.get(0).materials != null) {
                this.P.clear();
                this.P.addAll(com.tencent.mobileqq.wink.editor.sticker.m.L("CATEGORY_TEXT_STYLE", list.get(0).materials));
                this.P.add(0, com.tencent.mobileqq.wink.editor.sticker.m.a0());
                this.f322050m.postValue(this.P);
            }
            if (list.get(1).materials != null) {
                this.Q.clear();
                this.Q.addAll(com.tencent.mobileqq.wink.editor.sticker.m.L("CATEGORY_TEXT_PATTERN", list.get(1).materials));
                this.Q.add(0, com.tencent.mobileqq.wink.editor.sticker.m.b0("TEXT_PATTERN_NON_ID"));
            }
            if (list.get(2).materials != null) {
                this.R.clear();
                this.R.addAll(com.tencent.mobileqq.wink.editor.sticker.m.L("CATEGORY_TEXT_DECOR", list.get(2).materials));
                this.R.add(0, com.tencent.mobileqq.wink.editor.sticker.m.b0("TEXT_DECOR_NON_ID"));
            }
            O1();
        }
    }

    public void I2(int i3) {
        this.I.postValue(Pair.create(this.V, Integer.valueOf(i3)));
    }

    public void L1(@NotNull String str) {
        boolean z16;
        MetaMaterial metaMaterial = this.U;
        if (metaMaterial == null) {
            return;
        }
        int H = com.tencent.mobileqq.wink.editor.sticker.m.H(metaMaterial);
        if (str.length() > H) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = str.subSequence(0, H).toString();
        }
        if (R2(str) || z16) {
            if (z16) {
                this.L.setValue(new t73.a<>(Pair.create(str, Boolean.TRUE)));
            } else {
                this.L.setValue(new t73.a<>(Pair.create(str, Boolean.FALSE)));
            }
        }
    }

    public void M1(@NonNull MetaMaterial metaMaterial) {
        String str = metaMaterial.f30533id;
        if (str == null || this.U == null) {
            return;
        }
        if (!"TEXT_PATTERN_NON_ID".equals(str) && !"TEXT_DECOR_NON_ID".equals(metaMaterial.f30533id)) {
            O2(metaMaterial);
        } else {
            B2(metaMaterial.f30533id);
        }
    }

    public void N1(String str) {
        if (str == null) {
            O1();
            K2();
            return;
        }
        this.S = str;
        if (!str.equals("CATEGORY_TEXT_DECOR")) {
            if (str.equals("CATEGORY_TEXT_PATTERN")) {
                this.N = this.Q;
            }
        } else {
            this.N = this.R;
        }
        this.f322045i.postValue(this.S);
        this.C.postValue(this.N);
        MetaMaterial metaMaterial = this.U;
        if (metaMaterial != null) {
            z2(n2(metaMaterial));
        }
        O1();
        K2();
    }

    public void P1(View view, int i3, String str) {
        String str2;
        HashMap hashMap = new HashMap();
        if (i3 == R.id.ybm) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_STYLE_TYPE, "keyboard");
            str2 = "CATEGORY_KEYBOARD";
        } else if (i3 == R.id.f94975dq) {
            this.T = "style";
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_STYLE_TYPE, "style");
            str2 = "CATEGORY_TEXT_STYLE";
        } else if (i3 == R.id.f94875dg) {
            this.T = "huazi";
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_STYLE_TYPE, "huazi");
            str2 = "CATEGORY_TEXT_PATTERN";
        } else if (i3 == R.id.f94755d5) {
            this.T = "decorate";
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_STYLE_TYPE, "decorate");
            str2 = "CATEGORY_TEXT_DECOR";
        } else if (i3 == R.id.f94985dr) {
            this.T = "decorate";
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_STYLE_TYPE, "decorate");
            str2 = "CATEGORY_TEXT_SUBSTRATE";
        } else if (i3 == R.id.f94715d1) {
            this.T = "decorate";
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_STYLE_TYPE, "decorate");
            str2 = "CATEGORY_TEXT_COLOR";
        } else if (i3 == R.id.f94775d7) {
            this.T = "decorate";
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_STYLE_TYPE, "decorate");
            str2 = "CATEGORY_TEXT_FONT";
        } else {
            str2 = null;
        }
        N1(str2);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_VIDEO_OR_PIC_PAGE, str);
        R1(view, WinkDaTongReportConstant.ElementId.EM_XSJ_CHAR_PATTERN, hashMap);
    }

    public void P2(int i3) {
        Q2(i3, true);
    }

    public void Q1(boolean z16, boolean z17, int i3, PointF pointF, @Nullable RectF rectF, boolean z18, int i16) {
        String str;
        Map<String, Serializable> map;
        MetaMaterial metaMaterial = this.U;
        if (metaMaterial == null) {
            return;
        }
        if (z16) {
            WinkStickerModel winkStickerModel = this.V;
            if (winkStickerModel != null) {
                M2(metaMaterial, Float.valueOf(winkStickerModel.centerX), Float.valueOf(this.V.centerY), Float.valueOf(this.V.rotate), Float.valueOf(this.V.scaleX));
            }
            QLog.d(f322030n0, 2, "pagViewWidth:" + i3 + " pagViewCenter:" + pointF + " textBounds:" + rectF);
            if (z17) {
                this.U.additionalFields.put("pagViewWidth", Integer.toString(i3));
                this.U.additionalFields.put("pagViewCenterX", Float.toString(pointF.x));
                this.U.additionalFields.put("pagViewCenterY", Float.toString(pointF.y));
                if (rectF != null) {
                    this.U.additionalFields.put("textBoundsTop", Float.toString(rectF.top));
                    this.U.additionalFields.put("textBoundsBottom", Float.toString(rectF.bottom));
                    this.U.additionalFields.put("textBoundsLeft", Float.toString(rectF.left));
                    this.U.additionalFields.put("textBoundsRight", Float.toString(rectF.right));
                }
            } else {
                this.U.additionalFields.remove("pagViewWidth");
            }
            Map<String, String> map2 = this.U.additionalFields;
            if (i16 == 1) {
                str = "1";
            } else {
                str = "0";
            }
            map2.put("showTTSMenu", str);
            WinkStickerModel winkStickerModel2 = this.V;
            if (winkStickerModel2 != null && winkStickerModel2.isSubtitleSticker()) {
                x2(z18);
            } else {
                WinkStickerModel winkStickerModel3 = this.V;
                if (winkStickerModel3 != null && winkStickerModel3.isTemplateTextSticker()) {
                    y2(this.V, this.U);
                } else {
                    WinkStickerModel winkStickerModel4 = this.V;
                    if (winkStickerModel4 != null && winkStickerModel4.isBackgroundTextSticker()) {
                        v2(this.V, this.U);
                    } else {
                        WinkStickerModel winkStickerModel5 = this.W;
                        if (winkStickerModel5 != null && winkStickerModel5.getHasChooseTTS() && (map = this.U.additionalObjectFields) != null) {
                            map.put("ttsAudioInfo", this.W.getTtsAudioInfo());
                        }
                        this.K.postValue(this.U);
                    }
                }
            }
            L2();
            J2();
        } else {
            WinkStickerModel winkStickerModel6 = this.V;
            if (winkStickerModel6 != null) {
                if (winkStickerModel6.isSubtitleSticker()) {
                    HashMap hashMap = new HashMap();
                    Iterator<WinkStickerModel> it = this.Y.values().iterator();
                    while (it.hasNext()) {
                        hashMap.put(it.next(), null);
                    }
                    if (this.V.getMaterial() != null && com.tencent.mobileqq.wink.editor.sticker.m.M(this.V.getMaterial()) && this.f322048k0 != null) {
                        com.tencent.mobileqq.wink.editor.sticker.m.o0(this.V.getMaterial(), this.f322048k0);
                    }
                    this.M.postValue(hashMap);
                } else {
                    this.J.postValue(this.V);
                }
            }
        }
        this.f322048k0 = null;
        this.U = null;
        this.V = null;
        this.Y = null;
        this.X = null;
        this.S = null;
    }

    public void Q2(int i3, boolean z16) {
        int parseColor;
        MetaMaterial metaMaterial = this.U;
        if (metaMaterial == null) {
            return;
        }
        int i16 = this.f322039c0;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (!com.tencent.mobileqq.wink.editor.sticker.m.V(metaMaterial)) {
                        com.tencent.mobileqq.wink.editor.sticker.m.N0(this.U, i3);
                        com.tencent.mobileqq.wink.editor.sticker.m.e0(this.U, false);
                    } else {
                        com.tencent.mobileqq.wink.editor.sticker.m.N0(this.U, i3);
                    }
                    com.tencent.mobileqq.wink.editor.sticker.m.f0(this.U, 0);
                } else {
                    if (this.f322043g0.containsKey(Integer.valueOf(i3))) {
                        com.tencent.mobileqq.wink.editor.sticker.m.N0(this.U, Color.parseColor(this.f322043g0.get(Integer.valueOf(i3))));
                    } else {
                        com.tencent.mobileqq.wink.editor.sticker.m.N0(this.U, Color.parseColor(this.f322042f0));
                    }
                    com.tencent.mobileqq.wink.editor.sticker.m.g0(this.U, i3);
                    com.tencent.mobileqq.wink.editor.sticker.m.e0(this.U, false);
                    com.tencent.mobileqq.wink.editor.sticker.m.f0(this.U, (int) (this.f322046i0.floatValue() * 255.0f));
                }
            } else {
                if (this.f322043g0.containsKey(Integer.valueOf(i3))) {
                    com.tencent.mobileqq.wink.editor.sticker.m.N0(this.U, Color.parseColor(this.f322043g0.get(Integer.valueOf(i3))));
                } else {
                    com.tencent.mobileqq.wink.editor.sticker.m.N0(this.U, Color.parseColor(this.f322042f0));
                }
                com.tencent.mobileqq.wink.editor.sticker.m.g0(this.U, i3);
                com.tencent.mobileqq.wink.editor.sticker.m.e0(this.U, false);
                com.tencent.mobileqq.wink.editor.sticker.m.f0(this.U, 255);
            }
        } else {
            com.tencent.mobileqq.wink.editor.sticker.m.N0(metaMaterial, i3);
            com.tencent.mobileqq.wink.editor.sticker.m.e0(this.U, true);
            if (!this.f322049l0.booleanValue()) {
                if (this.f322041e0.containsKey(Integer.valueOf(i3))) {
                    parseColor = Color.parseColor(this.f322041e0.get(Integer.valueOf(i3)));
                    com.tencent.mobileqq.wink.editor.sticker.m.H0(this.U, parseColor);
                } else {
                    parseColor = Color.parseColor(this.f322040d0);
                    com.tencent.mobileqq.wink.editor.sticker.m.H0(this.U, parseColor);
                }
                U2(parseColor);
                com.tencent.mobileqq.wink.editor.sticker.m.f0(this.U, 0);
            }
        }
        this.Z = i3;
        if (z16) {
            w2();
        }
    }

    boolean R2(String str) {
        if (this.U == null) {
            return false;
        }
        if (TextUtils.isEmpty(str) && !u2()) {
            str = f322031o0;
        }
        if (com.tencent.mobileqq.wink.editor.sticker.m.M(this.U)) {
            MetaMaterialContentWrapper m3 = com.tencent.mobileqq.wink.editor.sticker.m.m(this.U);
            if (m3 != null && m3.getMetaMaterialContent() != null) {
                MetaMaterialContent metaMaterialContent = m3.getMetaMaterialContent().get(0);
                if (metaMaterialContent != null && str.equals(metaMaterialContent.getContent())) {
                    return false;
                }
                if (metaMaterialContent != null) {
                    metaMaterialContent.setContent(str);
                }
            }
        } else {
            if (str.equals(com.tencent.mobileqq.wink.editor.sticker.m.l(this.U))) {
                return false;
            }
            com.tencent.mobileqq.wink.editor.sticker.m.n0(this.U, str);
        }
        w2();
        return true;
    }

    public LiveData<MetaMaterial> S1() {
        return this.K;
    }

    public void S2(int i3) {
        T2(i3, true);
    }

    public void T2(int i3, boolean z16) {
        int parseColor;
        MetaMaterial metaMaterial = this.U;
        if (metaMaterial == null) {
            return;
        }
        this.f322039c0 = i3;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    com.tencent.mobileqq.wink.editor.sticker.m.N0(metaMaterial, this.Z);
                    com.tencent.mobileqq.wink.editor.c.l1(this.U, "applyStroke");
                    com.tencent.mobileqq.wink.editor.c.l1(this.U, "strokeColor");
                    com.tencent.mobileqq.wink.editor.c.l1(this.U, "strokeWidth");
                    com.tencent.mobileqq.wink.editor.c.l1(this.U, "backgroundColor");
                    com.tencent.mobileqq.wink.editor.c.l1(this.U, "backgroundAlpha");
                } else {
                    if (this.f322047j0.containsKey(Integer.valueOf(this.Z))) {
                        com.tencent.mobileqq.wink.editor.sticker.m.N0(this.U, Color.parseColor(this.f322047j0.get(Integer.valueOf(this.Z))));
                    } else {
                        com.tencent.mobileqq.wink.editor.sticker.m.N0(this.U, Color.parseColor(this.f322044h0));
                    }
                    com.tencent.mobileqq.wink.editor.sticker.m.g0(this.U, this.Z);
                    com.tencent.mobileqq.wink.editor.sticker.m.e0(this.U, false);
                    com.tencent.mobileqq.wink.editor.sticker.m.f0(this.U, (int) (this.f322046i0.floatValue() * 255.0f));
                }
            } else {
                if (this.f322043g0.containsKey(Integer.valueOf(this.Z))) {
                    com.tencent.mobileqq.wink.editor.sticker.m.N0(this.U, Color.parseColor(this.f322043g0.get(Integer.valueOf(this.Z))));
                } else {
                    com.tencent.mobileqq.wink.editor.sticker.m.N0(this.U, Color.parseColor(this.f322042f0));
                }
                com.tencent.mobileqq.wink.editor.sticker.m.g0(this.U, this.Z);
                com.tencent.mobileqq.wink.editor.sticker.m.e0(this.U, false);
                com.tencent.mobileqq.wink.editor.sticker.m.f0(this.U, 255);
            }
        } else {
            if (this.f322041e0.containsKey(Integer.valueOf(this.Z))) {
                parseColor = Color.parseColor(this.f322041e0.get(Integer.valueOf(this.Z)));
                com.tencent.mobileqq.wink.editor.sticker.m.H0(this.U, parseColor);
            } else {
                parseColor = Color.parseColor(this.f322040d0);
                com.tencent.mobileqq.wink.editor.sticker.m.H0(this.U, parseColor);
            }
            com.tencent.mobileqq.wink.editor.sticker.m.N0(this.U, this.Z);
            com.tencent.mobileqq.wink.editor.sticker.m.e0(this.U, true);
            U2(parseColor);
            com.tencent.mobileqq.wink.editor.sticker.m.f0(this.U, 0);
            com.tencent.mobileqq.wink.editor.sticker.m.g0(this.U, 0);
        }
        if (z16) {
            w2();
        }
    }

    public LiveData<String> U1() {
        return this.f322045i;
    }

    public WinkStickerModel W1() {
        return this.V;
    }

    public LiveData<MetaMaterial> X1() {
        return this.D;
    }

    public WinkStickerModel b2() {
        return this.W;
    }

    public int c2() {
        return this.Z;
    }

    public LiveData<Pair<WinkStickerModel, Integer>> d2() {
        return this.I;
    }

    public LiveData<WinkStickerModel> e2() {
        return this.J;
    }

    public LiveData<t73.a<Pair<String, Boolean>>> f2() {
        return this.L;
    }

    public LiveData<Integer> g2() {
        return this.G;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return f322030n0;
    }

    public LiveData<Integer> h2() {
        return this.F;
    }

    public LiveData<List<MetaMaterial>> i2() {
        return this.C;
    }

    public LiveData<Integer> j2() {
        return this.E;
    }

    public LiveData<List<MetaMaterial>> k2() {
        return this.f322050m;
    }

    public LiveData<Integer> l2() {
        return this.H;
    }

    public String m2() {
        return this.T;
    }

    public int n2(@NonNull MetaMaterial metaMaterial) {
        if (com.tencent.mobileqq.wink.editor.sticker.m.e(metaMaterial) && metaMaterial.additionalFields.containsKey("strokeWidth") && com.tencent.mobileqq.wink.editor.sticker.m.C(metaMaterial) > 0.01d) {
            return 1;
        }
        if (com.tencent.mobileqq.wink.editor.sticker.m.f(metaMaterial) > 0) {
            if (com.tencent.mobileqq.wink.editor.sticker.m.f(metaMaterial) == 255) {
                return 2;
            }
            return 3;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveData<Map<WinkStickerModel, MetaMaterial>> o2() {
        return this.M;
    }

    public void p2(boolean z16, boolean z17) {
        List<MetaMaterial> list;
        this.f322051m0 = Boolean.valueOf(z17);
        if (this.V == null) {
            if (this.f322037a0 > 0 && (list = this.P) != null && !list.isEmpty()) {
                if (WinkEditorResourceManager.a1().q(this.P.get(this.f322037a0))) {
                    MetaMaterial copy = this.P.get(this.f322037a0).copy();
                    this.U = copy;
                    com.tencent.mobileqq.wink.editor.sticker.m.n0(copy, f322031o0);
                } else {
                    this.U = com.tencent.mobileqq.wink.editor.sticker.m.a0();
                }
            } else {
                this.U = com.tencent.mobileqq.wink.editor.sticker.m.a0();
            }
            int i3 = this.f322038b0;
            if (i3 > -1) {
                if (z17) {
                    MetaMaterial metaMaterial = this.U;
                    List<Integer> list2 = f322035s0;
                    com.tencent.mobileqq.wink.editor.sticker.m.N0(metaMaterial, list2.get(i3).intValue());
                    Q2(list2.get(this.f322038b0).intValue(), false);
                } else {
                    MetaMaterial metaMaterial2 = this.U;
                    List<Integer> list3 = f322034r0;
                    com.tencent.mobileqq.wink.editor.sticker.m.N0(metaMaterial2, list3.get(i3).intValue());
                    Q2(list3.get(this.f322038b0).intValue(), false);
                }
            }
            if (z16) {
                N1("CATEGORY_TEXT_STYLE");
            } else if (z17) {
                T2(this.f322039c0, false);
                I2(0);
                N1("CATEGORY_TEXT_SUBSTRATE");
            } else {
                T2(this.f322039c0, false);
                I2(0);
                N1("CATEGORY_KEYBOARD");
            }
            w2();
        }
    }

    public void q2() {
        JSONObject A2 = A2();
        JSONObject optJSONObject = A2.optJSONObject("stroke");
        JSONObject optJSONObject2 = A2.optJSONObject("pureBackground");
        JSONObject optJSONObject3 = A2.optJSONObject("pureBackgroundAlpha");
        try {
            this.f322040d0 = optJSONObject.getString(SkinConstants.TintConstant.KEY_DEFAULT_COLOR);
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("specialColor");
            this.f322041e0 = new HashMap<>();
            Iterator keys = optJSONObject4.keys();
            while (keys.hasNext()) {
                String valueOf = String.valueOf(keys.next());
                this.f322041e0.put(Integer.valueOf(Color.parseColor(valueOf)), (String) optJSONObject4.get(valueOf));
            }
            this.f322042f0 = optJSONObject2.getString(SkinConstants.TintConstant.KEY_DEFAULT_COLOR);
            JSONObject optJSONObject5 = optJSONObject2.optJSONObject("specialColor");
            this.f322043g0 = new HashMap<>();
            Iterator keys2 = optJSONObject5.keys();
            while (keys2.hasNext()) {
                String valueOf2 = String.valueOf(keys2.next());
                this.f322043g0.put(Integer.valueOf(Color.parseColor(valueOf2)), (String) optJSONObject5.get(valueOf2));
            }
            this.f322044h0 = optJSONObject3.getString(SkinConstants.TintConstant.KEY_DEFAULT_COLOR);
            this.f322046i0 = Float.valueOf(Float.parseFloat(optJSONObject3.getString(com.tencent.luggage.wxa.c8.c.f123400v)));
            JSONObject optJSONObject6 = optJSONObject3.optJSONObject("specialColor");
            this.f322047j0 = new HashMap<>();
            Iterator keys3 = optJSONObject6.keys();
            while (keys3.hasNext()) {
                String valueOf3 = String.valueOf(keys3.next());
                this.f322047j0.put(Integer.valueOf(Color.parseColor(valueOf3)), (String) optJSONObject6.get(valueOf3));
            }
        } catch (Exception e16) {
            w53.b.d(f322030n0, "initUnderlay error: ", e16);
        }
    }

    public void w2() {
        MetaMaterial metaMaterial = this.U;
        if (metaMaterial == null) {
            return;
        }
        int i3 = this.f322039c0;
        if (i3 != 2 && i3 != 3) {
            E2(com.tencent.mobileqq.wink.editor.sticker.m.F(metaMaterial));
        } else {
            E2(com.tencent.mobileqq.wink.editor.sticker.m.g(metaMaterial));
        }
        this.D.postValue(this.U);
    }

    void y2(WinkStickerModel winkStickerModel, MetaMaterial metaMaterial) {
        this.J.postValue(com.tencent.mobileqq.wink.editor.sticker.m.b(metaMaterial, winkStickerModel, 0, true, false));
    }

    public void z2(int i3) {
        this.f322039c0 = i3;
        this.H.postValue(Integer.valueOf(i3));
    }
}
