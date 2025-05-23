package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_video_shuoshuo_upload_finish_rsp extends JceStruct {
    public int iRet;
    public String strErrMsg;

    public mobile_video_shuoshuo_upload_finish_rsp() {
        this.strErrMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, false);
        this.strErrMsg = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
        String str = this.strErrMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public mobile_video_shuoshuo_upload_finish_rsp(int i3, String str) {
        this.iRet = i3;
        this.strErrMsg = str;
    }
}
