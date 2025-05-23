package com.tencent.mobileqq.guild.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "channelId,eventType,msgSeq,eventRandom")
/* loaded from: classes13.dex */
public class ChannelMsgEvent extends Entity implements Serializable {
    public static final int SUBTYPE_GIFT = 1;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_PERSONAL_RED_PACKET = 3;
    public static final int SUBTYPE_RED_PACKET = 2;
    public String channelId;
    public String tinyId;
    public long eventType = 0;
    public long msgSeq = 0;
    public long eventRandom = 0;
    public int subType = 0;

    public boolean equals(@Nullable Object obj) {
        boolean z16;
        if (!(obj instanceof ChannelMsgEvent)) {
            return false;
        }
        ChannelMsgEvent channelMsgEvent = (ChannelMsgEvent) obj;
        if (channelMsgEvent.eventRandom == this.eventRandom) {
            z16 = true;
        } else {
            z16 = false;
        }
        long j3 = channelMsgEvent.eventType;
        if (j3 == 1 || j3 == 3 || j3 == 100) {
            z16 = true;
        }
        String str = channelMsgEvent.channelId;
        if (str == null || !str.equals(this.channelId) || channelMsgEvent.eventType != this.eventType || channelMsgEvent.msgSeq != this.msgSeq || !z16) {
            return false;
        }
        return true;
    }

    @NonNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("MsgEvent{");
        sb5.append("channelId = " + this.channelId);
        sb5.append(", eventType = " + this.eventType);
        sb5.append(", msgSeq = " + this.msgSeq);
        sb5.append(", tinyId = " + this.tinyId);
        sb5.append(", eventRandom = " + this.eventRandom);
        sb5.append(", subType = " + this.subType);
        sb5.append("}");
        return sb5.toString();
    }
}
