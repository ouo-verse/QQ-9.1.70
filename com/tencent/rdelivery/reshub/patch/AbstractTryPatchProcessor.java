package com.tencent.rdelivery.reshub.patch;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.rdelivery.reshub.core.g;
import com.tencent.rdelivery.reshub.core.k;
import com.tencent.rdelivery.reshub.download.ResProcessorDownloader;
import com.tencent.rdelivery.reshub.processor.l;
import com.tencent.rdelivery.reshub.util.c;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import jz3.b;
import jz3.d;
import jz3.e;
import jz3.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nz3.DiffInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010)\u001a\u00020\u0012\u0012\b\b\u0002\u0010(\u001a\u00020\u001a\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J0\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J8\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J0\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J0\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0002J*\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0004H&J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H&J(\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010 \u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010%\u001a\u00020\u00128\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/rdelivery/reshub/patch/AbstractTryPatchProcessor;", "Lcom/tencent/rdelivery/reshub/processor/a;", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Ljz3/e;", "r", "remoteConfig", "localConfig", "Lnz3/a;", DomainData.DOMAIN_NAME, "diffInfo", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/rdelivery/reshub/util/c;", "fileSync", "t", "", "targetPath", "patchPath", HippyTKDListViewAdapter.X, "Lcom/tencent/rdelivery/reshub/report/a;", "errorInfo", "u", "v", "", ReportConstant.COSTREPORT_PREFIX, "p", "o", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "d", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "TAG", "e", "Z", "checkResMustBeZip", "type", "<init>", "(Ljava/lang/String;Z)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public abstract class AbstractTryPatchProcessor extends com.tencent.rdelivery.reshub.processor.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean checkResMustBeZip;

    public AbstractTryPatchProcessor(@NotNull String type, boolean z16) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.checkResMustBeZip = z16;
        this.TAG = "TryPatch-" + type;
    }

    private final DiffInfo n(e remoteConfig, e localConfig) {
        String str = remoteConfig.f411260a;
        DiffInfo p16 = p(remoteConfig, localConfig);
        if (p16 == null) {
            d.e(this.TAG, "No Suitable DiffInfo for Res(" + str + ") LocalVersion(" + localConfig.f411261b + "), Ignore Patch.");
            return null;
        }
        d.e(this.TAG, "Find Patch for Res(" + str + "): " + p16);
        return p16;
    }

    private final e r(k req) {
        e m3 = req.getConfigMap().m(req.x());
        if (m3 == null) {
            d.e(this.TAG, "No Local Res(" + req.x() + "), Ignore Patch.");
            return null;
        }
        if (!m3.h(req.getAppInfo())) {
            d.c(this.TAG, "Invalid Local Res(" + req.x() + "), Ignore Patch. Path: " + m3.G);
            return null;
        }
        if (this.checkResMustBeZip && (!g.i(req.getAppInfo(), m3) || !new File(m3.G).isDirectory())) {
            d.c(this.TAG, "Local Res(" + req.x() + ") Not ZipFile, Ignore Patch. Path: " + m3.G);
            return null;
        }
        return m3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(k req, DiffInfo diffInfo, e localConfig, e remoteConfig, l chain, c fileSync) {
        com.tencent.rdelivery.reshub.report.a aVar;
        String localPath = diffInfo.getLocalPath();
        String o16 = o(req);
        if (!jz3.c.b(localPath, diffInfo.getCrc32(), diffInfo.getMd5())) {
            fileSync.c();
            com.tencent.rdelivery.reshub.report.a aVar2 = new com.tencent.rdelivery.reshub.report.a();
            aVar2.e(5006);
            aVar2.g("Invalid Res(" + req.x() + ") Patch File:  " + localPath);
            u(req, aVar2, localPath, o16, chain);
            return;
        }
        try {
            try {
                com.tencent.rdelivery.reshub.report.a y16 = y(localPath, o16, localConfig, remoteConfig);
                fileSync.c();
                aVar = y16;
            } catch (Exception e16) {
                com.tencent.rdelivery.reshub.report.a aVar3 = new com.tencent.rdelivery.reshub.report.a();
                aVar3.e(5007);
                aVar3.g("Perform Res(" + req.x() + ") Patch Merge Exception: " + e16.getMessage());
                fileSync.c();
                aVar = aVar3;
            }
            if (!aVar.d()) {
                u(req, aVar, localPath, o16, chain);
            } else {
                x(req, o16, localPath, remoteConfig, chain);
            }
        } catch (Throwable th5) {
            fileSync.c();
            throw th5;
        }
    }

    private final void u(k req, com.tencent.rdelivery.reshub.report.a errorInfo, String patchPath, String targetPath, l chain) {
        jz3.c.g(targetPath, true);
        d.c(this.TAG, errorInfo.getExtraMessage());
        v(req, errorInfo, patchPath, chain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(k req, com.tencent.rdelivery.reshub.report.a errorInfo, String patchPath, l chain) {
        com.tencent.rdelivery.reshub.processor.a.h(this, 4, req, errorInfo, 0L, 0L, 24, null);
        jz3.c.g(patchPath, true);
        chain.c(req);
    }

    static /* synthetic */ void w(AbstractTryPatchProcessor abstractTryPatchProcessor, k kVar, com.tencent.rdelivery.reshub.report.a aVar, String str, l lVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                aVar = new com.tencent.rdelivery.reshub.report.a();
            }
            abstractTryPatchProcessor.v(kVar, aVar, str, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPatchFinished");
    }

    private final void x(k req, String targetPath, String patchPath, e remoteConfig, l chain) {
        remoteConfig.H = targetPath;
        remoteConfig.G = targetPath;
        m(req);
        d.e(this.TAG, "Patch Res(" + req.x() + ") Success. Version(" + remoteConfig.f411261b + ") LocalPath: " + targetPath);
        w(this, req, null, patchPath, chain, 2, null);
    }

    private final void z(final k req, final DiffInfo diffInfo, final e localConfig, final e remoteConfig, final l chain) {
        String str;
        Map<String, String> map;
        final c cVar = new c(req);
        cVar.b();
        final String localPath = diffInfo.getLocalPath();
        final String downloadUrl = diffInfo.getDownloadUrl();
        d.e(this.TAG, "Start Downloading Res(" + req.x() + ") Patch: " + diffInfo);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        e resConfig = req.getResConfig();
        if (resConfig == null || (str = resConfig.f411268i) == null) {
            str = "";
        }
        linkedHashMap.put("res_type", str);
        linkedHashMap.put(IPreloadServiceProxy.KEY_RESID, req.x());
        linkedHashMap.put(VRReportDefine$ReportParam.DOWNLOAD_TYPE, String.valueOf(2));
        ResProcessorDownloader resProcessorDownloader = new ResProcessorDownloader(this, 2);
        long size = diffInfo.getSize();
        map = MapsKt__MapsKt.toMap(linkedHashMap);
        resProcessorDownloader.f(req, downloadUrl, localPath, size, map, new Function1<com.tencent.rdelivery.reshub.report.a, Unit>() { // from class: com.tencent.rdelivery.reshub.patch.AbstractTryPatchProcessor$startDownloadPatch$1
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
                if (errorInfo.d()) {
                    d.e(AbstractTryPatchProcessor.this.getTAG(), "Download Patch Res(" + req.x() + ") Success: " + downloadUrl + " -> " + localPath);
                    AbstractTryPatchProcessor.this.t(req, diffInfo, localConfig, remoteConfig, chain, cVar);
                    return;
                }
                cVar.c();
                d.c(AbstractTryPatchProcessor.this.getTAG(), "Download Patch Res(" + req.x() + ") Fail, Url: " + downloadUrl + " Err\uff1a" + com.tencent.rdelivery.reshub.report.c.a(errorInfo));
                AbstractTryPatchProcessor.this.v(req, errorInfo, localPath, chain);
            }
        });
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public void i(@NotNull k req, @NotNull l chain) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        e resConfig = req.getResConfig();
        if (resConfig == null) {
            j(chain, req, 207);
            return;
        }
        if (f.d(resConfig)) {
            d.e(this.TAG, "proceed localOriginFileAvailable, originLocal = " + resConfig.H);
            chain.c(req);
            return;
        }
        if (!req.getFilePatchChecked() && !req.getBigResPatchChecked()) {
            if (!s(resConfig)) {
                chain.c(req);
                return;
            }
            e r16 = r(req);
            if (r16 == null) {
                chain.c(req);
                return;
            }
            DiffInfo n3 = n(resConfig, r16);
            if (n3 == null) {
                chain.c(req);
                return;
            }
            com.tencent.rdelivery.reshub.processor.a.h(this, 2, req, null, 0L, 0L, 24, null);
            n3.k(b.i(req));
            z(req, n3, r16, resConfig, chain);
            return;
        }
        chain.c(req);
    }

    public abstract void m(@NotNull k req);

    @NotNull
    public abstract String o(@NotNull k req);

    @Nullable
    public abstract DiffInfo p(@NotNull e remoteConfig, @NotNull e localConfig);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: q, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    public abstract boolean s(@NotNull e remoteConfig);

    @NotNull
    public abstract com.tencent.rdelivery.reshub.report.a y(@NotNull String patchPath, @NotNull String targetPath, @NotNull e localConfig, @NotNull e remoteConfig);
}
