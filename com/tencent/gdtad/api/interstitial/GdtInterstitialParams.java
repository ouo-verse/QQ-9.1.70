package com.tencent.gdtad.api.interstitial;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.GdtAdParams;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class GdtInterstitialParams extends GdtAdParams implements Parcelable {
    public static final Parcelable.Creator<GdtInterstitialParams> CREATOR = new a();
    static final int STYLE_DEFAULT = 0;
    static final int STYLE_LARGE = 1;
    private static final String TAG = "GdtInterstitialParams";
    public String adInfoJson;

    @Nullable
    JSONObject antiSpamParamsForDisplayOnReportServer;

    @Nullable
    public GdtHandler.Options clickOptions;
    int height;
    public boolean isRenderTypeKuikly;
    public int orientation;
    int width;
    public boolean windowTranslucentStatus;

    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<GdtInterstitialParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GdtInterstitialParams createFromParcel(Parcel parcel) {
            return new GdtInterstitialParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GdtInterstitialParams[] newArray(int i3) {
            return new GdtInterstitialParams[i3];
        }
    }

    public GdtInterstitialParams() {
        this.orientation = Integer.MIN_VALUE;
        this.windowTranslucentStatus = false;
        this.adInfoJson = "";
        this.isRenderTypeKuikly = false;
        this.width = Integer.MIN_VALUE;
        this.height = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canShow() {
        if (isValid() && this.clickOptions.isValid()) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @android.support.annotation.Nullable
    public String getTraceId() {
        GdtAd gdtAd;
        if (!isValid() || (gdtAd = this.clickOptions.f108486ad) == null || !gdtAd.isValid()) {
            return null;
        }
        return this.clickOptions.f108486ad.getTraceId();
    }

    @Override // com.tencent.gdtad.api.GdtAdParams
    public boolean isValid() {
        if (this.clickOptions != null && this.orientation != Integer.MIN_VALUE) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@android.support.annotation.Nullable Parcel parcel, int i3) {
        String str;
        if (parcel == null) {
            GdtLog.e(TAG, "writeToParcel error");
            return;
        }
        JSONObject jSONObject = this.antiSpamParamsForDisplayOnReportServer;
        if (jSONObject != null && !JSONObject.NULL.equals(jSONObject)) {
            str = this.antiSpamParamsForDisplayOnReportServer.toString();
        } else {
            str = null;
        }
        parcel.writeString(str);
        parcel.writeParcelable(this.clickOptions, i3);
        parcel.writeInt(this.orientation);
        parcel.writeByte(this.windowTranslucentStatus ? (byte) 1 : (byte) 0);
    }

    protected GdtInterstitialParams(@android.support.annotation.Nullable Parcel parcel) {
        this.orientation = Integer.MIN_VALUE;
        this.windowTranslucentStatus = false;
        this.adInfoJson = "";
        this.isRenderTypeKuikly = false;
        this.width = Integer.MIN_VALUE;
        this.height = Integer.MIN_VALUE;
        if (parcel == null) {
            GdtLog.e(TAG, "GdtInterstitialParams(Parcel in) error");
            return;
        }
        String readString = parcel.readString();
        if (!TextUtils.isEmpty(readString)) {
            try {
                this.antiSpamParamsForDisplayOnReportServer = new JSONObject(readString);
            } catch (Throwable th5) {
                AdLog.e(TAG, "GdtInterstitialParams(Parcel in)", th5);
            }
        }
        this.clickOptions = (GdtHandler.Options) parcel.readParcelable(GdtHandler.Options.class.getClassLoader());
        this.orientation = parcel.readInt();
        this.windowTranslucentStatus = parcel.readByte() != 0;
    }
}
