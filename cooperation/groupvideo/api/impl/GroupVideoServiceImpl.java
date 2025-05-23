package cooperation.groupvideo.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import cooperation.groupvideo.GVideoProxyActivity;
import cooperation.groupvideo.api.IGroupVideoService;

/* compiled from: P */
/* loaded from: classes38.dex */
public class GroupVideoServiceImpl implements IGroupVideoService {
    @Override // cooperation.groupvideo.api.IGroupVideoService
    public Dialog installPlugin(Activity activity) {
        return GVideoProxyActivity.installPlugin(activity);
    }

    @Override // cooperation.groupvideo.api.IGroupVideoService
    public void openPluginActivity(Activity activity, Intent intent, Dialog dialog, String str, String str2, int i3) {
        GVideoProxyActivity.openPluginActivity(activity, intent, dialog, str, str2, i3);
    }
}
