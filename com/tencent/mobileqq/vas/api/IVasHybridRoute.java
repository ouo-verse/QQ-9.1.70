package com.tencent.mobileqq.vas.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\bg\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u001aJ\b\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J \u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&J3\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH&\u00a2\u0006\u0004\b\u000b\u0010\u0010J3\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH&\u00a2\u0006\u0004\b\u0011\u0010\u0010J0\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013H&J0\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00072\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0007H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasHybridRoute;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "", "isEnable", "Landroid/content/Context;", "context", "", "url", "", "openSchema", "openBrowser", "Landroid/os/Bundle;", "extra", "", "requestCode", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;Landroid/os/Bundle;)V", "openTranslucentBrowser", "pageName", "", "params", "openKuikly", QZoneDTLoginReporter.SCHEMA, "openKuiklySchema", "interceptUrl", "Companion", "a", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasHybridRoute extends QRouteApi, IVasManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f308451a;

    @NotNull
    public static final String KEY_OPEN_VAS_PAGE_TIME = "startOpenPageTime";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasHybridRoute$a;", "", "<init>", "()V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.api.IVasHybridRoute$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f308451a = new Companion();

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class b {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IVasHybridRoute iVasHybridRoute, Context context, String str, Map map, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    map = null;
                }
                iVasHybridRoute.openKuiklySchema(context, str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openKuiklySchema");
        }
    }

    boolean interceptUrl(@NotNull Context context, @NotNull String params);

    boolean isEnable();

    void openBrowser(@NotNull Context context, @NotNull String url);

    void openBrowser(@NotNull Context context, @NotNull String url, @NotNull Bundle extra);

    void openBrowser(@NotNull Context context, @NotNull String url, @Nullable Integer requestCode, @Nullable Bundle extra);

    void openKuikly(@NotNull Context context, @NotNull String pageName, @Nullable Map<String, String> params);

    void openKuiklySchema(@NotNull Context context, @NotNull String schema, @Nullable Map<String, String> params);

    void openSchema(@Nullable Context context, @NotNull String url);

    void openTranslucentBrowser(@NotNull Context context, @NotNull String url, @Nullable Integer requestCode, @Nullable Bundle extra);
}
