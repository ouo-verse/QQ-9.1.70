package com.qzone.reborn.feedx.presenter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.biz.richframework.compat.RFWNinePatchUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.report.QZonePushReporter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bk extends vg.a {
    protected QZoneRichTextView F;
    private xg.i G;
    private ch.d H;
    private FrameLayout I;
    private QZoneRichTextView J;
    private FrameLayout K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements TextCellLayout.OnCellClickListener {
        a() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell textCell, View view) {
            bk.this.R(textCell, view);
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater onTextOperater) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements TextCellLayout.OnCellClickListener {
        b() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell textCell, View view) {
            bk.this.R(textCell, view);
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater onTextOperater) {
            return false;
        }
    }

    private void O(String str) {
        if (P() == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("touin", Long.valueOf(this.f441565h.getUser().uin));
        hashMap.put(QZonePushReporter.EVENT_CODE_TYPE1, "ev_qz_wishes");
        hashMap.put("qua", com.tencent.open.adapter.a.f().i());
        fo.c.c(str, hashMap);
    }

    private com.tencent.mobileqq.service.qzone.bean.a P() {
        com.tencent.mobileqq.service.qzone.bean.a aVar;
        if (com.tencent.mobileqq.service.qzone.e.f286406a.e() && this.f441565h.getCellFeedCommInfo() != null && this.f441565h.getCellFeedCommInfo().extendInfo != null) {
            String str = this.f441565h.getCellFeedCommInfo().extendInfo.get("feed_res");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                aVar = (com.tencent.mobileqq.service.qzone.bean.a) new Gson().fromJson(str, com.tencent.mobileqq.service.qzone.bean.a.class);
            } catch (JsonSyntaxException e16) {
                QLog.e("QZoneFeedTextContentPresenter", 1, "getHolidayFeedRes  e = " + e16);
                aVar = null;
            }
            if (aVar != null && aVar.a() != null) {
                return aVar;
            }
        }
        return null;
    }

    private void Q(View view) {
        if (com.qzone.reborn.feedx.util.x.f55790a.c(o())) {
            return;
        }
        xg.d.a(this.f441565h, this.C, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(TextCell textCell, View view) {
        if ((textCell instanceof UserNameCell) && textCell.getUin() != null && textCell.getUin().longValue() > 0) {
            ho.h.b(this.C, textCell.getUin().longValue());
        } else {
            if (textCell == null || TextUtils.isEmpty(textCell.getUrl()) || view == null) {
                return;
            }
            yo.d.d(textCell.getUrl(), view.getContext(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public boolean X(View view) {
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

    private void T() {
        this.F.setTextColor(this.f441562d.getResources().getColor(R.color.qui_common_text_primary));
        this.F.setTextSize(ViewUtils.dpToPx(17.0f));
        this.F.setPadding(0, 0, 0, 0);
        this.F.setTextColorLink(this.f441562d.getResources().getColor(R.color.qui_common_text_link));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Q(view);
        O("ev_qz_wishes_click");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Q(view);
        O("ev_qz_wishes_click");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Q(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(LoadState loadState, Option option) {
        if (loadState.isFinishSuccess() && option.getResultBitMap() != null && NinePatch.isNinePatchChunk(option.getResultBitMap().getNinePatchChunk())) {
            this.I.setBackground(RFWNinePatchUtils.getNinePatchDrawable(option.getResultBitMap()));
        }
    }

    private void Z(String str) {
        this.I.setVisibility(8);
        this.K.setPadding(ImmersiveUtils.dpToPx(13.0f), 0, ImmersiveUtils.dpToPx(13.0f), ImmersiveUtils.dpToPx(12.0f));
        com.tencent.mobileqq.service.qzone.bean.a P = P();
        if (P == null) {
            return;
        }
        f0(P);
        this.K.setPadding(ImmersiveUtils.dpToPx(13.0f), 0, ImmersiveUtils.dpToPx(13.0f), ImmersiveUtils.dpToPx(10.0f));
        this.J.setRichText(str);
        this.J.setLineSpace(ImmersiveUtils.dpToPx(1.5f));
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.be
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bk.this.U(view);
            }
        });
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.bf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bk.this.V(view);
            }
        });
        this.J.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qzone.reborn.feedx.presenter.bg
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean X;
                X = bk.this.X(view);
                return X;
            }
        });
        this.J.setOnCellClickListener(new a());
    }

    private void a0() {
        this.F.setOnCellClickListener(new b());
    }

    private void b0() {
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.bh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bk.this.W(view);
            }
        });
        this.F.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qzone.reborn.feedx.presenter.bi
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean X;
                X = bk.this.X(view);
                return X;
            }
        });
    }

    private void c0(BusinessFeedData businessFeedData, String str) {
        CellSummary cellSummaryV2 = businessFeedData.getCellSummaryV2();
        if (cellSummaryV2 != null) {
            boolean z16 = businessFeedData.feedType == 4097;
            this.F.setFont(cellSummaryV2.getFontId(z16), cellSummaryV2.getFontUrl(z16), TextCellLayout.fontType2native(cellSummaryV2.getFontType(z16)), cellSummaryV2.getFontBGUrl(z16));
            QZoneFeedxViewUtils.j(this.F, cellSummaryV2.getSuperFontInfo(z16));
            this.F.setTextInType(cellSummaryV2.getFontSize());
        }
        this.F.setRichText(str);
        this.F.setLineSpace(ImmersiveUtils.dpToPx(1.5f));
        this.F.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.F.getLayoutParams();
        layoutParams.topMargin = -ImmersiveUtils.dpToPx(1.5f);
        layoutParams.bottomMargin = -ImmersiveUtils.dpToPx(1.5f);
        b0();
        a0();
        QLog.d("QZoneFeedTextContentPresenter", 1, "setupContentSummary   | feedKey = " + businessFeedData.getFeedCommInfo().feedskey + " | pos = " + this.f441567m + " | summaryText = " + com.tencent.util.k.d(str) + " | hashCode = " + hashCode());
    }

    private void d0(BusinessFeedData businessFeedData) {
        if (VasNormalToggle.VAS_BUG_118375991.isEnable(true)) {
            String str = Build.MANUFACTURER;
            if (!(Build.VERSION.SDK_INT == 23 && str.toLowerCase().contains("oppo")) && VasToggle.BUG_104274963.isEnable(true)) {
                if (this.H == null) {
                    this.H = new ch.d(this.F, this.f441562d);
                }
                this.H.f(businessFeedData);
            }
        }
    }

    private void e0() {
        if (!com.qzone.reborn.feedx.util.x.f55790a.c(o())) {
            this.F.setMaxLine(8);
            this.F.setShowMore(true);
            this.F.setShowMoreTextSize(ImmersiveUtils.dpToPx(12.0f));
            this.F.setShowMoreTextUnClickable(true);
            this.F.setShowMoreTextColor(this.f441562d.getResources().getColor(R.color.qui_common_text_secondary));
            return;
        }
        this.F.setShowMore(false);
        this.F.setMaxLine(-1);
        this.F.setShowMoreTextSize(0.0f);
        this.F.setShowMoreTextUnClickable(false);
        this.F.setShowMoreTextColor(0);
    }

    private void f0(com.tencent.mobileqq.service.qzone.bean.a aVar) {
        String b16;
        String d16;
        if (aVar != null && aVar.a() != null) {
            this.I.setVisibility(0);
            this.I.setBackground(null);
            this.F.setVisibility(8);
            if (com.qzone.reborn.util.k.f59549a.f()) {
                b16 = aVar.a().a();
            } else {
                b16 = aVar.a().b();
            }
            String a16 = com.tencent.mobileqq.service.qzone.e.f286406a.a(b16);
            if (!TextUtils.isEmpty(a16)) {
                Option obtain = Option.obtain();
                obtain.setUrl(a16);
                obtain.setIsNinePatch(true);
                com.tencent.mobileqq.qzone.picload.c.a().i(obtain, new IPicLoadStateListener() { // from class: com.qzone.reborn.feedx.presenter.bj
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option) {
                        bk.this.Y(loadState, option);
                    }
                });
            }
            try {
                if (QQTheme.isNowThemeIsNightForQzone()) {
                    d16 = aVar.a().c();
                } else {
                    d16 = aVar.a().d();
                }
                if (TextUtils.isEmpty(d16)) {
                    return;
                }
                this.J.setTextColor(Color.parseColor(d16));
                return;
            } catch (Exception e16) {
                QLog.e("QZoneFeedTextContentPresenter", 1, "initHolidayUI  e = " + e16);
                return;
            }
        }
        QLog.e("QZoneFeedTextContentPresenter", 1, "updateContentLayoutBg  bubbleBean == null");
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedTextContentPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nof;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public void z() {
        super.z();
        try {
            O("ev_qz_wishes_imp");
        } catch (Exception e16) {
            QLog.e("QZoneFeedTextContentPresenter", 1, "dtHolidayReport   e = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    public void A(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        this.f441562d.setVisibility(8);
        T();
        e0();
        String e16 = com.qzone.reborn.feedx.util.n.e(businessFeedData);
        if (TextUtils.isEmpty(e16)) {
            return;
        }
        c0(businessFeedData, e16);
        this.f441562d.setVisibility(0);
        d0(businessFeedData);
        try {
            Z(e16);
        } catch (Exception e17) {
            QLog.e("QZoneFeedTextContentPresenter", 1, "parseAndUpdateHolidayBubbleLayout   e = " + e17);
        }
    }

    @Override // vg.a
    protected void C(View view) {
        this.I = (FrameLayout) view.findViewById(R.id.jbe);
        this.F = (QZoneRichTextView) view.findViewById(R.id.nbg);
        this.J = (QZoneRichTextView) view.findViewById(R.id.n3b);
        this.K = (FrameLayout) view.findViewById(R.id.nbf);
    }
}
