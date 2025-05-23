package com.tencent.biz.pubaccount.weishi.drama;

import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface b extends com.tencent.biz.pubaccount.weishi.d<c> {
    void S0(com.tencent.biz.pubaccount.weishi.player.e eVar);

    void T0(RecyclerView.ViewHolder viewHolder, int i3);

    void U0(boolean z16, boolean z17);

    void a(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16);

    void b(WSSimpleBaseEvent wSSimpleBaseEvent);

    void c();

    void d(com.tencent.biz.pubaccount.weishi.player.e eVar);

    void doOnPause();

    void doOnResume();
}
