package ca3;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lca3/f;", "Lz93/e;", "Landroid/content/Context;", "context", "", "a", "", "b", "url", "needPreloadBID", "preloadWebView", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f implements z93.e {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            QLog.d("QQWinkResourceApiImpl", 2, "offline url:" + str);
            HtmlOffline.k(str, peekAppRuntime, new b(), true, 0, true);
        }
    }

    @Override // z93.e
    public boolean a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return com.tencent.mobileqq.guild.util.qqui.e.a(context);
    }

    @Override // z93.e
    @NotNull
    public String b() {
        IRuntimeService runtimeService = com.tencent.mobileqq.wink.b.a().getRuntimeService(IProfileDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface().getRun\u2026ssConstant.MAIN\n        )");
        Card profileCard = ((IProfileDataService) runtimeService).getProfileCard(com.tencent.mobileqq.wink.b.a().getCurrentUin(), false);
        if (profileCard == null || TextUtils.isEmpty(profileCard.strNick)) {
            return "";
        }
        String str = profileCard.strNick;
        Intrinsics.checkNotNullExpressionValue(str, "{\n            card.strNick\n        }");
        return str;
    }

    @Override // z93.e
    public boolean preloadWebView(@Nullable String url, boolean needPreloadBID) {
        AppRuntime peekAppRuntime;
        if (!TextUtils.isEmpty(url)) {
            final String queryParameter = Uri.parse(url).getQueryParameter("_bid");
            if (needPreloadBID && !TextUtils.isEmpty(queryParameter)) {
                ThreadManagerV2.excute(new Runnable() { // from class: ca3.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.d(queryParameter);
                    }
                }, 16, null, true);
            }
        }
        if (!QzoneConfig.getWinkPreloadWebViewOnLowDevice() && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IWebProcessManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026nt.MAIN\n                )");
            if (!((IWebProcessManagerService) runtimeService).isNeedPreloadWebProcess()) {
                return false;
            }
        }
        ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).preloadWebProcess(3, null);
        return true;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"ca3/f$b", "Lcom/tencent/biz/common/offline/a;", "", "param1", "", "code", "", "loaded", "progress", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements com.tencent.biz.common.offline.a {
        b() {
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(@Nullable String param1, int code) {
            QLog.d("QQWinkResourceApiImpl", 2, "offline url loaded code = " + code);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int progress) {
        }
    }
}
