package AvatarInfo;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetAvatarUrlReq extends JceStruct {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<DestUserInfo> cache_destUserInfo;
    public long myUin = 0;
    public ArrayList<DestUserInfo> destUserInfo = null;

    public GetAvatarUrlReq() {
        setMyUin(0L);
        setDestUserInfo(this.destUserInfo);
    }

    public String className() {
        return "AvatarInfo.GetAvatarUrlReq";
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
        jceDisplayer.display(this.myUin, "myUin");
        jceDisplayer.display((Collection) this.destUserInfo, "destUserInfo");
    }

    public boolean equals(Object obj) {
        GetAvatarUrlReq getAvatarUrlReq = (GetAvatarUrlReq) obj;
        if (JceUtil.equals(this.myUin, getAvatarUrlReq.myUin) && JceUtil.equals(this.destUserInfo, getAvatarUrlReq.destUserInfo)) {
            return true;
        }
        return false;
    }

    public ArrayList<DestUserInfo> getDestUserInfo() {
        return this.destUserInfo;
    }

    public long getMyUin() {
        return this.myUin;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        setMyUin(jceInputStream.read(this.myUin, 0, true));
        if (cache_destUserInfo == null) {
            cache_destUserInfo = new ArrayList<>();
            cache_destUserInfo.add(new DestUserInfo());
        }
        setDestUserInfo((ArrayList) jceInputStream.read((JceInputStream) cache_destUserInfo, 1, true));
    }

    public void setDestUserInfo(ArrayList<DestUserInfo> arrayList) {
        this.destUserInfo = arrayList;
    }

    public void setMyUin(long j3) {
        this.myUin = j3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.myUin, 0);
        jceOutputStream.write((Collection) this.destUserInfo, 1);
    }

    public GetAvatarUrlReq(long j3, ArrayList<DestUserInfo> arrayList) {
        setMyUin(j3);
        setDestUserInfo(arrayList);
    }
}
