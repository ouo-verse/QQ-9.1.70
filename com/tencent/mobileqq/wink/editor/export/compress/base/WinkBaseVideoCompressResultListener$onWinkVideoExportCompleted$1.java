package com.tencent.mobileqq.wink.editor.export.compress.base;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.export.ab;
import com.tencent.mobileqq.wink.editor.export.af;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.export.compress.base.WinkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1", f = "WinkBaseVideoCompressResultListener.kt", i = {0, 0}, l = {134}, m = "invokeSuspend", n = {QCircleWeakNetReporter.KEY_COST, "retryCount"}, s = {"J$0", "I$0"})
/* loaded from: classes21.dex */
final class WinkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $exportPath;
    int I$0;
    long J$0;
    int label;
    final /* synthetic */ WinkBaseVideoCompressResultListener this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1(WinkBaseVideoCompressResultListener winkBaseVideoCompressResultListener, String str, Continuation<? super WinkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1> continuation) {
        super(2, continuation);
        this.this$0 = winkBaseVideoCompressResultListener;
        this.$exportPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1(this.this$0, this.$exportPath, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x009d -> B:5:0x0019). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long currentTimeMillis;
        int parseInt;
        WinkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1 winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1;
        boolean z16;
        boolean exists;
        long j3;
        ArrayList<LocalMediaInfo> arrayListOf;
        ExportErrorCode b16;
        long j16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        int i16 = 1;
        if (i3 != 0) {
            if (i3 == 1) {
                parseInt = this.I$0;
                currentTimeMillis = this.J$0;
                ResultKt.throwOnFailure(obj);
                winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1 = this;
                j3 = currentTimeMillis;
                LocalMediaInfo d16 = WinkExportUtils.d(winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.$exportPath);
                Intrinsics.checkNotNullExpressionValue(d16, "buildLocalMediaInfoForVideo(exportPath)");
                af afVar = af.f320186a;
                long k3 = winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.getCompressTask().k();
                String str = winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.winkExportParams.D;
                Intrinsics.checkNotNullExpressionValue(str, "winkExportParams.mBusinessName");
                WinkBaseVideoCompressResultListener winkBaseVideoCompressResultListener = winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0;
                int i17 = winkBaseVideoCompressResultListener.type;
                LocalMediaInfo[] localMediaInfoArr = new LocalMediaInfo[i16];
                LocalMediaInfo localMediaInfo = winkBaseVideoCompressResultListener.winkExportParams.I;
                Intrinsics.checkNotNullExpressionValue(localMediaInfo, "winkExportParams.mLocalMediaInfo");
                localMediaInfoArr[0] = localMediaInfo;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(localMediaInfoArr);
                b16 = afVar.b(d16, k3, str, i17, arrayListOf, winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.winkExportParams.F);
                parseInt--;
                if (b16.transformedCode() != ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_FILE_BITRATE_ZERO && parseInt > 0) {
                    currentTimeMillis = j3;
                    i16 = 1;
                    winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.J$0 = currentTimeMillis;
                    winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.I$0 = parseInt;
                    winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.label = i16;
                    if (DelayKt.delay(1000L, winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = currentTimeMillis;
                    LocalMediaInfo d162 = WinkExportUtils.d(winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.$exportPath);
                    Intrinsics.checkNotNullExpressionValue(d162, "buildLocalMediaInfoForVideo(exportPath)");
                    af afVar2 = af.f320186a;
                    long k36 = winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.getCompressTask().k();
                    String str2 = winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.winkExportParams.D;
                    Intrinsics.checkNotNullExpressionValue(str2, "winkExportParams.mBusinessName");
                    WinkBaseVideoCompressResultListener winkBaseVideoCompressResultListener2 = winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0;
                    int i172 = winkBaseVideoCompressResultListener2.type;
                    LocalMediaInfo[] localMediaInfoArr2 = new LocalMediaInfo[i16];
                    LocalMediaInfo localMediaInfo2 = winkBaseVideoCompressResultListener2.winkExportParams.I;
                    Intrinsics.checkNotNullExpressionValue(localMediaInfo2, "winkExportParams.mLocalMediaInfo");
                    localMediaInfoArr2[0] = localMediaInfo2;
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(localMediaInfoArr2);
                    b16 = afVar2.b(d162, k36, str2, i172, arrayListOf, winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.winkExportParams.F);
                    parseInt--;
                    if (b16.transformedCode() != ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_FILE_BITRATE_ZERO) {
                    }
                    QLog.d(winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.getLogTag(), 1, "onWinkVideoExportCompleted, exportPath:" + winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.$exportPath + ", cost:" + j3 + ", errorCode:" + b16);
                    if (b16.transformedCode() != 0) {
                    }
                    return Unit.INSTANCE;
                }
                QLog.d(winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.getLogTag(), 1, "onWinkVideoExportCompleted, exportPath:" + winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.$exportPath + ", cost:" + j3 + ", errorCode:" + b16);
                if (b16.transformedCode() != 0) {
                    winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.d(b16);
                } else {
                    WinkBaseVideoCompressResultListener winkBaseVideoCompressResultListener3 = winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0;
                    com.tencent.mobileqq.wink.editor.export.c cVar = winkBaseVideoCompressResultListener3.callback;
                    if (cVar != null) {
                        cVar.d(winkBaseVideoCompressResultListener3.winkExportParams.E, d162, true);
                    }
                    ab compressTask = winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.getCompressTask();
                    WinkBaseVideoCompressResultListener winkBaseVideoCompressResultListener4 = winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0;
                    WinkExportParams winkExportParams = winkBaseVideoCompressResultListener4.winkExportParams;
                    int i18 = winkBaseVideoCompressResultListener4.type;
                    j16 = winkBaseVideoCompressResultListener4.videoAheadTime;
                    compressTask.f(winkExportParams, d162, true, false, j3, i18, j16);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        currentTimeMillis = System.currentTimeMillis() - this.this$0.getBeginTime();
        if (QLog.isColorLevel()) {
            String str3 = this.$exportPath;
            if (str3 != null && str3.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                exists = false;
            } else {
                exists = new File(this.$exportPath).exists();
            }
            QLog.d(this.this$0.getLogTag(), 2, "onWinkVideoExportCompleted, exportPath:" + this.$exportPath + ", exists:" + exists);
        }
        parseInt = Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_video_check_retry_count", "3"));
        winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1 = this;
        winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.J$0 = currentTimeMillis;
        winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.I$0 = parseInt;
        winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.label = i16;
        if (DelayKt.delay(1000L, winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1) == coroutine_suspended) {
        }
        j3 = currentTimeMillis;
        LocalMediaInfo d1622 = WinkExportUtils.d(winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.$exportPath);
        Intrinsics.checkNotNullExpressionValue(d1622, "buildLocalMediaInfoForVideo(exportPath)");
        af afVar22 = af.f320186a;
        long k362 = winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.getCompressTask().k();
        String str22 = winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.winkExportParams.D;
        Intrinsics.checkNotNullExpressionValue(str22, "winkExportParams.mBusinessName");
        WinkBaseVideoCompressResultListener winkBaseVideoCompressResultListener22 = winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0;
        int i1722 = winkBaseVideoCompressResultListener22.type;
        LocalMediaInfo[] localMediaInfoArr22 = new LocalMediaInfo[i16];
        LocalMediaInfo localMediaInfo22 = winkBaseVideoCompressResultListener22.winkExportParams.I;
        Intrinsics.checkNotNullExpressionValue(localMediaInfo22, "winkExportParams.mLocalMediaInfo");
        localMediaInfoArr22[0] = localMediaInfo22;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(localMediaInfoArr22);
        b16 = afVar22.b(d1622, k362, str22, i1722, arrayListOf, winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.winkExportParams.F);
        parseInt--;
        if (b16.transformedCode() != ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_FILE_BITRATE_ZERO) {
        }
        QLog.d(winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.this$0.getLogTag(), 1, "onWinkVideoExportCompleted, exportPath:" + winkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1.$exportPath + ", cost:" + j3 + ", errorCode:" + b16);
        if (b16.transformedCode() != 0) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
