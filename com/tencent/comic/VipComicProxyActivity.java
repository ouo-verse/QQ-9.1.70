package com.tencent.comic;

import android.os.Bundle;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes32.dex */
public class VipComicProxyActivity extends PluginProxyFragmentActivity {
    public static Class<? extends PluginProxyActivity> getProxyActivityClass(String str) {
        return VipComicProxyActivity.class;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public String getPluginID() {
        return IQQComicPluginUtil.COMIC_PLUGIN_ID;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity
    protected int getPluginResType() {
        return 2;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    protected Class<? extends PluginProxyActivity> getProxyActivity(String str) {
        return getProxyActivityClass(str);
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity
    protected int getThemeResId() {
        return 0;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            getWindow().addFlags(67108864);
        }
        super.onCreate(bundle);
    }
}
