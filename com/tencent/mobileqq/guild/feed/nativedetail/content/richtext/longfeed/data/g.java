package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data;

import android.text.SpannableStringBuilder;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.FeedMixedMediaDataCompatTool;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.MediaRawDataAdapterFactory;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedImageViewAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProImageElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\rB\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00138\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u00138\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/g;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/b;", "", "g", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/c;", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "i", "", "e", "a", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser$MediaInfo;", "getMediaInfo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProImageElem;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProImageElem;", "imageElem", "", "b", "I", "c", "()I", "index", "d", "paragraphIndex", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProImageElem;II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g implements a, b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProImageElem imageElem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int paragraphIndex;

    public g(@NotNull GProImageElem imageElem, int i3, int i16) {
        Intrinsics.checkNotNullParameter(imageElem, "imageElem");
        this.imageElem = imageElem;
        this.index = i3;
        this.paragraphIndex = i16;
    }

    private final com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c f(LongFeedParseParam parseParam) {
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a;
        GProStImage gProStImage = this.imageElem.image;
        Intrinsics.checkNotNullExpressionValue(gProStImage, "imageElem.image");
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c a16 = bVar.a(parseParam.getTextViewContainer(), BaseLongFeedViewAdapter.TYPE.IMAGE, bVar.g(gProStImage, getIndex(), getParagraphIndex()));
        if (a16 != null) {
            return a16;
        }
        GProImageElem gProImageElem = this.imageElem;
        float f16 = gProImageElem.props.widthPercent;
        GProStImage gProStImage2 = gProImageElem.image;
        Intrinsics.checkNotNullExpressionValue(gProStImage2, "imageElem.image");
        return new com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c(new LongFeedImageViewAdapter(parseParam, f16, gProStImage2, parseParam.getSceneType(), getIndex(), getParagraphIndex()));
    }

    private final String g() {
        if (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a.k()) {
            return "i";
        }
        return GuildMsgElementApiImpl.DESC_ELEMENT_PIC;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.b
    public boolean a() {
        return true;
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
        if (this.imageElem.props.widthPercent < 100.0f) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.b
    @NotNull
    public IFeedDetailDataParser.MediaInfo getMediaInfo() {
        String str;
        FeedMixedMediaDataCompatTool feedMixedMediaDataCompatTool = FeedMixedMediaDataCompatTool.f221103a;
        GProStImage gProStImage = this.imageElem.image;
        Intrinsics.checkNotNullExpressionValue(gProStImage, "imageElem.image");
        qj1.m d16 = new MediaRawDataAdapterFactory().d(feedMixedMediaDataCompatTool.d(gProStImage).getRaw());
        if (d16 == null || (str = d16.a(3)) == null) {
            str = "";
        }
        return new IFeedDetailDataParser.MediaInfo(str, 0, 0L, r0.getWidth(), r0.getHeight(), 0, 32, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a
    @NotNull
    public LongFeedUIData i(@NotNull LongFeedParseParam parseParam) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(parseParam, "parseParam");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) g());
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c f16 = f(parseParam);
        spannableStringBuilder.setSpan(f16, 0, spannableStringBuilder.length(), 33);
        if (QLog.isDevelopLevel()) {
            QLog.d("LongFeedImage", 4, "getSpannable, richSpan: " + f16.hashCode() + ", size: (" + f16.i().getWidth() + " x " + f16.i().getHeight() + ")");
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(f16);
        return new LongFeedUIData(spannableStringBuilder, arrayListOf, null, false, 8, null);
    }
}
