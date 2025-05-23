package com.qzone.homepage.business.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class EntranceItem implements SmartParcelable {

    @NeedParcel
    public String avatarText;

    @NeedParcel
    public long avatarUin;

    @NeedParcel
    public String content;

    @NeedParcel
    public String iconUrl;

    @NeedParcel
    public String jumpUrl;

    @NeedParcel
    public int order;

    @NeedParcel
    public int redId;
}
