package com.tencent.state.publicchat.data;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zr4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u0013\b\u0016\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/publicchat/data/LabelInfo;", "", "", "component1", "component2", "key", "value", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", HippyTextInputController.COMMAND_getValue, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Lzr4/b;", "pb", "(Lzr4/b;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class LabelInfo {
    private final String key;
    private final String value;

    public LabelInfo(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.key = key;
        this.value = value;
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final LabelInfo copy(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return new LabelInfo(key, value);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.key;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "LabelInfo(key=" + this.key + ", value=" + this.value + ")";
    }

    public LabelInfo(b bVar) {
        this("", "");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LabelInfo)) {
            return false;
        }
        LabelInfo labelInfo = (LabelInfo) other;
        return Intrinsics.areEqual(this.key, labelInfo.key) && Intrinsics.areEqual(this.value, labelInfo.value);
    }

    public static /* synthetic */ LabelInfo copy$default(LabelInfo labelInfo, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = labelInfo.key;
        }
        if ((i3 & 2) != 0) {
            str2 = labelInfo.value;
        }
        return labelInfo.copy(str, str2);
    }
}
