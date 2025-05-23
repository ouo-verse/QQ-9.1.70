package RegisterProxySvcPack;

import IPwdPxyMQQ.RespondHeader;
import IPwdPxyMQQ.RespondQueryIPwdStat;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcResponseIpwdStat extends JceStruct {
    static RespondHeader cache_stRespondHeader;
    static RespondQueryIPwdStat cache_stRespondQueryIPwdStat;
    public RespondHeader stRespondHeader;
    public RespondQueryIPwdStat stRespondQueryIPwdStat;

    public SvcResponseIpwdStat() {
        this.stRespondHeader = null;
        this.stRespondQueryIPwdStat = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stRespondHeader == null) {
            cache_stRespondHeader = new RespondHeader();
        }
        this.stRespondHeader = (RespondHeader) jceInputStream.read((JceStruct) cache_stRespondHeader, 0, true);
        if (cache_stRespondQueryIPwdStat == null) {
            cache_stRespondQueryIPwdStat = new RespondQueryIPwdStat();
        }
        this.stRespondQueryIPwdStat = (RespondQueryIPwdStat) jceInputStream.read((JceStruct) cache_stRespondQueryIPwdStat, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stRespondHeader, 0);
        jceOutputStream.write((JceStruct) this.stRespondQueryIPwdStat, 1);
    }

    public SvcResponseIpwdStat(RespondHeader respondHeader, RespondQueryIPwdStat respondQueryIPwdStat) {
        this.stRespondHeader = respondHeader;
        this.stRespondQueryIPwdStat = respondQueryIPwdStat;
    }
}
