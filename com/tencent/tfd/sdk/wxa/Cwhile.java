package com.tencent.tfd.sdk.wxa;

import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.jf.dexlib2.analysis.RegisterType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.while, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cwhile {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f375856j;

    /* renamed from: a, reason: collision with root package name */
    public Cthrow f375857a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f375858b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f375859c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f375860d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f375861e;

    /* renamed from: f, reason: collision with root package name */
    public int f375862f;

    /* renamed from: g, reason: collision with root package name */
    public int f375863g;

    /* renamed from: h, reason: collision with root package name */
    public int f375864h;

    /* renamed from: i, reason: collision with root package name */
    public int f375865i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375856j = new String[]{"px", "dp", "sp", "pt", "in", "mm"};
        }
    }

    public Cwhile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f375858b = new HashMap();
        }
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r15v6, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    public final Document a(InputStream inputStream) throws IOException, ParserConfigurationException {
        String b16;
        String str;
        Element createElementNS;
        String format;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Document) iPatchRedirector.redirect((short) 3, (Object) this, (Object) inputStream);
        }
        Cthrow cthrow = new Cthrow();
        this.f375857a = cthrow;
        byte[] bArr2 = new byte[inputStream.available()];
        this.f375859c = bArr2;
        inputStream.read(bArr2);
        inputStream.close();
        while (true) {
            int i3 = this.f375865i;
            if (i3 < this.f375859c.length) {
                int a16 = a(i3);
                int i16 = -1;
                if (a16 == -1) {
                    this.f375857a.getClass();
                } else if (a16 != 524291) {
                    if (a16 == 524672) {
                        int a17 = a(this.f375865i + 4);
                        int i17 = (a17 / 4) - 2;
                        this.f375864h = i17;
                        this.f375861e = new int[i17];
                        for (int i18 = 0; i18 < this.f375864h; i18++) {
                            this.f375861e[i18] = a(((i18 + 2) * 4) + this.f375865i);
                        }
                        this.f375865i += a17;
                    } else if (a16 != 1835009) {
                        switch (a16) {
                            case 1048832:
                                a(true);
                                break;
                            case 1048833:
                                a(false);
                                break;
                            case 1048834:
                                int a18 = a(this.f375865i + 16);
                                int a19 = a(this.f375865i + 20);
                                int i19 = this.f375865i + 28;
                                byte[] bArr3 = this.f375859c;
                                int i26 = (65280 & (bArr3[i19 + 1] << 8)) | ((bArr3[i19 + 0] << 0) & 255);
                                String b17 = b(a19);
                                if (a18 == -1) {
                                    str = b17;
                                    b16 = "";
                                } else {
                                    b16 = b(a18);
                                    str = this.f375858b.containsKey(b16) ? ((String) this.f375858b.get(b16)) + ':' + b17 : b17;
                                }
                                this.f375865i += 36;
                                Cthis[] cthisArr = new Cthis[i26];
                                int i27 = 0;
                                while (i27 < i26) {
                                    int a26 = a(this.f375865i);
                                    int a27 = a(this.f375865i + 4);
                                    int a28 = a(this.f375865i + 8);
                                    int a29 = a(this.f375865i + 12);
                                    int a36 = a(this.f375865i + 16);
                                    Cthis cthis = new Cthis();
                                    cthis.f375835a = b(a27);
                                    if (a26 == i16) {
                                        cthis.f375837c = null;
                                        cthis.f375836b = null;
                                    } else {
                                        String b18 = b(a26);
                                        if (this.f375858b.containsKey(b18)) {
                                            cthis.f375837c = b18;
                                            cthis.f375836b = (String) this.f375858b.get(b18);
                                        }
                                    }
                                    if (a28 == i16) {
                                        switch (a29) {
                                            case 16777224:
                                                format = String.format("@id/0x%08X", Integer.valueOf(a36));
                                                break;
                                            case MessageStruct.MSG_RECORD_SAVE_DRAFT /* 33554440 */:
                                                format = String.format("?id/0x%08X", Integer.valueOf(a36));
                                                break;
                                            case 50331656:
                                                format = b(a36);
                                                break;
                                            case MessageStruct.MSG_VIDEOPLAYER_PLAY_BEGIN /* 67108872 */:
                                                format = Float.toString(Float.intBitsToFloat(a36));
                                                break;
                                            case 83886088:
                                                format = Integer.toString(a36 >> 8) + f375856j[a36 & 255];
                                                break;
                                            case 100663304:
                                                format = new DecimalFormat("#.##%").format(a36 / 2.147483647E9d);
                                                break;
                                            case 268435464:
                                            case 285212680:
                                                format = Integer.toString(a36);
                                                break;
                                            case 301989896:
                                                format = Boolean.toString(a36 != 0);
                                                break;
                                            case 469762056:
                                            case 486539272:
                                                format = String.format("#%08X", Integer.valueOf(a36));
                                                break;
                                            default:
                                                format = String.format("%08X/0x%08X", Integer.valueOf(a29), Integer.valueOf(a36));
                                                break;
                                        }
                                        cthis.f375838d = format;
                                    } else {
                                        cthis.f375838d = b(a28);
                                    }
                                    cthisArr[i27] = cthis;
                                    this.f375865i += 20;
                                    i27++;
                                    i16 = -1;
                                }
                                Cthrow cthrow2 = this.f375857a;
                                cthrow2.getClass();
                                if (b16 == null || "".equals(b16)) {
                                    createElementNS = cthrow2.f375840b.createElement(b17);
                                } else {
                                    createElementNS = cthrow2.f375840b.createElementNS(b16, str);
                                }
                                for (int i28 = 0; i28 < i26; i28++) {
                                    Cthis cthis2 = cthisArr[i28];
                                    String str2 = cthis2.f375837c;
                                    if (str2 == null || "".equals(str2)) {
                                        createElementNS.setAttribute(cthis2.f375835a, cthis2.f375838d);
                                    } else {
                                        createElementNS.setAttributeNS(cthis2.f375837c, cthis2.f375836b + ':' + cthis2.f375835a, cthis2.f375838d);
                                    }
                                }
                                cthrow2.f375839a.peek().appendChild(createElementNS);
                                cthrow2.f375839a.push(createElementNS);
                                break;
                            case 1048835:
                                int a37 = a(this.f375865i + 16);
                                b(a(this.f375865i + 20));
                                if (a37 != -1) {
                                    b(a37);
                                }
                                this.f375857a.f375839a.pop();
                                this.f375865i += 24;
                                break;
                            case 1048836:
                                String b19 = b(a(this.f375865i + 16));
                                Cthrow cthrow3 = this.f375857a;
                                cthrow3.f375839a.peek().appendChild(cthrow3.f375840b.createCDATASection(b19));
                                this.f375865i += 28;
                                break;
                            default:
                                this.f375865i += 4;
                                break;
                        }
                    } else {
                        int a38 = a(this.f375865i + 4);
                        this.f375862f = a(this.f375865i + 8);
                        this.f375863g = a(this.f375865i + 12);
                        int i29 = this.f375865i;
                        int a39 = a(i29 + 20) + i29;
                        int a46 = a(this.f375865i + 24);
                        this.f375860d = new String[this.f375862f];
                        for (int i36 = 0; i36 < this.f375862f; i36++) {
                            int a47 = a(((i36 + 7) * 4) + this.f375865i) + a39;
                            String[] strArr = this.f375860d;
                            byte[] bArr4 = this.f375859c;
                            int i37 = bArr4[a47 + 1];
                            int i38 = bArr4[a47];
                            if (i37 == i38) {
                                bArr = new byte[i38];
                                for (int i39 = 0; i39 < i38; i39++) {
                                    bArr[i39] = this.f375859c[a47 + 2 + i39];
                                }
                            } else {
                                int i46 = (i38 & 255) | ((i37 << 8) & 65280);
                                bArr = new byte[i46];
                                for (int i47 = 0; i47 < i46; i47++) {
                                    bArr[i47] = this.f375859c[(i47 * 2) + a47 + 2];
                                }
                            }
                            strArr[i36] = new String(bArr);
                        }
                        if (a46 > 0) {
                            for (int i48 = 0; i48 < this.f375863g; i48++) {
                            }
                        }
                        this.f375865i += a38;
                    }
                } else {
                    Cthrow cthrow4 = this.f375857a;
                    Document newDocument = cthrow4.f375841c.newDocument();
                    cthrow4.f375840b = newDocument;
                    cthrow4.f375839a.push(newDocument);
                    this.f375865i += 8;
                }
            } else {
                this.f375857a.getClass();
                return cthrow.f375840b;
            }
        }
    }

    public final String b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.f375862f) {
            return this.f375860d[i3];
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    public final void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        int a16 = a(this.f375865i + 16);
        String b16 = b(a(this.f375865i + 20));
        String b17 = b(a16);
        if (z16) {
            this.f375857a.getClass();
            this.f375858b.put(b16, b17);
        } else {
            this.f375857a.getClass();
            this.f375858b.remove(b16);
        }
        this.f375865i += 24;
    }

    public final int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        byte[] bArr = this.f375859c;
        return ((bArr[i3 + 0] << 0) & 255) | ((bArr[i3 + 3] << 24) & (-16777216)) | ((bArr[i3 + 2] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((bArr[i3 + 1] << 8) & 65280);
    }
}
