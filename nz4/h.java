package nz4;

import com.tencent.mobileqq.tianshu.ui.RedTouch;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class h {
    public static String a(com.xingin.xhssharesdk.a.e eVar) {
        String str;
        StringBuilder sb5 = new StringBuilder(eVar.size());
        for (int i3 = 0; i3 < eVar.size(); i3++) {
            int a16 = eVar.a(i3);
            if (a16 != 34) {
                if (a16 != 39) {
                    if (a16 != 92) {
                        switch (a16) {
                            case 7:
                                str = "\\a";
                                break;
                            case 8:
                                str = "\\b";
                                break;
                            case 9:
                                str = "\\t";
                                break;
                            case 10:
                                str = RedTouch.NEWLINE_CHAR;
                                break;
                            case 11:
                                str = "\\v";
                                break;
                            case 12:
                                str = "\\f";
                                break;
                            case 13:
                                str = "\\r";
                                break;
                            default:
                                if (a16 < 32 || a16 > 126) {
                                    sb5.append('\\');
                                    sb5.append((char) (((a16 >>> 6) & 3) + 48));
                                    sb5.append((char) (((a16 >>> 3) & 7) + 48));
                                    a16 = (a16 & 7) + 48;
                                }
                                sb5.append((char) a16);
                                continue;
                        }
                    } else {
                        str = "\\\\";
                    }
                } else {
                    str = "\\'";
                }
            } else {
                str = "\\\"";
            }
            sb5.append(str);
        }
        return sb5.toString();
    }
}
