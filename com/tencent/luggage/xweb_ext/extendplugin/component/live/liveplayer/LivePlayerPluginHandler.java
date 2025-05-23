package com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.luggage.wxa.a8.h;
import com.tencent.luggage.wxa.a8.x;
import com.tencent.luggage.wxa.a8.y;
import com.tencent.luggage.wxa.ag.j;
import com.tencent.luggage.wxa.p004if.b0;
import com.tencent.luggage.wxa.p004if.p;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.z7.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class LivePlayerPluginHandler extends com.tencent.luggage.wxa.k8.a implements com.tencent.luggage.wxa.a8.p, com.tencent.luggage.wxa.a8.j, LifecycleOwner {
    public static final String TAG = "MicroMsg.SameLayer.LivePlayerPluginHandler";

    @Nullable
    private com.tencent.luggage.wxa.d8.a mAdapter;
    private boolean mAutoPauseIfNavigate;
    private boolean mAutoPauseIfOpenNative;
    private volatile boolean mAutoPlay;
    private com.tencent.luggage.wxa.a8.a mAutoRotationPluginHandlerCommons;

    @Nullable
    private volatile String mBackgroundPosterPath;

    @Nullable
    private volatile Bitmap mCachedVideoSnapshot;

    @Nullable
    private volatile com.tencent.luggage.wxa.b8.m mCastHandler;
    private com.tencent.luggage.wxa.e8.a mCustomHandler;
    private com.tencent.luggage.wxa.xd.t mEventFactory;
    private com.tencent.luggage.wxa.e8.b mEventHandler;

    @Nullable
    private volatile com.tencent.luggage.wxa.a8.g mGetSnapshotCallback;
    private int mHtmlHeight;
    private int mHtmlWidth;
    private com.tencent.luggage.wxa.z7.c mInsertInvokeContext;
    private boolean mIsAddOnOfBackgroundPlayAudioRegistered;
    private boolean mIsBackgroundPlayAudioEnabled;
    private volatile boolean mIsCastEnabled;
    private boolean mIsRTCMode;
    private AtomicBoolean mJustPlayAudio;
    private c.a mLifecycleListener;

    @NonNull
    private final com.tencent.luggage.wxa.dq.a mLivePlayerHandler;

    @NonNull
    private final com.tencent.luggage.wxa.a8.h mLivePlayerThread;

    @Nullable
    private x mOnPlayListener;
    private int mOnPlayListenerPendingEvent;
    private com.tencent.luggage.wxa.a8.b mPipPluginHandlerCommons;

    @NonNull
    private String mPlayerUrl;
    private com.tencent.luggage.wxa.e8.c mReportHandler;
    private boolean mShouldNotifyEvent;
    private Surface mSurface;
    private volatile SurfaceTexture mSurfaceTexture;

    @Nullable
    private volatile String mTitle;
    private com.tencent.luggage.wxa.a8.j mVideoPlayerDelegate;

    @NonNull
    private static h.a sThreadProvider = com.tencent.luggage.wxa.a8.t.a(com.tencent.luggage.wxa.a8.u.LivePlayer);

    @NonNull
    private static com.tencent.luggage.wxa.b8.h sCastHandlerFactory = com.tencent.luggage.wxa.vh.a.f143485a;
    private volatile int mSetSurfaceTextureWidth = -1;
    private volatile int mSetSurfaceTextureHeight = -1;
    private int mPosX = 0;
    private int mPosY = 0;

    @Nullable
    private com.tencent.luggage.wxa.cg.c mReferrerPolicy = null;

    @Nullable
    private String mReferrer = null;

    @NonNull
    private final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

    @NonNull
    private final b0 mAudioFocusComponent = b0.f130171e.a(new Function0() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.r
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.tencent.luggage.wxa.xd.d lambda$new$0;
            lambda$new$0 = LivePlayerPluginHandler.this.lambda$new$0();
            return lambda$new$0;
        }
    }, new p.a() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler.1
        @Override // com.tencent.luggage.wxa.if.p.a
        public void onPause() {
            com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            LivePlayerPluginHandler.this.muteIfIsUnMuted();
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onResume() {
            com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), "onResume");
            LivePlayerPluginHandler.this.unMuteIfIsMuted();
        }

        @Override // com.tencent.luggage.wxa.if.p.a
        public void onStop() {
            com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), DKHippyEvent.EVENT_STOP);
            LivePlayerPluginHandler.this.muteIfIsUnMuted();
        }
    });
    private volatile boolean mPassiveMute = false;
    private boolean isRuntimeInBackground = false;
    private volatile boolean mIsWebViewInBackground = false;
    private AtomicBoolean isPlayingWhenEnterBackground = null;

    @Nullable
    private volatile com.tencent.luggage.wxa.z7.c mSnapshotInvokeContext = null;

    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler$2, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass2 implements ITXLivePlayListener {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPlayEvent$0() {
            if (LivePlayerPluginHandler.this.mAdapter != null) {
                LivePlayerPluginHandler.this.mAdapter.operateLivePlayer("stop", null);
            }
        }

        @Override // com.tencent.rtmp.ITXLivePlayListener
        public void onNetStatus(Bundle bundle) {
            if (LivePlayerPluginHandler.this.shouldNotifyEvent()) {
                LivePlayerPluginHandler.this.mEventHandler.a(LivePlayerPluginHandler.this.getId(), bundle);
            }
        }

        @Override // com.tencent.rtmp.ITXLivePlayListener
        public void onPlayEvent(int i3, Bundle bundle) {
            int i16;
            if (2006 == i3 || -2301 == i3) {
                LivePlayerPluginHandler.this.runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivePlayerPluginHandler.AnonymousClass2.this.lambda$onPlayEvent$0();
                    }
                });
            }
            if (LivePlayerPluginHandler.this.shouldNotifyEvent()) {
                LivePlayerPluginHandler.this.mEventHandler.a(LivePlayerPluginHandler.this.getId(), i3, bundle);
            }
            if (LivePlayerPluginHandler.this.mCustomHandler != null) {
                LivePlayerPluginHandler.this.mCustomHandler.a(LivePlayerPluginHandler.this.getId(), i3, bundle);
            }
            if (i3 != -2301) {
                if (i3 != 2003) {
                    if (i3 != 2006) {
                        if (i3 == 2007) {
                            if (LivePlayerPluginHandler.this.mOnPlayListener == null) {
                                LivePlayerPluginHandler.this.mOnPlayListenerPendingEvent = 0;
                                return;
                            } else {
                                LivePlayerPluginHandler.this.mOnPlayListener.j();
                                return;
                            }
                        }
                        return;
                    }
                    if (LivePlayerPluginHandler.this.mOnPlayListener == null) {
                        LivePlayerPluginHandler.this.mOnPlayListenerPendingEvent = 7;
                    } else {
                        LivePlayerPluginHandler.this.mOnPlayListener.f();
                    }
                    com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), "onPlayEnd, abandonFocus");
                    LivePlayerPluginHandler.this.mAudioFocusComponent.a();
                    return;
                }
                if (LivePlayerPluginHandler.this.mOnPlayListener != null) {
                    LivePlayerPluginHandler.this.mOnPlayListener.b();
                    LivePlayerPluginHandler.this.mOnPlayListener.a(LivePlayerPluginHandler.this.mAutoPlay);
                } else {
                    LivePlayerPluginHandler livePlayerPluginHandler = LivePlayerPluginHandler.this;
                    if (livePlayerPluginHandler.mAutoPlay) {
                        i16 = 2;
                    } else {
                        i16 = 3;
                    }
                    livePlayerPluginHandler.mOnPlayListenerPendingEvent = i16;
                }
                com.tencent.luggage.wxa.tn.w.a(LivePlayerPluginHandler.this.getLogTag(), "onPlayEvent play, mIsWebViewInBackground: %b, isRuntimeInBackground: %b", Boolean.valueOf(LivePlayerPluginHandler.this.mIsWebViewInBackground), Boolean.valueOf(LivePlayerPluginHandler.this.isRuntimeInBackground));
                if (!LivePlayerPluginHandler.this.mIsWebViewInBackground && !LivePlayerPluginHandler.this.isRuntimeInBackground && !LivePlayerPluginHandler.this.isMuted()) {
                    com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), "onPlayEvent play, requestFocus");
                    if (!LivePlayerPluginHandler.this.mAudioFocusComponent.b()) {
                        com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), "onPlayEvent play, can not play");
                        LivePlayerPluginHandler.this.muteIfIsUnMuted();
                        return;
                    }
                    return;
                }
                return;
            }
            if (LivePlayerPluginHandler.this.mOnPlayListener == null) {
                LivePlayerPluginHandler.this.mOnPlayListenerPendingEvent = 6;
            } else {
                LivePlayerPluginHandler.this.mOnPlayListener.onStop();
            }
            com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), "onStop, abandonFocus");
            LivePlayerPluginHandler.this.mAudioFocusComponent.a();
        }
    }

    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler$9, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass9 implements com.tencent.luggage.wxa.a8.n {
        public AnonymousClass9() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$playAudio$0() {
            if (LivePlayerPluginHandler.this.mJustPlayAudio.get() && LivePlayerPluginHandler.this.mAdapter != null) {
                LivePlayerPluginHandler.this.mAdapter.setSurface(null);
                if (!LivePlayerPluginHandler.this.mAdapter.isPlaying()) {
                    LivePlayerPluginHandler.this.mAdapter.operateLivePlayer("play", null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$playAudio$1() {
            LivePlayerPluginHandler.this.runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.v
                @Override // java.lang.Runnable
                public final void run() {
                    LivePlayerPluginHandler.AnonymousClass9.this.lambda$playAudio$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$playVideo$2() {
            if (!LivePlayerPluginHandler.this.mJustPlayAudio.get() && LivePlayerPluginHandler.this.mAdapter != null) {
                LivePlayerPluginHandler.this.mAdapter.setSurface(LivePlayerPluginHandler.this.mSurface);
                if (!LivePlayerPluginHandler.this.mAdapter.isPlaying()) {
                    LivePlayerPluginHandler.this.mAdapter.operateLivePlayer("play", null);
                }
            }
        }

        @Override // com.tencent.luggage.wxa.a8.n
        public void playAudio() {
            com.tencent.luggage.wxa.tn.w.a(LivePlayerPluginHandler.this.getLogTag(), "playAudio");
            if (!LivePlayerPluginHandler.this.mJustPlayAudio.getAndSet(true)) {
                LivePlayerPluginHandler.this.tryCacheSnapshotBeforePlayAudio(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivePlayerPluginHandler.AnonymousClass9.this.lambda$playAudio$1();
                    }
                });
            }
        }

        @Override // com.tencent.luggage.wxa.a8.n
        public void playVideo() {
            com.tencent.luggage.wxa.tn.w.a(LivePlayerPluginHandler.this.getLogTag(), "playVideo");
            if (LivePlayerPluginHandler.this.mJustPlayAudio.getAndSet(false)) {
                LivePlayerPluginHandler.this.runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivePlayerPluginHandler.AnonymousClass9.this.lambda$playVideo$2();
                    }
                });
            }
        }
    }

    public LivePlayerPluginHandler() {
        com.tencent.luggage.wxa.xd.t tVar = new com.tencent.luggage.wxa.xd.t() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler.6
            private com.tencent.luggage.wxa.xd.s onXWeLivePlayerOrientationChanged = new com.tencent.luggage.wxa.wh.d();

            @Override // com.tencent.luggage.wxa.xd.t
            @NonNull
            public com.tencent.luggage.wxa.xd.s createAppBrandOnVideoOrientationChanged() {
                return this.onXWeLivePlayerOrientationChanged;
            }
        };
        this.mEventFactory = tVar;
        this.mAutoRotationPluginHandlerCommons = new com.tencent.luggage.wxa.a8.a(this, tVar) { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler.7
            @Override // com.tencent.luggage.wxa.a8.a
            public void handleJsApi(@NonNull String str, @NonNull com.tencent.luggage.wxa.z7.c cVar) {
                setPageView(cVar);
                JSONObject a16 = cVar.a();
                if (!str.contains("insert") && !str.contains("update")) {
                    if (str.contains("operate")) {
                        String optString = a16.optString("type");
                        if (!w0.c(optString) && (optString.equalsIgnoreCase("play") || optString.equalsIgnoreCase("resume"))) {
                            this.mIsNeedNotify = true;
                        }
                    } else if (str.contains("remove")) {
                        this.mIsNeedNotify = false;
                    }
                } else {
                    if (a16.has("autoplay")) {
                        this.mIsNeedNotify = a16.optBoolean("autoplay");
                    }
                    Boolean a17 = com.tencent.luggage.wxa.xd.w.a(a16);
                    if (a17 != null) {
                        this.mIsAutoRotationEnabled = a17.booleanValue();
                    }
                }
                com.tencent.luggage.wxa.tn.w.a(LivePlayerPluginHandler.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.mIsNeedNotify + ", mIsAutoRotationEnabled: " + this.mIsAutoRotationEnabled);
            }

            @Override // com.tencent.luggage.wxa.a8.a
            public boolean isInForeground() {
                return !LivePlayerPluginHandler.this.mIsWebViewInBackground;
            }
        };
        this.mPipPluginHandlerCommons = new com.tencent.luggage.wxa.a8.b() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler.8
            private b mPipInfoProvider = null;

            @Override // com.tencent.luggage.wxa.a8.b
            public int getId() {
                return LivePlayerPluginHandler.this.getId();
            }

            @Override // com.tencent.luggage.wxa.a8.b
            @NonNull
            public String getKey() {
                return LivePlayerPluginHandler.this.getKey();
            }

            @Override // com.tencent.luggage.wxa.a8.b
            @NonNull
            public String getLogTag() {
                return LivePlayerPluginHandler.this.getLogTag();
            }

            @Override // com.tencent.luggage.wxa.a8.b
            @NonNull
            public j.b getType() {
                return j.b.LivePlayer;
            }

            @Override // com.tencent.luggage.wxa.a8.b
            @NonNull
            public b getPipInfoProvider() {
                if (this.mPipInfoProvider == null) {
                    this.mPipInfoProvider = new b(LivePlayerPluginHandler.this);
                }
                return this.mPipInfoProvider;
            }
        };
        this.mPlayerUrl = "";
        this.mOnPlayListener = null;
        this.mOnPlayListenerPendingEvent = -1;
        this.mAutoPlay = false;
        this.mIsRTCMode = false;
        this.mIsAddOnOfBackgroundPlayAudioRegistered = false;
        this.mIsBackgroundPlayAudioEnabled = false;
        this.mVideoPlayerDelegate = new com.tencent.luggage.wxa.a8.w();
        this.mJustPlayAudio = new AtomicBoolean(false);
        this.mTitle = null;
        this.mBackgroundPosterPath = null;
        this.mGetSnapshotCallback = null;
        this.mCachedVideoSnapshot = null;
        this.mCastHandler = null;
        this.mIsCastEnabled = false;
        com.tencent.luggage.wxa.zp.h.f146825d.a(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.s
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.lambda$new$2();
            }
        });
        com.tencent.luggage.wxa.a8.h create = sThreadProvider.create();
        this.mLivePlayerThread = create;
        create.start();
        this.mLivePlayerHandler = create.getHandler();
        com.tencent.luggage.wxa.ff.i.b();
        initLivePlayerAdapter();
    }

    private void adjustHtmlSize() {
        if (this.mHtmlWidth != 0 && this.mHtmlHeight != 0 && this.mAdapter != null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "adjustHtmlSize, size:[%d, %d]", Integer.valueOf(this.mHtmlWidth), Integer.valueOf(this.mHtmlHeight));
            if (amIPipPlayer() && this.mIsWebViewInBackground) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "adjustHtmlSize, i am pip player, isWebViewInBackground");
            } else {
                this.mAdapter.setSurfaceSize(this.mHtmlWidth, this.mHtmlHeight);
            }
        }
    }

    private boolean amIBackgroundAudioPlayer() {
        com.tencent.luggage.wxa.z7.c cVar = this.mInsertInvokeContext;
        if (cVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
            return false;
        }
        com.tencent.luggage.wxa.ph.a a16 = com.tencent.luggage.wxa.a8.e.a(cVar);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
            return false;
        }
        return a16.a(this);
    }

    private boolean amIPipPlayer() {
        return this.mPipPluginHandlerCommons.amIPipPlayer(this.mInsertInvokeContext);
    }

    private void clearSurface() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
    }

    private void disableBackgroundPlayAudio(com.tencent.luggage.wxa.z7.c cVar) {
        boolean z16;
        com.tencent.luggage.wxa.af.c cVar2;
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "disableBackgroundPlayAudio");
        if (this.mIsRTCMode) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "disableBackgroundPlayAudio, mIsRTCMode");
            cVar.a(com.tencent.luggage.wxa.af.g.f121347p);
            return;
        }
        if (disableBackgroundPlayAudioInternal(cVar)) {
            this.mJustPlayAudio.set(false);
            com.tencent.luggage.wxa.d8.a aVar = this.mAdapter;
            if (aVar != null) {
                aVar.setSurface(this.mSurface);
            }
            this.mIsBackgroundPlayAudioEnabled = false;
            com.tencent.luggage.wxa.e8.b bVar = this.mEventHandler;
            if (bVar != null) {
                bVar.a(getId(), false);
            }
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "disableBackgroundPlayAudio, result:%s", Boolean.valueOf(z16));
        if (z16) {
            cVar2 = com.tencent.luggage.wxa.af.e.f121305a;
        } else {
            cVar2 = com.tencent.luggage.wxa.af.e.f121309e;
        }
        cVar.a(cVar2);
    }

    private boolean disableBackgroundPlayAudioInternal(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "disableBackgroundPlayAudioInternal");
        if (cVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
            return false;
        }
        com.tencent.luggage.wxa.ph.a a16 = com.tencent.luggage.wxa.a8.e.a(cVar);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
            return false;
        }
        a16.b(this);
        return true;
    }

    private void enableBackgroundPlayAudio(com.tencent.luggage.wxa.z7.c cVar) {
        boolean z16;
        com.tencent.luggage.wxa.af.c cVar2;
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "enableBackgroundPlayAudio");
        if (w0.c(this.mPlayerUrl)) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "enableBackgroundPlayAudio, playerUrl is empty");
            cVar.a(com.tencent.luggage.wxa.af.g.f121346o);
            return;
        }
        if (this.mIsRTCMode) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "enableBackgroundPlayAudio, mIsRTCMode");
            cVar.a(com.tencent.luggage.wxa.af.g.f121347p);
            return;
        }
        if (this.isRuntimeInBackground) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "enableBackgroundPlayAudio, isRuntimeInBackground");
            cVar.a(com.tencent.luggage.wxa.af.g.f121348q);
            return;
        }
        if (!this.mIsAddOnOfBackgroundPlayAudioRegistered) {
            registerAddOnPlayAudio();
            registerAddOnVideoController();
            registerAddOnInfo();
            registerAddOnGetSnapshot();
            this.mIsAddOnOfBackgroundPlayAudioRegistered = true;
        }
        if (enableBackgroundPlayAudioInternal(cVar)) {
            com.tencent.luggage.wxa.d8.a aVar = this.mAdapter;
            if (aVar != null && !aVar.isPlaying()) {
                this.mJustPlayAudio.set(true);
                this.mAdapter.setSurface(null);
            }
            this.mIsBackgroundPlayAudioEnabled = true;
            com.tencent.luggage.wxa.e8.b bVar = this.mEventHandler;
            if (bVar != null) {
                bVar.a(getId(), true);
            }
            requestAppEnterBackground();
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "enableBackgroundPlayAudio, result:%s", Boolean.valueOf(z16));
        if (z16) {
            cVar2 = com.tencent.luggage.wxa.af.e.f121305a;
        } else {
            cVar2 = com.tencent.luggage.wxa.af.e.f121309e;
        }
        cVar.a(cVar2);
    }

    private boolean enableBackgroundPlayAudioInternal(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "enableBackgroundPlayAudioInternal");
        if (cVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "enableBackgroundPlayAudioInternal, invokeContext is null");
            return false;
        }
        com.tencent.luggage.wxa.ph.a a16 = com.tencent.luggage.wxa.a8.e.a(cVar);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "enableBackgroundPlayAudioInternal, audioOfVideoBackgroundPlayManager is null");
            return false;
        }
        return a16.a((com.tencent.luggage.wxa.a8.j) this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLogTag() {
        return String.format("%s(%s)", TAG, key());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSnapshotAsync(@NonNull com.tencent.luggage.wxa.a8.g gVar) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "getSnapshotAsync");
        if (this.mAdapter == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "getSnapshotAsync, mAdapter is null");
            gVar.onSnapshotGot(null);
        } else {
            this.mGetSnapshotCallback = gVar;
            this.mAdapter.takePhoto(true, new TXLivePlayer.ITXSnapshotListener() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler.12
                @Override // com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener
                public void onSnapshot(Bitmap bitmap) {
                    com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), "getSnapshotAsync, onSnapshot");
                    com.tencent.luggage.wxa.a8.g gVar2 = LivePlayerPluginHandler.this.mGetSnapshotCallback;
                    if (gVar2 == null) {
                        com.tencent.luggage.wxa.tn.w.f(LivePlayerPluginHandler.this.getLogTag(), "getSnapshotAsync, getSnapshotCallback is null");
                    } else {
                        gVar2.onSnapshotGot(bitmap);
                        LivePlayerPluginHandler.this.mGetSnapshotCallback = null;
                    }
                }
            });
        }
    }

    private void handleAutoPlay(com.tencent.luggage.wxa.z7.c cVar) {
        JSONObject a16 = cVar.a();
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handleAutoPlay, null == dataJsonObj");
        } else {
            this.mAutoPlay = a16.optBoolean("autoplay", this.mAutoPlay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleJsApiInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$handleJsApi$4(com.tencent.luggage.wxa.z7.c cVar) {
        String c16 = cVar.c();
        if (w0.c(c16)) {
            return;
        }
        JSONObject a16 = cVar.a();
        boolean z16 = false;
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", key(), c16, a16.toString());
        Log.i("TXLivePlayerAdapter", "handleJsApi:" + c16 + ", data:" + a16);
        boolean isMuted = isMuted();
        handleAutoPlay(cVar);
        handlePlayerUrl(cVar);
        if (c16.contains("insert")) {
            reportJsapiCall(1);
            insert(cVar);
        } else if (c16.contains("update")) {
            reportJsapiCall(2);
            update(cVar);
        } else if (c16.contains("operate") && c16.contains("Background")) {
            operateBackground(cVar);
        } else if (c16.contains("operate")) {
            reportJsapiCall(3);
            operate(cVar);
        } else if (c16.contains("remove")) {
            reportJsapiCall(4);
            remove(cVar);
            this.mPipPluginHandlerCommons.removePipId(cVar);
        }
        this.mAutoRotationPluginHandlerCommons.handleJsApi(c16, cVar);
        this.mPipPluginHandlerCommons.handlePipInfo(cVar, this.mPlayerUrl);
        boolean isMuted2 = isMuted();
        if (isMuted2 != isMuted) {
            z16 = true;
        }
        if ((isPlaying() & z16) && !this.mIsWebViewInBackground && !this.isRuntimeInBackground) {
            if (isMuted2) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "live muted, abandonFocus");
                this.mAudioFocusComponent.a();
            } else {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "live unmuted, requestFocus");
                this.mAudioFocusComponent.b();
            }
        }
    }

    private void handlePlayerUrl(com.tencent.luggage.wxa.z7.c cVar) {
        JSONObject a16 = cVar.a();
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePlayerUrl, null == dataJsonObj");
        } else {
            this.mPlayerUrl = a16.optString("playUrl", this.mPlayerUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePluginDestroyInternal() {
        super.handlePluginDestroy();
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handlePluginDestroy", key());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handlePluginReadyInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$handlePluginReadyForGPUProcess$3(Surface surface) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handlePluginReady", key());
        this.mSurface = surface;
        if (this.mAdapter != null) {
            if (!this.mJustPlayAudio.get()) {
                this.mAdapter.setSurface(this.mSurface);
            } else {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "setSurface, JustPlayAudio");
            }
            adjustHtmlSize();
        }
    }

    private void handlePluginScreenshotTaken4JsApiCall(@Nullable Bitmap bitmap) {
        com.tencent.luggage.wxa.z7.c cVar = this.mSnapshotInvokeContext;
        if (cVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, invokeContext is null");
            return;
        }
        this.mSnapshotInvokeContext = null;
        com.tencent.luggage.wxa.e8.a aVar = this.mCustomHandler;
        if (aVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, customHandler is null");
        } else {
            aVar.a(cVar, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWebViewBackground(final int i3) {
        runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.e
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.lambda$handleWebViewBackground$6(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleWebViewBackgroundInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$handleWebViewBackground$6(int i3) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handleWebViewBackground, type:%d", key(), Integer.valueOf(i3));
        this.mIsWebViewInBackground = true;
        com.tencent.luggage.wxa.xd.d dVar = null;
        if (!isPluginReady(null)) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "plugin is not ready");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground, type:%s, autoPauseIfNative:%s, autoPauseIfNavigate:%s, isRuntimeInBackground:%s, isPlayingWhenEnterBackground:%s", Integer.valueOf(i3), Boolean.valueOf(this.mAutoPauseIfOpenNative), Boolean.valueOf(this.mAutoPauseIfNavigate), Boolean.valueOf(this.isRuntimeInBackground), getPlayingWhenEnterBackground());
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground, abandonFocus");
        this.mAudioFocusComponent.a();
        com.tencent.luggage.wxa.e8.a aVar = this.mCustomHandler;
        if (aVar != null && aVar.a(this, this.mInsertInvokeContext, i3)) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground, should intercept enter background, return");
            return;
        }
        if (i3 == 4) {
            com.tencent.luggage.wxa.d8.a aVar2 = this.mAdapter;
            if (aVar2 == null) {
                com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handleWebViewBackground, adapter is null 0");
            } else {
                aVar2.sendHandupStop();
            }
        }
        com.tencent.luggage.wxa.p004if.r a16 = com.tencent.luggage.wxa.p004if.g.f130201b.a(this.mAutoPauseIfNavigate, this.mAutoPauseIfOpenNative);
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground, autoPauseStrategy: %s", a16);
        com.tencent.luggage.wxa.z7.c cVar = this.mInsertInvokeContext;
        if (cVar != null) {
            dVar = cVar.e();
        }
        if (!a16.a(dVar, com.tencent.luggage.wxa.ph.b.a(i3))) {
            if (getPlayingWhenEnterBackground() != null && getPlayingWhenEnterBackground().get()) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground, live player not auto pause, try resume, type:%s", Integer.valueOf(i3));
                com.tencent.luggage.wxa.d8.a aVar3 = this.mAdapter;
                if (aVar3 == null) {
                    com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handleWebViewBackground, adapter is null 1");
                    return;
                } else {
                    aVar3.enterForeground();
                    return;
                }
            }
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground, live player not auto pause, ignore resume, type:%s", Integer.valueOf(i3));
            if (this.mAdapter != null && getPlayingWhenEnterBackground() == null) {
                setPlayingWhenEnterBackground(new AtomicBoolean(this.mAdapter.isPlaying()));
                return;
            }
            return;
        }
        if (this.mAdapter != null && getPlayingWhenEnterBackground() == null) {
            boolean isPlaying = this.mAdapter.isPlaying();
            setPlayingWhenEnterBackground(new AtomicBoolean(isPlaying));
            if (this.mIsBackgroundPlayAudioEnabled && 1 != i3 && amIBackgroundAudioPlayer()) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground runnable, background play audio is enabled, do not pause");
                return;
            }
            if (amIPipPlayer()) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground runnable, i am pip player, do not pause");
                return;
            }
            com.tencent.luggage.wxa.ff.h a17 = this.mAdapter.a();
            if (isPlaying) {
                onJSAdapterOperateDone("stop");
            }
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground, isPlayingWhenEnterBackground:%s, code:%d info:%s", Boolean.valueOf(isPlaying), Integer.valueOf(a17.f126108a), a17.f126109b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWebViewDestroy() {
        runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.j
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.handleWebViewDestroyInternal();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWebViewDestroyInternal() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handleWebViewDestroy", key());
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWebViewForeground() {
        runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.i
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.handleWebViewForegroundInternal();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWebViewForegroundInternal() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handleWebViewForeground", key());
        this.mIsWebViewInBackground = false;
        if (!isPluginReady(null)) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "plugin is not ready");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewForeground, isRuntimeInBackground: %b, passiveMute: %b", Boolean.valueOf(this.isRuntimeInBackground), Boolean.valueOf(this.mPassiveMute));
        if (!this.isRuntimeInBackground && (this.mPassiveMute || !isMuted())) {
            if (this.mPassiveMute) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewForeground, passiveMute, unMute");
                unMuteIfIsMuted();
            }
            if (isPlaying()) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewForeground, isPlaying, requestFocus");
                this.mAudioFocusComponent.b();
            }
        }
        if (!this.isRuntimeInBackground && this.mAdapter != null && getPlayingWhenEnterBackground() != null) {
            boolean z16 = getPlayingWhenEnterBackground().get();
            setPlayingWhenEnterBackground(null);
            if (z16) {
                com.tencent.luggage.wxa.ff.h enterForeground = this.mAdapter.enterForeground();
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewForeground, code:%d info:%s", Integer.valueOf(enterForeground.f126108a), enterForeground.f126109b);
            }
        }
    }

    private void initLivePlayerAdapter() {
        com.tencent.luggage.wxa.d8.b bVar = new com.tencent.luggage.wxa.d8.b(z.c());
        this.mAdapter = bVar;
        bVar.setPlayListener(new AnonymousClass2());
        this.mAdapter.setAudioVolumeListener(new TXLivePlayer.ITXAudioVolumeEvaluationListener() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler.3
            @Override // com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener
            public void onAudioVolumeEvaluationNotify(int i3) {
                if (LivePlayerPluginHandler.this.mEventHandler != null) {
                    LivePlayerPluginHandler.this.mEventHandler.a(LivePlayerPluginHandler.this.getId(), i3);
                }
            }
        });
    }

    private void insert(final com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.af.c cVar2;
        com.tencent.luggage.wxa.e8.a aVar;
        JSONObject a16 = cVar.a();
        if (a16.optInt("mode", 0) == 2) {
            this.mIsRTCMode = true;
        } else {
            this.mIsRTCMode = false;
        }
        TXLiveBase.setAppVersion(String.format("weixin_%s", cVar.getAppId()));
        this.mInsertInvokeContext = cVar;
        if (cVar.e() instanceof com.tencent.luggage.wxa.kj.v) {
            this.mIsWebViewInBackground = !com.tencent.luggage.wxa.sd.b.a(cVar);
        } else {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "insert, component is not AppBrandPageView");
        }
        registerLifecycleListener(cVar);
        com.tencent.luggage.wxa.e8.a aVar2 = this.mCustomHandler;
        if (aVar2 != null) {
            aVar2.a(cVar);
        }
        parseShouldNotifyEvent(cVar, a16);
        parseHtmlPosition(a16);
        this.mAutoPauseIfNavigate = a16.optBoolean("autoPauseIfNavigate", true);
        this.mAutoPauseIfOpenNative = a16.optBoolean("autoPauseIfOpenNative", true);
        this.mTitle = a16.optString("title", this.mTitle);
        this.mBackgroundPosterPath = a16.optString(com.tencent.luggage.wxa.c8.c.f123407y0, this.mBackgroundPosterPath);
        updateReferrers(cVar, a16);
        String str = this.mReferrer;
        if (str != null) {
            try {
                a16.put(com.tencent.luggage.wxa.c8.c.f123370d0, str);
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.f(getLogTag(), "insert, put referrer fail since " + e16.toString());
            }
        }
        preventAutoPlayInBackground(a16);
        toggleCastEnableStateIfNeed(cVar, a16);
        if (this.mAdapter == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "insert, adapter is null");
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
            return;
        }
        com.tencent.luggage.wxa.e8.a aVar3 = this.mCustomHandler;
        if (aVar3 != null) {
            final String a17 = aVar3.a(this, this);
            if (!w0.c(a17)) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "insert fail, message:%s", a17);
                cVar.a("fail: can not insert LivePlayer now", com.tencent.luggage.wxa.af.g.f121338g);
                com.tencent.luggage.wxa.zp.h.f146825d.a(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivePlayerPluginHandler.lambda$insert$5(com.tencent.luggage.wxa.z7.c.this, a17);
                    }
                });
                return;
            }
        }
        Bundle a18 = com.tencent.luggage.wxa.c8.d.a(a16);
        com.tencent.luggage.wxa.ff.h a19 = this.mAdapter.a(a18);
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "insert, code:%d info:%s", Integer.valueOf(a19.f126108a), a19.f126109b);
        if (a19.f126108a == 0) {
            cVar2 = com.tencent.luggage.wxa.af.e.f121305a;
        } else {
            cVar2 = com.tencent.luggage.wxa.af.e.f121309e;
        }
        cVar.a(cVar2, a19.f126110c);
        if (a19.f126108a == 0 && (aVar = this.mCustomHandler) != null) {
            aVar.a(cVar, a18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMuted() {
        com.tencent.luggage.wxa.d8.a aVar = this.mAdapter;
        if (aVar != null && aVar.b()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPlaying() {
        com.tencent.luggage.wxa.d8.a aVar = this.mAdapter;
        if (aVar != null && aVar.isPlaying()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$forceStop$9() {
        com.tencent.luggage.wxa.d8.a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.operateLivePlayer("stop", null);
            onJSAdapterOperateDone("stop");
            this.mAdapter.sendWeChatStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$insert$5(com.tencent.luggage.wxa.z7.c cVar, String str) {
        com.tencent.luggage.wxa.y9.a.makeText(cVar.getContext(), str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$muteIfIsUnMuted$1() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "muteIfIsUnMuted, set passive mute");
        this.mPassiveMute = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.tencent.luggage.wxa.xd.d lambda$new$0() {
        com.tencent.luggage.wxa.z7.c cVar = this.mInsertInvokeContext;
        if (cVar != null) {
            return cVar.e();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2() {
        this.mLifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$operate$11(String str, Runnable runnable) {
        com.tencent.luggage.wxa.d8.a aVar = this.mAdapter;
        if (aVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "run#operate, adapter is null");
            return;
        }
        aVar.operateLivePlayer(str, null);
        onJSAdapterOperateDone(str);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$8() {
        this.mLifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startIfForeground$10() {
        if (this.mAdapter != null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "startIfForeground, do start");
            this.mAdapter.operateLivePlayer("play", null);
            onJSAdapterOperateDone("play");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void muteIfIsUnMuted() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "muteIfIsUnMuted");
        if (isMuted()) {
            return;
        }
        operate("mute", new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.p
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.lambda$muteIfIsUnMuted$1();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void onJSAdapterOperateDone(@NonNull String str) {
        boolean z16;
        if (str.equalsIgnoreCase("pause")) {
            x xVar = this.mOnPlayListener;
            if (xVar != null) {
                xVar.onPause();
            } else {
                this.mOnPlayListenerPendingEvent = 4;
            }
            com.tencent.luggage.wxa.e8.a aVar = this.mCustomHandler;
            if (aVar != null) {
                aVar.a(getId(), 2006, (Bundle) null);
            }
        } else if (str.equalsIgnoreCase("stop")) {
            x xVar2 = this.mOnPlayListener;
            if (xVar2 != null) {
                xVar2.onStop();
            } else {
                this.mOnPlayListenerPendingEvent = 6;
            }
            com.tencent.luggage.wxa.e8.a aVar2 = this.mCustomHandler;
            if (aVar2 != null) {
                aVar2.a(getId(), 2006, (Bundle) null);
            }
        } else {
            if (str.equalsIgnoreCase("mute")) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operate, reset passive mute");
                this.mPassiveMute = false;
            }
            z16 = false;
            if (!z16) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operate " + str + ", abandonFocus");
                this.mAudioFocusComponent.a();
                return;
            }
            return;
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onRuntimeEnterBackgroundInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$onRuntimeEnterBackground$7(int i3) {
        this.isRuntimeInBackground = true;
        if (this.mAdapter != null && getPlayingWhenEnterBackground() == null) {
            boolean isPlaying = this.mAdapter.isPlaying();
            setPlayingWhenEnterBackground(new AtomicBoolean(isPlaying));
            com.tencent.luggage.wxa.tn.w.d(TAG, "onRuntimeEnterBackground, isPlayingWhenEnterBackground:%s", Boolean.valueOf(isPlaying));
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onRuntimeEnterBackground, abandonFocus");
            this.mAudioFocusComponent.a();
            if (this.mIsBackgroundPlayAudioEnabled && amIBackgroundAudioPlayer()) {
                com.tencent.luggage.wxa.tn.w.d(TAG, "onRuntimeEnterBackground, background play audio is enabled");
                return;
            }
            com.tencent.luggage.wxa.e8.a aVar = this.mCustomHandler;
            if (aVar != null && aVar.a(this, this.mInsertInvokeContext, i3)) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onRuntimeEnterBackground, should intercept enter background, return");
                return;
            }
            this.mAdapter.a();
            if (isPlaying) {
                onJSAdapterOperateDone("stop");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRuntimeEnterForegroundInternal() {
        this.isRuntimeInBackground = false;
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onRuntimeEnterForeground, mIsWebViewInBackground: %b, mPassiveMute: %b", Boolean.valueOf(this.mIsWebViewInBackground), Boolean.valueOf(this.mPassiveMute));
        if (!this.mIsWebViewInBackground && (this.mPassiveMute || !isMuted())) {
            if (this.mPassiveMute) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onRuntimeEnterForeground, passiveMute, unMute");
                unMuteIfIsMuted();
            }
            if (isPlaying()) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onRuntimeEnterForeground, isPlaying, requestFocus");
                this.mAudioFocusComponent.b();
            }
        }
        if (!this.mIsWebViewInBackground && getPlayingWhenEnterBackground() != null) {
            boolean z16 = getPlayingWhenEnterBackground().get();
            setPlayingWhenEnterBackground(null);
            if (z16) {
                com.tencent.luggage.wxa.tn.w.d(TAG, "onRuntimeEnterForeground, isPlayingWhenEnterBackground, try resume");
                com.tencent.luggage.wxa.d8.a aVar = this.mAdapter;
                if (aVar == null) {
                    com.tencent.luggage.wxa.tn.w.f(getLogTag(), "onRuntimeEnterForeground, adapter is null");
                } else {
                    aVar.enterForeground();
                }
            }
        }
    }

    private void operate(com.tencent.luggage.wxa.z7.c cVar) {
        JSONObject a16 = cVar.a();
        String optString = a16.optString("type");
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operate, type:%s", optString);
        if (w0.c(optString)) {
            cVar.a("fail:missing operateType", com.tencent.luggage.wxa.af.e.f121309e);
            return;
        }
        if (this.mAdapter == null) {
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
            return;
        }
        if (optString.equals("snapshot")) {
            operateSnapshot(cVar);
            return;
        }
        if (optString.equals(com.tencent.luggage.wxa.c8.c.f123372f0)) {
            operateSnapshotView(cVar);
            return;
        }
        if (optString.equalsIgnoreCase("requestFullScreen")) {
            operateRequestFullscreen(cVar);
            return;
        }
        if (optString.equalsIgnoreCase("exitFullScreen")) {
            operateExitFullscreen(cVar);
            return;
        }
        if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123397t0)) {
            operateExitPip(cVar);
            return;
        }
        if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123399u0)) {
            enableBackgroundPlayAudio(cVar);
            return;
        }
        if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123401v0)) {
            disableBackgroundPlayAudio(cVar);
            return;
        }
        if (shouldCastHandlerInterceptOperate(optString) && operateCastHandler(cVar, a16)) {
            cVar.a(com.tencent.luggage.wxa.af.e.f121305a);
        } else {
            com.tencent.luggage.wxa.ff.h operateLivePlayer = this.mAdapter.operateLivePlayer(optString, a16);
            cVar.a(operateLivePlayer.f126108a == 0 ? com.tencent.luggage.wxa.af.e.f121305a : com.tencent.luggage.wxa.af.e.f121309e, operateLivePlayer.f126110c);
        }
        onJSAdapterOperateDone(optString);
        if (optString.equalsIgnoreCase("stop") || optString.equalsIgnoreCase("pause")) {
            this.mPipPluginHandlerCommons.removePipId(cVar);
            if (optString.equalsIgnoreCase("stop") && this.isRuntimeInBackground) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operate, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                setPlayingWhenEnterBackground(new AtomicBoolean(false));
            }
        }
    }

    private void operateBackground(com.tencent.luggage.wxa.z7.c cVar) {
        String optString = cVar.a().optString("type");
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operateBackground, type:%s", optString);
        if (!w0.c(optString) && this.mAdapter != null) {
            if (optString.equals("stop")) {
                disableBackgroundPlayAudio(cVar);
                if (this.isRuntimeInBackground) {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operateBackground, isRuntimeInBackground, setPlayingWhenEnterBackground false");
                    setPlayingWhenEnterBackground(new AtomicBoolean(false));
                    return;
                }
                return;
            }
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
            return;
        }
        cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
    }

    private boolean operateCastHandler(@NonNull com.tencent.luggage.wxa.z7.c cVar, @NonNull JSONObject jSONObject) {
        com.tencent.luggage.wxa.b8.m mVar = this.mCastHandler;
        if (mVar == null) {
            return false;
        }
        return mVar.a(cVar, jSONObject);
    }

    private void operateExitFullscreen(com.tencent.luggage.wxa.z7.c cVar) {
        boolean z16;
        com.tencent.luggage.wxa.af.c cVar2;
        com.tencent.luggage.wxa.e8.a aVar = this.mCustomHandler;
        if (aVar != null && aVar.c(cVar)) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.tn.w.d(TAG, "operateExitFullscreen, result:%s", Boolean.valueOf(z16));
        if (z16) {
            cVar2 = com.tencent.luggage.wxa.af.e.f121305a;
        } else {
            cVar2 = com.tencent.luggage.wxa.af.e.f121309e;
        }
        cVar.a(cVar2);
    }

    private void operateExitPip(com.tencent.luggage.wxa.z7.c cVar) {
        this.mPipPluginHandlerCommons.exitPip(cVar);
    }

    private void operateRequestFullscreen(com.tencent.luggage.wxa.z7.c cVar) {
        boolean z16;
        com.tencent.luggage.wxa.af.c cVar2;
        com.tencent.luggage.wxa.e8.a aVar = this.mCustomHandler;
        if (aVar != null && aVar.b(cVar)) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.tn.w.d(TAG, "operateRequestFullscreen, result:%s", Boolean.valueOf(z16));
        if (z16) {
            cVar2 = com.tencent.luggage.wxa.af.e.f121305a;
        } else {
            cVar2 = com.tencent.luggage.wxa.af.e.f121309e;
        }
        cVar.a(cVar2);
    }

    private void operateSnapshot(final com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.d8.a aVar = this.mAdapter;
        if (aVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "operateSnapshot, adapter is null");
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
            return;
        }
        aVar.setSnapshotListener(new TXLivePlayer.ITXSnapshotListener() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler.5
            @Override // com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener
            public void onSnapshot(Bitmap bitmap) {
                if (cVar == null) {
                    com.tencent.luggage.wxa.tn.w.b(LivePlayerPluginHandler.TAG, "operateSnapshot, invokeContext is null");
                } else if (LivePlayerPluginHandler.this.mCustomHandler != null) {
                    LivePlayerPluginHandler.this.mCustomHandler.a(cVar, bitmap);
                }
            }
        });
        com.tencent.luggage.wxa.ff.h operateLivePlayer = this.mAdapter.operateLivePlayer("snapshot", cVar.a());
        if (operateLivePlayer.f126108a != 0) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operateSnapshot, fail:%s", Integer.valueOf(operateLivePlayer.f126108a));
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e, operateLivePlayer.f126110c);
        } else {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operateSnapshot, success");
        }
    }

    private void operateSnapshotView(@NonNull com.tencent.luggage.wxa.z7.c cVar) {
        if (this.mAdapter == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "operateSnapshotView, adapter is null");
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
        } else {
            takeScreenshot(cVar);
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operateSnapshotView, success");
        }
    }

    private void parseHtmlPosition(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject.has("position") && (optJSONObject = jSONObject.optJSONObject("position")) != null) {
            this.mHtmlWidth = com.tencent.luggage.wxa.tk.g.a(optJSONObject.optInt("width", 0));
            this.mHtmlHeight = com.tencent.luggage.wxa.tk.g.a(optJSONObject.optInt("height", 0));
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "parseHtmlPosition, size:[%d, %d]", Integer.valueOf(this.mHtmlWidth), Integer.valueOf(this.mHtmlHeight));
            adjustHtmlSize();
        }
    }

    private void parseShouldNotifyEvent(com.tencent.luggage.wxa.z7.c cVar, JSONObject jSONObject) {
        if (jSONObject.has("needEvent")) {
            this.mShouldNotifyEvent = jSONObject.optBoolean("needEvent", false);
            if (shouldNotifyEvent()) {
                this.mEventHandler.a(cVar);
            }
        }
    }

    private void preventAutoPlayInBackground(@NonNull JSONObject jSONObject) {
        if (this.mIsWebViewInBackground && !amIPipPlayer()) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "insert, webView in background");
            try {
                jSONObject.put(V2TXJSAdapterConstants.PLAYER_KEY_CAN_AUTO_PLAY, false);
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.f(getLogTag(), "insert, put isInForeground fail since " + e16.toString());
            }
            setPlayingWhenEnterBackground(new AtomicBoolean(jSONObject.optBoolean("autoplay", false)));
        }
    }

    private void registerAddOnGetSnapshot() {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "registerAddOnGetSnapshot");
        setAddOn(com.tencent.luggage.wxa.a8.l.class, new com.tencent.luggage.wxa.a8.l() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler.14
            public void getSnapshotAsync(@NonNull com.tencent.luggage.wxa.a8.g gVar) {
                LivePlayerPluginHandler.this.getSnapshotAsync(gVar);
            }

            @Override // com.tencent.luggage.wxa.a8.l
            @Nullable
            public Bitmap getSnapshotCached() {
                return LivePlayerPluginHandler.this.mCachedVideoSnapshot;
            }
        });
    }

    private void registerAddOnInfo() {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "registerAddOnInfo");
        setAddOn(com.tencent.luggage.wxa.a8.m.class, new com.tencent.luggage.wxa.a8.m() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler.11
            @Nullable
            public String getPosterPath() {
                com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), "getPosterPath, posterPath: " + LivePlayerPluginHandler.this.mBackgroundPosterPath);
                return LivePlayerPluginHandler.this.mBackgroundPosterPath;
            }

            @Nullable
            public String getTitle() {
                com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), "getTitle, title: " + LivePlayerPluginHandler.this.mTitle);
                return LivePlayerPluginHandler.this.mTitle;
            }
        });
    }

    private void registerAddOnPlayAudio() {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "registerAddOnPlayAudio");
        setAddOn(com.tencent.luggage.wxa.a8.n.class, new AnonymousClass9());
    }

    private void registerAddOnVideoController() {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "registerAddOnVideoController");
        setAddOn(com.tencent.luggage.wxa.a8.o.class, new com.tencent.luggage.wxa.a8.o() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler.10
            @Override // com.tencent.luggage.wxa.a8.o
            public boolean isPlaying() {
                return LivePlayerPluginHandler.this.isPlaying();
            }

            @Override // com.tencent.luggage.wxa.a8.o
            public void onBackgroundPlaybackChange(boolean z16) {
                com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.TAG, "onBackgroundPlaybackChange playInBackground:%b", Boolean.valueOf(z16));
                if (LivePlayerPluginHandler.this.mEventHandler != null) {
                    LivePlayerPluginHandler.this.mEventHandler.a(LivePlayerPluginHandler.this.getId(), z16);
                }
            }

            @Override // com.tencent.luggage.wxa.a8.o
            public void pause() {
                com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), "pause");
                LivePlayerPluginHandler.this.stopExternal();
            }

            @Override // com.tencent.luggage.wxa.a8.o
            public void start() {
                com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), "start");
                LivePlayerPluginHandler.this.playExternal();
            }
        });
    }

    private void registerLifecycleListener(com.tencent.luggage.wxa.z7.c cVar) {
        c.a aVar = new c.a() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler.4
            @Override // com.tencent.luggage.wxa.z7.c.a
            public void onBackground(int i3) {
                com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), "onBackground, type: " + i3);
                LivePlayerPluginHandler.this.handleWebViewBackground(i3);
            }

            @Override // com.tencent.luggage.wxa.z7.c.a
            public void onDestroy() {
                LivePlayerPluginHandler.this.handleWebViewDestroy();
            }

            @Override // com.tencent.luggage.wxa.z7.c.a
            public void onForeground() {
                com.tencent.luggage.wxa.tn.w.d(LivePlayerPluginHandler.this.getLogTag(), "onForeground");
                LivePlayerPluginHandler.this.handleWebViewForeground();
            }
        };
        this.mLifecycleListener = aVar;
        cVar.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        com.tencent.luggage.wxa.zp.h.f146825d.a(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.n
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.lambda$release$8();
            }
        });
        com.tencent.luggage.wxa.e8.a aVar = this.mCustomHandler;
        if (aVar != null) {
            aVar.d(this.mInsertInvokeContext);
        }
        com.tencent.luggage.wxa.d8.a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.uninitLivePlayer();
            this.mAdapter = null;
        }
        releaseCastHandler();
        clearSurface();
        unregisterLifecycleListener();
        releaseThreadHandler();
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "release, abandonFocus");
        this.mAudioFocusComponent.a();
        unregisterMySelf();
    }

    private void releaseCastHandler() {
        com.tencent.luggage.wxa.b8.m mVar = this.mCastHandler;
        this.mCastHandler = null;
        if (mVar != null) {
            mVar.n();
        }
    }

    private void releaseThreadHandler() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "LivePlayer release handler thread");
        this.mLivePlayerHandler.a((Object) null);
        this.mLivePlayerThread.a();
    }

    private void remove(com.tencent.luggage.wxa.z7.c cVar) {
        release();
        cVar.a(com.tencent.luggage.wxa.af.e.f121305a);
    }

    private void reportJsapiCall(int i3) {
        com.tencent.luggage.wxa.e8.c cVar = this.mReportHandler;
        if (cVar != null) {
            cVar.a(i3, 1L, false);
        }
    }

    private void requestAppEnterBackground() {
        com.tencent.luggage.wxa.kj.v vVar;
        com.tencent.luggage.wxa.z7.c cVar = this.mInsertInvokeContext;
        if (cVar instanceof AppBrandInvokeContext) {
            com.tencent.luggage.wxa.xd.d e16 = cVar.e();
            if (e16 instanceof com.tencent.luggage.wxa.kj.v) {
                vVar = (com.tencent.luggage.wxa.kj.v) e16;
            } else if (e16 instanceof com.tencent.luggage.wxa.ic.l) {
                vVar = ((com.tencent.luggage.wxa.ic.l) e16).J();
            } else {
                vVar = null;
            }
            if (vVar != null) {
                com.tencent.luggage.wxa.ic.g runtime = vVar.getRuntime();
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "requestAppEnterBackground close runtime");
                runtime.o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnLivePlayerThread(@NonNull Runnable runnable) {
        this.mLivePlayerHandler.a(runnable);
    }

    public static void setCastHandlerFactory(@NonNull com.tencent.luggage.wxa.b8.h hVar) {
        sCastHandlerFactory = hVar;
    }

    private boolean shouldCastHandlerInterceptOperate(@NonNull String str) {
        com.tencent.luggage.wxa.b8.m mVar = this.mCastHandler;
        if (mVar == null) {
            return false;
        }
        if (!"startCasting".equalsIgnoreCase(str) && com.tencent.luggage.wxa.b8.b.CastDeviceSelected != mVar.l()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldNotifyEvent() {
        if (this.mEventHandler != null) {
            return true;
        }
        return false;
    }

    private void takeScreenshot(@NonNull com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "takeScreenshot");
        this.mSnapshotInvokeContext = cVar;
        com.tencent.luggage.wxa.z7.f.a(getPluginClientProxy(), getType(), getId());
    }

    private void toggleCastEnableStateIfNeed(@NonNull com.tencent.luggage.wxa.z7.c cVar, @NonNull JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("enableCasting", this.mIsCastEnabled);
        this.mIsCastEnabled = optBoolean;
        com.tencent.luggage.wxa.b8.m mVar = this.mCastHandler;
        if (optBoolean && mVar == null) {
            mVar = sCastHandlerFactory.a(getId(), cVar);
            this.mCastHandler = mVar;
        }
        if (mVar != null) {
            mVar.c(optBoolean);
            mVar.a(this.mPlayerUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryCacheSnapshotBeforePlayAudio(@NonNull final Runnable runnable) {
        getSnapshotAsync(new com.tencent.luggage.wxa.a8.g() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler.13
            @Override // com.tencent.luggage.wxa.a8.g
            public void onSnapshotGot(@Nullable Bitmap bitmap) {
                LivePlayerPluginHandler.this.mCachedVideoSnapshot = bitmap;
                runnable.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unMuteIfIsMuted() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "unMuteIfIsMuted");
        if (!isMuted()) {
            return;
        }
        operate("mute");
    }

    private void unregisterAddOnGetSnapshot() {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "unregisterAddOnGetSnapshot");
        setAddOn(com.tencent.luggage.wxa.a8.l.class, null);
    }

    private void unregisterAddOnInfo() {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "unregisterAddOnInfo");
        setAddOn(com.tencent.luggage.wxa.a8.m.class, null);
    }

    private void unregisterAddOnPlayAudio() {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "unregisterAddOnPlayAudio");
        setAddOn(com.tencent.luggage.wxa.a8.n.class, null);
    }

    private void unregisterAddOnVideoController() {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "registerAddOnVideoController");
        setAddOn(com.tencent.luggage.wxa.a8.o.class, null);
    }

    private void unregisterLifecycleListener() {
        com.tencent.luggage.wxa.z7.c cVar = this.mInsertInvokeContext;
        if (cVar != null) {
            cVar.d();
            this.mLifecycleListener = null;
        }
    }

    private void update(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.af.c cVar2;
        com.tencent.luggage.wxa.e8.a aVar;
        JSONObject a16 = cVar.a();
        if (a16.has("autoPauseIfNavigate")) {
            this.mAutoPauseIfNavigate = a16.optBoolean("autoPauseIfNavigate", true);
        }
        if (a16.has("autoPauseIfOpenNative")) {
            this.mAutoPauseIfOpenNative = a16.optBoolean("autoPauseIfOpenNative", true);
        }
        com.tencent.luggage.wxa.e8.a aVar2 = this.mCustomHandler;
        if (aVar2 != null) {
            aVar2.a(cVar);
        }
        parseShouldNotifyEvent(cVar, a16);
        parseHtmlPosition(a16);
        this.mTitle = a16.optString("title", this.mTitle);
        this.mBackgroundPosterPath = a16.optString(com.tencent.luggage.wxa.c8.c.f123407y0, this.mBackgroundPosterPath);
        preventAutoPlayInBackground(a16);
        toggleCastEnableStateIfNeed(cVar, a16);
        if (this.mAdapter == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "update, adapter is null");
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
            return;
        }
        Bundle a17 = com.tencent.luggage.wxa.c8.d.a(a16);
        com.tencent.luggage.wxa.ff.h updateLivePlayer = this.mAdapter.updateLivePlayer(a17);
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "update, code:%d info:%s", Integer.valueOf(updateLivePlayer.f126108a), updateLivePlayer.f126109b);
        if (updateLivePlayer.f126108a == 0) {
            cVar2 = com.tencent.luggage.wxa.af.e.f121305a;
        } else {
            cVar2 = com.tencent.luggage.wxa.af.e.f121309e;
        }
        cVar.a(cVar2, updateLivePlayer.f126110c);
        if (updateLivePlayer.f126108a == 0 && (aVar = this.mCustomHandler) != null) {
            aVar.a(cVar, a17);
        }
    }

    private void updateReferrers(@NonNull com.tencent.luggage.wxa.z7.c cVar, @NonNull JSONObject jSONObject) {
        com.tencent.luggage.wxa.xd.d e16 = cVar.e();
        if (e16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "updateReferrers, component is null");
            return;
        }
        com.tencent.luggage.wxa.cg.a aVar = (com.tencent.luggage.wxa.cg.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.cg.a.class);
        if (aVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "updateReferrers, referrerHelper is null");
            return;
        }
        if (this.mReferrerPolicy == null) {
            this.mReferrerPolicy = aVar.s();
        }
        com.tencent.luggage.wxa.cg.c a16 = aVar.a(jSONObject, e16);
        if (a16 != null) {
            this.mReferrerPolicy = a16;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "updateReferrers, mReferrerPolicy: " + this.mReferrerPolicy);
        if (com.tencent.luggage.wxa.cg.c.NO_REFERRER == this.mReferrerPolicy) {
            this.mReferrer = null;
            return;
        }
        this.mReferrer = aVar.c(e16);
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "updateReferrers, mReferrer: " + this.mReferrer);
    }

    public void forceStop() {
        runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.m
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.lambda$forceStop$9();
            }
        });
    }

    @Nullable
    public com.tencent.luggage.wxa.d8.a getAdapter() {
        return this.mAdapter;
    }

    @Override // com.tencent.luggage.wxa.a8.j
    @Nullable
    public <AddOn extends com.tencent.luggage.wxa.a8.k> AddOn getAddOn(@NonNull Class<AddOn> cls) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "getAddOn for " + cls.getSimpleName());
        return (AddOn) this.mVideoPlayerDelegate.getAddOn(cls);
    }

    @Override // com.tencent.luggage.wxa.a8.p
    public String getComponentKey() {
        return String.format("%s_%s", getType(), Integer.valueOf(getId()));
    }

    public int getHtmlHeight() {
        return this.mHtmlHeight;
    }

    public int getHtmlWidth() {
        return this.mHtmlWidth;
    }

    public String getKey() {
        return key() + "@" + hashCode();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // com.tencent.luggage.wxa.a8.j
    @NonNull
    public String getName() {
        return getKey();
    }

    @Nullable
    public Integer getOriginPageViewId() {
        com.tencent.luggage.wxa.z7.c cVar = this.mInsertInvokeContext;
        if (cVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "getOriginPageViewId, invokeContext is null");
            return null;
        }
        com.tencent.luggage.wxa.kj.v pageView = com.tencent.luggage.wxa.a8.b.getPageView(cVar);
        if (pageView == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "getOriginPageViewId, pageView is null");
            return null;
        }
        return Integer.valueOf(pageView.hashCode());
    }

    public AtomicBoolean getPlayingWhenEnterBackground() {
        return this.isPlayingWhenEnterBackground;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    @Nullable
    public SurfaceTexture getSurfaceTexture() {
        return null;
    }

    public int getVideoPositionX() {
        return this.mPosX;
    }

    public int getVideoPositionY() {
        return this.mPosY;
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public String handleJsApi(final com.tencent.luggage.wxa.z7.c cVar) {
        runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.o
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.lambda$handleJsApi$4(cVar);
            }
        });
        return null;
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginDestroy() {
        this.mSurfaceTexture = null;
        runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.g
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.handlePluginDestroyInternal();
            }
        });
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public void handlePluginReady(SurfaceTexture surfaceTexture) {
        handlePluginReadyForGPUProcess(new Surface(surfaceTexture));
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginReadyForGPUProcess(final Surface surface) {
        super.handlePluginReadyForGPUProcess(surface);
        runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.d
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.lambda$handlePluginReadyForGPUProcess$3(surface);
            }
        });
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginScreenshotTaken(@Nullable Bitmap bitmap) {
        super.handlePluginScreenshotTaken(bitmap);
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handlePluginScreenshotTaken", key());
        handlePluginScreenshotTaken4JsApiCall(bitmap);
    }

    public void initPluginHandler(com.tencent.luggage.wxa.e8.a aVar) {
        this.mCustomHandler = aVar;
        if (aVar != null) {
            this.mEventHandler = aVar.b();
            this.mReportHandler = this.mCustomHandler.a();
            this.mCustomHandler.a(this);
        }
    }

    public boolean isAutoPauseIfNavigate() {
        return this.mAutoPauseIfNavigate;
    }

    public boolean isAutoPauseIfOpenNative() {
        return this.mAutoPauseIfOpenNative;
    }

    public boolean isBackgroundPlayAudioEnabled() {
        return this.mIsBackgroundPlayAudioEnabled;
    }

    public boolean isJustPlayAudio() {
        return this.mJustPlayAudio.get();
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public boolean isPluginReady(com.tencent.luggage.wxa.z7.c cVar) {
        return true;
    }

    public void onRuntimeEnterBackground(final int i3) {
        runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.l
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.lambda$onRuntimeEnterBackground$7(i3);
            }
        });
    }

    public void onRuntimeEnterForeground() {
        runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.q
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.onRuntimeEnterForegroundInternal();
            }
        });
    }

    public void playExternal() {
        com.tencent.luggage.wxa.d8.a aVar = this.mAdapter;
        if (aVar != null && !aVar.isPlaying()) {
            operate("play");
        }
    }

    public void releaseExternal() {
        runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.k
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.release();
            }
        });
    }

    @Override // com.tencent.luggage.wxa.a8.j
    public <AddOn extends com.tencent.luggage.wxa.a8.k> void setAddOn(@NonNull Class<AddOn> cls, @Nullable AddOn addon) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "setAddOn for " + cls.getSimpleName());
        this.mVideoPlayerDelegate.setAddOn(cls, addon);
    }

    public void setOnPlayListener(@Nullable x xVar) {
        this.mOnPlayListener = xVar;
        if (xVar != null) {
            y.a(this.mOnPlayListenerPendingEvent, xVar);
        }
    }

    public void setPlayingWhenEnterBackground(AtomicBoolean atomicBoolean) {
        this.isPlayingWhenEnterBackground = atomicBoolean;
    }

    public boolean setSurface(@Nullable Surface surface) {
        if (this.mAdapter != null) {
            if (!this.mJustPlayAudio.get()) {
                this.mAdapter.setSurface(surface);
                return true;
            }
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "setSurface, JustPlayAudio");
            return true;
        }
        com.tencent.luggage.wxa.tn.w.f(getLogTag(), "setSurface, Adapter is null");
        return false;
    }

    public boolean setSurfaceSize(int i3, int i16) {
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "setSurfaceSize, width: %d, height: %d", Integer.valueOf(i3), Integer.valueOf(i16));
        if (i3 != 0 && i16 != 0 && this.mAdapter != null) {
            if (!this.mJustPlayAudio.get()) {
                this.mAdapter.setSurfaceSize(i3, i16);
            } else {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "setSurfaceSize, JustPlayAudio");
            }
            return true;
        }
        com.tencent.luggage.wxa.tn.w.f(getLogTag(), "setSurfaceSize, Adapter is null");
        return false;
    }

    public boolean startIfForeground() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "startIfForeground");
        if (!this.mIsWebViewInBackground && !this.isRuntimeInBackground) {
            runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.c
                @Override // java.lang.Runnable
                public final void run() {
                    LivePlayerPluginHandler.this.lambda$startIfForeground$10();
                }
            });
            return true;
        }
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "startIfForeground, not in foregound");
        return false;
    }

    public void stopExternal() {
        operate("stop");
    }

    public void updateVideoPosition(@NonNull JSONObject jSONObject) {
        this.mPosX = com.tencent.luggage.wxa.tk.g.a(jSONObject.optInt(HippyTKDListViewAdapter.X, this.mPosX));
        this.mPosY = com.tencent.luggage.wxa.tk.g.a(jSONObject.optInt("y", this.mPosY));
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "updateVideoPosition, mPosX: %d, mPosY: %d", Integer.valueOf(this.mPosX), Integer.valueOf(this.mPosY));
    }

    private void operate(String str) {
        operate(str, null);
    }

    private void operate(final String str, @Nullable final Runnable runnable) {
        runOnLivePlayerThread(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.f
            @Override // java.lang.Runnable
            public final void run() {
                LivePlayerPluginHandler.this.lambda$operate$11(str, runnable);
            }
        });
    }
}
