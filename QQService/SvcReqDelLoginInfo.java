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
public final class SvcReqDelLoginInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<DeviceItemDes> cache_vecDeviceItemDes;
    static byte[] cache_vecGuid;
    public long iAppId;
    public long iDelMe;
    public long iDelType;
    public String strAppName;
    public ArrayList<DeviceItemDes> vecDeviceItemDes;
    public byte[] vecGuid;

    public SvcReqDelLoginInfo() {
        this.vecGuid = null;
        this.strAppName = "";
        this.vecDeviceItemDes = null;
        this.iDelType = 1L;
        this.iDelMe = 0L;
        this.iAppId = 0L;
    }

    public String className() {
        return "QQService.SvcReqDelLoginInfo";
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
        jceDisplayer.display((Collection) this.vecDeviceItemDes, "vecDeviceItemDes");
        jceDisplayer.display(this.iDelType, "iDelType");
        jceDisplayer.display(this.iDelMe, "iDelMe");
        jceDisplayer.display(this.iAppId, "iAppId");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.vecGuid, true);
        jceDisplayer.displaySimple(this.strAppName, true);
        jceDisplayer.displaySimple((Collection) this.vecDeviceItemDes, true);
        jceDisplayer.displaySimple(this.iDelType, true);
        jceDisplayer.displaySimple(this.iDelMe, true);
        jceDisplayer.displaySimple(this.iAppId, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        SvcReqDelLoginInfo svcReqDelLoginInfo = (SvcReqDelLoginInfo) obj;
        if (!JceUtil.equals(this.vecGuid, svcReqDelLoginInfo.vecGuid) || !JceUtil.equals(this.strAppName, svcReqDelLoginInfo.strAppName) || !JceUtil.equals(this.vecDeviceItemDes, svcReqDelLoginInfo.vecDeviceItemDes) || !JceUtil.equals(this.iDelType, svcReqDelLoginInfo.iDelType) || !JceUtil.equals(this.iDelMe, svcReqDelLoginInfo.iDelMe) || !JceUtil.equals(this.iAppId, svcReqDelLoginInfo.iAppId)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "QQService.SvcReqDelLoginInfo";
    }

    public long getIAppId() {
        return this.iAppId;
    }

    public long getIDelMe() {
        return this.iDelMe;
    }

    public long getIDelType() {
        return this.iDelType;
    }

    public String getStrAppName() {
        return this.strAppName;
    }

    public ArrayList<DeviceItemDes> getVecDeviceItemDes() {
        return this.vecDeviceItemDes;
    }

    public byte[] getVecGuid() {
        return this.vecGuid;
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
        if (cache_vecDeviceItemDes == null) {
            cache_vecDeviceItemDes = new ArrayList<>();
            cache_vecDeviceItemDes.add(new DeviceItemDes());
        }
        this.vecDeviceItemDes = (ArrayList) jceInputStream.read((JceInputStream) cache_vecDeviceItemDes, 2, true);
        this.iDelType = jceInputStream.read(this.iDelType, 3, false);
        this.iDelMe = jceInputStream.read(this.iDelMe, 4, false);
        this.iAppId = jceInputStream.read(this.iAppId, 5, false);
    }

    public void setIAppId(long j3) {
        this.iAppId = j3;
    }

    public void setIDelMe(long j3) {
        this.iDelMe = j3;
    }

    public void setIDelType(long j3) {
        this.iDelType = j3;
    }

    public void setStrAppName(String str) {
        this.strAppName = str;
    }

    public void setVecDeviceItemDes(ArrayList<DeviceItemDes> arrayList) {
        this.vecDeviceItemDes = arrayList;
    }

    public void setVecGuid(byte[] bArr) {
        this.vecGuid = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vecGuid, 0);
        jceOutputStream.write(this.strAppName, 1);
        jceOutputStream.write((Collection) this.vecDeviceItemDes, 2);
        jceOutputStream.write(this.iDelType, 3);
        jceOutputStream.write(this.iDelMe, 4);
        jceOutputStream.write(this.iAppId, 5);
    }

    public SvcReqDelLoginInfo(byte[] bArr, String str, ArrayList<DeviceItemDes> arrayList, long j3, long j16, long j17) {
        this.vecGuid = bArr;
        this.strAppName = str;
        this.vecDeviceItemDes = arrayList;
        this.iDelType = j3;
        this.iDelMe = j16;
        this.iAppId = j17;
    }
}
