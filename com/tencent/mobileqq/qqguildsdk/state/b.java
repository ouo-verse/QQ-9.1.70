package com.tencent.mobileqq.qqguildsdk.state;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelState;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelStateInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b extends a implements IAudioChannelState {

    /* renamed from: e, reason: collision with root package name */
    int f268474e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<IGProChannelStateInfo> f268475f;

    public b(String str, String str2) {
        super(str, str2, 2);
    }

    public ArrayList<IGProChannelStateInfo> c() {
        return this.f268475f;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelState
    public int getChannelState() {
        return this.f268474e;
    }

    @NonNull
    public String toString() {
        return "AudioChannelState: guild=" + getGuildId() + " channel=" + getChannelId() + " channelType=" + getChannelType() + " channelState=" + getChannelState() + " channelStateList=" + c() + " channelStateSeq=" + a();
    }
}
