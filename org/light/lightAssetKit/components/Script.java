package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Script extends Component {
    private String scriptPath = "";
    private ArrayList<String> aiRequire = new ArrayList<>();
    private ArrayList<String> dataRequire = new ArrayList<>();
    private int entityIDOffset = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Script) {
            Script script = (Script) componentBase;
            this.scriptPath = script.scriptPath;
            this.aiRequire = script.aiRequire;
            this.dataRequire = script.dataRequire;
            this.entityIDOffset = script.entityIDOffset;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<String> getAiRequire() {
        return this.aiRequire;
    }

    public ArrayList<String> getDataRequire() {
        return this.dataRequire;
    }

    public int getEntityIDOffset() {
        return this.entityIDOffset;
    }

    public String getScriptPath() {
        return this.scriptPath;
    }

    public void setAiRequire(ArrayList<String> arrayList) {
        this.aiRequire = arrayList;
        reportPropertyChange("aiRequire", arrayList);
    }

    public void setDataRequire(ArrayList<String> arrayList) {
        this.dataRequire = arrayList;
        reportPropertyChange("dataRequire", arrayList);
    }

    public void setEntityIDOffset(int i3) {
        this.entityIDOffset = i3;
        reportPropertyChange("entityIDOffset", Integer.valueOf(i3));
    }

    public void setScriptPath(String str) {
        this.scriptPath = str;
        reportPropertyChange("scriptPath", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Script";
    }
}
