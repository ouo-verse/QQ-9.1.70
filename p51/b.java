package p51;

import com.tencent.BuildConfig;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lp51/b;", "", "", "callerPackageName", "", "a", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f425345a = new b();

    b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(@Nullable String callerPackageName) {
        boolean z16;
        boolean startsWith$default;
        boolean isBlank;
        if (callerPackageName != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(callerPackageName);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(callerPackageName, BuildConfig.LIBRARY_PACKAGE_NAME, false, 2, null);
                    if (startsWith$default) {
                        return true;
                    }
                }
                return false;
            }
        }
        z16 = true;
        if (!z16) {
        }
        return false;
    }
}
