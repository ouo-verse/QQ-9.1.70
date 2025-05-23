package com.tencent.mobileqq.search.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.search.api.ISearchMore;
import com.tencent.mobileqq.search.business.game.GameSearchFragment;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchMoreImpl implements ISearchMore {
    @Override // com.tencent.mobileqq.search.api.ISearchMore
    public void openSearchMoreGamePage(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("search_words", str);
        QPublicFragmentActivity.start(context, intent, GameSearchFragment.class);
    }
}
