package com.tencent.mobileqq.profilecard.vas;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\t\u0010#\u001a\u00020\u0007H\u00c6\u0003J\t\u0010$\u001a\u00020\u0007H\u00c6\u0003J\t\u0010%\u001a\u00020\u0007H\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003Jq\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u0005H\u00d6\u0001J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "", "diyText", "", "diyTextFontId", "", "diyTextWidth", "", "diyTextHeight", "diyTextLocX", "diyTextLocY", "diyTextDegree", "diyTextScale", "diyTextTransparency", "diyDefaultText", "(Ljava/lang/String;IFFFFFFFLjava/lang/String;)V", "getDiyDefaultText", "()Ljava/lang/String;", "getDiyText", "getDiyTextDegree", "()F", "getDiyTextFontId", "()I", "getDiyTextHeight", "getDiyTextLocX", "getDiyTextLocY", "getDiyTextScale", "getDiyTextTransparency", "getDiyTextWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class VasDiyTextData {

    @Nullable
    private final String diyDefaultText;

    @Nullable
    private final String diyText;
    private final float diyTextDegree;
    private final int diyTextFontId;
    private final float diyTextHeight;
    private final float diyTextLocX;
    private final float diyTextLocY;
    private final float diyTextScale;
    private final float diyTextTransparency;
    private final float diyTextWidth;

    public VasDiyTextData() {
        this(null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 1023, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getDiyText() {
        return this.diyText;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getDiyDefaultText() {
        return this.diyDefaultText;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDiyTextFontId() {
        return this.diyTextFontId;
    }

    /* renamed from: component3, reason: from getter */
    public final float getDiyTextWidth() {
        return this.diyTextWidth;
    }

    /* renamed from: component4, reason: from getter */
    public final float getDiyTextHeight() {
        return this.diyTextHeight;
    }

    /* renamed from: component5, reason: from getter */
    public final float getDiyTextLocX() {
        return this.diyTextLocX;
    }

    /* renamed from: component6, reason: from getter */
    public final float getDiyTextLocY() {
        return this.diyTextLocY;
    }

    /* renamed from: component7, reason: from getter */
    public final float getDiyTextDegree() {
        return this.diyTextDegree;
    }

    /* renamed from: component8, reason: from getter */
    public final float getDiyTextScale() {
        return this.diyTextScale;
    }

    /* renamed from: component9, reason: from getter */
    public final float getDiyTextTransparency() {
        return this.diyTextTransparency;
    }

    @NotNull
    public final VasDiyTextData copy(@Nullable String diyText, int diyTextFontId, float diyTextWidth, float diyTextHeight, float diyTextLocX, float diyTextLocY, float diyTextDegree, float diyTextScale, float diyTextTransparency, @Nullable String diyDefaultText) {
        return new VasDiyTextData(diyText, diyTextFontId, diyTextWidth, diyTextHeight, diyTextLocX, diyTextLocY, diyTextDegree, diyTextScale, diyTextTransparency, diyDefaultText);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasDiyTextData)) {
            return false;
        }
        VasDiyTextData vasDiyTextData = (VasDiyTextData) other;
        if (Intrinsics.areEqual(this.diyText, vasDiyTextData.diyText) && this.diyTextFontId == vasDiyTextData.diyTextFontId && Float.compare(this.diyTextWidth, vasDiyTextData.diyTextWidth) == 0 && Float.compare(this.diyTextHeight, vasDiyTextData.diyTextHeight) == 0 && Float.compare(this.diyTextLocX, vasDiyTextData.diyTextLocX) == 0 && Float.compare(this.diyTextLocY, vasDiyTextData.diyTextLocY) == 0 && Float.compare(this.diyTextDegree, vasDiyTextData.diyTextDegree) == 0 && Float.compare(this.diyTextScale, vasDiyTextData.diyTextScale) == 0 && Float.compare(this.diyTextTransparency, vasDiyTextData.diyTextTransparency) == 0 && Intrinsics.areEqual(this.diyDefaultText, vasDiyTextData.diyDefaultText)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getDiyDefaultText() {
        return this.diyDefaultText;
    }

    @Nullable
    public final String getDiyText() {
        return this.diyText;
    }

    public final float getDiyTextDegree() {
        return this.diyTextDegree;
    }

    public final int getDiyTextFontId() {
        return this.diyTextFontId;
    }

    public final float getDiyTextHeight() {
        return this.diyTextHeight;
    }

    public final float getDiyTextLocX() {
        return this.diyTextLocX;
    }

    public final float getDiyTextLocY() {
        return this.diyTextLocY;
    }

    public final float getDiyTextScale() {
        return this.diyTextScale;
    }

    public final float getDiyTextTransparency() {
        return this.diyTextTransparency;
    }

    public final float getDiyTextWidth() {
        return this.diyTextWidth;
    }

    public int hashCode() {
        int hashCode;
        String str = this.diyText;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int floatToIntBits = ((((((((((((((((hashCode * 31) + this.diyTextFontId) * 31) + Float.floatToIntBits(this.diyTextWidth)) * 31) + Float.floatToIntBits(this.diyTextHeight)) * 31) + Float.floatToIntBits(this.diyTextLocX)) * 31) + Float.floatToIntBits(this.diyTextLocY)) * 31) + Float.floatToIntBits(this.diyTextDegree)) * 31) + Float.floatToIntBits(this.diyTextScale)) * 31) + Float.floatToIntBits(this.diyTextTransparency)) * 31;
        String str2 = this.diyDefaultText;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return floatToIntBits + i3;
    }

    @NotNull
    public String toString() {
        return "VasDiyTextData(diyText=" + this.diyText + ", diyTextFontId=" + this.diyTextFontId + ", diyTextWidth=" + this.diyTextWidth + ", diyTextHeight=" + this.diyTextHeight + ", diyTextLocX=" + this.diyTextLocX + ", diyTextLocY=" + this.diyTextLocY + ", diyTextDegree=" + this.diyTextDegree + ", diyTextScale=" + this.diyTextScale + ", diyTextTransparency=" + this.diyTextTransparency + ", diyDefaultText=" + this.diyDefaultText + ")";
    }

    public VasDiyTextData(@Nullable String str, int i3, float f16, float f17, float f18, float f19, float f26, float f27, float f28, @Nullable String str2) {
        this.diyText = str;
        this.diyTextFontId = i3;
        this.diyTextWidth = f16;
        this.diyTextHeight = f17;
        this.diyTextLocX = f18;
        this.diyTextLocY = f19;
        this.diyTextDegree = f26;
        this.diyTextScale = f27;
        this.diyTextTransparency = f28;
        this.diyDefaultText = str2;
    }

    public /* synthetic */ VasDiyTextData(String str, int i3, float f16, float f17, float f18, float f19, float f26, float f27, float f28, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? 0.0f : f16, (i16 & 8) != 0 ? 0.0f : f17, (i16 & 16) != 0 ? 0.0f : f18, (i16 & 32) != 0 ? 0.0f : f19, (i16 & 64) != 0 ? 0.0f : f26, (i16 & 128) != 0 ? 1.0f : f27, (i16 & 256) == 0 ? f28 : 0.0f, (i16 & 512) == 0 ? str2 : null);
    }
}
