package kd2;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.bugly.common.sp.ISharedPreferencesProvider;
import com.tencent.mobileqq.qmmkv.QMMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lkd2/b;", "Lcom/tencent/bugly/common/sp/ISharedPreferencesProvider;", "Landroid/content/Context;", "context", "", "name", "", "supportMultiProcess", "Landroid/content/SharedPreferences;", "getSharedPreferences", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements ISharedPreferencesProvider {
    @Override // com.tencent.bugly.common.sp.ISharedPreferencesProvider
    @NotNull
    public SharedPreferences getSharedPreferences(@NotNull Context context, @NotNull String name, boolean supportMultiProcess) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(context, name, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromSpAdapter, "fromSpAdapter(context, name, FILE_COMMON)");
        return fromSpAdapter;
    }
}
