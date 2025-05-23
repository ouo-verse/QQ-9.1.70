package com.tencent.qqmini.sdk.launcher.core.proxy.va;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/TipsElementData;", "", "type", "", "content", "", "textColor", "stroke", "", "(ILjava/lang/String;Ljava/lang/String;Z)V", "getContent", "()Ljava/lang/String;", "getStroke", "()Z", "getTextColor", "setTextColor", "(Ljava/lang/String;)V", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "Companion", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final /* data */ class TipsElementData {

    @NotNull
    public static final String DEFAULT_COLOR = "#ffffff";

    @NotNull
    private final String content;
    private final boolean stroke;

    @NotNull
    private String textColor;
    private final int type;

    public TipsElementData(@TipsDataType int i3, @NotNull String content, @NotNull String textColor, boolean z16) {
        Intrinsics.checkParameterIsNotNull(content, "content");
        Intrinsics.checkParameterIsNotNull(textColor, "textColor");
        this.type = i3;
        this.content = content;
        this.textColor = textColor;
        this.stroke = z16;
    }

    public static /* synthetic */ TipsElementData copy$default(TipsElementData tipsElementData, int i3, String str, String str2, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = tipsElementData.type;
        }
        if ((i16 & 2) != 0) {
            str = tipsElementData.content;
        }
        if ((i16 & 4) != 0) {
            str2 = tipsElementData.textColor;
        }
        if ((i16 & 8) != 0) {
            z16 = tipsElementData.stroke;
        }
        return tipsElementData.copy(i3, str, str2, z16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getStroke() {
        return this.stroke;
    }

    @NotNull
    public final TipsElementData copy(@TipsDataType int type, @NotNull String content, @NotNull String textColor, boolean stroke) {
        Intrinsics.checkParameterIsNotNull(content, "content");
        Intrinsics.checkParameterIsNotNull(textColor, "textColor");
        return new TipsElementData(type, content, textColor, stroke);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof TipsElementData) {
                TipsElementData tipsElementData = (TipsElementData) other;
                if (this.type != tipsElementData.type || !Intrinsics.areEqual(this.content, tipsElementData.content) || !Intrinsics.areEqual(this.textColor, tipsElementData.textColor) || this.stroke != tipsElementData.stroke) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final boolean getStroke() {
        return this.stroke;
    }

    @NotNull
    public final String getTextColor() {
        return this.textColor;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16 = this.type * 31;
        String str = this.content;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i16 + i3) * 31;
        String str2 = this.textColor;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        int i19 = (i18 + i17) * 31;
        boolean z16 = this.stroke;
        int i26 = z16;
        if (z16 != 0) {
            i26 = 1;
        }
        return i19 + i26;
    }

    public final void setTextColor(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.textColor = str;
    }

    @NotNull
    public String toString() {
        return "TipsElementData(type=" + this.type + ", content=" + this.content + ", textColor=" + this.textColor + ", stroke=" + this.stroke + ")";
    }

    public /* synthetic */ TipsElementData(int i3, String str, String str2, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? DEFAULT_COLOR : str2, (i16 & 8) != 0 ? true : z16);
    }
}
