package com.tencent.sqshow.zootopia.utils;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.util.VersionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/b;", "", "Landroid/content/Context;", "context", "", "b", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f373264a = new b();

    b() {
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (VersionUtils.isrFroyo()) {
            Object systemService = context.getSystemService("audio");
            AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            if (audioManager != null) {
                audioManager.abandonAudioFocus(null);
            }
        }
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (VersionUtils.isrFroyo()) {
            Object systemService = context.getSystemService("audio");
            AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            if (audioManager != null) {
                audioManager.requestAudioFocus(null, 3, 2);
            }
        }
    }
}
