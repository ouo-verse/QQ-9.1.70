package com.qzone.reborn.feedx.widget.header;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.qzone.homepage.ui.component.FriendshipWidget;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class al extends d {

    /* renamed from: f, reason: collision with root package name */
    private boolean f56190f;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f56191h;

    /* renamed from: i, reason: collision with root package name */
    private FriendshipWidget f56192i;

    /* renamed from: m, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.w f56193m;

    public al(View view, boolean z16) {
        super(view);
        this.f56190f = false;
        this.f56191h = (FrameLayout) view.findViewById(R.id.mzy);
        this.f56190f = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(x6.a aVar) {
        FriendshipWidget friendshipWidget = this.f56192i;
        if (friendshipWidget != null) {
            friendshipWidget.i(aVar, this.f56193m.getMUin());
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneUserHomeFriendshipElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) k(com.qzone.reborn.feedx.viewmodel.w.class);
        this.f56193m = wVar;
        wVar.C2().observe(i(), new Observer() { // from class: com.qzone.reborn.feedx.widget.header.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                al.this.q((x6.a) obj);
            }
        });
        p();
    }

    public int o() {
        return ((CoverEnv.getFinalCoverHeight() + CoverEnv.getCoverFriendPaddingTop()) - QZoneFeedxViewUtils.e(g())) - com.qzone.util.ar.e(40.0f);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
        FriendshipWidget friendshipWidget = this.f56192i;
        if (friendshipWidget != null) {
            friendshipWidget.f();
        }
    }

    protected void p() {
        if (this.f56193m.M2() || this.f56191h == null) {
            return;
        }
        FriendshipWidget friendshipWidget = new FriendshipWidget(g(), this.f56190f);
        this.f56192i = friendshipWidget;
        View e16 = friendshipWidget.e();
        this.f56191h.setVisibility(0);
        this.f56191h.removeAllViews();
        this.f56191h.addView(e16);
        if (this.f56191h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f56191h.getLayoutParams();
            marginLayoutParams.bottomMargin = o();
            this.f56191h.setLayoutParams(marginLayoutParams);
        }
    }
}
