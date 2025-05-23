package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import cooperation.qzone.widget.RedTouchExtendButton;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DiscoverTab implements Parcelable {
    public static final Parcelable.Creator<DiscoverTab> CREATOR = new Parcelable.Creator<DiscoverTab>() { // from class: cooperation.qzone.model.DiscoverTab.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiscoverTab createFromParcel(Parcel parcel) {
            return new DiscoverTab(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiscoverTab[] newArray(int i3) {
            return new DiscoverTab[i3];
        }
    };
    public View containerView;
    public int entranceId;
    public int index;
    public boolean isSelect;
    public String name;
    public String qbossTrace;
    public RedTouchExtendButton.RedInfo redInfo;
    public RedTouchExtendButton tabView;
    public String url;
    public boolean useWnsProxy;
    public String wnsHtml;

    public DiscoverTab() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.entranceId);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeInt(this.index);
        parcel.writeParcelable(this.redInfo, 0);
        parcel.writeString(this.qbossTrace);
        parcel.writeInt(this.isSelect ? 1 : 0);
        parcel.writeInt(this.useWnsProxy ? 1 : 0);
        parcel.writeString(this.wnsHtml);
    }

    public DiscoverTab(Parcel parcel) {
        this.entranceId = parcel.readInt();
        this.name = parcel.readString();
        this.url = parcel.readString();
        this.index = parcel.readInt();
        this.redInfo = (RedTouchExtendButton.RedInfo) parcel.readParcelable(getClass().getClassLoader());
        this.qbossTrace = parcel.readString();
        this.isSelect = parcel.readInt() == 1;
        this.useWnsProxy = parcel.readInt() == 1;
        this.wnsHtml = parcel.readString();
    }
}
