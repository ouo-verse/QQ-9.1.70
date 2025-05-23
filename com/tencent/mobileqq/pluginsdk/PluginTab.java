package com.tencent.mobileqq.pluginsdk;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabHost;
import com.tencent.mobileqq.pluginsdk.PluginTabHost;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes16.dex */
public class PluginTab extends PluginActivity implements TabHost.TabContentFactory, TabHost.OnTabChangeListener {
    static IPatchRedirector $redirector_;
    private TabHost.OnTabChangeListener mOnTabChangeListener;
    private PluginTabHost mPluginTabHost;
    private String mPreTag;

    public PluginTab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected final void addTabSpec(TabHost.TabSpec tabSpec, String str, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, tabSpec, str, intent);
            return;
        }
        if (this.mPluginTabHost == null) {
            return;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginTab addTabSpec:" + tabSpec.getTag() + ", " + str);
        }
        tabSpec.setContent(this);
        this.mPluginTabHost.addPluginInfo(tabSpec.getTag(), str, intent);
        this.mPluginTabHost.addTab(tabSpec);
    }

    @Override // android.widget.TabHost.TabContentFactory
    public View createTabContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginTab createTabContent:" + str);
        }
        PluginTabHost.TabSpecPluginInfo pluginInfo = this.mPluginTabHost.getPluginInfo(str);
        View view = null;
        if (pluginInfo == null) {
            return null;
        }
        try {
            ClassLoader classLoader = getBaseContext().getClassLoader();
            IPluginActivity iPluginActivity = (IPluginActivity) classLoader.loadClass(pluginInfo.mActivityName).newInstance();
            if (DebugHelper.sDebug) {
                DebugHelper.log("plugin_tag", "PluginTab Activity:" + iPluginActivity);
            }
            iPluginActivity.IInit(this.mPluginID, this.mApkFilePath, this, classLoader, this.mPackageInfo, this.mUseSkinEngine, this.mPluginResourcesType);
            iPluginActivity.ISetIsTab();
            iPluginActivity.ISetParent(this);
            iPluginActivity.ISetIntent(pluginInfo.mIntent);
            iPluginActivity.IOnSetTheme();
            iPluginActivity.IOnCreate(null);
            view = iPluginActivity.IGetContentView();
            pluginInfo.mActivity = iPluginActivity;
            return view;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("plugin_tag", 1, this.mPluginID + " createTabContent fail", e16);
            PluginRuntime.handleCrash(e16, this.mPluginID, this);
            return view;
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginActivity, com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    protected IPluginActivity getActivityByTag(String str) {
        PluginTabHost pluginTabHost;
        PluginTabHost.TabSpecPluginInfo pluginInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (IPluginActivity) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        if (str != null && (pluginTabHost = this.mPluginTabHost) != null && (pluginInfo = pluginTabHost.getPluginInfo(str)) != null) {
            return pluginInfo.mActivity;
        }
        return null;
    }

    protected IPluginActivity getCurrentActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IPluginActivity) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        PluginTabHost pluginTabHost = this.mPluginTabHost;
        if (pluginTabHost == null) {
            return null;
        }
        return getActivityByTag(pluginTabHost.getCurrentTabTag());
    }

    public PluginTabHost getTabHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (PluginTabHost) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mPluginTabHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        IPluginActivity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.IOnActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginActivity, com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        PluginTabHost.TabSpecPluginInfo pluginInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            int tabCount = this.mPluginTabHost.getTabCount();
            for (int i3 = 0; i3 < tabCount; i3++) {
                TabHost.TabSpec tabAt = this.mPluginTabHost.getTabAt(i3);
                if (tabAt != null && (pluginInfo = this.mPluginTabHost.getPluginInfo(tabAt.getTag())) != null) {
                    IPluginActivity iPluginActivity = pluginInfo.mActivity;
                }
            }
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        PluginTabHost.TabSpecPluginInfo pluginInfo;
        IPluginActivity iPluginActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        PluginTabHost pluginTabHost = this.mPluginTabHost;
        if (pluginTabHost == null) {
            return;
        }
        int tabCount = pluginTabHost.getTabCount();
        for (int i3 = 0; i3 < tabCount; i3++) {
            TabHost.TabSpec tabAt = this.mPluginTabHost.getTabAt(i3);
            if (tabAt != null && (pluginInfo = this.mPluginTabHost.getPluginInfo(tabAt.getTag())) != null && (iPluginActivity = pluginInfo.mActivity) != null) {
                iPluginActivity.IOnDestroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onPause();
        IPluginActivity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.IOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, android.app.Activity
    public void onRestart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onRestart();
        IPluginActivity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.IOnRestart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        IPluginActivity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.IOnResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onStart();
        IPluginActivity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.IOnStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.BasePluginActivity, mqq.app.BaseActivity, android.app.Activity
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onStop();
        IPluginActivity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.IOnStop();
        }
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginTab onTabChanged:" + str);
        }
        IPluginActivity activityByTag = getActivityByTag(this.mPreTag);
        if (activityByTag != null) {
            activityByTag.IOnPause();
        }
        this.mPreTag = str;
        IPluginActivity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.IOnResume();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.mOnTabChangeListener;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) onTabChangeListener);
        } else {
            this.mOnTabChangeListener = onTabChangeListener;
        }
    }

    protected final void setPluginTabHost(PluginTabHost pluginTabHost) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) pluginTabHost);
            return;
        }
        if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginTab setPluginTabHost:" + pluginTabHost);
        }
        this.mPluginTabHost = pluginTabHost;
        pluginTabHost.setup();
        this.mPluginTabHost.setOnTabChangedListener(this);
    }
}
