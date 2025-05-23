package NS_MOBILE_EXTRA;

import com.qq.e.comm.constants.TangramAppConstants;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_app_info extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public int appid;
    public String appname;
    public int apptype;
    public String downloadurl;
    public String downloadurl_android;
    public String h5_url;
    public String iconurl;
    public int isrecommend;
    public String packagename;
    public String recommendcomment;
    public String summary;

    public s_app_info() {
        this.appname = "";
        this.iconurl = "";
        this.downloadurl = "";
        this.downloadurl_android = "";
        this.summary = "";
        this.packagename = "";
        this.h5_url = "";
        this.recommendcomment = "";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.appid, "appid");
        jceDisplayer.display(this.appname, "appname");
        jceDisplayer.display(this.iconurl, TangramAppConstants.ICON_URL);
        jceDisplayer.display(this.downloadurl, JefsClass.DOWNLOAD_URL);
        jceDisplayer.display(this.downloadurl_android, "downloadurl_android");
        jceDisplayer.display(this.summary, "summary");
        jceDisplayer.display(this.isrecommend, "isrecommend");
        jceDisplayer.display(this.packagename, "packagename");
        jceDisplayer.display(this.h5_url, "h5_url");
        jceDisplayer.display(this.recommendcomment, "recommendcomment");
        jceDisplayer.display(this.apptype, "apptype");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.appid, true);
        jceDisplayer.displaySimple(this.appname, true);
        jceDisplayer.displaySimple(this.iconurl, true);
        jceDisplayer.displaySimple(this.downloadurl, true);
        jceDisplayer.displaySimple(this.downloadurl_android, true);
        jceDisplayer.displaySimple(this.summary, true);
        jceDisplayer.displaySimple(this.isrecommend, true);
        jceDisplayer.displaySimple(this.packagename, true);
        jceDisplayer.displaySimple(this.h5_url, true);
        jceDisplayer.displaySimple(this.recommendcomment, true);
        jceDisplayer.displaySimple(this.apptype, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        s_app_info s_app_infoVar = (s_app_info) obj;
        if (!JceUtil.equals(this.appid, s_app_infoVar.appid) || !JceUtil.equals(this.appname, s_app_infoVar.appname) || !JceUtil.equals(this.iconurl, s_app_infoVar.iconurl) || !JceUtil.equals(this.downloadurl, s_app_infoVar.downloadurl) || !JceUtil.equals(this.downloadurl_android, s_app_infoVar.downloadurl_android) || !JceUtil.equals(this.summary, s_app_infoVar.summary) || !JceUtil.equals(this.isrecommend, s_app_infoVar.isrecommend) || !JceUtil.equals(this.packagename, s_app_infoVar.packagename) || !JceUtil.equals(this.h5_url, s_app_infoVar.h5_url) || !JceUtil.equals(this.recommendcomment, s_app_infoVar.recommendcomment) || !JceUtil.equals(this.apptype, s_app_infoVar.apptype)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.appname = jceInputStream.readString(1, false);
        this.iconurl = jceInputStream.readString(2, false);
        this.downloadurl = jceInputStream.readString(3, false);
        this.downloadurl_android = jceInputStream.readString(4, false);
        this.summary = jceInputStream.readString(5, false);
        this.isrecommend = jceInputStream.read(this.isrecommend, 6, false);
        this.packagename = jceInputStream.readString(7, false);
        this.h5_url = jceInputStream.readString(8, false);
        this.recommendcomment = jceInputStream.readString(9, false);
        this.apptype = jceInputStream.read(this.apptype, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        String str = this.appname;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.iconurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.downloadurl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.downloadurl_android;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.summary;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        jceOutputStream.write(this.isrecommend, 6);
        String str6 = this.packagename;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        String str7 = this.h5_url;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
        String str8 = this.recommendcomment;
        if (str8 != null) {
            jceOutputStream.write(str8, 9);
        }
        jceOutputStream.write(this.apptype, 10);
    }

    public s_app_info(int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6, String str7, String str8, int i17) {
        this.appid = i3;
        this.appname = str;
        this.iconurl = str2;
        this.downloadurl = str3;
        this.downloadurl_android = str4;
        this.summary = str5;
        this.isrecommend = i16;
        this.packagename = str6;
        this.h5_url = str7;
        this.recommendcomment = str8;
        this.apptype = i17;
    }
}
