package com.tencent.mobileqq.qqvideoedit.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQVideoEditLaucher extends QRouteApi {
    void jumpToPreviewFragment(Context context, Intent intent, String str, int i3, String str2);

    void jumpToVideoCamera(Context context, Intent intent, String str);

    void jumpToVideoCoverEditor(Context context, Intent intent, String str, int i3, String str2);

    void jumpToVideoEditor(Context context, Intent intent, String str);

    void jumpToVideoPublish(Context context, Intent intent, String str);

    void preloadVideoEdit(Context context);
}
