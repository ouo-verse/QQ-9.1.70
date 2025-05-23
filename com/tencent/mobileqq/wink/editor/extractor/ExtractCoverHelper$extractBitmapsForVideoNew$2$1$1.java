package com.tencent.mobileqq.wink.editor.extractor;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper$extractBitmapsForVideoNew$2$1$1", f = "ExtractCoverHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class ExtractCoverHelper$extractBitmapsForVideoNew$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Long> $clipStamp;
    final /* synthetic */ ArrayList<byte[]> $coverBytesArray;
    final /* synthetic */ CountDownLatch $latch;
    final /* synthetic */ String $path;
    final /* synthetic */ Ref.LongRef $readBytes;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtractCoverHelper$extractBitmapsForVideoNew$2$1$1(String str, List<Long> list, CountDownLatch countDownLatch, Ref.LongRef longRef, ArrayList<byte[]> arrayList, Continuation<? super ExtractCoverHelper$extractBitmapsForVideoNew$2$1$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$clipStamp = list;
        this.$latch = countDownLatch;
        this.$readBytes = longRef;
        this.$coverBytesArray = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ExtractCoverHelper$extractBitmapsForVideoNew$2$1$1(this.$path, this.$clipStamp, this.$latch, this.$readBytes, this.$coverBytesArray, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Bitmap frameAtTime;
        byte[] n3;
        int i3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.$path);
                Iterator<Long> it = this.$clipStamp.iterator();
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    if (Build.VERSION.SDK_INT > 28 && (frameAtTime = mediaMetadataRetriever.getFrameAtTime(longValue, 2)) != null) {
                        Ref.LongRef longRef = this.$readBytes;
                        ArrayList<byte[]> arrayList = this.$coverBytesArray;
                        CountDownLatch countDownLatch = this.$latch;
                        n3 = ExtractCoverHelper.f320276a.n(frameAtTime);
                        w53.b.a("ExtractCoverHelper", "final size: " + n3.length + ", bitmap width: " + frameAtTime.getWidth() + ", height: " + frameAtTime.getHeight());
                        long length = longRef.element + ((long) n3.length);
                        longRef.element = length;
                        i3 = ExtractCoverHelper.EXTRACT_BITMAP_PIC_MAX_BYTE;
                        if (length >= i3) {
                            w53.b.a("ExtractCoverHelper", "over size");
                            if (arrayList.size() == 0) {
                                arrayList.add(n3);
                            }
                            frameAtTime.recycle();
                            mediaMetadataRetriever.release();
                            countDownLatch.countDown();
                            return Unit.INSTANCE;
                        }
                        arrayList.add(n3);
                        frameAtTime.recycle();
                    }
                }
                mediaMetadataRetriever.release();
                this.$latch.countDown();
                return Unit.INSTANCE;
            } catch (Throwable th5) {
                w53.b.c("ExtractCoverHelper", "extractBitmapsForVideoNew error: " + th5);
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ExtractCoverHelper$extractBitmapsForVideoNew$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
