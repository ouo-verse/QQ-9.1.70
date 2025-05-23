package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.FeedMixedMediaDataCompatTool;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.MediaRawDataAdapterFactory;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedVideoCoverViewAdapter;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedVideoViewAdapter;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVideoElem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qj1.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00158\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u00158\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/o;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/b;", "", "g", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/c;", "f", "j", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "i", "", "e", "a", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser$MediaInfo;", "getMediaInfo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProVideoElem;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProVideoElem;", "videoElem", "", "b", "I", "c", "()I", "index", "d", "paragraphIndex", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProVideoElem;II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class o implements a, b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProVideoElem videoElem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int paragraphIndex;

    public o(@NotNull GProVideoElem videoElem, int i3, int i16) {
        Intrinsics.checkNotNullParameter(videoElem, "videoElem");
        this.videoElem = videoElem;
        this.index = i3;
        this.paragraphIndex = i16;
    }

    private final com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c f(LongFeedParseParam parseParam) {
        if (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.c.a(parseParam.getSceneType())) {
            return h(parseParam);
        }
        return j(parseParam);
    }

    private final String g() {
        if (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a.k()) {
            return "v";
        }
        return "[\u89c6\u9891]";
    }

    private final com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c h(LongFeedParseParam parseParam) {
        long j3;
        GProStImage coverData = this.videoElem.video.cover;
        Intrinsics.checkNotNullExpressionValue(coverData, "coverData");
        String d16 = pl1.a.d(coverData);
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a;
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c a16 = bVar.a(parseParam.getTextViewContainer(), BaseLongFeedViewAdapter.TYPE.VIDEO_COVER, bVar.i(d16, getIndex(), getParagraphIndex()));
        if (a16 != null) {
            return a16;
        }
        GProStVideo gProStVideo = this.videoElem.video;
        if (gProStVideo != null) {
            j3 = gProStVideo.duration;
        } else {
            j3 = 0;
        }
        String videoTime = ax.y(j3);
        int i3 = coverData.width;
        int i16 = coverData.height;
        Intrinsics.checkNotNullExpressionValue(videoTime, "videoTime");
        return new com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c(new LongFeedVideoCoverViewAdapter(parseParam, 100.0f, d16, i3, i16, videoTime, this.videoElem.video.displayIndex, parseParam.getSceneType(), getIndex(), getParagraphIndex()));
    }

    private final com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c j(LongFeedParseParam parseParam) {
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a;
        GProStVideo gProStVideo = this.videoElem.video;
        Intrinsics.checkNotNullExpressionValue(gProStVideo, "videoElem.video");
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c a16 = bVar.a(parseParam.getTextViewContainer(), BaseLongFeedViewAdapter.TYPE.VIDEO, bVar.j(gProStVideo, getIndex(), getParagraphIndex()));
        if (a16 != null) {
            return a16;
        }
        GProStVideo gProStVideo2 = this.videoElem.video;
        Intrinsics.checkNotNullExpressionValue(gProStVideo2, "videoElem.video");
        return new com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c(new LongFeedVideoViewAdapter(parseParam, 100.0f, gProStVideo2, parseParam.getSceneType(), getIndex(), getParagraphIndex()));
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
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.b
    @NotNull
    public IFeedDetailDataParser.MediaInfo getMediaInfo() {
        String str;
        long j3;
        qj1.m a16;
        FeedMixedMediaDataCompatTool feedMixedMediaDataCompatTool = FeedMixedMediaDataCompatTool.f221103a;
        GProStVideo gProStVideo = this.videoElem.video;
        Intrinsics.checkNotNullExpressionValue(gProStVideo, "videoElem.video");
        v e16 = new MediaRawDataAdapterFactory().e(feedMixedMediaDataCompatTool.j(gProStVideo).getRaw());
        if (e16 == null || (a16 = e16.a()) == null || (str = a16.a(3)) == null) {
            str = "";
        }
        String str2 = str;
        if (e16 != null) {
            j3 = e16.getDurationMs();
        } else {
            j3 = 0;
        }
        return new IFeedDetailDataParser.MediaInfo(str2, 1, j3, r0.getWidth(), r0.getHeight(), 0, 32, null);
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
            QLog.d("LongFeedVideo", 4, "getSpannable, richSpan: " + f16.hashCode() + ", size: (" + f16.i().getWidth() + " x " + f16.i().getHeight() + ")");
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(f16);
        return new LongFeedUIData(spannableStringBuilder, arrayListOf, null, false, 8, null);
    }
}
