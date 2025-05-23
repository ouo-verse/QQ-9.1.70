package com.tencent.ams.mosaic.jsengine.component.container;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.Component;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import java.util.List;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface Container extends Component {
    boolean addChild(ComponentBase componentBase);

    List<ComponentBase> getChildren();

    void removeAllChildren();

    void removeChild(ComponentBase componentBase);

    void setDescendantFocusability(String str);
}
