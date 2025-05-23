package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_corner_adv extends JceStruct implements Cloneable {
    public int actiontype;
    public String actionurl;
    public int adv_appear_time;
    public int adv_hold_time;
    public s_picdata adv_info;
    public int feedback_appear_time;
    public s_picdata feedback_info;
    public s_picdata gif_info;
    public int min_video_time;
    public boolean show_corner_adv;
    static s_picdata cache_gif_info = new s_picdata();
    static s_picdata cache_feedback_info = new s_picdata();
    static s_picdata cache_adv_info = new s_picdata();

    public cell_corner_adv() {
        this.gif_info = null;
        this.feedback_info = null;
        this.adv_info = null;
        this.feedback_appear_time = 0;
        this.adv_appear_time = 0;
        this.adv_hold_time = 0;
        this.min_video_time = 0;
        this.actiontype = 0;
        this.actionurl = "";
        this.show_corner_adv = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.gif_info = (s_picdata) jceInputStream.read((JceStruct) cache_gif_info, 0, false);
        this.feedback_info = (s_picdata) jceInputStream.read((JceStruct) cache_feedback_info, 1, false);
        this.adv_info = (s_picdata) jceInputStream.read((JceStruct) cache_adv_info, 2, false);
        this.feedback_appear_time = jceInputStream.read(this.feedback_appear_time, 3, false);
        this.adv_appear_time = jceInputStream.read(this.adv_appear_time, 4, false);
        this.adv_hold_time = jceInputStream.read(this.adv_hold_time, 5, false);
        this.min_video_time = jceInputStream.read(this.min_video_time, 6, false);
        this.actiontype = jceInputStream.read(this.actiontype, 7, false);
        this.actionurl = jceInputStream.readString(8, false);
        this.show_corner_adv = jceInputStream.read(this.show_corner_adv, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_picdata s_picdataVar = this.gif_info;
        if (s_picdataVar != null) {
            jceOutputStream.write((JceStruct) s_picdataVar, 0);
        }
        s_picdata s_picdataVar2 = this.feedback_info;
        if (s_picdataVar2 != null) {
            jceOutputStream.write((JceStruct) s_picdataVar2, 1);
        }
        s_picdata s_picdataVar3 = this.adv_info;
        if (s_picdataVar3 != null) {
            jceOutputStream.write((JceStruct) s_picdataVar3, 2);
        }
        jceOutputStream.write(this.feedback_appear_time, 3);
        jceOutputStream.write(this.adv_appear_time, 4);
        jceOutputStream.write(this.adv_hold_time, 5);
        jceOutputStream.write(this.min_video_time, 6);
        jceOutputStream.write(this.actiontype, 7);
        String str = this.actionurl;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
        jceOutputStream.write(this.show_corner_adv, 9);
    }

    public cell_corner_adv(s_picdata s_picdataVar, s_picdata s_picdataVar2, s_picdata s_picdataVar3, int i3, int i16, int i17, int i18, int i19, String str, boolean z16) {
        this.gif_info = s_picdataVar;
        this.feedback_info = s_picdataVar2;
        this.adv_info = s_picdataVar3;
        this.feedback_appear_time = i3;
        this.adv_appear_time = i16;
        this.adv_hold_time = i17;
        this.min_video_time = i18;
        this.actiontype = i19;
        this.actionurl = str;
        this.show_corner_adv = z16;
    }
}
