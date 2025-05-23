package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SSummaryCardRsp extends JceStruct {
    static int cache_res;
    static cardDiyComplicatedInfo cache_stDiyComplicated;
    static cardDiyTextInfo cache_stDiyText;
    static STRecommendInfo cache_stRecom;
    static ArrayList<summaryCardWzryInfo> cache_wzryInfo;
    public String aid;
    public long bgid;
    public ArrayList<Integer> bgtype;
    public String bgurl;
    public int cardType;
    public long cardid;
    public long color;
    public int dynamicCardFlag;
    public String emsg;
    public String extInfo;
    public SUserLabel label;
    public int likeAreaID;
    public int payType;
    public int profileid;
    public int res;
    public cardDiyComplicatedInfo stDiyComplicated;
    public cardDiyTextInfo stDiyText;
    public STRecommendInfo stRecom;
    public String strActiveCardUrl;
    public String strDiyDefaultText;
    public String strDrawerCard;
    public String strWzryHeroUrl;
    public String strZipUrl;
    public long styleid;
    public String urlprefix;
    public ArrayList<summaryCardWzryInfo> wzryInfo;
    static SUserLabel cache_label = new SUserLabel();
    static ArrayList<Integer> cache_bgtype = new ArrayList<>();

    static {
        cache_bgtype.add(0);
        cache_stRecom = new STRecommendInfo();
        cache_wzryInfo = new ArrayList<>();
        cache_wzryInfo.add(new summaryCardWzryInfo());
        cache_stDiyText = new cardDiyTextInfo();
        cache_stDiyComplicated = new cardDiyComplicatedInfo();
    }

    public SSummaryCardRsp() {
        this.res = 0;
        this.cardid = 0L;
        this.styleid = 0L;
        this.bgurl = "";
        this.bgid = 0L;
        this.color = 0L;
        this.label = null;
        this.emsg = "";
        this.bgtype = null;
        this.dynamicCardFlag = 0;
        this.strZipUrl = "";
        this.stRecom = null;
        this.strActiveCardUrl = "";
        this.strDrawerCard = "";
        this.strWzryHeroUrl = "";
        this.wzryInfo = null;
        this.stDiyText = null;
        this.cardType = 0;
        this.strDiyDefaultText = "";
        this.extInfo = "";
        this.profileid = 0;
        this.urlprefix = "";
        this.stDiyComplicated = null;
        this.aid = "";
        this.payType = 0;
        this.likeAreaID = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.res = jceInputStream.read(this.res, 0, true);
        this.cardid = jceInputStream.read(this.cardid, 1, true);
        this.styleid = jceInputStream.read(this.styleid, 2, false);
        this.bgurl = jceInputStream.readString(3, false);
        this.bgid = jceInputStream.read(this.bgid, 4, false);
        this.color = jceInputStream.read(this.color, 5, false);
        this.label = (SUserLabel) jceInputStream.read((JceStruct) cache_label, 6, false);
        this.emsg = jceInputStream.readString(7, false);
        this.bgtype = (ArrayList) jceInputStream.read((JceInputStream) cache_bgtype, 8, false);
        this.dynamicCardFlag = jceInputStream.read(this.dynamicCardFlag, 9, false);
        this.strZipUrl = jceInputStream.readString(10, false);
        this.stRecom = (STRecommendInfo) jceInputStream.read((JceStruct) cache_stRecom, 11, false);
        this.strActiveCardUrl = jceInputStream.readString(12, false);
        this.strDrawerCard = jceInputStream.readString(13, false);
        this.strWzryHeroUrl = jceInputStream.readString(14, false);
        this.wzryInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_wzryInfo, 15, false);
        this.stDiyText = (cardDiyTextInfo) jceInputStream.read((JceStruct) cache_stDiyText, 16, false);
        this.cardType = jceInputStream.read(this.cardType, 17, false);
        this.strDiyDefaultText = jceInputStream.readString(18, false);
        this.extInfo = jceInputStream.readString(19, false);
        this.profileid = jceInputStream.read(this.profileid, 20, false);
        this.urlprefix = jceInputStream.readString(21, false);
        this.stDiyComplicated = (cardDiyComplicatedInfo) jceInputStream.read((JceStruct) cache_stDiyComplicated, 22, false);
        this.aid = jceInputStream.readString(23, false);
        this.payType = jceInputStream.read(this.payType, 24, false);
        this.likeAreaID = jceInputStream.read(this.likeAreaID, 25, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.res, 0);
        jceOutputStream.write(this.cardid, 1);
        jceOutputStream.write(this.styleid, 2);
        String str = this.bgurl;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.bgid, 4);
        jceOutputStream.write(this.color, 5);
        SUserLabel sUserLabel = this.label;
        if (sUserLabel != null) {
            jceOutputStream.write((JceStruct) sUserLabel, 6);
        }
        String str2 = this.emsg;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        ArrayList<Integer> arrayList = this.bgtype;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 8);
        }
        jceOutputStream.write(this.dynamicCardFlag, 9);
        String str3 = this.strZipUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        STRecommendInfo sTRecommendInfo = this.stRecom;
        if (sTRecommendInfo != null) {
            jceOutputStream.write((JceStruct) sTRecommendInfo, 11);
        }
        String str4 = this.strActiveCardUrl;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
        String str5 = this.strDrawerCard;
        if (str5 != null) {
            jceOutputStream.write(str5, 13);
        }
        String str6 = this.strWzryHeroUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 14);
        }
        ArrayList<summaryCardWzryInfo> arrayList2 = this.wzryInfo;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 15);
        }
        cardDiyTextInfo carddiytextinfo = this.stDiyText;
        if (carddiytextinfo != null) {
            jceOutputStream.write((JceStruct) carddiytextinfo, 16);
        }
        jceOutputStream.write(this.cardType, 17);
        String str7 = this.strDiyDefaultText;
        if (str7 != null) {
            jceOutputStream.write(str7, 18);
        }
        String str8 = this.extInfo;
        if (str8 != null) {
            jceOutputStream.write(str8, 19);
        }
        jceOutputStream.write(this.profileid, 20);
        String str9 = this.urlprefix;
        if (str9 != null) {
            jceOutputStream.write(str9, 21);
        }
        cardDiyComplicatedInfo carddiycomplicatedinfo = this.stDiyComplicated;
        if (carddiycomplicatedinfo != null) {
            jceOutputStream.write((JceStruct) carddiycomplicatedinfo, 22);
        }
        String str10 = this.aid;
        if (str10 != null) {
            jceOutputStream.write(str10, 23);
        }
        jceOutputStream.write(this.payType, 24);
        jceOutputStream.write(this.likeAreaID, 25);
    }

    public SSummaryCardRsp(int i3, long j3, long j16, String str, long j17, long j18, SUserLabel sUserLabel, String str2, ArrayList<Integer> arrayList, int i16, String str3, STRecommendInfo sTRecommendInfo, String str4, String str5, String str6, ArrayList<summaryCardWzryInfo> arrayList2, cardDiyTextInfo carddiytextinfo, int i17, String str7, String str8, int i18, String str9, cardDiyComplicatedInfo carddiycomplicatedinfo, String str10, int i19, int i26) {
        this.res = i3;
        this.cardid = j3;
        this.styleid = j16;
        this.bgurl = str;
        this.bgid = j17;
        this.color = j18;
        this.label = sUserLabel;
        this.emsg = str2;
        this.bgtype = arrayList;
        this.dynamicCardFlag = i16;
        this.strZipUrl = str3;
        this.stRecom = sTRecommendInfo;
        this.strActiveCardUrl = str4;
        this.strDrawerCard = str5;
        this.strWzryHeroUrl = str6;
        this.wzryInfo = arrayList2;
        this.stDiyText = carddiytextinfo;
        this.cardType = i17;
        this.strDiyDefaultText = str7;
        this.extInfo = str8;
        this.profileid = i18;
        this.urlprefix = str9;
        this.stDiyComplicated = carddiycomplicatedinfo;
        this.aid = str10;
        this.payType = i19;
        this.likeAreaID = i26;
    }
}
