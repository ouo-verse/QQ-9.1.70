package com.qzone.reborn.feedx.widget.header;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.qzone.common.business.model.AvatarCacheData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.cover.ui.QzoneAvatarDecorator;
import com.qzone.cover.ui.QzoneFacadeDecorator;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ao extends d implements IObserver.main {
    private boolean C;
    private com.qzone.reborn.feedx.viewmodel.w D;
    private ActionSheet E;
    private String F;
    private ActionSheet.OnButtonClickListener G;

    /* renamed from: f, reason: collision with root package name */
    private final QzoneAvatarDecorator f56196f;

    /* renamed from: h, reason: collision with root package name */
    private final QzoneFacadeDecorator f56197h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f56198i;

    /* renamed from: m, reason: collision with root package name */
    private final TextView f56199m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ao.this.B();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements ActionSheet.OnButtonClickListener {
        b() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            String str;
            if (ao.this.E != null) {
                ao.this.E.dismiss();
            }
            switch (ao.this.E != null ? ao.this.E.getActionMenuItem(i3).action : -1) {
                case 220:
                    if (ao.this.w().K2()) {
                        if (ao.this.f56197h != null && ao.this.f56197h.U != null && !"-1".equals(ao.this.f56197h.U.strId) && !TextUtils.isEmpty(ao.this.f56197h.U.strId)) {
                            if (ao.this.F != null && ao.this.F.equals("1")) {
                                vo.c.n(ao.this.g());
                                return;
                            } else {
                                vo.c.d(ao.this.g(), ao.this.f56197h.U.strId, QzoneCoverConst.REFER_USERHOME, ao.this.w().getMUin());
                                return;
                            }
                        }
                        vo.c.c(ao.this.g(), QzoneCoverConst.REFER_USERHOME, ao.this.w().getMUin());
                        return;
                    }
                    vo.c.c(ao.this.g(), QzoneCoverConst.REFER_USERHOME, ao.this.w().getMUin());
                    return;
                case 221:
                    ao.this.D.G2(ao.this.g());
                    return;
                case 222:
                    if (ao.this.w().K2()) {
                        x6.a value = ao.this.w().C2().getValue();
                        if (value != null && (str = value.personalizedYellowVipUrl) != null) {
                            String f16 = com.qzone.util.am.f(str);
                            if (!com.qzone.util.am.h(f16)) {
                                vo.c.Q(ao.this.g(), f16);
                            }
                        }
                    } else {
                        vo.c.O(ao.this.g(), ao.this.w().getMUin());
                    }
                    ClickReport.c(308, 65, "1", false, new String[0]);
                    return;
                default:
                    return;
            }
        }
    }

    public ao(View view, boolean z16) {
        super(view);
        this.C = true;
        this.F = null;
        this.G = new b();
        this.C = z16;
        this.f56196f = (QzoneAvatarDecorator) view.findViewById(R.id.mzm);
        this.f56197h = (QzoneFacadeDecorator) view.findViewById(R.id.mzn);
        this.f56198i = (TextView) view.findViewById(R.id.f162858n04);
        this.f56199m = (TextView) view.findViewById(R.id.f162859n05);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (w().K2()) {
            QzoneFacadeDecorator qzoneFacadeDecorator = this.f56197h;
            if (qzoneFacadeDecorator != null && qzoneFacadeDecorator.U != null) {
                if ("-1".equals(this.f56197h.U.strId)) {
                    this.D.G2(g());
                    return;
                }
                if (this.f56197h.U.mapExtInfo != null) {
                    this.F = this.f56197h.U.mapExtInfo.get(AvatarCacheData.PARAM_NAMEPLATE);
                }
                String str = this.F;
                if (str != null && str.equals("1")) {
                    C(R.string.ggb);
                } else {
                    C(R.string.ggc);
                }
            } else {
                this.D.G2(g());
            }
            com.qzone.misc.network.report.c.a(302, 806, 1);
            return;
        }
        C(R.string.gnv);
        com.qzone.misc.network.report.a.d();
    }

    private void D() {
        if (this.f56196f != null) {
            String valueOf = String.valueOf(w().getMUin());
            this.f56196f.c(g(), valueOf);
            this.f56196f.d();
            QzoneFacadeDecorator qzoneFacadeDecorator = this.f56197h;
            if (qzoneFacadeDecorator != null) {
                qzoneFacadeDecorator.r(g(), valueOf, this.C);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.qzone.reborn.feedx.viewmodel.w w() {
        if (this.D == null) {
            this.D = (com.qzone.reborn.feedx.viewmodel.w) k(com.qzone.reborn.feedx.viewmodel.w.class);
        }
        return this.D;
    }

    private void x() {
        this.f56196f.setFacadeDecorator(this.f56197h);
        this.f56196f.setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(x6.a aVar) {
        String a16;
        if (!TextUtils.isEmpty(aVar.name)) {
            a16 = com.qzone.util.g.a(aVar.name);
        } else {
            a16 = com.qzone.util.g.a(aVar.nickName);
        }
        this.f56198i.setText(a16);
        this.f56199m.setText("QQ\u53f7 " + aVar.uin);
        ProfileCardUtil.e(this.f56199m, String.valueOf(aVar.uin), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        B();
        EventCollector.getInstance().onViewClicked(view);
    }

    public void A() {
        this.f56196f.l(String.valueOf(w().getMUin()));
        QzoneFacadeDecorator qzoneFacadeDecorator = this.f56197h;
        if (qzoneFacadeDecorator != null) {
            qzoneFacadeDecorator.d();
        }
    }

    public void C(int i3) {
        x6.a value;
        try {
            boolean z16 = (w().K2() && ((value = w().C2().getValue()) == null || value.personalizedYellowVipUrl == null)) ? false : true;
            ArrayList arrayList = new ArrayList();
            if (z16) {
                arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(g(), w().K2() ? R.string.ggd : R.string.f173045go1), 222, 0));
            }
            arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(g(), i3), 220, 0));
            arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(g(), R.string.ggj), 221, 0));
            ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(g(), arrayList, this.G);
            this.E = createActionSheet;
            createActionSheet.addCancelButton(R.string.cancel);
            this.E.show();
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    public void E() {
        QzoneFacadeDecorator qzoneFacadeDecorator;
        if (this.f56196f == null || (qzoneFacadeDecorator = this.f56197h) == null) {
            return;
        }
        qzoneFacadeDecorator.d();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void a0(QZoneResult qZoneResult) {
        D();
        E();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneUserHomeHeaderAvatarElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        x();
        EventCenter.getInstance().addUIObserver(this, "QQHead", 1);
        D();
        w().C2().observe(i(), new Observer() { // from class: com.qzone.reborn.feedx.widget.header.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ao.this.y((x6.a) obj);
            }
        });
        this.f56198i.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.header.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ao.this.z(view);
            }
        });
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        QzoneAvatarDecorator qzoneAvatarDecorator = this.f56196f;
        if (qzoneAvatarDecorator != null) {
            qzoneAvatarDecorator.g();
        }
        QzoneFacadeDecorator qzoneFacadeDecorator = this.f56197h;
        if (qzoneFacadeDecorator != null) {
            qzoneFacadeDecorator.B();
        }
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        QzoneAvatarDecorator qzoneAvatarDecorator;
        if ("QQHead".equals(event.source.getName()) && event.what == 1 && (qzoneAvatarDecorator = this.f56196f) != null) {
            qzoneAvatarDecorator.d();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onPause() {
        QzoneFacadeDecorator qzoneFacadeDecorator = this.f56197h;
        if (qzoneFacadeDecorator != null) {
            qzoneFacadeDecorator.B();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
        QzoneFacadeDecorator qzoneFacadeDecorator = this.f56197h;
        if (qzoneFacadeDecorator != null) {
            qzoneFacadeDecorator.d();
        }
    }
}
