package com.tencent.rdelivery.reshub.net;

import com.tencent.raft.standard.net.IRDownload;
import com.tencent.raft.standard.net.IRNetwork;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import jz3.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J8\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J*\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/rdelivery/reshub/net/ResHubDefaultDownloadImpl;", "Lcom/tencent/raft/standard/net/IRDownload;", "", "url", "Ljava/io/File;", "file", "Lcom/tencent/rdelivery/reshub/net/b;", "failCallback", "Lcom/tencent/rdelivery/reshub/net/c;", "progressCallback", "Lkotlin/Function0;", "", "successAction", "downloadToFile", "filePath", "Lcom/tencent/raft/standard/net/IRDownload$IDownloadCallback;", "callback", "Lcom/tencent/raft/standard/net/IRDownload$IRDownloadTask;", "downloadWithUrl", "Lcom/tencent/raft/standard/net/IRDownload$DownloadPriority;", "priority", "TAG", "Ljava/lang/String;", "<init>", "()V", "reshub-net_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ResHubDefaultDownloadImpl implements IRDownload {
    private final String TAG = "ResHubDefaultDownloadImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/rdelivery/reshub/net/ResHubDefaultDownloadImpl$a", "Lcom/tencent/rdelivery/reshub/net/b;", "", "errorCode", "", "errorMsg", "", "isHttpError", "", "onError", "reshub-net_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a implements com.tencent.rdelivery.reshub.net.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IRDownload.IDownloadCallback f364546a;

        a(IRDownload.IDownloadCallback iDownloadCallback) {
            this.f364546a = iDownloadCallback;
        }

        @Override // com.tencent.rdelivery.reshub.net.b
        public void onError(int errorCode, @NotNull String errorMsg, boolean isHttpError) {
            Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
            this.f364546a.onComplete(com.tencent.rdelivery.reshub.net.a.a(isHttpError, errorCode, errorMsg));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/rdelivery/reshub/net/ResHubDefaultDownloadImpl$b", "Lcom/tencent/rdelivery/reshub/net/c;", "", "curSize", "totalSize", "", "onProgress", "reshub-net_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IRDownload.IDownloadCallback f364547a;

        b(IRDownload.IDownloadCallback iDownloadCallback) {
            this.f364547a = iDownloadCallback;
        }

        @Override // com.tencent.rdelivery.reshub.net.c
        public void onProgress(long curSize, long totalSize) {
            this.f364547a.onProgress(curSize, totalSize);
        }
    }

    private final void downloadToFile(final String url, final File file, final com.tencent.rdelivery.reshub.net.b failCallback, final c progressCallback, final Function0<Unit> successAction) {
        new ResHubDefaultHttpConnection().j(url, failCallback, new Function2<Long, InputStream, Unit>() { // from class: com.tencent.rdelivery.reshub.net.ResHubDefaultDownloadImpl$downloadToFile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l3, InputStream inputStream) {
                invoke(l3.longValue(), inputStream);
                return Unit.INSTANCE;
            }

            public final void invoke(long j3, @NotNull InputStream inputStream) {
                String str;
                Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
                if (FileUtilKt.b(inputStream, file, j3, progressCallback)) {
                    str = ResHubDefaultDownloadImpl.this.TAG;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Http Download Success: ");
                    sb5.append(url);
                    sb5.append(TokenParser.SP);
                    sb5.append("(thread: ");
                    Thread currentThread = Thread.currentThread();
                    Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
                    sb5.append(currentThread.getId());
                    sb5.append(')');
                    d.a(str, sb5.toString());
                    successAction.invoke();
                    return;
                }
                b bVar = failCallback;
                if (bVar != null) {
                    bVar.onError(2005, "Save Stream to File Fail.", false);
                }
            }
        });
    }

    @Override // com.tencent.raft.standard.net.IRDownload
    public /* synthetic */ IRDownload.IRDownloadTask downloadWithUrl(String str, String str2, IRDownload.DownloadPriority downloadPriority, IRDownload.IDownloadCallback iDownloadCallback, Map map) {
        return com.tencent.raft.standard.net.a.a(this, str, str2, downloadPriority, iDownloadCallback, map);
    }

    @Override // com.tencent.raft.standard.net.IRDownload
    @Nullable
    public IRDownload.IRDownloadTask downloadWithUrl(@NotNull String url, @NotNull String filePath, @NotNull final IRDownload.IDownloadCallback callback) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        File file = new File(filePath);
        a aVar = new a(callback);
        b bVar = new b(callback);
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Http Downloading: ");
        sb5.append(url);
        sb5.append(" to ");
        sb5.append(filePath);
        sb5.append("(Thread: ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb5.append(currentThread.getId());
        sb5.append(')');
        d.e(str, sb5.toString());
        downloadToFile(url, file, aVar, bVar, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.net.ResHubDefaultDownloadImpl$downloadWithUrl$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                IRNetwork.ResultInfo resultInfo = new IRNetwork.ResultInfo();
                resultInfo.setErrorType(IRNetwork.ResultInfo.ErrorType.SUCCESS);
                IRDownload.IDownloadCallback.this.onComplete(resultInfo);
            }
        });
        return null;
    }

    @Override // com.tencent.raft.standard.net.IRDownload
    @Nullable
    public IRDownload.IRDownloadTask downloadWithUrl(@NotNull String url, @NotNull String filePath, @NotNull IRDownload.DownloadPriority priority, @NotNull IRDownload.IDownloadCallback callback) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(filePath, "filePath");
        Intrinsics.checkParameterIsNotNull(priority, "priority");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        d.e(this.TAG, "Downloading With Priority(" + priority + "): " + url);
        return downloadWithUrl(url, filePath, callback);
    }
}
