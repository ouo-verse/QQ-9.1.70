package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ci extends vg.a implements View.OnClickListener {
    private QZoneUserAvatarView F;
    private QZoneNickNameView G;
    private View H;
    private gf.h I;

    private void I() {
        if (this.I == null) {
            this.I = (gf.h) j(gf.h.class);
        }
        this.I.h2(this.f441565h, this.f441567m, null);
    }

    private void K(User user) {
        QZoneUserAvatarView qZoneUserAvatarView = this.F;
        if (qZoneUserAvatarView == null) {
            return;
        }
        qZoneUserAvatarView.setVisibility(0);
        this.F.setUser(user);
    }

    private void L(BusinessFeedData businessFeedData) {
        if (this.G.getPaint() != null) {
            this.G.getPaint().setShader(null);
        }
        QZoneNickNameView qZoneNickNameView = this.G;
        qZoneNickNameView.setData(businessFeedData, qZoneNickNameView.getResources().getColor(R.color.qui_common_text_primary));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        VideoInfo videoInfo = this.f441565h.getVideoInfo();
        if (videoInfo != null && videoInfo.actionType == 23 && !TextUtils.isEmpty(videoInfo.actionUrl)) {
            yo.d.d(videoInfo.actionUrl, view.getContext(), null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void N(boolean z16) {
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(800, z16 ? 3 : 2, 3), false, false);
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        K(this.f441565h.getUser());
        L(businessFeedData);
        this.f441563e.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.ch
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ci.this.M(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFriendLikeHeadPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.nbp) {
            I();
        } else if (view.getId() == R.id.nby || view.getId() == R.id.n87) {
            J(this.f441565h);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        QZoneNickNameView qZoneNickNameView = this.G;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.j();
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.noo;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private void J(BusinessFeedData businessFeedData) {
        User user;
        if (businessFeedData == null) {
            QZLog.w("QZoneFriendLikeHeadPresenter", 1, "dealWithQCircleFollowFamousEvent businessFeedData is null");
            return;
        }
        CellUserInfo cellUserInfo = businessFeedData.getCellUserInfo();
        if (cellUserInfo != null && (user = cellUserInfo.user) != null && !TextUtils.isEmpty(user.actionurl)) {
            yo.d.d(cellUserInfo.user.actionurl, this.f441563e.getContext(), null);
            N(true);
        } else {
            QZLog.w("QZoneFriendLikeHeadPresenter", 1, "dealWithQCircleFollowFamousEvent cellUserInfo.user.actionurl is null");
        }
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (QZoneUserAvatarView) view.findViewById(R.id.nby);
        this.G = (QZoneNickNameView) view.findViewById(R.id.n87);
        this.H = view.findViewById(R.id.nbp);
        int dpToPx = ImmersiveUtils.dpToPx(10.0f);
        QZoneFeedxViewUtils.a(this.H, dpToPx, dpToPx, dpToPx, dpToPx);
        this.H.setOnClickListener(this);
        if (com.qzone.reborn.feedx.util.x.f55790a.c(o())) {
            this.H.setVisibility(8);
        }
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
    }
}
