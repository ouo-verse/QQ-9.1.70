package com.tencent.liteav.sdkcommon;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final g f119141a;

    /* renamed from: b, reason: collision with root package name */
    private final Button f119142b;

    j(g gVar, Button button) {
        this.f119141a = gVar;
        this.f119142b = button;
    }

    public static View.OnClickListener a(g gVar, Button button) {
        return new j(gVar, button);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        g gVar = this.f119141a;
        boolean z16 = gVar.f119130m;
        if (!z16) {
            gVar.f119119b.height = gVar.f119131n / 2;
        } else {
            WindowManager.LayoutParams layoutParams = gVar.f119119b;
            int i3 = gVar.f119131n;
            layoutParams.height = i3;
            int i16 = layoutParams.y;
            int i17 = i3 + i16;
            int i18 = gVar.f119118a.heightPixels;
            if (i17 > i18) {
                layoutParams.height = i18 - i16;
            }
        }
        gVar.f119130m = !z16;
        gVar.f119123f.updateViewLayout(gVar.f119124g, gVar.f119119b);
        ViewGroup.LayoutParams layoutParams2 = gVar.f119128k.getLayoutParams();
        layoutParams2.height = gVar.b();
        gVar.f119128k.setLayoutParams(layoutParams2);
        gVar.f119121d.post(l.a(gVar));
        EventCollector.getInstance().onViewClicked(view);
    }
}
