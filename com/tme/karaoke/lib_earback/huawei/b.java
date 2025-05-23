package com.tme.karaoke.lib_earback.huawei;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tme/karaoke/lib_earback/huawei/b;", "", "", "a", "b", "Ljava/lang/Boolean;", "isDegradeFunctionOn", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences;", "mSharePerference", "<init>", "()V", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes27.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Boolean isDegradeFunctionOn;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final SharedPreferences mSharePerference;

    /* renamed from: c, reason: collision with root package name */
    public static final b f386994c = new b();

    static {
        SharedPreferences sharedPreferences;
        Context a16 = com.tme.karaoke.lib_earback.base.b.a();
        if (a16 != null) {
            sharedPreferences = a16.getSharedPreferences("HWAudioKitDegradeMonitor", 0);
        } else {
            sharedPreferences = null;
        }
        mSharePerference = sharedPreferences;
    }

    b() {
    }

    private final boolean a() {
        SharedPreferences sharedPreferences = mSharePerference;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("degrade_switcher_key", false);
    }

    public final boolean b() {
        if (isDegradeFunctionOn == null) {
            isDegradeFunctionOn = Boolean.valueOf(a());
        }
        Boolean bool = isDegradeFunctionOn;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
