package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import android.graphics.Typeface;
import android.util.Size;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001b\u001a\u00020\u00048\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010%\u001a\u00020 8\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00048\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0018R\u0014\u0010+\u001a\u00020(8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R\u001c\u00105\u001a\u0002008\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendThirdShareLinkData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/k;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;", "", "getItemType", "cover", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/k;", "layoutParams", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExtData", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getRecommendExtData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "", "getMediaCoverURL", "()Ljava/lang/String;", "mediaCoverURL", "Landroid/util/Size;", "getMediaRawSize", "()Landroid/util/Size;", "mediaRawSize", "getMaxLines", "()I", "setMaxLines", "(I)V", "maxLines", "", "getMediaLayoutRoundCorner", "()[F", "mediaLayoutRoundCorner", "", "getMediaRatio", "()F", "setMediaRatio", "(F)V", "mediaRatio", "getMinH", "minH", "", "getRootBg", "()Z", "rootBg", "", "getTextPadding", "()[I", "textPadding", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", TextComponent.SpanStyle.TYPEFACE, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "feed", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/k;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendThirdShareLinkData extends RecommendAbsFeedData implements k, j {

    @NotNull
    private final k cover;

    @NotNull
    private final j layoutParams;

    @NotNull
    private final RecommendExtData recommendExtData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendThirdShareLinkData(@NotNull IGProContentRecommendFeed feed, @NotNull k cover, @NotNull j layoutParams, @NotNull RecommendExtData recommendExtData) {
        super(feed);
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(recommendExtData, "recommendExtData");
        this.cover = cover;
        this.layoutParams = layoutParams;
        this.recommendExtData = recommendExtData;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData, com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public int getItemType() {
        return com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE.z();
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
