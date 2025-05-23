package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import android.graphics.Typeface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010#\u001a\u00020\u001c\u0012\u0006\u0010+\u001a\u00020$\u0012\b\b\u0002\u0010/\u001a\u00020\u001c\u00a2\u0006\u0004\b0\u00101R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010/\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/h;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;", "", "d", "Z", "getRootBg", "()Z", "rootBg", "", "e", UserInfo.SEX_FEMALE, "getMediaRatio", "()F", "setMediaRatio", "(F)V", "mediaRatio", "", "f", "[F", "getMediaLayoutRoundCorner", "()[F", "mediaLayoutRoundCorner", "", tl.h.F, "[I", "getTextPadding", "()[I", "textPadding", "", "i", "I", "getMaxLines", "()I", "setMaxLines", "(I)V", "maxLines", "Landroid/graphics/Typeface;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", TextComponent.SpanStyle.TYPEFACE, BdhLogUtil.LogTag.Tag_Conn, "getMinH", "a", "minH", "<init>", "(ZF[F[IILandroid/graphics/Typeface;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h implements j {

    /* renamed from: C, reason: from kotlin metadata */
    private int minH;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean rootBg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mediaRatio;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] mediaLayoutRoundCorner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] textPadding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int maxLines;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Typeface typeface;

    public h(boolean z16, float f16, @NotNull float[] mediaLayoutRoundCorner, @NotNull int[] textPadding, int i3, @NotNull Typeface typeface, int i16) {
        Intrinsics.checkNotNullParameter(mediaLayoutRoundCorner, "mediaLayoutRoundCorner");
        Intrinsics.checkNotNullParameter(textPadding, "textPadding");
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.rootBg = z16;
        this.mediaRatio = f16;
        this.mediaLayoutRoundCorner = mediaLayoutRoundCorner;
        this.textPadding = textPadding;
        this.maxLines = i3;
        this.typeface = typeface;
        this.minH = i16;
    }

    public void a(int i3) {
        this.minH = i3;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    @NotNull
    public float[] getMediaLayoutRoundCorner() {
        return this.mediaLayoutRoundCorner;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public float getMediaRatio() {
        return this.mediaRatio;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public int getMinH() {
        return this.minH;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public boolean getRootBg() {
        return this.rootBg;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    @NotNull
    public int[] getTextPadding() {
        return this.textPadding;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    @NotNull
    public Typeface getTypeface() {
        return this.typeface;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public void setMaxLines(int i3) {
        this.maxLines = i3;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public void setMediaRatio(float f16) {
        this.mediaRatio = f16;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j
    public void setTypeface(@NotNull Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "<set-?>");
        this.typeface = typeface;
    }

    public /* synthetic */ h(boolean z16, float f16, float[] fArr, int[] iArr, int i3, Typeface typeface, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, f16, fArr, iArr, i3, typeface, (i17 & 64) != 0 ? Integer.MAX_VALUE : i16);
    }
}
