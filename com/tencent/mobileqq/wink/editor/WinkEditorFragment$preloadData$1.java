package com.tencent.mobileqq.wink.editor;

import android.os.Handler;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
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
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.WinkEditorFragment$preloadData$1", f = "WinkEditorFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorFragment$preloadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ int $width;
    int label;
    final /* synthetic */ WinkEditorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorFragment$preloadData$1(WinkEditorFragment winkEditorFragment, int i3, int i16, Continuation<? super WinkEditorFragment$preloadData$1> continuation) {
        super(2, continuation);
        this.this$0 = winkEditorFragment;
        this.$width = i3;
        this.$height = i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkEditorFragment winkEditorFragment, dr.WinkTavCutParams winkTavCutParams) {
        winkEditorFragment.tl(winkTavCutParams);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorFragment$preloadData$1(this.this$0, this.$width, this.$height, continuation);
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
            final dr.WinkTavCutParams H4 = this.this$0.Tk().H4(this.$width, this.$height);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) H4.u());
            WinkEditData winkEditData = (WinkEditData) firstOrNull;
            if (winkEditData != null && (mediaModel = winkEditData.getMediaModel()) != null) {
                list = mediaModel.videos;
            } else {
                list = null;
            }
            if (Intrinsics.areEqual(H4.getIsFromTemplateColl(), Boxing.boxBoolean(true))) {
                List<MediaClip> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    com.tencent.videocut.render.utils.b.f384205a.b(new b.a(H4.getTemplatePath(), com.tencent.videocut.render.extension.e.z(list, false, Boxing.boxBoolean(true)), true));
                }
            }
            Handler mainHandler = this.this$0.getMainHandler();
            final WinkEditorFragment winkEditorFragment = this.this$0;
            mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.cl
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorFragment$preloadData$1.b(WinkEditorFragment.this, H4);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorFragment$preloadData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
