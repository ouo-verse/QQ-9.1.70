package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGuildTaskCard extends Serializable {
    long getTaskId();

    IGProGuildTaskCardInfo getTaskInfo();

    IGProGuildTaskCardProgress getTaskProgress();

    String toString();
}
