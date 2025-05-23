package com.huawei.hms.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.EnableServiceActivity;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ErrorDialogFragment;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.common.api.HuaweiApiCallable;
import com.huawei.hms.common.internal.ConnectionErrorMessages;
import com.huawei.hms.common.internal.DialogRedirect;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.update.note.DoNothingResolution;
import com.huawei.hms.update.note.NotInstalledHmsResolution;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class HuaweiApiAvailabilityImpl extends HuaweiApiAvailability {

    /* renamed from: a, reason: collision with root package name */
    private static final HuaweiApiAvailabilityImpl f36707a = new HuaweiApiAvailabilityImpl();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements BusResponseCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TaskCompletionSource[] f36708a;

        a(TaskCompletionSource[] taskCompletionSourceArr) {
            this.f36708a = taskCompletionSourceArr;
        }

        @Override // com.huawei.hms.activity.internal.BusResponseCallback
        public BusResponseResult innerError(Activity activity, int i3, String str) {
            HMSLog.e("HuaweiApiAvailabilityImpl", "Test foreground bus error: resultCode " + i3 + ", errMessage" + str);
            this.f36708a[0].setException(new AvailabilityException());
            return null;
        }

        @Override // com.huawei.hms.activity.internal.BusResponseCallback
        public BusResponseResult succeedReturn(Activity activity, int i3, Intent intent) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "Test foreground bus success: resultCode " + i3 + ", data" + intent);
            return null;
        }
    }

    HuaweiApiAvailabilityImpl() {
    }

    private static Intent a(Activity activity, String str) {
        return BridgeActivity.getIntentStartBridgeActivity(activity, str);
    }

    public static HuaweiApiAvailabilityImpl getInstance() {
        return f36707a;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Task<Void> checkApiAccessible(HuaweiApi<?> huaweiApi, HuaweiApi<?>... huaweiApiArr) {
        Task<Void> task = new TaskCompletionSource().getTask();
        if (huaweiApi != null) {
            try {
                a(huaweiApi);
            } catch (AvailabilityException e16) {
                HMSLog.i("HuaweiApiAvailabilityImpl", "checkApi has AvailabilityException " + e16.getMessage());
            }
        }
        if (huaweiApiArr != null) {
            for (HuaweiApi<?> huaweiApi2 : huaweiApiArr) {
                a(huaweiApi2);
            }
        }
        return task;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public PendingIntent getErrPendingIntent(Context context, ConnectionResult connectionResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(connectionResult);
        return getResolveErrorPendingIntent(context, connectionResult.getErrorCode());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Dialog getErrorDialog(Activity activity, int i3, int i16) {
        Checker.checkNonNull(activity, "activity must not be null.");
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + i3);
        return getErrorDialog(activity, i3, i16, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public String getErrorString(int i3) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorString, errorCode: " + i3);
        return ConnectionResult.getErrorString(i3);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Task<Void> getHuaweiServicesReady(Activity activity) {
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        TaskCompletionSource[] taskCompletionSourceArr = {taskCompletionSource};
        Task<Void> task = taskCompletionSource.getTask();
        int isHuaweiMobileServicesAvailable = isHuaweiMobileServicesAvailable(activity.getApplicationContext(), 30000000);
        Intent resolveErrorIntent = getResolveErrorIntent(activity, isHuaweiMobileServicesAvailable);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, ResolutionDelegate.class.getName());
        if (resolveErrorIntent != null) {
            ForegroundIntentBuilder.registerResponseCallback(ResolutionDelegate.CALLBACK_METHOD, new a(taskCompletionSourceArr));
            Bundle bundle = new Bundle();
            bundle.putParcelable("resolution", resolveErrorIntent);
            intentStartBridgeActivity.putExtras(bundle);
            activity.startActivity(intentStartBridgeActivity);
        } else if (isHuaweiMobileServicesAvailable == 3) {
            Intent intent = new Intent();
            intent.setClass(activity, EnableServiceActivity.class);
            activity.startActivity(intent);
        } else if (isHuaweiMobileServicesAvailable == 0) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "The HMS service is available.");
        } else {
            HMSLog.e("HuaweiApiAvailabilityImpl", "Framework can not solve the availability problem.");
            taskCompletionSourceArr[0].setException(new AvailabilityException());
        }
        return task;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Intent getResolveErrorIntent(Activity activity, int i3) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + i3);
        if (i3 == 1 || i3 == 2) {
            if (Util.isAvailableLibExist(activity) && AvailableUtil.isInstallerLibExist(activity)) {
                return (Intent) UpdateAdapter.invokeMethod("com.huawei.hms.update.manager.UpdateManager", "getStartUpdateIntent", new Object[]{activity, a(activity.getApplicationContext())});
            }
            return a(activity, NotInstalledHmsResolution.class.getName());
        }
        if (i3 != 6) {
            if (i3 == 9 && Util.isAvailableLibExist(activity)) {
                return a(activity, AppSpoofResolution.class.getName());
            }
            return null;
        }
        return a(activity, BindingFailedResolution.class.getName());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public PendingIntent getResolveErrorPendingIntent(Activity activity, int i3) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i3);
        Intent resolveErrorIntent = getResolveErrorIntent(activity, i3);
        if (resolveErrorIntent != null) {
            return PendingIntent.getActivity(activity, 0, resolveErrorIntent, 67108864);
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public int isHuaweiMobileNoticeAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(new PackageManagerHelper(context).getPackageStates(HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService()))) {
            return 1;
        }
        if (HMSPackageManager.getInstance(context).isApkUpdateNecessary(20600000)) {
            return 2;
        }
        return 0;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, HuaweiApiAvailability.getServicesVersionCode());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean isUserResolvableError(int i3, PendingIntent pendingIntent) {
        if (i3 == 0) {
            return false;
        }
        return pendingIntent != null || i3 == 1 || i3 == 2 || i3 == 6 || i3 == 9;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void popupErrNotification(Context context, ConnectionResult connectionResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(connectionResult);
        showErrorNotification(context, connectionResult.getErrorCode());
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void resolveError(Activity activity, int i3, int i16) {
        resolveError(activity, i3, i16, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean showErrorDialogFragment(Activity activity, int i3, int i16) {
        return showErrorDialogFragment(activity, i3, i16, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void showErrorNotification(Context context, int i3) {
        Checker.checkNonNull(context, "context must not be null.");
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter showErrorNotification, errorCode: " + i3);
        if (!(context instanceof Activity)) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "context not instanceof Activity");
            return;
        }
        Dialog errorDialog = getErrorDialog((Activity) context, i3, 0);
        if (errorDialog == null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "showErrorNotification errorDialog can not be null");
        } else {
            errorDialog.show();
        }
    }

    private static Intent a(Context context, String str) {
        return BridgeActivity.getIntentStartBridgeActivity(context, str);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean isUserResolvableError(int i3) {
        return isUserResolvableError(i3, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void resolveError(Activity activity, int i3, int i16, PendingIntent pendingIntent) {
        Checker.checkNonNull(activity, "activity must not be null.");
        if (pendingIntent != null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter resolveError, param pendingIntent is not null. and.errorCode: " + i3);
        } else {
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter resolveError, param pendingIntent is  null. get pendingIntent from error code.and.errorCode: " + i3);
            pendingIntent = getResolveErrorPendingIntent(activity, i3);
        }
        if (pendingIntent != null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "In resolveError, start pendingIntent.errorCode: " + i3);
            try {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i16, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused) {
                HMSLog.e("HuaweiApiAvailabilityImpl", "Enter resolveError, start pendingIntent failed.errorCode: " + i3);
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean showErrorDialogFragment(Activity activity, int i3, int i16, DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i3, i16, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        a(activity, errorDialog, HuaweiMobileServicesUtil.HMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    private UpdateBean a(Context context) {
        UpdateBean updateBean = new UpdateBean();
        updateBean.setHmsOrApkUpgrade(true);
        updateBean.setClientPackageName(HMSPackageManager.getInstance(context).getHMSPackageName());
        updateBean.setClientVersionCode(HuaweiApiAvailability.getServicesVersionCode());
        updateBean.setClientAppId("C10132067");
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(context);
        }
        try {
            updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
        } catch (Exception e16) {
            HMSLog.e("HuaweiApiAvailabilityImpl", "getString has Exception:" + e16.getMessage());
        }
        return updateBean;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Dialog getErrorDialog(Activity activity, int i3, int i16, DialogInterface.OnCancelListener onCancelListener) {
        Checker.checkNonNull(activity, "activity must not be null.");
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + i3);
        return a(activity, i3, DialogRedirect.getInstance(activity, a(activity, i3), i16), onCancelListener);
    }

    public PendingIntent getResolveErrorPendingIntent(Context context, int i3) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i3);
        Intent resolveErrorIntent = getResolveErrorIntent(context, i3);
        if (resolveErrorIntent != null) {
            return PendingIntent.getActivity(context, 0, resolveErrorIntent, 67108864);
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public int isHuaweiMobileServicesAvailable(Context context, int i3) {
        Checker.checkNonNull(context, "context must not be null.");
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, i3);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean showErrorDialogFragment(Activity activity, int i3, Fragment fragment, int i16, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(activity, i3, i16, onCancelListener);
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public PendingIntent getErrPendingIntent(Context context, int i3, int i16) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i3 + " requestCode: " + i16);
        Intent resolveErrorIntent = getResolveErrorIntent(context, i3);
        if (resolveErrorIntent != null) {
            return PendingIntent.getActivity(context, i16, resolveErrorIntent, 67108864);
        }
        return null;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Task<Void> checkApiAccessible(HuaweiApiCallable huaweiApiCallable, HuaweiApiCallable... huaweiApiCallableArr) {
        Task<Void> task = new TaskCompletionSource().getTask();
        if (huaweiApiCallable != null) {
            try {
                a(huaweiApiCallable);
            } catch (AvailabilityException e16) {
                HMSLog.i("HuaweiApiAvailabilityImpl", "HuaweiApiCallable checkApi has AvailabilityException " + e16.getMessage());
            }
        }
        if (huaweiApiCallableArr != null) {
            for (HuaweiApiCallable huaweiApiCallable2 : huaweiApiCallableArr) {
                a(huaweiApiCallable2);
            }
        }
        return task;
    }

    public Intent getResolveErrorIntent(Context context, int i3) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + i3);
        if (i3 == 1 || i3 == 2) {
            if (Util.isAvailableLibExist(context) && AvailableUtil.isInstallerLibExist(context)) {
                return (Intent) UpdateAdapter.invokeMethod("com.huawei.hms.update.manager.UpdateManager", "getStartUpdateIntent", new Object[]{context, a(context.getApplicationContext())});
            }
            return a(context, NotInstalledHmsResolution.class.getName());
        }
        if (i3 != 6) {
            if (i3 == 9 && Util.isAvailableLibExist(context)) {
                return a(context, AppSpoofResolution.class.getName());
            }
            return null;
        }
        return a(context, BindingFailedResolution.class.getName());
    }

    private Intent a(Activity activity, int i3) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "getErrorResolutionIntent, errorCode: " + i3);
        if (i3 == 1 || i3 == 2) {
            if (Util.isAvailableLibExist(activity) && AvailableUtil.isInstallerLibExist(activity)) {
                return (Intent) UpdateAdapter.invokeMethod("com.huawei.hms.update.manager.UpdateManager", "startUpdateIntent", new Object[]{activity});
            }
            return BridgeActivity.getIntentStartBridgeActivity(activity, DoNothingResolution.class.getName());
        }
        if (i3 != 6) {
            if (i3 == 9 && Util.isAvailableLibExist(activity)) {
                return BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName());
            }
            return null;
        }
        return BridgeActivity.getIntentStartBridgeActivity(activity, BindingFailedResolution.class.getName());
    }

    private static Dialog a(Activity activity, int i3, DialogRedirect dialogRedirect, DialogInterface.OnCancelListener onCancelListener) {
        if (i3 == 0) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, UIUtil.getDialogThemeId(activity));
        builder.setMessage(ConnectionErrorMessages.getErrorMessage(activity, i3));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.setPositiveButton(ConnectionErrorMessages.getErrorDialogButtonMessage(activity, i3), dialogRedirect);
        if (Util.isAvailableLibExist(activity) && AvailableUtil.isInstallerLibExist(activity)) {
            String errorTitle = ConnectionErrorMessages.getErrorTitle(activity, i3);
            if (errorTitle != null) {
                builder.setTitle(errorTitle);
            }
        } else {
            String errorTitle2 = ConnectionErrorMessages.getErrorTitle(activity, i3);
            if (errorTitle2 != null) {
                builder.setTitle(errorTitle2);
            }
        }
        return builder.create();
    }

    private static void a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        Checker.checkNonNull(activity, "activity must not be null.");
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    private void a(Object obj) throws AvailabilityException {
        ConnectionResult connectionResult;
        AvailabilityException availabilityException = new AvailabilityException();
        if (obj instanceof HuaweiApi) {
            connectionResult = availabilityException.getConnectionResult((HuaweiApi<? extends Api.ApiOptions>) obj);
        } else {
            connectionResult = availabilityException.getConnectionResult((HuaweiApiCallable) obj);
        }
        if (connectionResult.getErrorCode() == 0) {
            return;
        }
        HMSLog.i("HuaweiApiAvailabilityImpl", "The service is unavailable: " + availabilityException.getMessage());
        throw availabilityException;
    }
}
