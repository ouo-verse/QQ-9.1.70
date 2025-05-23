package com.tencent.mobileqq.guild.main.data;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public class SchedulerMsgData extends SimpleBaseEvent implements Cloneable {
    public String channelId;
    public String creatorUrl;
    public long expireTimeMs;
    public long msgSeq;
    public String wording;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchedulerMsgData)) {
            return false;
        }
        SchedulerMsgData schedulerMsgData = (SchedulerMsgData) obj;
        if (this.expireTimeMs == schedulerMsgData.expireTimeMs && this.msgSeq == schedulerMsgData.msgSeq && Objects.equals(this.creatorUrl, schedulerMsgData.creatorUrl) && Objects.equals(this.wording, schedulerMsgData.wording) && Objects.equals(this.channelId, schedulerMsgData.channelId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.creatorUrl, this.wording, Long.valueOf(this.expireTimeMs), Long.valueOf(this.msgSeq), this.channelId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SchedulerMsgData m189clone() throws CloneNotSupportedException {
        SchedulerMsgData schedulerMsgData = (SchedulerMsgData) super.clone();
        schedulerMsgData.channelId = this.channelId;
        schedulerMsgData.creatorUrl = this.creatorUrl;
        schedulerMsgData.wording = this.wording;
        schedulerMsgData.expireTimeMs = this.expireTimeMs;
        schedulerMsgData.msgSeq = this.msgSeq;
        return schedulerMsgData;
    }
}
