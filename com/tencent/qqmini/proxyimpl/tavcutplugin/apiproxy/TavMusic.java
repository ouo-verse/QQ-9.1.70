package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "musicId", "b", "musicPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.m, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class TavMusic {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String musicId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String musicPath;

    public TavMusic(String musicId, String musicPath) {
        Intrinsics.checkNotNullParameter(musicId, "musicId");
        Intrinsics.checkNotNullParameter(musicPath, "musicPath");
        this.musicId = musicId;
        this.musicPath = musicPath;
    }

    /* renamed from: a, reason: from getter */
    public final String getMusicId() {
        return this.musicId;
    }

    /* renamed from: b, reason: from getter */
    public final String getMusicPath() {
        return this.musicPath;
    }

    public int hashCode() {
        return (this.musicId.hashCode() * 31) + this.musicPath.hashCode();
    }

    public String toString() {
        return "TavMusic(musicId=" + this.musicId + ", musicPath=" + this.musicPath + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TavMusic)) {
            return false;
        }
        TavMusic tavMusic = (TavMusic) other;
        return Intrinsics.areEqual(this.musicId, tavMusic.musicId) && Intrinsics.areEqual(this.musicPath, tavMusic.musicPath);
    }
}
