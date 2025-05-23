package com.tencent.mobileqq.profilecard.view.content.photowall;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.profilecard.preload.IProfileViewLoader;

/* loaded from: classes35.dex */
public class ElegantPhotoWallView extends PhotoWallView {
    public ElegantPhotoWallView(Context context, AppInterface appInterface, String str) {
        super(context, appInterface, str, true);
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView
    protected boolean enableEmptyView() {
        return false;
    }

    public ElegantPhotoWallView(Context context, AppInterface appInterface, String str, IProfileViewLoader iProfileViewLoader) {
        super(context, appInterface, str, iProfileViewLoader, true);
    }
}
