package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.graphics.Bitmap;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.adapter.api.impl.AIOChainAniStickerApiImpl$preparePicAndShow$3$1", f = "AIOChainAniStickerApiImpl.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class AIOChainAniStickerApiImpl$preparePicAndShow$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $localPath;
    final /* synthetic */ int $reportChatType;
    final /* synthetic */ Ref.ObjectRef<Pair<String, Bitmap>> $result;
    final /* synthetic */ int $serverId;
    int label;
    final /* synthetic */ AIOChainAniStickerApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.qqnt.aio.adapter.api.impl.AIOChainAniStickerApiImpl$preparePicAndShow$3$1$1", f = "AIOChainAniStickerApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOChainAniStickerApiImpl$preparePicAndShow$3$1$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $localPath;
        final /* synthetic */ Ref.ObjectRef<Pair<String, Bitmap>> $result;
        final /* synthetic */ int $serverId;
        int label;
        final /* synthetic */ AIOChainAniStickerApiImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<Pair<String, Bitmap>> objectRef, AIOChainAniStickerApiImpl aIOChainAniStickerApiImpl, Activity activity, String str, int i3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = objectRef;
            this.this$0 = aIOChainAniStickerApiImpl;
            this.$activity = activity;
            this.$localPath = str;
            this.$serverId = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$result, this.this$0, this.$activity, this.$localPath, this.$serverId, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            T t16;
            Pair compositeImage;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<Pair<String, Bitmap>> objectRef = this.$result;
                try {
                    AIOChainAniStickerApiImpl aIOChainAniStickerApiImpl = this.this$0;
                    Activity activity = this.$activity;
                    String localPath = this.$localPath;
                    Intrinsics.checkNotNullExpressionValue(localPath, "localPath");
                    compositeImage = aIOChainAniStickerApiImpl.compositeImage(activity, localPath, this.$serverId);
                    t16 = compositeImage;
                } catch (Error e16) {
                    QLog.i("AIOChainAniStickerApiImpl", 1, "compositeImage failed, e:" + e16);
                    t16 = 0;
                }
                objectRef.element = t16;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOChainAniStickerApiImpl$preparePicAndShow$3$1(Ref.ObjectRef<Pair<String, Bitmap>> objectRef, String str, AIOChainAniStickerApiImpl aIOChainAniStickerApiImpl, Activity activity, int i3, int i16, Continuation<? super AIOChainAniStickerApiImpl$preparePicAndShow$3$1> continuation) {
        super(2, continuation);
        this.$result = objectRef;
        this.$localPath = str;
        this.this$0 = aIOChainAniStickerApiImpl;
        this.$activity = activity;
        this.$serverId = i3;
        this.$reportChatType = i16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AIOChainAniStickerApiImpl$preparePicAndShow$3$1(this.$result, this.$localPath, this.this$0, this.$activity, this.$serverId, this.$reportChatType, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io5 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$result, this.this$0, this.$activity, this.$localPath, this.$serverId, null);
            this.label = 1;
            if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.$result.element != null) {
            QLog.i("AIOChainAniStickerApiImpl", 1, "download success, showShareActionSheet, path:" + this.$localPath);
            AIOChainAniStickerApiImpl aIOChainAniStickerApiImpl = this.this$0;
            Activity activity = this.$activity;
            Pair<String, Bitmap> pair = this.$result.element;
            Intrinsics.checkNotNull(pair);
            String first = pair.getFirst();
            Pair<String, Bitmap> pair2 = this.$result.element;
            Intrinsics.checkNotNull(pair2);
            aIOChainAniStickerApiImpl.showShareActionSheet(activity, first, pair2.getSecond(), this.$serverId, this.$reportChatType);
        } else {
            QLog.i("AIOChainAniStickerApiImpl", 1, "download success, compositeImage failed, path:" + this.$localPath);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AIOChainAniStickerApiImpl$preparePicAndShow$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
