package org.tencwebrtc;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RTCStats {

    /* renamed from: id, reason: collision with root package name */
    private final String f423846id;
    private final Map<String, Object> members;
    private final long timestampUs;
    private final String type;

    public RTCStats(long j3, String str, String str2, Map<String, Object> map) {
        this.timestampUs = j3;
        this.type = str;
        this.f423846id = str2;
        this.members = map;
    }

    private static void appendValue(StringBuilder sb5, Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            sb5.append('[');
            for (int i3 = 0; i3 < objArr.length; i3++) {
                if (i3 != 0) {
                    sb5.append(", ");
                }
                appendValue(sb5, objArr[i3]);
            }
            sb5.append(']');
            return;
        }
        if (obj instanceof String) {
            sb5.append('\"');
            sb5.append(obj);
            sb5.append('\"');
            return;
        }
        sb5.append(obj);
    }

    @CalledByNative
    static RTCStats create(long j3, String str, String str2, Map map) {
        return new RTCStats(j3, str, str2, map);
    }

    public String getId() {
        return this.f423846id;
    }

    public Map<String, Object> getMembers() {
        return this.members;
    }

    public double getTimestampUs() {
        return this.timestampUs;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{ timestampUs: ");
        sb5.append(this.timestampUs);
        sb5.append(", type: ");
        sb5.append(this.type);
        sb5.append(", id: ");
        sb5.append(this.f423846id);
        for (Map.Entry<String, Object> entry : this.members.entrySet()) {
            sb5.append(", ");
            sb5.append(entry.getKey());
            sb5.append(MsgSummary.STR_COLON);
            appendValue(sb5, entry.getValue());
        }
        sb5.append(" }");
        return sb5.toString();
    }
}
