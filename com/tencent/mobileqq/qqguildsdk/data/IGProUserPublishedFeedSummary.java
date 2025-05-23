package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProUserPublishedFeedSummary extends Serializable {
    ArrayList<byte[]> getFeedList();

    String getPublishedCountStr();

    String toString();
}
