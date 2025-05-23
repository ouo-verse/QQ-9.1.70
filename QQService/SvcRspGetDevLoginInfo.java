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
public final class SvcRspGetDevLoginInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<SvcDevLoginInfo> cache_vecAuthLoginDevInfo;
    static ArrayList<SvcDevLoginInfo> cache_vecCurrentLoginDevInfo;
    static ArrayList<SvcDevLoginInfo> cache_vecHistoryLoginDevInfo;
    public long iNextItemIndex;
    public int iResult;
    public long iTotalItemCount;
    public String strResult;
    public ArrayList<SvcDevLoginInfo> vecAuthLoginDevInfo;
    public ArrayList<SvcDevLoginInfo> vecCurrentLoginDevInfo;
    public ArrayList<SvcDevLoginInfo> vecHistoryLoginDevInfo;

    public SvcRspGetDevLoginInfo() {
        this.iResult = 0;
        this.strResult = "";
        this.iNextItemIndex = 0L;
        this.iTotalItemCount = 0L;
        this.vecCurrentLoginDevInfo = null;
        this.vecHistoryLoginDevInfo = null;
        this.vecAuthLoginDevInfo = null;
    }

    public String className() {
        return "QQService.SvcRspGetDevLoginInfo";
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
        jceDisplayer.display(this.iResult, "iResult");
        jceDisplayer.display(this.strResult, "strResult");
        jceDisplayer.display(this.iNextItemIndex, "iNextItemIndex");
        jceDisplayer.display(this.iTotalItemCount, "iTotalItemCount");
        jceDisplayer.display((Collection) this.vecCurrentLoginDevInfo, "vecCurrentLoginDevInfo");
        jceDisplayer.display((Collection) this.vecHistoryLoginDevInfo, "vecHistoryLoginDevInfo");
        jceDisplayer.display((Collection) this.vecAuthLoginDevInfo, "vecAuthLoginDevInfo");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.iResult, true);
        jceDisplayer.displaySimple(this.strResult, true);
        jceDisplayer.displaySimple(this.iNextItemIndex, true);
        jceDisplayer.displaySimple(this.iTotalItemCount, true);
        jceDisplayer.displaySimple((Collection) this.vecCurrentLoginDevInfo, true);
        jceDisplayer.displaySimple((Collection) this.vecHistoryLoginDevInfo, true);
        jceDisplayer.displaySimple((Collection) this.vecAuthLoginDevInfo, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        SvcRspGetDevLoginInfo svcRspGetDevLoginInfo = (SvcRspGetDevLoginInfo) obj;
        if (!JceUtil.equals(this.iResult, svcRspGetDevLoginInfo.iResult) || !JceUtil.equals(this.strResult, svcRspGetDevLoginInfo.strResult) || !JceUtil.equals(this.iNextItemIndex, svcRspGetDevLoginInfo.iNextItemIndex) || !JceUtil.equals(this.iTotalItemCount, svcRspGetDevLoginInfo.iTotalItemCount) || !JceUtil.equals(this.vecCurrentLoginDevInfo, svcRspGetDevLoginInfo.vecCurrentLoginDevInfo) || !JceUtil.equals(this.vecHistoryLoginDevInfo, svcRspGetDevLoginInfo.vecHistoryLoginDevInfo) || !JceUtil.equals(this.vecAuthLoginDevInfo, svcRspGetDevLoginInfo.vecAuthLoginDevInfo)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "QQService.SvcRspGetDevLoginInfo";
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
        this.iResult = jceInputStream.read(this.iResult, 0, true);
        this.strResult = jceInputStream.readString(1, false);
        this.iNextItemIndex = jceInputStream.read(this.iNextItemIndex, 2, true);
        this.iTotalItemCount = jceInputStream.read(this.iTotalItemCount, 3, true);
        if (cache_vecCurrentLoginDevInfo == null) {
            cache_vecCurrentLoginDevInfo = new ArrayList<>();
            cache_vecCurrentLoginDevInfo.add(new SvcDevLoginInfo());
        }
        this.vecCurrentLoginDevInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecCurrentLoginDevInfo, 4, false);
        if (cache_vecHistoryLoginDevInfo == null) {
            cache_vecHistoryLoginDevInfo = new ArrayList<>();
            cache_vecHistoryLoginDevInfo.add(new SvcDevLoginInfo());
        }
        this.vecHistoryLoginDevInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecHistoryLoginDevInfo, 5, false);
        if (cache_vecAuthLoginDevInfo == null) {
            cache_vecAuthLoginDevInfo = new ArrayList<>();
            cache_vecAuthLoginDevInfo.add(new SvcDevLoginInfo());
        }
        this.vecAuthLoginDevInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecAuthLoginDevInfo, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iResult, 0);
        String str = this.strResult;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.iNextItemIndex, 2);
        jceOutputStream.write(this.iTotalItemCount, 3);
        ArrayList<SvcDevLoginInfo> arrayList = this.vecCurrentLoginDevInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        ArrayList<SvcDevLoginInfo> arrayList2 = this.vecHistoryLoginDevInfo;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 5);
        }
        ArrayList<SvcDevLoginInfo> arrayList3 = this.vecAuthLoginDevInfo;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 6);
        }
    }

    public SvcRspGetDevLoginInfo(int i3, String str, long j3, long j16, ArrayList<SvcDevLoginInfo> arrayList, ArrayList<SvcDevLoginInfo> arrayList2, ArrayList<SvcDevLoginInfo> arrayList3) {
        this.iResult = i3;
        this.strResult = str;
        this.iNextItemIndex = j3;
        this.iTotalItemCount = j16;
        this.vecCurrentLoginDevInfo = arrayList;
        this.vecHistoryLoginDevInfo = arrayList2;
        this.vecAuthLoginDevInfo = arrayList3;
    }
}
