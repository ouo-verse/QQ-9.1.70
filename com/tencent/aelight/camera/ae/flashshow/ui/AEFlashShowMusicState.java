package com.tencent.aelight.camera.ae.flashshow.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/di;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "musicOn", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "mid", "d", "title", "albumUrl", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.di, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class AEFlashShowMusicState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean musicOn;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String mid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String albumUrl;

    public AEFlashShowMusicState(boolean z16, String str, String str2, String str3) {
        this.musicOn = z16;
        this.mid = str;
        this.title = str2;
        this.albumUrl = str3;
    }

    /* renamed from: a, reason: from getter */
    public final String getAlbumUrl() {
        return this.albumUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getMid() {
        return this.mid;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getMusicOn() {
        return this.musicOn;
    }

    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.musicOn;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        String str = this.mid;
        int hashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.albumUrl;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "AEFlashShowMusicState(musicOn=" + this.musicOn + ", mid=" + this.mid + ", title=" + this.title + ", albumUrl=" + this.albumUrl + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AEFlashShowMusicState)) {
            return false;
        }
        AEFlashShowMusicState aEFlashShowMusicState = (AEFlashShowMusicState) other;
        return this.musicOn == aEFlashShowMusicState.musicOn && Intrinsics.areEqual(this.mid, aEFlashShowMusicState.mid) && Intrinsics.areEqual(this.title, aEFlashShowMusicState.title) && Intrinsics.areEqual(this.albumUrl, aEFlashShowMusicState.albumUrl);
    }

    public /* synthetic */ AEFlashShowMusicState(boolean z16, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3);
    }
}
