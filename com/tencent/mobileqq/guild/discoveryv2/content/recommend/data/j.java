package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import android.graphics.Typeface;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u001a8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;", "", "", "getRootBg", "()Z", "rootBg", "", "getMediaRatio", "()F", "setMediaRatio", "(F)V", "mediaRatio", "", "getMediaLayoutRoundCorner", "()[F", "mediaLayoutRoundCorner", "", "getTextPadding", "()[I", "textPadding", "", "getMaxLines", "()I", "setMaxLines", "(I)V", "maxLines", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", TextComponent.SpanStyle.TYPEFACE, "getMinH", "minH", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface j {
    int getMaxLines();

    @NotNull
    float[] getMediaLayoutRoundCorner();

    float getMediaRatio();

    int getMinH();

    boolean getRootBg();

    @NotNull
    int[] getTextPadding();

    @NotNull
    Typeface getTypeface();

    void setMaxLines(int i3);

    void setMediaRatio(float f16);

    void setTypeface(@NotNull Typeface typeface);
}
