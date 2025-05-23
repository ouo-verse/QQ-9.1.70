package com.qzone.reborn.feedx.widget.header.famous;

import android.text.TextUtils;
import android.view.View;
import com.qzone.common.business.model.AvatarCacheData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.cover.ui.QzoneAvatarDecorator;
import com.qzone.cover.ui.QzoneFacadeDecorator;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.reborn.feedx.viewmodel.w;
import com.qzone.util.am;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a extends com.qzone.reborn.feedx.widget.header.d implements IObserver.main {
    private ActionSheet C;
    private String D;
    private ActionSheet.OnButtonClickListener E;

    /* renamed from: f, reason: collision with root package name */
    private final QzoneAvatarDecorator f56270f;

    /* renamed from: h, reason: collision with root package name */
    private final QzoneFacadeDecorator f56271h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f56272i;

    /* renamed from: m, reason: collision with root package name */
    private w f56273m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.reborn.feedx.widget.header.famous.a$a, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public class ViewOnClickListenerC0474a implements View.OnClickListener {
        ViewOnClickListenerC0474a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.w();
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
            if (a.this.C == null) {
                return;
            }
            a.this.C.dismiss();
            switch (a.this.C.getActionMenuItem(i3).action) {
                case 220:
                    if (a.this.u().K2()) {
                        if (a.this.f56271h != null && a.this.f56271h.U != null && !"-1".equals(a.this.f56271h.U.strId) && !TextUtils.isEmpty(a.this.f56271h.U.strId)) {
                            if (a.this.D != null && a.this.D.equals("1")) {
                                vo.c.n(a.this.g());
                                return;
                            } else {
                                vo.c.d(a.this.g(), a.this.f56271h.U.strId, QzoneCoverConst.REFER_USERHOME, a.this.u().getMUin());
                                return;
                            }
                        }
                        vo.c.c(a.this.g(), QzoneCoverConst.REFER_USERHOME, a.this.u().getMUin());
                        return;
                    }
                    vo.c.c(a.this.g(), QzoneCoverConst.REFER_USERHOME, a.this.u().getMUin());
                    return;
                case 221:
                    a.this.f56273m.G2(a.this.g());
                    return;
                case 222:
                    if (a.this.u().K2()) {
                        x6.a value = a.this.u().C2().getValue();
                        if (value != null && (str = value.personalizedYellowVipUrl) != null) {
                            String f16 = am.f(str);
                            if (!am.h(f16)) {
                                vo.c.Q(a.this.g(), f16);
                            }
                        }
                    } else {
                        vo.c.O(a.this.g(), a.this.u().getMUin());
                    }
                    ClickReport.c(308, 65, "1", false, new String[0]);
                    return;
                default:
                    return;
            }
        }
    }

    public a(View view, boolean z16) {
        super(view);
        this.f56272i = true;
        this.D = null;
        this.E = new b();
        this.f56272i = z16;
        this.f56270f = (QzoneAvatarDecorator) view.findViewById(R.id.mzm);
        this.f56271h = (QzoneFacadeDecorator) view.findViewById(R.id.mzn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public w u() {
        if (this.f56273m == null) {
            this.f56273m = (w) k(w.class);
        }
        return this.f56273m;
    }

    private void v() {
        this.f56270f.setFacadeDecorator(this.f56271h);
        this.f56270f.setOnClickListener(new ViewOnClickListenerC0474a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (u().K2()) {
            QzoneFacadeDecorator qzoneFacadeDecorator = this.f56271h;
            if (qzoneFacadeDecorator != null && qzoneFacadeDecorator.U != null) {
                if ("-1".equals(this.f56271h.U.strId)) {
                    this.f56273m.G2(g());
                    return;
                }
                if (this.f56271h.U.mapExtInfo != null) {
                    this.D = this.f56271h.U.mapExtInfo.get(AvatarCacheData.PARAM_NAMEPLATE);
                }
                String str = this.D;
                if (str != null && str.equals("1")) {
                    x(R.string.ggb);
                } else {
                    x(R.string.ggc);
                }
            } else {
                this.f56273m.G2(g());
            }
            com.qzone.misc.network.report.c.a(302, 806, 1);
            return;
        }
        x(R.string.gnv);
        com.qzone.misc.network.report.a.d();
    }

    private void y() {
        if (this.f56270f != null) {
            String valueOf = String.valueOf(u().getMUin());
            this.f56270f.c(g(), valueOf);
            this.f56270f.d();
            QzoneFacadeDecorator qzoneFacadeDecorator = this.f56271h;
            if (qzoneFacadeDecorator != null) {
                qzoneFacadeDecorator.r(g(), valueOf, this.f56272i);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void a0(QZoneResult qZoneResult) {
        y();
        z();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneUserHomeHeaderAvatarElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        v();
        EventCenter.getInstance().addUIObserver(this, "QQHead", 1);
        y();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        QzoneAvatarDecorator qzoneAvatarDecorator = this.f56270f;
        if (qzoneAvatarDecorator != null) {
            qzoneAvatarDecorator.g();
        }
        QzoneFacadeDecorator qzoneFacadeDecorator = this.f56271h;
        if (qzoneFacadeDecorator != null) {
            qzoneFacadeDecorator.B();
        }
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        QzoneAvatarDecorator qzoneAvatarDecorator;
        if ("QQHead".equals(event.source.getName()) && event.what == 1 && (qzoneAvatarDecorator = this.f56270f) != null) {
            qzoneAvatarDecorator.d();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onPause() {
        QzoneFacadeDecorator qzoneFacadeDecorator = this.f56271h;
        if (qzoneFacadeDecorator != null) {
            qzoneFacadeDecorator.B();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
        QzoneFacadeDecorator qzoneFacadeDecorator = this.f56271h;
        if (qzoneFacadeDecorator != null) {
            qzoneFacadeDecorator.d();
        }
    }

    public void x(int i3) {
        x6.a value;
        try {
            boolean z16 = (u().K2() && ((value = u().C2().getValue()) == null || value.personalizedYellowVipUrl == null)) ? false : true;
            ArrayList arrayList = new ArrayList();
            if (z16) {
                arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(g(), u().K2() ? R.string.ggd : R.string.f173045go1), 222, 0));
            }
            arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(g(), i3), 220, 0));
            arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(g(), R.string.ggj), 221, 0));
            ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(g(), arrayList, this.E);
            this.C = createActionSheet;
            createActionSheet.addCancelButton(R.string.cancel);
            this.C.show();
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    public void z() {
        QzoneFacadeDecorator qzoneFacadeDecorator;
        if (this.f56270f == null || (qzoneFacadeDecorator = this.f56271h) == null) {
            return;
        }
        qzoneFacadeDecorator.d();
    }
}
