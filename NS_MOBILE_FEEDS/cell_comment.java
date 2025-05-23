package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_comment extends JceStruct {
    static ArrayList<s_commment> cache_commments = new ArrayList<>();
    static s_commment cache_main_comment;
    static s_plug_in_comment cache_plug_in_info;
    public int actiontype;
    public int comment_and_reply_num;
    public ArrayList<s_commment> commments;
    public int displayflag;
    public int iRealCount;
    public s_commment main_comment;
    public int num;
    public s_plug_in_comment plug_in_info;
    public String txt;
    public int unreadCnt;

    static {
        cache_commments.add(new s_commment());
        cache_main_comment = new s_commment();
        cache_plug_in_info = new s_plug_in_comment();
    }

    public cell_comment() {
        this.num = 0;
        this.commments = null;
        this.main_comment = null;
        this.unreadCnt = 0;
        this.actiontype = 0;
        this.iRealCount = 0;
        this.displayflag = 0;
        this.plug_in_info = null;
        this.txt = "";
        this.comment_and_reply_num = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.num = jceInputStream.read(this.num, 0, false);
        this.commments = (ArrayList) jceInputStream.read((JceInputStream) cache_commments, 1, false);
        this.main_comment = (s_commment) jceInputStream.read((JceStruct) cache_main_comment, 2, false);
        this.unreadCnt = jceInputStream.read(this.unreadCnt, 3, false);
        this.actiontype = jceInputStream.read(this.actiontype, 4, false);
        this.iRealCount = jceInputStream.read(this.iRealCount, 5, false);
        this.displayflag = jceInputStream.read(this.displayflag, 6, false);
        this.plug_in_info = (s_plug_in_comment) jceInputStream.read((JceStruct) cache_plug_in_info, 7, false);
        this.txt = jceInputStream.readString(8, false);
        this.comment_and_reply_num = jceInputStream.read(this.comment_and_reply_num, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.num, 0);
        ArrayList<s_commment> arrayList = this.commments;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        s_commment s_commmentVar = this.main_comment;
        if (s_commmentVar != null) {
            jceOutputStream.write((JceStruct) s_commmentVar, 2);
        }
        jceOutputStream.write(this.unreadCnt, 3);
        jceOutputStream.write(this.actiontype, 4);
        jceOutputStream.write(this.iRealCount, 5);
        jceOutputStream.write(this.displayflag, 6);
        s_plug_in_comment s_plug_in_commentVar = this.plug_in_info;
        if (s_plug_in_commentVar != null) {
            jceOutputStream.write((JceStruct) s_plug_in_commentVar, 7);
        }
        String str = this.txt;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
        jceOutputStream.write(this.comment_and_reply_num, 10);
    }

    public cell_comment(int i3, ArrayList<s_commment> arrayList, s_commment s_commmentVar, int i16, int i17, int i18, int i19, s_plug_in_comment s_plug_in_commentVar, String str, int i26) {
        this.num = i3;
        this.commments = arrayList;
        this.main_comment = s_commmentVar;
        this.unreadCnt = i16;
        this.actiontype = i17;
        this.iRealCount = i18;
        this.displayflag = i19;
        this.plug_in_info = s_plug_in_commentVar;
        this.txt = str;
        this.comment_and_reply_num = i26;
    }
}
