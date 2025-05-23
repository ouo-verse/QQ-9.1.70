package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FeedSkin extends JceStruct {
    static ArrayList<Integer> cache_list = new ArrayList<>();
    public int iFrameRate;
    public int iItemId;
    public int iType;
    public ArrayList<Integer> lv10Numbers;
    public String strAndBgUrl;
    public String strBgColor;
    public String strFrameZip;
    public String strGradientColorBegin;
    public String strGradientColorEnd;
    public String strIosBgUrl;

    static {
        cache_list.add(0);
    }

    public FeedSkin() {
        this.iItemId = -1;
        this.iType = 0;
        this.strBgColor = "";
        this.strGradientColorBegin = "";
        this.strGradientColorEnd = "";
        this.strAndBgUrl = "";
        this.strIosBgUrl = "";
        this.strFrameZip = "";
        this.iFrameRate = 0;
        this.lv10Numbers = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, false);
        this.iType = jceInputStream.read(this.iType, 1, false);
        this.strBgColor = jceInputStream.readString(2, false);
        this.strGradientColorBegin = jceInputStream.readString(3, false);
        this.strGradientColorEnd = jceInputStream.readString(4, false);
        this.strAndBgUrl = jceInputStream.readString(5, false);
        this.strIosBgUrl = jceInputStream.readString(6, false);
        this.strFrameZip = jceInputStream.readString(7, false);
        this.iFrameRate = jceInputStream.read(this.iFrameRate, 8, false);
        this.lv10Numbers = (ArrayList) jceInputStream.read((JceInputStream) cache_list, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        jceOutputStream.write(this.iType, 1);
        String str = this.strBgColor;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.strGradientColorBegin;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.strGradientColorEnd;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.strAndBgUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.strIosBgUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        String str6 = this.strFrameZip;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        jceOutputStream.write(this.iFrameRate, 8);
        ArrayList<Integer> arrayList = this.lv10Numbers;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 9);
        }
    }

    public FeedSkin(int i3, int i16, String str, String str2, String str3, String str4, String str5, String str6, int i17, ArrayList<Integer> arrayList) {
        this.iItemId = i3;
        this.iType = i16;
        this.strBgColor = str;
        this.strGradientColorBegin = str2;
        this.strGradientColorEnd = str3;
        this.strAndBgUrl = str4;
        this.strIosBgUrl = str5;
        this.strFrameZip = str6;
        this.iFrameRate = i17;
        this.lv10Numbers = arrayList;
    }
}
