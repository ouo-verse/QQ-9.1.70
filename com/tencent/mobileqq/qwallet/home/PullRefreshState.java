package com.tencent.mobileqq.qwallet.home;

import com.tencent.mobileqq.highway.transaction.Tracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/PullRefreshState;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "isTouchState", "", "READY", "PULLING_NO_REFRESH", "PULLING_CAN_REFRESH", "REFRESHING", "SUCCESS", Tracker.FAIL, "CANCEL", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public enum PullRefreshState {
    READY(""),
    PULLING_NO_REFRESH("\u4e0b\u62c9\u5237\u65b0"),
    PULLING_CAN_REFRESH("\u653e\u5f00\u5237\u65b0"),
    REFRESHING("\u6b63\u5728\u5237\u65b0"),
    SUCCESS("\u5237\u65b0\u6210\u529f"),
    FAIL("\u5237\u65b0\u5931\u8d25"),
    CANCEL("\u53d6\u6d88\u5237\u65b0");


    @NotNull
    private final String text;

    PullRefreshState(String str) {
        this.text = str;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final boolean isTouchState() {
        if (this != READY && this != PULLING_NO_REFRESH && this != PULLING_CAN_REFRESH) {
            return false;
        }
        return true;
    }
}
