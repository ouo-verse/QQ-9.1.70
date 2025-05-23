package com.tencent.proxyinner.plugin.loader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wt0.a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\u000b\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/proxyinner/plugin/loader/PluginToolProcessService;", "Landroid/app/Service;", "", "a", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "", WadlProxyConsts.FLAGS, "startId", "onStartCommand", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "d", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "log", "<init>", "()V", "e", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PluginToolProcessService extends Service {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/proxyinner/plugin/loader/PluginToolProcessService$a;", "", "", "ACTION_PRELOAD_ICGAME_ROOM", "Ljava/lang/String;", "TAG", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.proxyinner.plugin.loader.PluginToolProcessService$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50084);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PluginToolProcessService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
    }

    private final void a() {
        a.d(false);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, intent, Integer.valueOf(flags), Integer.valueOf(startId))).intValue();
        }
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.log.i("PluginToolService", "onStartCommand action: " + str);
        if (Intrinsics.areEqual("action_preload_icgame_room", str)) {
            a();
        }
        return 2;
    }
}
