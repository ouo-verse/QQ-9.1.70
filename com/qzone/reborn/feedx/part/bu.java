package com.qzone.reborn.feedx.part;

import android.view.View;
import androidx.lifecycle.Observer;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bu extends g {
    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFriendFeedTopBannerPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        final com.qzone.reborn.feedx.viewmodel.q qVar = (com.qzone.reborn.feedx.viewmodel.q) getViewModel(com.qzone.reborn.feedx.viewmodel.q.class);
        final gf.n nVar = (gf.n) getIocInterface(gf.n.class);
        qVar.F2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.feedx.part.bt
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bu.E9(com.qzone.reborn.feedx.viewmodel.q.this, nVar, (ArrayList) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E9(com.qzone.reborn.feedx.viewmodel.q qVar, gf.n nVar, ArrayList arrayList) {
        if ((arrayList == null || arrayList.size() <= 0) && !qVar.getMNeedRefresh() && nVar.d()) {
            nVar.a();
        }
    }
}
