package com.tencent.qqnt.shortvideo.compress;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R0\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8F@FX\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\f\u0010\r\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/shortvideo/compress/c;", "", "Landroid/content/Context;", "context", "", "b", "Ljava/lang/String;", "PKG_NAME", "c", "DEFAULT_SHORT_VIDEO_PATH", "", "<set-?>", "d", "I", "a", "()I", "setShortVideoSoLoadStatus", "(I)V", "getShortVideoSoLoadStatus$annotations", "()V", "shortVideoSoLoadStatus", "<init>", "shortvideo_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f362245a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String PKG_NAME = "com.tencent.mobileqq";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String DEFAULT_SHORT_VIDEO_PATH = Environment.getDataDirectory().toString() + "/data/" + PKG_NAME + "/app_lib/QzoneVideoPlugin/";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int shortVideoSoLoadStatus = -4;

    c() {
    }

    public static final synchronized int a() {
        int i3;
        synchronized (c.class) {
            i3 = shortVideoSoLoadStatus;
        }
        return i3;
    }

    @JvmStatic
    @NotNull
    public static final String b(@Nullable Context context) {
        if (context == null) {
            return DEFAULT_SHORT_VIDEO_PATH;
        }
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getParent() + "/app_lib/QzoneVideoPlugin/";
        }
        return DEFAULT_SHORT_VIDEO_PATH;
    }
}
