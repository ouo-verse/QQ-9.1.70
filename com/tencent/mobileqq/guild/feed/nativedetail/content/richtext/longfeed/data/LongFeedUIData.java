package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\n\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/text/SpannableStringBuilder;", "a", "Landroid/text/SpannableStringBuilder;", "c", "()Landroid/text/SpannableStringBuilder;", "spannable", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/c;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "richTextSpans", "Lcom/tencent/aio/widget/textView/view/b;", "Lcom/tencent/aio/widget/textView/view/b;", "d", "()Lcom/tencent/aio/widget/textView/view/b;", "touchMovementMethod", "Z", "()Z", "hasItalicText", "<init>", "(Landroid/text/SpannableStringBuilder;Ljava/util/ArrayList;Lcom/tencent/aio/widget/textView/view/b;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.m, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class LongFeedUIData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SpannableStringBuilder spannable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> richTextSpans;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final com.tencent.aio.widget.textView.view.b touchMovementMethod;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasItalicText;

    public LongFeedUIData(@NotNull SpannableStringBuilder spannable, @NotNull ArrayList<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> richTextSpans, @Nullable com.tencent.aio.widget.textView.view.b bVar, boolean z16) {
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        Intrinsics.checkNotNullParameter(richTextSpans, "richTextSpans");
        this.spannable = spannable;
        this.richTextSpans = richTextSpans;
        this.touchMovementMethod = bVar;
        this.hasItalicText = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getHasItalicText() {
        return this.hasItalicText;
    }

    @NotNull
    public final ArrayList<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> b() {
        return this.richTextSpans;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final SpannableStringBuilder getSpannable() {
        return this.spannable;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final com.tencent.aio.widget.textView.view.b getTouchMovementMethod() {
        return this.touchMovementMethod;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LongFeedUIData)) {
            return false;
        }
        LongFeedUIData longFeedUIData = (LongFeedUIData) other;
        if (Intrinsics.areEqual(this.spannable, longFeedUIData.spannable) && Intrinsics.areEqual(this.richTextSpans, longFeedUIData.richTextSpans) && Intrinsics.areEqual(this.touchMovementMethod, longFeedUIData.touchMovementMethod) && this.hasItalicText == longFeedUIData.hasItalicText) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.spannable.hashCode() * 31) + this.richTextSpans.hashCode()) * 31;
        com.tencent.aio.widget.textView.view.b bVar = this.touchMovementMethod;
        if (bVar == null) {
            hashCode = 0;
        } else {
            hashCode = bVar.hashCode();
        }
        int i3 = (hashCode2 + hashCode) * 31;
        boolean z16 = this.hasItalicText;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    @NotNull
    public String toString() {
        SpannableStringBuilder spannableStringBuilder = this.spannable;
        return "LongFeedUIData(spannable=" + ((Object) spannableStringBuilder) + ", richTextSpans=" + this.richTextSpans + ", touchMovementMethod=" + this.touchMovementMethod + ", hasItalicText=" + this.hasItalicText + ")";
    }

    public /* synthetic */ LongFeedUIData(SpannableStringBuilder spannableStringBuilder, ArrayList arrayList, com.tencent.aio.widget.textView.view.b bVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(spannableStringBuilder, arrayList, bVar, (i3 & 8) != 0 ? false : z16);
    }
}
