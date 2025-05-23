package com.tencent.qqnt.chathistory.ui.media;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.base.p;
import com.tencent.qqnt.chathistory.ui.media.data.a;
import com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaItemModel;
import com.tencent.qqnt.chathistory.ui.media.viewmodel.ChatHistoryMediaViewModel;
import com.tencent.qqnt.chathistory.util.i;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$initStateObserver$1", f = "ChatHistoryMediaFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
public final class ChatHistoryMediaFragment$initStateObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ ChatHistoryMediaFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryMediaFragment$initStateObserver$1(ChatHistoryMediaFragment chatHistoryMediaFragment, Continuation<? super ChatHistoryMediaFragment$initStateObserver$1> continuation) {
        super(2, continuation);
        this.this$0 = chatHistoryMediaFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryMediaFragment, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new ChatHistoryMediaFragment$initStateObserver$1(this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LiveData obtainUiState = ((ChatHistoryMediaViewModel) this.this$0.rh()).obtainUiState();
                LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
                final Function1<com.tencent.qqnt.chathistory.ui.media.data.a, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.media.data.a, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment$initStateObserver$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryMediaFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.media.data.a aVar) {
                        invoke2(aVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(com.tencent.qqnt.chathistory.ui.media.data.a it) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        if (it instanceof a.b) {
                            ChatHistoryMediaFragment chatHistoryMediaFragment = ChatHistoryMediaFragment.this;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            chatHistoryMediaFragment.Th((a.b) it);
                            return;
                        }
                        if (it instanceof a.C9542a) {
                            FileTransNotifyInfo a16 = ((a.C9542a) it).a();
                            CopyOnWriteArrayList<com.tencent.qqnt.expandRecyclerView.adapter.node.b> m06 = ChatHistoryMediaFragment.this.adapter.m0();
                            ChatHistoryMediaFragment chatHistoryMediaFragment2 = ChatHistoryMediaFragment.this;
                            int i3 = 0;
                            for (Object obj2 : m06) {
                                int i16 = i3 + 1;
                                if (i3 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) obj2;
                                if (bVar instanceof SearchMediaItemModel) {
                                    SearchMediaItemModel searchMediaItemModel = (SearchMediaItemModel) bVar;
                                    if (searchMediaItemModel.j() == a16.msgId && searchMediaItemModel.h() == a16.msgElementId && a16.thumbSize == searchMediaItemModel.f().getSecond().intValue()) {
                                        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryMediaFragment", "notify " + i3 + "  error " + a16.fileErrCode + " notifyPath " + a16.filePath);
                                        searchMediaItemModel.s(a16.fileErrCode == 2006021);
                                        if (a16.fileErrCode == 0) {
                                            String str = a16.filePath;
                                            Intrinsics.checkNotNullExpressionValue(str, "notifyInfo.filePath");
                                            searchMediaItemModel.t(str);
                                        }
                                        chatHistoryMediaFragment2.adapter.notifyItemChanged(i3, new i(p.class, new p(a16)));
                                    }
                                }
                                i3 = i16;
                            }
                            return;
                        }
                        if (it instanceof a.c) {
                            ChatHistoryMediaFragment chatHistoryMediaFragment3 = ChatHistoryMediaFragment.this;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            chatHistoryMediaFragment3.Uh((a.c) it);
                        }
                    }
                };
                obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.media.g
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj2) {
                        Function1.this.invoke(obj2);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((ChatHistoryMediaFragment$initStateObserver$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
