package com.tencent.mobileqq.teamwork.fragment;

import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkDocsListFragment extends WebViewFragment {
    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.r
    public void showActionSheet() {
        SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) this.mComponentsProvider.a(4);
        if (swiftBrowserShareMenuHandler != null) {
            Share share = (Share) getShare();
            if (share != null && ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrl(share.getShareUrl())) {
                getHostActivity().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
                swiftBrowserShareMenuHandler.C = new TeamWorkShareActionSheetBuilder(getHostActivity());
            }
            swiftBrowserShareMenuHandler.S(share, getUIStyle().f314620c);
        }
    }
}
