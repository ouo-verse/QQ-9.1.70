package com.tencent.mtt.hippy.c.e;

import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mtt.hippy.c.f;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import org.apache.commons.lang.CharEncoding;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f337163d = {'d', 'a', 't', 'a', ':', 'i', 'm', 'a', 'g', 'e', '/'};

    /* renamed from: a, reason: collision with root package name */
    private final String[] f337164a = new String[2048];

    /* renamed from: b, reason: collision with root package name */
    private final int f337165b = 32;

    /* renamed from: c, reason: collision with root package name */
    private final LruCache<Integer, String> f337166c = new LruCache<>(32);

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, char[]> f337167e = new HashMap<String, char[]>() { // from class: com.tencent.mtt.hippy.c.e.b.1
        {
            put(LayoutAttrDefine.CLICK_URI, b.f337163d);
            put("src", b.f337163d);
            put("source", b.f337163d);
        }
    };

    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.c.e.b$2, reason: invalid class name */
    /* loaded from: classes20.dex */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f337169a;

        static {
            int[] iArr = new int[f.values().length];
            f337169a = iArr;
            try {
                iArr[f.OBJECT_KEY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f337169a[f.DENSE_ARRAY_KEY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f337169a[f.SPARSE_ARRAY_KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f337169a[f.MAP_KEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f337169a[f.OBJECT_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f337169a[f.DENSE_ARRAY_ITEM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f337169a[f.SPARSE_ARRAY_ITEM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f337169a[f.MAP_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f337169a[f.ERROR_MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f337169a[f.ERROR_STACK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f337169a[f.REGEXP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f337169a[f.SET_ITEM.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f337169a[f.TOP_LEVEL.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f337169a[f.VOID.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public static int a(byte[] bArr, int i3, int i16) {
        long j3 = 5381;
        while (i3 < i16) {
            j3 = bArr[i3] + (j3 << 5) + j3;
            i3++;
        }
        return (int) j3;
    }

    private static int b(byte[] bArr, int i3, int i16) {
        int i17 = 0;
        while (i3 < i16) {
            i17 = (i17 * 31) + (bArr[i3] & 255);
            i3++;
        }
        return i17;
    }

    @Override // com.tencent.mtt.hippy.c.e.a, com.tencent.mtt.hippy.c.e.c
    public String a(@NonNull ByteBuffer byteBuffer, @NonNull String str, f fVar, Object obj) throws UnsupportedEncodingException {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position() + byteBuffer.arrayOffset();
        int limit = byteBuffer.limit() - byteBuffer.position();
        switch (AnonymousClass2.f337169a[fVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return a(array, position, limit, str);
            case 5:
            case 6:
            case 7:
            case 8:
                return a(array, position, limit, str, obj);
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return super.a(byteBuffer, str, fVar, obj);
            case 14:
                return "";
            default:
                throw new com.tencent.mtt.hippy.b.b();
        }
    }

    private String a(byte[] bArr, int i3, int i16, @NonNull String str) throws UnsupportedEncodingException {
        if (i16 >= 32 || str.equals("UTF-8")) {
            return new String(bArr, i3, i16, str);
        }
        int a16 = a(bArr, i3, i16);
        int length = a16 & (r1.length - 1);
        String str2 = this.f337164a[length];
        if (str2 != null && a(bArr, i3, i16, str, str2)) {
            return str2;
        }
        String str3 = new String(bArr, i3, i16, str);
        this.f337164a[length] = str3;
        return str3;
    }

    private String a(byte[] bArr, int i3, int i16, @NonNull String str, Object obj) throws UnsupportedEncodingException {
        char[] cArr;
        String str2;
        int i17;
        if (!(obj instanceof String) || (cArr = this.f337167e.get(obj)) == null) {
            return new String(bArr, i3, i16, str);
        }
        boolean z16 = false;
        int i18 = 0;
        while (true) {
            if (i18 >= cArr.length) {
                z16 = true;
                break;
            }
            if (((byte) cArr[i18]) != bArr[i18]) {
                break;
            }
            i18++;
        }
        if (z16) {
            i17 = b(bArr, i3, i16);
            str2 = this.f337166c.get(Integer.valueOf(i17));
        } else {
            str2 = null;
            i17 = -1;
        }
        if (str2 == null) {
            str2 = new String(bArr, i3, i16, str);
            if (z16) {
                this.f337166c.put(Integer.valueOf(i17), str2);
            }
        }
        return str2;
    }

    @Override // com.tencent.mtt.hippy.c.e.a, com.tencent.mtt.hippy.c.e.c
    public void a() {
        this.f337166c.evictAll();
        super.a();
    }

    private boolean a(byte[] bArr, int i3, int i16, @NonNull String str, @NonNull String str2) {
        int i17 = str.equals(CharEncoding.UTF_16LE) ? 2 : 1;
        int length = str2.length();
        if (i16 / i17 != length) {
            return false;
        }
        for (int i18 = 0; i18 < length; i18++) {
            char charAt = str2.charAt(i18);
            int i19 = i3 + i18;
            if (bArr[i19] != ((byte) charAt) || (i17 == 2 && bArr[i19 + 1] != ((byte) (charAt >> '\b')))) {
                return false;
            }
        }
        return true;
    }
}
