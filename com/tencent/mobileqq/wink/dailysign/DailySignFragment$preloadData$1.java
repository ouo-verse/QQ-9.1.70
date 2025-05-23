package com.tencent.mobileqq.wink.dailysign;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.render.utils.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.dailysign.DailySignFragment$preloadData$1", f = "DailySignFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class DailySignFragment$preloadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.wink.lowthresholdltemplate.a $data;
    int label;
    final /* synthetic */ DailySignFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailySignFragment$preloadData$1(com.tencent.mobileqq.wink.lowthresholdltemplate.a aVar, DailySignFragment dailySignFragment, Continuation<? super DailySignFragment$preloadData$1> continuation) {
        super(2, continuation);
        this.$data = aVar;
        this.this$0 = dailySignFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DailySignFragment dailySignFragment, com.tencent.mobileqq.wink.lowthresholdltemplate.a aVar) {
        dailySignFragment.pi(aVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DailySignFragment$preloadData$1(this.$data, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object firstOrNull;
        List<MediaClip> list;
        boolean z16;
        MediaModel mediaModel;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.$data.getWinkTavCutParams().u());
            WinkEditData winkEditData = (WinkEditData) firstOrNull;
            if (winkEditData != null && (mediaModel = winkEditData.getMediaModel()) != null) {
                list = mediaModel.videos;
            } else {
                list = null;
            }
            if (Intrinsics.areEqual(this.$data.getWinkTavCutParams().getIsFromTemplateColl(), Boxing.boxBoolean(true))) {
                List<MediaClip> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    BaseApplication context = BaseApplication.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                    rd4.c.t(context, "", "lightsdk_qq", WinkContext.Companion.j(WinkContext.INSTANCE, false, 1, null));
                    com.tencent.videocut.render.utils.b.f384205a.b(new b.a(this.$data.getWinkTavCutParams().getTemplatePath(), com.tencent.videocut.render.extension.e.z(list, false, Boxing.boxBoolean(true)), true));
                }
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final DailySignFragment dailySignFragment = this.this$0;
            final com.tencent.mobileqq.wink.lowthresholdltemplate.a aVar = this.$data;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.dailysign.ae
                @Override // java.lang.Runnable
                public final void run() {
                    DailySignFragment$preloadData$1.b(DailySignFragment.this, aVar);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DailySignFragment$preloadData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
