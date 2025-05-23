package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_pic_text;
import NS_MOBILE_FEEDS.st_pic_text;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes39.dex */
public class CellPicTextInfo implements SmartParcelable {
    public static final String PICTEXT_TAB_LEFT = "pic_text_left";
    public static final String PICTEXT_TAB_RIGHT = "pic_text_right";

    @NeedParcel
    public int dataNum;

    @NeedParcel
    public ArrayList<PicText> picTexts;
    public String uniKeyLeft;
    public String uniKeyRight;

    public void readFrom(Parcel parcel) {
        this.dataNum = parcel.readInt();
        this.picTexts = ParcelableWrapper.createArrayListFromParcel(parcel);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellPicTextInfo {\n");
        sb5.append("dataNum: ");
        sb5.append(this.dataNum);
        sb5.append("\n");
        if (this.picTexts != null) {
            for (int i3 = 0; i3 < this.picTexts.size(); i3++) {
                sb5.append("picTexts[");
                sb5.append(i3);
                sb5.append("]: ");
                sb5.append(this.picTexts.get(i3).toString());
                sb5.append("\n");
            }
        }
        if (!TextUtils.isEmpty(this.uniKeyLeft)) {
            sb5.append("uniKeyLeft: ");
            sb5.append(this.uniKeyLeft);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.uniKeyRight)) {
            sb5.append("uniKeyRight: ");
            sb5.append(this.uniKeyRight);
            sb5.append("\n");
        }
        sb5.append("}");
        return sb5.toString();
    }

    public void writeToParcel(Parcel parcel) {
        parcel.writeInt(this.dataNum);
        ParcelableWrapper.writeArrayListToParcel(parcel, 0, this.picTexts);
    }

    public static CellPicTextInfo create(l lVar) {
        if (lVar == null || lVar.f50352g == null) {
            return null;
        }
        CellPicTextInfo cellPicTextInfo = new CellPicTextInfo();
        cell_pic_text cell_pic_textVar = lVar.f50352g;
        cellPicTextInfo.dataNum = cell_pic_textVar.data_num;
        if (cell_pic_textVar.data_list != null) {
            cellPicTextInfo.picTexts = new ArrayList<>();
            Iterator<st_pic_text> it = lVar.f50352g.data_list.iterator();
            while (it.hasNext()) {
                cellPicTextInfo.picTexts.add(com.qzone.proxy.feedcomponent.util.e.l(it.next()));
            }
        }
        return cellPicTextInfo;
    }
}
