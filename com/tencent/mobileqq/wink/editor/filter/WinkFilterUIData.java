package com.tencent.mobileqq.wink.editor.filter;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkFilterUIData extends WinkEditUIData {
    private static final String FILTER_MATERIAL = "FILTER_MATERIAL";
    private static final String FILTER_RANGE_MODE = "FILTER_RANGE_MODE";
    private static final String TAG = "WinkFilterUIData";
    private static final long serialVersionUID = 599093938747237760L;

    public WinkFilterUIData(@NotNull com.tencent.mobileqq.wink.editor.d dVar) {
        super(dVar);
    }

    public int getFilterRangeMode() {
        return getInt(FILTER_RANGE_MODE, -1);
    }

    public MetaMaterial getMaterialFromDraft() {
        Serializable serializable = getSerializable(FILTER_MATERIAL, null);
        if (serializable instanceof MetaMaterial) {
            return (MetaMaterial) serializable;
        }
        ms.a.c(TAG, "material recovery from draft failed.");
        return null;
    }

    public void saveFilterRangeMode(int i3) {
        putInt(FILTER_RANGE_MODE, i3);
    }

    public void selectMaterial(MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            putSerializable(FILTER_MATERIAL, new MetaMaterial());
        } else {
            putSerializable(FILTER_MATERIAL, metaMaterial);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.draft.WinkEditUIData
    protected void updateInner() {
    }
}
