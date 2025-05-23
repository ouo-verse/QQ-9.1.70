package com.qzone.reborn.feedx.widget.header;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class f extends d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.qzone.util.e.a(f.this.g(), false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public f(View view) {
        super(view);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneFeedxHeaderCancelDialogElement";
    }

    public void n() {
        FrameLayout frameLayout = (FrameLayout) d().findViewById(R.id.mzr);
        if (QZoneUnreadServletLogic.o(LoginData.getInstance().getUin()) == 2) {
            QZLog.d("QZoneFeedxHeaderCancelDialogElement", 1, "setCancelBgHeight height:", Integer.valueOf(d().getHeight()));
            ViewGroup.LayoutParams layoutParams = d().getLayoutParams();
            layoutParams.height = d().getHeight();
            frameLayout.setLayoutParams(layoutParams);
            frameLayout.setVisibility(0);
            frameLayout.setOnClickListener(new a());
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16) {
            n();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
    }
}
