package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface BubbleGroup {
    public static final int INVALID_BUBBLE_ID = -1;

    int addBubble(BubbleOptions bubbleOptions);

    void clearBubbleGroup();

    boolean containsBubble(int i3);

    List<Integer> getBubbleIds();

    boolean remove(int i3);

    boolean updateBubble(int i3, BubbleOptions bubbleOptions);
}
