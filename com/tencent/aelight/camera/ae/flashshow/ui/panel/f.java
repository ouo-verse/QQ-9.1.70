package com.tencent.aelight.camera.ae.flashshow.ui.panel;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R*\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\u0003\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/f;", "", "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/e;", "b", "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/e;", DownloadInfo.spKey_Config, "value", "a", "()Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/e;", "(Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/e;)V", "getCurrentConfig$annotations", "()V", "currentConfig", "<init>", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f65048a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static e config = g.a();

    f() {
    }

    public static final e a() {
        return config;
    }

    public static final void b(e value) {
        Intrinsics.checkNotNullParameter(value, "value");
        config = value;
    }
}
