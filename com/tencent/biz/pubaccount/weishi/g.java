package com.tencent.biz.pubaccount.weishi;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.util.ba;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends LinearLayoutManager {
    public g(Context context, int i3, boolean z16) {
        super(context, i3, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutManager
    public int getExtraLayoutSpace(RecyclerView.State state) {
        return super.getExtraLayoutSpace(state) + ba.n();
    }
}
