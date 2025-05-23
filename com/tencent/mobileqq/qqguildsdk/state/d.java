package com.tencent.mobileqq.qqguildsdk.state;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.fd;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d extends a implements fd {

    /* renamed from: e, reason: collision with root package name */
    int f268477e;

    public d(String str, String str2) {
        super(str, str2, 5);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.fd
    public int getChannelState() {
        return this.f268477e;
    }

    @NonNull
    public String toString() {
        return "LiveChannelState: guild=" + getGuildId() + " channel=" + getChannelId() + " channelType=" + getChannelType() + " channelState=" + getChannelState() + " channelStateSeq=" + a();
    }
}
