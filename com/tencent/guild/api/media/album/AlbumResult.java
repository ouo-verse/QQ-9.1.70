package com.tencent.guild.api.media.album;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\r\u001a\u00020\n\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R7\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u000b\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u0010\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0017\u0010%\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/guild/api/media/album/a;", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "Landroidx/activity/result/ActivityResult;", "a", "Landroidx/activity/result/ActivityResult;", "result", "", "Lcom/tencent/guild/api/media/album/e;", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", "selectMedias", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "editMap", "Z", "()Z", CustomImageProps.QUALITY, "Landroid/content/Intent;", "e", "Landroid/content/Intent;", "intent", "f", "I", "getResultCode", "()I", QzoneIPCModule.RESULT_CODE, "<init>", "(Landroidx/activity/result/ActivityResult;Ljava/util/List;Ljava/util/HashMap;Z)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guild.api.media.album.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class AlbumResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ActivityResult result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<e> selectMedias;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final HashMap<String, String> editMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean quality;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Intent intent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int resultCode;

    /* JADX WARN: Multi-variable type inference failed */
    public AlbumResult(@NotNull ActivityResult result, @NotNull List<? extends e> selectMedias, @Nullable HashMap<String, String> hashMap, boolean z16) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(selectMedias, "selectMedias");
        this.result = result;
        this.selectMedias = selectMedias;
        this.editMap = hashMap;
        this.quality = z16;
        Intent data = result.getData();
        this.intent = data == null ? new Intent() : data;
        this.resultCode = result.getResultCode();
    }

    @Nullable
    public final HashMap<String, String> a() {
        return this.editMap;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getQuality() {
        return this.quality;
    }

    @NotNull
    public final List<e> c() {
        return this.selectMedias;
    }

    public final boolean d() {
        if (this.resultCode == -1 && this.result.getData() != null && (this.intent.hasExtra("ALBUM_RESULT") || this.intent.hasExtra(PeakConstants.GUILD_ALBUM_SELECT_PHOTOS))) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlbumResult)) {
            return false;
        }
        AlbumResult albumResult = (AlbumResult) other;
        if (Intrinsics.areEqual(this.result, albumResult.result) && Intrinsics.areEqual(this.selectMedias, albumResult.selectMedias) && Intrinsics.areEqual(this.editMap, albumResult.editMap) && this.quality == albumResult.quality) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.result.hashCode() * 31) + this.selectMedias.hashCode()) * 31;
        HashMap<String, String> hashMap = this.editMap;
        if (hashMap == null) {
            hashCode = 0;
        } else {
            hashCode = hashMap.hashCode();
        }
        int i3 = (hashCode2 + hashCode) * 31;
        boolean z16 = this.quality;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    @NotNull
    public String toString() {
        return "AlbumResult(result=" + this.result + ", selectMedias=" + this.selectMedias + ", editMap=" + this.editMap + ", quality=" + this.quality + ")";
    }
}
