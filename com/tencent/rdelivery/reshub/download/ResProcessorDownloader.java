package com.tencent.rdelivery.reshub.download;

import com.tencent.raft.standard.net.IRDownload;
import com.tencent.raft.standard.net.IRNetwork;
import com.tencent.rdelivery.reshub.core.k;
import com.tencent.rdelivery.reshub.report.g;
import com.tencent.rdelivery.reshub.util.ThreadUtil;
import java.util.Map;
import jz3.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\"\u001a\u00020\u001e\u0012\b\b\u0002\u0010#\u001a\u00020\u0013\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JJ\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0002JR\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rR\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/rdelivery/reshub/download/ResProcessorDownloader;", "", "", "size", "", "e", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "", "url", "path", "", "extraInfo", "Lkotlin/Function1;", "Lcom/tencent/rdelivery/reshub/report/a;", "", "onDownloadFinish", "g", "f", "", "a", "I", "errorCodeForSpace", "b", "errorCodeForFileOpt", "c", "errorCodeForHttp", "d", "errorCodeForOther", "progressStatus", "Lcom/tencent/rdelivery/reshub/processor/a;", "Lcom/tencent/rdelivery/reshub/processor/a;", h.F, "()Lcom/tencent/rdelivery/reshub/processor/a;", "processor", "downloadType", "<init>", "(Lcom/tencent/rdelivery/reshub/processor/a;I)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ResProcessorDownloader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int errorCodeForSpace;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int errorCodeForFileOpt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int errorCodeForHttp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int errorCodeForOther;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int progressStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.rdelivery.reshub.processor.a processor;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/rdelivery/reshub/download/ResProcessorDownloader$a", "Lcom/tencent/raft/standard/net/IRDownload$IDownloadCallback;", "Lcom/tencent/raft/standard/net/IRNetwork$ResultInfo;", "info", "", "onComplete", "", "receivedSize", "totalSize", "onProgress", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a implements IRDownload.IDownloadCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f364493b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f364494c;

        a(Function1 function1, k kVar) {
            this.f364493b = function1;
            this.f364494c = kVar;
        }

        @Override // com.tencent.raft.standard.net.IRDownload.IDownloadCallback
        public void onComplete(@NotNull IRNetwork.ResultInfo info) {
            Intrinsics.checkParameterIsNotNull(info, "info");
            this.f364493b.invoke(g.d(info, ResProcessorDownloader.this.errorCodeForHttp, ResProcessorDownloader.this.errorCodeForOther));
        }

        @Override // com.tencent.raft.standard.net.IRDownload.IDownloadCallback
        public void onProgress(long receivedSize, long totalSize) {
            ResProcessorDownloader.this.getProcessor().g(ResProcessorDownloader.this.progressStatus, this.f364494c, null, receivedSize, totalSize);
        }
    }

    public ResProcessorDownloader(@NotNull com.tencent.rdelivery.reshub.processor.a processor, int i3) {
        Intrinsics.checkParameterIsNotNull(processor, "processor");
        this.processor = processor;
        if (i3 != 1) {
            if (i3 != 2) {
                this.errorCodeForSpace = 2104;
                this.errorCodeForFileOpt = 2105;
                this.errorCodeForHttp = 2101;
                this.errorCodeForOther = 2102;
                this.progressStatus = 13;
                return;
            }
            this.errorCodeForSpace = 5004;
            this.errorCodeForFileOpt = 5005;
            this.errorCodeForHttp = 5001;
            this.errorCodeForOther = 5002;
            this.progressStatus = 3;
            return;
        }
        this.errorCodeForSpace = 2004;
        this.errorCodeForFileOpt = 2005;
        this.errorCodeForHttp = 2001;
        this.errorCodeForOther = 2002;
        this.progressStatus = 6;
    }

    private final boolean e(long size) {
        long j3;
        try {
            j3 = jz3.b.g(com.tencent.rdelivery.reshub.core.g.d());
        } catch (Exception unused) {
            j3 = -1;
        }
        if (size <= 0 || j3 < 0 || size + 10240 <= j3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(k req, String url, String path, Map<String, String> extraInfo, Function1<? super com.tencent.rdelivery.reshub.report.a, Unit> onDownloadFinish) {
        long j3;
        String x16 = req.x();
        a aVar = new a(onDownloadFinish, req);
        e resConfig = req.getResConfig();
        if (resConfig != null) {
            j3 = resConfig.E;
        } else {
            j3 = 0;
        }
        new c(x16).a(url, path, aVar, j3, extraInfo);
    }

    public final void f(@NotNull final k req, @NotNull final String url, @NotNull final String path, long size, @Nullable final Map<String, String> extraInfo, @NotNull final Function1<? super com.tencent.rdelivery.reshub.report.a, Unit> onDownloadFinish) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(path, "path");
        Intrinsics.checkParameterIsNotNull(onDownloadFinish, "onDownloadFinish");
        if (!e(size)) {
            com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
            aVar.e(this.errorCodeForSpace);
            onDownloadFinish.invoke(aVar);
            return;
        }
        Exception n3 = jz3.b.n(path);
        if (n3 != null) {
            com.tencent.rdelivery.reshub.report.a aVar2 = new com.tencent.rdelivery.reshub.report.a();
            aVar2.e(this.errorCodeForFileOpt);
            aVar2.f(n3);
            onDownloadFinish.invoke(aVar2);
            return;
        }
        ThreadUtil.f364593c.d("Download", req.getPriority(), new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.download.ResProcessorDownloader$doDownload$3
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
                kz3.a batchContext = req.getBatchContext();
                if (batchContext != null) {
                    batchContext.c(req.x());
                }
                ResProcessorDownloader.this.g(req, url, path, extraInfo, onDownloadFinish);
            }
        });
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final com.tencent.rdelivery.reshub.processor.a getProcessor() {
        return this.processor;
    }
}
