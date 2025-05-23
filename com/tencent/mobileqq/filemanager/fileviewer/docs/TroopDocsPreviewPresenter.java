package com.tencent.mobileqq.filemanager.fileviewer.docs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filebrowser.FileBrowserActivity;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IFlashTransferDTReportApi;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.LoadingUtil;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class TroopDocsPreviewPresenter {

    /* renamed from: b, reason: collision with root package name */
    private AppActivity f208257b;

    /* renamed from: c, reason: collision with root package name */
    private ForwardFileInfo f208258c;

    /* renamed from: e, reason: collision with root package name */
    private long f208260e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.fileviewer.docs.a f208261f;

    /* renamed from: g, reason: collision with root package name */
    private String f208262g;

    /* renamed from: h, reason: collision with root package name */
    private String f208263h;

    /* renamed from: i, reason: collision with root package name */
    private int f208264i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f208265j;

    /* renamed from: k, reason: collision with root package name */
    private int f208266k;

    /* renamed from: l, reason: collision with root package name */
    private int f208267l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f208268m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f208269n;

    /* renamed from: o, reason: collision with root package name */
    private long f208270o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f208271p;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Long> f208256a = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    protected int f208259d = 10006;

    /* renamed from: q, reason: collision with root package name */
    private int f208272q = 0;

    /* renamed from: r, reason: collision with root package name */
    private Dialog f208273r = null;

    /* renamed from: s, reason: collision with root package name */
    private int f208274s = -1;

    /* renamed from: t, reason: collision with root package name */
    private String f208275t = "";

    /* renamed from: u, reason: collision with root package name */
    private com.tencent.qqnt.circularprogress.b f208276u = null;

    /* renamed from: v, reason: collision with root package name */
    private View f208277v = null;

    /* renamed from: w, reason: collision with root package name */
    private EIPCResultCallback f208278w = new EIPCResultCallback() { // from class: com.tencent.mobileqq.filemanager.fileviewer.docs.TroopDocsPreviewPresenter.1
        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            String str;
            String str2;
            String string = eIPCResult.data.getString("action_type");
            if (!string.equals("action_download_file") && !string.equals("action_print_file")) {
                if (!string.equals("action_share_file") || eIPCResult.data.getInt("key_action_in_sheet", 0) != 27) {
                    return;
                }
                if (!eIPCResult.isSuccess() && !TextUtils.isEmpty(((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).getErrorMsg(TroopDocsPreviewPresenter.this.f208257b))) {
                    str2 = "\u4fdd\u5b58\u5fae\u4e91\u5931\u8d25";
                } else {
                    str2 = "\u4fdd\u5b58\u5fae\u4e91\u6210\u529f";
                }
                TroopDocsPreviewPresenter.this.O(str2);
                return;
            }
            if (eIPCResult.isSuccess()) {
                final String string2 = eIPCResult.data.getString("key_download_path");
                String str3 = "\u4fdd\u5b58\u6587\u4ef6\u6210\u529f";
                if (string.equals("action_download_file")) {
                    if (!TextUtils.isEmpty(string2)) {
                        if (TroopDocsPreviewPresenter.this.f208274s == 58 && TroopDocsPreviewPresenter.this.f208276u != null) {
                            TroopDocsPreviewPresenter.this.f208276u.setProgress(1.0d);
                            TroopDocsPreviewPresenter.this.f208277v.setVisibility(4);
                            TroopDocsPreviewPresenter.this.f208276u = null;
                            TroopDocsPreviewPresenter.this.f208277v = null;
                        }
                        if (TroopDocsPreviewPresenter.this.f208274s == 58) {
                            str3 = "\u4e0b\u8f7d\u6210\u529f";
                        }
                        TroopDocsPreviewPresenter.this.O(str3);
                        TroopDocsPreviewPresenter.this.I(string2);
                        return;
                    }
                    return;
                }
                if (TroopDocsPreviewPresenter.this.f208273r != null) {
                    TroopDocsPreviewPresenter.this.f208273r.dismiss();
                    TroopDocsPreviewPresenter.this.f208273r = null;
                }
                TroopDocsPreviewPresenter.this.O("\u4fdd\u5b58\u6587\u4ef6\u6210\u529f");
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.docs.TroopDocsPreviewPresenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TroopDocsPreviewPresenter.this.f208258c.C(string2);
                        ((IPrintApi) QRoute.api(IPrintApi.class)).jumpSysPrintPage(TroopDocsPreviewPresenter.this.f208257b, string2);
                    }
                }, 2000L);
                return;
            }
            QLog.d("TroopDocsPreviewPresenter", 1, "download failed.");
            if (TroopDocsPreviewPresenter.this.f208274s == 58 && TroopDocsPreviewPresenter.this.f208276u != null) {
                TroopDocsPreviewPresenter.this.f208276u.a("download_with_progress");
                TroopDocsPreviewPresenter.this.f208276u.setProgress(0.0d);
                TroopDocsPreviewPresenter.this.f208276u = null;
                TroopDocsPreviewPresenter.this.f208277v = null;
            }
            if (TroopDocsPreviewPresenter.this.f208274s == 58) {
                str = "\u4e0b\u8f7d\u5931\u8d25";
            } else {
                str = "\u4fdd\u5b58\u6587\u4ef6\u5931\u8d25";
            }
            TroopDocsPreviewPresenter.this.O(str);
            if (string.equals("action_print_file") && TroopDocsPreviewPresenter.this.f208273r != null) {
                TroopDocsPreviewPresenter.this.f208273r.dismiss();
                TroopDocsPreviewPresenter.this.f208273r = null;
            }
        }
    };

    /* renamed from: x, reason: collision with root package name */
    private View.OnClickListener f208279x = new a();

    /* renamed from: y, reason: collision with root package name */
    private EIPCResultCallback f208280y = new b();

    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (q.f(TroopDocsPreviewPresenter.this.f208258c.l())) {
                ((IPrintApi) QRoute.api(IPrintApi.class)).jumpSysPrintPage(TroopDocsPreviewPresenter.this.f208257b, TroopDocsPreviewPresenter.this.f208258c.l());
            } else {
                if (TroopDocsPreviewPresenter.this.f208273r == null) {
                    TroopDocsPreviewPresenter troopDocsPreviewPresenter = TroopDocsPreviewPresenter.this;
                    troopDocsPreviewPresenter.f208273r = LoadingUtil.showLoadingDialog(troopDocsPreviewPresenter.f208257b, "\u6587\u4ef6\u4e0b\u8f7d\u4e2d", false);
                    TroopDocsPreviewPresenter.this.f208273r.show();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("key_session_id", TroopDocsPreviewPresenter.this.f208258c.n());
                bundle.putBoolean("key_from_troop_plugin", TroopDocsPreviewPresenter.this.f208265j);
                QIPCClientHelper.getInstance().getClient().callServer("TroopDocsShareActionModel", "action_print_file", bundle, TroopDocsPreviewPresenter.this.f208278w);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes12.dex */
    class b implements EIPCResultCallback {
        b() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult.data.getString("action_type").equals("action_get_progress")) {
                float f16 = eIPCResult.data.getFloat("key_progress");
                if (TroopDocsPreviewPresenter.this.f208274s == 58 && TroopDocsPreviewPresenter.this.f208276u != null) {
                    TroopDocsPreviewPresenter.this.f208276u.a("progress");
                    double d16 = f16;
                    TroopDocsPreviewPresenter.this.f208276u.setProgress(d16);
                    if (d16 < 1.0d) {
                        TroopDocsPreviewPresenter.this.M();
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    private class c extends WebChromeClient {
        c() {
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            if (QLog.isColorLevel()) {
                QLog.i("TroopDocsPreviewPresenter", 2, "onProgressChanged, newProgress:" + i3);
            }
            TroopDocsPreviewPresenter.this.f208272q = i3;
            super.onProgressChanged(webView, i3);
        }
    }

    public TroopDocsPreviewPresenter(AppActivity appActivity) {
        this.f208257b = appActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(IGetExternalInterface.b bVar, String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("p_skey=");
        sb5.append(str);
        sb5.append(";");
        String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        sb5.append("p_uin=o");
        sb5.append(account);
        sb5.append("");
        bVar.a(sb5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(StringBuilder sb5) {
        CookieManager.getInstance().setCookie(ITeamWorkHandler.DOCS_DOMAIN, sb5.toString(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        Intent intent = new Intent(this.f208257b.getIntent());
        if (this.f208265j) {
            intent.setClass(this.f208257b, TroopFileDetailBrowserActivity.class);
            intent.putExtra("fileinfo", this.f208258c);
            intent.putExtra(IFileBrowserService.STRING_BROWSE_ID, this.f208266k);
        } else {
            intent.setClass(this.f208257b, FileBrowserActivity.class);
            intent.putExtra(IFileBrowserService.STRING_BROWSE_ID, this.f208266k);
        }
        Bundle bundleExtra = intent.getBundleExtra("file_browser_extra_params");
        if (bundleExtra != null) {
            bundleExtra.putBoolean("hide_online_preview_button", true);
        }
        this.f208257b.overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
        this.f208257b.startActivity(intent);
        this.f208257b.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str) {
        this.f208258c.C(str);
        J();
    }

    private void J() {
        this.f208257b.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.docs.e
            @Override // java.lang.Runnable
            public final void run() {
                TroopDocsPreviewPresenter.this.H();
            }
        });
    }

    private void K(String str) {
        Intent intent = new Intent(this.f208257b, (Class<?>) TeamWorkDocEditBrowserActivity.class);
        intent.addFlags(603979776);
        TeamWorkDocEditBrowserActivity.getOpenTeamWorkIntent(intent, str, this.f208257b);
        this.f208257b.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        Bundle bundle = new Bundle();
        bundle.putLong("key_session_id", this.f208258c.n());
        bundle.putBoolean("key_from_troop_plugin", this.f208265j);
        QIPCClientHelper.getInstance().getClient().callServer("TroopDocsShareActionModel", "action_get_progress", bundle, this.f208280y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(final String str) {
        this.f208257b.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.docs.TroopDocsPreviewPresenter.3
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(TroopDocsPreviewPresenter.this.f208257b, str, 0).show();
            }
        });
    }

    private String u(String str) {
        return TroopDocsPreviewConfigProcessor.c().a().get(str);
    }

    private void v(final IGetExternalInterface.b bVar) {
        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.c() { // from class: com.tencent.mobileqq.filemanager.fileviewer.docs.d
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
            public final void a(String str) {
                TroopDocsPreviewPresenter.F(IGetExternalInterface.b.this, str);
            }
        });
    }

    public long A() {
        return this.f208258c.n();
    }

    @SuppressLint({"LongLogTag"})
    public boolean B(WebView webView, String str) {
        if (str == null) {
            return false;
        }
        try {
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopDocsPreviewPresenter", 1, "url parse fail!,url:" + str);
            }
            e16.printStackTrace();
        }
        if (str.startsWith("jsbridge://troopFile/downloadFile")) {
            JSONObject jSONObject = new JSONObject(Uri.parse(str).getQueryParameter("p"));
            String optString = jSONObject.optString("fileId");
            String optString2 = jSONObject.optString("callback");
            if (QLog.isColorLevel()) {
                Log.d("TroopDocsPreviewPresenter", "downloadFile - fileId" + optString + ", callBack:" + optString2);
            }
            P(optString, null, null);
            return true;
        }
        if (str.startsWith("jsbridge://docx/troopFileDismiss")) {
            O("\u6587\u4ef6\u9884\u89c8\u8d85\u65f6\uff0c\u8bf7\u76f4\u63a5\u4e0b\u8f7d\u3002");
            J();
            return true;
        }
        if (str.startsWith("jsbridge://ui/openUrl")) {
            String optString3 = new JSONObject(Uri.parse(str).getQueryParameter("p")).optString("url");
            String host = Uri.parse(optString3).getHost();
            if (host.equals("m.q.qq.com") || host.equals(ITeamWorkHandler.DOCS_DOMAIN)) {
                K(optString3);
                return true;
            }
        }
        return false;
    }

    public boolean C(Intent intent) {
        this.f208258c = (ForwardFileInfo) intent.getParcelableExtra("fileinfo");
        try {
            this.f208260e = Long.parseLong(intent.getStringExtra("file_browser_extra_params_uin"));
            ForwardFileInfo forwardFileInfo = this.f208258c;
            if (forwardFileInfo == null) {
                return false;
            }
            this.f208259d = forwardFileInfo.getType();
            if (!s(intent)) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopDocsPreviewPresenter", 2, "create FileBrowserView failed");
                }
                return false;
            }
            if (!FileManagerUtil.is2GOr3G()) {
                Intent intent2 = new Intent(this.f208257b, (Class<?>) WebProcessReceiver.class);
                intent2.setAction(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.ACTION_DOWNLOAD_TBS);
                this.f208257b.sendBroadcast(intent2, "com.tencent.msg.permission.pushnotify");
                return true;
            }
            return true;
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopDocsPreviewPresenter", 2, "parse troop uin failed");
            }
            return false;
        }
    }

    public void D(WebSettings webSettings) {
        if (webSettings == null) {
            return;
        }
        webSettings.setUserAgentString(i.n(webSettings.getUserAgentString(), null, false));
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(-1);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
    }

    public void E(WebView webView) {
        v(new IGetExternalInterface.b() { // from class: com.tencent.mobileqq.filemanager.fileviewer.docs.c
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.b
            public final void a(StringBuilder sb5) {
                TroopDocsPreviewPresenter.G(sb5);
            }
        });
        webView.setWebChromeClient(new c());
        webView.setScrollBarStyle(0);
        webView.requestFocus();
        WebView.setWebContentsDebuggingEnabled(true);
        webView.setFocusableInTouchMode(false);
        D(webView.getSettings());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(Object obj, boolean z16) {
        if (this.f208274s != 58) {
            return;
        }
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.fileName = this.f208258c.f();
        fileManagerEntity.nFileType = ((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).getFileType(this.f208258c.f());
        fileManagerEntity.fileSize = this.f208258c.g();
        fileManagerEntity.strFilePath = "";
        fileManagerEntity.nOpType = 58;
        ((IFlashTransferDTReportApi) QRoute.api(IFlashTransferDTReportApi.class)).reportFileBrowse(obj, fileManagerEntity, z16);
    }

    public void N() {
        if (this.f208261f == null) {
            this.f208261f = new com.tencent.mobileqq.filemanager.fileviewer.docs.a(this.f208257b, this.f208258c, this.f208278w, this.f208265j, this.f208279x);
        }
        this.f208261f.k();
    }

    public void P(String str, com.tencent.qqnt.circularprogress.b bVar, View view) {
        com.tencent.qqnt.circularprogress.b bVar2;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f208256a.containsKey(str) && currentTimeMillis - this.f208256a.get(str).longValue() < 500) {
            return;
        }
        this.f208256a.put(str, Long.valueOf(currentTimeMillis));
        this.f208276u = bVar;
        this.f208277v = view;
        Bundle bundle = new Bundle();
        bundle.putLong("key_session_id", this.f208258c.n());
        bundle.putBoolean("key_from_troop_plugin", this.f208265j);
        QIPCClientHelper.getInstance().getClient().callServer("TroopDocsShareActionModel", "action_download_file", bundle, this.f208278w);
        if (this.f208274s == 58 && (bVar2 = this.f208276u) != null) {
            bVar2.a("progress");
            this.f208276u.setProgress(0.0d);
            M();
            return;
        }
        QQToast.makeText(this.f208257b, "\u6b63\u5728\u4fdd\u5b58\u6587\u4ef6", 0).show();
    }

    @TargetApi(14)
    protected boolean s(Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("file_browser_extra_params");
        if (bundleExtra == null) {
            return false;
        }
        int i3 = bundleExtra.getInt("enter_file_browser_optype", 0);
        this.f208274s = i3;
        if (i3 == 58) {
            this.f208275t = bundleExtra.getString("key_url", "");
            this.f208265j = bundleExtra.getBoolean("key_from_troop_plugin", true);
            return true;
        }
        String string = bundleExtra.getString("key_troop_file_id", "");
        this.f208262g = string;
        if (string.isEmpty()) {
            return false;
        }
        this.f208263h = bundleExtra.getString("key_troop_file_md5", "");
        this.f208264i = bundleExtra.getInt("key_troop_bus_id", 102);
        this.f208265j = bundleExtra.getBoolean("key_from_troop_plugin", true);
        this.f208266k = bundleExtra.getInt(IFileBrowserService.STRING_BROWSE_ID, 0);
        this.f208267l = bundleExtra.getInt("key_preview_entrance", 4);
        this.f208268m = bundleExtra.getBoolean("key_is_c2c_type", false);
        this.f208269n = bundleExtra.getBoolean("key_is_send", false);
        this.f208270o = bundleExtra.getLong("key_send_uin", 0L);
        this.f208271p = bundleExtra.getBoolean("key_need_report", false);
        return true;
    }

    public void t() {
        EIPCClient client = QIPCClientHelper.getInstance().getClient();
        client.removeCallback(this.f208278w);
        client.removeCallback(this.f208280y);
    }

    public String w() {
        return this.f208258c.f();
    }

    public int x() {
        return this.f208274s;
    }

    public String y() {
        String str;
        int i3;
        long j3;
        if (this.f208274s == 58) {
            return this.f208275t;
        }
        if (this.f208267l == 4) {
            str = "s_qq_grpfile_list";
        } else {
            str = "s_qq_grp_aio";
        }
        String lowerCase = q.j(this.f208258c.f()).toLowerCase();
        int i16 = 2;
        if (this.f208269n) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        boolean z16 = this.f208268m;
        if (z16) {
            j3 = this.f208270o;
        } else {
            j3 = this.f208260e;
        }
        if (z16) {
            i16 = 0;
        }
        if (lowerCase.startsWith(".") && lowerCase.length() > 0) {
            lowerCase = lowerCase.substring(1, lowerCase.length());
        }
        String u16 = u(lowerCase);
        if (u16 == null || u16.isEmpty()) {
            u16 = "https://qqandroid.docs.qq.com/document/importFile";
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        StringBuffer stringBuffer = new StringBuffer(u16);
        stringBuffer.append("?file_id=");
        stringBuffer.append(Uri.encode(this.f208262g));
        stringBuffer.append("&scene_file_id=");
        stringBuffer.append(Uri.encode(this.f208263h));
        stringBuffer.append("&filename=");
        stringBuffer.append(Uri.encode(this.f208258c.f()));
        stringBuffer.append("&scene_id=");
        stringBuffer.append(j3);
        stringBuffer.append("&filesize=");
        stringBuffer.append(this.f208258c.g());
        stringBuffer.append("&business_type=2");
        stringBuffer.append("&scene_type=");
        stringBuffer.append(i16);
        stringBuffer.append("&bus_id=");
        stringBuffer.append(this.f208264i);
        stringBuffer.append("&src_type=");
        stringBuffer.append(lowerCase);
        stringBuffer.append("&from=qunfile");
        stringBuffer.append("&tdsourcetag=");
        stringBuffer.append(str);
        stringBuffer.append("&owner_type=");
        stringBuffer.append(i3);
        stringBuffer.append("&file_md5=");
        stringBuffer.append(this.f208263h);
        stringBuffer.append("&client=qq_files");
        stringBuffer.append("&third_appid=8622083aae9947b5b461fd03a42f1c6a");
        if (!this.f208271p) {
            stringBuffer.append("&disablePreviewReport=1");
        } else {
            stringBuffer.append("&is_qq_vip=");
            stringBuffer.append(VasUtil.getSignedService(peekAppRuntime).getVipStatus().isVip() ? 1 : 0);
            stringBuffer.append("&is_qq_super_vip=");
            stringBuffer.append(VasUtil.getSignedService(peekAppRuntime).getVipStatus().isSVip() ? 1 : 0);
            stringBuffer.append("&sso_bld=");
            stringBuffer.append(BaseApplication.getContext().getAppId());
            if (!this.f208268m) {
                ITroopInfoService iTroopInfoService = (ITroopInfoService) ((AppInterface) peekAppRuntime.getAppRuntime("modular_web")).getRuntimeService(ITroopInfoService.class, "");
                stringBuffer.append("&group_name=");
                stringBuffer.append(Uri.encode(iTroopInfoService.getTroopNameByID(String.valueOf(this.f208260e))));
            }
        }
        return stringBuffer.toString();
    }

    public int z() {
        return this.f208272q;
    }
}
