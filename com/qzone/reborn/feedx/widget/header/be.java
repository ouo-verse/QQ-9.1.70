package com.qzone.reborn.feedx.widget.header;

import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.feed.utils.e;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.Serializable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class be extends d implements View.OnClickListener, com.qzone.feed.utils.e {
    private TextView C;

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.h f56233f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f56234h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f56235i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f56236m;

    public be(View view) {
        super(view);
        this.f56234h = (RelativeLayout) view.findViewById(R.id.f68533ga);
        this.f56235i = (ImageView) view.findViewById(R.id.f68543gb);
        this.f56236m = (TextView) view.findViewById(R.id.f68553gc);
        TextView textView = (TextView) view.findViewById(R.id.f68563gd);
        this.C = textView;
        textView.setOnClickListener(this);
    }

    private void o() {
        String str;
        QZoneFeedUtil.X(this.f56233f.b2().S(), com.qzone.reborn.feedx.widget.i.d(this.C), this.f56233f.C2(), "pg_qz_dynamic_detail_page");
        if (this.f56233f.w2()) {
            str = "1";
        } else {
            str = "2";
        }
        LpReportInfo_pf00064.allReport(346, 10, 3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(UIStateData uIStateData) {
        if (uIStateData.getData() != null) {
            q();
        }
    }

    private void q() {
        String str;
        this.f56234h.setVisibility(0);
        this.f56236m.setText(this.f56233f.q2());
        rn.h.a(this.f56235i, "qui_calendar", R.color.qui_common_icon_primary);
        if (this.f56233f.w2()) {
            str = "1";
        } else {
            str = "2";
        }
        LpReportInfo_pf00064.allReport(346, 9, 2, str);
    }

    @Override // d5.n
    public boolean Lc() {
        return false;
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QzoneFeedxDetailHeaderTitleElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        String str;
        com.qzone.reborn.feedx.viewmodel.h hVar = (com.qzone.reborn.feedx.viewmodel.h) k(com.qzone.reborn.feedx.viewmodel.h.class);
        this.f56233f = hVar;
        hVar.f55901m.observe(i(), new Observer() { // from class: com.qzone.reborn.feedx.widget.header.bd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                be.this.p((UIStateData) obj);
            }
        });
        if (this.f56233f.w2()) {
            str = "1";
        } else {
            str = "2";
        }
        LpReportInfo_pf00064.allReport(346, 9, 1, str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f68563gd) {
            o();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // d5.n
    public void F7() {
    }

    @Override // d5.n
    public void b9(d5.k<BusinessFeedData> kVar) {
    }

    @Override // com.qzone.feed.utils.e
    public void x0(e.a aVar, Serializable serializable, Parcelable parcelable, Map<String, Object> map) {
    }
}
