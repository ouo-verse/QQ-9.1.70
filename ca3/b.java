package ca3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lca3/b;", "Lz93/b;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "jumpToQQWinkHome", "Landroid/content/Intent;", "intent", "a", "c", "d", "b", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b implements z93.b {
    @Override // z93.b
    public void a(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        com.tencent.mobileqq.wink.g.f322861a.m(context, intent);
    }

    @Override // z93.b
    public void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            w53.b.f("QQWinkNavigateApiImpl", "[stopPreLoadWebView]");
            context.stopService(new Intent(context, (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPreloadWebServiceClass()));
        } catch (Throwable th5) {
            w53.b.d("QQWinkNavigateApiImpl", "[stopPreLoadWebView], error=", th5);
        }
    }

    @Override // z93.b
    public void c(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.setClassName(context, QQBrowserActivity.class.getName());
        intent.putExtra("titleBarStyle", 7);
        context.startActivity(intent);
    }

    @Override // z93.b
    public void d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        w53.b.f("QQWinkNavigateApiImpl", "[preLoadWebView]");
        boolean isQQWinkVideoMusicUseWNSUrl = QzoneConfig.isQQWinkVideoMusicUseWNSUrl();
        String str = QQWinkConstants.QWINK_LOAD_QQ_MUSIC_URL;
        if (isQQWinkVideoMusicUseWNSUrl) {
            str = QzoneConfig.getWinkEditorEditedMusicUrl(QQWinkConstants.QWINK_LOAD_QQ_MUSIC_URL);
        }
        try {
            Intent intent = new Intent(context, (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPreloadWebServiceClass());
            intent.putExtra("url", str);
            context.startService(intent);
        } catch (Throwable th5) {
            w53.b.d("QQWinkNavigateApiImpl", "[preLoadWebView], error=", th5);
        }
    }

    @Override // z93.b
    public void jumpToQQWinkHome(@NotNull Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        com.tencent.mobileqq.wink.g.f322861a.d(context, bundle);
    }
}
