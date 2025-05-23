package com.tencent.tavcut.core.render.builder.light.model;

import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J]\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020\u0006H\u00d6\u0001J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006'"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/TextPlaceInfo;", "", "key", "", "text", "fillColor", "", "maxLength", "layerWidth", "", "layerHeight", "replaceIndex", TemplateParser.KEY_ENTITY_ID, "(Ljava/lang/String;Ljava/lang/String;IIFFII)V", "getEntityId", "()I", "getFillColor", "getKey", "()Ljava/lang/String;", "getLayerHeight", "()F", "getLayerWidth", "getMaxLength", "getReplaceIndex", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class TextPlaceInfo {
    private final int entityId;
    private final int fillColor;

    @Nullable
    private final String key;
    private final float layerHeight;
    private final float layerWidth;
    private final int maxLength;
    private final int replaceIndex;

    @Nullable
    private final String text;

    public TextPlaceInfo(@Nullable String str, @Nullable String str2, int i3, int i16, float f16, float f17, int i17, int i18) {
        this.key = str;
        this.text = str2;
        this.fillColor = i3;
        this.maxLength = i16;
        this.layerWidth = f16;
        this.layerHeight = f17;
        this.replaceIndex = i17;
        this.entityId = i18;
    }

    public static /* synthetic */ TextPlaceInfo copy$default(TextPlaceInfo textPlaceInfo, String str, String str2, int i3, int i16, float f16, float f17, int i17, int i18, int i19, Object obj) {
        String str3;
        String str4;
        int i26;
        int i27;
        float f18;
        float f19;
        int i28;
        int i29;
        if ((i19 & 1) != 0) {
            str3 = textPlaceInfo.key;
        } else {
            str3 = str;
        }
        if ((i19 & 2) != 0) {
            str4 = textPlaceInfo.text;
        } else {
            str4 = str2;
        }
        if ((i19 & 4) != 0) {
            i26 = textPlaceInfo.fillColor;
        } else {
            i26 = i3;
        }
        if ((i19 & 8) != 0) {
            i27 = textPlaceInfo.maxLength;
        } else {
            i27 = i16;
        }
        if ((i19 & 16) != 0) {
            f18 = textPlaceInfo.layerWidth;
        } else {
            f18 = f16;
        }
        if ((i19 & 32) != 0) {
            f19 = textPlaceInfo.layerHeight;
        } else {
            f19 = f17;
        }
        if ((i19 & 64) != 0) {
            i28 = textPlaceInfo.replaceIndex;
        } else {
            i28 = i17;
        }
        if ((i19 & 128) != 0) {
            i29 = textPlaceInfo.entityId;
        } else {
            i29 = i18;
        }
        return textPlaceInfo.copy(str3, str4, i26, i27, f18, f19, i28, i29);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFillColor() {
        return this.fillColor;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMaxLength() {
        return this.maxLength;
    }

    /* renamed from: component5, reason: from getter */
    public final float getLayerWidth() {
        return this.layerWidth;
    }

    /* renamed from: component6, reason: from getter */
    public final float getLayerHeight() {
        return this.layerHeight;
    }

    /* renamed from: component7, reason: from getter */
    public final int getReplaceIndex() {
        return this.replaceIndex;
    }

    /* renamed from: component8, reason: from getter */
    public final int getEntityId() {
        return this.entityId;
    }

    @NotNull
    public final TextPlaceInfo copy(@Nullable String key, @Nullable String text, int fillColor, int maxLength, float layerWidth, float layerHeight, int replaceIndex, int entityId) {
        return new TextPlaceInfo(key, text, fillColor, maxLength, layerWidth, layerHeight, replaceIndex, entityId);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof TextPlaceInfo) {
                TextPlaceInfo textPlaceInfo = (TextPlaceInfo) other;
                if (!Intrinsics.areEqual(this.key, textPlaceInfo.key) || !Intrinsics.areEqual(this.text, textPlaceInfo.text) || this.fillColor != textPlaceInfo.fillColor || this.maxLength != textPlaceInfo.maxLength || Float.compare(this.layerWidth, textPlaceInfo.layerWidth) != 0 || Float.compare(this.layerHeight, textPlaceInfo.layerHeight) != 0 || this.replaceIndex != textPlaceInfo.replaceIndex || this.entityId != textPlaceInfo.entityId) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getEntityId() {
        return this.entityId;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    public final float getLayerHeight() {
        return this.layerHeight;
    }

    public final float getLayerWidth() {
        return this.layerWidth;
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    public final int getReplaceIndex() {
        return this.replaceIndex;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int i3;
        String str = this.key;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.text;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return ((((((((((((i17 + i16) * 31) + this.fillColor) * 31) + this.maxLength) * 31) + Float.floatToIntBits(this.layerWidth)) * 31) + Float.floatToIntBits(this.layerHeight)) * 31) + this.replaceIndex) * 31) + this.entityId;
    }

    @NotNull
    public String toString() {
        return "TextPlaceInfo(key=" + this.key + ", text=" + this.text + ", fillColor=" + this.fillColor + ", maxLength=" + this.maxLength + ", layerWidth=" + this.layerWidth + ", layerHeight=" + this.layerHeight + ", replaceIndex=" + this.replaceIndex + ", entityId=" + this.entityId + ")";
    }

    public /* synthetic */ TextPlaceInfo(String str, String str2, int i3, int i16, float f16, float f17, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? null : str, (i19 & 2) != 0 ? null : str2, i3, i16, f16, f17, i17, i18);
    }
}
