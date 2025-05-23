package com.heytap.databaseengine.apiv2.device.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class GameDataWrapper implements Parcelable {
    public static final Parcelable.Creator<GameDataWrapper> CREATOR = new Parcelable.Creator<GameDataWrapper>() { // from class: com.heytap.databaseengine.apiv2.device.game.model.GameDataWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameDataWrapper createFromParcel(Parcel parcel) {
            return new GameDataWrapper(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameDataWrapper[] newArray(int i3) {
            return new GameDataWrapper[i3];
        }
    };
    private int countDown;
    private int killType;

    public GameDataWrapper() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCountDown() {
        return this.countDown;
    }

    public int getKillType() {
        return this.killType;
    }

    public void setCountDown(int i3) {
        this.countDown = i3;
    }

    public void setKillType(int i3) {
        this.killType = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.killType);
        parcel.writeInt(this.countDown);
    }

    protected GameDataWrapper(Parcel parcel) {
        this.killType = parcel.readInt();
        this.countDown = parcel.readInt();
    }
}
