package com.tencent.ams.hippo.quickjs.android;

import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class JSInt extends JSNumber {
    static IPatchRedirector $redirector_;
    private final int value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSInt(long j3, JSContext jSContext, int i3) {
        super(j3, jSContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), jSContext, Integer.valueOf(i3));
        } else {
            this.value = i3;
        }
    }

    private int getIntInRange(String str, int i3, int i16) {
        int i17 = this.value;
        if (i3 <= i17 && i17 <= i16) {
            return i17;
        }
        throw new JSDataException("Can't treat " + i17 + " as " + str);
    }

    @Override // com.tencent.ams.hippo.quickjs.android.JSNumber
    public byte getByte() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Byte) iPatchRedirector.redirect((short) 2, (Object) this)).byteValue();
        }
        return (byte) getIntInRange("byte", -128, 127);
    }

    @Override // com.tencent.ams.hippo.quickjs.android.JSNumber
    public double getDouble() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Double) iPatchRedirector.redirect((short) 7, (Object) this)).doubleValue();
        }
        return this.value;
    }

    @Override // com.tencent.ams.hippo.quickjs.android.JSNumber
    public float getFloat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.value;
    }

    @Override // com.tencent.ams.hippo.quickjs.android.JSNumber
    public int getInt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.value;
    }

    @Override // com.tencent.ams.hippo.quickjs.android.JSNumber
    public long getLong() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.value;
    }

    @Override // com.tencent.ams.hippo.quickjs.android.JSNumber
    public short getShort() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Short) iPatchRedirector.redirect((short) 3, (Object) this)).shortValue();
        }
        return (short) getIntInRange(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT, -32768, 32767);
    }
}
