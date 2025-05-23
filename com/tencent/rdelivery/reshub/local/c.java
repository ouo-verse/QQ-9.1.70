package com.tencent.rdelivery.reshub.local;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.rdelivery.reshub.core.g;
import com.tencent.rdelivery.reshub.core.j;
import com.tencent.rdelivery.reshub.report.ReportHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/rdelivery/reshub/local/c;", "", "", "errMsg", "", "d", "Ljz3/e;", DownloadInfo.spKey_Config, "", "validateResFile", "c", "a", "b", "Lcom/tencent/rdelivery/reshub/core/a;", "Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "<init>", "(Lcom/tencent/rdelivery/reshub/core/a;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.rdelivery.reshub.core.a appInfo;

    public c(@NotNull com.tencent.rdelivery.reshub.core.a appInfo) {
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        this.appInfo = appInfo;
    }

    private final void d(String errMsg) {
        ReportHelper reportHelper = new ReportHelper();
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(11001);
        aVar.g(errMsg);
        reportHelper.b(aVar);
    }

    @Nullable
    public final String a(@NotNull jz3.e config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (config.f411278s == 1) {
            String str = "Res(" + config.f411260a + ") Local Version is Closed, LocalVer: " + config.f411261b;
            jz3.d.c("LocalResValidator", str);
            return str;
        }
        String str2 = config.f411260a;
        Intrinsics.checkExpressionValueIsNotNull(str2, "config.id");
        int g16 = g.g(str2, this.appInfo);
        if (config.f411261b < g16) {
            String str3 = "Res(" + config.f411260a + ") Local Version Not Usable, MinVer: " + g16 + " LocalVer: " + config.f411261b;
            jz3.d.c("LocalResValidator", str3);
            return str3;
        }
        if (!com.tencent.rdelivery.reshub.util.a.b(config, j.L.e(this.appInfo))) {
            String str4 = "Res(" + config.f411260a + ") Max App Version Not Satisfy.";
            jz3.d.c("LocalResValidator", str4);
            return str4;
        }
        return null;
    }

    @Nullable
    public final String b(@NotNull jz3.e config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (!config.h(this.appInfo)) {
            String str = "Res(" + config.f411260a + ") Local File Invalid: " + config.G;
            jz3.d.c("LocalResValidator", str);
            d(str);
            return str;
        }
        return null;
    }

    @Nullable
    public final String c(@NotNull jz3.e config, boolean validateResFile) {
        String b16;
        Intrinsics.checkParameterIsNotNull(config, "config");
        String a16 = a(config);
        if (a16 != null) {
            return a16;
        }
        if (validateResFile && (b16 = b(config)) != null) {
            return b16;
        }
        return null;
    }
}
