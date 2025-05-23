package com.tencent.mobileqq.qqvideoedit.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IVideoExportApi extends QRouteApi {
    void fillPreviewAndSendVideoParams(Bundle bundle);

    void previewVideo(Activity activity, Intent intent);

    void sendVideo(Activity activity, Intent intent, ArrayList<String> arrayList, int i3, boolean z16);
}
