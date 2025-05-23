package com.tencent.biz.pubaccount.weishi.player.wrapper;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R\"\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/player/wrapper/l;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "audioCodec", "b", "g", "audioProfile", "c", tl.h.F, "videoCodec", "d", "e", "j", "videoProfile", "", "I", "()I", "i", "(I)V", "videoFps", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String audioCodec = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String audioProfile = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String videoCodec = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String videoProfile = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int videoFps;

    /* renamed from: a, reason: from getter */
    public final String getAudioCodec() {
        return this.audioCodec;
    }

    /* renamed from: b, reason: from getter */
    public final String getAudioProfile() {
        return this.audioProfile;
    }

    /* renamed from: c, reason: from getter */
    public final String getVideoCodec() {
        return this.videoCodec;
    }

    /* renamed from: d, reason: from getter */
    public final int getVideoFps() {
        return this.videoFps;
    }

    /* renamed from: e, reason: from getter */
    public final String getVideoProfile() {
        return this.videoProfile;
    }

    public final void f(String str) {
        this.audioCodec = str;
    }

    public final void g(String str) {
        this.audioProfile = str;
    }

    public final void h(String str) {
        this.videoCodec = str;
    }

    public final void i(int i3) {
        this.videoFps = i3;
    }

    public final void j(String str) {
        this.videoProfile = str;
    }
}
