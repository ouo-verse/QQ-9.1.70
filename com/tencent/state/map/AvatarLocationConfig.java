package com.tencent.state.map;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/map/AvatarLocationConfig;", "", "avatarWidth", "", "avatarHeight", "singleBottomMargin", "groupBottomMargin", "(IIII)V", "getAvatarHeight", "()I", "getAvatarWidth", "getGroupBottomMargin", "getSingleBottomMargin", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class AvatarLocationConfig {
    private final int avatarHeight;
    private final int avatarWidth;
    private final int groupBottomMargin;
    private final int singleBottomMargin;

    public AvatarLocationConfig(int i3, int i16, int i17, int i18) {
        this.avatarWidth = i3;
        this.avatarHeight = i16;
        this.singleBottomMargin = i17;
        this.groupBottomMargin = i18;
    }

    public final int getAvatarHeight() {
        return this.avatarHeight;
    }

    public final int getAvatarWidth() {
        return this.avatarWidth;
    }

    public final int getGroupBottomMargin() {
        return this.groupBottomMargin;
    }

    public final int getSingleBottomMargin() {
        return this.singleBottomMargin;
    }

    public /* synthetic */ AvatarLocationConfig(int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) != 0 ? 0 : i18);
    }
}
