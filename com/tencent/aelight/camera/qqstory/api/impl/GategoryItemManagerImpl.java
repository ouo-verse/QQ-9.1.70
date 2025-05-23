package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.qqstory.api.IGategoryItemManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GategoryItemManagerImpl implements IGategoryItemManager {
    @Override // com.tencent.aelight.camera.qqstory.api.IGategoryItemManager
    public String getItemName(Object obj) {
        if (obj == null || !(obj instanceof QIMFilterCategoryItem)) {
            return null;
        }
        return ((QIMFilterCategoryItem) obj).f66698e;
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IGategoryItemManager
    public String getJumApp(Object obj) {
        if (obj == null || !(obj instanceof QIMFilterCategoryItem)) {
            return null;
        }
        return ((QIMFilterCategoryItem) obj).M;
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IGategoryItemManager
    public boolean isCombo(Object obj) {
        if (obj == null || !(obj instanceof QIMFilterCategoryItem)) {
            return false;
        }
        return ((QIMFilterCategoryItem) obj).L;
    }
}
