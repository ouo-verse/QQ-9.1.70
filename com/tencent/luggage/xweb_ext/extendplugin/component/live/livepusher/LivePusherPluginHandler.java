package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Size;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.math.MathUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.luggage.wxa.a8.h;
import com.tencent.luggage.wxa.ag.j;
import com.tencent.luggage.wxa.g8.a;
import com.tencent.luggage.wxa.h8.e;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.h0;
import com.tencent.luggage.wxa.z7.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class LivePusherPluginHandler extends com.tencent.luggage.wxa.k8.a implements com.tencent.luggage.wxa.a8.p, LifecycleOwner {
    private static final int MAX_REQUEST_PERMISSION_COUNT = 5;
    public static final String TAG = "MicroMsg.SameLayer.LivePusherPluginHandler";
    private com.tencent.luggage.wxa.f8.m mAdapter;
    private com.tencent.luggage.wxa.g8.a mCustomHandler;
    private com.tencent.luggage.wxa.g8.b mEventHandler;
    private String mFilterImageMd5;
    private boolean mFocusWhenTouch;
    private int mHtmlHeight;
    private int mHtmlWidth;
    private com.tencent.luggage.wxa.z7.c mInsertInvokeContext;
    private c.a mLifecycleListener;

    @NonNull
    private final com.tencent.luggage.wxa.dq.a mLivePusherHandler;

    @NonNull
    private final com.tencent.luggage.wxa.a8.h mLivePusherThread;
    private Handler mMainHandler;
    private h0 mOrientationListenerHelper;
    private com.tencent.luggage.wxa.g8.c mReportHandler;
    private ScaleGestureDetector mScaleGestureDetector;
    private boolean mShouldNotifyEvent;
    private Surface mSurface;
    private volatile SurfaceTexture mSurfaceTexture;

    @NonNull
    private final com.tencent.luggage.wxa.h8.e mVideoCustomRenderProcessor;
    private boolean mZoomWhenScale;
    private int requestPermissionCount;

    @NonNull
    private static e.a sVideoCustomRenderProcessorFactory = com.tencent.luggage.wxa.h8.a.INSTANCE;
    private static boolean sEnableZoomOpt = true;

    @NonNull
    private static h.a sThreadProvider = com.tencent.luggage.wxa.a8.t.a(com.tencent.luggage.wxa.a8.u.LivePusher);
    private volatile int mSetSurfaceTextureWidth = -1;
    private volatile int mSetSurfaceTextureHeight = -1;
    private String mFilterImage = "";
    private TouchFocusRunnable mTouchFocusRunnable = new TouchFocusRunnable();
    private int mLastAngle = 0;
    private CheckRotateTask mCheckRotateTask = new CheckRotateTask();

    @NonNull
    private final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
    private volatile boolean mHasReleased = false;
    private boolean mHadPauseFromExternal = false;

    @Nullable
    private volatile com.tencent.luggage.wxa.z7.c mSnapshotInvokeContext = null;
    private final ScaleGestureDetector.OnScaleGestureListener mScaleGestureListenerV1 = new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.15
        private int mCurrentScale = 1;

        /* JADX WARN: Code restructure failed: missing block: B:34:0x003e, code lost:
        
            if (r8 >= 0.9f) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x0029, code lost:
        
            if (r8 <= 1.1f) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x002b, code lost:
        
            r8 = r3;
         */
        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float f16;
            int maxZoom = LivePusherPluginHandler.this.mAdapter.getMaxZoom();
            if (maxZoom > 0) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (scaleFactor > 1.0f) {
                    scaleFactor = ((0.2f / maxZoom) * (maxZoom - this.mCurrentScale)) + 1.0f;
                    f16 = 1.1f;
                } else {
                    if (scaleFactor < 1.0f) {
                        scaleFactor = 1.0f - ((0.2f / maxZoom) * this.mCurrentScale);
                        f16 = 0.9f;
                    }
                    int round = Math.round(this.mCurrentScale * scaleFactor);
                    int i3 = this.mCurrentScale;
                    if (round == i3) {
                        if (scaleFactor > 1.0f) {
                            round++;
                        } else if (scaleFactor < 1.0f) {
                            round--;
                        }
                    }
                    if (round >= maxZoom) {
                        round = maxZoom;
                    }
                    if (round <= 1) {
                        round = 1;
                    }
                    if (scaleFactor <= 1.0f ? scaleFactor >= 1.0f || round <= i3 : round >= i3) {
                        i3 = round;
                    }
                    this.mCurrentScale = i3;
                    if (LivePusherPluginHandler.this.mAdapter != null) {
                        com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "onScale, maxZoom:%s, current scale:%s", Integer.valueOf(maxZoom), Integer.valueOf(this.mCurrentScale));
                        LivePusherPluginHandler.this.mAdapter.setZoom(this.mCurrentScale);
                        LivePusherPluginHandler.this.mVideoCustomRenderProcessor.b().a(i3);
                    }
                }
            }
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    };
    private final ScaleGestureDetector.OnScaleGestureListener mScaleGestureListenerV2 = new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.16
        private float mLastScaleFactor;
        private float mScaleFactor;

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            int maxZoom = LivePusherPluginHandler.this.mAdapter.getMaxZoom();
            if (maxZoom <= 0) {
                return false;
            }
            float scaleFactor = scaleGestureDetector.getScaleFactor() - this.mLastScaleFactor;
            this.mLastScaleFactor = scaleGestureDetector.getScaleFactor();
            this.mScaleFactor = MathUtils.clamp(this.mScaleFactor + scaleFactor, 0.0f, 1.0f);
            if (LivePusherPluginHandler.this.mAdapter != null) {
                int i3 = (int) (this.mScaleFactor * maxZoom);
                com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "onScale, maxZoom: %d, scaleFactor: %f, scale: %d", Integer.valueOf(maxZoom), Float.valueOf(this.mScaleFactor), Integer.valueOf(i3));
                LivePusherPluginHandler.this.mAdapter.setZoom(i3);
                LivePusherPluginHandler.this.mVideoCustomRenderProcessor.b().a(i3);
            }
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.mLastScaleFactor = scaleGestureDetector.getScaleFactor();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    };
    private volatile boolean mIsWebViewInBackground = false;

    @NonNull
    private String mPusherUrl = "";
    private int mPosX = 0;
    private int mPosY = 0;
    private final com.tencent.luggage.wxa.a8.b mPipPluginHandlerCommons = new com.tencent.luggage.wxa.a8.b() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.17
        private com.tencent.luggage.wxa.f8.r mPipInfoProvider = null;

        @Override // com.tencent.luggage.wxa.a8.b
        public int getId() {
            return LivePusherPluginHandler.this.getId();
        }

        @Override // com.tencent.luggage.wxa.a8.b
        @NonNull
        public String getKey() {
            return LivePusherPluginHandler.this.getKey();
        }

        @Override // com.tencent.luggage.wxa.a8.b
        @NonNull
        public String getLogTag() {
            return LivePusherPluginHandler.this.getLogTag();
        }

        @Override // com.tencent.luggage.wxa.a8.b
        @NonNull
        public j.b getType() {
            return j.b.LivePusher;
        }

        @Override // com.tencent.luggage.wxa.a8.b
        @NonNull
        public com.tencent.luggage.wxa.f8.r getPipInfoProvider() {
            if (this.mPipInfoProvider == null) {
                this.mPipInfoProvider = new com.tencent.luggage.wxa.f8.r(LivePusherPluginHandler.this);
            }
            return this.mPipInfoProvider;
        }
    };

    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler$10, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass10 implements a.b {
        public AnonymousClass10() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoad$0(String str) {
            if (LivePusherPluginHandler.this.mAdapter != null) {
                Bundle bundle = new Bundle();
                bundle.putString(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, str);
                LivePusherPluginHandler.this.mAdapter.updateLivePusher(bundle);
            }
        }

        @Override // com.tencent.luggage.wxa.g8.a.b
        public void onLoad(String str, String str2) {
            if (!w0.c(str2)) {
                final String a16 = com.tencent.luggage.wxa.y8.i.a(str2, false);
                com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "convertFilterImageToLocalPath, targetPath:%s", a16);
                LivePusherPluginHandler.this.runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivePusherPluginHandler.AnonymousClass10.this.lambda$onLoad$0(a16);
                    }
                });
            } else {
                com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "convertFilterImageToLocalPath, load filter image fail");
                if (LivePusherPluginHandler.this.mEventHandler != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("url", str);
                    LivePusherPluginHandler.this.mEventHandler.a(LivePusherPluginHandler.this.getId(), com.tencent.luggage.wxa.af.g.f121349r, 10005, "load filter image fail", hashMap);
                }
            }
        }
    }

    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler$12, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass12 implements a.b {
        final /* synthetic */ JSONObject val$param;

        public AnonymousClass12(JSONObject jSONObject) {
            this.val$param = jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoad$0(JSONObject jSONObject, String str) {
            if (LivePusherPluginHandler.this.mAdapter != null && LivePusherPluginHandler.this.mAdapter.operateLivePusher(com.tencent.luggage.wxa.c8.c.f123373g0, jSONObject).f126108a != 0) {
                com.tencent.luggage.wxa.tn.w.b(LivePusherPluginHandler.TAG, "operatePlayBgm, play bgm fail, url:%s", str);
                if (LivePusherPluginHandler.this.mEventHandler != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("url", str);
                    LivePusherPluginHandler.this.mEventHandler.a(LivePusherPluginHandler.this.getId(), com.tencent.luggage.wxa.af.g.f121349r, 10003, "play bgm fail", hashMap);
                }
            }
        }

        @Override // com.tencent.luggage.wxa.g8.a.b
        public void onLoad(final String str, String str2) {
            if (!w0.c(str2)) {
                com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "operatePlayBgm, local file path:%s", str2);
                try {
                    this.val$param.put("BGMFilePath", str2);
                } catch (JSONException e16) {
                    com.tencent.luggage.wxa.tn.w.b(LivePusherPluginHandler.TAG, "operatePlayBgm, set param fail", e16);
                }
                LivePusherPluginHandler livePusherPluginHandler = LivePusherPluginHandler.this;
                final JSONObject jSONObject = this.val$param;
                livePusherPluginHandler.runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivePusherPluginHandler.AnonymousClass12.this.lambda$onLoad$0(jSONObject, str);
                    }
                });
                return;
            }
            com.tencent.luggage.wxa.tn.w.b(LivePusherPluginHandler.TAG, "operatePlayBgm, download file fail, url:%s", str);
            if (LivePusherPluginHandler.this.mEventHandler != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("url", str);
                LivePusherPluginHandler.this.mEventHandler.a(LivePusherPluginHandler.this.getId(), com.tencent.luggage.wxa.af.g.f121349r, 10003, "download file fail", hashMap);
            }
        }
    }

    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler$18, reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass18 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mm$plugin$appbrand$utils$OrientationListenerHelper$Orientation;

        static {
            int[] iArr = new int[h0.a.values().length];
            $SwitchMap$com$tencent$mm$plugin$appbrand$utils$OrientationListenerHelper$Orientation = iArr;
            try {
                iArr[h0.a.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mm$plugin$appbrand$utils$OrientationListenerHelper$Orientation[h0.a.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$mm$plugin$appbrand$utils$OrientationListenerHelper$Orientation[h0.a.REVERSE_PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$mm$plugin$appbrand$utils$OrientationListenerHelper$Orientation[h0.a.REVERSE_LANDSCAPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler$6, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass6 implements a.InterfaceC6237a {
        final /* synthetic */ JSONObject val$data;
        final /* synthetic */ com.tencent.luggage.wxa.z7.c val$invokeContext;
        final /* synthetic */ String val$type;

        public AnonymousClass6(JSONObject jSONObject, com.tencent.luggage.wxa.z7.c cVar, String str) {
            this.val$data = jSONObject;
            this.val$invokeContext = cVar;
            this.val$type = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoad$0(String str, JSONObject jSONObject, com.tencent.luggage.wxa.z7.c cVar) {
            com.tencent.luggage.wxa.af.c cVar2;
            if (LivePusherPluginHandler.this.mAdapter == null) {
                com.tencent.luggage.wxa.tn.w.f(LivePusherPluginHandler.this.getLogTag(), "convertResourcePathAndOperateLivePusher#onLoad, adapter is null");
                return;
            }
            com.tencent.luggage.wxa.ff.h operateLivePusher = LivePusherPluginHandler.this.mAdapter.operateLivePusher(str, jSONObject);
            com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "convertResourcePathAndOperateLivePusher#onLoad, type:%s, error:[%s, %s]", str, Integer.valueOf(operateLivePusher.f126108a), operateLivePusher.f126109b);
            if (operateLivePusher.f126108a == 0) {
                cVar2 = com.tencent.luggage.wxa.af.e.f121305a;
            } else {
                cVar2 = com.tencent.luggage.wxa.af.e.f121309e;
            }
            cVar.a(cVar2, operateLivePusher.f126110c);
        }

        @Override // com.tencent.luggage.wxa.g8.a.b
        public void onLoad(String str, String str2) {
            com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "convertResourcePathAndOperateLivePusher#onLoad, path: %s, localPath: %s", str, str2);
            try {
                this.val$data.put("path", str2);
                LivePusherPluginHandler livePusherPluginHandler = LivePusherPluginHandler.this;
                final String str3 = this.val$type;
                final JSONObject jSONObject = this.val$data;
                final com.tencent.luggage.wxa.z7.c cVar = this.val$invokeContext;
                livePusherPluginHandler.runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivePusherPluginHandler.AnonymousClass6.this.lambda$onLoad$0(str3, jSONObject, cVar);
                    }
                });
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.f(LivePusherPluginHandler.this.getLogTag(), "convertResourcePathAndOperateLivePusher#onLoad, put fail since " + e16);
                this.val$invokeContext.a(com.tencent.luggage.wxa.af.e.f121309e);
            }
        }

        @Override // com.tencent.luggage.wxa.g8.a.InterfaceC6237a
        public void onLoadFailure(String str) {
            com.tencent.luggage.wxa.tn.w.f(LivePusherPluginHandler.this.getLogTag(), "convertResourcePathAndOperateLivePusher#onLoadFailure");
        }
    }

    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler$7, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass7 implements a.InterfaceC6237a {
        final /* synthetic */ int val$curIndex;
        final /* synthetic */ JSONObject val$data;
        final /* synthetic */ com.tencent.luggage.wxa.z7.c val$invokeContext;
        final /* synthetic */ CountHolder val$pendingConvertCountHolder;
        final /* synthetic */ JSONObject val$stickerJsonObj;

        public AnonymousClass7(int i3, JSONObject jSONObject, com.tencent.luggage.wxa.z7.c cVar, CountHolder countHolder, JSONObject jSONObject2) {
            this.val$curIndex = i3;
            this.val$stickerJsonObj = jSONObject;
            this.val$invokeContext = cVar;
            this.val$pendingConvertCountHolder = countHolder;
            this.val$data = jSONObject2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoad$0(int i3, JSONObject jSONObject, com.tencent.luggage.wxa.z7.c cVar) {
            com.tencent.luggage.wxa.af.c cVar2;
            if (LivePusherPluginHandler.this.mAdapter == null) {
                com.tencent.luggage.wxa.tn.w.h(LivePusherPluginHandler.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, adapter is null", Integer.valueOf(i3));
                return;
            }
            com.tencent.luggage.wxa.ff.h operateLivePusher = LivePusherPluginHandler.this.mAdapter.operateLivePusher(com.tencent.luggage.wxa.c8.c.f123392r, jSONObject);
            com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, type:applySticker, error:[%s, %s]", Integer.valueOf(i3), Integer.valueOf(operateLivePusher.f126108a), operateLivePusher.f126109b);
            if (operateLivePusher.f126108a == 0) {
                cVar2 = com.tencent.luggage.wxa.af.e.f121305a;
            } else {
                cVar2 = com.tencent.luggage.wxa.af.e.f121309e;
            }
            cVar.a(cVar2, operateLivePusher.f126110c);
        }

        @Override // com.tencent.luggage.wxa.g8.a.b
        public void onLoad(String str, String str2) {
            com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, path: %s, localPath: %s", Integer.valueOf(this.val$curIndex), str, str2);
            try {
                this.val$stickerJsonObj.put("path", str2);
                this.val$pendingConvertCountHolder.count--;
                com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, pendingConvertCount: %d", Integer.valueOf(this.val$curIndex), Integer.valueOf(this.val$pendingConvertCountHolder.count));
                if (this.val$pendingConvertCountHolder.count == 0) {
                    LivePusherPluginHandler livePusherPluginHandler = LivePusherPluginHandler.this;
                    final int i3 = this.val$curIndex;
                    final JSONObject jSONObject = this.val$data;
                    final com.tencent.luggage.wxa.z7.c cVar = this.val$invokeContext;
                    livePusherPluginHandler.runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.w
                        @Override // java.lang.Runnable
                        public final void run() {
                            LivePusherPluginHandler.AnonymousClass7.this.lambda$onLoad$0(i3, jSONObject, cVar);
                        }
                    });
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.h(LivePusherPluginHandler.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, put fail since %s", Integer.valueOf(this.val$curIndex), e16);
                this.val$invokeContext.a(com.tencent.luggage.wxa.af.e.f121309e);
            }
        }

        @Override // com.tencent.luggage.wxa.g8.a.InterfaceC6237a
        public void onLoadFailure(String str) {
            com.tencent.luggage.wxa.tn.w.f(LivePusherPluginHandler.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoadFailure#" + this.val$curIndex);
        }
    }

    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler$8, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass8 implements a.InterfaceC6237a {
        final /* synthetic */ int val$curIndex;
        final /* synthetic */ JSONObject val$data;
        final /* synthetic */ com.tencent.luggage.wxa.z7.c val$invokeContext;
        final /* synthetic */ String[] val$keyArr;
        final /* synthetic */ JSONObject val$makeupJsonObj;
        final /* synthetic */ CountHolder val$pendingConvertCountHolder;

        public AnonymousClass8(int i3, JSONObject jSONObject, String[] strArr, com.tencent.luggage.wxa.z7.c cVar, CountHolder countHolder, JSONObject jSONObject2) {
            this.val$curIndex = i3;
            this.val$makeupJsonObj = jSONObject;
            this.val$keyArr = strArr;
            this.val$invokeContext = cVar;
            this.val$pendingConvertCountHolder = countHolder;
            this.val$data = jSONObject2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoad$0(int i3, JSONObject jSONObject, com.tencent.luggage.wxa.z7.c cVar) {
            com.tencent.luggage.wxa.af.c cVar2;
            if (LivePusherPluginHandler.this.mAdapter == null) {
                com.tencent.luggage.wxa.tn.w.h(LivePusherPluginHandler.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, adapter is null", Integer.valueOf(i3));
                return;
            }
            com.tencent.luggage.wxa.ff.h operateLivePusher = LivePusherPluginHandler.this.mAdapter.operateLivePusher(com.tencent.luggage.wxa.c8.c.K, jSONObject);
            com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, type:applyMakeup, error:[%s, %s]", Integer.valueOf(i3), Integer.valueOf(operateLivePusher.f126108a), operateLivePusher.f126109b);
            if (operateLivePusher.f126108a == 0) {
                cVar2 = com.tencent.luggage.wxa.af.e.f121305a;
            } else {
                cVar2 = com.tencent.luggage.wxa.af.e.f121309e;
            }
            cVar.a(cVar2, operateLivePusher.f126110c);
        }

        @Override // com.tencent.luggage.wxa.g8.a.b
        public void onLoad(String str, String str2) {
            com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, path: %s, localPath: %s", Integer.valueOf(this.val$curIndex), str, str2);
            try {
                this.val$makeupJsonObj.put(this.val$keyArr[this.val$curIndex], str2);
                this.val$pendingConvertCountHolder.count--;
                com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, pendingConvertCount: %d", Integer.valueOf(this.val$curIndex), Integer.valueOf(this.val$pendingConvertCountHolder.count));
                if (this.val$pendingConvertCountHolder.count == 0) {
                    LivePusherPluginHandler livePusherPluginHandler = LivePusherPluginHandler.this;
                    final int i3 = this.val$curIndex;
                    final JSONObject jSONObject = this.val$data;
                    final com.tencent.luggage.wxa.z7.c cVar = this.val$invokeContext;
                    livePusherPluginHandler.runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.x
                        @Override // java.lang.Runnable
                        public final void run() {
                            LivePusherPluginHandler.AnonymousClass8.this.lambda$onLoad$0(i3, jSONObject, cVar);
                        }
                    });
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.h(LivePusherPluginHandler.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, put fail since %s", Integer.valueOf(this.val$curIndex), e16);
                this.val$invokeContext.a(com.tencent.luggage.wxa.af.e.f121309e);
            }
        }

        @Override // com.tencent.luggage.wxa.g8.a.InterfaceC6237a
        public void onLoadFailure(String str) {
            com.tencent.luggage.wxa.tn.w.f(LivePusherPluginHandler.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoadFailure#" + this.val$curIndex);
        }
    }

    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler$9, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass9 implements a.b {
        public AnonymousClass9() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoad$0(String str) {
            if (LivePusherPluginHandler.this.mAdapter != null) {
                Bundle bundle = new Bundle();
                bundle.putString("backgroundImage", str);
                LivePusherPluginHandler.this.mAdapter.updateLivePusher(bundle);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoad$1() {
            Bundle bundle = new Bundle();
            bundle.putString("backgroundImage", "");
            LivePusherPluginHandler.this.mAdapter.updateLivePusher(bundle);
        }

        @Override // com.tencent.luggage.wxa.g8.a.b
        public void onLoad(String str, String str2) {
            if (!w0.c(str2)) {
                final String a16 = com.tencent.luggage.wxa.y8.i.a(str2, false);
                com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "convertBackgroundImageToLocalPath, targetPath:%s", a16);
                LivePusherPluginHandler.this.runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivePusherPluginHandler.AnonymousClass9.this.lambda$onLoad$0(a16);
                    }
                });
                return;
            }
            com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "convertBackgroundImageToLocalPath, url: %s, localPath: %s", str, str2);
            if (w0.c(str)) {
                if (str != null) {
                    LivePusherPluginHandler.this.runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.z
                        @Override // java.lang.Runnable
                        public final void run() {
                            LivePusherPluginHandler.AnonymousClass9.this.lambda$onLoad$1();
                        }
                    });
                }
            } else if (LivePusherPluginHandler.this.mEventHandler != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("url", str);
                LivePusherPluginHandler.this.mEventHandler.a(LivePusherPluginHandler.this.getId(), com.tencent.luggage.wxa.af.g.f121349r, 10004, "load background image fail", hashMap);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class CheckRotateTask implements Runnable {
        private static final int DELAY = 250;
        int number = 0;
        int senorAngle;

        public CheckRotateTask() {
        }

        public void cancel() {
            this.number = 0;
            LivePusherPluginHandler.this.mMainHandler.removeCallbacks(this);
        }

        public void post() {
            LivePusherPluginHandler.this.mMainHandler.postDelayed(this, 250L);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3 = this.number + 1;
            this.number = i3;
            com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.TAG, "[CheckRotateTask] number:%s, angle:%s", Integer.valueOf(i3), Integer.valueOf(this.senorAngle));
            int rotationAngle = LivePusherPluginHandler.this.getRotationAngle();
            if (rotationAngle == this.senorAngle) {
                LivePusherPluginHandler.this.notifyOrientationChanged(rotationAngle);
            } else if (this.number < 8) {
                LivePusherPluginHandler.this.mMainHandler.postDelayed(this, 250L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class CountHolder {
        int count;

        CountHolder() {
        }
    }

    /* loaded from: classes9.dex */
    public class TouchFocusRunnable implements Runnable {
        private MotionEvent event;

        TouchFocusRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LivePusherPluginHandler.this.mFocusWhenTouch && LivePusherPluginHandler.this.mHtmlWidth != 0 && LivePusherPluginHandler.this.mHtmlHeight != 0) {
                LivePusherPluginHandler.this.onTouchFocusPosition(this.event.getX(), this.event.getY());
            }
        }

        public void setEvent(MotionEvent motionEvent) {
            this.event = motionEvent;
        }
    }

    public LivePusherPluginHandler() {
        com.tencent.luggage.wxa.zp.h.f146825d.a(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.lambda$new$0();
            }
        });
        com.tencent.luggage.wxa.a8.h create = sThreadProvider.create();
        this.mLivePusherThread = create;
        create.start();
        this.mLivePusherHandler = create.getHandler();
        this.mMainHandler = new Handler(com.tencent.luggage.wxa.tn.z.c().getMainLooper());
        com.tencent.luggage.wxa.ff.i.b();
        initLivePusherAdapter();
        this.mVideoCustomRenderProcessor = sVideoCustomRenderProcessorFactory.a(this, this.mAdapter);
        initOrientationListener();
        initScaleGestureDetector();
    }

    private void adjustHtmlSize() {
        if (this.mHtmlWidth != 0 && this.mHtmlHeight != 0 && this.mAdapter != null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "adjustHtmlSize, size:[%d, %d]", Integer.valueOf(this.mHtmlWidth), Integer.valueOf(this.mHtmlHeight));
            if (amIPipPlayer() && this.mIsWebViewInBackground) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "adjustHtmlSize, i am pip player, isWebViewInBackground");
            } else {
                this.mAdapter.setSurfaceSize(this.mHtmlWidth, this.mHtmlHeight);
                this.mVideoCustomRenderProcessor.a(new Size(this.mHtmlWidth, this.mHtmlHeight));
            }
        }
    }

    private void clearSurface() {
        if (this.mSurface != null) {
            this.mVideoCustomRenderProcessor.e();
            this.mSurface.release();
            this.mSurface = null;
        }
    }

    private void convertBackgroundImageToLocalPath(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.g8.a aVar = this.mCustomHandler;
        if (aVar != null) {
            aVar.a(cVar, new AnonymousClass9());
        }
    }

    private void convertFilterImageToLocalPath(com.tencent.luggage.wxa.z7.c cVar) {
        if (this.mCustomHandler != null && !w0.c(this.mFilterImage)) {
            this.mCustomHandler.a(cVar, this.mFilterImage, this.mFilterImageMd5, new AnonymousClass10());
        }
    }

    private void convertPathAndApplyMakeupInner(@NonNull String[] strArr, @NonNull String[] strArr2, @NonNull String[] strArr3, @NonNull JSONObject jSONObject, @NonNull com.tencent.luggage.wxa.z7.c cVar, @NonNull JSONObject jSONObject2) {
        int length = strArr.length;
        CountHolder countHolder = new CountHolder();
        countHolder.count = length;
        for (int i3 = 0; i3 < length; i3++) {
            this.mCustomHandler.a(cVar, strArr[i3], strArr2[i3], false, new AnonymousClass8(i3, jSONObject, strArr3, cVar, countHolder, jSONObject2));
        }
    }

    private void convertResourcePathAndOperateLivePusher(@NonNull com.tencent.luggage.wxa.z7.c cVar, @NonNull String str, @NonNull JSONObject jSONObject) {
        if (this.mCustomHandler == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "convertResourcePathAndOperateLivePusher, customHandler is null");
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
        } else {
            if (!str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123388p)) {
                convertResourcePathWorkaroundAndOperateLivePusher(cVar, str, jSONObject);
                return;
            }
            String optString = jSONObject.optString("path", null);
            if (w0.c(optString)) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "convertResourcePathAndOperateLivePusher, resourcePath is empty");
                return;
            }
            this.mCustomHandler.a(cVar, optString, jSONObject.optString("md5", null), str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123392r), new AnonymousClass6(jSONObject, cVar, str));
        }
    }

    private void convertResourcePathWorkaroundAndOperateLivePusher(@NonNull com.tencent.luggage.wxa.z7.c cVar, @NonNull String str, @NonNull JSONObject jSONObject) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher");
        if (str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123392r)) {
            convertResourcePathWorkaroundAndOperateLivePusher1(cVar, jSONObject);
        } else if (str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.K)) {
            convertResourcePathWorkaroundAndOperateLivePusher2(cVar, jSONObject);
        } else {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher, type is illegal");
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
        }
    }

    private void convertResourcePathWorkaroundAndOperateLivePusher1(@NonNull com.tencent.luggage.wxa.z7.c cVar, @NonNull JSONObject jSONObject) {
        int length;
        JSONArray optJSONArray = jSONObject.optJSONArray(com.tencent.luggage.wxa.c8.c.B);
        if (optJSONArray != null && (length = optJSONArray.length()) != 0) {
            CountHolder countHolder = new CountHolder();
            countHolder.count = length;
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject == null) {
                    com.tencent.luggage.wxa.tn.w.h(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1, stickerJsonObj(%d) is null", Integer.valueOf(i3));
                    cVar.a("fail:stickers is illegal", com.tencent.luggage.wxa.af.e.f121315k);
                    return;
                }
                String optString = optJSONObject.optString("path", null);
                if (w0.c(optString)) {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1, resourcePath(%d) is empty", Integer.valueOf(i3));
                    cVar.a("fail:stickers is illegal", com.tencent.luggage.wxa.af.e.f121315k);
                    return;
                }
                this.mCustomHandler.a(cVar, optString, optJSONObject.optString("md5", null), true, new AnonymousClass7(i3, optJSONObject, cVar, countHolder, jSONObject));
            }
            return;
        }
        com.tencent.luggage.wxa.tn.w.f(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher, stickersJsonArr is empty");
        cVar.a("fail:stickers is empty", com.tencent.luggage.wxa.af.e.f121315k);
    }

    private void convertResourcePathWorkaroundAndOperateLivePusher2(@NonNull com.tencent.luggage.wxa.z7.c cVar, @NonNull JSONObject jSONObject) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        com.tencent.luggage.wxa.af.c cVar2;
        String optString = jSONObject.optString(com.tencent.luggage.wxa.c8.c.M, null);
        if (w0.c(optString)) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupTypeStr is empty");
            cVar.a("fail:makeupType is empty", com.tencent.luggage.wxa.af.e.f121315k);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(com.tencent.luggage.wxa.c8.c.N);
        if (optJSONObject == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupJsonObj is null");
            cVar.a("fail:makeup is null or undefined", com.tencent.luggage.wxa.af.e.f121315k);
            return;
        }
        if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.O)) {
            com.tencent.luggage.wxa.ff.h operateLivePusher = this.mAdapter.operateLivePusher(com.tencent.luggage.wxa.c8.c.K, jSONObject);
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, type:applyMakeup, error:[%s, %s]", Integer.valueOf(operateLivePusher.f126108a), operateLivePusher.f126109b);
            if (operateLivePusher.f126108a == 0) {
                cVar2 = com.tencent.luggage.wxa.af.e.f121305a;
            } else {
                cVar2 = com.tencent.luggage.wxa.af.e.f121309e;
            }
            cVar.a(cVar2, operateLivePusher.f126110c);
            return;
        }
        if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.P)) {
            String optString2 = optJSONObject.optString("path", null);
            if (w0.c(optString2)) {
                com.tencent.luggage.wxa.tn.w.f(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, path is empty");
                cVar.a("fail:path is empty", com.tencent.luggage.wxa.af.e.f121315k);
                return;
            }
            String optString3 = optJSONObject.optString(com.tencent.luggage.wxa.c8.c.Y, null);
            String optString4 = optJSONObject.optString(com.tencent.luggage.wxa.c8.c.f123367a0, null);
            if (!w0.c(optString4)) {
                String[] strArr4 = {optString3, optJSONObject.optString(com.tencent.luggage.wxa.c8.c.f123368b0, null)};
                strArr3 = new String[]{"path", com.tencent.luggage.wxa.c8.c.f123367a0};
                strArr = strArr4;
                strArr2 = new String[]{optString2, optString4};
            } else {
                strArr = new String[]{optString3};
                strArr2 = new String[]{optString2};
                strArr3 = new String[]{"path"};
            }
            convertPathAndApplyMakeupInner(strArr2, strArr, strArr3, optJSONObject, cVar, jSONObject);
            return;
        }
        if (!optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.Q) && !optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.R) && !optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.S)) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupTypeStr is illegal");
            cVar.a("fail:makeupType is illegal", com.tencent.luggage.wxa.af.e.f121315k);
            return;
        }
        String optString5 = optJSONObject.optString("path", null);
        if (w0.c(optString5)) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, path is empty");
            cVar.a("fail:path is empty", com.tencent.luggage.wxa.af.e.f121315k);
        } else {
            convertPathAndApplyMakeupInner(new String[]{optString5}, new String[]{optJSONObject.optString(com.tencent.luggage.wxa.c8.c.Y, null)}, new String[]{"path"}, optJSONObject, cVar, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInvokeInsertAfterRequestPermission(final Context context, final com.tencent.luggage.wxa.z7.c cVar) {
        int i3 = this.requestPermissionCount;
        this.requestPermissionCount = i3 + 1;
        if (i3 > 5) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "doInvokeInsertAfterRequestPermission, avoid dead loop");
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
            cVar.a(com.tencent.luggage.wxa.af.g.f121350s);
            return;
        }
        com.tencent.luggage.wxa.rj.q.c(cVar.getAppId(), new ActivityCompat.OnRequestPermissionsResultCallback() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.13
            @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
            public void onRequestPermissionsResult(int i16, @NonNull String[] strArr, @NonNull int[] iArr) {
                com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "onRequestPermissionsResult callback, requestCode:%d", Integer.valueOf(i16));
                if (i16 == 117) {
                    if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                        c0.a(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                                LivePusherPluginHandler.this.doInvokeInsertAfterRequestPermission(context, cVar);
                            }
                        }, 50L);
                    } else {
                        com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "onRequestPermissionsResult callback, camera permission not grant");
                        com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
                        cVar.a(com.tencent.luggage.wxa.af.g.f121350s);
                    }
                }
                com.tencent.luggage.wxa.rj.q.b(cVar.getAppId(), this);
            }
        });
        com.tencent.luggage.wxa.rj.q.c(cVar.getAppId(), new ActivityCompat.OnRequestPermissionsResultCallback() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.14
            @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
            public void onRequestPermissionsResult(int i16, @NonNull String[] strArr, @NonNull int[] iArr) {
                com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "onRequestPermissionsResult callback, requestCode:%d", Integer.valueOf(i16));
                if (i16 == 118) {
                    if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                        c0.a(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                                LivePusherPluginHandler.this.doInvokeInsertAfterRequestPermission(context, cVar);
                            }
                        }, 50L);
                    } else {
                        com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "onRequestPermissionsResult callback, microphone permission not grant");
                        com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
                        cVar.a(com.tencent.luggage.wxa.af.g.f121350s);
                    }
                }
                com.tencent.luggage.wxa.rj.q.b(cVar.getAppId(), this);
            }
        });
        if (!com.tencent.luggage.wxa.h6.k.a(context, cVar.e(), new String[]{QQPermissionConstants.Permission.CAMERA}, 117, "", "")) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "doInvokeInsertAfterRequestPermission, no Camera Permission");
        } else if (!com.tencent.luggage.wxa.h6.k.a(context, cVar.e(), new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 118, "", "")) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "doInvokeInsertAfterRequestPermission, no Microphone Permission");
        } else {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
            insertInternal(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLogTag() {
        return String.format("%s(%s)", TAG, key());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRotationAngle() {
        if (com.tencent.luggage.wxa.tn.z.c().getSystemService("window") != null) {
            return ((WindowManager) com.tencent.luggage.wxa.tn.z.c().getSystemService("window")).getDefaultDisplay().getRotation();
        }
        com.tencent.luggage.wxa.tn.w.b(getLogTag(), "getRotationAngle, window service is null");
        return 0;
    }

    private void handleAutoPush(com.tencent.luggage.wxa.z7.c cVar) {
        if (this.mCustomHandler == null) {
            return;
        }
        JSONObject a16 = cVar.a();
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handleAutoPlay, dataJsonObj is null");
        } else {
            if (!a16.has("autopush")) {
                return;
            }
            this.mCustomHandler.a(a16.optBoolean("autopush", false));
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
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", key(), c16, a16.toString());
        Log.i("TXLivePusherAdapter", "handleJsApi:" + c16 + ", data:" + a16);
        if (c16.contains("insert")) {
            reportJsapiCall(5);
            this.mVideoCustomRenderProcessor.c(cVar);
            insert(cVar);
        } else if (c16.contains("update")) {
            reportJsapiCall(6);
            this.mVideoCustomRenderProcessor.b(cVar);
            update(cVar);
        } else if (c16.contains("operate")) {
            reportJsapiCall(7);
            operate(cVar);
        } else if (c16.contains("remove")) {
            reportJsapiCall(8);
            remove(cVar);
            this.mPipPluginHandlerCommons.removePipId(cVar);
        }
        handleAutoPush(cVar);
        handlePusherUrl(cVar);
        this.mPipPluginHandlerCommons.handlePipInfo(cVar, this.mPusherUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePluginDestroyInternal() {
        super.handlePluginDestroy();
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handlePluginDestroy", key());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handlePluginReadyInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$handlePluginReadyForGPUProcess$2(Surface surface) {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handlePluginReady", key());
        this.mSurface = surface;
        com.tencent.luggage.wxa.f8.m mVar = this.mAdapter;
        if (mVar != null) {
            mVar.setSurface(surface);
            this.mVideoCustomRenderProcessor.a(surface);
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
        com.tencent.luggage.wxa.g8.a aVar = this.mCustomHandler;
        if (aVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, customHandler is null");
        } else {
            aVar.a(cVar, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handlePluginTouchInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$handlePluginTouch$3(MotionEvent motionEvent) {
        ScaleGestureDetector scaleGestureDetector;
        super.handlePluginTouch(motionEvent);
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handlePluginTouch(%s)", key(), motionEvent);
        if (this.mFocusWhenTouch || this.mZoomWhenScale) {
            if (motionEvent.getPointerCount() == 1 && motionEvent.getAction() == 0) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handlePluginTouch, 1 pointer action down");
                this.mTouchFocusRunnable.setEvent(motionEvent);
                c0.a(this.mTouchFocusRunnable, 100L);
            } else if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handlePluginTouch, 2 pointer action move");
                c0.b(this.mTouchFocusRunnable);
                onTouchFocusPosition(-1.0f, -1.0f);
                if (this.mZoomWhenScale && (scaleGestureDetector = this.mScaleGestureDetector) != null) {
                    scaleGestureDetector.onTouchEvent(motionEvent);
                }
            }
        }
    }

    private void handlePusherUrl(com.tencent.luggage.wxa.z7.c cVar) {
        JSONObject a16 = cVar.a();
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "handlePusherUrl, dataJsonObj is null");
        } else {
            this.mPusherUrl = a16.optString("pushUrl", this.mPusherUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWebViewBackground(final int i3) {
        runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.k
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.lambda$handleWebViewBackground$5(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleWebViewBackgroundInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$handleWebViewBackground$5(int i3) {
        com.tencent.luggage.wxa.f8.m mVar;
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handleWebViewBackground, type:%s", key(), Integer.valueOf(i3));
        this.mIsWebViewInBackground = true;
        if (!isPluginReady(null)) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "plugin is not ready");
            return;
        }
        com.tencent.luggage.wxa.g8.a aVar = this.mCustomHandler;
        if (aVar != null) {
            if (!aVar.b(this, this.mInsertInvokeContext, i3) && (mVar = this.mAdapter) != null && i3 == 4) {
                mVar.sendHandupStop();
            }
            if (this.mAdapter != null) {
                if (amIPipPlayer()) {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground runnable, i am pip player, do not pause");
                } else if (this.mCustomHandler.a(this, this.mInsertInvokeContext, i3)) {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackground pusher not puase when voip mode and runtime not background");
                } else if (i3 == 3) {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackgroundInternal, type back");
                    this.mAdapter.enterBackground(true);
                } else {
                    com.tencent.luggage.wxa.tn.w.d(getLogTag(), "handleWebViewBackgroundInternal, type others");
                    this.mAdapter.enterBackground(false);
                }
            }
        }
        this.mOrientationListenerHelper.disable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWebViewDestroy() {
        runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.handleWebViewDestroyInternal();
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
        runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.handleWebViewForegroundInternal();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWebViewForegroundInternal() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handleWebViewForeground", key());
        com.tencent.luggage.wxa.g8.a aVar = this.mCustomHandler;
        if (aVar != null) {
            aVar.c();
        }
        this.mIsWebViewInBackground = false;
        if (!isPluginReady(null)) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "plugin is not ready");
            return;
        }
        com.tencent.luggage.wxa.f8.m mVar = this.mAdapter;
        if (mVar != null) {
            mVar.enterForeground();
        }
        this.mOrientationListenerHelper.enable();
    }

    private void initLivePusherAdapter() {
        TXLivePusherJSAdapter tXLivePusherJSAdapter = new TXLivePusherJSAdapter(com.tencent.luggage.wxa.tn.z.c());
        this.mAdapter = tXLivePusherJSAdapter;
        tXLivePusherJSAdapter.setPushListener(new ITXLivePushListener() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.1
            @Override // com.tencent.rtmp.ITXLivePushListener
            public void onNetStatus(Bundle bundle) {
                if (LivePusherPluginHandler.this.shouldNotifyEvent()) {
                    LivePusherPluginHandler.this.mEventHandler.a(LivePusherPluginHandler.this.getId(), bundle);
                }
            }

            @Override // com.tencent.rtmp.ITXLivePushListener
            public void onPushEvent(int i3, Bundle bundle) {
                if (LivePusherPluginHandler.this.shouldNotifyEvent()) {
                    com.tencent.luggage.wxa.tn.w.a(LivePusherPluginHandler.TAG, "onPushEvent, errCode:%s", Integer.valueOf(i3));
                    LivePusherPluginHandler.this.mEventHandler.a(LivePusherPluginHandler.this.getId(), i3, bundle);
                }
                if (LivePusherPluginHandler.this.mCustomHandler != null) {
                    if (i3 != 1002 && i3 != 1003 && i3 != 1018) {
                        if (i3 == -1307) {
                            com.tencent.luggage.wxa.g8.a aVar = LivePusherPluginHandler.this.mCustomHandler;
                            LivePusherPluginHandler livePusherPluginHandler = LivePusherPluginHandler.this;
                            aVar.b(livePusherPluginHandler, livePusherPluginHandler.mInsertInvokeContext);
                            return;
                        }
                        return;
                    }
                    if (!LivePusherPluginHandler.this.mHasReleased) {
                        com.tencent.luggage.wxa.g8.a aVar2 = LivePusherPluginHandler.this.mCustomHandler;
                        LivePusherPluginHandler livePusherPluginHandler2 = LivePusherPluginHandler.this;
                        aVar2.c(livePusherPluginHandler2, livePusherPluginHandler2.mInsertInvokeContext);
                    }
                }
            }
        });
        this.mAdapter.setBGMNotifyListener(new TXLivePusher.OnBGMNotify() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.2
            @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
            public void onBGMComplete(int i3) {
                if (LivePusherPluginHandler.this.shouldNotifyEvent()) {
                    LivePusherPluginHandler.this.mEventHandler.a(LivePusherPluginHandler.this.getId(), i3);
                }
            }

            @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
            public void onBGMProgress(long j3, long j16) {
                if (LivePusherPluginHandler.this.shouldNotifyEvent()) {
                    LivePusherPluginHandler.this.mEventHandler.a(LivePusherPluginHandler.this.getId(), j3, j16);
                }
            }

            @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
            public void onBGMStart() {
                if (LivePusherPluginHandler.this.shouldNotifyEvent()) {
                    LivePusherPluginHandler.this.mEventHandler.a(LivePusherPluginHandler.this.getId());
                }
            }
        });
        this.mAdapter.setAudioVolumeListener(new TXLivePusher.ITXAudioVolumeEvaluationListener() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.3
            @Override // com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener
            public void onAudioVolumeEvaluationNotify(int i3) {
                if (LivePusherPluginHandler.this.shouldNotifyEvent()) {
                    LivePusherPluginHandler.this.mEventHandler.b(LivePusherPluginHandler.this.getId(), i3);
                }
            }
        });
    }

    private void initOrientationListener() {
        h0 h0Var = new h0(com.tencent.luggage.wxa.tn.z.c(), new h0.b() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.4
            @Override // com.tencent.luggage.wxa.uk.h0.b
            public void onFourOrientationsChange(h0.a aVar, h0.a aVar2) {
                int i3 = AnonymousClass18.$SwitchMap$com$tencent$mm$plugin$appbrand$utils$OrientationListenerHelper$Orientation[aVar2.ordinal()];
                int i16 = 1;
                if (i3 != 1) {
                    i16 = 2;
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                i16 = 3;
                            }
                        }
                    }
                    i16 = 0;
                }
                LivePusherPluginHandler.this.mCheckRotateTask.cancel();
                LivePusherPluginHandler.this.mCheckRotateTask.senorAngle = i16;
                LivePusherPluginHandler.this.mCheckRotateTask.post();
            }
        });
        this.mOrientationListenerHelper = h0Var;
        h0Var.enable();
        notifyOrientationChanged(getRotationAngle());
    }

    private void initScaleGestureDetector() {
        Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.e
                @Override // java.lang.Runnable
                public final void run() {
                    LivePusherPluginHandler.this.lambda$initScaleGestureDetector$1();
                }
            });
        }
    }

    private void insert(com.tencent.luggage.wxa.z7.c cVar) {
        invokeInsertAfterRequestPermission(cVar);
    }

    private void insertInternal(final com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.af.c cVar2;
        com.tencent.luggage.wxa.g8.a aVar;
        if (this.mAdapter == null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "insert, adapter is null");
            return;
        }
        TXLiveBase.setAppVersion(String.format("weixin_%s", cVar.getAppId()));
        this.mInsertInvokeContext = cVar;
        if (cVar.e() instanceof com.tencent.luggage.wxa.kj.v) {
            this.mIsWebViewInBackground = !((com.tencent.luggage.wxa.kj.v) r1).M0();
        } else {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "insert, component is not AppBrandPageView");
        }
        registerLifecycleListener(cVar);
        JSONObject a16 = cVar.a();
        parseShouldNotifyEvent(cVar, a16);
        parseHtmlPosition(a16);
        parseFocusWhenTouch(a16);
        parseZoomWhenScale(a16);
        parseFilterImage(a16);
        Bundle b16 = com.tencent.luggage.wxa.c8.d.b(a16);
        com.tencent.luggage.wxa.g8.a aVar2 = this.mCustomHandler;
        if (aVar2 != null) {
            final String a17 = aVar2.a(cVar, b16, this, this);
            if (!w0.c(a17)) {
                com.tencent.luggage.wxa.tn.w.d(getLogTag(), "insert fail, message:%s", a17);
                cVar.a("fail: can not insert LivePusher now", com.tencent.luggage.wxa.af.g.f121338g);
                com.tencent.luggage.wxa.zp.h.f146825d.a(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        LivePusherPluginHandler.lambda$insertInternal$6(com.tencent.luggage.wxa.z7.c.this, a17);
                    }
                });
                return;
            }
        }
        com.tencent.luggage.wxa.ff.h initLivePusher = this.mAdapter.initLivePusher(b16);
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "insert, code:%d info:%s", Integer.valueOf(initLivePusher.f126108a), initLivePusher.f126109b);
        if (initLivePusher.f126108a == 0) {
            cVar2 = com.tencent.luggage.wxa.af.e.f121305a;
        } else {
            cVar2 = com.tencent.luggage.wxa.af.e.f121309e;
        }
        cVar.a(cVar2, initLivePusher.f126110c);
        convertBackgroundImageToLocalPath(cVar);
        convertFilterImageToLocalPath(cVar);
        if (initLivePusher.f126108a == 0 && (aVar = this.mCustomHandler) != null) {
            aVar.a(this, this.mInsertInvokeContext, b16);
        }
    }

    private void invokeInsertAfterRequestPermission(com.tencent.luggage.wxa.z7.c cVar) {
        Context context = cVar.getContext();
        if (!(context instanceof Activity)) {
            com.tencent.luggage.wxa.tn.w.f(TAG, "invokeInsertAfterRequestPermission, pageContext not activity");
            cVar.a("fail:internal error invalid android context", com.tencent.luggage.wxa.af.e.f121309e);
            com.tencent.luggage.wxa.rj.q.a(cVar.getAppId());
        } else {
            this.requestPermissionCount = 0;
            doInvokeInsertAfterRequestPermission(context, cVar);
        }
    }

    private boolean isCustomEffectApplyOperateAction(@NonNull String str) {
        if (!str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123388p) && !str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123392r) && !str.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.K)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$forceStop$7() {
        com.tencent.luggage.wxa.f8.m mVar = this.mAdapter;
        if (mVar != null) {
            mVar.operateLivePusher("stop", new JSONObject());
            this.mAdapter.sendWeChatStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initScaleGestureDetector$1() {
        ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener;
        Context c16 = com.tencent.luggage.wxa.tn.z.c();
        if (sEnableZoomOpt) {
            onScaleGestureListener = this.mScaleGestureListenerV2;
        } else {
            onScaleGestureListener = this.mScaleGestureListenerV1;
        }
        this.mScaleGestureDetector = new ScaleGestureDetector(c16, onScaleGestureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$insertInternal$6(com.tencent.luggage.wxa.z7.c cVar, String str) {
        com.tencent.luggage.wxa.y9.a.makeText(cVar.getContext(), str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        this.mLifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$operate$10(String str) {
        com.tencent.luggage.wxa.f8.m mVar = this.mAdapter;
        if (mVar == null) {
            com.tencent.luggage.wxa.tn.w.f(getLogTag(), "run#operate, adapter is null");
        } else {
            mVar.operateLivePusher(str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$9() {
        this.mLifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startIfForeground$8() {
        if (this.mAdapter != null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "startIfForeground, do start");
            this.mAdapter.operateLivePusher("start", new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyOrientationChanged(int i3) {
        if (i3 != this.mLastAngle) {
            this.mLastAngle = i3;
            com.tencent.luggage.wxa.tn.w.d(TAG, "notifyOrientationChanged, new angle:%s", Integer.valueOf(i3));
            com.tencent.luggage.wxa.f8.m mVar = this.mAdapter;
            if (mVar != null) {
                mVar.notifyOrientationChanged(i3);
                this.mVideoCustomRenderProcessor.f().b(i3);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTouchFocusPosition(float f16, float f17) {
        com.tencent.luggage.wxa.f8.m mVar = this.mAdapter;
        if (mVar != null) {
            com.tencent.luggage.wxa.ff.h focusPosition = mVar.setFocusPosition(f16, f17);
            this.mVideoCustomRenderProcessor.d().a(new PointF(f16, f17));
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "onTouchFocusPosition, set focus(%s, %s), code:%d, info:%s", Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(focusPosition.f126108a), focusPosition.f126109b);
        }
    }

    private void operate(com.tencent.luggage.wxa.z7.c cVar) {
        if (this.mAdapter == null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operate, adapter is null");
            return;
        }
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
        if (optString.equalsIgnoreCase(com.tencent.luggage.wxa.c8.c.f123397t0)) {
            this.mPipPluginHandlerCommons.exitPip(cVar);
            return;
        }
        if (optString.equals(com.tencent.luggage.wxa.c8.c.f123373g0)) {
            operatePlayBgm(cVar, a16);
            return;
        }
        if (isCustomEffectApplyOperateAction(optString)) {
            convertResourcePathAndOperateLivePusher(cVar, optString, a16);
            return;
        }
        com.tencent.luggage.wxa.ff.h operateLivePusher = this.mAdapter.operateLivePusher(optString, a16);
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "operate, type:%s, error:[%s, %s]", optString, Integer.valueOf(operateLivePusher.f126108a), operateLivePusher.f126109b);
        cVar.a(operateLivePusher.f126108a == 0 ? com.tencent.luggage.wxa.af.e.f121305a : com.tencent.luggage.wxa.af.e.f121309e, operateLivePusher.f126110c);
        if (optString.equalsIgnoreCase("stop") && operateLivePusher.f126108a == 0) {
            this.mPipPluginHandlerCommons.removePipId(cVar);
            com.tencent.luggage.wxa.g8.a aVar = this.mCustomHandler;
            if (aVar != null) {
                aVar.b(this, this.mInsertInvokeContext);
            }
        }
    }

    private void operatePlayBgm(com.tencent.luggage.wxa.z7.c cVar, @NonNull JSONObject jSONObject) {
        com.tencent.luggage.wxa.g8.a aVar = this.mCustomHandler;
        if (aVar != null) {
            aVar.b(cVar, new AnonymousClass12(jSONObject));
            cVar.a(com.tencent.luggage.wxa.af.e.f121305a);
        } else {
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e);
        }
    }

    private void operateSnapshot(final com.tencent.luggage.wxa.z7.c cVar) {
        this.mAdapter.setSnapshotListener(new TXLivePusher.ITXSnapshotListener() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.11
            @Override // com.tencent.rtmp.TXLivePusher.ITXSnapshotListener
            public void onSnapshot(Bitmap bitmap) {
                if (cVar == null) {
                    com.tencent.luggage.wxa.tn.w.b(LivePusherPluginHandler.TAG, "operateSnapshot, invokeContext is null");
                } else if (LivePusherPluginHandler.this.mCustomHandler != null) {
                    LivePusherPluginHandler.this.mCustomHandler.a(cVar, bitmap);
                }
            }
        });
        com.tencent.luggage.wxa.ff.h operateLivePusher = this.mAdapter.operateLivePusher("snapshot", cVar.a());
        if (operateLivePusher.f126108a != 0) {
            cVar.a(com.tencent.luggage.wxa.af.e.f121309e, operateLivePusher.f126110c);
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

    private void parseFilterImage(JSONObject jSONObject) {
        if (jSONObject.has(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE)) {
            this.mFilterImage = jSONObject.optString(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, this.mFilterImage);
            this.mFilterImageMd5 = jSONObject.optString(com.tencent.luggage.wxa.ff.g.f126099a, null);
            if (w0.c(this.mFilterImage)) {
                try {
                    jSONObject.put(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, "");
                    return;
                } catch (JSONException e16) {
                    com.tencent.luggage.wxa.tn.w.h(getLogTag(), "parseFilterImage, ignore exception:%s", e16);
                    return;
                }
            }
            if (this.mFilterImage.startsWith("http://") || this.mFilterImage.startsWith("https://")) {
                jSONObject.remove(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE);
            }
        }
    }

    private void parseFocusWhenTouch(JSONObject jSONObject) {
        if (jSONObject.has("focusMode")) {
            boolean z16 = false;
            if (jSONObject.optInt("focusMode", 0) != 0) {
                z16 = true;
            }
            this.mFocusWhenTouch = z16;
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

    private void parseZoomWhenScale(JSONObject jSONObject) {
        if (jSONObject.has("zoom")) {
            this.mZoomWhenScale = jSONObject.optBoolean("zoom", false);
        }
    }

    private void registerLifecycleListener(com.tencent.luggage.wxa.z7.c cVar) {
        c.a aVar = new c.a() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.LivePusherPluginHandler.5
            @Override // com.tencent.luggage.wxa.z7.c.a
            public void onBackground(int i3) {
                com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "onBackground, type: " + i3);
                LivePusherPluginHandler.this.handleWebViewBackground(i3);
            }

            @Override // com.tencent.luggage.wxa.z7.c.a
            public void onDestroy() {
                LivePusherPluginHandler.this.handleWebViewDestroy();
            }

            @Override // com.tencent.luggage.wxa.z7.c.a
            public void onForeground() {
                com.tencent.luggage.wxa.tn.w.d(LivePusherPluginHandler.this.getLogTag(), "onForeground");
                LivePusherPluginHandler.this.handleWebViewForeground();
            }
        };
        this.mLifecycleListener = aVar;
        cVar.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.mHasReleased = true;
        com.tencent.luggage.wxa.zp.h.f146825d.a(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.lambda$release$9();
            }
        });
        com.tencent.luggage.wxa.g8.a aVar = this.mCustomHandler;
        if (aVar != null) {
            aVar.b(this, this.mInsertInvokeContext);
            this.mCustomHandler.a(this, this.mInsertInvokeContext);
        }
        com.tencent.luggage.wxa.f8.m mVar = this.mAdapter;
        if (mVar != null) {
            mVar.unInitLivePusher();
            this.mAdapter = null;
        }
        clearSurface();
        unregisterLifecycleListener();
        releaseThreadHandler();
        unregisterMySelf();
    }

    private void releaseThreadHandler() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "LivePusher release handler thread");
        this.mLivePusherHandler.a((Object) null);
        this.mLivePusherThread.a();
    }

    private void remove(com.tencent.luggage.wxa.z7.c cVar) {
        release();
        cVar.a(com.tencent.luggage.wxa.af.e.f121305a);
    }

    private void reportJsapiCall(int i3) {
        com.tencent.luggage.wxa.g8.c cVar = this.mReportHandler;
        if (cVar != null) {
            cVar.a(i3, 1L, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnLivePusherThreadSafely(@NonNull Runnable runnable) {
        this.mLivePusherHandler.a(runnable);
    }

    public static void setEnableZoomOpt(boolean z16) {
        sEnableZoomOpt = z16;
    }

    public static void setVideoCustomRenderProcessorFactory(@NonNull e.a aVar) {
        sVideoCustomRenderProcessorFactory = aVar;
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

    private void unregisterLifecycleListener() {
        com.tencent.luggage.wxa.z7.c cVar = this.mInsertInvokeContext;
        if (cVar != null) {
            cVar.d();
            this.mLifecycleListener = null;
        }
    }

    private void update(com.tencent.luggage.wxa.z7.c cVar) {
        com.tencent.luggage.wxa.af.c cVar2;
        com.tencent.luggage.wxa.g8.a aVar;
        if (this.mAdapter == null) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "update, adapter is null");
            return;
        }
        JSONObject a16 = cVar.a();
        parseShouldNotifyEvent(cVar, a16);
        parseHtmlPosition(a16);
        parseFocusWhenTouch(a16);
        parseZoomWhenScale(a16);
        parseFilterImage(a16);
        Bundle b16 = com.tencent.luggage.wxa.c8.d.b(a16);
        com.tencent.luggage.wxa.ff.h updateLivePusher = this.mAdapter.updateLivePusher(b16);
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "update, code:%d info:%s", Integer.valueOf(updateLivePusher.f126108a), updateLivePusher.f126109b);
        if (updateLivePusher.f126108a == 0) {
            cVar2 = com.tencent.luggage.wxa.af.e.f121305a;
        } else {
            cVar2 = com.tencent.luggage.wxa.af.e.f121309e;
        }
        cVar.a(cVar2, updateLivePusher.f126110c);
        convertBackgroundImageToLocalPath(cVar);
        convertFilterImageToLocalPath(cVar);
        if (updateLivePusher.f126108a == 0 && (aVar = this.mCustomHandler) != null) {
            aVar.a(this, this.mInsertInvokeContext, b16);
            this.mCustomHandler.b(this, this.mInsertInvokeContext, b16);
        }
    }

    public boolean amIPipPlayer() {
        return this.mPipPluginHandlerCommons.amIPipPlayer(this.mInsertInvokeContext);
    }

    public void forceStop() {
        runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.s
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.lambda$forceStop$7();
            }
        });
    }

    @Nullable
    public com.tencent.luggage.wxa.f8.m getAdapter() {
        return this.mAdapter;
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

    @NonNull
    public String getKey() {
        return key() + "@" + hashCode();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
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

    public int getPositionX() {
        return this.mPosX;
    }

    public int getPositionY() {
        return this.mPosY;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public String handleJsApi(final com.tencent.luggage.wxa.z7.c cVar) {
        if (this.mVideoCustomRenderProcessor.a(cVar)) {
            return null;
        }
        runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.f
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.lambda$handleJsApi$4(cVar);
            }
        });
        return null;
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginDestroy() {
        this.mSurfaceTexture = null;
        runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.handlePluginDestroyInternal();
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
        runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.p
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.lambda$handlePluginReadyForGPUProcess$2(surface);
            }
        });
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginScreenshotTaken(@Nullable Bitmap bitmap) {
        super.handlePluginScreenshotTaken(bitmap);
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "*** handler(%s) handlePluginScreenshotTaken", key());
        handlePluginScreenshotTaken4JsApiCall(bitmap);
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginTouch(final MotionEvent motionEvent) {
        runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.lambda$handlePluginTouch$3(motionEvent);
            }
        });
    }

    public void initPluginHandler(com.tencent.luggage.wxa.g8.a aVar) {
        this.mCustomHandler = aVar;
        if (aVar != null) {
            this.mEventHandler = aVar.b();
            this.mReportHandler = this.mCustomHandler.a();
        }
    }

    public boolean isIsWebViewInBackground() {
        return this.mIsWebViewInBackground;
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public boolean isPluginReady(com.tencent.luggage.wxa.z7.c cVar) {
        return true;
    }

    public void pauseExternal() {
        com.tencent.luggage.wxa.tn.w.d(TAG, "pauseExternal");
        this.mHadPauseFromExternal = true;
        operate("pause");
    }

    public void postOnLivePusherThreadSafely(@NonNull Runnable runnable) {
        runOnLivePusherThreadSafely(runnable);
    }

    public void releaseExternal() {
        this.mHadPauseFromExternal = false;
        runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.release();
            }
        });
    }

    public void setOnPlayListener(@Nullable com.tencent.luggage.wxa.a8.x xVar) {
        com.tencent.luggage.wxa.g8.a aVar = this.mCustomHandler;
        if (aVar == null) {
            return;
        }
        aVar.a(xVar);
    }

    public boolean setSurface(@Nullable Surface surface) {
        com.tencent.luggage.wxa.f8.m mVar = this.mAdapter;
        if (mVar != null) {
            mVar.setSurface(surface);
            return true;
        }
        com.tencent.luggage.wxa.tn.w.f(getLogTag(), "setSurface, Adapter is null");
        return false;
    }

    public boolean setSurfaceSize(int i3, int i16) {
        com.tencent.luggage.wxa.f8.m mVar;
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "setSurfaceSize, width: %d, height: %d", Integer.valueOf(i3), Integer.valueOf(i16));
        if (i3 != 0 && i16 != 0 && (mVar = this.mAdapter) != null) {
            mVar.setSurfaceSize(i3, i16);
            return true;
        }
        com.tencent.luggage.wxa.tn.w.f(getLogTag(), "setSurfaceSize, Adapter is null");
        return false;
    }

    public void startExternal() {
        com.tencent.luggage.wxa.tn.w.d(TAG, "startExternal mHadPauseFromExternal:%b mAdapter.isPushing():%b", Boolean.valueOf(this.mHadPauseFromExternal), Boolean.valueOf(this.mAdapter.isPushing()));
        com.tencent.luggage.wxa.f8.m mVar = this.mAdapter;
        if (mVar != null && !mVar.isPushing()) {
            operate("start");
        } else if (this.mHadPauseFromExternal && this.mAdapter.isPushing()) {
            operate("resume");
        }
        this.mHadPauseFromExternal = false;
    }

    public boolean startIfForeground() {
        com.tencent.luggage.wxa.tn.w.d(getLogTag(), "startIfForeground");
        if (this.mIsWebViewInBackground) {
            com.tencent.luggage.wxa.tn.w.d(getLogTag(), "startIfForeground, not in foregound");
            return false;
        }
        runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.lambda$startIfForeground$8();
            }
        });
        return true;
    }

    public void updatePosition(@NonNull JSONObject jSONObject) {
        this.mPosX = com.tencent.luggage.wxa.tk.g.a(jSONObject.optInt(HippyTKDListViewAdapter.X, this.mPosX));
        this.mPosY = com.tencent.luggage.wxa.tk.g.a(jSONObject.optInt("y", this.mPosY));
        com.tencent.luggage.wxa.tn.w.a(getLogTag(), "updatePosition, mPosX: %d, mPosY: %d", Integer.valueOf(this.mPosX), Integer.valueOf(this.mPosY));
    }

    private void operate(final String str) {
        runOnLivePusherThreadSafely(new Runnable() { // from class: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j
            @Override // java.lang.Runnable
            public final void run() {
                LivePusherPluginHandler.this.lambda$operate$10(str);
            }
        });
    }
}
