package com.tencent.mobileqq.guild.mainframe.helper;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static a f227424c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile d f227425d;

    /* renamed from: a, reason: collision with root package name */
    private String f227426a = "";

    /* renamed from: b, reason: collision with root package name */
    private a f227427b = null;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f227428a;

        /* renamed from: b, reason: collision with root package name */
        public String f227429b;

        public a(int i3, @NonNull String str) {
            this.f227428a = i3;
            this.f227429b = str;
        }

        public boolean a() {
            int i3 = this.f227428a;
            if (i3 == 0 || i3 == 1) {
                return true;
            }
            return false;
        }

        public boolean equals(Object obj) {
            String str;
            a aVar;
            String str2;
            if (!(obj instanceof a) || (str = this.f227429b) == null || (str2 = (aVar = (a) obj).f227429b) == null || this.f227428a != aVar.f227428a || !str.equals(str2)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "SelItem{selType=" + this.f227428a + ", selKey='" + this.f227429b + "'}";
        }
    }

    private cs1.b c(List<cs1.b> list) {
        for (cs1.b bVar : list) {
            if (bVar.h() == 2) {
                return bVar;
            }
        }
        return null;
    }

    private cs1.b d(List<cs1.b> list) {
        for (cs1.b bVar : list) {
            if (bVar.b()) {
                return bVar;
            }
        }
        return null;
    }

    private cs1.b e(List<cs1.b> list) {
        for (cs1.b bVar : list) {
            if (bVar.h() == 1) {
                return bVar;
            }
        }
        return null;
    }

    public static d f() {
        if (f227425d == null) {
            synchronized (d.class) {
                if (f227425d == null) {
                    f227425d = new d();
                }
            }
        }
        return f227425d;
    }

    private boolean g(int i3) {
        if (i3 == 0 || i3 == 1) {
            return true;
        }
        return false;
    }

    private void h(List<cs1.b> list) {
        cs1.b e16 = e(list);
        if (e16 == null) {
            e16 = c(list);
        }
        if (e16 == null) {
            e16 = d(list);
        }
        if (e16 != null) {
            a aVar = new a(e16.f391795d, e16.f391796e);
            j(aVar);
            this.f227426a = aVar.f227429b + " " + ch.g();
            if (QLog.isColorLevel()) {
                QLog.i("Guild.MF.Lt.GuildLeftBarSelHelper", 2, "setDefaultSelItem to type:" + aVar.f227428a + " new value:" + this.f227426a);
                return;
            }
            return;
        }
        QLog.i("Guild.MF.Lt.GuildLeftBarSelHelper", 2, "setDefaultSelItem to null");
        j(null);
        this.f227426a = "";
    }

    public void a() {
        this.f227427b = null;
    }

    @NonNull
    public a b() {
        if (this.f227427b == null) {
            bw bwVar = bw.f235485a;
            this.f227427b = new a(bwVar.J(), bwVar.I());
        }
        a aVar = this.f227427b;
        return new a(aVar.f227428a, aVar.f227429b);
    }

    public void i(String str) {
        this.f227426a = str + " " + ch.g();
    }

    public void j(a aVar) {
        k(aVar, false);
    }

    public void k(a aVar, boolean z16) {
        int i3;
        String str;
        String str2;
        if (aVar != null) {
            s.a("Guild.MF.Lt.GuildLeftBarSelHelper", aVar.f227429b);
        }
        this.f227427b = aVar;
        bw bwVar = bw.f235485a;
        if (aVar != null) {
            i3 = aVar.f227428a;
        } else {
            i3 = -1;
        }
        bwVar.r1(i3);
        a aVar2 = this.f227427b;
        String str3 = "";
        if (aVar2 == null) {
            str = "";
        } else {
            str = aVar2.f227429b;
        }
        bwVar.q1(str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setSelItem by ");
        if (z16) {
            str2 = "click";
        } else {
            str2 = "jump";
        }
        sb5.append(str2);
        a aVar3 = this.f227427b;
        if (aVar3 != null) {
            str3 = aVar3.toString();
        }
        sb5.append(str3);
        QLog.i("Guild.MF.Lt.GuildLeftBarSelHelper", 1, sb5.toString());
        f227424c = this.f227427b;
    }

    public boolean l(@NonNull List<cs1.b> list) {
        boolean z16;
        cs1.b next;
        QLog.d("Guild.MF.Lt.GuildLeftBarSelHelper", 2, "updateCurSelItem size:" + list.size());
        a b16 = b();
        if (b16.f227428a == -1) {
            h(list);
            return true;
        }
        String str = b16.f227429b + " " + ch.g();
        Iterator<cs1.b> it = list.iterator();
        do {
            if (it.hasNext()) {
                next = it.next();
                if (g(b16.f227428a) && g(next.f391795d) && TextUtils.equals(b16.f227429b, next.f391796e)) {
                    int i3 = b16.f227428a;
                    int i16 = next.f391795d;
                    if (i3 != i16) {
                        b16.f227428a = i16;
                        j(b16);
                        if (QLog.isColorLevel()) {
                            QLog.d("Guild.MF.Lt.GuildLeftBarSelHelper", 2, "updateCurSelItem find last select item=" + b16.toString() + " type changed");
                        }
                        return true;
                    }
                    if (!TextUtils.equals(str, this.f227426a)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Guild.MF.Lt.GuildLeftBarSelHelper", 2, "updateCurSelItem mLastJumpGuildIdWithUid is dif, jumpKey=" + str, ", lastJumpKey=", this.f227426a);
                        }
                        j(b16);
                        this.f227426a = str;
                        return true;
                    }
                    z16 = true;
                }
            } else {
                z16 = false;
            }
            if (z16) {
                return false;
            }
            h(list);
            return true;
        } while (!b16.equals(new a(next.f391795d, next.f391796e)));
        this.f227426a = str;
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Lt.GuildLeftBarSelHelper", 2, "updateCurSelItem find last select item=" + b16);
        }
        return false;
    }
}
