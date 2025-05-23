package com.tencent.rdelivery.reshub.processor;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.rdelivery.reshub.FileSuffix;
import com.tencent.rdelivery.reshub.download.ResProcessorDownloader;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0014J\b\u0010\u0011\u001a\u00020\rH\u0014J\b\u0010\u0012\u001a\u00020\rH\u0014J\b\u0010\u0013\u001a\u00020\rH\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\u0002H\u0014J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014J \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/DownloadProcessor;", "Lcom/tencent/rdelivery/reshub/processor/a;", "Ljz3/e;", "resConfig", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/rdelivery/reshub/core/k;", "req", "curConfig", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "", "t", "", "getPriority", "i", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "k", "", "p", "l", "r", "Lcom/tencent/rdelivery/reshub/report/a;", "error", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class DownloadProcessor extends a {
    private final boolean s(jz3.e resConfig) {
        if (jz3.f.e(resConfig) && resConfig.g()) {
            jz3.d.e(p(), "Local Res File Exist, Skip Download. Path: " + resConfig.H);
            return true;
        }
        if (resConfig.f411273n == 1 && jz3.f.c(resConfig) && jz3.f.a(resConfig)) {
            jz3.d.i(p(), "Encrypted Res File Exist, Skip Download. Path: " + resConfig.I);
            return true;
        }
        return false;
    }

    private final void t(final com.tencent.rdelivery.reshub.core.k req, final jz3.e curConfig, final l chain) {
        String str;
        Map<String, String> map;
        String str2;
        a.h(this, o(), req, null, 0L, 0L, 24, null);
        final String r16 = r(req, curConfig);
        final com.tencent.rdelivery.reshub.util.c cVar = new com.tencent.rdelivery.reshub.util.c(req);
        cVar.b();
        if (s(curConfig)) {
            cVar.c();
            chain.c(req);
            return;
        }
        String l3 = l(curConfig);
        String str3 = "";
        if (l3 == null) {
            str = "";
        } else {
            str = l3;
        }
        jz3.d.e(p(), "Start Downloading Full Res(" + req.x() + "): " + str + ",path: " + r16);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        jz3.e resConfig = req.getResConfig();
        if (resConfig != null && (str2 = resConfig.f411268i) != null) {
            str3 = str2;
        }
        linkedHashMap.put("res_type", str3);
        linkedHashMap.put(IPreloadServiceProxy.KEY_RESID, req.x());
        linkedHashMap.put(VRReportDefine$ReportParam.DOWNLOAD_TYPE, String.valueOf(k()));
        ResProcessorDownloader resProcessorDownloader = new ResProcessorDownloader(this, k());
        long j3 = curConfig.f411263d;
        map = MapsKt__MapsKt.toMap(linkedHashMap);
        final String str4 = str;
        resProcessorDownloader.f(req, str, r16, j3, map, new Function1<com.tencent.rdelivery.reshub.report.a, Unit>() { // from class: com.tencent.rdelivery.reshub.processor.DownloadProcessor$tryDownload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.rdelivery.reshub.report.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.rdelivery.reshub.report.a errorInfo) {
                Intrinsics.checkParameterIsNotNull(errorInfo, "errorInfo");
                cVar.c();
                if (errorInfo.d()) {
                    DownloadProcessor downloadProcessor = DownloadProcessor.this;
                    a.h(downloadProcessor, downloadProcessor.m(), req, new com.tencent.rdelivery.reshub.report.a(), 0L, curConfig.f411263d, 8, null);
                    jz3.d.e(DownloadProcessor.this.p(), "Download Full Res(" + req.x() + ") Success: " + str4 + " -> " + r16);
                    chain.c(req);
                    return;
                }
                jz3.d.c(DownloadProcessor.this.p(), "Download Full Res(" + req.x() + ") Fail, Url: " + str4 + " Err: " + com.tencent.rdelivery.reshub.report.c.a(errorInfo));
                DownloadProcessor.this.q(req, chain, errorInfo);
            }
        });
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public int getPriority() {
        return 600;
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public void i(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        jz3.e resConfig = req.getResConfig();
        if (resConfig == null) {
            j(chain, req, n());
            return;
        }
        if (req.getBigResPatchChecked()) {
            chain.c(req);
            return;
        }
        com.tencent.rdelivery.reshub.util.c cVar = new com.tencent.rdelivery.reshub.util.c(req);
        cVar.b();
        if (s(resConfig)) {
            cVar.c();
            chain.c(req);
        } else {
            cVar.c();
            t(req, resConfig, chain);
        }
    }

    protected int k() {
        return 1;
    }

    @Nullable
    protected String l(@NotNull jz3.e curConfig) {
        Intrinsics.checkParameterIsNotNull(curConfig, "curConfig");
        return curConfig.f411266g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int m() {
        return 7;
    }

    protected int n() {
        return 203;
    }

    protected int o() {
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public String p() {
        return "FullDownload";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain, @NotNull com.tencent.rdelivery.reshub.report.a error) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Intrinsics.checkParameterIsNotNull(error, "error");
        a.h(this, m(), req, error, 0L, 0L, 24, null);
        e(false, n(), req, chain, error);
    }

    @NotNull
    protected String r(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull jz3.e curConfig) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(curConfig, "curConfig");
        String k3 = jz3.b.k(req);
        if (curConfig.f411273n == 1) {
            String str = k3 + FileSuffix.ENCRYPT_FILE;
            curConfig.I = str;
            return str;
        }
        curConfig.H = k3;
        return k3;
    }
}
