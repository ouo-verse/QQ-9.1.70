package com.tencent.mobileqq.qqlive.api.player.impl;

import android.util.Size;
import android.view.View;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qqlive.sail.player.LiveVideoPlayer;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mi2.b;
import mi2.c;
import mi2.d;
import mi2.e;
import mi2.f;
import mi2.g;
import mi2.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00105\u001a\u000204\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010$\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010'\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010)\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010*\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010,\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010-\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010/\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00100\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00102\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u000101H\u0016J\u0012\u00103\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u000101H\u0016R\u0017\u00105\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/impl/QQLivePlayerImpl;", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "", "prepare", "startPlay", "pause", "replay", "stop", "url", "switchStream", "release", "", "isOutputMute", "mute", "setOutputMute", "isPlaying", "Landroid/util/Size;", "getVideoSize", "Landroid/view/View;", "getVideoView", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer$XYAxis;", "axis", "setXYAxis", "Lcom/tencent/mobileqq/qqlive/sail/model/player/a;", "getPlayerQuality", "Lmi2/g;", "listener", "registerVideoPreparedListener", "unRegisterVideoPreparedListener", "Lmi2/d;", "registerFirstFrameRenderedListener", "unRegisterFirstFrameRenderedListener", "Lmi2/h;", "registerVideoSizeChangedListener", "unRegisterVideoSizeChangedListener", "Lmi2/b;", "registerCompletedListener", "unRegisterCompletedListener", "Lmi2/c;", "registerErrorListener", "unRegisterErrorListener", "Lmi2/a;", "registerBufferListener", "unRegisterBufferListener", "Lmi2/f;", "registerSwitchDefinitionListener", "unRegisterSwitchDefinitionListener", "Lmi2/e;", "registerSeiInfoListener", "unRegisterSeiInfoListener", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "getConfig", "()Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoPlayer;", "player", "Lcom/tencent/mobileqq/qqlive/sail/player/LiveVideoPlayer;", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;)V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLivePlayerImpl implements IQQLivePlayer {
    static IPatchRedirector $redirector_;

    @NotNull
    private final PlayerConfig config;

    @NotNull
    private LiveVideoPlayer player;

    public QQLivePlayerImpl(@NotNull PlayerConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) config);
        } else {
            this.config = config;
            this.player = new LiveVideoPlayer(config, 0L, 2, null);
        }
    }

    @NotNull
    public final PlayerConfig getConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PlayerConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.config;
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    @Nullable
    public com.tencent.mobileqq.qqlive.sail.model.player.a getPlayerQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.qqlive.sail.model.player.a) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.player.getPlayerQuality();
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    @Nullable
    public Size getVideoSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Size) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.player.getVideoSize();
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    @Nullable
    public View getVideoView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.player.getVideoView();
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public boolean isOutputMute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.player.isOutputMute();
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.player.isPlaying();
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.player.pause();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void prepare(@NotNull String videoUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) videoUrl);
        } else {
            Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
            this.player.prepare(videoUrl);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerBufferListener(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) listener);
        } else {
            this.player.registerBufferListener(listener);
        }
    }

    public void registerCompletedListener(@Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) listener);
        } else {
            this.player.k(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerErrorListener(@Nullable c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) listener);
        } else {
            this.player.registerErrorListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerFirstFrameRenderedListener(@Nullable d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) listener);
        } else {
            this.player.registerFirstFrameRenderedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerSeiInfoListener(@Nullable e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) listener);
        } else {
            this.player.registerSeiInfoListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerSwitchDefinitionListener(@Nullable f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) listener);
        } else {
            this.player.registerSwitchDefinitionListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerVideoPreparedListener(@Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) listener);
        } else {
            this.player.registerVideoPreparedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void registerVideoSizeChangedListener(@Nullable h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) listener);
        } else {
            this.player.registerVideoSizeChangedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.player.release();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void replay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.player.replay();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void setOutputMute(boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, mute);
        } else {
            this.player.setOutputMute(mute);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void setXYAxis(@NotNull IQQLivePlayer.XYAxis axis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) axis);
        } else {
            Intrinsics.checkNotNullParameter(axis, "axis");
            this.player.setXYAxis(axis);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void startPlay(@Nullable String videoUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) videoUrl);
        } else {
            this.player.startPlay(videoUrl);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.player.stop();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void switchStream(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) url);
        } else {
            Intrinsics.checkNotNullParameter(url, "url");
            this.player.switchStream(url);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterBufferListener(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) listener);
        } else {
            this.player.unRegisterBufferListener(listener);
        }
    }

    public void unRegisterCompletedListener(@Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) listener);
        } else {
            this.player.m(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterErrorListener(@Nullable c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) listener);
        } else {
            this.player.unRegisterErrorListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterFirstFrameRenderedListener(@Nullable d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) listener);
        } else {
            this.player.unRegisterFirstFrameRenderedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterSeiInfoListener(@Nullable e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) listener);
        } else {
            this.player.unRegisterSeiInfoListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterSwitchDefinitionListener(@Nullable f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) listener);
        } else {
            this.player.unRegisterSwitchDefinitionListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterVideoPreparedListener(@Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) listener);
        } else {
            this.player.unRegisterVideoPreparedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.player.IQQLivePlayer
    public void unRegisterVideoSizeChangedListener(@Nullable h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) listener);
        } else {
            this.player.unRegisterVideoSizeChangedListener(listener);
        }
    }
}
