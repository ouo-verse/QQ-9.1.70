package cooperation.groupvideo.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.groupvideo.a;
import cooperation.groupvideo.api.IGroupVideoHelper;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class GroupVideoHelperImpl implements IGroupVideoHelper {
    @Override // cooperation.groupvideo.api.IGroupVideoHelper
    public void bindService(AppRuntime appRuntime, Class cls, ServiceConnection serviceConnection, String str) {
        a.a(appRuntime, cls, serviceConnection, str);
    }

    @Override // cooperation.groupvideo.api.IGroupVideoHelper
    public AppRuntime createAppInterface(Object obj, String str) {
        return a.b((BaseApplicationImpl) obj, str);
    }

    @Override // cooperation.groupvideo.api.IGroupVideoHelper
    public boolean enterTroopVideo(AppInterface appInterface, Activity activity, Intent intent, int i3) {
        return a.c(appInterface, activity, intent, i3);
    }

    @Override // cooperation.groupvideo.api.IGroupVideoHelper
    public boolean enterTroopVideoByPlugin(AppInterface appInterface, Context context, Intent intent, int i3) {
        return a.d((QQAppInterface) appInterface, context, intent, i3);
    }

    @Override // cooperation.groupvideo.api.IGroupVideoHelper
    public boolean isGvideoExist(Context context) {
        return a.e(context);
    }

    @Override // cooperation.groupvideo.api.IGroupVideoHelper
    public void unbindService(AppRuntime appRuntime, ServiceConnection serviceConnection) {
        a.f(appRuntime, serviceConnection);
    }
}
