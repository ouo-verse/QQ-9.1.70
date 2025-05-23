package com.tencent.mobileqq.qqguildsdk.state;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelState;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelStateInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g extends a implements IAudioChannelState {

    /* renamed from: e, reason: collision with root package name */
    int f268490e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<IGProChannelStateInfo> f268491f;

    public g(String str, String str2) {
        super(str, str2, 8);
    }

    public ArrayList<IGProChannelStateInfo> c() {
        return this.f268491f;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelState
    public int getChannelState() {
        return this.f268490e;
    }

    @NonNull
    public String toString() {
        return "WorldChannelState: guild=" + getGuildId() + " channel=" + getChannelId() + " channelType=" + getChannelType() + " channelState=" + getChannelState() + " channelStateList=" + c() + " channelStateSeq=" + a();
    }
}
