package com.tencent.mobileqq.profilecard.collector;

import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileComponentConst;
import com.tencent.mobileqq.profilecard.component.ProfileFavorComponent;
import com.tencent.mobileqq.profilecard.component.ProfileInStepComponent;
import com.tencent.mobileqq.profilecard.component.ProfileIntimateComponent;
import com.tencent.mobileqq.profilecard.component.ProfileMetaFarmComponent;
import com.tencent.mobileqq.profilecard.component.ProfileMusicDataComponent;
import com.tencent.mobileqq.profilecard.component.content.ProfileAddProfileComponent;
import com.tencent.mobileqq.profilecard.component.content.photowall.ProfilePhotoWallComponent;
import com.tencent.mobileqq.profilecard.component.head.OldProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.component.pymk.ProfileRecReasonComponentOld;

/* compiled from: P */
/* loaded from: classes35.dex */
public class FeatureComponentCollector implements IProfileComponentCollector, IProfileComponentConst {
    @Override // com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector
    public SparseArray<Class<? extends AbsProfileComponent>> collect() {
        SparseArray<Class<? extends AbsProfileComponent>> sparseArray = new SparseArray<>();
        sparseArray.put(1002, OldProfileHeaderComponent.class);
        sparseArray.put(1009, ProfilePhotoWallComponent.class);
        sparseArray.put(1006, ProfileFavorComponent.class);
        sparseArray.put(1038, ProfileAddProfileComponent.class);
        sparseArray.put(1041, ProfileInStepComponent.class);
        sparseArray.put(1042, ProfileIntimateComponent.class);
        sparseArray.put(1048, ProfileMusicDataComponent.class);
        sparseArray.put(1050, ProfileMetaFarmComponent.class);
        sparseArray.put(1051, ProfileRecReasonComponentOld.class);
        return sparseArray;
    }
}
