package com.tencent.rdelivery.reshub.local;

import com.tencent.rdelivery.reshub.core.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/rdelivery/reshub/local/b;", "", "Ljz3/e;", "newConfig", "curConfig", "", "c", "Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "Lcom/tencent/rdelivery/reshub/local/ResUpdateCheckResult;", "a", "", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    public b(@NotNull String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.name = name;
    }

    public static /* synthetic */ ResUpdateCheckResult b(b bVar, jz3.e eVar, jz3.e eVar2, com.tencent.rdelivery.reshub.core.a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        return bVar.a(eVar, eVar2, aVar);
    }

    private final boolean c(jz3.e newConfig, jz3.e curConfig) {
        boolean z16;
        String str = "For Local(" + this.name + ") Res: " + curConfig.f411260a + ". Ver: " + newConfig.f411261b;
        boolean z17 = false;
        if (!Intrinsics.areEqual(curConfig.f411272m, newConfig.f411272m)) {
            jz3.d.e("ResConfigUpdater", "Refresh FileExtra " + str);
            curConfig.f411272m = newConfig.f411272m;
            z16 = true;
        } else {
            z16 = false;
        }
        if (!Intrinsics.areEqual(curConfig.f411277r, newConfig.f411277r)) {
            jz3.d.e("ResConfigUpdater", "Refresh AppMaxVer(" + curConfig.f411277r + " -> " + newConfig.f411277r + ") " + str);
            curConfig.f411277r = newConfig.f411277r;
            z16 = true;
        }
        if (curConfig.f411278s != newConfig.f411278s) {
            jz3.d.e("ResConfigUpdater", "Refresh ResClose(" + curConfig.f411278s + " -> " + newConfig.f411278s + ") " + str);
            curConfig.f411278s = newConfig.f411278s;
            z16 = true;
        }
        String str2 = newConfig.G;
        if (str2 == null || str2.length() == 0) {
            z17 = true;
        }
        if (!z17 && (!Intrinsics.areEqual(curConfig.G, newConfig.G))) {
            jz3.d.i("ResConfigUpdater", "ResLocalFilePath Modified! " + str + " (" + curConfig.G + " -> " + newConfig.G + ')');
            curConfig.G = newConfig.G;
            z16 = true;
        }
        if (curConfig.f411284y != newConfig.f411284y) {
            jz3.d.e("ResConfigUpdater", "Refresh ForceUpdate(" + curConfig.f411284y + " -> " + newConfig.f411284y + ") " + str);
            curConfig.f411284y = newConfig.f411284y;
            z16 = true;
        }
        if (curConfig.A != newConfig.A) {
            jz3.d.e("ResConfigUpdater", "Refresh NoNeedUnZip(" + curConfig.A + " -> " + newConfig.A + ") " + str);
            curConfig.A = newConfig.A;
            return true;
        }
        return z16;
    }

    @NotNull
    public final ResUpdateCheckResult a(@NotNull jz3.e newConfig, @Nullable jz3.e curConfig, @Nullable com.tencent.rdelivery.reshub.core.a appInfo) {
        Long l3;
        Intrinsics.checkParameterIsNotNull(newConfig, "newConfig");
        String str = newConfig.f411260a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Local(");
        sb5.append(this.name);
        sb5.append(") Res: ");
        sb5.append(str);
        sb5.append(" [CurVer: ");
        if (curConfig != null) {
            l3 = Long.valueOf(curConfig.f411261b);
        } else {
            l3 = null;
        }
        sb5.append(l3);
        sb5.append(" NewVer: ");
        sb5.append(newConfig.f411261b);
        sb5.append(']');
        String sb6 = sb5.toString();
        if (curConfig != null) {
            long j3 = curConfig.f411261b;
            long j16 = newConfig.f411261b;
            if (j3 >= j16) {
                if (j3 == j16) {
                    if (c(newConfig, curConfig)) {
                        jz3.d.e("ResConfigUpdater", "Refreshed Same Version " + sb6);
                        return ResUpdateCheckResult.Refreshed;
                    }
                    jz3.d.e("ResConfigUpdater", "No Need To Update (Same Version) " + sb6);
                    return ResUpdateCheckResult.Same;
                }
                if (appInfo != null && !com.tencent.rdelivery.reshub.util.a.b(curConfig, j.L.e(appInfo))) {
                    jz3.d.e("ResConfigUpdater", "local res invalid, local Will Update " + sb6);
                    return ResUpdateCheckResult.Update;
                }
                if (curConfig.f411285z == 1) {
                    jz3.d.e("ResConfigUpdater", "local res allowAssetDowngrade, local Will Update " + sb6);
                    return ResUpdateCheckResult.Update;
                }
                jz3.d.e("ResConfigUpdater", "Cannot Update (Older Version) " + sb6);
                return ResUpdateCheckResult.Older;
            }
        }
        jz3.d.e("ResConfigUpdater", "Will Update " + sb6);
        return ResUpdateCheckResult.Update;
    }
}
