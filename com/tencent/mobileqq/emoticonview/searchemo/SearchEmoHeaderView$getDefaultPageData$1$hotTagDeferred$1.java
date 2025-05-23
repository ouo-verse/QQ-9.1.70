package com.tencent.mobileqq.emoticonview.searchemo;

import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicHotWordsItem;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicHotWordsItem;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$getDefaultPageData$1$hotTagDeferred$1", f = "SearchEmoHeaderView.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class SearchEmoHeaderView$getDefaultPageData$1$hotTagDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends EmojiHotPicHotWordsItem>>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QQEmoticonMainPanelApp $mainPanelApp;
    int label;
    final /* synthetic */ SearchEmoHeaderView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchEmoHeaderView$getDefaultPageData$1$hotTagDeferred$1(SearchEmoHeaderView searchEmoHeaderView, QQEmoticonMainPanelApp qQEmoticonMainPanelApp, Continuation<? super SearchEmoHeaderView$getDefaultPageData$1$hotTagDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = searchEmoHeaderView;
        this.$mainPanelApp = qQEmoticonMainPanelApp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, searchEmoHeaderView, qQEmoticonMainPanelApp, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new SearchEmoHeaderView$getDefaultPageData$1$hotTagDeferred$1(this.this$0, this.$mainPanelApp, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends EmojiHotPicHotWordsItem>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<EmojiHotPicHotWordsItem>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
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
                SearchEmoHeaderView searchEmoHeaderView = this.this$0;
                QQEmoticonMainPanelApp qQEmoticonMainPanelApp = this.$mainPanelApp;
                this.label = 1;
                obj = searchEmoHeaderView.getHotTagList(qQEmoticonMainPanelApp, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<EmojiHotPicHotWordsItem>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((SearchEmoHeaderView$getDefaultPageData$1$hotTagDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
