package com.tencent.biz.webviewplugin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.g;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class OfflinePlugin extends WebViewPlugin {

    /* renamed from: b0, reason: collision with root package name */
    public static HashMap<String, v> f97342b0;

    /* renamed from: e0, reason: collision with root package name */
    private static Context f97345e0;
    ProgressBar C;
    public String H;
    public OfflineWebResManager P;
    Handler R;
    protected CopyOnWriteArraySet<String> W;
    protected CopyOnWriteArrayList<String> X;

    /* renamed from: d, reason: collision with root package name */
    private AuthorizeConfig f97349d;

    /* renamed from: e, reason: collision with root package name */
    private String f97350e;

    /* renamed from: f, reason: collision with root package name */
    private String f97351f;

    /* renamed from: h, reason: collision with root package name */
    RelativeLayout f97352h;

    /* renamed from: i, reason: collision with root package name */
    LinearLayout f97353i;

    /* renamed from: m, reason: collision with root package name */
    TextView f97354m;

    /* renamed from: c0, reason: collision with root package name */
    static final int f97343c0 = Build.VERSION.SDK_INT;

    /* renamed from: d0, reason: collision with root package name */
    private static boolean f97344d0 = false;

    /* renamed from: f0, reason: collision with root package name */
    public static ConcurrentHashMap<String, ArrayList<String>> f97346f0 = new ConcurrentHashMap<>();

    /* renamed from: g0, reason: collision with root package name */
    public static HashMap<String, String> f97347g0 = new HashMap<>();
    boolean D = false;
    boolean E = false;
    boolean F = false;
    public volatile int G = 0;
    public volatile int I = 0;
    public volatile boolean J = false;
    public volatile boolean K = false;
    public volatile long L = -1;
    public volatile long M = -1;
    public AtomicBoolean N = new AtomicBoolean(false);
    public HashSet<String> Q = new HashSet<>(6);
    private boolean S = false;
    public boolean T = false;
    public AtomicInteger U = new AtomicInteger(0);
    public String V = "";
    private View.OnClickListener Y = new e();
    private com.tencent.biz.common.util.f Z = new f();

    /* renamed from: a0, reason: collision with root package name */
    public Runnable f97348a0 = new Runnable() { // from class: com.tencent.biz.webviewplugin.OfflinePlugin.9
        @Override // java.lang.Runnable
        public void run() {
            v vVar;
            HashMap<String, v> hashMap = OfflinePlugin.f97342b0;
            if (hashMap != null && (vVar = hashMap.get(OfflinePlugin.this.f97351f)) != null && vVar.d() == 1) {
                LinearLayout linearLayout = OfflinePlugin.this.f97353i;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                ProgressBar progressBar = OfflinePlugin.this.C;
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                }
                vVar.f(2);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            v vVar;
            OfflinePlugin offlinePlugin = OfflinePlugin.this;
            if (offlinePlugin.D) {
                return;
            }
            if (message.what == 121) {
                offlinePlugin.G(message);
            }
            int i3 = message.arg1;
            if (i3 == 1) {
                OfflinePlugin.this.G = message.arg2;
                String str = (String) message.obj;
                CustomWebView e16 = OfflinePlugin.this.mRuntime.e();
                if (e16 == null) {
                    return;
                }
                if (OfflinePlugin.this.L == -1) {
                    OfflinePlugin.this.L = System.currentTimeMillis();
                }
                e16.loadUrlOriginal(str);
                e16.requestFocus();
                if (QLog.isColorLevel()) {
                    QLog.i("OfflinePluginQQ", 2, "mCheckupHandler loadUrl start \n" + str);
                }
                OfflinePlugin.this.u(str);
            } else if (i3 == 2) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("OfflinePluginQQ", 4, "checkOfflineUpBack refresh current url");
                }
                OfflinePlugin.this.N();
            } else if (i3 == 3) {
                try {
                    OfflinePlugin.this.x((JSONObject) message.obj);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
            Activity a16 = OfflinePlugin.this.mRuntime.a();
            WebViewPlugin.b bVar = OfflinePlugin.this.mRuntime;
            com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
            if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.f)) {
                int i16 = message.arg1;
                if (i16 == 4) {
                    if (OfflinePlugin.f97342b0 != null && !TextUtils.isEmpty(OfflinePlugin.this.f97351f)) {
                        v vVar2 = OfflinePlugin.f97342b0.get(OfflinePlugin.this.f97351f);
                        ProgressBar progressBar = OfflinePlugin.this.C;
                        if (progressBar != null) {
                            progressBar.setProgress(message.arg2);
                        }
                        TextView textView = OfflinePlugin.this.f97354m;
                        if (textView != null) {
                            textView.setText(vVar2.D + message.arg2 + "%");
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i16 == 5 && OfflinePlugin.f97342b0 != null && !TextUtils.isEmpty(OfflinePlugin.this.f97351f) && (vVar = OfflinePlugin.f97342b0.get(OfflinePlugin.this.f97351f)) != null) {
                    OfflinePlugin.this.S(message, a16, vVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements SwiftBrowserOfflineHandler.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f97363a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f97364b;

        d(long j3, String str) {
            this.f97363a = j3;
            this.f97364b = str;
        }

        @Override // com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.b
        public void onCheckOfflineFinish(int i3) {
            OfflinePlugin.this.I = (int) (System.currentTimeMillis() - this.f97363a);
            if (QLog.isColorLevel()) {
                QLog.i("OfflinePluginQQ", 2, "onCheckOfflineFinish, cost: " + OfflinePlugin.this.I + ", url: " + com.tencent.mobileqq.webview.util.s.d(this.f97364b, new String[0]));
            }
            OfflinePlugin.this.R(this.f97364b, i3);
            CustomWebView e16 = OfflinePlugin.this.mRuntime.e();
            if (e16 != null) {
                e16.loadUrlOriginal(this.f97364b);
                return;
            }
            QLog.e("OfflinePluginQQ", 1, "error!!!! webview is null, now can not loadUrl " + this.f97364b);
        }
    }

    /* loaded from: classes5.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v vVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            Activity a16 = OfflinePlugin.this.mRuntime.a();
            if (a16 != null && OfflinePlugin.f97342b0 != null && !TextUtils.isEmpty(OfflinePlugin.this.f97351f) && (vVar = OfflinePlugin.f97342b0.get(OfflinePlugin.this.f97351f)) != null) {
                if (vVar.d() == 3) {
                    vVar.c0();
                    OfflinePlugin.this.O();
                    vVar.f(4);
                    RelativeLayout relativeLayout = OfflinePlugin.this.f97352h;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(8);
                    }
                    OfflinePlugin.f97342b0.remove(OfflinePlugin.this.f97351f);
                } else if (vVar.d() == 0) {
                    HtmlOffline.r(a16.getApplicationContext(), OfflinePlugin.this.f97351f, vVar.E, vVar.F, vVar);
                    vVar.f(1);
                    TextView textView = OfflinePlugin.this.f97354m;
                    if (textView != null) {
                        textView.setCompoundDrawables(null, null, null, null);
                    }
                    OfflinePlugin offlinePlugin = OfflinePlugin.this;
                    offlinePlugin.R.postDelayed(offlinePlugin.f97348a0, 2000L);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes5.dex */
    class f implements com.tencent.biz.common.util.f {
        f() {
        }

        @Override // com.tencent.biz.common.util.f
        public void c0() {
            CustomWebView e16;
            Activity a16 = OfflinePlugin.this.mRuntime.a();
            if (a16 == null) {
                return;
            }
            WebViewPlugin.b bVar = OfflinePlugin.this.mRuntime;
            com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
            if (QBaseActivity.sTopActivity != a16 && (e16 = OfflinePlugin.this.mRuntime.e()) != null) {
                try {
                    if (d16 instanceof com.tencent.mobileqq.webviewplugin.r) {
                        e16.loadUrl(((com.tencent.mobileqq.webviewplugin.r) d16).getCurrentUrl());
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            Message obtainMessage = OfflinePlugin.this.R.obtainMessage();
            obtainMessage.arg1 = 5;
            obtainMessage.arg2 = i3;
            OfflinePlugin.this.R.sendMessage(obtainMessage);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
            Message obtainMessage = OfflinePlugin.this.R.obtainMessage();
            obtainMessage.arg1 = 4;
            obtainMessage.arg2 = i3;
            OfflinePlugin.this.R.sendMessage(obtainMessage);
        }
    }

    private WebResourceResponse D(String str, String str2) {
        boolean z16;
        String v3 = HtmlOffline.v(str);
        WebResourceResponse webResourceResponse = null;
        if (!TextUtils.isEmpty(this.f97350e) && str2.equals(this.f97350e)) {
            z16 = false;
        } else {
            if (this.W == null) {
                this.W = new CopyOnWriteArraySet<>();
            }
            if (!this.W.contains(str2)) {
                this.W.add(str2);
                if (QLog.isColorLevel()) {
                    QLog.i("OfflinePluginQQ", 2, "now begin check ex bid : " + str2);
                }
                com.tencent.mobileqq.webview.util.s.a("OfflinePlugin_verifySign_" + str2);
                boolean R = HtmlOffline.R(str2) ^ true;
                com.tencent.mobileqq.webview.util.s.b("OfflinePlugin_verifySign_" + str2);
                if (R) {
                    this.W.remove(str2);
                    if (QLog.isColorLevel()) {
                        QLog.d("OfflinePluginQQ", 2, "verfySign fail to reload");
                    }
                    return null;
                }
            }
            z16 = true;
        }
        if (this.G == 3 || z16) {
            com.tencent.mobileqq.webview.util.s.a("OfflinePlugin_verifySingleFile_" + v3);
            boolean S = HtmlOffline.S(str2, str) ^ true;
            com.tencent.mobileqq.webview.util.s.b("OfflinePlugin_verifySingleFile_" + v3);
            if (S) {
                if (!z16) {
                    this.K = true;
                    N();
                }
                P(str2, "Offline_InterceptRequest", 0, 3, str, "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("OfflinePluginQQ", 2, "shouldInterceptRequest verfy single fail to reload");
                }
                return null;
            }
        }
        com.tencent.mobileqq.webview.util.s.a("OfflinePlugin_offlineGetResponse_" + v3);
        HtmlOffline.c B = HtmlOffline.B(str2, str);
        if (B != null) {
            webResourceResponse = new WebResourceResponse(B.f78433a, "utf-8", B.f78434b);
        }
        com.tencent.mobileqq.webview.util.s.b("OfflinePlugin_offlineGetResponse_" + v3);
        if (webResourceResponse != null) {
            this.S = true;
            if (!z16) {
                this.T = true;
            }
        }
        return webResourceResponse;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        if (r1 != null) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d A[Catch: all -> 0x0080, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:39:0x0078, B:34:0x007d), top: B:38:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String E(String str) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        ConcurrentHashMap<String, String> concurrentHashMap = HtmlOffline.f78404g;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
            return HtmlOffline.f78404g.get(str);
        }
        String str2 = com.tencent.biz.common.offline.c.c(str) + str + "/verify.json";
        String str3 = null;
        str3 = null;
        str3 = null;
        r2 = null;
        str3 = null;
        BufferedInputStream bufferedInputStream2 = null;
        if (!new File(str2).exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str2);
        } catch (Exception e16) {
            e = e16;
            bufferedInputStream = null;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(fileInputStream);
        } catch (Exception e17) {
            e = e17;
            bufferedInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            if (bufferedInputStream2 != null) {
            }
            if (fileInputStream != null) {
            }
            throw th;
        }
        try {
            try {
                str3 = com.tencent.biz.common.util.h.d(bufferedInputStream);
                HtmlOffline.f78404g.put(str, str3);
                bufferedInputStream.close();
            } catch (Throwable th7) {
                th = th7;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Throwable unused) {
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Exception e18) {
            e = e18;
            QLog.e("OfflinePluginQQ", 1, e.getMessage());
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        }
        fileInputStream.close();
        return str3;
    }

    private Boolean F() {
        v vVar;
        RelativeLayout relativeLayout;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            QLog.e("OfflinePluginQQ", 1, "handleEvent error mRuntime == null");
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                return Boolean.FALSE;
            }
            throw new RuntimeException("handleEvent error mRuntime == null");
        }
        Activity a16 = bVar.a();
        WebViewPlugin.b bVar2 = this.mRuntime;
        com.tencent.mobileqq.webview.swift.y d16 = bVar2.d(bVar2.a());
        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.f)) {
            RelativeLayout relativeLayout2 = this.f97352h;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            if (f97342b0 != null && !TextUtils.isEmpty(this.f97351f) && (vVar = f97342b0.get(this.f97351f)) != null) {
                H();
                vVar.a(this.Z);
                RelativeLayout relativeLayout3 = this.f97352h;
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(0);
                }
                LinearLayout linearLayout = this.f97353i;
                if (linearLayout != null) {
                    linearLayout.setOnClickListener(this.Y);
                }
                int d17 = vVar.d();
                if (d17 != 0) {
                    if (d17 != 1) {
                        if (d17 != 2) {
                            if (d17 != 3) {
                                if (d17 == 4 && (relativeLayout = this.f97352h) != null) {
                                    relativeLayout.setVisibility(8);
                                }
                            } else {
                                TextView textView = this.f97354m;
                                if (textView != null) {
                                    textView.setText(vVar.C);
                                }
                                if (a16 == null) {
                                    return Boolean.FALSE;
                                }
                                Drawable drawable = a16.getResources().getDrawable(R.drawable.common_green_checkbox);
                                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                                TextView textView2 = this.f97354m;
                                if (textView2 != null) {
                                    textView2.setCompoundDrawables(drawable, null, null, null);
                                }
                                ProgressBar progressBar = this.C;
                                if (progressBar != null) {
                                    progressBar.setVisibility(8);
                                }
                                LinearLayout linearLayout2 = this.f97353i;
                                if (linearLayout2 != null) {
                                    linearLayout2.setVisibility(0);
                                }
                            }
                        } else {
                            ProgressBar progressBar2 = this.C;
                            if (progressBar2 != null) {
                                progressBar2.setProgress(vVar.c());
                            }
                            ProgressBar progressBar3 = this.C;
                            if (progressBar3 != null) {
                                progressBar3.setVisibility(0);
                            }
                            LinearLayout linearLayout3 = this.f97353i;
                            if (linearLayout3 != null) {
                                linearLayout3.setVisibility(8);
                            }
                        }
                    } else {
                        TextView textView3 = this.f97354m;
                        if (textView3 != null) {
                            textView3.setText(vVar.D + vVar.c() + "%");
                        }
                        ProgressBar progressBar4 = this.C;
                        if (progressBar4 != null) {
                            progressBar4.setVisibility(0);
                        }
                        LinearLayout linearLayout4 = this.f97353i;
                        if (linearLayout4 != null) {
                            linearLayout4.setVisibility(0);
                        }
                    }
                } else if (K(a16, vVar)) {
                    return Boolean.FALSE;
                }
            }
            return null;
        }
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(Message message) {
        try {
            try {
                String str = (String) ((Object[]) message.obj)[1];
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("retcode", 0);
                jSONObject.put("data", com.tencent.mobileqq.webview.util.s.l(str));
                callJs(this.H, jSONObject.toString());
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + e16);
                }
            }
        } catch (Exception unused) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("retcode", -1);
            jSONObject2.put("msg", "error");
            callJs(this.H, jSONObject2.toString());
        }
    }

    private void H() {
        this.mRuntime.a();
    }

    private void I() {
        this.R = new b(Looper.getMainLooper());
    }

    private boolean K(Activity activity, v vVar) {
        TextView textView = this.f97354m;
        if (textView != null) {
            textView.setText(vVar.f97646m);
        }
        if (activity == null) {
            return true;
        }
        Drawable drawable = activity.getResources().getDrawable(R.drawable.qq_conversation_call_icon_detail_nor);
        drawable.setBounds(0, 0, 40, 40);
        TextView textView2 = this.f97354m;
        if (textView2 != null) {
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        ProgressBar progressBar = this.C;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        LinearLayout linearLayout = this.f97353i;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        return false;
    }

    private void L(final CustomWebView customWebView, final String str, final String str2) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.webviewplugin.OfflinePlugin.6
            @Override // java.lang.Runnable
            public void run() {
                HashSet<String> hashSet;
                String str3;
                boolean z16;
                int tbsVersion = QbSdk.getTbsVersion(BaseApplication.getContext());
                String str4 = "OfflinePluginQQ";
                if (tbsVersion < 43700) {
                    QLog.e("OfflinePluginQQ", 1, "current tbs version " + tbsVersion + " doesn't support ServiceWorker! require >= 43700");
                    return;
                }
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("offline_sw_register", 4);
                String v3 = HtmlOffline.v(str2);
                String str5 = v3 + "_register_time";
                long j3 = sharedPreferences.getLong(str5, -1L);
                if (!"0".equals(str) && OfflinePlugin.y()) {
                    QLog.i("OfflinePluginQQ", 1, String.format("now start registerServiceWorkerOffline, current tbs version: %d, url: %s", Integer.valueOf(tbsVersion), com.tencent.mobileqq.webview.util.s.d(str2, new String[0])));
                    String string = sharedPreferences.getString(v3, "");
                    if (!TextUtils.isEmpty(string)) {
                        hashSet = new HashSet(Arrays.asList(string.split(",")));
                    } else {
                        hashSet = new HashSet();
                    }
                    if (OfflinePlugin.this.Q.size() > 0) {
                        if (QLog.isColorLevel()) {
                            QLog.i("OfflinePluginQQ", 2, "shouldInterceptRequest has new resource, need register SW again!");
                        }
                        hashSet.addAll(OfflinePlugin.this.Q);
                        if (QLog.isColorLevel()) {
                            QLog.i("OfflinePluginQQ", 2, "merge new bid: " + TextUtils.join(",", hashSet));
                        }
                        z16 = true;
                        str3 = "OfflinePluginQQ";
                    } else {
                        if (hashSet.size() > 0) {
                            SharedPreferences sharedPreferences2 = BaseApplication.getContext().getSharedPreferences("bid_update_success_time", 4);
                            for (String str6 : hashSet) {
                                String str7 = str4;
                                long j16 = sharedPreferences2.getLong(str6, -1L);
                                if (j3 != -1 && j16 <= j3) {
                                    str4 = str7;
                                } else {
                                    if (QLog.isColorLevel()) {
                                        str3 = str7;
                                        QLog.i(str3, 2, "bid " + str6 + " has update, now need register again! updateTime: " + j16 + ", lastRegisterTime: " + j3);
                                    } else {
                                        str3 = str7;
                                    }
                                    z16 = true;
                                }
                            }
                        }
                        str3 = str4;
                        z16 = false;
                    }
                    if (z16) {
                        ArrayList arrayList = new ArrayList();
                        if (hashSet.size() > 0) {
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                String B = OfflinePlugin.this.B((String) it.next());
                                if (!TextUtils.isEmpty(B)) {
                                    arrayList.add(B);
                                }
                            }
                        }
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        if (arrayList.size() > 0) {
                            edit.putString(v3, TextUtils.join(",", hashSet));
                            edit.putLong(str5, System.currentTimeMillis());
                            edit.commit();
                            if (QLog.isColorLevel()) {
                                QLog.i(str3, 2, "registerServiceWorkerOffline,, paths: " + TextUtils.join(",", arrayList));
                            }
                            customWebView.getX5WebViewExtension().registerServiceWorkerOffline(str2, arrayList, true);
                        }
                        if (OfflinePlugin.this.Q.size() > 0) {
                            OfflinePlugin.this.Q.clear();
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(str3, 2, "It doesn't need update and register SW again! " + TextUtils.join(",", hashSet));
                        return;
                    }
                    return;
                }
                if (j3 != -1) {
                    if (QLog.isColorLevel()) {
                        QLog.i("OfflinePluginQQ", 2, "unRegisterServiceWorker, url: " + str2);
                    }
                    sharedPreferences.edit().putLong(str5, -1L).commit();
                    customWebView.getX5WebViewExtension().unRegisterServiceWorker(str2, true);
                }
            }
        }, 8, null, false);
    }

    public static void P(String str, String str2, int i3, int i16, String str3, String str4, String str5) {
        int i17;
        String str6 = str3;
        if (f97345e0 == null) {
            f97345e0 = BaseApplication.getContext();
        }
        if (f97345e0 != null) {
            i17 = NetworkUtil.getNetWorkType();
        } else {
            i17 = -1;
        }
        if (!TextUtils.isEmpty(str3) && (str6.startsWith("http") || str6.startsWith("https"))) {
            int indexOf = str6.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (indexOf != -1) {
                str6 = str6.substring(0, indexOf);
            }
        } else {
            str6 = "";
        }
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", "OfflineStatusReport", "", str2, str, i3, 1, i16, str6, str4, str5, String.valueOf(i17));
    }

    public static void Q(String str) {
        f97346f0.remove(str);
        SwiftBrowserOfflineHandler c16 = SwiftBrowserOfflineHandler.c(str);
        if (c16 != null) {
            c16.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Message message, Activity activity, v vVar) {
        int i3 = message.arg2;
        if (i3 == 0) {
            vVar.f(3);
            if (activity != null) {
                Drawable drawable = activity.getResources().getDrawable(R.drawable.common_green_checkbox);
                drawable.setBounds(0, 0, 40, 40);
                TextView textView = this.f97354m;
                if (textView != null) {
                    textView.setCompoundDrawables(drawable, null, null, null);
                }
                TextView textView2 = this.f97354m;
                if (textView2 != null) {
                    textView2.setText(vVar.C);
                }
                ProgressBar progressBar = this.C;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                LinearLayout linearLayout = this.f97353i;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 != 5 && i3 != 7) {
            QQToastUtil.showQQToast(1, R.string.dq5);
            RelativeLayout relativeLayout = this.f97352h;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            vVar.f(4);
            return;
        }
        RelativeLayout relativeLayout2 = this.f97352h;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        vVar.f(4);
    }

    private void s(String str) {
        long j3;
        if (this.M == -1) {
            ComponentCallbacks2 a16 = this.mRuntime.a();
            WebViewProvider f16 = this.mRuntime.f();
            if (f16 != null) {
                String redirect302Url = f16.getRedirect302Url();
                if (!TextUtils.isEmpty(redirect302Url)) {
                    this.V = redirect302Url;
                }
            } else if (a16 instanceof com.tencent.mobileqq.webviewplugin.e) {
                String redirect302Url2 = ((com.tencent.mobileqq.webviewplugin.e) a16).getRedirect302Url();
                if (!TextUtils.isEmpty(redirect302Url2)) {
                    this.V = redirect302Url2;
                }
            }
            String v3 = HtmlOffline.v(this.V);
            if (!TextUtils.isEmpty(v3)) {
                if (v3.equalsIgnoreCase(str)) {
                    j3 = System.currentTimeMillis();
                } else {
                    j3 = -1;
                }
                this.M = j3;
                if (QLog.isColorLevel() && this.M != -1) {
                    QLog.d("OfflinePluginQQ", 2, "read index offline res!");
                }
            }
        }
    }

    private boolean t(String str) {
        SwiftBrowserOfflineHandler d16 = SwiftBrowserOfflineHandler.d(str);
        if (d16 != null) {
            d16.a();
            if (SwiftBrowserOfflineHandler.f314265g.get() == 4) {
                this.f97350e = null;
                this.F = true;
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean y() {
        Integer[] webViewFeatureParams = WebAccelerateHelper.getInstance().getWebViewFeatureParams();
        if (webViewFeatureParams != null && webViewFeatureParams[13].intValue() != 0) {
            if (QLog.isColorLevel()) {
                QLog.i("OfflinePluginQQ", 2, "now enable service worker!");
            }
            return true;
        }
        QLog.e("OfflinePluginQQ", 1, "disable service worker!");
        return false;
    }

    public static void z(final String str) {
        if (f97346f0 == null) {
            f97346f0 = new ConcurrentHashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.biz.webviewplugin.OfflinePlugin.10
            @Override // java.lang.Runnable
            public void run() {
                int size;
                OfflinePlugin.f97346f0.remove(str);
                ArrayList<String> arrayList = new ArrayList<>();
                String c16 = com.tencent.biz.common.offline.c.c(str);
                if (TextUtils.isEmpty(c16)) {
                    return;
                }
                String str2 = c16 + str + File.separator;
                File file = new File(str2 + "b.zip");
                if (!file.exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("OfflinePluginQQ", 2, "find nothing in " + str2);
                    }
                    arrayList.add(str2 + "none");
                    OfflinePlugin.f97346f0.put(str, arrayList);
                    return;
                }
                QZipFile qZipFile = null;
                try {
                    try {
                        try {
                            QZipFile qZipFile2 = new QZipFile(file);
                            try {
                                Enumeration<? extends ZipEntry> entries = qZipFile2.entries();
                                if (qZipFile2.size() == 0) {
                                    size = 16;
                                } else {
                                    size = qZipFile2.size() * 128;
                                }
                                StringBuilder sb5 = new StringBuilder(size);
                                while (entries.hasMoreElements()) {
                                    ZipEntry nextElement = entries.nextElement();
                                    if (!nextElement.isDirectory()) {
                                        if (QLog.isColorLevel()) {
                                            sb5.append("find index: ");
                                            sb5.append(str2);
                                            sb5.append(nextElement.getName());
                                            sb5.append("\n");
                                        }
                                        arrayList.add(str2 + nextElement.getName());
                                    }
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.i("OfflinePluginQQ", 2, sb5.toString());
                                }
                                OfflinePlugin.f97346f0.put(str, arrayList);
                                qZipFile2.close();
                            } catch (Exception e16) {
                                e = e16;
                                qZipFile = qZipFile2;
                                QLog.e("OfflinePluginQQ", 1, "generateOfflineFileIndex got exception!", e);
                                if (qZipFile != null) {
                                    qZipFile.close();
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                qZipFile = qZipFile2;
                                if (qZipFile != null) {
                                    try {
                                        qZipFile.close();
                                    } catch (IOException e17) {
                                        e17.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (Exception e18) {
                        e = e18;
                    }
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            }
        });
    }

    public String A() {
        return this.f97350e;
    }

    public String B(String str) {
        String c16 = com.tencent.biz.common.offline.c.c(str);
        if (TextUtils.isEmpty(c16)) {
            return null;
        }
        return c16 + str + "/";
    }

    public WebResourceResponse C(String str, String str2) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String E = E(str2);
            if (TextUtils.isEmpty(E)) {
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject(E);
            String v3 = HtmlOffline.v(str);
            String optString = jSONObject.optString(v3);
            long currentTimeMillis3 = System.currentTimeMillis();
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (MobileQQ.sProcessId == 7) {
                AppRuntime appRuntime = waitAppRuntime.getAppRuntime("modular_web");
                if (appRuntime instanceof AppInterface) {
                    this.P = new OfflineWebResManager((AppInterface) appRuntime);
                }
            } else if (waitAppRuntime instanceof AppInterface) {
                this.P = new OfflineWebResManager((AppInterface) waitAppRuntime);
            }
            OfflineWebResManager offlineWebResManager = this.P;
            if (offlineWebResManager == null) {
                return null;
            }
            OfflineWebRes k3 = offlineWebResManager.k(optString);
            long currentTimeMillis4 = System.currentTimeMillis();
            if (k3 == null) {
                return null;
            }
            File file = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
            if (!file.exists() && !file.mkdirs()) {
                return null;
            }
            String str3 = "text/html";
            if (v3.contains(".css")) {
                str3 = "text/css";
            } else if (v3.contains(PTSFileUtil.JS_FORMAT)) {
                str3 = "application/x-javascript";
            } else if (v3.contains(".jpg") || v3.contains(QzoneEmotionUtils.SIGN_ICON_URL_END) || v3.contains(".png") || v3.contains(".jpeg")) {
                str3 = "image/*";
            }
            File file2 = new File(file, k3.hashName);
            if (!file2.exists()) {
                return null;
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(str3, "utf-8", new BufferedInputStream(new FileInputStream(file2)));
            if (QLog.isColorLevel()) {
                QLog.d("OfflinePluginQQ", 2, "shouldInterceptRequest from database return local res, readMd5File: " + (currentTimeMillis2 - currentTimeMillis) + ", getMd5: " + (currentTimeMillis3 - currentTimeMillis2) + ", query: " + (currentTimeMillis4 - currentTimeMillis3) + ", totalCost: " + (System.currentTimeMillis() - currentTimeMillis) + ", filePath: " + HtmlOffline.v(str));
            }
            return webResourceResponse;
        } catch (Exception e16) {
            QLog.e("OfflinePluginQQ", 1, "getOfflineResFromDatabase got exception!", e16);
            return null;
        }
    }

    protected boolean J(String str) {
        String str2;
        try {
            str2 = Uri.parse(str).getQueryParameter("_duck");
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("QQBrowserActivity", 2, "checkOfflineUpr:url parse exception:" + com.tencent.mobileqq.webview.util.s.d(str, new String[0]));
            }
            str2 = "0";
        }
        try {
            str2 = Uri.parse(str).getQueryParameter("_discheck");
        } catch (Exception unused2) {
            if (QLog.isColorLevel()) {
                QLog.e("QQBrowserActivity", 2, "checkOfflineUpr:url parse exception:" + com.tencent.mobileqq.webview.util.s.d(str, new String[0]));
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f97349d.t(str);
        }
        if (!TextUtils.isEmpty(str2) && str2.equals("1")) {
            if (QLog.isDevelopLevel()) {
                QLog.e("webviewLoadUrl", 4, "1 checkOfflineUp _duck=1");
            }
            if (QLog.isColorLevel()) {
                QLog.d("OfflineCheck", 2, "has discheck " + str);
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OfflineCheck", 2, "no discheck " + str);
            return true;
        }
        return true;
    }

    @TargetApi(11)
    public void M() {
        CustomWebView e16 = this.mRuntime.e();
        if (e16 == null || e16.getX5WebViewExtension() == null) {
            return;
        }
        String url = e16.getUrl();
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Uri parse = Uri.parse(url);
        if (parse != null && parse.isHierarchical()) {
            String queryParameter = parse.getQueryParameter("_sw");
            if (!"1".equals(queryParameter) && !"0".equals(queryParameter)) {
                if (QLog.isColorLevel()) {
                    QLog.i("OfflinePluginQQ", 2, "url doesn't support ServiceWorker! " + com.tencent.mobileqq.webview.util.s.d(url, new String[0]));
                    return;
                }
                return;
            }
            int indexOf = url.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (indexOf != -1) {
                url = url.substring(0, indexOf);
            }
            L(e16, queryParameter, url);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("OfflinePluginQQ", 2, "url is illegal! " + url);
        }
    }

    protected void N() {
        CustomWebView e16;
        if (this.mRuntime.a() == null) {
            return;
        }
        WebViewPlugin.b bVar = this.mRuntime;
        com.tencent.mobileqq.webview.swift.y d16 = bVar.d(bVar.a());
        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.r) && (e16 = this.mRuntime.e()) != null) {
            e16.loadUrl(((com.tencent.mobileqq.webviewplugin.r) d16).getCurrentUrl());
            if (QLog.isColorLevel()) {
                QLog.i("OfflinePluginQQ", 2, "reloadCurrentUrl");
            }
        }
    }

    public void O() {
        v vVar;
        if (f97342b0 != null && !TextUtils.isEmpty(this.f97351f) && (vVar = f97342b0.get(this.f97351f)) != null) {
            vVar.c0();
        }
        N();
    }

    public void R(String str, int i3) {
        boolean z16;
        this.G = i3;
        this.L = System.currentTimeMillis();
        SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) getBrowserComponent(-2);
        if (swiftBrowserStatistics != null) {
            if (i3 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            swiftBrowserStatistics.O0 = z16;
        }
        if (!TextUtils.isEmpty(this.f97350e)) {
            if (QLog.isColorLevel()) {
                QLog.i("OfflinePluginQQ", 2, "OfflinePlugin handleSchemaRequest loadMode: " + this.G + ", bid: " + this.f97350e + ", cost: " + this.I);
            }
            u(str);
            P(this.f97350e, "Offline_Check", this.I, 2, str, String.valueOf(this.G), "");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "offline";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 42L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 3L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        if (j3 == 8) {
            return shouldInterceptRequest(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"offline".equals(str2)) {
            return false;
        }
        String str4 = null;
        if (HippyReporter.RemoveEngineReason.CLEAR_CACHE.equals(str3) && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("bid");
                str4 = jSONObject.optString("callback");
                HtmlOffline.P(this.mRuntime.a(), optString, 1);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("retcode", 0);
                jSONObject2.put("msg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                callJs(str4, jSONObject2.toString());
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, clearCache, JSONException :" + e16);
                }
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("retcode", -1);
                    jSONObject3.put("msg", "error");
                    callJs(str4, jSONObject3.toString());
                } catch (JSONException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, clearCache, JSONException :" + e17);
                    }
                }
            }
        } else if ("disableCache".equals(str3)) {
            try {
                str4 = new JSONObject(strArr[0]).optString("callback");
                f97344d0 = true;
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("retcode", 0);
                jSONObject4.put("msg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                callJs(str4, jSONObject4.toString());
            } catch (JSONException e18) {
                if (QLog.isColorLevel()) {
                    QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, disableCache, JSONException :" + e18);
                }
                try {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("retcode", -1);
                    jSONObject5.put("msg", "error");
                    callJs(str4, jSONObject5.toString());
                } catch (JSONException e19) {
                    if (QLog.isColorLevel()) {
                        QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, disableCache, JSONException :" + e19);
                    }
                }
            }
        } else if ("batchCheckUpdate".equals(str3) && strArr.length > 0) {
            try {
                JSONObject jSONObject6 = new JSONObject(strArr[0]);
                JSONArray optJSONArray = jSONObject6.optJSONArray(QQGamePreDownloadServiceImpl.QQGAME_BIDS_KEY);
                this.H = jSONObject6.optString("callback");
                int length = optJSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(optJSONArray.optString(i3));
                }
                HtmlOffline.C(arrayList, this.mRuntime.b(), new c(jsBridgeListener), true, false);
            } catch (JSONException e26) {
                if (QLog.isColorLevel()) {
                    QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + e26);
                }
                try {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("retcode", -1);
                    jSONObject7.put("msg", "error");
                    callJs(this.H, jSONObject7.toString());
                } catch (JSONException e27) {
                    if (QLog.isColorLevel()) {
                        QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + e27);
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        int i3;
        if (!str2.equals("http") && !str2.equals("https")) {
            return false;
        }
        if (com.tencent.mobileqq.webview.swift.utils.q.b().c(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("OfflinePluginQQ", 2, "ignore url:" + str);
            }
            return false;
        }
        String w3 = w(str);
        long currentTimeMillis = System.currentTimeMillis();
        SwiftBrowserOfflineHandler d16 = SwiftBrowserOfflineHandler.d(w3);
        if (d16 != null && !d16.e()) {
            d16.b(new d(currentTimeMillis, w3), w3);
            return true;
        }
        if (d16 != null) {
            i3 = d16.f314269d.get();
        } else {
            i3 = 0;
        }
        R(w3, i3);
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onAppRuntimeReady(AppRuntime appRuntime) {
        this.f97349d = AuthorizeConfig.y();
        I();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && ((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).j()) {
            QLog.e("OfflinePluginQQ", 1, "disable offline!");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        this.D = true;
        if (f97342b0 != null && !TextUtils.isEmpty(this.f97351f)) {
            v vVar = f97342b0.get(this.f97351f);
            if (vVar != null) {
                vVar.e(this.Z);
                if (vVar.b() == 0) {
                    f97342b0.remove(this.f97351f);
                }
            }
            if (f97342b0.size() == 0) {
                f97342b0 = null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f7, code lost:
    
        if (r7.contains(r5 + r6) == false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WebResourceResponse shouldInterceptRequest(String str) {
        if (!((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).j() && !this.F && !TextUtils.isEmpty(str) && str.startsWith("http")) {
            String queryParameter = Uri.parse(str).getQueryParameter("_bid");
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = this.f97350e;
            }
            g.a b16 = com.tencent.mobileqq.webview.swift.utils.g.b(str);
            if (b16 != null && !TextUtils.isEmpty(b16.f314753b)) {
                if (QLog.isColorLevel()) {
                    QLog.d("OfflinePluginQQ", 2, "load offline data cache on loadRes");
                }
                this.Q.add(queryParameter);
                return new WebResourceResponse(b16.f314752a, b16.f314754c, new BufferedInputStream(new ByteArrayInputStream(b16.f314753b.getBytes())));
            }
            try {
                if (TextUtils.isEmpty(queryParameter)) {
                    return null;
                }
                if (!queryParameter.equals(this.f97350e)) {
                    if (!this.N.get()) {
                        if (this.X == null) {
                            this.X = new CopyOnWriteArrayList<>();
                        }
                        if (!this.X.contains(str)) {
                            this.X.add(str);
                        }
                    } else {
                        v(str);
                    }
                }
                String c16 = com.tencent.biz.common.offline.c.c(queryParameter);
                if (TextUtils.isEmpty(c16)) {
                    return null;
                }
                String str2 = c16 + queryParameter + File.separator;
                String v3 = HtmlOffline.v(str);
                if (queryParameter.equals(this.f97350e)) {
                    ArrayList<String> arrayList = f97346f0.get(queryParameter);
                    if (arrayList != null && arrayList.size() > 0) {
                    }
                    return null;
                }
                WebResourceResponse C = C(str, queryParameter);
                if (C == null) {
                    C = D(str, queryParameter);
                }
                if (C != null) {
                    if (queryParameter.equals(this.f97350e)) {
                        this.T = true;
                    }
                    Map<String, String> responseHeaders = C.getResponseHeaders();
                    if (responseHeaders == null) {
                        responseHeaders = new HashMap<>();
                    }
                    responseHeaders.put("Access-Control-Allow-Origin", "*");
                    C.setResponseHeaders(responseHeaders);
                    OfflineWebResManager.b(str);
                    s(v3);
                }
                if (C != null) {
                    QLog.d("OfflinePluginQQ", 2, "Url(" + str + ") uses the offline res");
                    this.Q.add(queryParameter);
                } else {
                    QLog.d("OfflinePluginQQ", 2, "Url(" + str + ") does not  use the offline res");
                }
                return C;
            } catch (Exception e16) {
                QLog.e("OfflinePluginQQ", 1, "OfflinePlugin shouldInterceptRequest got Exception", e16);
            }
        }
        return null;
    }

    protected void u(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp,url=" + str);
        }
        if (TextUtils.isEmpty(str) || !J(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp.");
        }
        AppRuntime b16 = this.mRuntime.b();
        if (b16 == null) {
            b16 = this.mRuntime.c();
        }
        HtmlOffline.e(str, b16, new a());
    }

    protected void v(String str) {
        if (TextUtils.isEmpty(str) || !J(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("OfflinePluginQQ", 2, "checkOfflineUpNotCallback.");
        }
        AppRuntime b16 = this.mRuntime.b();
        if (b16 == null) {
            b16 = this.mRuntime.c();
        }
        HtmlOffline.d(str, b16);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String w(String str) {
        String str2;
        AuthorizeConfig authorizeConfig;
        if (!TextUtils.isEmpty(str) && Uri.parse(str).isHierarchical()) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter("_bid");
                this.f97350e = queryParameter;
                if (this.f97351f == null) {
                    this.f97351f = queryParameter;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f97350e) && (authorizeConfig = this.f97349d) != null) {
                String D = authorizeConfig.D(str);
                this.f97350e = D;
                if (this.f97351f == null) {
                    this.f97351f = D;
                }
                if (!TextUtils.isEmpty(D)) {
                    str2 = HtmlOffline.b(str, "_bid=" + this.f97350e);
                    if (!t(str2)) {
                        return str;
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUrl:" + com.tencent.mobileqq.webview.util.s.d(str2, new String[0]));
                    }
                    return str2;
                }
            }
            str2 = str;
            if (!t(str2)) {
            }
        } else {
            return str;
        }
    }

    public void x(JSONObject jSONObject) {
        Activity a16;
        if (TextUtils.isEmpty(this.f97351f) || (a16 = this.mRuntime.a()) == null) {
            return;
        }
        if (f97342b0 == null) {
            f97342b0 = new HashMap<>();
        }
        if (f97342b0.get(this.f97351f) != null) {
            return;
        }
        v vVar = new v(this.f97351f);
        vVar.a(this.Z);
        JSONObject optJSONObject = jSONObject.optJSONObject("wording");
        if (optJSONObject != null) {
            vVar.f97646m = optJSONObject.optString("nonWifiUpdatingText");
            vVar.f97645i = optJSONObject.optString("wifiUpdatingText");
            vVar.C = optJSONObject.optString("updateCompletedText");
        }
        vVar.D = a16.getResources().getString(R.string.dq6);
        f97342b0.put(this.f97351f, vVar);
        String optString = jSONObject.optString("url");
        vVar.E = optString;
        int optInt = jSONObject.optInt(MediaDBValues.FILESIZE);
        vVar.F = optInt;
        LinearLayout linearLayout = this.f97353i;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this.Y);
        }
        if (NetworkUtil.isWifiConnected(a16.getApplicationContext())) {
            String str = vVar.f97645i;
            vVar.D = str;
            if (!TextUtils.isEmpty(optString) && optInt > 0) {
                H();
                vVar.f(1);
                TextView textView = this.f97354m;
                if (textView != null) {
                    textView.setText(str + "0%");
                }
                LinearLayout linearLayout2 = this.f97353i;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                ProgressBar progressBar = this.C;
                if (progressBar != null) {
                    progressBar.setProgress(0);
                }
                ProgressBar progressBar2 = this.C;
                if (progressBar2 != null) {
                    progressBar2.setVisibility(0);
                }
                RelativeLayout relativeLayout = this.f97352h;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                HtmlOffline.r(a16.getApplicationContext(), this.f97351f, optString, optInt, vVar);
                this.R.postDelayed(this.f97348a0, 2000L);
                return;
            }
            return;
        }
        String str2 = vVar.f97646m;
        if (!TextUtils.isEmpty(optString) && optInt > 0) {
            H();
            vVar.f(0);
            Drawable drawable = a16.getResources().getDrawable(R.drawable.qq_conversation_call_icon_detail_nor);
            drawable.setBounds(0, 0, 40, 40);
            TextView textView2 = this.f97354m;
            if (textView2 != null) {
                textView2.setCompoundDrawables(drawable, null, null, null);
            }
            TextView textView3 = this.f97354m;
            if (textView3 != null) {
                textView3.setText(str2);
            }
            RelativeLayout relativeLayout2 = this.f97352h;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            LinearLayout linearLayout3 = this.f97353i;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            ProgressBar progressBar3 = this.C;
            if (progressBar3 != null) {
                progressBar3.setProgress(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        WebViewPlugin.b bVar;
        g.a b16;
        if (j3 == 2) {
            Boolean F = F();
            if (F != null) {
                return F.booleanValue();
            }
        } else if (j3 == 8589934594L) {
            this.N.set(true);
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.webviewplugin.OfflinePlugin.5
                @Override // java.lang.Runnable
                public void run() {
                    CopyOnWriteArrayList<String> copyOnWriteArrayList = OfflinePlugin.this.X;
                    if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
                        Iterator<String> it = OfflinePlugin.this.X.iterator();
                        while (it.hasNext()) {
                            OfflinePlugin.this.v(it.next());
                        }
                        OfflinePlugin.this.X.clear();
                    }
                }
            }, 5, null, false);
            OfflineWebResManager offlineWebResManager = this.P;
            if (offlineWebResManager != null) {
                offlineWebResManager.e(5);
            }
        } else if (j3 == 8589934601L) {
            OfflineWebResManager offlineWebResManager2 = this.P;
            if (offlineWebResManager2 != null) {
                offlineWebResManager2.e(0);
            }
            M();
        } else {
            if (j3 != 32 || (bVar = this.mRuntime) == null) {
                return false;
            }
            CustomWebView e16 = bVar.e();
            if (e16.getX5WebViewExtension() != null && (b16 = com.tencent.mobileqq.webview.swift.utils.g.b(str)) != null && !TextUtils.isEmpty(b16.f314753b)) {
                handleSchemaRequest(str, com.tencent.mobileqq.webview.swift.utils.i.k(str));
                e16.loadDataWithBaseURL(str, b16.f314753b, "text/html", "utf-8", str);
                if (QLog.isColorLevel()) {
                    QLog.d("OfflinePluginQQ", 2, "load offline data cache on loadUrl");
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements com.tencent.biz.common.offline.a {
        a() {
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            JSONObject jSONObject;
            if (QLog.isColorLevel()) {
                QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp. result: " + str + ", code: " + i3);
            }
            if (i3 == 9) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.i("OfflinePluginQQ", 2, "-->offline:checkUp loaded err:" + str);
                    }
                    jSONObject = null;
                }
                Message obtainMessage = OfflinePlugin.this.R.obtainMessage();
                obtainMessage.arg1 = 3;
                obtainMessage.obj = jSONObject;
                OfflinePlugin.this.R.sendMessage(obtainMessage);
                return;
            }
            if (i3 == -1) {
                Message obtainMessage2 = OfflinePlugin.this.R.obtainMessage();
                obtainMessage2.arg1 = 2;
                OfflinePlugin.this.R.sendMessage(obtainMessage2);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
        }
    }

    /* loaded from: classes5.dex */
    class c implements com.tencent.biz.common.offline.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsBridgeListener f97361d;

        c(JsBridgeListener jsBridgeListener) {
            this.f97361d = jsBridgeListener;
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            if (TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("retcode", -1);
                    jSONObject.put("msg", "error");
                    OfflinePlugin offlinePlugin = OfflinePlugin.this;
                    offlinePlugin.callJs(offlinePlugin.H, jSONObject.toString());
                    return;
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("OfflinePluginQQ", 2, "OfflinePlugin, batchCheckUpdate, JSONException :" + e16);
                        return;
                    }
                    return;
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 121;
            obtain.obj = new Object[]{this.f97361d, str};
            OfflinePlugin.this.R.sendMessage(obtain);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
        }
    }
}
