package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class JudgeDownloadReq extends JceStruct {
    static ArrayList<ResInfo> cache_vecResInfo = new ArrayList<>();
    public int iActId = 1001;
    public long iUin = 0;
    public ArrayList<ResInfo> vecResInfo = null;
    public String sQQVersion = "";
    public int iType = 1;
    public String sPhoneType = "";
    public float fMinCPUFreq = 0.0f;
    public float fMaxCPUFreq = 0.0f;
    public int iCores = 0;
    public long iMemory = 0;
    public int iPlatForm = 1;
    public int iRetryTimes = 0;

    static {
        cache_vecResInfo.add(new ResInfo());
    }

    public static JudgeDownloadReq createReq(ArrayList<ResInfo> arrayList, long j3, int i3, String str, String str2, float f16, float f17, int i16, long j16) {
        JudgeDownloadReq judgeDownloadReq = new JudgeDownloadReq();
        judgeDownloadReq.iUin = j3;
        judgeDownloadReq.vecResInfo = arrayList;
        judgeDownloadReq.sPhoneType = str;
        judgeDownloadReq.sQQVersion = str2;
        judgeDownloadReq.fMinCPUFreq = f16;
        judgeDownloadReq.fMaxCPUFreq = f17;
        judgeDownloadReq.iCores = i16;
        judgeDownloadReq.iMemory = j16;
        judgeDownloadReq.iRetryTimes = i3;
        return judgeDownloadReq;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iActId = jceInputStream.read(this.iActId, 0, false);
        this.iUin = jceInputStream.read(this.iUin, 1, false);
        this.vecResInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecResInfo, 2, false);
        this.sQQVersion = jceInputStream.readString(3, false);
        this.iType = jceInputStream.read(this.iType, 4, false);
        this.sPhoneType = jceInputStream.readString(5, false);
        this.fMinCPUFreq = jceInputStream.read(this.fMinCPUFreq, 6, false);
        this.fMaxCPUFreq = jceInputStream.read(this.fMaxCPUFreq, 7, false);
        this.iCores = jceInputStream.read(this.iCores, 8, false);
        this.iMemory = jceInputStream.read(this.iMemory, 9, false);
        this.iPlatForm = jceInputStream.read(this.iPlatForm, 10, false);
        this.iRetryTimes = jceInputStream.read(this.iRetryTimes, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iActId, 0);
        jceOutputStream.write(this.iUin, 1);
        ArrayList<ResInfo> arrayList = this.vecResInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str = this.sQQVersion;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.iType, 4);
        String str2 = this.sPhoneType;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.fMinCPUFreq, 6);
        jceOutputStream.write(this.fMaxCPUFreq, 7);
        jceOutputStream.write(this.iCores, 8);
        jceOutputStream.write(this.iMemory, 9);
        jceOutputStream.write(this.iPlatForm, 10);
        jceOutputStream.write(this.iRetryTimes, 11);
    }
}
