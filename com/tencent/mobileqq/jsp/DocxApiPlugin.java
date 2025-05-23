package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkPicBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.doc.e;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.jsp.DocxApiPlugin;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkForceShare;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder;
import com.tencent.mobileqq.teamwork.TenDocWebPreLoadHelper;
import com.tencent.mobileqq.teamwork.api.ICameraHelper;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.IVoiceInputHelper;
import com.tencent.mobileqq.teamwork.bo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.UnVisibleWebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.util.Pair;
import com.tencent.xweb.FileReaderHelper;
import com.tenpay.realname.RealNameSource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class DocxApiPlugin extends WebViewPlugin {

    /* renamed from: e, reason: collision with root package name */
    private ICameraHelper f238585e;

    /* renamed from: f, reason: collision with root package name */
    private IVoiceInputHelper f238586f;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.doc.e f238584d = null;

    /* renamed from: h, reason: collision with root package name */
    private String f238587h = null;

    /* renamed from: i, reason: collision with root package name */
    private ClipData f238588i = null;

    /* renamed from: m, reason: collision with root package name */
    private long f238589m = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.jsp.DocxApiPlugin$2, reason: invalid class name */
    /* loaded from: classes33.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f238592d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f238593e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f238594f;

        AnonymousClass2(Activity activity, String str, String str2) {
            this.f238592d = activity;
            this.f238593e = str;
            this.f238594f = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, String str2, Object obj) {
            if (!(obj instanceof ArrayList)) {
                DocxApiPlugin.this.callJs("insertImageForNativeJSBridge('" + ((Object) null) + "','" + str + "','" + str2 + "')");
                if (QLog.isColorLevel()) {
                    QLog.i("TeamWorkDocEditBrowserActivity", 2, "picture upload fail");
                    return;
                }
                return;
            }
            ArrayList arrayList = (ArrayList) obj;
            if (!arrayList.isEmpty()) {
                String str3 = (String) arrayList.get(0);
                if (QLog.isColorLevel()) {
                    QLog.i("TeamWorkDocEditBrowserActivity", 2, " url = " + str3 + " fileName = " + str2);
                }
                DocxApiPlugin.this.callJs("insertImageForNativeJSBridge('" + str3 + "','" + str + "','" + str2 + "')");
                return;
            }
            DocxApiPlugin.this.callJs("insertImageForNativeJSBridge('" + ((Object) null) + "','" + str + "','" + str2 + "')");
            if (QLog.isColorLevel()) {
                QLog.i("TeamWorkDocEditBrowserActivity", 2, "picture upload fail");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment teamWorkDocEditBrowserFragment = (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment) ((TeamWorkDocEditBrowserActivity) this.f238592d).getCurrentWebViewFragment();
            if (teamWorkDocEditBrowserFragment == null) {
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.f238593e);
            final String name = new File(this.f238593e).getName();
            TeamWorkDocEditBrowserActivity teamWorkDocEditBrowserActivity = (TeamWorkDocEditBrowserActivity) this.f238592d;
            String str = teamWorkDocEditBrowserFragment.T;
            String str2 = teamWorkDocEditBrowserFragment.U;
            int i3 = teamWorkDocEditBrowserFragment.M;
            final String str3 = this.f238594f;
            teamWorkDocEditBrowserActivity.I2(arrayList, str, "1", str2, i3, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.jsp.g
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    DocxApiPlugin.AnonymousClass2.this.b(str3, name, obj);
                }
            });
        }
    }

    /* loaded from: classes33.dex */
    class a implements e.a {
        a() {
        }

        @Override // com.tencent.mobileqq.doc.e.a
        public void a(com.tencent.mobileqq.doc.e eVar) {
            try {
                eVar.dismiss();
            } catch (Throwable th5) {
                QLog.e("DocxApiPlugin", 1, "handleEvent", th5);
            }
            DocxApiPlugin.this.mRuntime.a().finish();
            ReportController.o(null, "CliOper", "", "", "0X80094EB", "0X80094EB", 0, 0, "", "", "", "");
        }
    }

    private void q() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.jsp.DocxApiPlugin.6
            @Override // java.lang.Runnable
            public void run() {
                TeamWorkHandlerUtils.c();
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final ArrayList<String> arrayList) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.jsp.DocxApiPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    TeamWorkHandlerUtils.f(DocxApiPlugin.this.mRuntime.b().getCurrentAccountUin(), TeamWorkHandlerUtils.j(str), str);
                }
            }
        }, 128, null, false);
    }

    public static void sendDocsDataBack(final String str, final TouchWebView touchWebView) {
        HashMap<String, Integer> hashMap;
        if (!new ta1.n().c()) {
            try {
                final JSONObject jSONObject = new JSONObject();
                jSONObject.put("retcode", 1);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.jsp.DocxApiPlugin.7
                    @Override // java.lang.Runnable
                    public void run() {
                        TouchWebView.this.loadUrl("javascript:window.injectLocalTcntDocData(" + jSONObject.toString() + ")");
                    }
                });
                return;
            } catch (JSONException e16) {
                QLog.e("DocxApiPlugin", 1, "JSONException ", e16);
                return;
            }
        }
        if (TextUtils.isEmpty(str) || (hashMap = bo.f292111e) == null || hashMap.get(str) == null || bo.f292111e.get(str).intValue() != 2) {
            return;
        }
        bo.f292111e.remove(str);
        if (TeamWorkHandlerUtils.a(str)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.jsp.DocxApiPlugin.8
                @Override // java.lang.Runnable
                public void run() {
                    final String g16 = TeamWorkHandlerUtils.g(str);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.jsp.DocxApiPlugin.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            touchWebView.loadUrl("javascript:window.injectLocalTcntDocData(" + g16 + ")");
                        }
                    });
                    Log.e("tendocpreload", "end preload data send Back 2 Web ");
                }
            }, 64, null, false);
            return;
        }
        try {
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("retcode", 1);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.jsp.DocxApiPlugin.9
                @Override // java.lang.Runnable
                public void run() {
                    TouchWebView.this.loadUrl("javascript:window.injectLocalTcntDocData(" + jSONObject2.toString() + ")");
                }
            });
        } catch (JSONException e17) {
            QLog.e("DocxApiPlugin", 1, "JSONException ", e17);
        }
    }

    private void v(String str) {
        QLog.d("DocxApiPlugin", 2, "req json = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f238587h = jSONObject.optString("callback");
            new TeamWorkForceShare(this, jSONObject).n();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public synchronized void A(String str) {
        try {
            String optString = new JSONObject(str).optString("folderId");
            final QQBrowserActivity qQBrowserActivity = (QQBrowserActivity) this.mRuntime.a();
            final String url = qQBrowserActivity.getHostWebView().getUrl();
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.jsp.DocxApiPlugin.10
                @Override // java.lang.Runnable
                public void run() {
                    ea.E2(qQBrowserActivity, url);
                }
            }, null, true);
            ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openFileSelectorByDocApiPlugin(qQBrowserActivity, optString);
            qQBrowserActivity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
        } catch (Exception e16) {
            QLog.e("DocxApiPlugin", 1, "openFMActivityToImport exception e = " + e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return FileReaderHelper.DOCX_EXT;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8589934615L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        QQBrowserActivity qQBrowserActivity;
        WebViewFragment currentWebViewFragment;
        WebViewFragment currentWebViewFragment2;
        SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler;
        JSONArray jSONArray;
        if (QLog.isColorLevel()) {
            QLog.d("DocxApiPlugin", 2, " handleJsRequest url = " + str + " pkgName = " + str2 + ",method = " + str3);
        }
        if (FileReaderHelper.DOCX_EXT.equals(str2)) {
            addOpenApiListenerIfNeeded(str3, jsBridgeListener);
            if ("readyToInsertImageCallBack".equals(str3) && strArr.length <= 1) {
                try {
                    if (strArr.length == 1) {
                        JSONObject jSONObject = new JSONObject(strArr[0]);
                        String string = jSONObject.getString("attachmentId");
                        String string2 = jSONObject.getString("localpath");
                        Activity a16 = this.mRuntime.a();
                        if (QLog.isColorLevel()) {
                            QLog.i("TeamWorkDocEditBrowserActivity", 2, "\u56de\u8c03id = " + string + " localPath = " + string2);
                        }
                        if (a16 != null && (a16 instanceof TeamWorkDocEditBrowserActivity)) {
                            ThreadManagerV2.postImmediately(new AnonymousClass2(a16, string2, string), null, false);
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("DocxApiPlugin", 4, "readyToInsertImageCallBack failed:" + e16);
                    }
                }
            } else if ("getDocxImageIndex".equals(str3) && strArr.length <= 1) {
                try {
                    if (strArr.length == 1) {
                        JSONObject jSONObject2 = new JSONObject(strArr[0]);
                        ArrayList arrayList = new ArrayList();
                        int i3 = jSONObject2.has("currentImageIndex") ? jSONObject2.getInt("currentImageIndex") : -1;
                        if (jSONObject2.has("imageList") && (jSONArray = jSONObject2.getJSONArray("imageList")) != null) {
                            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                                arrayList.add((String) jSONArray.get(i16));
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("TeamWorkDocEditBrowserActivity", 2, " index = " + i3 + " urls.size = " + arrayList.size());
                        }
                        Activity a17 = this.mRuntime.a();
                        if (a17 != null && (a17 instanceof TeamWorkDocEditBrowserActivity) && i3 != -1) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                                PicInfo picInfo = new PicInfo();
                                picInfo.f258917e = (String) arrayList.get(i17);
                                picInfo.f258918f = (String) arrayList.get(i17);
                                arrayList2.add(picInfo);
                            }
                            Intent intent = new Intent(a17, (Class<?>) TeamWorkPicBrowserActivity.class);
                            intent.putExtra("intent_param_index", i3);
                            intent.putExtra("intent_param_pic_infos", arrayList2);
                            intent.addFlags(536870912);
                            a17.startActivity(intent);
                        }
                    }
                } catch (Exception e17) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("DocxApiPlugin", 4, "getDocxImageList failed:" + e17);
                    }
                }
            } else if ("setAuthForSharePad".equals(str3) && strArr.length <= 1) {
                try {
                    if (strArr.length == 1 && (this.mRuntime.a() instanceof QQBrowserActivity)) {
                        com.tencent.mobileqq.teamwork.o oVar = new com.tencent.mobileqq.teamwork.o();
                        JSONObject jSONObject3 = new JSONObject(strArr[0]);
                        oVar.f292295a = (String) jSONObject3.opt("authFirstLineInfo");
                        oVar.f292296b = (String) jSONObject3.opt("authSecondLineInfo");
                        oVar.f292297c = ((Integer) jSONObject3.opt("policy")).intValue();
                        oVar.f292298d = ((Boolean) jSONObject3.opt("isCreator")).booleanValue();
                        oVar.f292299e = (String) jSONObject3.opt("docName");
                        oVar.f292300f = ((Integer) jSONObject3.opt("docType")).intValue();
                        oVar.f292301g = (String) jSONObject3.opt("docIconUrl");
                        oVar.f292302h = ((Integer) jSONObject3.opt("taskType")).intValue();
                        oVar.f292303i = (String) jSONObject3.opt(GetGuildJoinUrlServlet.BUNDLE_KEY_URL);
                        oVar.f292304j = ((Integer) jSONObject3.opt("memLength")).intValue();
                        oVar.f292305k = (String) jSONObject3.opt("memListPrefix");
                        oVar.f292306l = (String) jSONObject3.opt("descriptionSuffix");
                        oVar.f292307m = (String) jSONObject3.opt("padId");
                        oVar.f292308n = (String) jSONObject3.opt("domainId");
                        oVar.f292309o = (String) jSONObject3.opt("padTitle");
                        oVar.f292310p = (String) jSONObject3.opt("folderId");
                        QQBrowserActivity qQBrowserActivity2 = (QQBrowserActivity) this.mRuntime.a();
                        if (qQBrowserActivity2 != null && qQBrowserActivity2.getCurrentWebViewFragment() != null && (currentWebViewFragment2 = qQBrowserActivity2.getCurrentWebViewFragment()) != null) {
                            ((Share) currentWebViewFragment2.getShare()).d0(oVar);
                            com.tencent.mobileqq.webview.swift.component.b componentProvider = currentWebViewFragment2.getComponentProvider();
                            if (componentProvider != null && (swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) componentProvider.a(4)) != null) {
                                ShareActionSheetBuilder shareActionSheetBuilder = swiftBrowserShareMenuHandler.C;
                                if (shareActionSheetBuilder instanceof TeamWorkShareActionSheetBuilder) {
                                    shareActionSheetBuilder.updateUIIfShowing();
                                }
                            }
                        }
                    }
                } catch (Exception e18) {
                    QLog.d("DocxApiPlugin", 1, "setAuthForSharePad error:" + e18);
                }
            } else {
                if ("sendDocToChat".equals(str3) && strArr.length <= 1) {
                    return B(strArr[0]);
                }
                if ("writeSystemClipboard".equals(str3) && strArr.length <= 1) {
                    if (strArr.length == 1) {
                        x(strArr[0]);
                    }
                } else if ("readSystemClipboard".equals(str3) && strArr.length <= 1) {
                    if (strArr.length == 1) {
                        u(strArr[0]);
                    }
                } else if ("eventShare".equals(str3) && strArr.length == 1) {
                    v(strArr[0]);
                } else if ("openLocalFilesToImport".equals(str3) && strArr.length <= 1) {
                    A(strArr[0]);
                } else if ("openExportedFile".equals(str3) && strArr.length <= 1) {
                    s(strArr[0]);
                } else if ("openExportedFileAndDownload".equals(str3) && strArr.length <= 1) {
                    if (NetworkUtil.isNetSupport(this.mRuntime.a())) {
                        t(strArr[0]);
                    } else {
                        QQToast.makeText(this.mRuntime.a(), this.mRuntime.a().getString(R.string.c4w), 0).show();
                    }
                } else if ("txDocsStartExport".equals(str3) && strArr.length <= 1) {
                    WebViewPlugin.b bVar = this.mRuntime;
                    if (bVar != null && bVar.a() != null) {
                        if (NetworkUtil.isNetSupport(this.mRuntime.a())) {
                            w(strArr[0]);
                        } else {
                            QQToast.makeText(this.mRuntime.a(), this.mRuntime.a().getString(R.string.c4w), 0).show();
                        }
                    }
                } else if (IVoiceInputHelper.METHOD_VOICE_INPUT_SETUP.equals(str3) && strArr.length <= 1) {
                    IVoiceInputHelper iVoiceInputHelper = this.f238586f;
                    if (iVoiceInputHelper == null) {
                        IVoiceInputHelper iVoiceInputHelper2 = ((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getIVoiceInputHelper(this);
                        this.f238586f = iVoiceInputHelper2;
                        iVoiceInputHelper2.setup();
                    } else if (!iVoiceInputHelper.isInitialized()) {
                        this.f238586f.setup();
                    }
                } else if (IVoiceInputHelper.METHOD_VOICE_INPUT_START.equals(str3) && strArr.length <= 1) {
                    if (this.f238586f != null) {
                        if (strArr.length == 1) {
                            try {
                                return this.f238586f.start(new JSONObject(strArr[0]).optString("callback"));
                            } catch (Throwable th5) {
                                QLog.e("DocxApiPlugin", 1, "VoiceInputHelper start error", th5);
                            }
                        } else {
                            QLog.e("DocxApiPlugin", 1, "VoiceInputHelper start args error.");
                        }
                    } else {
                        QLog.e("DocxApiPlugin", 1, "VoiceInputHelper has destroyed, start failed.");
                    }
                } else if (IVoiceInputHelper.METHOD_VOICE_INPUT_STOP.equals(str3) && strArr.length <= 1) {
                    IVoiceInputHelper iVoiceInputHelper3 = this.f238586f;
                    if (iVoiceInputHelper3 != null) {
                        iVoiceInputHelper3.stop();
                    }
                } else if (ICameraHelper.METHOD_CAMERA_CHECK_PERMISSION.equals(str3) && strArr.length <= 1) {
                    if (this.f238585e == null) {
                        this.f238585e = ((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getCameraHelper(this);
                    }
                    if (strArr.length == 1) {
                        try {
                            return this.f238585e.checkPermission(new JSONObject(strArr[0]).optString("callback"));
                        } catch (Throwable th6) {
                            QLog.e("DocxApiPlugin", 1, "CameraHelper checkPermission error", th6);
                        }
                    } else {
                        QLog.e("DocxApiPlugin", 1, "CameraHelper checkPermission args error.");
                    }
                } else if (IVoiceInputHelper.METHOD_RECORD_CHECK_PERMISSION.equals(str3) && strArr.length <= 1) {
                    if (this.f238586f == null) {
                        this.f238586f = ((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getIVoiceInputHelper(this);
                    }
                    if (strArr.length == 1) {
                        try {
                            return this.f238586f.checkPermission(new JSONObject(strArr[0]).optString("callback"));
                        } catch (Throwable th7) {
                            QLog.e("DocxApiPlugin", 1, "VoiceInputHelper checkPermission error", th7);
                        }
                    } else {
                        QLog.e("DocxApiPlugin", 1, "VoiceInputHelper checkPermission args error.");
                    }
                } else if ("getTcntDocData".equals(str3) && strArr.length <= 1) {
                    try {
                        JSONObject jSONObject4 = new JSONObject(strArr[0]);
                        final String optString = jSONObject4.optString("url");
                        final String optString2 = jSONObject4.optString("callback");
                        final String j3 = TeamWorkHandlerUtils.j(optString);
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.jsp.DocxApiPlugin.3
                            @Override // java.lang.Runnable
                            public void run() {
                                ta1.n nVar = new ta1.n();
                                if (nVar.a() && nVar.b() && TeamWorkHandlerUtils.a(j3)) {
                                    DocxApiPlugin.this.callJs(optString2, TeamWorkHandlerUtils.g(j3));
                                } else {
                                    try {
                                        JSONObject jSONObject5 = new JSONObject();
                                        jSONObject5.put("retcode", 1);
                                        DocxApiPlugin.this.callJs(optString2, jSONObject5.toString());
                                    } catch (JSONException e19) {
                                        QLog.e("DocxApiPlugin", 1, "JSONException ", e19);
                                    }
                                }
                                ArrayList arrayList3 = new ArrayList(1);
                                arrayList3.add(optString);
                                DocxApiPlugin.this.r(arrayList3);
                            }
                        }, 64, null, false);
                    } catch (Exception e19) {
                        QLog.e("DocxApiPlugin", 1, "JSONException ", e19);
                    }
                } else if ("delTcntDocData".equals(str3) && strArr.length <= 1) {
                    try {
                        final String j16 = TeamWorkHandlerUtils.j(new JSONObject(strArr[0]).optString("url"));
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.jsp.DocxApiPlugin.4
                            @Override // java.lang.Runnable
                            public void run() {
                                TeamWorkHandlerUtils.d(j16);
                            }
                        }, 64, null, false);
                    } catch (JSONException e26) {
                        QLog.e("DocxApiPlugin", 1, "JSONException ", e26);
                    }
                } else if ("preFetchTcntDocData".equals(str3) && strArr.length <= 1) {
                    ta1.n nVar = new ta1.n();
                    if (!nVar.a() || !nVar.b()) {
                        return false;
                    }
                    q();
                    try {
                        JSONArray optJSONArray = new JSONObject(strArr[0]).optJSONArray("keys");
                        if (optJSONArray != null) {
                            ArrayList<String> arrayList3 = new ArrayList<>(optJSONArray.length());
                            for (int i18 = 0; i18 < optJSONArray.length(); i18++) {
                                arrayList3.add(optJSONArray.getJSONObject(i18).optString("doc_url"));
                            }
                            if (nVar.c() && !arrayList3.isEmpty()) {
                                String str4 = arrayList3.get(0);
                                if (((QBaseActivity) this.mRuntime.a()).getSupportFragmentManager().findFragmentByTag("doc_preload") == null) {
                                    QLog.e("DocxApiPlugin", 1, "tendocpreload UnVisibleWebViewFragment create ");
                                    TenDocWebPreLoadHelper.c(str4);
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("url", str4);
                                    intent2.putExtra("hide_more_button", true);
                                    intent2.putExtra("webStyle", "noBottomBar");
                                    intent2.putExtra("isScreenOrientationPortrait", true);
                                    intent2.putExtra("title", " ");
                                    ((QBaseActivity) this.mRuntime.a()).getSupportFragmentManager().beginTransaction().add(UnVisibleWebViewFragment.rh(intent2), "doc_preload").commitAllowingStateLoss();
                                }
                            }
                            r(arrayList3);
                        }
                    } catch (JSONException e27) {
                        QLog.e("DocxApiPlugin", 1, "JSONException ", e27);
                    }
                } else if ("showShareView".equals(str3) && strArr.length <= 1 && (qQBrowserActivity = (QQBrowserActivity) this.mRuntime.a()) != null && qQBrowserActivity.getCurrentWebViewFragment() != null && (currentWebViewFragment = qQBrowserActivity.getCurrentWebViewFragment()) != null && (currentWebViewFragment instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)) {
                    ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment) currentWebViewFragment).ti();
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        String str;
        int i16;
        int i17;
        super.onActivityResult(intent, b16, i3);
        String str2 = this.f238587h;
        if (str2 == null || TextUtils.isEmpty(str2)) {
            return;
        }
        if (b16 == 17) {
            str = "user canceld share panel";
            i16 = 0;
            i17 = 0;
        } else {
            str = "user canceled";
            if (b16 == 18 || b16 == 52) {
                i16 = b16 == 18 ? 1 : 2;
                if (i3 == 0) {
                    i3 = -1;
                    i17 = 0;
                } else {
                    i17 = 2;
                    i3 = 0;
                    str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                }
            } else {
                if (b16 == 86 || b16 == 120) {
                    i16 = b16 == 86 ? 3 : 4;
                    switch (i3) {
                        case -6:
                            str = "err ban";
                            i17 = 0;
                            break;
                        case -5:
                            str = "unsupport";
                            i17 = 0;
                            break;
                        case -4:
                            str = "auth denied";
                            i17 = 0;
                            break;
                        case -3:
                            str = "sent failed";
                            i17 = 0;
                            break;
                        case -2:
                            i17 = 0;
                            break;
                        case -1:
                            str = "err comm";
                            i17 = 0;
                            break;
                        case 0:
                            i17 = 2;
                            break;
                        default:
                            i17 = 0;
                            break;
                    }
                } else {
                    i16 = 0;
                    i3 = 0;
                    i17 = 0;
                }
                str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            }
        }
        String format = String.format("{\"type\":%d,\"action\":%d,\"ec\":%d,\"em\":\"%s\"}", Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i3), str);
        QLog.d("DocxApiPlugin", 2, "rsp json = " + format);
        callJs(this.f238587h, format);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        IVoiceInputHelper iVoiceInputHelper = ((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getIVoiceInputHelper(this);
        WebViewPlugin.b bVar = this.mRuntime;
        iVoiceInputHelper.preInit(bVar == null ? null : bVar.b());
    }

    public synchronized void s(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("success");
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString(WadlProxyConsts.PARAM_FILENAME);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSuccess", optBoolean);
            bundle.putString("url", optString);
            bundle.putString(WadlProxyConsts.PARAM_FILENAME, optString2);
            Activity a16 = this.mRuntime.a();
            String url = (!(a16 instanceof TeamWorkDocEditBrowserActivity) || ((TeamWorkDocEditBrowserActivity) a16).getHostWebView() == null) ? null : ((TeamWorkDocEditBrowserActivity) a16).getHostWebView().getUrl();
            if (TextUtils.isEmpty(url)) {
                url = jSONObject.optString("refer_url");
            }
            bundle.putString("docUrl", url);
            bundle.putString("cookie", CookieManager.getInstance().getCookie(optString));
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "TeamWorkModule", "action_download_export_file", bundle);
        } catch (Exception e16) {
            QLog.e("DocxApiPlugin", 1, "downloadExportedFile exception e = " + e16.toString());
        }
    }

    public synchronized void t(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("success");
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString(WadlProxyConsts.PARAM_FILENAME);
            Activity a16 = this.mRuntime.a();
            String url = (!(a16 instanceof TeamWorkDocEditBrowserActivity) || ((TeamWorkDocEditBrowserActivity) a16).getHostWebView() == null) ? null : ((TeamWorkDocEditBrowserActivity) a16).getHostWebView().getUrl();
            if (TextUtils.isEmpty(url)) {
                url = jSONObject.optString("refer_url");
            }
            String cookie = CookieManager.getInstance().getCookie(optString);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSuccess", optBoolean);
            bundle.putString("url", optString);
            bundle.putString(WadlProxyConsts.PARAM_FILENAME, optString2);
            bundle.putString("docUrl", url);
            bundle.putString("cookie", cookie);
            bundle.putBoolean(ITeamWorkUtils.FILE_BROWSER_PARAMS_KEY_MINI_PROGRAM, false);
            com.tencent.mobileqq.teamwork.w.d(this.mRuntime.a(), com.tencent.mobileqq.teamwork.w.c(optString2), bundle);
        } catch (Exception e16) {
            QLog.e("DocxApiPlugin", 1, "openDownloadExportedFile exception e = " + e16.toString());
        }
    }

    void u(String str) {
        String str2;
        int i3;
        try {
            if (QLog.isColorLevel()) {
                QLog.d("DocxApiPlugin", 2, "handleReadClipboard jsonString = " + str);
            }
            if (TextUtils.isEmpty(str)) {
                QLog.d("DocxApiPlugin", 1, "handleReadClipboard return for empty json");
                return;
            }
            String optString = new JSONObject(str).optString("callback");
            JSONObject jSONObject = new JSONObject();
            Activity a16 = this.mRuntime.a();
            if (a16 == null) {
                QLog.d("DocxApiPlugin", 1, "handleReadClipboard return for null activity");
                callJs(optString, String.valueOf(-2), jSONObject.toString());
                return;
            }
            ClipboardManager clipboardManager = (ClipboardManager) a16.getSystemService("clipboard");
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f238589m < 1000) {
                if (QLog.isColorLevel()) {
                    QLog.d("DocxApiPlugin", 2, "handleReadClipboard, frequency limit, abort");
                    return;
                }
                return;
            }
            this.f238589m = currentTimeMillis;
            ClipData primaryClip = ClipboardMonitor.getPrimaryClip(clipboardManager);
            if (QLog.isColorLevel()) {
                QLog.d("DocxApiPlugin", 2, "handleReadClipboard ClipData = " + primaryClip);
            }
            String str3 = null;
            if (primaryClip != null) {
                if (primaryClip.getItemCount() > 0) {
                    ClipData.Item itemAt = primaryClip.getItemAt(0);
                    str3 = itemAt.getText().toString();
                    str2 = itemAt.getHtmlText();
                } else {
                    str2 = null;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("DocxApiPlugin", 2, "handleReadClipboard text  = " + str3 + ",html = " + str2);
                }
            } else {
                str2 = null;
            }
            if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2)) {
                i3 = -1;
            } else {
                jSONObject.put("plain", str3);
                jSONObject.put(TextComponent.SpanType.HTML, str2);
                i3 = 0;
            }
            callJs(optString, String.valueOf(i3), jSONObject.toString());
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("DocxApiPlugin", 1, "handleReadClipboard exception", e16);
            try {
                callJs(new JSONObject(str).optString("callback"), String.valueOf(-3), new JSONObject().toString());
            } catch (Exception e17) {
                QLog.d("DocxApiPlugin", 1, "handleReadClipboard Exception e1", e17);
            }
        }
    }

    public synchronized void w(String str) {
        try {
            String optString = new JSONObject(str).optString(WadlProxyConsts.PARAM_FILENAME);
            new Bundle().putString(WadlProxyConsts.PARAM_FILENAME, optString);
            com.tencent.mobileqq.teamwork.w.e(this.mRuntime.a(), optString);
        } catch (Exception e16) {
            QLog.e("DocxApiPlugin", 1, "startExportedFile exception e = " + e16.toString());
        }
    }

    void x(String str) {
        String[] strArr;
        try {
            if (QLog.isColorLevel()) {
                QLog.d("DocxApiPlugin", 2, "handleWriteClipboard jsonString = " + str);
            }
            if (TextUtils.isEmpty(str)) {
                QLog.d("DocxApiPlugin", 1, "handleWriteClipboard return for empty json");
                return;
            }
            Activity a16 = this.mRuntime.a();
            if (a16 == null) {
                QLog.d("DocxApiPlugin", 1, "handleWriteClipboard return for null activity");
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("plain");
            String optString2 = jSONObject.optString(TextComponent.SpanType.HTML);
            if (QLog.isColorLevel()) {
                QLog.d("DocxApiPlugin", 2, "handleWriteClipboard text = " + optString + ",html = " + optString2);
            }
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2)) {
                QLog.d("DocxApiPlugin", 1, "handleWriteClipboard return for empty text and html");
                return;
            }
            ClipboardManager clipboardManager = (ClipboardManager) a16.getSystemService("clipboard");
            ClipData.Item item = new ClipData.Item(optString, optString2);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                strArr = new String[]{"text/plain", "text/html"};
            } else if (!TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2)) {
                strArr = new String[]{"text/plain"};
            } else {
                strArr = (!TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) ? null : new String[]{"text/html"};
            }
            ClipData clipData = new ClipData(new ClipDescription("", strArr), item);
            ClipData clipData2 = this.f238588i;
            if (clipData2 == null) {
                this.f238588i = clipData;
            } else if (y(clipData2, clipData)) {
                return;
            }
            ClipboardMonitor.setPrimaryClip(clipboardManager, clipData);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("DocxApiPlugin", 1, "handleWriteClipboard exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        this.f238584d = null;
        ICameraHelper iCameraHelper = this.f238585e;
        if (iCameraHelper != null) {
            iCameraHelper.destroy();
            this.f238585e = null;
        }
        IVoiceInputHelper iVoiceInputHelper = this.f238586f;
        if (iVoiceInputHelper != null) {
            iVoiceInputHelper.destroy();
            this.f238586f = null;
        }
        super.onDestroy();
    }

    public synchronized boolean B(String str) {
        String str2;
        long j3;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        QLog.i("DocxApiPlugin" + com.tencent.mobileqq.teamwork.t.f292405j, 1, "sendDocToChat been called. strJson = " + str);
        String str3 = " ";
        String str4 = "https://url.cn/UQoBHn";
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString(GetGuildJoinUrlServlet.BUNDLE_KEY_URL);
            String optString4 = jSONObject.optString("image_url");
            String optString5 = jSONObject.optString("type");
            String optString6 = jSONObject.optString("miniprogram_image_url");
            String optString7 = jSONObject.optString("graytipsinfo");
            String optString8 = jSONObject.optString("to_uin");
            int optInt = jSONObject.optInt(IPublicAccountBrowser.KEY_UIN_TYPE);
            QQBrowserActivity qQBrowserActivity = (QQBrowserActivity) this.mRuntime.a();
            String stringExtra = qQBrowserActivity.getIntent().getStringExtra(RealNameSource.EXTRA_KEY_SOURCE_NAME);
            if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrl(optString3)) {
                str3 = "web";
                stringExtra = HardCodeUtil.qqStr(R.string.lpe);
                str4 = ITeamWorkUtils.DOCS_LIST_WEB_URL;
                str2 = ITeamWorkUtils.DOCS_SOURCE_ICON_URL;
                j3 = ITeamWorkUtils.DOCS_APPID;
            } else {
                str2 = null;
                j3 = 801097412;
            }
            long j16 = j3;
            Intent intent = new Intent();
            intent.putExtra("type", optString5);
            intent.putExtra("miniprogram_image_url", optString6);
            intent.putExtra("key_flag_from_plugin", true);
            intent.setClass(qQBrowserActivity, ForwardRecentActivity.class);
            intent.putExtra("isFromShare", true);
            intent.putExtra("forward_type", 1001);
            intent.putExtra("pluginName", "web_share");
            intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 95);
            intent.putExtra("detail_url", optString3);
            intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, optString4);
            if (j16 != -1) {
                intent.putExtra("req_share_id", j16);
            }
            intent.putExtra(AppConstants.Key.SHARE_SOURCE_URL, str4);
            intent.putExtra("app_name", stringExtra);
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, str2);
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, str3);
            intent.putExtra(IPublicAccountJavascriptInterface.KEY_PUB_UIN, "");
            intent.putExtra("struct_uin", "");
            if (optString != null && optString.length() > 45) {
                optString = optString.substring(0, 45) + "\u2026";
            }
            intent.putExtra("title", optString);
            if (optString2 != null && optString2.length() > 60) {
                optString2 = optString2.substring(0, 60) + "\u2026";
            }
            intent.putExtra("desc", optString2);
            intent.putExtra(AppConstants.Key.FORWARD_THUMB, optString4);
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION, "web");
            intent.putExtra("req_share_id", -1L);
            intent.putExtra(AppConstants.Key.SHARE_BRIEF, qQBrowserActivity.getString(R.string.f171308dy0, optString));
            intent.putExtra("to_uin", optString8);
            intent.putExtra(IPublicAccountBrowser.KEY_UIN_TYPE, optInt);
            if (!TextUtils.isEmpty(optString7)) {
                intent.putExtra("docs_gray_tips_info_json", optString7);
            } else {
                QLog.i("DocxApiPlugin" + com.tencent.mobileqq.teamwork.t.f292405j, 1, "sendDocToChat. docsGrayInfoJson is empty.");
            }
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "TeamWorkModule", "send_to_chat_msg", intent.getExtras());
            return false;
        } catch (JSONException unused) {
            QLog.e("DocxApiPlugin" + com.tencent.mobileqq.teamwork.t.f292405j, 1, "sendDocToChat param error");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        IVoiceInputHelper iVoiceInputHelper;
        if (QLog.isColorLevel()) {
            QLog.i("DocxApiPlugin", 2, "handleEvent " + str + ", type=" + j3 + ", info=" + map);
        }
        if (j3 == 8589934601L) {
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar != null && bVar.a() != null && (this.mRuntime.a() instanceof QQBrowserActivity)) {
                if (!this.mRuntime.a().getIntent().getBooleanExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO, false)) {
                    QLog.e("DocxApiPlugin", 1, "handleEvent not fromAIO, url=" + str);
                }
                if (this.f238584d != null) {
                    QLog.e("DocxApiPlugin", 1, "handleEvent guide has shown");
                    return super.handleEvent(str, j3, map);
                }
                Pair<Boolean, Integer> a16 = com.tencent.mobileqq.doc.b.a(this.mRuntime.b());
                boolean booleanValue = a16.first.booleanValue();
                int intValue = a16.second.intValue();
                int a17 = com.tencent.mobileqq.doc.f.a(this.mRuntime.b(), this.mRuntime.a());
                if (QLog.isColorLevel()) {
                    QLog.i("DocxApiPlugin", 2, "handleEvent enable=" + booleanValue + ", total=" + intValue + ", shown=" + a17);
                }
                if (!booleanValue) {
                    QLog.e("DocxApiPlugin", 1, "handleEvent not enable");
                    return super.handleEvent(str, j3, map);
                }
                if (a17 >= intValue) {
                    QLog.e("DocxApiPlugin", 1, "handleEvent shown >= total");
                    return super.handleEvent(str, j3, map);
                }
                com.tencent.mobileqq.doc.e eVar = new com.tencent.mobileqq.doc.e(this.mRuntime.a());
                this.f238584d = eVar;
                eVar.N(new a());
                com.tencent.mobileqq.doc.f.b(this.mRuntime.b(), this.mRuntime.a(), a17 + 1);
                try {
                    this.f238584d.show();
                    ReportController.o(null, "CliOper", "", "", "0X80094EA", "0X80094EA", 0, 0, "", "", "", "");
                    return true;
                } catch (Throwable th5) {
                    QLog.e("DocxApiPlugin", 1, "", th5);
                    return super.handleEvent(str, j3, map);
                }
            }
            QLog.e("DocxApiPlugin", 1, "handleEvent sth is null or not instanceof QQBrowserActivity");
            return super.handleEvent(str, j3, map);
        }
        if (j3 == 8589934597L && (iVoiceInputHelper = this.f238586f) != null) {
            iVoiceInputHelper.stop();
        }
        return super.handleEvent(str, j3, map);
    }

    private boolean y(ClipData clipData, ClipData clipData2) {
        int mimeTypeCount;
        if (clipData == null && clipData2 == null) {
            return true;
        }
        if (clipData == null || clipData2 == null) {
            return false;
        }
        ClipDescription description = clipData.getDescription();
        ClipDescription description2 = clipData2.getDescription();
        if (!description.getLabel().equals(description2.getLabel()) || (mimeTypeCount = description.getMimeTypeCount()) != description2.getMimeTypeCount()) {
            return false;
        }
        for (int i3 = 0; i3 < mimeTypeCount; i3++) {
            if (!description.getMimeType(i3).equals(description2.getMimeType(i3))) {
                return false;
            }
        }
        int itemCount = clipData.getItemCount();
        if (itemCount != clipData2.getItemCount()) {
            return false;
        }
        if (itemCount > 0) {
            return z(clipData.getItemAt(0), clipData2.getItemAt(0));
        }
        return true;
    }

    private boolean z(ClipData.Item item, ClipData.Item item2) {
        if (item == null && item2 == null) {
            return true;
        }
        return item != null && item2 != null && item.getText().equals(item2.getText()) && item.getHtmlText().equals(item2.getHtmlText());
    }
}
