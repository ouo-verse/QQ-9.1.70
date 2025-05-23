package com.tencent.rdelivery.reshub.processor;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.rdelivery.reshub.FileSuffix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0014J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0014J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/c;", "Lcom/tencent/rdelivery/reshub/processor/DownloadProcessor;", "", "p", "", "getPriority", "k", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Ljz3/e;", "curConfig", "l", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "", "i", "r", "Lcom/tencent/rdelivery/reshub/report/a;", "error", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class c extends DownloadProcessor {
    @Override // com.tencent.rdelivery.reshub.processor.DownloadProcessor, com.tencent.rdelivery.reshub.processor.a
    public int getPriority() {
        return 530;
    }

    @Override // com.tencent.rdelivery.reshub.processor.DownloadProcessor, com.tencent.rdelivery.reshub.processor.a
    public void i(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        jz3.e resConfig = req.getResConfig();
        if (resConfig != null) {
            if (!resConfig.k()) {
                jz3.d.e("CompOrigFileDownload", "proceed return for not compOrigFile");
                chain.c(req);
            } else {
                super.i(req, chain);
            }
        }
    }

    @Override // com.tencent.rdelivery.reshub.processor.DownloadProcessor
    protected int k() {
        return 3;
    }

    @Override // com.tencent.rdelivery.reshub.processor.DownloadProcessor
    @Nullable
    protected String l(@NotNull jz3.e curConfig) {
        Intrinsics.checkParameterIsNotNull(curConfig, "curConfig");
        return curConfig.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.rdelivery.reshub.processor.DownloadProcessor
    public int m() {
        return 14;
    }

    @Override // com.tencent.rdelivery.reshub.processor.DownloadProcessor
    protected int n() {
        return 210;
    }

    @Override // com.tencent.rdelivery.reshub.processor.DownloadProcessor
    protected int o() {
        return 12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.rdelivery.reshub.processor.DownloadProcessor
    @NotNull
    public String p() {
        return "CompOrigFileDownload";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.rdelivery.reshub.processor.DownloadProcessor
    public void q(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain, @NotNull com.tencent.rdelivery.reshub.report.a error) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Intrinsics.checkParameterIsNotNull(error, "error");
        jz3.d.a("CompOrigFileDownload", "onDownloadError " + error);
        a.h(this, m(), req, error, 0L, 0L, 24, null);
        chain.c(req);
    }

    @Override // com.tencent.rdelivery.reshub.processor.DownloadProcessor
    @NotNull
    protected String r(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull jz3.e curConfig) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(curConfig, "curConfig");
        String k3 = jz3.b.k(req);
        if (curConfig.f411273n == 1) {
            k3 = k3 + FileSuffix.ENCRYPT_FILE;
            if (curConfig.k()) {
                k3 = k3 + FileSuffix.COMP_ORIG_FILE;
            }
        } else if (curConfig.k()) {
            k3 = k3 + FileSuffix.COMP_ORIG_FILE;
        }
        curConfig.J = k3;
        return k3;
    }
}
