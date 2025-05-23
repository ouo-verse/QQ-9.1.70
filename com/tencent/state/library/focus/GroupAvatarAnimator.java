package com.tencent.state.library.focus;

import android.util.Size;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.map.AvatarLocationConfig;
import com.tencent.state.map.Location;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.view.BaseAvatarAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/library/focus/GroupAvatarAnimator;", "", "leftImage", "Lcom/tencent/state/square/avatar/SquareAvatarView;", "rightImage", "parentSize", "Landroid/util/Size;", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/AvatarLocationConfig;", "betweenMargin", "(Lcom/tencent/state/square/avatar/SquareAvatarView;Lcom/tencent/state/square/avatar/SquareAvatarView;Landroid/util/Size;Lcom/tencent/state/map/AvatarLocationConfig;Landroid/util/Size;)V", "leftAnimator", "Lcom/tencent/state/view/BaseAvatarAnimator;", "getLeftAnimator", "()Lcom/tencent/state/view/BaseAvatarAnimator;", "rightAnimator", "getRightAnimator", "getAvatarLocation", "Lcom/tencent/state/map/Location;", "isLeft", "", "getLeftAvatarLocation", "getRightAvatarLocation", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class GroupAvatarAnimator {
    private final Size betweenMargin;
    private final AvatarLocationConfig config;
    private final BaseAvatarAnimator leftAnimator;
    private final Size parentSize;
    private final BaseAvatarAnimator rightAnimator;

    public GroupAvatarAnimator(SquareAvatarView leftImage, SquareAvatarView rightImage, Size parentSize, AvatarLocationConfig config, Size betweenMargin) {
        Intrinsics.checkNotNullParameter(leftImage, "leftImage");
        Intrinsics.checkNotNullParameter(rightImage, "rightImage");
        Intrinsics.checkNotNullParameter(parentSize, "parentSize");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(betweenMargin, "betweenMargin");
        this.parentSize = parentSize;
        this.config = config;
        this.betweenMargin = betweenMargin;
        this.leftAnimator = new BaseAvatarAnimator(leftImage);
        this.rightAnimator = new BaseAvatarAnimator(rightImage);
    }

    public final BaseAvatarAnimator getLeftAnimator() {
        return this.leftAnimator;
    }

    public final BaseAvatarAnimator getRightAnimator() {
        return this.rightAnimator;
    }

    public final Location getLeftAvatarLocation() {
        return getAvatarLocation(true);
    }

    public final Location getRightAvatarLocation() {
        return getAvatarLocation(false);
    }

    private final Location getAvatarLocation(boolean isLeft) {
        int height;
        int groupBottomMargin;
        if (isLeft) {
            height = (this.parentSize.getHeight() - this.config.getAvatarHeight()) - this.config.getGroupBottomMargin();
            groupBottomMargin = this.betweenMargin.getHeight();
        } else {
            height = this.parentSize.getHeight() - this.config.getAvatarHeight();
            groupBottomMargin = this.config.getGroupBottomMargin();
        }
        int i3 = height - groupBottomMargin;
        int width = (this.parentSize.getWidth() - (this.config.getAvatarWidth() + this.betweenMargin.getWidth())) / 2;
        if (!isLeft) {
            width += this.betweenMargin.getWidth();
        }
        return new Location(width, i3, this.config.getAvatarWidth(), this.config.getAvatarHeight(), 0, 0, 48, null);
    }
}
