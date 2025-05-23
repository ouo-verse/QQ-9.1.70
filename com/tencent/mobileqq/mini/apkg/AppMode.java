package com.tencent.mobileqq.mini.apkg;

import NS_MINI_INTERFACE.INTERFACE$StAppMode;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppMode implements Parcelable, Serializable {
    public static final Parcelable.Creator<AppMode> CREATOR = new Parcelable.Creator<AppMode>() { // from class: com.tencent.mobileqq.mini.apkg.AppMode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppMode createFromParcel(Parcel parcel) {
            AppMode appMode = new AppMode();
            appMode.interMode = parcel.readInt() == 1;
            appMode.authoritySilent = parcel.readInt() == 1;
            appMode.keepOffPullList = parcel.readInt() == 1;
            appMode.closeTopRightCapsule = parcel.readInt() == 1;
            appMode.openNativeApi = parcel.readInt() == 1;
            appMode.hideAppSearch = parcel.readInt() == 1;
            appMode.isAppStore = parcel.readInt() == 1;
            appMode.isWangKa = parcel.readInt() == 1;
            appMode.isInterLoading = parcel.readInt() == 1;
            appMode.isLimitedAccess = parcel.readInt() == 1;
            appMode.isPayForFriend = parcel.readInt() == 1;
            appMode.useAppInfoWhenNavigate = parcel.readInt() == 1;
            appMode.disableAddToMyApp = parcel.readInt() == 1;
            appMode.disableAddToMyFavor = parcel.readInt() == 1;
            appMode.reloadWithFirstPageChange = parcel.readInt() == 1;
            appMode.unlimitedApiRight = parcel.readInt() == 1;
            appMode.disableShareToAIO = parcel.readInt() == 1;
            appMode.disableShareToQZone = parcel.readInt() == 1;
            appMode.disableShareToWeChat = parcel.readInt() == 1;
            return appMode;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppMode[] newArray(int i3) {
            return new AppMode[i3];
        }
    };
    public boolean authoritySilent;
    public boolean closeTopRightCapsule;
    public boolean disableAddToMyApp;
    public boolean disableAddToMyFavor;
    public boolean disableShareToAIO;
    public boolean disableShareToQZone;
    public boolean disableShareToWeChat;
    public boolean hideAppSearch;
    public boolean interMode;
    public boolean isAppStore;
    public boolean isInterLoading;
    public boolean isLimitedAccess;
    public boolean isPayForFriend;
    public boolean isWangKa;
    public boolean keepOffPullList;
    public boolean openNativeApi;
    public boolean reloadWithFirstPageChange;
    public boolean unlimitedApiRight;
    public boolean useAppInfoWhenNavigate;

    public static AppMode from(INTERFACE$StAppMode iNTERFACE$StAppMode) {
        AppMode appMode = new AppMode();
        if (iNTERFACE$StAppMode != null) {
            appMode.interMode = iNTERFACE$StAppMode.interMode.get();
            appMode.authoritySilent = iNTERFACE$StAppMode.authoritySilent.get();
            appMode.keepOffPullList = iNTERFACE$StAppMode.keepOffPullList.get();
            appMode.closeTopRightCapsule = iNTERFACE$StAppMode.closeTopRightCapsule.get();
            appMode.openNativeApi = iNTERFACE$StAppMode.openNativeApi.get();
            appMode.hideAppSearch = iNTERFACE$StAppMode.hideAppSearch.get();
            appMode.isAppStore = iNTERFACE$StAppMode.isAppStore.get();
            appMode.isWangKa = iNTERFACE$StAppMode.isWangKa.get();
            appMode.isInterLoading = iNTERFACE$StAppMode.interLoading.get();
            appMode.isLimitedAccess = iNTERFACE$StAppMode.isLimitedAccess.get();
            appMode.isPayForFriend = iNTERFACE$StAppMode.isPayForFriend.get();
            appMode.useAppInfoWhenNavigate = iNTERFACE$StAppMode.useAppInfoWhenNavigate.get();
            appMode.disableAddToMyApp = iNTERFACE$StAppMode.disableAddToMyApp.get();
            appMode.disableAddToMyFavor = iNTERFACE$StAppMode.disableAddToMyFavor.get();
            appMode.reloadWithFirstPageChange = iNTERFACE$StAppMode.reloadWithFirstPageChange.get();
            appMode.unlimitedApiRight = iNTERFACE$StAppMode.unlimitedApiRight.get();
            appMode.disableShareToAIO = iNTERFACE$StAppMode.disableShareToAIO.get();
            appMode.disableShareToQZone = iNTERFACE$StAppMode.disableShareToQZone.get();
            appMode.disableShareToWeChat = iNTERFACE$StAppMode.disableShareToWeChat.get();
        }
        return appMode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.interMode ? 1 : 0);
        parcel.writeInt(this.authoritySilent ? 1 : 0);
        parcel.writeInt(this.keepOffPullList ? 1 : 0);
        parcel.writeInt(this.closeTopRightCapsule ? 1 : 0);
        parcel.writeInt(this.openNativeApi ? 1 : 0);
        parcel.writeInt(this.hideAppSearch ? 1 : 0);
        parcel.writeInt(this.isAppStore ? 1 : 0);
        parcel.writeInt(this.isWangKa ? 1 : 0);
        parcel.writeInt(this.isInterLoading ? 1 : 0);
        parcel.writeInt(this.isLimitedAccess ? 1 : 0);
        parcel.writeInt(this.isPayForFriend ? 1 : 0);
        parcel.writeInt(this.useAppInfoWhenNavigate ? 1 : 0);
        parcel.writeInt(this.disableAddToMyApp ? 1 : 0);
        parcel.writeInt(this.disableAddToMyFavor ? 1 : 0);
        parcel.writeInt(this.reloadWithFirstPageChange ? 1 : 0);
        parcel.writeInt(this.unlimitedApiRight ? 1 : 0);
        parcel.writeInt(this.disableShareToAIO ? 1 : 0);
        parcel.writeInt(this.disableShareToQZone ? 1 : 0);
        parcel.writeInt(this.disableShareToWeChat ? 1 : 0);
    }
}
