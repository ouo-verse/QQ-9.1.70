package com.tencent.mapsdk.core.components.protocol.jce.user;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class user_login_t extends MapJceStruct {
    public String channel;

    /* renamed from: fr, reason: collision with root package name */
    public String f147624fr;
    public String imei;
    public boolean is_login;
    public String nettp;

    /* renamed from: pf, reason: collision with root package name */
    public String f147625pf;
    public String session_id;
    public long uin;
    public int uip;
    public long user_id;
    public String version;

    /* renamed from: x, reason: collision with root package name */
    public double f147626x;

    /* renamed from: y, reason: collision with root package name */
    public double f147627y;

    public user_login_t() {
        this.user_id = 0L;
        this.session_id = "";
        this.uin = 0L;
        this.uip = 0;
        this.imei = "";
        this.f147626x = 0.0d;
        this.f147627y = 0.0d;
        this.f147625pf = "";
        this.version = "";
        this.is_login = true;
        this.f147624fr = "";
        this.nettp = "";
        this.channel = "";
    }

    @Override // com.tencent.mapsdk.internal.p
    public final String className() {
        return "navsns.user_login_t";
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void readFrom(m mVar) {
        this.user_id = mVar.a(this.user_id, 0, true);
        this.session_id = mVar.b(1, true);
        this.uin = mVar.a(this.uin, 2, true);
        this.uip = mVar.a(this.uip, 3, true);
        this.imei = mVar.b(4, false);
        this.f147626x = mVar.a(this.f147626x, 5, false);
        this.f147627y = mVar.a(this.f147627y, 6, false);
        this.f147625pf = mVar.b(7, false);
        this.version = mVar.b(8, false);
        this.is_login = mVar.a(9, false);
        this.f147624fr = mVar.b(10, false);
        this.nettp = mVar.b(11, false);
        this.channel = mVar.b(12, false);
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void writeTo(n nVar) {
        nVar.a(this.user_id, 0);
        nVar.a(this.session_id, 1);
        nVar.a(this.uin, 2);
        nVar.a(this.uip, 3);
        String str = this.imei;
        if (str != null) {
            nVar.a(str, 4);
        }
        nVar.a(this.f147626x, 5);
        nVar.a(this.f147627y, 6);
        String str2 = this.f147625pf;
        if (str2 != null) {
            nVar.a(str2, 7);
        }
        String str3 = this.version;
        if (str3 != null) {
            nVar.a(str3, 8);
        }
        nVar.a(this.is_login, 9);
        String str4 = this.f147624fr;
        if (str4 != null) {
            nVar.a(str4, 10);
        }
        String str5 = this.nettp;
        if (str5 != null) {
            nVar.a(str5, 11);
        }
        String str6 = this.channel;
        if (str6 != null) {
            nVar.a(str6, 12);
        }
    }

    public user_login_t(long j3, String str, long j16, int i3, String str2, double d16, double d17, String str3, String str4, boolean z16, String str5, String str6, String str7) {
        this.user_id = j3;
        this.session_id = str;
        this.uin = j16;
        this.uip = i3;
        this.imei = str2;
        this.f147626x = d16;
        this.f147627y = d17;
        this.f147625pf = str3;
        this.version = str4;
        this.is_login = z16;
        this.f147624fr = str5;
        this.nettp = str6;
        this.channel = str7;
    }
}
