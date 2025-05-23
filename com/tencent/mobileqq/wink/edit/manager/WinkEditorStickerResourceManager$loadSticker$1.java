package com.tencent.mobileqq.wink.edit.manager;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import java.util.ArrayList;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.edit.manager.WinkEditorStickerResourceManager$loadSticker$1", f = "WinkEditorStickerResourceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorStickerResourceManager$loadSticker$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromAttach;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorStickerResourceManager$loadSticker$1(boolean z16, Continuation<? super WinkEditorStickerResourceManager$loadSticker$1> continuation) {
        super(2, continuation);
        this.$fromAttach = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorStickerResourceManager$loadSticker$1(this.$fromAttach, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ArrayList<MetaCategory> f16;
        Object obj2;
        Object obj3;
        Object obj4;
        ArrayList<MetaCategory> k3;
        List<MetaCategory> listOfNotNull;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList<MetaCategory> H1 = WinkEditorResourceManager.a1().H1();
            Intrinsics.checkNotNullExpressionValue(H1, "getInstance().stickerCategory");
            ArrayList arrayList = new ArrayList();
            f16 = WinkEditorStickerResourceManager.f318326a.f(H1);
            Iterator<T> it = f16.iterator();
            while (true) {
                obj2 = null;
                if (it.hasNext()) {
                    obj3 = it.next();
                    if (Intrinsics.areEqual(((MetaCategory) obj3).f30532id, "1000290")) {
                        break;
                    }
                } else {
                    obj3 = null;
                    break;
                }
            }
            MetaCategory metaCategory = (MetaCategory) obj3;
            if (metaCategory != null) {
                metaCategory.name = "\u70ed\u95e8\u5173\u952e\u8bcd";
            }
            TypeIntrinsics.asMutableCollection(f16).remove(metaCategory);
            Iterator<T> it5 = f16.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj4 = it5.next();
                    if (Intrinsics.areEqual(((MetaCategory) obj4).f30532id, "1000291")) {
                        break;
                    }
                } else {
                    obj4 = null;
                    break;
                }
            }
            MetaCategory metaCategory2 = (MetaCategory) obj4;
            if (metaCategory2 != null) {
                metaCategory2.name = "\u70ed\u95e8\u8d34\u7eb8";
            }
            TypeIntrinsics.asMutableCollection(f16).remove(metaCategory2);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(f16);
            WinkEditorResourceManager.a1().I1().postValue(arrayList2);
            Iterator<T> it6 = f16.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    break;
                }
                Object next = it6.next();
                if (Intrinsics.areEqual(((MetaCategory) next).f30532id, "100029")) {
                    obj2 = next;
                    break;
                }
            }
            MetaCategory metaCategory3 = (MetaCategory) obj2;
            TypeIntrinsics.asMutableCollection(f16).remove(metaCategory3);
            WinkEditorResourceManager.a1().Y0().postValue(metaCategory2);
            WinkEditorResourceManager.a1().D1().postValue(com.tencent.mobileqq.wink.editor.sticker.sticker.h.INSTANCE.l(f16, metaCategory2));
            MetaCategory metaCategory4 = new MetaCategory();
            metaCategory4.f30532id = "common_sticker";
            metaCategory4.name = "\u8d34\u7eb8";
            metaCategory4.subCategories = f16;
            arrayList.add(metaCategory4);
            MetaCategory metaCategory5 = new MetaCategory();
            boolean z16 = this.$fromAttach;
            metaCategory5.f30532id = "qq_sticker";
            metaCategory5.name = "QQ\u8868\u60c5";
            WinkEditorStickerResourceManager winkEditorStickerResourceManager = WinkEditorStickerResourceManager.f318326a;
            k3 = winkEditorStickerResourceManager.k(metaCategory3, z16);
            metaCategory5.subCategories = k3;
            arrayList.add(metaCategory5);
            listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new MetaCategory[]{metaCategory, metaCategory2});
            arrayList.add(winkEditorStickerResourceManager.i(listOfNotNull));
            WinkEditorResourceManager.a1().J1().postValue(arrayList);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorStickerResourceManager$loadSticker$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
