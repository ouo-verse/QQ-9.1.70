package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightAssetFragment extends Component {
    private long defaultDuration = 3000000;
    private int pagOrientation = 0;
    private int mainEditableEntityId = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof LightAssetFragment) {
            LightAssetFragment lightAssetFragment = (LightAssetFragment) componentBase;
            this.defaultDuration = lightAssetFragment.defaultDuration;
            this.pagOrientation = lightAssetFragment.pagOrientation;
            this.mainEditableEntityId = lightAssetFragment.mainEditableEntityId;
        }
        super.doUpdate(componentBase);
    }

    public long getDefaultDuration() {
        return this.defaultDuration;
    }

    public int getMainEditableEntityId() {
        return this.mainEditableEntityId;
    }

    public int getPagOrientation() {
        return this.pagOrientation;
    }

    public void setDefaultDuration(long j3) {
        this.defaultDuration = j3;
        reportPropertyChange("defaultDuration", Long.valueOf(j3));
    }

    public void setMainEditableEntityId(int i3) {
        this.mainEditableEntityId = i3;
        reportPropertyChange("mainEditableEntityId", Integer.valueOf(i3));
    }

    public void setPagOrientation(int i3) {
        this.pagOrientation = i3;
        reportPropertyChange("pagOrientation", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "LightAssetFragment";
    }
}
