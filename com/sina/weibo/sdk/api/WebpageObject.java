package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class WebpageObject extends MediaObject {
    public static final Parcelable.Creator<WebpageObject> CREATOR = new Parcelable.Creator<WebpageObject>() { // from class: com.sina.weibo.sdk.api.WebpageObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WebpageObject createFromParcel(Parcel parcel) {
            return new WebpageObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WebpageObject[] newArray(int i3) {
            return new WebpageObject[i3];
        }
    };
    private static final long serialVersionUID = 7142128794153927442L;
    public String defaultText;

    public WebpageObject() {
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
    }

    public WebpageObject(Parcel parcel) {
        super(parcel);
    }
}
