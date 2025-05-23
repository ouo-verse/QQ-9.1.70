package com.tencent.mobileqq.pluginsdk;

import androidx.fragment.app.Fragment;

/* loaded from: classes16.dex */
public interface IPluginFragmentActivity extends IPluginActivity {
    void IOnAttachFragment(Fragment fragment);

    void ISetParent(BasePluginFragmentActivity basePluginFragmentActivity);
}
