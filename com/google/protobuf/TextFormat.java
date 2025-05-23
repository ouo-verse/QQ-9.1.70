package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.cc;
import com.google.protobuf.p;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TextFormat {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f35606a = Logger.getLogger(TextFormat.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final Parser f35607b = Parser.a().a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        InvalidEscapeSequenceException(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Parser {

        /* renamed from: a, reason: collision with root package name */
        private final ca f35608a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f35609b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f35610c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f35611d;

        /* renamed from: e, reason: collision with root package name */
        private final SingularOverwritePolicy f35612e;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public enum SingularOverwritePolicy {
            ALLOW_SINGULAR_OVERWRITES,
            FORBID_SINGULAR_OVERWRITES
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private boolean f35613a = false;

            /* renamed from: b, reason: collision with root package name */
            private boolean f35614b = false;

            /* renamed from: c, reason: collision with root package name */
            private boolean f35615c = false;

            /* renamed from: d, reason: collision with root package name */
            private SingularOverwritePolicy f35616d = SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;

            /* renamed from: e, reason: collision with root package name */
            private ca f35617e = ca.c();

            public Parser a() {
                return new Parser(this.f35617e, this.f35613a, this.f35614b, this.f35615c, this.f35616d, null, null);
            }
        }

        /* synthetic */ Parser(ca caVar, boolean z16, boolean z17, boolean z18, SingularOverwritePolicy singularOverwritePolicy, bz bzVar, a aVar) {
            this(caVar, z16, z17, z18, singularOverwritePolicy, bzVar);
        }

        public static a a() {
            return new a();
        }

        Parser(ca caVar, boolean z16, boolean z17, boolean z18, SingularOverwritePolicy singularOverwritePolicy, bz bzVar) {
            this.f35608a = caVar;
            this.f35609b = z16;
            this.f35610c = z17;
            this.f35611d = z18;
            this.f35612e = singularOverwritePolicy;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35618a;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            f35618a = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f35618a[Descriptors.FieldDescriptor.Type.f35373GROUP.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        private static final b f35619c = new b(true, ca.c());

        /* renamed from: a, reason: collision with root package name */
        private final boolean f35620a;

        /* renamed from: b, reason: collision with root package name */
        private final ca f35621b;

        b(boolean z16, ca caVar) {
            this.f35620a = z16;
            this.f35621b = caVar;
        }

        private void b(ax axVar, c cVar) throws IOException {
            if (axVar.getDescriptorForType().i().equals("google.protobuf.Any") && e(axVar, cVar)) {
                return;
            }
            h(axVar, cVar);
        }

        private boolean e(ax axVar, c cVar) throws IOException {
            Descriptors.b descriptorForType = axVar.getDescriptorForType();
            Descriptors.FieldDescriptor o16 = descriptorForType.o(1);
            Descriptors.FieldDescriptor o17 = descriptorForType.o(2);
            if (o16 != null && o16.y() == Descriptors.FieldDescriptor.Type.STRING && o17 != null && o17.y() == Descriptors.FieldDescriptor.Type.BYTES) {
                String str = (String) axVar.getField(o16);
                if (str.isEmpty()) {
                    return false;
                }
                Object field = axVar.getField(o17);
                try {
                    Descriptors.b b16 = this.f35621b.b(str);
                    if (b16 == null) {
                        return false;
                    }
                    p.b newBuilderForType = p.e(b16).newBuilderForType();
                    newBuilderForType.mergeFrom((ByteString) field);
                    cVar.d("[");
                    cVar.d(str);
                    cVar.d("] {");
                    cVar.a();
                    cVar.b();
                    b(newBuilderForType, cVar);
                    cVar.c();
                    cVar.d("}");
                    cVar.a();
                    return true;
                } catch (InvalidProtocolBufferException unused) {
                }
            }
            return false;
        }

        private void f(Descriptors.FieldDescriptor fieldDescriptor, Object obj, c cVar) throws IOException {
            if (fieldDescriptor.isRepeated()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i(fieldDescriptor, it.next(), cVar);
                }
                return;
            }
            i(fieldDescriptor, obj, cVar);
        }

        private void g(Descriptors.FieldDescriptor fieldDescriptor, Object obj, c cVar) throws IOException {
            String replace;
            switch (a.f35618a[fieldDescriptor.y().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    cVar.d(((Integer) obj).toString());
                    return;
                case 4:
                case 5:
                case 6:
                    cVar.d(((Long) obj).toString());
                    return;
                case 7:
                    cVar.d(((Boolean) obj).toString());
                    return;
                case 8:
                    cVar.d(((Float) obj).toString());
                    return;
                case 9:
                    cVar.d(((Double) obj).toString());
                    return;
                case 10:
                case 11:
                    cVar.d(TextFormat.p(((Integer) obj).intValue()));
                    return;
                case 12:
                case 13:
                    cVar.d(TextFormat.q(((Long) obj).longValue()));
                    return;
                case 14:
                    cVar.d("\"");
                    if (this.f35620a) {
                        replace = bx.e((String) obj);
                    } else {
                        replace = TextFormat.e((String) obj).replace("\n", RedTouch.NEWLINE_CHAR);
                    }
                    cVar.d(replace);
                    cVar.d("\"");
                    return;
                case 15:
                    cVar.d("\"");
                    if (obj instanceof ByteString) {
                        cVar.d(TextFormat.c((ByteString) obj));
                    } else {
                        cVar.d(TextFormat.d((byte[]) obj));
                    }
                    cVar.d("\"");
                    return;
                case 16:
                    cVar.d(((Descriptors.d) obj).getName());
                    return;
                case 17:
                case 18:
                    b((ar) obj, cVar);
                    return;
                default:
                    return;
            }
        }

        private void h(ax axVar, c cVar) throws IOException {
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : axVar.getAllFields().entrySet()) {
                f(entry.getKey(), entry.getValue(), cVar);
            }
            n(axVar.getUnknownFields(), cVar);
        }

        private void i(Descriptors.FieldDescriptor fieldDescriptor, Object obj, c cVar) throws IOException {
            if (fieldDescriptor.z()) {
                cVar.d("[");
                if (fieldDescriptor.q().u().getMessageSetWireFormat() && fieldDescriptor.y() == Descriptors.FieldDescriptor.Type.MESSAGE && fieldDescriptor.B() && fieldDescriptor.t() == fieldDescriptor.w()) {
                    cVar.d(fieldDescriptor.w().i());
                } else {
                    cVar.d(fieldDescriptor.i());
                }
                cVar.d("]");
            } else if (fieldDescriptor.y() == Descriptors.FieldDescriptor.Type.f35373GROUP) {
                cVar.d(fieldDescriptor.w().getName());
            } else {
                cVar.d(fieldDescriptor.getName());
            }
            Descriptors.FieldDescriptor.JavaType v3 = fieldDescriptor.v();
            Descriptors.FieldDescriptor.JavaType javaType = Descriptors.FieldDescriptor.JavaType.MESSAGE;
            if (v3 == javaType) {
                cVar.d(" {");
                cVar.a();
                cVar.b();
            } else {
                cVar.d(MsgSummary.STR_COLON);
            }
            g(fieldDescriptor, obj, cVar);
            if (fieldDescriptor.v() == javaType) {
                cVar.c();
                cVar.d("}");
            }
            cVar.a();
        }

        private static void l(int i3, int i16, List<?> list, c cVar) throws IOException {
            for (Object obj : list) {
                cVar.d(String.valueOf(i3));
                cVar.d(MsgSummary.STR_COLON);
                m(i16, obj, cVar);
                cVar.a();
            }
        }

        private static void m(int i3, Object obj, c cVar) throws IOException {
            int b16 = WireFormat.b(i3);
            if (b16 != 0) {
                if (b16 != 1) {
                    if (b16 != 2) {
                        if (b16 != 3) {
                            if (b16 == 5) {
                                cVar.d(String.format(null, "0x%08x", (Integer) obj));
                                return;
                            }
                            throw new IllegalArgumentException("Bad tag: " + i3);
                        }
                        n((cc) obj, cVar);
                        return;
                    }
                    try {
                        cc j3 = cc.j((ByteString) obj);
                        cVar.d("{");
                        cVar.a();
                        cVar.b();
                        n(j3, cVar);
                        cVar.c();
                        cVar.d("}");
                        return;
                    } catch (InvalidProtocolBufferException unused) {
                        cVar.d("\"");
                        cVar.d(TextFormat.c((ByteString) obj));
                        cVar.d("\"");
                        return;
                    }
                }
                cVar.d(String.format(null, "0x%016x", (Long) obj));
                return;
            }
            cVar.d(TextFormat.q(((Long) obj).longValue()));
        }

        private static void n(cc ccVar, c cVar) throws IOException {
            for (Map.Entry<Integer, cc.c> entry : ccVar.b().entrySet()) {
                int intValue = entry.getKey().intValue();
                cc.c value = entry.getValue();
                l(intValue, 0, value.s(), cVar);
                l(intValue, 5, value.l(), cVar);
                l(intValue, 1, value.m(), cVar);
                l(intValue, 2, value.p(), cVar);
                for (cc ccVar2 : value.n()) {
                    cVar.d(entry.getKey().toString());
                    cVar.d(" {");
                    cVar.a();
                    cVar.b();
                    n(ccVar2, cVar);
                    cVar.c();
                    cVar.d("}");
                    cVar.a();
                }
            }
        }

        public void c(ax axVar, Appendable appendable) throws IOException {
            b(axVar, TextFormat.h(appendable));
        }

        public void d(cc ccVar, Appendable appendable) throws IOException {
            n(ccVar, TextFormat.h(appendable));
        }

        public String j(ax axVar) {
            try {
                StringBuilder sb5 = new StringBuilder();
                c(axVar, sb5);
                return sb5.toString();
            } catch (IOException e16) {
                throw new IllegalStateException(e16);
            }
        }

        public String k(cc ccVar) {
            try {
                StringBuilder sb5 = new StringBuilder();
                d(ccVar, sb5);
                return sb5.toString();
            } catch (IOException e16) {
                throw new IllegalStateException(e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Appendable f35622a;

        /* renamed from: b, reason: collision with root package name */
        private final StringBuilder f35623b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f35624c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f35625d;

        /* synthetic */ c(Appendable appendable, boolean z16, a aVar) {
            this(appendable, z16);
        }

        public void a() throws IOException {
            if (!this.f35624c) {
                this.f35622a.append("\n");
            }
            this.f35625d = true;
        }

        public void b() {
            this.f35623b.append("  ");
        }

        public void c() {
            int length = this.f35623b.length();
            if (length != 0) {
                this.f35623b.setLength(length - 2);
                return;
            }
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void d(CharSequence charSequence) throws IOException {
            CharSequence charSequence2;
            if (this.f35625d) {
                this.f35625d = false;
                Appendable appendable = this.f35622a;
                if (this.f35624c) {
                    charSequence2 = " ";
                } else {
                    charSequence2 = this.f35623b;
                }
                appendable.append(charSequence2);
            }
            this.f35622a.append(charSequence);
        }

        c(Appendable appendable, boolean z16) {
            this.f35623b = new StringBuilder();
            this.f35625d = false;
            this.f35622a = appendable;
            this.f35624c = z16;
        }
    }

    TextFormat() {
    }

    private static int b(byte b16) {
        int i3;
        if (48 <= b16 && b16 <= 57) {
            return b16 - 48;
        }
        if (97 <= b16 && b16 <= 122) {
            i3 = b16 - 97;
        } else {
            i3 = b16 - 65;
        }
        return i3 + 10;
    }

    public static String c(ByteString byteString) {
        return bx.a(byteString);
    }

    public static String d(byte[] bArr) {
        return bx.c(bArr);
    }

    public static String e(String str) {
        return bx.d(str);
    }

    private static boolean f(byte b16) {
        if ((48 <= b16 && b16 <= 57) || ((97 <= b16 && b16 <= 102) || (65 <= b16 && b16 <= 70))) {
            return true;
        }
        return false;
    }

    private static boolean g(byte b16) {
        if (48 <= b16 && b16 <= 55) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c h(Appendable appendable) {
        return new c(appendable, false, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(String str) throws NumberFormatException {
        return (int) k(str, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long j(String str) throws NumberFormatException {
        return k(str, true, true);
    }

    private static long k(String str, boolean z16, boolean z17) throws NumberFormatException {
        int i3;
        int i16 = 0;
        if (str.startsWith("-", 0)) {
            if (z16) {
                i16 = 1;
            } else {
                throw new NumberFormatException("Number must be positive: " + str);
            }
        }
        int i17 = i16;
        if (str.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING, i16)) {
            i16 += 2;
            i3 = 16;
        } else if (str.startsWith("0", i16)) {
            i3 = 8;
        } else {
            i3 = 10;
        }
        String substring = str.substring(i16);
        if (substring.length() < 16) {
            long parseLong = Long.parseLong(substring, i3);
            if (i17 != 0) {
                parseLong = -parseLong;
            }
            if (!z17) {
                if (z16) {
                    if (parseLong > TTL.MAX_VALUE || parseLong < WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
                    }
                    return parseLong;
                }
                if (parseLong >= 4294967296L || parseLong < 0) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
                }
                return parseLong;
            }
            return parseLong;
        }
        BigInteger bigInteger = new BigInteger(substring, i3);
        if (i17 != 0) {
            bigInteger = bigInteger.negate();
        }
        if (!z17) {
            if (z16) {
                if (bigInteger.bitLength() > 31) {
                    throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
                }
            } else if (bigInteger.bitLength() > 32) {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
            }
        } else if (z16) {
            if (bigInteger.bitLength() > 63) {
                throw new NumberFormatException("Number out of range for 64-bit signed integer: " + str);
            }
        } else if (bigInteger.bitLength() > 64) {
            throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + str);
        }
        return bigInteger.longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(String str) throws NumberFormatException {
        return (int) k(str, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long m(String str) throws NumberFormatException {
        return k(str, false, true);
    }

    public static b n() {
        return b.f35619c;
    }

    public static ByteString o(CharSequence charSequence) throws InvalidEscapeSequenceException {
        int i3;
        int i16;
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(charSequence.toString());
        int size = copyFromUtf8.size();
        byte[] bArr = new byte[size];
        int i17 = 0;
        int i18 = 0;
        while (i17 < copyFromUtf8.size()) {
            byte byteAt = copyFromUtf8.byteAt(i17);
            if (byteAt == 92) {
                i17++;
                if (i17 < copyFromUtf8.size()) {
                    byte byteAt2 = copyFromUtf8.byteAt(i17);
                    if (g(byteAt2)) {
                        int b16 = b(byteAt2);
                        int i19 = i17 + 1;
                        if (i19 < copyFromUtf8.size() && g(copyFromUtf8.byteAt(i19))) {
                            b16 = (b16 * 8) + b(copyFromUtf8.byteAt(i19));
                            i17 = i19;
                        }
                        int i26 = i17 + 1;
                        if (i26 < copyFromUtf8.size() && g(copyFromUtf8.byteAt(i26))) {
                            b16 = (b16 * 8) + b(copyFromUtf8.byteAt(i26));
                            i17 = i26;
                        }
                        i3 = i18 + 1;
                        bArr[i18] = (byte) b16;
                    } else {
                        if (byteAt2 != 34) {
                            if (byteAt2 != 39) {
                                if (byteAt2 != 92) {
                                    if (byteAt2 != 102) {
                                        if (byteAt2 != 110) {
                                            if (byteAt2 != 114) {
                                                if (byteAt2 != 116) {
                                                    if (byteAt2 != 118) {
                                                        if (byteAt2 != 120) {
                                                            if (byteAt2 != 97) {
                                                                if (byteAt2 == 98) {
                                                                    i16 = i18 + 1;
                                                                    bArr[i18] = 8;
                                                                } else {
                                                                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) byteAt2) + '\'');
                                                                }
                                                            } else {
                                                                i16 = i18 + 1;
                                                                bArr[i18] = 7;
                                                            }
                                                        } else {
                                                            i17++;
                                                            if (i17 < copyFromUtf8.size() && f(copyFromUtf8.byteAt(i17))) {
                                                                int b17 = b(copyFromUtf8.byteAt(i17));
                                                                int i27 = i17 + 1;
                                                                if (i27 < copyFromUtf8.size() && f(copyFromUtf8.byteAt(i27))) {
                                                                    b17 = (b17 * 16) + b(copyFromUtf8.byteAt(i27));
                                                                    i17 = i27;
                                                                }
                                                                i3 = i18 + 1;
                                                                bArr[i18] = (byte) b17;
                                                            } else {
                                                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                                                            }
                                                        }
                                                    } else {
                                                        i16 = i18 + 1;
                                                        bArr[i18] = 11;
                                                    }
                                                } else {
                                                    i16 = i18 + 1;
                                                    bArr[i18] = 9;
                                                }
                                            } else {
                                                i16 = i18 + 1;
                                                bArr[i18] = 13;
                                            }
                                        } else {
                                            i16 = i18 + 1;
                                            bArr[i18] = 10;
                                        }
                                    } else {
                                        i16 = i18 + 1;
                                        bArr[i18] = 12;
                                    }
                                } else {
                                    i16 = i18 + 1;
                                    bArr[i18] = 92;
                                }
                            } else {
                                i16 = i18 + 1;
                                bArr[i18] = 39;
                            }
                        } else {
                            i16 = i18 + 1;
                            bArr[i18] = WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION;
                        }
                        i18 = i16;
                        i17++;
                    }
                } else {
                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
                }
            } else {
                i3 = i18 + 1;
                bArr[i18] = byteAt;
            }
            i18 = i3;
            i17++;
        }
        if (size == i18) {
            return ByteString.wrap(bArr);
        }
        return ByteString.copyFrom(bArr, 0, i18);
    }

    public static String p(int i3) {
        if (i3 >= 0) {
            return Integer.toString(i3);
        }
        return Long.toString(i3 & 4294967295L);
    }

    public static String q(long j3) {
        if (j3 >= 0) {
            return Long.toString(j3);
        }
        return BigInteger.valueOf(j3 & Long.MAX_VALUE).setBit(63).toString();
    }
}
