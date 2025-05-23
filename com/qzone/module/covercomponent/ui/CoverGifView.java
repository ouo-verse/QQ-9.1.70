package com.qzone.module.covercomponent.ui;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.qzone.module.covercomponent.manage.QZoneCoverContainerManager;
import com.qzone.module.covercomponent.utils.CoverHelper;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverJumpAction;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.widget.AsynAutoGifImageView;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.component.media.utils.BaseHandler;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverGifView extends CoverBaseView implements AsynAutoGifImageView.a, AutoGifDrawable.GifDownloadCallBackListener, AsyncImageable.AsyncImageListener, View.OnClickListener {
    private AsynAutoGifImageView J;
    private AsyncImageView K;
    private AsyncImageView L;
    private String M;
    private String N;
    private FrameLayout P;
    private long Q;
    private boolean R;
    private volatile int S;
    private Handler T;
    private Runnable U;

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        AsynAutoGifImageView asynAutoGifImageView = this.J;
        if (asynAutoGifImageView != null) {
            asynAutoGifImageView.i();
            this.J.g();
            this.J = null;
        }
        FrameLayout frameLayout = this.P;
        if (frameLayout != null) {
            frameLayout.removeAllViewsInLayout();
        }
    }

    private void u() {
        int i3 = this.E != 1 ? 2 : 1;
        String config = CoverEnv.getConfig("H5Url", QzoneCoverConst.SECONDARY_COVER_GIF_COVER_MALL_URL, CoverHelper.JUMP_COVER_MALL_URL_DEFAULT);
        String coverJumpUrlFromJce = CoverEnv.getCoverJumpUrlFromJce(CoverEnv.getLoginUin());
        if (!TextUtils.isEmpty(coverJumpUrlFromJce)) {
            config = coverJumpUrlFromJce;
        }
        CoverJumpAction.handleScheme(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceWithUin(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceWithQua(config), "{hostUin}", String.valueOf(this.Q)), CoverEnv.getLoginUin()), "{page}", String.valueOf(i3)), "{from}", CoverHelper.getFromPageName(this.E)), CoverEnv.getContext(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.S != 1) {
            CoverLog.i("CoverGifView", CoverLog.CLR, "onPause show pic");
            t();
            z();
            y();
        }
    }

    private void w() {
        CoverLog.i("CoverGifView", CoverLog.CLR, "onResume ... mClickByUser=" + this.R);
        if (CoverEnv.isWifiConn()) {
            if (this.S != 3 && this.S != 2) {
                CoverLog.i("CoverGifView", CoverLog.CLR, "showing gif donothing");
                x();
                return;
            }
            CoverLog.i("CoverGifView", CoverLog.CLR, "onResume show gif2");
            t();
            z();
            y();
            x();
            return;
        }
        if (this.S != 1) {
            CoverLog.i("CoverGifView", CoverLog.CLR, "onResume show pic");
            t();
            z();
            y();
        }
    }

    private void x() {
        if (TextUtils.isEmpty(this.M)) {
            CoverLog.e("CoverGifView", "gif url is empty!", null);
            return;
        }
        AsynAutoGifImageView asynAutoGifImageView = this.J;
        if (asynAutoGifImageView != null) {
            asynAutoGifImageView.i();
            this.J.g();
            this.J = null;
        }
        AsynAutoGifImageView asynAutoGifImageView2 = new AsynAutoGifImageView(CoverEnv.getContext());
        this.J = asynAutoGifImageView2;
        asynAutoGifImageView2.setAsyncImageListener(this);
        this.J.setOnClickListener(this);
        this.J.setOnLongClickListener(this);
        ImageLoader.getInstance(CoverEnv.getContext()).clear(this.M);
        this.J.setAsynGifImage(this.M, this, this);
        this.J.h();
        this.S = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (TextUtils.isEmpty(this.M)) {
            CoverLog.i("CoverGifView", CoverLog.USR, "gif url is empty not show play icon");
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        if (this.K == null) {
            this.K = new AsyncImageView(CoverEnv.getContext());
        }
        this.K.setImageResource(CoverHelper.getResId(8));
        FrameLayout frameLayout = this.P;
        if (frameLayout != null) {
            frameLayout.addView(this.K, layoutParams);
        }
        this.K.setOnClickListener(this);
        this.K.setOnLongClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.L == null) {
            this.L = new AsyncImageView(CoverEnv.getContext());
        }
        this.L.setAsyncImage(this.N);
        this.L.setOnClickListener(this);
        this.L.setOnLongClickListener(this);
        t();
        if (this.P != null) {
            this.P.addView(this.L, new FrameLayout.LayoutParams(-1, -1));
        }
        this.S = 1;
    }

    public boolean isChanged(long j3, HashMap<String, String> hashMap) {
        if (this.Q != j3) {
            return true;
        }
        if ((hashMap != null ? hashMap.get(CoverHelper.GIF_URL_KEY) : null) != null) {
            return !r3.equals(this.M);
        }
        return true;
    }

    @Override // com.qzone.widget.AsynAutoGifImageView.a
    public boolean isListViewScrollIdle() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.J) {
            u();
        } else if (view == this.L) {
            u();
        } else if (view == this.K) {
            this.R = true;
            x();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onDestroy() {
        super.onDestroy();
        CoverLog.i("CoverGifView", CoverLog.CLR, "onDestroy ...");
        Handler handler = this.T;
        if (handler != null) {
            handler.removeCallbacks(this.U);
        }
        t();
        AsyncImageView asyncImageView = this.L;
        if (asyncImageView != null) {
            asyncImageView.clearAsyncImage();
            this.L = null;
        }
        AsyncImageView asyncImageView2 = this.K;
        if (asyncImageView2 != null) {
            asyncImageView2.clearAsyncImage();
            this.K = null;
        }
        this.R = false;
        this.S = 0;
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
    public void onImageCanceled(String str, ImageLoader.Options options) {
        CoverLog.i("CoverGifView", CoverLog.CLR, "onImageCanceled ");
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
    public void onImageFailed(String str, ImageLoader.Options options) {
        CoverLog.e("CoverGifView", "onImageFailed1 gif url=" + this.M, null);
        if (CoverEnv.isDebugVersion()) {
            CoverEnv.showToast("[DEBUG]\u52a0\u8f7d\u52a8\u56fe\u80cc\u666f\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        }
        Handler handler = this.T;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.qzone.module.covercomponent.ui.CoverGifView.1
                @Override // java.lang.Runnable
                public void run() {
                    CoverGifView.this.t();
                    CoverGifView.this.z();
                    CoverGifView.this.y();
                }
            });
        }
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
    public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
        CoverLog.i("CoverGifView", CoverLog.CLR, "onImageLoaded1 start gif");
        HdAsync.with(this).then(new HdAsyncAction(Looper.getMainLooper()) { // from class: com.qzone.module.covercomponent.ui.CoverGifView.2
            @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
            public HdAsyncResult call(Object obj) {
                if (CoverGifView.this.P != null) {
                    if (CoverGifView.this.K != null) {
                        CoverGifView.this.P.removeView(CoverGifView.this.K);
                        CoverGifView.this.K.clearAsyncImage();
                        CoverGifView.this.K = null;
                    }
                    if (CoverGifView.this.L != null) {
                        CoverGifView.this.P.removeView(CoverGifView.this.L);
                        CoverGifView.this.L.clearAsyncImage();
                        CoverGifView.this.L = null;
                    }
                    if (CoverGifView.this.J != null) {
                        if (CoverGifView.this.J.getParent() != CoverGifView.this.P) {
                            CoverGifView.this.P.removeView(CoverGifView.this.J);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(CoverEnv.getScreenWidth(), CoverEnv.getFinalCoverHeight());
                            layoutParams.gravity = 17;
                            CoverGifView.this.P.addView(CoverGifView.this.J, 0, layoutParams);
                        } else {
                            CoverGifView.this.J.bringToFront();
                        }
                    }
                }
                if (CoverGifView.this.J != null) {
                    CoverGifView.this.J.invalidateGifView();
                    CoverGifView.this.S = 3;
                }
                return doNext(false);
            }
        }).call();
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
    public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        CoverLog.i("CoverGifView", CoverLog.CLR, "onImageProgress=" + f16 + JefsClass.INDEX_URL + str);
    }

    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
    public void onImageStarted(AsyncImageable asyncImageable) {
        CoverLog.i("CoverGifView", CoverLog.CLR, "onImageStarted ");
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onInvisible() {
        if (isCoverVisible()) {
            super.onInvisible();
            v();
        }
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onPause() {
        if (isPaused()) {
            return;
        }
        super.onPause();
        CoverLog.i("CoverGifView", CoverLog.CLR, "onPause ...");
        Handler handler = this.T;
        if (handler != null) {
            handler.removeCallbacks(this.U);
            this.T.postDelayed(this.U, 2000L);
        }
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onResume() {
        if (isPaused()) {
            super.onResume();
            Handler handler = this.T;
            if (handler != null) {
                handler.removeCallbacks(this.U);
            }
            w();
        }
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onVisible() {
        if (isCoverVisible()) {
            return;
        }
        super.onVisible();
        Handler handler = this.T;
        if (handler != null) {
            handler.removeCallbacks(this.U);
        }
        w();
    }

    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
    public void onImageProgress(AsyncImageable asyncImageable, float f16) {
        CoverLog.i("CoverGifView", CoverLog.CLR, "AsyncImageable onImageProgress=" + f16);
    }

    public CoverGifView(long j3, FrameLayout frameLayout, int i3, String str, String str2) {
        super(16);
        this.R = false;
        this.S = 0;
        this.U = new Runnable() { // from class: com.qzone.module.covercomponent.ui.CoverGifView.3
            @Override // java.lang.Runnable
            public void run() {
                CoverGifView.this.v();
            }
        };
        this.Q = j3;
        this.P = frameLayout;
        this.E = i3;
        this.M = str2;
        this.N = str;
        this.T = new BaseHandler();
        z();
        y();
        if (CoverEnv.isWifiConn()) {
            x();
        }
    }

    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
    public void onImageLoaded(AsyncImageable asyncImageable) {
        CoverLog.i("CoverGifView", CoverLog.CLR, "onImageLoaded2 ");
    }

    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
    public void onImageFailed(AsyncImageable asyncImageable) {
        CoverLog.e("CoverGifView", "onImageFailed2 gif url=" + this.M, null);
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void draw(Canvas canvas) {
    }
}
