package com.tencent.state.view;

import android.view.View;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.avatar.IAvatarAnimView;
import com.tencent.state.square.avatar.ISquareAvatarView;
import com.tencent.state.square.data.MapResourceType;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.utils.AnimationUtils;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.view.BaseAvatarAnimator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 !2\u00020\u0001:\u0002 !B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0002J$\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00070\u001cJ6\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00162\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00070\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/view/BaseAvatarAnimator;", "", "avatarImage", "Lcom/tencent/state/square/avatar/ISquareAvatarView;", "(Lcom/tencent/state/square/avatar/ISquareAvatarView;)V", "enterScaleCallback", "Lkotlin/Function0;", "", "scaleDuration", "", "getScaleDuration", "()J", "setScaleDuration", "(J)V", "enterScaleAnim", "source", "Lcom/tencent/state/square/media/MapPlayableSource;", "isChangeResource", "", "callback", "invokeEnterScaleCallback", "from", "", "onAvatarViewShow", "startAlphaAnimation", "updateAvatar", "resource", "Lcom/tencent/state/square/data/Resource;", "Lkotlin/Function1;", "updateAvatarFilament", "uin", "needCleanAll", "AvatarViewListener", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public class BaseAvatarAnimator {
    private static final String TAG = "CommonAvatarAnimator";
    private final ISquareAvatarView avatarImage;
    private Function0<Unit> enterScaleCallback;
    private long scaleDuration;

    public BaseAvatarAnimator(ISquareAvatarView avatarImage) {
        Intrinsics.checkNotNullParameter(avatarImage, "avatarImage");
        this.avatarImage = avatarImage;
        this.scaleDuration = 500L;
    }

    public final void invokeEnterScaleCallback(String from) {
        if (this.enterScaleCallback != null) {
            SquareBaseKt.getSquareLog().i(TAG, "[SquareScaleDetail] enterScaleAnim callback from " + from);
            Function0<Unit> function0 = this.enterScaleCallback;
            if (function0 != null) {
                function0.invoke();
            }
            this.enterScaleCallback = null;
        }
    }

    private final void startAlphaAnimation() {
        this.avatarImage.setAlpha(0.0f);
        ISquareAvatarView iSquareAvatarView = this.avatarImage;
        if (!(iSquareAvatarView instanceof View)) {
            iSquareAvatarView = null;
        }
        View view = (View) iSquareAvatarView;
        if (view != null) {
            AnimationUtils.INSTANCE.startAlphaAnimation(view, true, 500L, null);
        }
    }

    public final void enterScaleAnim(final MapPlayableSource source, final boolean isChangeResource, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.avatarImage.setImageViewVisibility(false);
        SquareBaseKt.getSquareThread().postOnUiDelayed(this.scaleDuration, new Function0<Unit>() { // from class: com.tencent.state.view.BaseAvatarAnimator$enterScaleAnim$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ISquareAvatarView iSquareAvatarView;
                if (source == null) {
                    SquareBaseKt.getSquareLog().i("CommonAvatarAnimator", "[SquareScaleDetail] enterScaleAnim callback on source null");
                    callback.invoke();
                    return;
                }
                SquareBaseKt.getSquareLog().i("CommonAvatarAnimator", "[SquareScaleDetail] enterScaleAnim: isChangeResource=" + isChangeResource);
                BaseAvatarAnimator.this.enterScaleCallback = callback;
                iSquareAvatarView = BaseAvatarAnimator.this.avatarImage;
                iSquareAvatarView.setAnimSource(source, new BaseAvatarAnimator.AvatarViewListener() { // from class: com.tencent.state.view.BaseAvatarAnimator$enterScaleAnim$1.1
                    @Override // com.tencent.state.view.BaseAvatarAnimator.AvatarViewListener, com.tencent.state.square.avatar.IAvatarAnimListener
                    public void onFirstFrame() {
                        ISquareAvatarView iSquareAvatarView2;
                        ISquareAvatarView iSquareAvatarView3;
                        super.onFirstFrame();
                        iSquareAvatarView2 = BaseAvatarAnimator.this.avatarImage;
                        iSquareAvatarView2.setVideoViewVisibility(true);
                        BaseAvatarAnimator.this.onAvatarViewShow();
                        BaseAvatarAnimator$enterScaleAnim$1 baseAvatarAnimator$enterScaleAnim$1 = BaseAvatarAnimator$enterScaleAnim$1.this;
                        if (isChangeResource) {
                            return;
                        }
                        iSquareAvatarView3 = BaseAvatarAnimator.this.avatarImage;
                        iSquareAvatarView3.setAlpha(1.0f);
                        BaseAvatarAnimator.this.invokeEnterScaleCallback("enterScaleAnim firstFrame");
                    }

                    @Override // com.tencent.state.view.BaseAvatarAnimator.AvatarViewListener, com.tencent.state.square.avatar.IAvatarAnimListener
                    public void onPlayError(int errorCode) {
                        super.onPlayError(errorCode);
                        BaseAvatarAnimator.this.onAvatarViewShow();
                        BaseAvatarAnimator.this.invokeEnterScaleCallback("enterScaleAnim playError");
                    }
                }, false);
                if (SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
                    return;
                }
                SquareBaseKt.getSquareThread().postOnUiDelayed(2000L, new Function0<Unit>() { // from class: com.tencent.state.view.BaseAvatarAnimator$enterScaleAnim$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SquareBaseKt.getSquareLog().i("CommonAvatarAnimator", "[SquareScaleDetail] enterScaleAnim callback on timeout");
                        BaseAvatarAnimator.this.invokeEnterScaleCallback("enterScaleAnim timeout");
                    }
                });
            }
        });
        if (isChangeResource) {
            startAlphaAnimation();
        }
    }

    public final long getScaleDuration() {
        return this.scaleDuration;
    }

    public final void setScaleDuration(long j3) {
        this.scaleDuration = j3;
    }

    public final void updateAvatar(Resource resource, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (resource.canPlay()) {
            this.avatarImage.setImageViewVisibility(false);
            IAvatarAnimView.DefaultImpls.changeSourceWithAnim$default(this.avatarImage, SquareItemKt.toMapPlayableSource$default(resource, null, 1, null), new AvatarViewListener() { // from class: com.tencent.state.view.BaseAvatarAnimator$updateAvatar$1
                @Override // com.tencent.state.view.BaseAvatarAnimator.AvatarViewListener, com.tencent.state.square.avatar.IAvatarAnimListener
                public void onFirstFrame() {
                    super.onFirstFrame();
                    callback.invoke(Boolean.TRUE);
                    BaseAvatarAnimator.this.invokeEnterScaleCallback("updateAvatar firstFrame");
                }

                @Override // com.tencent.state.view.BaseAvatarAnimator.AvatarViewListener, com.tencent.state.square.avatar.IAvatarAnimListener
                public void onPlayError(int errorCode) {
                    ISquareAvatarView iSquareAvatarView;
                    super.onPlayError(errorCode);
                    iSquareAvatarView = BaseAvatarAnimator.this.avatarImage;
                    iSquareAvatarView.setVideoViewVisibility(true);
                    callback.invoke(Boolean.FALSE);
                    BaseAvatarAnimator.this.invokeEnterScaleCallback("updateAvatar playError");
                }

                @Override // com.tencent.state.view.BaseAvatarAnimator.AvatarViewListener, com.tencent.state.square.avatar.IAvatarAnimListener
                public void onRemovedListener() {
                    super.onRemovedListener();
                    callback.invoke(null);
                }
            }, false, 4, null);
            return;
        }
        SquareBaseKt.getSquareLog().w(TAG, "playDynamicAvatar but url is empty, actionId=" + resource.getActionId());
        callback.invoke(Boolean.TRUE);
    }

    public final void updateAvatarFilament(Resource resource, String uin, final Function1<? super Boolean, Unit> callback, boolean needCleanAll) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.avatarImage.setImageViewVisibility(false);
        this.avatarImage.changeSourceWithAnim(SquareItemKt.toMapPlayableSource$default(resource, MapResourceType.Filament, uin, null, 4, null), new AvatarViewListener() { // from class: com.tencent.state.view.BaseAvatarAnimator$updateAvatarFilament$1
            @Override // com.tencent.state.view.BaseAvatarAnimator.AvatarViewListener, com.tencent.state.square.avatar.IAvatarAnimListener
            public void onFirstFrame() {
                super.onFirstFrame();
                callback.invoke(Boolean.TRUE);
                BaseAvatarAnimator.this.invokeEnterScaleCallback("updateAvatar firstFrame");
            }

            @Override // com.tencent.state.view.BaseAvatarAnimator.AvatarViewListener, com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayError(int errorCode) {
                ISquareAvatarView iSquareAvatarView;
                super.onPlayError(errorCode);
                iSquareAvatarView = BaseAvatarAnimator.this.avatarImage;
                iSquareAvatarView.setVideoViewVisibility(true);
                callback.invoke(Boolean.FALSE);
                BaseAvatarAnimator.this.invokeEnterScaleCallback("updateAvatar playError");
            }

            @Override // com.tencent.state.view.BaseAvatarAnimator.AvatarViewListener, com.tencent.state.square.avatar.IAvatarAnimListener
            public void onRemovedListener() {
                super.onRemovedListener();
                callback.invoke(null);
            }

            @Override // com.tencent.state.view.BaseAvatarAnimator.AvatarViewListener, com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticSuccess() {
                callback.invoke(Boolean.TRUE);
            }
        }, needCleanAll);
    }

    public static /* synthetic */ void updateAvatarFilament$default(BaseAvatarAnimator baseAvatarAnimator, Resource resource, String str, Function1 function1, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 8) != 0) {
                z16 = false;
            }
            baseAvatarAnimator.updateAvatarFilament(resource, str, function1, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAvatarFilament");
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/view/BaseAvatarAnimator$AvatarViewListener;", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "()V", "onFirstFrame", "", HippyQQPagView.EventName.ON_PLAY_END, "onPlayError", "errorCode", "", HippyQQPagView.EventName.ON_PLAY_START, "onStaticFailed", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static class AvatarViewListener implements IAvatarAnimListener {
        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onFirstFrame() {
            SquareBaseKt.getSquareLog().i(BaseAvatarAnimator.TAG, "onFirstFrame");
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onPlayError(int errorCode) {
            SquareBaseKt.getSquareLog().i(BaseAvatarAnimator.TAG, "onPlayError: errorCode=" + errorCode);
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onRemovedListener() {
            IAvatarAnimListener.DefaultImpls.onRemovedListener(this);
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onStaticFailed() {
            SquareBaseKt.getSquareLog().i(BaseAvatarAnimator.TAG, "onStaticFailed");
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onStaticSuccess() {
            IAvatarAnimListener.DefaultImpls.onStaticSuccess(this);
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onPlayEnd() {
        }

        @Override // com.tencent.state.square.avatar.IAvatarAnimListener
        public void onPlayStart() {
        }
    }

    public void onAvatarViewShow() {
    }
}
