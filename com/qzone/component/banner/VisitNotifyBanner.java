package com.qzone.component.banner;

import NS_MOBILE_MAIN_PAGE.s_user;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.personalitycomponent.model.WidgetVisitorsData;
import com.qzone.widget.AvatarImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VisitNotifyBanner extends BasePushBanner {
    private int G;
    private int H;
    private int I;
    private int J;
    private com.qzone.feed.business.model.a K;
    private int L;
    private int M;
    private ArrayList<WidgetVisitorsData.WidgetVistor> N;
    private View.OnClickListener P;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(BaseActivity.class.getSimpleName(), view);
            ClickReport.q("302", "14", ThemeReporter.FROM_SIMPLE, false);
            VisitNotifyBanner.this.g();
            Context context = VisitNotifyBanner.this.getContext();
            if (context != null) {
                VisitNotifyBanner.this.J = 0;
                if (VisitNotifyBanner.this.J != 0 && VisitNotifyBanner.this.N != null && VisitNotifyBanner.this.N.size() != 0) {
                    Iterator it = VisitNotifyBanner.this.N.iterator();
                    String str = "";
                    while (it.hasNext()) {
                        WidgetVisitorsData.WidgetVistor widgetVistor = (WidgetVisitorsData.WidgetVistor) it.next();
                        if (widgetVistor != null) {
                            str = (str + widgetVistor.uin) + "|";
                        }
                    }
                }
                vo.c.x(context, LoginData.getInstance().getUin());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public VisitNotifyBanner(Context context) {
        super(context);
        this.L = 1;
        this.M = 0;
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 1;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 9;
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        this.G = getResources().getDimensionPixelOffset(R.dimen.f158723nd);
        this.H = getResources().getDimensionPixelOffset(R.dimen.ap7);
        this.P = new a();
        w(QZoneConfigHelper.S());
        setVisibility(8);
        this.f46297e = true;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        if (this.f46297e) {
            setVisibility(z16 ? 0 : 8);
            if (z16) {
                u();
                this.f46298f = false;
                ClickReport.q("302", "14", ThemeReporter.FROM_CLEANER, false);
            }
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46297e && getVisibility() == 0;
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        if (this.f46297e && aVar != null && C(aVar)) {
            this.f46313h.removeAllViews();
            if (aVar.f47117a == 9) {
                AvatarImageView avatarImageView = new AvatarImageView(getContext());
                if (aVar.f47125i.size() > 0) {
                    avatarImageView.j(aVar.f47125i.get(0).uin);
                    if (TextUtils.isEmpty(aVar.f47125i.get(0).visit_info)) {
                        return;
                    }
                    this.f46315m.setText(aVar.f47125i.get(0).visit_info);
                    this.f46315m.setVisibility(0);
                    int i3 = this.H;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
                    layoutParams.setMargins(this.G, 0, 0, 0);
                    this.f46313h.addView(avatarImageView, layoutParams);
                    setOnClickListener(this.P);
                }
            }
            this.f46298f = true;
            c();
        }
    }

    @Override // com.qzone.component.banner.BasePushBanner
    protected void x() {
        if (this.L < this.M) {
            if (QZLog.isDevelopLevel()) {
                QZLog.d("visitNotify", 4, "show  next visitor banner counter:" + this.L + "visitRecordSize:" + this.M);
            }
            this.f46313h.removeAllViews();
            com.qzone.feed.business.model.a aVar = this.K;
            if (aVar == null || aVar.f47125i == null) {
                return;
            }
            AvatarImageView avatarImageView = new AvatarImageView(getContext());
            if (this.L < this.K.f47125i.size()) {
                s_user s_userVar = this.K.f47125i.get(this.L);
                avatarImageView.j(s_userVar.uin);
                String str = s_userVar.visit_info;
                int i3 = this.H;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
                layoutParams.setMargins(this.G, 0, 0, 0);
                this.f46313h.addView(avatarImageView, layoutParams);
                if (!TextUtils.isEmpty(str)) {
                    this.f46315m.setText(str);
                    this.f46315m.setVisibility(0);
                }
                setVisibility(0);
                setOnClickListener(this.P);
                u();
                this.L++;
                return;
            }
            return;
        }
        this.L = 1;
        this.f46313h.removeAllViews();
        g();
    }

    public VisitNotifyBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = 1;
        this.M = 0;
    }

    public boolean C(com.qzone.feed.business.model.a aVar) {
        if (aVar == null) {
            return false;
        }
        this.I = aVar.f47126j;
        if (this.N == null) {
            this.N = new ArrayList<>();
        }
        ArrayList<s_user> arrayList = aVar.f47125i;
        int size = arrayList.size();
        this.M = size;
        if (size > 3) {
            this.M = 3;
        }
        this.K = aVar;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            s_user s_userVar = arrayList.get(i3);
            WidgetVisitorsData.WidgetVistor widgetVistor = new WidgetVisitorsData.WidgetVistor();
            widgetVistor.uin = s_userVar.uin;
            widgetVistor.visit_time = (int) s_userVar.vtime;
            this.N.add(widgetVistor);
        }
        return arrayList.size() != 0;
    }

    @Override // com.qzone.component.banner.BasePushBanner
    protected void y() {
    }
}
