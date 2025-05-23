package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CKV_HasLiked extends JceStruct {
    public boolean hasLiked;

    public CKV_HasLiked() {
        this.hasLiked = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hasLiked = jceInputStream.read(this.hasLiked, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.hasLiked, 0);
    }

    public CKV_HasLiked(boolean z16) {
        this.hasLiked = z16;
    }
}
