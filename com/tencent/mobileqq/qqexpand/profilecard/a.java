package com.tencent.mobileqq.qqexpand.profilecard;

import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileComponentConst;
import com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a implements IProfileComponentCollector, IProfileComponentConst {
    @Override // com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector
    public SparseArray<Class<? extends AbsProfileComponent>> collect() {
        SparseArray<Class<? extends AbsProfileComponent>> sparseArray = new SparseArray<>();
        sparseArray.put(1008, ProfileExtendFriendComponent.class);
        return sparseArray;
    }
}
