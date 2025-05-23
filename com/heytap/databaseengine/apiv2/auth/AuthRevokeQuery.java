package com.heytap.databaseengine.apiv2.auth;

import android.content.pm.PackageManager;
import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv2.IAuthorityManager;
import com.heytap.databaseengine.apiv2.common.HRemoteService;
import com.heytap.databaseengine.apiv2.common.HRunnable;
import com.heytap.databaseengine.callback.ICommonListener;
import com.heytap.databaseengine.utils.HLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AuthRevokeQuery extends HRunnable {
    private static final String TAG = "AuthRevokeQuery";
    private HResponse<List<Object>> mCallback;

    public AuthRevokeQuery(HResponse<List<Object>> hResponse) {
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
        ((IAuthorityManager) HRemoteService.getInstance().remoteApi(IAuthorityManager.class)).revoke(new ICommonListener.Stub() { // from class: com.heytap.databaseengine.apiv2.auth.AuthRevokeQuery.1
            @Override // com.heytap.databaseengine.callback.ICommonListener
            public void onFailure(int i3, List list) {
                HLog.i(AuthRevokeQuery.TAG, "revoke failed.");
                AuthRevokeQuery.this.mCallback.onFailure(i3);
            }

            @Override // com.heytap.databaseengine.callback.ICommonListener
            public void onSuccess(int i3, List list) {
                HLog.i(AuthRevokeQuery.TAG, "revoke succeed.");
                AuthRevokeQuery.this.mCallback.onSuccess(list);
            }
        });
        HLog.i(TAG, "revoke authority finish.");
    }
}
