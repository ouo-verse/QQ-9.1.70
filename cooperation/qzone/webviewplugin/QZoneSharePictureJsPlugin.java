package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.webviewplugin.n;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.xhsapi.XhsShareHelper;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IDataUtils;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.qzonehub.api.impl.QZoneHelperProxyImpl;
import com.xingin.xhssharesdk.model.other.VersionCheckResult;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.GifCoder;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZoneSharePictureJsPlugin extends QzoneInternalWebViewPlugin {
    private static final String ARG_ARRAY_IMAGES = "images";
    private static final String ARG_INT_FRAME_DELAY = "delay";
    private static final String ARG_NEED_PUBLISHED = "needPublish";
    private static final String ARG_STR_CONTENT = "content";
    private static final String ARG_SUPPORT_MULTI_PIECES_CALLBACK = "supportMultiPiecesCallback";
    private static final String ARG_USE_ORIGIN = "useSample";
    private static final String ARG_USE_PATH = "usePath";
    private static final String NAMESPACE = "Qzone";
    private static final int RESULT_CANCEL = 1;
    private static final int RESULT_FAILURE = -1;
    private static final int RESULT_OK = 0;
    private static final int SHARE_TO_GUILD = 5;
    private static final int SHARE_TO_QQ = 0;
    private static final int SHARE_TO_QZONE = 1;
    private static final int SHARE_TO_WECHAT = 2;
    private static final int SHARE_TO_WECHAT_MONMENT = 3;
    private static final int SHARE_TO_XHS = 6;
    public static final String SHARE_TO_XHS_FILE_PATH = "share_to_xhs_file_path";
    private static final String TAG = "QZoneSharePictureJsPlugin";
    public static final String TEMP_FILE_NAME_PREFIX = "tempfile_";
    private static final String TYPE_SHARE_TO_XHS_VALUE = "6";
    private String callback;
    static final Pattern pattern = Pattern.compile("@\\{uin:(\\d+),nick:(.+?)\\}");
    private static final String DISK_FULL_MSG = HardCodeUtil.qqStr(R.string.s8h);
    IQzoneShareApi.WXShareListener wxShareListener = new IQzoneShareApi.WXShareListener() { // from class: cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.8
        @Override // com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener
        public void onWXShareResp(BaseResp baseResp) {
            QZoneSharePictureJsPlugin.this.onShareWXResp(baseResp);
        }
    };
    WXShareHelper.a wezoneWxShareListener = new WXShareHelper.a() { // from class: cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.9
        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            QZoneSharePictureJsPlugin.this.onShareWXResp(baseResp);
        }
    };

    public static boolean appendFileContent(String str, String str2) {
        boolean z16 = true;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str, true)));
                try {
                    bufferedWriter2.write(str2);
                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedWriter2);
                } catch (Exception e16) {
                    e = e16;
                    bufferedWriter = bufferedWriter2;
                    QZLog.w(TAG, 1, e, new Object[0]);
                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedWriter);
                    z16 = false;
                    return z16;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = bufferedWriter2;
                    ((IDataUtils) QRoute.api(IDataUtils.class)).closeDataObject(bufferedWriter);
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
            }
            return z16;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void callJS(String str, int i3, String str2) {
        WebViewPlugin.b bVar;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "callback is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", i3);
            jSONObject.put("msg", str2);
            String jSONObject2 = jSONObject.toString();
            WebViewPlugin webViewPlugin = this.parentPlugin;
            if (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null || bVar.e() == null) {
                return;
            }
            this.parentPlugin.mRuntime.e().callJs(str, jSONObject2);
            QLog.i(TAG, 1, "callJs \uff1aretCode = " + i3 + ", msg = " + str2);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0032: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:30:0x0032 */
    public static byte[] compressToBytes(Bitmap bitmap, int i3) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(8192);
                } catch (Exception e16) {
                    e = e16;
                    byteArrayOutputStream = null;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    byteArrayOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        byteArrayOutputStream3.flush();
                        byteArrayOutputStream3.close();
                    } catch (Exception e18) {
                        QLog.e(TAG, 1, e18.toString());
                    }
                    throw th;
                }
                try {
                    if (bitmap.hasAlpha()) {
                        bitmap.compress(Bitmap.CompressFormat.PNG, i3, byteArrayOutputStream);
                    } else {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    } catch (Exception e19) {
                        QLog.e(TAG, 1, e19.toString());
                    }
                    return byteArray;
                } catch (Exception e26) {
                    e = e26;
                    QLog.e(TAG, 1, e.toString());
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return null;
                } catch (OutOfMemoryError e27) {
                    e = e27;
                    QLog.e(TAG, 1, e.toString());
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
                byteArrayOutputStream3 = byteArrayOutputStream2;
                byteArrayOutputStream3.flush();
                byteArrayOutputStream3.close();
                throw th;
            }
        } catch (Exception e28) {
            QLog.e(TAG, 1, e28.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAppendTempFile(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("callback");
            if (TextUtils.isEmpty(optString)) {
                ToastUtil.a().e("callback is null");
                QLog.e(TAG, 1, "doAppendTempFile ,callback is null");
                return;
            }
            String optString2 = jSONObject.optString("path");
            if (TextUtils.isEmpty(optString2)) {
                callJS(optString, -1, "path is empty");
                return;
            }
            if (!checkIsValidTempFileName(optString2)) {
                callJS(optString, -1, "path is invalid");
                return;
            }
            String optString3 = jSONObject.optString("data");
            if (TextUtils.isEmpty(optString3)) {
                callJS(optString, -1, "data is empty");
                return;
            }
            String path = CacheManager.getWebviewOfflineFileCacheService().getPath(optString2);
            QLog.i(TAG, 1, "doAppendTempFile path=" + path + ",data len=" + optString3.length());
            File file = new File(path);
            if (!file.exists()) {
                callJS(optString, -1, HardCodeUtil.qqStr(R.string.s8d));
                return;
            }
            if (!file.canWrite()) {
                callJS(optString, -1, HardCodeUtil.qqStr(R.string.s8g));
                return;
            }
            if (appendFileContent(path, optString3)) {
                try {
                    long length = file.length();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("path", optString2);
                    jSONObject2.put(c.E, length);
                    callJS(optString, 0, "", jSONObject2);
                    return;
                } catch (JSONException e16) {
                    QLog.e(TAG, 1, "JSONObject fail", e16);
                    return;
                }
            }
            callJS(optString, -1, HardCodeUtil.qqStr(R.string.s8m));
        } catch (JSONException e17) {
            QLog.e(TAG, 1, "JSONObject fail", e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCreateTempFile(String str) {
        File file;
        QLog.i(TAG, 1, "doCreateTempFile arg=" + str);
        String str2 = null;
        try {
            str2 = new JSONObject(str).optString("callback");
            if (TextUtils.isEmpty(str2)) {
                ToastUtil.a().e("callback is null");
                QLog.e(TAG, 1, "doCreateTempFile arg=" + str + ",callback is null");
                return;
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "JSONObject fail", e16);
        }
        String dir = CacheManager.getWebviewOfflineFileCacheService().getDir();
        if (TextUtils.isEmpty(dir)) {
            callJS(str2, -1, HardCodeUtil.qqStr(R.string.s8f));
            return;
        }
        try {
            file = new File(dir);
        } catch (Exception e17) {
            QLog.e(TAG, 1, "\u68c0\u67e5\u4e34\u65f6\u76ee\u5f55\u5931\u8d25", e17);
        }
        if (!q.p(dir) && !file.mkdirs()) {
            String str3 = DISK_FULL_MSG;
            QLog.e(TAG, 1, str3);
            callJS(str2, -1, str3);
            return;
        }
        long A = Utils.A(file);
        if (A < QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneConfig.SECONDARY_GIF_COVER_MIN_DISK_SIZE, 2097152)) {
            QLog.e(TAG, 1, "\u624b\u673a\u5b58\u50a8\u7a7a\u95f4\u5df2\u6ee1\uff0c\u8bf7\u6e05\u7406\u540e\u91cd\u8bd5\u3002 spaceLen=" + A + ",dir=" + dir);
            callJS(str2, -1, DISK_FULL_MSG);
            return;
        }
        QLog.i(TAG, 1, "saxon spaceLen=" + A);
        String str4 = "tempfile_" + System.currentTimeMillis() + "_" + ((int) ((Math.random() * 1000000.0d) % 10000.0d));
        try {
            if (new File(CacheManager.getWebviewOfflineFileCacheService().getPath(str4)).createNewFile()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("path", str4);
                callJS(str2, 0, "", jSONObject);
            } else {
                callJS(str2, -1, HardCodeUtil.qqStr(R.string.f172577s90));
            }
        } catch (Exception e18) {
            QLog.e(TAG, 1, "create file fail", e18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDeleteTempFile(String str) {
        QLog.i(TAG, 1, "doDeleteTempFile arg=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("callback");
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            JSONObject jSONObject2 = new JSONObject();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    String string = optJSONArray.getString(i3);
                    if (TextUtils.isEmpty(string)) {
                        jSONObject2.put(string, false);
                        QLog.w(TAG, 1, "doDeleteTempFile fileName is empty");
                    } else if (!checkIsValidTempFileName(string)) {
                        jSONObject2.put(string, false);
                        QLog.w(TAG, 1, "doDeleteTempFile fileName is invalid, fileName=" + string);
                    } else {
                        String path = CacheManager.getWebviewOfflineFileCacheService().getPath(string);
                        boolean d16 = q.d(path);
                        jSONObject2.put(string, d16);
                        QZLog.i(TAG, "delete file " + path + ", ret=" + d16);
                    }
                }
            }
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            callJS(optString, 0, "", jSONObject2);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "JSONObject fail", e16);
        }
    }

    private void genGifCallback(String str, int i3, String str2, int i16, int i17, String str3, int i18) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("total", i16);
            jSONObject.put("current", i17);
            jSONObject.put("base64Data", str3);
            jSONObject.put("fileLength", i18);
            callJS(str, i3, str2, jSONObject);
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 1, "callback" + str + ",total=" + i16 + ",current=" + i17 + ",fileLength=" + i18 + ",base64Data len=" + str3.length());
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "genGifCallback fail.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGenerateGif(WebViewPlugin.b bVar, String... strArr) {
        int i3;
        String str;
        QLog.i(TAG, 1, "saxon handleGenerateGif start");
        if (bVar != null && strArr != null && strArr.length >= 1) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                JSONArray jSONArray = jSONObject.getJSONArray("images");
                if (jSONArray == null) {
                    return;
                }
                int optInt = jSONObject.optInt(ARG_INT_FRAME_DELAY);
                if (optInt < 0) {
                    optInt = 100;
                }
                int i16 = optInt;
                String optString = jSONObject.optString("content");
                this.callback = jSONObject.optString("callback");
                boolean optBoolean = jSONObject.optBoolean(ARG_NEED_PUBLISHED, false);
                boolean optBoolean2 = jSONObject.optBoolean(ARG_USE_ORIGIN, false);
                boolean optBoolean3 = jSONObject.optBoolean(ARG_USE_PATH, false);
                boolean optBoolean4 = jSONObject.optBoolean(ARG_SUPPORT_MULTI_PIECES_CALLBACK, false);
                QLog.i(TAG, 1, "QzoneWidgetAI.handleGenerateGif frameDelay is :" + i16 + ",jsonArrayImages len=" + jSONArray.length() + ",content=" + optString + ",usePath=" + optBoolean3 + ",supportMultiPiecesCallback=" + optBoolean4);
                GifCoder gifCoder = new GifCoder();
                gifCoder.setUseOrignalBitmap(false);
                gifCoder.setEncoderDither(true);
                String cameraPath = PhotoUtils.getCameraPath(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE), "IMG", QzoneEmotionUtils.SIGN_ICON_URL_END);
                if (!new File(cameraPath).getParentFile().exists()) {
                    new File(cameraPath).mkdirs();
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean encodeGifFromBase64 = gifCoder.encodeGifFromBase64(cameraPath, jSONArray, i16, !optBoolean2, optBoolean3);
                gifCoder.closeEncoder();
                QLog.i(TAG, 4, "encodeGif: duration=" + (System.currentTimeMillis() - currentTimeMillis));
                if (encodeGifFromBase64) {
                    i3 = 0;
                    str = "success";
                } else {
                    str = "gif\u5408\u6210\u5931\u8d25";
                    i3 = -1;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("published", optBoolean);
                if (!optBoolean) {
                    int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneConfig.SECONDARY_GIF_COVER_CALLBACK_PIECE_SIZE, 1048576);
                    String file2Base64 = file2Base64(new File(cameraPath));
                    if (TextUtils.isEmpty(file2Base64)) {
                        callJS(this.callback, -2, "gif\u6587\u4ef6\u8f6cbase64\u5931\u8d25", jSONObject2);
                        return;
                    }
                    if (!optBoolean4) {
                        QLog.i(TAG, 1, "saxon \u4e0d\u5206\u7247callback ");
                        genGifCallback(this.callback, i3, str, 1, 0, file2Base64, file2Base64.length());
                        return;
                    }
                    if (file2Base64.length() <= config) {
                        QLog.i(TAG, 1, "saxon \u4e0d\u5206\u7247callback len=" + file2Base64.length());
                        genGifCallback(this.callback, i3, str, 1, 0, file2Base64, file2Base64.length());
                        return;
                    }
                    int length = (file2Base64.length() / config) + (file2Base64.length() % config == 0 ? 0 : 1);
                    QLog.i(TAG, 1, "saxon \u5206\u7247callback pcount\uff1d" + length + ",filelen=" + file2Base64.length());
                    int i17 = 0;
                    while (true) {
                        int i18 = length - 1;
                        if (i17 < i18) {
                            int i19 = i17 + 1;
                            int i26 = length;
                            genGifCallback(this.callback, i3, str, length, i17, file2Base64.substring(i17 * config, i19 * config), file2Base64.length());
                            QLog.i(TAG, 1, "saxon \u5206\u7247callback ,i=" + i17);
                            try {
                                LockMethodProxy.sleep(200L);
                            } catch (InterruptedException e16) {
                                QLog.e(TAG, 1, "handleGenerateGif Thread.sleep(200) fail.", e16);
                            }
                            i17 = i19;
                            length = i26;
                        } else {
                            genGifCallback(this.callback, i3, str, length, i18, file2Base64.substring(config * i18), file2Base64.length());
                            QLog.i(TAG, 1, "saxon \u5206\u7247callback last piece,i=" + i18);
                            return;
                        }
                    }
                } else {
                    callJS(this.callback, i3, str, jSONObject2);
                    QZoneHelper.forwardToPublishMood(bVar.a(), QZoneHelper.UserInfo.getInstance(), cameraPath, HardCodeUtil.qqStr(R.string.s8u), optString, -1);
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "handleGenerateGif fail, compressGIFTask exception.", th5);
            }
        } else {
            QLog.d(TAG, 1, "QzoneWidgetAI.handleGenerateGif args is empty");
        }
    }

    private void handleSharePicture(final WebViewPlugin.b bVar, String... strArr) {
        String str;
        QQProgressDialog sharePD;
        if (this.parentPlugin == null || bVar == null || strArr == null || strArr.length <= 0) {
            if (bVar == null) {
                QLog.i(TAG, 1, "runtime is null");
                return;
            } else if (strArr == null) {
                QLog.i(TAG, 1, "args is null");
                return;
            } else {
                if (strArr.length <= 0) {
                    QLog.i(TAG, 1, "args.length = 0");
                    return;
                }
                return;
            }
        }
        try {
            int i3 = 0;
            JSONObject jSONObject = new JSONObject(strArr[0]);
            String optString = jSONObject.optString("type");
            String optString2 = jSONObject.optString("base64");
            this.callback = jSONObject.optString("callback");
            String optString3 = jSONObject.optString("shareFrom");
            try {
                byte[] decode = Base64.decode(cutHeadIfNeeded(optString2).getBytes(), 0);
                if (isShareToXHS(optString)) {
                    str = null;
                } else {
                    str = saveByteBufferToLocalFile(decode);
                    if (TextUtils.isEmpty(str)) {
                        QLog.i(TAG, 1, "saveByteBufferToLocalFile catch exception");
                        makeText(HardCodeUtil.qqStr(R.string.s8s));
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "the filePath is " + str);
                }
                if (!TextUtils.isEmpty(optString) && bVar.a() != null) {
                    QLog.i(TAG, 1, "share type is " + optString);
                    try {
                        i3 = Integer.parseInt(optString);
                    } catch (NumberFormatException e16) {
                        QLog.w(TAG, 1, "parse string to integer catch a numberformatexcetion", e16);
                    }
                    if (i3 == 0) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("forward_type", 1);
                        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
                        bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
                        bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
                        bundle.putBoolean("key_flag_from_plugin", true);
                        bundle.putBoolean("forward_photo_shortvideo_is_edited", true);
                        Intent intent = new Intent();
                        intent.putExtras(bundle);
                        if (QZoneConfigHelper.v()) {
                            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
                            intent.putExtra("isFromShare", true);
                            intent.putExtra("sendMultiple", true);
                        }
                        int generateRequestCode = QZoneHelperProxyImpl.generateRequestCode(this.parentPlugin, bVar, 21);
                        Class cls = ForwardRecentActivity.class;
                        String optString4 = jSONObject.optString(WadlProxyConsts.EXT_JSON);
                        if (!TextUtils.isEmpty(optString4)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString4);
                                int optInt = jSONObject2.optInt("targetUinType");
                                String optString5 = jSONObject2.optString(IProfileProtocolConst.PARAM_TARGET_UIN);
                                String optString6 = jSONObject2.optString("targetNickname");
                                if (!TextUtils.isEmpty(optString5)) {
                                    intent.putExtra("uinType", optInt);
                                    intent.putExtra("toUin", optString5);
                                    intent.putExtra("nickName", optString6);
                                    cls = DirectForwardActivity.class;
                                }
                            } catch (JSONException e17) {
                                QLog.e(TAG, 1, "share to qq: parse extJson error!", e17);
                            }
                        }
                        ForwardBaseOption.startForwardActivityForResult(bVar.a(), intent, (Class<?>) cls, generateRequestCode, -1, "");
                    } else if (i3 == 1) {
                        writeMood(jSONObject, str, bVar);
                    } else if (i3 == 2) {
                        shareToWeChat(str, optString3, bVar);
                    } else if (i3 != 3) {
                        if (i3 == 5) {
                            ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).shareQzonePicToGuild(bVar.a(), jSONObject, str, QZoneHelperProxyImpl.generateRequestCode(this.parentPlugin, bVar, 21));
                        } else if (i3 == 6) {
                            shareToXhs(bVar.a(), decode);
                        }
                    } else if (((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).isWXinstalled()) {
                        if (TextUtils.equals(optString3, "wezone")) {
                            WXShareHelper.b0().A(this.wezoneWxShareListener);
                            WXShareHelper.b0().D0(str, null, 1);
                        } else {
                            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(this.wxShareListener);
                            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), str, null, 1);
                        }
                    } else if (bVar.e() != null) {
                        bVar.e().post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.5
                            @Override // java.lang.Runnable
                            public void run() {
                                QQToast.makeText(bVar.e().getContext(), HardCodeUtil.qqStr(R.string.s8p), 0).show();
                            }
                        });
                    }
                }
                y d16 = bVar.d(bVar.a());
                if (d16 != null && (d16 instanceof n) && (sharePD = ((Share) ((n) d16).getShare()).getSharePD()) != null && sharePD.isShowing()) {
                    sharePD.dismiss();
                }
                QLog.i(TAG, 1, "WebView share picture call jsbridge successful!");
            } catch (Exception e18) {
                QLog.w(TAG, 1, "Base64.decode Exception: " + e18.toString());
                makeText(HardCodeUtil.qqStr(R.string.s87));
            }
        } catch (Exception e19) {
            QLog.w(TAG, 1, "handleSharePicture catch an exception in disPatchMethod", e19);
        }
    }

    private boolean isShareToXHS(String str) {
        return !TextUtils.isEmpty(str) && str.equals("6");
    }

    private boolean isSupportShareToXhs(Context context, XhsShareHelper xhsShareHelper) {
        if (xhsShareHelper != null && context != null) {
            VersionCheckResult h16 = xhsShareHelper.h(context);
            if (h16 == null) {
                QLog.e(TAG, 1, "checkResult is null error!");
                return false;
            }
            int i3 = h16.checkResultCode;
            if (i3 == -1) {
                QQToast.makeText(context, R.string.f2047553r, 0).show();
                return false;
            }
            if (i3 == 0) {
                return true;
            }
            QQToast.makeText(context, R.string.f2047653s, 0).show();
            return false;
        }
        QLog.e(TAG, 1, "args is null error!");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareToXhs$1(String str, final String str2, byte[] bArr, final Activity activity) {
        if (!saveImageToTargetPath(str, str2, bArr)) {
            QLog.e(TAG, 1, "tryToSaveImageToTargetPath false.");
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: cooperation.qzone.webviewplugin.b
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneSharePictureJsPlugin.this.lambda$shareToXhs$0(activity, str2);
                }
            });
        }
    }

    private void makeText(String str) {
        WebViewPlugin.b bVar;
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null || bVar.e() == null) {
            return;
        }
        QQToast.makeText(this.parentPlugin.mRuntime.e().getContext(), str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShareWXResp(BaseResp baseResp) {
        String qqStr;
        int i3 = baseResp.errCode;
        if (i3 == 0) {
            String qqStr2 = HardCodeUtil.qqStr(R.string.f172579s92);
            makeText(qqStr2);
            qqStr = qqStr2;
            i3 = 0;
        } else if (i3 == -2) {
            String qqStr3 = HardCodeUtil.qqStr(R.string.s8t);
            makeText(qqStr3);
            qqStr = qqStr3;
            i3 = 1;
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.s8q);
            QLog.e(TAG, 1, "wx share fail:" + i3);
        }
        callJS(this.callback, i3, qqStr);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String saveByteBufferToLocalFile(byte[] bArr) {
        FileOutputStream fileOutputStream;
        File file;
        StringBuilder sb5 = new StringBuilder();
        String str = IQzoneShareApi.PHOTO_PATH;
        sb5.append(str);
        sb5.append(String.valueOf(System.currentTimeMillis()));
        sb5.append(".jpg");
        String sb6 = sb5.toString();
        boolean z16 = true;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file2 = new File(str);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(sb6);
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        try {
                            fileOutputStream.write(bArr);
                            fileOutputStream.flush();
                            try {
                                fileOutputStream.close();
                            } catch (Exception e16) {
                                QLog.d(TAG, 1, "fos close " + e16);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Exception e17) {
                                    QLog.d(TAG, 1, "fos close " + e17);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e18) {
                        e = e18;
                        QLog.d(TAG, 1, "save bytes to local file " + e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e19) {
                                QLog.d(TAG, 1, "fos close " + e19);
                            }
                        }
                        z16 = false;
                        if (z16) {
                        }
                    }
                } catch (IOException e26) {
                    e = e26;
                    fileOutputStream = null;
                }
            } catch (IOException e27) {
                e = e27;
                fileOutputStream = null;
                file = null;
            }
            if (z16) {
                return null;
            }
            return file.getAbsolutePath();
        } catch (Throwable th6) {
            th = th6;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
    }

    private boolean saveImageToTargetPath(String str, String str2, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && bArr != null) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(str2);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e16) {
                            QLog.d(TAG, 1, "fos close " + e16);
                        }
                        return true;
                    } catch (IOException e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        QLog.d(TAG, 1, "save bytes to local file " + e);
                        if (fileOutputStream == null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Exception e18) {
                            QLog.d(TAG, 1, "fos close " + e18);
                            return false;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e19) {
                                QLog.d(TAG, 1, "fos close " + e19);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e26) {
                e = e26;
            }
        } else {
            QLog.e(TAG, 1, "args is null error!");
            return false;
        }
    }

    private void shareToWeChat(String str, String str2, final WebViewPlugin.b bVar) {
        if (((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).isWXinstalled()) {
            if (TextUtils.equals(str2, "wezone")) {
                byte[] compressToBytesForWX = compressToBytesForWX(str);
                WXShareHelper.b0().A(this.wezoneWxShareListener);
                WXShareHelper.b0().D0(str, compressToBytesForWX, 0);
                return;
            } else if (TextUtils.equals(str2, "qq")) {
                WXShareHelper.b0().u0(str, com.tencent.open.base.b.d(str, 120, 120, false), 0);
                return;
            } else {
                byte[] compressToBytesForWX2 = compressToBytesForWX(str);
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).addObserver(this.wxShareListener);
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), str, compressToBytesForWX2, 0);
                return;
            }
        }
        if (bVar.e() != null) {
            bVar.e().post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.6
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(bVar.e().getContext(), HardCodeUtil.qqStr(R.string.s8y), 0).show();
                }
            });
        }
    }

    private void shareToXhs(final Activity activity, final byte[] bArr) {
        if (activity != null && bArr != null) {
            XhsShareHelper xhsShareHelper = new XhsShareHelper();
            if (!isSupportShareToXhs(activity, xhsShareHelper)) {
                QLog.i(TAG, 1, "isSupportShareToXhs false");
                return;
            }
            final String f16 = xhsShareHelper.f();
            if (TextUtils.isEmpty(f16)) {
                QLog.i(TAG, 1, "fileDir is null");
                return;
            }
            final String str = f16 + System.currentTimeMillis() + ".jpg";
            ThreadManagerV2.excute(new Runnable() { // from class: cooperation.qzone.webviewplugin.a
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneSharePictureJsPlugin.this.lambda$shareToXhs$1(f16, str, bArr, activity);
                }
            }, 64, null, true);
            return;
        }
        QLog.e(TAG, 1, "shareToXhs context is null.");
    }

    private void writeMood(final JSONObject jSONObject, final String str, final WebViewPlugin.b bVar) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.7
            /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
            
                if (android.text.TextUtils.isEmpty(r1) == false) goto L10;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str2;
                String optString = jSONObject.optString("base64UBBText");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        str2 = new String(Base64.decode(optString, 2));
                    } catch (Throwable th5) {
                        QLog.e(QZoneSharePictureJsPlugin.TAG, 1, "writeMood: parse base64UBBText error:", th5);
                    }
                }
                str2 = null;
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(URLDecoder.decode(str));
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("images", arrayList);
                bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, 1);
                bundle.putBoolean("key_need_save_draft", false);
                bundle.putString("shareSource", jSONObject.optString("shareSource"));
                bundle.putString(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, jSONObject.optString("thirdPartyAppId"));
                int generateRequestCode = QZoneHelperProxyImpl.generateRequestCode(QZoneSharePictureJsPlugin.this.parentPlugin, bVar, 5);
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("summary", str2);
                }
                QZoneShareManager.publishToQzone(bVar.b(), bVar.a(), bundle, null, generateRequestCode);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0025 -> B:8:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String file2Base64(File file) {
        Throwable th5;
        ?? r75;
        String str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        ?? r36 = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
            file = e16;
        }
        try {
            try {
                r75 = new BufferedInputStream(new FileInputStream(file));
            } catch (FileNotFoundException e17) {
                e = e17;
                r75 = 0;
            } catch (IOException e18) {
                e = e18;
                r75 = 0;
            } catch (OutOfMemoryError e19) {
                e = e19;
                r75 = 0;
            } catch (Throwable th6) {
                th5 = th6;
                if (r36 != null) {
                }
                throw th5;
            }
            try {
                byte[] bArr = new byte[r75.available()];
                r75.read(bArr);
                str = Base64.encodeToString(bArr, 0);
                r75.close();
                file = r75;
            } catch (FileNotFoundException e26) {
                e = e26;
                QLog.d(TAG, 1, "", e);
                file = r75;
                if (r75 != 0) {
                    r75.close();
                    file = r75;
                }
                return str;
            } catch (IOException e27) {
                e = e27;
                QLog.d(TAG, 1, "", e);
                file = r75;
                if (r75 != 0) {
                    r75.close();
                    file = r75;
                }
                return str;
            } catch (OutOfMemoryError e28) {
                e = e28;
                QLog.d(TAG, 1, "", e);
                file = r75;
                if (r75 != 0) {
                    r75.close();
                    file = r75;
                }
                return str;
            }
            return str;
        } catch (Throwable th7) {
            th5 = th7;
            r36 = file;
            if (r36 != null) {
                try {
                    r36.close();
                } catch (IOException e29) {
                    e29.printStackTrace();
                }
            }
            throw th5;
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, final String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals("Qzone") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (QZoneJsConstants.METHOD_WEBVIEW_SHARE_PICTURE.equalsIgnoreCase(str3)) {
                handleSharePicture(this.parentPlugin.mRuntime, strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_WEBVIEW_GENETATE_GIF.equalsIgnoreCase(str3)) {
                ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneSharePictureJsPlugin qZoneSharePictureJsPlugin = QZoneSharePictureJsPlugin.this;
                        qZoneSharePictureJsPlugin.handleGenerateGif(qZoneSharePictureJsPlugin.parentPlugin.mRuntime, strArr);
                    }
                });
                return true;
            }
            if (QZoneJsConstants.METHOD_WEBVIEW_CREATE_TEMP_FILE.equalsIgnoreCase(str3)) {
                if (strArr != null && strArr.length >= 1) {
                    ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneSharePictureJsPlugin.this.doCreateTempFile(strArr[0]);
                        }
                    });
                    return true;
                }
                QLog.e(TAG, 1, "args invalid");
                return true;
            }
            if (QZoneJsConstants.METHOD_WEBVIEW_APPEND_TEMP_FILE.equalsIgnoreCase(str3)) {
                if (strArr != null && strArr.length >= 1) {
                    ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.3
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneSharePictureJsPlugin.this.doAppendTempFile(strArr[0]);
                        }
                    });
                    return true;
                }
                QLog.e(TAG, 1, "args invalid");
                return true;
            }
            if (QZoneJsConstants.METHOD_WEBVIEW_DELETE_TEMP_FILE.equalsIgnoreCase(str3)) {
                if (strArr != null && strArr.length >= 1) {
                    ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.4
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneSharePictureJsPlugin.this.doDeleteTempFile(strArr[0]);
                        }
                    });
                    return true;
                }
                QLog.e(TAG, 1, "args invalid");
                return true;
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        String qqStr;
        int i16;
        super.onActivityResult(intent, b16, i3);
        if (b16 == 5 || b16 == 21) {
            if (i3 == -1) {
                qqStr = HardCodeUtil.qqStr(R.string.s98);
                i16 = 0;
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.s8a);
                i16 = 1;
            }
            callJS(this.callback, i16, qqStr);
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        if (this.wxShareListener != null) {
            ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).removeObserver(this.wxShareListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: realShareToXhs, reason: merged with bridge method [inline-methods] */
    public void lambda$shareToXhs$0(Activity activity, String str) {
        if (activity != null && !activity.isFinishing() && !TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(SHARE_TO_XHS_FILE_PATH, str);
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_share_to_xhs_pic", "", 0, bundle));
            return;
        }
        QLog.e(TAG, 1, "realShareToXhs args error");
    }

    public static byte[] compressToBytesForWX(String str) {
        Bitmap d16 = com.tencent.open.base.b.d(str, 120, 120, false);
        if (d16 == null) {
            return null;
        }
        byte[] compressToBytes = compressToBytes(d16, 90);
        double length = compressToBytes.length / 30720.0d;
        if (length > 1.0d) {
            Matrix matrix = new Matrix();
            float sqrt = (float) (1.0d / Math.sqrt(length));
            matrix.postScale(sqrt, sqrt);
            Bitmap createBitmap = Bitmap.createBitmap(d16, 0, 0, d16.getWidth(), d16.getHeight(), matrix, true);
            byte[] compressToBytes2 = compressToBytes(createBitmap, 90);
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "thumbBmp.size:" + (compressToBytes2.length / 1024) + " thumbBmp.width:" + createBitmap.getWidth() + " thumbBmp.height:" + createBitmap.getHeight());
            }
            createBitmap.recycle();
            compressToBytes = compressToBytes2;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "bitmap.size:" + (compressToBytes.length / 1024) + " bitmap.width:" + d16.getWidth() + " bitmap.height:" + d16.getHeight());
        }
        d16.recycle();
        return compressToBytes;
    }

    public static boolean checkIsValidTempFileName(String str) {
        if (str != null && str.length() <= 50 && str.startsWith("tempfile_")) {
            return Pattern.compile("[a-zA-Z0-9_]+").matcher(str).matches();
        }
        return false;
    }

    private String cutHeadIfNeeded(String str) {
        int indexOf;
        int i3;
        if (str == null) {
            return null;
        }
        return (!str.startsWith("data:image") || (indexOf = str.indexOf("base64,")) < 0 || (i3 = indexOf + 7) >= str.length()) ? str : str.substring(i3);
    }

    private void callJS(String str, int i3, String str2, JSONObject jSONObject) {
        WebViewPlugin.b bVar;
        WebViewPlugin.b bVar2;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "callback is null");
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("retCode", i3);
            jSONObject2.put("msg", str2);
            jSONObject2.put("data", jSONObject);
            String jSONObject3 = jSONObject2.toString();
            QLog.i(TAG, 1, "callJs \uff1acallback\uff1d" + str + ", args length=" + jSONObject3.length());
            WebViewPlugin webViewPlugin = this.parentPlugin;
            if (webViewPlugin == null || (bVar2 = webViewPlugin.mRuntime) == null || bVar2.e() == null) {
                return;
            }
            this.parentPlugin.mRuntime.e().callJs(str, jSONObject3);
            QLog.i(TAG, 1, "callJs \uff1aretCode = " + i3 + ", msg = " + str2);
        } catch (OutOfMemoryError e16) {
            QLog.e(TAG, 1, "callJS OutOfMemoryError \u5185\u5b58\u4e0d\u8db3", e16);
            if (QZLog.isDevelopLevel()) {
                ToastUtil.a().e(HardCodeUtil.qqStr(R.string.s88));
            }
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("retCode", -1);
                jSONObject4.put("msg", HardCodeUtil.qqStr(R.string.s8j));
                String jSONObject5 = jSONObject4.toString();
                WebViewPlugin webViewPlugin2 = this.parentPlugin;
                if (webViewPlugin2 == null || (bVar = webViewPlugin2.mRuntime) == null || bVar.e() == null) {
                    return;
                }
                this.parentPlugin.mRuntime.e().callJs(str, jSONObject5);
                QLog.i(TAG, 1, "callJs \uff1aretCode = -1 msg = \u5185\u5b58\u4e0d\u8db3");
            } catch (JSONException e17) {
                QLog.e(TAG, 1, "JSONException", e17);
            }
        } catch (JSONException e18) {
            QLog.e(TAG, 1, "JSONException", e18);
        }
    }
}
