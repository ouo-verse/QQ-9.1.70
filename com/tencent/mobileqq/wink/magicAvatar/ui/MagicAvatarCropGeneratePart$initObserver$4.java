package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.os.Bundle;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.magicAvatar.model.ClipBitmapInfo;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarCropGeneratePart$initObserver$4", f = "MagicAvatarCropGeneratePart.kt", i = {}, l = {com.tencent.luggage.wxa.yd.a.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicAvatarCropGeneratePart$initObserver$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MagicAvatarCropGeneratePart this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlowCollector<ClipBitmapInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicAvatarCropGeneratePart f323545d;

        public a(MagicAvatarCropGeneratePart magicAvatarCropGeneratePart) {
            this.f323545d = magicAvatarCropGeneratePart;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(ClipBitmapInfo clipBitmapInfo, @NotNull Continuation<? super Unit> continuation) {
            Bundle bundle;
            Bundle bundle2;
            i83.b bVar;
            ClipBitmapInfo clipBitmapInfo2 = clipBitmapInfo;
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(BaseApplication.getContext(), "\u5f53\u524d\u65e0\u7f51\u7edc\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u94fe\u63a5\u201d", 0).show();
            } else {
                w53.b.f("MagicAvatarCropPart", "getClipPath");
                this.f323545d.clipBitmapInfo = clipBitmapInfo2;
                bundle = this.f323545d.bundle;
                bundle.putBoolean("key_is_preview", clipBitmapInfo2.isPreview());
                bundle2 = this.f323545d.bundle;
                String videoFilePath = clipBitmapInfo2.getVideoFilePath();
                if (videoFilePath == null) {
                    videoFilePath = "";
                }
                bundle2.putString("key_video_file", videoFilePath);
                this.f323545d.ga();
                bVar = this.f323545d.delegate;
                if (bVar != null) {
                    bVar.a(this.f323545d);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarCropGeneratePart$initObserver$4(MagicAvatarCropGeneratePart magicAvatarCropGeneratePart, Continuation<? super MagicAvatarCropGeneratePart$initObserver$4> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarCropGeneratePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarCropGeneratePart$initObserver$4(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MagicAvatarCropViewModel magicAvatarCropViewModel;
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
            magicAvatarCropViewModel = this.this$0.magicCropVm;
            SharedFlow<ClipBitmapInfo> D2 = magicAvatarCropViewModel.D2();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (D2.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarCropGeneratePart$initObserver$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
