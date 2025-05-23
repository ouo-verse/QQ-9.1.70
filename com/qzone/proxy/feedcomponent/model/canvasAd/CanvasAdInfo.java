package com.qzone.proxy.feedcomponent.model.canvasAd;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasAdInfo implements SmartParcelable {

    @NeedParcel
    public int basicRootFontSize;

    @NeedParcel
    public int basicWidth;

    @NeedParcel
    public String canvasId;

    @NeedParcel
    public String canvasName;

    @NeedParcel
    public List<CanvasPage> pageList;
}
