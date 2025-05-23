package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProAISearchSessionMsg extends Serializable {
    IGProAISearchMsgContent getContent();

    String getCoupleId();

    long getCreateTime();

    boolean getIsFold();

    int getModelType();

    String getMsgId();

    String getMsgShareSummary();

    int getMsgStatus();

    int getType();

    long getUin();

    String toString();
}
