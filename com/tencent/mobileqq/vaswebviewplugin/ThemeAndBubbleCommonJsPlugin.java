package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.etrump.mixlayout.ETDIYConfig;
import com.etrump.mixlayout.ETTextView;
import com.google.gson.Gson;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.pts.ui.PTSNodeAttributeConstant;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class ThemeAndBubbleCommonJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "common";
    private static final int SAVEIMG = 1;
    public static final List<HYDIYFontJsHandler> SJS_PLUGINS;
    public static final String TAG = "CommonJsHandler";
    public Handler handler = new Handler() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.7
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                try {
                    int i3 = message.getData().getInt("downResult");
                    JSONObject jSONObject = new JSONObject();
                    if (i3 == 0) {
                        jSONObject.put("ret", 0);
                    } else if (i3 != 1) {
                        jSONObject.put("ret", 3);
                    } else {
                        jSONObject.put("ret", 2);
                    }
                    if (i3 == 0) {
                        ReportController.o(null, "CliOper", "", "", "starphoto", "downloadsuc_starphoto_button", 0, 0, "", "", "", "");
                    } else {
                        ReportController.o(null, "CliOper", "", "", "starphoto", "downloadfail_starphoto_button", 0, 0, "", "", "", "");
                    }
                    ThemeAndBubbleCommonJsPlugin themeAndBubbleCommonJsPlugin = ThemeAndBubbleCommonJsPlugin.this;
                    themeAndBubbleCommonJsPlugin.callJs(themeAndBubbleCommonJsPlugin.mSaveCallbackId, jSONObject.toString());
                } catch (Exception e16) {
                    ThemeAndBubbleCommonJsPlugin themeAndBubbleCommonJsPlugin2 = ThemeAndBubbleCommonJsPlugin.this;
                    themeAndBubbleCommonJsPlugin2.callJsOnError(themeAndBubbleCommonJsPlugin2.mSaveCallbackId, e16.getMessage());
                }
            }
        }
    };
    private String mSaveCallbackId;

    static {
        ArrayList arrayList = new ArrayList();
        SJS_PLUGINS = arrayList;
        arrayList.add(new HYDIYFontJsHandler());
    }

    public void closePage(JSONObject jSONObject, String str) {
        try {
            this.mRuntime.a().finish();
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "common";
    }

    public void getNetwork(JSONObject jSONObject, String str) {
        int systemNetwork = NetworkUtil.getSystemNetwork(this.mRuntime.a());
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", systemNetwork);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("result", 0);
            jSONObject3.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            jSONObject3.put("data", jSONObject2);
            super.callJs(str + "(" + jSONObject3.toString() + ");");
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 32L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str != null && "common".equals(str2) && str3 != null) {
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
            int i3 = 0;
            while (true) {
                List<HYDIYFontJsHandler> list = SJS_PLUGINS;
                if (i3 < list.size()) {
                    if (list.get(i3).handler(str3, jsonFromJSBridge, optString, this)) {
                        return true;
                    }
                    i3++;
                } else {
                    if ("getNetwork".equals(str3)) {
                        getNetwork(jsonFromJSBridge, optString);
                    } else if ("showMsgBox".equals(str3)) {
                        showMsgBox(jsonFromJSBridge, optString);
                    } else if ("closePage".equals(str3)) {
                        closePage(jsonFromJSBridge, optString);
                    } else if (IndividuationPlugin.Method_OpenPage.equals(str3)) {
                        openPage(jsonFromJSBridge, optString);
                    } else if ("openWebView".equals(str3)) {
                        openWebView(jsonFromJSBridge, optString);
                    } else if ("saveImage".equals(str3)) {
                        saveImage(jsonFromJSBridge, optString);
                    } else if ("showMyImage".equals(str3)) {
                        showMyEmotion(optString);
                    } else if ("popup".equals(str3)) {
                        this.mRuntime.a().finish();
                    } else if ("openSettings".equals(str3)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("jumpTo", jsonFromJSBridge.optString("jumpto"));
                        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_open_settings", optString, this.mOnRemoteResp.key, bundle), false, true);
                    } else if ("isWhiteName".equals(str3)) {
                        isWhiteName(jsonFromJSBridge, optString);
                    } else if (QLog.isColorLevel()) {
                        QLog.w(TAG, 2, "NOT support method " + str3 + " yet!!");
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        return handleThemeAndBubbleSchemaRequest(str, str2, "common");
    }

    public void isWhiteName(JSONObject jSONObject, final String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("managerId", jSONObject.optInt("id"));
        QIPCClientHelper.getInstance().callServer("VasCommonIPCModule", "is_white_name", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.6
            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                try {
                    Bundle bundle2 = eIPCResult.data;
                    boolean z16 = bundle2 != null ? bundle2.getBoolean("isWhiteName", false) : false;
                    if (QLog.isColorLevel()) {
                        QLog.d(ThemeAndBubbleCommonJsPlugin.TAG, 2, "isWhiteName result return ");
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", z16);
                    ThemeAndBubbleCommonJsPlugin.this.callJs(str + "(" + jSONObject2.toString() + ");");
                } catch (Exception e16) {
                    QLog.e(ThemeAndBubbleCommonJsPlugin.TAG, 2, "isWhiteName erro " + e16);
                }
            }
        });
    }

    public void openPage(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString(VasWebviewConstants.KEY_PAGE_URL);
            String string2 = jSONObject.getString(VasWebviewConstants.KEY_PAGE_TITLE);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "CommonJsHandler openWebView pageUrl=" + string + ",pageTitle=" + string2);
            }
            Intent intent = new Intent();
            intent.putExtra(VasWebviewConstants.KEY_PAGE_TITLE, string2);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            VasWebviewUtil.openQQBrowserWithoutAD(this.mRuntime.a(), string, this.mRuntime.a().getIntent().getIntExtra("business", 0), intent, false, -1);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", 0);
            jSONObject2.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            super.callJs(str + "(" + jSONObject2.toString() + ");");
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    public void openWebView(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString(VasWebviewConstants.KEY_PAGE_URL);
            String string2 = jSONObject.getString(VasWebviewConstants.KEY_PAGE_TITLE);
            String string3 = jSONObject.getString("pageType");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "CommonJsHandler openWebView pageUrl=" + string + ",pageTitle=" + string2 + ",pageType=" + string3);
            }
            Intent intent = new Intent();
            intent.putExtra(VasWebviewConstants.KEY_PAGE_URL, string);
            intent.putExtra("url", string);
            intent.putExtra(VasWebviewConstants.KEY_PAGE_TITLE, string2);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.setClass(this.mRuntime.a(), QQBrowserActivity.class);
            this.mRuntime.a().startActivity(intent);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", 0);
            jSONObject2.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            super.callJs(str + "(" + jSONObject2.toString() + ");");
        } catch (ActivityNotFoundException e16) {
            super.callJsOnError(str, e16.getMessage());
        } catch (JSONException e17) {
            super.callJsOnError(str, e17.getMessage());
        } catch (Exception e18) {
            super.callJsOnError(str, e18.getMessage());
        }
    }

    public void saveImage(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("url");
            this.mSaveCallbackId = str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(string);
            sb5.append("?client=androidQQ");
            sb5.append("&version=" + AppSetting.f99554n);
            sb5.append("&system=" + Build.VERSION.RELEASE);
            sb5.append("&device=" + Build.DEVICE);
            sb5.append("&uin=" + ((AppActivity) this.mRuntime.a()).getAppRuntime().getAccount());
            final String A = com.tencent.mobileqq.emosm.e.A("VIP_xingying", sb5.toString());
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "CommonJsHandler saveImage imageUrl=" + A);
            }
            final File file = new File(AppConstants.SDCARD_IMG_SAVE, System.currentTimeMillis() + ".jpg");
            ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.5
                @Override // java.lang.Runnable
                public void run() {
                    int downloadData = HttpDownloadUtil.downloadData(ThemeAndBubbleCommonJsPlugin.this.mRuntime.b(), A, file);
                    Message message = new Message();
                    message.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putInt("downResult", downloadData);
                    message.setData(bundle);
                    ThemeAndBubbleCommonJsPlugin.this.handler.sendMessage(message);
                }
            });
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void showMsgBox(JSONObject jSONObject, final String str) {
        try {
            String string = jSONObject.getString("prompt");
            String string2 = jSONObject.getString("title");
            String string3 = jSONObject.getString("button");
            String[] split = string3.split("\t");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "CommonJsHandler showMsgBox prompt=" + string + ",title=" + string2 + ",button=" + string3);
            }
            if (split.length >= 1) {
                final QQCustomDialogThreeBtns createCustomThreeBtnsDialog = DialogUtil.createCustomThreeBtnsDialog(this.mRuntime.a(), 230);
                createCustomThreeBtnsDialog.setTitle(string2);
                createCustomThreeBtnsDialog.setMessage(string);
                createCustomThreeBtnsDialog.setLeftButton(split[0], new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("result", 0);
                            jSONObject2.put("message", "btn0 press");
                            ThemeAndBubbleCommonJsPlugin.this.callJs(str + "(" + jSONObject2.toString() + ");");
                        } catch (Exception e16) {
                            ThemeAndBubbleCommonJsPlugin.this.callJsOnError(str, e16.getMessage());
                        }
                    }
                });
                if (split.length >= 2) {
                    createCustomThreeBtnsDialog.setMiddleButton(split[1], new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("result", 1);
                                jSONObject2.put("message", "btn1 press");
                                ThemeAndBubbleCommonJsPlugin.this.callJs(str + "(" + jSONObject2.toString() + ");");
                            } catch (Exception e16) {
                                ThemeAndBubbleCommonJsPlugin.this.callJsOnError(str, e16.getMessage());
                            }
                        }
                    });
                }
                if (split.length >= 3) {
                    createCustomThreeBtnsDialog.setRightButton(split[2], new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("result", 1);
                                jSONObject2.put("message", "btn1 press");
                                ThemeAndBubbleCommonJsPlugin.this.callJs(str + "(" + jSONObject2.toString() + ");");
                            } catch (Exception e16) {
                                ThemeAndBubbleCommonJsPlugin.this.callJsOnError(str, e16.getMessage());
                            }
                        }
                    });
                }
                createCustomThreeBtnsDialog.setCanceledOnTouchOutside(false);
                createCustomThreeBtnsDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.4
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                        if (i3 != 4 || !createCustomThreeBtnsDialog.isShowing()) {
                            return false;
                        }
                        createCustomThreeBtnsDialog.dismiss();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("result", -1);
                            jSONObject2.put("message", "home back pressed");
                            ThemeAndBubbleCommonJsPlugin.this.callJs(str + "(" + jSONObject2.toString() + ");");
                            return true;
                        } catch (Exception e16) {
                            ThemeAndBubbleCommonJsPlugin.this.callJsOnError(str, e16.getMessage());
                            return true;
                        }
                    }
                });
                createCustomThreeBtnsDialog.show();
                return;
            }
            super.callJsOnError(str, "Button no found - " + string3);
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    public void showMyEmotion(String str) {
        QRoute.startUri(new ActivityURIRequest(this.mRuntime.a(), RouterConstants.UI_ROUTE_EMOSM_ACTIVITY));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 0);
            super.callJs(str + "(" + jSONObject.toString() + ");");
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public static class HYDIYFontJsHandler {
        private static int VIEW_ID = 1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes35.dex */
        public class AddViewData {
            String callback;
            Params params;

            /* renamed from: x, reason: collision with root package name */
            float f312427x = 0.0f;

            /* renamed from: y, reason: collision with root package name */
            float f312428y = 0.0f;
            float width = 0.0f;
            float height = 0.0f;

            AddViewData() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes35.dex */
        public interface DealETTextView {
            Object deal(FrameLayout frameLayout, ETTextView eTTextView);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes35.dex */
        public class Params {
            int fontID = 0;
            String image = "";
            String text = "";
            int fontType = 0;
            String type = "";
            int fontSize = 20;
            int contentLeft = 35;
            int contentTop = 35;

            Params() {
            }
        }

        HYDIYFontJsHandler() {
        }

        private void controlETTextView(JSONObject jSONObject, String str, DealETTextView dealETTextView, ThemeAndBubbleCommonJsPlugin themeAndBubbleCommonJsPlugin) {
            int intValue = ((Integer) findAndDealView(jSONObject.optInt(PTSNodeAttributeConstant.VIEW_ID, 0), dealETTextView, themeAndBubbleCommonJsPlugin)).intValue();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", intValue);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("result", 0);
                jSONObject3.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                jSONObject3.put("data", jSONObject2);
                themeAndBubbleCommonJsPlugin.callJs(str + "(" + jSONObject3.toString() + ");");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }

        private Object findAndDealView(int i3, DealETTextView dealETTextView, ThemeAndBubbleCommonJsPlugin themeAndBubbleCommonJsPlugin) {
            WebViewPlugin.b bVar;
            if (themeAndBubbleCommonJsPlugin != null && (bVar = themeAndBubbleCommonJsPlugin.mRuntime) != null) {
                Activity a16 = bVar.a();
                if (!(a16 instanceof QQBrowserActivity)) {
                    return "";
                }
                FrameLayout rootView = ((QQBrowserActivity) a16).getRootView();
                for (int i16 = 0; i16 < rootView.getChildCount(); i16++) {
                    View childAt = rootView.getChildAt(i16);
                    if ((childAt instanceof ETTextView) && childAt.getTag() != null && i3 == ((Integer) childAt.getTag()).intValue()) {
                        return dealETTextView.deal(rootView, (ETTextView) childAt);
                    }
                }
            }
            return "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getDrawingCacheIamge(ETTextView eTTextView) {
            byte[] bArr;
            if (eTTextView.getVisibility() != 0) {
                return "";
            }
            eTTextView.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(eTTextView.getDrawingCache(), 0, 0, eTTextView.getWidth(), eTTextView.getHeight());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    createBitmap.compress(Bitmap.CompressFormat.PNG, 40, byteArrayOutputStream);
                    bArr = Base64.encode(byteArrayOutputStream.toByteArray(), 0);
                    try {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    try {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                    bArr = null;
                }
                eTTextView.setDrawingCacheEnabled(false);
                if (bArr == null) {
                    return "";
                }
                return "data:image/png;base64," + new String(bArr);
            } catch (Throwable th5) {
                try {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
                throw th5;
            }
        }

        private ETTextView getEtTextView(int i3, String str, AddViewData addViewData, Activity activity) {
            Resources resources = activity.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
            QQBrowserActivity qQBrowserActivity = (QQBrowserActivity) activity;
            FrameLayout rootView = qQBrowserActivity.getRootView();
            ETTextView eTTextView = new ETTextView(activity);
            eTTextView.setGravity(1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BaseAIOUtils.f(addViewData.width, activity.getResources()), BaseAIOUtils.f(addViewData.height, activity.getResources()));
            layoutParams.leftMargin = BaseAIOUtils.f(addViewData.f312427x, activity.getResources());
            layoutParams.topMargin = BaseAIOUtils.f(addViewData.f312428y, activity.getResources()) + dimensionPixelSize;
            eTTextView.setPadding(BaseAIOUtils.f(addViewData.params.contentLeft, activity.getResources()), BaseAIOUtils.f(addViewData.params.contentTop, activity.getResources()), BaseAIOUtils.f(addViewData.params.contentLeft, activity.getResources()), BaseAIOUtils.f(addViewData.params.contentTop, activity.getResources()));
            com.tencent.mobileqq.vas.adapter.a aVar = new com.tencent.mobileqq.vas.adapter.a((AppInterface) qQBrowserActivity.getAppRuntime(), addViewData.params.fontID, 1);
            aVar.i(-1);
            aVar.j(eTTextView, addViewData.params.fontSize, true);
            aVar.k(addViewData.params.fontID, 1);
            eTTextView.setTextSize(addViewData.params.fontSize);
            eTTextView.setText(addViewData.params.text);
            eTTextView.setTag(Integer.valueOf(i3));
            eTTextView.bringToFront();
            rootView.addView(eTTextView, layoutParams);
            if (eTTextView.W == null) {
                return null;
            }
            String e16 = ETDIYConfig.e(addViewData.params.fontID, str);
            if (!TextUtils.isEmpty(e16)) {
                eTTextView.W.set_substitution(com.etrump.mixlayout.g.c(eTTextView.W, e16));
            }
            String[] split = eTTextView.W.getPath().split(File.separator);
            String str2 = "";
            for (int i16 = 0; i16 < split.length - 1; i16++) {
                str2 = str2 + split[i16] + File.separator;
            }
            try {
                eTTextView.setBackground(URLDrawable.getFileDrawable(str2 + "previewBubble.9.png", null));
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            return eTTextView;
        }

        public void addView(JSONObject jSONObject, String str, ThemeAndBubbleCommonJsPlugin themeAndBubbleCommonJsPlugin) {
            Params params;
            int i3 = VIEW_ID;
            VIEW_ID = i3 + 1;
            String str2 = i3 + "";
            if (themeAndBubbleCommonJsPlugin == null || themeAndBubbleCommonJsPlugin.mRuntime == null) {
                return;
            }
            AddViewData addViewData = (AddViewData) new Gson().fromJson(jSONObject.toString(), AddViewData.class);
            Activity a16 = themeAndBubbleCommonJsPlugin.mRuntime.a();
            if (!(a16 instanceof QQBrowserActivity) || addViewData == null || (params = addViewData.params) == null || params.fontType != 1) {
                return;
            }
            String[] split = params.image.split(",");
            if (split.length == 2) {
                com.etrump.mixlayout.a.f32687b.put(str2, split[1]);
            }
            ETTextView etTextView = getEtTextView(i3, str2, addViewData, a16);
            if (etTextView == null) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PTSNodeAttributeConstant.VIEW_ID, etTextView.getTag());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("result", 0);
                jSONObject3.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                jSONObject3.put("data", jSONObject2);
                themeAndBubbleCommonJsPlugin.callJs(str + "(" + jSONObject3.toString() + ");");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }

        public boolean handler(String str, final JSONObject jSONObject, final String str2, final ThemeAndBubbleCommonJsPlugin themeAndBubbleCommonJsPlugin) {
            if ("addView".equals(str)) {
                addView(jSONObject, str2, themeAndBubbleCommonJsPlugin);
                return true;
            }
            if ("getViewShot".equals(str)) {
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HYDIYFontJsHandler.this.getViewShot(jSONObject, str2, themeAndBubbleCommonJsPlugin);
                    }
                });
                return true;
            }
            if ("removeView".equals(str)) {
                removeView(jSONObject, str2, themeAndBubbleCommonJsPlugin);
                return true;
            }
            if ("hiddenView".equals(str)) {
                hiddenView(jSONObject, str2, themeAndBubbleCommonJsPlugin);
                return true;
            }
            if (!"showView".equals(str)) {
                return false;
            }
            showView(jSONObject, str2, themeAndBubbleCommonJsPlugin);
            return true;
        }

        public void hiddenView(JSONObject jSONObject, String str, ThemeAndBubbleCommonJsPlugin themeAndBubbleCommonJsPlugin) {
            controlETTextView(jSONObject, str, new DealETTextView() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.4
                @Override // com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.DealETTextView
                public Object deal(FrameLayout frameLayout, ETTextView eTTextView) {
                    eTTextView.setVisibility(8);
                    return 1;
                }
            }, themeAndBubbleCommonJsPlugin);
        }

        public void removeView(JSONObject jSONObject, String str, ThemeAndBubbleCommonJsPlugin themeAndBubbleCommonJsPlugin) {
            controlETTextView(jSONObject, str, new DealETTextView() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.3
                @Override // com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.DealETTextView
                public Object deal(FrameLayout frameLayout, ETTextView eTTextView) {
                    frameLayout.removeView(eTTextView);
                    return 1;
                }
            }, themeAndBubbleCommonJsPlugin);
        }

        public void showView(JSONObject jSONObject, String str, ThemeAndBubbleCommonJsPlugin themeAndBubbleCommonJsPlugin) {
            controlETTextView(jSONObject, str, new DealETTextView() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.5
                @Override // com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.DealETTextView
                public Object deal(FrameLayout frameLayout, ETTextView eTTextView) {
                    eTTextView.setVisibility(0);
                    return 1;
                }
            }, themeAndBubbleCommonJsPlugin);
        }

        public void getViewShot(JSONObject jSONObject, String str, ThemeAndBubbleCommonJsPlugin themeAndBubbleCommonJsPlugin) {
            if (themeAndBubbleCommonJsPlugin == null) {
                return;
            }
            String str2 = (String) findAndDealView(jSONObject.optInt(PTSNodeAttributeConstant.VIEW_ID, 0), new DealETTextView() { // from class: com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.2
                @Override // com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin.HYDIYFontJsHandler.DealETTextView
                public String deal(FrameLayout frameLayout, ETTextView eTTextView) {
                    return HYDIYFontJsHandler.this.getDrawingCacheIamge(eTTextView);
                }
            }, themeAndBubbleCommonJsPlugin);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("image", str2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("result", 0);
                jSONObject3.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                jSONObject3.put("data", jSONObject2);
                themeAndBubbleCommonJsPlugin.callJs(str + "(" + jSONObject3.toString() + ");");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }
}
