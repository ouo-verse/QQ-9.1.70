package com.heytap.databaseengine.model.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.model.SportHealthData;
import com.heytap.databaseengine.model.UserInfo;

@Keep
/* loaded from: classes2.dex */
public class UserInfoProxy extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<UserInfoProxy> CREATOR = new Parcelable.Creator<UserInfoProxy>() { // from class: com.heytap.databaseengine.model.proxy.UserInfoProxy.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfoProxy createFromParcel(Parcel parcel) {
            return new UserInfoProxy(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfoProxy[] newArray(int i3) {
            return new UserInfoProxy[i3];
        }
    };
    private String userName;

    public UserInfoProxy(@NonNull UserInfo userInfo) {
        this.userName = userInfo.getUserName();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getUserName() {
        return this.userName;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "UserInfoProxy:\nuserName=" + getUserName() + '\n';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.userName);
    }

    protected UserInfoProxy(Parcel parcel) {
        this.userName = parcel.readString();
    }
}
