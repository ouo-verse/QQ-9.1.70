package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LiquefactionV6 extends Component {
    private ArrayList<LiquefactionParam> liquefactionParams = new ArrayList<>();
    private boolean editMode = false;
    private float enlargeeyeFactor = 1.0f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof LiquefactionV6) {
            LiquefactionV6 liquefactionV6 = (LiquefactionV6) componentBase;
            this.liquefactionParams = liquefactionV6.liquefactionParams;
            this.editMode = liquefactionV6.editMode;
            this.enlargeeyeFactor = liquefactionV6.enlargeeyeFactor;
        }
        super.doUpdate(componentBase);
    }

    public boolean getEditMode() {
        return this.editMode;
    }

    public float getEnlargeeyeFactor() {
        return this.enlargeeyeFactor;
    }

    public ArrayList<LiquefactionParam> getLiquefactionParams() {
        return this.liquefactionParams;
    }

    public void setEditMode(boolean z16) {
        this.editMode = z16;
        reportPropertyChange("editMode", Boolean.valueOf(z16));
    }

    public void setEnlargeeyeFactor(float f16) {
        this.enlargeeyeFactor = f16;
        reportPropertyChange("enlargeeyeFactor", Float.valueOf(f16));
    }

    public void setLiquefactionParams(ArrayList<LiquefactionParam> arrayList) {
        this.liquefactionParams = arrayList;
        reportPropertyChange("liquefactionParams", arrayList);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "LiquefactionV6";
    }
}
