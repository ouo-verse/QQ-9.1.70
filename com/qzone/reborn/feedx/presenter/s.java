package com.qzone.reborn.feedx.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class s extends vg.a {
    private QZoneRichTextView F;
    private xg.i G;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements CellTextView.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f55659a;

        a(View view) {
            this.f55659a = view;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
        public List<TextCell> a(List<TextCell> list) {
            return com.qzone.reborn.feedx.widget.b.c(list, this.f55659a.getResources().getColor(R.color.qui_common_text_primary));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        CellFeedCommInfo cellFeedCommInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        BusinessFeedData businessFeedData = this.f441566i;
        if (businessFeedData != null && (cellFeedCommInfo = businessFeedData.cellFeedCommInfo) != null && cellFeedCommInfo.appid == 7035) {
            QLog.d(getTAG(), 1, "onClick favor feed dont launch original feed");
        } else {
            xg.d.a(this.f441565h, this.C, view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean K(View view) {
        Activity c16 = com.qzone.reborn.feedx.widget.i.c(view);
        if (c16 == null) {
            QLog.e(getTAG(), 1, "onLongClick  activity == null");
            return false;
        }
        if (this.G == null) {
            this.G = new xg.i(c16);
        }
        return this.G.e(view, this.f441565h);
    }

    private void L() {
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s.this.J(view);
            }
        });
        this.F.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qzone.reborn.feedx.presenter.r
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean K;
                K = s.this.K(view);
                return K;
            }
        });
    }

    private void M() {
        if (!com.qzone.reborn.feedx.util.x.f55790a.c(o())) {
            this.F.setMaxLine(8);
            this.F.setShowMore(true);
            this.F.setShowMoreTextSize(ImmersiveUtils.dpToPx(12.0f));
            this.F.setShowMoreTextUnClickable(true);
            return;
        }
        this.F.setShowMore(false);
        this.F.setMaxLine(-1);
        this.F.setShowMoreTextSize(0.0f);
        this.F.setShowMoreTextUnClickable(false);
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        this.f441562d.setVisibility(8);
        String f16 = com.qzone.reborn.feedx.util.n.f(businessFeedData, true, com.qzone.reborn.feedx.util.x.f55790a.c(o()));
        if (TextUtils.isEmpty(f16)) {
            return;
        }
        this.F.setRichText(f16);
        M();
        this.f441562d.setVisibility(0);
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedForwardContentPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nni;
    }

    @Override // vg.a
    protected boolean x() {
        return true;
    }

    @Override // vg.a
    protected void C(View view) {
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) view.findViewById(R.id.niu);
        this.F = qZoneRichTextView;
        qZoneRichTextView.setTextColorLink(qZoneRichTextView.getContext().getColor(R.color.qui_common_text_link));
        this.F.setPreDecorateListener(new a(view));
        L();
    }
}
