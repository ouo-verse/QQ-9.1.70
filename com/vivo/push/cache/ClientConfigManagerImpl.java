package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.u;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ClientConfigManagerImpl implements d {
    private static final String TAG = "ClientConfigManager";
    private static volatile ClientConfigManagerImpl sClientConfigManagerImpl;
    private a mAppConfigSettings;
    private Context mContext;
    private e mPushConfigSettings;

    ClientConfigManagerImpl(Context context) {
        this.mContext = ContextDelegate.getContext(context);
        this.mAppConfigSettings = new a(this.mContext);
        this.mPushConfigSettings = new e(this.mContext);
    }

    public static synchronized ClientConfigManagerImpl getInstance(Context context) {
        ClientConfigManagerImpl clientConfigManagerImpl;
        synchronized (ClientConfigManagerImpl.class) {
            if (sClientConfigManagerImpl == null) {
                sClientConfigManagerImpl = new ClientConfigManagerImpl(context);
            }
            clientConfigManagerImpl = sClientConfigManagerImpl;
        }
        return clientConfigManagerImpl;
    }

    private void prepareAppConfig() {
        a aVar = this.mAppConfigSettings;
        if (aVar == null) {
            this.mAppConfigSettings = new a(this.mContext);
        } else {
            aVar.c();
        }
    }

    private e preparePushConfigSettings() {
        e eVar = this.mPushConfigSettings;
        if (eVar == null) {
            this.mPushConfigSettings = new e(this.mContext);
        } else {
            eVar.c();
        }
        return this.mPushConfigSettings;
    }

    public void clearPush() {
        this.mAppConfigSettings.d();
    }

    public Set<String> getBlackEventList() {
        return null;
    }

    public String getSuitTag() {
        return preparePushConfigSettings().c("CSPT");
    }

    public String getValueByKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.mPushConfigSettings.c();
        return this.mPushConfigSettings.c(str);
    }

    public Set<Long> getWhiteLogList() {
        HashSet hashSet = new HashSet();
        String valueByKey = getValueByKey("WLL");
        if (!TextUtils.isEmpty(valueByKey)) {
            for (String str : valueByKey.split(",")) {
                try {
                    hashSet.add(Long.valueOf(Long.parseLong(str)));
                } catch (Exception unused) {
                }
            }
        }
        u.d(TAG, " initWhiteLogList ".concat(String.valueOf(hashSet)));
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0020 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isCancleBroadcastReceiver() {
        int parseInt;
        String c16 = preparePushConfigSettings().c("PSM");
        if (!TextUtils.isEmpty(c16)) {
            try {
                parseInt = Integer.parseInt(c16);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
            if ((parseInt & 4) != 0) {
                return false;
            }
            return true;
        }
        parseInt = 0;
        if ((parseInt & 4) != 0) {
        }
    }

    public boolean isDebug() {
        this.mAppConfigSettings.c();
        return a.a(this.mAppConfigSettings.b());
    }

    public boolean isEnablePush() {
        prepareAppConfig();
        com.vivo.push.model.a c16 = this.mAppConfigSettings.c(this.mContext.getPackageName());
        if (c16 != null) {
            return "1".equals(c16.b());
        }
        return true;
    }

    @Override // com.vivo.push.cache.d
    public boolean isInBlackList(long j3) {
        String c16 = preparePushConfigSettings().c("BL");
        if (!TextUtils.isEmpty(c16)) {
            for (String str : c16.split(",")) {
                try {
                    if (!TextUtils.isEmpty(str) && Long.parseLong(str) == j3) {
                        return true;
                    }
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean isDebug(int i3) {
        return a.a(i3);
    }
}
