package com.tencent.qqmini.sdk.launcher.model;

import NS_MINI_INTERFACE.INTERFACE$StAppMode;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppMode implements Parcelable {
    public static final Parcelable.Creator<AppMode> CREATOR = new Parcelable.Creator<AppMode>() { // from class: com.tencent.qqmini.sdk.launcher.model.AppMode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppMode createFromParcel(Parcel parcel) {
            AppMode appMode = new AppMode();
            appMode.interMode = AppMode.isEqOne(parcel.readInt());
            appMode.authoritySilent = AppMode.isEqOne(parcel.readInt());
            appMode.keepOffPullList = AppMode.isEqOne(parcel.readInt());
            appMode.closeTopRightCapsule = AppMode.isEqOne(parcel.readInt());
            appMode.openNativeApi = AppMode.isEqOne(parcel.readInt());
            appMode.hideAppSearch = AppMode.isEqOne(parcel.readInt());
            appMode.isAppStore = AppMode.isEqOne(parcel.readInt());
            appMode.isWangKa = AppMode.isEqOne(parcel.readInt());
            appMode.interLoading = AppMode.isEqOne(parcel.readInt());
            appMode.isLimitedAccess = AppMode.isEqOne(parcel.readInt());
            appMode.isPayForFriend = AppMode.isEqOne(parcel.readInt());
            appMode.useAppInfoWhenNavigate = AppMode.isEqOne(parcel.readInt());
            appMode.disableAddToMyApp = AppMode.isEqOne(parcel.readInt());
            appMode.disableAddToMyFavor = AppMode.isEqOne(parcel.readInt());
            appMode.reloadWithFirstPageChange = AppMode.isEqOne(parcel.readInt());
            appMode.unlimitedApiRight = AppMode.isEqOne(parcel.readInt());
            appMode.disableShareToAIO = AppMode.isEqOne(parcel.readInt());
            appMode.disableShareToQZone = AppMode.isEqOne(parcel.readInt());
            appMode.disableShareToWeChat = AppMode.isEqOne(parcel.readInt());
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
    public boolean interLoading;
    public boolean interMode;
    public boolean isAppStore;
    public boolean isCustomConfigTileBarMode;
    public boolean isLimitedAccess;
    public boolean isPayForFriend;
    public boolean isWangKa;
    public boolean keepOffPullList;
    public boolean openNativeApi;
    public boolean reloadWithFirstPageChange;
    public boolean unlimitedApiRight;
    public boolean useAppInfoWhenNavigate;

    public static final int booleanToInt(boolean z16) {
        if (z16) {
            return 1;
        }
        return 0;
    }

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
            appMode.interLoading = iNTERFACE$StAppMode.interLoading.get();
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

    public static final boolean isEqOne(int i3) {
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(booleanToInt(this.interMode));
        parcel.writeInt(booleanToInt(this.authoritySilent));
        parcel.writeInt(booleanToInt(this.keepOffPullList));
        parcel.writeInt(booleanToInt(this.closeTopRightCapsule));
        parcel.writeInt(booleanToInt(this.openNativeApi));
        parcel.writeInt(booleanToInt(this.hideAppSearch));
        parcel.writeInt(booleanToInt(this.isAppStore));
        parcel.writeInt(booleanToInt(this.isWangKa));
        parcel.writeInt(booleanToInt(this.interLoading));
        parcel.writeInt(booleanToInt(this.isLimitedAccess));
        parcel.writeInt(booleanToInt(this.isPayForFriend));
        parcel.writeInt(booleanToInt(this.useAppInfoWhenNavigate));
        parcel.writeInt(booleanToInt(this.disableAddToMyApp));
        parcel.writeInt(booleanToInt(this.disableAddToMyFavor));
        parcel.writeInt(booleanToInt(this.reloadWithFirstPageChange));
        parcel.writeInt(booleanToInt(this.unlimitedApiRight));
        parcel.writeInt(booleanToInt(this.disableShareToAIO));
        parcel.writeInt(booleanToInt(this.disableShareToQZone));
        parcel.writeInt(booleanToInt(this.disableShareToWeChat));
    }
}
