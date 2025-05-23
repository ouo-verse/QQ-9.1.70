package com.tencent.sqshow.zootopia.avatar;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "", "engineId", "", "(Ljava/lang/String;II)V", "getEngineId", "()I", "UE", "FILAMENT", "UE_SMALL_HOME", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public enum AvatarEngineType {
    UE(0),
    FILAMENT(1),
    UE_SMALL_HOME(0);

    private final int engineId;

    AvatarEngineType(int i3) {
        this.engineId = i3;
    }

    public final int getEngineId() {
        return this.engineId;
    }
}
