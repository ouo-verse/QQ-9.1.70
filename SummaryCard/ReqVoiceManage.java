package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqVoiceManage extends JceStruct {
    static int cache_eOpType;
    static VoiceInfo cache_stVoiceInfo;
    public int eOpType;
    public long lFriendUin;
    public VoiceInfo stVoiceInfo;

    public ReqVoiceManage() {
        this.eOpType = 0;
        this.stVoiceInfo = null;
        this.lFriendUin = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.eOpType = jceInputStream.read(this.eOpType, 0, true);
        if (cache_stVoiceInfo == null) {
            cache_stVoiceInfo = new VoiceInfo();
        }
        this.stVoiceInfo = (VoiceInfo) jceInputStream.read((JceStruct) cache_stVoiceInfo, 1, true);
        this.lFriendUin = jceInputStream.read(this.lFriendUin, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.eOpType, 0);
        jceOutputStream.write((JceStruct) this.stVoiceInfo, 1);
        jceOutputStream.write(this.lFriendUin, 2);
    }

    public ReqVoiceManage(int i3, VoiceInfo voiceInfo, long j3) {
        this.eOpType = i3;
        this.stVoiceInfo = voiceInfo;
        this.lFriendUin = j3;
    }
}
