package o51;

import com.tencent.minibox.common.log.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lo51/c;", "", "", "uin", "Lo51/b;", "a", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f422119a = new c();

    c() {
    }

    @Nullable
    public final RainbowPluginConfig a(@NotNull String uin) {
        String replace$default;
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        try {
            replace$default = StringsKt__StringsJVMKt.replace$default("0.5.2", ".", "_", false, 4, (Object) null);
            String a16 = k51.a.f411715a.a("miniboxplugin." + replace$default);
            if (a16 != null) {
                RainbowPluginConfig rainbowPluginConfig = new RainbowPluginConfig(uin, a16);
                rainbowPluginConfig.i(System.currentTimeMillis());
                if (rainbowPluginConfig.getRetCode() == 0) {
                    return rainbowPluginConfig;
                }
            } else {
                LogUtils.e("PluginConfigHelper", "[pullPluginConfig] failed.");
            }
            return null;
        } catch (Exception e16) {
            LogUtils.e("PluginConfigHelper", "[pullConfig] exception.", e16);
            return null;
        }
    }
}
