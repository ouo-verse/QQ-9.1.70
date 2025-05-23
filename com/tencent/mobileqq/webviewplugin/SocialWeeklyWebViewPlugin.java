package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class SocialWeeklyWebViewPlugin extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private String f315032d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        if (r4 != null) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1 A[Catch: Exception -> 0x00a4, TRY_LEAVE, TryCatch #6 {Exception -> 0x00a4, blocks: (B:44:0x009c, B:39:0x00a1), top: B:43:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String r(String str) {
        byte[] bArr;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        File cacheDir;
        File file;
        String str2 = null;
        str2 = null;
        str2 = null;
        FileOutputStream fileOutputStream2 = null;
        str2 = null;
        try {
            bArr = PluginBaseInfoHelper.Base64Helper.decode(str, 0);
        } catch (Exception e16) {
            QLog.d("SocialWeeklyWebViewPlugin", 1, "decodeAndSaveSharePic BASE64 decode fail! base64Str=" + str, e16);
            bArr = null;
        }
        try {
            if (bArr != null) {
                try {
                    if ("mounted".equals(Environment.getExternalStorageState())) {
                        cacheDir = new File(AppConstants.SDCARD_PATH);
                    } else {
                        cacheDir = BaseApplicationImpl.getApplication().getCacheDir();
                    }
                    File file2 = new File(cacheDir, "SocialWeekly");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    file = new File(file2, MD5.toMD5(bArr));
                    if (file.exists()) {
                        file.delete();
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    } catch (Exception e17) {
                        e = e17;
                        bufferedOutputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = null;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    e = e18;
                    fileOutputStream = null;
                    bufferedOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream = null;
                    if (fileOutputStream2 != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
                try {
                    try {
                        bufferedOutputStream.write(bArr);
                        str2 = file.getAbsolutePath();
                        fileOutputStream.close();
                    } catch (Throwable th7) {
                        th = th7;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Exception unused) {
                                throw th;
                            }
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e19) {
                    e = e19;
                    QLog.d("SocialWeeklyWebViewPlugin", 1, "decodeAndSaveSharePic file save fail!", e);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
                bufferedOutputStream.close();
            }
        } catch (Exception unused2) {
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "SocialWeekly";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        int indexOf;
        if (QLog.isColorLevel()) {
            QLog.d("SocialWeeklyWebViewPlugin", 2, String.format("handleJsRequest pkgName=%s method=%s url=%s", str2, str3, str));
        }
        if (!"SocialWeekly".equals(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str) || !"sharePicMessage".equals(str3)) {
            return false;
        }
        try {
            JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
            if (jsonFromJSBridge != null) {
                String string = jsonFromJSBridge.getString("imageData");
                if (!TextUtils.isEmpty(string) && (indexOf = string.indexOf(44)) > 0) {
                    final String substring = string.substring(indexOf);
                    postPluginAsyncTask(new Runnable() { // from class: com.tencent.mobileqq.webviewplugin.SocialWeeklyWebViewPlugin.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SocialWeeklyWebViewPlugin socialWeeklyWebViewPlugin = SocialWeeklyWebViewPlugin.this;
                            socialWeeklyWebViewPlugin.f315032d = socialWeeklyWebViewPlugin.r(substring);
                        }
                    });
                }
            }
        } catch (Exception e16) {
            QLog.d("SocialWeeklyWebViewPlugin", 1, "handleJsRequest json parse fail!", e16);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    protected void onPostPluginAsyncTask() {
        Activity a16;
        if (QLog.isColorLevel()) {
            QLog.d("SocialWeeklyWebViewPlugin", 2, "onPostPluginAsyncTask mSharePicLocalPath=" + this.f315032d);
        }
        if (TextUtils.isEmpty(this.f315032d) || (a16 = this.mRuntime.a()) == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(a16, ForwardRecentActivity.class);
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, this.f315032d);
        intent.putExtra("isFromShare", true);
        a16.startActivity(intent);
    }
}
