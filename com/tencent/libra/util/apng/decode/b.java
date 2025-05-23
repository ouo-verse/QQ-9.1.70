package com.tencent.libra.util.apng.decode;

import android.text.TextUtils;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f118817a;

    /* renamed from: b, reason: collision with root package name */
    public int f118818b;

    /* renamed from: c, reason: collision with root package name */
    public int f118819c;

    /* renamed from: d, reason: collision with root package name */
    public int f118820d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 4) {
            return ((str.charAt(3) & '\u00ff') << 24) | (str.charAt(0) & '\u00ff') | ((str.charAt(1) & '\u00ff') << 8) | ((str.charAt(2) & '\u00ff') << 16);
        }
        return -1159790593;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(h11.a aVar) throws IOException {
        int available = aVar.available();
        b(aVar);
        int available2 = available - aVar.available();
        int i3 = this.f118817a;
        if (available2 <= i3) {
            if (available2 < i3) {
                aVar.skip(i3 - available2);
                return;
            }
            return;
        }
        throw new IOException("Out of chunk area");
    }

    void b(h11.a aVar) throws IOException {
    }
}
