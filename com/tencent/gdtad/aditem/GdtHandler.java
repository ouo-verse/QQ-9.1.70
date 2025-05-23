package com.tencent.gdtad.aditem;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdClickLocationParams;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtActivityHandler;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtHandler {
    private static final String TAG = "GdtHandler";
    static QBaseActivity.a sTopResumedActivityListener = new a();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class Params extends Options {

        @Nullable
        public WeakReference<Activity> activity;
        public int processId = Integer.MIN_VALUE;

        public boolean isInitialized() {
            WeakReference<Activity> weakReference = this.activity;
            if (weakReference != null && weakReference.get() != null) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.gdtad.aditem.GdtHandler.Options
        public boolean isValid() {
            if (super.isValid() && isInitialized()) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements QBaseActivity.a {
        a() {
        }

        @Override // com.tencent.mobileqq.app.QBaseActivity.a
        public void a(Activity activity, boolean z16) {
            ((IGdtActivityHandler) QRoute.api(IGdtActivityHandler.class)).onTopResumedActivityChanged(new WeakReference<>(activity), z16);
        }
    }

    public static boolean canLaunchApp(Params params) {
        return AdClickUtil.canLaunchApp(toParams(params));
    }

    public static void fillClickUtilParamsFromOptions(Options options, AdClickUtil.Params params) {
        if (options != null && params != null) {
            params.f61334ad = options.f108486ad;
            params.reportForClick = options.reportForClick;
            params.sceneID = options.sceneID;
            params.componentID = options.componentID;
            params.videoCeilingSupported = options.videoCeilingSupportedIfNotInstalled;
            params.widthHeightRatioOfVideoCeiling = options.widthHeightRatioOfVideoCeiling;
            params.videoStartPositionMillis = options.videoStartPositionMillis;
            Bundle bundle = new Bundle();
            params.extrasForIntent = bundle;
            bundle.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            if (options.extra != null) {
                GdtLog.i(TAG, "[fillClickUtilParamsFromOptions]toParams pass refId " + options.extra);
                params.extrasForIntent.putAll(options.extra);
            } else {
                GdtLog.i(TAG, "[fillClickUtilParamsFromOptions]toParams not pass refId \n" + QLog.getStackTraceString(new IllegalArgumentException()));
            }
            params.videoPlayForced = options.directPlay;
            params.antiSpamParams = options.antiSpamParams;
            AdClickLocationParams adClickLocationParams = new AdClickLocationParams();
            adClickLocationParams.indexOfCarouselAd = options.indexOfCarouselAd;
            adClickLocationParams.indexOfMPDA = options.indexOfMDPA;
            params.clickLocationParams = adClickLocationParams;
            params.useVerticalTransitionBetweenActivities = options.useVerticalTransitionBetweenActivities;
            params.startActivityRequestCode = options.startActivityRequestCode;
            return;
        }
        GdtLog.e(TAG, "[fillClickUtilParamsFromOptions] options is null");
    }

    public static boolean fillOptions(@Nullable Options options, @Nullable String str) {
        if (options == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            GdtLog.i(TAG, String.format("fromJSON %s", str));
            JSONObject jSONObject2 = jSONObject.getJSONObject("options");
            boolean z16 = jSONObject2.getBoolean("reportForClick");
            JSONObject optJSONObject = jSONObject2.optJSONObject("mediaViewLocationRect");
            Rect rect = new Rect();
            if (optJSONObject != null) {
                rect.left = optJSONObject.optInt("left", 0);
                rect.top = optJSONObject.optInt("top", 0);
                rect.right = optJSONObject.optInt("right", 0);
                rect.bottom = optJSONObject.optInt("bottom", 0);
            }
            options.reportForClick = z16;
            options.videoCeilingSupportedIfNotInstalled = jSONObject2.optBoolean("videoCeilingSupported", false);
            options.widthHeightRatioOfVideoCeiling = jSONObject2.optString("widthHeightRatioOfVerticalVideoCeiling");
            options.directPlay = jSONObject2.optBoolean("videoPlayForced");
            options.indexOfCarouselAd = jSONObject2.optInt("indexOfCarouselAd", Integer.MIN_VALUE);
            options.indexOfMDPA = jSONObject2.optInt("indexOfMDPA", Integer.MIN_VALUE);
            options.useVerticalTransitionBetweenActivities = jSONObject2.optBoolean("useVerticalTransitionBetweenActivities", false);
            if (jSONObject.has("adInfo")) {
                options.f108486ad = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), jSONObject.getJSONObject("adInfo"))));
            }
            return true;
        } catch (Throwable th5) {
            GdtLog.e(TAG, "handleJsCallRequest error", th5);
            return false;
        }
    }

    @Nullable
    public static void fillOptionsFromClickUtilParams(@Nullable AdClickUtil.Params params, Options options) {
        if (params != null && options != null) {
            Ad ad5 = params.f61334ad;
            if (ad5 instanceof GdtAd) {
                options.f108486ad = (GdtAd) ad5;
            }
            options.reportForClick = params.reportForClick;
            options.sceneID = params.sceneID;
            options.componentID = params.componentID;
            options.videoCeilingSupportedIfNotInstalled = params.videoCeilingSupported;
            options.widthHeightRatioOfVideoCeiling = params.widthHeightRatioOfVideoCeiling;
            options.videoStartPositionMillis = params.videoStartPositionMillis;
            options.directPlay = params.videoPlayForced;
            options.antiSpamParams = params.antiSpamParams;
            Bundle bundle = new Bundle();
            options.extra = bundle;
            bundle.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            if (params.extrasForIntent != null) {
                GdtLog.i(TAG, "toParams pass refId " + params.extrasForIntent);
                options.extra.putAll(params.extrasForIntent);
            } else {
                GdtLog.i(TAG, "toParams not pass refId \n" + QLog.getStackTraceString(new IllegalArgumentException()));
            }
            AdClickLocationParams adClickLocationParams = params.clickLocationParams;
            options.indexOfCarouselAd = adClickLocationParams.indexOfCarouselAd;
            options.indexOfMDPA = adClickLocationParams.indexOfMPDA;
            options.useVerticalTransitionBetweenActivities = params.useVerticalTransitionBetweenActivities;
            options.startActivityRequestCode = params.startActivityRequestCode;
            return;
        }
        GdtLog.e(TAG, "[fillOptionsFromClickUtilParams] error");
    }

    @Deprecated
    public static void handle(@Nullable Params params) throws IllegalArgumentException {
        Activity activity;
        int i3;
        GdtLog.i(TAG, "handle");
        IGdtAdAPI iGdtAdAPI = (IGdtAdAPI) QRoute.api(IGdtAdAPI.class);
        if (iGdtAdAPI == null) {
            QLog.i(TAG, 1, "gdtAdAPI == null");
            return;
        }
        if (params != null && params.isValid()) {
            activity = params.activity.get();
        } else {
            activity = null;
        }
        if (activity != null) {
            iGdtAdAPI.initGdtContext(activity, new InitGdtContextParams());
            if (activity instanceof QBaseActivity) {
                ((QBaseActivity) activity).setTopResumedActivityListener(sTopResumedActivityListener);
            }
        }
        AdClickUtil.Result handle = AdClickUtil.handle(toParams(params));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[handle] errorCode:");
        if (handle != null) {
            i3 = handle.getErrorCode();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        sb5.append(i3);
        GdtLog.i(TAG, sb5.toString());
    }

    public static AdClickUtil.Params toParams(@Nullable Params params) {
        if (params == null) {
            return null;
        }
        AdClickUtil.Params params2 = new AdClickUtil.Params();
        fillClickUtilParamsFromOptions(params, params2);
        params2.activity = params.activity;
        return params2;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Options implements Parcelable {
        public static final Parcelable.Creator<Options> CREATOR = new a();

        /* renamed from: ad, reason: collision with root package name */
        @Nullable
        public GdtAd f108486ad;

        @Nullable
        public String antiSpamParams;

        @Nullable
        public JSONObject antiSpamParamsForClick;

        @Deprecated
        public boolean appAutoDownload;
        public int componentID;
        public boolean directPlay;

        @Nullable
        public Bundle extra;
        public int indexOfCarouselAd;
        public int indexOfMDPA;
        public boolean reportForClick;
        public int sceneID;
        public int startActivityRequestCode;
        public boolean useVerticalTransitionBetweenActivities;

        @Deprecated
        public boolean videoCeilingSupportedIfInstalled;
        public boolean videoCeilingSupportedIfNotInstalled;
        private boolean videoLoop;
        public long videoStartPositionMillis;
        public String widthHeightRatioOfVideoCeiling;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class a implements Parcelable.Creator<Options> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Options createFromParcel(Parcel parcel) {
                return new Options(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Options[] newArray(int i3) {
                return new Options[i3];
            }
        }

        public Options() {
            this.reportForClick = true;
            this.sceneID = Integer.MIN_VALUE;
            this.componentID = Integer.MIN_VALUE;
            this.appAutoDownload = false;
            this.videoCeilingSupportedIfNotInstalled = false;
            this.videoCeilingSupportedIfInstalled = false;
            this.videoLoop = false;
            this.videoStartPositionMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            this.directPlay = false;
            this.antiSpamParams = null;
            this.antiSpamParamsForClick = null;
            this.indexOfCarouselAd = Integer.MIN_VALUE;
            this.indexOfMDPA = Integer.MIN_VALUE;
            this.useVerticalTransitionBetweenActivities = false;
            this.startActivityRequestCode = Integer.MIN_VALUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean isValid() {
            boolean z16;
            boolean z17;
            GdtAd gdtAd = this.f108486ad;
            if (gdtAd == null || !gdtAd.isValid()) {
                return false;
            }
            AdClickLocationParams adClickLocationParams = new AdClickLocationParams();
            adClickLocationParams.indexOfCarouselAd = this.indexOfCarouselAd;
            adClickLocationParams.indexOfMPDA = this.indexOfMDPA;
            if (!adClickLocationParams.isValid(this.f108486ad)) {
                return false;
            }
            if (!TextUtils.isEmpty(this.f108486ad.getTraceId()) && !TextUtils.isEmpty(this.f108486ad.getUrlForEffect()) && !TextUtils.isEmpty(this.f108486ad.getUrlForAction())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!this.f108486ad.isWXCanvasAd() && !this.f108486ad.isWXMINIProgramOrWXMINIGameProductType()) {
                if (z16 && !TextUtils.isEmpty(this.f108486ad.getUrlForLandingPage())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (adClickLocationParams.isValidForCarouselAd(this.f108486ad)) {
                    if (z16 && !TextUtils.isEmpty(this.f108486ad.getUrlForLandingPage(adClickLocationParams))) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
            }
            if (z16 && !TextUtils.isEmpty(this.f108486ad.getUrlForImpression()) && !TextUtils.isEmpty(this.f108486ad.getUrlForClick())) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (adClickLocationParams.isValidForCarouselAd(this.f108486ad)) {
                if (!z17 || TextUtils.isEmpty(this.f108486ad.getUrlForClick(adClickLocationParams))) {
                    return false;
                }
                return true;
            }
            return z17;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@Nullable Parcel parcel, int i3) {
            String str;
            if (parcel == null) {
                GdtLog.e(GdtHandler.TAG, "writeToParcel error");
                return;
            }
            parcel.writeParcelable(this.f108486ad, i3);
            parcel.writeByte(this.reportForClick ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.sceneID);
            parcel.writeInt(this.componentID);
            parcel.writeByte(this.appAutoDownload ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.videoCeilingSupportedIfNotInstalled ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.videoCeilingSupportedIfInstalled ? (byte) 1 : (byte) 0);
            parcel.writeString(this.widthHeightRatioOfVideoCeiling);
            parcel.writeByte(this.videoLoop ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.videoStartPositionMillis);
            parcel.writeByte(this.directPlay ? (byte) 1 : (byte) 0);
            parcel.writeString(this.antiSpamParams);
            parcel.writeBundle(this.extra);
            JSONObject jSONObject = this.antiSpamParamsForClick;
            if (jSONObject != null && !JSONObject.NULL.equals(jSONObject)) {
                str = this.antiSpamParamsForClick.toString();
            } else {
                str = null;
            }
            parcel.writeString(str);
        }

        protected Options(@Nullable Parcel parcel) {
            this.reportForClick = true;
            this.sceneID = Integer.MIN_VALUE;
            this.componentID = Integer.MIN_VALUE;
            this.appAutoDownload = false;
            this.videoCeilingSupportedIfNotInstalled = false;
            this.videoCeilingSupportedIfInstalled = false;
            this.videoLoop = false;
            this.videoStartPositionMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            this.directPlay = false;
            this.antiSpamParams = null;
            this.antiSpamParamsForClick = null;
            this.indexOfCarouselAd = Integer.MIN_VALUE;
            this.indexOfMDPA = Integer.MIN_VALUE;
            this.useVerticalTransitionBetweenActivities = false;
            this.startActivityRequestCode = Integer.MIN_VALUE;
            if (parcel == null) {
                GdtLog.e(GdtHandler.TAG, "Options(Parcel in) error");
                return;
            }
            this.f108486ad = (GdtAd) parcel.readParcelable(GdtAd.class.getClassLoader());
            this.reportForClick = parcel.readByte() != 0;
            this.sceneID = parcel.readInt();
            this.componentID = parcel.readInt();
            this.appAutoDownload = parcel.readByte() != 0;
            this.videoCeilingSupportedIfNotInstalled = parcel.readByte() != 0;
            this.videoCeilingSupportedIfInstalled = parcel.readByte() != 0;
            this.widthHeightRatioOfVideoCeiling = parcel.readString();
            this.videoLoop = parcel.readByte() != 0;
            this.videoStartPositionMillis = parcel.readLong();
            this.directPlay = parcel.readByte() != 0;
            this.antiSpamParams = parcel.readString();
            this.extra = parcel.readBundle();
            try {
                this.antiSpamParamsForClick = new JSONObject(parcel.readString());
            } catch (Throwable th5) {
                GdtLog.e(GdtHandler.TAG, "Options(Parcel in)", th5);
            }
        }
    }
}
