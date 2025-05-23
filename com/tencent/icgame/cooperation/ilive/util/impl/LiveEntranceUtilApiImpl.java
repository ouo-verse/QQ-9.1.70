package com.tencent.icgame.cooperation.ilive.util.impl;

import com.tencent.icgame.cooperation.ilive.util.ILiveEntranceUtilApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wt0.a;
import zt0.b;
import zt0.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\f\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/icgame/cooperation/ilive/util/impl/LiveEntranceUtilApiImpl;", "Lcom/tencent/icgame/cooperation/ilive/util/ILiveEntranceUtilApi;", "", "checkIsAnchorRoomNow", "Lxt0/a;", "params", "", "liveWatchEntranceJump", "", "offset", "isClickEnable", "Ljava/lang/Class;", "getICGameJumpParserClass", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class LiveEntranceUtilApiImpl implements ILiveEntranceUtilApi {
    @Override // com.tencent.icgame.cooperation.ilive.util.ILiveEntranceUtilApi
    public boolean checkIsAnchorRoomNow() {
        return a.b();
    }

    @Override // com.tencent.icgame.cooperation.ilive.util.ILiveEntranceUtilApi
    @NotNull
    public Class<?> getICGameJumpParserClass() {
        return f.class;
    }

    @Override // com.tencent.icgame.cooperation.ilive.util.ILiveEntranceUtilApi
    public boolean isClickEnable(int offset) {
        return b.c(offset);
    }

    @Override // com.tencent.icgame.cooperation.ilive.util.ILiveEntranceUtilApi
    public void liveWatchEntranceJump(@Nullable xt0.a params) {
        b.e(params);
    }
}
