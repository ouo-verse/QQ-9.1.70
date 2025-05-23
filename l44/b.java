package l44;

import android.net.Uri;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u000f"}, d2 = {"Ll44/b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "getNameSpace", "nameSpace", "", "getWebViewSchemaByNameSpace", "url", ZPlanPublishSource.FROM_SCHEME, "", "handleSchemaRequest", "<init>", "()V", "d", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        return "robotProfile";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(@Nullable String nameSpace) {
        return 3L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(@Nullable String url, @Nullable String scheme) {
        boolean startsWith$default;
        boolean z16;
        if (url != null) {
            boolean z17 = false;
            String str = null;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https://app.qun.qq.com/cgi-bin/api/inner_thirdrobotset", false, 2, null);
            if (startsWith$default) {
                String queryParameter = Uri.parse(url).getQueryParameter("bkn");
                SwiftBrowserCookieMonster s16 = SwiftBrowserCookieMonster.s(url);
                if (s16 != null) {
                    str = s16.f314209a;
                }
                String i3 = RobotProfileUtils.f368193a.i(str);
                if (queryParameter != null && queryParameter.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    if (i3.length() > 0) {
                        z17 = true;
                    }
                    if (z17 && !Intrinsics.areEqual(queryParameter, i3)) {
                        String replace = new Regex("(bkn=[^&]*)").replace(url, "bkn=" + i3);
                        QLog.d("RobotProfilePlugin", 1, "bkn changed, newUrl=" + replace);
                        CustomWebView e16 = this.mRuntime.e();
                        if (e16 != null) {
                            e16.loadUrl(replace);
                        }
                        return true;
                    }
                }
            }
        }
        return super.handleSchemaRequest(url, scheme);
    }
}
