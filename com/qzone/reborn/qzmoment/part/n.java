package com.qzone.reborn.qzmoment.part;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class n extends an.a {

    /* renamed from: d, reason: collision with root package name */
    private View f58975d;

    /* renamed from: e, reason: collision with root package name */
    private gn.c f58976e;

    private void D9() {
        fo.c.o(this.f58975d, "em_bas_shooting_entrance", null);
    }

    private void E9() {
        if (G9()) {
            return;
        }
        rn.d.d(getActivity(), this.f58975d);
    }

    private boolean G9() {
        if (this.f58976e == null) {
            this.f58976e = (gn.c) getIocInterface(gn.c.class);
        }
        gn.c cVar = this.f58976e;
        if (cVar == null || cVar.M7()) {
            return false;
        }
        c6.a.i(com.tencent.mobileqq.service.qzone.b.l());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        E9();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        F9(view);
    }

    private void F9(View view) {
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.f166707dg0);
        this.f58975d = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.qzmoment.part.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.this.H9(view2);
            }
        });
        D9();
        this.f58975d.setVisibility(0);
    }
}
