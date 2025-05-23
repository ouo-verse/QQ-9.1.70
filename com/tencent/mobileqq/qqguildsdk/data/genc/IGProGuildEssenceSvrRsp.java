package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGuildEssenceSvrRsp extends Serializable {
    int getCanModify();

    String getTips();

    IGProUnifiedEssenceInfo getUnifiedEssenceInfo();

    int getVisitorEdit();

    String toString();
}
