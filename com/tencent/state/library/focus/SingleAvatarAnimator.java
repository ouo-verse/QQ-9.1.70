package com.tencent.state.library.focus;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.map.AvatarLocationConfig;
import com.tencent.state.map.Location;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.view.BaseAvatarAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/library/focus/SingleAvatarAnimator;", "Lcom/tencent/state/view/BaseAvatarAnimator;", "avatarImage", "Lcom/tencent/state/square/avatar/SquareAvatarView;", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/AvatarLocationConfig;", "(Lcom/tencent/state/square/avatar/SquareAvatarView;Lcom/tencent/state/map/AvatarLocationConfig;)V", "getConfig", "()Lcom/tencent/state/map/AvatarLocationConfig;", "getAvatarLocation", "Lcom/tencent/state/map/Location;", "screenWidth", "", "screenHeight", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class SingleAvatarAnimator extends BaseAvatarAnimator {
    private final AvatarLocationConfig config;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleAvatarAnimator(SquareAvatarView avatarImage, AvatarLocationConfig config) {
        super(avatarImage);
        Intrinsics.checkNotNullParameter(avatarImage, "avatarImage");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public final Location getAvatarLocation(int screenWidth, int screenHeight) {
        return new Location((screenWidth - this.config.getAvatarWidth()) / 2, (screenHeight - this.config.getAvatarHeight()) - this.config.getSingleBottomMargin(), this.config.getAvatarWidth(), this.config.getAvatarHeight(), 0, 0, 48, null);
    }

    public final AvatarLocationConfig getConfig() {
        return this.config;
    }
}
