package gd;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0004\u00a8\u0006\u0010"}, d2 = {"Lgd/a;", "", "", "configKey", "", "value", "", "e", RemoteHandleConst.PARAM_DEFAULT_VALUE, "c", "", "d", "a", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f401926a = new a();

    a() {
    }

    public final int a(String configKey, int defaultValue) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        if (!b()) {
            return defaultValue;
        }
        return u5.c.h("QZONE_DEBUG_KEY_" + configKey, defaultValue);
    }

    public final boolean b() {
        return !((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion() || ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion();
    }

    public final boolean c(String configKey, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        if (!b()) {
            return defaultValue;
        }
        return u5.c.f("QZONE_DEBUG_KEY_" + configKey, defaultValue);
    }

    public final void d(String configKey, int value) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        u5.c.D("QZONE_DEBUG_KEY_" + configKey, value);
    }

    public final void e(String configKey, boolean value) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        u5.c.B("QZONE_DEBUG_KEY_" + configKey, value);
    }
}
