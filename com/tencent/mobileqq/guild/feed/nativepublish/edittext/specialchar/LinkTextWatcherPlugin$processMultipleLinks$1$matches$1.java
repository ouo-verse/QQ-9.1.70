package com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
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

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00020\u0001j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0002`\u0005*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ljava/util/ArrayList;", "Lkotlin/Triple;", "", "", "Lkotlin/collections/ArrayList;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.LinkTextWatcherPlugin$processMultipleLinks$1$matches$1", f = "LinkTextWatcherPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class LinkTextWatcherPlugin$processMultipleLinks$1$matches$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<Triple<? extends String, ? extends Integer, ? extends Integer>>>, Object> {
    final /* synthetic */ int $startIndex;
    final /* synthetic */ String $updatedFullContent;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkTextWatcherPlugin$processMultipleLinks$1$matches$1(String str, int i3, Continuation<? super LinkTextWatcherPlugin$processMultipleLinks$1$matches$1> continuation) {
        super(2, continuation);
        this.$updatedFullContent = str;
        this.$startIndex = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LinkTextWatcherPlugin$processMultipleLinks$1$matches$1(this.$updatedFullContent, this.$startIndex, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ArrayList<Triple<? extends String, ? extends Integer, ? extends Integer>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ArrayList<Triple<String, Integer, Integer>>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Pattern pattern;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            pattern = LinkTextWatcherPlugin.K;
            Matcher matcher = pattern.matcher(this.$updatedFullContent);
            while (matcher.find()) {
                int start = matcher.start() + this.$startIndex;
                int end = matcher.end() + this.$startIndex;
                String substring = this.$updatedFullContent.substring(matcher.start(), matcher.end());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                arrayList.add(new Triple(substring, Boxing.boxInt(start), Boxing.boxInt(end)));
            }
            QLog.d("LinkTextWatcherPlugin", 1, "[processMultipleLinks] process regex match success: " + arrayList.size());
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ArrayList<Triple<String, Integer, Integer>>> continuation) {
        return ((LinkTextWatcherPlugin$processMultipleLinks$1$matches$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
