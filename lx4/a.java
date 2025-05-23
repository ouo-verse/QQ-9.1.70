package lx4;

import android.content.Context;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0002H'J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\rH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0013"}, d2 = {"Llx4/a;", "", "", "getNetWorkType", "getCarrier", "", "getImei", "c", "getGender", "userId", "Landroid/content/Context;", "getContext", "a", "", "isDebugVersion", "getCurrentUin", "b", "", "getServerTime", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {
    @NotNull
    String a();

    boolean b();

    @NotNull
    String c();

    int getCarrier();

    @NotNull
    Context getContext();

    @Nullable
    String getCurrentUin();

    @Deprecated(message = "\u4f7f\u7528 getGender(userId: String): Int \u63a5\u53e3")
    int getGender();

    int getGender(@NotNull String userId);

    @NotNull
    String getImei();

    int getNetWorkType();

    long getServerTime();

    boolean isDebugVersion();
}
