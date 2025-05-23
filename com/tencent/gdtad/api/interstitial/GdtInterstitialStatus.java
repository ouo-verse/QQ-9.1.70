package com.tencent.gdtad.api.interstitial;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.common.util.WebViewConstants;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtInterstitialStatus implements Parcelable {
    public static final Parcelable.Creator<GdtInterstitialStatus> CREATOR = new a();
    static final int REASON_CLICK = 1;
    static final int REASON_CLOSE = 2;
    public static final int REASON_ERROR = 4;
    static final int REASON_INVOKED = 3;
    static final int VIDEO_STATUS_ENDED = 5;
    static final int VIDEO_STATUS_ERROR = 6;
    static final int VIDEO_STATUS_LOADED = 2;
    static final int VIDEO_STATUS_LOADING = 1;
    static final int VIDEO_STATUS_PAUSED = 4;
    static final int VIDEO_STATUS_PLAYING = 3;
    static final int VIDEO_STATUS_UNKNOWN = 0;
    public int activityStatus;
    public boolean arkAppDownloaded;
    public boolean arkScriptLoaded;
    public boolean arkViewLoaded;
    public boolean arkViewLoadedReported;
    public int closeError;
    public int closeErrorForArk;
    public int closeErrorForArkScript;
    public int closeReason;
    public boolean exposed;
    public boolean jsCoreDownloaded;
    long startToShowTimeMillis;
    public int videoStatus;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<GdtInterstitialStatus> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GdtInterstitialStatus createFromParcel(@android.support.annotation.Nullable Parcel parcel) {
            return new GdtInterstitialStatus(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GdtInterstitialStatus[] newArray(int i3) {
            return new GdtInterstitialStatus[i3];
        }
    }

    public GdtInterstitialStatus() {
        this.activityStatus = 0;
        this.arkAppDownloaded = false;
        this.jsCoreDownloaded = false;
        this.arkViewLoaded = false;
        this.arkViewLoadedReported = false;
        this.arkScriptLoaded = false;
        this.exposed = false;
        this.closeReason = Integer.MIN_VALUE;
        this.closeError = Integer.MIN_VALUE;
        this.closeErrorForArk = Integer.MIN_VALUE;
        this.closeErrorForArkScript = Integer.MIN_VALUE;
        this.videoStatus = 0;
        this.startToShowTimeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDurationBetweenStartAndNow() {
        if (this.startToShowTimeMillis == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - this.startToShowTimeMillis;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@android.support.annotation.Nullable Parcel parcel, int i3) {
        if (parcel == null) {
            return;
        }
        parcel.writeInt(this.activityStatus);
        parcel.writeByte(this.arkAppDownloaded ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.jsCoreDownloaded ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.arkViewLoaded ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.arkViewLoadedReported ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.arkScriptLoaded ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.exposed ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.closeReason);
        parcel.writeInt(this.closeError);
        parcel.writeInt(this.closeErrorForArk);
        parcel.writeInt(this.closeErrorForArkScript);
        parcel.writeInt(this.videoStatus);
        parcel.writeLong(this.startToShowTimeMillis);
    }

    protected GdtInterstitialStatus(@Nullable Parcel parcel) {
        this.activityStatus = 0;
        this.arkAppDownloaded = false;
        this.jsCoreDownloaded = false;
        this.arkViewLoaded = false;
        this.arkViewLoadedReported = false;
        this.arkScriptLoaded = false;
        this.exposed = false;
        this.closeReason = Integer.MIN_VALUE;
        this.closeError = Integer.MIN_VALUE;
        this.closeErrorForArk = Integer.MIN_VALUE;
        this.closeErrorForArkScript = Integer.MIN_VALUE;
        this.videoStatus = 0;
        this.startToShowTimeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        if (parcel == null) {
            return;
        }
        this.activityStatus = parcel.readInt();
        this.arkAppDownloaded = parcel.readByte() != 0;
        this.jsCoreDownloaded = parcel.readByte() != 0;
        this.arkViewLoaded = parcel.readByte() != 0;
        this.arkViewLoadedReported = parcel.readByte() != 0;
        this.arkScriptLoaded = parcel.readByte() != 0;
        this.exposed = parcel.readByte() != 0;
        this.closeReason = parcel.readInt();
        this.closeError = parcel.readInt();
        this.closeErrorForArk = parcel.readInt();
        this.closeErrorForArkScript = parcel.readInt();
        this.videoStatus = parcel.readInt();
        this.startToShowTimeMillis = parcel.readLong();
    }
}
