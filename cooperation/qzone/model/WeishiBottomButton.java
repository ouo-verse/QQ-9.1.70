package cooperation.qzone.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WeishiBottomButton implements Parcelable {
    public static final Parcelable.Creator<WeishiBottomButton> CREATOR = new Parcelable.Creator<WeishiBottomButton>() { // from class: cooperation.qzone.model.WeishiBottomButton.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiBottomButton createFromParcel(Parcel parcel) {
            return new WeishiBottomButton(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiBottomButton[] newArray(int i3) {
            return new WeishiBottomButton[i3];
        }
    };
    public int actionType;
    public String actionUrl;
    public int appearTime;
    public String buttonBackgroundImg;
    public String buttonIcon;
    public String buttonImg;
    public String button_text;
    public int durationTime;
    public HashMap<Integer, Integer> stMapABTest;

    public WeishiBottomButton() {
        this.button_text = "";
        this.actionUrl = "";
        this.buttonImg = "";
        this.buttonBackgroundImg = "";
        this.buttonIcon = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.button_text);
        parcel.writeInt(this.actionType);
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.buttonImg);
        parcel.writeString(this.buttonBackgroundImg);
        parcel.writeString(this.buttonIcon);
        parcel.writeInt(this.appearTime);
        parcel.writeInt(this.durationTime);
        Bundle bundle = new Bundle();
        bundle.putSerializable("stMapABTest", this.stMapABTest);
        parcel.writeBundle(bundle);
    }

    public WeishiBottomButton(String str, int i3, String str2, String str3, String str4, String str5, HashMap<Integer, Integer> hashMap, int i16, int i17) {
        this.button_text = str;
        this.actionType = i3;
        this.actionUrl = str2;
        this.buttonImg = str3;
        this.buttonBackgroundImg = str4;
        this.buttonIcon = str5;
        this.stMapABTest = hashMap;
        this.appearTime = i16;
        this.durationTime = i17;
    }

    protected WeishiBottomButton(Parcel parcel) {
        this.button_text = "";
        this.actionUrl = "";
        this.buttonImg = "";
        this.buttonBackgroundImg = "";
        this.buttonIcon = "";
        this.button_text = parcel.readString();
        this.actionType = parcel.readInt();
        this.actionUrl = parcel.readString();
        this.buttonImg = parcel.readString();
        this.buttonBackgroundImg = parcel.readString();
        this.buttonIcon = parcel.readString();
        this.appearTime = parcel.readInt();
        this.durationTime = parcel.readInt();
        this.stMapABTest = (HashMap) parcel.readBundle().getSerializable("stMapABTest");
    }
}
