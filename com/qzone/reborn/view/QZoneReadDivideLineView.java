package com.qzone.reborn.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.event.EventCenter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.proxy.feedcomponent.ui.h;
import com.qzone.widget.AvatarImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneReadDivideLineView extends AbsFeedView implements View.OnClickListener {
    private TextView C;
    private String D;
    private ArrayList<String> E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private View f59588d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f59589e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f59590f;

    /* renamed from: h, reason: collision with root package name */
    private AvatarImageView f59591h;

    /* renamed from: i, reason: collision with root package name */
    private AvatarImageView f59592i;

    /* renamed from: m, reason: collision with root package name */
    private AvatarImageView f59593m;

    public QZoneReadDivideLineView(Context context) {
        super(context);
        this.E = new ArrayList<>();
        this.F = 0;
        e(context);
    }

    private void a() {
        if (QQTheme.isNowThemeIsNightForQzone()) {
            setBackgroundColor(-16777216);
            LinearLayout linearLayout = this.f59589e;
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(-16777216);
            }
            TextView textView = this.C;
            if (textView != null) {
                textView.setTextColor(-1);
            }
        }
    }

    private void d(BusinessFeedData businessFeedData) {
        CellGuiding cellGuiding;
        this.E = new ArrayList<>();
        if (businessFeedData == null || (cellGuiding = businessFeedData.getCellGuiding()) == null) {
            return;
        }
        if (cellGuiding.cutLineJumpTime > 0) {
            String valueOf = String.valueOf(businessFeedData.getCellGuiding().cutLineJumpTime);
            this.D = valueOf;
            this.E.add(valueOf);
        } else {
            Map<Integer, String> map = businessFeedData.getCellGuiding().busi_param;
            this.E.add(map.get(209));
            this.E.add(map.get(210));
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean hasVideoPlayed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAlwaysAutoPlayFeed() {
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public boolean isAutoVideoFeed() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.f69433iq) {
            Object[] objArr = {this.E};
            LpReportInfo_pf00064.allReport(302, 504, 2, (String) null, this.F);
            EventCenter.getInstance().post("ReadLine", 1, objArr);
            removeAllViews();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setData(BusinessFeedData businessFeedData) {
        super.setData(businessFeedData);
        a();
        c(businessFeedData);
        b(businessFeedData);
        d(businessFeedData);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setFeedPosition(int i3) {
        this.F = i3;
        LpReportInfo_pf00064.allReport(302, 504, 1, (String) null, i3);
    }

    private void e(Context context) {
        setOrientation(1);
        setGravity(17);
        View inflate = LayoutInflater.from(context).inflate(R.layout.hky, (ViewGroup) null);
        this.f59588d = inflate;
        this.f59589e = (LinearLayout) inflate.findViewById(R.id.f69443ir);
        this.f59590f = (RelativeLayout) this.f59588d.findViewById(R.id.f69433iq);
        this.f59591h = (AvatarImageView) this.f59588d.findViewById(R.id.f69403in);
        this.f59592i = (AvatarImageView) this.f59588d.findViewById(R.id.f69413io);
        this.f59593m = (AvatarImageView) this.f59588d.findViewById(R.id.f69423ip);
        this.C = (TextView) this.f59588d.findViewById(R.id.f69453is);
        a();
        this.f59590f.setOnClickListener(this);
        addView(this.f59588d);
    }

    private void b(BusinessFeedData businessFeedData) {
        ArrayList<User> arrayList;
        if (businessFeedData == null || businessFeedData.getCellGuiding() == null || (arrayList = businessFeedData.getCellGuiding().vecUsers) == null || arrayList.size() != 3) {
            return;
        }
        long j3 = arrayList.get(0).uin;
        long j16 = arrayList.get(1).uin;
        long j17 = arrayList.get(2).uin;
        this.f59591h.j(j3);
        this.f59592i.j(j16);
        this.f59593m.j(j17);
    }

    private void c(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getCellGuiding() == null) {
            return;
        }
        this.C.setText(businessFeedData.getCellGuiding().title);
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdle() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateScrolling() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void startFlashNickName() {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void onStateIdleOnDetail(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setAlpha(int i3) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasRecommHeader(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setHasSearchSeparator(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setNeedFillBlackArea(boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedElementClickListener(g gVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void setOnFeedEventListener(h hVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateLikeInfo(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateRecommAction(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTransparentBackground(BusinessFeedData businessFeedData) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void reportFeed(BusinessFeedData businessFeedData, int i3) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void showSearchSeparator(boolean z16, String str) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateTitle(BusinessFeedData businessFeedData, Boolean bool) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }

    @Override // com.qzone.proxy.feedcomponent.ui.AbsFeedView
    public void updateSpecialFollowInfo(BusinessFeedData businessFeedData, long j3, boolean z16) {
    }
}
