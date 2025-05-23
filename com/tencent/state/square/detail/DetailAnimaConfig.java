package com.tencent.state.square.detail;

import android.util.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/detail/DetailAnimaConfig;", "", "editorAvatarSize", "Landroid/util/Size;", "editorBottomDistance", "", "avatarWidth", "avatarHeight", "(Landroid/util/Size;III)V", "getAvatarHeight", "()I", "getAvatarWidth", "getEditorAvatarSize", "()Landroid/util/Size;", "getEditorBottomDistance", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailAnimaConfig {
    private final int avatarHeight;
    private final int avatarWidth;
    private final Size editorAvatarSize;
    private final int editorBottomDistance;

    public DetailAnimaConfig(Size editorAvatarSize, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(editorAvatarSize, "editorAvatarSize");
        this.editorAvatarSize = editorAvatarSize;
        this.editorBottomDistance = i3;
        this.avatarWidth = i16;
        this.avatarHeight = i17;
    }

    public final int getAvatarHeight() {
        return this.avatarHeight;
    }

    public final int getAvatarWidth() {
        return this.avatarWidth;
    }

    public final Size getEditorAvatarSize() {
        return this.editorAvatarSize;
    }

    public final int getEditorBottomDistance() {
        return this.editorBottomDistance;
    }
}
