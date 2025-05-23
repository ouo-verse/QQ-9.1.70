package com.tencent.turingcam;

import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import org.jf.dexlib2.analysis.RegisterType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* compiled from: P */
/* loaded from: classes27.dex */
public class IJMwu {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f381848j;

    /* renamed from: a, reason: collision with root package name */
    public aw2ka f381849a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f381850b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f381851c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f381852d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f381853e;

    /* renamed from: f, reason: collision with root package name */
    public int f381854f;

    /* renamed from: g, reason: collision with root package name */
    public int f381855g;

    /* renamed from: h, reason: collision with root package name */
    public int f381856h;

    /* renamed from: i, reason: collision with root package name */
    public int f381857i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15896);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f381848j = new String[]{"px", "dp", "sp", "pt", "in", "mm"};
        }
    }

    public IJMwu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f381850b = new HashMap();
        }
    }

    public Document a(InputStream inputStream) {
        String b16;
        String str;
        Element createElementNS;
        String format;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Document) iPatchRedirector.redirect((short) 3, (Object) this, (Object) inputStream);
        }
        aw2ka aw2kaVar = new aw2ka();
        this.f381849a = aw2kaVar;
        byte[] bArr2 = new byte[inputStream.available()];
        this.f381851c = bArr2;
        inputStream.read(bArr2);
        inputStream.close();
        while (true) {
            int i3 = this.f381857i;
            if (i3 < this.f381851c.length) {
                int a16 = a(i3);
                int i16 = -1;
                if (a16 == -1) {
                    this.f381849a.getClass();
                } else if (a16 != 524291) {
                    if (a16 == 524672) {
                        int a17 = a(this.f381857i + 4);
                        int i17 = (a17 / 4) - 2;
                        this.f381856h = i17;
                        this.f381853e = new int[i17];
                        for (int i18 = 0; i18 < this.f381856h; i18++) {
                            this.f381853e[i18] = a(((i18 + 2) * 4) + this.f381857i);
                        }
                        this.f381857i += a17;
                    } else if (a16 != 1835009) {
                        switch (a16) {
                            case 1048832:
                                a(true);
                                break;
                            case 1048833:
                                a(false);
                                break;
                            case 1048834:
                                int a18 = a(this.f381857i + 16);
                                int a19 = a(this.f381857i + 20);
                                int i19 = this.f381857i + 28;
                                byte[] bArr3 = this.f381851c;
                                int i26 = (65280 & (bArr3[i19 + 1] << 8)) | ((bArr3[i19 + 0] << 0) & 255);
                                String b17 = b(a19);
                                if (a18 == -1) {
                                    str = b17;
                                    b16 = "";
                                } else {
                                    b16 = b(a18);
                                    str = this.f381850b.containsKey(b16) ? this.f381850b.get(b16) + ':' + b17 : b17;
                                }
                                this.f381857i += 36;
                                Y6UCg[] y6UCgArr = new Y6UCg[i26];
                                int i27 = 0;
                                while (i27 < i26) {
                                    int a26 = a(this.f381857i);
                                    int a27 = a(this.f381857i + 4);
                                    int a28 = a(this.f381857i + 8);
                                    int a29 = a(this.f381857i + 12);
                                    int a36 = a(this.f381857i + 16);
                                    Y6UCg y6UCg = new Y6UCg();
                                    y6UCg.f382103a = b(a27);
                                    if (a26 == i16) {
                                        y6UCg.f382105c = null;
                                        y6UCg.f382104b = null;
                                    } else {
                                        String b18 = b(a26);
                                        if (this.f381850b.containsKey(b18)) {
                                            y6UCg.f382105c = b18;
                                            y6UCg.f382104b = this.f381850b.get(b18);
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
                                                format = Integer.toString(a36 >> 8) + f381848j[a36 & 255];
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
                                        y6UCg.f382106d = format;
                                    } else {
                                        y6UCg.f382106d = b(a28);
                                    }
                                    y6UCgArr[i27] = y6UCg;
                                    this.f381857i += 20;
                                    i27++;
                                    i16 = -1;
                                }
                                aw2ka aw2kaVar2 = this.f381849a;
                                aw2kaVar2.getClass();
                                if (b16 == null || "".equals(b16)) {
                                    createElementNS = aw2kaVar2.f382139b.createElement(b17);
                                } else {
                                    createElementNS = aw2kaVar2.f382139b.createElementNS(b16, str);
                                }
                                for (int i28 = 0; i28 < i26; i28++) {
                                    Y6UCg y6UCg2 = y6UCgArr[i28];
                                    String str2 = y6UCg2.f382105c;
                                    if (str2 == null || "".equals(str2)) {
                                        createElementNS.setAttribute(y6UCg2.f382103a, y6UCg2.f382106d);
                                    } else {
                                        createElementNS.setAttributeNS(y6UCg2.f382105c, y6UCg2.f382104b + ':' + y6UCg2.f382103a, y6UCg2.f382106d);
                                    }
                                }
                                aw2kaVar2.f382138a.peek().appendChild(createElementNS);
                                aw2kaVar2.f382138a.push(createElementNS);
                                break;
                            case 1048835:
                                int a37 = a(this.f381857i + 16);
                                b(a(this.f381857i + 20));
                                if (a37 != -1) {
                                    b(a37);
                                }
                                this.f381849a.f382138a.pop();
                                this.f381857i += 24;
                                break;
                            case 1048836:
                                String b19 = b(a(this.f381857i + 16));
                                aw2ka aw2kaVar3 = this.f381849a;
                                aw2kaVar3.f382138a.peek().appendChild(aw2kaVar3.f382139b.createCDATASection(b19));
                                this.f381857i += 28;
                                break;
                            default:
                                this.f381857i += 4;
                                break;
                        }
                    } else {
                        int a38 = a(this.f381857i + 4);
                        this.f381854f = a(this.f381857i + 8);
                        this.f381855g = a(this.f381857i + 12);
                        int i29 = this.f381857i;
                        int a39 = a(i29 + 20) + i29;
                        int a46 = a(this.f381857i + 24);
                        this.f381852d = new String[this.f381854f];
                        for (int i36 = 0; i36 < this.f381854f; i36++) {
                            int a47 = a(((i36 + 7) * 4) + this.f381857i) + a39;
                            String[] strArr = this.f381852d;
                            byte[] bArr4 = this.f381851c;
                            int i37 = bArr4[a47 + 1];
                            int i38 = bArr4[a47];
                            if (i37 == i38) {
                                bArr = new byte[i38];
                                for (int i39 = 0; i39 < i38; i39++) {
                                    bArr[i39] = this.f381851c[a47 + 2 + i39];
                                }
                            } else {
                                int i46 = (i38 & 255) | ((i37 << 8) & 65280);
                                bArr = new byte[i46];
                                for (int i47 = 0; i47 < i46; i47++) {
                                    bArr[i47] = this.f381851c[(i47 * 2) + a47 + 2];
                                }
                            }
                            strArr[i36] = new String(bArr);
                        }
                        if (a46 > 0) {
                            for (int i48 = 0; i48 < this.f381855g; i48++) {
                            }
                        }
                        this.f381857i += a38;
                    }
                } else {
                    aw2ka aw2kaVar4 = this.f381849a;
                    Document newDocument = aw2kaVar4.f382140c.newDocument();
                    aw2kaVar4.f382139b = newDocument;
                    aw2kaVar4.f382138a.push(newDocument);
                    this.f381857i += 8;
                }
            } else {
                this.f381849a.getClass();
                return aw2kaVar.f382139b;
            }
        }
    }

    public final String b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.f381854f) {
            return this.f381852d[i3];
        }
        return null;
    }

    public final void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        int a16 = a(this.f381857i + 16);
        String b16 = b(a(this.f381857i + 20));
        String b17 = b(a16);
        if (z16) {
            this.f381849a.getClass();
            this.f381850b.put(b16, b17);
        } else {
            this.f381849a.getClass();
            this.f381850b.remove(b16);
        }
        this.f381857i += 24;
    }

    public final int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        byte[] bArr = this.f381851c;
        return ((bArr[i3 + 0] << 0) & 255) | ((bArr[i3 + 3] << 24) & (-16777216)) | ((bArr[i3 + 2] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((bArr[i3 + 1] << 8) & 65280);
    }
}
