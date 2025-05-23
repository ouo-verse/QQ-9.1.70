package com.tencent.mobileqq.matchfriend.reborn.publish.upload;

import android.graphics.BitmapFactory;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.l;
import com.tencent.qqnt.kernel.nativeinterface.BdhUploadReq;
import com.tencent.qqnt.kernel.nativeinterface.BdhUploadRsp;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadCompleteCallback;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import mqq.app.MobileQQ;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\u0010\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J1\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/upload/SquareFeedPicUploader;", "", "Lcom/tencent/qqnt/kernel/api/l;", "f", "", "path", "", ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "Lcom/tencent/mobileqq/matchfriend/reborn/publish/upload/a;", "k", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "rspData", "", "width", "height", "j", "uploadPath", "Lcom/tencent/qqnt/kernel/nativeinterface/BdhUploadReq;", "i", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "e", h.F, "g", "", "paths", "l", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SquareFeedPicUploader {

    /* renamed from: a, reason: collision with root package name */
    public static final SquareFeedPicUploader f245352a = new SquareFeedPicUploader();

    SquareFeedPicUploader() {
    }

    private final ByteStringMicro e(String uploadPath) {
        ByteStringMicro copyFromUtf8 = ByteStringMicro.copyFromUtf8(h() + "-" + g(uploadPath) + ".jpg");
        Intrinsics.checkNotNullExpressionValue(copyFromUtf8, "copyFromUtf8(filePath)");
        return copyFromUtf8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final l f() {
        l bdhUploadService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getBdhUploadService();
        if (bdhUploadService == null) {
            QLog.e("SquareFeedPicUploader", 1, "getKernelBdhUploadService is null.");
        }
        return bdhUploadService;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String g(String path) {
        FileInputStream fileInputStream;
        byte[] hexStr2Bytes;
        File file = new File(path);
        FileInputStream fileInputStream2 = null;
        r4 = null;
        r4 = null;
        byte[] bArr = null;
        try {
            try {
                fileInputStream = new FileInputStream(path);
            } catch (IOException e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    hexStr2Bytes = MD5.toMD5Byte(fileInputStream, file.length());
                } catch (UnsatisfiedLinkError unused) {
                    if (file.exists()) {
                        String d16 = com.tencent.qqprotect.singleupdate.a.d(file);
                        Intrinsics.checkNotNullExpressionValue(d16, "getFileMD5String(file)");
                        hexStr2Bytes = HexUtil.hexStr2Bytes(d16);
                    }
                }
                bArr = hexStr2Bytes;
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    QLog.e("SquareFeedPicUploader", 1, e17, new Object[0]);
                }
            } catch (IOException e18) {
                e = e18;
                QLog.e("SquareFeedPicUploader", 1, e, new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e19) {
                        QLog.e("SquareFeedPicUploader", 1, e19, new Object[0]);
                    }
                }
                String bytes2HexStr = HexUtil.bytes2HexStr(bArr);
                Intrinsics.checkNotNullExpressionValue(bytes2HexStr, "bytes2HexStr(mLocalMd5)");
                return bytes2HexStr;
            }
            String bytes2HexStr2 = HexUtil.bytes2HexStr(bArr);
            Intrinsics.checkNotNullExpressionValue(bytes2HexStr2, "bytes2HexStr(mLocalMd5)");
            return bytes2HexStr2;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e26) {
                    QLog.e("SquareFeedPicUploader", 1, e26, new Object[0]);
                }
            }
            throw th;
        }
    }

    private final int h() {
        return new Random().nextInt(90000000) + 10000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BdhUploadReq i(String uploadPath) {
        BdhUploadReq bdhUploadReq = new BdhUploadReq();
        bdhUploadReq.commandId = 84L;
        bdhUploadReq.filePath = uploadPath;
        bdhUploadReq.priority = 1;
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(f245352a.e(uploadPath));
        bdhUploadReq.bizInfo = commFileExtReq.toByteArray();
        return bdhUploadReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PicUploadResult j(byte[] rspData, int width, int height) {
        if (rspData == null) {
            QLog.e("SquareFeedPicUploader", 1, "[handleOnUploadSuccess] rspData is null.");
            return new PicUploadResult(false, null, 0, 0, 14, null);
        }
        Bdh_extinfo.CommFileExtRsp commFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
        try {
            commFileExtRsp.mergeFrom(rspData);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("SquareFeedPicUploader", 1, e16, new Object[0]);
        }
        ByteStringMicro byteStringMicro = commFileExtRsp.bytes_download_url.get();
        String stringUtf8 = byteStringMicro != null ? byteStringMicro.toStringUtf8() : null;
        if (stringUtf8 == null) {
            stringUtf8 = "";
        }
        QLog.i("SquareFeedPicUploader", 1, "[handleOnUploadSuccess] resultCode=" + commFileExtRsp.int32_retcode.get() + ", url=" + stringUtf8);
        return new PicUploadResult(true, stringUtf8, width, height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object k(String str, boolean z16, Continuation<? super PicUploadResult> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        final long currentTimeMillis = System.currentTimeMillis();
        if (z16) {
            CompressInfo compressInfo = new CompressInfo(str, 0);
            compressInfo.K = 0;
            ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
            String str2 = compressInfo.H;
            Intrinsics.checkNotNullExpressionValue(str2, "compressInfo.destPath");
            if (str2.length() > 0) {
                str = compressInfo.H;
                Intrinsics.checkNotNullExpressionValue(str, "compressInfo.destPath");
            }
            if (QLog.isDevelopLevel()) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                String str3 = compressInfo.H;
                QLog.d("SquareFeedPicUploader", 4, "[uploadPic] compress cost:" + currentTimeMillis2 + ", success=" + (!(str3 == null || str3.length() == 0)));
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        final int i3 = options.outWidth;
        final int i16 = options.outHeight;
        QLog.i("SquareFeedPicUploader", 1, "[uploadPic] width=" + i3 + ", height=" + i16);
        SquareFeedPicUploader squareFeedPicUploader = f245352a;
        l f16 = squareFeedPicUploader.f();
        QLog.i("SquareFeedPicUploader", 1, "start upload pic taskId=" + (f16 != null ? f16.uploadFile(squareFeedPicUploader.i(str), new IKernelBdhUploadCompleteCallback() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.upload.SquareFeedPicUploader$uploadPic$2$taskId$1
            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadCompleteCallback
            public void onResult(int result, String errMsg, BdhUploadRsp rsp) {
                PicUploadResult j3;
                Long valueOf = rsp != null ? Long.valueOf(rsp.taskId) : null;
                switch (result) {
                    case 2006013:
                    case 2006014:
                        QLog.i("SquareFeedPicUploader", 1, "[uploadFile] onResult, task cancel. result=" + result + ", taskId=" + valueOf);
                        return;
                    default:
                        if (result != 0) {
                            QLog.i("SquareFeedPicUploader", 1, "[uploadFile] onResult, result=" + result + ", taskId=" + valueOf + ", errMsg=" + errMsg);
                            cancellableContinuationImpl.resume(new PicUploadResult(false, null, 0, 0, 14, null), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.upload.SquareFeedPicUploader$uploadPic$2$taskId$1$onResult$1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }
                            });
                            return;
                        }
                        if (rsp == null) {
                            QLog.e("SquareFeedPicUploader", 1, "[uploadFile] onResult, rsp is null.");
                            return;
                        }
                        int i17 = rsp.status;
                        if (i17 == 1) {
                            QLog.i("SquareFeedPicUploader", 1, "[uploadFile] trans onStart, taskId=" + valueOf);
                            return;
                        }
                        if (i17 == 2) {
                            QLog.d("SquareFeedPicUploader", 4, "[uploadFile] trans onProcess, taskId=" + valueOf + ", process=" + rsp.process);
                            return;
                        }
                        if (i17 != 3) {
                            QLog.e("SquareFeedPicUploader", 1, "[uploadFile] unknown status=" + i17 + ", taskId=" + valueOf);
                            return;
                        }
                        QLog.i("SquareFeedPicUploader", 1, "[uploadFile] trans onSuccess, taskId=" + valueOf + ", cost:" + (System.currentTimeMillis() - currentTimeMillis));
                        CancellableContinuation<PicUploadResult> cancellableContinuation = cancellableContinuationImpl;
                        j3 = SquareFeedPicUploader.f245352a.j(rsp.rspBuf, i3, i16);
                        cancellableContinuation.resume(j3, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.upload.SquareFeedPicUploader$uploadPic$2$taskId$1$onResult$2
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }
                        });
                        return;
                }
            }
        }) : null));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0082 -> B:16:0x0083). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object l(List<String> list, boolean z16, Continuation<? super List<PicUploadResult>> continuation) {
        SquareFeedPicUploader$uploadPics$1 squareFeedPicUploader$uploadPics$1;
        Object coroutine_suspended;
        int i3;
        int collectionSizeOrDefault;
        Iterator it;
        boolean z17;
        Collection collection;
        if (continuation instanceof SquareFeedPicUploader$uploadPics$1) {
            squareFeedPicUploader$uploadPics$1 = (SquareFeedPicUploader$uploadPics$1) continuation;
            int i16 = squareFeedPicUploader$uploadPics$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                squareFeedPicUploader$uploadPics$1.label = i16 - Integer.MIN_VALUE;
                Object obj = squareFeedPicUploader$uploadPics$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = squareFeedPicUploader$uploadPics$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    List<String> list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    it = list2.iterator();
                    z17 = z16;
                    collection = arrayList;
                    if (it.hasNext()) {
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z17 = squareFeedPicUploader$uploadPics$1.Z$0;
                    collection = (Collection) squareFeedPicUploader$uploadPics$1.L$2;
                    it = (Iterator) squareFeedPicUploader$uploadPics$1.L$1;
                    Collection collection2 = (Collection) squareFeedPicUploader$uploadPics$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    collection.add((Deferred) obj);
                    collection = collection2;
                    if (it.hasNext()) {
                        SquareFeedPicUploader$uploadPics$resultList$1$1 squareFeedPicUploader$uploadPics$resultList$1$1 = new SquareFeedPicUploader$uploadPics$resultList$1$1((String) it.next(), z17, null);
                        squareFeedPicUploader$uploadPics$1.L$0 = collection;
                        squareFeedPicUploader$uploadPics$1.L$1 = it;
                        squareFeedPicUploader$uploadPics$1.L$2 = collection;
                        squareFeedPicUploader$uploadPics$1.Z$0 = z17;
                        squareFeedPicUploader$uploadPics$1.label = 1;
                        obj = CoroutineScopeKt.coroutineScope(squareFeedPicUploader$uploadPics$resultList$1$1, squareFeedPicUploader$uploadPics$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        collection2 = collection;
                        collection.add((Deferred) obj);
                        collection = collection2;
                        if (it.hasNext()) {
                            squareFeedPicUploader$uploadPics$1.L$0 = null;
                            squareFeedPicUploader$uploadPics$1.L$1 = null;
                            squareFeedPicUploader$uploadPics$1.L$2 = null;
                            squareFeedPicUploader$uploadPics$1.label = 2;
                            obj = AwaitKt.awaitAll((List) collection, squareFeedPicUploader$uploadPics$1);
                            return obj == coroutine_suspended ? coroutine_suspended : obj;
                        }
                    }
                }
            }
        }
        squareFeedPicUploader$uploadPics$1 = new SquareFeedPicUploader$uploadPics$1(this, continuation);
        Object obj2 = squareFeedPicUploader$uploadPics$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = squareFeedPicUploader$uploadPics$1.label;
        if (i3 != 0) {
        }
    }

    public static /* synthetic */ Object m(SquareFeedPicUploader squareFeedPicUploader, List list, boolean z16, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return squareFeedPicUploader.l(list, z16, continuation);
    }
}
