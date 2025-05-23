package com.tencent.halley.downloader.b;

import com.tencent.halley.common.a.h;
import com.tencent.halley.downloader.task.TaskDivider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f113619a;

    /* renamed from: b, reason: collision with root package name */
    public long f113620b;

    /* renamed from: c, reason: collision with root package name */
    public long f113621c;

    /* renamed from: d, reason: collision with root package name */
    public int f113622d;

    /* renamed from: e, reason: collision with root package name */
    public long f113623e;

    /* renamed from: f, reason: collision with root package name */
    public String f113624f;

    /* renamed from: g, reason: collision with root package name */
    public String f113625g;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113619a = 0;
        this.f113620b = 0L;
        this.f113621c = -1L;
        this.f113622d = -1;
        this.f113623e = -1L;
        this.f113624f = "";
        this.f113625g = "";
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(TaskDivider taskDivider, List<c> list, int i3, long j3) {
        boolean z16;
        int i16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, taskDivider, list, Integer.valueOf(i3), Long.valueOf(j3));
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f113619a);
        sb5.append(",");
        sb5.append(this.f113620b);
        sb5.append(",");
        sb5.append(this.f113622d);
        sb5.append(",");
        sb5.append(this.f113621c);
        sb5.append(",");
        sb5.append(this.f113623e);
        sb5.append(",");
        sb5.append(this.f113624f);
        sb5.append(",");
        int a16 = h.a("down_hijack_force_feature", 0, 1, 0);
        if (list.size() > 0) {
            for (c cVar : list) {
                if (cVar.f113629c) {
                    this.f113625g = cVar.f113635i;
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (list.size() > 0) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().f113629c) {
                }
            }
            if (taskDivider == null) {
                i16 = taskDivider.getHijackRollbackFlow();
            } else {
                i16 = -1;
            }
            sb5.append(a16);
            sb5.append(",");
            String str2 = "1";
            Object obj = "0";
            if (!z16) {
                str = "1";
            } else {
                str = "0";
            }
            sb5.append(str);
            sb5.append(",");
            if (!z17) {
                str2 = "0";
            }
            sb5.append(str2);
            sb5.append(",");
            sb5.append(i16);
            sb5.append(",");
            if (j3 > 0) {
                obj = Long.valueOf(j3);
            }
            sb5.append(obj);
            sb5.append(",");
            sb5.append(i3);
            sb5.append(",");
            sb5.append(this.f113625g);
            return sb5.toString();
        }
        z17 = false;
        if (taskDivider == null) {
        }
        sb5.append(a16);
        sb5.append(",");
        String str22 = "1";
        Object obj2 = "0";
        if (!z16) {
        }
        sb5.append(str);
        sb5.append(",");
        if (!z17) {
        }
        sb5.append(str22);
        sb5.append(",");
        sb5.append(i16);
        sb5.append(",");
        if (j3 > 0) {
        }
        sb5.append(obj2);
        sb5.append(",");
        sb5.append(i3);
        sb5.append(",");
        sb5.append(this.f113625g);
        return sb5.toString();
    }
}
