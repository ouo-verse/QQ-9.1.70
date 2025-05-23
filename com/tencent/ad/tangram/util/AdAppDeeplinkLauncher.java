package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAppDeeplinkLauncher {
    private static final String TAG = "AdAppDeeplinkLauncher";

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {

        @Nullable
        public String deeplink;
        public Bundle extrasForIntent;

        @Nullable
        public String packageName;
        public int addflags = Integer.MIN_VALUE;
        public int requestCode = Integer.MIN_VALUE;

        @Nullable
        Intent getIntent() {
            Uri parse;
            if (!isValid() || (parse = AdUriUtil.parse(this.deeplink)) == null) {
                return null;
            }
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, parse);
            if (!TextUtils.isEmpty(this.packageName)) {
                intent.setPackage(this.packageName);
            }
            Bundle bundle = this.extrasForIntent;
            if (bundle != null && !bundle.isEmpty()) {
                intent.putExtras(this.extrasForIntent);
            }
            int i3 = this.addflags;
            if (i3 != Integer.MIN_VALUE) {
                intent.addFlags(i3);
            }
            return intent;
        }

        boolean isValid() {
            return !TextUtils.isEmpty(this.deeplink);
        }
    }

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Result {
        AdError error;

        @Nullable
        ResolveInfo resolveInfo;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public String getActivityName() {
            ActivityInfo activityInfo;
            ResolveInfo resolveInfo = this.resolveInfo;
            if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null) {
                return activityInfo.name;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public AdError getError() {
            AdError adError = this.error;
            if (adError == null) {
                return new AdError(1);
            }
            return adError;
        }

        public int getErrorCode() {
            return getError().getErrorCode();
        }

        public boolean isSuccess() {
            AdError adError = this.error;
            if (adError != null && adError.isSuccess()) {
                return true;
            }
            return false;
        }
    }

    @NonNull
    public static Result canLaunch(@Nullable Context context, @NonNull Params params) {
        Result result = new Result();
        if (context != null && params.isValid()) {
            Intent intent = params.getIntent();
            if (intent == null) {
                result.error = new AdError(201);
            } else {
                ResolveInfo resolveActivity = AdAppUtil.resolveActivity(context, intent);
                result.resolveInfo = resolveActivity;
                if (resolveActivity == null) {
                    result.error = new AdError(204);
                } else {
                    result.error = new AdError(0);
                }
            }
        } else {
            result.error = new AdError(4);
        }
        return result;
    }

    @NonNull
    public static Result launch(@Nullable Activity activity, @NonNull Params params) {
        String str;
        String str2;
        ActivityInfo activityInfo;
        Result result = new Result();
        int i3 = Integer.MIN_VALUE;
        if (activity != null && params.isValid()) {
            Intent intent = params.getIntent();
            if (intent == null) {
                result.error = new AdError(201);
            } else {
                result = canLaunch(activity, params);
                if (result != null && result.isSuccess()) {
                    try {
                        int i16 = params.requestCode;
                        if (i16 != Integer.MIN_VALUE) {
                            activity.startActivityForResult(intent, i16);
                        } else {
                            activity.startActivity(intent);
                        }
                        result.error = new AdError(0);
                    } catch (Throwable th5) {
                        AdLog.e(TAG, "launch", th5);
                        result.error = new AdError(202, th5);
                    }
                }
            }
        } else {
            result.error = new AdError(4);
        }
        if (result == null) {
            result = new Result();
            result.error = new AdError(1);
        }
        Object[] objArr = new Object[5];
        String str3 = null;
        if (params != null) {
            str = params.deeplink;
        } else {
            str = null;
        }
        objArr[0] = str;
        if (params != null) {
            str2 = params.packageName;
        } else {
            str2 = null;
        }
        objArr[1] = str2;
        if (params != null) {
            i3 = params.addflags;
        }
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(result.getErrorCode());
        ResolveInfo resolveInfo = result.resolveInfo;
        if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null) {
            str3 = activityInfo.toString();
        }
        objArr[4] = str3;
        AdLog.i(TAG, String.format("launch \nparams deeplink:%s packageName:%s flags:%d \nresult errorCode:%d resolveInfo.activityInfo:%s", objArr));
        return result;
    }
}
