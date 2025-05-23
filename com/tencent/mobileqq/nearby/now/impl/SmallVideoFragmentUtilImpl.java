package com.tencent.mobileqq.nearby.now.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.ISmallVideoFragmentUtil;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SmallVideoFragmentUtilImpl implements ISmallVideoFragmentUtil {
    @Override // com.tencent.mobileqq.nearby.now.ISmallVideoFragmentUtil
    public void launch(Context context, Bundle bundle) {
        SmallVideoFragment.vh(context, bundle);
    }

    @Override // com.tencent.mobileqq.nearby.now.ISmallVideoFragmentUtil
    public void launch(Context context, String str) {
        SmallVideoFragment.launch(context, str);
    }
}
