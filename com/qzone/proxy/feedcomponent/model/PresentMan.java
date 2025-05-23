package com.qzone.proxy.feedcomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* loaded from: classes39.dex */
public class PresentMan implements SmartParcelable {

    @NeedParcel
    public User user;

    public PresentMan(User user) {
        this.user = user;
    }

    public PresentMan() {
    }
}
