package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import com.tencent.mobileqq.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes12.dex */
public class FileManagerEntitySearchPCPart {

    /* renamed from: h, reason: collision with root package name */
    private static Calendar f207684h = Calendar.getInstance();

    /* renamed from: a, reason: collision with root package name */
    public String f207685a;

    /* renamed from: b, reason: collision with root package name */
    public long f207686b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f207687c;

    /* renamed from: d, reason: collision with root package name */
    public int f207688d;

    /* renamed from: e, reason: collision with root package name */
    public FileDownloadState f207689e;

    /* renamed from: f, reason: collision with root package name */
    public long f207690f;

    /* renamed from: g, reason: collision with root package name */
    public long f207691g;

    /* loaded from: classes12.dex */
    public enum FileDownloadState {
        KNULL,
        KDOWNLOADING,
        KCOMPLETE,
        KFAILED,
        PAUSE
    }

    public FileManagerEntitySearchPCPart() {
        this.f207685a = "";
        this.f207686b = 0L;
        this.f207687c = false;
        this.f207688d = 0;
        FileDownloadState fileDownloadState = FileDownloadState.KNULL;
        this.f207685a = "";
        this.f207686b = 0L;
        this.f207687c = false;
        this.f207688d = 0;
        this.f207689e = fileDownloadState;
        this.f207690f = 0L;
        this.f207691g = 0L;
    }

    public static String b(long j3, Context context) {
        f207684h.setTimeInMillis(System.currentTimeMillis());
        int i3 = f207684h.get(1);
        int i16 = f207684h.get(2);
        int i17 = f207684h.get(5);
        f207684h.setTimeInMillis(j3);
        int i18 = f207684h.get(1);
        int i19 = f207684h.get(2);
        int i26 = f207684h.get(5);
        if (i3 != i18) {
            return new SimpleDateFormat("yyyy-MM-dd ", context.getResources().getConfiguration().locale).format(new Date(j3));
        }
        if (i16 != i19) {
            return new SimpleDateFormat("MM-dd ", context.getResources().getConfiguration().locale).format(new Date(j3));
        }
        if (i17 == i26) {
            return new SimpleDateFormat("HH:mm ", context.getResources().getConfiguration().locale).format(new Date(j3));
        }
        if (i17 - i26 <= 1) {
            return context.getString(R.string.f213775r4);
        }
        return new SimpleDateFormat("MM-dd ", context.getResources().getConfiguration().locale).format(new Date(j3));
    }

    public String a(Context context, long j3) {
        if (g()) {
            return d(this.f207691g, "%s %s/s");
        }
        String b16 = b(this.f207686b, context);
        if (!i()) {
            return b16;
        }
        String str = b16 + "  " + d(j3, "%s%s");
        if (f()) {
            return String.format("%s  %s", str, context.getString(R.string.zwb));
        }
        if (h()) {
            return String.format("%s  %s", str, context.getString(R.string.zwa));
        }
        return str;
    }

    public int c() {
        if (e()) {
            return R.drawable.qui_chevron_right;
        }
        if (f()) {
            return 0;
        }
        if (g()) {
            return R.drawable.jm8;
        }
        if (h()) {
            return R.drawable.qui_caution_filled_feedback_error;
        }
        return R.drawable.jm9;
    }

    String d(long j3, String str) {
        String l3;
        String str2;
        float f16 = (float) j3;
        float f17 = f16 / 1.07374182E9f;
        if (f17 > 1.0f) {
            l3 = String.format("%.2f", Float.valueOf(f17));
            str2 = "GB";
        } else {
            float f18 = f16 / 1048576.0f;
            if (f18 > 1.0f) {
                l3 = String.format("%.2f", Float.valueOf(f18));
                str2 = "MB";
            } else {
                float f19 = f16 / 1024.0f;
                if (f19 > 1.0f) {
                    l3 = String.format("%.2f", Float.valueOf(f19));
                    str2 = "KB";
                } else {
                    if (j3 <= 0) {
                        l3 = "0";
                    } else {
                        l3 = Long.toString(j3);
                    }
                    str2 = "B";
                }
            }
        }
        return String.format(str, l3, str2);
    }

    public boolean e() {
        return this.f207687c;
    }

    public boolean f() {
        if (this.f207689e == FileDownloadState.KCOMPLETE) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f207689e == FileDownloadState.KDOWNLOADING) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f207689e == FileDownloadState.KFAILED) {
            return true;
        }
        return false;
    }

    public boolean i() {
        return !this.f207687c;
    }

    public int j(long j3) {
        if (f()) {
            return 100;
        }
        if (!g() || j3 <= 0) {
            return 0;
        }
        return Math.min(Math.max(0, (int) ((this.f207690f * 100) / j3)), 100);
    }

    public String toString() {
        return "FileManagerEntityForSearchPC{, fileId=" + this.f207685a + ", creationTime=" + this.f207686b + ", isDir=" + this.f207687c + ", dirType=" + this.f207688d + ", downloadState=" + this.f207689e + ", downloadProgress=" + this.f207690f + ", downloadSpeed=" + this.f207691g + '}';
    }
}
