package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AlembicMeshDataComponent extends Component {
    private String URI = "";
    private int UUID = 0;
    private boolean topologyConst = false;
    private int totalFrameCount = 0;
    private boolean enableStreamLoad = true;
    private ArrayList<AtrributeBufferView> attributeBufferView = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof AlembicMeshDataComponent) {
            AlembicMeshDataComponent alembicMeshDataComponent = (AlembicMeshDataComponent) componentBase;
            this.URI = alembicMeshDataComponent.URI;
            this.UUID = alembicMeshDataComponent.UUID;
            this.topologyConst = alembicMeshDataComponent.topologyConst;
            this.totalFrameCount = alembicMeshDataComponent.totalFrameCount;
            this.enableStreamLoad = alembicMeshDataComponent.enableStreamLoad;
            this.attributeBufferView = alembicMeshDataComponent.attributeBufferView;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<AtrributeBufferView> getAttributeBufferView() {
        return this.attributeBufferView;
    }

    public boolean getEnableStreamLoad() {
        return this.enableStreamLoad;
    }

    public boolean getTopologyConst() {
        return this.topologyConst;
    }

    public int getTotalFrameCount() {
        return this.totalFrameCount;
    }

    public String getURI() {
        return this.URI;
    }

    public int getUUID() {
        return this.UUID;
    }

    public void setAttributeBufferView(ArrayList<AtrributeBufferView> arrayList) {
        this.attributeBufferView = arrayList;
        reportPropertyChange("attributeBufferView", arrayList);
    }

    public void setEnableStreamLoad(boolean z16) {
        this.enableStreamLoad = z16;
        reportPropertyChange("enableStreamLoad", Boolean.valueOf(z16));
    }

    public void setTopologyConst(boolean z16) {
        this.topologyConst = z16;
        reportPropertyChange("topologyConst", Boolean.valueOf(z16));
    }

    public void setTotalFrameCount(int i3) {
        this.totalFrameCount = i3;
        reportPropertyChange("totalFrameCount", Integer.valueOf(i3));
    }

    public void setURI(String str) {
        this.URI = str;
        reportPropertyChange("URI", str);
    }

    public void setUUID(int i3) {
        this.UUID = i3;
        reportPropertyChange("UUID", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "AlembicMeshDataComponent";
    }
}
