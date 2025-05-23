package com.tencent.biz.pubaccount.weishi.main;

import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.h;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class WSMainVerticalPresenter extends WSAbsMainPresenter {
    private stSimpleMetaFeed mIntentFeed;
    private String mIntentFeedId;
    protected String mPersonId;

    public WSMainVerticalPresenter(c cVar) {
        super(cVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSAbsMainPresenter
    protected List<QBaseFragment> createFragments() {
        ArrayList arrayList = new ArrayList();
        c view = getView();
        if (view != null) {
            WSVerticalPageFragment Rh = WSVerticalPageFragment.Rh(view.Ra());
            Rh.zi(this);
            arrayList.add(Rh);
            arrayList.add(WSRightContainerFragment.qh());
        }
        return arrayList;
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSAbsMainPresenter, com.tencent.biz.pubaccount.weishi.main.b
    public stSimpleMetaFeed getIntentFeed() {
        return this.mIntentFeed;
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSAbsMainPresenter, com.tencent.biz.pubaccount.weishi.main.b
    public String getIntentFeedId() {
        String str;
        if (!TextUtils.isEmpty(this.mIntentFeedId)) {
            return this.mIntentFeedId;
        }
        stSimpleMetaFeed stsimplemetafeed = this.mIntentFeed;
        return (stsimplemetafeed == null || (str = stsimplemetafeed.f25129id) == null) ? "" : str;
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSAbsMainPresenter, com.tencent.biz.pubaccount.weishi.main.b
    public void onRightLeftPageSelected(int i3) {
        h adapter;
        c view = getView();
        if (view == null || (adapter = view.getAdapter()) == null) {
            return;
        }
        view.Tb(i3 == 0);
        WSRightContainerFragment wSRightContainerFragment = (WSRightContainerFragment) adapter.getItem(1);
        if (i3 == 0) {
            wSRightContainerFragment.sh();
        } else {
            wSRightContainerFragment.rh(view.v6());
            if (!view.v6()) {
                WSVerticalPageFragment wSVerticalPageFragment = (WSVerticalPageFragment) adapter.getItem(0);
                reportAvatarClick(wSVerticalPageFragment, wSVerticalPageFragment.Th());
            }
        }
        view.G9(false);
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSAbsMainPresenter, com.tencent.biz.pubaccount.weishi.main.b
    public void handleIntent(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mPersonId = bundle.getString("person_id");
        this.mIntentFeedId = bundle.getString("key_feed_id");
        List list = (List) bundle.getSerializable("key_feed_list");
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mIntentFeed = (stSimpleMetaFeed) list.get(0);
    }
}
