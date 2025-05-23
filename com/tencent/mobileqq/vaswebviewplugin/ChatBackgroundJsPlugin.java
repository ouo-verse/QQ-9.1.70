package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasIpcTempData;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.api.EIPCCallbackWrapper;
import com.tencent.mobileqq.vas.api.f;
import com.tencent.mobileqq.vas.quickupdate.ChatBackgroundBusiness;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.vas.update.entity.UpdateListenerParams;
import cooperation.peak.PeakConstants;
import cooperation.qzone.model.Size;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class ChatBackgroundJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "chatBg";
    public static final int COMPRESS_HD = 2;
    public static final int COMPRESS_NORMAL = 0;
    public static final int COMPRESS_RAW = 3;
    private static final int DIY_ERROR_CODE_BITMAP_CREATE_FAILT = 4;
    private static final int DIY_ERROR_CODE_BITMAP_NULL = 2;
    private static final int DIY_ERROR_CODE_BITMAP_OOM = 3;
    private static final int DIY_ERROR_CODE_IO_EXCEPTION = 5;
    public static final String FROM_CHATBACKGROUNDJS = "fromChatBackgroundJsPlugin";
    public static final String ISFROMPHOTO = "isFromPhoto";
    private static final String TAG = "ChatBackgroundJsPlugin";
    private BrowserAppInterface browserApp;
    private Bundle mReqBundle;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static w33.b compressBitmapToFile(Context context, int i3, Bitmap bitmap, String str, float f16, float f17, float f18, int i16) {
        int i17;
        Bitmap bitmap2;
        Throwable th5;
        FileOutputStream fileOutputStream;
        Size bitmapSize;
        Throwable th6;
        if (bitmap == null) {
            VasLogReporter.getChatBackgroundJsb().report("can not read bitmap", VasLogReportProxy.LEVEL.HIGHEST);
            return new w33.b(2, "\u672c\u5730\u6587\u4ef6\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u521b\u5efabitmap");
        }
        int compressType = getCompressType(i3);
        float f19 = f16 + f18 > 100.0f ? 100.0f - f18 : f16;
        if (i16 != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(i16, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
            try {
                i17 = 3;
            } catch (OutOfMemoryError e16) {
                e = e16;
                i17 = 3;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
                bitmap.recycle();
                bitmap2 = createBitmap;
            } catch (OutOfMemoryError e17) {
                e = e17;
                VasLogReporter.getChatBackgroundJsb().report("set chat bg oom", VasLogReportProxy.LEVEL.HIGHEST);
                e.fillInStackTrace();
                return new w33.b(i17, "oom bitmap create");
            }
        } else {
            i17 = 3;
            bitmap2 = bitmap;
        }
        float width = bitmap2.getWidth() * (f18 / 100.0f);
        float f26 = (context.getResources().getDisplayMetrics().heightPixels * width) / context.getResources().getDisplayMetrics().widthPixels;
        float width2 = (f17 / 100.0f) * bitmap2.getWidth();
        if (f26 + width2 > bitmap2.getHeight()) {
            f26 = bitmap2.getHeight() - width2;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                Bitmap createBitmap2 = Bitmap.createBitmap(bitmap2, (int) (bitmap2.getWidth() * (f19 / 100.0f)), (int) width2, (int) width, (int) f26);
                if (createBitmap2 == 0) {
                    try {
                        VasLogReporter.getChatBackgroundJsb().report("copy bitmap error", VasLogReportProxy.LEVEL.HIGHEST);
                        w33.b bVar = new w33.b(4, "copy bitmap fail");
                        if (createBitmap2 != bitmap2) {
                            bitmap2.recycle();
                        }
                        return bVar;
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        fileOutputStream2 = createBitmap2;
                        VasLogReporter.getChatBackgroundJsb().report("copy bitmap oom", VasLogReportProxy.LEVEL.HIGHEST);
                        e.fillInStackTrace();
                        w33.b bVar2 = new w33.b(i17, "oom copy bitmap");
                        if (fileOutputStream2 != bitmap2) {
                            bitmap2.recycle();
                        }
                        return bVar2;
                    } catch (Throwable th7) {
                        th = th7;
                        fileOutputStream2 = createBitmap2;
                        if (fileOutputStream2 != bitmap2) {
                            bitmap2.recycle();
                        }
                        throw th;
                    }
                }
                if (createBitmap2 != bitmap2) {
                    bitmap2.recycle();
                }
                File file = new File(str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                try {
                    try {
                        fileOutputStream = new FileOutputStream(str);
                        try {
                            createBitmap2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                            fileOutputStream.close();
                            createBitmap2.recycle();
                            try {
                                fileOutputStream.close();
                            } catch (IOException e19) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 1, "compressBitmapToFile error : " + e19);
                                }
                            }
                        } catch (IOException unused) {
                            fileOutputStream2 = fileOutputStream;
                            VasLogReporter.getChatBackgroundJsb().report("write jpeg error", VasLogReportProxy.LEVEL.HIGHEST);
                            createBitmap2.recycle();
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e26) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TAG, 1, "compressBitmapToFile error : " + e26);
                                    }
                                }
                            }
                            fileOutputStream = fileOutputStream2;
                            bitmapSize = ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).getBitmapSize(str);
                            if (bitmapSize != null) {
                            }
                        } catch (Throwable th8) {
                            th5 = th8;
                            fileOutputStream2 = fileOutputStream;
                            createBitmap2.recycle();
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                    throw th5;
                                } catch (IOException e27) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TAG, 1, "compressBitmapToFile error : " + e27);
                                        throw th5;
                                    }
                                    throw th5;
                                }
                            }
                            throw th5;
                        }
                    } catch (Throwable th9) {
                        th5 = th9;
                    }
                } catch (IOException unused2) {
                }
                bitmapSize = ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).getBitmapSize(str);
                if (bitmapSize != null) {
                    VasLogReporter.getChatBackgroundJsb().report("getBitmapSize error", VasLogReportProxy.LEVEL.HIGHEST);
                    return new w33.b(5, "io\u5f02\u5e38\uff0cwrite jpeg error, disk size: " + ProfileCardUtil.y());
                }
                double ratio = ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).getRatio(context, compressType, bitmapSize);
                VasLogReporter.getChatBackgroundJsb().report("imageWidth=" + f18 + " ratio=" + ratio);
                if (ratio > 0.0d) {
                    bitmapSize.width = (int) (bitmapSize.width / ratio);
                    bitmapSize.height = (int) (bitmapSize.height / ratio);
                }
                byte[] decode = Base64.decode(((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).encodeBase64File(str, bitmapSize.width, bitmapSize.height), 2);
                try {
                    try {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(str);
                        try {
                            fileOutputStream3.write(decode);
                            fileOutputStream3.close();
                            w33.b bVar3 = new w33.b(0, "");
                            try {
                                fileOutputStream3.close();
                            } catch (IOException e28) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 1, "imageBase64 to bytes write file error : " + e28);
                                }
                            }
                            return bVar3;
                        } catch (IOException e29) {
                            e = e29;
                            fileOutputStream = fileOutputStream3;
                            VasLogReporter.getChatBackgroundJsb().report("Base64 write error", VasLogReportProxy.LEVEL.HIGHEST);
                            e.printStackTrace();
                            w33.b bVar4 = new w33.b(5, "io\u5f02\u5e38\uff0cBase64 write error, disk size:" + ProfileCardUtil.y());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e36) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TAG, 1, "imageBase64 to bytes write file error : " + e36);
                                    }
                                }
                            }
                            return bVar4;
                        } catch (Throwable th10) {
                            th6 = th10;
                            fileOutputStream = fileOutputStream3;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    throw th6;
                                } catch (IOException e37) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TAG, 1, "imageBase64 to bytes write file error : " + e37);
                                        throw th6;
                                    }
                                    throw th6;
                                }
                            }
                            throw th6;
                        }
                    } catch (IOException e38) {
                        e = e38;
                    }
                } catch (Throwable th11) {
                    th6 = th11;
                }
            } catch (Throwable th12) {
                th = th12;
            }
        } catch (OutOfMemoryError e39) {
            e = e39;
        }
    }

    private void custom(String str) {
        Intent intent = this.mRuntime.a().getIntent();
        String customImageFilePath = getCustomImageFilePath();
        Rect rect = new Rect();
        this.mRuntime.a().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        intent.putExtra(ISFROMPHOTO, true);
        intent.putExtra(FROM_CHATBACKGROUNDJS, true);
        intent.putExtra("onNewIntentReDoStateMachine", false);
        PhotoUtils.startPhotoListEdit(intent, this.mRuntime.a(), QQBrowserActivity.class.getName(), (rect.width() / 5) * 4, (rect.height() / 5) * 4, rect.width(), rect.height(), customImageFilePath);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", 0);
            super.callJs(str, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
            callJsOnError(str, e16.getMessage());
        }
    }

    private static int getCompressType(int i3) {
        if (i3 == 1) {
            return 2;
        }
        if (i3 != 2) {
            return 0;
        }
        return 3;
    }

    private String getCustomImageFilePath() {
        if (ThemeDiyStyleLogic.isNewCustomBackground) {
            return ThemeDiyStyleLogic.getNewCustomBackgroundPath();
        }
        return ThemeDiyStyleLogic.getDataDIYDir() + DiySecureFileHelper.secureUin(this.browserApp.getAccount()) + "/" + System.currentTimeMillis() + ".jpg";
    }

    private boolean handleCustomPic(String str, int i3, String str2, int i16, boolean z16) {
        if (!z16 || str2 == null || this.browserApp == null) {
            return false;
        }
        VasUtil.getService().getJsbCallManager().setCustomChatBackground(str, str2, i16, i3);
        VasLogReporter.getChatBackgroundJsb().report("send binder", VasLogReportProxy.LEVEL.HIGHEST);
        QQToast.makeText(this.mRuntime.a(), R.string.d0h, 0).show();
        ReportController.o(null, "CliOper", "", "", "chatbackground", "BjIDShezhi", 0, 0, "1", "", "", "");
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 2181038080L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 131L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:148:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x06c9  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        int i3;
        boolean z16;
        boolean z17;
        String str5;
        String str6;
        String str7;
        int i16;
        boolean isFileExists;
        String[] strArr2;
        final String str8;
        String str9;
        String str10;
        Bitmap bitmap;
        w33.b compressBitmapToFile;
        File file;
        StringBuilder sb5;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        int i17;
        String string;
        String shopBgPath;
        Intent intent;
        String string2;
        String optString;
        String optString2;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        VasLogReporter.getChatBackgroundJsb().report("web handleJsRequest - url " + str + ", pkgName " + str2 + ", methodName " + str3);
        if (str == null || !BUSINESS_NAME.equals(str2) || str3 == null) {
            return false;
        }
        final JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        if (jsonFromJSBridge == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
        }
        final String optString3 = jsonFromJSBridge.optString("callback");
        if (TextUtils.isEmpty(optString3)) {
            QLog.e(TAG, 1, "callback id is null, so return");
            return true;
        }
        VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
        ChatBackgroundBusiness chatBackgroundBusiness = (ChatBackgroundBusiness) QQVasUpdateBusiness.getBusiness(ChatBackgroundBusiness.class);
        if ("getCurrentChatBgId".equals(str3)) {
            String stringExtra = this.mRuntime.a().getIntent().getStringExtra("chatbg_intent_frinedUin");
            if (stringExtra == null) {
                String string3 = VasIpcTempData.getKuikly().getString("chat_uin", "");
                if (!TextUtils.isEmpty(string3)) {
                    QLog.i(TAG, 1, "use kuikly uin=" + string3);
                    stringExtra = string3;
                }
            }
            final String str17 = stringExtra != null ? stringExtra : "none";
            final int intExtra = this.mRuntime.a().getIntent().getIntExtra("uintype", -1);
            if (intExtra == 3000) {
                intExtra = 1;
            }
            if (intExtra == -1) {
                String string4 = VasIpcTempData.getKuikly().getString("chat_type", "");
                if (!TextUtils.isEmpty(string4)) {
                    QLog.i(TAG, 1, "use kuikly type=" + string4);
                    intExtra = Integer.parseInt(string4);
                }
            }
            VasUtil.getService().getJsbCallManager().getCurrentChatBgId(str17, new EIPCCallback.Stub() { // from class: com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundJsPlugin.1
                @Override // eipc.EIPCCallback
                public void callback(EIPCResult eIPCResult) throws RemoteException {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("result", 0);
                        jSONObject.put("uinType", intExtra);
                        jSONObject.put("friendUin", str17);
                        jSONObject.put("id", eIPCResult.data.getString("id"));
                        jSONObject.put("themeId", eIPCResult.data.getString("themeId"));
                        jSONObject.put("isDIYTheme", eIPCResult.data.getString("isDIYTheme"));
                        VasLogReporter.getChatBackgroundJsb().reportHighest("getCurrentChatBgId uin=" + str17 + " id=" + eIPCResult.data.getString("id"));
                        ChatBackgroundJsPlugin.this.callJs(optString3, jSONObject.toString());
                    } catch (JSONException e16) {
                        throw new RuntimeException(e16);
                    }
                }
            });
            str5 = "web ";
            str6 = str3;
            str4 = "";
        } else {
            str4 = "";
            if ("startDownload".equals(str3)) {
                try {
                    int parseInt = Integer.parseInt(jsonFromJSBridge.getString("id"));
                    if (this.proxy != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", parseInt);
                        try {
                            jSONObject.put("result", 0);
                            callJs(optString3, jSONObject.toString());
                            return true;
                        } catch (JSONException e16) {
                            e = e16;
                            i3 = 0;
                            Object[] objArr = new Object[i3];
                            z16 = true;
                            QLog.e(TAG, 1, e, objArr);
                            z17 = z16;
                            str5 = "web ";
                            str6 = str3;
                            str7 = optString3;
                            str16 = str4;
                            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str16, str7, this.mOnRemoteResp.key, this.mReqBundle), false, z17);
                            VasLogReporter.getChatBackgroundJsb().report(str5 + str6 + " - mReqBundle:" + this.mReqBundle.toString());
                            return true;
                        }
                    }
                    String string5 = jsonFromJSBridge.getString("url");
                    VasLogReporter.getChatBackgroundJsb().reportHighest("startDownload id=" + parseInt + " bgUrl=" + string5);
                    chatBackgroundBusiness.addDownLoadListener(parseInt, new IDownLoadListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundJsPlugin.2
                        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                        public void onLoadFail(UpdateListenerParams updateListenerParams) {
                            try {
                                String string6 = jsonFromJSBridge.getString("id");
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("id", string6);
                                jSONObject2.put("result", updateListenerParams.mErrorCode);
                                jSONObject2.put("msg", updateListenerParams.mErrorMessage);
                                ChatBackgroundJsPlugin.this.callJs(optString3, jSONObject2.toString());
                                VasLogReporter.getChatBackgroundJsb().reportHighest("download error");
                            } catch (JSONException e17) {
                                QLog.e(ChatBackgroundJsPlugin.TAG, 1, e17, new Object[0]);
                            }
                        }

                        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                        public void onLoadSuccess(UpdateListenerParams updateListenerParams) {
                            try {
                                String string6 = jsonFromJSBridge.getString("id");
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("id", string6);
                                jSONObject2.put("result", 0);
                                ChatBackgroundJsPlugin.this.callJs(optString3, jSONObject2.toString());
                                VasLogReporter.getChatBackgroundJsb().reportHighest("download success");
                            } catch (JSONException e17) {
                                QLog.e(ChatBackgroundJsPlugin.TAG, 1, e17, new Object[0]);
                            }
                        }
                    });
                    chatBackgroundBusiness.startDownload(parseInt);
                    VasLogReporter.getChatBackgroundJsb().reportHighest("startDownload id=" + parseInt + " bgUrl=" + string5);
                    str5 = "web ";
                    str6 = str3;
                } catch (JSONException e17) {
                    e = e17;
                    i3 = 0;
                }
            } else if (GameCenterAPIJavaScript.QUERY_INFO.equals(str3)) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    String optString4 = jsonFromJSBridge.optString("id");
                    if (this.proxy != null) {
                        isFileExists = new JSONObject(this.proxy.queryInfo(jsonFromJSBridge.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY), Integer.parseInt(optString4), QQVasUpdateBusiness.getBusiness(ChatBackgroundBusiness.class))).optInt("status") == 3;
                    } else {
                        isFileExists = chatBackgroundBusiness.isFileExists(Integer.parseInt(optString4));
                    }
                    jSONObject2.put("id", optString4);
                    jSONObject2.put("status", isFileExists ? 1 : 0);
                    try {
                        jSONObject2.put("result", 0);
                        jSONObject2.put("progress", isFileExists ? 100 : 0);
                        strArr2 = new String[1];
                        i16 = 0;
                    } catch (JSONException e18) {
                        e = e18;
                        i16 = 0;
                    }
                    try {
                        strArr2[0] = jSONObject2.toString();
                        callJs(optString3, strArr2);
                        str5 = "web ";
                        str6 = str3;
                    } catch (JSONException e19) {
                        e = e19;
                        Object[] objArr2 = new Object[i16];
                        z16 = true;
                        QLog.e(TAG, 1, e, objArr2);
                        z17 = z16;
                        str5 = "web ";
                        str6 = str3;
                        str7 = optString3;
                        str16 = str4;
                        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str16, str7, this.mOnRemoteResp.key, this.mReqBundle), false, z17);
                        VasLogReporter.getChatBackgroundJsb().report(str5 + str6 + " - mReqBundle:" + this.mReqBundle.toString());
                        return true;
                    }
                } catch (JSONException e26) {
                    e = e26;
                    i16 = 0;
                }
            } else {
                if ("setChatBg".equals(str3)) {
                    try {
                        string = jsonFromJSBridge.getString("id");
                        shopBgPath = string.startsWith("theme") ? "null" : ChatBackgroundUtil.getShopBgPath(string);
                        str13 = "chatbackground_setbg";
                        try {
                            intent = this.mRuntime.a().getIntent();
                            if (jsonFromJSBridge.has("friendUin")) {
                                try {
                                    str12 = "web ";
                                    string2 = jsonFromJSBridge.getString("friendUin");
                                } catch (Exception e27) {
                                    e = e27;
                                    str16 = str13;
                                    str12 = "web ";
                                    str14 = TAG;
                                    str15 = optString3;
                                    i17 = 0;
                                    QLog.e(str14, 1, e, new Object[i17]);
                                    z17 = true;
                                    str7 = str15;
                                    str5 = str12;
                                    str6 = str3;
                                    super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str16, str7, this.mOnRemoteResp.key, this.mReqBundle), false, z17);
                                    VasLogReporter.getChatBackgroundJsb().report(str5 + str6 + " - mReqBundle:" + this.mReqBundle.toString());
                                    return true;
                                }
                            } else {
                                str12 = "web ";
                                string2 = "none";
                            }
                            try {
                                if ("none".equals(string2)) {
                                    string2 = null;
                                }
                                optString = jsonFromJSBridge.optString("name");
                                optString2 = jsonFromJSBridge.optString(VipFunCallConstants.KEY_FEET_TYPE);
                                str14 = TAG;
                                try {
                                    this.mReqBundle.clear();
                                    try {
                                        this.mReqBundle.putString("path", shopBgPath);
                                        this.mReqBundle.putString("friendUin", string2);
                                        this.mReqBundle.putString("from", "chatbgJs");
                                        this.mReqBundle.putString("name", optString);
                                        this.mReqBundle.putString(VipFunCallConstants.KEY_FEET_TYPE, optString2);
                                        this.mReqBundle.putString("id", string);
                                        VasLogReporter.getChatBackgroundJsb().reportHighest("setChatBg " + this.mReqBundle.toString());
                                        this.mReqBundle.putParcelable("intent", intent);
                                    } catch (Exception e28) {
                                        e = e28;
                                        str15 = optString3;
                                    }
                                } catch (Exception e29) {
                                    e = e29;
                                    str15 = optString3;
                                    str16 = str13;
                                    i17 = 0;
                                    QLog.e(str14, 1, e, new Object[i17]);
                                    z17 = true;
                                    str7 = str15;
                                    str5 = str12;
                                    str6 = str3;
                                    super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str16, str7, this.mOnRemoteResp.key, this.mReqBundle), false, z17);
                                    VasLogReporter.getChatBackgroundJsb().report(str5 + str6 + " - mReqBundle:" + this.mReqBundle.toString());
                                    return true;
                                }
                            } catch (Exception e36) {
                                e = e36;
                                str14 = TAG;
                                str15 = optString3;
                                str16 = str13;
                                i17 = 0;
                                QLog.e(str14, 1, e, new Object[i17]);
                                z17 = true;
                                str7 = str15;
                                str5 = str12;
                                str6 = str3;
                                super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str16, str7, this.mOnRemoteResp.key, this.mReqBundle), false, z17);
                                VasLogReporter.getChatBackgroundJsb().report(str5 + str6 + " - mReqBundle:" + this.mReqBundle.toString());
                                return true;
                            }
                        } catch (Exception e37) {
                            e = e37;
                            str12 = "web ";
                        }
                    } catch (Exception e38) {
                        e = e38;
                        str12 = "web ";
                        str13 = "chatbackground_setbg";
                    }
                    if (this.proxy != null) {
                        this.proxy.chatBackgroundSetUp(jsonFromJSBridge.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY), string, string2, shopBgPath, optString, "", Integer.parseInt(optString2), intent);
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("result", 0);
                            str15 = optString3;
                            try {
                                super.callJs(str15, jSONObject3.toString());
                                return true;
                            } catch (Exception e39) {
                                e = e39;
                                str16 = str13;
                                i17 = 0;
                                QLog.e(str14, 1, e, new Object[i17]);
                                z17 = true;
                                str7 = str15;
                                str5 = str12;
                                str6 = str3;
                                super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str16, str7, this.mOnRemoteResp.key, this.mReqBundle), false, z17);
                                VasLogReporter.getChatBackgroundJsb().report(str5 + str6 + " - mReqBundle:" + this.mReqBundle.toString());
                                return true;
                            }
                        } catch (Exception e46) {
                            e = e46;
                            str15 = optString3;
                            str16 = str13;
                            i17 = 0;
                            QLog.e(str14, 1, e, new Object[i17]);
                            z17 = true;
                            str7 = str15;
                            str5 = str12;
                            str6 = str3;
                            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str16, str7, this.mOnRemoteResp.key, this.mReqBundle), false, z17);
                            VasLogReporter.getChatBackgroundJsb().report(str5 + str6 + " - mReqBundle:" + this.mReqBundle.toString());
                            return true;
                        }
                    }
                    str16 = str13;
                    str6 = str3;
                    str5 = str12;
                    str7 = optString3;
                    z17 = true;
                    super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str16, str7, this.mOnRemoteResp.key, this.mReqBundle), false, z17);
                    VasLogReporter.getChatBackgroundJsb().report(str5 + str6 + " - mReqBundle:" + this.mReqBundle.toString());
                    return true;
                }
                if ("custom".equals(str3)) {
                    VasLogReporter.getChatBackgroundJsb().report("web " + str3);
                    custom(optString3);
                    return true;
                }
                if (IndividuationPlugin.Method_OpenPage.equals(str3)) {
                    try {
                        Intent intent2 = new Intent();
                        intent2.putExtra("bg_replace_entrance", 8);
                        intent2.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, this.mRuntime.a().getString(R.string.button_back));
                        intent2.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
                        intent2.putExtra("show_right_close_button", false);
                        intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                        VasWebviewUtil.openQQBrowserWithoutAD(this.mRuntime.a(), IndividuationUrlHelper.getMarketUrl(this.mRuntime.a(), "background", str4), 33554432L, intent2, false, -1);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("result", 0);
                        VasLogReporter.getChatBackgroundJsb().report("web " + str3);
                        super.callJs(optString3, jSONObject4.toString());
                        return true;
                    } catch (Exception e47) {
                        e47.printStackTrace();
                        super.callJs(optString3, e47.getMessage());
                        return true;
                    }
                }
                if ("isSupportDynamic".equals(str3)) {
                    int h16 = ChatBackgroundManager.h();
                    int i18 = (h16 & 1) != 0 ? 1 : 0;
                    int i19 = (h16 & 2) != 0 ? 1 : 0;
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("result", 0);
                        jSONObject5.put("isDeviceEnable", i18);
                        jSONObject5.put("isWebviewEnable", i19);
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "isSupportDynamic deviceEnable:" + i18 + ", webViewEnable:" + i19);
                        }
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("result", 0);
                        jSONObject6.put("message", "isSupportDynamic return deviceEnable:" + i18 + ", webViewEnable:" + i19);
                        jSONObject6.put("data", jSONObject5);
                        super.callJs(optString3, jSONObject6.toString());
                        str11 = "web ";
                    } catch (JSONException e48) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("handleJsRequest exception url=");
                        sb6.append(str);
                        sb6.append(", pkgName=");
                        str11 = "web ";
                        sb6.append(str2);
                        sb6.append(", methodName=");
                        sb6.append(str3);
                        QLog.e(TAG, 1, sb6.toString(), e48);
                    }
                    str7 = optString3;
                    str6 = str3;
                    str4 = str4;
                    str5 = str11;
                } else {
                    if ("setDIYConfig".equals(str3)) {
                        VasLogReporter.getChatBackgroundJsb().report("call jsb", VasLogReportProxy.LEVEL.HIGHEST);
                        String optString5 = jsonFromJSBridge.optString(IECDtReport.ACTION_IDENTIFIER);
                        String optString6 = jsonFromJSBridge.optString("compressType");
                        String optString7 = jsonFromJSBridge.optString("effectId");
                        String optString8 = jsonFromJSBridge.optString("callback");
                        String optString9 = jsonFromJSBridge.optString("originX");
                        String optString10 = jsonFromJSBridge.optString("originY");
                        String optString11 = jsonFromJSBridge.optString("uinType");
                        String optString12 = jsonFromJSBridge.has("friendUin") ? jsonFromJSBridge.optString("friendUin") : null;
                        String optString13 = jsonFromJSBridge.optString("imageWidth");
                        if (optString6.equals("2")) {
                            str9 = optString6;
                            if (this.mRuntime.a().getResources().getDisplayMetrics().widthPixels <= 1200) {
                                VasLogReporter.getChatBackgroundJsb().report("reset compressType to 1");
                                str10 = "1";
                                if (!TextUtils.isEmpty(optString5)) {
                                    VasLogReporter.getChatBackgroundJsb().report("web " + str3 + " - identifier == null");
                                    QLog.w(TAG, 2, "@coverOptimize  identifier is null or size is 0 ");
                                    return false;
                                }
                                str4 = str4;
                                String str18 = new String(Base64.decode(optString5, 2));
                                String customImageFilePath = getCustomImageFilePath();
                                str5 = "web ";
                                int exifOrientation = BaseImageUtil.getExifOrientation(str18);
                                try {
                                    bitmap = BitmapFactory.decodeFile(str18);
                                    if (bitmap == null) {
                                        try {
                                            file = new File(str18);
                                            sb5 = new StringBuilder();
                                            str8 = optString3;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            str8 = optString3;
                                        }
                                        try {
                                            sb5.append("file exist: ");
                                            sb5.append(file.exists());
                                            sb5.append(", fileSize");
                                            sb5.append(file.length());
                                            QLog.e(TAG, 1, sb5.toString());
                                        } catch (Throwable th6) {
                                            th = th6;
                                            QLog.e(TAG, 1, "bitmap create error: " + customImageFilePath + ", degress" + exifOrientation + ", " + th.getMessage());
                                            compressBitmapToFile = compressBitmapToFile(this.mRuntime.a(), Integer.parseInt(str10), bitmap, customImageFilePath, Float.parseFloat(optString9), Float.parseFloat(optString10), Float.parseFloat(optString13), exifOrientation);
                                            if (compressBitmapToFile.getResult() == 0) {
                                            }
                                            super.callJs(optString8, compressBitmapToFile.toString());
                                            str6 = str3;
                                            str7 = str8;
                                            z17 = true;
                                            str16 = str4;
                                            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str16, str7, this.mOnRemoteResp.key, this.mReqBundle), false, z17);
                                            VasLogReporter.getChatBackgroundJsb().report(str5 + str6 + " - mReqBundle:" + this.mReqBundle.toString());
                                            return true;
                                        }
                                    } else {
                                        str8 = optString3;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    str8 = optString3;
                                    bitmap = null;
                                }
                                compressBitmapToFile = compressBitmapToFile(this.mRuntime.a(), Integer.parseInt(str10), bitmap, customImageFilePath, Float.parseFloat(optString9), Float.parseFloat(optString10), Float.parseFloat(optString13), exifOrientation);
                                if (compressBitmapToFile.getResult() == 0) {
                                    handleCustomPic(optString12, Integer.parseInt(optString11), customImageFilePath, Integer.parseInt(optString7), true);
                                }
                                super.callJs(optString8, compressBitmapToFile.toString());
                                str6 = str3;
                            }
                        } else {
                            str9 = optString6;
                        }
                        str10 = str9;
                        if (!TextUtils.isEmpty(optString5)) {
                        }
                    } else {
                        str8 = optString3;
                        str4 = str4;
                        str5 = "web ";
                        str6 = str3;
                        if ("openImagePicker".equals(str6)) {
                            VasUtil.getService().getGxh().openMobilePhotoSelect(EIPCCallbackWrapper.newInstance(new f.b() { // from class: com.tencent.mobileqq.vaswebviewplugin.a
                                @Override // com.tencent.mobileqq.vas.api.f.b
                                public final void onCallback(String str19) {
                                    ChatBackgroundJsPlugin.this.lambda$handleJsRequest$0(str8, str19);
                                }
                            }));
                            return true;
                        }
                    }
                    str7 = str8;
                }
                z17 = true;
            }
            str16 = str4;
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str16, str7, this.mOnRemoteResp.key, this.mReqBundle), false, z17);
            VasLogReporter.getChatBackgroundJsb().report(str5 + str6 + " - mReqBundle:" + this.mReqBundle.toString());
            return true;
        }
        str7 = optString3;
        z17 = true;
        str16 = str4;
        super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str16, str7, this.mOnRemoteResp.key, this.mReqBundle), false, z17);
        VasLogReporter.getChatBackgroundJsb().report(str5 + str6 + " - mReqBundle:" + this.mReqBundle.toString());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.mReqBundle = new Bundle();
        AppInterface b16 = this.mRuntime.b();
        if (b16 instanceof BrowserAppInterface) {
            this.browserApp = (BrowserAppInterface) b16;
        } else if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "ERROR!!! chatbg market is not running in web process!");
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    void onPushMsg(Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onPushMsg=" + bundle);
        }
        int i3 = bundle.getInt("id");
        int i16 = bundle.getInt("result");
        String string = bundle.getString("callbackId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i3);
            jSONObject.put("result", i16);
        } catch (JSONException unused) {
        }
        super.callJs(string, jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        if (bundle != null && bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
            String string = bundle.getString("cmd");
            try {
                String string2 = bundle.getString("callbackid");
                Bundle bundle2 = bundle.getBundle("response");
                JSONObject jSONObject = new JSONObject();
                if ("chatbackground_setbg".equals(string)) {
                    jSONObject.put("result", bundle2.getInt("result"));
                    super.callJs(string2, jSONObject.toString());
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "Failed to handle cmd " + string + ", exception: " + e16.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleJsRequest$0(String str, String str2) {
        callJs(str, str2);
    }

    private void handleCustomPic(Intent intent) {
        if (intent == null) {
            QLog.d(TAG, 2, "handleCustomPic intent = null");
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra(ISFROMPHOTO, false);
        handleCustomPic(intent.getStringExtra("chatbg_intent_frinedUin"), 0, intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"), 0, booleanExtra);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        Object obj;
        if (j3 == 128 && (obj = map.get("intent")) != null && (obj instanceof Intent)) {
            Intent intent = (Intent) obj;
            if (intent.getBooleanExtra(FROM_CHATBACKGROUNDJS, false)) {
                handleCustomPic(intent);
                return true;
            }
        }
        return super.handleEvent(str, j3, map);
    }
}
