package com.tencent.mobileqq.widget.search;

import com.tencent.mobileqq.widget.search.QUISearchBar;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ActionCallbackAdapter implements QUISearchBar.ActionCallback {
    @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
    public boolean onBack() {
        return false;
    }

    @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
    public int onCancel() {
        return 0;
    }

    @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
    public boolean onClear() {
        return false;
    }

    @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
    public void onSearch() {
    }
}
