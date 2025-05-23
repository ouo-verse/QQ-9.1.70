package nn1;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f420529a;

    a() {
    }

    public static a b() {
        if (f420529a == null) {
            synchronized (a.class) {
                if (f420529a == null) {
                    f420529a = new a();
                }
            }
        }
        return f420529a;
    }

    public WebViewTitleStyle a(Context context) {
        WebViewTitleStyle webViewTitleStyle = new WebViewTitleStyle();
        if (context == null) {
            QLog.d("GuildFeedPublishStyleFactory", 1, "context is null return default");
            return webViewTitleStyle;
        }
        webViewTitleStyle.f313797d = ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(context, R.color.qui_common_bg_bottom_light);
        webViewTitleStyle.f313798e = ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(context, R.color.qui_common_bg_bottom_light);
        return webViewTitleStyle;
    }
}
