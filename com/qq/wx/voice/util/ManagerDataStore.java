package com.qq.wx.voice.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ManagerDataStore {
    public static final long NULLNUM = (long) (-Math.pow(2.0d, 63.0d));

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences.Editor f41106a = null;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f41107b = null;

    public long getDeltaTime() {
        return this.f41107b.getLong("deltaTime", NULLNUM);
    }

    public void init(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("wxvoicesdk", 0);
        this.f41107b = sharedPreferences;
        this.f41106a = sharedPreferences.edit();
    }

    public void setDeltaTime(long j3) {
        this.f41106a.putLong("deltaTime", j3);
        this.f41106a.commit();
    }
}
