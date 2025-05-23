package cooperation.vip.tianshu.js;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.vassplash.common.c;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ad.i;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes28.dex */
public class TianShuWebPlugin extends WebViewPlugin {
    private static final String METHOD_SPLASH_VIDEO_FILE_PATH = "splashVideoFilePath";
    public static final String NAMESPACE = "TianShu";
    private static final String PARAM_KEY_CALLBACK = "callback";
    private static final String PARAM_KEY_FILE_PATH = "filePath";
    private static final String PARAM_KEY_VIDEO_URL = "videoUrl";
    private static final String TAG = "TianShuWebPlugin";
    private static final String VIDEO_FILE_FOLDER_NAME = "video/";

    private void handleSplashVideoFilePathMethod(String[] strArr) {
        QLog.d(TAG, 1, "handleSplashVideoFilePathMethod  args = " + Arrays.toString(strArr));
        if (strArr != null && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("videoUrl");
                String optString2 = jSONObject.optString("callback");
                String videoUrlTransferFilePath = videoUrlTransferFilePath(optString);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("filePath", videoUrlTransferFilePath);
                callJs(optString2, jSONObject2.toString());
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "handleSplashVideoFilePathMethod  e = " + e16);
            }
        }
    }

    private String videoUrlTransferFilePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = VFSAssistantUtils.getSDKPrivatePath(c.f312373a) + "video/" + str.hashCode() + i.c(str);
        boolean fileExists = RFWFileUtils.fileExists(str2);
        QLog.i(TAG, 1, "videoUrlTransferFilePath   | videoUrl = " + str + " | filePath = " + str2 + " | isFileExist = " + fileExists);
        if (!fileExists) {
            return "";
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NonNull
    public String getNameSpace() {
        return "TianShu";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str2, "TianShu") || !TextUtils.equals(METHOD_SPLASH_VIDEO_FILE_PATH, str3)) {
            return false;
        }
        handleSplashVideoFilePathMethod(strArr);
        return true;
    }
}
