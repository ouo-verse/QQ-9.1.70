package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProFeedStat extends Serializable {
    long getPageView();

    long getPreferCount();

    int getPreferStatus();

    long getShareCount();

    long getTotalCommentCount();

    String toString();
}
