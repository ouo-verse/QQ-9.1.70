package com.qzone.reborn.feedx.part;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class o extends g {

    /* renamed from: d, reason: collision with root package name */
    private tc.b f55311d;

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void j7(List<? extends BusinessFeedData> list, int i3) {
        super.j7(list, i3);
        tc.b bVar = this.f55311d;
        if (bVar == null) {
            return;
        }
        bVar.n2();
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void p4() {
        super.p4();
        this.f55311d = C9();
    }
}
