package com.qzone.common.activities.base;

import android.content.Intent;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;

/* compiled from: P */
@Named("BaseFeedFragmentAlbumImp")
/* loaded from: classes39.dex */
public class l implements d5.a {
    @Inject
    public l() {
    }

    @Override // d5.a
    public void a(Intent intent) {
        BusinessAlbumInfo businessAlbumInfo = (BusinessAlbumInfo) intent.getParcelableExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO);
        if (businessAlbumInfo != null) {
            n5.d.l().v(businessAlbumInfo);
        }
    }
}
