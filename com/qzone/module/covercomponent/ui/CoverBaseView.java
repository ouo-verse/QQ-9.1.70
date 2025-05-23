package com.qzone.module.covercomponent.ui;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.module.covercomponent.utils.QzoneCoverSquareImageProcessor;
import com.qzone.module.covercomponent.utils.QzoneShowCutInnerSquareImageProcessor;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverJumpAction;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.covercomponent.model.LoadPhotoState;
import com.qzone.proxy.covercomponent.model.PhotoLoadedListener;
import com.qzone.proxy.covercomponent.ui.ICoverBaseParent;
import com.qzone.proxy.covercomponent.ui.ICoverBaseView;
import com.qzone.proxy.covercomponent.ui.IOnCoverClickListener;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.model.CoverCacheData;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class CoverBaseView implements ICoverBaseView, View.OnLongClickListener {
    public static final String TAG = "CoverBaseView";
    protected int E;
    protected String F;
    protected IOnCoverClickListener G;
    private int I;

    /* renamed from: f, reason: collision with root package name */
    private int f48651f;

    /* renamed from: i, reason: collision with root package name */
    private ICoverBaseParent f48653i;

    /* renamed from: m, reason: collision with root package name */
    private int f48654m;

    /* renamed from: d, reason: collision with root package name */
    private ImageLoader.ImageLoadListener f48649d = new MyImageLoadListener();

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, LoadPhotoState> f48650e = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private AtomicInteger f48652h = new AtomicInteger(0);
    private boolean C = false;
    protected volatile boolean D = false;
    private Runnable H = new Runnable() { // from class: com.qzone.module.covercomponent.ui.CoverBaseView.1
        @Override // java.lang.Runnable
        public void run() {
            if (CoverLog.isColorLevel()) {
                CoverLog.d(CoverBaseView.TAG, CoverLog.CLR, "mCoverSwitchRunable, run, thread:" + Thread.currentThread());
            }
            try {
                CoverBaseView.this.onCoverSwitch();
                CoverBaseView.this.switchCover();
            } catch (Exception e16) {
                CoverLog.e(CoverBaseView.TAG, "runnable error", e16);
            }
        }
    };

    /* compiled from: P */
    /* renamed from: com.qzone.module.covercomponent.ui.CoverBaseView$2, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LoadPhotoState f48655d;

        AnonymousClass2(LoadPhotoState loadPhotoState) {
            this.f48655d = loadPhotoState;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            obtain.useMainThread = false;
            obtain.needShowGifAnimation = false;
            int i3 = this.f48655d.alian;
            if (i3 == 3) {
                obtain.extraProcessor = new QzoneCoverSquareImageProcessor(0);
            } else if (i3 == 1) {
                obtain.extraProcessor = new QzoneShowCutInnerSquareImageProcessor(CoverEnv.getScreenWidth(), 1.0d);
            }
            CoverLog.i(CoverBaseView.TAG, CoverLog.CLR, "start loadPhoto, url=" + this.f48655d.url + " ,alian=" + this.f48655d.alian);
            FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(this.f48655d.url).g(new a.c() { // from class: com.qzone.module.covercomponent.ui.a
                @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                public final void a(k kVar) {
                    kVar.w(4);
                }
            }).a();
            CoverBaseView.this.g(this.f48655d.url, a16);
            ConcurrentHashMap concurrentHashMap = CoverBaseView.this.f48650e;
            LoadPhotoState loadPhotoState = this.f48655d;
            concurrentHashMap.putIfAbsent(loadPhotoState.url, loadPhotoState);
            if (a16 == null) {
                ConcurrentHashMap concurrentHashMap2 = CoverBaseView.this.f48650e;
                LoadPhotoState loadPhotoState2 = this.f48655d;
                concurrentHashMap2.putIfAbsent(loadPhotoState2.url, loadPhotoState2);
                return;
            }
            PhotoLoadedListener photoLoadedListener = this.f48655d.listener.get();
            if (photoLoadedListener != null) {
                photoLoadedListener.onLoadSuccess(this.f48655d, a16);
            }
            if (CoverBaseView.this.C && CoverBaseView.this.f48652h.incrementAndGet() == CoverBaseView.this.f48654m) {
                CoverBaseView.this.switchCover();
            }
        }
    }

    public CoverBaseView(int i3) {
        this.f48651f = 0;
        this.f48651f = i3;
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, Drawable drawable) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, "onImageLoaded, url:" + str + ", thread:" + Thread.currentThread().getName());
        }
        LoadPhotoState loadPhotoState = this.f48650e.get(str);
        if (loadPhotoState == null) {
            CoverLog.w(TAG, "photoState is null url:" + str, null);
            this.f48650e.remove(str);
            return;
        }
        PhotoLoadedListener photoLoadedListener = loadPhotoState.listener.get();
        if (photoLoadedListener != null) {
            photoLoadedListener.onLoadSuccess(loadPhotoState, drawable);
        }
        this.f48650e.remove(str);
        if (this.C && this.f48652h.incrementAndGet() == this.f48654m) {
            switchCover();
        }
    }

    private void h() {
        switch (this.f48651f) {
            case 0:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                return;
            case 1:
                this.f48654m = 1;
                return;
            case 2:
                this.f48654m = 3;
                return;
            default:
                throw new IllegalStateException("\u4e0d\u53ef\u8bc6\u522b\u7684Cover\u7c7b\u578b type=" + this.f48651f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        int i3;
        ICoverBaseParent iCoverBaseParent = this.f48653i;
        if (iCoverBaseParent == null || !(iCoverBaseParent instanceof QZoneCoverContainer)) {
            i3 = 0;
        } else {
            CoverLog.d(TAG, CoverLog.DEV, "getParentHeight height = " + ((QZoneCoverContainer) this.f48653i).getParentHeight());
            i3 = ((QZoneCoverContainer) this.f48653i).getParentHeight();
        }
        return (i3 == 0 || i3 == -2 || i3 == -1) ? CoverEnv.getScreenWidth() : i3;
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public int getCoverType() {
        return this.f48651f;
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void invalidate() {
        ICoverBaseParent iCoverBaseParent = this.f48653i;
        if (iCoverBaseParent != null) {
            iCoverBaseParent.coverInvalidate();
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public boolean isCoverVisible() {
        return this.D;
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public boolean isPaused() {
        return !isCoverVisible();
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void needCoverSwitch(boolean z16) {
        this.C = z16;
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onConfigurationChanged(Configuration configuration) {
        if (this.I != CoverEnv.getScreenWidth()) {
            this.I = CoverEnv.getScreenWidth();
            onScreenSharpnessChange();
        }
        CoverLog.d(TAG, CoverLog.USR, "onConfigurationChanged width =" + CoverEnv.getScreenWidth());
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onDestroy() {
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, "onDestory");
        }
        this.f48649d = null;
        this.D = false;
        if (VasNormalToggle.QZONE_THREAD_MOVE_SWITCH.isEnable(true)) {
            ThreadManagerV2.removeJob(this.H, 16);
        } else {
            CoverEnv.getNormalThreadHandler().removeCallbacks(this.H);
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onInvisible() {
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, "onInvisible");
        }
        this.D = false;
        if (VasNormalToggle.QZONE_THREAD_MOVE_SWITCH.isEnable(true)) {
            ThreadManagerV2.removeJob(this.H, 16);
        } else {
            CoverEnv.getNormalThreadHandler().removeCallbacks(this.H);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        IOnCoverClickListener iOnCoverClickListener = this.G;
        if (iOnCoverClickListener != null) {
            iOnCoverClickListener.onLongClick(view);
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return true;
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onPause() {
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        this.D = false;
        if (VasNormalToggle.QZONE_THREAD_MOVE_SWITCH.isEnable(true)) {
            ThreadManagerV2.removeJob(this.H, 16);
        } else {
            CoverEnv.getNormalThreadHandler().removeCallbacks(this.H);
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onResume() {
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, "onResume");
        }
        this.D = true;
        switchCover();
    }

    public void onScreenSharpnessChange() {
        CoverLog.d(TAG, CoverLog.DEV, "onScreenSharpnessChange lastScreenWidth = " + this.I);
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onVisible() {
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, "onVisible");
        }
        this.D = true;
        switchCover();
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void postInvalidate() {
        ICoverBaseParent iCoverBaseParent = this.f48653i;
        if (iCoverBaseParent != null) {
            iCoverBaseParent.postCoverInvalidate();
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void setCoverBaseParent(ICoverBaseParent iCoverBaseParent) {
        this.f48653i = iCoverBaseParent;
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void setOnCoverClickListener(IOnCoverClickListener iOnCoverClickListener) {
        this.G = iOnCoverClickListener;
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void setRefer(int i3) {
        this.E = i3;
        if (i3 == 1) {
            this.F = "qzone";
        } else if (i3 == 2) {
            this.F = QzoneCoverConst.REFER_USERHOME;
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void switchCover() {
        if (this.C && this.D) {
            VasQzoneYellowThread.INSTANCE.execJobDelay(this.H, 5000L);
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public boolean loadPhoto(LoadPhotoState loadPhotoState) {
        if (loadPhotoState == null || TextUtils.isEmpty(loadPhotoState.url) || loadPhotoState.listener == null) {
            return false;
        }
        CoverEnv.getRealTimeThreadHandler().post(new AnonymousClass2(loadPhotoState));
        return true;
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public boolean onTouchEvent(Activity activity, View view, MotionEvent motionEvent, CoverCacheData coverCacheData) {
        if (activity == null) {
            CoverLog.w(TAG, "onTouchEvent activity is null", null);
            return true;
        }
        if (coverCacheData == null) {
            CoverLog.w(TAG, "onTouchEvent CoverCacheData is null", null);
            return true;
        }
        if (!CoverEnv.isInQQ() && CoverEnv.getLoginUin() != coverCacheData.uin) {
            CoverLog.i(TAG, CoverLog.CLR, "\u72ec\u7acb\u7248,\u5ba2\u4eba\u6001 \u70b9\u51fb\u4e0d\u8df3\u8f6c");
            return true;
        }
        if (coverCacheData.uin != CoverEnv.getLoginUin() && coverCacheData.mapExtInfo.containsKey(QzoneCoverConst.KEY_ACTIVITY_COVER_URL)) {
            CoverEnv.RDMCollector.addNoramlClickAction(TAG, view);
            String str = coverCacheData.mapExtInfo.get(QzoneCoverConst.KEY_ACTIVITY_COVER_URL);
            if (str != null) {
                activity.startActivity(CoverJumpAction.getActivityCoverPageIntent(str));
            }
        } else {
            CoverEnv.RDMCollector.addNoramlClickAction(TAG, view);
            if (TextUtils.isEmpty(CoverEnv.getCoverJumpUrlFromJce(coverCacheData.uin))) {
                CoverJumpAction.jumpToCoverCenter(activity, this.E, this.F, coverCacheData.uin);
            } else {
                CoverJumpAction.jumpToUrlPageFromJceData(activity, coverCacheData.uin);
            }
        }
        return true;
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void delayShow() {
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onCoverSwitch() {
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onPullChanged(float f16) {
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onPullEnd() {
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onPullStart() {
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onStart() {
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onStop() {
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private class MyImageLoadListener implements ImageLoader.ImageLoadListener {
        MyImageLoadListener() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            CoverBaseView.this.g(str, drawable);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void dispatchPullEvent(int i3, int i16) {
    }
}
