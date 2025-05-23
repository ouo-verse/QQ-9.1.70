package gv0;

import android.content.Context;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lgv0/b;", "", "", "c", "Landroid/content/Context;", "context", "", "a", "b", "Z", "autoPlayIn4G", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f403419a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean autoPlayIn4G = rx0.a.b("live_auto_play_when_4g", false);

    b() {
    }

    public final boolean a(@NotNull Context context) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (HwNetworkUtil.isMobileNetWork(context) && !autoPlayIn4G) {
            z16 = false;
        } else {
            z16 = true;
        }
        g.g("ICGameWifiOr4GStateHolder", 1, "canPlayIn4G: " + z16 + " " + autoPlayIn4G);
        return z16;
    }

    public final boolean b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return HwNetworkUtil.isMobileNetWork(context);
    }

    public final void c() {
        autoPlayIn4G = true;
        rx0.a.h("live_auto_play_when_4g", true);
    }
}
