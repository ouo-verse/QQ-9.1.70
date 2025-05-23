package com.qzone.reborn.feedx.widget.header.famous;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.reborn.feedx.viewmodel.w;
import com.qzone.reborn.feedx.widget.header.famous.k;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.vip.vipcomponent.util.VipResourcesListener;

/* compiled from: P */
/* loaded from: classes37.dex */
public class k extends com.qzone.reborn.feedx.widget.header.d {
    private final ImageView C;
    private final ImageView D;
    private w E;

    /* renamed from: f, reason: collision with root package name */
    private final TextView f56286f;

    /* renamed from: h, reason: collision with root package name */
    private final TextView f56287h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f56288i;

    /* renamed from: m, reason: collision with root package name */
    private final TextView f56289m;

    public k(View view) {
        super(view);
        this.f56286f = (TextView) view.findViewById(R.id.n38);
        this.f56287h = (TextView) view.findViewById(R.id.f162874n32);
        this.f56288i = (TextView) view.findViewById(R.id.n39);
        this.f56289m = (TextView) view.findViewById(R.id.n37);
        this.C = (ImageView) view.findViewById(R.id.f162872n30);
        this.D = (ImageView) view.findViewById(R.id.n3a);
    }

    private w t() {
        if (this.E == null) {
            this.E = (w) k(w.class);
        }
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(x6.a aVar) {
        String a16;
        if (!TextUtils.isEmpty(aVar.name)) {
            a16 = com.qzone.util.g.a(aVar.name);
        } else {
            a16 = com.qzone.util.g.a(aVar.nickName);
        }
        this.f56286f.setText(a16);
        this.f56286f.setMaxWidth(pl.a.f426446a.l(g()) - ar.d(60.0f));
        this.f56287h.setText(com.qzone.reborn.util.a.a(aVar.fansCount));
        this.f56288i.setText(com.qzone.reborn.util.a.a(com.qzone.reborn.util.a.b(aVar.visitorCount)));
        if (!TextUtils.isEmpty(aVar.spaceDesc)) {
            this.f56289m.setText(aVar.spaceDesc);
        } else {
            this.f56289m.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ComeToFollowMe", "\u5927\u5bb6\u5feb\u6765\u5173\u6ce8\u6211\u5427"));
        }
        if (lg.a.f414452a.d(aVar)) {
            this.C.setVisibility(0);
            this.C.setImageResource(R.drawable.qzone_famous_icon);
        } else {
            this.C.setVisibility(8);
        }
        int i3 = aVar.vipType;
        if (aVar.isVip) {
            i3++;
        }
        s(VipComponentProxy.f50997g.getUiInterface().getYellowVipIcon(aVar.vipLevel, i3, aVar.isAnnualVip == 1, aVar.isCustomDiamondUser, aVar.customDiamondUrl, 8, new a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ho.i.z().j(g(), this.E.getMUin());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ho.i.z().x(g(), this.E.getMUin());
        EventCollector.getInstance().onViewClicked(view);
    }

    private void x() {
        fo.c.n(this.f56287h, "em_qz_aut_fan_button");
        fo.c.n(this.f56288i, "em_qz_aut_visitor_button");
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneFamousUserHomeHeaderAvatarElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        t().C2().observe(i(), new Observer() { // from class: com.qzone.reborn.feedx.widget.header.famous.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                k.this.u((x6.a) obj);
            }
        });
        this.f56287h.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.header.famous.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.this.v(view);
            }
        });
        this.f56288i.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.header.famous.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.this.w(view);
            }
        });
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Drawable drawable) {
        if (drawable != null) {
            this.D.setVisibility(0);
            this.D.setImageDrawable(drawable);
        } else {
            this.D.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements VipResourcesListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Drawable drawable) {
            k.this.s(drawable);
        }

        @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
        public void onLoaded(final Drawable drawable) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.famous.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.this.b(drawable);
                }
            });
        }

        @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
        public void onFailed() {
        }
    }
}
