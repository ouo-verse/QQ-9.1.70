package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SSummaryCardLableRsp extends JceStruct {
    static SUserLabel cache_likes;
    static int cache_ret;
    public SUserLabel likes;

    /* renamed from: msg, reason: collision with root package name */
    public String f25108msg;
    public int ret;

    public SSummaryCardLableRsp() {
        this.ret = 0;
        this.f25108msg = "";
        this.likes = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, true);
        this.f25108msg = jceInputStream.readString(1, false);
        if (cache_likes == null) {
            cache_likes = new SUserLabel();
        }
        this.likes = (SUserLabel) jceInputStream.read((JceStruct) cache_likes, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25108msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        SUserLabel sUserLabel = this.likes;
        if (sUserLabel != null) {
            jceOutputStream.write((JceStruct) sUserLabel, 2);
        }
    }

    public SSummaryCardLableRsp(int i3, String str, SUserLabel sUserLabel) {
        this.ret = i3;
        this.f25108msg = str;
        this.likes = sUserLabel;
    }
}
