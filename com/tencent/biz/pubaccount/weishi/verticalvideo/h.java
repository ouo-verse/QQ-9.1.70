package com.tencent.biz.pubaccount.weishi.verticalvideo;

import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi.main.WSVideoPageChangeObserver;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface h extends v00.b<List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>> {
    void A0();

    void C();

    boolean D();

    com.tencent.biz.pubaccount.weishi.verticalvideo.choicepanel.a De();

    String Ec();

    boolean K3(boolean z16);

    void Ld();

    TextView Qc();

    void T(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list);

    List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> T9();

    stSimpleMetaFeed Tc();

    WSPlayerManager U0();

    WsCommentPresenter Ue();

    void Yb(int i3, int i16);

    WSVideoPageChangeObserver Zf();

    void b1(stGlobalConfig stglobalconfig);

    void c(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list);

    f getAdapter();

    String getFrom();

    String getIntentFeedId();

    String getPlayScene();

    WSSwipeRefreshLayout getRefreshLayout();

    boolean isFinishing();

    String mg();

    void n2(String str);

    void od();

    void pa(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar);

    void qa(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar);

    void qb(int i3, Intent intent);

    void r0();

    void ra(int i3);

    VideoFeedsRecyclerView x();
}
