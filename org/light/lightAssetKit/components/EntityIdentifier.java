package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class EntityIdentifier extends Component {

    /* renamed from: id, reason: collision with root package name */
    private int f423811id;
    private String name;
    private int originID;

    public EntityIdentifier() {
        this.f423811id = 0;
        this.originID = 0;
        this.name = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof EntityIdentifier) {
            EntityIdentifier entityIdentifier = (EntityIdentifier) componentBase;
            this.f423811id = entityIdentifier.f423811id;
            this.originID = entityIdentifier.originID;
            this.name = entityIdentifier.name;
        }
        super.doUpdate(componentBase);
    }

    public int getId() {
        return this.f423811id;
    }

    public String getName() {
        return this.name;
    }

    public int getOriginID() {
        return this.originID;
    }

    public void setId(int i3) {
        this.f423811id = i3;
        reportPropertyChange("id", Integer.valueOf(i3));
    }

    public void setName(String str) {
        this.name = str;
        reportPropertyChange("name", str);
    }

    public void setOriginID(int i3) {
        this.originID = i3;
        reportPropertyChange("originID", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "EntityIdentifier";
    }

    public EntityIdentifier(String str, int i3, int i16) {
        this.name = str;
        this.f423811id = i3;
        this.originID = i16;
    }
}
