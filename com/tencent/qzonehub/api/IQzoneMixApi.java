package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import mqq.app.QQPermissionCallback;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneMixApi extends QRouteApi {
    public static final int CLOSE_SHARPP = 0;
    public static final String KEY_CTRL_CMD = "key_ctrl_cmd";
    public static final String KEY_DESC = "key_desc";
    public static final int NOT_SUPPORT_SHARPP = 0;
    public static final int OPEN_SHARPP = 1;
    public static final int SUPPORT_SHARPP = 1;

    void broadcastBannerGameRedDot(Context context, Bundle bundle);

    void broadcastFollowIfNeed(Context context, String str, int i3);

    void execCtrlCommand(String str, int i3, Map<String, String> map);

    int getVersion();

    int isSupportSharpP(Context context);

    boolean requestStoragePermission(Activity activity, QQPermissionCallback qQPermissionCallback, int i3);
}
