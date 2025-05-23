package com.tencent.gdtad.basics.flipCard;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface FlipCardInteractiveListener {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public @interface FailReason {
        public static final int CLICK_DO_NOT_IN_CARD = 5;
        public static final int NONE = 0;
        public static final int NOT_INTERACTIVE = 1;
        public static final int SLIDE_DO_NOT_IN_HOTAREA = 3;
        public static final int SLIDE_DO_NOT_REACH_THRESHOLD = 2;
        public static final int SLOPE_DO_NOT_REACH_THRESHOLD = 4;
    }
}
