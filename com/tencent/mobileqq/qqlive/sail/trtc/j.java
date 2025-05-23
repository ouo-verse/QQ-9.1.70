package com.tencent.mobileqq.qqlive.sail.trtc;

import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R&\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/j;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/d;", "", "isEngineReady", "Lcom/tencent/mobileqq/qqlive/trtc/a;", EnginePathProvider.ENGINE_DIR, "", "d", "", "roomId", "userId", "connectRemote", "disconnectRemote", "", "uid", "Landroid/widget/FrameLayout;", "videoView", "startRemoteView", "stopRemoteView", "mute", "muteRemoteAudio", "b", "a", "Lcom/tencent/mobileqq/qqlive/trtc/a;", "trtcEngine", "", "Lmqq/util/WeakReference;", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "Ljava/util/Map;", "uidToVideoViewMap", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class j implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.trtc.a trtcEngine;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, WeakReference<TXCloudVideoView>> uidToVideoViewMap;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.uidToVideoViewMap = new LinkedHashMap();
        }
    }

    private final boolean isEngineReady() {
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar == null || aVar.getEngineState() != 2) {
            return false;
        }
        return true;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.trtcEngine = null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.d
    public void connectRemote(long roomId, long userId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(roomId), Long.valueOf(userId));
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "connectRemote", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar != null) {
            aVar.connectRemote(roomId, userId);
        }
    }

    public void d(@Nullable com.tencent.mobileqq.qqlive.trtc.a engine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) engine);
        } else {
            this.trtcEngine = engine;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.d
    public void disconnectRemote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "disconnectRemote", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar != null) {
            aVar.disconnectRemote();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.d
    public void muteRemoteAudio(@NotNull String userId, boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, userId, Boolean.valueOf(mute));
            return;
        }
        Intrinsics.checkNotNullParameter(userId, "userId");
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar != null) {
            aVar.muteRemoteAudio(userId, mute);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.d
    public void startRemoteView(@NotNull String uid, @NotNull FrameLayout videoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uid, (Object) videoView);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        TXCloudVideoView tXCloudVideoView = new TXCloudVideoView(videoView.getContext());
        this.uidToVideoViewMap.put(uid, new WeakReference<>(tXCloudVideoView));
        videoView.addView(tXCloudVideoView, new FrameLayout.LayoutParams(-1, -1));
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar != null) {
            aVar.e(uid, tXCloudVideoView);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.d
    public void stopRemoteView(@NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) uid);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        this.uidToVideoViewMap.remove(uid);
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar != null) {
            aVar.stopRemoteView(uid);
        }
    }
}
