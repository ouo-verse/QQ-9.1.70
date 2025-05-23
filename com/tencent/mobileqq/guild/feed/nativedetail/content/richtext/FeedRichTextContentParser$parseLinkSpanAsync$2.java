package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.guild.aio.msglist.markdown.LinkSpanEntity;
import com.tencent.guild.aio.util.j;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yn1.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "Lcom/tencent/aio/widget/textView/view/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser$parseLinkSpanAsync$2", f = "FeedRichTextContentParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedRichTextContentParser$parseLinkSpanAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends SpannableStringBuilder, ? extends com.tencent.aio.widget.textView.view.b>>, Object> {
    final /* synthetic */ int $linkColor;
    final /* synthetic */ boolean $needDoubleTap;
    final /* synthetic */ boolean $needSelectable;
    final /* synthetic */ SpannableStringBuilder $this_parseLinkSpanAsync;
    final /* synthetic */ Set<Integer> $unMatchTypes;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedRichTextContentParser$parseLinkSpanAsync$2(SpannableStringBuilder spannableStringBuilder, Set<Integer> set, int i3, boolean z16, boolean z17, Continuation<? super FeedRichTextContentParser$parseLinkSpanAsync$2> continuation) {
        super(2, continuation);
        this.$this_parseLinkSpanAsync = spannableStringBuilder;
        this.$unMatchTypes = set;
        this.$linkColor = i3;
        this.$needSelectable = z16;
        this.$needDoubleTap = z17;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedRichTextContentParser$parseLinkSpanAsync$2(this.$this_parseLinkSpanAsync, this.$unMatchTypes, this.$linkColor, this.$needSelectable, this.$needDoubleTap, continuation);
    }

    /* JADX WARN: Type inference failed for: r7v6, types: [T, com.tencent.aio.widget.textView.view.b] */
    /* JADX WARN: Type inference failed for: r8v10, types: [T, com.tencent.aio.widget.textView.view.b] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        ?? e16;
        FeedRichTextContentParser.b g16;
        FeedRichTextContentParser.a f16;
        ?? e17;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.$this_parseLinkSpanAsync);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            g.Companion companion = g.INSTANCE;
            String spannableStringBuilder2 = spannableStringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "result.toString()");
            int i3 = 0;
            ArrayList<a.GuildJumpEntity> b16 = companion.b(spannableStringBuilder2, new IntRange(0, spannableStringBuilder.length()));
            int i16 = this.$linkColor;
            boolean z17 = this.$needSelectable;
            boolean z18 = this.$needDoubleTap;
            for (a.GuildJumpEntity guildJumpEntity : b16) {
                Object[] existingSpans = spannableStringBuilder.getSpans(guildJumpEntity.getStartIndex(), guildJumpEntity.getEndIndex(), Object.class);
                Intrinsics.checkNotNullExpressionValue(existingSpans, "existingSpans");
                int length = existingSpans.length;
                for (int i17 = i3; i17 < length; i17++) {
                    Object obj2 = existingSpans[i17];
                    if ((obj2 instanceof com.tencent.mobileqq.guild.feed.a) || (obj2 instanceof ForegroundColorSpan)) {
                        spannableStringBuilder.removeSpan(obj2);
                    }
                }
                Integer boxInt = Boxing.boxInt(i16);
                FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
                f16 = feedRichTextContentParser.f(guildJumpEntity.getGuildNumber(), z17);
                spannableStringBuilder.setSpan(new com.tencent.mobileqq.guild.feed.a(boxInt, true, f16), guildJumpEntity.getStartIndex(), guildJumpEntity.getEndIndex(), 33);
                e17 = feedRichTextContentParser.e(z18);
                objectRef.element = e17;
                i3 = 0;
            }
            j jVar = j.f112409a;
            String spannableStringBuilder3 = spannableStringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder3, "result.toString()");
            List<LinkSpanEntity> b17 = j.b(jVar, spannableStringBuilder3, false, this.$unMatchTypes, 2, null);
            int i18 = this.$linkColor;
            boolean z19 = this.$needSelectable;
            boolean z26 = this.$needDoubleTap;
            for (LinkSpanEntity linkSpanEntity : b17) {
                Object[] existingSpans2 = spannableStringBuilder.getSpans(linkSpanEntity.getStart(), linkSpanEntity.getEnd(), Object.class);
                Intrinsics.checkNotNullExpressionValue(existingSpans2, "existingSpans");
                if (existingSpans2.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    Integer boxInt2 = Boxing.boxInt(i18);
                    g16 = FeedRichTextContentParser.f221393a.g(linkSpanEntity.getContent(), z19);
                    spannableStringBuilder.setSpan(new com.tencent.mobileqq.guild.feed.a(boxInt2, false, g16), linkSpanEntity.getStart(), linkSpanEntity.getEnd(), 33);
                }
                e16 = FeedRichTextContentParser.f221393a.e(z26);
                objectRef.element = e16;
            }
            return new Pair(spannableStringBuilder, objectRef.element);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<? extends SpannableStringBuilder, ? extends com.tencent.aio.widget.textView.view.b>> continuation) {
        return ((FeedRichTextContentParser$parseLinkSpanAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
