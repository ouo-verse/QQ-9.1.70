package com.tencent.rdelivery.reshub.processor;

import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/f;", "Lcom/tencent/rdelivery/reshub/processor/a;", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Ljz3/e;", "newConfig", "", "newPath", "k", "", "getPriority", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "", "i", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class f extends a {
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
    
        r9 = kotlin.io.FilesKt__FileTreeWalkKt.walk$default(r9, null, 1, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String k(com.tencent.rdelivery.reshub.core.k req, jz3.e newConfig, String newPath) {
        String str;
        File file;
        FileTreeWalk walk$default;
        File file2;
        boolean z16;
        jz3.e n3 = req.getConfigMap().n(req.x());
        String str2 = null;
        if (n3 != null && jz3.f.e(n3) && Intrinsics.areEqual(n3.f411264e, newConfig.f411264e)) {
            str = n3.H;
            jz3.d.a("CopyDuplicateFile", "findDuplicateFilePath from config, result = " + str);
        } else {
            str = null;
        }
        if (str == null) {
            File parentFile = new File(newPath).getParentFile();
            if (parentFile != null) {
                file = parentFile.getParentFile();
            } else {
                file = null;
            }
            if (file != null && walk$default != null) {
                Iterator<File> it = walk$default.iterator();
                while (true) {
                    if (it.hasNext()) {
                        file2 = it.next();
                        File file3 = file2;
                        if (file3.isFile() && file3.length() == newConfig.f411263d && jz3.c.b(file3.getAbsolutePath(), newConfig.f411265f, newConfig.f411264e)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        file2 = null;
                        break;
                    }
                }
                File file4 = file2;
                if (file4 != null) {
                    str2 = file4.getAbsolutePath();
                }
            }
            jz3.d.a("CopyDuplicateFile", "findDuplicateFilePath from dir, result = " + str2);
            return str2;
        }
        return str;
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public int getPriority() {
        return ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID;
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public void i(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain) {
        Object m476constructorimpl;
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        jz3.e resConfig = req.getResConfig();
        if (resConfig != null) {
            String k3 = jz3.b.k(req);
            com.tencent.rdelivery.reshub.util.c cVar = new com.tencent.rdelivery.reshub.util.c(req);
            cVar.b();
            long currentTimeMillis = System.currentTimeMillis();
            String k16 = k(req, resConfig, k3);
            jz3.d.a("CopyDuplicateFile", "proceed, findDuplicateFilePath cost:" + (System.currentTimeMillis() - currentTimeMillis));
            cVar.c();
            if (k16 != null) {
                com.tencent.rdelivery.reshub.util.c cVar2 = new com.tencent.rdelivery.reshub.util.c(req);
                cVar2.b();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    if (!jz3.c.b(k3, resConfig.f411265f, resConfig.f411264e)) {
                        FilesKt__UtilsKt.copyTo$default(new File(k16), new File(k3), true, 0, 4, null);
                        jz3.d.e("CopyDuplicateFile", "proceed, local is duplicate, old:" + k16 + ",new:" + k3);
                        if (jz3.c.b(k3, resConfig.f411265f, resConfig.f411264e)) {
                            jz3.d.e("CopyDuplicateFile", "proceed, set originLocal");
                            resConfig.H = k3;
                        } else {
                            jz3.c.g(k3, true);
                        }
                    } else {
                        resConfig.H = k3;
                    }
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    jz3.d.c("CopyDuplicateFile", "proceed err: " + m479exceptionOrNullimpl);
                }
                cVar2.c();
            }
            chain.c(req);
            return;
        }
        j(chain, req, 210);
    }
}
