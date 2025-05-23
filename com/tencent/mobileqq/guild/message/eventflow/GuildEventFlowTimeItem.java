package com.tencent.mobileqq.guild.message.eventflow;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildEventFlowTimeItem implements Serializable {
    private static final long serialVersionUID = 1;
    public byte[] cookie;
    public long eventBeginTime;
    public long eventEndTime;
    public long registProxyTime;

    public GuildEventFlowTimeItem() {
        this.registProxyTime = 0L;
        this.eventBeginTime = 0L;
        this.eventEndTime = 0L;
        this.cookie = null;
    }

    public String toString() {
        return "registProxyTime:" + this.registProxyTime + " eventBeginTime:" + this.eventBeginTime + " eventEndTime:" + this.eventEndTime + " ";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GuildEventFlowTimeItem m191clone() {
        try {
            GuildEventFlowTimeItem guildEventFlowTimeItem = (GuildEventFlowTimeItem) super.clone();
            byte[] bArr = this.cookie;
            guildEventFlowTimeItem.cookie = bArr == null ? null : (byte[]) bArr.clone();
            return guildEventFlowTimeItem;
        } catch (CloneNotSupportedException unused) {
            return this;
        }
    }

    public GuildEventFlowTimeItem(long j3, long j16, long j17, byte[] bArr) {
        this.cookie = null;
        this.registProxyTime = j3;
        this.eventBeginTime = j16;
        this.eventEndTime = j17;
        this.cookie = bArr != null ? (byte[]) bArr.clone() : null;
    }
}
