package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FilterGroup extends Component {

    /* renamed from: id, reason: collision with root package name */
    private int f423812id = 0;
    private String name = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof FilterGroup) {
            FilterGroup filterGroup = (FilterGroup) componentBase;
            this.f423812id = filterGroup.f423812id;
            this.name = filterGroup.name;
        }
        super.doUpdate(componentBase);
    }

    public int getId() {
        return this.f423812id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int i3) {
        this.f423812id = i3;
        reportPropertyChange("id", Integer.valueOf(i3));
    }

    public void setName(String str) {
        this.name = str;
        reportPropertyChange("name", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "FilterGroup";
    }
}
