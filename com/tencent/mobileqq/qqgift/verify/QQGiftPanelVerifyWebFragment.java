package com.tencent.mobileqq.qqgift.verify;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.h;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* loaded from: classes16.dex */
public class QQGiftPanelVerifyWebFragment extends WebViewFragment implements h {
    static IPatchRedirector $redirector_;
    private String C;
    private long D;

    public QQGiftPanelVerifyWebFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.C = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0() {
        try {
            getActivity().getWindow().setSoftInputMode(16);
        } catch (Throwable th5) {
            QLog.e("GiftPanelVerifyWebFragment", 1, "setSoftInputMode error, ", th5);
        }
    }

    public static QQGiftPanelVerifyWebFragment qh(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        QQGiftPanelVerifyWebFragment qQGiftPanelVerifyWebFragment = new QQGiftPanelVerifyWebFragment();
        qQGiftPanelVerifyWebFragment.setArguments(bundle);
        return qQGiftPanelVerifyWebFragment;
    }

    @Override // com.tencent.mobileqq.webview.swift.h
    public WebViewFragment newInstance(int i3, u uVar, WebViewTabBarData webViewTabBarData, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WebViewFragment) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), uVar, webViewTabBarData, intent);
        }
        return qh(intent);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.C = this.intent.getStringExtra("extra_key_app_id");
        this.D = this.intent.getLongExtra("extra_key_req_flag", 0L);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        } else {
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (onCreateView != null) {
                onCreateView.post(new Runnable() { // from class: com.tencent.mobileqq.qqgift.verify.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQGiftPanelVerifyWebFragment.this.lambda$onCreateView$0();
                    }
                });
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QQGiftPanelVerifyBroadcastReceiver.a(this.C, this.D, 100);
            super.onDestroy();
        }
    }
}
