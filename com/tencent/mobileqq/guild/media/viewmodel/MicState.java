package com.tencent.mobileqq.guild.media.viewmodel;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/viewmodel/MicState;", "", "", "state", "I", "getState", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "MIC_STATE_UNKNOWN", "MIC_STATE_ON", "MIC_STATE_OFF", "MIC_STATE_DISABLE", "MIC_STATE_IN_ACTIVE", "MIC_STATE_GONE", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public enum MicState {
    MIC_STATE_UNKNOWN(-1),
    MIC_STATE_ON(0),
    MIC_STATE_OFF(1),
    MIC_STATE_DISABLE(2),
    MIC_STATE_IN_ACTIVE(3),
    MIC_STATE_GONE(4);

    private final int state;

    MicState(int i3) {
        this.state = i3;
    }

    public final int getState() {
        return this.state;
    }
}
