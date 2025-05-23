package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class JudgeDownloadRsp extends JceStruct {
    public static final int STATUS_NOT_DOWNLOAD = 2;
    public static final int STATUS_NOW_DOWNLOAD = 1;
    public static final int STATUS_NULL = -1;
    public static final int STATUS_WAIT_TO_REQ = 0;
    static ArrayList<ResInfo> cache_vecDownloadRes = new ArrayList<>();
    public int iDownloadStatus = 0;
    public ArrayList<ResInfo> vecDownloadRes = null;
    public int iSegTime = 0;
    public int iFailedRetryMax = 3;

    static {
        cache_vecDownloadRes.add(new ResInfo());
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iDownloadStatus = jceInputStream.read(this.iDownloadStatus, 0, false);
        this.vecDownloadRes = (ArrayList) jceInputStream.read((JceInputStream) cache_vecDownloadRes, 1, false);
        this.iSegTime = jceInputStream.read(this.iSegTime, 2, false);
        this.iFailedRetryMax = jceInputStream.read(this.iFailedRetryMax, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iDownloadStatus, 0);
        ArrayList<ResInfo> arrayList = this.vecDownloadRes;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.iSegTime, 2);
        jceOutputStream.write(this.iFailedRetryMax, 3);
    }
}
