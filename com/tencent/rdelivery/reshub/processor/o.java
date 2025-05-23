package com.tencent.rdelivery.reshub.processor;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J'\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0010\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/o;", "Lcom/tencent/rdelivery/reshub/processor/a;", "Ljz3/e;", DownloadInfo.spKey_Config, "", "unZipDir", "", "l", "", "getPriority", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "", "i", "withLog", "k", "(Ljz3/e;Ljava/lang/String;Z)Z", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class o extends a {
    private final boolean l(jz3.e config, String unZipDir) {
        boolean z16;
        if (unZipDir != null && unZipDir.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        String str = "ResId: " + config.f411260a + "\n OriginFilePath: " + config.H + "\n UnzippedPath: " + unZipDir;
        boolean k3 = k(config, unZipDir, false);
        if (k3) {
            jz3.d.e("Unzip", "Res Already Unzipped, Ignore Unzipping. " + str);
        } else {
            jz3.d.i("Unzip", "Res Have Unzipped Path, But Not Valid. " + str);
        }
        return k3;
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public int getPriority() {
        return 900;
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public void i(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain) {
        boolean z16;
        String str;
        boolean z17;
        int i3;
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        jz3.e resConfig = req.getResConfig();
        if (resConfig == null) {
            j(chain, req, 204);
            return;
        }
        if (req.getBigResPatchChecked()) {
            chain.c(req);
            return;
        }
        if (!com.tencent.rdelivery.reshub.core.g.j(req)) {
            chain.c(req);
            return;
        }
        com.tencent.rdelivery.reshub.util.c cVar = new com.tencent.rdelivery.reshub.util.c(req);
        cVar.b();
        String str2 = resConfig.G;
        Intrinsics.checkExpressionValueIsNotNull(str2, "config.local");
        boolean z18 = false;
        if (str2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str3 = resConfig.G;
            Intrinsics.checkExpressionValueIsNotNull(str3, "config.local");
            if (!p.d(str3)) {
                String str4 = resConfig.G;
                Intrinsics.checkExpressionValueIsNotNull(str4, "config.local");
                if (l(resConfig, str4)) {
                    jz3.d.e("Unzip", "Skip Unzip for already unzipped");
                    cVar.c();
                    chain.c(req);
                    return;
                }
            }
        }
        String l3 = jz3.b.l(req);
        if (!p.d(l3) && com.tencent.rdelivery.reshub.core.j.L.R() && l(resConfig, l3)) {
            jz3.d.e("Unzip", "Skip Unzip for already unzipped 2");
            cVar.c();
            resConfig.G = l3;
            chain.c(req);
            return;
        }
        a.h(this, 8, req, null, 0L, 0L, 24, null);
        p.c(l3);
        try {
            String str5 = resConfig.H;
            Intrinsics.checkExpressionValueIsNotNull(str5, "config.originLocal");
            if (com.tencent.rdelivery.reshub.core.g.b(str5, l3, false, null, 12, null) == 0) {
                z18 = true;
            }
            z17 = z18;
            str = "Unzip";
        } catch (Exception e16) {
            str = "Unzip";
            jz3.d.d(str, "Unzip Exception: " + e16.getMessage(), e16);
            z17 = false;
        }
        jz3.d.e(str, "Unzip result: " + z17 + ", dir = " + l3);
        boolean k3 = k(resConfig, l3, true);
        if (z17 && k3) {
            p.b(l3);
            cVar.c();
            a.h(this, 9, req, null, 0L, 0L, 24, null);
            resConfig.G = l3;
            chain.c(req);
            return;
        }
        jz3.d.c(str, "Unzip Res File Fail. (Unzip: " + z17 + " MD5Check: " + k3 + "), Delete UnzipDir.  ResId: " + resConfig.f411260a + "\n OriginFilePath: " + resConfig.H + "\n UnzippedPath: " + l3);
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        if (!z17) {
            i3 = 3001;
        } else {
            i3 = 3002;
        }
        aVar.e(i3);
        jz3.c.f(new File(l3), true);
        p.b(l3);
        cVar.c();
        a.h(this, 9, req, aVar, 0L, 0L, 24, null);
        e(false, 204, req, chain, aVar);
    }

    public boolean k(@NotNull jz3.e config, @NotNull String unZipDir, boolean withLog) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        Intrinsics.checkParameterIsNotNull(unZipDir, "unZipDir");
        return jz3.b.d(config.f411271l, config.f411270k, unZipDir, withLog);
    }
}
