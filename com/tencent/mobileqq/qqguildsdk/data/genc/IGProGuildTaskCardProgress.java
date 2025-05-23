package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGuildTaskCardProgress extends Serializable {
    int getCurState();

    long getCurStatus();

    long getRequireStatus();

    String toString();
}
