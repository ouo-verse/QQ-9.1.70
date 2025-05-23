package com.tencent.state.square.data;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\b\u0010\u001a\u001a\u00020\u0007H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/square/data/SquareIntimateData;", "", "type", "", "value", "", "prefixText", "", "suffixText", "(IJLjava/lang/String;Ljava/lang/String;)V", "getPrefixText", "()Ljava/lang/String;", "getSuffixText", "getType", "()I", HippyTextInputController.COMMAND_getValue, "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareIntimateData {
    private final String prefixText;
    private final String suffixText;
    private final int type;
    private final long value;

    public SquareIntimateData(int i3, long j3, String prefixText, String suffixText) {
        Intrinsics.checkNotNullParameter(prefixText, "prefixText");
        Intrinsics.checkNotNullParameter(suffixText, "suffixText");
        this.type = i3;
        this.value = j3;
        this.prefixText = prefixText;
        this.suffixText = suffixText;
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final long getValue() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPrefixText() {
        return this.prefixText;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSuffixText() {
        return this.suffixText;
    }

    public final SquareIntimateData copy(int type, long value, String prefixText, String suffixText) {
        Intrinsics.checkNotNullParameter(prefixText, "prefixText");
        Intrinsics.checkNotNullParameter(suffixText, "suffixText");
        return new SquareIntimateData(type, value, prefixText, suffixText);
    }

    public final String getPrefixText() {
        return this.prefixText;
    }

    public final String getSuffixText() {
        return this.suffixText;
    }

    public final int getType() {
        return this.type;
    }

    public final long getValue() {
        return this.value;
    }

    public int hashCode() {
        int a16 = ((this.type * 31) + c.a(this.value)) * 31;
        String str = this.prefixText;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.suffixText;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "type=" + this.type + "-value=" + this.value + "-prefixText=" + this.prefixText + "-suffixText=" + this.suffixText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareIntimateData)) {
            return false;
        }
        SquareIntimateData squareIntimateData = (SquareIntimateData) other;
        return this.type == squareIntimateData.type && this.value == squareIntimateData.value && Intrinsics.areEqual(this.prefixText, squareIntimateData.prefixText) && Intrinsics.areEqual(this.suffixText, squareIntimateData.suffixText);
    }

    public static /* synthetic */ SquareIntimateData copy$default(SquareIntimateData squareIntimateData, int i3, long j3, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = squareIntimateData.type;
        }
        if ((i16 & 2) != 0) {
            j3 = squareIntimateData.value;
        }
        long j16 = j3;
        if ((i16 & 4) != 0) {
            str = squareIntimateData.prefixText;
        }
        String str3 = str;
        if ((i16 & 8) != 0) {
            str2 = squareIntimateData.suffixText;
        }
        return squareIntimateData.copy(i3, j16, str3, str2);
    }
}
