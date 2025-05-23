package cooperation.groupvideo.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IGroupVideoService extends QRouteApi {
    Dialog installPlugin(Activity activity);

    void openPluginActivity(Activity activity, Intent intent, Dialog dialog, String str, String str2, int i3);
}
