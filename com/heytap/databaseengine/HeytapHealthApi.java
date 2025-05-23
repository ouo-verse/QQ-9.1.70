package com.heytap.databaseengine;

import android.content.Context;
import com.heytap.databaseengine.apiv2.IHeytapHealthApi;
import com.heytap.databaseengine.apiv2.InitException;
import com.heytap.databaseengine.apiv2._HeytapHealth;
import com.heytap.databaseengine.apiv2.auth.AuthorityApiImpl;
import com.heytap.databaseengine.apiv2.auth.IAuthorityApi;
import com.heytap.databaseengine.apiv2.device.DeviceApiImpl;
import com.heytap.databaseengine.apiv2.device.IDeviceApi;
import com.heytap.databaseengine.apiv2.health.business.ISportHealthApi;
import com.heytap.databaseengine.apiv2.health.business.SportHealthApiImpl;
import com.heytap.databaseengine.apiv2.userinfo.IUserInfoApi;
import com.heytap.databaseengine.apiv2.userinfo.UserInfoApiImpl;
import com.heytap.databaseengine.apiv3.business.HealthDataApiImpl;
import com.heytap.databaseengine.apiv3.business.IHealthDataApi;
import com.heytap.databaseengine.utils.HLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class HeytapHealthApi implements IHeytapHealthApi {
    private static final String TAG = "HeytapHealthApi";
    private IAuthorityApi mAuthorityApi;
    private IDeviceApi mDeviceApi;
    private IHealthDataApi mHealthDataApi;
    private ISportHealthApi mSportHealthApi;
    private IUserInfoApi mUserInfoApi;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class HeytapHealthApiHolder {
        private static final HeytapHealthApi sInstance = new HeytapHealthApi();

        HeytapHealthApiHolder() {
        }
    }

    public static IHeytapHealthApi getInstance() {
        if (_HeytapHealth.hasInit()) {
            return HeytapHealthApiHolder.sInstance;
        }
        throw new InitException("Heytap Health not init(context)");
    }

    public static void init(Context context) {
        if (!_HeytapHealth.hasInit()) {
            HLog.i(TAG, "Heytap health init start");
            _HeytapHealth.init(context);
            HLog.i(TAG, "Heytap health init end");
        }
    }

    public static boolean isLoggable() {
        return HLog.isLoggable();
    }

    public static void setLoggable(boolean z16) {
        HLog.setIsLoggable(z16);
    }

    @Override // com.heytap.databaseengine.apiv2.IHeytapHealthApi
    public IAuthorityApi authorityApi() {
        if (this.mAuthorityApi == null) {
            this.mAuthorityApi = new AuthorityApiImpl();
        }
        return this.mAuthorityApi;
    }

    @Override // com.heytap.databaseengine.apiv2.IHeytapHealthApi
    public IHealthDataApi dataApi() {
        if (this.mHealthDataApi == null) {
            this.mHealthDataApi = new HealthDataApiImpl();
        }
        return this.mHealthDataApi;
    }

    @Override // com.heytap.databaseengine.apiv2.IHeytapHealthApi
    public IDeviceApi deviceApi() {
        if (this.mDeviceApi == null) {
            this.mDeviceApi = new DeviceApiImpl();
        }
        return this.mDeviceApi;
    }

    @Override // com.heytap.databaseengine.apiv2.IHeytapHealthApi
    public ISportHealthApi sportHealthApi() {
        if (this.mSportHealthApi == null) {
            this.mSportHealthApi = new SportHealthApiImpl();
        }
        return this.mSportHealthApi;
    }

    @Override // com.heytap.databaseengine.apiv2.IHeytapHealthApi
    public IUserInfoApi userInfoApi() {
        if (this.mUserInfoApi == null) {
            this.mUserInfoApi = new UserInfoApiImpl();
        }
        return this.mUserInfoApi;
    }

    HeytapHealthApi() {
    }
}
