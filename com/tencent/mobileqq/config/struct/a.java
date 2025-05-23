package com.tencent.mobileqq.config.struct;

import com.tencent.mobileqq.config.d;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f202963a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f202964b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f202965c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f202966d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f202967e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f202968f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f202969g = "";

    /* renamed from: h, reason: collision with root package name */
    private d f202970h = null;

    public void a() {
        if (this.f202967e.equals("LOCAL")) {
            if (!this.f202968f.equals("1") && !this.f202968f.equals("2") && !this.f202968f.equals("4") && !this.f202968f.equals("5") && !this.f202968f.equals("6")) {
                this.f202968f.equals("7");
                return;
            }
            return;
        }
        if (!this.f202967e.equals("WAP") && !this.f202967e.equals("TMTWAP") && !this.f202967e.equals("WAPI") && !this.f202967e.equals("TMTWAPI") && !this.f202967e.equals("VOICECALL")) {
            if (this.f202967e.equals("QQMSG")) {
                this.f202965c.equals("AUTO");
                return;
            }
            if (!this.f202967e.equals("AUTOQQMSG") && !this.f202967e.equals("HTTP") && !this.f202967e.equals("AUTOSMS")) {
                if (this.f202967e.equals("USERSMS")) {
                    this.f202965c.equals("AUTO");
                } else {
                    this.f202967e.equals("RESET");
                }
            }
        }
    }

    public void b(boolean z16) {
        if (this.f202966d != null && !this.f202967e.equals("") && this.f202970h == null) {
            this.f202970h = new d(this.f202966d, 1, 1);
        }
    }
}
