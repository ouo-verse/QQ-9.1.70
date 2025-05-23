package com.heytap.databaseengine.apiv2.auth;

import android.app.Activity;
import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.utils.HExecutorService;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AuthorityApiImpl implements IAuthorityApi {
    @Override // com.heytap.databaseengine.apiv2.auth.IAuthorityApi
    public void request(Activity activity, HResponse<AuthResult> hResponse) {
        new AuthRequestQuery(activity, null, hResponse).realRun();
    }

    @Override // com.heytap.databaseengine.apiv2.auth.IAuthorityApi
    public void revoke(HResponse<List<Object>> hResponse) {
        HExecutorService.create().execute(new AuthRevokeQuery(hResponse));
    }

    @Override // com.heytap.databaseengine.apiv2.auth.IAuthorityApi
    public void valid(HResponse<List<String>> hResponse) {
        HExecutorService.create().execute(new AuthValidQuery(hResponse));
    }

    @Override // com.heytap.databaseengine.apiv2.auth.IAuthorityApi
    public void request(Activity activity, String str, HResponse<AuthResult> hResponse) {
        new AuthRequestQuery(activity, str, hResponse).realRun();
    }
}
