package com.tencent.filament.zplan.scene.xwconnect.handler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectDrawHandler;
import com.tencent.filament.zplanservice.pbjava.XwConnect$DrawImageReq;
import com.tencent.filament.zplanservice.pbjava.XwConnect$ImagePixel;
import com.tencent.filament.zplanservice.pbjava.XwConnect$ImageRsp;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.util.List;
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
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.xwconnect.handler.MiniHomeConnectDrawHandler$drawImage$1", f = "MiniHomeConnectDrawHandler.kt", i = {0}, l = {163}, m = "invokeSuspend", n = {"dataReq"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class MiniHomeConnectDrawHandler$drawImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.filament.zplanservice.channel.a $callbackN2C;
    final /* synthetic */ MessageMicro $pbField;
    Object L$0;
    int label;
    final /* synthetic */ MiniHomeConnectDrawHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectDrawHandler$drawImage$1(MiniHomeConnectDrawHandler miniHomeConnectDrawHandler, MessageMicro messageMicro, com.tencent.filament.zplanservice.channel.a aVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = miniHomeConnectDrawHandler;
        this.$pbField = messageMicro;
        this.$callbackN2C = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new MiniHomeConnectDrawHandler$drawImage$1(this.this$0, this.$pbField, this.$callbackN2C, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeConnectDrawHandler$drawImage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        XwConnect$DrawImageReq xwConnect$DrawImageReq;
        MiniHomeConnectDrawHandler.c cVar;
        List<XwConnect$ImagePixel> mutableListOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    xwConnect$DrawImageReq = (XwConnect$DrawImageReq) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                MessageMicro messageMicro = this.$pbField;
                if (messageMicro != null) {
                    XwConnect$DrawImageReq xwConnect$DrawImageReq2 = (XwConnect$DrawImageReq) messageMicro;
                    MiniHomeConnectDrawHandler miniHomeConnectDrawHandler = this.this$0;
                    String str = xwConnect$DrawImageReq2.url.get();
                    Intrinsics.checkNotNullExpressionValue(str, "dataReq.url.get()");
                    this.L$0 = xwConnect$DrawImageReq2;
                    this.label = 1;
                    Object d16 = MiniHomeConnectDrawHandler.d(miniHomeConnectDrawHandler, str, null, this, 2, null);
                    if (d16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    xwConnect$DrawImageReq = xwConnect$DrawImageReq2;
                    obj = d16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.filament.zplanservice.pbjava.XwConnect.DrawImageReq");
                }
            }
            cVar = (MiniHomeConnectDrawHandler.c) obj;
        } catch (Throwable th5) {
            FLog.INSTANCE.e("ConnectHandler_MiniHomeConnectDrawHandler", "drawImage failed, throw: " + th5);
            com.tencent.filament.zplanservice.channel.handler.a.d(this.$callbackN2C, 0, "drawImage failed.", 1, null);
        }
        if ((cVar instanceof MiniHomeConnectDrawHandler.c.Success) && ((MiniHomeConnectDrawHandler.c.Success) cVar).getFilePath() != null && new File(((MiniHomeConnectDrawHandler.c.Success) cVar).getFilePath()).isFile()) {
            Bitmap decodeFile = BitmapFactory.decodeFile(((MiniHomeConnectDrawHandler.c.Success) cVar).getFilePath());
            if (decodeFile != null) {
                int width = decodeFile.getWidth();
                int height = decodeFile.getHeight();
                try {
                    if (width != 0 && height != 0) {
                        ByteBuffer allocate = ByteBuffer.allocate(decodeFile.getByteCount());
                        decodeFile.copyPixelsToBuffer(allocate);
                        decodeFile.recycle();
                        XwConnect$ImageRsp xwConnect$ImageRsp = new XwConnect$ImageRsp();
                        xwConnect$ImageRsp.scene_address.set(xwConnect$DrawImageReq.scene_address.get());
                        PBRepeatMessageField<XwConnect$ImagePixel> pBRepeatMessageField = xwConnect$ImageRsp.mipmap_data;
                        XwConnect$ImagePixel xwConnect$ImagePixel = new XwConnect$ImagePixel();
                        PBBytesField pBBytesField = xwConnect$ImagePixel.data;
                        byte[] array = allocate.array();
                        Intrinsics.checkNotNullExpressionValue(array, "buffer.array()");
                        pBBytesField.set(com.tencent.filament.zplanservice.util.d.b(array));
                        xwConnect$ImagePixel.width.set(width);
                        xwConnect$ImagePixel.height.set(height);
                        xwConnect$ImagePixel.level.set(0);
                        Unit unit = Unit.INSTANCE;
                        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(xwConnect$ImagePixel);
                        pBRepeatMessageField.set(mutableListOf);
                        com.tencent.filament.zplanservice.channel.handler.a.e(this.$callbackN2C, xwConnect$ImageRsp);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("\u56fe\u7247\u5927\u5c0f\u4e3a0 " + xwConnect$DrawImageReq.url.get() + TokenParser.SP + cVar);
                } catch (Throwable th6) {
                    decodeFile.recycle();
                    throw th6;
                }
            }
            throw new IllegalStateException("\u56fe\u7247\u52a0\u8f7d\u5931\u8d25 " + xwConnect$DrawImageReq.url.get() + TokenParser.SP + cVar);
        }
        throw new FileNotFoundException("\u4e0b\u8f7d\u5931\u8d25 " + xwConnect$DrawImageReq.url.get() + TokenParser.SP + cVar);
    }
}
