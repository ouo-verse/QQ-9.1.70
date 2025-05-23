package com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar;

import android.text.Editable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.LinkTextWatcherPlugin$processMultipleLinks$1", f = "LinkTextWatcherPlugin.kt", i = {}, l = {233, 258}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class LinkTextWatcherPlugin$processMultipleLinks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fullContent;
    final /* synthetic */ int $startIndex;
    final /* synthetic */ Editable $text;
    int label;
    final /* synthetic */ LinkTextWatcherPlugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkTextWatcherPlugin$processMultipleLinks$1(String str, Editable editable, int i3, LinkTextWatcherPlugin linkTextWatcherPlugin, Continuation<? super LinkTextWatcherPlugin$processMultipleLinks$1> continuation) {
        super(2, continuation);
        this.$fullContent = str;
        this.$text = editable;
        this.$startIndex = i3;
        this.this$0 = linkTextWatcherPlugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LinkTextWatcherPlugin$processMultipleLinks$1(this.$fullContent, this.$text, this.$startIndex, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String replace$default;
        Object o16;
        String b16;
        sk1.b v3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            replace$default = StringsKt__StringsJVMKt.replace$default(this.$fullContent, "\u200b", " ", false, 4, (Object) null);
            if (!replace$default.contentEquals(this.$fullContent)) {
                Editable editable = this.$text;
                int i16 = this.$startIndex;
                editable.replace(i16, this.$fullContent.length() + i16, replace$default);
            }
            CoroutineDispatcher io5 = Dispatchers.getIO();
            LinkTextWatcherPlugin$processMultipleLinks$1$matches$1 linkTextWatcherPlugin$processMultipleLinks$1$matches$1 = new LinkTextWatcherPlugin$processMultipleLinks$1$matches$1(replace$default, this.$startIndex, null);
            this.label = 1;
            obj = BuildersKt.withContext(io5, linkTextWatcherPlugin$processMultipleLinks$1$matches$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Editable editable2 = this.$text;
        LinkTextWatcherPlugin linkTextWatcherPlugin = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (Triple triple : (ArrayList) obj) {
            String str = (String) triple.component1();
            int intValue = ((Number) triple.component2()).intValue();
            int intValue2 = ((Number) triple.component3()).intValue();
            b16 = j.b(editable2, intValue, intValue2);
            if (b16.contentEquals(str)) {
                v3 = linkTextWatcherPlugin.v(editable2, intValue, intValue2);
            } else {
                v3 = null;
            }
            if (v3 != null) {
                arrayList.add(v3);
            }
        }
        if (!arrayList.isEmpty()) {
            LinkTextWatcherPlugin linkTextWatcherPlugin2 = this.this$0;
            Editable editable3 = this.$text;
            this.label = 2;
            o16 = linkTextWatcherPlugin2.o(editable3, arrayList, this);
            if (o16 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LinkTextWatcherPlugin$processMultipleLinks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
