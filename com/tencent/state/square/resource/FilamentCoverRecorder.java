package com.tencent.state.square.resource;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.vas.banner.c;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.RecordSuccessListener;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.state.square.resource.FilamentCoverRecorder;
import com.tencent.zplan.meme.model.MemeResult;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0004+,-.B\u0005\u00a2\u0006\u0002\u0010\u0002JI\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J*\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0006\u0010 \u001a\u00020\nJ*\u0010!\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J(\u0010\"\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J*\u0010%\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/tencent/state/square/resource/FilamentCoverRecorder;", "Lcom/tencent/state/square/api/RecordSuccessListener;", "()V", "isCallbackAdded", "Ljava/util/concurrent/atomic/AtomicBoolean;", Constants.Raft.TASKS, "", "", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordTask;", "copyFile", "", "srcPath", "targetPath", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "errCode", "doStartRecord", "task", "getCallbackKey", "actionId", IECDtReport.ACTION_IDENTIFIER, "Lcom/tencent/state/square/record/RecordIdentifier;", "onCloudRecordSuccess", "recordIdentifier", "cover", "Lcom/tencent/state/square/data/RecordSource;", "mp4", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onLocalRecordSuccess", "onRecordError", "type", "errorCode", "onUploadSuccess", "startRecord", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordRequest;", "callback", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$IRecordCallback;", "Companion", "IRecordCallback", "RecordRequest", "RecordTask", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FilamentCoverRecorder implements RecordSuccessListener {
    public static final int ERR_FILE_COPY_FAILED = 2;
    public static final int ERR_FILE_NOT_EXIST = 1;
    public static final int ERR_RECORD_START_FAIL = 3;
    private static final String TAG = "FilamentCoverRecorder";
    private final Map<String, RecordTask> tasks = new LinkedHashMap();
    private AtomicBoolean isCallbackAdded = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/resource/FilamentCoverRecorder$IRecordCallback;", "", "onRecordError", "", "type", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordRequest;", "errorCode", "onRecordSuccess", "cover", "Lcom/tencent/state/square/data/RecordSource;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public interface IRecordCallback {
        void onRecordError(int type, RecordRequest request, int errorCode);

        void onRecordSuccess(RecordRequest request, RecordSource cover);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00c6\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0006\u0010\u0015\u001a\u00020\u0007J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\u0006\u0010\u001b\u001a\u00020\u0017J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordTask;", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordRequest;", "callback", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$IRecordCallback;", "startTime", "", "(Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordRequest;Lcom/tencent/state/square/resource/FilamentCoverRecorder$IRecordCallback;J)V", "getCallback", "()Lcom/tencent/state/square/resource/FilamentCoverRecorder$IRecordCallback;", "getRequest", "()Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordRequest;", "getStartTime", "()J", "setStartTime", "(J)V", "component1", "component2", "component3", "copy", QCircleWeakNetReporter.KEY_COST, "equals", "", "other", "hashCode", "", "isTimeout", "toString", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final /* data */ class RecordTask {
        public static final long TIMEOUT_MS = 10000;
        private final IRecordCallback callback;
        private final RecordRequest request;
        private long startTime;

        public RecordTask(RecordRequest request, IRecordCallback iRecordCallback, long j3) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
            this.callback = iRecordCallback;
            this.startTime = j3;
        }

        /* renamed from: component1, reason: from getter */
        public final RecordRequest getRequest() {
            return this.request;
        }

        /* renamed from: component2, reason: from getter */
        public final IRecordCallback getCallback() {
            return this.callback;
        }

        /* renamed from: component3, reason: from getter */
        public final long getStartTime() {
            return this.startTime;
        }

        public final RecordTask copy(RecordRequest request, IRecordCallback callback, long startTime) {
            Intrinsics.checkNotNullParameter(request, "request");
            return new RecordTask(request, callback, startTime);
        }

        public final long cost() {
            return System.currentTimeMillis() - this.startTime;
        }

        public final IRecordCallback getCallback() {
            return this.callback;
        }

        public final RecordRequest getRequest() {
            return this.request;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public int hashCode() {
            RecordRequest recordRequest = this.request;
            int hashCode = (recordRequest != null ? recordRequest.hashCode() : 0) * 31;
            IRecordCallback iRecordCallback = this.callback;
            return ((hashCode + (iRecordCallback != null ? iRecordCallback.hashCode() : 0)) * 31) + c.a(this.startTime);
        }

        public final boolean isTimeout() {
            return cost() > 10000;
        }

        public final void setStartTime(long j3) {
            this.startTime = j3;
        }

        public String toString() {
            return "RecordTask(request=" + this.request + ", callback=" + this.callback + ", startTime=" + this.startTime + ")";
        }

        public /* synthetic */ RecordTask(RecordRequest recordRequest, IRecordCallback iRecordCallback, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(recordRequest, iRecordCallback, (i3 & 4) != 0 ? System.currentTimeMillis() : j3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecordTask)) {
                return false;
            }
            RecordTask recordTask = (RecordTask) other;
            return Intrinsics.areEqual(this.request, recordTask.request) && Intrinsics.areEqual(this.callback, recordTask.callback) && this.startTime == recordTask.startTime;
        }

        public static /* synthetic */ RecordTask copy$default(RecordTask recordTask, RecordRequest recordRequest, IRecordCallback iRecordCallback, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                recordRequest = recordTask.request;
            }
            if ((i3 & 2) != 0) {
                iRecordCallback = recordTask.callback;
            }
            if ((i3 & 4) != 0) {
                j3 = recordTask.startTime;
            }
            return recordTask.copy(recordRequest, iRecordCallback, j3);
        }
    }

    private final void copyFile(final String srcPath, final String targetPath, final Function0<Unit> onSuccess, final Function1<? super Integer, Unit> onError) {
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.square.resource.FilamentCoverRecorder$copyFile$1
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
                try {
                    File file = new File(srcPath);
                    if (file.exists()) {
                        File file2 = new File(targetPath);
                        File parentFile = file2.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        FilesKt__UtilsKt.copyTo$default(file, file2, true, 0, 4, null);
                        onSuccess.invoke();
                        return;
                    }
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FilamentCoverRecorder", "copyFile: src file not exist, path=" + srcPath, null, 4, null);
                    onError.invoke(1);
                } catch (Exception e16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FilamentCoverRecorder", "copyFile: error=" + e16, null, 4, null);
                    onError.invoke(2);
                }
            }
        });
    }

    private final void doStartRecord(RecordTask task) {
        RecordRequest request = task.getRequest();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FilamentCoverRecorder$doStartRecord$1(request, request.getResource(), task, null), 3, null);
    }

    private final String getCallbackKey(int actionId, RecordIdentifier identifier) {
        String joinToString$default;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(actionId);
        sb5.append(util.base64_pad_url);
        sb5.append(identifier.getSender().getUin());
        sb5.append(util.base64_pad_url);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(identifier.getReceivers(), "_", null, null, 0, null, new Function1<UserIdentifier, CharSequence>() { // from class: com.tencent.state.square.resource.FilamentCoverRecorder$getCallbackKey$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(UserIdentifier it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getUin();
            }
        }, 30, null);
        sb5.append(joinToString$default);
        sb5.append(util.base64_pad_url);
        sb5.append(identifier.getType());
        sb5.append(util.base64_pad_url);
        sb5.append(identifier.getNeedUpload());
        return sb5.toString();
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onCloudRecordSuccess(int actionId, RecordIdentifier recordIdentifier, RecordSource cover, RecordSource mp42) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(cover, "cover");
    }

    public final synchronized void onDestroy() {
        this.tasks.clear();
        Square.INSTANCE.getConfig().getRecorder().removeRecordDoneCallback(this);
        this.isCallbackAdded.set(false);
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public synchronized void onLocalRecordSuccess(final int actionId, final RecordIdentifier recordIdentifier, final RecordSource cover, RecordSource mp42) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(cover, "cover");
        if (recordIdentifier.getType().isFilamentFrame()) {
            SquareBaseKt.getSquareLog().i(TAG, "onLocalRecordSuccess: uin=" + recordIdentifier.getSender().getUin() + ", actionId=" + actionId + ", cover=" + cover);
            final RecordTask remove = this.tasks.remove(getCallbackKey(actionId, recordIdentifier));
            if (remove != null) {
                copyFile(cover.getPath(), remove.getRequest().getCoverPath(), new Function0<Unit>() { // from class: com.tencent.state.square.resource.FilamentCoverRecorder$onLocalRecordSuccess$1
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
                        SquareBaseKt.getSquareLog().i("FilamentCoverRecorder", "onLocalRecordSuccess: copyFile success, uin=" + RecordIdentifier.this.getSender().getUin() + ", actionId=" + actionId + ", coverPath=" + remove.getRequest().getCoverPath());
                        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.resource.FilamentCoverRecorder$onLocalRecordSuccess$1.1
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
                                FilamentCoverRecorder.IRecordCallback callback = remove.getCallback();
                                if (callback != null) {
                                    FilamentCoverRecorder.RecordRequest request = remove.getRequest();
                                    FilamentCoverRecorder$onLocalRecordSuccess$1 filamentCoverRecorder$onLocalRecordSuccess$1 = FilamentCoverRecorder$onLocalRecordSuccess$1.this;
                                    callback.onRecordSuccess(request, RecordSource.copy$default(cover, remove.getRequest().getCoverPath(), null, 2, null));
                                }
                            }
                        });
                    }
                }, new Function1<Integer, Unit>() { // from class: com.tencent.state.square.resource.FilamentCoverRecorder$onLocalRecordSuccess$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final int i3) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FilamentCoverRecorder", "onLocalRecordSuccess: copyFile error, uin=" + RecordIdentifier.this.getSender().getUin() + ", actionId=" + actionId + ", errCode=" + i3, null, 4, null);
                        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.resource.FilamentCoverRecorder$onLocalRecordSuccess$2.1
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
                                FilamentCoverRecorder.IRecordCallback callback = remove.getCallback();
                                if (callback != null) {
                                    callback.onRecordError(0, remove.getRequest(), i3);
                                }
                            }
                        });
                    }
                });
                SquareBaseKt.getSquareLog().i(TAG, "TaskFinish: cost=" + remove.cost() + "ms uin=" + recordIdentifier.getSender().getUin() + ", actionId=" + actionId + ", coverPath=" + remove.getRequest().getCoverPath());
            }
        }
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onRecordDone(boolean z16, MemeResult result, RecordIdentifier identifier) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        RecordSuccessListener.DefaultImpls.onRecordDone(this, z16, result, identifier);
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public synchronized void onRecordError(int actionId, final int type, final int errorCode, RecordIdentifier recordIdentifier) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        if (recordIdentifier.getType().isFilamentFrame()) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "onRecordError: actionId=" + actionId + ", type=" + type + ", uin=" + recordIdentifier + ", error=" + errorCode, null, 4, null);
            final RecordTask remove = this.tasks.remove(getCallbackKey(actionId, recordIdentifier));
            if (remove != null) {
                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.resource.FilamentCoverRecorder$onRecordError$1
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
                        FilamentCoverRecorder.IRecordCallback callback = FilamentCoverRecorder.RecordTask.this.getCallback();
                        if (callback != null) {
                            callback.onRecordError(type, FilamentCoverRecorder.RecordTask.this.getRequest(), errorCode);
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onUploadSuccess(int actionId, RecordIdentifier recordIdentifier, RecordSource cover, RecordSource mp42) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(cover, "cover");
    }

    public final synchronized void startRecord(RecordRequest request, IRecordCallback callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        String callbackKey = getCallbackKey(request.getResource().getActionId(), request.toRecordIdentifier());
        if (this.tasks.containsKey(callbackKey)) {
            RecordTask recordTask = this.tasks.get(callbackKey);
            if (recordTask != null && recordTask.isTimeout()) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "startRecord: timeout, key=" + callbackKey, null, 4, null);
                this.tasks.remove(callbackKey);
            } else {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "startRecord: already started, key=" + callbackKey, null, 4, null);
                return;
            }
        }
        RecordTask recordTask2 = new RecordTask(request, callback, 0L, 4, null);
        this.tasks.put(callbackKey, recordTask2);
        if (this.isCallbackAdded.compareAndSet(false, true)) {
            Square.INSTANCE.getConfig().getRecorder().addRecordDoneCallback(this);
        }
        doStartRecord(recordTask2);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u000bH\u00c6\u0003J\t\u0010!\u001a\u00020\rH\u00c6\u0003JQ\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020&H\u00d6\u0001J\u0006\u0010'\u001a\u00020(J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015\u00a8\u0006*"}, d2 = {"Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordRequest;", "", "id", "", "sender", "Lcom/tencent/state/square/record/UserIdentifier;", "receiver", "resource", "Lcom/tencent/state/square/data/Resource;", QQWinkConstants.COVER_PATH, "needUpload", "", "recordType", "Lcom/tencent/state/square/record/RecordType;", "(Ljava/lang/String;Lcom/tencent/state/square/record/UserIdentifier;Lcom/tencent/state/square/record/UserIdentifier;Lcom/tencent/state/square/data/Resource;Ljava/lang/String;ZLcom/tencent/state/square/record/RecordType;)V", "getCoverPath", "()Ljava/lang/String;", "getId", "getNeedUpload", "()Z", "getReceiver", "()Lcom/tencent/state/square/record/UserIdentifier;", "getRecordType", "()Lcom/tencent/state/square/record/RecordType;", "getResource", "()Lcom/tencent/state/square/data/Resource;", "getSender", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toRecordIdentifier", "Lcom/tencent/state/square/record/RecordIdentifier;", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final /* data */ class RecordRequest {
        private final String coverPath;
        private final String id;
        private final boolean needUpload;
        private final UserIdentifier receiver;
        private final RecordType recordType;
        private final Resource resource;
        private final UserIdentifier sender;

        public RecordRequest(String id5, UserIdentifier sender, UserIdentifier userIdentifier, Resource resource, String coverPath, boolean z16, RecordType recordType) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(resource, "resource");
            Intrinsics.checkNotNullParameter(coverPath, "coverPath");
            Intrinsics.checkNotNullParameter(recordType, "recordType");
            this.id = id5;
            this.sender = sender;
            this.receiver = userIdentifier;
            this.resource = resource;
            this.coverPath = coverPath;
            this.needUpload = z16;
            this.recordType = recordType;
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final UserIdentifier getSender() {
            return this.sender;
        }

        /* renamed from: component3, reason: from getter */
        public final UserIdentifier getReceiver() {
            return this.receiver;
        }

        /* renamed from: component4, reason: from getter */
        public final Resource getResource() {
            return this.resource;
        }

        /* renamed from: component5, reason: from getter */
        public final String getCoverPath() {
            return this.coverPath;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getNeedUpload() {
            return this.needUpload;
        }

        /* renamed from: component7, reason: from getter */
        public final RecordType getRecordType() {
            return this.recordType;
        }

        public final RecordRequest copy(String id5, UserIdentifier sender, UserIdentifier receiver, Resource resource, String coverPath, boolean needUpload, RecordType recordType) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(resource, "resource");
            Intrinsics.checkNotNullParameter(coverPath, "coverPath");
            Intrinsics.checkNotNullParameter(recordType, "recordType");
            return new RecordRequest(id5, sender, receiver, resource, coverPath, needUpload, recordType);
        }

        public final String getCoverPath() {
            return this.coverPath;
        }

        public final String getId() {
            return this.id;
        }

        public final boolean getNeedUpload() {
            return this.needUpload;
        }

        public final UserIdentifier getReceiver() {
            return this.receiver;
        }

        public final RecordType getRecordType() {
            return this.recordType;
        }

        public final Resource getResource() {
            return this.resource;
        }

        public final UserIdentifier getSender() {
            return this.sender;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.id;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            UserIdentifier userIdentifier = this.sender;
            int hashCode2 = (hashCode + (userIdentifier != null ? userIdentifier.hashCode() : 0)) * 31;
            UserIdentifier userIdentifier2 = this.receiver;
            int hashCode3 = (hashCode2 + (userIdentifier2 != null ? userIdentifier2.hashCode() : 0)) * 31;
            Resource resource = this.resource;
            int hashCode4 = (hashCode3 + (resource != null ? resource.hashCode() : 0)) * 31;
            String str2 = this.coverPath;
            int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z16 = this.needUpload;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode5 + i3) * 31;
            RecordType recordType = this.recordType;
            return i16 + (recordType != null ? recordType.hashCode() : 0);
        }

        public final RecordIdentifier toRecordIdentifier() {
            List listOfNotNull;
            UserIdentifier userIdentifier = this.sender;
            listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(this.receiver);
            return new RecordIdentifier(userIdentifier, listOfNotNull, 0, this.recordType, this.needUpload, 4, null);
        }

        public String toString() {
            return "RecordRequest(id=" + this.id + ", sender=" + this.sender + ", receiver=" + this.receiver + ", resource=" + this.resource + ", coverPath=" + this.coverPath + ", needUpload=" + this.needUpload + ", recordType=" + this.recordType + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecordRequest)) {
                return false;
            }
            RecordRequest recordRequest = (RecordRequest) other;
            return Intrinsics.areEqual(this.id, recordRequest.id) && Intrinsics.areEqual(this.sender, recordRequest.sender) && Intrinsics.areEqual(this.receiver, recordRequest.receiver) && Intrinsics.areEqual(this.resource, recordRequest.resource) && Intrinsics.areEqual(this.coverPath, recordRequest.coverPath) && this.needUpload == recordRequest.needUpload && Intrinsics.areEqual(this.recordType, recordRequest.recordType);
        }

        public static /* synthetic */ RecordRequest copy$default(RecordRequest recordRequest, String str, UserIdentifier userIdentifier, UserIdentifier userIdentifier2, Resource resource, String str2, boolean z16, RecordType recordType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = recordRequest.id;
            }
            if ((i3 & 2) != 0) {
                userIdentifier = recordRequest.sender;
            }
            UserIdentifier userIdentifier3 = userIdentifier;
            if ((i3 & 4) != 0) {
                userIdentifier2 = recordRequest.receiver;
            }
            UserIdentifier userIdentifier4 = userIdentifier2;
            if ((i3 & 8) != 0) {
                resource = recordRequest.resource;
            }
            Resource resource2 = resource;
            if ((i3 & 16) != 0) {
                str2 = recordRequest.coverPath;
            }
            String str3 = str2;
            if ((i3 & 32) != 0) {
                z16 = recordRequest.needUpload;
            }
            boolean z17 = z16;
            if ((i3 & 64) != 0) {
                recordType = recordRequest.recordType;
            }
            return recordRequest.copy(str, userIdentifier3, userIdentifier4, resource2, str3, z17, recordType);
        }
    }
}
