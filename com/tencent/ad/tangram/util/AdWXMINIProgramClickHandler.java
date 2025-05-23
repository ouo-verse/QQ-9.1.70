package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.biz.common.util.WebViewConstants;
import java.lang.ref.WeakReference;

@AdKeep
/* loaded from: classes3.dex */
public final class AdWXMINIProgramClickHandler {
    private static final String TAG = "AdWXMINIProgramClickHandler";

    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Params extends AdClickUtil.Params {
        @Override // com.tencent.ad.tangram.util.AdClickUtil.Params
        public boolean isValid() {
            Ad ad5;
            WeakReference<Activity> weakReference = this.activity;
            if (weakReference != null && weakReference.get() != null && (ad5 = this.f61334ad) != null && !TextUtils.isEmpty(ad5.getTraceId()) && !TextUtils.isEmpty(this.f61334ad.getPosId()) && this.f61334ad.getAId() != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                return true;
            }
            return false;
        }
    }

    @AdKeep
    /* loaded from: classes3.dex */
    public static final class Result extends AdClickUtil.Result {
        public Result(AdClickUtil.Result result) {
            super(result);
        }

        public Result(int i3, int i16) {
            super(i3, i16);
        }

        public Result(AdError adError, int i3) {
            super(adError, i3);
        }
    }

    @AdKeep
    /* loaded from: classes3.dex */
    private static final class URLObject extends AdClickUtil.URLObject {
        private final boolean mIsValid;

        public URLObject(AdClickUtil.URLObject uRLObject) {
            super(uRLObject);
            this.mIsValid = check(this.url);
        }

        private static boolean check(String str) {
            boolean z16;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                Uri parse = Uri.parse(str);
                if (parse == null) {
                    AdLog.e(AdWXMINIProgramClickHandler.TAG, "[URLObject][check] error, uri is null, url:" + str);
                    return false;
                }
                String scheme = parse.getScheme();
                if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    return true;
                }
                AdLog.e(AdWXMINIProgramClickHandler.TAG, "[URLObject][check] error, unknown scheme, scheme:" + scheme + " url:" + str);
                return false;
            } catch (Throwable th5) {
                AdLog.e(AdWXMINIProgramClickHandler.TAG, "[URLObject][check] url:" + str, th5);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.ad.tangram.util.AdClickUtil.URLObject
        public boolean isValid() {
            if (super.isValid() && this.mIsValid) {
                return true;
            }
            return false;
        }
    }

    @AdKeep
    /* loaded from: classes3.dex */
    private static final class URLParams extends AdClickUtil.URLParams {
        URLParams() {
        }
    }

    public static Result handle(Params params) {
        Result result;
        Boolean bool;
        if (params != null && params.isValid()) {
            AdLog.i(TAG, "[handle]");
            AdClickUtil.beforeClick(params);
            if (!TextUtils.isEmpty(params.f61334ad.getAppDeeplink(params.clickLocationParams))) {
                result = new Result(AdClickUtil.handleAppWithDeeplink(params, 1, false));
            } else {
                result = null;
            }
            if (params.isValidForApp()) {
                bool = Boolean.valueOf(AdAppUtil.isInstalled(params.activity.get(), params.f61334ad.getAppPackageName()));
            } else {
                bool = null;
            }
            if ((result == null || !result.isSuccess()) && params.isValidForApp() && !params.f61334ad.disableLaunchApp() && bool != null && bool.booleanValue()) {
                result = new Result(AdClickUtil.handleApp(params, false));
            }
            URLObject uRLObject = new URLObject(AdClickUtil.getURLObject(params, new URLParams()));
            if ((result == null || !result.isSuccess()) && uRLObject.isValid()) {
                result = new Result(AdClickUtil.handleUrl(params, uRLObject));
            }
            if (result != null && result.isSuccess() && params.isValidForApp() && params.f61334ad.getDestType() == 1 && bool != null && !bool.booleanValue()) {
                AdAppReceiverWrapper.getInstance().observe(params, result);
            }
            if (result == null) {
                result = new Result(4, 0);
            }
            AdClickUtil.afterClick(params, result);
            return result;
        }
        AdLog.e(TAG, "[handle] error, not valid");
        return new Result(4, 0);
    }
}
