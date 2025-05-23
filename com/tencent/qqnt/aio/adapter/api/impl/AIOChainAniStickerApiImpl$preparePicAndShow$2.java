package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.adapter.api.impl.AIOChainAniStickerApiImpl$preparePicAndShow$2", f = "AIOChainAniStickerApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class AIOChainAniStickerApiImpl$preparePicAndShow$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Ref.BooleanRef $fileExist;
    final /* synthetic */ String $localPath;
    final /* synthetic */ Ref.ObjectRef<Pair<String, Bitmap>> $result;
    final /* synthetic */ int $serverId;
    int label;
    final /* synthetic */ AIOChainAniStickerApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOChainAniStickerApiImpl$preparePicAndShow$2(Ref.BooleanRef booleanRef, String str, Ref.ObjectRef<Pair<String, Bitmap>> objectRef, AIOChainAniStickerApiImpl aIOChainAniStickerApiImpl, Activity activity, int i3, Continuation<? super AIOChainAniStickerApiImpl$preparePicAndShow$2> continuation) {
        super(2, continuation);
        this.$fileExist = booleanRef;
        this.$localPath = str;
        this.$result = objectRef;
        this.this$0 = aIOChainAniStickerApiImpl;
        this.$activity = activity;
        this.$serverId = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AIOChainAniStickerApiImpl$preparePicAndShow$2(this.$fileExist, this.$localPath, this.$result, this.this$0, this.$activity, this.$serverId, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        T t16;
        Pair compositeImage;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$fileExist.element = FileUtils.fileExists(this.$localPath);
            if (this.$fileExist.element) {
                Ref.ObjectRef<Pair<String, Bitmap>> objectRef = this.$result;
                try {
                    AIOChainAniStickerApiImpl aIOChainAniStickerApiImpl = this.this$0;
                    Activity activity = this.$activity;
                    String localPath = this.$localPath;
                    Intrinsics.checkNotNullExpressionValue(localPath, "localPath");
                    compositeImage = aIOChainAniStickerApiImpl.compositeImage(activity, localPath, this.$serverId);
                    t16 = compositeImage;
                } catch (Throwable th5) {
                    QLog.e("AIOChainAniStickerApiImpl", 1, "compositeImage failed, throwable:" + th5);
                    t16 = 0;
                }
                objectRef.element = t16;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AIOChainAniStickerApiImpl$preparePicAndShow$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
