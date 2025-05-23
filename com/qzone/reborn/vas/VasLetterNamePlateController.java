package com.qzone.reborn.vas;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.proxy.vipcomponent.model.QzoneVipInfo;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.ui.IVipFrameDrawable;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import cooperation.qzone.util.ProcessUtils;
import cooperation.vip.manager.i;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import gf.o;
import java.util.Arrays;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import yo.d;
import yo.f;

/* loaded from: classes37.dex */
public class VasLetterNamePlateController {

    /* renamed from: a, reason: collision with root package name */
    private o f59561a;

    /* renamed from: b, reason: collision with root package name */
    private IVipFrameDrawable f59562b;

    /* renamed from: c, reason: collision with root package name */
    private IVipFrameDrawable f59563c;

    private String g(QzoneVipInfo qzoneVipInfo, String str, JSONObject jSONObject) {
        String optString;
        if (!TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        if (qzoneVipInfo.getVipType() == 1) {
            if (qzoneVipInfo.isAnnualVip()) {
                optString = jSONObject.optString("AnnualVIPNameplate", "");
            } else {
                optString = jSONObject.optString("VIPNameplate", "");
            }
        } else if (qzoneVipInfo.isAnnualVip()) {
            optString = jSONObject.optString("AnnualLuxuryVIPNameplate", "");
        } else {
            optString = jSONObject.optString("LuxuryVIPNameplate", "");
        }
        return optString.replace("{vipLevel}", String.valueOf(qzoneVipInfo.getVipLevel()));
    }

    private String i() {
        if (QQTheme.isNowSimpleUI()) {
            return "jhan_ggtncjianjie";
        }
        return "jhan_ggtncputong";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Context context, QzoneVipInfo qzoneVipInfo, boolean z16) {
        String string = context.getResources().getString(qzoneVipInfo.getVipType() > 0 ? R.string.h_9 : R.string.gpz);
        if (z16) {
            String j3 = f.j(f.i(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UNION_VIP_PAY_URL, QzoneConfig.DEFAULT_UNION_VIP_PAY_URL), "{openUin}", LoginData.getInstance().getUin()), "{openMonth}", 3L), "{aid}", i());
            o oVar = this.f59561a;
            if (oVar != null) {
                d.p(oVar.getActivity(), j3, -1, null, null, null);
                return;
            }
            return;
        }
        o oVar2 = this.f59561a;
        if (oVar2 == null) {
            return;
        }
        Activity activity = oVar2.getActivity();
        if (activity == null) {
            activity = ProcessUtils.getTopActivity();
        }
        if (activity != null) {
            ak.Q(activity, ak.p(activity, i(), qzoneVipInfo.getVipType(), string, false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), 101);
        }
    }

    private void o(String str, final ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IVipFrameDrawable iVipFrameDrawable = this.f59563c;
        if (iVipFrameDrawable != null) {
            w(imageView, iVipFrameDrawable.getDrawable());
        }
        ((IVipIconUtils) QRoute.api(IVipIconUtils.class)).getQzoneNamePlateDrawable("[\"" + str + "\"]", new Function1() { // from class: com.qzone.reborn.vas.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l3;
                l3 = VasLetterNamePlateController.this.l(imageView, (IVipFrameDrawable) obj);
                return l3;
            }
        });
    }

    private void p(String str, final ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IVipFrameDrawable iVipFrameDrawable = this.f59562b;
        if (iVipFrameDrawable != null) {
            w(imageView, iVipFrameDrawable.getDrawable());
        }
        ((IVipIconUtils) QRoute.api(IVipIconUtils.class)).getQzoneNamePlateDrawable(str, new Function1() { // from class: com.qzone.reborn.vas.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m3;
                m3 = VasLetterNamePlateController.this.m(imageView, (IVipFrameDrawable) obj);
                return m3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(QQUnionIconInfo qQUnionIconInfo, String str, Drawable drawable, ImageView imageView, boolean z16, Drawable drawable2) {
        String carouselUrls = QQUnionIconInfo.getCarouselUrls(qQUnionIconInfo);
        if (!TextUtils.isEmpty(carouselUrls)) {
            p(carouselUrls, imageView);
            return;
        }
        String tenYellowId = QQUnionIconInfo.getTenYellowId(qQUnionIconInfo);
        if (!TextUtils.isEmpty(tenYellowId)) {
            r(tenYellowId, imageView, str, qQUnionIconInfo.mIconHeight);
        } else if (!z16) {
            o(str, imageView);
        } else {
            imageView.setImageDrawable(drawable2);
        }
    }

    private void r(String str, ImageView imageView, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IVipIconUtils) QRoute.api(IVipIconUtils.class)).setQzoneLetterSwitchIcon(imageView, str2, Arrays.asList(str.split("#")), "bg.png", "fc.png", i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(QzoneVipInfo qzoneVipInfo, int i3, String str, int i16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(StartupReportKey.PLATFORM_ID, 1);
            jSONObject.put("user_type", h(qzoneVipInfo));
            jSONObject.put("aid", i());
        } catch (JSONException e16) {
            QLog.e("VasLetterNamePlateController", 1, e16, new Object[0]);
        }
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(LpReportInfo_dc04586.APPID, LpReportInfo_dc04586.PAGE_ID_CONCISE_HEADER, LpReportInfo_dc04586.MODULE_ID_CONCISE_HEADER, i3 + "", str, "", "4", i16, 0, 0, "", jSONObject.toString(), "");
    }

    private void w(ImageView imageView, Drawable drawable) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = (drawable.getIntrinsicWidth() * ar.d(20.0f)) / drawable.getIntrinsicHeight();
        layoutParams.height = ar.d(20.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(drawable);
    }

    public void u(o oVar) {
        this.f59561a = oVar;
    }

    public void v(final ImageView imageView, final Drawable drawable) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.vas.a
            @Override // java.lang.Runnable
            public final void run() {
                VasLetterNamePlateController.this.n(imageView, drawable);
            }
        }, 16, null, true);
    }

    private int h(QzoneVipInfo qzoneVipInfo) {
        if (qzoneVipInfo == null) {
            return -1;
        }
        if (qzoneVipInfo.getVipType() == 0) {
            return 0;
        }
        if (qzoneVipInfo.getVipType() == 1) {
            return qzoneVipInfo.isAnnualVip() ? 2 : 1;
        }
        if (qzoneVipInfo.getVipType() == 2) {
            return qzoneVipInfo.isAnnualVip() ? 4 : 3;
        }
        return -1;
    }

    private String j(Map<String, QQUnionIconInfo> map, String str) {
        QQUnionIconInfo qQUnionIconInfo;
        return (map == null || (qQUnionIconInfo = map.get("feed_icon")) == null || TextUtils.isEmpty(qQUnionIconInfo.mIconUrl) || qQUnionIconInfo.mIconWidth <= 0 || qQUnionIconInfo.mIconHeight <= 0) ? str : qQUnionIconInfo.mIconUrl;
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void n(final ImageView imageView, final Drawable drawable) {
        int i3;
        String str;
        int i16;
        boolean z16;
        Drawable drawable2;
        boolean z17;
        final String str2;
        final int i17;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        x6.a g16 = z5.a.f().g(peekAppRuntime.getLongAccountUin());
        final QzoneVipInfo currentVipInfo = VipComponentProxy.f50997g.getServiceInterface().getCurrentVipInfo();
        JSONObject jsonString = VasToggle.VAS_QZONE_NAMEPLATE.getJsonString();
        boolean optBoolean = jsonString != null ? jsonString.optBoolean("isShowGrayNameplate", false) : false;
        if (currentVipInfo.getVipType() <= 0) {
            i3 = 0;
            str = "";
        } else {
            str = j(currentVipInfo.getQQNewVipIconMap(), "");
            i3 = 3;
        }
        if (TextUtils.isEmpty(str) && i.r().G()) {
            str = j(currentVipInfo.getQQUnionVipIconMap(), str);
            i16 = 4;
            z16 = true;
        } else {
            i16 = i3;
            z16 = false;
        }
        if (TextUtils.isEmpty(str) && g16 != null && g16.isCustomDiamondUser) {
            str = g16.customDiamondUrl;
            i16 = 5;
            drawable2 = l15.a.a().c(currentVipInfo.getVipLevel(), currentVipInfo.getVipType(), currentVipInfo.isAnnualVip(), true, g16.customDiamondUrl, 8, new VipResourcesListener() { // from class: com.qzone.reborn.vas.VasLetterNamePlateController.1
                @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
                public void onLoaded(final Drawable drawable3) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.reborn.vas.VasLetterNamePlateController.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.setImageDrawable(drawable3);
                        }
                    });
                }

                @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
                public void onFailed() {
                    QLog.w("VasLetterNamePlateController", 1, "VipResourcesListener failed");
                }
            });
            z17 = true;
        } else {
            drawable2 = null;
            z17 = false;
        }
        if (currentVipInfo.getVipType() > 0) {
            if (TextUtils.isEmpty(str)) {
                str2 = g(currentVipInfo, str, jsonString);
                i17 = 2;
            }
            str2 = str;
            i17 = i16;
        } else {
            if (optBoolean) {
                String optString = jsonString.optString("GrayNameplate", "");
                if (!TextUtils.isEmpty(optString)) {
                    optString = optString.replace("{vipLevel}", String.valueOf(currentVipInfo.getVipLevel() > 0 ? currentVipInfo.getVipLevel() : 1));
                }
                str2 = optString;
                i17 = 1;
            }
            str2 = str;
            i17 = i16;
        }
        final QQUnionIconInfo g17 = cooperation.vip.vipcomponent.util.c.g(8, currentVipInfo.getVipLevel(), currentVipInfo.getQQNewVipIconMap());
        final boolean z18 = z16;
        final boolean z19 = z17;
        final Drawable drawable3 = drawable2;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.reborn.vas.VasLetterNamePlateController.2

            /* renamed from: com.qzone.reborn.vas.VasLetterNamePlateController$2$a */
            /* loaded from: classes37.dex */
            class a implements View.OnClickListener {
                a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    VasLetterNamePlateController.this.t(currentVipInfo, i17, str2, 102);
                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                    VasLetterNamePlateController vasLetterNamePlateController = VasLetterNamePlateController.this;
                    Context context = imageView.getContext();
                    AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                    vasLetterNamePlateController.k(context, currentVipInfo, z18);
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str2) && VasToggle.VAS_QZONE_NAMEPLATE.isEnable(true)) {
                    imageView.setVisibility(0);
                    VasLetterNamePlateController.this.t(currentVipInfo, i17, str2, 101);
                    imageView.setOnClickListener(new a());
                    VasLetterNamePlateController.this.q(g17, str2, drawable, imageView, z19, drawable3);
                    return;
                }
                imageView.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit l(ImageView imageView, IVipFrameDrawable iVipFrameDrawable) {
        if (iVipFrameDrawable == null) {
            return null;
        }
        Drawable drawable = iVipFrameDrawable.getDrawable();
        if (drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) {
            this.f59563c = iVipFrameDrawable;
            w(imageView, drawable);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit m(ImageView imageView, IVipFrameDrawable iVipFrameDrawable) {
        if (iVipFrameDrawable == null) {
            return null;
        }
        Drawable drawable = iVipFrameDrawable.getDrawable();
        if (drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) {
            this.f59562b = iVipFrameDrawable;
            w(imageView, drawable);
        }
        return null;
    }
}
