package com.tencent.mobileqq.profile;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.profilecard.diybg.IVasDiyCardBgKuikly;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.business.ProfileCardBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.webview.plugin.VasTransformUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.webviewplugin.r;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.util.URLUtil;
import com.tencent.vas.update.entity.UpdateListenerParams;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class h extends VasWebviewJsPlugin {
    static IPatchRedirector $redirector_;
    ActionSheet C;
    private final int D;
    private final int E;
    private final int F;
    private DownloaderFactory G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private boolean f260161d;

    /* renamed from: e, reason: collision with root package name */
    public int f260162e;

    /* renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f260163f;

    /* renamed from: h, reason: collision with root package name */
    public AtomicInteger f260164h;

    /* renamed from: i, reason: collision with root package name */
    public AtomicInteger f260165i;

    /* renamed from: m, reason: collision with root package name */
    public List<m> f260166m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Activity a16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent != null && (a16 = h.this.mRuntime.a()) != null && !a16.isFinishing()) {
                WebViewPlugin.b bVar = h.this.mRuntime;
                y d16 = bVar.d(bVar.a());
                if (d16 != null && (d16 instanceof r)) {
                    String currentUrl = ((r) d16).getCurrentUrl();
                    if (!TextUtils.isEmpty(currentUrl) && currentUrl.contains(MttLoader.ENTRY_ID)) {
                        h.this.f260162e = URLUtil.getInt(URLUtil.getArgumentsFromURL(currentUrl), MttLoader.ENTRY_ID, 2);
                    } else {
                        h.this.f260162e = 2;
                    }
                }
                a16.finish();
                Intent profileCardIntentOnly = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(h.this.mRuntime.a(), new AllInOne(h.this.mRuntime.b().getCurrentAccountUin(), 0));
                if (h.this.f260162e == 0) {
                    profileCardIntentOnly.setFlags(67108864);
                }
                h.this.mRuntime.a().startActivity(profileCardIntentOnly);
                Intent intent2 = new Intent();
                intent2.putExtra("closeSpecialLogic", true);
                h.this.mRuntime.a().setResult(-1, intent2);
                h.this.mRuntime.a().finish();
                VasCommonReporter.getDiyCard().setValue1("set diy end").report();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends EIPCCallback.Stub {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f260168d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSONObject f260169e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f260170f;

        b(JSONObject jSONObject, JSONObject jSONObject2, String str) {
            this.f260168d = jSONObject;
            this.f260169e = jSONObject2;
            this.f260170f = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, jSONObject, jSONObject2, str);
            }
        }

        @Override // eipc.EIPCCallback
        public void callback(EIPCResult eIPCResult) throws RemoteException {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            try {
                long j3 = eIPCResult.data.getLong("currentId");
                long j16 = eIPCResult.data.getLong("styleId");
                int i16 = eIPCResult.data.getInt("result");
                String string = eIPCResult.data.getString("diy_url");
                if (j16 != ProfileCardTemplate.PROFILE_CARD_STYLE_SOCIAL && j16 != ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID && j16 != ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE) {
                    i3 = 0;
                    this.f260168d.put("currentId", j3);
                    this.f260168d.put("styleId", j16);
                    this.f260168d.put("isPhotoWall", i3);
                    this.f260168d.put("url", string);
                    this.f260169e.put("data", this.f260168d);
                    this.f260169e.put("result", i16);
                    h.this.callPJs(this.f260170f, this.f260169e.toString());
                }
                i3 = 1;
                this.f260168d.put("currentId", j3);
                this.f260168d.put("styleId", j16);
                this.f260168d.put("isPhotoWall", i3);
                this.f260168d.put("url", string);
                this.f260169e.put("data", this.f260168d);
                this.f260169e.put("result", i16);
                h.this.callPJs(this.f260170f, this.f260169e.toString());
            } catch (Exception e16) {
                QLog.e("ProfileCardWebviewPlugin", 1, "getInfo:json put error" + e16.getMessage());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c extends EIPCCallback.Stub {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f260172d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f260173e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f260174f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f260175h;

        c(JSONObject jSONObject, String str, String str2, int i3) {
            this.f260172d = jSONObject;
            this.f260173e = str;
            this.f260174f = str2;
            this.f260175h = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, jSONObject, str, str2, Integer.valueOf(i3));
            }
        }

        @Override // eipc.EIPCCallback
        public void callback(EIPCResult eIPCResult) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            int i3 = eIPCResult.data.getInt("result");
            String string = eIPCResult.data.getString("message");
            try {
                this.f260172d.put("result", i3);
                this.f260172d.put("message", string);
                h.this.callPJs(this.f260173e, this.f260172d.toString());
                ((VasWebviewJsPlugin) h.this).proxy.cardSingleStepEndReport(this.f260174f, this.f260175h, 2, i3);
            } catch (JSONException unused) {
                QLog.e("ProfileCardWebviewPlugin", 1, "json put error, bgId: " + this.f260175h);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f260177a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f260178b;

        d(JSONObject jSONObject, String str) {
            this.f260177a = jSONObject;
            this.f260178b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, jSONObject, str);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                h.this.w(this.f260177a, this.f260178b, updateListenerParams.mErrorCode);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                h.this.w(this.f260177a, this.f260178b, updateListenerParams.mErrorCode);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                h.this.y(i3);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class f extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<h> f260181a;

        public f(h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
            } else {
                this.f260181a = new WeakReference<>(hVar);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            h hVar;
            WebViewPlugin.b bVar;
            Activity a16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent != null && (hVar = this.f260181a.get()) != null && (bVar = hVar.mRuntime) != null && (a16 = bVar.a()) != null && !a16.isFinishing()) {
                y d16 = bVar.d(bVar.a());
                if (d16 != null && (d16 instanceof r)) {
                    String currentUrl = ((r) d16).getCurrentUrl();
                    if (!TextUtils.isEmpty(currentUrl) && currentUrl.contains(MttLoader.ENTRY_ID)) {
                        hVar.f260162e = URLUtil.getInt(URLUtil.getArgumentsFromURL(currentUrl), MttLoader.ENTRY_ID, 2);
                    } else {
                        hVar.f260162e = 2;
                    }
                }
                a16.finish();
                Intent profileCardIntentOnly = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(bVar.a(), new AllInOne(bVar.b().getCurrentAccountUin(), 0));
                if (hVar.f260162e == 0) {
                    profileCardIntentOnly.setFlags(67108864);
                }
                bVar.a().startActivity(profileCardIntentOnly);
                Intent intent2 = new Intent();
                intent2.putExtra("closeSpecialLogic", true);
                bVar.a().setResult(-1, intent2);
                bVar.a().finish();
                VasCommonReporter.getDiyCard().setValue1("set diy end").report();
            }
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f260161d = VasNormalToggle.VAS_PROFILE_CARD_TEMP_SWITCH.isEnable(true);
        this.f260162e = -1;
        this.f260163f = new a();
        this.f260164h = new AtomicInteger(-1);
        this.f260165i = new AtomicInteger(0);
        this.f260166m = Collections.synchronizedList(new ArrayList());
        this.C = null;
        this.D = 0;
        this.E = 1;
        this.F = 2;
        this.G = null;
        this.H = false;
    }

    private void A() {
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("selectPhoto", "", this.mOnRemoteResp.key, new Bundle()), false, false);
    }

    private void B() {
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("takePhoto", "", this.mOnRemoteResp.key, new Bundle()), false, false);
    }

    private boolean s(String str, JSONObject jSONObject) throws JSONException {
        long y16 = ProfileCardUtil.y();
        if (y16 < RFixConstants.MD5_FILE_BUF_LENGTH) {
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCardWebviewPlugin", 2, "Insufficient SDCard space, reserved:" + RFixConstants.MD5_FILE_BUF_LENGTH + "|available:" + y16);
            }
            jSONObject.put("result", -3);
            jSONObject.put("message", "Insufficient SDCard space.");
            callPJs(str, jSONObject.toString());
            return true;
        }
        return false;
    }

    private void t() {
        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openKuiklySchema(this.mRuntime.a(), ((IVasDiyCardBgKuikly) QRoute.api(IVasDiyCardBgKuikly.class)).getScheme(), null);
    }

    private void u() {
        v();
        ActionSheet createMenuSheet = ActionSheet.createMenuSheet(this.mRuntime.a());
        this.C = createMenuSheet;
        createMenuSheet.addButton(this.mRuntime.a().getResources().getString(R.string.heb));
        this.C.addButton(this.mRuntime.a().getResources().getString(R.string.hel));
        this.C.addButton(this.mRuntime.a().getResources().getString(R.string.cancel));
        this.C.setOnButtonClickListener(new e());
        this.C.setCanceledOnTouchOutside(true);
        try {
            this.C.show();
            ReportController.o(null, "CliOper", "", "", "card_mall", "0X80066C9", 0, 0, "", "", "", "");
        } catch (Exception unused) {
        }
    }

    private void v() {
        ActionSheet actionSheet = this.C;
        if (actionSheet != null && actionSheet.isShowing()) {
            try {
                this.C.dismiss();
            } catch (Exception unused) {
            } catch (Throwable th5) {
                this.C = null;
                throw th5;
            }
            this.C = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(JSONObject jSONObject, String str, int i3) {
        try {
            jSONObject.put("result", i3);
            jSONObject.put("message", "onHttpEnd");
            callPJs(str, jSONObject.toString());
        } catch (Exception e16) {
            QLog.i("ProfileCardWebviewPlugin", 1, "startQueryInfo callback error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i3) {
        if (!this.H) {
            this.H = true;
            if (ar.b("kenaiyu", "2024-02-22", "vas_bug_120056993").isEnable(true)) {
                this.f260163f = new f(this);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.action.closeWeb");
            this.mRuntime.a().getApplication().registerReceiver(this.f260163f, intentFilter, "com.tencent.msg.permission.pushnotify", null);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    v();
                    ReportController.o(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "3", "", "", "");
                    return;
                }
                return;
            }
            B();
            v();
            ReportController.o(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "2", "", "", "");
            return;
        }
        A();
        v();
        ReportController.o(null, "CliOper", "", "", "card_mall", "0X80066CA", 0, 0, "1", "", "", "");
    }

    public void callPJs(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCardWebviewPlugin", 2, "method:" + str + ", json:" + str2);
        }
        callJs(str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IndividuationUrlHelper.UrlId.CARD_HOME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x03a6: MOVE (r4 I:??[OBJECT, ARRAY]) = (r19 I:??[OBJECT, ARRAY]), block:B:377:0x03a4 */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x03a8: MOVE (r3 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]), block:B:377:0x03a4 */
    /* JADX WARN: Type inference failed for: r10v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v100 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v157 */
    /* JADX WARN: Type inference failed for: r1v183 */
    /* JADX WARN: Type inference failed for: r1v66, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v8, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v86 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jSONObject;
        ?? r46;
        String str4;
        Exception exc;
        String str5;
        ?? r16;
        String str6;
        boolean equals;
        String str7;
        String str8;
        String str9;
        JSONObject jSONObject2;
        String str10;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (str2 == null || !str2.equalsIgnoreCase(IndividuationUrlHelper.UrlId.CARD_HOME)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(strArr[0]);
        } catch (JSONException unused) {
            if (QLog.isColorLevel()) {
                QLog.i("ProfileCardWebviewPlugin", 2, "Failed to parse json str,json=" + strArr[0]);
            }
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ProfileCardWebviewPlugin", 2, "method:" + str3 + ", json:" + jSONObject.toString());
        }
        String str11 = "callback";
        JSONObject jSONObject3 = new JSONObject();
        ?? jSONObject4 = new JSONObject();
        Context applicationContext = this.mRuntime.a().getApplicationContext();
        try {
            str11 = jSONObject.optString("callback");
            if (QLog.isDebugVersion()) {
                try {
                    QLog.i("ProfileCardWebviewPlugin", 1, "handleJsRequest method:" + str3);
                } catch (Exception e16) {
                    exc = e16;
                    str6 = "message";
                    str4 = "result";
                    r16 = jSONObject4;
                    str5 = str6;
                    exc.printStackTrace();
                    try {
                        r16.put(str4, -1);
                        r16.put(str5, "ProfileCardWebviewPlugin Exception");
                        callPJs(str11, r16.toString());
                        return true;
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                        return true;
                    }
                }
            }
            VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report(false);
            equals = str3.equals("getInfo");
            str7 = VasCommonJsbProxy.JSON_KEY_SET_KEY;
        } catch (Exception e18) {
            e = e18;
            r46 = "message";
            str4 = "result";
        }
        if (equals) {
            if (this.proxy != null && this.f260161d) {
                this.proxy.cardProfileGetInfo(jSONObject.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY), VasNormalToggle.VAS_BUG_118008826.isEnable(true), new b(jSONObject3, jSONObject4, str11));
                return true;
            }
            sendRemoteReq(com.tencent.mobileqq.emosm.a.a("card_getinfo", str11, this.mOnRemoteResp.key, new Bundle()), false, false);
            return true;
        }
        String str12 = "bgId";
        try {
        } catch (Exception e19) {
            exc = e19;
            r16 = jSONObject4;
            str5 = str8;
            str4 = str9;
        }
        if (str3.equals("setSummaryCard")) {
            VasLogReporter.getProfileCard().reportHighest("jsb setSummaryCard " + jSONObject);
            Bundle a16 = com.tencent.mobileqq.emosm.a.a("card_setSummaryCard", str11, this.mOnRemoteResp.key, new Bundle());
            a16.putInt("styleId", jSONObject.getInt("styleId"));
            a16.putInt("bgId", jSONObject.optInt("bgId", 0));
            a16.putLong("cardId", jSONObject.optLong("cardId", 0L));
            a16.putString("extInfo", jSONObject.optString("extInfo"));
            a16.putString("renderInfo", jSONObject.optString("renderInfo"));
            if (this.proxy != null && this.f260161d) {
                String optString = jSONObject.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY, "");
                int optInt = jSONObject.optInt("bgId", 0);
                this.proxy.cardProfileSetUp(optString, jSONObject.optInt("styleId", 0), optInt, jSONObject.optLong("cardId", 0L), jSONObject.optString("extInfo"), jSONObject.optString("renderInfo"), new c(jSONObject4, str11, optString, optInt));
                return true;
            }
            sendRemoteReq(a16, false, false);
            return true;
        }
        try {
            if (str3.equals("download")) {
                int optInt2 = jSONObject.optInt("id");
                QQVasUpdateBusiness<?> s16 = ProfileCardManager.s();
                try {
                    if (s16 != null) {
                        if (s16.isFileExists(optInt2)) {
                            try {
                                jSONObject4.put("result", 0);
                                jSONObject4.put("message", "local has");
                                callPJs(str11, jSONObject4.toString());
                                return true;
                            } catch (Exception e26) {
                                exc = e26;
                                r16 = jSONObject4;
                                str4 = "result";
                                str5 = "message";
                            }
                        } else {
                            str12 = "message";
                            str7 = "result";
                            if (s(str11, jSONObject4)) {
                                return true;
                            }
                            int a17 = com.tencent.mobileqq.webview.js.a.a(optInt2, s16, new d(jSONObject4, str11));
                            try {
                                if (a17 == 3) {
                                    jSONObject4.put(str12, "local has");
                                    w(jSONObject4, str11, 0);
                                } else {
                                    if (a17 != 2) {
                                        return true;
                                    }
                                    QLog.i("ProfileCardWebviewPlugin", 1, "\u5f00\u59cb\u4e0b\u8f7d");
                                }
                                return true;
                            } catch (Exception e27) {
                                jSONObject4.put(str12, e27.getMessage());
                                w(jSONObject4, str11, -1);
                                return true;
                            }
                        }
                    } else {
                        String string = jSONObject.getString("image_url");
                        String optString2 = jSONObject.optString("dynamicZip");
                        JSONObject jSONObject5 = jSONObject;
                        long j3 = optInt2;
                        if (ProfileCardManager.w(applicationContext, j3, "cardPreview.jpg")) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ProfileCardWebviewPlugin", 2, "handleJsRequest bg exists, dynamicZip = " + optString2);
                            }
                            if (TextUtils.isEmpty(optString2)) {
                                jSONObject4.put("result", 0);
                                jSONObject4.put("message", "local has");
                                callPJs(str11, jSONObject4.toString());
                                return true;
                            }
                            if (ProfileCardManager.w(applicationContext, j3, ".dynamic")) {
                                jSONObject4.put("result", 0);
                                jSONObject4.put("message", "local has");
                                callPJs(str11, jSONObject4.toString());
                                return true;
                            }
                        }
                        if (!NetworkUtil.isNetSupport(this.mRuntime.a().getApplicationContext())) {
                            jSONObject4.put("result", -2);
                            jSONObject4.put("message", RaffleJsPlugin.ERROR_REPORT_NO_NETWORK);
                            callPJs(str11, jSONObject4.toString());
                            return true;
                        }
                        if (s(str11, jSONObject4)) {
                            return true;
                        }
                        if (this.f260165i.get() == 1 && this.f260166m.get(this.f260164h.get()).f260258j == m.f260248n && this.f260166m.get(this.f260164h.get()).f260250b.equalsIgnoreCase(string) && jSONObject5.getLong("id") == this.f260166m.get(this.f260164h.get()).f260249a.longValue()) {
                            this.f260166m.get(this.f260164h.get()).f260258j = m.f260246l;
                            this.f260166m.get(this.f260164h.get()).f260256h = str11;
                            return true;
                        }
                        m mVar = new m();
                        mVar.f260249a = Long.valueOf(j3);
                        mVar.f260250b = string;
                        mVar.f260251c = optString2;
                        mVar.f260256h = str11;
                        mVar.f260255g = 0;
                        mVar.f260258j = m.f260245k;
                        this.f260166m.add(mVar);
                        if (this.f260165i.get() != 0) {
                            return true;
                        }
                        x();
                        return true;
                    }
                } catch (Exception e28) {
                    exc = e28;
                    r16 = jSONObject4;
                    str4 = str7;
                    str5 = str12;
                }
            } else {
                str4 = "result";
                try {
                    if (str3.equals("queryDownloadInfo")) {
                        try {
                            String string2 = jSONObject.getString("image_url");
                            String optString3 = jSONObject.optString("dynamicZip");
                            int optInt3 = jSONObject.optInt("id");
                            if (this.proxy != null && this.f260161d) {
                                callPJs(str11, VasTransformUtils.INSTANCE.transformProfileCard(this.proxy.queryInfo(jSONObject.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY), optInt3, QQVasUpdateBusiness.getBusiness(ProfileCardBusiness.class))));
                                return true;
                            }
                            long j16 = optInt3;
                            if (ProfileCardManager.w(applicationContext, j16, "cardPreview.jpg") && (TextUtils.isEmpty(optString3) || ProfileCardManager.w(applicationContext, j16, ".dynamic"))) {
                                jSONObject2 = jSONObject3;
                                jSONObject2.put("status", 3);
                                jSONObject2.put("progress", 100);
                                jSONObject4.put(str4, 0);
                            } else {
                                jSONObject2 = jSONObject3;
                                if (this.f260164h.get() < 0) {
                                    jSONObject2.put("status", 1);
                                    jSONObject2.put("progress", 0);
                                    jSONObject4.put(str4, 0);
                                } else {
                                    int i3 = this.f260164h.get();
                                    while (true) {
                                        if (i3 >= this.f260166m.size()) {
                                            break;
                                        }
                                        if (this.f260166m.get(i3).f260250b.equalsIgnoreCase(string2) && j16 == this.f260166m.get(i3).f260249a.longValue()) {
                                            str10 = string2;
                                            if (this.f260166m.get(i3).f260258j != m.f260248n) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.i("ProfileCardWebviewPlugin", 2, "mIndex:" + this.f260164h.get() + ",id:" + this.f260166m.get(i3).f260249a + "status:" + this.f260166m.get(i3).f260258j);
                                                }
                                                if (this.f260166m.get(i3).f260258j != m.f260245k && this.f260166m.get(i3).f260258j != m.f260246l) {
                                                    if (this.f260166m.get(i3).f260258j == m.f260247m) {
                                                        jSONObject2.put("status", 1);
                                                        jSONObject2.put("progress", this.f260166m.get(i3).f260255g);
                                                    } else {
                                                        jSONObject2.put("status", 1);
                                                        jSONObject2.put("progress", 0);
                                                    }
                                                    jSONObject4.put(str4, this.f260166m.get(i3).f260257i);
                                                }
                                                Bundle a18 = com.tencent.mobileqq.emosm.a.a("card_query_download", str11, this.mOnRemoteResp.key, new Bundle());
                                                a18.putInt("bgId", optInt3);
                                                sendRemoteReq(a18, false, false);
                                                return true;
                                            }
                                        } else {
                                            str10 = string2;
                                        }
                                        i3++;
                                        string2 = str10;
                                    }
                                    if (i3 >= this.f260166m.size()) {
                                        jSONObject2.put("status", 1);
                                        jSONObject2.put("progress", 0);
                                        jSONObject4.put(str4, 0);
                                    }
                                }
                            }
                            jSONObject4.put("data", jSONObject2);
                            callPJs(str11, jSONObject4.toString());
                            return true;
                        } catch (Exception e29) {
                            exc = e29;
                            r16 = jSONObject4;
                            str5 = "message";
                        }
                    } else {
                        try {
                            r46 = str3.equals("preview");
                            try {
                                if (r46 != 0) {
                                    try {
                                        Intent intent = new Intent(this.mRuntime.a(), (Class<?>) VipProfileCardPreviewActivity.class);
                                        intent.putExtra("preview", jSONObject.toString());
                                        super.startActivityForResult(intent, (byte) 1);
                                        jSONObject4.put(str4, 0);
                                        jSONObject4.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                                        callPJs(str11, jSONObject4.toString());
                                        return true;
                                    } catch (Exception e36) {
                                        e = e36;
                                        r46 = "message";
                                        exc = e;
                                        str6 = r46;
                                        r16 = jSONObject4;
                                        str5 = str6;
                                        exc.printStackTrace();
                                        r16.put(str4, -1);
                                        r16.put(str5, "ProfileCardWebviewPlugin Exception");
                                        callPJs(str11, r16.toString());
                                        return true;
                                    }
                                }
                                r46 = "message";
                                try {
                                    if (str3.equals("getTime")) {
                                        jSONObject4.put("data", NetConnInfoCenter.getServerTimeMillis());
                                        jSONObject4.put(str4, 0);
                                        jSONObject4.put(r46, "");
                                        callPJs(str11, jSONObject4.toString());
                                        return true;
                                    }
                                    if (str3.equals("cancelDownload")) {
                                        String string3 = jSONObject.getString("image_url");
                                        long j17 = jSONObject.getLong("id");
                                        if (this.f260164h.get() == -1) {
                                            this.f260164h.set(0);
                                        }
                                        int i16 = this.f260164h.get();
                                        while (true) {
                                            if (i16 < this.f260166m.size()) {
                                                if (this.f260166m.get(i16).f260249a.longValue() == j17 && this.f260166m.get(i16).f260250b.equalsIgnoreCase(string3) && this.f260166m.get(i16).f260258j != m.f260248n) {
                                                    Bundle a19 = com.tencent.mobileqq.emosm.a.a("card_cancel_download", str11, this.mOnRemoteResp.key, new Bundle());
                                                    a19.putLong("bgId", j17);
                                                    sendRemoteReq(a19, false, false);
                                                    this.f260165i.set(0);
                                                    this.f260166m.get(i16).f260258j = m.f260248n;
                                                    jSONObject4.put(str4, 0);
                                                    jSONObject4.put(r46, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                                                    break;
                                                }
                                                i16++;
                                            } else {
                                                break;
                                            }
                                        }
                                        if (i16 == this.f260166m.size()) {
                                            jSONObject4.put(str4, -2);
                                            jSONObject4.put(r46, "cancel download fail\uff0c bgId:" + j17);
                                        }
                                        callPJs(str11, jSONObject4.toString());
                                        ?? jSONObject6 = new JSONObject();
                                        try {
                                            jSONObject6.put(str4, -1);
                                            jSONObject6.put(r46, "cancel download bgUrl:" + this.f260166m.get(i16).f260250b);
                                            callPJs(this.f260166m.get(i16).f260256h, jSONObject6.toString());
                                            return true;
                                        } catch (JSONException e37) {
                                            e37.printStackTrace();
                                            return true;
                                        }
                                    }
                                    if (str3.equals("report")) {
                                        Bundle a26 = com.tencent.mobileqq.emosm.a.a("card_getVipInfo", str11, this.mOnRemoteResp.key, new Bundle());
                                        a26.putString("op_name", jSONObject.getString("op_name"));
                                        a26.putString("ext1", jSONObject.getString("ext1"));
                                        a26.putString("ext2", jSONObject.getString("ext2"));
                                        a26.putString("ext3", jSONObject.getString("ext3"));
                                        sendRemoteReq(a26, false, false);
                                        return true;
                                    }
                                    if (str3.equals("openView")) {
                                        String string4 = jSONObject.getString("ADTAG");
                                        Activity a27 = this.mRuntime.a();
                                        if (a27 == null) {
                                            return true;
                                        }
                                        Intent intent2 = new Intent(a27, (Class<?>) QQBrowserActivity.class);
                                        intent2.putExtra("uin", this.mRuntime.b().getAccount());
                                        intent2.putExtra("isShowAd", false);
                                        intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                                        intent2.putExtra("url", IndividuationUrlHelper.getMarketUrl(a27, IndividuationUrlHelper.UrlId.CARD_HOME, string4));
                                        a27.startActivity(intent2);
                                        return true;
                                    }
                                    if (str3.equals("clickPhotoWall")) {
                                        WebViewPlugin.b bVar = this.mRuntime;
                                        y d16 = bVar.d(bVar.a());
                                        if (d16 != null && (d16 instanceof r)) {
                                            String currentUrl = ((r) d16).getCurrentUrl();
                                            if (!TextUtils.isEmpty(currentUrl) && currentUrl.contains(MttLoader.ENTRY_ID)) {
                                                this.f260162e = URLUtil.getInt(URLUtil.getArgumentsFromURL(currentUrl), MttLoader.ENTRY_ID, 2);
                                            } else {
                                                this.f260162e = 2;
                                            }
                                        }
                                        String account = this.mRuntime.b().getAccount();
                                        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                                        userInfo.qzone_uin = account;
                                        QZoneHelper.forwardToCoverPhotoWall(this.mRuntime.a(), userInfo, null, account, getRequestCode((byte) 2));
                                        return true;
                                    }
                                    if (str3.equals("uploadBackground")) {
                                        if (((IVasDiyCardBgKuikly) QRoute.api(IVasDiyCardBgKuikly.class)).isEnable()) {
                                            t();
                                        } else {
                                            u();
                                        }
                                        jSONObject4.put(str4, 0);
                                        jSONObject4.put(r46, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                                        callPJs(str11, jSONObject4.toString());
                                        return true;
                                    }
                                    if (str3.equals("setGameHonour")) {
                                        Bundle a28 = com.tencent.mobileqq.emosm.a.a("card_set_custom_honor", str11, this.mOnRemoteResp.key, new Bundle());
                                        a28.putString("honor_data", jSONObject.toString());
                                        sendRemoteReq(a28, false, false);
                                        return true;
                                    }
                                    try {
                                        if (str3.equals("downloadWzResource")) {
                                            long optLong = jSONObject.optLong("id");
                                            String optString4 = jSONObject.optString("bgUrl");
                                            jSONObject.optString("dynamicZip");
                                            String optString5 = jSONObject.optString("wzHeroUrl");
                                            try {
                                                boolean z16 = p.f((long) jSONObject.optInt("styleId")) && p.d(VasUpdateConstants.SCID_WZRY_TEMPLATE);
                                                boolean z17 = !TextUtils.isEmpty(optString4) && ProfileCardManager.w(applicationContext, optLong, "wzJoinImage.png");
                                                boolean z18 = !TextUtils.isEmpty(optString5) && ProfileCardManager.w(applicationContext, optLong, "wzMainImage.png");
                                                if (z16 && z17) {
                                                    if (!TextUtils.isEmpty(optString5) ? ProfileCardManager.w(applicationContext, optLong, "wzMainImage.png") : true) {
                                                        jSONObject4.put(str4, 0);
                                                        jSONObject4.put("progress", 100);
                                                        callJs(str11, jSONObject4.toString());
                                                        return true;
                                                    }
                                                }
                                                if (!NetworkUtil.isNetSupport(this.mRuntime.a().getApplicationContext())) {
                                                    jSONObject4.put(str4, -2);
                                                    jSONObject4.put(r46, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK);
                                                    callPJs(str11, jSONObject4.toString());
                                                    return true;
                                                }
                                                if (s(str11, jSONObject4)) {
                                                    return true;
                                                }
                                                if (!this.f260166m.isEmpty() && this.f260164h.get() >= 0 && this.f260164h.get() < this.f260166m.size()) {
                                                    m mVar2 = this.f260166m.get(this.f260164h.get());
                                                    if (this.f260165i.get() == 1 && mVar2.f260258j.equals(m.f260248n) && mVar2.f260250b.equalsIgnoreCase(optString4) && optLong == mVar2.f260249a.longValue()) {
                                                        mVar2.f260258j = m.f260246l;
                                                        mVar2.f260256h = str11;
                                                        return true;
                                                    }
                                                }
                                                m mVar3 = new m();
                                                mVar3.f260249a = Long.valueOf(optLong);
                                                mVar3.f260250b = optString4;
                                                mVar3.f260256h = str11;
                                                mVar3.f260252d = z18 ? null : optString5;
                                                mVar3.f260254f = !z16;
                                                mVar3.f260253e = true;
                                                mVar3.f260255g = 0;
                                                mVar3.f260258j = m.f260245k;
                                                this.f260166m.add(mVar3);
                                                if (this.f260165i.get() != 0) {
                                                    return true;
                                                }
                                                x();
                                                return true;
                                            } catch (Exception e38) {
                                                e = e38;
                                                applicationContext = jSONObject4;
                                                exc = e;
                                                r16 = applicationContext;
                                                str5 = r46;
                                                exc.printStackTrace();
                                                r16.put(str4, -1);
                                                r16.put(str5, "ProfileCardWebviewPlugin Exception");
                                                callPJs(str11, r16.toString());
                                                return true;
                                            }
                                        }
                                        if (!str3.equals("setSwitchOfKingGlory")) {
                                            return false;
                                        }
                                        int optInt4 = jSONObject.optInt("status");
                                        Bundle bundle = new Bundle();
                                        bundle.putInt("status", optInt4);
                                        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_plateofking_switch", str11, this.mOnRemoteResp.key, bundle), false, false);
                                        return true;
                                    } catch (Exception e39) {
                                        e = e39;
                                    }
                                } catch (Exception e46) {
                                    e = e46;
                                    applicationContext = jSONObject4;
                                    exc = e;
                                    r16 = applicationContext;
                                    str5 = r46;
                                    exc.printStackTrace();
                                    r16.put(str4, -1);
                                    r16.put(str5, "ProfileCardWebviewPlugin Exception");
                                    callPJs(str11, r16.toString());
                                    return true;
                                }
                            } catch (Exception e47) {
                                e = e47;
                            }
                        } catch (Exception e48) {
                            e = e48;
                            applicationContext = jSONObject4;
                            r46 = "message";
                        }
                    }
                } catch (Exception e49) {
                    e = e49;
                    r46 = "message";
                }
            }
        } catch (Exception e56) {
            e = e56;
            applicationContext = jSONObject4;
            r46 = "message";
            str4 = "result";
        }
        exc.printStackTrace();
        r16.put(str4, -1);
        r16.put(str5, "ProfileCardWebviewPlugin Exception");
        callPJs(str11, r16.toString());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        if (r6.f260162e != 0) goto L19;
     */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(Intent intent, byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCardWebviewPlugin", 2, "ProfileCardWebviewPlugin onActivityResult,requestCode = " + ((int) b16) + ", resultCode = " + i3 + ", data = " + intent);
        }
        if (i3 == -1 && intent != null) {
            if (b16 != 1) {
                if (b16 == 2) {
                    try {
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                intent.putExtra("closeSpecialLogic", true);
                this.mRuntime.a().setResult(-1, intent);
                this.mRuntime.a().finish();
            }
            String stringExtra = intent.getStringExtra("uin");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = this.mRuntime.b().getCurrentAccountUin();
            }
            this.mRuntime.a().startActivity(((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.mRuntime.a(), new AllInOne(stringExtra, 0)));
            intent.putExtra("closeSpecialLogic", true);
            this.mRuntime.a().setResult(-1, intent);
            this.mRuntime.a().finish();
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onCreate();
            this.G = new DownloaderFactory(this.mRuntime.b());
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDestroy();
        this.G.onDestroy();
        try {
            if (this.H) {
                this.mRuntime.a().unregisterReceiver(this.f260163f);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCardWebviewPlugin", 2, "unregister receiver exception:" + e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        if (bundle != null) {
            try {
                if (bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    String string = bundle.getString("cmd");
                    String string2 = bundle.getString("callbackid");
                    Bundle bundle2 = bundle.getBundle("response");
                    if (string != null) {
                        if (QLog.isDebugVersion()) {
                            QLog.i("ProfileCardWebviewPlugin", 1, "onResponse method:" + string);
                        }
                        if ("card_getinfo".equals(string)) {
                            long j3 = bundle2.getLong("currentId");
                            try {
                                long j16 = bundle2.getLong("styleId");
                                int i16 = bundle2.getInt("result");
                                String string3 = bundle2.getString("diy_url");
                                if (j16 != ProfileCardTemplate.PROFILE_CARD_STYLE_SOCIAL && j16 != ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID && j16 != ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE) {
                                    i3 = 0;
                                    jSONObject.put("currentId", j3);
                                    jSONObject.put("styleId", j16);
                                    jSONObject.put("isPhotoWall", i3);
                                    jSONObject.put("url", string3);
                                    jSONObject2.put("data", jSONObject);
                                    jSONObject2.put("result", i16);
                                    callPJs(string2, jSONObject2.toString());
                                    return;
                                }
                                i3 = 1;
                                jSONObject.put("currentId", j3);
                                jSONObject.put("styleId", j16);
                                jSONObject.put("isPhotoWall", i3);
                                jSONObject.put("url", string3);
                                jSONObject2.put("data", jSONObject);
                                jSONObject2.put("result", i16);
                                callPJs(string2, jSONObject2.toString());
                                return;
                            } catch (Exception e16) {
                                e = e16;
                                e.printStackTrace();
                            }
                        }
                        if ("card_setSummaryCard".equals(string)) {
                            int i17 = bundle2.getInt("result");
                            String string4 = bundle2.getString("message");
                            jSONObject2.put("result", i17);
                            jSONObject2.put("message", string4);
                            callPJs(string2, jSONObject2.toString());
                            return;
                        }
                        if ("card_getVipInfo".equals(string)) {
                            ReportController.o(null, "P_CliOper", "Vip_SummaryCard", "", bundle.getString("op_name"), bundle.getString("op_name"), 0, 0, bundle.getString("ext1"), bundle.getString("ext2"), bundle.getString("ext3"), bundle2.getString("vip_info"));
                            jSONObject2.put("result", 0);
                            jSONObject2.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                            callPJs(string2, jSONObject2.toString());
                            return;
                        }
                        if (!"selectPhoto".equals(string) && !"takePhoto".equals(string)) {
                            if ("card_download_wzry_template".equals(string)) {
                                int i18 = bundle2.getInt("result");
                                String string5 = bundle2.getString("message");
                                if (i18 != 0) {
                                    jSONObject2.put("result", -1);
                                    jSONObject2.put("message", string5);
                                    callPJs(string2, jSONObject2.toString());
                                    this.f260165i.set(0);
                                    return;
                                }
                                Bundle a16 = com.tencent.mobileqq.emosm.a.a("card_download", string2, this.mOnRemoteResp.key, new Bundle());
                                a16.putLong("bgId", bundle.getLong("bgId"));
                                sendRemoteReq(a16, false, false);
                                return;
                            }
                            if ("card_download".equals(string)) {
                                jSONObject2.put("result", bundle2.getInt("result"));
                                jSONObject2.put("message", "onHttpEnd");
                                try {
                                    if (this.f260166m.get(this.f260164h.get()).f260258j != m.f260248n) {
                                        this.f260166m.get(this.f260164h.get()).f260258j = m.f260247m;
                                    }
                                    this.f260166m.get(this.f260164h.get()).f260255g = 100;
                                } catch (Exception e17) {
                                    QLog.i("ProfileCardWebviewPlugin", 1, "IPC_CARD_DOWNLOAD", e17);
                                }
                                callPJs(string2, jSONObject2.toString());
                                this.f260165i.set(0);
                                x();
                                return;
                            }
                            if ("card_query_download".equals(string)) {
                                jSONObject2.put("result", 0);
                                jSONObject.put("status", 2);
                                int i19 = bundle2.getInt("progress");
                                jSONObject.put("progress", i19);
                                if (this.f260166m.get(this.f260164h.get()).f260258j != m.f260247m) {
                                    this.f260166m.get(this.f260164h.get()).f260255g = Integer.valueOf(i19);
                                }
                                jSONObject2.put("data", jSONObject);
                                callPJs(string2, jSONObject2.toString());
                            }
                        }
                    }
                }
            } catch (Exception e18) {
                e = e18;
                e.printStackTrace();
            }
        }
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f260165i.get() == 1) {
            return;
        }
        try {
            if (z() == 0) {
                m mVar = this.f260166m.get(this.f260164h.get());
                String str = mVar.f260256h;
                Long l3 = mVar.f260249a;
                if (mVar.f260254f) {
                    mVar.f260254f = false;
                    this.f260165i.set(1);
                    Bundle a16 = com.tencent.mobileqq.emosm.a.a("card_download_wzry_template", str, this.mOnRemoteResp.key, new Bundle());
                    a16.putLong("bgId", l3.longValue());
                    sendRemoteReq(a16, false, false);
                } else {
                    this.f260165i.set(1);
                    Bundle a17 = com.tencent.mobileqq.emosm.a.a("card_download", str, this.mOnRemoteResp.key, new Bundle());
                    a17.putLong("bgId", l3.longValue());
                    sendRemoteReq(a17, false, false);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public int z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        if (this.f260166m == null) {
            return -1;
        }
        if (this.f260164h.get() < 0) {
            if (this.f260166m.size() <= 0) {
                return -1;
            }
            this.f260164h.set(0);
            return 0;
        }
        if (this.f260164h.get() < this.f260166m.size() && this.f260164h.get() >= 0) {
            int i3 = this.f260164h.get();
            do {
                i3++;
                if (i3 >= this.f260166m.size()) {
                    return -1;
                }
                this.f260164h.set(i3);
            } while (this.f260166m.get(i3).f260258j != m.f260245k);
            return 0;
        }
        this.f260164h.set(-1);
        return -2;
    }
}
