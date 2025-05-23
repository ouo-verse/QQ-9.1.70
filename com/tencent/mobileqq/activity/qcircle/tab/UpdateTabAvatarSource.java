package com.tencent.mobileqq.activity.qcircle.tab;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/tab/UpdateTabAvatarSource;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "UPDATE_RED_POINT", "TAB_SELECTED", "CHANGE_ACCOUNT", "UPDATE_NUM_RED_AVATAR", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public enum UpdateTabAvatarSource {
    UPDATE_RED_POINT(0),
    TAB_SELECTED(1),
    CHANGE_ACCOUNT(2),
    UPDATE_NUM_RED_AVATAR(3);

    private final int type;

    UpdateTabAvatarSource(int i3) {
        this.type = i3;
    }

    public final int getType() {
        return this.type;
    }
}
