package hu3;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lhu3/a;", "", "", "appId", "", "c", "a", "b", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f406343a = new a();

    a() {
    }

    @JvmStatic
    public static final boolean c(@Nullable String appId) {
        boolean z16;
        WnsConfigProxy wnsConfigProxy;
        if (appId != null && appId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class)) == null) {
            return false;
        }
        return wnsConfigProxy.getWebgl2Enable(appId, false);
    }

    public final boolean a() {
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        boolean z16 = false;
        if (wnsConfigProxy != null) {
            z16 = wnsConfigProxy.getToggleEnableStatus("MinigamePremultipliedAlpha", false);
        }
        QMLog.i("GameToggleConfig", "isEnablePremultipliedAlpha val = " + z16);
        return z16;
    }

    public final boolean b() {
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        if (wnsConfigProxy != null) {
            return wnsConfigProxy.isWebAudioEnable();
        }
        return false;
    }
}
