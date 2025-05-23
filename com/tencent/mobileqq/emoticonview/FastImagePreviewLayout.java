package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.List;
import mqq.os.MqqHandler;

/* loaded from: classes12.dex */
public class FastImagePreviewLayout extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    public static final long SHOW_TIMEOUT = 2000;
    static String TAG;
    final String CACHE_IMAGE;
    Context context;
    float density;
    URLDrawable fastImgDrawable;
    MqqHandler mHandler;
    long mPicTimeInterval;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71651);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            TAG = FastImagePreviewLayout.class.getSimpleName();
        }
    }

    public FastImagePreviewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.CACHE_IMAGE = "/tencent/zebra/cache/";
        this.mPicTimeInterval = 0L;
        this.fastImgDrawable = null;
        this.context = context;
        this.density = context.getResources().getDisplayMetrics().density;
    }

    public void queryFastImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.FastImagePreviewLayout.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FastImagePreviewLayout.this);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:61:0x019e  */
                /* JADX WARN: Removed duplicated region for block: B:64:0x01de  */
                /* JADX WARN: Removed duplicated region for block: B:75:0x022b  */
                /* JADX WARN: Removed duplicated region for block: B:78:0x024e  */
                /* JADX WARN: Removed duplicated region for block: B:95:0x0275  */
                /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    Drawable drawable;
                    long j3;
                    FastImagePreviewLayout fastImagePreviewLayout;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SystemClock.elapsedRealtime();
                    if (QLog.isColorLevel()) {
                        QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage called start!");
                    }
                    List<LocalMediaInfo> n3 = com.tencent.mobileqq.utils.e.n(FastImagePreviewLayout.this.context, 210, 1, MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
                    if (n3 != null && n3.size() > 0) {
                        LocalMediaInfo localMediaInfo = n3.get(0);
                        if (QLog.isColorLevel()) {
                            QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage, imageInfo.path = " + localMediaInfo.path);
                        }
                        String str = PlusPanelUtils.f179797b;
                        if (str != null && str.equals(localMediaInfo.path)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage return 1");
                                return;
                            }
                            return;
                        }
                        PlusPanelUtils.f179797b = localMediaInfo.path;
                        if (PlusPanelUtils.f179797b.equals(BaseApplication.getContext().getSharedPreferences(PeakConstants.PRESEND_CONFIG_SP, 4).getString(PeakConstants.SHOT_PHOTO_PATH, ""))) {
                            if (QLog.isColorLevel()) {
                                QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage return 2\uff0cpeak shot photo");
                                return;
                            }
                            return;
                        }
                        String str2 = PlusPanelUtils.f179796a;
                        if (str2 != null && PlusPanelUtils.f179797b.equals(str2)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage return 2.dataline shot photo");
                                return;
                            }
                            return;
                        }
                        if (localMediaInfo.path.contains("/tencent/zebra/cache/")) {
                            if (QLog.isColorLevel()) {
                                QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage return 3");
                                return;
                            }
                            return;
                        }
                        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("send_fast_image_check_pic_type_before_preview", true) && !FileUtils.isPicFile(localMediaInfo.path)) {
                            QLog.i(FastImagePreviewLayout.TAG, 1, "queryFastImage, unsupported pic file, path=" + localMediaInfo.path);
                            return;
                        }
                        ColorDrawable colorDrawable = new ColorDrawable(570425344);
                        try {
                            drawable = FastImagePreviewLayout.this.context.getResources().getDrawable(R.drawable.asd);
                        } catch (NullPointerException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage NullPointerException = " + e16);
                            }
                            drawable = null;
                            URL generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(localMediaInfo);
                            int i3 = AlbumThumbDownloader.THUMB_WIDHT;
                            localMediaInfo.thumbHeight = i3;
                            localMediaInfo.thumbWidth = i3;
                            long currentTimeMillis = System.currentTimeMillis();
                            j3 = currentTimeMillis - (localMediaInfo.addedDate * 1000);
                            if (QLog.isColorLevel()) {
                            }
                            if (FastImagePreviewLayout.this.mPicTimeInterval == 0) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            fastImagePreviewLayout = FastImagePreviewLayout.this;
                            if (j3 < fastImagePreviewLayout.mPicTimeInterval) {
                            }
                            if (!QLog.isColorLevel()) {
                            }
                        } catch (OutOfMemoryError e17) {
                            if (QLog.isColorLevel()) {
                                QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage OutOfMemoryError = " + e17);
                            }
                            drawable = null;
                            URL generateAlbumThumbURL2 = QAlbumUtil.generateAlbumThumbURL(localMediaInfo);
                            int i36 = AlbumThumbDownloader.THUMB_WIDHT;
                            localMediaInfo.thumbHeight = i36;
                            localMediaInfo.thumbWidth = i36;
                            long currentTimeMillis2 = System.currentTimeMillis();
                            j3 = currentTimeMillis2 - (localMediaInfo.addedDate * 1000);
                            if (QLog.isColorLevel()) {
                            }
                            if (FastImagePreviewLayout.this.mPicTimeInterval == 0) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            fastImagePreviewLayout = FastImagePreviewLayout.this;
                            if (j3 < fastImagePreviewLayout.mPicTimeInterval) {
                            }
                            if (!QLog.isColorLevel()) {
                            }
                        } catch (EmptyStackException e18) {
                            if (QLog.isColorLevel()) {
                                QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage EmptyStackException = " + e18);
                            }
                            drawable = null;
                            URL generateAlbumThumbURL22 = QAlbumUtil.generateAlbumThumbURL(localMediaInfo);
                            int i362 = AlbumThumbDownloader.THUMB_WIDHT;
                            localMediaInfo.thumbHeight = i362;
                            localMediaInfo.thumbWidth = i362;
                            long currentTimeMillis22 = System.currentTimeMillis();
                            j3 = currentTimeMillis22 - (localMediaInfo.addedDate * 1000);
                            if (QLog.isColorLevel()) {
                            }
                            if (FastImagePreviewLayout.this.mPicTimeInterval == 0) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                            fastImagePreviewLayout = FastImagePreviewLayout.this;
                            if (j3 < fastImagePreviewLayout.mPicTimeInterval) {
                            }
                            if (!QLog.isColorLevel()) {
                            }
                        }
                        URL generateAlbumThumbURL222 = QAlbumUtil.generateAlbumThumbURL(localMediaInfo);
                        int i3622 = AlbumThumbDownloader.THUMB_WIDHT;
                        localMediaInfo.thumbHeight = i3622;
                        localMediaInfo.thumbWidth = i3622;
                        long currentTimeMillis222 = System.currentTimeMillis();
                        j3 = currentTimeMillis222 - (localMediaInfo.addedDate * 1000);
                        if (QLog.isColorLevel()) {
                            QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage called, spentTime = " + j3 + ",currentTime = " + currentTimeMillis222 + ",addedTime = " + localMediaInfo.addedDate + ",modifiedTime = " + localMediaInfo.modifiedDate);
                        }
                        if (FastImagePreviewLayout.this.mPicTimeInterval == 0) {
                            try {
                                FastImagePreviewLayout.this.mPicTimeInterval = Long.valueOf(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_fastimage.name(), "120000")).longValue();
                            } catch (NumberFormatException e19) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage NumberFormatException = " + e19);
                                }
                                FastImagePreviewLayout.this.mPicTimeInterval = 120000L;
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage called, mPicTimeInterval = " + FastImagePreviewLayout.this.mPicTimeInterval);
                        }
                        fastImagePreviewLayout = FastImagePreviewLayout.this;
                        if (j3 < fastImagePreviewLayout.mPicTimeInterval) {
                            fastImagePreviewLayout.fastImgDrawable = URLDrawableHelper.getDrawable(generateAlbumThumbURL222, colorDrawable, drawable);
                            FastImagePreviewLayout.this.fastImgDrawable.setTag(localMediaInfo);
                            FastImagePreviewLayout.this.fastImgDrawable.startDownload();
                            MqqHandler mqqHandler = FastImagePreviewLayout.this.mHandler;
                            mqqHandler.sendMessage(mqqHandler.obtainMessage(32));
                        }
                    }
                    if (!QLog.isColorLevel()) {
                        QLog.d(FastImagePreviewLayout.TAG, 2, "queryFastImage called end!");
                    }
                }
            });
        }
    }

    public void removeFastImage(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeFastImage called");
        }
        setVisibility(8);
        if (z16) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            setAnimation(alphaAnimation);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setFillAfter(true);
            startAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.emoticonview.FastImagePreviewLayout.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FastImagePreviewLayout.this);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) animation);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(FastImagePreviewLayout.TAG, 2, "removeFastImage fadeoutanimation ended");
                    }
                    FastImagePreviewLayout.this.removeAllViews();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animation);
                    }
                }
            });
            return;
        }
        removeAllViews();
    }

    public void setHandler(MqqHandler mqqHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mqqHandler);
        } else {
            this.mHandler = mqqHandler;
        }
    }

    public void showFastImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showFastImage called, path = " + PlusPanelUtils.f179797b);
        }
        removeAllViews();
        View inflate = View.inflate(this.context, R.layout.f167595bf, null);
        ((ImageView) inflate.findViewById(R.id.c2x)).setImageDrawable(this.fastImgDrawable);
        addView(inflate);
        setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        setAnimation(alphaAnimation);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setFillAfter(true);
        startAnimation(alphaAnimation);
    }
}
