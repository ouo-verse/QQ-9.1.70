package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class CompressedPackage extends JceStruct {
    static byte[] cache_buffer;
    static int cache_command;
    public byte[] buffer;
    public int command;
    public boolean compressed;

    public CompressedPackage() {
        this.compressed = true;
        this.command = 0;
        this.buffer = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.compressed = jceInputStream.read(this.compressed, 0, true);
        this.command = jceInputStream.read(this.command, 1, true);
        if (cache_buffer == null) {
            cache_buffer = r0;
            byte[] bArr = {0};
        }
        this.buffer = jceInputStream.read(cache_buffer, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.compressed, 0);
        jceOutputStream.write(this.command, 1);
        jceOutputStream.write(this.buffer, 2);
    }

    public CompressedPackage(boolean z16, int i3, byte[] bArr) {
        this.compressed = z16;
        this.command = i3;
        this.buffer = bArr;
    }
}
