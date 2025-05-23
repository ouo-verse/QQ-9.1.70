package com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar;

import android.text.Editable;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.LinkTextWatcherPlugin$processSingleLink$1", f = "LinkTextWatcherPlugin.kt", i = {}, l = {205, 215}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class LinkTextWatcherPlugin$processSingleLink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $endIndex;
    final /* synthetic */ String $potentialLink;
    final /* synthetic */ int $startIndex;
    final /* synthetic */ Editable $text;
    int label;
    final /* synthetic */ LinkTextWatcherPlugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkTextWatcherPlugin$processSingleLink$1(Editable editable, int i3, int i16, String str, LinkTextWatcherPlugin linkTextWatcherPlugin, Continuation<? super LinkTextWatcherPlugin$processSingleLink$1> continuation) {
        super(2, continuation);
        this.$text = editable;
        this.$startIndex = i3;
        this.$endIndex = i16;
        this.$potentialLink = str;
        this.this$0 = linkTextWatcherPlugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LinkTextWatcherPlugin$processSingleLink$1(this.$text, this.$startIndex, this.$endIndex, this.$potentialLink, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String b16;
        sk1.b v3;
        List listOf;
        Object o16;
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
            CoroutineDispatcher io5 = Dispatchers.getIO();
            LinkTextWatcherPlugin$processSingleLink$1$matches$1 linkTextWatcherPlugin$processSingleLink$1$matches$1 = new LinkTextWatcherPlugin$processSingleLink$1$matches$1(this.$potentialLink, null);
            this.label = 1;
            obj = BuildersKt.withContext(io5, linkTextWatcherPlugin$processSingleLink$1$matches$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (((Boolean) obj).booleanValue()) {
            b16 = j.b(this.$text, this.$startIndex, this.$endIndex);
            if (b16.contentEquals(this.$potentialLink)) {
                v3 = this.this$0.v(this.$text, this.$startIndex, this.$endIndex);
                LinkTextWatcherPlugin linkTextWatcherPlugin = this.this$0;
                Editable editable = this.$text;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(v3);
                this.label = 2;
                o16 = linkTextWatcherPlugin.o(editable, listOf, this);
                if (o16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LinkTextWatcherPlugin$processSingleLink$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
