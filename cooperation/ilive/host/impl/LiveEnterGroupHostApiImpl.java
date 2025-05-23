package cooperation.ilive.host.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.host.ILiveEnterGroupHostApi;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcooperation/ilive/host/impl/LiveEnterGroupHostApiImpl;", "Lcooperation/ilive/host/ILiveEnterGroupHostApi;", "()V", "joinGroup", "", "hasJoin", "", "groupId", "", "groupName", "Companion", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class LiveEnterGroupHostApiImpl implements ILiveEnterGroupHostApi {

    @NotNull
    private static final String TAG = "EnterGroupHostApiImpl";

    @Override // cooperation.ilive.host.ILiveEnterGroupHostApi
    public void joinGroup(boolean hasJoin, @Nullable String groupId, @Nullable String groupName) {
        try {
            if (hasJoin) {
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(MobileQQ.sMobileQQ, RouterConstants.UI_ROUTE_CHAT_ACTVITY);
                activityURIRequest.extra().putBoolean("open_chatfragment", true);
                activityURIRequest.extra().putString("uin", groupId);
                activityURIRequest.extra().putInt("uintype", 1);
                activityURIRequest.extra().putString("uinname", groupName);
                activityURIRequest.setFlags(268435456);
                QRoute.startUri(activityURIRequest, (o) null);
            } else {
                Bundle b16 = aq.b(groupId, 4);
                b16.putInt(AppConstants.Key.TROOP_INFO_FROM, 30);
                ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopInfoActivity(MobileQQ.sMobileQQ, b16, 2);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "joinGroup fail ", th5);
        }
    }
}
