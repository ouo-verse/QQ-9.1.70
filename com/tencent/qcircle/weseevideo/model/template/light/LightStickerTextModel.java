package com.tencent.qcircle.weseevideo.model.template.light;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/template/light/LightStickerTextModel;", "", "stickerTextContent", "", "stickerTextColor", "", "(Ljava/lang/String;I)V", "getStickerTextColor", "()I", "setStickerTextColor", "(I)V", "getStickerTextContent", "()Ljava/lang/String;", "setStickerTextContent", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class LightStickerTextModel {
    private int stickerTextColor;

    @Nullable
    private String stickerTextContent;

    public LightStickerTextModel() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LightStickerTextModel copy$default(LightStickerTextModel lightStickerTextModel, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = lightStickerTextModel.stickerTextContent;
        }
        if ((i16 & 2) != 0) {
            i3 = lightStickerTextModel.stickerTextColor;
        }
        return lightStickerTextModel.copy(str, i3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getStickerTextContent() {
        return this.stickerTextContent;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStickerTextColor() {
        return this.stickerTextColor;
    }

    @NotNull
    public final LightStickerTextModel copy(@Nullable String stickerTextContent, int stickerTextColor) {
        return new LightStickerTextModel(stickerTextContent, stickerTextColor);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof LightStickerTextModel) {
                LightStickerTextModel lightStickerTextModel = (LightStickerTextModel) other;
                if (!Intrinsics.areEqual(this.stickerTextContent, lightStickerTextModel.stickerTextContent) || this.stickerTextColor != lightStickerTextModel.stickerTextColor) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getStickerTextColor() {
        return this.stickerTextColor;
    }

    @Nullable
    public final String getStickerTextContent() {
        return this.stickerTextContent;
    }

    public int hashCode() {
        int i3;
        String str = this.stickerTextContent;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return (i3 * 31) + this.stickerTextColor;
    }

    public final void setStickerTextColor(int i3) {
        this.stickerTextColor = i3;
    }

    public final void setStickerTextContent(@Nullable String str) {
        this.stickerTextContent = str;
    }

    @NotNull
    public String toString() {
        return "LightStickerTextModel(stickerTextContent=" + this.stickerTextContent + ", stickerTextColor=" + this.stickerTextColor + ")";
    }

    public LightStickerTextModel(@Nullable String str, int i3) {
        this.stickerTextContent = str;
        this.stickerTextColor = i3;
    }

    public /* synthetic */ LightStickerTextModel(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : str, (i16 & 2) != 0 ? -1 : i3);
    }
}
