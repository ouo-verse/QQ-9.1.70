package com.tencent.rdelivery.reshub.processor;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.raft.standard.net.IRDownload;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.rdelivery.reshub.util.PatchUtil;
import com.tencent.rdelivery.reshub.util.ThreadUtil;
import com.tencent.rdelivery.reshub.util.d;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nz3.DiffInfo;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J/\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/TryPatchProcessor;", "Lcom/tencent/rdelivery/reshub/processor/a;", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lnz3/a;", "diffInfo", "Ljz3/e;", "localConfig", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "Lcom/tencent/rdelivery/reshub/util/c;", "fileSync", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "curConfig", "l", "", "getPriority", "i", DomainData.DOMAIN_NAME, "(Lnz3/a;Lcom/tencent/rdelivery/reshub/core/k;Lcom/tencent/rdelivery/reshub/processor/l;Ljz3/e;)V", "<init>", "()V", "patch_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes34.dex */
public class TryPatchProcessor extends com.tencent.rdelivery.reshub.processor.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0006\u001a\n \u0004*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "tag", "", "kotlin.jvm.PlatformType", "msg", ReportConstant.COSTREPORT_TRANS, "", "e"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes34.dex */
    public static final class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f364551a = new a();

        a() {
        }

        @Override // com.tencent.rdelivery.reshub.util.d.a
        public final void e(String str, String str2, Throwable th5) {
            jz3.d.d(str, str2, th5);
        }
    }

    private final jz3.e l(jz3.e curConfig, com.tencent.rdelivery.reshub.core.k req) {
        List<DiffInfo> list = curConfig.f411269j;
        if (list == null) {
            return null;
        }
        Iterator<DiffInfo> it = list.iterator();
        while (it.hasNext()) {
            for (Pair<Long, jz3.e> pair : req.getConfigMap().j(req.x(), it.next().getVersion())) {
                if (pair.getSecond().g()) {
                    jz3.d.a("Patch", "findValidLocalTaskConfig\uff0cresult\uff1a" + pair.getSecond());
                    return pair.getSecond();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(com.tencent.rdelivery.reshub.core.k req, DiffInfo diffInfo, jz3.e localConfig, l chain, com.tencent.rdelivery.reshub.util.c fileSync) {
        File file;
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        try {
            jz3.e resConfig = req.getResConfig();
            try {
                if (resConfig == null) {
                    j(chain, req, 207);
                    fileSync.c();
                    com.tencent.rdelivery.reshub.processor.a.h(this, 4, req, aVar, 0L, diffInfo.getSize(), 8, null);
                    file = new File(diffInfo.getLocalPath());
                } else {
                    String localPath = diffInfo.getLocalPath();
                    if (!jz3.c.b(localPath, diffInfo.getCrc32(), diffInfo.getMd5())) {
                        aVar.e(5006);
                        fileSync.c();
                        com.tencent.rdelivery.reshub.processor.a.h(this, 4, req, aVar, 0L, diffInfo.getSize(), 8, null);
                        file = new File(diffInfo.getLocalPath());
                    } else {
                        String str = localConfig.H;
                        String k3 = jz3.b.k(req);
                        try {
                            jz3.c.o(k3);
                        } catch (Exception e16) {
                            jz3.d.d("Patch", "patchAfterDownload Create or Clear File Failed. Path: " + k3, e16);
                        }
                        com.tencent.rdelivery.reshub.util.d.b(a.f364551a);
                        boolean a16 = PatchUtil.a(str, k3, localPath);
                        boolean b16 = jz3.c.b(k3, resConfig.f411265f, resConfig.f411264e);
                        if (!a16) {
                            aVar.e(5007);
                            jz3.d.c("Patch", "patch\u5305\u5408\u5e76\u5931\u8d25");
                            fileSync.c();
                            com.tencent.rdelivery.reshub.processor.a.h(this, 4, req, aVar, 0L, diffInfo.getSize(), 8, null);
                            file = new File(diffInfo.getLocalPath());
                        } else if (!b16) {
                            aVar.e(5008);
                            jz3.d.c("Patch", "patch\u5305\u5408\u5e76\u540e\uff0c\u6821\u9a8cmd5\u5931\u8d25");
                            fileSync.c();
                            com.tencent.rdelivery.reshub.processor.a.h(this, 4, req, aVar, 0L, diffInfo.getSize(), 8, null);
                            file = new File(diffInfo.getLocalPath());
                        } else {
                            if (a16 && b16) {
                                resConfig.H = k3;
                                resConfig.G = k3;
                                req.H(true);
                                jz3.d.e("Patch", "patch\u5305\u5408\u6210\u529f\uff0c\u4e14md5\u6821\u9a8c\u6210\u529f");
                            }
                            fileSync.c();
                            com.tencent.rdelivery.reshub.processor.a.h(this, 4, req, aVar, 0L, diffInfo.getSize(), 8, null);
                            jz3.c.f(new File(diffInfo.getLocalPath()), true);
                            chain.c(req);
                            return;
                        }
                    }
                }
                jz3.c.f(file, true);
                chain.c(req);
            } catch (Throwable th5) {
                th = th5;
                fileSync.c();
                com.tencent.rdelivery.reshub.processor.a.h(this, 4, req, aVar, 0L, diffInfo.getSize(), 8, null);
                jz3.c.f(new File(diffInfo.getLocalPath()), true);
                chain.c(req);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public int getPriority() {
        return 400;
    }

    public void n(final DiffInfo diffInfo, final com.tencent.rdelivery.reshub.core.k req, final l chain, final jz3.e localConfig) {
        Intrinsics.checkParameterIsNotNull(diffInfo, "diffInfo");
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Intrinsics.checkParameterIsNotNull(localConfig, "localConfig");
        final com.tencent.rdelivery.reshub.util.c cVar = new com.tencent.rdelivery.reshub.util.c(req);
        cVar.b();
        Exception n3 = jz3.b.n(diffInfo.getLocalPath());
        if (n3 != null) {
            cVar.c();
            com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
            aVar.e(5005);
            aVar.f(n3);
            com.tencent.rdelivery.reshub.processor.a.h(this, 4, req, aVar, 0L, 0L, 24, null);
            chain.c(req);
            return;
        }
        ThreadUtil.f364593c.d("ResPatchDownload", req.getPriority(), new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.processor.TryPatchProcessor$startDownloadPatch$2

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/rdelivery/reshub/processor/TryPatchProcessor$startDownloadPatch$2$a", "Lcom/tencent/raft/standard/net/IRDownload$IDownloadCallback;", "Lcom/tencent/raft/standard/net/IRNetwork$ResultInfo;", "info", "", "onComplete", "", "receivedSize", "totalSize", "onProgress", "patch_debug"}, k = 1, mv = {1, 4, 0})
            /* loaded from: classes34.dex */
            public static final class a implements IRDownload.IDownloadCallback {
                a() {
                }

                @Override // com.tencent.raft.standard.net.IRDownload.IDownloadCallback
                public void onComplete(IRNetwork.ResultInfo info) {
                    Intrinsics.checkParameterIsNotNull(info, "info");
                    com.tencent.rdelivery.reshub.report.a d16 = com.tencent.rdelivery.reshub.report.g.d(info, 5001, 5002);
                    if (d16.d()) {
                        jz3.d.e("Patch", "patch\u5305\u4e0b\u8f7d\u6210\u529f\uff1a" + diffInfo.getDownloadUrl());
                        TryPatchProcessor$startDownloadPatch$2 tryPatchProcessor$startDownloadPatch$2 = TryPatchProcessor$startDownloadPatch$2.this;
                        TryPatchProcessor.this.m(req, diffInfo, localConfig, chain, cVar);
                        return;
                    }
                    cVar.c();
                    jz3.d.c("Patch", "patch\u5305\u4e0b\u8f7d\u5931\u8d25\uff1a" + diffInfo.getDownloadUrl() + "\uff0cerr\uff1a" + info.getErrorMessage());
                    TryPatchProcessor$startDownloadPatch$2 tryPatchProcessor$startDownloadPatch$22 = TryPatchProcessor$startDownloadPatch$2.this;
                    com.tencent.rdelivery.reshub.processor.a.h(TryPatchProcessor.this, 4, req, d16, 0L, 0L, 24, null);
                    TryPatchProcessor$startDownloadPatch$2 tryPatchProcessor$startDownloadPatch$23 = TryPatchProcessor$startDownloadPatch$2.this;
                    chain.c(req);
                }

                @Override // com.tencent.raft.standard.net.IRDownload.IDownloadCallback
                public void onProgress(long receivedSize, long totalSize) {
                    TryPatchProcessor$startDownloadPatch$2 tryPatchProcessor$startDownloadPatch$2 = TryPatchProcessor$startDownloadPatch$2.this;
                    TryPatchProcessor.this.g(3, req, null, receivedSize, totalSize);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                Map<String, String> map;
                jz3.d.e("Patch", "\u5f00\u59cb\u4e0b\u8f7dpatch\u5305\uff1a" + diffInfo);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                jz3.e resConfig = req.getResConfig();
                if (resConfig == null || (str = resConfig.f411268i) == null) {
                    str = "";
                }
                linkedHashMap.put("res_type", str);
                linkedHashMap.put(IPreloadServiceProxy.KEY_RESID, req.x());
                linkedHashMap.put(VRReportDefine$ReportParam.DOWNLOAD_TYPE, String.valueOf(2));
                jz3.e resConfig2 = req.getResConfig();
                long j3 = resConfig2 != null ? resConfig2.E : 0L;
                com.tencent.rdelivery.reshub.download.c cVar2 = new com.tencent.rdelivery.reshub.download.c(req.x());
                String downloadUrl = diffInfo.getDownloadUrl();
                String localPath = diffInfo.getLocalPath();
                a aVar2 = new a();
                map = MapsKt__MapsKt.toMap(linkedHashMap);
                cVar2.a(downloadUrl, localPath, aVar2, j3, map);
            }
        });
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public void i(com.tencent.rdelivery.reshub.core.k req, l chain) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        jz3.e resConfig = req.getResConfig();
        if (resConfig == null) {
            j(chain, req, 207);
            return;
        }
        if (jz3.f.d(resConfig)) {
            jz3.d.e("Patch", "proceed localOriginFileAvailable, originLocal = " + resConfig.H);
            chain.c(req);
            return;
        }
        jz3.e m3 = req.getConfigMap().m(req.x());
        if (com.tencent.rdelivery.reshub.core.j.L.u() && (m3 == null || !m3.g())) {
            m3 = l(resConfig, req);
        }
        jz3.e eVar = m3;
        if (eVar != null && eVar.g()) {
            DiffInfo j3 = resConfig.j(eVar.f411264e);
            if (j3 == null) {
                jz3.d.a("Patch", "\u6ca1\u6709\u627e\u5230\u5408\u9002\u7684diffInfo\uff0c\u4e0d\u8fdb\u884cPatch\uff1a" + eVar);
                chain.c(req);
                return;
            }
            long j16 = resConfig.D;
            if (j16 > 0 && j16 < j3.getSize()) {
                jz3.d.e("Patch", "compressSize less than diffInfo.size\uff0cskip patch\uff1a" + eVar);
                chain.c(req);
                return;
            }
            com.tencent.rdelivery.reshub.processor.a.h(this, 2, req, null, 0L, 0L, 24, null);
            j3.k(jz3.b.i(req));
            n(j3, req, chain, eVar);
            return;
        }
        if (eVar != null && jz3.f.e(eVar)) {
            jz3.d.c("Patch", "\u672c\u5730\u6587\u4ef6\u975e\u6cd5\uff0c\u65e0\u6cd5patch\uff1a" + eVar);
        }
        chain.c(req);
    }
}
