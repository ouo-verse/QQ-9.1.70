package com.tencent.mobileqq.icgame.base.room.multipage.api;

import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u000f\u001a\u00020\u0004H&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\nH&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/multipage/api/a;", "", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/f;", "switchInfo", "", "da", "getPageInfo", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/e;", "stateListener", "v1", "", MiniChatConstants.MINI_APP_LANDSCAPE, "onOrientationChange", "onBackPressed", "eb", "a0", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/d;", "viewPager", "Hd", "n0", "isForceUpdate", "Ud", "B4", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface a {
    boolean B4();

    void Hd(@NotNull d viewPager);

    void Ud(boolean isForceUpdate);

    void a0();

    void da(@NotNull SwitchPageInfo switchInfo);

    void eb();

    @NotNull
    SwitchPageInfo getPageInfo();

    @Nullable
    d n0();

    boolean onBackPressed();

    void onOrientationChange(boolean isLandscape);

    void v1(@NotNull e stateListener);
}
