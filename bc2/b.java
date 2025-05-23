package bc2;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.ads.data.AdParam;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.now.netchannel.websso.e;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.internal.ConstValue;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {

    /* renamed from: i, reason: collision with root package name */
    public static b f28251i = new b();

    /* renamed from: a, reason: collision with root package name */
    private BaseApplication f28252a;

    /* renamed from: b, reason: collision with root package name */
    private String f28253b;

    /* renamed from: c, reason: collision with root package name */
    private String f28254c;

    /* renamed from: d, reason: collision with root package name */
    private String f28255d;

    /* renamed from: e, reason: collision with root package name */
    private String f28256e;

    /* renamed from: f, reason: collision with root package name */
    private String f28257f;

    /* renamed from: g, reason: collision with root package name */
    private int f28258g;

    /* renamed from: h, reason: collision with root package name */
    private Callback f28259h = new a();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements Callback {
        a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            QLog.e("ReportCenter", 4, iOException, new Object[0]);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (response != null && response.code() == 200) {
                QLog.i("ReportCenter", 4, "data report success.");
            }
        }
    }

    b() {
        BaseApplication context = BaseApplication.getContext();
        this.f28252a = context;
        this.f28258g = 0;
        this.f28254c = String.valueOf(ah.Q(context));
        this.f28253b = ah.P();
        String model = DeviceInfoMonitor.getModel();
        this.f28257f = model;
        if (model == null) {
            this.f28257f = "unknown";
        }
        String str = Build.VERSION.RELEASE;
        this.f28256e = str;
        if (str == null) {
            this.f28256e = "unknown";
        }
        String str2 = Build.MANUFACTURER;
        this.f28255d = str2;
        if (str2 == null) {
            this.f28255d = "unknown";
        }
    }

    private static int b(Context context) {
        int networkType = NetworkUtil.getNetworkType(context);
        if (networkType == 1) {
            return 2;
        }
        if (networkType == 2) {
            return 3;
        }
        if (networkType != 3) {
            return 1;
        }
        return 4;
    }

    private String c(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        Iterator<String> it = bundle.keySet().iterator();
        String str = "personal_live_base";
        while (true) {
            String str2 = "";
            if (it.hasNext()) {
                String next = it.next();
                if ("tid".equals(next)) {
                    str = bundle.getString(next);
                } else if (!"bid".equals(next)) {
                    jSONArray.mo162put(next);
                    if (!StringUtil.isEmpty(bundle.getString(next))) {
                        str2 = bundle.getString(next);
                    }
                    jSONArray2.mo162put(str2);
                }
            } else {
                JSONArray jSONArray3 = new JSONArray();
                jSONArray3.mo162put(jSONArray2);
                try {
                    return "&table=" + str + "&fields=" + URLEncoder.encode(jSONArray.toString(), "UTF-8") + "&datas=" + URLEncoder.encode(jSONArray3.toString(), "UTF-8");
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                    return "";
                }
            }
        }
    }

    private void d(Bundle bundle) {
        Headers build = new Headers.Builder().add("Content-Type", "application/x-www-form-urlencoded").add("Referer", "https://now.qq.com/").build();
        yb2.a.b().newCall(new Request.Builder().url("https://now.qq.com/cgi-bin/now/web/tdw/report").headers(build).post(RequestBody.create(MediaType.get("application/x-www-form-urlencoded"), c(bundle))).build()).enqueue(this.f28259h);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("appid", String.valueOf(16130));
        bundle.putString("installsrc", String.valueOf(16130));
        bundle.putString("platform", "Android");
        bundle.putString("opername", "now_jiehe");
        bundle.putString(IPublicAccountBrowser.KEY_UIN_TYPE, "0");
        bundle.putString("uin", String.valueOf(e.f()));
        bundle.putString("rom", this.f28255d);
        bundle.putString(AdParam.OSVERSION, this.f28256e);
        bundle.putString(ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, this.f28254c);
        bundle.putString("qqversion", this.f28253b);
        bundle.putString("timestr", String.valueOf(System.currentTimeMillis() / 1000));
        bundle.putString(QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE, String.valueOf(b(this.f28252a)));
        return bundle;
    }

    public void e(Bundle bundle) {
        if (bundle == null) {
            QLog.d("ReportCenter", 4, "send(): no data to report");
        } else {
            d(bundle);
        }
    }
}
