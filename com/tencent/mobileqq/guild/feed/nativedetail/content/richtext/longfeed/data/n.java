package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.TextViewContainer;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedThirdVideoViewAdapter;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedVideoCoverViewAdapter;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProURLElem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0017\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00178\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u00178\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/n;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "j", tl.h.F, "", "g", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/c;", "f", "l", "k", "i", "", "e", "a", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser$MediaInfo;", "getMediaInfo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProURLElem;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProURLElem;", "urlElem", "", "b", "I", "c", "()I", "index", "d", "paragraphIndex", "Z", "isThirdVideo", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProURLElem;II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n implements a, b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProURLElem urlElem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int paragraphIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isThirdVideo;

    public n(@NotNull GProURLElem urlElem, int i3, int i16) {
        Intrinsics.checkNotNullParameter(urlElem, "urlElem");
        this.urlElem = urlElem;
        this.index = i3;
        this.paragraphIndex = i16;
    }

    private final com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c f(LongFeedParseParam parseParam) {
        if (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.c.a(parseParam.getSceneType())) {
            return k(parseParam);
        }
        return l(parseParam);
    }

    private final String g() {
        if (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a.k()) {
            return "t";
        }
        return "[\u89c6\u9891]";
    }

    private final LongFeedUIData h(LongFeedParseParam parseParam) {
        ArrayList arrayListOf;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) g());
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c f16 = f(parseParam);
        spannableStringBuilder.setSpan(f16, 0, spannableStringBuilder.length(), 33);
        if (QLog.isDevelopLevel()) {
            QLog.d("LongFeedThirdVideo", 4, "getSpannable, richSpan: " + f16.hashCode() + ", size: (" + f16.i().getWidth() + " x " + f16.i().getHeight() + ")");
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(f16);
        return new LongFeedUIData(spannableStringBuilder, arrayListOf, null, false, 8, null);
    }

    private final LongFeedUIData j(LongFeedParseParam parseParam) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        boolean e16 = parseParam.g().e();
        boolean d16 = parseParam.g().d();
        IParseRichTextConfig<GProElem> g16 = parseParam.g();
        GProElem gProElem = new GProElem();
        gProElem.url = this.urlElem;
        Unit unit = Unit.INSTANCE;
        Drawable m3 = g16.m(gProElem);
        String str = this.urlElem.urlContent.url;
        Intrinsics.checkNotNullExpressionValue(str, "urlElem.urlContent.url");
        feedRichTextContentParser.x(e16, d16, m3, str, spannableStringBuilder);
        String str2 = this.urlElem.urlContent.url;
        Intrinsics.checkNotNullExpressionValue(str2, "urlElem.urlContent.url");
        String str3 = this.urlElem.urlContent.displayText;
        Intrinsics.checkNotNullExpressionValue(str3, "urlElem.urlContent.displayText");
        IParseRichTextConfig<GProElem> g17 = parseParam.g();
        Boolean bool = Boolean.TRUE;
        return new LongFeedUIData(spannableStringBuilder, new ArrayList(), feedRichTextContentParser.w(str2, str3, spannableStringBuilder, g17, new Pair<>(bool, bool)), false, 8, null);
    }

    private final com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c k(LongFeedParseParam parseParam) {
        String coverUrl = this.urlElem.urlContent.getThirdVideoInfo().cover;
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a;
        TextViewContainer textViewContainer = parseParam.getTextViewContainer();
        BaseLongFeedViewAdapter.TYPE type = BaseLongFeedViewAdapter.TYPE.VIDEO_COVER;
        Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c a16 = bVar.a(textViewContainer, type, bVar.i(coverUrl, getIndex(), getParagraphIndex()));
        if (a16 != null) {
            return a16;
        }
        return new com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c(new LongFeedVideoCoverViewAdapter(parseParam, 100.0f, coverUrl, 0, 0, "", -1, parseParam.getSceneType(), getIndex(), getParagraphIndex()));
    }

    private final com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c l(LongFeedParseParam parseParam) {
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a;
        TextViewContainer textViewContainer = parseParam.getTextViewContainer();
        BaseLongFeedViewAdapter.TYPE type = BaseLongFeedViewAdapter.TYPE.THIRD_VIDEO;
        String str = this.urlElem.urlContent.playUrl;
        Intrinsics.checkNotNullExpressionValue(str, "urlElem.urlContent.playUrl");
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c a16 = bVar.a(textViewContainer, type, bVar.h(str, getIndex(), getParagraphIndex()));
        if (a16 != null) {
            return a16;
        }
        Context context = parseParam.getTextViewContainer().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parseParam.textViewContainer.context");
        GProStRichTextURLContent gProStRichTextURLContent = this.urlElem.urlContent;
        Intrinsics.checkNotNullExpressionValue(gProStRichTextURLContent, "urlElem.urlContent");
        return new com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c(new LongFeedThirdVideoViewAdapter(context, gProStRichTextURLContent, parseParam.e(), parseParam.getSceneType(), getIndex(), getParagraphIndex()));
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.b
    public boolean a() {
        if (this.urlElem.urlContent.type == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h
    /* renamed from: b */
    public int getDisplayIndex() {
        return a.C7760a.a(this);
    }

    /* renamed from: c, reason: from getter */
    public int getIndex() {
        return this.index;
    }

    /* renamed from: d, reason: from getter */
    public int getParagraphIndex() {
        return this.paragraphIndex;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a
    public boolean e() {
        if (this.isThirdVideo) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.b
    @Nullable
    public IFeedDetailDataParser.MediaInfo getMediaInfo() {
        if (a()) {
            String str = this.urlElem.urlContent.thirdVideoInfo.cover;
            Intrinsics.checkNotNullExpressionValue(str, "urlElem.urlContent.thirdVideoInfo.cover");
            return new IFeedDetailDataParser.MediaInfo(str, 1, this.urlElem.urlContent.thirdVideoInfo.duration * 1000, 0.0f, 0.0f, 0, 32, null);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a
    @NotNull
    public LongFeedUIData i(@NotNull LongFeedParseParam parseParam) {
        Intrinsics.checkNotNullParameter(parseParam, "parseParam");
        int i3 = this.urlElem.urlContent.type;
        if (i3 == 1) {
            this.isThirdVideo = true;
            return h(parseParam);
        }
        if (i3 == 5) {
            return new LongFeedUIData(new SpannableStringBuilder(), new ArrayList(), null, false, 8, null);
        }
        return j(parseParam);
    }
}
