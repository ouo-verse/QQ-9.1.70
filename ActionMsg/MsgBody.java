package ActionMsg;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgBody extends JceStruct {
    public String actMsgContentValue;
    public String action;

    /* renamed from: msg, reason: collision with root package name */
    public String f24895msg;
    public long shareAppID;

    public MsgBody() {
        this.f24895msg = "";
        this.action = "";
        this.shareAppID = 0L;
        this.actMsgContentValue = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.f24895msg = jceInputStream.readString(0, true);
        this.action = jceInputStream.readString(1, true);
        this.shareAppID = jceInputStream.read(this.shareAppID, 2, false);
        this.actMsgContentValue = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f24895msg, 0);
        jceOutputStream.write(this.action, 1);
        jceOutputStream.write(this.shareAppID, 2);
        String str = this.actMsgContentValue;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public MsgBody(String str, String str2, long j3, String str3) {
        this.f24895msg = str;
        this.action = str2;
        this.shareAppID = j3;
        this.actMsgContentValue = str3;
    }
}
