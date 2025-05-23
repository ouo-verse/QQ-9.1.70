package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ExternalRender extends Component {
    private String key = "";
    private String data = "";
    private boolean is_external_render_input_flip = false;
    private boolean is_external_render_output_flip = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof ExternalRender) {
            ExternalRender externalRender = (ExternalRender) componentBase;
            this.key = externalRender.key;
            this.data = externalRender.data;
            this.is_external_render_input_flip = externalRender.is_external_render_input_flip;
            this.is_external_render_output_flip = externalRender.is_external_render_output_flip;
        }
        super.doUpdate(componentBase);
    }

    public String getData() {
        return this.data;
    }

    public boolean getIs_external_render_input_flip() {
        return this.is_external_render_input_flip;
    }

    public boolean getIs_external_render_output_flip() {
        return this.is_external_render_output_flip;
    }

    public String getKey() {
        return this.key;
    }

    public void setData(String str) {
        this.data = str;
        reportPropertyChange("data", str);
    }

    public void setIs_external_render_input_flip(boolean z16) {
        this.is_external_render_input_flip = z16;
        reportPropertyChange("is_external_render_input_flip", Boolean.valueOf(z16));
    }

    public void setIs_external_render_output_flip(boolean z16) {
        this.is_external_render_output_flip = z16;
        reportPropertyChange("is_external_render_output_flip", Boolean.valueOf(z16));
    }

    public void setKey(String str) {
        this.key = str;
        reportPropertyChange("key", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "ExternalRender";
    }
}
