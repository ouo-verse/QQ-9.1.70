package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.data.EmoticonPackage;

/* loaded from: classes12.dex */
public interface EmoticonPackageChangedListener {
    void onPackageAdded(EmoticonPackage emoticonPackage);

    void onPackageDataListUpdate();

    void onPackageDeleted(EmoticonPackage emoticonPackage);

    void onPackageMoved(int i3, int i16);

    void onPackageSetBottom();
}
