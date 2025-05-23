package com.qzone.business.vip;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.e;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import yo.f;

/* loaded from: classes39.dex */
public class QZoneVIPUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final int f44890a = (int) (ViewUtils.getDensity() * 24.0f);

    public static void a(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("key_aid_star_vip", str);
        VipComponentProxy.f50997g.getUiInterface().goOpenStarVip(context, intent);
    }

    public static boolean b(int i3) {
        if ((i3 & 512) == 512) {
            return true;
        }
        return false;
    }

    public static boolean c(int i3) {
        if ((i3 & 1) == 1) {
            return true;
        }
        return false;
    }

    public static void d(final long j3, final int i3, final int i16) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.PreLoadThread).post(new Runnable() { // from class: com.qzone.business.vip.QZoneVIPUtils.2
            @Override // java.lang.Runnable
            public void run() {
                String i17 = f.i(f.i(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_VIP_PAYMENT, "https://h5.qzone.qq.com/payDialog/index/{openUin}/{openMonth}/{openVipType}?_wv=16781315&aid={aid}&_wwv=1"), "{openUin}", j3), "{openMonth}", i3), "{openVipType}", i16);
                if (TextUtils.isEmpty(e.n(i17))) {
                    try {
                        WebSoService.j().G(i17, null);
                    } catch (Exception e16) {
                        QZLog.w("preload", "preload h5 exception" + e16.toString());
                    }
                }
            }
        });
    }

    public static void e(final ImageView imageView, User user, View.OnClickListener onClickListener, Context context) {
        Drawable yellowVipIcon;
        if (user != null && user.vipLevel > 0 && user.vip != 0) {
            imageView.setVisibility(0);
            int i3 = user.vip;
            if (i3 == 1 || i3 == 2) {
                yellowVipIcon = VipComponentProxy.f50997g.getUiInterface().getYellowVipIcon(user.vipLevel, user.vip, user.isAnnualVip == 1, user.isCustomDiamond, user.customDiamondUrl, 6, 100, user.personalizedYellowVipUrl, new VipResourcesListener() { // from class: com.qzone.business.vip.QZoneVIPUtils.1
                    @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
                    public void onLoaded(final Drawable drawable) {
                        ImageView imageView2 = imageView;
                        if (imageView2 != null) {
                            imageView2.post(new Runnable() { // from class: com.qzone.business.vip.QZoneVIPUtils.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    imageView.setImageDrawable(drawable);
                                    imageView.invalidate();
                                }
                            });
                        }
                    }

                    @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
                    public void onFailed() {
                    }
                });
            } else {
                yellowVipIcon = null;
            }
            if (yellowVipIcon != null) {
                yellowVipIcon.setBounds(0, 0, yellowVipIcon.getIntrinsicWidth(), yellowVipIcon.getIntrinsicHeight());
            }
            imageView.setImageDrawable(yellowVipIcon);
            imageView.setOnClickListener(onClickListener);
            return;
        }
        imageView.setVisibility(8);
    }
}
