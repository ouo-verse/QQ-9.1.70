package com.heytap.databaseengine.apiv2.userinfo;

import com.heytap.databaseengine.apiv2.HResponse;
import com.heytap.databaseengine.apiv3.data.DataSet;
import com.heytap.databaseengine.model.proxy.UserInfoProxy;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IUserInfoApi {
    @Deprecated
    void query(HResponse<List<UserInfoProxy>> hResponse);

    void readInfo(HResponse<List<DataSet>> hResponse);
}
