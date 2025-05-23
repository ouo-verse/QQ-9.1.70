package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetReminderRsp extends JceStruct {
    static ReminderInfo cache_stReminderInfo;
    public int iRet;
    public String sMsg;
    public ReminderInfo stReminderInfo;

    public GetReminderRsp() {
        this.sMsg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRet = jceInputStream.read(this.iRet, 0, true);
        this.sMsg = jceInputStream.readString(1, true);
        if (cache_stReminderInfo == null) {
            cache_stReminderInfo = new ReminderInfo();
        }
        this.stReminderInfo = (ReminderInfo) jceInputStream.read((JceStruct) cache_stReminderInfo, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRet, 0);
        jceOutputStream.write(this.sMsg, 1);
        jceOutputStream.write((JceStruct) this.stReminderInfo, 2);
    }

    public GetReminderRsp(int i3, String str, ReminderInfo reminderInfo) {
        this.iRet = i3;
        this.sMsg = str;
        this.stReminderInfo = reminderInfo;
    }
}
