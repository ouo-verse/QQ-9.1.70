package org.light.lightAssetKit.components;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Component extends ComponentBase {
    private boolean enabled = true;
    private boolean needReload = true;
    private boolean paused = false;
    private int componentID = 0;
    private int entityId = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Component) {
            Component component = (Component) componentBase;
            this.enabled = component.enabled;
            this.needReload = component.needReload;
            this.paused = component.paused;
            this.componentID = component.componentID;
            this.entityId = component.entityId;
        }
        super.doUpdate(componentBase);
    }

    public int getComponentID() {
        return this.componentID;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public boolean getNeedReload() {
        return this.needReload;
    }

    public boolean getPaused() {
        return this.paused;
    }

    public void setComponentID(int i3) {
        this.componentID = i3;
        reportPropertyChange(TemplateParser.KEY_COMPONENT_ID, Integer.valueOf(i3));
    }

    public void setEnabled(boolean z16) {
        this.enabled = z16;
        reportPropertyChange(NodeProps.ENABLED, Boolean.valueOf(z16));
    }

    public void setEntityId(int i3) {
        this.entityId = i3;
        reportPropertyChange(TemplateParser.KEY_ENTITY_ID, Integer.valueOf(i3));
    }

    public void setNeedReload(boolean z16) {
        this.needReload = z16;
        reportPropertyChange("needReload", Boolean.valueOf(z16));
    }

    public void setPaused(boolean z16) {
        this.paused = z16;
        reportPropertyChange("paused", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Component";
    }
}
