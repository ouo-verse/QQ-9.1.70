package com.tencent.open.appcommon.now.download.local;

import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f340740a;

    /* renamed from: b, reason: collision with root package name */
    public String f340741b;

    /* renamed from: c, reason: collision with root package name */
    public int f340742c;

    /* renamed from: d, reason: collision with root package name */
    public int f340743d;

    /* renamed from: e, reason: collision with root package name */
    public long f340744e;

    /* renamed from: f, reason: collision with root package name */
    public long f340745f;

    /* renamed from: g, reason: collision with root package name */
    public int f340746g = 0;

    /* renamed from: h, reason: collision with root package name */
    public String f340747h = "";

    public a a(DownloadInfo downloadInfo) {
        this.f340740a = downloadInfo.f341184e;
        this.f340741b = downloadInfo.f341189h;
        this.f340742c = b(downloadInfo.f());
        this.f340743d = downloadInfo.Q;
        this.f340744e = downloadInfo.f341180b0;
        this.f340745f = 0L;
        return this;
    }

    public int b(int i3) {
        if (i3 == -2) {
            return 6;
        }
        if (i3 != 6) {
            if (i3 != 10) {
                if (i3 != 13) {
                    if (i3 == 20) {
                        return 4;
                    }
                    if (i3 != 2) {
                        if (i3 == 3) {
                            return 2;
                        }
                        if (i3 == 4) {
                            return 3;
                        }
                        return 0;
                    }
                    return 1;
                }
                return 9;
            }
            return 5;
        }
        return 7;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x002a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x002d. Please report as an issue. */
    public int c(int i3) {
        if (i3 != -50 && i3 != -40 && i3 != -30) {
            if (i3 == -24) {
                return -24;
            }
            if (i3 != -20) {
                if (i3 != -10) {
                    if (i3 != -1) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 4) {
                                        if (i3 != 5) {
                                            switch (i3) {
                                                case 600:
                                                case 601:
                                                case 602:
                                                case 603:
                                                case 604:
                                                case 605:
                                                case 606:
                                                    return 203;
                                                default:
                                                    switch (i3) {
                                                        case 700:
                                                        case 701:
                                                        case 702:
                                                            break;
                                                        case 703:
                                                        case 704:
                                                        case 705:
                                                        case 706:
                                                        case 707:
                                                            break;
                                                        case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK /* 708 */:
                                                            return 400;
                                                        case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES /* 709 */:
                                                            return 401;
                                                        default:
                                                            switch (i3) {
                                                                case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH /* 730 */:
                                                                    break;
                                                                case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY /* 731 */:
                                                                case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION /* 732 */:
                                                                    break;
                                                                default:
                                                                    return 700;
                                                            }
                                                        case 710:
                                                        case 711:
                                                            return 600;
                                                    }
                                                case 607:
                                                    return 300;
                                            }
                                        } else {
                                            return 101;
                                        }
                                    } else {
                                        return 100;
                                    }
                                }
                                return 102;
                            }
                            return 201;
                        }
                        return 202;
                    }
                }
                return 600;
            }
        }
        return 500;
    }
}
