package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.j;
import com.tencent.qqnt.http.api.l;
import com.tencent.qqnt.http.api.m;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.HWDetailMediaDataModel$downloadFileItem$1", f = "HWDetailMediaDataModel.kt", i = {}, l = {191, 239}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWDetailMediaDataModel$downloadFileItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ FileItem $item;
    final /* synthetic */ Function0<Unit> $openCallback;
    final /* synthetic */ Function0<Unit> $updateCallback;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ HWDetailMediaDataModel<T> this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel$downloadFileItem$1$a", "Lcom/tencent/qqnt/http/api/l;", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/m;", "result", "", "onFailed", "onSuccess", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements l {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HWDetailMediaDataModel<T> f296779a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f296780b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FileItem f296781c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f296782d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f296783e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f296784f;

        a(HWDetailMediaDataModel<T> hWDetailMediaDataModel, String str, FileItem fileItem, Function0<Unit> function0, String str2, Function0<Unit> function02) {
            this.f296779a = hWDetailMediaDataModel;
            this.f296780b = str;
            this.f296781c = fileItem;
            this.f296782d = function0;
            this.f296783e = str2;
            this.f296784f = function02;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, hWDetailMediaDataModel, str, fileItem, function0, str2, function02);
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onFailed(@NotNull com.tencent.qqnt.http.api.b task, @NotNull m result) {
            ConcurrentHashMap concurrentHashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.w("HW.MediaEdit.HWDetailMediaDataModel", 1, "downloadFileItem, onFailed, " + task.x() + ", " + result);
            concurrentHashMap = ((HWDetailMediaDataModel) this.f296779a).downloadFileTaskMap;
            concurrentHashMap.remove(this.f296780b);
            this.f296781c.setState(UploadOrDownloadState.DOWNLOAD_ERR);
            Function0<Unit> function0 = this.f296782d;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onSuccess(@NotNull com.tencent.qqnt.http.api.b task, @NotNull m result) {
            ConcurrentHashMap concurrentHashMap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) task, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("HW.MediaEdit.HWDetailMediaDataModel", 1, "downloadFileItem, onSuccess, " + task.x());
            this.f296781c.setLocalPath(this.f296783e);
            concurrentHashMap = ((HWDetailMediaDataModel) this.f296779a).downloadFileTaskMap;
            concurrentHashMap.remove(this.f296780b);
            this.f296781c.setState(UploadOrDownloadState.DOWNLOAD_SUC);
            Function0<Unit> function0 = this.f296782d;
            if (function0 != null) {
                function0.invoke();
            }
            Function0<Unit> function02 = this.f296784f;
            if (function02 != null) {
                function02.invoke();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/HWDetailMediaDataModel$downloadFileItem$1$b", "Lcom/tencent/qqnt/http/api/j;", "Lcom/tencent/qqnt/http/api/b;", "task", "", "writeLength", "contentLength", "", "onProgress", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileItem f296785a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f296786b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(FileItem fileItem, Function0<Unit> function0) {
            super(0L, 1, null);
            this.f296785a = fileItem;
            this.f296786b = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fileItem, (Object) function0);
            }
        }

        @Override // com.tencent.qqnt.http.api.j
        public void onProgress(@NotNull com.tencent.qqnt.http.api.b task, long writeLength, long contentLength) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, task, Long.valueOf(writeLength), Long.valueOf(contentLength));
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            if (QLog.isColorLevel()) {
                QLog.d("HW.MediaEdit.HWDetailMediaDataModel", 4, "downloadFileItem, onProgress:" + ((writeLength * 100.0d) / contentLength));
            }
            this.f296785a.setProgress((((float) writeLength) * 1.0f) / ((float) contentLength));
            Function0<Unit> function0 = this.f296786b;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWDetailMediaDataModel$downloadFileItem$1(FileItem fileItem, Function0<Unit> function0, String str, HWDetailMediaDataModel<T> hWDetailMediaDataModel, Function0<Unit> function02, Continuation<? super HWDetailMediaDataModel$downloadFileItem$1> continuation) {
        super(2, continuation);
        this.$item = fileItem;
        this.$openCallback = function0;
        this.$url = str;
        this.this$0 = hWDetailMediaDataModel;
        this.$updateCallback = function02;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fileItem, function0, str, hWDetailMediaDataModel, function02, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new HWDetailMediaDataModel$downloadFileItem$1(this.$item, this.$openCallback, this.$url, this.this$0, this.$updateCallback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ConcurrentHashMap concurrentHashMap;
        IHttpService m3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_HOMEWORK_NOTICE_FILE + this.$item.getFileName());
            File file = new File(sDKPrivatePath);
            if (file.exists()) {
                String fileMd5 = this.$item.getFileMd5();
                if (fileMd5 != null && fileMd5.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16 && Intrinsics.areEqual(HexUtil.bytes2HexStr(MD5.getFileMd5(sDKPrivatePath)), this.$item.getFileMd5())) {
                    QLog.i("HW.MediaEdit.HWDetailMediaDataModel", 1, "downloadFileItem, file exists, " + sDKPrivatePath);
                    this.$item.setLocalPath(sDKPrivatePath);
                    Function0<Unit> function0 = this.$openCallback;
                    if (function0 != null) {
                        HWDetailMediaDataModel<T> hWDetailMediaDataModel = this.this$0;
                        this.label = 1;
                        if (hWDetailMediaDataModel.e(function0, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                file.delete();
                file.createNewFile();
            } else {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    Boxing.boxBoolean(parentFile.mkdirs());
                }
                file.createNewFile();
            }
            QLog.i("HW.MediaEdit.HWDetailMediaDataModel", 1, "downloadFileItem, start downloadPath:" + sDKPrivatePath);
            b.a aVar = new b.a("hw_notice_file", this.$url, new File(sDKPrivatePath));
            aVar.P(new a(this.this$0, this.$url, this.$item, this.$updateCallback, sDKPrivatePath, this.$openCallback));
            aVar.O(new b(this.$item, this.$updateCallback));
            com.tencent.qqnt.http.api.b c16 = aVar.c();
            concurrentHashMap = ((HWDetailMediaDataModel) this.this$0).downloadFileTaskMap;
            concurrentHashMap.put(this.$url, c16);
            m3 = this.this$0.m();
            m3.asyncExecute(c16);
            this.$item.setProgress(0.0f);
            this.$item.setState(UploadOrDownloadState.DOWNLOADING);
            Function0<Unit> function02 = this.$updateCallback;
            if (function02 != null) {
                HWDetailMediaDataModel<T> hWDetailMediaDataModel2 = this.this$0;
                this.label = 2;
                if (hWDetailMediaDataModel2.e(function02, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWDetailMediaDataModel$downloadFileItem$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
