package com.tencent.mobileqq.wink.picker.utils;

import com.tencent.luggage.wxa.yf.e0;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.Iterator;
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
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.picker.utils.MediaCompressUtils$compressQzoneMedia$1", f = "MediaCompressUtils.kt", i = {0}, l = {e0.CTRL_INDEX}, m = "invokeSuspend", n = {"index$iv"}, s = {"I$0"})
/* loaded from: classes21.dex */
public final class MediaCompressUtils$compressQzoneMedia$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<LocalMediaInfo> $media;
    final /* synthetic */ Function2<Integer, Float, Unit> $onProgressChanged;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MediaCompressUtils$compressQzoneMedia$1(List<? extends LocalMediaInfo> list, Function2<? super Integer, ? super Float, Unit> function2, Continuation<? super MediaCompressUtils$compressQzoneMedia$1> continuation) {
        super(2, continuation);
        this.$media = list;
        this.$onProgressChanged = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaCompressUtils$compressQzoneMedia$1(this.$media, this.$onProgressChanged, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0067 -> B:5:0x006a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0072 -> B:5:0x006a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0076 -> B:5:0x006a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Function2<Integer, Float, Unit> function2;
        MediaCompressUtils$compressQzoneMedia$1 mediaCompressUtils$compressQzoneMedia$1;
        Iterator it;
        int i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                int i17 = this.I$0;
                it = (Iterator) this.L$1;
                function2 = (Function2) this.L$0;
                ResultKt.throwOnFailure(obj);
                int i18 = i17;
                mediaCompressUtils$compressQzoneMedia$1 = this;
                i3 = i18;
                if (it.hasNext()) {
                    Object next = it.next();
                    i18 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) next;
                    MediaCompressUtils mediaCompressUtils = MediaCompressUtils.f325262a;
                    mediaCompressUtils.o().add(localMediaInfo.path);
                    if (e93.i.I(localMediaInfo)) {
                        mediaCompressUtils$compressQzoneMedia$1.L$0 = function2;
                        mediaCompressUtils$compressQzoneMedia$1.L$1 = it;
                        mediaCompressUtils$compressQzoneMedia$1.I$0 = i18;
                        mediaCompressUtils$compressQzoneMedia$1.label = 1;
                        if (mediaCompressUtils.l(i3, localMediaInfo, function2, mediaCompressUtils$compressQzoneMedia$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (e93.i.G(localMediaInfo)) {
                        mediaCompressUtils.j(i3, localMediaInfo, true, function2);
                    } else {
                        w53.b.f("MediaCompressUtils", "[compressQzoneMedia] type not image or video");
                    }
                    i3 = i18;
                    if (it.hasNext()) {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            List<LocalMediaInfo> list = this.$media;
            function2 = this.$onProgressChanged;
            mediaCompressUtils$compressQzoneMedia$1 = this;
            it = list.iterator();
            i3 = 0;
            if (it.hasNext()) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaCompressUtils$compressQzoneMedia$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
