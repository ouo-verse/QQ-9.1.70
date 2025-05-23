package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.view.View;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopIntent;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppMineViewHolder$mDragListener$1$recentMiniAppDragDrop$1", f = "MiniAppMineAdapter.kt", i = {}, l = {371}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppMineViewHolder$mDragListener$1$recentMiniAppDragDrop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MiniAppDragData $dragData;
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ MiniAppMineViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppMineViewHolder$mDragListener$1$recentMiniAppDragDrop$1(MiniAppMineViewHolder miniAppMineViewHolder, MiniAppDragData miniAppDragData, View view, Continuation<? super MiniAppMineViewHolder$mDragListener$1$recentMiniAppDragDrop$1> continuation) {
        super(2, continuation);
        this.this$0 = miniAppMineViewHolder;
        this.$dragData = miniAppDragData;
        this.$view = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppMineViewHolder$mDragListener$1$recentMiniAppDragDrop$1(this.this$0, this.$dragData, this.$view, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int insertMyMiniAppPosition;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            MiniAppDeskTopViewModel mMiniAppDesktopViewModel = this.this$0.getMMiniAppDesktopViewModel();
            if (mMiniAppDesktopViewModel != null) {
                DesktopAppInfo fromDesktopAppInfo = this.$dragData.getFromDesktopAppInfo();
                insertMyMiniAppPosition = this.this$0.getInsertMyMiniAppPosition(this.$view);
                MiniAppDeskTopIntent.InsertMyMiniApp insertMyMiniApp = new MiniAppDeskTopIntent.InsertMyMiniApp(fromDesktopAppInfo, insertMyMiniAppPosition);
                this.label = 1;
                if (mMiniAppDesktopViewModel.sendUserIntent(insertMyMiniApp, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniAppMineViewHolder$mDragListener$1$recentMiniAppDragDrop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
