package com.tencent.qqlive.tvkplayer.logo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKLogoCommonDefine;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKLogoImageView;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKLogoSurfaceView;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogoUtils {
    private static final String TAG = "TVKLogoUtils";

    public static void addLogoSurfaceViewInUIThread(final TVKLogoSurfaceView tVKLogoSurfaceView, final ViewGroup viewGroup) {
        if (tVKLogoSurfaceView != null && viewGroup != null) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.utils.TVKLogoUtils.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TVKLogoUtils.addLogoSurfaceViewOnViewGroup(TVKLogoSurfaceView.this, viewGroup);
                    }
                });
                return;
            } else {
                addLogoSurfaceViewOnViewGroup(tVKLogoSurfaceView, viewGroup);
                return;
            }
        }
        TVKLogUtil.i(TAG, "logoSurfaceView:" + tVKLogoSurfaceView + "or viewGroup:" + viewGroup + " is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addLogoSurfaceViewOnViewGroup(TVKLogoSurfaceView tVKLogoSurfaceView, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        try {
            ViewGroup viewGroup2 = (ViewGroup) tVKLogoSurfaceView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(tVKLogoSurfaceView);
            }
            viewGroup.addView(tVKLogoSurfaceView, layoutParams);
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
        }
    }

    public static void clearCanvas(Canvas canvas) {
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPaint(paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        TVKLogUtil.i(TAG, "clear canvas complete");
    }

    public static void clearSurface(Context context, SurfaceView surfaceView) {
        Canvas lockCanvas;
        TVKLogUtil.i(TAG, "clear surface canvas start");
        if (isSupportLogoHardWareAccelerate(context)) {
            lockCanvas = surfaceView.getHolder().lockHardwareCanvas();
            TVKLogUtil.i(TAG, "logoShowSurface, lockHardwareCanvas");
        } else {
            lockCanvas = surfaceView.getHolder().lockCanvas();
        }
        if (lockCanvas != null) {
            clearCanvas(lockCanvas);
            surfaceView.getHolder().unlockCanvasAndPost(lockCanvas);
            TVKLogUtil.i(TAG, "clear surface canvas success");
            return;
        }
        TVKLogUtil.i(TAG, "canvas is null, clear surface canvas failed");
    }

    public static boolean drawCanvas(Canvas canvas, int i3, int i16, List<TVKLogoCommonDefine.LogoShowUIInfo> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    clearCanvas(canvas);
                    boolean z16 = true;
                    for (int i17 = 0; i17 < list.size(); i17++) {
                        TVKLogoCommonDefine.LogoShowUIInfo logoShowUIInfo = list.get(i17);
                        if (logoShowUIInfo.getImageView() != null && logoShowUIInfo.getImageView().getBitmap() != null && logoShowUIInfo.isNeedShow()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("drawCanvas, logoLeft=");
                            float f16 = i3;
                            sb5.append((int) ((f16 - logoShowUIInfo.getRightX()) - logoShowUIInfo.getLogoWidth()));
                            sb5.append(", logoTop=");
                            sb5.append((int) logoShowUIInfo.getRightY());
                            sb5.append(", logoRight=");
                            sb5.append((int) (f16 - logoShowUIInfo.getRightX()));
                            sb5.append(", logoBottom=");
                            sb5.append((int) (logoShowUIInfo.getRightY() + logoShowUIInfo.getLogoHeight()));
                            sb5.append(", canvas=");
                            sb5.append(canvas);
                            TVKLogUtil.i(TAG, sb5.toString());
                            Paint paint = new Paint();
                            paint.setAlpha((logoShowUIInfo.getAlpha() * 255) / 100);
                            paint.setFilterBitmap(true);
                            Bitmap bitmap = logoShowUIInfo.getImageView().getBitmap();
                            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect((int) ((f16 - logoShowUIInfo.getRightX()) - logoShowUIInfo.getLogoWidth()), (int) logoShowUIInfo.getRightY(), (int) (f16 - logoShowUIInfo.getRightX()), (int) (logoShowUIInfo.getRightY() + logoShowUIInfo.getLogoHeight())), paint);
                        }
                        z16 = false;
                    }
                    return z16;
                }
            } catch (Exception e16) {
                TVKLogUtil.e(TAG, e16);
                return false;
            }
        }
        TVKLogUtil.e(TAG, "draw canvas, logo info is null or empty");
        return false;
    }

    public static boolean drawImageViews(ViewGroup viewGroup, List<TVKLogoCommonDefine.LogoShowUIInfo> list) {
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                TVKLogoCommonDefine.LogoShowUIInfo logoShowUIInfo = list.get(i3);
                TVKLogoImageView imageView = logoShowUIInfo.getImageView();
                if (logoShowUIInfo.isNeedShow() && imageView != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) logoShowUIInfo.getLogoWidth(), (int) logoShowUIInfo.getLogoHeight());
                    layoutParams.setMargins(0, (int) logoShowUIInfo.getRightY(), (int) logoShowUIInfo.getRightX(), 0);
                    layoutParams.gravity = 53;
                    ViewGroup viewGroup2 = (ViewGroup) imageView.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(imageView);
                        viewGroup.addView(imageView, layoutParams);
                    } else {
                        viewGroup.addView(imageView, layoutParams);
                    }
                    TVKLogoGraduallyShowTask.newTask(imageView, logoShowUIInfo.getAlpha());
                }
            }
            return true;
        }
        TVKLogUtil.e(TAG, "drawImageViews, logo info is null or empty");
        return false;
    }

    private static boolean isInLogoHardWareAccelerateWhiteList(Context context) {
        if (TextUtils.isEmpty(TVKMediaPlayerConfig.PlayerConfig.logo_hardware_accelerate_chip_list)) {
            return false;
        }
        String cpuChipModel = TVKVcSystemInfo.getCpuChipModel(context);
        if (TextUtils.isEmpty(cpuChipModel)) {
            return false;
        }
        for (String str : TVKMediaPlayerConfig.PlayerConfig.logo_hardware_accelerate_chip_list.split(",")) {
            if (cpuChipModel.equalsIgnoreCase(str)) {
                TVKLogUtil.i(TAG, "TVKLogoConfig logo hardware accelerate chip in white list!");
                return true;
            }
        }
        return false;
    }

    public static boolean isSupportLogoHardWareAccelerate(Context context) {
        if (isInLogoHardWareAccelerateWhiteList(context)) {
            TVKLogUtil.i(TAG, "chip in hardware accelerate whitelist!");
            return true;
        }
        if (Build.VERSION.SDK_INT >= 28 && TVKMediaPlayerConfig.PlayerConfig.enable_logo_draw_hardware && !"SM-G9350".equals(TVKVcSystemInfo.getDeviceModel())) {
            TVKLogUtil.i(TAG, "TVKLogoConfig use hardware");
            return true;
        }
        return false;
    }

    public static Canvas lockCanvasFromSurfaceView(Context context, SurfaceView surfaceView) {
        Canvas lockHardwareCanvas;
        if (isSupportLogoHardWareAccelerate(context)) {
            TVKLogUtil.i(TAG, "logoShowSurface, lockHardwareCanvas");
            lockHardwareCanvas = surfaceView.getHolder().lockHardwareCanvas();
            return lockHardwareCanvas;
        }
        return surfaceView.getHolder().lockCanvas();
    }
}
