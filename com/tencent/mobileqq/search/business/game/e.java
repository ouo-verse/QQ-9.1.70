package com.tencent.mobileqq.search.business.game;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends com.tencent.mobileqq.search.business.net.view.c {
    private LinearLayout M;

    public e(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        super.a();
        this.M = (LinearLayout) j(this.E).findViewById(R.id.ecl);
    }

    public View p() {
        return this.M;
    }
}
