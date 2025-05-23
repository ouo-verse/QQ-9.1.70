package com.tencent.mobileqq.emoticonview.searchemo;

import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.emoticonview.searchemo.SearchEmoHeaderView$getDefaultPageData$1", f = "SearchEmoHeaderView.kt", i = {0}, l = {232, 236}, m = "invokeSuspend", n = {"hotTagDeferred"}, s = {"L$0"})
/* loaded from: classes12.dex */
public final class SearchEmoHeaderView$getDefaultPageData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $isExperiment;
    final /* synthetic */ QQEmoticonMainPanelApp $mainPanelApp;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ SearchEmoHeaderView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchEmoHeaderView$getDefaultPageData$1(boolean z16, SearchEmoHeaderView searchEmoHeaderView, QQEmoticonMainPanelApp qQEmoticonMainPanelApp, Continuation<? super SearchEmoHeaderView$getDefaultPageData$1> continuation) {
        super(2, continuation);
        this.$isExperiment = z16;
        this.this$0 = searchEmoHeaderView;
        this.$mainPanelApp = qQEmoticonMainPanelApp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), searchEmoHeaderView, qQEmoticonMainPanelApp, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new SearchEmoHeaderView$getDefaultPageData$1(this.$isExperiment, this.this$0, this.$mainPanelApp, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred deferred;
        List emptyList;
        Deferred deferred2;
        Deferred deferred3;
        com.tencent.mobileqq.qcoroutine.api.coroutine.a c16;
        com.tencent.mobileqq.qcoroutine.api.coroutine.a c17;
        SearchEmoHeaderView searchEmoHeaderView;
        boolean z16;
        Object await;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        Object obj2 = obj;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        List list = null;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    z17 = this.Z$0;
                    List list2 = (List) this.L$1;
                    searchEmoHeaderView = (SearchEmoHeaderView) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    emptyList = list2;
                    await = obj2;
                    list = (List) await;
                    z16 = z17;
                    searchEmoHeaderView.updateDefaultPage(z16, emptyList, list);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            deferred3 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            com.tencent.mobileqq.qcoroutine.framework.impl.a aVar = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a;
            i.f fVar = i.f.f261784e;
            CoroutineScope f16 = aVar.f(fVar);
            if (f16 != null && (c17 = CorountineFunKt.c(f16, "SearchEmoHeaderView", null, null, new SearchEmoHeaderView$getDefaultPageData$1$hotTagDeferred$1(this.this$0, this.$mainPanelApp, null), 6, null)) != null) {
                deferred = c17.p();
            } else {
                deferred = null;
            }
            if (!this.$isExperiment) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                CoroutineScope f17 = aVar.f(fVar);
                if (f17 != null && (c16 = CorountineFunKt.c(f17, "SearchEmoHeaderView", null, null, new SearchEmoHeaderView$getDefaultPageData$1$hotPicList$hotPicDeferred$1(this.this$0, null), 6, null)) != null) {
                    deferred2 = c16.p();
                } else {
                    deferred2 = null;
                }
                if (deferred2 != null) {
                    this.L$0 = deferred;
                    this.label = 1;
                    obj2 = deferred2.await(this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    deferred3 = deferred;
                } else {
                    emptyList = null;
                }
            }
            searchEmoHeaderView = this.this$0;
            z16 = this.$isExperiment;
            if (deferred != null) {
                this.L$0 = searchEmoHeaderView;
                this.L$1 = emptyList;
                this.Z$0 = z16;
                this.label = 2;
                await = deferred.await(this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z17 = z16;
                list = (List) await;
                z16 = z17;
            }
            searchEmoHeaderView.updateDefaultPage(z16, emptyList, list);
            return Unit.INSTANCE;
        }
        emptyList = (List) obj2;
        deferred = deferred3;
        searchEmoHeaderView = this.this$0;
        z16 = this.$isExperiment;
        if (deferred != null) {
        }
        searchEmoHeaderView.updateDefaultPage(z16, emptyList, list);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((SearchEmoHeaderView$getDefaultPageData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
