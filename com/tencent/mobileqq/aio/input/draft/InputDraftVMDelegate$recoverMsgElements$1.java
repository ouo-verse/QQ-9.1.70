package com.tencent.mobileqq.aio.input.draft;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.fullscreen.p;
import com.tencent.mobileqq.aio.input.reply.InputReplyMsgIntent;
import com.tencent.mobileqq.aio.utils.x;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.input.draft.InputDraftVMDelegate$recoverMsgElements$1", f = "InputDraftVMDelegate.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
public final class InputDraftVMDelegate$recoverMsgElements$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ List<MsgElement> $elements;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InputDraftVMDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputDraftVMDelegate$recoverMsgElements$1(List<MsgElement> list, InputDraftVMDelegate inputDraftVMDelegate, Continuation<? super InputDraftVMDelegate$recoverMsgElements$1> continuation) {
        super(2, continuation);
        this.$elements = list;
        this.this$0 = inputDraftVMDelegate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, inputDraftVMDelegate, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        InputDraftVMDelegate$recoverMsgElements$1 inputDraftVMDelegate$recoverMsgElements$1 = new InputDraftVMDelegate$recoverMsgElements$1(this.$elements, this.this$0, continuation);
        inputDraftVMDelegate$recoverMsgElements$1.L$0 = obj;
        return inputDraftVMDelegate$recoverMsgElements$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object o16;
        ReplyElement replyElement;
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.aio.api.runtime.a aVar2;
        String string;
        boolean z16;
        Deferred async$default;
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
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                ArrayList arrayList = new ArrayList();
                List<MsgElement> list = this.$elements;
                InputDraftVMDelegate inputDraftVMDelegate = this.this$0;
                for (MsgElement msgElement : list) {
                    int i16 = msgElement.elementType;
                    com.tencent.aio.api.runtime.a aVar3 = null;
                    Uri uri = null;
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 6) {
                                if (i16 == 7 && (replyElement = msgElement.replyElement) != null) {
                                    Intrinsics.checkNotNullExpressionValue(replyElement, "replyElement");
                                    aVar = inputDraftVMDelegate.mContext;
                                    if (aVar == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                    } else {
                                        aVar3 = aVar;
                                    }
                                    aVar3.e().h(new InputReplyMsgIntent.SetReplyData(replyElement));
                                }
                            } else {
                                spannableStringBuilder.append(x.f194179a.n(msgElement.faceElement, 19));
                            }
                        } else {
                            PicElement picElement = msgElement.picElement;
                            if (picElement != null) {
                                Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
                                aVar2 = inputDraftVMDelegate.mContext;
                                if (aVar2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                    aVar2 = null;
                                }
                                Context context = aVar2.c().getContext();
                                if (context != null && (string = context.getString(R.string.yrb)) != null) {
                                    Intrinsics.checkNotNullExpressionValue(string, "mContext.fragment.contex\u2026_span_text) ?: return@let");
                                    String str = picElement.fileUuid;
                                    if (str != null && str.length() != 0) {
                                        z16 = false;
                                    } else {
                                        z16 = true;
                                    }
                                    if (!z16) {
                                        uri = Uri.parse(picElement.fileUuid);
                                    }
                                    Object a16 = p.f189662a.a(picElement.fileName, uri, picElement.original);
                                    if (a16 != null) {
                                        spannableStringBuilder.append((CharSequence) string).setSpan(a16, spannableStringBuilder.length() - string.length(), spannableStringBuilder.length(), 33);
                                    }
                                }
                            }
                        }
                    } else {
                        Integer boxInt = Boxing.boxInt(spannableStringBuilder.length());
                        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getMain(), null, new InputDraftVMDelegate$recoverMsgElements$1$1$2(msgElement, inputDraftVMDelegate, null), 2, null);
                        arrayList.add(TuplesKt.to(boxInt, async$default));
                    }
                }
                InputDraftVMDelegate inputDraftVMDelegate2 = this.this$0;
                this.label = 1;
                o16 = inputDraftVMDelegate2.o(arrayList, spannableStringBuilder, this);
                if (o16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((InputDraftVMDelegate$recoverMsgElements$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
