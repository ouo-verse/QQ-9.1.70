package cooperation.qzone.webviewplugin.mood;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneSelectMoodPictureJsPlugin extends WebViewPlugin {
    public static final String KEY_WEB_PICTURE_ATTACHINFO = "mood_web_pic_attachinfo";
    public static final String KEY_WEB_PICTURE_HEIGHT = "mood_web_pic_height";
    public static final String KEY_WEB_PICTURE_ID = "mood_web_pic_id";
    public static final String KEY_WEB_PICTURE_SOURCEID = "mood_web_pic_sourceid";
    public static final String KEY_WEB_PICTURE_URL = "mood_web_pic_url";
    public static final String KEY_WEB_PICTURE_WIDTH = "mood_web_pic_width";
    public static final String MUSIC_METHOD_NAMESPACE = "QzMoodSelectPicture";
    public static final String select_picture_func_name = "selectPicture";
    private String TAG = QzoneSelectMoodPictureJsPlugin.class.getSimpleName();

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "QzMoodSelectPicture";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!str2.equals("QzMoodSelectPicture") || !str3.equals("selectPicture") || strArr == null || strArr.length <= 0) {
            return false;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            bundle.putString("mood_web_pic_url", jSONObject.getString("url"));
            bundle.putString("mood_web_pic_id", jSONObject.getString("imageId"));
            bundle.putInt("mood_web_pic_width", jSONObject.getInt("width"));
            bundle.putInt("mood_web_pic_height", jSONObject.getInt("height"));
            bundle.putInt("mood_web_pic_sourceid", jSONObject.optInt("sourceid"));
            bundle.putString("mood_web_pic_attachinfo", jSONObject.getString("quickselect"));
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(this.TAG, 2, "select mood picture,decode param error");
            }
        }
        intent.putExtras(bundle);
        if (this.mRuntime.a() == null) {
            return true;
        }
        this.mRuntime.a().setResult(-1, intent);
        this.mRuntime.a().finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("url", "https://www.baidu.com");
        intent.putExtras(bundle);
        this.mRuntime.a().setResult(50, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
    }
}
