package com.tencent.biz.pubaccount.weishi.main;

import com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/main/WSVideoPageChangeDefaultObserver;", "Lcom/tencent/biz/pubaccount/weishi/main/WSVideoPageChangeObserver;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "data", "", "position", "", "onVideoSelected", "onVideoSelectedIdle", "", "uid", "onVideoPageHeaderClick", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSVideoPageChangeDefaultObserver implements WSVideoPageChangeObserver {
    @Override // com.tencent.biz.pubaccount.weishi.main.WSVideoPageChangeObserver
    public void onVideoPageHeaderClick(String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        WSProfileFragment.ri(BaseApplication.context, uid, "click_avatar");
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSVideoPageChangeObserver
    public void onVideoSelected(j data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSVideoPageChangeObserver
    public void onVideoSelectedIdle(j data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
    }
}
