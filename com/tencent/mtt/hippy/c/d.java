package com.tencent.mtt.hippy.c;

import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.math.BigInteger;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Map;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class d extends e {

    /* renamed from: a, reason: collision with root package name */
    protected com.tencent.mtt.hippy.c.c.b.b f337140a;

    /* renamed from: f, reason: collision with root package name */
    private final int f337141f;

    /* renamed from: g, reason: collision with root package name */
    private int f337142g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Object, Integer> f337143h = new IdentityHashMap();

    /* renamed from: i, reason: collision with root package name */
    private char[] f337144i;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(com.tencent.mtt.hippy.c.c.b.b bVar, int i3) {
        this.f337140a = bVar;
        this.f337141f = i3;
    }

    public void a() {
        this.f337143h.clear();
        this.f337142g = 0;
        this.f337144i = null;
    }

    public void b() {
        a((byte) -1);
        this.f337140a.a(this.f337141f);
    }

    public int c() {
        return this.f337141f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(byte b16) {
        this.f337140a.a(b16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Object obj) {
        Map<Object, Integer> map = this.f337143h;
        int i3 = this.f337142g;
        this.f337142g = i3 + 1;
        map.put(obj, Integer.valueOf(i3));
    }

    public void a(double d16) {
        this.f337140a.a(d16);
    }

    protected void a(int i3) {
        this.f337140a.a(com.tencent.mtt.hippy.c.f.a.a((i3 >> 31) ^ (i3 << 1)));
    }

    public void a(com.tencent.mtt.hippy.c.c.b.b bVar) {
        this.f337140a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull String str) {
        int length = str.length();
        int i3 = 0;
        if (length > 32) {
            char[] cArr = this.f337144i;
            if (cArr == null || cArr.length < length) {
                this.f337144i = new char[length];
            }
            str.getChars(0, length, this.f337144i, 0);
        }
        a(WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION);
        long j3 = length;
        int a16 = this.f337140a.a(j3) + 1;
        int i16 = 0;
        if (length <= 32) {
            while (i16 < length) {
                char charAt = str.charAt(i16);
                if (charAt > '\u00ff') {
                    break;
                }
                this.f337140a.a((byte) charAt);
                i16++;
            }
        } else {
            while (i16 < length) {
                char c16 = this.f337144i[i16];
                if (c16 > '\u00ff') {
                    break;
                }
                this.f337140a.a((byte) c16);
                i16++;
            }
        }
        if (i16 == length) {
            return;
        }
        this.f337140a.a((-a16) - i16);
        a((byte) 99);
        this.f337140a.a(j3 * 2);
        if (length > 32) {
            while (i3 < length) {
                this.f337140a.a(this.f337144i[i3]);
                i3++;
            }
            return;
        }
        while (i3 < length) {
            this.f337140a.a(str.charAt(i3));
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull BigInteger bigInteger) {
        boolean z16 = bigInteger.signum() == -1;
        if (z16) {
            bigInteger = bigInteger.negate();
        }
        int bitLength = ((bigInteger.bitLength() + 63) / 64) * 8;
        int i3 = bitLength << 1;
        if (z16) {
            i3++;
        }
        this.f337140a.a(i3);
        int i16 = 0;
        while (i16 < bitLength) {
            int i17 = i16 + 1;
            byte b16 = 0;
            for (int i18 = (i17 * 8) - 1; i18 >= i16 * 8; i18--) {
                b16 = (byte) (b16 << 1);
                if (bigInteger.testBit(i18)) {
                    b16 = (byte) (b16 + 1);
                }
            }
            this.f337140a.a(b16);
            i16 = i17;
        }
    }

    private void a(@NonNull Date date) {
        a((byte) 68);
        this.f337140a.a(date.getTime());
    }

    public boolean a(Object obj) {
        byte b16;
        if (obj instanceof String) {
            a((String) obj);
            return true;
        }
        if (obj instanceof Number) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                a((byte) 73);
                a(((Integer) obj).intValue());
                return true;
            }
            if (obj instanceof Long) {
                long longValue = ((Long) obj).longValue();
                if (longValue <= 4294967295L && longValue >= 0) {
                    a((byte) 85);
                    this.f337140a.a(longValue);
                    return true;
                }
            } else if (obj instanceof BigInteger) {
                a((byte) 90);
                a((BigInteger) obj);
                return true;
            }
            a((byte) 78);
            this.f337140a.a(((Number) obj).doubleValue());
            return true;
        }
        if (obj == Boolean.TRUE) {
            b16 = 84;
        } else if (obj == Boolean.FALSE) {
            b16 = 70;
        } else if (obj == this.f337162d) {
            b16 = MultipartStream.DASH;
        } else if (obj == this.f337161c) {
            b16 = 95;
        } else {
            if (obj != this.f337160b) {
                if (this.f337143h.get(obj) != null) {
                    a((byte) 94);
                    this.f337140a.a(r0.intValue());
                    return true;
                }
                if (!(obj instanceof Date)) {
                    return false;
                }
                b(obj);
                a((Date) obj);
                return true;
            }
            b16 = 48;
        }
        a(b16);
        return true;
    }
}
