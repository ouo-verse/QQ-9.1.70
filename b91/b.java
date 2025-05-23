package b91;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ark.Constants;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.Doraemon.impl.webviewModule.a;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ark.browser.ArkBrowserFragment;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.message.msgtype.MessageRecordForMarkdown;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.component.f;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.webviewplugin.l;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.protofile.getappinfo.GetAppInfoProto$AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto$GetAppinfoResponse;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends com.tencent.mobileqq.Doraemon.impl.webviewModule.a {

    /* renamed from: c, reason: collision with root package name */
    private Dialog f28079c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f28080d = false;

    /* renamed from: e, reason: collision with root package name */
    private String f28081e = null;

    /* renamed from: f, reason: collision with root package name */
    private String f28082f = null;

    /* renamed from: g, reason: collision with root package name */
    private String f28083g = null;

    /* renamed from: h, reason: collision with root package name */
    private String f28084h = null;

    /* renamed from: i, reason: collision with root package name */
    private String f28085i = null;

    /* renamed from: j, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f28086j = new ConcurrentHashMap<>();

    /* renamed from: k, reason: collision with root package name */
    private boolean f28087k = false;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.mobileqq.Doraemon.a f28088l = null;

    /* renamed from: m, reason: collision with root package name */
    private d f28089m = new d();

    /* renamed from: n, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f28090n = new ConcurrentHashMap<>();

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.mobileqq.Doraemon.a f28091o = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements com.tencent.open.appcommon.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f28092d;

        a(Activity activity) {
            this.f28092d = activity;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            GetAppInfoProto$AndroidInfo getAppInfoProto$AndroidInfo;
            String string = this.f28092d.getString(R.string.f170465rx);
            if (z16) {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        GetAppInfoProto$GetAppinfoResponse getAppInfoProto$GetAppinfoResponse = new GetAppInfoProto$GetAppinfoResponse();
                        getAppInfoProto$GetAppinfoResponse.mergeFrom(byteArray);
                        if (getAppInfoProto$GetAppinfoResponse.has() && getAppInfoProto$GetAppinfoResponse.ret.get() == 0 && (getAppInfoProto$AndroidInfo = getAppInfoProto$GetAppinfoResponse.androidInfo) != null) {
                            PBStringField pBStringField = getAppInfoProto$AndroidInfo.messagetail;
                            if (pBStringField == null) {
                                string = "";
                            } else {
                                string = pBStringField.get();
                            }
                            string.trim();
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ArkWebModule", 2, e16.getMessage());
                    }
                }
            }
            if (TextUtils.isEmpty(string)) {
                string = this.f28092d.getString(R.string.f170465rx);
            }
            b.this.l(String.format(this.f28092d.getString(R.string.f170466ry), string));
            b.this.f28079c.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: b91.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class ViewOnClickListenerC0111b implements View.OnClickListener {
        ViewOnClickListenerC0111b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b.this.f28090n.put(b.this.f28089m.f28096a, 1);
            Activity a16 = ((com.tencent.mobileqq.Doraemon.impl.webviewModule.a) b.this).f154219b.a();
            if (!PackageUtil.isAppInstalled(a16, b.this.f28089m.f28098c)) {
                if (!TextUtils.isEmpty(b.this.f28089m.f28102g)) {
                    Intent intent = new Intent(a16, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", b.this.f28089m.f28102g);
                    intent.putExtra("fromArkAppDownload", true);
                    a16.startActivity(intent);
                }
                DoraemonUtil.c(b.this.f28088l, -4, "need to download");
            } else {
                b bVar = b.this;
                bVar.t(bVar.f28089m.f28096a, b.this.f28089m.f28097b, b.this.f28089m.f28098c, b.this.f28089m.f28099d, b.this.f28089m.f28100e, b.this.f28089m.f28101f);
                DoraemonUtil.e(b.this.f28088l, com.tencent.mobileqq.Doraemon.c.f154094a);
            }
            b.this.f28089m.a();
            b.this.f28079c.dismiss();
            b.this.f28088l = null;
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DoraemonUtil.c(b.this.f28088l, -3, "user canceled");
            b.this.f28089m.a();
            b.this.f28079c.dismiss();
            b.this.f28088l = null;
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f28096a;

        /* renamed from: b, reason: collision with root package name */
        public String f28097b;

        /* renamed from: c, reason: collision with root package name */
        public String f28098c;

        /* renamed from: d, reason: collision with root package name */
        public String f28099d;

        /* renamed from: e, reason: collision with root package name */
        public String f28100e;

        /* renamed from: f, reason: collision with root package name */
        public String f28101f;

        /* renamed from: g, reason: collision with root package name */
        public String f28102g;

        d() {
        }

        public void a() {
            this.f28096a = null;
            this.f28097b = null;
            this.f28098c = null;
            this.f28099d = null;
            this.f28100e = null;
            this.f28101f = null;
            this.f28102g = null;
        }
    }

    private void m(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ArkWebModule", 1, "decodeArkH5Config, keywordCfgJsonStr is empty");
            return;
        }
        this.f28086j.clear();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("web-view-open-app-config");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    Object obj = optJSONObject.get(str2);
                    if ((obj instanceof String) && obj != null) {
                        this.f28086j.put(str2, (String) obj);
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e("ArkWebModule", 1, String.format("decodeArkH5Config, parse json failed, err=%s", e16.getMessage()));
        }
    }

    private void n(JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        if (!this.f28087k) {
            DoraemonUtil.c(this.f28088l, -1, "no auth");
            return;
        }
        try {
            if (jSONObject.has("enable")) {
                boolean optBoolean = jSONObject.optBoolean("enable");
                y d16 = this.f154219b.d();
                boolean z16 = true;
                if (d16 != null && (d16 instanceof l)) {
                    l lVar = (l) d16;
                    if (optBoolean) {
                        z16 = false;
                    }
                    lVar.O3(z16);
                } else {
                    f q16 = q(-1);
                    if (q16 != null) {
                        if (optBoolean) {
                            z16 = false;
                        }
                        q16.h("image_long_click", z16);
                    }
                }
                DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
                return;
            }
        } catch (Exception unused) {
        }
        DoraemonUtil.c(aVar, -2, "param error");
    }

    private void o(JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        if (!this.f28087k) {
            DoraemonUtil.c(this.f28088l, -1, "no auth");
            return;
        }
        try {
            if (jSONObject.has("enable")) {
                boolean optBoolean = jSONObject.optBoolean("enable");
                y d16 = this.f154219b.d();
                boolean z16 = true;
                if (d16 != null && (d16 instanceof l)) {
                    l lVar = (l) d16;
                    if (optBoolean) {
                        z16 = false;
                    }
                    lVar.L6(z16);
                } else {
                    f q16 = q(-1);
                    if (q16 != null) {
                        if (optBoolean) {
                            z16 = false;
                        }
                        q16.h("web_view_long_click", z16);
                    }
                }
                DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
                return;
            }
        } catch (Exception unused) {
        }
        DoraemonUtil.c(aVar, -2, "param error");
    }

    private void p(JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        if (!this.f28087k) {
            DoraemonUtil.c(this.f28088l, -1, "no auth");
            return;
        }
        String format = String.format("%d", Integer.valueOf(ark.arkGetPlatformVersion()));
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("version", format);
        } catch (Exception e16) {
            QLog.e("ArkWebModule", 1, "getArkSDKVersion error e = ", e16);
        }
        DoraemonUtil.e(aVar, jSONObject2);
    }

    private f q(int i3) {
        a.C7083a c7083a = this.f154219b;
        if (c7083a != null) {
            WebViewFragment c16 = c7083a.c();
            if (c16 != null) {
                return (f) c16.getComponentProvider().a(i3);
            }
            if (this.f154219b.a() instanceof b.f) {
                return (f) ((b.f) this.f154219b.a()).getComponentProvider().a(i3);
            }
            return null;
        }
        return null;
    }

    private String r() {
        WebViewFragment c16;
        a.C7083a c7083a = this.f154219b;
        if (c7083a != null && (c16 = c7083a.c()) != null) {
            return c16.getCurrentUrl();
        }
        return null;
    }

    private void s() {
        Bundle arguments;
        Bundle extras;
        if (this.f28080d) {
            return;
        }
        try {
            l91.a.a();
        } catch (Exception e16) {
            QLog.e("ArkWebModule", 1, String.format("setupArkEnvironment error, err=%s", e16.getMessage()));
        }
        WebViewFragment c16 = this.f154219b.c();
        if (c16 != null && (arguments = c16.getArguments()) != null && (extras = ((Intent) arguments.getParcelable("intent")).getExtras()) != null) {
            this.f28083g = extras.getString(AppConstants.Key.H5_ARK_APP_NAME);
            this.f28081e = extras.getString(AppConstants.Key.H5_ARK_APP_PATH);
            this.f28082f = extras.getString(AppConstants.Key.H5_ARK_APP_DESCRIPTION);
            m(extras.getString(AppConstants.Key.H5_ARK_CHECK_CONFIG));
            this.f28084h = extras.getString(AppConstants.Key.H5_ARK_NATION_CODE);
            this.f28085i = extras.getString(AppConstants.Key.H5_ARK_PHONE_NUMBER);
            this.f28080d = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        if (QLog.isColorLevel()) {
            QLog.d("ArkWebModule", 2, "launchAppWithTokens " + str3);
        }
        eq2.a aVar = new eq2.a();
        AppInterface b16 = this.f154219b.b();
        if (b16 == null) {
            return;
        }
        int i3 = 268435456;
        try {
            int parseInt = Integer.parseInt(str4);
            if ((parseInt & 67108864) == 67108864) {
                i3 = 335544320;
            }
            if ((parseInt & 536870912) == 536870912) {
                i3 |= 536870912;
            }
            if ((parseInt & 4194304) == 4194304) {
                i3 |= 4194304;
            }
        } catch (Exception unused) {
        }
        int i16 = i3;
        ReportController.o(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, str, "", "", "");
        Activity a16 = this.f154219b.a();
        String str8 = "tencentwtlogin" + str + QzoneWebViewOfflinePlugin.STR_DEVIDER;
        boolean z16 = false;
        if (util.FILE_DIR.equals(str5) && a16 != null) {
            PackageManager packageManager = a16.getPackageManager();
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(str8));
            if (packageManager != null && InstalledAppListMonitor.queryIntentActivities(packageManager, intent, 0).size() > 0) {
                z16 = true;
            }
        }
        if (z16) {
            if (this.f154219b.e() != null) {
                str7 = this.f154219b.e().getUrl();
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin webview is null");
                }
                str7 = "";
            }
            aVar.f(str8, a16, str7, b16, str, str3, i16, str6);
            return;
        }
        if (a16 != null) {
            aVar.d(b16, a16, str, str2, str3, i16);
        } else {
            QLog.e("ArkWebModule", 1, "launchAppWithTokens fail for context is null");
        }
    }

    private void v(JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        String str;
        AppInterface b16;
        Integer num;
        if (!this.f28087k) {
            DoraemonUtil.c(this.f28088l, -1, "no auth");
            return;
        }
        this.f28088l = aVar;
        Dialog dialog = this.f28079c;
        if (dialog != null && dialog.isShowing()) {
            DoraemonUtil.c(this.f28088l, -5, "other");
            return;
        }
        try {
            this.f28089m.f28096a = jSONObject.optString("appID");
            this.f28089m.f28097b = jSONObject.optString("paramsStr");
            this.f28089m.f28098c = jSONObject.optString("packageName");
            this.f28089m.f28099d = jSONObject.optString(WadlProxyConsts.FLAGS);
            this.f28089m.f28102g = jSONObject.optString("url");
        } catch (Exception e16) {
            QLog.e("ArkWebModule", 1, String.format("get mOpenAppinfo json error, err=%s", e16.getMessage()));
        }
        if (TextUtils.isEmpty(this.f28089m.f28096a)) {
            QLog.e("ArkWebModule", 1, "mOpenAppinfo.appId is null");
            DoraemonUtil.c(this.f28088l, -2, "param error");
            return;
        }
        if (this.f28090n.containsKey(this.f28089m.f28096a) && (num = this.f28090n.get(this.f28089m.f28096a)) != null) {
            if (num.intValue() == 1) {
                Activity a16 = this.f154219b.a();
                if (!PackageUtil.isAppInstalled(a16, this.f28089m.f28098c)) {
                    if (!TextUtils.isEmpty(this.f28089m.f28102g)) {
                        Intent intent = new Intent(a16, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", this.f28089m.f28102g);
                        intent.putExtra("fromArkAppDownload", true);
                        a16.startActivity(intent);
                    }
                    DoraemonUtil.c(this.f28088l, -4, "need to download");
                    return;
                }
                d dVar = this.f28089m;
                t(dVar.f28096a, dVar.f28097b, dVar.f28098c, dVar.f28099d, dVar.f28100e, dVar.f28101f);
                DoraemonUtil.e(this.f28088l, com.tencent.mobileqq.Doraemon.c.f154094a);
                return;
            }
            if (num.intValue() == 0) {
                y();
                DoraemonUtil.c(this.f28088l, -3, "user canceled");
                return;
            }
        }
        s();
        ConcurrentHashMap<String, String> concurrentHashMap = this.f28086j;
        if (concurrentHashMap != null) {
            for (String str2 : concurrentHashMap.keySet()) {
                if (!TextUtils.isEmpty(this.f28083g) && str2.equals(this.f28083g)) {
                    str = this.f28086j.get(str2);
                    break;
                }
            }
        }
        str = "ask";
        if (str.equals("allow")) {
            Activity a17 = this.f154219b.a();
            if (!PackageUtil.isAppInstalled(a17, this.f28089m.f28098c)) {
                if (!TextUtils.isEmpty(this.f28089m.f28102g)) {
                    Intent intent2 = new Intent(a17, (Class<?>) QQBrowserActivity.class);
                    intent2.putExtra("url", this.f28089m.f28102g);
                    intent2.putExtra("fromArkAppDownload", true);
                    a17.startActivity(intent2);
                }
                DoraemonUtil.c(this.f28088l, -4, "need to download");
                return;
            }
            d dVar2 = this.f28089m;
            t(dVar2.f28096a, dVar2.f28097b, dVar2.f28098c, dVar2.f28099d, dVar2.f28100e, dVar2.f28101f);
            DoraemonUtil.e(this.f28088l, com.tencent.mobileqq.Doraemon.c.f154094a);
            return;
        }
        if (str.equals("ask")) {
            Activity a18 = this.f154219b.a();
            if (a18 == null || a18.isFinishing() || (b16 = this.f154219b.b()) == null) {
                return;
            }
            try {
                Share.o(b16, this.f154219b.a(), b16.getAccount(), Long.parseLong(this.f28089m.f28096a), 2000L, new a(a18));
                return;
            } catch (NumberFormatException e17) {
                QLog.e("ArkWebModule", 1, String.format("mOpenAppinfo appid to Long error, err=%s", e17.getMessage()));
                l(String.format(a18.getString(R.string.f170466ry), a18.getString(R.string.f170465rx)));
                Dialog dialog2 = this.f28079c;
                if (dialog2 != null) {
                    dialog2.show();
                    return;
                }
                return;
            }
        }
        if (str.equals("forbidden")) {
            y();
            DoraemonUtil.c(this.f28088l, -3, "user canceled");
        }
    }

    private void w(JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        String str;
        int i3;
        String str2;
        b bVar = this;
        if (!bVar.f28087k) {
            DoraemonUtil.c(bVar.f28088l, -1, "no auth");
            return;
        }
        WebViewFragment c16 = bVar.f154219b.c();
        if (c16 == null) {
            DoraemonUtil.c(aVar, -3, "other");
            return;
        }
        SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) c16.mComponentsProvider.a(4);
        if (swiftBrowserShareMenuHandler == null) {
            DoraemonUtil.c(aVar, -3, "other");
            return;
        }
        try {
            String optString = jSONObject.optString("appName");
            String optString2 = jSONObject.optString(QQCustomArkDialogUtil.APP_VIEW);
            String optString3 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
            String optString4 = jSONObject.optString(QQCustomArkDialogUtil.APP_MIN_VERSION);
            String optString5 = jSONObject.optString("appConfig");
            String optString6 = jSONObject.optString(QQCustomArkDialogUtil.META_DATA);
            String optString7 = jSONObject.optString("appDesc");
            String optString8 = jSONObject.optString(QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT);
            String optString9 = jSONObject.optString(MessageRecordForMarkdown.MSG_MARKDOWN_COMPATIBLE_TEXT);
            if (TextUtils.isEmpty(optString)) {
                str2 = "other";
                bVar = this;
            } else {
                try {
                    if (TextUtils.isEmpty(optString2)) {
                        str2 = "other";
                    } else {
                        s();
                        if (TextUtils.isEmpty(optString4)) {
                            optString4 = Constants.DEFAULT_MIN_APP_VERSION;
                        }
                        String str3 = optString4;
                        str2 = "other";
                        try {
                            Bundle a16 = QQCustomArkDialog.b.a(optString, optString2, optString3, str3, optString6, com.tencent.mobileqq.ark.f.c(), null, null);
                            a16.putBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT, false);
                            a16.putString("forward_ark_app_name", optString);
                            a16.putString("forward_ark_app_view", optString2);
                            a16.putString("forward_ark_biz_src", optString3);
                            a16.putString(AppConstants.Key.FORWARD_ARK_APP_DESC, optString7);
                            a16.putString("forward_ark_app_ver", str3);
                            a16.putString("forward_ark_app_meta", optString6);
                            a16.putString("forward_ark_app_prompt", optString8);
                            a16.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString5);
                            a16.putString(AppConstants.Key.FORWARD_ARK_APP_COMPAT, optString9);
                            a16.putBoolean(AppConstants.Key.FORWARD_ARK_FROM_H5, true);
                            Intent intent = new Intent();
                            intent.setClass(swiftBrowserShareMenuHandler.f314297f, ForwardRecentActivity.class);
                            intent.putExtra("forward_type", 27);
                            intent.putExtra("is_ark_display_share", true);
                            intent.putExtras(a16);
                            ForwardBaseOption.startForwardActivity(swiftBrowserShareMenuHandler.f314297f, intent);
                            if (QLog.isColorLevel()) {
                                QLog.i("ArkWebModule", 2, "buildForwardIntent: " + a16);
                            }
                            ReportCenter.f().p("", "", "", "1000", "101", "0", false);
                            ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_webview_38", "qq_ark_share", 0, 1, 0, "", "", "", "");
                            DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
                            return;
                        } catch (Exception unused) {
                            str = str2;
                            i3 = -3;
                            DoraemonUtil.c(aVar, i3, str);
                        }
                    }
                } catch (Exception unused2) {
                    str = "other";
                    i3 = -3;
                    DoraemonUtil.c(aVar, i3, str);
                }
            }
            try {
                DoraemonUtil.c(bVar.f28091o, -2, "param error");
            } catch (Exception unused3) {
                str = str2;
                i3 = -3;
                DoraemonUtil.c(aVar, i3, str);
            }
        } catch (Exception unused4) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0141 A[Catch: Exception -> 0x015a, TRY_LEAVE, TryCatch #1 {Exception -> 0x015a, blocks: (B:31:0x004f, B:33:0x0058, B:12:0x0078, B:14:0x00db, B:17:0x00e2, B:19:0x0141, B:11:0x006c), top: B:30:0x004f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void x(JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        String str;
        String optString;
        String optString2;
        String optString3;
        String optString4;
        String optString5;
        String optString6;
        String optString7;
        String optString8;
        String r16;
        b bVar = this;
        if (!bVar.f28087k) {
            DoraemonUtil.c(bVar.f28088l, -1, "no auth");
            return;
        }
        bVar.f28091o = aVar;
        try {
            Activity a16 = bVar.f154219b.a();
            Intent intent = new Intent();
            String optString9 = jSONObject.optString("appName");
            String optString10 = jSONObject.optString("toUin");
            int optInt = jSONObject.optInt("uinType", 0);
            String optString11 = jSONObject.optString("toNickName");
            if (optString10 != null) {
                try {
                    str = "appName";
                    if (optString10.length() >= 5) {
                        intent.setClass(a16, DirectForwardActivity.class);
                        intent.putExtra("toUin", optString10);
                        intent.putExtra("uinType", optInt);
                        intent.putExtra("nickName", optString11);
                        intent.putExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, jSONObject.optInt(AppConstants.Key.SHARE_REQ_QQ_TYPE, 13));
                        intent.putExtra("forward_type", 27);
                        intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
                        intent.putExtra("k_back", jSONObject.optBoolean("k_back", jSONObject.optBoolean("back", false)));
                        optString = jSONObject.optString("appDesc");
                        optString2 = jSONObject.optString(QQCustomArkDialogUtil.APP_MIN_VERSION);
                        optString3 = jSONObject.optString(QQCustomArkDialogUtil.APP_VIEW);
                        optString4 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
                        optString5 = jSONObject.optString("appConfig");
                        optString6 = jSONObject.optString(QQCustomArkDialogUtil.META_DATA);
                        optString7 = jSONObject.optString(QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT);
                        optString8 = jSONObject.optString(MessageRecordForMarkdown.MSG_MARKDOWN_COMPATIBLE_TEXT);
                        if (!TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString3)) {
                            r16 = r();
                            intent.putExtra("forward_ark_app_name", optString9);
                            intent.putExtra("forward_ark_app_view", optString3);
                            intent.putExtra("forward_ark_biz_src", optString4);
                            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, optString);
                            intent.putExtra("forward_ark_app_ver", optString2);
                            intent.putExtra("forward_ark_app_prompt", optString7);
                            intent.putExtra("forward_ark_app_meta", optString6);
                            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString5);
                            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_COMPAT, optString8);
                            intent.putExtra("is_ark_display_share", true);
                            intent.putExtra(str, optString9);
                            intent.putExtra(QQCustomArkDialogUtil.APP_VIEW, optString3);
                            intent.putExtra(QQCustomArkDialogUtil.APP_MIN_VERSION, optString2);
                            intent.putExtra(QQCustomArkDialogUtil.META_DATA, optString6);
                            intent.putExtra("scale", com.tencent.mobileqq.ark.f.c());
                            if (!TextUtils.isEmpty(r16)) {
                                intent.putExtra(AppConstants.Key.FORWARD_ARK_H5_FROM_JS, r16);
                            }
                            z(intent, (byte) 0);
                            return;
                        }
                        DoraemonUtil.c(this.f28091o, -2, "param error");
                    }
                } catch (Exception e16) {
                    e = e16;
                    bVar = this;
                    DoraemonUtil.c(bVar.f28091o, -4, "other");
                    QLog.e("ArkWebModule", 1, "shareArkMsg error: " + e.toString());
                    return;
                }
            } else {
                str = "appName";
            }
            intent.putExtra("isWebCompShare", true);
            intent.setClass(a16, ForwardRecentActivity.class);
            intent.putExtra(AppConstants.Key.SHARE_REQ_QQ_TYPE, jSONObject.optInt(AppConstants.Key.SHARE_REQ_QQ_TYPE, 13));
            intent.putExtra("forward_type", 27);
            intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
            intent.putExtra("k_back", jSONObject.optBoolean("k_back", jSONObject.optBoolean("back", false)));
            optString = jSONObject.optString("appDesc");
            optString2 = jSONObject.optString(QQCustomArkDialogUtil.APP_MIN_VERSION);
            optString3 = jSONObject.optString(QQCustomArkDialogUtil.APP_VIEW);
            optString4 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
            optString5 = jSONObject.optString("appConfig");
            optString6 = jSONObject.optString(QQCustomArkDialogUtil.META_DATA);
            optString7 = jSONObject.optString(QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT);
            optString8 = jSONObject.optString(MessageRecordForMarkdown.MSG_MARKDOWN_COMPATIBLE_TEXT);
            if (!TextUtils.isEmpty(optString9)) {
                r16 = r();
                intent.putExtra("forward_ark_app_name", optString9);
                intent.putExtra("forward_ark_app_view", optString3);
                intent.putExtra("forward_ark_biz_src", optString4);
                intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, optString);
                intent.putExtra("forward_ark_app_ver", optString2);
                intent.putExtra("forward_ark_app_prompt", optString7);
                intent.putExtra("forward_ark_app_meta", optString6);
                intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString5);
                intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_COMPAT, optString8);
                intent.putExtra("is_ark_display_share", true);
                intent.putExtra(str, optString9);
                intent.putExtra(QQCustomArkDialogUtil.APP_VIEW, optString3);
                intent.putExtra(QQCustomArkDialogUtil.APP_MIN_VERSION, optString2);
                intent.putExtra(QQCustomArkDialogUtil.META_DATA, optString6);
                intent.putExtra("scale", com.tencent.mobileqq.ark.f.c());
                if (!TextUtils.isEmpty(r16)) {
                }
                z(intent, (byte) 0);
                return;
            }
            DoraemonUtil.c(this.f28091o, -2, "param error");
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void y() {
        Activity a16;
        a.C7083a c7083a = this.f154219b;
        if (c7083a != null && (a16 = c7083a.a()) != null && !a16.isFinishing()) {
            QQToast.makeText(a16, HardCodeUtil.qqStr(R.string.jqr), 0).show();
        }
    }

    private void z(Intent intent, byte b16) {
        WebViewFragment c16 = this.f154219b.c();
        if (c16 != null) {
            c16.startActivityForResult(intent, b16);
        } else if (QLog.isDevelopLevel()) {
            QLog.d("ArkWebModule", 4, "startActivityForResult not called, webViewFragment != null");
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public boolean c(int i3, String str, JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        switch (i3) {
            case 11:
                n(jSONObject, aVar);
                return true;
            case 12:
                o(jSONObject, aVar);
                return true;
            case 13:
                p(jSONObject, aVar);
                return true;
            case 14:
                v(jSONObject, aVar);
                return true;
            case 15:
                w(jSONObject, aVar);
                return true;
            case 16:
                x(jSONObject, aVar);
                return true;
            default:
                return false;
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.impl.webviewModule.a, com.tencent.mobileqq.Doraemon.e
    protected void d() {
        super.d();
        if (this.f154219b.c() instanceof ArkBrowserFragment) {
            this.f28087k = true;
        }
    }

    protected void l(String str) {
        Dialog dialog = this.f28079c;
        if (dialog == null) {
            ReportDialog reportDialog = new ReportDialog(BaseActivity.sTopActivity, R.style.qZoneInputDialog);
            this.f28079c = reportDialog;
            reportDialog.setContentView(R.layout.f167856jn);
            TextView textView = (TextView) this.f28079c.findViewById(R.id.dialogTitle);
            TextView textView2 = (TextView) this.f28079c.findViewById(R.id.dialogText);
            TextView textView3 = (TextView) this.f28079c.findViewById(R.id.dialogLeftBtn);
            TextView textView4 = (TextView) this.f28079c.findViewById(R.id.dialogRightBtn);
            textView.setText(R.string.f173206i10);
            if (!TextUtils.isEmpty(str)) {
                textView2.setText(str);
            }
            textView4.setText(R.string.igh);
            textView4.setOnClickListener(new ViewOnClickListenerC0111b());
            textView3.setOnClickListener(new c());
            textView3.setText(R.string.cancel);
            return;
        }
        TextView textView5 = (TextView) dialog.findViewById(R.id.dialogText);
        if (!TextUtils.isEmpty(str)) {
            textView5.setText(str);
        }
    }

    public void u(Intent intent, byte b16, int i3) {
        com.tencent.mobileqq.Doraemon.a aVar;
        if (b16 == 0 && (aVar = this.f28091o) != null) {
            if (i3 == -1) {
                DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
            } else {
                DoraemonUtil.c(aVar, -3, "user cancel");
            }
        }
    }
}
