package com.tencent.mtt.hippy.views.common;

import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyNestedScrollComponent {
    public static final int DIRECTION_ALL = 0;
    public static final int DIRECTION_BOTTOM = 4;
    public static final int DIRECTION_INVALID = -1;
    public static final int DIRECTION_LEFT = 1;
    public static final int DIRECTION_RIGHT = 3;
    public static final int DIRECTION_TOP = 2;
    public static final String PRIORITY_NONE = "none";
    public static final String PRIORITY_PARENT = "parent";
    public static final String PRIORITY_SELF = "self";
    public static final String PROP_BOTTOM_PRIORITY = "nestedScrollBottomPriority";
    public static final String PROP_LEFT_PRIORITY = "nestedScrollLeftPriority";
    public static final String PROP_PRIORITY = "nestedScrollPriority";
    public static final String PROP_RIGHT_PRIORITY = "nestedScrollRightPriority";
    public static final String PROP_TOP_PRIORITY = "nestedScrollTopPriority";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface HippyNestedScrollTarget extends NestedScrollingChild, NestedScrollingParent, HippyNestedScrollComponent {
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface HippyNestedScrollTarget2 extends NestedScrollingChild2, NestedScrollingParent2, HippyNestedScrollTarget {
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum Priority {
        NOT_SET,
        PARENT,
        SELF,
        NONE
    }

    Priority getNestedScrollPriority(int i3);

    void setNestedScrollPriority(int i3, Priority priority);
}
