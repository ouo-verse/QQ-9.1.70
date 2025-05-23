package cooperation.qzone.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ForwardGroupAlbumBean implements Parcelable {
    public static final Parcelable.Creator<ForwardGroupAlbumBean> CREATOR = new Parcelable.Creator<ForwardGroupAlbumBean>() { // from class: cooperation.qzone.model.ForwardGroupAlbumBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ForwardGroupAlbumBean createFromParcel(Parcel parcel) {
            return new ForwardGroupAlbumBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ForwardGroupAlbumBean[] newArray(int i3) {
            return new ForwardGroupAlbumBean[i3];
        }
    };
    public String albumId;
    public String albumName;
    public Context context;
    public String groupId;
    public boolean isSingleMedia;
    public List<ForwardMediaInfo> mediaList;

    public ForwardGroupAlbumBean() {
        this.context = null;
        this.isSingleMedia = false;
        this.mediaList = new ArrayList();
        this.groupId = "";
        this.albumId = "";
        this.albumName = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByte(this.isSingleMedia ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.mediaList);
        parcel.writeString(this.groupId);
        parcel.writeString(this.albumId);
        parcel.writeString(this.albumName);
    }

    protected ForwardGroupAlbumBean(Parcel parcel) {
        this.context = null;
        this.isSingleMedia = false;
        this.mediaList = new ArrayList();
        this.groupId = "";
        this.albumId = "";
        this.albumName = "";
        this.isSingleMedia = parcel.readByte() != 0;
        this.mediaList = parcel.createTypedArrayList(ForwardMediaInfo.CREATOR);
        this.groupId = parcel.readString();
        this.albumId = parcel.readString();
        this.albumName = parcel.readString();
    }
}
