package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import com.qzone.module.feedcomponent.FeedUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellForwardListInfo;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class v extends vg.a {
    private QZoneRichTextView F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements TextCellLayout.OnCellClickListener {
        a() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell textCell, View view) {
            if (!(textCell instanceof UserNameCell) || ((UserNameCell) textCell).getUin().longValue() == 0) {
                return;
            }
            ho.h.b(((vg.a) v.this).C, textCell.getUin().longValue());
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater onTextOperater) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List K(View view, List list) {
        return com.qzone.reborn.feedx.widget.b.c(list, view.getResources().getColor(R.color.qui_common_text_primary));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(BusinessFeedData businessFeedData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String str = businessFeedData.getCellForwardInfo() != null ? businessFeedData.getCellForwardInfo().actionUrl : null;
        if (!TextUtils.isEmpty(str)) {
            yo.d.d(str, view.getContext(), null);
        }
        M(businessFeedData);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void N(final BusinessFeedData businessFeedData, CellForwardListInfo cellForwardListInfo) {
        this.F.setRichText("     " + cellForwardListInfo.displayStr);
        AccessibilityUtil.s(this.F, cellForwardListInfo.displayStr);
        this.F.setOnCellClickListener(new a());
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.this.L(businessFeedData, view);
            }
        });
    }

    @Override // vg.a
    public void B() {
        super.B();
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedForwardPresenter";
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnh;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public void z() {
        super.z();
    }

    private void M(BusinessFeedData businessFeedData) {
        String str;
        if (businessFeedData == null || businessFeedData.getUser() == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getUser() == null) {
            return;
        }
        String str2 = "1";
        if (businessFeedData.getUser().isSafeModeUser == 1) {
            str = "1";
        } else {
            str = "0";
        }
        if (!com.qzone.reborn.feedx.util.x.f55790a.c(o())) {
            str2 = "0";
        }
        LpReportInfo_pf00064.allReport(201, 3, 1, str, str2, businessFeedData.getFeedCommInfo().feedsid);
    }

    @Override // vg.a
    protected void C(final View view) {
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) view.findViewById(R.id.n2b);
        this.F = qZoneRichTextView;
        qZoneRichTextView.setTextSize(com.qzone.util.ar.e(14.0f));
        this.F.setPreDecorateListener(new CellTextView.d() { // from class: com.qzone.reborn.feedx.presenter.u
            @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
            public final List a(List list) {
                List K;
                K = v.K(view, list);
                return K;
            }
        });
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            this.f441562d.setVisibility(8);
            return;
        }
        BusinessFeedData businessFeedData2 = businessFeedData.parentFeedData;
        if (businessFeedData2 != null && businessFeedData2.isFriendLikeContainer()) {
            this.f441562d.setVisibility(8);
            return;
        }
        if (!FeedUtil.hasForwardCount(businessFeedData)) {
            this.f441562d.setVisibility(8);
            return;
        }
        CellForwardListInfo cellForwardInfo = businessFeedData.getCellForwardInfo();
        if (cellForwardInfo != null && cellForwardInfo.num > 0 && !TextUtils.isEmpty(cellForwardInfo.displayStr)) {
            N(businessFeedData, cellForwardInfo);
            this.f441562d.setVisibility(0);
        } else {
            this.f441562d.setVisibility(8);
        }
    }
}
