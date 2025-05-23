package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SuperResolution extends Component {
    private ArrayList<Integer> indexes = new ArrayList<>();
    private boolean highQuality = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof SuperResolution) {
            SuperResolution superResolution = (SuperResolution) componentBase;
            this.indexes = superResolution.indexes;
            this.highQuality = superResolution.highQuality;
        }
        super.doUpdate(componentBase);
    }

    public boolean getHighQuality() {
        return this.highQuality;
    }

    public ArrayList<Integer> getIndexes() {
        return this.indexes;
    }

    public void setHighQuality(boolean z16) {
        this.highQuality = z16;
        reportPropertyChange("highQuality", Boolean.valueOf(z16));
    }

    public void setIndexes(ArrayList<Integer> arrayList) {
        this.indexes = arrayList;
        reportPropertyChange("indexes", arrayList);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "SuperResolution";
    }
}
