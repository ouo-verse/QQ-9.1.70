package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProRecommendVoiceChannel extends Serializable {
    IGProRecommendCoverInfo getCover();

    IAudioChannelMemberInfos getVoiceChannel();

    String toString();
}
