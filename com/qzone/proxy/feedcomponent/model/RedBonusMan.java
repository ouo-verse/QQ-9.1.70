package com.qzone.proxy.feedcomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RedBonusMan implements SmartParcelable {

    @NeedParcel
    public long payMoney;

    @NeedParcel
    public long payTime;

    @NeedParcel
    public User user;
}
