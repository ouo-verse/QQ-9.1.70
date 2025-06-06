package com.tencent.biz.pubaccount.weishi.main;

import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/main/WSVideoPageChangeObserver;", "Ljava/io/Serializable;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "data", "", "position", "", "onVideoSelected", "onVideoSelectedIdle", "", "uid", "onVideoPageHeaderClick", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public interface WSVideoPageChangeObserver extends Serializable {
    void onVideoPageHeaderClick(String uid);

    void onVideoSelected(j data, int position);

    void onVideoSelectedIdle(j data, int position);
}
