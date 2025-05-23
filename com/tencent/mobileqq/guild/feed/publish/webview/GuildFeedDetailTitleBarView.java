package com.tencent.mobileqq.guild.feed.publish.webview;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qui.immersive.c;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes13.dex */
public class GuildFeedDetailTitleBarView extends SwiftIphoneTitleBarUI {
    public GuildFeedDetailTitleBarView(v vVar) {
        super(vVar);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void l() {
        Context context;
        boolean z16;
        try {
            Activity activity = this.f314045d.E;
            if (activity != null) {
                ViewGroup viewGroup = this.M;
                if (viewGroup != null) {
                    context = viewGroup.getContext();
                } else {
                    context = activity;
                }
                if (c.c(((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(context, R.color.qui_common_bg_bottom_light)) > c.f276883h) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ImmersiveUtils.setStatusTextColorNew(z16, activity.getWindow(), false);
            }
        } catch (Exception e16) {
            QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "initDefaultThemeTitleBar error" + e16.getMessage());
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void m() {
        ViewGroup viewGroup = this.M;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        WebViewProgressBar webViewProgressBar = this.f314045d.T;
        if (webViewProgressBar != null) {
            webViewProgressBar.setVisibility(8);
        }
    }
}
