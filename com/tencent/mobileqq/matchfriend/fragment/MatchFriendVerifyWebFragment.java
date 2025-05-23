package com.tencent.mobileqq.matchfriend.fragment;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.h;
import com.tencent.mobileqq.webview.swift.u;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendVerifyWebFragment extends WebViewFragment implements h {
    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void activityFinish() {
        getQBaseActivity().setResult(-1, new Intent());
        super.activityFinish();
    }

    @Override // com.tencent.mobileqq.webview.swift.h
    public WebViewFragment newInstance(int i3, u uVar, WebViewTabBarData webViewTabBarData, Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        MatchFriendVerifyWebFragment matchFriendVerifyWebFragment = new MatchFriendVerifyWebFragment();
        matchFriendVerifyWebFragment.setArguments(bundle);
        return matchFriendVerifyWebFragment;
    }
}
