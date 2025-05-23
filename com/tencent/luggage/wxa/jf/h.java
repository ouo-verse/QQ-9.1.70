package com.tencent.luggage.wxa.jf;

import android.text.TextUtils;
import com.tencent.luggage.wxa.fd.q;
import com.tencent.luggage.wxa.fd.r;
import com.tencent.luggage.wxa.fd.x;
import com.tencent.luggage.wxa.jf.d;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.jf.a {
    public static final int CTRL_INDEX = 251;
    public static final String NAME = "navigateToMiniProgram";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements d.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f131013a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f131014b;

        public a(com.tencent.luggage.wxa.ic.d dVar, int i3) {
            this.f131013a = dVar;
            this.f131014b = i3;
        }

        @Override // com.tencent.luggage.wxa.jf.d.c
        public /* synthetic */ void a(com.tencent.luggage.wxa.fd.i iVar) {
            l.a(this, iVar);
        }

        @Override // com.tencent.luggage.wxa.jf.d.c
        public void a(boolean z16, String str) {
            String str2;
            if (z16) {
                this.f131013a.a(this.f131014b, h.this.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("fail");
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = " " + str;
            }
            sb5.append(str2);
            this.f131013a.a(this.f131014b, h.this.makeReturnJson(new com.tencent.luggage.wxa.af.c(0, sb5.toString())));
        }
    }

    public void a(x.c cVar, JSONObject jSONObject) {
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x03e8  */
    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void invoke(final com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String str;
        JSONObject jSONObject4;
        String str2;
        JSONObject jSONObject5;
        String str3;
        String str4;
        String str5;
        x.c cVar;
        JSONObject jSONObject6;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        x.c cVar2;
        double d16;
        String str6;
        String str7;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z46;
        double d17;
        double d18;
        double d19;
        boolean z47;
        boolean z48;
        x.d dVar2;
        x.a aVar;
        String optString = jSONObject.optString("appId", null);
        if (w0.c(optString)) {
            dVar.a(i3, makeReturnJson("fail:appID is empty"));
            return;
        }
        final String optString2 = jSONObject.optString("path", null);
        q j06 = dVar.getRuntime().j0();
        if (j06 == null) {
            w.b("Luggage.JsApiNavigateToMiniProgram", "invoke appId:%s, navigateToAppId:%s, NULL sysConfig", dVar.getAppId(), optString);
            dVar.a(i3, makeReturnJson("fail:internal error"));
            return;
        }
        int i16 = j06.f125966l.f151861a;
        int i17 = b.a(jSONObject.optString("envVersion"), b.RELEASE).f130986a;
        if (a(dVar.getRuntime()) && i16 != 1 && i16 != 2) {
            i17 = 0;
        }
        if (optString.equals(dVar.getAppId())) {
            if (i17 == dVar.getRuntime().l0()) {
                dVar.getRuntime().e(new Runnable() { // from class: com.tencent.luggage.wxa.jf.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.luggage.wxa.ic.d.this.getRuntime().Y().a(optString2, true);
                    }
                });
                dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                return;
            } else {
                final com.tencent.luggage.wxa.fd.i clone = dVar.getRuntime().S().clone();
                clone.f125811d = i17;
                clone.f125813f = optString2;
                dVar.getRuntime().e(new Runnable() { // from class: com.tencent.luggage.wxa.jf.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.luggage.wxa.ic.d.this.getRuntime().a(clone, com.tencent.luggage.wxa.li.a.JsApiNavigateToMiniProgram.b());
                    }
                });
                return;
            }
        }
        int optInt = jSONObject.optInt("sourcetype", 0);
        String optString3 = jSONObject.optString("agentId");
        d.a aVar2 = new d.a();
        aVar2.f130988a = i3;
        aVar2.f130989b = jSONObject.optInt("scene", 0);
        aVar2.f130990c = jSONObject.optString("sceneNote");
        aVar2.f130991d = jSONObject.optInt("preScene", 0);
        aVar2.f130992e = jSONObject.optString("preSceneNote");
        aVar2.f130994g = optInt;
        aVar2.f130993f = optString3;
        aVar2.f130995h = jSONObject.optString("adInfo");
        aVar2.f130997j = jSONObject.optBoolean("noRelaunchIfPathUnchanged", false);
        try {
            jSONObject2 = jSONObject.getJSONObject("uiParam");
        } catch (JSONException unused) {
            jSONObject2 = null;
        }
        try {
            jSONObject3 = jSONObject.getJSONObject("halfPage");
        } catch (JSONException unused2) {
            jSONObject3 = null;
        }
        x.c cVar3 = new x.c();
        int i18 = i17;
        if (!"halfPage".equals(jSONObject.optString("mode", ""))) {
            str = "hideCapsuleMenu";
            jSONObject4 = jSONObject2;
            str2 = "needShowTemplateNav";
            jSONObject5 = jSONObject3;
            str3 = "hideSimulatedNativeLeftReturnButton";
            str4 = "forceLightMode";
            str5 = "usePushAnimation";
            cVar = cVar3;
            if ("embedded".equals(jSONObject.optString("mode", ""))) {
                int[] iArr = new int[2];
                v pageView = dVar.getRuntime().Y().getPageView();
                if (pageView == null) {
                    dVar.a(i3, makeReturnJson("fail:page don't exist"));
                    return;
                }
                try {
                    jSONObject6 = jSONObject.getJSONObject("embedded");
                } catch (JSONException unused3) {
                    jSONObject6 = null;
                }
                if (jSONObject6 != null) {
                    z16 = jSONObject6.optBoolean("allowFullScreen");
                } else {
                    z16 = false;
                }
                if (!z16 && !f0.e("AppBrandDebugUI").getBoolean("ENABLE_EMBED_HALF_SCREEN_EXPAND", false)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                com.tencent.luggage.wxa.kl.b W = pageView.W();
                if (W == null) {
                    dVar.a(i3, makeReturnJson("fail:internal error"));
                    return;
                }
                W.getCapsuleView().getLocationInWindow(iArr);
                cVar.d(true).a(x.j.EMBED).a((com.tencent.luggage.wxa.lo.q.b(z.c()).y - (iArr[1] + pageView.W().getCapsuleView().getHeight())) - com.tencent.luggage.wxa.ep.a.a(dVar.getContext(), 12.0f)).a(x.d.SINGLE_CLOSE).a(new x.b(z.c().getResources().getDimension(R.dimen.bh9), true, true, false, false)).h(true).a(false).b(true).k(z17).a(x.l.NORMAL).i(true).l(z17).e(z17);
                a(cVar, jSONObject);
                if (jSONObject4 != null) {
                    JSONObject jSONObject7 = jSONObject4;
                    String str8 = str;
                    JSONObject jSONObject8 = jSONObject5;
                    if (jSONObject7.has(str8)) {
                        if (jSONObject5 != null) {
                            z29 = jSONObject8.optBoolean(str8, false);
                        } else {
                            z29 = false;
                        }
                        if (jSONObject7.optBoolean(str8, z29)) {
                            cVar.a(x.d.HIDE);
                        }
                    }
                    String str9 = str4;
                    if (jSONObject7.has(str9)) {
                        z18 = false;
                        if (jSONObject8 != null) {
                            z28 = jSONObject8.optBoolean(str9, false);
                        } else {
                            z28 = false;
                        }
                        cVar.g(jSONObject7.optBoolean(str9, z28));
                    } else {
                        z18 = false;
                    }
                    String str10 = str2;
                    if (jSONObject7.has(str10)) {
                        if (jSONObject8 != null) {
                            z27 = jSONObject8.optBoolean(str10, z18);
                        } else {
                            z27 = z18;
                        }
                        cVar.i(jSONObject7.optBoolean(str10, z27));
                    }
                    String str11 = str5;
                    if (jSONObject7.has(str11)) {
                        if (jSONObject8 != null) {
                            z26 = jSONObject8.optBoolean(str11, z18);
                        } else {
                            z26 = false;
                        }
                        if (jSONObject7.optBoolean(str11, z26)) {
                            cVar.a(x.a.SLIDE);
                        } else {
                            cVar.a(x.a.POPUP);
                        }
                    }
                    String str12 = str3;
                    if (jSONObject7.has(str12)) {
                        boolean z49 = false;
                        if (jSONObject8 != null) {
                            z49 = jSONObject8.optBoolean(str12, false);
                        }
                        boolean optBoolean = jSONObject7.optBoolean(str12, z49);
                        z19 = true;
                        cVar.j(!optBoolean);
                    } else {
                        z19 = true;
                    }
                    cVar.d(z19);
                }
                e().a(dVar, optString, i18, optString2, aVar2, jSONObject, cVar.a(), a(dVar, jSONObject, i3));
            }
        } else {
            x.d dVar3 = x.d.NORMAL;
            if (jSONObject3 != null) {
                double a16 = a(jSONObject3.optDouble("width", -2.0d));
                cVar2 = cVar3;
                double a17 = a(jSONObject3.optDouble("height", 0.0d));
                jSONObject4 = jSONObject2;
                double d26 = -2.0d;
                double a18 = a(jSONObject3.optDouble("landscapeHeight", -2.0d));
                double a19 = a(jSONObject3.optDouble("landscapeWidth", -2.0d));
                if (a17 == 0.0d) {
                    a17 = -2.0d;
                }
                if (a16 == 0.0d) {
                    a16 = -2.0d;
                }
                if (a18 == 0.0d) {
                    a18 = -2.0d;
                }
                if (a19 != 0.0d) {
                    d26 = a19;
                }
                boolean optBoolean2 = jSONObject3.optBoolean("hideSimulatedNativeLeftReturnButton", false);
                double d27 = a16;
                String optString4 = jSONObject3.optString("loadingDarkModeStyle", "");
                z47 = jSONObject3.optBoolean("hideCapsuleMenu", false);
                String optString5 = jSONObject3.optString("capsuleMenuType", "");
                boolean optBoolean3 = jSONObject3.optBoolean("forceLightMode", false);
                boolean optBoolean4 = jSONObject3.optBoolean("enableFullScreenGesture", false);
                boolean optBoolean5 = jSONObject3.optBoolean("forbidFullScreenDragUpGesture", false);
                boolean optBoolean6 = jSONObject3.optBoolean("needShowTemplateNav", false);
                z46 = optBoolean2;
                boolean optBoolean7 = jSONObject3.optBoolean("usePushAnimation", false);
                str6 = optString5;
                str2 = "needShowTemplateNav";
                z36 = optBoolean3;
                str = "hideCapsuleMenu";
                z37 = optBoolean6;
                str3 = "hideSimulatedNativeLeftReturnButton";
                d17 = d26;
                d19 = a17;
                d18 = a18;
                d16 = d27;
                jSONObject5 = jSONObject3;
                str4 = "forceLightMode";
                z39 = optBoolean4;
                z38 = optBoolean5;
                str5 = "usePushAnimation";
                str7 = optString4;
                z48 = optBoolean7;
            } else {
                jSONObject4 = jSONObject2;
                cVar2 = cVar3;
                str = "hideCapsuleMenu";
                str2 = "needShowTemplateNav";
                jSONObject5 = jSONObject3;
                d16 = -2.0d;
                str6 = "";
                str7 = str6;
                str3 = "hideSimulatedNativeLeftReturnButton";
                str4 = "forceLightMode";
                str5 = "usePushAnimation";
                z36 = false;
                z37 = false;
                z38 = false;
                z39 = false;
                z46 = false;
                d17 = -2.0d;
                d18 = -2.0d;
                d19 = 0.0d;
                z47 = false;
                z48 = false;
            }
            if (z47) {
                dVar2 = x.d.HIDE;
            } else if ("singleClose".equals(str6)) {
                dVar2 = x.d.SINGLE_CLOSE;
            } else {
                dVar2 = dVar3;
            }
            if (z48) {
                aVar = x.a.SLIDE;
            } else {
                aVar = x.a.POPUP;
            }
            String str13 = str7;
            cVar = cVar2;
            cVar.d(true).a((int) d19).d((int) d16).b((int) d18).c((int) d17).a(dVar2).a(new x.b(z.c().getResources().getDimension(R.dimen.bh9), true, true, false, false)).g(z36).b(true).h(true).k(z39).f(z38).i(z37).a(aVar).c(false).j(!z46);
            if (MiniAppConst.MENU_STYLE_DARK.equals(str13)) {
                cVar.a(r.FORCE_DARK);
            } else if (MiniAppConst.MENU_STYLE_LIGHT.equals(str13)) {
                cVar.a(r.FORCE_LIGHT);
            }
            a(cVar, jSONObject);
        }
        if (jSONObject4 != null) {
        }
        e().a(dVar, optString, i18, optString2, aVar2, jSONObject, cVar.a(), a(dVar, jSONObject, i3));
    }

    public boolean a(com.tencent.luggage.wxa.ic.g gVar) {
        return true;
    }

    public final double a(double d16) {
        if (d16 == -2.0d) {
            return d16;
        }
        if (d16 < 0.0d) {
            d16 = 0.0d;
        }
        return com.tencent.luggage.wxa.tk.g.a() * d16;
    }

    public d.c a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        return new a(dVar, i3);
    }
}
