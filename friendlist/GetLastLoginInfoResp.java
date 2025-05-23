package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetLastLoginInfoResp extends JceStruct {
    static int cache_result;
    static LastLoginPageInfo cache_stPageInfo;
    static ArrayList<LastLoginInfo> cache_vecLastLoginInfo;
    public short errorCode;
    public int iRefreshIntervalMin;
    public int result;
    public LastLoginPageInfo stPageInfo;
    public ArrayList<LastLoginInfo> vecLastLoginInfo;

    public GetLastLoginInfoResp() {
        this.result = 0;
        this.errorCode = (short) 0;
        this.stPageInfo = null;
        this.vecLastLoginInfo = null;
        this.iRefreshIntervalMin = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, true);
        this.errorCode = jceInputStream.read(this.errorCode, 1, true);
        if (cache_stPageInfo == null) {
            cache_stPageInfo = new LastLoginPageInfo();
        }
        this.stPageInfo = (LastLoginPageInfo) jceInputStream.read((JceStruct) cache_stPageInfo, 2, false);
        if (cache_vecLastLoginInfo == null) {
            cache_vecLastLoginInfo = new ArrayList<>();
            cache_vecLastLoginInfo.add(new LastLoginInfo());
        }
        this.vecLastLoginInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecLastLoginInfo, 3, false);
        this.iRefreshIntervalMin = jceInputStream.read(this.iRefreshIntervalMin, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.result, 0);
        jceOutputStream.write(this.errorCode, 1);
        LastLoginPageInfo lastLoginPageInfo = this.stPageInfo;
        if (lastLoginPageInfo != null) {
            jceOutputStream.write((JceStruct) lastLoginPageInfo, 2);
        }
        ArrayList<LastLoginInfo> arrayList = this.vecLastLoginInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.iRefreshIntervalMin, 4);
    }

    public GetLastLoginInfoResp(int i3, short s16, LastLoginPageInfo lastLoginPageInfo, ArrayList<LastLoginInfo> arrayList, int i16) {
        this.result = i3;
        this.errorCode = s16;
        this.stPageInfo = lastLoginPageInfo;
        this.vecLastLoginInfo = arrayList;
        this.iRefreshIntervalMin = i16;
    }
}
