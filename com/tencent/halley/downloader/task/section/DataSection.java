package com.tencent.halley.downloader.task.section;

import com.tencent.halley.NotProguard;
import com.tencent.halley.common.utils.d;
import com.tencent.halley.downloader.task.TaskDivider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@NotProguard
/* loaded from: classes6.dex */
public class DataSection {
    static IPatchRedirector $redirector_;
    private static String INNER_SEG;
    public TaskDivider divider;
    public volatile long end;
    public volatile boolean isRunning;
    public int parentId;
    public boolean parseOk;
    public volatile long read;
    public volatile long save;
    public int sectionId;
    public volatile long start;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f113942a;

        /* renamed from: b, reason: collision with root package name */
        public long f113943b;

        public a(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
            } else {
                this.f113942a = j3;
                this.f113943b = j16;
            }
        }

        public final boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f113942a == aVar.f113942a && this.f113943b == aVar.f113943b) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "[" + this.f113942a + "," + this.f113943b + "]";
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public List<a> f113944a;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f113944a = new ArrayList();
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f113944a.size();
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder("bytes=");
            for (a aVar : this.f113944a) {
                sb5.append(aVar.f113942a);
                sb5.append("-");
                long j3 = aVar.f113943b;
                if (j3 != -1) {
                    sb5.append(j3);
                }
                sb5.append(",");
            }
            sb5.deleteCharAt(sb5.length() - 1);
            return sb5.toString();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14266);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INNER_SEG = ",";
        }
    }

    public DataSection(TaskDivider taskDivider, long j3, long j16, long j17, long j18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, taskDivider, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18));
            return;
        }
        this.parseOk = true;
        this.sectionId = -1;
        this.parentId = -1;
        this.isRunning = false;
        this.divider = taskDivider;
        this.start = j3;
        this.end = j18;
        this.save = j16;
        this.read = Math.max(j16, j17);
    }

    public long getRemain(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, j3)).longValue();
        }
        if (this.end != -1) {
            return this.end - this.read;
        }
        return j3 - this.read;
    }

    public a toByteRange(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        long j3 = this.end;
        if (i3 <= 0) {
            return new a(this.read, j3);
        }
        if (this.end == -1) {
            j3 = this.read + i3;
        } else {
            long j16 = i3;
            if (j16 < this.end - this.read) {
                j3 = this.read + j16;
            } else if (!z16) {
                j3 = -1;
            }
        }
        return new a(this.read, j3);
    }

    public String toDbText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.sectionId + INNER_SEG + this.parentId + INNER_SEG + this.start + INNER_SEG + this.save + INNER_SEG + this.end;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "[" + this.sectionId + INNER_SEG + this.parentId + INNER_SEG + this.start + INNER_SEG + this.save + INNER_SEG + this.read + INNER_SEG + this.end + "]";
    }

    public DataSection(TaskDivider taskDivider, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) taskDivider, (Object) str);
            return;
        }
        this.parseOk = true;
        this.sectionId = -1;
        this.parentId = -1;
        this.isRunning = false;
        this.divider = taskDivider;
        String[] split = str.split(INNER_SEG);
        if (split == null || split.length != 5) {
            d.d("halley-downloader-DataSection", "new BDRange(String) pattern fail.");
            this.parseOk = false;
            return;
        }
        this.sectionId = Integer.valueOf(split[0]).intValue();
        this.parentId = Integer.valueOf(split[1]).intValue();
        this.start = Long.valueOf(split[2]).longValue();
        this.save = Long.valueOf(split[3]).longValue();
        this.read = this.save;
        this.end = Long.valueOf(split[4]).longValue();
    }
}
