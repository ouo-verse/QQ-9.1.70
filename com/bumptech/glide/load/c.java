package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
public interface c {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f31560a = Charset.forName("UTF-8");

    void b(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
