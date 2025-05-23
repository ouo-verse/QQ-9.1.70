package com.tencent.biz.pubaccount.weishi.main;

import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.g;
import com.tencent.mobileqq.app.QBaseFragment;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes32.dex */
public abstract class WSAbsMainPresenter implements b, WSVideoPageChangeObserver {
    public static final int PAGE_INDEX_LEFT = 0;
    public static final int PAGE_INDEX_RIGHT = 1;
    protected List<QBaseFragment> mFragments = createFragments();
    private final WeakReference<c> mViewWeakReference;

    public WSAbsMainPresenter(c cVar) {
        this.mViewWeakReference = new WeakReference<>(cVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    public void attachView(c cVar) {
    }

    protected abstract List<QBaseFragment> createFragments();

    @Override // com.tencent.biz.pubaccount.weishi.main.b
    public List<QBaseFragment> getFragments(Bundle bundle) {
        return this.mFragments;
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.b
    public stSimpleMetaFeed getIntentFeed() {
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.b
    public String getIntentFeedId() {
        return "";
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.b
    public abstract /* synthetic */ void handleIntent(Bundle bundle);

    @Override // com.tencent.biz.pubaccount.weishi.main.b
    public abstract /* synthetic */ void onRightLeftPageSelected(int i3);

    @Override // com.tencent.biz.pubaccount.weishi.main.WSVideoPageChangeObserver
    public void onVideoPageHeaderClick(String str) {
        c view = getView();
        if (view == null) {
            return;
        }
        x.i("WSVerticalMainPresenter", "[WSVerticalMainPresenter.java][onVideoPageHeaderClick]");
        view.yc();
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSVideoPageChangeObserver
    public void onVideoSelected(j jVar, int i3) {
        c view = getView();
        if (view == null) {
            return;
        }
        x.i("WSVerticalMainPresenter", "[WSVerticalMainPresenter.java][onVideoSelected] position" + i3);
        view.h9(false);
        view.y3(i3 == 1);
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSVideoPageChangeObserver
    public void onVideoSelectedIdle(j jVar, int i3) {
        c view = getView();
        if (view == null || this.mFragments.size() <= 1) {
            return;
        }
        x.i("WSVerticalMainPresenter", "[WSVerticalMainPresenter.java][onVideoSelectedIdle] position" + i3);
        boolean z16 = jVar.e().video_type != 2;
        setCanScrollHorizontally(view, jVar);
        ((WSRightContainerFragment) this.mFragments.get(1)).th(z16, jVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportAvatarClick(WSVerticalPageFragment wSVerticalPageFragment, stSimpleMetaFeed stsimplemetafeed) {
        g presenter = wSVerticalPageFragment.getPresenter();
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.p(wSVerticalPageFragment.getFrom(), wSVerticalPageFragment.getPlayScene(), "left_slide", 1007007, stsimplemetafeed, presenter == null ? null : presenter.h0());
    }

    protected void setCanScrollHorizontally(c cVar, j jVar) {
        boolean z16 = (jVar.e().video_type == 2 || jVar.e().video_type == 12) ? false : true;
        x.i("WSVerticalMainPresenter", "[WSVerticalMainPresenter][setCanScrollHorizontally] canScrollHorizon:" + z16);
        cVar.h9(z16);
    }

    public c getView() {
        return this.mViewWeakReference.get();
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    public void destroy() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    public void detachView() {
    }
}
