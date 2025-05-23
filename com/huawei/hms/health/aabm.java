package com.huawei.hms.health;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.AndroidRuntimeException;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.hihealth.HiHealthKitClient;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.activity.HealthKitMainActivity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aabm extends TaskApiCall<aabh, aabp> {
    public aabm(String str, String str2) {
        super(str, str2);
    }

    private void aab(ResponseErrorCode responseErrorCode, TaskCompletionSource<aabp> taskCompletionSource, Context context) {
        Parcelable parcelable = responseErrorCode.getParcelable();
        if (parcelable instanceof PendingIntent) {
            aabz.aabb("HealthHmsTaskApiCall", "parcelable is instanceof PendingIntent");
            PendingIntent pendingIntent = (PendingIntent) parcelable;
            try {
                if (UIUtil.isBackground(context)) {
                    taskCompletionSource.setException(new ResolvableApiException(responseErrorCode));
                } else {
                    aacu.aaba(pendingIntent.getCreatorPackage(), HMSPackageManager.getInstance(context).getHMSPackageName());
                    pendingIntent.send();
                }
            } catch (PendingIntent.CanceledException e16) {
                StringBuilder aab = aab.aab("Failed to resolve, ");
                aab.append(e16.getMessage());
                aabz.aab("HealthHmsTaskApiCall", aab.toString());
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        if (parcelable instanceof Intent) {
            aabz.aabb("HealthHmsTaskApiCall", "parcelable is instanceof Intent");
            Intent intent = (Intent) parcelable;
            aacu.aab(intent, HMSPackageManager.getInstance(context).getHMSPackageName());
            intent.setFlags(268435456);
            if (UIUtil.isBackground(context) && !"10414141".equals(Util.getAppId(context))) {
                throw new SecurityException(String.valueOf(HiHealthStatusCodes.INVALID_CONTEXT));
            }
            aabz.aabb("HealthHmsTaskApiCall", "application is not background or calling app is health app");
            context.startActivity(intent);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    protected void doExecute(aabh aabhVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<aabp> taskCompletionSource) {
        String str2;
        String str3;
        boolean z16;
        aabh aabhVar2 = aabhVar;
        if (responseErrorCode == null) {
            aabz.aab("HealthHmsTaskApiCall", "FrameworkTestTaskApiCall header is null");
            return;
        }
        aab.aab("FrameworkTestTaskApiCall header code : ").append(responseErrorCode.getErrorCode());
        if (responseErrorCode.getErrorCode() == 0) {
            aabp aabpVar = new aabp(null);
            if (responseErrorCode.getParcelable() != null && (responseErrorCode.getParcelable() instanceof Intent)) {
                taskCompletionSource.setResult(new aabp((Intent) responseErrorCode.getParcelable()));
                return;
            } else {
                taskCompletionSource.setResult(aabpVar);
                return;
            }
        }
        if (responseErrorCode.hasResolution()) {
            if (responseErrorCode.getErrorCode() != -11) {
                StringBuilder aab = aab.aab("update healthKit fail, hasResolution is ");
                aab.append(responseErrorCode.getResolution());
                aabz.aab("HealthHmsTaskApiCall", aab.toString());
                HiHealthKitClient.getInstance().countDownChange();
                if (responseErrorCode.getErrorCode() != 1212) {
                    if (new AvailableAdapter(40002300).checkHuaweiMobileServicesForUpdate(aabhVar2.getContext()) == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        StringBuilder aab2 = aab.aab("connect to hms core fail, errorCode is ");
                        aab2.append(responseErrorCode.getErrorCode());
                        str2 = aab2.toString();
                        aabz.aab("HealthHmsTaskApiCall", str2);
                        return;
                    }
                }
                try {
                    aab(responseErrorCode, taskCompletionSource, aabhVar2.getContext());
                } catch (SecurityException e16) {
                    aabz.aab("HealthHmsTaskApiCall", "openHmsUpdateActivity catch SecurityException");
                    if (String.valueOf(HiHealthStatusCodes.INVALID_CONTEXT).equals(e16.getMessage())) {
                        Context context = aabhVar2.getContext();
                        Context context2 = HiHealthKitClient.getInstance().getContext();
                        if (context2 == null) {
                            aabz.aab("HealthHmsTaskApiCall", "update kit failed, HiHealthKitClient context is null");
                        } else {
                            context = context2;
                        }
                        if (context == null) {
                            str3 = "update kit failed, context from hmsFrameWork is null";
                        } else {
                            Intent intent = new Intent(context, (Class<?>) HealthKitMainActivity.class);
                            intent.addFlags(268435456);
                            intent.putExtra(HealthKitMainActivity.HEALTH_FRAGMENT_CODE, 1);
                            try {
                                context.startActivity(intent);
                                return;
                            } catch (AndroidRuntimeException unused) {
                                str3 = "update kit failed, catch AndroidRuntimeException";
                                aabz.aab("HealthHmsTaskApiCall", str3);
                            } catch (Exception unused2) {
                                str3 = "update kit failed, catch basic Exception";
                                aabz.aab("HealthHmsTaskApiCall", str3);
                            }
                        }
                        aabz.aab("HealthHmsTaskApiCall", str3);
                    }
                } catch (Throwable unused3) {
                    str2 = "openHmsUpdateActivity catch basic exception";
                }
            } else {
                aabz.aab("HealthHmsTaskApiCall", "this phone not install hms core");
                throw new SecurityException(String.valueOf(HiHealthStatusCodes.HMS_CORE_VER_NOT_MATCH));
            }
        } else {
            StringBuilder aab3 = aab.aab("update healthKit fail, hasResolution is ");
            aab3.append(responseErrorCode.getResolution());
            aabz.aabb("HealthHmsTaskApiCall", aab3.toString());
            if (responseErrorCode.getErrorCode() == 1212) {
                aabz.aab("HealthHmsTaskApiCall", "parcelable is null, update kit failed, invalid context, errorCode is 50049");
            }
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }
}
