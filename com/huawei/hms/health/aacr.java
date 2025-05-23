package com.huawei.hms.health;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.hihealth.HiHealthKitClient;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.activity.HealthKitMainActivity;
import com.huawei.hms.hihealth.data.DataType;
import com.huawei.hms.hihealth.options.DataTypeAddOptions;
import com.huawei.hms.hihealth.result.HealthKitAuthResult;
import com.huawei.hms.support.api.client.Status;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aacr implements com.huawei.hms.hihealth.aabq {
    private static volatile aacr aaba;
    private HiHealthKitClient aab = HiHealthKitClient.getInstance();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aab implements Callable<DataType> {
        final /* synthetic */ DataTypeAddOptions aab;

        aab(DataTypeAddOptions dataTypeAddOptions) {
            this.aab = dataTypeAddOptions;
        }

        @Override // java.util.concurrent.Callable
        public DataType call() throws Exception {
            if (aacr.aab(aacr.this, this.aab.getName())) {
                StringBuilder aab = com.huawei.hms.health.aab.aab("addDataType name:");
                aab.append(this.aab.getName());
                aab.append(" is available");
                try {
                    DataType aab2 = aack.aabf().aabe().aab(this.aab);
                    if (aab2 != null) {
                        return aab2;
                    }
                    if (aacr.aab(aacr.this, this.aab.getName())) {
                        throw aacr.this.aabh();
                    }
                    throw aacr.this.aabj();
                } catch (SecurityException e16) {
                    aabz.aabc("SettingControllerImpl", "addDataType security exception");
                    throw aacr.this.aab(e16);
                } catch (Exception e17) {
                    aabz.aabc("SettingControllerImpl", "addDataType common exception");
                    throw aacr.this.aab(e17);
                }
            }
            aabz.aabc("SettingControllerImpl", "addDataType name is illegal");
            throw aacr.this.aabj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aaba implements Callable<DataType> {
        final /* synthetic */ String aab;

        aaba(String str) {
            this.aab = str;
        }

        @Override // java.util.concurrent.Callable
        public DataType call() throws Exception {
            if (!aacr.this.aabb(this.aab) && !aacr.aab(aacr.this, this.aab)) {
                aabz.aabc("SettingControllerImpl", "readDataType name is illegal");
                throw aacr.this.aabj();
            }
            StringBuilder aab = com.huawei.hms.health.aab.aab("readDataType name:");
            aab.append(this.aab);
            aab.append(" is available");
            try {
                DataType aaba = aack.aabf().aabe().aaba(this.aab);
                if (aaba != null) {
                    return aaba;
                }
                if (aacr.aab(aacr.this, this.aab)) {
                    throw aacr.this.aabi();
                }
                throw aacr.this.aabj();
            } catch (SecurityException e16) {
                aabz.aabc("SettingControllerImpl", "readDataType security exception");
                throw aacr.this.aab(e16);
            } catch (Exception e17) {
                aabz.aabc("SettingControllerImpl", "readDataType common exception");
                throw aacr.this.aab(e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabb implements Callable<Void> {
        aabb() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            try {
                aack.aabf().aabe().aaba();
                return null;
            } catch (SecurityException e16) {
                aabz.aabc("SettingControllerImpl", "disableHiHealth security exception");
                throw aacr.this.aab(e16);
            } catch (Exception e17) {
                aabz.aabc("SettingControllerImpl", "disableHiHealth common exception");
                throw aacr.this.aab(e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabc implements Callable<Void> {
        aabc() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            try {
                aack.aabf().aabe().aabf();
                return null;
            } catch (SecurityException e16) {
                aabz.aabc("SettingControllerImpl", "checkAuthorisation security exception");
                throw aacr.this.aab((Exception) e16);
            } catch (Exception e17) {
                aabz.aabc("SettingControllerImpl", "checkAuthorisation common exception");
                throw aacr.this.aab(e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabd implements Callable<Boolean> {
        aabd() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                return Boolean.valueOf(aack.aabf().aabe().aabi());
            } catch (Exception e16) {
                aabz.aabc("SettingControllerImpl", "getAuthorisation common exception");
                throw aacr.this.aab(e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabe implements Callable<String> {
        aabe() {
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            try {
                return aack.aabf().aabe().aabe();
            } catch (Exception e16) {
                aabz.aabc("SettingControllerImpl", "getAuthUrl common exception");
                throw aacr.this.aab(e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabf implements Callable<Boolean> {
        aabf() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                return Boolean.valueOf(aack.aabf().aabe().aabj());
            } catch (Exception e16) {
                aabz.aabc("SettingControllerImpl", "getLinkHealthKitStatus common exception");
                throw aacr.this.aab(e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabg implements Callable<Boolean> {
        final /* synthetic */ boolean aab;

        aabg(boolean z16) {
            this.aab = z16;
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                return Boolean.valueOf(aack.aabf().aabe().aaba(this.aab));
            } catch (Exception e16) {
                aabz.aabc("SettingControllerImpl", "setLinkHealthKitStatus common exception");
                throw aacr.this.aab(e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabh implements Callable<com.huawei.hms.hihealth.data.aabc> {
        aabh() {
        }

        @Override // java.util.concurrent.Callable
        public com.huawei.hms.hihealth.data.aabc call() throws Exception {
            try {
                return aack.aabf().aabe().aabk();
            } catch (Exception e16) {
                aabz.aabc("SettingControllerImpl", "getInterfacePolicy common exception");
                throw aacr.this.aab(e16);
            }
        }
    }

    public static aacr aabg() {
        if (aaba == null) {
            synchronized (aacr.class) {
                if (aaba == null) {
                    aaba = new aacr();
                }
            }
        }
        return aaba;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ApiException aabh() {
        return new ApiException(new Status(50001, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ApiException aabi() {
        return new ApiException(new Status(50003, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ApiException aabj() {
        return new ApiException(new Status(50002, "DataType's name does not match package name."));
    }

    public Intent aab(String[] strArr, boolean z16) {
        Intent intent = new Intent(this.aab.getContext(), (Class<?>) HealthKitMainActivity.class);
        intent.putExtra("scopes", strArr);
        intent.putExtra("enableHealthAuth", z16);
        return intent;
    }

    public Task<Void> aaba() {
        return aacs.aab(5, new aabb());
    }

    public Task<String> aabb() {
        return aacs.aaba(5, new aabe());
    }

    public Task<Boolean> aabc() {
        return aacs.aaba(5, new aabd());
    }

    public Task<com.huawei.hms.hihealth.data.aabc> aabd() {
        return aacs.aaba(5, new aabh());
    }

    public Task<Boolean> aabe() {
        return aacs.aaba(5, new aabf());
    }

    public boolean aabf() {
        String str;
        try {
            if (aack.aabf().aabe() == null) {
                if (!HiHealthKitClient.getInstance().isConnected()) {
                    return false;
                }
                HiHealthKitClient.getInstance().bindServiceWithOutCheckEmui(5);
            }
            return aack.aabf().aabe().aab();
        } catch (IllegalStateException unused) {
            str = "openAuthFromCloud IllegalState Exception";
            aabz.aabc("SettingControllerImpl", str);
            return false;
        } catch (Exception unused2) {
            str = "openAuthFromCloud common exception";
            aabz.aabc("SettingControllerImpl", str);
            return false;
        }
    }

    public Task<Void> aab() {
        return aacs.aaba(5, new aabc());
    }

    public Task<DataType> aaba(String str) {
        return aacs.aab(5, new aaba(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aabb(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 11) {
            return "com.huawei.".equals(str.substring(0, 11));
        }
        return false;
    }

    public Task<DataType> aab(DataTypeAddOptions dataTypeAddOptions) {
        return aacs.aab(5, new aab(dataTypeAddOptions));
    }

    public Task<Boolean> aab(boolean z16) {
        return aacs.aaba(5, new aabg(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ApiException aab(SecurityException securityException) {
        try {
            int parseInt = Integer.parseInt(securityException.getMessage());
            return new ApiException(new Status(parseInt, HiHealthStatusCodes.getStatusCodeMessage(parseInt)));
        } catch (NumberFormatException unused) {
            aabz.aab("SettingControllerImpl", "parse statusCode Error");
            return new ApiException(new Status(50011, HiHealthStatusCodes.getStatusCodeMessage(50011)));
        }
    }

    public HealthKitAuthResult aab(Intent intent) {
        String str;
        if (intent == null) {
            return null;
        }
        try {
            return new HealthKitAuthResult().fromJson(intent.getStringExtra("HEALTHKIT_AUTH_RESULT"));
        } catch (JSONException unused) {
            str = "JSONException";
            aabz.aab("SettingControllerImpl", str);
            return null;
        } catch (Throwable unused2) {
            str = "Exception";
            aabz.aab("SettingControllerImpl", str);
            return null;
        }
    }

    public Boolean aab(String str) {
        String str2;
        try {
            if (aack.aabf().aabe() == null) {
                if (!HiHealthKitClient.getInstance().isConnected()) {
                    return Boolean.FALSE;
                }
                HiHealthKitClient.getInstance().bindServiceWithOutCheckEmui(5);
            }
            return Boolean.valueOf(aack.aabf().aabe().aabc(str));
        } catch (IllegalStateException unused) {
            str2 = "isAppInTrustList IllegalState Exception";
            aabz.aabc("SettingControllerImpl", str2);
            return Boolean.FALSE;
        } catch (Exception unused2) {
            str2 = "isAppInTrustList common exception";
            aabz.aabc("SettingControllerImpl", str2);
            return Boolean.FALSE;
        }
    }

    static /* synthetic */ boolean aab(aacr aacrVar, String str) {
        String packageName = aacrVar.aab.getContext().getPackageName();
        String str2 = packageName + ".";
        if (TextUtils.isEmpty(packageName) || TextUtils.isEmpty(str) || str.length() <= str2.length()) {
            return false;
        }
        return str2.equals(str.substring(0, str2.length()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ApiException aab(Exception exc) {
        if (exc == null || exc.getMessage() == null) {
            return new ApiException(new Status(50011));
        }
        String message = exc.getMessage();
        return (message == null || message.length() == 0) ? false : Pattern.matches("^[-\\+]?[\\d]*$", message) ? new ApiException(new Status(Integer.parseInt(exc.getMessage()), HiHealthStatusCodes.getStatusCodeMessage(Integer.parseInt(exc.getMessage())))) : new ApiException(new Status(50011, exc.getMessage()));
    }
}
