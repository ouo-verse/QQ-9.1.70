package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGuildTaskCardInfo extends Serializable {
    String getBackgroundImg();

    IGProGuildTaskCardText getButton();

    String getIconImg();

    IGProGuildTaskCardLineText getMainTitle();

    IGProGuildTaskCardLineText getProgressComment();

    IGProGuildTaskCardLineText getSubTitle();

    int getTaskType();

    String toString();
}
