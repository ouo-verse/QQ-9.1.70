package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class l extends d {

    /* renamed from: a, reason: collision with root package name */
    public int f422779a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f422780b = 0;

    public l() {
        this._type = 6;
    }

    @Override // oicq.wlogin_sdk.devicelock.d
    public void parse() {
        int i3 = this._head_len;
        this.f422779a = util.buf_to_int16(this._buf, i3);
        this.f422780b = util.buf_to_int16(this._buf, i3 + 2);
    }
}
