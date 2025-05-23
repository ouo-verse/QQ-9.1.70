package com.tencent.qqmini.sdk.launcher.ui;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MoreItem implements Parcelable {
    public static final int ABOUT = 5;
    public static final int COMPLAINT = 6;
    public static final Parcelable.Creator<MoreItem> CREATOR = new Parcelable.Creator<MoreItem>() { // from class: com.tencent.qqmini.sdk.launcher.ui.MoreItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MoreItem createFromParcel(Parcel parcel) {
            return new MoreItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MoreItem[] newArray(int i3) {
            return new MoreItem[i3];
        }
    };
    public static final int DEBUG = 7;
    public static final int EXPORT_LOG = 13;
    public static final int FAVORITE = 10;
    private static final int FIRST_BUILTIN_ITEM = 1;
    public static final int MAX_EXT_ITEM_ID = 200;
    public static final int MIN_EXT_ITEM_ID = 100;
    public static final int MONITOR = 8;
    public static final int QQ_FAVORITE = 12;
    public static final int RESTART = 9;
    public static final int SHARE_QQ = 1;
    public static final int SHARE_QZONE = 2;
    public static final int SHARE_WX_FRIEND = 3;
    public static final int SHARE_WX_MOMENT = 4;
    public static final int SHORTCUT = 11;
    public int drawable;

    /* renamed from: id, reason: collision with root package name */
    public int f348090id;
    public boolean shareInMiniProcess;
    public String text;
    public boolean visible;

    public MoreItem() {
        this.visible = true;
    }

    public static boolean isValidExtendedItemId(int i3) {
        if (i3 >= 100 && i3 <= 200) {
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
        parcel.writeInt(this.f348090id);
        parcel.writeInt(this.visible ? 1 : 0);
        parcel.writeInt(this.drawable);
        parcel.writeString(this.text);
        parcel.writeInt(this.shareInMiniProcess ? 1 : 0);
    }

    public MoreItem(Parcel parcel) {
        this.f348090id = parcel.readInt();
        this.visible = parcel.readInt() == 1;
        this.drawable = parcel.readInt();
        this.text = parcel.readString();
        this.shareInMiniProcess = parcel.readInt() == 1;
    }
}
