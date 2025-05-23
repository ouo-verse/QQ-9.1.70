package cooperation.qzone.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import mqq.app.AppRuntime;

/* loaded from: classes38.dex */
public class QzonePublicAccountHelper {
    private static final String ACTION_FOLLOW = "action.qzone_public_account_follow";
    private static final String PERMISSION = "com.tencent.qzone.permission.notify";
    private static final String TAG = "QzonePublicAccountHelper";

    public static void broadcastFollowIfNeed(Context context, FollowUpdateEvent followUpdateEvent) {
        if (followUpdateEvent != null) {
            broadcastFollowIfNeed(context, followUpdateEvent.useId, followUpdateEvent.followStatus);
        }
    }

    public static void broadcastFollowIfNeed(Activity activity, FollowUpdateEvent followUpdateEvent) {
        ExtraTypeInfo extraTypeInfo;
        if (activity == null || activity.getIntent() == null || (extraTypeInfo = (ExtraTypeInfo) activity.getIntent().getSerializableExtra(ExtraTypeInfo.KEY_SUBSCRIBE_INTENT_EXTRA_TYPE_INFO)) == null || extraTypeInfo.sourceType != 9002 || followUpdateEvent == null) {
            return;
        }
        broadcastFollowIfNeed(activity, followUpdateEvent.useId, followUpdateEvent.followStatus);
    }

    public static boolean isQZonePluginReady(Context context, AppRuntime appRuntime) {
        QLog.i(TAG, 1, "QzonePublicAccountHelper: start to load qzone plugin ");
        return ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).needShowMsgFeedList((Activity) context, appRuntime);
    }

    public static void broadcastFollowIfNeed(Context context, String str, int i3) {
        if (context == null || str == null) {
            return;
        }
        Intent intent = new Intent(ACTION_FOLLOW);
        intent.putExtra(QCircleDaTongConstant.ElementParamValue.FOLLOWED, i3);
        intent.putExtra("uin", str);
        context.sendBroadcast(intent, PERMISSION);
    }
}
