package com.tencent.mobileqq.guild.vas.panel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.guild.t;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.vas.panel.b;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GroupGiftItem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

/* loaded from: classes33.dex */
public class GiftPanelController extends com.tencent.mobileqq.guild.vas.panel.a implements PopupWindow.OnDismissListener {
    private static final int N = ViewUtils.dpToPx(15.0f);
    private PopupWindow C;
    private QQViewPager D;
    private LinearLayout E;
    private View F;
    private j12.a G;
    private RelativeLayout H;
    private TextView I;
    private View J;
    private long K;
    private String L;
    private WeakReference<Activity> M;

    /* renamed from: m, reason: collision with root package name */
    private String f235718m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GiftPanelController.this.toRechargePanel(IVasNativePayManager.TITLE_RECHARGE);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GiftPanelController.this.h();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class e implements IElementDynamicParams {
        e() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IElementDynamicParams
        public Map<String, Object> getElementDynamicParams() {
            HashMap hashMap = new HashMap();
            hashMap.put("balance_amt", Long.valueOf(GiftPanelController.this.K));
            return hashMap;
        }
    }

    public GiftPanelController(t tVar) {
        super(tVar);
    }

    private void A(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    private void C(Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.hgm, (ViewGroup) null, false);
        View findViewById = inflate.findViewById(R.id.f165373vq1);
        this.J = findViewById;
        findViewById.setOnClickListener(new b());
        this.I = (TextView) inflate.findViewById(R.id.vps);
        this.f235732e = (TextView) inflate.findViewById(R.id.f110476im);
        this.f235733f = (ImageView) inflate.findViewById(R.id.y7q);
        inflate.findViewById(R.id.vpy).setOnClickListener(new c());
        PopupWindow popupWindow = new PopupWindow(inflate, -1, (int) TypedValue.applyDimension(1, 392.0f, activity.getResources().getDisplayMetrics()));
        this.C = popupWindow;
        popupWindow.setAnimationStyle(R.style.f173923av4);
        this.C.setBackgroundDrawable(new BitmapDrawable());
        this.C.setFocusable(true);
        this.C.setOutsideTouchable(true);
        this.C.update();
        this.C.setOnDismissListener(this);
        this.D = (QQViewPager) inflate.findViewById(R.id.f165374vq2);
        this.E = (LinearLayout) inflate.findViewById(R.id.yoo);
        this.H = (RelativeLayout) inflate.findViewById(R.id.vpv);
    }

    private void F() {
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).preloadWebProcess();
    }

    private void G(Activity activity) {
        if (this.C == null || this.f235731d.getGiftPanelAction() == null) {
            return;
        }
        try {
            VideoReport.addToDetectionWhitelist(activity);
            VideoReport.setPageId(this.C.getContentView(), "pg_sgrp_gift_panel");
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_channel_id", Long.valueOf(this.f235731d.getGiftPanelAction().getChannelId()));
            hashMap.put("sgrp_sub_channel_id", Long.valueOf(this.f235731d.getGiftPanelAction().getGroupId()));
            hashMap.put("pgid", "pg_sgrp_gift_panel");
            VideoReport.setPageParams(this.C.getContentView(), new PageParams(hashMap));
            VideoReport.setElementId(this.J, "em_sgrp_recharge_entrance");
            VideoReport.setElementDynamicParams(this.J, new e());
            VideoReport.reportEvent("pgin", this.C.getContentView(), hashMap);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context v() {
        PopupWindow popupWindow = this.C;
        if (popupWindow == null || popupWindow.getContentView() == null) {
            return null;
        }
        return this.C.getContentView().getContext();
    }

    private String x() {
        String str;
        String str2 = this.f235718m;
        if (str2 != null && str2.length() > 0) {
            str = this.f235718m;
        } else {
            str = "https://h5.qzone.qq.com/v2/vip/qun-gift/channel-charge-dialog?_wv=16781315&_wwv=13&themeMode={themeMode}&source={source}&clusterid={clusterid}&subclusterid={subclusterid}";
        }
        if (this.f235731d.getGiftPanelAction() != null) {
            str = str.replace("{themeMode}", this.f235731d.getGiftPanelAction().isNightMode() + "").replace("{clusterid}", this.f235731d.getGiftPanelAction().getGroupId() + "").replace("{subclusterid}", this.f235731d.getGiftPanelAction().getChannelId() + "");
        }
        return str.replace("{source}", "1");
    }

    private void y() {
        PopupWindow popupWindow = this.C;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.C.setAnimationStyle(0);
        this.C.update();
    }

    private void z() {
        PopupWindow popupWindow = this.C;
        if (popupWindow != null) {
            popupWindow.getContentView().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.vas.panel.GiftPanelController.8
                @Override // java.lang.Runnable
                public void run() {
                    GiftPanelController.this.C.setAnimationStyle(R.style.f173923av4);
                    GiftPanelController.this.C.update();
                }
            }, 200L);
        }
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void a() {
        PopupWindow popupWindow = this.C;
        if (popupWindow == null || popupWindow.getContentView() == null) {
            return;
        }
        this.C.getContentView().post(new Runnable() { // from class: com.tencent.mobileqq.guild.vas.panel.GiftPanelController.3
            @Override // java.lang.Runnable
            public void run() {
                GiftPanelController.this.C.dismiss();
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, com.tencent.mobileqq.guild.vas.panel.b
    public void e(int i3, int i16) {
        String str = this.f235734h;
        if (str == null) {
            if (this.f235731d.getGiftPanelAction() == null || v() == null) {
                return;
            }
            QQToast.makeText(v(), v().getString(R.string.f146110ta), 0).show();
            return;
        }
        this.f235731d.sendGift(Long.parseLong(str), i3, i16);
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, com.tencent.mobileqq.guild.vas.panel.b
    public void g(Activity activity, List<giftList$GroupGiftItem> list, b.a aVar, long j3) {
        this.M = new WeakReference<>(activity);
        if (this.C == null) {
            C(activity);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            activity.getApplication().registerActivityLifecycleCallbacks(this);
        }
        this.L = activity.getComponentName().getClassName();
        j12.a aVar2 = new j12.a(list, this);
        this.G = aVar2;
        this.D.setAdapter(aVar2);
        this.D.addOnPageChangeListener(new a(aVar));
        A(activity);
        this.C.showAtLocation(activity.getWindow().getDecorView(), 80, 0, 0);
        B((int) j3, activity.getApplicationContext());
        I(list);
        F();
        this.f235731d.getCoins();
        G(activity);
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a
    public void h() {
        if (this.f235731d.getGiftPanelAction() != null) {
            this.f235731d.getGiftPanelAction().b();
        }
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity.getComponentName().getClassName().equals(this.L)) {
            y();
        }
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity.getComponentName().getClassName().equals(this.L)) {
            z();
            this.f235731d.getCoins();
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        H();
        if (this.C == null || v() == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        try {
            ((Application) v().getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, com.tencent.mobileqq.guild.vas.panel.b
    public void toRechargePanel(String str) {
        if (v() != null) {
            WeakReference<Activity> weakReference = this.M;
            if (weakReference != null && weakReference.get() != null && ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).isSwitchEnable()) {
                ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).initAndShowPayPanel(this.M.get(), str, "", new IVasNativePayManager.ReportData("1003", "0", "1", "0_0_" + (this.f235731d.getGiftPanelAction().getGroupId() + "") + "_" + (this.f235731d.getGiftPanelAction().getChannelId() + "")), new d());
                return;
            }
            E(v());
        }
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, com.tencent.mobileqq.guild.vas.panel.b
    public void toastSendError() {
        if (this.f235731d.getGiftPanelAction() == null || v() == null) {
            return;
        }
        QQToast.makeText(v(), v().getString(R.string.f146120tb), 0).show();
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, com.tencent.mobileqq.guild.vas.panel.b
    public void updateCoins(final long j3, final String str) {
        this.K = j3;
        TextView textView = this.I;
        if (textView == null) {
            return;
        }
        textView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.vas.panel.GiftPanelController.7
            @Override // java.lang.Runnable
            public void run() {
                String valueOf;
                if (GiftPanelController.this.v() != null) {
                    TextView textView2 = GiftPanelController.this.I;
                    long j16 = j3;
                    if (j16 <= 0) {
                        valueOf = GiftPanelController.this.v().getString(R.string.g4j);
                    } else {
                        valueOf = String.valueOf(j16);
                    }
                    textView2.setText(valueOf);
                }
                String str2 = str;
                if (str2 == null || str2.length() <= 0) {
                    return;
                }
                GiftPanelController.this.f235718m = str;
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, com.tencent.mobileqq.guild.vas.panel.b
    public void updateGiftPanel(final List<giftList$GroupGiftItem> list) {
        QQViewPager qQViewPager = this.D;
        if (qQViewPager != null) {
            qQViewPager.post(new Runnable() { // from class: com.tencent.mobileqq.guild.vas.panel.GiftPanelController.1
                @Override // java.lang.Runnable
                public void run() {
                    GiftPanelController.this.I(list);
                    if (GiftPanelController.this.G != null) {
                        GiftPanelController.this.G.g(list);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E(Context context) {
        try {
            Intent intent = new Intent(context, (Class<?>) QQTranslucentBrowserActivity.class);
            intent.putExtra("url", x());
            intent.setData(Uri.parse(x()));
            intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, false);
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
            context.startActivity(intent);
            return true;
        } catch (Exception e16) {
            QLog.e("GiftPanelController", 2, e16, new Object[0]);
            return false;
        }
    }

    private void H() {
        this.f235734h = null;
        if (v() != null) {
            this.f235732e.setText(v().getText(R.string.f146100t_));
        }
        this.f235733f.setVisibility(8);
    }

    private void B(int i3, Context context) {
        if (i3 > 0) {
            int i16 = (i3 / 8) + (i3 % 8 == 0 ? 0 : 1);
            int i17 = N;
            int i18 = i16 * i17;
            ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = i18;
                this.E.removeAllViews();
                View view = new View(context);
                this.F = view;
                view.setBackgroundDrawable(this.D.getResources().getDrawable(R.drawable.guild_gift_recharge_progress));
                this.E.addView(this.F, new ViewGroup.LayoutParams(i17, -1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(List<giftList$GroupGiftItem> list) {
        if (list != null && list.size() > 0) {
            this.H.setVisibility(8);
        } else {
            this.H.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, com.tencent.mobileqq.guild.vas.panel.b
    public void d(String str, String str2, String str3, Drawable drawable) {
        if (str2 == null || str3 == null || drawable == null) {
            return;
        }
        this.f235734h = str2;
        this.f235732e.setText(str3);
        this.f235733f.setVisibility(0);
        this.f235733f.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class d implements IVasNativePayManager.PayObserver {
        d() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewFail() {
            GiftPanelController giftPanelController = GiftPanelController.this;
            giftPanelController.E(giftPanelController.v());
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewSuccess() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPaySuccess() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayError(int i3) {
        }
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void b() {
    }

    /* loaded from: classes33.dex */
    class a implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b.a f235722d;

        a(b.a aVar) {
            this.f235722d = aVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            if (GiftPanelController.this.F != null) {
                GiftPanelController.this.F.animate().x(GiftPanelController.N * i3).setDuration(300L).start();
            }
            if (GiftPanelController.this.G.getF373114d() - 1 == i3) {
                this.f235722d.a();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
