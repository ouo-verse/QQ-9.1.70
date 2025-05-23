package com.tencent.state.square.api;

import android.graphics.Color;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0006\u0010\u001a\u001a\u00020\u0000J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/square/api/SummaryData;", "", "isContainEmoji", "", "highText", "", "msgText", "highColor", "", "status", "isTroop", "(ZLjava/lang/String;Ljava/lang/String;IIZ)V", "getHighColor", "()I", "getHighText", "()Ljava/lang/String;", "()Z", "getMsgText", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "component1", "component2", "component3", "component4", "component5", "component6", "copy", "copyDepth", "equals", "other", "hashCode", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class SummaryData {
    private final int highColor;

    @Nullable
    private final String highText;
    private final boolean isContainEmoji;
    private final boolean isTroop;

    @Nullable
    private final String msgText;
    private final int status;

    public SummaryData() {
        this(false, null, null, 0, 0, false, 63, null);
    }

    public static /* synthetic */ SummaryData copy$default(SummaryData summaryData, boolean z16, String str, String str2, int i3, int i16, boolean z17, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            z16 = summaryData.isContainEmoji;
        }
        if ((i17 & 2) != 0) {
            str = summaryData.highText;
        }
        String str3 = str;
        if ((i17 & 4) != 0) {
            str2 = summaryData.msgText;
        }
        String str4 = str2;
        if ((i17 & 8) != 0) {
            i3 = summaryData.highColor;
        }
        int i18 = i3;
        if ((i17 & 16) != 0) {
            i16 = summaryData.status;
        }
        int i19 = i16;
        if ((i17 & 32) != 0) {
            z17 = summaryData.isTroop;
        }
        return summaryData.copy(z16, str3, str4, i18, i19, z17);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsContainEmoji() {
        return this.isContainEmoji;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getHighText() {
        return this.highText;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMsgText() {
        return this.msgText;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHighColor() {
        return this.highColor;
    }

    /* renamed from: component5, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsTroop() {
        return this.isTroop;
    }

    @NotNull
    public final SummaryData copy(boolean isContainEmoji, @Nullable String highText, @Nullable String msgText, int highColor, int status, boolean isTroop) {
        return new SummaryData(isContainEmoji, highText, msgText, highColor, status, isTroop);
    }

    @NotNull
    public final SummaryData copyDepth() {
        return new SummaryData(this.isContainEmoji, this.highText, this.msgText, this.highColor, this.status, this.isTroop);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SummaryData) {
                SummaryData summaryData = (SummaryData) other;
                if (this.isContainEmoji != summaryData.isContainEmoji || !Intrinsics.areEqual(this.highText, summaryData.highText) || !Intrinsics.areEqual(this.msgText, summaryData.msgText) || this.highColor != summaryData.highColor || this.status != summaryData.status || this.isTroop != summaryData.isTroop) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getHighColor() {
        return this.highColor;
    }

    @Nullable
    public final String getHighText() {
        return this.highText;
    }

    @Nullable
    public final String getMsgText() {
        return this.msgText;
    }

    public final int getStatus() {
        return this.status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        int i3;
        boolean z16 = this.isContainEmoji;
        int i16 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i17 = r06 * 31;
        String str = this.highText;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (i17 + i3) * 31;
        String str2 = this.msgText;
        if (str2 != null) {
            i18 = str2.hashCode();
        }
        int i26 = (((((i19 + i18) * 31) + this.highColor) * 31) + this.status) * 31;
        boolean z17 = this.isTroop;
        if (!z17) {
            i16 = z17 ? 1 : 0;
        }
        return i26 + i16;
    }

    public final boolean isContainEmoji() {
        return this.isContainEmoji;
    }

    public final boolean isTroop() {
        return this.isTroop;
    }

    @NotNull
    public String toString() {
        return "SummaryData(isContainEmoji=" + this.isContainEmoji + ", highText=" + this.highText + ", msgText=" + this.msgText + ", highColor=" + this.highColor + ", status=" + this.status + ", isTroop=" + this.isTroop + ")";
    }

    public SummaryData(boolean z16, @Nullable String str, @Nullable String str2, int i3, int i16, boolean z17) {
        this.isContainEmoji = z16;
        this.highText = str;
        this.msgText = str2;
        this.highColor = i3;
        this.status = i16;
        this.isTroop = z17;
    }

    public /* synthetic */ SummaryData(boolean z16, String str, String str2, int i3, int i16, boolean z17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? null : str, (i17 & 4) == 0 ? str2 : null, (i17 & 8) != 0 ? Color.parseColor("#f28c48") : i3, (i17 & 16) != 0 ? 0 : i16, (i17 & 32) != 0 ? false : z17);
    }
}
