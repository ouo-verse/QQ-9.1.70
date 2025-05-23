package com.tencent.biz.pubaccount.weishi.main;

import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface b extends com.tencent.biz.pubaccount.weishi.d<c> {
    List<QBaseFragment> getFragments(Bundle bundle);

    stSimpleMetaFeed getIntentFeed();

    String getIntentFeedId();

    void handleIntent(Bundle bundle);

    void onRightLeftPageSelected(int i3);
}
