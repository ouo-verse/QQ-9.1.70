package com.tencent.mobileqq.troop.homework;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f296260a;

    /* renamed from: b, reason: collision with root package name */
    public long f296261b;

    /* renamed from: c, reason: collision with root package name */
    public String f296262c;

    /* renamed from: d, reason: collision with root package name */
    public String f296263d;

    /* renamed from: e, reason: collision with root package name */
    public String f296264e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f296265f;

    /* renamed from: g, reason: collision with root package name */
    public String f296266g;

    /* renamed from: h, reason: collision with root package name */
    public int f296267h;

    /* renamed from: i, reason: collision with root package name */
    public long f296268i;

    /* renamed from: j, reason: collision with root package name */
    public List<Long> f296269j;

    /* renamed from: k, reason: collision with root package name */
    public long f296270k;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "HomeworkInfo{content='" + this.f296263d + "', group_id=" + this.f296260a + ", uin=" + this.f296261b + ", title='" + this.f296262c + "', date='" + this.f296264e + "', need_feedback=" + this.f296265f + ", course_name=" + this.f296266g + ", syncgids=" + this.f296269j + ", hw_id=" + this.f296270k + '}';
    }
}
