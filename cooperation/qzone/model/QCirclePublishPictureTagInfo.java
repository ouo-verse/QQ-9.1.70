package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes28.dex */
public class QCirclePublishPictureTagInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<QCirclePublishPictureTagInfo> CREATOR = new Parcelable.Creator<QCirclePublishPictureTagInfo>() { // from class: cooperation.qzone.model.QCirclePublishPictureTagInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QCirclePublishPictureTagInfo createFromParcel(Parcel parcel) {
            QCirclePublishPictureTagInfo qCirclePublishPictureTagInfo = new QCirclePublishPictureTagInfo();
            qCirclePublishPictureTagInfo.picId = parcel.readString();
            qCirclePublishPictureTagInfo.picTags = parcel.readArrayList(String.class.getClassLoader());
            qCirclePublishPictureTagInfo.materialId = parcel.readString();
            qCirclePublishPictureTagInfo.filterId = parcel.readString();
            qCirclePublishPictureTagInfo.exif = (HashMap) parcel.readSerializable();
            return qCirclePublishPictureTagInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QCirclePublishPictureTagInfo[] newArray(int i3) {
            return new QCirclePublishPictureTagInfo[i3];
        }
    };
    public HashMap<String, String> exif;
    public String picId = "";
    public ArrayList<String> picTags = new ArrayList<>();
    public String materialId = "";
    public String filterId = "";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.picId);
        parcel.writeList(this.picTags);
        parcel.writeString(this.materialId);
        parcel.writeString(this.filterId);
        parcel.writeSerializable(this.exif);
    }
}
