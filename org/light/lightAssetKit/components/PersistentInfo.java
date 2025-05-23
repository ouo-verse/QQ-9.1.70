package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* loaded from: classes29.dex */
public class PersistentInfo extends Component {
    private int render_size_width_ = 0;
    private int render_size_height_ = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof PersistentInfo) {
            PersistentInfo persistentInfo = (PersistentInfo) componentBase;
            this.render_size_width_ = persistentInfo.render_size_width_;
            this.render_size_height_ = persistentInfo.render_size_height_;
        }
        super.doUpdate(componentBase);
    }

    public int getRender_size_height_() {
        return this.render_size_height_;
    }

    public int getRender_size_width_() {
        return this.render_size_width_;
    }

    public void setRender_size_height_(int i3) {
        this.render_size_height_ = i3;
        reportPropertyChange("render_size_height_", Integer.valueOf(i3));
    }

    public void setRender_size_width_(int i3) {
        this.render_size_width_ = i3;
        reportPropertyChange("render_size_width_", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "PersistentInfo";
    }
}
