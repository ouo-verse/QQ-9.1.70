package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProChannelPresenceInfo extends Serializable {
    ArrayList<IGProChannelPresenceItemInfo> getItemList();

    long getPlaySpeed();

    int getTemplateId();

    String toString();
}
