package com.qzone.reborn.feedx.widget.header;

import android.os.Message;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

/* compiled from: P */
/* loaded from: classes37.dex */
public class u extends d implements IObserver.main {

    /* renamed from: f, reason: collision with root package name */
    private final QZoneUserAvatarView f56326f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ho.i.z().r(u.this.g(), LoginData.getInstance().getUin());
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 20, 2);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public u(View view) {
        super(view);
        this.f56326f = (QZoneUserAvatarView) view.findViewById(R.id.f162757mh0);
    }

    private void n() {
        this.f56326f.setUser(LoginData.getInstance().getUin());
        LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 20, 1);
        this.f56326f.setOnClickListener(new a());
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void a0(QZoneResult qZoneResult) {
        QZoneUserAvatarView qZoneUserAvatarView = this.f56326f;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setUser(LoginData.getInstance().getUin());
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneMoodListHeaderAvatarElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        n();
        EventCenter.getInstance().addUIObserver(this, "QQHead", 1);
    }

    public void o() {
        this.f56326f.setUser(LoginData.getInstance().getUin());
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        QZoneUserAvatarView qZoneUserAvatarView;
        if ("QQHead".equals(event.source.getName()) && event.what == 1 && (qZoneUserAvatarView = this.f56326f) != null) {
            qZoneUserAvatarView.setUser(LoginData.getInstance().getUin());
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onHandleMessage(Message message) {
        QZoneUserAvatarView qZoneUserAvatarView;
        QZoneResult unpack = QZoneResult.unpack(message);
        if (message.what == 999924 && unpack != null && unpack.getSucceed() && (qZoneUserAvatarView = this.f56326f) != null) {
            qZoneUserAvatarView.setUser(LoginData.getInstance().getUin());
        }
    }
}
