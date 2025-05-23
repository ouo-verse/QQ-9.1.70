package com.tencent.qqmini.sdk.launcher.model;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qqmini.sdk.MiniSDK;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ShareData implements Parcelable {
    public static final Parcelable.Creator<ShareData> CREATOR = new Parcelable.Creator<ShareData>() { // from class: com.tencent.qqmini.sdk.launcher.model.ShareData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareData createFromParcel(Parcel parcel) {
            return new ShareData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareData[] newArray(int i3) {
            return new ShareData[i3];
        }
    };
    public static final String KEY_SHARE_RESULT = "key_share_result";
    protected static final String TAG = "ShareData";
    public boolean isLocalPic;
    protected MiniAppInfo miniAppInfo;
    public boolean needShareCallback;
    public boolean shareInMiniProcess;
    public int shareItemId;
    public int shareOrigin;
    public String sharePicPath;
    public int shareSource;
    public int shareTarget;
    public String summary;
    public String targetUrl;
    public String title;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ShareResult {
        public static final int CANCEL = 2;
        public static final int FAIL = 1;
        public static final int SUCCESS = 0;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ShareSource {
        public static final int DETAIL = 10;
        public static final int INNER_BUTTON = 11;
        public static final int MINI_APP_SHARE_FROM_PAY = 13;
        public static final int MORE_BUTTON = 12;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ShareTarget {
        public static final int FRIEND_LIST = 6;
        public static final int GUILD = 8;
        public static final int QQ = 0;
        public static final int QQ_DIRECTLY = 2;
        public static final int QZONE = 1;
        public static final int SHARE_CHAT = 5;
        public static final int UPDATABLE_MSG = 7;
        public static final int WECHAT_FRIEND = 3;
        public static final int WECHAT_MOMENTS = 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMiniAppIconUrl() {
        return this.miniAppInfo.iconUrl;
    }

    public String getMiniAppId() {
        return this.miniAppInfo.appId;
    }

    public String getMiniAppName() {
        return this.miniAppInfo.name;
    }

    public void notifyShareResult(Context context, int i3) {
        notifyShareResult(context, i3, false);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.shareSource);
        parcel.writeInt(this.shareTarget);
        parcel.writeInt(this.shareItemId);
        parcel.writeString(this.title);
        parcel.writeString(this.summary);
        parcel.writeString(this.sharePicPath);
        parcel.writeInt(this.isLocalPic ? 1 : 0);
        parcel.writeString(this.targetUrl);
        parcel.writeInt(this.needShareCallback ? 1 : 0);
        parcel.writeInt(this.shareInMiniProcess ? 1 : 0);
        parcel.writeParcelable(this.miniAppInfo, 0);
        parcel.writeInt(this.shareOrigin);
    }

    public ShareData(Parcel parcel) {
        this.shareSource = parcel.readInt();
        this.shareTarget = parcel.readInt();
        this.shareItemId = parcel.readInt();
        this.title = parcel.readString();
        this.summary = parcel.readString();
        this.sharePicPath = parcel.readString();
        this.isLocalPic = parcel.readInt() == 1;
        this.targetUrl = parcel.readString();
        this.needShareCallback = parcel.readInt() == 1;
        this.shareInMiniProcess = parcel.readInt() == 1;
        this.miniAppInfo = (MiniAppInfo) parcel.readParcelable(MiniAppInfo.class.getClassLoader());
        this.shareOrigin = parcel.readInt();
    }

    public void notifyShareResult(Context context, int i3, boolean z16) {
        if (this.needShareCallback || z16) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_SHARE_RESULT, i3);
            MiniSDK.notifyShareResult(context, this.miniAppInfo, bundle);
        }
    }
}
