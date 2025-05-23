package com.tencent.mobileqq.matchfriend.share;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.net.URLDecoder;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
class MatchFriendShareHelper$6 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f245588d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Context f245589e;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(URLDecoder.decode(this.f245588d));
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("images", arrayList);
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, 1);
        bundle.putBoolean("key_need_save_draft", false);
        AppInterface appInterface = HippyUtils.getAppInterface();
        if (appInterface != null) {
            QZoneShareManager.publishToQzone(appInterface, this.f245589e, bundle, null, -1);
        } else {
            QLog.e("MatchFriendShareHelper", 1, "sharePictureToQZone AppRuntime is not AppInterface");
        }
    }
}
