package com.tencent.mobileqq.guild.vas.panel;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.r;
import com.tencent.mobileqq.guild.t;
import com.tencent.mobileqq.guild.vas.panel.b;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList$GroupGiftItem;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;
import sh2.c;

/* loaded from: classes33.dex */
public class GiftPanelControllerV2 extends com.tencent.mobileqq.guild.vas.panel.a implements c.f {
    private c C;
    private View D;
    private long E;

    /* renamed from: m, reason: collision with root package name */
    private nh2.c f235728m;

    /* loaded from: classes33.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GiftPanelControllerV2.this.h();
            if (GiftPanelControllerV2.this.C != null && GiftPanelControllerV2.this.C.n() != null) {
                GiftPanelControllerV2.this.C.n().b();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GiftPanelControllerV2(t tVar) {
        super(tVar);
    }

    private void k() {
        View view = this.D;
        if (view != null) {
            VideoReport.setElementId(view, "em_qq_gift_panel_set_choose");
            VideoReport.setElementClickPolicy(this.D, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(this.D, ExposurePolicy.REPORT_ALL);
            VideoReport.reportEvent("imp", this.D, null);
            c cVar = this.C;
            if (cVar == null || cVar.n() == null) {
                return;
            }
            this.C.n().a();
        }
    }

    private com.tencent.mobileqq.qqgift.mvvm.business.data.a l() {
        com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar = new com.tencent.mobileqq.qqgift.mvvm.business.data.a();
        r giftPanelAction = this.f235731d.getGiftPanelAction();
        if (giftPanelAction != null) {
            aVar.f264944k = String.valueOf(giftPanelAction.getGroupId());
            aVar.f264945l = String.valueOf(giftPanelAction.getChannelId());
        }
        return aVar;
    }

    private HashMap<String, String> m() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sgrp_subchannel_type", "1");
        return hashMap;
    }

    private synchronized void n() {
        com.tencent.mobileqq.qqgift.sdk.config.a b16;
        nh2.c cVar = this.f235728m;
        if (cVar == null || cVar.isDestroyed()) {
            this.f235728m = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(10010);
        }
        nh2.c cVar2 = this.f235728m;
        if (cVar2 == null) {
            return;
        }
        if (cVar2.getSDKConfig() != null) {
            b16 = this.f235728m.getSDKConfig();
        } else {
            b16 = com.tencent.mobileqq.qqgift.sdk.config.a.a().b();
        }
        b16.f264972a = 10010;
        b16.f264976e = WadlProxyConsts.CHANNEL;
        b16.f264977f = "1c7d45f5";
        b16.f264978g = "1003";
        b16.f264979h = true;
        nh2.c cVar3 = this.f235728m;
        if (cVar3 != null && !cVar3.isInited()) {
            this.f235728m.c(null, b16);
        }
        t tVar = this.f235731d;
        if (tVar != null && tVar.getGiftPanelAction() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("channel_id", String.valueOf(this.f235731d.getGiftPanelAction().getChannelId()));
            b16.f264980i = hashMap;
        }
    }

    private boolean o() {
        return Math.abs(System.currentTimeMillis() - this.E) < 500;
    }

    @Override // sh2.c.f
    public boolean D() {
        return false;
    }

    @Override // sh2.c.f
    public boolean O(d dVar, int i3) {
        if (TextUtils.isEmpty(this.f235734h)) {
            QQToast.makeText(this.f235728m.getAppRuntime().getApp(), "\u8bf7\u9009\u62e9\u6536\u793c\u4eba", 0).show();
            return true;
        }
        t tVar = this.f235731d;
        if (tVar != null) {
            r giftPanelAction = tVar.getGiftPanelAction();
            if (giftPanelAction != null && giftPanelAction.getChannelType() == 1 && o()) {
                return true;
            }
            this.f235728m.a().Q(this.f235731d.getGiftSendReq(Long.parseLong(this.f235734h), dVar.f264874d));
            this.E = System.currentTimeMillis();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void a() {
        nh2.c cVar = this.f235728m;
        if (cVar != null) {
            cVar.destroy();
        }
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.b
    public void b() {
        try {
            n();
            nh2.c cVar = this.f235728m;
            if (cVar == null || cVar.isDestroyed() || this.f235728m.a().D() != null) {
                return;
            }
            this.f235728m.a().M(null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // sh2.c.f
    public boolean f() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, com.tencent.mobileqq.guild.vas.panel.b
    public void g(Activity activity, List<giftList$GroupGiftItem> list, b.a aVar, long j3) {
        int parseColor;
        VasPerfReportUtils.saveStartTime("10010");
        View inflate = View.inflate(activity, R.layout.hgn, null);
        this.D = inflate;
        this.f235732e = (TextView) inflate.findViewById(R.id.f110476im);
        this.f235733f = (ImageView) this.D.findViewById(R.id.y7q);
        this.D.findViewById(R.id.vpy).setOnClickListener(new a());
        super.g(activity, list, aVar, j3);
        n();
        nh2.c cVar = this.f235728m;
        if (cVar != null && !cVar.isDestroyed()) {
            c l3 = this.f235728m.d().l((QBaseActivity) activity, 0);
            this.C = l3;
            l3.setPanelEventListener(l3.l(this));
            if (this.C.k().findViewById(R.id.vpy) == null) {
                this.C.k().addView(this.D, new ViewGroup.LayoutParams(-1, ViewUtils.dpToPx(55.0f)));
            }
            LinearLayout k3 = this.C.k();
            k3.setPadding(k3.getPaddingLeft(), 0, k3.getPaddingRight(), k3.getPaddingBottom());
            boolean z16 = QQTheme.isNowThemeIsNight() || QQTheme.isNowThemeSimpleNight();
            Drawable background = this.D.findViewById(R.id.yq9).getBackground();
            if (background instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                if (z16) {
                    parseColor = Color.parseColor("#33FFFFFF");
                } else {
                    parseColor = Color.parseColor("#14000000");
                }
                gradientDrawable.setColor(parseColor);
            }
            this.D.findViewById(R.id.yq9).setBackgroundDrawable(background);
            this.f235732e.setTextColor(z16 ? -1 : -16777216);
            this.C.setPanelStyle(new com.tencent.mobileqq.qqgift.mvvm.business.data.b(z16));
            this.C.setDtParams(l());
            this.C.setDtPageExtra(m());
            this.C.setCacheList(this.f235728m.a().D());
            this.C.p(activity.findViewById(android.R.id.content));
            k();
        }
        this.E = 0L;
    }

    @Override // sh2.c.f
    public boolean h0(d dVar, int i3) {
        return false;
    }

    @Override // sh2.c.f
    public boolean n1(boolean z16, final d dVar, int i3, String str) {
        WeakReference<Activity> weakReference = this.f235735i;
        if (weakReference == null || !z16) {
            return false;
        }
        weakReference.get().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.vas.panel.GiftPanelControllerV2.2
            @Override // java.lang.Runnable
            public void run() {
                d dVar2 = dVar;
                if (dVar2 == null || !dVar2.b()) {
                    GiftPanelControllerV2.this.C.hide();
                }
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, com.tencent.mobileqq.guild.vas.panel.b
    public void onFreeGiftCountDownEnd() {
        try {
            n();
            nh2.c cVar = this.f235728m;
            if (cVar == null || cVar.isDestroyed()) {
                return;
            }
            this.f235728m.g().exitRoom();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.guild.vas.panel.a, com.tencent.mobileqq.guild.vas.panel.b
    public void onFreeGiftCountDownStart() {
        try {
            n();
            nh2.c cVar = this.f235728m;
            if (cVar == null || cVar.isDestroyed()) {
                return;
            }
            this.f235728m.g().enterRoom();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // sh2.c.f
    public boolean r(d dVar, int i3) {
        return false;
    }

    @Override // sh2.c.f
    public boolean t() {
        return false;
    }

    @Override // sh2.c.f
    public boolean u0(d dVar, int i3) {
        return false;
    }

    @Override // sh2.c.f
    public boolean w(d dVar, int i3) {
        return false;
    }

    @Override // sh2.c.f
    public void o1(d dVar, int i3, int i16) {
    }
}
