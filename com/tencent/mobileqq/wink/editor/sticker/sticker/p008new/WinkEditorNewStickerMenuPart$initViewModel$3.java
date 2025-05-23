package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import android.view.View;
import android.widget.FrameLayout;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.wink.editor.sticker.sticker.p008new.d;
import com.tencent.mobileqq.wink.utils.ar;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.sticker.sticker.new.WinkEditorNewStickerMenuPart$initViewModel$3", f = "WinkEditorNewStickerMenuPart.kt", i = {}, l = {QVipGiftProcessor.CMD}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorNewStickerMenuPart$initViewModel$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WinkEditorNewStickerMenuPart this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<d> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkEditorNewStickerMenuPart f321853d;

        public a(WinkEditorNewStickerMenuPart winkEditorNewStickerMenuPart) {
            this.f321853d = winkEditorNewStickerMenuPart;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(d dVar, @NotNull Continuation<? super Unit> continuation) {
            View ab5;
            StickerSearchPage bb5;
            FrameLayout Za;
            ArrayList arrayList;
            FrameLayout Xa;
            ArrayList arrayList2;
            String str;
            View ab6;
            d dVar2 = dVar;
            int i3 = 0;
            if (dVar2 instanceof d.TopTabSelect) {
                d.TopTabSelect topTabSelect = (d.TopTabSelect) dVar2;
                this.f321853d.sb(topTabSelect.a());
                MetaCategory selectedCate = topTabSelect.getSelectedCate();
                if (selectedCate != null) {
                    str = selectedCate.f30532id;
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, "qq_sticker")) {
                    ar.f326685a.m("ae_key_editor_need_show_qq_emo_sticker_reddot", false);
                    ab6 = this.f321853d.ab();
                    ab6.setVisibility(8);
                }
            } else if (dVar2 instanceof d.ScrollContent) {
                arrayList2 = this.f321853d.pages;
                d.ScrollContent scrollContent = (d.ScrollContent) dVar2;
                ((StickerPage) arrayList2.get(scrollContent.getTopTabIndex())).m(scrollContent.getItemPosition());
            } else if (dVar2 instanceof d.a) {
                Xa = this.f321853d.Xa();
                BottomSheetBehavior.from(Xa).setState(4);
            } else if (dVar2 instanceof d.ScrollSelectBottomTab) {
                arrayList = this.f321853d.pages;
                d.ScrollSelectBottomTab scrollSelectBottomTab = (d.ScrollSelectBottomTab) dVar2;
                ((StickerPage) arrayList.get(scrollSelectBottomTab.getTopTabIndex())).n(scrollSelectBottomTab.getIndex());
            } else if (dVar2 instanceof d.SearchToggle) {
                ab5 = this.f321853d.ab();
                d.SearchToggle searchToggle = (d.SearchToggle) dVar2;
                if (searchToggle.getOpen() || !ar.f326685a.c("ae_key_editor_need_show_qq_emo_sticker_reddot", true)) {
                    i3 = 8;
                }
                ab5.setVisibility(i3);
                bb5 = this.f321853d.bb();
                boolean open = searchToggle.getOpen();
                Za = this.f321853d.Za();
                bb5.r(open, Za);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorNewStickerMenuPart$initViewModel$3(WinkEditorNewStickerMenuPart winkEditorNewStickerMenuPart, Continuation<? super WinkEditorNewStickerMenuPart$initViewModel$3> continuation) {
        super(2, continuation);
        this.this$0 = winkEditorNewStickerMenuPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorNewStickerMenuPart$initViewModel$3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            WinkEditorStickerViewModel winkEditorStickerViewModel = this.this$0.stickerViewModel;
            if (winkEditorStickerViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stickerViewModel");
                winkEditorStickerViewModel = null;
            }
            SharedFlow<d> p26 = winkEditorStickerViewModel.p2();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (p26.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorNewStickerMenuPart$initViewModel$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
