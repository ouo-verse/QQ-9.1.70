package com.tencent.mobileqq.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;

/* compiled from: P */
/* loaded from: classes20.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private static a f307817a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f307818a;

        /* renamed from: b, reason: collision with root package name */
        private long f307819b;

        a() {
        }

        public String a() {
            return this.f307818a;
        }

        public boolean b() {
            if (System.currentTimeMillis() - this.f307819b > 3000) {
                return true;
            }
            return false;
        }

        public void c(String str) {
            this.f307818a = str;
            this.f307819b = System.currentTimeMillis();
        }
    }

    public static synchronized String a(Context context) {
        String sb5;
        synchronized (v.class) {
            a aVar = f307817a;
            if (aVar != null && !aVar.b()) {
                return f307817a.a();
            }
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            if (clipboardManager == null) {
                return "";
            }
            ClipData primaryClip = ClipboardMonitor.getPrimaryClip(clipboardManager);
            if (primaryClip == null) {
                sb5 = "";
            } else {
                StringBuilder sb6 = new StringBuilder();
                for (int i3 = 0; i3 < primaryClip.getItemCount(); i3++) {
                    for (char c16 : primaryClip.getItemAt(i3).coerceToText(context).toString().toCharArray()) {
                        if (Character.isDigit(c16)) {
                            sb6.append(c16);
                        }
                    }
                }
                sb5 = sb6.toString();
            }
            a aVar2 = new a();
            f307817a = aVar2;
            aVar2.c(sb5);
            return sb5;
        }
    }
}
