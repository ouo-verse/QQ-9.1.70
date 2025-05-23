package com.qzone.reborn.feedpro.part;

import android.view.View;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b extends com.qzone.reborn.base.k implements a {
    public com.qzone.reborn.feedpro.viewmodel.c C9() {
        if (getPartHost() instanceof com.qzone.reborn.feedpro.viewmodel.a) {
            return ((com.qzone.reborn.feedpro.viewmodel.a) getPartHost()).Le();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }

    @Override // com.qzone.reborn.feedpro.part.a
    public void c9() {
    }
}
