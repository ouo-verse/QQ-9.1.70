package UserGrowth;

import NS_MOBILE_FEEDS.s_button;
import NS_MOBILE_FEEDS.s_droplist_option;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class stSimpleMetaGdtAdInfo extends JceStruct {
    public String actionUrl;
    public int advPos;
    public String appid;
    public s_button bottomButton;
    public Map<Integer, String> busiParam;
    public String canvasData;
    public String cellId;
    public Map<Integer, String> cookie;
    public ArrayList<s_droplist_option> customDroplist;
    public int dest_type;
    public String dest_url;
    public stFloatingLayerCardStyle floatingLayerCardStyle;
    public String gdtTangramAdJson;
    public int hasReportExposure;
    public String impressionUrl;
    public boolean isGdtAdImpressionReport;
    public boolean isGdtAdOriginalImpressionReport;
    public boolean isGdtAdVidoReport;
    public boolean isGdtAdclicked;
    public boolean isWeishiGdtTangramAdv;
    public stNewIconStyle left_top_button;
    public Map<Integer, byte[]> mapPassBack;
    public int numbersOfGdtAdPlayed;
    public stImgReplacement pictureUrl;
    public byte playType;
    public int rankCurrentWithHalfStar;
    public String reportUrl;
    public String schemaPageUrl;
    public Map<Integer, Integer> stMapABTest;
    public String summary;
    public stSimpleMetaPerson user;
    public int videoClickType;
    public String videoId;
    public long videoTime;
    public int videoType;
    public String video_url;
    static stFloatingLayerCardStyle cache_floatingLayerCardStyle = new stFloatingLayerCardStyle();
    static s_button cache_bottom_button = new s_button();
    static stSimpleMetaPerson cache_poster = new stSimpleMetaPerson();
    static stImgReplacement cache_imgReplacements = new stImgReplacement();
    static stNewIconStyle cache_new_icon = new stNewIconStyle();

    public stSimpleMetaGdtAdInfo() {
        this.gdtTangramAdJson = "";
        this.cellId = "";
        this.floatingLayerCardStyle = null;
        this.video_url = "";
        this.videoClickType = 0;
        this.pictureUrl = null;
        this.mapPassBack = null;
        this.stMapABTest = null;
        this.busiParam = null;
        this.isGdtAdImpressionReport = false;
        this.isGdtAdOriginalImpressionReport = false;
        this.isGdtAdVidoReport = false;
        this.isGdtAdclicked = false;
        this.numbersOfGdtAdPlayed = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isWeishiGdtTangramAdv = jceInputStream.read(this.isWeishiGdtTangramAdv, 0, false);
        this.gdtTangramAdJson = jceInputStream.readString(1, false);
        this.cellId = jceInputStream.readString(2, false);
        this.floatingLayerCardStyle = (stFloatingLayerCardStyle) jceInputStream.read((JceStruct) cache_floatingLayerCardStyle, 3, false);
        this.cookie = (Map) jceInputStream.read((JceInputStream) this.cookie, 4, false);
        this.appid = jceInputStream.readString(5, false);
        this.bottomButton = (s_button) jceInputStream.read((JceStruct) cache_new_icon, 6, false);
        this.playType = jceInputStream.read(this.playType, 7, false);
        this.videoType = jceInputStream.read(this.videoType, 8, false);
        this.videoTime = jceInputStream.read(this.videoTime, 9, false);
        this.user = (stSimpleMetaPerson) jceInputStream.read((JceStruct) cache_poster, 10, false);
        this.video_url = jceInputStream.readString(11, false);
        this.videoId = jceInputStream.readString(12, false);
        this.videoClickType = jceInputStream.read(this.videoClickType, 13, false);
        this.summary = jceInputStream.readString(14, false);
        this.pictureUrl = (stImgReplacement) jceInputStream.read((JceStruct) cache_imgReplacements, 15, false);
        this.customDroplist = (ArrayList) jceInputStream.read((JceInputStream) this.customDroplist, 16, false);
        this.canvasData = jceInputStream.readString(17, false);
        this.dest_url = jceInputStream.readString(18, false);
        this.dest_type = jceInputStream.read(this.dest_type, 19, false);
        this.reportUrl = jceInputStream.readString(20, false);
        this.actionUrl = jceInputStream.readString(21, false);
        this.rankCurrentWithHalfStar = jceInputStream.read(this.rankCurrentWithHalfStar, 22, false);
        this.schemaPageUrl = jceInputStream.readString(23, false);
        this.left_top_button = (stNewIconStyle) jceInputStream.read((JceStruct) cache_new_icon, 24, false);
        this.mapPassBack = (Map) jceInputStream.read((JceInputStream) this.mapPassBack, 25, false);
        this.stMapABTest = (Map) jceInputStream.read((JceInputStream) this.stMapABTest, 26, false);
        this.hasReportExposure = jceInputStream.read(this.hasReportExposure, 27, false);
        this.busiParam = (Map) jceInputStream.read((JceInputStream) this.stMapABTest, 28, false);
        this.advPos = jceInputStream.read(this.advPos, 29, false);
        this.impressionUrl = jceInputStream.readString(30, false);
        this.isGdtAdImpressionReport = jceInputStream.read(this.isWeishiGdtTangramAdv, 31, false);
        this.isGdtAdVidoReport = jceInputStream.read(this.isGdtAdVidoReport, 32, false);
        this.isGdtAdclicked = jceInputStream.read(this.isGdtAdclicked, 33, false);
        this.numbersOfGdtAdPlayed = jceInputStream.read(this.numbersOfGdtAdPlayed, 34, false);
        this.isGdtAdOriginalImpressionReport = jceInputStream.read(this.isGdtAdOriginalImpressionReport, 35, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isWeishiGdtTangramAdv, 0);
        String str = this.gdtTangramAdJson;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.cellId;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        stFloatingLayerCardStyle stfloatinglayercardstyle = this.floatingLayerCardStyle;
        if (stfloatinglayercardstyle != null) {
            jceOutputStream.write((JceStruct) stfloatinglayercardstyle, 3);
        }
        Map<Integer, String> map = this.cookie;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        String str3 = this.appid;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        s_button s_buttonVar = this.bottomButton;
        if (s_buttonVar != null) {
            jceOutputStream.write((JceStruct) s_buttonVar, 6);
        }
        jceOutputStream.write(this.playType, 7);
        jceOutputStream.write(this.videoType, 8);
        jceOutputStream.write(this.videoTime, 9);
        stSimpleMetaPerson stsimplemetaperson = this.user;
        if (stsimplemetaperson != null) {
            jceOutputStream.write((JceStruct) stsimplemetaperson, 10);
        }
        String str4 = this.video_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 11);
        }
        String str5 = this.videoId;
        if (str5 != null) {
            jceOutputStream.write(str5, 12);
        }
        jceOutputStream.write(this.videoClickType, 13);
        String str6 = this.summary;
        if (str6 != null) {
            jceOutputStream.write(str6, 14);
        }
        stImgReplacement stimgreplacement = this.pictureUrl;
        if (stimgreplacement != null) {
            jceOutputStream.write((JceStruct) stimgreplacement, 15);
        }
        ArrayList<s_droplist_option> arrayList = this.customDroplist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 16);
        }
        String str7 = this.canvasData;
        if (str7 != null) {
            jceOutputStream.write(str7, 17);
        }
        String str8 = this.dest_url;
        if (str8 != null) {
            jceOutputStream.write(str8, 18);
        }
        jceOutputStream.write(this.dest_type, 19);
        String str9 = this.reportUrl;
        if (str9 != null) {
            jceOutputStream.write(str9, 20);
        }
        String str10 = this.actionUrl;
        if (str10 != null) {
            jceOutputStream.write(str10, 21);
        }
        jceOutputStream.write(this.rankCurrentWithHalfStar, 22);
        String str11 = this.schemaPageUrl;
        if (str11 != null) {
            jceOutputStream.write(str11, 23);
        }
        stNewIconStyle stnewiconstyle = this.left_top_button;
        if (stnewiconstyle != null) {
            jceOutputStream.write((JceStruct) stnewiconstyle, 24);
        }
        Map<Integer, byte[]> map2 = this.mapPassBack;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 25);
        }
        Map<Integer, Integer> map3 = this.stMapABTest;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 26);
        }
        jceOutputStream.write(this.hasReportExposure, 27);
        Map<Integer, String> map4 = this.busiParam;
        if (map4 != null) {
            jceOutputStream.write((Map) map4, 28);
        }
        jceOutputStream.write(this.advPos, 29);
        String str12 = this.impressionUrl;
        if (str12 != null) {
            jceOutputStream.write(str12, 30);
        }
        jceOutputStream.write(this.isGdtAdImpressionReport, 31);
        jceOutputStream.write(this.isGdtAdVidoReport, 32);
        jceOutputStream.write(this.isGdtAdclicked, 33);
        jceOutputStream.write(this.numbersOfGdtAdPlayed, 34);
        jceOutputStream.write(this.isGdtAdOriginalImpressionReport, 35);
    }

    public stSimpleMetaGdtAdInfo(boolean z16, String str, String str2, stFloatingLayerCardStyle stfloatinglayercardstyle, Map<Integer, String> map, String str3, s_button s_buttonVar, byte b16, int i3, long j3, stSimpleMetaPerson stsimplemetaperson, String str4, String str5, int i16, String str6, stImgReplacement stimgreplacement, ArrayList<s_droplist_option> arrayList, String str7, String str8, int i17, String str9, String str10, int i18, String str11, stNewIconStyle stnewiconstyle, Map<Integer, byte[]> map2, Map<Integer, Integer> map3, int i19, Map<Integer, String> map4, int i26, String str12, boolean z17, boolean z18, boolean z19, int i27, boolean z26) {
        this.isWeishiGdtTangramAdv = z16;
        this.gdtTangramAdJson = str;
        this.cellId = str2;
        this.floatingLayerCardStyle = stfloatinglayercardstyle;
        this.cookie = map;
        this.appid = str3;
        this.bottomButton = s_buttonVar;
        this.playType = b16;
        this.videoType = i3;
        this.videoTime = j3;
        this.user = stsimplemetaperson;
        this.video_url = str4;
        this.videoId = str5;
        this.videoClickType = i16;
        this.summary = str6;
        this.pictureUrl = stimgreplacement;
        this.customDroplist = arrayList;
        this.canvasData = str7;
        this.dest_url = str8;
        this.dest_type = i17;
        this.reportUrl = str9;
        this.actionUrl = str10;
        this.rankCurrentWithHalfStar = i18;
        this.schemaPageUrl = str11;
        this.left_top_button = stnewiconstyle;
        this.mapPassBack = map2;
        this.stMapABTest = map3;
        this.hasReportExposure = i19;
        this.busiParam = map4;
        this.advPos = i26;
        this.impressionUrl = str12;
        this.isGdtAdImpressionReport = z17;
        this.isGdtAdVidoReport = z18;
        this.isGdtAdclicked = z19;
        this.numbersOfGdtAdPlayed = i27;
        this.isGdtAdOriginalImpressionReport = z26;
    }
}
