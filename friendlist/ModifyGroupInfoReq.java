package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ModifyGroupInfoReq extends JceStruct {
    public long cGroupOption;
    public long dwGroupClass;
    public long dwGroupCode;
    public long dwValidMask;
    public String strFingerMemo;
    public String strGroupMemo;
    public String strGroupName;
    public String strRichFingerMemo;
    public int wGroupFace;
    public int wVersion;

    public ModifyGroupInfoReq() {
        this.dwGroupCode = 0L;
        this.cGroupOption = 0L;
        this.dwGroupClass = 0L;
        this.strGroupName = "";
        this.wGroupFace = 0;
        this.strGroupMemo = "";
        this.strFingerMemo = "";
        this.dwValidMask = 0L;
        this.strRichFingerMemo = "";
        this.wVersion = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwGroupCode = jceInputStream.read(this.dwGroupCode, 0, true);
        this.cGroupOption = jceInputStream.read(this.cGroupOption, 1, true);
        this.dwGroupClass = jceInputStream.read(this.dwGroupClass, 2, true);
        this.strGroupName = jceInputStream.readString(3, true);
        this.wGroupFace = jceInputStream.read(this.wGroupFace, 4, true);
        this.strGroupMemo = jceInputStream.readString(5, true);
        this.strFingerMemo = jceInputStream.readString(6, true);
        this.dwValidMask = jceInputStream.read(this.dwValidMask, 7, false);
        this.strRichFingerMemo = jceInputStream.readString(8, false);
        this.wVersion = jceInputStream.read(this.wVersion, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwGroupCode, 0);
        jceOutputStream.write(this.cGroupOption, 1);
        jceOutputStream.write(this.dwGroupClass, 2);
        jceOutputStream.write(this.strGroupName, 3);
        jceOutputStream.write(this.wGroupFace, 4);
        jceOutputStream.write(this.strGroupMemo, 5);
        jceOutputStream.write(this.strFingerMemo, 6);
        jceOutputStream.write(this.dwValidMask, 7);
        String str = this.strRichFingerMemo;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
        jceOutputStream.write(this.wVersion, 9);
    }

    public ModifyGroupInfoReq(long j3, long j16, long j17, String str, int i3, String str2, String str3, long j18, String str4, int i16) {
        this.dwGroupCode = j3;
        this.cGroupOption = j16;
        this.dwGroupClass = j17;
        this.strGroupName = str;
        this.wGroupFace = i3;
        this.strGroupMemo = str2;
        this.strFingerMemo = str3;
        this.dwValidMask = j18;
        this.strRichFingerMemo = str4;
        this.wVersion = i16;
    }
}
