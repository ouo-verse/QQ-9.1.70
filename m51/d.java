package m51;

import android.os.Bundle;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.proxy.HostNotifyProxy;
import com.tencent.minibox.proxy.MiniBoxProxy;
import com.tencent.minibox.proxy.ProxyRef;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lm51/d;", "", "Ljava/io/File;", "libDir", "", "a", "<init>", "()V", "MiniBoxCommon_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f416182a = new d();

    d() {
    }

    public final void a(@NotNull File libDir) {
        HostNotifyProxy hostNotifyProxy;
        boolean endsWith$default;
        Intrinsics.checkParameterIsNotNull(libDir, "libDir");
        MiniBoxProxy proxyHolder = ProxyRef.getProxyHolder();
        if (proxyHolder != null) {
            hostNotifyProxy = proxyHolder.getHostNotifyProxy();
        } else {
            hostNotifyProxy = null;
        }
        if (hostNotifyProxy == null) {
            LogUtils.e("SoUtil", "registerSo: hostNotifyProxy is null.");
            return;
        }
        if (!libDir.exists()) {
            LogUtils.e("SoUtil", "registerSo: libDir is not exists.");
            return;
        }
        File[] listFiles = libDir.listFiles();
        if (listFiles != null) {
            for (File it : listFiles) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                String name = it.getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "it.name");
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(name, ".so", false, 2, null);
                if (endsWith$default) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key_so_path", it.getAbsolutePath());
                    hostNotifyProxy.notifyHost("minibox_register_so", bundle);
                }
            }
        }
    }
}
