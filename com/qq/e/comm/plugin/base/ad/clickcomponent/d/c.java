package com.qq.e.comm.plugin.base.ad.clickcomponent.d;

import android.text.TextUtils;
import com.qq.e.comm.constants.TangramAppConstants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.model.n;
import com.qq.e.comm.plugin.k.ao;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.net.URL;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class c {
    public static boolean a(ClickInfo clickInfo) {
        com.qq.e.comm.plugin.base.ad.clickcomponent.e b16 = clickInfo.b();
        if (!com.qq.e.comm.plugin.j.c.a(clickInfo.n(), "enter_landing_page_while_downloading", 1, 1) || !com.qq.e.comm.plugin.k.d.e(clickInfo.j())) {
            return true;
        }
        if (a(b16.e(), clickInfo.c().f38510b, clickInfo.d() != null ? clickInfo.d().s() : null) || !c(clickInfo)) {
            return true;
        }
        return e(clickInfo) == 3 && com.qq.e.comm.plugin.k.b.i(clickInfo.j()) && clickInfo.l() != null && clickInfo.l().f38512a != null;
    }

    public static boolean b(ClickInfo clickInfo) {
        if (clickInfo == null) {
            return false;
        }
        return (clickInfo.g() == 5 || clickInfo.g() == 8) && com.qq.e.comm.plugin.j.c.a("externalDownloadSwitch", 1, 1);
    }

    public static boolean c(ClickInfo clickInfo) {
        int g16 = clickInfo.g();
        if (g16 == 1 || g16 == 3) {
            return true;
        }
        return false;
    }

    public static boolean d(ClickInfo clickInfo) {
        if (clickInfo != null && clickInfo.b() != null && clickInfo.b().a() != null && clickInfo.c() != null && y.a(clickInfo.j())) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
    
        if (com.qq.e.comm.plugin.j.e.a().a(r6.c().f38511c, "supportVideoFormPage", 0) == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int e(ClickInfo clickInfo) {
        boolean z16;
        int i3 = 1;
        if (clickInfo.f() != null && clickInfo.f().a() == 1) {
            return 1;
        }
        JSONObject j3 = clickInfo.j();
        if (com.qq.e.comm.plugin.k.d.a(j3) && !com.qq.e.comm.plugin.k.d.e(j3)) {
            return -1;
        }
        if (clickInfo.c().f38510b != com.qq.e.comm.plugin.base.ad.b.NATIVEUNIFIEDAD) {
            z16 = false;
        }
        z16 = true;
        String x16 = clickInfo.d().x();
        int H = clickInfo.d().H();
        if (TextUtils.isEmpty(x16) || clickInfo.k() == null) {
            return 1;
        }
        if (z16) {
            if (H == 3 && !com.qq.e.comm.plugin.k.b.i(j3)) {
                i3 = 2;
            } else {
                i3 = H;
            }
        }
        if (i3 == 0) {
            return 2;
        }
        return i3;
    }

    public static boolean f(ClickInfo clickInfo) {
        int i3;
        n U;
        if (clickInfo == null) {
            return false;
        }
        com.qq.e.comm.plugin.base.ad.model.f d16 = clickInfo.d();
        if (d16 != null && (U = d16.U()) != null) {
            i3 = U.c();
        } else {
            i3 = 0;
        }
        if (!a(clickInfo.j()) || i3 != 1) {
            return false;
        }
        return true;
    }

    public static boolean b(JSONObject jSONObject) {
        if (!a(jSONObject)) {
            return false;
        }
        String b16 = com.qq.e.comm.plugin.k.d.c(jSONObject).b();
        if (TextUtils.isEmpty(b16)) {
            return false;
        }
        return ao.a(((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getStatus(b16));
    }

    public static boolean a(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("producttype");
        return optInt == 19 || optInt == 12 || optInt == 5;
    }

    public static boolean a(int i3, com.qq.e.comm.plugin.base.ad.b bVar, String str) {
        return (i3 == 2 && bVar == com.qq.e.comm.plugin.base.ad.b.NATIVEUNIFIEDAD) && com.qq.e.comm.plugin.j.c.a(str, "nativeEndcardStopExterior", 0, 0);
    }

    public static com.qq.e.comm.plugin.a.b a(ClickInfo clickInfo, JSONObject jSONObject, int i3, int i16, String str) {
        JSONObject j3 = clickInfo.j();
        String optString = j3.optString("cl");
        String b16 = com.qq.e.comm.plugin.k.d.c(j3).b();
        com.qq.e.comm.plugin.a.b bVar = new com.qq.e.comm.plugin.a.b(optString, j3.optString("productid"), clickInfo.e(), jSONObject.optString(TangramAppConstants.ICON_URL), str, jSONObject.optString("name"), b16, null, GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue(), j3.optString("effect_url"));
        bVar.a(com.qq.e.comm.plugin.base.ad.e.a.a.a(j3));
        bVar.a("posId", clickInfo.c().f38511c);
        bVar.a(VirtualAppProxy.KEY_AUTO_DOWNLOAD, i3);
        bVar.a(VirtualAppProxy.KEY_DOWNLOAD_SCENE, i16);
        return bVar;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URL(str).getHost();
            if (!host.contains("c.gdt.qq.com") && !host.contains("c.l.qq.com")) {
                if (!host.contains("ttc.gdt.qq.com")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean a() {
        return com.qq.e.comm.plugin.j.c.a("clickLinkReportSwitchToNode", 1, 1);
    }
}
