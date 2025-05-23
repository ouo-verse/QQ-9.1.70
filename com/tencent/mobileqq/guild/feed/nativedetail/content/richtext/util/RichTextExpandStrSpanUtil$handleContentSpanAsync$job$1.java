package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq0.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.RichTextExpandStrSpanUtil$handleContentSpanAsync$job$1", f = "RichTextExpandStrSpanUtil.kt", i = {}, l = {128, 148}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class RichTextExpandStrSpanUtil$handleContentSpanAsync$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $basicKey;
    final /* synthetic */ SpannableString $expandStringBuilder;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> $parseConfig;
    final /* synthetic */ SpannableStringBuilder $text;
    final /* synthetic */ l $txtView;
    final /* synthetic */ int $width;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.RichTextExpandStrSpanUtil$handleContentSpanAsync$job$1$1", f = "RichTextExpandStrSpanUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.RichTextExpandStrSpanUtil$handleContentSpanAsync$job$1$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $basicKey;
        final /* synthetic */ com.tencent.aio.widget.textView.view.b $movementMethod;
        final /* synthetic */ boolean $needTruncate;
        final /* synthetic */ SpannableStringBuilder $resultSpan;
        final /* synthetic */ l $txtView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(l lVar, boolean z16, com.tencent.aio.widget.textView.view.b bVar, SpannableStringBuilder spannableStringBuilder, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$txtView = lVar;
            this.$needTruncate = z16;
            this.$movementMethod = bVar;
            this.$resultSpan = spannableStringBuilder;
            this.$basicKey = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$txtView, this.$needTruncate, this.$movementMethod, this.$resultSpan, this.$basicKey, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                l lVar = this.$txtView;
                boolean z16 = this.$needTruncate;
                com.tencent.aio.widget.textView.view.b bVar = this.$movementMethod;
                SpannableStringBuilder spannableStringBuilder = this.$resultSpan;
                String str = this.$basicKey;
                if (z16 || bVar != null) {
                    lVar.f(spannableStringBuilder, str + "_" + spannableStringBuilder.length());
                }
                if (bVar != null) {
                    lVar.d(bVar, false);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichTextExpandStrSpanUtil$handleContentSpanAsync$job$1(SpannableStringBuilder spannableStringBuilder, IParseRichTextConfig<GProStRichTextContent> iParseRichTextConfig, l lVar, int i3, int i16, SpannableString spannableString, String str, Continuation<? super RichTextExpandStrSpanUtil$handleContentSpanAsync$job$1> continuation) {
        super(2, continuation);
        this.$text = spannableStringBuilder;
        this.$parseConfig = iParseRichTextConfig;
        this.$txtView = lVar;
        this.$width = i3;
        this.$maxLines = i16;
        this.$expandStringBuilder = spannableString;
        this.$basicKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RichTextExpandStrSpanUtil$handleContentSpanAsync$job$1(this.$text, this.$parseConfig, this.$txtView, this.$width, this.$maxLines, this.$expandStringBuilder, this.$basicKey, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Pair pair;
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
            FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
            SpannableStringBuilder spannableStringBuilder = this.$text;
            int n3 = this.$parseConfig.n();
            boolean j3 = this.$parseConfig.j();
            boolean e16 = this.$parseConfig.e();
            Set<Integer> r16 = this.$parseConfig.r();
            this.label = 1;
            obj = feedRichTextContentParser.m(spannableStringBuilder, n3, j3, e16, r16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Pair pair2 = (Pair) obj;
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) pair2.component1();
        com.tencent.aio.widget.textView.view.b bVar = (com.tencent.aio.widget.textView.view.b) pair2.component2();
        if (this.$parseConfig.b()) {
            FeedRichTextContentParser.f221393a.t(spannableStringBuilder2);
        }
        if (this.$parseConfig.i()) {
            pair = RichTextExpandStrSpanUtil.f221634a.s(spannableStringBuilder2, this.$txtView, this.$width, this.$maxLines, this.$expandStringBuilder);
        } else {
            pair = TuplesKt.to(Boxing.boxBoolean(true), spannableStringBuilder2);
        }
        boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
        SpannableStringBuilder spannableStringBuilder3 = (SpannableStringBuilder) pair.component2();
        MainCoroutineDispatcher e17 = ae.a().e();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$txtView, booleanValue, bVar, spannableStringBuilder3, this.$basicKey, null);
        this.label = 2;
        if (BuildersKt.withContext(e17, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RichTextExpandStrSpanUtil$handleContentSpanAsync$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
