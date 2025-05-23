package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_video_nagative_feedback extends JceStruct {
    static ArrayList<nagative_fb_info> cache_vecNagFbInfo = new ArrayList<>();
    public String buttonTxt;
    public String leftTitle;
    public String toastTxt;
    public ArrayList<nagative_fb_info> vecNagFbInfo;

    static {
        cache_vecNagFbInfo.add(new nagative_fb_info());
    }

    public cell_video_nagative_feedback() {
        this.vecNagFbInfo = null;
        this.leftTitle = "";
        this.buttonTxt = "";
        this.toastTxt = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecNagFbInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecNagFbInfo, 0, false);
        this.leftTitle = jceInputStream.readString(1, false);
        this.buttonTxt = jceInputStream.readString(2, false);
        this.toastTxt = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<nagative_fb_info> arrayList = this.vecNagFbInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.leftTitle;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.buttonTxt;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.toastTxt;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public cell_video_nagative_feedback(ArrayList<nagative_fb_info> arrayList, String str, String str2, String str3) {
        this.vecNagFbInfo = arrayList;
        this.leftTitle = str;
        this.buttonTxt = str2;
        this.toastTxt = str3;
    }
}
