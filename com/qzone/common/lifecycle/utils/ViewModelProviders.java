package com.qzone.common.lifecycle.utils;

import a6.a;
import androidx.lifecycle.ViewModelProvider;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.activities.base.BaseFragment;
import com.tencent.common.app.BaseApplicationImpl;

/* loaded from: classes39.dex */
public class ViewModelProviders {
    public static ViewModelProvider of(BaseActivity baseActivity) {
        return new ViewModelProvider(a.a(baseActivity), ViewModelProvider.AndroidViewModelFactory.getInstance(BaseApplicationImpl.getApplication()));
    }

    public static ViewModelProvider of(BaseFragment baseFragment) {
        return new ViewModelProvider(a.b(baseFragment), ViewModelProvider.AndroidViewModelFactory.getInstance(BaseApplicationImpl.getApplication()));
    }
}
