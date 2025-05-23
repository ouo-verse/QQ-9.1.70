package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webviewplugin.s;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class AvatarPendantJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "faceAddon";
    private static final String JS_REQUEST_SCHEME = "jsbridge";
    public static final String KEY_FORM_PENDANT_PHOTO = "keyFromPendantPhoto";
    public static final int MENU_ITEM_SELECT_PHOTO = 1;
    public static final int MENU_ITEM_TAKE_PHOTO = 0;
    public static final String PENDANT_SP_KEY_DIY_GUIDE_SHOW = "PendantDiyGuideShown";
    public static final String PENDANT_SP_NAME = "PendantSpName_";
    static final String TAG = "AvatarPendantJsPlugin";
    public BrowserAppInterface browserApp;
    Vector<JSONObject> mNumPicRequests = new Vector<>();

    private void getNumberPic(JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getNumberPic: " + jSONObject);
        }
        Bundle bundle = new Bundle();
        bundle.putString("params", jSONObject.toString());
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("getPendantNumberPic", str, this.mOnRemoteResp.key, bundle), false, false);
    }

    private Bitmap getRoundFaceBitmap(String str) {
        if (new File(str).exists()) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str, BaseImageUtil.calculateInSampleSize(new BitmapFactory.Options(), str, 200));
                int width = decodeFile.getWidth();
                Bitmap roundedCornerBitmap = BaseImageUtil.getRoundedCornerBitmap(decodeFile, width, width, decodeFile.getHeight());
                return (roundedCornerBitmap == null || roundedCornerBitmap.getWidth() <= 200) ? roundedCornerBitmap : BaseImageUtil.scaleBitmap(roundedCornerBitmap, 200);
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        return BaseImageUtil.getDefaultFaceBitmap();
    }

    private void showDiyGuide(JSONObject jSONObject, String str) {
        SharedPreferences sharedPreferences = this.browserApp.getApp().getSharedPreferences(PENDANT_SP_NAME + this.browserApp.getCurrentAccountUin(), 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("result", 0);
            if (jSONObject.has("shown")) {
                sharedPreferences.edit().putBoolean(PENDANT_SP_KEY_DIY_GUIDE_SHOW, jSONObject.optBoolean("shown", false)).apply();
            } else {
                jSONObject2.put("shown", sharedPreferences.getBoolean(PENDANT_SP_KEY_DIY_GUIDE_SHOW, false));
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "showDiyGuide error", e16.getMessage());
        }
        callJs(str, jSONObject2.toString());
    }

    public void changeFace(JSONObject jSONObject, final String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "changeFace: " + jSONObject);
        }
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.mRuntime.a(), null);
        actionSheet.addButton(HardCodeUtil.qqStr(R.string.f171623jv0));
        actionSheet.addButton(HardCodeUtil.qqStr(R.string.f171625jv2));
        actionSheet.addCancelButton(HardCodeUtil.qqStr(R.string.j6l));
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.5
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        Intent intent = new Intent();
                        intent.putExtra(AvatarPendantJsPlugin.KEY_FORM_PENDANT_PHOTO, true);
                        intent.putExtra("Business_Origin", 100);
                        int min = Math.min(482, ProfileCardUtil.A(AvatarPendantJsPlugin.this.mRuntime.a()));
                        PhotoUtils.startPhotoListEdit(intent, AvatarPendantJsPlugin.this.mRuntime.a(), QQBrowserActivity.class.getName(), min, min, 1080, 1080, FaceUtil.getUploadAvatarTempPath());
                        AvatarPendantUiPlugin.sJsHandler = AvatarPendantJsPlugin.this;
                        AvatarPendantUiPlugin.sCallbackId = str;
                    }
                } else {
                    if (QavCameraUsage.a(BaseApplication.getContext())) {
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    String str2 = AppConstants.SDCARD_PATH;
                    sb5.append(str2);
                    sb5.append("photo/");
                    File file = new File(sb5.toString());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    Intent intent2 = new Intent();
                    Uri systemCapture = FileProvider7Helper.setSystemCapture(AvatarPendantJsPlugin.this.mRuntime.a(), new File(str2 + "photo/" + System.currentTimeMillis() + ".jpg"), intent2);
                    AvatarPendantJsPlugin.this.mRuntime.a().startActivityForResult(intent2, 1);
                    AvatarPendantUiPlugin.sJsHandler = AvatarPendantJsPlugin.this;
                    AvatarPendantUiPlugin.sCallbackId = str;
                    AvatarPendantUiPlugin.sUploadPhotoUri = systemCapture;
                }
                try {
                    actionSheet.dismiss();
                } catch (Exception unused) {
                }
            }
        });
        actionSheet.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.6
            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public void onDismiss() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("result", 2);
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(AvatarPendantJsPlugin.TAG, 2, "changeFace cancel failed: " + e16.getMessage());
                    }
                }
                AvatarPendantJsPlugin.this.callJs(str + "(" + jSONObject2.toString() + ");");
            }
        });
        actionSheet.show();
    }

    public void getFaceAddon(JSONObject jSONObject, final String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getFaceAddon: " + jSONObject);
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                Activity a16;
                Activity a17;
                try {
                    final JSONObject jSONObject2 = new JSONObject();
                    if (AvatarPendantJsPlugin.this.browserApp != null) {
                        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(AvatarPendantJsPlugin.this.browserApp.getAccount()), AvatarPendantJsPlugin.TAG);
                        jSONObject2.put("result", 0);
                        if (vasSimpleInfoWithUid == null) {
                            jSONObject2.put("id", 0);
                        } else {
                            jSONObject2.put("id", vasSimpleInfoWithUid.pendantId);
                        }
                        WebViewPlugin.b bVar = AvatarPendantJsPlugin.this.mRuntime;
                        if (bVar == null || (a17 = bVar.a()) == null) {
                            return;
                        }
                        a17.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AvatarPendantJsPlugin.this.callJs(str + "(" + jSONObject2.toString() + ");");
                            }
                        });
                    }
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(AvatarPendantJsPlugin.TAG, 2, "getFaceAddon failed: " + e16.getMessage());
                    }
                    final String message = e16.getMessage();
                    WebViewPlugin.b bVar2 = AvatarPendantJsPlugin.this.mRuntime;
                    if (bVar2 == null || (a16 = bVar2.a()) == null) {
                        return;
                    }
                    a16.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AvatarPendantJsPlugin.this.callJsOnError(str, message);
                        }
                    });
                }
            }
        }, 8, null, false);
    }

    public int getIPCResponseKey() {
        return this.mOnRemoteResp.key;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 2147484160L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 128L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str != null && BUSINESS_NAME.equals(str2) && str3 != null) {
            JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
            if (jsonFromJSBridge == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
            }
            String optString = jsonFromJSBridge.optString("callback");
            if (TextUtils.isEmpty(optString)) {
                QLog.e(TAG, 1, "callback id is null, so return");
                return true;
            }
            VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
            if ("getFaceAddon".equals(str3)) {
                getFaceAddon(jsonFromJSBridge, optString);
                return true;
            }
            if ("updateFaceAddon".equals(str3)) {
                updateFaceAddon(jsonFromJSBridge, optString);
                return true;
            }
            if ("showMsgBox".equals(str3)) {
                showMsgBox(jsonFromJSBridge, optString);
                return true;
            }
            if ("changeFace".equals(str3)) {
                changeFace(jsonFromJSBridge, optString);
                return true;
            }
            if ("showDiyGuide".equals(str3)) {
                showDiyGuide(jsonFromJSBridge, optString);
                return true;
            }
            if ("getNumberPic".equals(str3)) {
                if (this.mNumPicRequests.isEmpty()) {
                    getNumberPic(jsonFromJSBridge, optString);
                } else {
                    this.mNumPicRequests.add(jsonFromJSBridge);
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "NOT support method " + str3 + " yet!!");
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        AppInterface b16 = this.mRuntime.b();
        if (b16 instanceof BrowserAppInterface) {
            this.browserApp = (BrowserAppInterface) b16;
        } else if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "ERROR!!! Pendant market is not running in web process!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        if (bundle != null && bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
            String string = bundle.getString("cmd");
            try {
                String string2 = bundle.getString("callbackid");
                Bundle bundle2 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
                Bundle bundle3 = bundle.getBundle("response");
                JSONObject jSONObject = new JSONObject();
                if ("changeAvatar".equals(string)) {
                    if (bundle3.getBoolean("updateResult")) {
                        Bitmap roundFaceBitmap = getRoundFaceBitmap(bundle2.getString("path"));
                        if (roundFaceBitmap == null) {
                            jSONObject.put("result", 1002);
                        } else {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            roundFaceBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                            String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                            jSONObject.put("result", 1);
                            jSONObject.put("file", "data:image/png;base64," + encodeToString);
                            jSONObject.put("size", roundFaceBitmap.getWidth());
                            byteArrayOutputStream.close();
                        }
                    } else {
                        s g16 = this.mRuntime.g();
                        if (g16 != null && g16.getWebTitleBarInterface() != null) {
                            QQToast.makeText(this.mRuntime.a(), R.string.hfc, 0).show(g16.getWebTitleBarInterface().getTitleBarHeight());
                        }
                        jSONObject.put("result", 1001);
                    }
                } else if ("updatePendantId".equals(string)) {
                    jSONObject.put("result", 0);
                } else if ("getPendantNumberPic".equals(string)) {
                    if (bundle3.getBoolean("updateResult", false)) {
                        jSONObject.put("result", 0);
                        jSONObject.put("file", bundle3.getString("file"));
                    } else {
                        jSONObject.put("result", -1);
                        jSONObject.put("errMsg", bundle3.getString("errMsg"));
                    }
                    if (!this.mNumPicRequests.isEmpty()) {
                        JSONObject remove = this.mNumPicRequests.remove(0);
                        getNumberPic(remove, remove.optString("callback"));
                    }
                }
                super.callJs(string2 + "(" + jSONObject.toString() + ");");
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "Failed to handle cmd " + string + ", exception: " + e16.getMessage());
                }
            }
        }
    }

    public void showMsgBox(JSONObject jSONObject, final String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "showMsgBox: " + jSONObject);
        }
        try {
            String string = jSONObject.getString("msg");
            String string2 = jSONObject.getString("title");
            JSONArray jSONArray = jSONObject.getJSONArray("button");
            if (jSONArray.length() >= 1) {
                QQCustomDialogThreeBtns createCustomThreeBtnsDialog = DialogUtil.createCustomThreeBtnsDialog(this.mRuntime.a(), 230);
                createCustomThreeBtnsDialog.setTitle(string2);
                createCustomThreeBtnsDialog.setMessage(string);
                createCustomThreeBtnsDialog.setLeftButton(jSONArray.getString(0), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("result", 0);
                            AvatarPendantJsPlugin.this.callJs(str + "(" + jSONObject2.toString() + ");");
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(AvatarPendantJsPlugin.TAG, 2, "showMsgBox failed: " + e16.getMessage());
                            }
                            AvatarPendantJsPlugin.this.callJsOnError(str, e16.getMessage());
                        }
                    }
                });
                if (jSONArray.length() >= 2) {
                    createCustomThreeBtnsDialog.setMiddleButton(jSONArray.getString(1), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("result", 1);
                                AvatarPendantJsPlugin.this.callJs(str + "(" + jSONObject2.toString() + ");");
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(AvatarPendantJsPlugin.TAG, 2, "showMsgBox failed: " + e16.getMessage());
                                }
                                AvatarPendantJsPlugin.this.callJsOnError(str, e16.getMessage());
                            }
                        }
                    });
                }
                if (jSONArray.length() >= 3) {
                    createCustomThreeBtnsDialog.setRightButton(jSONArray.getString(2), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("result", 2);
                                AvatarPendantJsPlugin.this.callJs(str + "(" + jSONObject2.toString() + ");");
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(AvatarPendantJsPlugin.TAG, 2, "showMsgBox failed: " + e16.getMessage());
                                }
                                AvatarPendantJsPlugin.this.callJsOnError(str, e16.getMessage());
                            }
                        }
                    });
                }
                createCustomThreeBtnsDialog.show();
                super.callJs(str + "(" + new JSONObject().toString() + ");");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "no button message");
            }
            throw new Exception("no button message");
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "showMsgBox failed: " + e16.getMessage());
            }
            super.callJsOnError(str, e16.getMessage());
        }
    }

    public void updateFaceAddon(JSONObject jSONObject, String str) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateFaceAddon: " + jSONObject);
        }
        try {
            long j3 = jSONObject.getLong("id");
            Bundle bundle = new Bundle();
            bundle.putString("uin", this.browserApp.getAccount());
            bundle.putLong("pendantId", j3);
            try {
                jSONObject.getLong("t");
                z16 = true;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "updateFaceAddon: isDiyPendant = false");
                }
                z16 = false;
            }
            bundle.putBoolean("is_diypendant", z16);
            VasLogReporter.getAvatarPendant().reportHighest("updateFaceAddon pendantId=" + j3 + " isDiyPendant=" + z16);
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("updatePendantId", str, this.mOnRemoteResp.key, bundle), false, false);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "updateFaceAddon failed: " + e16.getMessage());
            }
            super.callJsOnError(str, e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        Object obj;
        if (j3 == 128 && (obj = map.get("intent")) != null && (obj instanceof Intent)) {
            Intent intent = (Intent) obj;
            if (intent.getBooleanExtra(KEY_FORM_PENDANT_PHOTO, false)) {
                WebViewPlugin.b bVar = this.mRuntime;
                CustomWebView e16 = bVar != null ? bVar.e() : null;
                WebViewPluginEngine pluginEngine = e16 != null ? e16.getPluginEngine() : null;
                if (pluginEngine == null) {
                    return true;
                }
                new HashMap().put("intent", intent);
                pluginEngine.s(str, 8589934605L, map);
                return true;
            }
        }
        return super.handleEvent(str, j3, map);
    }
}
