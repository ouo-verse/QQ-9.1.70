package org.tencwebrtc;

import com.tencent.mobileqq.activity.recent.MsgSummary;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StatsReport {

    /* renamed from: id, reason: collision with root package name */
    public final String f423848id;
    public final double timestamp;
    public final String type;
    public final Value[] values;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Value {
        public final String name;
        public final String value;

        @CalledByNative("Value")
        public Value(String str, String str2) {
            this.name = str;
            this.value = str2;
        }

        public String toString() {
            return "[" + this.name + MsgSummary.STR_COLON + this.value + "]";
        }
    }

    @CalledByNative
    public StatsReport(String str, String str2, double d16, Value[] valueArr) {
        this.f423848id = str;
        this.type = str2;
        this.timestamp = d16;
        this.values = valueArr;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("id: ");
        sb5.append(this.f423848id);
        sb5.append(", type: ");
        sb5.append(this.type);
        sb5.append(", timestamp: ");
        sb5.append(this.timestamp);
        sb5.append(", values: ");
        int i3 = 0;
        while (true) {
            Value[] valueArr = this.values;
            if (i3 < valueArr.length) {
                sb5.append(valueArr[i3].toString());
                sb5.append(", ");
                i3++;
            } else {
                return sb5.toString();
            }
        }
    }
}
