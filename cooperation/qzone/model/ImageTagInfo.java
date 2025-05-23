package cooperation.qzone.model;

import NS_MOBILE_FEEDS.stPhotoTag;
import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ImageTagInfo implements Parcelable {
    public static final Parcelable.Creator<ImageTagInfo> CREATOR = new Parcelable.Creator<ImageTagInfo>() { // from class: cooperation.qzone.model.ImageTagInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageTagInfo createFromParcel(Parcel parcel) {
            return new ImageTagInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageTagInfo[] newArray(int i3) {
            return new ImageTagInfo[i3];
        }
    };
    private static String sDbKey;
    public int appId;
    public String content;
    public int direction;
    public int patternId;
    public String poiTagStreet;
    public String resTraceInfo;
    public int resourceId;
    public String tagId;
    public int type;
    public int xScale;
    public int yScale;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Columns {
        public static final String DATA = "data";
        public static final String KEY = "key";
    }

    public static ArrayList<stPhotoTag> ImageTagInfoConvertTostPhotoTag(ArrayList<ImageTagInfo> arrayList) {
        ArrayList<stPhotoTag> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<ImageTagInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                ImageTagInfo next = it.next();
                if (next != null) {
                    arrayList2.add(new stPhotoTag(next.type, next.content, next.tagId, next.xScale, next.yScale, next.direction, next.poiTagStreet));
                }
            }
        }
        return arrayList2;
    }

    public static String getDbKey() {
        return sDbKey;
    }

    public static void setDbKey(String str) {
        if (str == null) {
            str = "";
        }
        sDbKey = str;
    }

    public static ArrayList<ImageTagInfo> stPhotoTagConvertToImageTagInfo(ArrayList<stPhotoTag> arrayList) {
        ArrayList<ImageTagInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<stPhotoTag> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new ImageTagInfo(it.next()));
            }
        }
        return arrayList2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void writeTo(ContentValues contentValues) {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put("key", sDbKey);
        contentValues.put("data", marshall);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.type);
        parcel.writeString(this.content);
        parcel.writeString(this.tagId);
        parcel.writeInt(this.appId);
        parcel.writeInt(this.resourceId);
        parcel.writeInt(this.patternId);
        parcel.writeInt(this.xScale);
        parcel.writeInt(this.yScale);
        parcel.writeInt(this.direction);
        parcel.writeString(this.poiTagStreet);
        parcel.writeString(this.resTraceInfo);
    }

    public ImageTagInfo() {
        this.type = 0;
        this.tagId = "";
        this.direction = 2;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ImageTagInfo m471clone() {
        ImageTagInfo imageTagInfo = new ImageTagInfo();
        imageTagInfo.type = this.type;
        imageTagInfo.content = this.content;
        imageTagInfo.tagId = this.tagId;
        imageTagInfo.appId = this.appId;
        imageTagInfo.resourceId = this.resourceId;
        imageTagInfo.patternId = this.patternId;
        imageTagInfo.xScale = this.xScale;
        imageTagInfo.yScale = this.yScale;
        imageTagInfo.direction = this.direction;
        imageTagInfo.poiTagStreet = this.poiTagStreet;
        imageTagInfo.resTraceInfo = this.resTraceInfo;
        return imageTagInfo;
    }

    public ImageTagInfo(stPhotoTag stphototag) {
        this.type = 0;
        this.tagId = "";
        this.direction = 2;
        if (stphototag != null) {
            this.type = stphototag.type;
            this.content = stphototag.content;
            this.tagId = stphototag.tag_id;
            this.xScale = (int) stphototag.x_scale;
            this.yScale = (int) stphototag.y_scale;
            this.direction = stphototag.direction;
            this.poiTagStreet = stphototag.poiTagStreet;
        }
    }

    ImageTagInfo(Parcel parcel) {
        this.type = 0;
        this.tagId = "";
        this.direction = 2;
        this.type = parcel.readInt();
        this.content = parcel.readString();
        this.tagId = parcel.readString();
        this.appId = parcel.readInt();
        this.resourceId = parcel.readInt();
        this.patternId = parcel.readInt();
        this.xScale = parcel.readInt();
        this.yScale = parcel.readInt();
        this.direction = parcel.readInt();
        this.poiTagStreet = parcel.readString();
        this.resTraceInfo = parcel.readString();
    }
}
