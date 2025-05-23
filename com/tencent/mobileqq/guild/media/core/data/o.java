package com.tencent.mobileqq.guild.media.core.data;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0000H\u0016J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\b\u0010\rR\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0017\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/data/o;", "", "", "a", "b", TtmlNode.ATTR_TTS_ORIGIN, "c", "", "d", "I", "getMicState", "()I", "e", "(I)V", "micState", "getCameraState", "cameraState", "f", "getScreenState", tl.h.F, "screenState", "getNetworkQuality", "networkQuality", "i", "getSysMicBusy", "sysMicBusy", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class o implements Cloneable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int micState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int cameraState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int screenState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int networkQuality;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int sysMicBusy;

    public final void a() {
        this.micState = 0;
        this.cameraState = 0;
        this.screenState = 0;
        this.networkQuality = 0;
        this.sysMicBusy = 0;
    }

    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.data.UserDevState");
        return (o) clone;
    }

    public final void c(@NotNull o origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.micState = origin.micState;
        this.cameraState = origin.cameraState;
        this.screenState = origin.screenState;
        this.networkQuality = origin.networkQuality;
        this.sysMicBusy = origin.sysMicBusy;
    }

    public final void d(int i3) {
        this.cameraState = i3;
    }

    public final void e(int i3) {
        this.micState = i3;
    }

    public final void f(int i3) {
        this.networkQuality = i3;
    }

    public final void h(int i3) {
        this.screenState = i3;
    }

    public final void i(int i3) {
        this.sysMicBusy = i3;
    }
}
