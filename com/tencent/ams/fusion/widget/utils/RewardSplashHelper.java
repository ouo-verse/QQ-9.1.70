package com.tencent.ams.fusion.widget.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RewardSplashHelper {
    static IPatchRedirector $redirector_ = null;
    public static final int REWARD_ICON_VISIBLE_HEIGHT_DP = 105;

    public RewardSplashHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addRewardImageLayer(Context context, Bitmap bitmap, List<AnimatorLayer> list, float f16, float f17, float f18, float f19) {
        if (context != null && list != null) {
            if (bitmap != null && !bitmap.isRecycled()) {
                int i3 = (int) f18;
                int i16 = (int) f19;
                try {
                    Bitmap scaleBitmapSafe = Utils.scaleBitmapSafe(bitmap, i3, i16);
                    BitmapLayer bitmapLayer = new BitmapLayer();
                    bitmapLayer.setBitmap(scaleBitmapSafe);
                    bitmapLayer.setX(f16);
                    bitmapLayer.setY(f17);
                    bitmapLayer.setWidth(i3);
                    bitmapLayer.setHeight(i16);
                    bitmapLayer.setAnimator(new KeepAnimator(bitmapLayer));
                    list.add(bitmapLayer);
                    return;
                } catch (Throwable th5) {
                    Logger.e("addRewardImageLayer\uff0cerror:", th5);
                    return;
                }
            }
            Logger.e("addRewardImageLayer\uff0c imageBitmap == null");
            return;
        }
        Logger.e("addRewardImageLayer\uff0c invalid params");
    }
}
