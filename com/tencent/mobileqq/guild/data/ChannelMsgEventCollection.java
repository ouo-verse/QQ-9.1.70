package com.tencent.mobileqq.guild.data;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ChannelMsgEventCollection implements Serializable {
    public String channelId;
    public String guildId;
    public List<ChannelMsgEvent> msgEventList;

    @NonNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ChannelMsgEvent{");
        sb5.append("guildId = " + this.guildId);
        sb5.append(", channelId = " + this.channelId);
        sb5.append(", msgEventList = ");
        List<ChannelMsgEvent> list = this.msgEventList;
        if (list != null && list.size() > 0) {
            sb5.append("[ ");
            Iterator<ChannelMsgEvent> it = this.msgEventList.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString());
                sb5.append(", ");
            }
            sb5.append("]");
        } else {
            sb5.append("null");
        }
        sb5.append("}");
        return sb5.toString();
    }
}
