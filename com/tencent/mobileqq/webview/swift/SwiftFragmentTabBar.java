package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.widget.TabBarView;
import java.util.List;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes20.dex */
public class SwiftFragmentTabBar extends TabBarView implements i {
    static IPatchRedirector $redirector_;

    public SwiftFragmentTabBar(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.i
    public void a(Intent intent, List<WebViewTabBarData> list, TabBarView.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, list, dVar);
            return;
        }
        if (list != null && list.size() >= 1) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                super.e(list.get(i3).tabName);
            }
            super.setOnTabChangeListener(dVar);
            super.setSelectedTab(0, false);
            super.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.i
    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this;
    }
}
