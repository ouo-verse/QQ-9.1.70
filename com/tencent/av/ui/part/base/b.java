package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.utils.DataReport;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends nw.a implements mw.c {

    /* renamed from: e, reason: collision with root package name */
    protected int f76258e = -1;

    /* renamed from: f, reason: collision with root package name */
    private CalloutPopupWindow f76259f = null;

    /* renamed from: h, reason: collision with root package name */
    protected long f76260h = -1;

    /* renamed from: i, reason: collision with root package name */
    protected int f76261i = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B9() {
        this.f76260h = System.currentTimeMillis();
        this.f76259f = null;
        this.f76258e = -1;
    }

    @Override // mw.c
    public void Y0(boolean z16) {
        String str;
        if (this.f76261i != 2 || System.currentTimeMillis() - this.f76260h > 250) {
            return;
        }
        if (z16) {
            str = "2";
        } else {
            str = "1";
        }
        DataReport.T(null, "dc00898", "", "", "0X800C447", "0X800C447", 0, 0, str, "", "", "");
    }

    @Override // nw.a
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        RFWIocAbilityProvider.g().registerIoc(view, this, mw.c.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), mw.c.class);
    }

    @Override // mw.c
    public boolean g2(int i3, View view, int i16, int i17) {
        String str;
        if (i3 <= this.f76258e) {
            return false;
        }
        CalloutPopupWindow calloutPopupWindow = this.f76259f;
        if (calloutPopupWindow != null) {
            calloutPopupWindow.dismiss();
        }
        Context context = view.getContext();
        CalloutPopupWindow build = new CalloutPopupWindow.DrawableBuilder(CalloutPopupWindow.builder(view.getContext()).setText(context.getString(i16)).setTextSize(14.0f).setTextColor(-1).setPosition(50).setLifetime(i17).setTextSingleLine(true).setMaxWidth((int) (context.getResources().getDisplayMetrics().widthPixels * 0.5d))).setBackgroundColor(context.getResources().getColor(R.color.black)).setBackgroundRadius(8).build().build();
        if (build != null) {
            build.showAsPointer(view);
            build.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.av.ui.part.base.a
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    b.this.B9();
                }
            });
        }
        this.f76259f = build;
        this.f76258e = i3;
        this.f76261i = i3;
        if (r.h0() != null && n.e().f() != null && i3 == 2) {
            if (n.e().f().P()) {
                str = "2";
            } else {
                str = "1";
            }
            ReportController.o(null, "dc00898", "", "", "0X800C446", "0X800C446", 0, 0, str, "", "", "");
        }
        return true;
    }
}
