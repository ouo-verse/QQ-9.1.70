package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data;

import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTextElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTextProps;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/k;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "i", "", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTextElem;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTextElem;", "textElem", "", "b", "I", "getIndex", "()I", "index", "c", "getParagraphIndex", "paragraphIndex", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTextElem;II)V", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProTextElem textElem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int paragraphIndex;

    public k(@NotNull GProTextElem textElem, int i3, int i16) {
        Intrinsics.checkNotNullParameter(textElem, "textElem");
        this.textElem = textElem;
        this.index = i3;
        this.paragraphIndex = i16;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h
    public int b() {
        return a.C7760a.a(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a
    public boolean e() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a
    @NotNull
    public LongFeedUIData i(@NotNull LongFeedParseParam parseParam) {
        Intrinsics.checkNotNullParameter(parseParam, "parseParam");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        String str = this.textElem.textContent.text;
        Intrinsics.checkNotNullExpressionValue(str, "textElem.textContent.text");
        com.tencent.aio.widget.textView.view.b l3 = feedRichTextContentParser.l(str, spannableStringBuilder, parseParam.g());
        if (l3 == null) {
            l3 = null;
        }
        com.tencent.aio.widget.textView.view.b j3 = feedRichTextContentParser.j(spannableStringBuilder, parseParam.g());
        if (j3 != null) {
            l3 = j3;
        }
        if (this.textElem.props.underline) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), 0, spannableStringBuilder.length(), 33);
        }
        GProTextProps gProTextProps = this.textElem.props;
        int i3 = gProTextProps.fontWeight;
        if (i3 > 500 && gProTextProps.italic) {
            spannableStringBuilder.setSpan(new StyleSpan(3), 0, spannableStringBuilder.length(), 33);
        } else if (i3 > 500) {
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 33);
        } else if (gProTextProps.italic) {
            spannableStringBuilder.setSpan(new StyleSpan(2), 0, spannableStringBuilder.length(), 33);
        }
        return new LongFeedUIData(spannableStringBuilder, new ArrayList(), l3, this.textElem.props.italic);
    }
}
