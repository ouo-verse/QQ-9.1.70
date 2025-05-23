package ok1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes13.dex */
public class f extends c {
    public static String r(String str) {
        int indexOf = str.indexOf("guildFeedPublish/localMedia");
        if (indexOf < 0) {
            return null;
        }
        return str.substring(indexOf + 27);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NonNull
    public String getNameSpace() {
        return "guildfeed";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        String c16;
        if (!TextUtils.isEmpty(str) && j3 == 8) {
            s(str);
            if (str.startsWith("https://qun.qq.com/")) {
                c16 = r(str);
            } else {
                c16 = com.tencent.mobileqq.guild.picload.e.a().c(new Option().setUrl(str));
            }
            if (TextUtils.isEmpty(c16)) {
                return null;
            }
            try {
                File file = new File(URLDecoder.decode(c16, "utf-8"));
                if (file.exists() && file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    QLog.e("GuildFeedJsPlugin", 1, "load local cache, url=" + str + ",localFile=" + file.getAbsolutePath());
                    return new WebResourceResponse("image/*", "utf-8", fileInputStream);
                }
                return null;
            } catch (Exception e16) {
                QLog.e("GuildFeedJsPlugin", 1, "handleEvent fail, e=" + e16);
            }
        }
        return null;
    }

    @Override // ok1.c
    @NonNull
    protected b p() {
        return new pk1.a();
    }

    @Override // ok1.c
    @NonNull
    protected String q() {
        return "GuildFeedJsPlugin";
    }

    private void s(String str) {
    }
}
