package com.tencent.ams.fusion.widget.animatorplayer;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer;
import com.tencent.ams.fusion.widget.animatorplayer.node.NodeAnimationPlayer;
import com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsAnimationPlayer;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class AnimationPlayerView extends FrameLayout implements AnimationPlayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AnimationPlayerView";
    private AnimationPlayer.AnimationClickListener mAnimationClickListener;
    private AnimationPlayer.AnimationPlayListener mAnimationPlayListener;
    private AnimationPlayer mPlayer;

    public AnimationPlayerView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void createPlayer(int i3) {
        if (this.mPlayer != null) {
            return;
        }
        if (i3 == 1) {
            this.mPlayer = new NodeAnimationPlayer(this);
            return;
        }
        if (i3 == 2) {
            this.mPlayer = new PhysicsAnimationPlayer(this);
            return;
        }
        Logger.w(TAG, "unknown animation type:" + i3);
    }

    @Override // android.view.View, com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void clearAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        AnimationPlayer animationPlayer = this.mPlayer;
        if (animationPlayer != null) {
            animationPlayer.clearAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AnimationPlayer animationPlayer = this.mPlayer;
        if (animationPlayer != null) {
            animationPlayer.pause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AnimationPlayer animationPlayer = this.mPlayer;
        if (animationPlayer != null) {
            animationPlayer.resume();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void setAnimationClickListener(AnimationPlayer.AnimationClickListener animationClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animationClickListener);
            return;
        }
        this.mAnimationClickListener = animationClickListener;
        AnimationPlayer animationPlayer = this.mPlayer;
        if (animationPlayer != null) {
            animationPlayer.setAnimationClickListener(animationClickListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void setAnimationPlayInfo(AnimationPlayInfo animationPlayInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animationPlayInfo);
            return;
        }
        if (animationPlayInfo == null) {
            Logger.w(TAG, "can't set null animation play info");
            return;
        }
        createPlayer(animationPlayInfo.getAnimationType());
        AnimationPlayer animationPlayer = this.mPlayer;
        if (animationPlayer != null) {
            animationPlayer.setAnimationPlayInfo(animationPlayInfo);
            this.mPlayer.setAnimationClickListener(this.mAnimationClickListener);
            this.mPlayer.setAnimationPlayListener(this.mAnimationPlayListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void setAnimationPlayListener(AnimationPlayer.AnimationPlayListener animationPlayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) animationPlayListener);
            return;
        }
        this.mAnimationPlayListener = animationPlayListener;
        AnimationPlayer animationPlayer = this.mPlayer;
        if (animationPlayer != null) {
            animationPlayer.setAnimationPlayListener(animationPlayListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AnimationPlayer animationPlayer = this.mPlayer;
        if (animationPlayer != null) {
            animationPlayer.start();
            return;
        }
        Logger.w(TAG, "start failed: player is not created, check whether animationType is set to AnimationPlayInfo");
        AnimationPlayer.AnimationPlayListener animationPlayListener = this.mAnimationPlayListener;
        if (animationPlayListener != null) {
            animationPlayListener.onError(null, 100);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        AnimationPlayer animationPlayer = this.mPlayer;
        if (animationPlayer != null) {
            animationPlayer.stop();
        }
    }

    public AnimationPlayerView(Context context, int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            createPlayer(i3);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        }
    }
}
