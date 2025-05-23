package com.tencent.mobileqq.profilecard.collector;

import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;

/* loaded from: classes16.dex */
public interface IProfileComponentCollector {
    SparseArray<Class<? extends AbsProfileComponent>> collect();
}
