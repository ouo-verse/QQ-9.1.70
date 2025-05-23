package com.tencent.state.square.avatar;

import com.tencent.state.square.avatar.IAvatarAnimListener;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/state/square/avatar/EmptyAnimListener;", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class EmptyAnimListener implements IAvatarAnimListener {
    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onFirstFrame() {
        IAvatarAnimListener.DefaultImpls.onFirstFrame(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayEnd() {
        IAvatarAnimListener.DefaultImpls.onPlayEnd(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayError(int i3) {
        IAvatarAnimListener.DefaultImpls.onPlayError(this, i3);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayStart() {
        IAvatarAnimListener.DefaultImpls.onPlayStart(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onRemovedListener() {
        IAvatarAnimListener.DefaultImpls.onRemovedListener(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onStaticFailed() {
        IAvatarAnimListener.DefaultImpls.onStaticFailed(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onStaticSuccess() {
        IAvatarAnimListener.DefaultImpls.onStaticSuccess(this);
    }
}
