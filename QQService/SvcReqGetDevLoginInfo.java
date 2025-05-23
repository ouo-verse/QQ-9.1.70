package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcReqGetDevLoginInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static byte[] cache_vecGuid;
    public long iGetDevListType;
    public long iLoginType;
    public long iNextItemIndex;
    public long iRequireMax;
    public long iTimeStamp;
    public String strAppName;
    public byte[] vecGuid;

    public SvcReqGetDevLoginInfo() {
        this.vecGuid = null;
        this.strAppName = "";
        this.iLoginType = 1L;
        this.iTimeStamp = 0L;
        this.iNextItemIndex = 0L;
        this.iRequireMax = 0L;
        this.iGetDevListType = 7L;
    }

    public String className() {
        return "QQService.SvcReqGetDevLoginInfo";
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
        jceDisplayer.display(this.vecGuid, "vecGuid");
        jceDisplayer.display(this.strAppName, "strAppName");
        jceDisplayer.display(this.iLoginType, "iLoginType");
        jceDisplayer.display(this.iTimeStamp, "iTimeStamp");
        jceDisplayer.display(this.iNextItemIndex, "iNextItemIndex");
        jceDisplayer.display(this.iRequireMax, "iRequireMax");
        jceDisplayer.display(this.iGetDevListType, "iGetDevListType");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.vecGuid, true);
        jceDisplayer.displaySimple(this.strAppName, true);
        jceDisplayer.displaySimple(this.iLoginType, true);
        jceDisplayer.displaySimple(this.iTimeStamp, true);
        jceDisplayer.displaySimple(this.iNextItemIndex, true);
        jceDisplayer.displaySimple(this.iRequireMax, true);
        jceDisplayer.displaySimple(this.iGetDevListType, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        SvcReqGetDevLoginInfo svcReqGetDevLoginInfo = (SvcReqGetDevLoginInfo) obj;
        if (!JceUtil.equals(this.vecGuid, svcReqGetDevLoginInfo.vecGuid) || !JceUtil.equals(this.strAppName, svcReqGetDevLoginInfo.strAppName) || !JceUtil.equals(this.iLoginType, svcReqGetDevLoginInfo.iLoginType) || !JceUtil.equals(this.iTimeStamp, svcReqGetDevLoginInfo.iTimeStamp) || !JceUtil.equals(this.iNextItemIndex, svcReqGetDevLoginInfo.iNextItemIndex) || !JceUtil.equals(this.iRequireMax, svcReqGetDevLoginInfo.iRequireMax) || !JceUtil.equals(this.iGetDevListType, svcReqGetDevLoginInfo.iGetDevListType)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "QQService.SvcReqGetDevLoginInfo";
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
        if (cache_vecGuid == null) {
            cache_vecGuid = r0;
            byte[] bArr = {0};
        }
        this.vecGuid = jceInputStream.read(cache_vecGuid, 0, true);
        this.strAppName = jceInputStream.readString(1, true);
        this.iLoginType = jceInputStream.read(this.iLoginType, 2, true);
        this.iTimeStamp = jceInputStream.read(this.iTimeStamp, 3, true);
        this.iNextItemIndex = jceInputStream.read(this.iNextItemIndex, 4, true);
        this.iRequireMax = jceInputStream.read(this.iRequireMax, 5, true);
        this.iGetDevListType = jceInputStream.read(this.iGetDevListType, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vecGuid, 0);
        jceOutputStream.write(this.strAppName, 1);
        jceOutputStream.write(this.iLoginType, 2);
        jceOutputStream.write(this.iTimeStamp, 3);
        jceOutputStream.write(this.iNextItemIndex, 4);
        jceOutputStream.write(this.iRequireMax, 5);
        jceOutputStream.write(this.iGetDevListType, 6);
    }

    public SvcReqGetDevLoginInfo(byte[] bArr, String str, long j3, long j16, long j17, long j18, long j19) {
        this.vecGuid = bArr;
        this.strAppName = str;
        this.iLoginType = j3;
        this.iTimeStamp = j16;
        this.iNextItemIndex = j17;
        this.iRequireMax = j18;
        this.iGetDevListType = j19;
    }
}
