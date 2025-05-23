package cooperation.vip.ad;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f391167a = "";

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f391168b;

    /* renamed from: c, reason: collision with root package name */
    private static Integer f391169c;

    /* renamed from: d, reason: collision with root package name */
    private static Boolean f391170d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f391171e;

    /* renamed from: f, reason: collision with root package name */
    private static MMKVOptionEntityV2 f391172f;

    /* renamed from: g, reason: collision with root package name */
    private static final Gson f391173g = new Gson();

    /* renamed from: h, reason: collision with root package name */
    private static final Type f391174h = new a().getType();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends TypeToken<Map<String, Object>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements Callback {
        b() {
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException iOException) {
            QLog.d("TianshuAdUtils", 1, "single report send fail! ,e:" + iOException.getLocalizedMessage());
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            try {
                QLog.d("TianshuAdUtils", 1, "single report code:" + response.code());
                response.close();
            } catch (Exception e16) {
                QLog.d("TianshuAdUtils", 1, "single report  fail!", e16);
            }
            QLog.d("TianshuAdUtils", 1, "single report send success!");
        }
    }

    public static QQAppInterface b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    public static String c(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String path = new URL(str).getPath();
            if (TextUtils.isEmpty(path) || (lastIndexOf = path.lastIndexOf(46)) == -1) {
                return "";
            }
            return path.substring(lastIndexOf);
        } catch (MalformedURLException e16) {
            QLog.e("TianshuAdUtils", 1, "getFileSuffixFromUrl e = " + e16);
            return "";
        }
    }

    public static TianShuAdPosItemData d() {
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = 1;
        tianShuAdPosItemData.mPosId = 973;
        if (!TextUtils.isEmpty(f391167a)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("app_open_source", f391167a);
            tianShuAdPosItemData.mExtraData = hashMap;
        }
        return tianShuAdPosItemData;
    }

    public static int e() {
        if (f391169c == null) {
            f391169c = Integer.valueOf(RFWConfig.getConfigValue("tianshu_request_interval_time", 5000));
        }
        return f391169c.intValue();
    }

    public static List<TianShuAdPosItemData> f() {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = 1;
        tianShuAdPosItemData.mPosId = 339;
        arrayList.add(tianShuAdPosItemData);
        TianShuAdPosItemData tianShuAdPosItemData2 = new TianShuAdPosItemData();
        tianShuAdPosItemData2.mNeedCnt = 1;
        tianShuAdPosItemData2.mPosId = 340;
        arrayList.add(tianShuAdPosItemData2);
        TianShuAdPosItemData tianShuAdPosItemData3 = new TianShuAdPosItemData();
        tianShuAdPosItemData3.mNeedCnt = 1;
        tianShuAdPosItemData3.mPosId = 341;
        arrayList.add(tianShuAdPosItemData3);
        return arrayList;
    }

    public static MMKVOptionEntityV2 g() {
        if (f391172f == null) {
            f391172f = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU);
        }
        return f391172f;
    }

    public static void h(QQAppInterface qQAppInterface, Context context, String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("TianshuAdUtils", 2, "url empty");
            return;
        }
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        if (iMiniAppService.isMiniAppUrl(str)) {
            iMiniAppService.startMiniApp(context, str, i3, null);
            return;
        }
        if (str.startsWith("mqqapi://") && qQAppInterface != null) {
            ax c16 = bi.c(qQAppInterface, context, str);
            if (c16 != null) {
                c16.b();
                return;
            }
            return;
        }
        if (str.startsWith("weixin://") && qQAppInterface != null) {
            QLog.e("TianshuAdUtils", 2, "[handleUrl]: " + str);
            ((IWeChatGuildApi) QRoute.api(IWeChatGuildApi.class)).openWechat(context, str, true);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserDelegationActivity.class);
        intent.putExtra("url", str);
        if (context instanceof Application) {
            intent.setFlags(268435456);
        }
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        context.startActivity(intent);
    }

    public static Boolean i() {
        if (f391168b == null) {
            f391168b = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("tianshu_requeset_carry_ui_status", Boolean.TRUE);
            QLog.d("TianshuAdUtils", 1, "sIsRequestCarryUIStatus " + f391168b);
        }
        return f391168b;
    }

    public static boolean j() {
        if (f391171e == null) {
            f391171e = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tianshu_send_simple_event_bus", true));
        }
        return f391171e.booleanValue();
    }

    public static boolean k() {
        if (f391170d == null) {
            f391170d = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tianshu_splash_use_new_request", true));
        }
        return f391170d.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(Map map) {
        try {
            p(map);
        } catch (Throwable th5) {
            QLog.e("TianshuAdUtils", 1, "singleReport exception:" + th5.getLocalizedMessage());
        }
    }

    public static void m(int i3, String str, int i16, String str2) {
        w.c(str, i3, i16, str2);
    }

    @Deprecated
    public static void n(QQAppInterface qQAppInterface, int i3, String str, String str2) {
        w.d(str, i3, str2);
    }

    public static void o(final Map<String, String> map) {
        RFWThreadManager.getInstance().getSerialThreadHandler().postDelayed(new Runnable() { // from class: cooperation.vip.ad.h
            @Override // java.lang.Runnable
            public final void run() {
                i.l(map);
            }
        }, 5000L);
    }

    private static void p(Map<String, String> map) {
        QLog.d("TianshuAdUtils", 1, "singleReportToServer");
        if (map != null && !map.isEmpty()) {
            StringBuilder sb5 = new StringBuilder("https://h.trace.qq.com/kv?");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(entry.getValue());
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.append("_dc");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(Math.random());
            QLog.d("TianshuAdUtils", 1, "reportToServer, url:" + ((Object) sb5));
            new OkHttpClient().newCall(new Request.Builder().url(sb5.toString()).build()).enqueue(new b());
        }
    }

    public static void q(String str, String str2) {
        f391167a = str;
        QLog.d("TianshuAdUtils", 1, "setHalfLayerADParams ", str, " from:", str2);
    }
}
