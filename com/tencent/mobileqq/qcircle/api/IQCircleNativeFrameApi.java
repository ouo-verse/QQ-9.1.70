package com.tencent.mobileqq.qcircle.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleNativeFrameApi extends QRouteApi {
    Fragment createFolderFragment();

    void enterNativePage(Bundle bundle);

    Intent getNativeFolderIntent(String str, HashMap<String, String> hashMap, HashMap<String, byte[]> hashMap2);

    boolean isInQCircle();

    boolean isNewLayerMode();

    void launchMakeRedPacketPage(Activity activity, Bundle bundle, int i3);

    void launchPersonalDetailPage(Context context, long j3);

    void launchRedPacketPreviewPage(Activity activity, Bundle bundle);

    void preloadFolderView(Context context);

    void preloadTabInfo();

    void putArgusToHostActivity(Intent intent, String str, HashMap<String, String> hashMap, HashMap<String, byte[]> hashMap2);
}
