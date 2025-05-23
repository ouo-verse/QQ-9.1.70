package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_qboss_psv_adv extends JceStruct {
    static Map<String, String> cache_extendinfo;
    static s_picdata cache_float_picdata;
    public int actiontype;
    public String actionurl;
    public s_picdata backgd_picdata;
    public String btnText;
    public long countDownTime;
    public Map<String, String> extendinfo;
    public s_picdata float_picdata;
    public int markType;
    public int mediatype;
    public s_picdata picdata;
    public int psvAdvType;
    public String summary;
    public String title;
    static s_picdata cache_picdata = new s_picdata();
    static s_picdata cache_backgd_picdata = new s_picdata();

    static {
        HashMap hashMap = new HashMap();
        cache_extendinfo = hashMap;
        hashMap.put("", "");
        cache_float_picdata = new s_picdata();
    }

    public cell_qboss_psv_adv() {
        this.mediatype = 0;
        this.picdata = null;
        this.title = "";
        this.summary = "";
        this.countDownTime = 0L;
        this.backgd_picdata = null;
        this.psvAdvType = 0;
        this.markType = 0;
        this.btnText = "";
        this.actiontype = 0;
        this.actionurl = "";
        this.extendinfo = null;
        this.float_picdata = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mediatype = jceInputStream.read(this.mediatype, 0, false);
        this.picdata = (s_picdata) jceInputStream.read((JceStruct) cache_picdata, 1, false);
        this.title = jceInputStream.readString(2, false);
        this.summary = jceInputStream.readString(3, false);
        this.countDownTime = jceInputStream.read(this.countDownTime, 4, false);
        this.backgd_picdata = (s_picdata) jceInputStream.read((JceStruct) cache_backgd_picdata, 5, false);
        this.psvAdvType = jceInputStream.read(this.psvAdvType, 6, false);
        this.markType = jceInputStream.read(this.markType, 7, false);
        this.btnText = jceInputStream.readString(8, false);
        this.actiontype = jceInputStream.read(this.actiontype, 9, false);
        this.actionurl = jceInputStream.readString(10, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 11, false);
        this.float_picdata = (s_picdata) jceInputStream.read((JceStruct) cache_float_picdata, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.mediatype, 0);
        s_picdata s_picdataVar = this.picdata;
        if (s_picdataVar != null) {
            jceOutputStream.write((JceStruct) s_picdataVar, 1);
        }
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.summary;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.countDownTime, 4);
        s_picdata s_picdataVar2 = this.backgd_picdata;
        if (s_picdataVar2 != null) {
            jceOutputStream.write((JceStruct) s_picdataVar2, 5);
        }
        jceOutputStream.write(this.psvAdvType, 6);
        jceOutputStream.write(this.markType, 7);
        String str3 = this.btnText;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        jceOutputStream.write(this.actiontype, 9);
        String str4 = this.actionurl;
        if (str4 != null) {
            jceOutputStream.write(str4, 10);
        }
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 11);
        }
        s_picdata s_picdataVar3 = this.float_picdata;
        if (s_picdataVar3 != null) {
            jceOutputStream.write((JceStruct) s_picdataVar3, 12);
        }
    }

    public cell_qboss_psv_adv(int i3, s_picdata s_picdataVar, String str, String str2, long j3, s_picdata s_picdataVar2, int i16, int i17, String str3, int i18, String str4, Map<String, String> map, s_picdata s_picdataVar3) {
        this.mediatype = i3;
        this.picdata = s_picdataVar;
        this.title = str;
        this.summary = str2;
        this.countDownTime = j3;
        this.backgd_picdata = s_picdataVar2;
        this.psvAdvType = i16;
        this.markType = i17;
        this.btnText = str3;
        this.actiontype = i18;
        this.actionurl = str4;
        this.extendinfo = map;
        this.float_picdata = s_picdataVar3;
    }
}
