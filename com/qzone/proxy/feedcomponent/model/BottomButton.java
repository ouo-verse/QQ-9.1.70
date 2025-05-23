package com.qzone.proxy.feedcomponent.model;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BottomButton implements SmartParcelable {

    @NeedParcel
    public int actionType;

    @NeedParcel
    public int animation_duration;

    @NeedParcel
    public String animation_url;

    @NeedParcel
    public int appearTime;

    @NeedParcel
    public int durationTime;

    @NeedParcel
    public HashMap<String, String> extendInfo;

    @NeedParcel
    public HashMap<Integer, Integer> stMapABTest;

    @NeedParcel
    public String button_text = "";

    @NeedParcel
    public String actionUrl = "";

    @NeedParcel
    public String buttonImg = "";

    @NeedParcel
    public String buttonBackgroundImg = "";

    @NeedParcel
    public String buttonIcon = "";

    public void readFrom(Parcel parcel) {
        this.button_text = parcel.readString();
        this.actionType = parcel.readInt();
        this.actionUrl = parcel.readString();
        this.buttonImg = parcel.readString();
        this.buttonBackgroundImg = parcel.readString();
        this.buttonIcon = parcel.readString();
        this.appearTime = parcel.readInt();
        this.durationTime = parcel.readInt();
        this.animation_url = parcel.readString();
        this.animation_duration = parcel.readInt();
        Bundle readBundle = parcel.readBundle();
        this.stMapABTest = (HashMap) readBundle.getSerializable("stMapABTest");
        this.extendInfo = (HashMap) readBundle.getSerializable("extendInfo");
    }

    public String toString() {
        return "ButtomButton [button_text=" + this.button_text + ", actionType=" + this.actionType + ", actionUrl=" + this.actionUrl + ", buttonImg=" + this.buttonImg + ", buttonBackgroundImg=" + this.buttonBackgroundImg + ", buttonIcon=" + this.buttonIcon + "]";
    }

    public void writeTo(Parcel parcel) {
        parcel.writeString(this.button_text);
        parcel.writeInt(this.actionType);
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.buttonImg);
        parcel.writeString(this.buttonBackgroundImg);
        parcel.writeString(this.buttonIcon);
        parcel.writeInt(this.appearTime);
        parcel.writeInt(this.durationTime);
        parcel.writeString(this.animation_url);
        parcel.writeInt(this.animation_duration);
        Bundle bundle = new Bundle();
        bundle.putSerializable("stMapABTest", this.stMapABTest);
        bundle.putSerializable("extendInfo", this.extendInfo);
        parcel.writeBundle(bundle);
    }
}
