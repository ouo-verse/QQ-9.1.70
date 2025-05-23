package com.qzone.feed.business.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BusinessMyRelationData implements SmartParcelable {
    public static final String STORE_KEY = "MyRelationData";

    @NeedParcel
    public String actiondesc = "";

    @NeedParcel
    public String nickname = "";

    @NeedParcel
    public long uUin = 0;
}
