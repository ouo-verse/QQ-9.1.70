package com.tencent.mobileqq.newnearby.hippy.impl;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newnearby.hippy.INearbyHippyBridge;
import com.tencent.mobileqq.newnearby.impl.NearbyAlbumHelperImpl;
import com.tencent.mtt.hippy.modules.Promise;
import pb2.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyHippyBridgeImpl implements INearbyHippyBridge {
    private static final String TAG = "NearbyHippyBridgeImpl";

    @Override // com.tencent.mobileqq.newnearby.hippy.INearbyHippyBridge
    public void openAppSetting() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", qBaseActivity.getPackageName(), null));
        qBaseActivity.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.newnearby.hippy.INearbyHippyBridge
    public void openMqqUrl(String str) {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        qBaseActivity.startActivity(new Intent(qBaseActivity, (Class<?>) JumpActivity.class).setData(Uri.parse(str)));
    }

    @Override // com.tencent.mobileqq.newnearby.hippy.INearbyHippyBridge
    public void requestLBS(Promise promise) {
        b.f(QBaseActivity.sTopActivity, promise);
    }

    @Override // com.tencent.mobileqq.newnearby.hippy.INearbyHippyBridge
    public void selectAndUploadPicture(int i3, Promise promise) {
        NearbyAlbumHelperImpl.b(i3, QBaseActivity.sTopActivity, promise);
    }

    @Override // com.tencent.mobileqq.newnearby.hippy.INearbyHippyBridge
    public void uploadProfilePicture(Promise promise) {
        NearbyAlbumHelperImpl.f(promise);
    }
}
