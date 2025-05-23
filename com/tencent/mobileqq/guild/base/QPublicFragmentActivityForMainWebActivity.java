package com.tencent.mobileqq.guild.base;

import android.content.res.Configuration;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.config.GuildArgusPreloadConfigParser;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* loaded from: classes12.dex */
public class QPublicFragmentActivityForMainWebActivity extends QPublicFragmentActivity implements u {

    /* renamed from: a0, reason: collision with root package name */
    private final boolean f214690a0 = GuildArgusPreloadConfigParser.c().getIsDelegateLayoutInflaterEnabled();

    /* renamed from: b0, reason: collision with root package name */
    private final boolean f214691b0 = GuildArgusPreloadConfigParser.c().getIsCloneInflaterInSubThreadEnabled();

    /* renamed from: c0, reason: collision with root package name */
    private final boolean f214692c0 = GuildArgusPreloadConfigParser.c().getIsDelegateResourceEnabled();

    /* JADX WARN: Multi-variable type inference failed */
    private WebViewFragment findCurrentWebViewFragment(List<Fragment> list) {
        if (list != null && !list.isEmpty()) {
            for (Fragment fragment : list) {
                if (fragment.isVisible()) {
                    if (fragment instanceof WebViewFragment) {
                        return (WebViewFragment) fragment;
                    }
                    if (fragment instanceof u) {
                        return ((u) fragment).getCurrentWebViewFragment();
                    }
                    WebViewFragment findCurrentWebViewFragment = findCurrentWebViewFragment(fragment.getChildFragmentManager().getFragments());
                    if (findCurrentWebViewFragment != null) {
                        return findCurrentWebViewFragment;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    public WebViewFragment getCurrentWebViewFragment() {
        return findCurrentWebViewFragment(super.getSupportFragmentManager().getFragments());
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isCloneInflaterInSubThreadEnabled() {
        return this.f214691b0;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isDelegateLayoutInflaterEnabled() {
        return this.f214690a0;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isDelegateResourceEnabled() {
        return this.f214692c0;
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    public boolean setBottomBarVisibility(boolean z16) {
        return false;
    }
}
