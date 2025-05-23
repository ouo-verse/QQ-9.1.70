package com.qzone.reborn.layer.part;

import cooperation.qzone.model.PhotoInfo;

/* compiled from: P */
/* loaded from: classes37.dex */
public class at extends g {
    @Override // com.qzone.reborn.layer.part.g
    protected String Q9(String str) {
        if (getViewModel(uk.d.class) == null || ((uk.d) getViewModel(uk.d.class)).W1() == null) {
            return str;
        }
        return str + "&groupid=" + ((uk.d) getViewModel(uk.d.class)).W1().qunid;
    }

    @Override // com.qzone.reborn.layer.part.g
    protected String V9() {
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null) {
            return "";
        }
        return String.valueOf(photoInfo.uploaduin);
    }

    @Override // com.qzone.reborn.layer.part.g
    protected boolean W9() {
        return false;
    }
}
