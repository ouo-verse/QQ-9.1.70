package com.tencent.mobileqq.minigame.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.QLog;
import ne0.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RedpacketTranslucentBrowserFragment extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment {
    public static final String TAG = "WebLog_RedpacketTranslucentBrowserFragment";

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        f.c(this, activity);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return f.d(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return f.e(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return f.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return f.g(this);
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
    public void onInitUIContent(Bundle bundle, t tVar) {
        try {
            DisplayUtil.setActivityFullScreen(super.getQBaseActivity());
            super.getQBaseActivity().getWindow().addFlags(1024);
            if (Build.VERSION.SDK_INT >= 28) {
                View decorView = super.getQBaseActivity().getWindow().getDecorView();
                WindowManager.LayoutParams attributes = super.getQBaseActivity().getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                super.getQBaseActivity().getWindow().setAttributes(attributes);
                super.getQBaseActivity().getWindow().getDecorView().setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "set fullscreen error", e16);
        }
        super.onInitUIContent(bundle, tVar);
        try {
            boolean z16 = super.getQBaseActivity().getIntent().getExtras().getBoolean("isLandScape");
            QLog.d(TAG, 1, "isLandScape in fragment is" + z16);
            if (z16) {
                QLog.d(TAG, 1, "\u4f7f\u7528redpacket\u81ea\u5df1\u7684fragment\uff0c\u8bbe\u7f6e\u80cc\u666f\u56fe\u7247");
                super.getQBaseActivity().getWindow().setBackgroundDrawableResource(R.drawable.n1n);
            }
        } catch (Exception e17) {
            QLog.e(TAG, 1, "RedpacketTranslucentBrowserFragment error", e17);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        f.l(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return f.o(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }
}
