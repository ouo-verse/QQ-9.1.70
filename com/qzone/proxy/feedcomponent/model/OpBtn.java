package com.qzone.proxy.feedcomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class OpBtn implements SmartParcelable {

    @NeedParcel
    public int actiontype;

    @NeedParcel
    public int color;

    @NeedParcel
    public String title;

    @NeedParcel
    public String url;
}
