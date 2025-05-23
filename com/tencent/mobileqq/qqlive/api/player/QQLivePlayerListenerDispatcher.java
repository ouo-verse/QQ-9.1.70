package com.tencent.mobileqq.qqlive.api.player;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.callback.room.VideoSeiInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
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

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0007J(\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007J\u0010\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001c\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001e\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010\u001f\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010!\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010 J\u0010\u0010\"\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010 J\u0010\u0010$\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010#J\u0010\u0010%\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010#J\u0010\u0010'\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010&J\u0010\u0010(\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010&J\u0010\u0010*\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010)J\u0010\u0010+\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010)J\u0010\u0010-\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010,J\u0010\u0010.\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010,J\u0010\u00100\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010/J\u0010\u00101\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010/J\u0006\u00102\u001a\u00020\u0007R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020#0\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020&0\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00104R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020)0\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020,0\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00104R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020/0\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00104R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020 0\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00104R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00104R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00190\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00104\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/QQLivePlayerListenerDispatcher;", "", "T", "", "createListenerSet", "Lcom/tencent/mobileqq/qqlive/callback/room/VideoSeiInfo;", "seiInfo", "", "dispatchSeiInfoListener", "dispatchSwitchDefinition", "dispatchFirstFrameRendered", "", "width", "height", "dispatchVideoSizeChanged", "dispatchCompleted", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "dispatchError", "dispatchStartBuffer", "dispatchEndBuffer", "dispatchVideoPrepared", "Lmi2/g;", "listener", "addVideoPreparedListener", "removeVideoPreparedListener", "Lmi2/e;", "addSeiInfoListener", "removeSeiInfoListener", "Lmi2/f;", "addSwitchDefinitionListener", "removeSwitchDefinitionListener", "Lmi2/d;", "addFirstFrameRenderedListener", "removeFirstFrameRenderedListener", "Lmi2/h;", "addVideoSizeChangedListener", "removeVideoSizeChangedListener", "Lmi2/b;", "addCompletedListener", "removeCompletedListener", "Lmi2/c;", "addErrorListener", "removeErrorListener", "Lmi2/a;", "addBufferListener", "removeBufferListener", "release", "firstFrameRenderedListeners", "Ljava/util/Set;", "videoSizeChangedListeners", "completeListeners", "errorListeners", "bufferListeners", "switchDefinitionListeners", "seiInfoListeners", "videoPreparedListeners", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLivePlayerListenerDispatcher {
    static IPatchRedirector $redirector_;

    @NotNull
    private final Set<mi2.a> bufferListeners;

    @NotNull
    private final Set<b> completeListeners;

    @NotNull
    private final Set<c> errorListeners;

    @NotNull
    private final Set<d> firstFrameRenderedListeners;

    @NotNull
    private final Set<e> seiInfoListeners;

    @NotNull
    private final Set<f> switchDefinitionListeners;

    @NotNull
    private final Set<g> videoPreparedListeners;

    @NotNull
    private final Set<h> videoSizeChangedListeners;

    public QQLivePlayerListenerDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.firstFrameRenderedListeners = createListenerSet();
        this.videoSizeChangedListeners = createListenerSet();
        this.completeListeners = createListenerSet();
        this.errorListeners = createListenerSet();
        this.bufferListeners = createListenerSet();
        this.switchDefinitionListeners = createListenerSet();
        this.seiInfoListeners = createListenerSet();
        this.videoPreparedListeners = createListenerSet();
    }

    private final <T> Set<T> createListenerSet() {
        ConcurrentHashMap.KeySetView newKeySet;
        if (Build.VERSION.SDK_INT > 23) {
            newKeySet = ConcurrentHashMap.newKeySet();
            Intrinsics.checkNotNullExpressionValue(newKeySet, "{\n            Concurrent\u2026Map.newKeySet()\n        }");
            return newKeySet;
        }
        return new CopyOnWriteArraySet();
    }

    public final void addBufferListener(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.bufferListeners.add(listener);
        }
    }

    public final void addCompletedListener(@Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.completeListeners.add(listener);
        }
    }

    public final void addErrorListener(@Nullable c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.errorListeners.add(listener);
        }
    }

    public final void addFirstFrameRenderedListener(@Nullable d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.firstFrameRenderedListeners.add(listener);
        }
    }

    public final void addSeiInfoListener(@Nullable e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.seiInfoListeners.add(listener);
        }
    }

    public final void addSwitchDefinitionListener(@Nullable f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.switchDefinitionListeners.add(listener);
        }
    }

    public final void addVideoPreparedListener(@Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.videoPreparedListeners.add(listener);
        }
    }

    public final void addVideoSizeChangedListener(@Nullable h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.videoSizeChangedListeners.add(listener);
        }
    }

    public final void dispatchCompleted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<T> it = this.completeListeners.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onComplete();
        }
    }

    public final void dispatchEndBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Iterator<T> it = this.bufferListeners.iterator();
        while (it.hasNext()) {
            ((mi2.a) it.next()).w();
        }
    }

    public final void dispatchError(int module, int errorType, int errorCode, @Nullable String extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(module), Integer.valueOf(errorType), Integer.valueOf(errorCode), extraInfo);
            return;
        }
        Iterator<T> it = this.errorListeners.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onError(module, errorType, errorCode, extraInfo);
        }
    }

    public final void dispatchFirstFrameRendered() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<T> it = this.firstFrameRenderedListeners.iterator();
        while (it.hasNext()) {
            ((d) it.next()).onFirstFrameRendered();
        }
    }

    public final void dispatchSeiInfoListener(@NotNull VideoSeiInfo seiInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) seiInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(seiInfo, "seiInfo");
        Iterator<T> it = this.seiInfoListeners.iterator();
        while (it.hasNext()) {
            ((e) it.next()).q(seiInfo);
        }
    }

    public final void dispatchStartBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Iterator<T> it = this.bufferListeners.iterator();
        while (it.hasNext()) {
            ((mi2.a) it.next()).K();
        }
    }

    public final void dispatchSwitchDefinition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Iterator<T> it = this.switchDefinitionListeners.iterator();
        while (it.hasNext()) {
            ((f) it.next()).o();
        }
    }

    public final void dispatchVideoPrepared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Iterator<T> it = this.videoPreparedListeners.iterator();
        while (it.hasNext()) {
            ((g) it.next()).onVideoPrepared();
        }
    }

    public final void dispatchVideoSizeChanged(int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(width), Integer.valueOf(height));
            return;
        }
        Iterator<T> it = this.videoSizeChangedListeners.iterator();
        while (it.hasNext()) {
            ((h) it.next()).onVideoSizeChanged(width, height);
        }
    }

    public final void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        this.videoPreparedListeners.clear();
        this.firstFrameRenderedListeners.clear();
        this.videoSizeChangedListeners.clear();
        this.completeListeners.clear();
        this.switchDefinitionListeners.clear();
        this.errorListeners.clear();
        this.bufferListeners.clear();
        this.seiInfoListeners.clear();
    }

    public final void removeBufferListener(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.bufferListeners.remove(listener);
        }
    }

    public final void removeCompletedListener(@Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.completeListeners.remove(listener);
        }
    }

    public final void removeErrorListener(@Nullable c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.errorListeners.remove(listener);
        }
    }

    public final void removeFirstFrameRenderedListener(@Nullable d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.firstFrameRenderedListeners.remove(listener);
        }
    }

    public final void removeSeiInfoListener(@Nullable e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.seiInfoListeners.remove(listener);
        }
    }

    public final void removeSwitchDefinitionListener(@Nullable f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.switchDefinitionListeners.remove(listener);
        }
    }

    public final void removeVideoPreparedListener(@Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.videoPreparedListeners.remove(listener);
        }
    }

    public final void removeVideoSizeChangedListener(@Nullable h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.videoSizeChangedListeners.remove(listener);
        }
    }
}
