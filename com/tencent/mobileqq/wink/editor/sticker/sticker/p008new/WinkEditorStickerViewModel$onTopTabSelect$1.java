package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.mobileqq.wink.editor.sticker.sticker.p008new.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorStickerViewModel$onTopTabSelect$1", f = "WinkEditorStickerViewModel.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorStickerViewModel$onTopTabSelect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    final /* synthetic */ Ref.ObjectRef<MetaCategory> $selectedCate;
    int label;
    final /* synthetic */ WinkEditorStickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorStickerViewModel$onTopTabSelect$1(WinkEditorStickerViewModel winkEditorStickerViewModel, Ref.ObjectRef<MetaCategory> objectRef, int i3, Continuation<? super WinkEditorStickerViewModel$onTopTabSelect$1> continuation) {
        super(2, continuation);
        this.this$0 = winkEditorStickerViewModel;
        this.$selectedCate = objectRef;
        this.$position = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorStickerViewModel$onTopTabSelect$1(this.this$0, this.$selectedCate, this.$position, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
        ArrayList arrayList;
        IntRange indices;
        int collectionSizeOrDefault;
        boolean z16;
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
            mutableSharedFlow = this.this$0._stickerMenuEvent;
            arrayList = this.this$0.currentData;
            indices = CollectionsKt__CollectionsKt.getIndices(arrayList);
            int i16 = this.$position;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<Integer> it = indices.iterator();
            while (it.hasNext()) {
                if (((IntIterator) it).nextInt() == i16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                arrayList2.add(Boxing.boxBoolean(z16));
            }
            d.TopTabSelect topTabSelect = new d.TopTabSelect(arrayList2, this.$selectedCate.element);
            this.label = 1;
            if (mutableSharedFlow.emit(topTabSelect, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorStickerViewModel$onTopTabSelect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
