package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e implements XmlSerializer {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private BufferedWriter f290403a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f290404b;

    /* renamed from: c, reason: collision with root package name */
    private int f290405c;

    /* renamed from: d, reason: collision with root package name */
    private int f290406d;

    /* renamed from: e, reason: collision with root package name */
    private String[] f290407e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f290408f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f290409g;

    /* renamed from: h, reason: collision with root package name */
    private boolean[] f290410h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f290411i;

    /* renamed from: j, reason: collision with root package name */
    private String f290412j;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f290407e = new String[12];
        this.f290408f = new int[4];
        this.f290409g = new String[8];
        this.f290410h = new boolean[4];
    }

    private final void a(boolean z16) throws IOException {
        String str;
        if (!this.f290404b) {
            return;
        }
        int i3 = this.f290406d + 1;
        this.f290406d = i3;
        this.f290404b = false;
        boolean[] zArr = this.f290410h;
        if (zArr.length <= i3) {
            boolean[] zArr2 = new boolean[i3 + 4];
            System.arraycopy(zArr, 0, zArr2, 0, i3);
            this.f290410h = zArr2;
        }
        boolean[] zArr3 = this.f290410h;
        int i16 = this.f290406d;
        zArr3[i16] = zArr3[i16 - 1];
        int i17 = this.f290408f[i16 - 1];
        while (true) {
            int[] iArr = this.f290408f;
            int i18 = this.f290406d;
            if (i17 < iArr[i18]) {
                this.f290403a.write(32);
                this.f290403a.write("xmlns");
                int i19 = i17 * 2;
                if (this.f290409g[i19].length() != 0) {
                    this.f290403a.write(58);
                    this.f290403a.write(this.f290409g[i19]);
                } else if (getNamespace() != null && getNamespace().length() == 0 && this.f290409g[i19 + 1].length() != 0) {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                }
                this.f290403a.write("=\"");
                d(this.f290409g[i19 + 1], 34);
                this.f290403a.write(34);
                i17++;
            } else {
                if (iArr.length <= i18 + 1) {
                    int[] iArr2 = new int[i18 + 8];
                    System.arraycopy(iArr, 0, iArr2, 0, i18 + 1);
                    this.f290408f = iArr2;
                }
                int[] iArr3 = this.f290408f;
                int i26 = this.f290406d;
                iArr3[i26 + 1] = iArr3[i26];
                BufferedWriter bufferedWriter = this.f290403a;
                if (z16) {
                    str = " />";
                } else {
                    str = ">";
                }
                bufferedWriter.write(str);
                return;
            }
        }
    }

    private final String b(String str, boolean z16, boolean z17) throws IOException {
        String sb5;
        int i3 = this.f290408f[this.f290406d + 1] * 2;
        while (true) {
            i3 -= 2;
            String str2 = null;
            if (i3 >= 0) {
                if (this.f290409g[i3 + 1].equals(str) && (z16 || this.f290409g[i3].length() != 0)) {
                    String str3 = this.f290409g[i3];
                    int i16 = i3 + 2;
                    while (true) {
                        if (i16 < this.f290408f[this.f290406d + 1] * 2) {
                            if (this.f290409g[i16].equals(str3)) {
                                break;
                            }
                            i16++;
                        } else {
                            str2 = str3;
                            break;
                        }
                    }
                    if (str2 != null) {
                        return str2;
                    }
                }
            } else {
                if (!z17) {
                    return null;
                }
                if (str.length() == 0) {
                    sb5 = "";
                    boolean z18 = this.f290404b;
                    this.f290404b = false;
                    setPrefix(sb5, str);
                    this.f290404b = z18;
                    return sb5;
                }
                do {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(DomainData.DOMAIN_NAME);
                    int i17 = this.f290405c;
                    this.f290405c = i17 + 1;
                    sb6.append(i17);
                    sb5 = sb6.toString();
                    int i18 = (this.f290408f[this.f290406d + 1] * 2) - 2;
                    while (true) {
                        if (i18 < 0) {
                            break;
                        }
                        if (sb5.equals(this.f290409g[i18])) {
                            sb5 = null;
                            break;
                        }
                        i18 -= 2;
                    }
                } while (sb5 == null);
                boolean z182 = this.f290404b;
                this.f290404b = false;
                setPrefix(sb5, str);
                this.f290404b = z182;
                return sb5;
            }
        }
    }

    private static void c(char c16) {
        throw new IllegalArgumentException("Illegal character (" + Integer.toHexString(c16) + ")");
    }

    private final void d(String str, int i3) throws IOException {
        String str2;
        for (int i16 = 0; i16 < str.length(); i16++) {
            char charAt = str.charAt(i16);
            if (charAt != '\t' && charAt != '\n' && charAt != '\r') {
                if (charAt != '&') {
                    if (charAt != '<') {
                        if (charAt != '>') {
                            if (charAt == i3) {
                                BufferedWriter bufferedWriter = this.f290403a;
                                if (charAt == '\"') {
                                    str2 = "&quot;";
                                } else {
                                    str2 = "&apos;";
                                }
                                bufferedWriter.write(str2);
                            } else {
                                if (charAt < ' ' || charAt > '\ud7ff') {
                                }
                                if (!this.f290411i && charAt >= '\u007f') {
                                    this.f290403a.write("&#" + ((int) charAt) + ";");
                                } else {
                                    this.f290403a.write(charAt);
                                }
                            }
                        } else {
                            this.f290403a.write("&gt;");
                        }
                    } else {
                        this.f290403a.write("&lt;");
                    }
                } else {
                    this.f290403a.write("&amp;");
                }
            } else if (i3 == -1) {
                this.f290403a.write(charAt);
            } else {
                this.f290403a.write("&#" + ((int) charAt) + ';');
            }
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (XmlSerializer) iPatchRedirector.redirect((short) 16, this, str, str2, str3);
        }
        if (this.f290404b) {
            String str4 = "";
            if (str == null) {
                str = "";
            }
            if (str.length() != 0) {
                str4 = b(str, false, true);
            }
            this.f290403a.write(32);
            if (str4.length() != 0) {
                this.f290403a.write(str4);
                this.f290403a.write(58);
            }
            this.f290403a.write(str2);
            this.f290403a.write(61);
            int i3 = 34;
            if (str3.indexOf(34) != -1) {
                i3 = 39;
            }
            this.f290403a.write(i3);
            d(str3, i3);
            this.f290403a.write(i3);
            return this;
        }
        throw new IllegalStateException("illegal position for attribute");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) throws IOException {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
            return;
        }
        a(false);
        char[] charArray = str.replace("]]>", "]]]]><![CDATA[>").toCharArray();
        for (char c16 : charArray) {
            if ((c16 < ' ' || c16 > '\ud7ff') && c16 != '\t' && c16 != '\n' && c16 != '\r' && (c16 < '\ue000' || c16 > '\ufffd')) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                c(c16);
            }
        }
        this.f290403a.write("<![CDATA[");
        this.f290403a.write(charArray, 0, charArray.length);
        this.f290403a.write("]]>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
            return;
        }
        a(false);
        this.f290403a.write("<!--");
        this.f290403a.write(str);
        this.f290403a.write("-->");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.f290403a.write("<!DOCTYPE");
        this.f290403a.write(str);
        this.f290403a.write(">");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        while (true) {
            int i3 = this.f290406d;
            if (i3 > 0) {
                String[] strArr = this.f290407e;
                endTag(strArr[(i3 * 3) - 3], strArr[(i3 * 3) - 1]);
            } else {
                flush();
                return;
            }
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (XmlSerializer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) str2);
        }
        if (!this.f290404b) {
            this.f290406d--;
        }
        if ((str != null || this.f290407e[this.f290406d * 3] == null) && ((str == null || str.equals(this.f290407e[this.f290406d * 3])) && this.f290407e[(this.f290406d * 3) + 2].equals(str2))) {
            if (this.f290404b) {
                a(true);
                this.f290406d--;
            } else {
                if (this.f290410h[this.f290406d + 1]) {
                    this.f290403a.write("\r\n");
                    for (int i3 = 0; i3 < this.f290406d; i3++) {
                        this.f290403a.write("  ");
                    }
                }
                this.f290403a.write("</");
                String str3 = this.f290407e[(this.f290406d * 3) + 1];
                if (str3.length() != 0) {
                    this.f290403a.write(str3);
                    this.f290403a.write(58);
                }
                this.f290403a.write(str2);
                this.f290403a.write(62);
            }
            int[] iArr = this.f290408f;
            int i16 = this.f290406d;
            iArr[i16 + 1] = iArr[i16];
            return this;
        }
        throw new IllegalArgumentException("</{" + str + "}" + str2 + "> does not match start");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        a(false);
        this.f290403a.write(38);
        this.f290403a.write(str);
        this.f290403a.write(59);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            a(false);
            this.f290403a.flush();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        if (this.f290404b) {
            return this.f290406d + 1;
        }
        return this.f290406d;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
            return this.f290410h[this.f290406d];
        }
        return false;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        if (getDepth() == 0) {
            return null;
        }
        return this.f290407e[(getDepth() * 3) - 1];
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (getDepth() == 0) {
            return null;
        }
        return this.f290407e[(getDepth() * 3) - 3];
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
        }
        try {
            return b(str, false, z16);
        } catch (IOException e16) {
            throw new RuntimeException(e16.toString());
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        throw new RuntimeException("Unsupported property");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            text(str);
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
            return;
        }
        a(false);
        this.f290403a.write("<?");
        this.f290403a.write(str);
        this.f290403a.write("?>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16));
        } else {
            if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
                this.f290410h[this.f290406d] = z16;
                return;
            }
            throw new RuntimeException("Unsupported Feature");
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) writer);
            return;
        }
        if (writer instanceof BufferedWriter) {
            this.f290403a = (BufferedWriter) writer;
        } else {
            this.f290403a = new BufferedWriter(writer, 500);
        }
        int[] iArr = this.f290408f;
        iArr[0] = 2;
        iArr[1] = 2;
        String[] strArr = this.f290409g;
        strArr[0] = "";
        strArr[1] = "";
        strArr[2] = "xml";
        strArr[3] = "https://www.w3.org/XML/1998/namespace";
        this.f290404b = false;
        this.f290405c = 0;
        this.f290406d = 0;
        this.f290411i = false;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
            return;
        }
        a(false);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str.equals(b(str2, true, false))) {
            return;
        }
        int[] iArr = this.f290408f;
        int i3 = this.f290406d + 1;
        int i16 = iArr[i3];
        iArr[i3] = i16 + 1;
        int i17 = i16 << 1;
        String[] strArr = this.f290409g;
        int i18 = i17 + 1;
        if (strArr.length < i18) {
            String[] strArr2 = new String[strArr.length + 16];
            System.arraycopy(strArr, 0, strArr2, 0, i17);
            this.f290409g = strArr2;
        }
        String[] strArr3 = this.f290409g;
        strArr3[i17] = str;
        strArr3[i18] = str2;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, obj);
            return;
        }
        throw new RuntimeException("Unsupported Property:" + obj);
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) bool);
            return;
        }
        this.f290403a.write("<?xml version='1.0' ");
        if (str != null) {
            this.f290412j = str;
            if (str.toLowerCase(Locale.US).startsWith("utf")) {
                this.f290411i = true;
            }
        }
        if (this.f290412j != null) {
            this.f290403a.write("encoding='");
            this.f290403a.write(this.f290412j);
            this.f290403a.write("' ");
        }
        if (bool != null) {
            this.f290403a.write("standalone='");
            BufferedWriter bufferedWriter = this.f290403a;
            if (bool.booleanValue()) {
                str2 = "yes";
            } else {
                str2 = "no";
            }
            bufferedWriter.write(str2);
            this.f290403a.write("' ");
        }
        this.f290403a.write("?>");
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) throws IOException {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (XmlSerializer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) str2);
        }
        a(false);
        if (this.f290410h[this.f290406d]) {
            this.f290403a.write("\r\n");
            for (int i3 = 0; i3 < this.f290406d; i3++) {
                this.f290403a.write("  ");
            }
        }
        int i16 = this.f290406d * 3;
        String[] strArr = this.f290407e;
        if (strArr.length < i16 + 3) {
            String[] strArr2 = new String[strArr.length + 12];
            System.arraycopy(strArr, 0, strArr2, 0, i16);
            this.f290407e = strArr2;
        }
        if (str == null) {
            b16 = "";
        } else {
            b16 = b(str, true, true);
        }
        if (str != null && str.length() == 0) {
            for (int i17 = this.f290408f[this.f290406d]; i17 < this.f290408f[this.f290406d + 1]; i17++) {
                int i18 = i17 * 2;
                if (this.f290409g[i18].length() == 0 && this.f290409g[i18 + 1].length() != 0) {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                }
            }
        }
        String[] strArr3 = this.f290407e;
        int i19 = i16 + 1;
        strArr3[i16] = str;
        strArr3[i19] = b16;
        strArr3[i19 + 1] = str2;
        this.f290403a.write(60);
        if (b16.length() != 0) {
            this.f290403a.write(b16);
            this.f290403a.write(58);
        }
        this.f290403a.write(str2);
        this.f290404b = true;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (XmlSerializer) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        }
        a(false);
        this.f290410h[this.f290406d] = false;
        d(str, -1);
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (XmlSerializer) iPatchRedirector.redirect((short) 23, this, cArr, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        text(new String(cArr, i3, i16));
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) throws IOException {
        OutputStreamWriter outputStreamWriter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) outputStream, (Object) str);
            return;
        }
        if (outputStream != null) {
            if (str == null) {
                outputStreamWriter = new OutputStreamWriter(outputStream);
            } else {
                outputStreamWriter = new OutputStreamWriter(outputStream, str);
            }
            setOutput(outputStreamWriter);
            this.f290412j = str;
            if (str == null || !str.toLowerCase(Locale.US).startsWith("utf")) {
                return;
            }
            this.f290411i = true;
            return;
        }
        throw new IllegalArgumentException("os == null");
    }
}
