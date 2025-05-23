package com.tencent.mobileqq.wink.editor;

import com.tencent.qphone.base.util.QLog;
import com.tencent.videocut.model.MediaClip;
import java.util.ArrayList;
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
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.WinkEditorFragment$initTavCut$6", f = "WinkEditorFragment.kt", i = {}, l = {1505}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorFragment$initTavCut$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WinkEditorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorFragment$initTavCut$6(WinkEditorFragment winkEditorFragment, Continuation<? super WinkEditorFragment$initTavCut$6> continuation) {
        super(2, continuation);
        this.this$0 = winkEditorFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorFragment$initTavCut$6(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.mobileqq.wink.editor.recommend.b Yk;
        List<MediaClip> emptyList;
        com.tencent.mobileqq.wink.editor.recommend.b Yk2;
        ArrayList<byte[]> arrayList;
        List<MediaClip> emptyList2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            WinkEditorFragment$initTavCut$6$result$1 winkEditorFragment$initTavCut$6$result$1 = new WinkEditorFragment$initTavCut$6$result$1(this.this$0, null);
            this.label = 1;
            obj = TimeoutKt.withTimeoutOrNull(3000L, winkEditorFragment$initTavCut$6$result$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        long j3 = 0;
        if (((Boolean) obj) != null) {
            Yk2 = this.this$0.Yk();
            arrayList = this.this$0.extractResult;
            dr drVar = this.this$0.curTavCut;
            if (drVar == null || (emptyList2 = drVar.g0()) == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            }
            List<MediaClip> list = emptyList2;
            long currentTimeMillis = System.currentTimeMillis();
            boolean isAllImages = this.this$0.Tk().getIsAllImages();
            dr drVar2 = this.this$0.curTavCut;
            if (drVar2 != null) {
                j3 = drVar2.getDurationUs();
            }
            Yk2.L1(arrayList, list, currentTimeMillis, isAllImages, j3);
        } else {
            QLog.i("WinkEditorFragment", 1, "extractResult null");
            Yk = this.this$0.Yk();
            dr drVar3 = this.this$0.curTavCut;
            if (drVar3 == null || (emptyList = drVar3.g0()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            boolean isAllImages2 = this.this$0.Tk().getIsAllImages();
            dr drVar4 = this.this$0.curTavCut;
            if (drVar4 != null) {
                j3 = drVar4.getDurationUs();
            }
            Yk.M1(emptyList, isAllImages2, j3);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorFragment$initTavCut$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
