package com.tencent.mobileqq.wink.preprocess;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.utils.o;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.preprocess.WinkProcessContentTransFragment$processMedia$1", f = "WinkProcessContentTransFragment.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkProcessContentTransFragment$processMedia$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fromPart;
    final /* synthetic */ List<String> $mediaPaths;
    final /* synthetic */ String $textContent;
    int label;
    final /* synthetic */ WinkProcessContentTransFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkProcessContentTransFragment$processMedia$1(WinkProcessContentTransFragment winkProcessContentTransFragment, List<String> list, String str, String str2, Continuation<? super WinkProcessContentTransFragment$processMedia$1> continuation) {
        super(2, continuation);
        this.this$0 = winkProcessContentTransFragment;
        this.$mediaPaths = list;
        this.$fromPart = str;
        this.$textContent = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkProcessContentTransFragment$processMedia$1(this.this$0, this.$mediaPaths, this.$fromPart, this.$textContent, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        List listOf;
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
            WinkProcessContentTransFragment winkProcessContentTransFragment = this.this$0;
            List<String> list = this.$mediaPaths;
            this.label = 1;
            obj = winkProcessContentTransFragment.Kh(list, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        List<String> list2 = (List) obj;
        List<String> list3 = list2;
        if (list3 != null && !list3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.this$0.Ah("processedMediaPaths error, finish activity");
            return Unit.INSTANCE;
        }
        List<LocalMediaInfo> i16 = o.f326724a.i(list2);
        this.this$0.selectedMedia.clear();
        this.this$0.selectedMedia.addAll(i16);
        this.this$0.Ih(i16);
        w53.b.f("WinkProcessContentTransFragment", "performClickNextStep invoke, selectedMedia.size=" + i16.size());
        if (i16.size() != 1 || QAlbumUtil.getMediaType(i16.get(0).path) == 1 || !Intrinsics.areEqual(QQWinkConstants.SUB_ENTRY_BUSINESS_QZONE_SHUOSHUO, this.$fromPart)) {
            this.this$0.Fh(i16);
        } else {
            WinkProcessContentTransFragment winkProcessContentTransFragment2 = this.this$0;
            String str = this.$textContent;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(i16.get(0).path);
            winkProcessContentTransFragment2.Eh(str, listOf);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkProcessContentTransFragment$processMedia$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
