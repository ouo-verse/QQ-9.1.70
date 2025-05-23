package cooperation.qzone.model;

import NS_MOBILE_FEEDS.cell_colorful_tail;
import NS_MOBILE_FEEDS.s_tail_color;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class CellColorfulTail implements Parcelable {
    public static final Parcelable.Creator<CellColorfulTail> CREATOR = new Parcelable.Creator<CellColorfulTail>() { // from class: cooperation.qzone.model.CellColorfulTail.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellColorfulTail createFromParcel(Parcel parcel) {
            return new CellColorfulTail(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellColorfulTail[] newArray(int i3) {
            return new CellColorfulTail[i3];
        }
    };
    public String actionUrl;
    public TailColor brightStyle;
    public TailColor darkStyle;
    public String desc;
    public String name;
    public HashMap<String, String> reportParam = new HashMap<>();
    public int type;
    public String usedCount;

    public CellColorfulTail() {
    }

    public static CellColorfulTail create(cell_colorful_tail cell_colorful_tailVar) {
        if (cell_colorful_tailVar == null) {
            return null;
        }
        CellColorfulTail cellColorfulTail = new CellColorfulTail();
        cellColorfulTail.actionUrl = cell_colorful_tailVar.action_url;
        cellColorfulTail.name = cell_colorful_tailVar.name;
        cellColorfulTail.desc = cell_colorful_tailVar.desc;
        TailColor tailColor = new TailColor();
        cellColorfulTail.brightStyle = tailColor;
        s_tail_color s_tail_colorVar = cell_colorful_tailVar.bright_style;
        if (s_tail_colorVar != null) {
            tailColor.token = s_tail_colorVar.token;
            tailColor.backgroundColor = s_tail_colorVar.background_color;
            tailColor.textColor = s_tail_colorVar.text_color;
        }
        TailColor tailColor2 = new TailColor();
        cellColorfulTail.darkStyle = tailColor2;
        s_tail_color s_tail_colorVar2 = cell_colorful_tailVar.dark_style;
        if (s_tail_colorVar2 != null) {
            tailColor2.token = s_tail_colorVar2.token;
            tailColor2.textColor = s_tail_colorVar2.text_color;
            tailColor2.backgroundColor = s_tail_colorVar2.background_color;
        }
        cellColorfulTail.type = cell_colorful_tailVar.type;
        cellColorfulTail.reportParam.putAll(cell_colorful_tailVar.report_param);
        cellColorfulTail.usedCount = cell_colorful_tailVar.used_count;
        return cellColorfulTail;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        return "name:" + this.name + ", desc:" + this.desc + ", actionUrl:" + this.actionUrl + ",type:" + this.type + ",usedCount:" + this.usedCount;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.name);
        parcel.writeString(this.desc);
        parcel.writeParcelable(this.brightStyle, i3);
        parcel.writeParcelable(this.darkStyle, i3);
        parcel.writeInt(this.type);
        parcel.writeString(this.usedCount);
    }

    protected CellColorfulTail(Parcel parcel) {
        this.actionUrl = parcel.readString();
        this.name = parcel.readString();
        this.desc = parcel.readString();
        this.brightStyle = (TailColor) parcel.readParcelable(TailColor.class.getClassLoader());
        this.darkStyle = (TailColor) parcel.readParcelable(TailColor.class.getClassLoader());
        this.type = parcel.readInt();
        this.usedCount = parcel.readString();
    }
}
