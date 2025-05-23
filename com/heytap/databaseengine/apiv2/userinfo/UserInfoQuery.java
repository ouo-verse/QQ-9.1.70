package com.heytap.databaseengine.apiv2.userinfo;

import android.content.pm.PackageManager;
import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv2.IUserInfoManager;
import com.heytap.databaseengine.apiv2.common.HRemoteService;
import com.heytap.databaseengine.apiv2.common.HRunnable;
import com.heytap.databaseengine.callback.ICommonListener;
import com.heytap.databaseengine.model.proxy.UserInfoProxy;
import com.heytap.databaseengine.utils.HLog;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public class UserInfoQuery extends HRunnable {
    private static final String TAG = "UserInfoQuery";
    private final HResponse<List<UserInfoProxy>> mCallback;

    public UserInfoQuery(HResponse<List<UserInfoProxy>> hResponse) {
        this.mCallback = hResponse;
    }

    @Override // com.heytap.databaseengine.apiv2.common.HRunnable
    public void onException(Exception exc) {
        HLog.e(TAG, exc.getMessage());
        if (exc.getClass().equals(PackageManager.NameNotFoundException.class)) {
            this.mCallback.onFailure(100007);
        } else if (exc.getClass().equals(IllegalStateException.class)) {
            this.mCallback.onFailure(100008);
        } else {
            this.mCallback.onFailure(100003);
        }
    }

    @Override // com.heytap.databaseengine.apiv2.common.HRunnable
    public void realRun() throws Exception {
        ((IUserInfoManager) HRemoteService.getInstance().remoteApi(IUserInfoManager.class)).readUserInfo(new ICommonListener.Stub() { // from class: com.heytap.databaseengine.apiv2.userinfo.UserInfoQuery.1
            @Override // com.heytap.databaseengine.callback.ICommonListener
            public void onFailure(int i3, List list) {
                HLog.i(UserInfoQuery.TAG, "readUserInfo onFailure: endTime = " + System.currentTimeMillis());
                UserInfoQuery.this.mCallback.onFailure(i3);
            }

            @Override // com.heytap.databaseengine.callback.ICommonListener
            public void onSuccess(int i3, List list) {
                HLog.i(UserInfoQuery.TAG, "readUserInfo onSuccess: endTime = " + System.currentTimeMillis());
                UserInfoQuery.this.mCallback.onSuccess(list);
            }
        });
    }
}
