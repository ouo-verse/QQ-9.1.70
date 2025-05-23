package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import android.graphics.Typeface;
import android.util.Size;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\u00020\u00048\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u00020\u001d8\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u00048\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0015R\u0014\u0010(\u001a\u00020%8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u001c\u00102\u001a\u00020-8\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendVideoMixData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/k;", "", "getItemType", "cover", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/k;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "gproStVideo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "getGproStVideo", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "layoutParams", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExtData", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getRecommendExtData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getMaxLines", "()I", "setMaxLines", "(I)V", "maxLines", "", "getMediaLayoutRoundCorner", "()[F", "mediaLayoutRoundCorner", "", "getMediaRatio", "()F", "setMediaRatio", "(F)V", "mediaRatio", "getMinH", "minH", "", "getRootBg", "()Z", "rootBg", "", "getTextPadding", "()[I", "textPadding", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", TextComponent.SpanStyle.TYPEFACE, "", "getMediaCoverURL", "()Ljava/lang/String;", "mediaCoverURL", "Landroid/util/Size;", "getMediaRawSize", "()Landroid/util/Size;", "mediaRawSize", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "content", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/k;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendVideoMixData extends RecommendAbsFeedData implements j, k {

    @NotNull
    private final k cover;

    @Nullable
    private final GProStVideo gproStVideo;

    @NotNull
    private final j layoutParams;

    @NotNull
    private final RecommendExtData recommendExtData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendVideoMixData(@NotNull IGProContentRecommendFeed content, @NotNull k cover, @Nullable GProStVideo gProStVideo, @NotNull j layoutParams, @NotNull RecommendExtData recommendExtData) {
        super(content);
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(recommendExtData, "recommendExtData");
        this.cover = cover;
        this.gproStVideo = gProStVideo;
        this.layoutParams = layoutParams;
        this.recommendExtData = recommendExtData;
    }

    @Nullable
    public final GProStVideo getGproStVideo() {
        return this.gproStVideo;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData, com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public int getItemType() {
        return com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE.B();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public int getMaxLines() {
        return this.layoutParams.getMaxLines();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.k
    @NotNull
    public String getMediaCoverURL() {
        return this.cover.getMediaCoverURL();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    @NotNull
    public float[] getMediaLayoutRoundCorner() {
        return this.layoutParams.getMediaLayoutRoundCorner();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public float getMediaRatio() {
        return this.layoutParams.getMediaRatio();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.k
    @NotNull
    public Size getMediaRawSize() {
        return this.cover.getMediaRawSize();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public int getMinH() {
        return this.layoutParams.getMinH();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData, com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public RecommendExtData getRecommendExtData() {
        return this.recommendExtData;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public boolean getRootBg() {
        return this.layoutParams.getRootBg();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    @NotNull
    public int[] getTextPadding() {
        return this.layoutParams.getTextPadding();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    @NotNull
    public Typeface getTypeface() {
        return this.layoutParams.getTypeface();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public void setMaxLines(int i3) {
        this.layoutParams.setMaxLines(i3);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public void setMediaRatio(float f16) {
        this.layoutParams.setMediaRatio(f16);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public void setTypeface(@NotNull Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "<set-?>");
        this.layoutParams.setTypeface(typeface);
    }
}
