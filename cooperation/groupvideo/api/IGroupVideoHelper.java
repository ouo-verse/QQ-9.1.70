package cooperation.groupvideo.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface IGroupVideoHelper extends QRouteApi {
    public static final String API_ENTER_GROUP_VIDEO = "mqqapi://gvideo/open_plugin?src_type=app";
    public static final String CLASS_ACTIVITY = "com.gvideo.com.tencent.av.ui.GroupVideoActivity";
    public static final int REQUEST_OPEN_GROUP_VIDEO = 1;

    void bindService(AppRuntime appRuntime, Class cls, ServiceConnection serviceConnection, String str);

    AppRuntime createAppInterface(Object obj, String str);

    boolean enterTroopVideo(AppInterface appInterface, Activity activity, Intent intent, int i3);

    boolean enterTroopVideoByPlugin(AppInterface appInterface, Context context, Intent intent, int i3);

    boolean isGvideoExist(Context context);

    void unbindService(AppRuntime appRuntime, ServiceConnection serviceConnection);
}
