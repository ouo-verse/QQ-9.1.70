package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class l implements BaseNotifyDataAdapter {

    /* renamed from: e, reason: collision with root package name */
    private static int f387904e;

    /* renamed from: f, reason: collision with root package name */
    private static int f387905f;

    /* renamed from: a, reason: collision with root package name */
    private Resources f387906a;

    /* renamed from: b, reason: collision with root package name */
    private String f387907b;

    /* renamed from: c, reason: collision with root package name */
    private String f387908c;

    /* renamed from: d, reason: collision with root package name */
    private String f387909d;

    private static boolean a(int i3) {
        return (i3 == -1 || i3 == 0) ? false : true;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        int a16;
        if (a(f387904e)) {
            return f387904e;
        }
        String str = this.f387909d;
        if (!a(str)) {
            a16 = -1;
        } else {
            a16 = a(str, "_notifyicon");
        }
        f387904e = a16;
        if (a(a16)) {
            return f387904e;
        }
        for (String str2 = this.f387908c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.f387906a.getIdentifier("vivo_push_rom" + str2 + "_notifyicon", "drawable", this.f387907b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f387906a.getIdentifier("vivo_push_notifyicon", "drawable", this.f387907b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        int a16;
        if (a(f387905f)) {
            return f387905f;
        }
        String str = this.f387909d;
        if (!a(str)) {
            a16 = -1;
        } else {
            a16 = a(str, "_icon");
        }
        f387905f = a16;
        if (a(a16)) {
            return f387905f;
        }
        for (String str2 = this.f387908c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.f387906a.getIdentifier("vivo_push_rom" + str2 + "_icon", "drawable", this.f387907b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f387906a.getIdentifier("vivo_push_icon", "drawable", this.f387907b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return 2;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.f387907b = context.getPackageName();
        this.f387906a = context.getResources();
        this.f387908c = n.a();
        this.f387909d = Build.VERSION.RELEASE;
    }

    private static boolean a(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        u.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    }

    private int a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            if (split != null && split.length > 0) {
                str = split[0];
            }
            try {
                for (int parseInt = Integer.parseInt(str); parseInt > 0; parseInt--) {
                    String str3 = "vivo_push_ard" + parseInt + str2;
                    u.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                    int identifier = this.f387906a.getIdentifier(str3, "drawable", this.f387907b);
                    if (identifier > 0) {
                        u.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (Exception e16) {
                u.a("DefaultNotifyDataAdapter", e16);
            }
        }
        return -1;
    }
}
