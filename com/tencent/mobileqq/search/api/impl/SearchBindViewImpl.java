package com.tencent.mobileqq.search.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.search.api.ISearchBindView;
import com.tencent.mobileqq.search.business.game.e;
import lo2.s;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchBindViewImpl implements ISearchBindView {
    @Override // com.tencent.mobileqq.search.api.ISearchBindView
    public void bindNetSearchGameView(Object obj, Object obj2) {
        com.tencent.mobileqq.search.business.game.d.b((s) obj, (e) obj2);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchBindView
    public void bindNetSearchGuildItemView(Object obj, Object obj2, Bundle bundle) {
        go2.c.c(obj, obj2, bundle);
    }
}
