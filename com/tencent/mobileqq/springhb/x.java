package com.tencent.mobileqq.springhb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.springhb.entry.model.GameCenterConfigData;
import com.tencent.mobileqq.springhb.pack.PackInfo;
import com.tencent.mobileqq.springhb.preload.SpringHbZipMappingBean;
import com.tencent.mobileqq.springhb.prize.SpringPrizeFragment;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import eipc.EIPCResult;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class x {
    static IPatchRedirector $redirector_;

    public static boolean c(PackInfo packInfo) {
        int i3;
        if (packInfo != null && ((i3 = packInfo.type) == 1 || i3 == 2 || i3 == 102)) {
            return true;
        }
        return false;
    }

    public static PackInfo d() {
        PackInfo packInfo = new PackInfo();
        packInfo.f289475id = "";
        packInfo.bizId = "";
        packInfo.businessVideo = "";
        packInfo.type = 102;
        packInfo.wishing = "\u795d\u4f60\u65b0\u6625\u5feb\u4e50\uff0c\u5154\u5e74\u884c\u5927\u8fd0";
        packInfo.url = "";
        packInfo.businessNamePic = "";
        GameCenterConfigData h16 = com.tencent.mobileqq.springhb.prize.h.h();
        if (h16 != null) {
            packInfo.businessCover = h16.fallbackWallpaperResUrl;
        }
        packInfo.couponName = "QQ\u5154\u5e74\u798f\u5361";
        return packInfo;
    }

    public static int e() {
        try {
            return QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeInt("spring_hb_util_key_scene_type", -1);
        } catch (Exception e16) {
            QLog.e("SpringHb_SpringHbUtil", 1, "getCurrentSceneType exception=", e16);
            return -1;
        }
    }

    public static int f() {
        try {
            return QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeInt("spring_hb_util_key_remain_seconds", 0);
        } catch (Exception e16) {
            QLog.e("SpringHb_SpringHbUtil", 1, "getRemainSeconds exception=", e16);
            return 0;
        }
    }

    public static void g() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.v
            @Override // java.lang.Runnable
            public final void run() {
                x.i();
            }
        }, 64, null, false);
    }

    public static void h(Activity activity, PackInfo packInfo, int i3, boolean z16, int i16, String str) {
        boolean z17 = false;
        QLog.d("SpringHb_SpringHbUtil", 1, "jumpToGiftResultPage, context=", activity, ", packInfo=", packInfo, ", sceneType:", Integer.valueOf(i3), " , isLandscape=", Boolean.valueOf(z16), " , prizeType=", Integer.valueOf(i16));
        if (activity == null) {
            return;
        }
        com.tencent.mobileqq.springhb.prize.ad.e(packInfo, i3);
        String lowerCase = packInfo.url.toLowerCase();
        if (lowerCase.startsWith("http://") || lowerCase.startsWith("https://") || packInfo.isH5) {
            z17 = true;
        }
        boolean startsWith = lowerCase.startsWith("mqqapi:");
        if (c(packInfo)) {
            Intent intent = new Intent();
            intent.putExtra("extra_pack_info", packInfo);
            intent.putExtra("extra_scene_type", i3);
            intent.putExtra("extra_from_src", str);
            intent.putExtra("extra_prize_type", i16);
            intent.putExtra("public_fragment_window_feature", 1);
            QPublicFragmentActivity.b.b(activity, intent, QPublicTransFragmentActivity.class, SpringPrizeFragment.class);
            return;
        }
        if (z17) {
            QLog.d("SpringHb_SpringHbUtil", 1, "jumpToGiftResultPage, to h5 page");
            k(activity, packInfo, i3, str);
            return;
        }
        if (startsWith) {
            QLog.d("SpringHb_SpringHbUtil", 1, "jumpToGiftResultPage, to hippy coupon page");
            String str2 = packInfo.url;
            if (!TextUtils.isEmpty(str2)) {
                str2 = URLUtil.addParameter(URLUtil.addParameter(str2, "REMAININGTIME", String.valueOf(packInfo.remainSeconds * 1000)), "source", str);
            }
            m(activity, str2);
            return;
        }
        PackInfo d16 = d();
        Intent intent2 = new Intent();
        intent2.putExtra("extra_pack_info", d16);
        intent2.putExtra("extra_scene_type", i3);
        intent2.putExtra("extra_from_src", str);
        intent2.putExtra("extra_prize_type", i16);
        intent2.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.b.b(activity, intent2, QPublicTransFragmentActivity.class, SpringPrizeFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i() {
        Bundle bundle;
        Bundle bundle2;
        try {
            QLog.i("SpringHb_SpringHbUtil", 1, "initSpringResList");
            EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "SpringHbIPCModule", "GetSpringHbPreloadDomain", null);
            if (callServer != null && (bundle2 = callServer.data) != null && callServer.code != -102) {
                List<? extends IPreloadResource> list = (List) bundle2.getSerializable("res_list");
                List<? extends SpringHbZipMappingBean> list2 = (List) callServer.data.getSerializable("mapping_list");
                if (list != null && list2 != null) {
                    QLog.i("SpringHb_SpringHbUtil", 1, "initSpringResList, updateResourceList");
                    com.tencent.mobileqq.springhb.preload.r.f289531a.m(list, list2);
                }
            }
            EIPCResult callServer2 = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "SpringHbIPCModule", "GetGameCenterPreloadDomain", null);
            if (callServer2 != null && (bundle = callServer2.data) != null && callServer2.code != -102) {
                List<? extends IPreloadResource> list3 = (List) bundle.getSerializable("res_list");
                List<? extends SpringHbZipMappingBean> list4 = (List) callServer2.data.getSerializable("mapping_list");
                if (list3 != null && list4 != null) {
                    QLog.i("SpringHb_SpringHbUtil", 1, "initSpringResList, updateResourceList");
                    com.tencent.mobileqq.springhb.preload.r.f289531a.l(list3, list4);
                }
            }
        } catch (Exception e16) {
            QLog.e("SpringHb_SpringHbUtil", 2, "initSpringResList exception=", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        view.setVisibility(0);
        view.startAnimation(translateAnimation);
    }

    private static void k(Activity activity, PackInfo packInfo, int i3, String str) {
        o(i3, packInfo.remainSeconds);
        Intent intent = new Intent();
        String str2 = packInfo.url;
        if (!TextUtils.isEmpty(str2)) {
            str2 = URLUtil.addParameter(URLUtil.addParameter(str2, "REMAININGTIME", String.valueOf(packInfo.remainSeconds * 1000)), "source", str);
        }
        intent.putExtra("url", str2);
        RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    public static void l(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("SpringHb_SpringHbUtil", 1, "openSchema error, schema is null!");
            return;
        }
        try {
            ax c16 = bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), BaseApplication.getContext(), str);
            if (c16 == null) {
                QLog.e("SpringHb_SpringHbUtil", 1, "openSchema error, action is null! schema = ", str);
            } else {
                c16.b();
            }
        } catch (Throwable th5) {
            QLog.e("SpringHb_SpringHbUtil", 1, "[openSchema], th:", th5);
        }
    }

    public static void m(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("SpringHb_SpringHbUtil", 1, "openSchema error, schema is null!");
            return;
        }
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                ax c16 = bi.c((QQAppInterface) runtime, BaseApplication.getContext(), str);
                if (c16 == null) {
                    QLog.e("SpringHb_SpringHbUtil", 1, "openSchema error, action is null! schema = ", str);
                    return;
                } else {
                    c16.b();
                    return;
                }
            }
            n(activity, str);
        } catch (Throwable th5) {
            QLog.e("SpringHb_SpringHbUtil", 1, "[openSchema], th:", th5);
        }
    }

    public static void n(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && activity != null) {
            if (!str.startsWith("http") && !str.startsWith("https")) {
                if (str.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
                    Intent intent = new Intent(activity, (Class<?>) JumpActivity.class);
                    intent.setData(Uri.parse(str));
                    activity.startActivity(intent);
                    return;
                }
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("url", str);
            RouteUtils.startActivity(activity, intent2, RouterConstants.UI_ROUTE_BROWSER);
        }
    }

    public static void o(int i3, int i16) {
        QLog.d("SpringHb_SpringHbUtil", 1, "setCurrentRemainSeconds sceneType=", Integer.valueOf(i3), ", remainSeconds=", Integer.valueOf(i16));
        try {
            QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeInt("spring_hb_util_key_scene_type", i3).encodeInt("spring_hb_util_key_remain_seconds", i16);
        } catch (Exception e16) {
            QLog.e("SpringHb_SpringHbUtil", 1, "setCurrentRemainSeconds exception=", e16);
        }
    }

    public static void p(final View view) {
        if (view != null) {
            view.setVisibility(4);
            view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.springhb.w
                @Override // java.lang.Runnable
                public final void run() {
                    x.j(view);
                }
            }, 300L);
        }
    }

    public static void q(Context context) {
        if (context == null) {
            return;
        }
        if (!i.f289200a.a()) {
            QLog.d("SpringHb_SpringHbUtil", 1, "vibrate cancle");
        } else {
            ((Vibrator) context.getSystemService("vibrator")).vibrate(300L);
        }
    }
}
