package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.util.AdAppDeeplinkLauncher;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAppMarketLauncher {
    private static final int MAX_NUM_OF_ATTEMPTS = 5;
    private static final String TAG = "AdAppMarketLauncher";

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params {
        public List<AdAppDeeplinkLauncher.Params> list;

        boolean isValid() {
            List<AdAppDeeplinkLauncher.Params> list = this.list;
            if (list != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Result {
        private List<Pair<AdAppDeeplinkLauncher.Params, AdAppDeeplinkLauncher.Result>> details;
        private AdError error;

        public List<Pair<AdAppDeeplinkLauncher.Params, AdAppDeeplinkLauncher.Result>> getDetails() {
            return this.details;
        }

        @NonNull
        public AdError getError() {
            AdError adError = this.error;
            if (adError == null) {
                return new AdError(1);
            }
            return adError;
        }

        public int getErrorCode() {
            if (getError() != null) {
                return getError().getErrorCode();
            }
            return 1;
        }

        public boolean isSuccess() {
            AdError adError = this.error;
            if (adError != null && adError.isSuccess()) {
                return true;
            }
            return false;
        }
    }

    @Nullable
    public static Result launch(WeakReference<Activity> weakReference, @Nullable Params params) {
        String str;
        AdAppDeeplinkLauncher.Result launch;
        Result result = new Result();
        if (weakReference == null || params == null || !params.isValid()) {
            result.error = new AdError(4);
            return result;
        }
        int min = Math.min(5, params.list.size());
        result.details = new LinkedList();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i16 >= min) {
                break;
            }
            AdAppDeeplinkLauncher.Params params2 = params.list.get(i16);
            if (params2 != null) {
                str = params2.packageName;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str) && !AdAppUtil.isInstalled(weakReference.get(), str)) {
                launch = new AdAppDeeplinkLauncher.Result();
                launch.error = new AdError(12);
            } else {
                launch = AdAppDeeplinkLauncher.launch(weakReference.get(), params2);
            }
            if (launch == null) {
                launch = new AdAppDeeplinkLauncher.Result();
                launch.error = new AdError(1);
            }
            result.details.add(new Pair(params2, launch));
            if (launch.isSuccess()) {
                i3 = 1;
                break;
            }
            i16++;
        }
        result.error = new AdError(i3 ^ 1);
        return result;
    }
}
