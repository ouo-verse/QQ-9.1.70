package com.tencent.mobileqq.pluginsdk;

import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.TabHost;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes16.dex */
public class PluginTabHost extends TabHost {
    static IPatchRedirector $redirector_;
    private final Map<String, TabSpecPluginInfo> mPluginInfos;
    private final List<TabSpecWrapper> mTabSpecs;

    /* loaded from: classes16.dex */
    protected static class TabSpecPluginInfo {
        static IPatchRedirector $redirector_;
        public IPluginActivity mActivity;
        public String mActivityName;
        public Intent mIntent;
        public String mTag;

        protected TabSpecPluginInfo(String str, String str2, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, intent);
                return;
            }
            this.mTag = str;
            this.mIntent = intent;
            this.mActivityName = str2;
        }
    }

    /* loaded from: classes16.dex */
    static class TabSpecWrapper {
        static IPatchRedirector $redirector_;
        public TabHost.TabSpec mTabSpec;
        public String mTag;

        TabSpecWrapper(String str, TabHost.TabSpec tabSpec) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) tabSpec);
            } else {
                this.mTag = str;
                this.mTabSpec = tabSpec;
            }
        }
    }

    public PluginTabHost(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mTabSpecs = new ArrayList();
            this.mPluginInfos = new HashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPluginInfo(String str, String str2, Intent intent) {
        this.mPluginInfos.put(str, new TabSpecPluginInfo(str, str2, intent));
    }

    @Override // android.widget.TabHost
    public void addTab(TabHost.TabSpec tabSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tabSpec);
            return;
        }
        super.addTab(tabSpec);
        if (tabSpec != null) {
            this.mTabSpecs.add(new TabSpecWrapper(tabSpec.getTag(), tabSpec));
        }
    }

    @Override // android.widget.TabHost
    public void clearAllTabs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.clearAllTabs();
        this.mTabSpecs.clear();
        this.mPluginInfos.clear();
    }

    public TabSpecPluginInfo getPluginInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TabSpecPluginInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return this.mPluginInfos.get(str);
    }

    public TabHost.TabSpec getTabAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TabHost.TabSpec) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.mTabSpecs.size()) {
            return this.mTabSpecs.get(i3).mTabSpec;
        }
        return null;
    }

    public int getTabCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mTabSpecs.size();
    }

    @Override // android.widget.TabHost
    public void setup(LocalActivityManager localActivityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) localActivityManager);
        }
    }

    public PluginTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.mTabSpecs = new ArrayList();
            this.mPluginInfos = new HashMap();
        }
    }
}
