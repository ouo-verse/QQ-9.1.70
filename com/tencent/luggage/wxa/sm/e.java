package com.tencent.luggage.wxa.sm;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {
    public static final int A = 601;
    public static final int B = 602;
    public static final int C = 603;
    public static final int D = 604;
    public static final int E = 605;
    public static final int F = 700;
    public static final int G = 701;
    public static final int H = 702;
    public static final int I = 703;
    public static final int J = 704;
    public static final int K = 705;
    public static final int L = 706;
    public static final int M = 707;
    public static final int N = 750;
    public static final int O = 751;
    public static final int P = 752;
    public static final int Q = 753;
    public static final int R = 754;
    public static final int S = 10001;
    public static final int T = 10002;
    public static final int U = 10003;
    public static final int V = 10004;
    public static final int W = -1;

    /* renamed from: a, reason: collision with root package name */
    private static final String f140419a = "MicroMsg.PlayerErrorHandler";

    /* renamed from: b, reason: collision with root package name */
    public static final int f140420b = 90;

    /* renamed from: c, reason: collision with root package name */
    public static final int f140421c = 91;

    /* renamed from: d, reason: collision with root package name */
    public static final int f140422d = 92;

    /* renamed from: e, reason: collision with root package name */
    public static final int f140423e = 95;

    /* renamed from: f, reason: collision with root package name */
    public static final int f140424f = 53;

    /* renamed from: g, reason: collision with root package name */
    public static final int f140425g = 54;

    /* renamed from: h, reason: collision with root package name */
    public static final int f140426h = 55;

    /* renamed from: i, reason: collision with root package name */
    public static final int f140427i = 62;

    /* renamed from: j, reason: collision with root package name */
    public static final int f140428j = 63;

    /* renamed from: k, reason: collision with root package name */
    public static final int f140429k = 64;

    /* renamed from: l, reason: collision with root package name */
    public static final int f140430l = 66;

    /* renamed from: m, reason: collision with root package name */
    public static final int f140431m = 67;

    /* renamed from: n, reason: collision with root package name */
    public static final int f140432n = 69;

    /* renamed from: o, reason: collision with root package name */
    public static final int f140433o = 70;

    /* renamed from: p, reason: collision with root package name */
    public static final int f140434p = 74;

    /* renamed from: q, reason: collision with root package name */
    public static final int f140435q = 80;

    /* renamed from: r, reason: collision with root package name */
    public static final int f140436r = 101;

    /* renamed from: s, reason: collision with root package name */
    public static final int f140437s = 102;

    /* renamed from: t, reason: collision with root package name */
    public static final int f140438t = 105;

    /* renamed from: u, reason: collision with root package name */
    public static final int f140439u = 500;

    /* renamed from: v, reason: collision with root package name */
    public static final int f140440v = 501;

    /* renamed from: w, reason: collision with root package name */
    public static final int f140441w = 502;

    /* renamed from: x, reason: collision with root package name */
    public static final int f140442x = 503;

    /* renamed from: y, reason: collision with root package name */
    public static final int f140443y = 504;

    /* renamed from: z, reason: collision with root package name */
    public static final int f140444z = 600;

    public static String a(int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("errCode:" + i3 + ", err:");
        if (i3 != 66) {
            if (i3 != 67) {
                if (i3 != 69) {
                    if (i3 != 70) {
                        if (i3 != 74) {
                            if (i3 != 80) {
                                if (i3 != 101) {
                                    if (i3 != 102) {
                                        switch (i3) {
                                            case 53:
                                                sb5.append("file not found");
                                                break;
                                            case 54:
                                                sb5.append("file can not read");
                                                break;
                                            case 55:
                                                sb5.append("unknow format");
                                                break;
                                            default:
                                                switch (i3) {
                                                    case 62:
                                                        sb5.append("load or init native decode so fail");
                                                        break;
                                                    case 63:
                                                        sb5.append("get audio info fail");
                                                        break;
                                                    case 64:
                                                        sb5.append("invalid audio info");
                                                        break;
                                                    default:
                                                        switch (i3) {
                                                            case 500:
                                                                sb5.append("error URL format");
                                                                break;
                                                            case 501:
                                                                sb5.append("error player to prepare");
                                                                break;
                                                            case 502:
                                                                sb5.append("error player to start");
                                                                break;
                                                            case 503:
                                                                sb5.append("error player to pause");
                                                                break;
                                                            case 504:
                                                                sb5.append("error player to stop");
                                                                break;
                                                            default:
                                                                switch (i3) {
                                                                    case 600:
                                                                        sb5.append("error create player fail, exceed max count audio players");
                                                                        break;
                                                                    case 601:
                                                                        sb5.append("error, not found audioId");
                                                                        break;
                                                                    case 602:
                                                                        sb5.append("error, not found param");
                                                                        break;
                                                                    case 603:
                                                                        sb5.append("error, ready exist audioId");
                                                                        break;
                                                                    case 604:
                                                                        sb5.append("error, invalid audioID");
                                                                        break;
                                                                    case 605:
                                                                        sb5.append("error, invalid param");
                                                                        break;
                                                                    default:
                                                                        switch (i3) {
                                                                            case 701:
                                                                                sb5.append("error, invalid param");
                                                                                break;
                                                                            case 702:
                                                                                sb5.append("error, mmplayer set source occur error");
                                                                                break;
                                                                            case 703:
                                                                                sb5.append("error, mmplayer media format error");
                                                                                break;
                                                                            case 704:
                                                                                sb5.append("error, mmplayer create MediaCode error");
                                                                                break;
                                                                            case 705:
                                                                                sb5.append("error, mmplayer get audio info error");
                                                                                break;
                                                                            case 706:
                                                                                sb5.append("error, mmplayer decode error");
                                                                                break;
                                                                            case 707:
                                                                                sb5.append("error, mmplayer create audio track orror");
                                                                                break;
                                                                            default:
                                                                                sb5.append("unknow exception");
                                                                                break;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                    } else {
                                        sb5.append("write AudioTrack data fail");
                                    }
                                } else {
                                    sb5.append("recognition audio format error");
                                }
                            } else {
                                sb5.append("connect network fail");
                            }
                        } else {
                            sb5.append("invalid seek or seek fail");
                        }
                    } else {
                        sb5.append("create temp file fail");
                    }
                } else {
                    sb5.append("so file not found");
                }
            } else {
                sb5.append("decode audio fail");
            }
        } else {
            sb5.append("create AudioTrack fail");
        }
        return sb5.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x003b. Please report as an issue. */
    public static int b(int i3) {
        w.d(f140419a, "getErrCodeType, errorCode: %d", Integer.valueOf(i3));
        if (i3 != 66 && i3 != 67 && i3 != 69 && i3 != 70 && i3 != 74) {
            if (i3 != 80) {
                if (i3 != 101) {
                    if (i3 != 102) {
                        switch (i3) {
                            case 53:
                            case 54:
                                return 10003;
                            case 55:
                                return 10004;
                            default:
                                switch (i3) {
                                    case 62:
                                        break;
                                    case 63:
                                    case 64:
                                        return 10004;
                                    default:
                                        switch (i3) {
                                            default:
                                                switch (i3) {
                                                    case 600:
                                                    case 601:
                                                    case 602:
                                                    case 603:
                                                    case 604:
                                                    case 605:
                                                        break;
                                                    default:
                                                        switch (i3) {
                                                            case 701:
                                                            case 703:
                                                            case 705:
                                                                return 10004;
                                                            case 702:
                                                            case 704:
                                                            case 706:
                                                            case 707:
                                                                break;
                                                            default:
                                                                return -1;
                                                        }
                                                }
                                            case 500:
                                            case 501:
                                            case 502:
                                            case 503:
                                            case 504:
                                                return 10001;
                                        }
                                }
                        }
                    }
                } else {
                    return 10004;
                }
            } else {
                return 10002;
            }
        }
        return 10001;
    }
}
