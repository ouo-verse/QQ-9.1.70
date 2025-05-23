package com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar;

import android.text.Editable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.LinkTextWatcherPlugin$parseUnRichLinkSpan$1", f = "LinkTextWatcherPlugin.kt", i = {}, l = {417}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class LinkTextWatcherPlugin$parseUnRichLinkSpan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Editable $text;
    int label;
    final /* synthetic */ LinkTextWatcherPlugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkTextWatcherPlugin$parseUnRichLinkSpan$1(Editable editable, LinkTextWatcherPlugin linkTextWatcherPlugin, Continuation<? super LinkTextWatcherPlugin$parseUnRichLinkSpan$1> continuation) {
        super(2, continuation);
        this.$text = editable;
        this.this$0 = linkTextWatcherPlugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LinkTextWatcherPlugin$parseUnRichLinkSpan$1(this.$text, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object o16;
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
            Editable editable = this.$text;
            Object[] spans = editable.getSpans(0, editable.length(), sk1.b.class);
            Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(0, text.le\u2026th, LinkSpan::class.java)");
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : spans) {
                if (!((sk1.b) obj2).getIsRich()) {
                    arrayList.add(obj2);
                }
            }
            QLog.e("LinkTextWatcherPlugin", 1, "[parseEditableLinkSpans] found " + arrayList.size() + " editable spans");
            LinkTextWatcherPlugin linkTextWatcherPlugin = this.this$0;
            Editable editable2 = this.$text;
            this.label = 1;
            o16 = linkTextWatcherPlugin.o(editable2, arrayList, this);
            if (o16 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LinkTextWatcherPlugin$parseUnRichLinkSpan$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
