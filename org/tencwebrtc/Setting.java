package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Setting {
    public boolean dump_decoded_bitstream;
    public String dump_path;
    public boolean dump_received_bitstream;
    public long dump_size;

    private static native void nativeConfigure(boolean z16, boolean z17, long j3, String str);

    public void configure() {
        nativeConfigure(this.dump_received_bitstream, this.dump_decoded_bitstream, this.dump_size, this.dump_path);
    }
}
