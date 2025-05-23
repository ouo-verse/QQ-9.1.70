package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QmfServerInfo extends JceStruct {
    static QmfClientIpInfo cache_ipWebapp;
    public long changeTime;
    public QmfClientIpInfo ipWebapp;

    public QmfServerInfo() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_ipWebapp == null) {
            cache_ipWebapp = new QmfClientIpInfo();
        }
        this.ipWebapp = (QmfClientIpInfo) jceInputStream.read((JceStruct) cache_ipWebapp, 0, true);
        this.changeTime = jceInputStream.read(this.changeTime, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.ipWebapp, 0);
        jceOutputStream.write(this.changeTime, 1);
    }

    public QmfServerInfo(QmfClientIpInfo qmfClientIpInfo, long j3) {
        this.ipWebapp = qmfClientIpInfo;
        this.changeTime = j3;
    }
}
