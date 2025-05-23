package com.tencent.ams.hippo.quickjs.android;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class JSFloat64 extends JSNumber {
    static IPatchRedirector $redirector_;
    private final double value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSFloat64(long j3, JSContext jSContext, double d16) {
        super(j3, jSContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), jSContext, Double.valueOf(d16));
        } else {
            this.value = d16;
        }
    }

    private String wrongNumberMessage(String str, double d16) {
        return "Can't treat " + d16 + " as " + str;
    }

    @Override // com.tencent.ams.hippo.quickjs.android.JSNumber
    public byte getByte() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Byte) iPatchRedirector.redirect((short) 2, (Object) this)).byteValue();
        }
        double d16 = this.value;
        byte b16 = (byte) d16;
        if (b16 == d16) {
            return b16;
        }
        throw new JSDataException(wrongNumberMessage("byte", d16));
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
        return (float) this.value;
    }

    @Override // com.tencent.ams.hippo.quickjs.android.JSNumber
    public int getInt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        double d16 = this.value;
        int i3 = (int) d16;
        if (i3 == d16) {
            return i3;
        }
        throw new JSDataException(wrongNumberMessage(PoiListCacheRecord.WEIGHT_TYPE, d16));
    }

    @Override // com.tencent.ams.hippo.quickjs.android.JSNumber
    public long getLong() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        double d16 = this.value;
        long j3 = (long) d16;
        if (j3 == d16) {
            return j3;
        }
        throw new JSDataException(wrongNumberMessage(PoiListCacheRecord.TIMESTAMP_TYPE, d16));
    }

    @Override // com.tencent.ams.hippo.quickjs.android.JSNumber
    public short getShort() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Short) iPatchRedirector.redirect((short) 3, (Object) this)).shortValue();
        }
        double d16 = this.value;
        short s16 = (short) d16;
        if (s16 == d16) {
            return s16;
        }
        throw new JSDataException(wrongNumberMessage(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT, d16));
    }
}
