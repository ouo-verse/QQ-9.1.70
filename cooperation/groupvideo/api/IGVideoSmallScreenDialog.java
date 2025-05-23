package cooperation.groupvideo.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IGVideoSmallScreenDialog extends QRouteApi {
    String getPluginID();

    void openPluginActivity(Activity activity, Intent intent, String str);
}
