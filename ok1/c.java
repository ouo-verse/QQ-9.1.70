package ok1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class c extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private Map<String, a> f423066d;

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(q(), 2, "getWebViewEventByNameSpace-> ", str);
            return 4294967295L;
        }
        return 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (QLog.isDevelopLevel()) {
            QLog.d(q(), 4, "handleEvent-> ", str, " type: ", Long.toBinaryString(j3), " info: ", String.valueOf(map));
        }
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!TextUtils.equals(getNameSpace(), str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(q(), 1, "handleJsRequest-> ", "url: ", str, str2, " method:", str3, " args:", Arrays.toString(strArr));
        }
        a aVar = this.f423066d.get(str3);
        if (aVar == null) {
            return true;
        }
        return aVar.n(this, str, str2, str3, strArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f423066d = Collections.unmodifiableMap(p().a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        Iterator<a> it = this.f423066d.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    @NonNull
    protected abstract b p();

    @NonNull
    protected abstract String q();
}
