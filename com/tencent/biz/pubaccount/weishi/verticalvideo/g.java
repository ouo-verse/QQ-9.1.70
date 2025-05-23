package com.tencent.biz.pubaccount.weishi.verticalvideo;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface g extends com.tencent.biz.pubaccount.weishi.d<h> {
    HashSet<rz.a> C(QBaseActivity qBaseActivity);

    Map<String, String> E();

    void F(boolean z16);

    void H(boolean z16, boolean z17, String str);

    void I(String str);

    boolean J();

    boolean L();

    void M(boolean z16);

    List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N(ArrayList arrayList);

    void Q(RecyclerView.ViewHolder viewHolder);

    void T0(RecyclerView.ViewHolder viewHolder, int i3);

    boolean U();

    boolean V();

    void X(String str, WSVerticalPageFragment wSVerticalPageFragment, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar);

    WSAutoShowCommentParams Y();

    void Z();

    void a(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16);

    void a0();

    void b(WSSimpleBaseEvent wSSimpleBaseEvent);

    void c();

    int c0();

    void d(com.tencent.biz.pubaccount.weishi.player.e eVar);

    void doOnPause();

    void doOnResume();

    void f0(RecyclerView.ViewHolder viewHolder);

    void g();

    void g0();

    Map<String, String> h0();

    void handleIntent(Bundle bundle);

    void j();

    int k0();

    void l();

    boolean m();

    void n(RecyclerView.ViewHolder viewHolder);

    int p(int i3);

    void p0(String str);

    void r(String str);

    void s0();

    int t();

    boolean t0();

    void u0(boolean z16);

    com.tencent.biz.pubaccount.weishi.player.e w();

    hz.a w0();

    void y(BaseViewHolder<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> baseViewHolder, int i3);
}
