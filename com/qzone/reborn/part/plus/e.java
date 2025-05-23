package com.qzone.reborn.part.plus;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.feed.utils.QZonePlusIconBubbleController;
import com.qzone.util.ak;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import eo.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e extends Part {

    /* renamed from: d, reason: collision with root package name */
    private View f58513d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f58514e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f58515f;

    /* renamed from: h, reason: collision with root package name */
    private final String f58516h;

    /* renamed from: i, reason: collision with root package name */
    private final int f58517i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            eo.c.f396879a.b();
            if (TextUtils.equals(e.this.f58516h, "2")) {
                i3 = 3;
            } else {
                i3 = QQTheme.isNowSimpleUI() ? 2 : 1;
            }
            e.this.broadcastMessage("OPEN_NEW_PLUS_MENU", Integer.valueOf(i3));
            if (e.this.f58517i > 0) {
                eo.a.f396875a.c(2);
                if (QZonePlusIconBubbleController.d() != null) {
                    ak.g(QZonePlusIconBubbleController.d(), 102);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public e(String str, int i3) {
        this.f58516h = str;
        this.f58517i = i3;
    }

    private LpReportInfo_pf00064 B9() {
        String str;
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        String str2 = "1";
        if (QzoneFrame.isNewConciseFragment()) {
            str = "1";
        } else {
            str = "0";
        }
        lpReportInfo_pf00064.reserves8 = str;
        if (!QQTheme.isNowSimpleUI()) {
            str2 = "0";
        }
        lpReportInfo_pf00064.reserves9 = str2;
        lpReportInfo_pf00064.reserves10 = this.f58516h;
        return lpReportInfo_pf00064;
    }

    private void C9() {
        String str;
        if (this.f58513d == null || this.f58514e == null || this.f58515f == null) {
            View findViewById = getPartRootView().findViewById(R.id.f166707dg0);
            this.f58513d = findViewById;
            AccessibilityUtil.p(findViewById, "\u53d1\u8868\u52a8\u6001");
            com.tencent.mobileqq.qui.b.f276860a.a(this.f58513d, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
            this.f58514e = (ImageView) getPartRootView().findViewById(R.id.hgu);
            this.f58515f = (ImageView) getPartRootView().findViewById(R.id.f68363fu);
            fo.b bVar = new fo.b();
            bVar.h(new c.a());
            if (this.f58516h.equals("1")) {
                str = "em_qz_plus_sign";
            } else {
                str = "em_qz_plus_suspend";
            }
            fo.c.o(this.f58513d, str, bVar);
        }
    }

    private void D9() {
        LpReportInfo_pf00064 B9 = B9();
        B9.actionType = 309;
        B9.subactionType = 102;
        B9.reserves = 2;
        LpReportManager.getInstance().reportToPF00064(B9, false, false);
    }

    private void F9() {
        C9();
        this.f58513d.setVisibility(0);
        this.f58513d.setOnClickListener(new a());
        this.f58514e.setImageResource(R.drawable.nws);
        A9(this.f58514e);
        LpReportInfo_pf00064.allReport(137, 4, 1);
        D9();
        if (this.f58517i > 0) {
            eo.a.f396875a.d(2);
        }
        E9();
    }

    public void E9() {
        if (getContext() == null) {
            return;
        }
        ImageView imageView = this.f58515f;
        if (imageView != null) {
            imageView.setColorFilter(getContext().getColor(R.color.qui_common_brand_standard));
        }
        ImageView imageView2 = this.f58514e;
        if (imageView2 != null) {
            imageView2.setColorFilter(getContext().getColor(R.color.qui_common_on_brand_primary));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFloatPlusIconPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        View view;
        super.handleBroadcastMessage(str, obj);
        if (!"DISMISS_PLUS_MENU".equals(str) || (view = this.f58513d) == null) {
            return;
        }
        view.sendAccessibilityEvent(8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        F9();
    }

    private void A9(ImageView imageView) {
        if (imageView == null || !(imageView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.height = ImmersiveUtils.dpToPx(20.0f);
        layoutParams.width = ImmersiveUtils.dpToPx(20.0f);
    }
}
