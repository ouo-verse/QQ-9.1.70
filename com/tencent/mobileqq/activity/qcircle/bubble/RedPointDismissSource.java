package com.tencent.mobileqq.activity.qcircle.bubble;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/bubble/RedPointDismissSource;", "", "sourceType", "", "(Ljava/lang/String;II)V", "getSourceType", "()I", "TIME_OUT", "CHANGE_TAB", "CHANGE_ACCOUNT", "TAB_DISMISS", "TAB_ANIMATION", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public enum RedPointDismissSource {
    TIME_OUT(0),
    CHANGE_TAB(1),
    CHANGE_ACCOUNT(2),
    TAB_DISMISS(3),
    TAB_ANIMATION(4);

    private final int sourceType;

    RedPointDismissSource(int i3) {
        this.sourceType = i3;
    }

    public final int getSourceType() {
        return this.sourceType;
    }
}
