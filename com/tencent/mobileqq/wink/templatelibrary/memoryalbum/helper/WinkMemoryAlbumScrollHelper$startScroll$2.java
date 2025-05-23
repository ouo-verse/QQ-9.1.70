package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper.WinkMemoryAlbumScrollHelper$startScroll$2", f = "WinkMemoryAlbumScrollHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkMemoryAlbumScrollHelper$startScroll$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WinkMemoryAlbumScrollHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMemoryAlbumScrollHelper$startScroll$2(WinkMemoryAlbumScrollHelper winkMemoryAlbumScrollHelper, Continuation<? super WinkMemoryAlbumScrollHelper$startScroll$2> continuation) {
        super(2, continuation);
        this.this$0 = winkMemoryAlbumScrollHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkMemoryAlbumScrollHelper$startScroll$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        RecyclerView recyclerView;
        String str;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            recyclerView = this.this$0.recyclerView;
            Context context = recyclerView.getContext();
            str = this.this$0.com.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String;
            QQToast.makeText(context, str + "\u5408\u96c6\u5df2\u4e0d\u5b58\u5728\uff0c\u67e5\u770b\u5176\u4ed6\u5408\u96c6\u5427\u3002", 0).show();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkMemoryAlbumScrollHelper$startScroll$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
