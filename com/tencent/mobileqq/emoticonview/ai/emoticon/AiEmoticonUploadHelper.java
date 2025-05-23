package com.tencent.mobileqq.emoticonview.ai.emoticon;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.l;
import com.tencent.qqnt.kernel.api.n;
import com.tencent.qqnt.kernel.nativeinterface.BdhUploadReq;
import com.tencent.qqnt.kernel.nativeinterface.BdhUploadRsp;
import com.tencent.qqnt.kernel.nativeinterface.CheckImageResult;
import com.tencent.qqnt.kernel.nativeinterface.ICheckImageCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadCompleteCallback;
import com.tencent.qqnt.kernel.nativeinterface.PicMaterial;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J9\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000ej\b\u0012\u0004\u0012\u00020\t`\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J=\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010#\u001a\u00020\"8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/ai/emoticon/AiEmoticonUploadHelper;", "", "Lcom/tencent/qqnt/kernel/api/l;", "bdhUploadService", "Lkotlin/Pair;", "", "pathMd5List", "", "extendInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/PicMaterial;", "uploadFile", "(Lcom/tencent/qqnt/kernel/api/l;Lkotlin/Pair;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/api/n;", "emojiService", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "imageList", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckImageResult;", "checkImage", "(Lcom/tencent/qqnt/kernel/api/n;Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "path", "", "getFileLength", "originPath", "getPicThumbPath", "", "Lcom/tencent/mobileqq/emoticonview/ai/emoticon/PicModel;", "picModelList", IEmoticonPanelIpcService.ACTION_UPLOAD_PIC_AND_CHECK, "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "DEFAULT_FILE_EXTENSION", "AI_EMOTICON_FILE_PREFIX", "", "PIC_MAX_SIZE", "I", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AiEmoticonUploadHelper {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String AI_EMOTICON_FILE_PREFIX = "tmp_figure";

    @NotNull
    private static final String DEFAULT_FILE_EXTENSION = "png";

    @NotNull
    public static final AiEmoticonUploadHelper INSTANCE;
    private static final int PIC_MAX_SIZE = 1536;

    @NotNull
    public static final String TAG = "AiEmoticonUploadHelper";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19849);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new AiEmoticonUploadHelper();
        }
    }

    AiEmoticonUploadHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object checkImage(n nVar, ArrayList<PicMaterial> arrayList, Continuation<? super CheckImageResult> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QLog.d(TAG, 1, "checkImage imageUrlList:" + arrayList);
        if (nVar != null) {
            nVar.checkImage(arrayList, new ICheckImageCallback(safeContinuation) { // from class: com.tencent.mobileqq.emoticonview.ai.emoticon.AiEmoticonUploadHelper$checkImage$2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Continuation<CheckImageResult> $continuation;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.$continuation = safeContinuation;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) safeContinuation);
                    }
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.ICheckImageCallback
                public final void onCheckImage(CheckImageResult checkImageResult) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) checkImageResult);
                        return;
                    }
                    QLog.d(AiEmoticonUploadHelper.TAG, 1, "checkImage result:" + checkImageResult);
                    this.$continuation.resumeWith(Result.m476constructorimpl(checkImageResult));
                }
            });
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final long getFileLength(String path) {
        if (TextUtils.isEmpty(path)) {
            return 0L;
        }
        File file = new File(path);
        if (!file.exists()) {
            return 0L;
        }
        return file.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object uploadFile(final l lVar, final Pair<String, String> pair, byte[] bArr, Continuation<? super PicMaterial> continuation) {
        Continuation intercepted;
        final Long l3;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (lVar != null) {
            BdhUploadReq bdhUploadReq = new BdhUploadReq();
            bdhUploadReq.filePath = pair.getFirst();
            bdhUploadReq.commandId = 2021L;
            bdhUploadReq.bizInfo = bArr;
            l3 = lVar.uploadFile(bdhUploadReq, new IKernelBdhUploadCompleteCallback(cancellableContinuationImpl, pair) { // from class: com.tencent.mobileqq.emoticonview.ai.emoticon.AiEmoticonUploadHelper$uploadFile$2$taskId$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ CancellableContinuation<PicMaterial> $continuation;
                final /* synthetic */ Pair<String, String> $pathMd5List;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.$continuation = cancellableContinuationImpl;
                    this.$pathMd5List = pair;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl, (Object) pair);
                    }
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadCompleteCallback
                public final void onResult(int i3, String str, BdhUploadRsp bdhUploadRsp) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bdhUploadRsp);
                        return;
                    }
                    if (this.$continuation.isActive()) {
                        if (i3 != 0) {
                            QLog.e(AiEmoticonUploadHelper.TAG, 1, "upload file failed, result:" + i3 + ", errMsg:" + str);
                            CancellableContinuation<PicMaterial> cancellableContinuation = this.$continuation;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("Upload failed code:" + i3 + ", errMsg:" + str))));
                            return;
                        }
                        if (bdhUploadRsp.status == 3) {
                            try {
                                Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
                                uploadPicExtInfo.mergeFrom(bdhUploadRsp.rspBuf);
                                uploadPicExtInfo.bytes_file_resid.get().toStringUtf8();
                                String stringUtf8 = uploadPicExtInfo.bytes_download_url.get().toStringUtf8();
                                uploadPicExtInfo.bytes_thumb_download_url.get().toStringUtf8();
                                QLog.d(AiEmoticonUploadHelper.TAG, 1, "uploadFile success:path:" + ((Object) this.$pathMd5List.getFirst()) + ", url:" + stringUtf8);
                                PicMaterial picMaterial = new PicMaterial();
                                picMaterial.url = stringUtf8;
                                picMaterial.md5 = this.$pathMd5List.getSecond();
                                this.$continuation.resumeWith(Result.m476constructorimpl(picMaterial));
                            } catch (Exception e16) {
                                CancellableContinuation<PicMaterial> cancellableContinuation2 = this.$continuation;
                                Result.Companion companion2 = Result.INSTANCE;
                                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("Parse upload pic ext info failed:" + e16))));
                            }
                        }
                    }
                }
            });
        } else {
            l3 = null;
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>(l3, lVar) { // from class: com.tencent.mobileqq.emoticonview.ai.emoticon.AiEmoticonUploadHelper$uploadFile$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ l $bdhUploadService;
            final /* synthetic */ Long $taskId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$taskId = l3;
                this.$bdhUploadService = lVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) l3, (Object) lVar);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) th5);
                    return;
                }
                Long l16 = this.$taskId;
                if (l16 != null) {
                    this.$bdhUploadService.cancelUpload(l16.longValue());
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @NotNull
    public final String getPicThumbPath(@NotNull String originPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) originPath);
        }
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        boolean z16 = false;
        CompressInfo compressInfo = new CompressInfo(originPath, 0);
        compressInfo.V = PIC_MAX_SIZE;
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        String str = compressInfo.H;
        if (str == null || str.length() == 0) {
            z16 = true;
        }
        if (z16) {
            QLog.i(TAG, 1, "getPicThumbPath  originPath:" + originPath + ", originSize:" + getFileLength(originPath));
            return originPath;
        }
        long fileLength = getFileLength(originPath);
        String str2 = compressInfo.H;
        Intrinsics.checkNotNullExpressionValue(str2, "compressInfo.destPath");
        QLog.i(TAG, 1, "getPicThumbPath  originPath:" + originPath + ", originSize:" + fileLength + ", destPath:" + str2 + ", destSize:" + getFileLength(str2));
        String str3 = compressInfo.H;
        Intrinsics.checkNotNullExpressionValue(str3, "{\n            QLog.i(TAG\u2026ssInfo.destPath\n        }");
        return str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object uploadPicAndCheck(@NotNull List<Pair<String, String>> list, @NotNull List<PicModel> list2, @NotNull Continuation<? super CheckImageResult> continuation) {
        AiEmoticonUploadHelper$uploadPicAndCheck$1 aiEmoticonUploadHelper$uploadPicAndCheck$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        IKernelService iKernelService;
        l lVar;
        n nVar;
        AiEmoticonUploadHelper aiEmoticonUploadHelper;
        n nVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, list, list2, continuation);
        }
        try {
            if (continuation instanceof AiEmoticonUploadHelper$uploadPicAndCheck$1) {
                aiEmoticonUploadHelper$uploadPicAndCheck$1 = (AiEmoticonUploadHelper$uploadPicAndCheck$1) continuation;
                int i16 = aiEmoticonUploadHelper$uploadPicAndCheck$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    aiEmoticonUploadHelper$uploadPicAndCheck$1.label = i16 - Integer.MIN_VALUE;
                    obj = aiEmoticonUploadHelper$uploadPicAndCheck$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = aiEmoticonUploadHelper$uploadPicAndCheck$1.label;
                    if (i3 == 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                ResultKt.throwOnFailure(obj);
                                return (CheckImageResult) obj;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        nVar2 = (n) aiEmoticonUploadHelper$uploadPicAndCheck$1.L$1;
                        aiEmoticonUploadHelper = (AiEmoticonUploadHelper) aiEmoticonUploadHelper$uploadPicAndCheck$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (peekAppRuntime != null) {
                            iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "");
                        } else {
                            iKernelService = null;
                        }
                        if (iKernelService != null) {
                            lVar = iKernelService.getBdhUploadService();
                        } else {
                            lVar = null;
                        }
                        if (iKernelService != null) {
                            nVar = iKernelService.getEmojiService();
                        } else {
                            nVar = null;
                        }
                        AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1 aiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1 = new AiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1(list, lVar, list2, null);
                        aiEmoticonUploadHelper$uploadPicAndCheck$1.L$0 = this;
                        aiEmoticonUploadHelper$uploadPicAndCheck$1.L$1 = nVar;
                        aiEmoticonUploadHelper$uploadPicAndCheck$1.label = 1;
                        Object coroutineScope = CoroutineScopeKt.coroutineScope(aiEmoticonUploadHelper$uploadPicAndCheck$picMaterialList$1, aiEmoticonUploadHelper$uploadPicAndCheck$1);
                        if (coroutineScope == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aiEmoticonUploadHelper = this;
                        n nVar3 = nVar;
                        obj = coroutineScope;
                        nVar2 = nVar3;
                    }
                    ArrayList<PicMaterial> arrayList = new ArrayList<>((List) obj);
                    aiEmoticonUploadHelper$uploadPicAndCheck$1.L$0 = null;
                    aiEmoticonUploadHelper$uploadPicAndCheck$1.L$1 = null;
                    aiEmoticonUploadHelper$uploadPicAndCheck$1.label = 2;
                    obj = aiEmoticonUploadHelper.checkImage(nVar2, arrayList, aiEmoticonUploadHelper$uploadPicAndCheck$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return (CheckImageResult) obj;
                }
            }
            if (i3 == 0) {
            }
            ArrayList<PicMaterial> arrayList2 = new ArrayList<>((List) obj);
            aiEmoticonUploadHelper$uploadPicAndCheck$1.L$0 = null;
            aiEmoticonUploadHelper$uploadPicAndCheck$1.L$1 = null;
            aiEmoticonUploadHelper$uploadPicAndCheck$1.label = 2;
            obj = aiEmoticonUploadHelper.checkImage(nVar2, arrayList2, aiEmoticonUploadHelper$uploadPicAndCheck$1);
            if (obj == coroutine_suspended) {
            }
            return (CheckImageResult) obj;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "uploadPicAndCheck failed, exception:" + e16);
            return null;
        }
        aiEmoticonUploadHelper$uploadPicAndCheck$1 = new AiEmoticonUploadHelper$uploadPicAndCheck$1(this, continuation);
        obj = aiEmoticonUploadHelper$uploadPicAndCheck$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aiEmoticonUploadHelper$uploadPicAndCheck$1.label;
    }
}
