package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/TroopRequestType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "PROFILE_HOST", "PROFILE_GUEST", "TYPE_FEED", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public enum TroopRequestType {
    PROFILE_HOST(1),
    PROFILE_GUEST(2),
    TYPE_FEED(3);

    private final int type;

    TroopRequestType(int i3) {
        this.type = i3;
    }

    public final int getType() {
        return this.type;
    }
}
