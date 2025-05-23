package com.qzone.proxy.feedcomponent.model.canvasAd;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.List;

/* loaded from: classes39.dex */
public class CanvasPage implements SmartParcelable {

    @NeedParcel
    public String backgroundColor;

    @NeedParcel
    public List<CanvasComponent> componentItemList;

    @NeedParcel
    public String pageId;
}
