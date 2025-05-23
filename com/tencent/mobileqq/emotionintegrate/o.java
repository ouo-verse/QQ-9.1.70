package com.tencent.mobileqq.emotionintegrate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.emoticonview.api.IAiEmoticonService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import cooperation.qzone.QzoneIPCModule;
import eipc.EIPCResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class o extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private String f205260d;

    /* renamed from: e, reason: collision with root package name */
    private String f205261e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            o.this.K();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            QLog.d("EmoticonPlugin", 1, "requestPermissions denied " + list + list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f205263a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f205264b;

        b(Activity activity, int i3) {
            this.f205263a = activity;
            this.f205264b = i3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            o.this.I(this.f205263a, this.f205264b);
        }
    }

    private void A() {
        WebViewPlugin.b bVar = this.mRuntime;
        Activity a16 = bVar != null ? bVar.a() : null;
        if (a16 == null) {
            QLog.w("EmoticonPlugin", 1, "[error] activity is null, cant goToMsgTab");
            return;
        }
        QLog.d("EmoticonPlugin", 1, "goToMsgTab");
        Intent aliasIntent = SplashActivity.getAliasIntent(a16);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, 1);
        aliasIntent.setFlags(335544320);
        a16.startActivity(aliasIntent);
    }

    private void B(String[] strArr) {
        WebViewPlugin.b bVar = this.mRuntime;
        Activity a16 = bVar != null ? bVar.a() : null;
        if (a16 == null) {
            return;
        }
        int i3 = 2;
        boolean z16 = false;
        try {
            QLog.i("EmoticonPlugin", 1, "handleAiEmoticonChoosePic  args:" + strArr[0]);
            JSONObject jSONObject = new JSONObject(strArr[0]);
            this.f205260d = jSONObject.optString("callback");
            z16 = jSONObject.optBoolean("useCamera", false);
            i3 = jSONObject.optInt("count", 2);
        } catch (JSONException e16) {
            QLog.d("EmoticonPlugin", 1, "handleAiEmoticonChoosePic error: " + ThrowablesUtils.getStackTraceAsString(e16));
        }
        if (z16) {
            x(a16);
        } else {
            w(a16, i3);
        }
    }

    private void D(Intent intent, int i3) {
        QLog.i("EmoticonPlugin", 1, "handleOpenCameraResult  resultCode:" + i3);
        if (i3 != -1) {
            callJs(this.f205260d, v("result code error").toString());
            return;
        }
        final Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            QLog.i("EmoticonPlugin", 1, "handleOpenCameraResult activity is null");
            return;
        }
        if (TextUtils.isEmpty(this.f205261e)) {
            QLog.i("EmoticonPlugin", 1, "handleOpenCameraResult activity is null");
            return;
        }
        final QQProgressDialog qQProgressDialog = new QQProgressDialog(a16, a16.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        qQProgressDialog.setMessage(R.string.c7z);
        qQProgressDialog.O(new j(qQProgressDialog));
        qQProgressDialog.show();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emotionintegrate.l
            @Override // java.lang.Runnable
            public final void run() {
                o.this.H(a16, qQProgressDialog);
            }
        }, 192, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(Activity activity, int i3, boolean z16, QQProgressDialog qQProgressDialog, LoadState loadState, Option option) {
        if (loadState == LoadState.STATE_DOWNLOAD_SUCCESS) {
            M(activity, option.getLocalPath(), i3, z16);
        } else if (loadState == LoadState.STATE_DOWNLOAD_FAILED) {
            QLog.i("EmoticonPlugin", 1, "download pic failed");
        }
        qQProgressDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F() {
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", IEmoticonPanelIpcService.ACTION_GET_AI_EMOTICON_LIST, new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(EIPCResult eIPCResult, Activity activity, QQProgressDialog qQProgressDialog) {
        if (eIPCResult == null) {
            QLog.i("EmoticonPlugin", 1, "handleOpenCameraResult result is null");
            QQToast.makeText(activity, R.string.xan, 0).show();
            qQProgressDialog.dismiss();
            return;
        }
        if (eIPCResult.code == -102) {
            QQToast.makeText(activity, eIPCResult.data.getInt("ai_emoticon_toast_res"), 0).show();
            qQProgressDialog.dismiss();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String string = eIPCResult.data.getString("ai_emoticon_choose_pic_result");
            String string2 = eIPCResult.data.getString("ai_emoticon_choose_pic_path");
            jSONObject.put("succeeded", true);
            jSONObject.put("result", string);
            jSONObject.put(QzoneIPCModule.PIC_PATH, string2);
            callJs(this.f205260d, jSONObject.toString());
            QLog.e("EmoticonPlugin", 1, "callJs result:" + jSONObject);
        } catch (Exception e16) {
            callJs(this.f205260d, v(e16.getMessage()).toString());
            QLog.e("EmoticonPlugin", 1, "handleOpenCameraResult assemble package failed", e16);
        }
        qQProgressDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(final Activity activity, final QQProgressDialog qQProgressDialog) {
        Bundle bundle = new Bundle();
        bundle.putString(IEmoticonPanelIpcService.PARAM_FILE_PATH, this.f205261e);
        this.f205261e = null;
        final EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", IEmoticonPanelIpcService.ACTION_UPLOAD_PIC_AND_CHECK, bundle);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emotionintegrate.n
            @Override // java.lang.Runnable
            public final void run() {
                o.this.G(callServer, activity, qQProgressDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Activity activity, int i3) {
        Intent aiEmoticonAlbumIntent = ((IAiEmoticonService) QRoute.api(IAiEmoticonService.class)).getAiEmoticonAlbumIntent(activity, i3);
        if (aiEmoticonAlbumIntent != null) {
            activity.startActivityForResult(aiEmoticonAlbumIntent, L(2));
            ReportController.o(null, "dc00898", "", "", "0X800C607", "0X800C607", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        WebViewPlugin.b bVar = this.mRuntime;
        Activity a16 = bVar != null ? bVar.a() : null;
        if (a16 == null) {
            return;
        }
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady(QQWinkConstants.ENTRY_QQ_OTHER)) {
            J();
        } else {
            com.tencent.mobileqq.emotionintegrate.media.a.c(a16, L(4));
        }
    }

    private static int L(int i3) {
        return i3 + (ao.b("emoticon") << 8);
    }

    private void M(Activity activity, String str, int i3, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
        bundle.putBoolean("key_flag_from_plugin", true);
        bundle.putBoolean("forward_photo_shortvideo_is_edited", true);
        bundle.putInt(AppConstants.Key.FORWARD_PIC_SUB_TYPE, i3);
        bundle.putBoolean(AppConstants.Key.FORWARD_SHOW_WECHAT_ENTRANCE, z16);
        bundle.putBoolean("isWebCompShare", true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentActivity.class, 21, -1, "");
    }

    private void N(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            SearchEmoticonWebBean searchEmoticonWebBean = new SearchEmoticonWebBean();
            searchEmoticonWebBean.f205169d = jSONObject.optString("emt_name", "");
            searchEmoticonWebBean.f205170e = jSONObject.optString("emt_oriUrl", "");
            searchEmoticonWebBean.f205171f = jSONObject.optString("emt_oriMd5", "");
            searchEmoticonWebBean.f205172h = jSONObject.optInt("emt_oriFileSize", 0);
            searchEmoticonWebBean.f205173i = jSONObject.optInt("emt_oriWidth", 0);
            searchEmoticonWebBean.f205174m = jSONObject.optInt("emt_oriHeight", 0);
            searchEmoticonWebBean.C = jSONObject.optInt("emt_type", 0);
            searchEmoticonWebBean.D = jSONObject.optString("emt_packCoverUrl", "");
            searchEmoticonWebBean.E = jSONObject.optString("emt_packId", "");
            searchEmoticonWebBean.F = jSONObject.optString("emt_packName", "");
            searchEmoticonWebBean.G = jSONObject.optString("emt_miniId", "");
            searchEmoticonWebBean.H = jSONObject.optString("emt_miniName", "");
            SearchEmoticonFragment.Fh(this.mRuntime.a(), searchEmoticonWebBean);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonPlugin", 2, "showEmoticon error : " + ThrowablesUtils.getStackTraceAsString(e16));
            }
        }
    }

    private void O(String[] strArr) {
        String str = "";
        WebViewPlugin.b bVar = this.mRuntime;
        Activity a16 = bVar != null ? bVar.a() : null;
        if (a16 == null) {
            return;
        }
        try {
            str = new JSONObject(strArr[0]).optString("type", "");
        } catch (JSONException e16) {
            QLog.d("EmoticonPlugin", 1, "showEmoticonPanel error: " + ThrowablesUtils.getStackTraceAsString(e16));
        }
        if ("aiEmoticon".equals(str)) {
            a16.setResult(1003);
        }
    }

    private JSONObject v(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("succeeded", false);
            jSONObject.put("message", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void w(Activity activity, int i3) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ALBUM, QQPermissionConstants.Business.SCENE.OPEN_ALBUM));
        if (qQPermission == null) {
            QLog.d("EmoticonPlugin", 1, "handleAiEmoticonChoosePic qqPermission is null");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            I(activity, i3);
        } else {
            qQPermission.requestPermissions(QQPermissionConstants.Permission.GROUP_STORAGE, 2, new b(activity, i3));
        }
    }

    private void x(Activity activity) {
        if (QavCameraUsage.a(BaseApplication.getContext())) {
            QLog.i("EmoticonPlugin", 1, "chooseFromCamera but camera used");
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEBVIEW, QQPermissionConstants.Business.SCENE.WEBVIEW_MEDIA));
        if (qQPermission == null) {
            QLog.d("EmoticonPlugin", 1, "chooseFromCamera qqPermission is null");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) == 0) {
            K();
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new a());
        }
    }

    private void z(String[] strArr) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emotionintegrate.m
            @Override // java.lang.Runnable
            public final void run() {
                o.F();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "emoticon";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"emoticon".equals(str2)) {
            return false;
        }
        if ("showEmoticon".equals(str3)) {
            N(strArr);
            return true;
        }
        if ("aiEmoticonChoosePic".equals(str3)) {
            B(strArr);
            return true;
        }
        if ("showEmoticonPanel".equals(str3)) {
            O(strArr);
            return true;
        }
        if (IEmoticonPanelIpcService.ACTION_GET_AI_EMOTICON_LIST.equals(str3)) {
            z(strArr);
            return true;
        }
        if ("shareEmoticon".equals(str3)) {
            y(strArr);
            return true;
        }
        if (!"goToMsgTab".equals(str3)) {
            return true;
        }
        A();
        return true;
    }

    private void J() {
        File file;
        try {
            file = File.createTempFile("IMAGE_" + System.currentTimeMillis() + "_", ".jpg", BaseApplication.getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        } catch (IOException e16) {
            QLog.e("EmoticonPlugin", 1, "createImageFileError: ", e16);
            file = null;
        }
        if (file == null) {
            return;
        }
        this.f205261e = file.getAbsolutePath();
        Intent intent = new Intent();
        FileProvider7Helper.setSystemCapture(BaseApplication.getContext(), file, intent);
        intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        startActivityForResult(intent, (byte) 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void y(String[] strArr) {
        int i3;
        final Activity a16;
        JSONObject jSONObject;
        if (strArr != null && strArr.length != 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("shareEmoticon  jsonString:");
            boolean z16 = false;
            sb5.append(strArr[0]);
            QLog.i("EmoticonPlugin", 1, sb5.toString());
            String str = null;
            try {
                jSONObject = new JSONObject(strArr[0]);
                str = jSONObject.optString("image", "");
                i3 = jSONObject.optInt("type");
            } catch (JSONException e16) {
                e = e16;
                i3 = 0;
            }
            try {
                z16 = jSONObject.optBoolean("shareToWX");
            } catch (JSONException e17) {
                e = e17;
                QLog.d("EmoticonPlugin", 1, "shareEmoticon error: " + ThrowablesUtils.getStackTraceAsString(e));
                final int i16 = i3;
                final boolean z17 = z16;
                a16 = this.mRuntime.a();
                if (a16 != null) {
                }
            }
            final int i162 = i3;
            final boolean z172 = z16;
            a16 = this.mRuntime.a();
            if (a16 != null) {
                QLog.i("EmoticonPlugin", 1, "shareEmoticon activity is null");
                return;
            }
            final QQProgressDialog qQProgressDialog = new QQProgressDialog(a16, a16.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            qQProgressDialog.setMessage(R.string.c7z);
            qQProgressDialog.O(new j(qQProgressDialog));
            qQProgressDialog.show();
            QQPicLoader.f201806a.d().download(Option.obtain().setUrl(str), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.emotionintegrate.k
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    o.this.E(a16, i162, z172, qQProgressDialog, loadState, option);
                }
            });
            return;
        }
        QLog.i("EmoticonPlugin", 1, "shareEmoticon args is empty");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        if (b16 == 2) {
            C(intent, i3);
        } else if (b16 == 3) {
            D(intent, i3);
        } else if (b16 == 4) {
            if (intent == null) {
                QLog.i("EmoticonPlugin", 1, "onActivityResult intent is null");
                callJs(this.f205260d, v("intent is null").toString());
                return;
            }
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra("OUTPUT_MEDIA");
            if (arrayList != null && !arrayList.isEmpty() && i3 == -1) {
                this.f205261e = ((LocalMediaInfo) arrayList.get(0)).path;
                D(intent, i3);
            } else {
                callJs(this.f205260d, v("result code cancel").toString());
                return;
            }
        }
        super.onActivityResult(intent, b16, i3);
    }

    private void C(Intent intent, int i3) {
        if (i3 != -1) {
            callJs(this.f205260d, v("result code error").toString());
            return;
        }
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String string = intent.getExtras().getString("ai_emoticon_choose_pic_result");
            String string2 = intent.getExtras().getString("ai_emoticon_choose_pic_path");
            jSONObject.put("succeeded", true);
            jSONObject.put("result", string);
            jSONObject.put(QzoneIPCModule.PIC_PATH, string2);
            callJs(this.f205260d, jSONObject.toString());
        } catch (Exception e16) {
            callJs(this.f205260d, v(e16.getMessage()).toString());
        }
    }
}
