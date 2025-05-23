package com.heytap.databaseengine.apiv2.userinfo;

import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv3.business.UserInfoRead;
import com.heytap.databaseengine.apiv3.data.DataSet;
import com.heytap.databaseengine.model.proxy.UserInfoProxy;
import com.heytap.databaseengine.utils.HExecutorService;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class UserInfoApiImpl implements IUserInfoApi {
    @Override // com.heytap.databaseengine.apiv2.userinfo.IUserInfoApi
    public void query(HResponse<List<UserInfoProxy>> hResponse) {
        HExecutorService.create().execute(new UserInfoQuery(hResponse));
    }

    @Override // com.heytap.databaseengine.apiv2.userinfo.IUserInfoApi
    public void readInfo(HResponse<List<DataSet>> hResponse) {
        HExecutorService.create().execute(new UserInfoRead(hResponse));
    }
}
