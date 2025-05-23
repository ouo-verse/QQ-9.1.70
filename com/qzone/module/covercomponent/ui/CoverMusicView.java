package com.qzone.module.covercomponent.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.module.covercomponent.manage.CoverCacheManager;
import com.qzone.module.covercomponent.utils.CoverHelper;
import com.qzone.module.covercomponent.utils.CoverURLDrawableHelper;
import com.qzone.personalize.music.business.QusicService;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverJumpAction;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.covercomponent.model.LoadPhotoState;
import com.qzone.proxy.covercomponent.model.PhotoLoadedListener;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.model.CoverCacheData;
import e8.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverMusicView extends CoverBaseView implements PhotoLoadedListener, IObserver.main {
    public static final String MUSIC_COVER_LYRIC = "music_cover_lyric";
    public static final String TAG = "CoverMusicView";
    private volatile Drawable J;
    private Rect K;
    private Map<String, Drawable> L;
    private CoverCacheData M;
    private String N;
    private long P;
    private int Q;
    private AlphaAnimation R;
    private FrameLayout S;
    private int T;
    private Activity U;
    private ImageView V;
    private ImageView W;
    private ImageView X;
    private ImageView Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private String[] f48671a0;

    /* renamed from: b0, reason: collision with root package name */
    private Handler f48672b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f48673c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f48674d0;

    private void t() {
        this.S.removeAllViews();
        ImageView imageView = new ImageView(this.U);
        this.V = imageView;
        this.S.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        this.V.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageView imageView2 = new ImageView(this.U);
        this.W = imageView2;
        this.S.addView(imageView2, new FrameLayout.LayoutParams(-1, -1));
        this.W.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.W.setVisibility(8);
        this.X = new ImageView(this.U);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.S.addView(this.X, layoutParams);
        this.X.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageView imageView3 = new ImageView(this.U);
        this.Y = imageView3;
        imageView3.setBackgroundResource(CoverHelper.getResId(9));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ViewUtils.dpToPx(50.0f), ViewUtils.dpToPx(50.0f));
        layoutParams2.gravity = 17;
        this.S.addView(this.Y, layoutParams2);
        this.Y.setScaleType(ImageView.ScaleType.FIT_XY);
        SongInfo musicInfo = CoverCacheManager.getMusicInfo(this.M);
        if (musicInfo != null && QusicService.O().Z(musicInfo.f251867d)) {
            this.Y.setVisibility(8);
        } else if (CoverEnv.isWifiAutoPlay() && 2 == this.E) {
            u();
        }
        this.Y.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.covercomponent.ui.CoverMusicView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                CoverMusicView.this.u();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(CoverCacheManager.getMusicInfo(this.M));
        if (arrayList.isEmpty()) {
            return;
        }
        f.a().b().l((SongInfo) arrayList.get(0));
        EventCenter.getInstance().post("MusicPlayer", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        String[] strArr = this.f48671a0;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        if (strArr.length > 1) {
            if (this.f48674d0) {
                return;
            }
            if (this.L.get(strArr[this.Z]) != null) {
                this.V.setImageDrawable(this.L.get(this.f48671a0[this.Z]));
            }
            v();
            return;
        }
        this.V.setImageDrawable(this.L.get(strArr[0]));
    }

    private void x() {
        String[] musicCoverUrl = CoverCacheManager.getMusicCoverUrl(this.M);
        this.f48671a0 = musicCoverUrl;
        if (musicCoverUrl != null && musicCoverUrl.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr = this.f48671a0;
                if (i3 >= strArr.length) {
                    break;
                }
                loadImage(strArr[i3]);
                i3++;
            }
        }
        String str = this.M.mapExtInfo.get(MUSIC_COVER_LYRIC);
        this.f48673c0 = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        loadImage(this.f48673c0);
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void draw(Canvas canvas) {
        if (this.J == null || this.K == null || canvas == null) {
            return;
        }
        this.J.setBounds(this.K);
        this.J.draw(canvas);
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onCoverSwitch() {
        throw new IllegalStateException("\u9759\u6001Cover\u6ca1\u6709\u56fe\u7247\u5207\u6362");
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onDestroy() {
        super.onDestroy();
        this.J = null;
        this.K = null;
        FrameLayout frameLayout = this.S;
        if (frameLayout != null) {
            frameLayout.removeAllViewsInLayout();
        }
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("MusicPlayer".equals(event.source.getName())) {
            int i3 = event.what;
            if (i3 == 1) {
                this.Y.setVisibility(0);
            } else {
                if (i3 != 2) {
                    return;
                }
                this.Y.setVisibility(8);
            }
        }
    }

    @Override // com.qzone.proxy.covercomponent.model.PhotoLoadedListener
    public void onLoadSuccess(final LoadPhotoState loadPhotoState, final Drawable drawable) {
        if (CoverLog.isColorLevel()) {
            int i3 = CoverLog.CLR;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onLoadSuccess ");
            sb5.append(loadPhotoState != null ? loadPhotoState.url : null);
            CoverLog.i(TAG, i3, sb5.toString());
        }
        this.f48672b0.post(new Runnable() { // from class: com.qzone.module.covercomponent.ui.CoverMusicView.4
            @Override // java.lang.Runnable
            public void run() {
                LoadPhotoState loadPhotoState2;
                String str;
                if (drawable != null) {
                    LoadPhotoState loadPhotoState3 = loadPhotoState;
                    if (loadPhotoState3 != null && !TextUtils.isEmpty(loadPhotoState3.url)) {
                        CoverMusicView.this.L.put(loadPhotoState.url, drawable);
                    }
                    if (CoverMusicView.this.f48671a0 != null && CoverMusicView.this.f48671a0.length > 0 && (loadPhotoState2 = loadPhotoState) != null && (str = loadPhotoState2.url) != null && !str.equals(CoverMusicView.this.f48673c0)) {
                        boolean z16 = true;
                        for (int i16 = 0; i16 < CoverMusicView.this.f48671a0.length; i16++) {
                            if (CoverMusicView.this.L.get(CoverMusicView.this.f48671a0[i16]) == null) {
                                z16 = false;
                            }
                        }
                        if (z16) {
                            CoverMusicView.this.w();
                            return;
                        }
                        return;
                    }
                    if (CoverMusicView.this.L.get(CoverMusicView.this.f48673c0) != null) {
                        CoverMusicView.this.X.setImageDrawable((Drawable) CoverMusicView.this.L.get(CoverMusicView.this.f48673c0));
                    }
                }
            }
        });
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onStart() {
        x();
        super.onStart();
    }

    public void setCoverData(Context context, Activity activity, FrameLayout frameLayout, long j3, CoverCacheData coverCacheData, int i3, int i16) {
        this.P = j3;
        this.Q = i3;
        this.S = frameLayout;
        this.M = coverCacheData;
        this.U = activity;
        this.E = i16;
        t();
        this.f48672b0 = new Handler();
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.f48674d0 = true;
        this.f48672b0.postDelayed(new Runnable() { // from class: com.qzone.module.covercomponent.ui.CoverMusicView.1
            @Override // java.lang.Runnable
            public void run() {
                if (CoverMusicView.this.f48671a0 != null) {
                    if (CoverMusicView.this.f48671a0.length <= CoverMusicView.this.Z) {
                        CoverMusicView.this.Z = 0;
                        return;
                    }
                    if (CoverMusicView.this.L.get(CoverMusicView.this.f48671a0[CoverMusicView.this.Z]) != null) {
                        CoverMusicView.this.W.setImageDrawable((Drawable) CoverMusicView.this.L.get(CoverMusicView.this.f48671a0[CoverMusicView.this.Z]));
                        CoverMusicView.this.W.setVisibility(0);
                    }
                    if (CoverMusicView.this.Z == CoverMusicView.this.f48671a0.length - 1) {
                        CoverMusicView.this.Z = 0;
                    } else {
                        CoverMusicView.this.Z++;
                    }
                    if (CoverMusicView.this.L.get(CoverMusicView.this.f48671a0[CoverMusicView.this.Z]) != null) {
                        CoverMusicView.this.V.setImageDrawable((Drawable) CoverMusicView.this.L.get(CoverMusicView.this.f48671a0[CoverMusicView.this.Z]));
                    }
                    CoverMusicView coverMusicView = CoverMusicView.this;
                    coverMusicView.setHideAnimation(coverMusicView.W, 1000);
                }
            }
        }, 2000L);
    }

    public boolean init(String str) {
        this.T = 0;
        return loadImage(str);
    }

    public boolean loadImage(String str) {
        Drawable loadImage;
        needCoverSwitch(false);
        int screenWidth = CoverEnv.getScreenWidth();
        this.K = new Rect(0, 0, screenWidth, screenWidth);
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, "init, width=" + screenWidth + ", height=" + screenWidth + ", coverUrl=" + str);
        }
        int i3 = this.T;
        if (i3 == 0) {
            i3 = 3;
        }
        if (VasToggle.isEnable("qzone_cover_load_with_URLDrawable", false)) {
            loadImage = CoverURLDrawableHelper.getCoverDrawable(str, ImageLoader.Options.obtain(), null);
        } else {
            loadImage = ImageLoader.getInstance().loadImage(str, ImageLoader.Options.obtain());
        }
        if (loadImage == null) {
            loadPhoto(new LoadPhotoState(str, 0, i3, this));
            CoverLog.i(TAG, CoverLog.CLR, "get image drawable asyn, wait for callback: " + str + " ,photoalian=" + i3);
        } else {
            this.L.put(str, loadImage);
            String[] strArr = this.f48671a0;
            if (strArr != null && strArr.length > 0 && !str.equals(this.f48673c0)) {
                int i16 = 0;
                boolean z16 = true;
                while (true) {
                    String[] strArr2 = this.f48671a0;
                    if (i16 >= strArr2.length) {
                        break;
                    }
                    if (this.L.get(strArr2[i16]) == null) {
                        z16 = false;
                    }
                    i16++;
                }
                if (z16) {
                    w();
                }
            } else if (this.L.get(this.f48673c0) != null) {
                this.X.setImageDrawable(this.L.get(this.f48673c0));
            }
            this.J = loadImage;
            postInvalidate();
            CoverLog.i(TAG, CoverLog.CLR, "get image drawable ok, postInvalidate");
        }
        return true;
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onStop() {
        this.J = null;
        this.K = null;
        super.onStop();
    }

    public CoverMusicView() {
        super(19);
        this.Z = 0;
        this.f48672b0 = new Handler(Looper.getMainLooper());
        this.f48674d0 = false;
        this.L = new HashMap();
        this.N = CoverCacheManager.gLoginUserCoverUrl;
        EventCenter.getInstance().addUIObserver(this, "MusicPlayer", 1);
        EventCenter.getInstance().addUIObserver(this, "MusicPlayer", 2);
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public boolean onTouchEvent(Activity activity, View view, MotionEvent motionEvent, CoverCacheData coverCacheData) {
        if (coverCacheData == null) {
            return super.onTouchEvent(activity, view, motionEvent, null);
        }
        if (!CoverEnv.isInQQ() && CoverEnv.getLoginUin() != coverCacheData.uin) {
            return super.onTouchEvent(activity, view, motionEvent, null);
        }
        int screenWidth = CoverEnv.getScreenWidth();
        motionEvent.getX();
        motionEvent.getY();
        int i3 = screenWidth / 8;
        if (coverCacheData.uin != CoverEnv.getLoginUin() && CoverEnv.isUserHomeActivity(activity) && !coverCacheData.type.equals(QzoneCoverConst.CoverStringType.COVER_TYPE_CUSTOM) && !coverCacheData.mapExtInfo.containsKey(QzoneCoverConst.KEY_ACTIVITY_COVER_URL)) {
            CoverEnv.RDMCollector.addNoramlClickAction(TAG, view);
            Intent musicCoverPreviewIntent = CoverJumpAction.getMusicCoverPreviewIntent(coverCacheData.coverId, 2, QzoneCoverConst.REFER_USERHOME, coverCacheData.uin);
            Intent coverClickedIntentFromJceData = CoverJumpAction.getCoverClickedIntentFromJceData(coverCacheData.uin);
            if (coverClickedIntentFromJceData != null) {
                musicCoverPreviewIntent = coverClickedIntentFromJceData;
            }
            activity.startActivity(musicCoverPreviewIntent);
            return true;
        }
        return super.onTouchEvent(activity, view, motionEvent, coverCacheData);
    }

    public void setHideAnimation(View view, int i3) {
        if (view == null || i3 < 0) {
            return;
        }
        AlphaAnimation alphaAnimation = this.R;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.R = alphaAnimation2;
        alphaAnimation2.setDuration(i3);
        this.R.setFillAfter(true);
        this.R.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.covercomponent.ui.CoverMusicView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                CoverMusicView.this.W.setVisibility(8);
                CoverMusicView.this.v();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(this.R);
    }
}
