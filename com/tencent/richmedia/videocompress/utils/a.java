package com.tencent.richmedia.videocompress.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<String> f365135a = new ArrayList<>(50);

    public void a(@NonNull String str) {
        this.f365135a.add(str);
    }

    public void b(@NonNull String str, int i3) {
        if (i3 > 0) {
            d(str, String.valueOf(i3));
        }
    }

    public void c(@NonNull String str, int i3, int i16) {
        if (i3 > 0) {
            d(str, String.valueOf(i3));
        } else {
            d(str, String.valueOf(i16));
        }
    }

    public void d(@NonNull String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.f365135a.add(str);
            this.f365135a.add(str2);
        }
    }

    public ArrayList<String> e() {
        return this.f365135a;
    }
}
