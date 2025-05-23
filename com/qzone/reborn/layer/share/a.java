package com.qzone.reborn.layer.share;

import android.app.Activity;
import cooperation.qzone.model.PhotoInfo;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a extends h {
    public a(Activity activity) {
        super(activity);
    }

    @Override // com.qzone.reborn.layer.share.h
    protected boolean G(f fVar) {
        PhotoInfo photoInfo;
        if (fVar == null || (photoInfo = fVar.f58179c) == null) {
            return false;
        }
        return com.qzone.preview.d.e(photoInfo);
    }
}
