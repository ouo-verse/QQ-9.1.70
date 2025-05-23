package com.tencent.mobileqq.icgame.base.room.multipage.api;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000bH&J\b\u0010\r\u001a\u00020\tH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/multipage/api/c;", "", "", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/f;", "pageList", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/SwitchDirection;", "direction", "", "index", "", "u1", "Landroidx/lifecycle/LiveData;", "Z0", "B0", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface c {
    void B0();

    @NotNull
    LiveData<List<SwitchPageInfo>> Z0();

    void u1(@NotNull List<SwitchPageInfo> pageList, @NotNull SwitchDirection direction, int index);
}
