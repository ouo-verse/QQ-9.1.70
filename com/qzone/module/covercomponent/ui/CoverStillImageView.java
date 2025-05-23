package com.qzone.module.covercomponent.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.module.covercomponent.manage.CoverCacheManager;
import com.qzone.module.covercomponent.utils.CoverHelper;
import com.qzone.module.covercomponent.utils.QzoneCoverSquareImageProcessor;
import com.qzone.module.covercomponent.utils.QzoneShowCutInnerSquareImageProcessor;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverJumpAction;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.covercomponent.model.LoadPhotoState;
import com.qzone.proxy.covercomponent.model.PhotoLoadedListener;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import cooperation.qzone.model.CoverCacheData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverStillImageView extends CoverBaseView implements PhotoLoadedListener {
    public static final String TAG = "CoverStillImageView";
    private volatile Drawable J;
    private Rect K;
    private CoverCacheData L;
    private CoverCacheData.GameCoverInfo M;
    private String N;
    private int P;
    private long Q;
    private int R;
    private int S;

    private void k() {
        String str;
        CoverCacheData coverCacheData;
        CoverCacheData coverCacheData2 = this.L;
        if (coverCacheData2 != null) {
            if (TextUtils.equals(coverCacheData2.type, String.valueOf(3))) {
                str = CoverHelper.getDefaultCover();
            } else {
                str = CoverCacheManager.getRightCoverUrl(this.L);
            }
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = CoverHelper.getDefaultCover();
        }
        if ((this.Q != CoverEnv.getLoginUin() || TextUtils.isEmpty(this.N) || !this.N.equals(CoverCacheManager.gLoginUserCoverUrl)) && this.L != null && this.Q == CoverEnv.getLoginUin()) {
            CoverCacheManager.gLoginUserCoverUrl = str;
            this.N = str;
        }
        loadImage(str);
        if (this.R == 5 && (coverCacheData = this.L) != null) {
            setGameInfo(coverCacheData.gameCoverInfo);
        } else {
            setGameInfo(null);
        }
    }

    @Override // com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void draw(Canvas canvas) {
        if (CoverEnv.getScreenWidth() != this.S) {
            CoverLog.i(TAG, CoverLog.USR, "mCurrentImageWidth reload");
            k();
        } else {
            if (this.J == null || this.K == null || canvas == null) {
                return;
            }
            this.J.setBounds(this.K);
            this.J.draw(canvas);
        }
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
    }

    @Override // com.qzone.proxy.covercomponent.model.PhotoLoadedListener
    public void onLoadSuccess(LoadPhotoState loadPhotoState, Drawable drawable) {
        if (CoverLog.isColorLevel()) {
            int i3 = CoverLog.CLR;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onLoadSuccess ");
            sb5.append(loadPhotoState != null ? loadPhotoState.url : null);
            CoverLog.i(TAG, i3, sb5.toString());
        }
        if (drawable != null) {
            this.J = drawable;
            postInvalidate();
        }
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView
    public void onScreenSharpnessChange() {
        super.onScreenSharpnessChange();
        k();
    }

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public void onStart() {
        k();
        super.onStart();
    }

    public void setCoverData(long j3, CoverCacheData coverCacheData, int i3, int i16) {
        this.P = i16;
        this.Q = j3;
        this.R = i3;
        this.L = coverCacheData;
        k();
    }

    public void setGameInfo(CoverCacheData.GameCoverInfo gameCoverInfo) {
        this.M = gameCoverInfo;
    }

    public CoverStillImageView() {
        super(0);
        this.N = CoverCacheManager.gLoginUserCoverUrl;
    }

    public boolean init(String str) {
        this.P = 0;
        return loadImage(str);
    }

    public boolean loadImage(String str) {
        Drawable loadImage;
        needCoverSwitch(false);
        int screenWidth = CoverEnv.getScreenWidth();
        int f16 = f();
        this.S = screenWidth;
        CoverLog.d(TAG, CoverLog.CLR, "loadImage, mCoverHeight = " + f16);
        this.K = new Rect(0, 0, screenWidth, f16);
        if (CoverLog.isColorLevel()) {
            CoverLog.d(TAG, CoverLog.CLR, "init, width=" + screenWidth + ", height=" + f16 + ", coverUrl=" + str);
        }
        int i3 = this.P;
        if (i3 == 0) {
            i3 = 3;
        }
        if (CoverHelper.isResourceUrl(str)) {
            int parseResourceUrl = CoverHelper.parseResourceUrl(str, 0);
            if (parseResourceUrl > 0) {
                try {
                    loadImage = CoverEnv.getContext().getResources().getDrawable(parseResourceUrl);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            loadImage = null;
        } else {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            obtain.needShowGifAnimation = false;
            if (i3 == 1) {
                obtain.extraProcessor = new QzoneShowCutInnerSquareImageProcessor(screenWidth, 1.0d);
            } else if (i3 == 3) {
                obtain.extraProcessor = new QzoneCoverSquareImageProcessor(0);
            }
            if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
                loadImage = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(str).g(new a.c() { // from class: com.qzone.module.covercomponent.ui.b
                    @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                    public final void a(k kVar) {
                        kVar.w(4);
                    }
                }).l(VasDynamicDrawableCache.INSTANCE).a();
            } else {
                loadImage = ImageLoader.getInstance().loadImage(str, obtain);
            }
        }
        if (loadImage == null) {
            loadPhoto(new LoadPhotoState(str, 0, i3, this));
            CoverLog.i(TAG, CoverLog.CLR, "get image drawable asyn, wait for callback: " + str + " ,photoalian=" + i3);
        } else {
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

    @Override // com.qzone.module.covercomponent.ui.CoverBaseView, com.qzone.proxy.covercomponent.ui.ICoverBaseView
    public boolean onTouchEvent(Activity activity, View view, MotionEvent motionEvent, CoverCacheData coverCacheData) {
        if (coverCacheData != null && activity != null) {
            if (!CoverEnv.isInQQ() && CoverEnv.getLoginUin() != coverCacheData.uin) {
                return super.onTouchEvent(activity, view, motionEvent, null);
            }
            float screenWidth = CoverEnv.getScreenWidth();
            float x16 = motionEvent.getX() / screenWidth;
            float y16 = (motionEvent.getY() - (r1 / 8)) / screenWidth;
            CoverCacheData.GameCoverInfo gameCoverInfo = this.M;
            if (gameCoverInfo != null) {
                double d16 = x16;
                if (d16 > gameCoverInfo.xCoordLU && d16 < gameCoverInfo.xCoordRD) {
                    double d17 = y16;
                    if (d17 > gameCoverInfo.yCoordLU && d17 < gameCoverInfo.yCoordRD) {
                        if (gameCoverInfo.jmpType == 0) {
                            CoverJumpAction.handleScheme(gameCoverInfo.jmpUrl, activity, null);
                        } else {
                            String[] split = gameCoverInfo.schema.split("\\|");
                            if (split.length == 3) {
                                String str = split[1];
                                String str2 = split[2];
                                if (CoverEnv.checkAppInstalled(activity, str)) {
                                    if (TextUtils.isEmpty(str2)) {
                                        Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(activity.getPackageManager(), str);
                                        if (launchIntentForPackage != null) {
                                            activity.startActivity(launchIntentForPackage);
                                        } else {
                                            CoverJumpAction.handleScheme(this.M.jmpUrl, activity, null);
                                        }
                                    } else {
                                        ComponentName componentName = new ComponentName(str, str2);
                                        Intent intent = new Intent();
                                        intent.setComponent(componentName);
                                        activity.startActivity(intent);
                                    }
                                } else {
                                    CoverJumpAction.handleScheme(this.M.jmpUrl, activity, null);
                                }
                            } else if (split.length == 2) {
                                String str3 = split[1];
                                if (CoverEnv.checkAppInstalled(activity, str3)) {
                                    Intent launchIntentForPackage2 = InstalledAppListMonitor.getLaunchIntentForPackage(activity.getPackageManager(), str3);
                                    if (launchIntentForPackage2 != null) {
                                        activity.startActivity(launchIntentForPackage2);
                                    } else {
                                        CoverJumpAction.handleScheme(this.M.jmpUrl, activity, null);
                                    }
                                } else {
                                    CoverJumpAction.handleScheme(this.M.jmpUrl, activity, null);
                                }
                            } else {
                                CoverJumpAction.handleScheme(this.M.jmpUrl, activity, null);
                            }
                        }
                        if (coverCacheData.uin == CoverEnv.getLoginUin()) {
                            CoverEnv.report("", "", "", false, "362", "1", "1", "", coverCacheData.coverId);
                        } else {
                            CoverEnv.report("", "", "", false, "362", "1", "2", "", coverCacheData.coverId);
                        }
                        return true;
                    }
                }
            }
            if (coverCacheData.uin != CoverEnv.getLoginUin() && CoverEnv.isUserHomeActivity(activity) && !coverCacheData.type.equals(QzoneCoverConst.CoverStringType.COVER_TYPE_CUSTOM) && !coverCacheData.mapExtInfo.containsKey(QzoneCoverConst.KEY_ACTIVITY_COVER_URL)) {
                CoverEnv.RDMCollector.addNoramlClickAction(TAG, view);
                Intent coverPreviewIntent = CoverJumpAction.getCoverPreviewIntent(coverCacheData.coverId, 2, QzoneCoverConst.REFER_USERHOME, coverCacheData.uin);
                Intent coverClickedIntentFromJceData = CoverJumpAction.getCoverClickedIntentFromJceData(coverCacheData.uin);
                if (coverClickedIntentFromJceData != null) {
                    coverPreviewIntent = coverClickedIntentFromJceData;
                }
                activity.startActivity(coverPreviewIntent);
                return true;
            }
            return super.onTouchEvent(activity, view, motionEvent, coverCacheData);
        }
        return super.onTouchEvent(activity, view, motionEvent, null);
    }
}
