package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_bottom_recomm extends JceStruct {
    public String AdvIconUrl;
    public int actiontype;
    public String actionurl;
    public int anonymity;
    public String buttonIconUrl;
    public String buttontext;
    public WeishiDownlowdUrl downloadUrl;
    public int iButtonFlag;
    public int iReportFlag;
    public String icon_token;
    public boolean isSupportFeedback;
    public s_join_list joinlist;
    public String jsonData;
    public s_picdata picinfo;
    public int style;
    public String summary;
    public String summaryColor;
    public String title;
    static s_picdata cache_picinfo = new s_picdata();
    static s_join_list cache_joinlist = new s_join_list();
    static WeishiDownlowdUrl cache_downloadUrl = new WeishiDownlowdUrl();

    public cell_bottom_recomm() {
        this.picinfo = null;
        this.title = "";
        this.summary = "";
        this.buttonIconUrl = "";
        this.actiontype = 0;
        this.actionurl = "";
        this.AdvIconUrl = "";
        this.summaryColor = "";
        this.buttontext = "";
        this.anonymity = 0;
        this.joinlist = null;
        this.isSupportFeedback = false;
        this.iReportFlag = 0;
        this.iButtonFlag = 0;
        this.downloadUrl = null;
        this.jsonData = "";
        this.style = 0;
        this.icon_token = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.picinfo = (s_picdata) jceInputStream.read((JceStruct) cache_picinfo, 0, false);
        this.title = jceInputStream.readString(1, false);
        this.summary = jceInputStream.readString(2, false);
        this.buttonIconUrl = jceInputStream.readString(3, false);
        this.actiontype = jceInputStream.read(this.actiontype, 4, false);
        this.actionurl = jceInputStream.readString(5, false);
        this.AdvIconUrl = jceInputStream.readString(6, false);
        this.summaryColor = jceInputStream.readString(7, false);
        this.buttontext = jceInputStream.readString(8, false);
        this.anonymity = jceInputStream.read(this.anonymity, 9, false);
        this.joinlist = (s_join_list) jceInputStream.read((JceStruct) cache_joinlist, 10, false);
        this.isSupportFeedback = jceInputStream.read(this.isSupportFeedback, 11, false);
        this.iReportFlag = jceInputStream.read(this.iReportFlag, 12, false);
        this.iButtonFlag = jceInputStream.read(this.iButtonFlag, 13, false);
        this.downloadUrl = (WeishiDownlowdUrl) jceInputStream.read((JceStruct) cache_downloadUrl, 14, false);
        this.jsonData = jceInputStream.readString(15, false);
        this.style = jceInputStream.read(this.style, 16, false);
        this.icon_token = jceInputStream.readString(17, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_picdata s_picdataVar = this.picinfo;
        if (s_picdataVar != null) {
            jceOutputStream.write((JceStruct) s_picdataVar, 0);
        }
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.summary;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.buttonIconUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.actiontype, 4);
        String str4 = this.actionurl;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.AdvIconUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        String str6 = this.summaryColor;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        String str7 = this.buttontext;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
        jceOutputStream.write(this.anonymity, 9);
        s_join_list s_join_listVar = this.joinlist;
        if (s_join_listVar != null) {
            jceOutputStream.write((JceStruct) s_join_listVar, 10);
        }
        jceOutputStream.write(this.isSupportFeedback, 11);
        jceOutputStream.write(this.iReportFlag, 12);
        jceOutputStream.write(this.iButtonFlag, 13);
        WeishiDownlowdUrl weishiDownlowdUrl = this.downloadUrl;
        if (weishiDownlowdUrl != null) {
            jceOutputStream.write((JceStruct) weishiDownlowdUrl, 14);
        }
        String str8 = this.jsonData;
        if (str8 != null) {
            jceOutputStream.write(str8, 15);
        }
        jceOutputStream.write(this.style, 16);
        String str9 = this.icon_token;
        if (str9 != null) {
            jceOutputStream.write(str9, 17);
        }
    }

    public cell_bottom_recomm(s_picdata s_picdataVar, String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7, int i16, s_join_list s_join_listVar, boolean z16, int i17, int i18, WeishiDownlowdUrl weishiDownlowdUrl, String str8, int i19, String str9) {
        this.picinfo = s_picdataVar;
        this.title = str;
        this.summary = str2;
        this.buttonIconUrl = str3;
        this.actiontype = i3;
        this.actionurl = str4;
        this.AdvIconUrl = str5;
        this.summaryColor = str6;
        this.buttontext = str7;
        this.anonymity = i16;
        this.joinlist = s_join_listVar;
        this.isSupportFeedback = z16;
        this.iReportFlag = i17;
        this.iButtonFlag = i18;
        this.downloadUrl = weishiDownlowdUrl;
        this.jsonData = str8;
        this.style = i19;
        this.icon_token = str9;
    }
}
