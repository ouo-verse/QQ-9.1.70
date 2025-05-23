package com.tencent.theme;

import android.content.res.XmlResourceParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes26.dex */
public class AndroidXmlResourceParser implements XmlResourceParser {
    static IPatchRedirector $redirector_ = null;
    private static final int ATTRIBUTE_IX_NAME = 1;
    private static final int ATTRIBUTE_IX_NAMESPACE_URI = 0;
    private static final int ATTRIBUTE_IX_VALUE_DATA = 4;
    private static final int ATTRIBUTE_IX_VALUE_STRING = 2;
    private static final int ATTRIBUTE_IX_VALUE_TYPE = 3;
    private static final int ATTRIBUTE_LENGHT = 5;
    private static final int CHUNK_AXML_FILE = 524291;
    private static final int CHUNK_RESOURCEIDS = 524672;
    private static final int CHUNK_XML_END_NAMESPACE = 1048833;
    private static final int CHUNK_XML_END_TAG = 1048835;
    private static final int CHUNK_XML_FIRST = 1048832;
    private static final int CHUNK_XML_LAST = 1048836;
    private static final int CHUNK_XML_START_NAMESPACE = 1048832;
    private static final int CHUNK_XML_START_TAG = 1048834;
    private static final int CHUNK_XML_TEXT = 1048836;
    private static final String E_NOT_SUPPORTED = "Method is not supported.";
    private ByteBuffer mBuffer;
    private int[] m_attributes;
    private int m_classAttribute;
    private boolean m_decreaseDepth;
    private int m_event;
    private int m_idAttribute;
    private int m_lineNumber;
    private int m_name;
    private int m_namespaceUri;
    private final a m_namespaces;
    private boolean m_operational;
    private int[] m_resourceIDs;
    private q m_strings;
    private int m_styleAttribute;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int[] f376028a;

        /* renamed from: b, reason: collision with root package name */
        private int f376029b;

        /* renamed from: c, reason: collision with root package name */
        private int f376030c;

        /* renamed from: d, reason: collision with root package name */
        private int f376031d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f376028a = new int[32];
            }
        }

        private void b(int i3) {
            int[] iArr = this.f376028a;
            int length = iArr.length;
            int i16 = this.f376029b;
            int i17 = length - i16;
            if (i17 > i3) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i17) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i16);
            this.f376028a = iArr2;
        }

        private int c(int i3, boolean z16) {
            int i16 = this.f376029b;
            if (i16 == 0) {
                return -1;
            }
            int i17 = i16 - 1;
            for (int i18 = this.f376031d; i18 != 0; i18--) {
                i17 -= 2;
                for (int i19 = this.f376028a[i17]; i19 != 0; i19--) {
                    if (z16) {
                        int[] iArr = this.f376028a;
                        if (iArr[i17] == i3) {
                            return iArr[i17 + 1];
                        }
                    } else {
                        int[] iArr2 = this.f376028a;
                        if (iArr2[i17 + 1] == i3) {
                            return iArr2[i17];
                        }
                    }
                    i17 -= 2;
                }
            }
            return -1;
        }

        private int e(int i3, boolean z16) {
            if (this.f376029b != 0 && i3 >= 0) {
                int i16 = 0;
                for (int i17 = this.f376031d; i17 != 0; i17--) {
                    int[] iArr = this.f376028a;
                    int i18 = iArr[i16];
                    if (i3 >= i18) {
                        i3 -= i18;
                        i16 += (i18 * 2) + 2;
                    } else {
                        int i19 = i16 + (i3 * 2) + 1;
                        if (!z16) {
                            i19++;
                        }
                        return iArr[i19];
                    }
                }
            }
            return -1;
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this);
                return;
            }
            int i3 = this.f376029b;
            if (i3 == 0) {
                return;
            }
            int i16 = i3 - 1;
            int i17 = this.f376028a[i16];
            int i18 = i17 * 2;
            if ((i16 - 1) - i18 == 0) {
                return;
            }
            this.f376029b = i3 - (i18 + 2);
            this.f376030c -= i17;
            this.f376031d--;
        }

        public int d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
            }
            return c(i3, false);
        }

        public int f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
            }
            int i16 = 0;
            if (this.f376029b != 0 && i3 >= 0) {
                int i17 = this.f376031d;
                if (i3 > i17) {
                    i3 = i17;
                }
                int i18 = 0;
                while (i3 != 0) {
                    int i19 = this.f376028a[i18];
                    i16 += i19;
                    i18 += (i19 * 2) + 2;
                    i3--;
                }
            }
            return i16;
        }

        public int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            int i3 = this.f376029b;
            if (i3 == 0) {
                return 0;
            }
            return this.f376028a[i3 - 1];
        }

        public int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            return this.f376031d;
        }

        public int i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, i3)).intValue();
            }
            return e(i3, true);
        }

        public int j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
            }
            return e(i3, false);
        }

        public void k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this);
                return;
            }
            b(2);
            int i3 = this.f376029b;
            int[] iArr = this.f376028a;
            iArr[i3] = 0;
            iArr[i3 + 1] = 0;
            this.f376029b = i3 + 2;
            this.f376031d++;
        }

        public boolean l() {
            int i3;
            int[] iArr;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            int i17 = this.f376029b;
            if (i17 == 0 || (i16 = (iArr = this.f376028a)[i17 - 1]) == 0) {
                return false;
            }
            int i18 = i16 - 1;
            int i19 = i3 - 2;
            iArr[i19] = i18;
            iArr[i19 - ((i18 * 2) + 1)] = i18;
            this.f376029b = i17 - 2;
            this.f376030c--;
            return true;
        }

        public void m(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (this.f376031d == 0) {
                k();
            }
            b(2);
            int i17 = this.f376029b;
            int i18 = i17 - 1;
            int[] iArr = this.f376028a;
            int i19 = iArr[i18];
            int i26 = (i18 - 1) - (i19 * 2);
            int i27 = i19 + 1;
            iArr[i26] = i27;
            iArr[i18] = i3;
            iArr[i18 + 1] = i16;
            iArr[i18 + 2] = i27;
            this.f376029b = i17 + 2;
            this.f376030c++;
        }

        public void n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f376029b = 0;
            this.f376030c = 0;
            this.f376031d = 0;
        }
    }

    public AndroidXmlResourceParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.m_operational = false;
        this.m_namespaces = new a();
        resetEventInfo();
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x018c, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r6 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void doNext() throws IOException {
        int i3;
        int i16;
        if (this.m_strings == null) {
            com.tencent.theme.a.b(this.mBuffer, CHUNK_AXML_FILE);
            com.tencent.theme.a.d(this.mBuffer, 4);
            this.m_strings = q.c(this.mBuffer);
            this.m_namespaces.k();
            this.m_operational = true;
        }
        int i17 = this.m_event;
        if (i17 == 1) {
            return;
        }
        resetEventInfo();
        while (true) {
            if (this.m_decreaseDepth) {
                this.m_decreaseDepth = false;
                this.m_namespaces.a();
            }
            int i18 = 3;
            if (i17 == 3 && this.m_namespaces.h() == 1 && this.m_namespaces.g() == 0) {
                this.m_event = 1;
                return;
            }
            if (i17 == 0) {
                i3 = CHUNK_XML_START_TAG;
            } else {
                i3 = this.mBuffer.getInt();
            }
            if (i3 == CHUNK_RESOURCEIDS) {
                i16 = this.mBuffer.getInt();
                if (i16 < 8 || i16 % 4 != 0) {
                    break;
                } else {
                    this.m_resourceIDs = com.tencent.theme.a.c(this.mBuffer, (i16 / 4) - 2);
                }
            } else {
                if (i3 < 1048832 || i3 > 1048836) {
                    break;
                }
                if (i3 == CHUNK_XML_START_TAG && i17 == -1) {
                    this.m_event = 0;
                    return;
                }
                com.tencent.theme.a.d(this.mBuffer, 4);
                int i19 = this.mBuffer.getInt();
                com.tencent.theme.a.d(this.mBuffer, 4);
                if (i3 != 1048832 && i3 != CHUNK_XML_END_NAMESPACE) {
                    this.m_lineNumber = i19;
                    if (i3 == CHUNK_XML_START_TAG) {
                        this.m_namespaceUri = this.mBuffer.getInt();
                        this.m_name = this.mBuffer.getInt();
                        com.tencent.theme.a.d(this.mBuffer, 4);
                        int i26 = this.mBuffer.getInt();
                        this.m_idAttribute = (i26 >>> 16) - 1;
                        int i27 = this.mBuffer.getInt();
                        this.m_styleAttribute = (i27 >>> 16) - 1;
                        this.m_classAttribute = (65535 & i27) - 1;
                        this.m_attributes = com.tencent.theme.a.c(this.mBuffer, (i26 & 65535) * 5);
                        while (true) {
                            int[] iArr = this.m_attributes;
                            if (i18 < iArr.length) {
                                iArr[i18] = iArr[i18] >>> 24;
                                i18 += 5;
                            } else {
                                this.m_namespaces.k();
                                this.m_event = 2;
                                return;
                            }
                        }
                    } else {
                        if (i3 == CHUNK_XML_END_TAG) {
                            this.m_namespaceUri = this.mBuffer.getInt();
                            this.m_name = this.mBuffer.getInt();
                            this.m_event = 3;
                            this.m_decreaseDepth = true;
                            return;
                        }
                        if (i3 == 1048836) {
                            this.m_name = this.mBuffer.getInt();
                            com.tencent.theme.a.d(this.mBuffer, 4);
                            com.tencent.theme.a.d(this.mBuffer, 4);
                            this.m_event = 4;
                            return;
                        }
                    }
                } else if (i3 == 1048832) {
                    this.m_namespaces.m(this.mBuffer.getInt(), this.mBuffer.getInt());
                } else {
                    com.tencent.theme.a.d(this.mBuffer, 4);
                    com.tencent.theme.a.d(this.mBuffer, 4);
                    this.m_namespaces.l();
                }
            }
        }
        throw new IOException("Invalid resource ids size (" + i16 + ").");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        return r0 / 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int findAttribute(String str, String str2) {
        int a16;
        int i3;
        q qVar = this.m_strings;
        if (qVar == null || str2 == null || (a16 = qVar.a(str2)) == -1) {
            return -1;
        }
        if (str != null) {
            i3 = this.m_strings.a(str);
        } else {
            i3 = -1;
        }
        int i16 = 0;
        while (true) {
            int[] iArr = this.m_attributes;
            if (i16 == iArr.length) {
                break;
            }
            int i17 = i16 + 1;
            if (a16 != iArr[i17] || (i3 != -1 && i3 != iArr[i16 + 0])) {
                i16 = i17;
            }
        }
        return -1;
    }

    private final int getAttributeOffset(int i3) {
        if (this.m_event == 2) {
            int i16 = i3 * 5;
            if (i16 < this.m_attributes.length) {
                return i16;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i3 + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    private final void resetEventInfo() {
        this.m_event = -1;
        this.m_lineNumber = -1;
        this.m_name = -1;
        this.m_namespaceUri = -1;
        this.m_attributes = null;
        this.m_idAttribute = -1;
        this.m_classAttribute = -1;
        this.m_styleAttribute = -1;
    }

    @Override // android.content.res.XmlResourceParser, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!this.m_operational) {
            return;
        }
        this.m_operational = false;
        this.mBuffer = null;
        this.m_strings = null;
        this.m_resourceIDs = null;
        this.m_namespaces.n();
        resetEventInfo();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) throws XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) str, (Object) str2);
            return;
        }
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    @Override // android.util.AttributeSet
    public boolean getAttributeBooleanValue(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) ? getAttributeIntValue(i3, z16 ? 1 : 0) != 0 : ((Boolean) iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public int getAttributeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        if (this.m_event != 2) {
            return -1;
        }
        return this.m_attributes.length / 5;
    }

    @Override // android.util.AttributeSet
    public float getAttributeFloatValue(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Float) iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), Float.valueOf(f16))).floatValue();
        }
        int attributeOffset = getAttributeOffset(i3);
        int[] iArr = this.m_attributes;
        return iArr[attributeOffset + 3] == 4 ? Float.intBitsToFloat(iArr[attributeOffset + 4]) : f16;
    }

    @Override // android.util.AttributeSet
    public int getAttributeIntValue(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        int attributeOffset = getAttributeOffset(i3);
        int[] iArr = this.m_attributes;
        int i17 = iArr[attributeOffset + 3];
        return (i17 < 16 || i17 > 31) ? i16 : iArr[attributeOffset + 4];
    }

    @Override // android.util.AttributeSet
    public int getAttributeListValue(int i3, String[] strArr, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 43)) {
            return 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 43, this, Integer.valueOf(i3), strArr, Integer.valueOf(i16))).intValue();
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeName(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, i3);
        }
        int i16 = this.m_attributes[getAttributeOffset(i3) + 1];
        if (i16 == -1) {
            return "";
        }
        return this.m_strings.b(i16);
    }

    @Override // android.util.AttributeSet
    public int getAttributeNameResource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this, i3)).intValue();
        }
        int i16 = this.m_attributes[getAttributeOffset(i3) + 1];
        int[] iArr = this.m_resourceIDs;
        if (iArr != null && i16 >= 0 && i16 < iArr.length) {
            return iArr[i16];
        }
        return 0;
    }

    @Override // android.content.res.XmlResourceParser, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeNamespace(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this, i3);
        }
        int i16 = this.m_attributes[getAttributeOffset(i3) + 0];
        if (i16 == -1) {
            return "";
        }
        return this.m_strings.b(i16);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributePrefix(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this, i3);
        }
        int d16 = this.m_namespaces.d(this.m_attributes[getAttributeOffset(i3) + 0]);
        if (d16 == -1) {
            return "";
        }
        return this.m_strings.b(d16);
    }

    @Override // android.util.AttributeSet
    public int getAttributeResourceValue(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        int attributeOffset = getAttributeOffset(i3);
        int[] iArr = this.m_attributes;
        return iArr[attributeOffset + 3] == 1 ? iArr[attributeOffset + 4] : i16;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getAttributeType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (String) iPatchRedirector.redirect((short) 45, (Object) this, i3);
        }
        return "CDATA";
    }

    @Override // android.util.AttributeSet
    public int getAttributeUnsignedIntValue(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) ? getAttributeIntValue(i3, i16) : ((Integer) iPatchRedirector.redirect((short) 35, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeValue(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this, i3);
        }
        int attributeOffset = getAttributeOffset(i3);
        int[] iArr = this.m_attributes;
        if (iArr[attributeOffset + 3] == 3) {
            return this.m_strings.b(iArr[attributeOffset + 2]);
        }
        int i16 = iArr[attributeOffset + 4];
        return "";
    }

    public int getAttributeValueData(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this, i3)).intValue();
        }
        return this.m_attributes[getAttributeOffset(i3) + 4];
    }

    public int getAttributeValueType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this, i3)).intValue();
        }
        return this.m_attributes[getAttributeOffset(i3) + 3];
    }

    @Override // android.util.AttributeSet
    public String getClassAttribute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        int i3 = this.m_classAttribute;
        if (i3 == -1) {
            return null;
        }
        return this.m_strings.b(this.m_attributes[getAttributeOffset(i3) + 2]);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getColumnNumber() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Integer) iPatchRedirector.redirect((short) 50, (Object) this)).intValue();
        }
        return -1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getDepth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.m_namespaces.h() - 1;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getEventType() throws XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.m_event;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this, (Object) str)).booleanValue();
        }
        return false;
    }

    @Override // android.util.AttributeSet
    public String getIdAttribute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        int i3 = this.m_idAttribute;
        if (i3 == -1) {
            return null;
        }
        return this.m_strings.b(this.m_attributes[getAttributeOffset(i3) + 2]);
    }

    @Override // android.util.AttributeSet
    public int getIdAttributeResourceValue(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, i3)).intValue();
        }
        int i16 = this.m_idAttribute;
        if (i16 == -1) {
            return i3;
        }
        int attributeOffset = getAttributeOffset(i16);
        int[] iArr = this.m_attributes;
        if (iArr[attributeOffset + 3] != 1) {
            return i3;
        }
        return iArr[attributeOffset + 4];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getInputEncoding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (String) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getLineNumber() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.m_lineNumber;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        int i3 = this.m_name;
        if (i3 != -1) {
            int i16 = this.m_event;
            if (i16 == 2 || i16 == 3) {
                return this.m_strings.b(i3);
            }
            return null;
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? this.m_strings.b(this.m_namespaceUri) : (String) iPatchRedirector.redirect((short) 14, (Object) this);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int getNamespaceCount(int i3) throws XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, i3)).intValue();
        }
        return this.m_namespaces.f(i3);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespacePrefix(int i3) throws XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this, i3);
        }
        return this.m_strings.b(this.m_namespaces.i(i3));
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespaceUri(int i3) throws XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
        return this.m_strings.b(this.m_namespaces.j(i3));
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public String getPositionDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "XML line #" + getLineNumber();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.m_strings.b(this.m_namespaces.d(this.m_namespaceUri));
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public Object getProperty(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return iPatchRedirector.redirect((short) 55, (Object) this, (Object) str);
        }
        return null;
    }

    final q getStrings() {
        return this.m_strings;
    }

    @Override // android.util.AttributeSet
    public int getStyleAttribute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        int i3 = this.m_styleAttribute;
        if (i3 == -1) {
            return 0;
        }
        return this.m_attributes[getAttributeOffset(i3) + 4];
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        int i3 = this.m_name;
        if (i3 != -1 && this.m_event == 4) {
            return this.m_strings.b(i3);
        }
        return null;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (char[]) iPatchRedirector.redirect((short) 13, (Object) this, (Object) iArr);
        }
        String text = getText();
        if (text == null) {
            return null;
        }
        iArr[0] = 0;
        iArr[1] = text.length();
        char[] cArr = new char[text.length()];
        text.getChars(0, text.length(), cArr, 0);
        return cArr;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isAttributeDefault(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this, i3)).booleanValue();
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isEmptyElementTag() throws XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public boolean isWhitespace() throws XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int next() throws XmlPullParserException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.mBuffer != null) {
            try {
                doNext();
                return this.m_event;
            } catch (IOException e16) {
                close();
                throw e16;
            }
        }
        throw new XmlPullParserException("Parser is not opened.", this, null);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextTag() throws XmlPullParserException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int next = next();
        if (next == 4 && isWhitespace()) {
            next = next();
        }
        if (next != 2 && next != 3) {
            throw new XmlPullParserException("Expected start or end tag.", this, null);
        }
        return next;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String nextText() throws XmlPullParserException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (getEventType() == 2) {
            int next = next();
            if (next == 4) {
                String text = getText();
                if (next() == 3) {
                    return text;
                }
                throw new XmlPullParserException("Event TEXT must be immediately followed by END_TAG.", this, null);
            }
            if (next == 3) {
                return "";
            }
            throw new XmlPullParserException("Parser must be on START_TAG or TEXT to read text.", this, null);
        }
        throw new XmlPullParserException("Parser must be on START_TAG to read next text.", this, null);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public int nextToken() throws XmlPullParserException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return next();
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void require(int i3, String str, String str2) throws XmlPullParserException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (i3 == getEventType() && ((str == null || str.equals(getNamespace())) && (str2 == null || str2.equals(getName())))) {
            return;
        }
        throw new XmlPullParserException(XmlResourceParser.TYPES[i3] + " is expected.", this, null);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setFeature(String str, boolean z16) throws XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, this, str, Boolean.valueOf(z16));
            return;
        }
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(InputStream inputStream, String str) throws XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) inputStream, (Object) str);
            return;
        }
        try {
            close();
            if (inputStream != null) {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                inputStream.close();
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                this.mBuffer = wrap;
                wrap.order(ByteOrder.LITTLE_ENDIAN);
            }
        } catch (IOException e16) {
            new XmlPullParserException("error load stream").initCause(e16);
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setProperty(String str, Object obj) throws XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) str, obj);
            return;
        }
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    @Override // android.util.AttributeSet
    public boolean getAttributeBooleanValue(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, this, str, str2, Boolean.valueOf(z16))).booleanValue();
        }
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? z16 : getAttributeBooleanValue(findAttribute, z16);
    }

    @Override // android.util.AttributeSet
    public int getAttributeListValue(String str, String str2, String[] strArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 44)) {
            return 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 44, this, str, str2, strArr, Integer.valueOf(i3))).intValue();
    }

    @Override // android.util.AttributeSet
    public int getAttributeUnsignedIntValue(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, this, str, str2, Integer.valueOf(i3))).intValue();
        }
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? i3 : getAttributeUnsignedIntValue(findAttribute, i3);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public String getNamespace(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 54)) {
            throw new RuntimeException(E_NOT_SUPPORTED);
        }
        return (String) iPatchRedirector.redirect((short) 54, (Object) this, (Object) str);
    }

    @Override // android.util.AttributeSet
    public int getAttributeIntValue(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, this, str, str2, Integer.valueOf(i3))).intValue();
        }
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? i3 : getAttributeIntValue(findAttribute, i3);
    }

    @Override // android.util.AttributeSet
    public int getAttributeResourceValue(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Integer) iPatchRedirector.redirect((short) 42, this, str, str2, Integer.valueOf(i3))).intValue();
        }
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? i3 : getAttributeResourceValue(findAttribute, i3);
    }

    @Override // android.util.AttributeSet
    public float getAttributeFloatValue(String str, String str2, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Float) iPatchRedirector.redirect((short) 39, this, str, str2, Float.valueOf(f16))).floatValue();
        }
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? f16 : getAttributeFloatValue(findAttribute, f16);
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public String getAttributeValue(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this, (Object) str, (Object) str2);
        }
        int findAttribute = findAttribute(str, str2);
        if (findAttribute == -1) {
            return null;
        }
        return getAttributeValue(findAttribute);
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public void setInput(Reader reader) throws XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 48)) {
            throw new XmlPullParserException(E_NOT_SUPPORTED);
        }
        iPatchRedirector.redirect((short) 48, (Object) this, (Object) reader);
    }
}
