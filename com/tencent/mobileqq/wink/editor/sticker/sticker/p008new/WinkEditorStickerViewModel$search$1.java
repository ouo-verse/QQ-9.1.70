package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.luggage.wxa.se.b;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorStickerResourceManager;
import com.tencent.mobileqq.wink.editor.sticker.sticker.p008new.d;
import java.util.List;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorStickerViewModel$search$1", f = "WinkEditorStickerViewModel.kt", i = {0, 1}, l = {b.CTRL_INDEX, 374, NotificationUtil.Constants.NOTIFY_ID_UNIFORM_DOWNLOAD_END}, m = "invokeSuspend", n = {"initData", "initData"}, s = {"L$0", "L$0"})
/* loaded from: classes21.dex */
public final class WinkEditorStickerViewModel$search$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyword;
    Object L$0;
    int label;
    final /* synthetic */ WinkEditorStickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorStickerViewModel$search$1(WinkEditorStickerViewModel winkEditorStickerViewModel, String str, Continuation<? super WinkEditorStickerViewModel$search$1> continuation) {
        super(2, continuation);
        this.this$0 = winkEditorStickerViewModel;
        this.$keyword = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorStickerViewModel$search$1(this.this$0, this.$keyword, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v8, types: [camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        StickerListData k26;
        MutableSharedFlow mutableSharedFlow;
        MetaCategory y26;
        MutableSharedFlow mutableSharedFlow2;
        MetaCategory metaCategory;
        b bVar;
        List<MetaCategory> list;
        MutableLiveData mutableLiveData2;
        int i3;
        StickerListData l26;
        MutableLiveData mutableLiveData3;
        List emptyList;
        MutableLiveData mutableLiveData4;
        StickerListData k27;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        MetaCategory metaCategory2 = this.label;
        try {
        } catch (Exception e16) {
            if (e16 instanceof CancellationException) {
                mutableSharedFlow = this.this$0._stickerMenuEvent;
                d.C9037d c9037d = d.C9037d.f321870a;
                this.L$0 = null;
                this.label = 3;
                if (mutableSharedFlow.emit(c9037d, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (metaCategory2 != 0) {
                    mutableLiveData = this.this$0._stickerSearchData;
                    k26 = this.this$0.k2(metaCategory2);
                    mutableLiveData.postValue(k26);
                }
                return Unit.INSTANCE;
            }
        }
        if (metaCategory2 != 0) {
            if (metaCategory2 != 1) {
                if (metaCategory2 != 2) {
                    if (metaCategory2 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                MetaCategory metaCategory3 = (MetaCategory) this.L$0;
                ResultKt.throwOnFailure(obj);
                metaCategory2 = metaCategory3;
                list = (List) obj;
                this.this$0.lastSearchDataStickerPage = 0;
                this.this$0.lastSearchData = list;
                if (!list.isEmpty()) {
                    if (metaCategory2 != 0) {
                        mutableLiveData4 = this.this$0._stickerSearchData;
                        k27 = this.this$0.k2(metaCategory2);
                        mutableLiveData4.postValue(k27);
                    }
                } else if (list.size() == 1) {
                    mutableLiveData3 = this.this$0._stickerSearchData;
                    MetaCategory i16 = WinkEditorStickerResourceManager.f318326a.i(list);
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    mutableLiveData3.postValue(new StickerListData(i16, list, emptyList, 0, false, false, 56, null));
                } else {
                    mutableLiveData2 = this.this$0._stickerSearchData;
                    WinkEditorStickerViewModel winkEditorStickerViewModel = this.this$0;
                    i3 = winkEditorStickerViewModel.lastSearchDataStickerPage;
                    l26 = winkEditorStickerViewModel.l2(list, (i3 + 1) * 12);
                    mutableLiveData2.postValue(l26);
                }
                return Unit.INSTANCE;
            }
            MetaCategory metaCategory4 = (MetaCategory) this.L$0;
            ResultKt.throwOnFailure(obj);
            metaCategory = metaCategory4;
        } else {
            ResultKt.throwOnFailure(obj);
            y26 = this.this$0.y2();
            mutableSharedFlow2 = this.this$0._stickerMenuEvent;
            d.f fVar = d.f.f321872a;
            this.L$0 = y26;
            this.label = 1;
            if (mutableSharedFlow2.emit(fVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            metaCategory = y26;
        }
        bVar = this.this$0.dataSource;
        String str = this.$keyword;
        this.L$0 = metaCategory;
        this.label = 2;
        obj = bVar.c(str, this);
        metaCategory2 = metaCategory;
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        list = (List) obj;
        this.this$0.lastSearchDataStickerPage = 0;
        this.this$0.lastSearchData = list;
        if (!list.isEmpty()) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorStickerViewModel$search$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
