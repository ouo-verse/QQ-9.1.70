package com.tencent.state.square.avatar;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "", "onFirstFrame", "", HippyQQPagView.EventName.ON_PLAY_END, "onPlayError", "errorCode", "", HippyQQPagView.EventName.ON_PLAY_START, "onRemovedListener", "onStaticFailed", "onStaticSuccess", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IAvatarAnimListener {
    void onFirstFrame();

    void onPlayEnd();

    void onPlayError(int errorCode);

    void onPlayStart();

    void onRemovedListener();

    void onStaticFailed();

    void onStaticSuccess();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static void onFirstFrame(IAvatarAnimListener iAvatarAnimListener) {
        }

        public static void onPlayEnd(IAvatarAnimListener iAvatarAnimListener) {
        }

        public static void onPlayStart(IAvatarAnimListener iAvatarAnimListener) {
        }

        public static void onRemovedListener(IAvatarAnimListener iAvatarAnimListener) {
        }

        public static void onStaticFailed(IAvatarAnimListener iAvatarAnimListener) {
        }

        public static void onStaticSuccess(IAvatarAnimListener iAvatarAnimListener) {
        }

        public static void onPlayError(IAvatarAnimListener iAvatarAnimListener, int i3) {
        }
    }
}
