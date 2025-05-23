package dr0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\"\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\n\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000e\u00a8\u0006&"}, d2 = {"Ldr0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "g", "(I)V", "aniStickerType", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "aniStickerPackId", "e", "aniStickerId", "d", "getSevrId", "j", "sevrId", "getLocalId", h.F, "localId", "k", "text", "getRandomKey", "i", "randomKey", "<init>", "(ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;I)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: dr0.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class LottieFaceInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int aniStickerType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String aniStickerPackId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String aniStickerId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int sevrId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int localId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String text;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int randomKey;

    public LottieFaceInfo() {
        this(0, null, null, 0, 0, null, 0, 127, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAniStickerId() {
        return this.aniStickerId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAniStickerPackId() {
        return this.aniStickerPackId;
    }

    /* renamed from: c, reason: from getter */
    public final int getAniStickerType() {
        return this.aniStickerType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.aniStickerId = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LottieFaceInfo)) {
            return false;
        }
        LottieFaceInfo lottieFaceInfo = (LottieFaceInfo) other;
        if (this.aniStickerType == lottieFaceInfo.aniStickerType && Intrinsics.areEqual(this.aniStickerPackId, lottieFaceInfo.aniStickerPackId) && Intrinsics.areEqual(this.aniStickerId, lottieFaceInfo.aniStickerId) && this.sevrId == lottieFaceInfo.sevrId && this.localId == lottieFaceInfo.localId && Intrinsics.areEqual(this.text, lottieFaceInfo.text) && this.randomKey == lottieFaceInfo.randomKey) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.aniStickerPackId = str;
    }

    public final void g(int i3) {
        this.aniStickerType = i3;
    }

    public final void h(int i3) {
        this.localId = i3;
    }

    public int hashCode() {
        return (((((((((((this.aniStickerType * 31) + this.aniStickerPackId.hashCode()) * 31) + this.aniStickerId.hashCode()) * 31) + this.sevrId) * 31) + this.localId) * 31) + this.text.hashCode()) * 31) + this.randomKey;
    }

    public final void i(int i3) {
        this.randomKey = i3;
    }

    public final void j(int i3) {
        this.sevrId = i3;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    @NotNull
    public String toString() {
        return "LottieFaceInfo(aniStickerType=" + this.aniStickerType + ", aniStickerPackId=" + this.aniStickerPackId + ", aniStickerId=" + this.aniStickerId + ", sevrId=" + this.sevrId + ", localId=" + this.localId + ", text=" + this.text + ", randomKey=" + this.randomKey + ")";
    }

    public LottieFaceInfo(int i3, @NotNull String aniStickerPackId, @NotNull String aniStickerId, int i16, int i17, @NotNull String text, int i18) {
        Intrinsics.checkNotNullParameter(aniStickerPackId, "aniStickerPackId");
        Intrinsics.checkNotNullParameter(aniStickerId, "aniStickerId");
        Intrinsics.checkNotNullParameter(text, "text");
        this.aniStickerType = i3;
        this.aniStickerPackId = aniStickerPackId;
        this.aniStickerId = aniStickerId;
        this.sevrId = i16;
        this.localId = i17;
        this.text = text;
        this.randomKey = i18;
    }

    public /* synthetic */ LottieFaceInfo(int i3, String str, String str2, int i16, int i17, String str3, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? "" : str, (i19 & 4) != 0 ? "" : str2, (i19 & 8) != 0 ? 0 : i16, (i19 & 16) != 0 ? 0 : i17, (i19 & 32) == 0 ? str3 : "", (i19 & 64) != 0 ? 0 : i18);
    }
}
