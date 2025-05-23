package com.qzone.reborn.feedpro.utils;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.reborn.feedpro.utils.QzoneFeedProLongPicUtils$realSaveLongPic$1$1$1", f = "QzoneFeedProLongPicUtils.kt", i = {0}, l = {121}, m = "invokeSuspend", n = {"currentPic"}, s = {"L$0"})
/* loaded from: classes37.dex */
final class QzoneFeedProLongPicUtils$realSaveLongPic$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $downloadPicList;
    final /* synthetic */ int $index;
    final /* synthetic */ List<String> $localPathUrlList;
    final /* synthetic */ String[] $tempSavePaths;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProLongPicUtils$realSaveLongPic$1$1$1(List<String> list, int i3, List<String> list2, String[] strArr, Continuation<? super QzoneFeedProLongPicUtils$realSaveLongPic$1$1$1> continuation) {
        super(2, continuation);
        this.$downloadPicList = list;
        this.$index = i3;
        this.$localPathUrlList = list2;
        this.$tempSavePaths = strArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QzoneFeedProLongPicUtils$realSaveLongPic$1$1$1(this.$downloadPicList, this.$index, this.$localPathUrlList, this.$tempSavePaths, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object i3;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = this.$downloadPicList.get(this.$index);
            String str3 = this.$localPathUrlList.get(this.$index);
            String str4 = System.currentTimeMillis() + this.$index + ".jpeg";
            String newFilePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE + str4);
            this.$tempSavePaths[this.$index] = newFilePath;
            QzoneFeedProLongPicUtils qzoneFeedProLongPicUtils = QzoneFeedProLongPicUtils.f54255a;
            Intrinsics.checkNotNullExpressionValue(newFilePath, "newFilePath");
            this.L$0 = str2;
            this.label = 1;
            i3 = qzoneFeedProLongPicUtils.i(str2, str3, newFilePath, this);
            if (i3 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = str2;
            obj = i3;
        } else if (i16 == 1) {
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            return Unit.INSTANCE;
        }
        throw new IOException("save picError:" + str);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QzoneFeedProLongPicUtils$realSaveLongPic$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
