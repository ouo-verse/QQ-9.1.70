package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProSendGiftEventData extends Serializable {
    long getChannelId();

    String getEventId();

    IGProGiftInfo getGiftInfo();

    long getGuildId();

    IGProUser getReceiverMember();

    IGProUser getSenderMember();
}
