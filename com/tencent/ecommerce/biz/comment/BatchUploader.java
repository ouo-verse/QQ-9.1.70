package com.tencent.ecommerce.biz.comment;

import com.tencent.component.media.image.ProgressTracer;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.base.uploader.ECBaseUploader;
import com.tencent.ecommerce.biz.comment.IUploadReporter;
import com.tencent.ecommerce.biz.comment.UploadStateListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.apache.httpcore.message.TokenParser;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0002\u0015\u0019Bx\u0012\u0006\u0010$\u001a\u00020\n\u0012\u0006\u0010(\u001a\u00020%\u0012H\b\u0002\u00100\u001aB\b\u0001\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b($\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0-\u0012\u0006\u0012\u0004\u0018\u00010\u00010)\u0012\b\b\u0002\u00103\u001a\u000201\u0012\b\b\u0002\u00106\u001a\u000204\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u00108J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J!\u0010\b\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\u0005J\u001f\u0010\u0011\u001a\u00020\u0010*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R&\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00140\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'RW\u00100\u001aB\b\u0001\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b($\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0-\u0012\u0006\u0012\u0004\u0018\u00010\u00010)8\u0002X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u00105\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00069"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/BatchUploader;", "", "", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "allMediaInfos", "", "j", "localMediaInfo", "k", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", h.F, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "Lcom/tencent/ecommerce/base/uploader/ECBaseUploader;", "mediaInfo", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a$f;", "l", "(Lcom/tencent/ecommerce/base/uploader/ECBaseUploader;Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlinx/coroutines/Deferred;", "a", "Ljava/util/List;", "uploadJobs", "", "b", "Ljava/util/Map;", "mediaInfoToDeferred", "c", "processingMediaInfos", "Lkotlinx/coroutines/CoroutineScope;", "d", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "e", "Ljava/lang/String;", "scene", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "f", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "listener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "filePath", "Lkotlin/coroutines/Continuation;", "g", "Lkotlin/jvm/functions/Function3;", "uploaderFactory", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lcom/tencent/ecommerce/biz/comment/IUploadReporter;", "Lcom/tencent/ecommerce/biz/comment/IUploadReporter;", "uploadReporter", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/biz/comment/UploadStateListener;Lkotlin/jvm/functions/Function3;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/tencent/ecommerce/biz/comment/IUploadReporter;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class BatchUploader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<Deferred<UploadStateListener.a.f>> uploadJobs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<ECMediaInfo, Deferred<UploadStateListener.a.f>> mediaInfoToDeferred;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<ECMediaInfo> processingMediaInfos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope coroutineScope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String scene;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final UploadStateListener listener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Function3<String, String, Continuation<? super ECBaseUploader>, Object> uploaderFactory;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher dispatcher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final IUploadReporter uploadReporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/BatchUploader$b;", "Lcom/tencent/ecommerce/base/uploader/ECBaseUploader$IUploaderListener;", "", "onUploadStarted", "", "uploadedFileSizeByte", "totalFileSizeByte", "onUploadProgress", "", "url", "onUploadSucceed", "", "errCode", "errMsg", "onUploadFailed", "onUploadCancelled", "onPauseSucceed", "a", "Ljava/lang/String;", "filePath", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "b", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "stateChangeListener", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/biz/comment/UploadStateListener;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    private static final class b implements ECBaseUploader.IUploaderListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String filePath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final UploadStateListener stateChangeListener;

        public b(String str, UploadStateListener uploadStateListener) {
            this.filePath = str;
            this.stateChangeListener = uploadStateListener;
        }

        @Override // com.tencent.ecommerce.base.uploader.ECBaseUploader.IUploaderListener
        public void onPauseFailed() {
            ECBaseUploader.IUploaderListener.a.a(this);
        }

        @Override // com.tencent.ecommerce.base.uploader.ECBaseUploader.IUploaderListener
        public void onPauseSucceed() {
            this.stateChangeListener.onStateChanged(new UploadStateListener.a.c(this.filePath));
        }

        @Override // com.tencent.ecommerce.base.uploader.ECBaseUploader.IUploaderListener
        public void onUploadCancelled() {
            this.stateChangeListener.onStateChanged(new UploadStateListener.a.C1045a(this.filePath));
        }

        @Override // com.tencent.ecommerce.base.uploader.ECBaseUploader.IUploaderListener
        public void onUploadFailed(int errCode, String errMsg) {
            this.stateChangeListener.onStateChanged(new UploadStateListener.a.b(this.filePath, errCode, errMsg));
        }

        @Override // com.tencent.ecommerce.base.uploader.ECBaseUploader.IUploaderListener
        public void onUploadProgress(long uploadedFileSizeByte, long totalFileSizeByte) {
            this.stateChangeListener.onStateChanged(new UploadStateListener.a.d(this.filePath, (((float) uploadedFileSizeByte) * 1.0f) / ((float) totalFileSizeByte)));
        }

        @Override // com.tencent.ecommerce.base.uploader.ECBaseUploader.IUploaderListener
        public void onUploadStarted() {
            this.stateChangeListener.onStateChanged(new UploadStateListener.a.e(this.filePath));
        }

        @Override // com.tencent.ecommerce.base.uploader.ECBaseUploader.IUploaderListener
        public void onUploadSucceed(String url) {
            cg0.a.b("BatchUploader", "filePath: " + this.filePath + " success: " + url);
            this.stateChangeListener.onStateChanged(new UploadStateListener.a.f(this.filePath, url));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/comment/BatchUploader$uploadSync$2$stateListener$1", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "state", "", "onStateChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements UploadStateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation f101362a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f101363b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BatchUploader f101364c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ECBaseUploader f101365d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECMediaInfo f101366e;

        c(CancellableContinuation cancellableContinuation, long j3, BatchUploader batchUploader, ECBaseUploader eCBaseUploader, ECMediaInfo eCMediaInfo) {
            this.f101362a = cancellableContinuation;
            this.f101363b = j3;
            this.f101364c = batchUploader;
            this.f101365d = eCBaseUploader;
            this.f101366e = eCMediaInfo;
        }

        @Override // com.tencent.ecommerce.biz.comment.UploadStateListener
        public void onStateChanged(UploadStateListener.a state) {
            String trimIndent;
            if (this.f101362a.isCancelled()) {
                trimIndent = StringsKt__IndentKt.trimIndent("\n                                state changed after coroutine cancelled,\n                                path: " + state.filePath + "\n                                is success:" + (state instanceof UploadStateListener.a.f));
                cg0.a.b("BatchUploader", trimIndent);
                return;
            }
            if (this.f101362a.isCompleted()) {
                cg0.a.a("BatchUploader", "onStateChanged", "Uploader callback after terminal state");
                return;
            }
            this.f101364c.listener.onStateChanged(state);
            if (state instanceof UploadStateListener.a.f) {
                IUploadReporter.b.a(this.f101364c.uploadReporter, this.f101366e, 0, System.currentTimeMillis() - this.f101363b, 0, 8, null);
                cg0.a.b("BatchUploader", "upload success:" + state.filePath + " -> " + ((UploadStateListener.a.f) state).url);
                this.f101362a.resumeWith(Result.m476constructorimpl(state));
                return;
            }
            if (state instanceof UploadStateListener.a.b) {
                this.f101364c.uploadReporter.reportFileUploadResult(this.f101366e, 1, System.currentTimeMillis() - this.f101363b, ((UploadStateListener.a.b) state).errCode);
                cg0.a.a("BatchUploader", "uploadSync", "upload failed:" + state.filePath + " -> " + ((UploadStateListener.a.b) state).errMsg);
                CancellableContinuation cancellableContinuation = this.f101362a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new UploadFailedException(this.f101366e.getMediaPath(), "UploadFailed"))));
                return;
            }
            if (state instanceof UploadStateListener.a.C1045a) {
                IUploadReporter.b.a(this.f101364c.uploadReporter, this.f101366e, 2, System.currentTimeMillis() - this.f101363b, 0, 8, null);
                cg0.a.a("BatchUploader", "uploadSync", "upload cancelled:" + state.filePath);
                CancellableContinuation cancellableContinuation2 = this.f101362a;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new UploadFailedException(this.f101366e.getMediaPath(), "Upload Cancelled"))));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BatchUploader(String str, UploadStateListener uploadStateListener, Function3<? super String, ? super String, ? super Continuation<? super ECBaseUploader>, ? extends Object> function3, CoroutineDispatcher coroutineDispatcher, IUploadReporter iUploadReporter) {
        this.scene = str;
        this.listener = uploadStateListener;
        this.uploaderFactory = function3;
        this.dispatcher = coroutineDispatcher;
        this.uploadReporter = iUploadReporter;
        this.uploadJobs = new ArrayList();
        this.mediaInfoToDeferred = new LinkedHashMap();
        this.processingMediaInfos = new ArrayList();
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("BatchUploader")));
    }

    private final void j(List<ECMediaInfo> allMediaInfos) {
        Set set;
        List<ECMediaInfo> minus;
        List<ECMediaInfo> list = this.processingMediaInfos;
        set = CollectionsKt___CollectionsKt.toSet(allMediaInfos);
        minus = CollectionsKt___CollectionsKt.minus((Iterable) list, (Iterable) set);
        Map<ECMediaInfo, Deferred<UploadStateListener.a.f>> map = this.mediaInfoToDeferred;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<ECMediaInfo, Deferred<UploadStateListener.a.f>>> it = map.entrySet().iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<ECMediaInfo, Deferred<UploadStateListener.a.f>> next = it.next();
            List list2 = minus;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it5 = list2.iterator();
                while (it5.hasNext()) {
                    if (Intrinsics.areEqual((ECMediaInfo) it5.next(), next.getKey())) {
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        for (final ECMediaInfo eCMediaInfo : minus) {
            CollectionsKt__MutableCollectionsKt.removeAll(this.mediaInfoToDeferred.entrySet(), new Function1<Map.Entry<ECMediaInfo, Deferred<? extends UploadStateListener.a.f>>, Boolean>() { // from class: com.tencent.ecommerce.biz.comment.BatchUploader$cancelAndRemoveOldJobs$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<ECMediaInfo, Deferred<? extends UploadStateListener.a.f>> entry) {
                    return Boolean.valueOf(invoke2((Map.Entry<ECMediaInfo, Deferred<UploadStateListener.a.f>>) entry));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(Map.Entry<ECMediaInfo, Deferred<UploadStateListener.a.f>> entry) {
                    return Intrinsics.areEqual(entry.getKey(), ECMediaInfo.this);
                }
            });
        }
        cg0.a.b("BatchUploader", "removing " + minus);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            ECMediaInfo eCMediaInfo2 = (ECMediaInfo) entry.getKey();
            Deferred deferred = (Deferred) entry.getValue();
            cg0.a.b("BatchUploader", "cancelling " + eCMediaInfo2);
            Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
            this.uploadJobs.remove(deferred);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bf, code lost:
    
        r1.add(((com.tencent.ecommerce.biz.comment.UploadStateListener.a.f) r7).url);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Continuation<? super List<String>> continuation) throws UploadFailedException, CancellationException {
        BatchUploader$allUrlsOrThrow$1 batchUploader$allUrlsOrThrow$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        List<ECMediaInfo> mutableList;
        BatchUploader batchUploader;
        BatchUploader batchUploader2;
        if (continuation instanceof BatchUploader$allUrlsOrThrow$1) {
            batchUploader$allUrlsOrThrow$1 = (BatchUploader$allUrlsOrThrow$1) continuation;
            int i16 = batchUploader$allUrlsOrThrow$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                batchUploader$allUrlsOrThrow$1.label = i16 - Integer.MIN_VALUE;
                obj = batchUploader$allUrlsOrThrow$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = batchUploader$allUrlsOrThrow$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            batchUploader2 = (BatchUploader) batchUploader$allUrlsOrThrow$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            List list = (List) obj;
                            ArrayList arrayList = new ArrayList();
                            for (ECMediaInfo eCMediaInfo : batchUploader2.processingMediaInfos) {
                                try {
                                    Iterator it = list.iterator();
                                    while (it.hasNext()) {
                                        Object next = it.next();
                                        if (Boxing.boxBoolean(Intrinsics.areEqual(((UploadStateListener.a.f) next).filePath, eCMediaInfo.getMediaPath())).booleanValue()) {
                                            break;
                                        }
                                    }
                                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                } catch (NoSuchElementException unused) {
                                    cg0.a.a("BatchUploader", "allUrls", "\u672a\u4e0a\u4f20\u5b8c\u6210\uff1f\uff1f" + eCMediaInfo);
                                    throw new UploadFailedException("-", "don't call allUrls after cancelAll");
                                }
                            }
                            return arrayList;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    batchUploader = (BatchUploader) batchUploader$allUrlsOrThrow$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (CoroutineScopeKt.isActive(this.coroutineScope)) {
                        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.processingMediaInfos);
                        batchUploader$allUrlsOrThrow$1.L$0 = this;
                        batchUploader$allUrlsOrThrow$1.label = 1;
                        if (k(mutableList, batchUploader$allUrlsOrThrow$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        batchUploader = this;
                    } else {
                        cg0.a.a("BatchUploader", "allUrls", "don't call allUrls after cancelAll");
                        throw new UploadFailedException("-", "don't call allUrls after cancelAll");
                    }
                }
                List<Deferred<UploadStateListener.a.f>> list2 = batchUploader.uploadJobs;
                batchUploader$allUrlsOrThrow$1.L$0 = batchUploader;
                batchUploader$allUrlsOrThrow$1.label = 2;
                obj = AwaitKt.awaitAll(list2, batchUploader$allUrlsOrThrow$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                batchUploader2 = batchUploader;
                List list3 = (List) obj;
                ArrayList arrayList2 = new ArrayList();
                while (r0.hasNext()) {
                }
                return arrayList2;
            }
        }
        batchUploader$allUrlsOrThrow$1 = new BatchUploader$allUrlsOrThrow$1(this, continuation);
        obj = batchUploader$allUrlsOrThrow$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = batchUploader$allUrlsOrThrow$1.label;
        if (i3 == 0) {
        }
        List<Deferred<UploadStateListener.a.f>> list22 = batchUploader.uploadJobs;
        batchUploader$allUrlsOrThrow$1.L$0 = batchUploader;
        batchUploader$allUrlsOrThrow$1.label = 2;
        obj = AwaitKt.awaitAll(list22, batchUploader$allUrlsOrThrow$1);
        if (obj != coroutine_suspended) {
        }
    }

    public final void i() {
        cg0.a.a("BatchUploader", "cancelAll", "cancel all tasks");
        CoroutineScopeKt.cancel$default(this.coroutineScope, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object l(final ECBaseUploader eCBaseUploader, final ECMediaInfo eCMediaInfo, Continuation<? super UploadStateListener.a.f> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        eCBaseUploader.e(new b(eCMediaInfo.getMediaPath(), new c(cancellableContinuationImpl, System.currentTimeMillis(), this, eCBaseUploader, eCMediaInfo)));
        eCBaseUploader.f();
        cg0.a.b("BatchUploader", "upload operated " + eCMediaInfo);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.ecommerce.biz.comment.BatchUploader$uploadSync$$inlined$suspendCancellableCoroutine$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th5) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("on cancel: ");
                sb5.append(eCMediaInfo);
                sb5.append(TokenParser.SP);
                sb5.append(th5 != null ? th5.getMessage() : null);
                sb5.append(TokenParser.SP);
                sb5.append(th5 != null ? th5.getCause() : null);
                cg0.a.a("BatchUploader", "uploadSync", sb5.toString());
                eCBaseUploader.a();
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object k(List<ECMediaInfo> list, Continuation<? super Unit> continuation) {
        List<ECMediaInfo> distinct;
        Set set;
        List minus;
        List plus;
        List<ECMediaInfo> sortedWith;
        Deferred async$default;
        boolean z16;
        cg0.a.b("BatchUploader", "new upload: " + list);
        distinct = CollectionsKt___CollectionsKt.distinct(list);
        j(distinct);
        List<ECMediaInfo> list2 = distinct;
        set = CollectionsKt___CollectionsKt.toSet(this.processingMediaInfos);
        minus = CollectionsKt___CollectionsKt.minus((Iterable) list2, (Iterable) set);
        ArrayList arrayList = new ArrayList();
        Map map = this.mediaInfoToDeferred;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = map.entrySet().iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            ECMediaInfo eCMediaInfo = (ECMediaInfo) entry.getKey();
            if (((Deferred) entry.getValue()).isCancelled()) {
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it5 = list2.iterator();
                    while (it5.hasNext()) {
                        if (Boxing.boxBoolean(Intrinsics.areEqual((ECMediaInfo) it5.next(), eCMediaInfo)).booleanValue()) {
                            z16 = true;
                            break;
                        }
                    }
                }
                z16 = false;
                if (z16) {
                    z17 = true;
                }
            }
            if (Boxing.boxBoolean(z17).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        Iterator it6 = linkedHashMap.entrySet().iterator();
        while (it6.hasNext()) {
            ECMediaInfo eCMediaInfo2 = (ECMediaInfo) ((Map.Entry) it6.next()).getKey();
            cg0.a.b("BatchUploader", "need restart: " + eCMediaInfo2);
            arrayList2.add(eCMediaInfo2);
        }
        arrayList.addAll(arrayList2);
        CollectionsKt__MutableCollectionsKt.removeAll(this.uploadJobs, (Function1) new Function1<Deferred<? extends UploadStateListener.a.f>, Boolean>() { // from class: com.tencent.ecommerce.biz.comment.BatchUploader$startNewOrNeedRestartJobs$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Deferred<? extends UploadStateListener.a.f> deferred) {
                return Boolean.valueOf(invoke2((Deferred<UploadStateListener.a.f>) deferred));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Deferred<UploadStateListener.a.f> deferred) {
                return deferred.isCancelled();
            }
        });
        plus = CollectionsKt___CollectionsKt.plus((Collection) minus, (Iterable) arrayList);
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(plus, new a(distinct));
        cg0.a.b("BatchUploader", "all be uploading : " + sortedWith);
        for (ECMediaInfo eCMediaInfo3 : sortedWith) {
            async$default = BuildersKt__Builders_commonKt.async$default(this.coroutineScope, new CoroutineName(eCMediaInfo3.getMediaPath()), null, new BatchUploader$uploadAll$$inlined$startNewOrNeedRestartJobs$lambda$1(eCMediaInfo3, null, this), 2, null);
            Iterator<ECMediaInfo> it7 = distinct.iterator();
            int i3 = 0;
            while (true) {
                if (!it7.hasNext()) {
                    i3 = -1;
                    break;
                }
                if (Boxing.boxBoolean(Intrinsics.areEqual(it7.next(), eCMediaInfo3)).booleanValue()) {
                    break;
                }
                i3++;
            }
            this.uploadJobs.add(i3, async$default);
            cg0.a.b("BatchUploader", "add job: " + eCMediaInfo3 + " index = " + i3 + TokenParser.SP + async$default + ProgressTracer.SEPARATOR + async$default.isCancelled() + TokenParser.SP + this.uploadJobs);
            this.mediaInfoToDeferred.put(eCMediaInfo3, async$default);
        }
        this.processingMediaInfos.clear();
        this.processingMediaInfos.addAll(list);
        return Unit.INSTANCE;
    }

    public /* synthetic */ BatchUploader(String str, UploadStateListener uploadStateListener, Function3 function3, CoroutineDispatcher coroutineDispatcher, IUploadReporter iUploadReporter, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, uploadStateListener, (i3 & 4) != 0 ? BatchUploaderKt.f101367a : function3, (i3 & 8) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i3 & 16) != 0 ? ECBatchUploaderReporter.f101368a : iUploadReporter);
    }
}
