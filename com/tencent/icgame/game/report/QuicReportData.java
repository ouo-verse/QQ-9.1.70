package com.tencent.icgame.game.report;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
class QuicReportData {

    /* renamed from: a, reason: collision with root package name */
    @DownloadType
    public String f115787a = "none";

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f115788b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    @RequestProtoType
    private String f115789c = "unknown";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public @interface DownloadType {
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public @interface RequestProtoType {
    }

    public void a(String str) {
        char c16;
        synchronized (this.f115788b) {
            if (this.f115788b.size() > 20) {
                return;
            }
            this.f115788b.add(str);
            if ("quic".equals(str)) {
                if (com.tencent.mobileqq.msf.core.quicksend.b.A.equals(this.f115789c)) {
                    this.f115789c = "quic";
                }
            } else if (com.tencent.mobileqq.msf.core.quicksend.b.A.equals(str)) {
                String str2 = this.f115789c;
                switch (str2.hashCode()) {
                    case -284840886:
                        if (str2.equals("unknown")) {
                            c16 = 0;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 114657:
                        if (str2.equals(com.tencent.mobileqq.msf.core.quicksend.b.A)) {
                            c16 = 1;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 3482174:
                        if (str2.equals("quic")) {
                            c16 = 2;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    case 1933997054:
                        if (str2.equals("quic-to-tcp")) {
                            c16 = 3;
                            break;
                        }
                        c16 = '\uffff';
                        break;
                    default:
                        c16 = '\uffff';
                        break;
                }
                if (c16 != 0 && c16 != 1) {
                    if (c16 == 2) {
                        this.f115789c = "quic-to-tcp";
                    }
                } else {
                    this.f115789c = com.tencent.mobileqq.msf.core.quicksend.b.A;
                }
            }
        }
    }
}
