package com.tencent.mobileqq.wink.picker.qcircle;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.downloader.WinkQZoneMediaDownloader;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleCollectionPickerFragment;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.picker.qcircle.QCircleCollectionPickerFragment$getFirstFramePath$1$1", f = "QCircleCollectionPickerFragment.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class QCircleCollectionPickerFragment$getFirstFramePath$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ QCircleCollectionPickerFragment.b $callBack;
    final /* synthetic */ LocalMediaInfo $selectedMedia;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleCollectionPickerFragment$getFirstFramePath$1$1(LocalMediaInfo localMediaInfo, QCircleCollectionPickerFragment.b bVar, Continuation<? super QCircleCollectionPickerFragment$getFirstFramePath$1$1> continuation) {
        super(2, continuation);
        this.$selectedMedia = localMediaInfo;
        this.$callBack = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QCircleCollectionPickerFragment$getFirstFramePath$1$1(this.$selectedMedia, this.$callBack, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        QCircleCollectionPickerFragment.b bVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                bVar = (QCircleCollectionPickerFragment.b) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            String j3 = e93.i.j(this.$selectedMedia);
            if (j3 != null) {
                QCircleCollectionPickerFragment.b bVar2 = this.$callBack;
                WinkQZoneMediaDownloader winkQZoneMediaDownloader = WinkQZoneMediaDownloader.f318202a;
                this.L$0 = bVar2;
                this.label = 1;
                obj = winkQZoneMediaDownloader.a(j3, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bVar = bVar2;
            }
            return Unit.INSTANCE;
        }
        String str = (String) obj;
        if (str != null) {
            w53.b.a("QCircleCollectionPickerFragment", "qzone image frame path: " + str);
            bVar.a(str);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QCircleCollectionPickerFragment$getFirstFramePath$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
