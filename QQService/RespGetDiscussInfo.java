package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetDiscussInfo extends JceStruct {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<DiscussMemberInfo> cache_Members;
    public long CreateTime;
    public long DiscussFlag;
    public long DiscussUin;
    public long GroupCode;
    public long GroupUin;
    public long InfoSeq;
    public long InteRemarkTimeStamp;
    public ArrayList<DiscussMemberInfo> Members;
    public String Name;
    public long OwnerUin;

    public RespGetDiscussInfo() {
        this.DiscussUin = 0L;
        this.OwnerUin = 0L;
        this.InfoSeq = 0L;
        this.DiscussFlag = 0L;
        this.Name = "";
        this.Members = null;
        this.CreateTime = 0L;
        this.InteRemarkTimeStamp = 0L;
        this.GroupCode = 0L;
        this.GroupUin = 0L;
    }

    public String className() {
        return "QQService.RespGetDiscussInfo";
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
        jceDisplayer.display(this.DiscussUin, "DiscussUin");
        jceDisplayer.display(this.OwnerUin, "OwnerUin");
        jceDisplayer.display(this.InfoSeq, "InfoSeq");
        jceDisplayer.display(this.DiscussFlag, "DiscussFlag");
        jceDisplayer.display(this.Name, "Name");
        jceDisplayer.display((Collection) this.Members, "Members");
        jceDisplayer.display(this.CreateTime, "CreateTime");
        jceDisplayer.display(this.InteRemarkTimeStamp, "InteRemarkTimeStamp");
        jceDisplayer.display(this.GroupCode, "GroupCode");
        jceDisplayer.display(this.GroupUin, "GroupUin");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.DiscussUin, true);
        jceDisplayer.displaySimple(this.OwnerUin, true);
        jceDisplayer.displaySimple(this.InfoSeq, true);
        jceDisplayer.displaySimple(this.DiscussFlag, true);
        jceDisplayer.displaySimple(this.Name, true);
        jceDisplayer.displaySimple((Collection) this.Members, true);
        jceDisplayer.displaySimple(this.CreateTime, true);
        jceDisplayer.displaySimple(this.InteRemarkTimeStamp, true);
        jceDisplayer.displaySimple(this.GroupCode, true);
        jceDisplayer.displaySimple(this.GroupUin, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        RespGetDiscussInfo respGetDiscussInfo = (RespGetDiscussInfo) obj;
        if (!JceUtil.equals(this.DiscussUin, respGetDiscussInfo.DiscussUin) || !JceUtil.equals(this.OwnerUin, respGetDiscussInfo.OwnerUin) || !JceUtil.equals(this.InfoSeq, respGetDiscussInfo.InfoSeq) || !JceUtil.equals(this.DiscussFlag, respGetDiscussInfo.DiscussFlag) || !JceUtil.equals(this.Name, respGetDiscussInfo.Name) || !JceUtil.equals(this.Members, respGetDiscussInfo.Members) || !JceUtil.equals(this.CreateTime, respGetDiscussInfo.CreateTime) || !JceUtil.equals(this.InteRemarkTimeStamp, respGetDiscussInfo.InteRemarkTimeStamp) || !JceUtil.equals(this.GroupCode, respGetDiscussInfo.GroupCode) || !JceUtil.equals(this.GroupUin, respGetDiscussInfo.GroupUin)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "QQService.RespGetDiscussInfo";
    }

    public long getDiscussUin() {
        return this.DiscussUin;
    }

    public long getGroupCode() {
        return this.GroupCode;
    }

    public long getGroupUin() {
        return this.GroupUin;
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
        this.DiscussUin = jceInputStream.read(this.DiscussUin, 0, true);
        this.OwnerUin = jceInputStream.read(this.OwnerUin, 1, true);
        this.InfoSeq = jceInputStream.read(this.InfoSeq, 2, true);
        this.DiscussFlag = jceInputStream.read(this.DiscussFlag, 3, true);
        this.Name = jceInputStream.readString(4, true);
        if (cache_Members == null) {
            cache_Members = new ArrayList<>();
            cache_Members.add(new DiscussMemberInfo());
        }
        this.Members = (ArrayList) jceInputStream.read((JceInputStream) cache_Members, 5, true);
        this.CreateTime = jceInputStream.read(this.CreateTime, 6, false);
        this.InteRemarkTimeStamp = jceInputStream.read(this.InteRemarkTimeStamp, 7, false);
        this.GroupCode = jceInputStream.read(this.GroupCode, 8, false);
        this.GroupUin = jceInputStream.read(this.GroupUin, 9, false);
    }

    public void setGroupCode(long j3) {
        this.GroupCode = j3;
    }

    public void setGroupUin(long j3) {
        this.GroupUin = j3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.DiscussUin, 0);
        jceOutputStream.write(this.OwnerUin, 1);
        jceOutputStream.write(this.InfoSeq, 2);
        jceOutputStream.write(this.DiscussFlag, 3);
        jceOutputStream.write(this.Name, 4);
        jceOutputStream.write((Collection) this.Members, 5);
        jceOutputStream.write(this.CreateTime, 6);
        jceOutputStream.write(this.InteRemarkTimeStamp, 7);
        jceOutputStream.write(this.GroupCode, 8);
        jceOutputStream.write(this.GroupUin, 9);
    }

    public RespGetDiscussInfo(long j3, long j16, long j17, long j18, String str, ArrayList<DiscussMemberInfo> arrayList, long j19, long j26, long j27, long j28) {
        this.DiscussUin = j3;
        this.OwnerUin = j16;
        this.InfoSeq = j17;
        this.DiscussFlag = j18;
        this.Name = str;
        this.Members = arrayList;
        this.CreateTime = j19;
        this.InteRemarkTimeStamp = j26;
        this.GroupCode = j27;
        this.GroupUin = j28;
    }
}
