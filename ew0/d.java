package ew0;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lew0/d;", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0007R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lew0/d$a;", "", "", "a", "value", "", "b", "", "PREFS_KEY_LIKE_VIBRATE_CONFIG", "Ljava/lang/String;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ew0.d$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a() {
            MMKVOptionEntity from = QMMKV.from(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getApplicationContext(), QMMKVFile.FILE_ICGAME);
            Intrinsics.checkNotNullExpressionValue(from, "from(context, QMMKVFile.FILE_ICGAME)");
            return from.decodeBool("prefs_key_like_vibrate_config", true);
        }

        @JvmStatic
        public final void b(boolean value) {
            MMKVOptionEntity from = QMMKV.from(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getApplicationContext(), QMMKVFile.FILE_ICGAME);
            Intrinsics.checkNotNullExpressionValue(from, "from(context, QMMKVFile.FILE_ICGAME)");
            from.encodeBool("prefs_key_like_vibrate_config", value);
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final boolean a() {
        return INSTANCE.a();
    }

    @JvmStatic
    public static final void b(boolean z16) {
        INSTANCE.b(z16);
    }
}
