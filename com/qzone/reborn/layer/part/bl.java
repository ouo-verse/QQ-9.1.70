package com.qzone.reborn.layer.part;

import cooperation.qzone.model.PhotoInfo;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bl extends v {
    @Override // com.qzone.reborn.layer.part.v
    protected int M9() {
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null) {
            return 0;
        }
        return photoInfo.commentCount;
    }

    @Override // com.qzone.reborn.layer.part.v
    protected void R9() {
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null) {
            return;
        }
        photoInfo.commentCount++;
    }
}
