package com.qzone.component.banner;

import android.content.Context;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.account.LoginData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VisitorBubbleBanner extends BaseBubbleBanner {
    public VisitorBubbleBanner(Context context) {
        super(context);
        BaseBubbleBanner.S = "VisitorBubbleBanner";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.component.banner.BaseBubbleBanner
    public void C() {
        super.C();
        vo.c.v(getContext(), LoginData.getInstance().getUin());
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(54);
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.component.banner.BaseBubbleBanner
    public void F() {
        super.F();
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 1;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 23;
    }

    @Override // com.qzone.component.banner.Banner
    public boolean j() {
        return false;
    }
}
