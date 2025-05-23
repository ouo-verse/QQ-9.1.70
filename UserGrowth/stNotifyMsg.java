package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stNotifyMsg extends JceStruct {
    public stMsgContentAssociateInfo associate;
    public stMsgContent content;
    public String contentFeedID;
    public long createTime;
    public int delFlag;
    public int flag;
    public String msgID;
    public stMsgContentPersonInfo oper;
    static stMsgContent cache_content = new stMsgContent();
    static stMsgContentPersonInfo cache_oper = new stMsgContentPersonInfo();
    static stMsgContentAssociateInfo cache_associate = new stMsgContentAssociateInfo();

    public stNotifyMsg() {
        this.msgID = "";
        this.content = null;
        this.flag = 0;
        this.oper = null;
        this.contentFeedID = "";
        this.associate = null;
        this.createTime = 0L;
        this.delFlag = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.msgID = jceInputStream.readString(0, false);
        this.content = (stMsgContent) jceInputStream.read((JceStruct) cache_content, 1, false);
        this.flag = jceInputStream.read(this.flag, 2, false);
        this.oper = (stMsgContentPersonInfo) jceInputStream.read((JceStruct) cache_oper, 3, false);
        this.contentFeedID = jceInputStream.readString(4, false);
        this.associate = (stMsgContentAssociateInfo) jceInputStream.read((JceStruct) cache_associate, 5, false);
        this.createTime = jceInputStream.read(this.createTime, 6, false);
        this.delFlag = jceInputStream.read(this.delFlag, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.msgID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        stMsgContent stmsgcontent = this.content;
        if (stmsgcontent != null) {
            jceOutputStream.write((JceStruct) stmsgcontent, 1);
        }
        jceOutputStream.write(this.flag, 2);
        stMsgContentPersonInfo stmsgcontentpersoninfo = this.oper;
        if (stmsgcontentpersoninfo != null) {
            jceOutputStream.write((JceStruct) stmsgcontentpersoninfo, 3);
        }
        String str2 = this.contentFeedID;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        stMsgContentAssociateInfo stmsgcontentassociateinfo = this.associate;
        if (stmsgcontentassociateinfo != null) {
            jceOutputStream.write((JceStruct) stmsgcontentassociateinfo, 5);
        }
        jceOutputStream.write(this.createTime, 6);
        jceOutputStream.write(this.delFlag, 7);
    }

    public stNotifyMsg(String str, stMsgContent stmsgcontent, int i3, stMsgContentPersonInfo stmsgcontentpersoninfo, String str2, stMsgContentAssociateInfo stmsgcontentassociateinfo, long j3, int i16) {
        this.msgID = str;
        this.content = stmsgcontent;
        this.flag = i3;
        this.oper = stmsgcontentpersoninfo;
        this.contentFeedID = str2;
        this.associate = stmsgcontentassociateinfo;
        this.createTime = j3;
        this.delFlag = i16;
    }
}
