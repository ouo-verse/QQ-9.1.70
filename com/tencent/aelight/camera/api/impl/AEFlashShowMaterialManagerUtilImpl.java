package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.control.b;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.api.IAEFlashShowMaterialManagerUtil;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aelight/camera/api/impl/AEFlashShowMaterialManagerUtilImpl;", "Lcom/tencent/aelight/camera/api/IAEFlashShowMaterialManagerUtil;", "", "forceRefresh", "", "initAsync", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "getRandomGuildPic", "<init>", "()V", "Companion", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEFlashShowMaterialManagerUtilImpl implements IAEFlashShowMaterialManagerUtil {
    private static final String TAG = "AEFlashShowMaterialManagerUtilImpl";

    @Override // com.tencent.aelight.camera.api.IAEFlashShowMaterialManagerUtil
    public AEMaterialMetaData getRandomGuildPic() {
        Object firstOrNull;
        List<AEMaterialMetaData> list;
        Object first;
        b b16 = com.tencent.aelight.camera.ae.control.a.b(3);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager");
        AEFlashShowMaterialManager aEFlashShowMaterialManager = (AEFlashShowMaterialManager) b16;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) aEFlashShowMaterialManager.z());
        AEMaterialCategory aEMaterialCategory = (AEMaterialCategory) firstOrNull;
        if (aEMaterialCategory == null || (list = aEMaterialCategory.f69044d) == null) {
            return null;
        }
        int size = list.size();
        int nextInt = Random.INSTANCE.nextInt(size);
        QLog.d(TAG, 1, "getRandomGuildPic... size:" + size + " random:" + nextInt);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) aEFlashShowMaterialManager.z());
        return ((AEMaterialCategory) first).f69044d.get(nextInt);
    }

    @Override // com.tencent.aelight.camera.api.IAEFlashShowMaterialManagerUtil
    public void initAsync(boolean forceRefresh) {
        b b16 = com.tencent.aelight.camera.ae.control.a.b(3);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager");
        ((AEFlashShowMaterialManager) b16).F(forceRefresh);
    }
}
