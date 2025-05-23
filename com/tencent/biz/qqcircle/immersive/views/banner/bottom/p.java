package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import feedcloud.FeedCloudMeta$StButtomBanner;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes4.dex */
public class p extends c implements View.OnClickListener {
    private static Set<String> H;
    private LinearLayout D;
    private FrameLayout E;
    private boolean F;
    private boolean G;

    public p(@NonNull a aVar) {
        super(aVar);
    }

    private boolean A() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (System.currentTimeMillis() - uq3.k.b().f("sp_key_click_banner_last_time", 0L) >= u()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (System.currentTimeMillis() - uq3.k.b().f("sp_key_show_banner_last_time", 0L) >= x()) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.F = z17;
        if (uq3.k.b().e("sp_key_show_banner_count", 0) < v("y")) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.G = z18;
        boolean z19 = z();
        QLog.d("QFSFeedFriendUpdateGuideView", 1, "isMeetFrequencyCtl click: " + z16 + ", hasShowBanner: " + z19 + ", interval: " + this.F + ", count: " + this.G);
        if (z16 && (this.F || this.G || z19)) {
            return true;
        }
        return false;
    }

    private void B() {
        this.D = (LinearLayout) this.f90604h.findViewById(R.id.f34340yw);
        if (this.E != null) {
            QLog.d("QFSFeedFriendUpdateGuideView", 1, "mLayout has inflate");
            return;
        }
        ViewStub viewStub = (ViewStub) this.f90604h.findViewById(R.id.f42251j_);
        if (viewStub != null && this.f90602e != null) {
            View inflate = viewStub.inflate();
            this.E = (FrameLayout) inflate.findViewById(R.id.f42231j8);
            ((TextView) inflate.findViewById(R.id.f42241j9)).setText(y());
            this.E.setOnClickListener(this);
            VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_FRIEND_GUIDE_PANEL);
            VideoReport.setElementClickPolicy(this.E, ClickPolicy.REPORT_NONE);
            VideoReport.setElementReuseIdentifier(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_FRIEND_GUIDE_PANEL + this.f90602e.f398449id.get());
        }
    }

    private void C(boolean z16) {
        int i3;
        FrameLayout frameLayout = this.E;
        int i16 = 0;
        if (frameLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            frameLayout.setVisibility(i3);
        }
        LinearLayout linearLayout = this.D;
        if (linearLayout != null) {
            if (!z16) {
                i16 = 8;
            }
            linearLayout.setVisibility(i16);
        }
    }

    private void D() {
        if (H == null) {
            H = new HashSet();
        }
        if (this.F) {
            uq3.k.b().n("sp_key_show_banner_last_time", System.currentTimeMillis());
            uq3.k.b().m("sp_key_show_banner_count", 0);
        }
        if (this.G && !z()) {
            uq3.k.b().m("sp_key_show_banner_count", uq3.k.b().e("sp_key_show_banner_count", 0) + 1);
        }
        QLog.d("QFSFeedFriendUpdateGuideView", 1, "updateBannerShowCount , interval: " + this.F + ", count: " + this.G + ", hasShowBanner: " + z());
        H.add(this.f90602e.f398449id.get());
    }

    private FeedCloudMeta$StButtomBanner t() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed == null) {
            return null;
        }
        return feedCloudMeta$StFeed.buttomBanner.get();
    }

    private long u() {
        return v(QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW) * 1000 * 86400;
    }

    private int v(String str) {
        String d16;
        if (t() == null) {
            d16 = "0";
        } else {
            d16 = bh.d(this.f90602e.buttomBanner.extInfo.get(), str);
        }
        try {
            return Integer.parseInt(d16);
        } catch (Exception e16) {
            QLog.d("QFSFeedFriendUpdateGuideView", 1, "parse error. ", e16);
            return 0;
        }
    }

    private String w() {
        if (t() == null) {
            return "";
        }
        return bh.d(this.f90602e.buttomBanner.extInfo.get(), QZoneDTLoginReporter.SCHEMA);
    }

    private long x() {
        return v(HippyTKDListViewAdapter.X) * 1000 * 86400;
    }

    private String y() {
        if (t() == null) {
            return "";
        }
        return this.f90602e.buttomBanner.title.get();
    }

    private boolean z() {
        Set<String> set;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && (set = H) != null) {
            return set.contains(feedCloudMeta$StFeed.f398449id.get());
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 124;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(e30.b bVar, int i3) {
        super.h(bVar, i3);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        boolean z16;
        if (this.f90602e == null || p() == null) {
            return false;
        }
        int pageId = p().getPageId();
        FeedCloudMeta$StButtomBanner feedCloudMeta$StButtomBanner = this.f90602e.buttomBanner.get();
        if (pageId == 503 && feedCloudMeta$StButtomBanner != null && feedCloudMeta$StButtomBanner.style_type.get() == 5) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || !A()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.E != null && view.getId() == R.id.f42231j8) {
            C(false);
            VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_FRIEND_GUIDE_PANEL);
            VideoReport.reportEvent("ev_xsj_abnormal_clck", this.E, new QCircleDTParamBuilder().buildElementParams());
            uq3.k.b().n("sp_key_show_banner_last_time", 0L);
            uq3.k.b().m("sp_key_show_banner_count", 0);
            uq3.k.b().n("sp_key_click_banner_last_time", System.currentTimeMillis());
            QCircleSchemeLauncher.d(j(), w());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        B();
        D();
        H.add(this.f90602e.f398449id.get());
        C(true);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        C(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
    }
}
