package com.tencent.mobileqq.emosm.emosearch;

import android.view.View;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface c {
    String getSearchWord();

    void onHide(boolean z16);

    void onShow();

    void reportItemExposed();

    void resetEmoticonSearch();

    void setEmptyView(View view);

    void setLoadingStatus(int i3);

    void setSearchWords(String str);

    void startSearch(String str);
}
