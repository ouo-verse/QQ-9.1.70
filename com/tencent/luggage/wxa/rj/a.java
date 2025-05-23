package com.tencent.luggage.wxa.rj;

import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile Set f139772a = new HashSet();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.rj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C6687a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f139773a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.qc.b.values().length];
            f139773a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.qc.b.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f139773a[com.tencent.luggage.wxa.qc.b.DESTROYED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f139773a[com.tencent.luggage.wxa.qc.b.BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f139773a[com.tencent.luggage.wxa.qc.b.FOREGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        f139772a.add(com.tencent.luggage.wxa.ff.c.NAME);
        f139772a.add(com.tencent.mm.plugin.appbrand.jsapi.live.c.NAME);
        f139772a.add("operateXWebLivePlayer");
        f139772a.add("operateXWebLivePusher");
        f139772a.add("operateRecorder");
        Collections.addAll(f139772a, "insertCamera", com.tencent.luggage.wxa.rh.b.NAME, "operateCamera");
        Collections.addAll(f139772a, PluginConst.VoIPPluginConst.API_JOIN_IP_CHAT, "exitVoIPChat", "onVoIPChatMembersChanged", "onVoIPChatSpeakersChanged", "onVoIPChatInterrupted", "updateVoIPChatMuteConfig", "insertVoIPView", "updateVoIPView", "removeVoIPView");
        Collections.addAll(f139772a, "getLocation", com.tencent.luggage.wxa.ef.e.NAME, com.tencent.luggage.wxa.ef.f.NAME, com.tencent.luggage.wxa.ef.h.NAME);
        f139772a.add("navigateTo");
    }

    public static int a(com.tencent.luggage.wxa.xd.d dVar, String str, String str2) {
        int optInt;
        if (!a(dVar, str) || w0.c(str2)) {
            return Integer.MIN_VALUE;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!jSONObject.has("permissionBytes")) {
                return Integer.MIN_VALUE;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("permissionBytes");
            if (jSONArray.length() < 3) {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppRuntimeApiPermissionController", "permissionBytes length:%d invalid", Integer.valueOf(jSONArray.length()));
                return Integer.MIN_VALUE;
            }
            if (dVar instanceof com.tencent.luggage.wxa.ic.l) {
                int i3 = C6687a.f139773a[((com.tencent.luggage.wxa.ic.l) dVar).getRuntime().c0().b().ordinal()];
                if (i3 == 1) {
                    optInt = jSONArray.optInt(2, Integer.MIN_VALUE);
                } else if (i3 != 2 && i3 != 3) {
                    optInt = jSONArray.optInt(0, Integer.MIN_VALUE);
                } else {
                    optInt = jSONArray.optInt(1, Integer.MIN_VALUE);
                }
            } else {
                optInt = jSONArray.optInt(0, Integer.MIN_VALUE);
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy api:%s checkRet:%d", str, Integer.valueOf(optInt));
            return optInt;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy exp:%s", e16.getMessage());
            return Integer.MIN_VALUE;
        }
    }

    public static void a(String str) {
        f139772a.add(str);
    }

    public static boolean a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        if (dVar instanceof com.tencent.luggage.wxa.kj.v) {
            return true;
        }
        return f139772a.contains(str);
    }
}
