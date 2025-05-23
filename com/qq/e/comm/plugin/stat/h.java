package com.qq.e.comm.plugin.stat;

import android.os.Build;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.k.ac;
import com.qq.e.comm.plugin.k.aj;
import com.qq.e.comm.plugin.k.x;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.StringUtil;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f39720a = new a();
    }

    public static x a() {
        return b.f39720a.a();
    }

    public static x b() {
        if (b.f39720a != null) {
            return b.f39720a.b();
        }
        return null;
    }

    public static Map<Integer, String> c() {
        return b.f39720a.c();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f39717a;

        /* renamed from: b, reason: collision with root package name */
        private volatile Pair<String, String> f39718b;

        /* renamed from: c, reason: collision with root package name */
        private final Map<Integer, String> f39719c;

        a() {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            this.f39719c = concurrentHashMap;
            new WeakReference(GDTADManager.getInstance().getAppContext().getApplicationContext());
            x xVar = new x();
            xVar.a("pkg", GDTADManager.getInstance().getAppStatus().getAPPName());
            xVar.a("av", GDTADManager.getInstance().getAppStatus().getAPPVersion());
            xVar.a(GdtADFlyingStreamingReportHelper.PARAM_KEY_SV, SDKStatus.getSDKVersion());
            xVar.a("plv", GDTADManager.getInstance().getPM().getPluginVersion());
            if (SDKStatus.getSDKVersionCode() >= 130) {
                xVar.a("build_num", SDKStatus.getSDKBuildNum());
            }
            xVar.a("sdk_st", aj.a());
            xVar.a("sdk_pt", 1);
            String str = Build.VERSION.RELEASE;
            xVar.a(GdtADFlyingStreamingReportHelper.PARAM_KEY_OV, str);
            concurrentHashMap.put(403, String.valueOf(str));
            xVar.a("al", Build.VERSION.SDK_INT);
            xVar.a("os", 2);
            xVar.a("imei", ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getDeviceId());
            xVar.a("st", 2);
            String hashDeviceId = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getHashDeviceId();
            xVar.a("muid", hashDeviceId);
            concurrentHashMap.put(110, String.valueOf(hashDeviceId));
            String buildModel = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getBuildModel();
            xVar.a("md", buildModel);
            concurrentHashMap.put(117, String.valueOf(buildModel));
            xVar.a("pl", Build.FINGERPRINT);
            xVar.a(GdtADFlyingStreamingReportHelper.PARAM_KEY_MN, Build.PRODUCT);
            Pair<Integer, Integer> heightAndWidth = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getHeightAndWidth();
            if (heightAndWidth != null) {
                if (((Integer) heightAndWidth.first).intValue() > ((Integer) heightAndWidth.second).intValue()) {
                    xVar.a("w", heightAndWidth.second);
                    concurrentHashMap.put(Integer.valueOf(QzoneCoverConst.MSG_COVER_INVALIDATE), String.valueOf(heightAndWidth.second));
                    xVar.a(tl.h.F, heightAndWidth.first);
                    concurrentHashMap.put(1191, String.valueOf(heightAndWidth.first));
                } else {
                    xVar.a("w", heightAndWidth.first);
                    concurrentHashMap.put(Integer.valueOf(QzoneCoverConst.MSG_COVER_INVALIDATE), String.valueOf(heightAndWidth.first));
                    xVar.a(tl.h.F, heightAndWidth.second);
                    concurrentHashMap.put(1191, String.valueOf(heightAndWidth.second));
                }
            }
            this.f39717a = xVar.a();
        }

        x a(x xVar) {
            if (xVar == null) {
                return null;
            }
            if (this.f39718b != null) {
                xVar.a("td", (String) this.f39718b.first);
                this.f39719c.put(2, String.valueOf(this.f39718b.first));
                xVar.a("od", (String) this.f39718b.second);
                this.f39719c.put(1, String.valueOf(this.f39718b.second));
            }
            JSONObject jSONObject = this.f39717a;
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    xVar.a(str, this.f39717a.opt(str));
                }
            }
            return xVar;
        }

        x b() {
            x xVar = new x();
            xVar.a("ts", System.currentTimeMillis());
            xVar.a("app", GDTADManager.getInstance().getAppStatus().getAPPID());
            return a(xVar);
        }

        Map<Integer, String> c() {
            return this.f39719c;
        }

        x a() {
            x xVar = new x();
            xVar.a("ts", System.currentTimeMillis());
            xVar.a("app", GDTADManager.getInstance().getAppStatus().getAPPID());
            int connValue = GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue();
            xVar.a(LinkReportConstant$GlobalKey.CONNECT_TYPE, connValue);
            this.f39719c.put(312, String.valueOf(connValue));
            String a16 = ac.a();
            if (!StringUtil.isEmpty(a16)) {
                xVar.a("cell_native", a16);
                this.f39719c.put(313, String.valueOf(a16));
            }
            String language = Locale.getDefault().getLanguage();
            xVar.a("lg", language);
            String id5 = TimeZone.getDefault().getID();
            xVar.a("tz", id5);
            int carrier = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getCarrier();
            xVar.a("ca", carrier);
            this.f39719c.put(304, String.valueOf(language));
            this.f39719c.put(306, String.valueOf(id5));
            this.f39719c.put(305, String.valueOf(carrier));
            this.f39718b = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getTaidAndOaidTicket();
            return a(xVar);
        }
    }
}
