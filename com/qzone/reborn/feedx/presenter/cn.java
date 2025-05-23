package com.qzone.reborn.feedx.presenter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.common.event.EventCenter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class cn extends vg.a implements View.OnClickListener {
    private com.qzone.reborn.feedx.viewmodel.q F;
    private LinearLayout G;
    private QZoneUserAvatarView H;
    private QZoneUserAvatarView I;
    private QZoneUserAvatarView J;
    private TextView K;
    private String L;
    private ArrayList<String> M = new ArrayList<>();

    private void K(BusinessFeedData businessFeedData) {
        CellGuiding cellGuiding;
        this.M = new ArrayList<>();
        if (businessFeedData == null || (cellGuiding = businessFeedData.getCellGuiding()) == null) {
            return;
        }
        if (cellGuiding.cutLineJumpTime > 0) {
            String valueOf = String.valueOf(businessFeedData.getCellGuiding().cutLineJumpTime);
            this.L = valueOf;
            this.M.add(valueOf);
        } else {
            Map<Integer, String> map = businessFeedData.getCellGuiding().busi_param;
            this.M.add(map.get(209));
            this.M.add(map.get(210));
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        J(businessFeedData);
        I(businessFeedData);
        K(businessFeedData);
        L(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneReadDivideLinePresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.n_6) {
            H(this.M);
            L(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected int s() {
        return R.id.nlz;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private void I(BusinessFeedData businessFeedData) {
        ArrayList<User> arrayList;
        if (businessFeedData == null || businessFeedData.getCellGuiding() == null || (arrayList = businessFeedData.getCellGuiding().vecUsers) == null || arrayList.size() != 3) {
            return;
        }
        long j3 = arrayList.get(0).uin;
        long j16 = arrayList.get(1).uin;
        long j17 = arrayList.get(2).uin;
        this.H.setUser(j3);
        this.I.setUser(j16);
        this.J.setUser(j17);
    }

    private void J(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getCellGuiding() == null) {
            return;
        }
        this.K.setText(businessFeedData.getCellGuiding().title);
    }

    private void H(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() == 2) {
            this.F.z2(this.M, true);
        } else {
            this.F.y2(this.M);
        }
        EventCenter.getInstance().post("FeedX", 1);
    }

    @Override // vg.a
    protected void C(View view) {
        this.G = (LinearLayout) view.findViewById(R.id.n_6);
        this.H = (QZoneUserAvatarView) view.findViewById(R.id.n_3);
        this.I = (QZoneUserAvatarView) view.findViewById(R.id.n_4);
        this.J = (QZoneUserAvatarView) view.findViewById(R.id.n_5);
        this.K = (TextView) view.findViewById(R.id.n_7);
        this.G.setOnClickListener(this);
        this.F = (com.qzone.reborn.feedx.viewmodel.q) r(com.qzone.reborn.feedx.viewmodel.q.class);
    }

    private void L(boolean z16) {
        LpReportInfo_pf00064.allReport(302, 504, z16 ? 1 : 2, (String) null, this.f441567m);
    }
}
