package com.tencent.state.square.data;

import android.net.Uri;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import java.io.File;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0006\u0010\u0010\u001a\u00020\u0003J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\u0006\u0010\u0017\u001a\u00020\u0006J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/data/FilamentAvatarCoverUri;", "", QAdRewardDefine$VideoParams.CACHE_PATH, "", "remoteUrl", "isRemoteCorrect", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getCachePath", "()Ljava/lang/String;", "()Z", "getRemoteUrl", "component1", "component2", "component3", "copy", "encode", "equals", "other", "getLocalCacheFile", "Ljava/io/File;", "hashCode", "", "isLocalCacheExists", "toString", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class FilamentAvatarCoverUri {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String SCHEME_PREFIX = "fcover:///";

    @NotNull
    private final String cachePath;
    private final boolean isRemoteCorrect;

    @NotNull
    private final String remoteUrl;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/square/data/FilamentAvatarCoverUri$Companion;", "", "()V", "SCHEME_PREFIX", "", "decode", "Lcom/tencent/state/square/data/FilamentAvatarCoverUri;", "url", "square_base_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final FilamentAvatarCoverUri decode(@Nullable String url) {
            boolean startsWith$default;
            if (url != null) {
                boolean z16 = false;
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, FilamentAvatarCoverUri.SCHEME_PREFIX, false, 2, null);
                if (!startsWith$default) {
                    return null;
                }
                try {
                    Uri parse = Uri.parse(url);
                    String queryParameter = parse.getQueryParameter(QAdRewardDefine$VideoParams.CACHE_PATH);
                    String str = "";
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(\"cachePath\") ?: \"\"");
                    String queryParameter2 = parse.getQueryParameter("remoteUrl");
                    if (queryParameter2 != null) {
                        str = queryParameter2;
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "uri.getQueryParameter(\"remoteUrl\") ?: \"\"");
                    String queryParameter3 = parse.getQueryParameter("isRemoteCorrect");
                    if (queryParameter3 != null) {
                        z16 = Boolean.parseBoolean(queryParameter3);
                    }
                    return new FilamentAvatarCoverUri(queryParameter, str, z16);
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FilamentAvatarCoverUri(@NotNull String cachePath, @NotNull String remoteUrl, boolean z16) {
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        this.cachePath = cachePath;
        this.remoteUrl = remoteUrl;
        this.isRemoteCorrect = z16;
    }

    public static /* synthetic */ FilamentAvatarCoverUri copy$default(FilamentAvatarCoverUri filamentAvatarCoverUri, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = filamentAvatarCoverUri.cachePath;
        }
        if ((i3 & 2) != 0) {
            str2 = filamentAvatarCoverUri.remoteUrl;
        }
        if ((i3 & 4) != 0) {
            z16 = filamentAvatarCoverUri.isRemoteCorrect;
        }
        return filamentAvatarCoverUri.copy(str, str2, z16);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getCachePath() {
        return this.cachePath;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getRemoteUrl() {
        return this.remoteUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsRemoteCorrect() {
        return this.isRemoteCorrect;
    }

    @NotNull
    public final FilamentAvatarCoverUri copy(@NotNull String cachePath, @NotNull String remoteUrl, boolean isRemoteCorrect) {
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        return new FilamentAvatarCoverUri(cachePath, remoteUrl, isRemoteCorrect);
    }

    @NotNull
    public final String encode() {
        return "fcover:///?cachePath=" + URLEncoder.encode(this.cachePath, "UTF-8") + "&remoteUrl=" + URLEncoder.encode(this.remoteUrl, "UTF-8") + "&isRemoteCorrect=" + this.isRemoteCorrect;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FilamentAvatarCoverUri) {
                FilamentAvatarCoverUri filamentAvatarCoverUri = (FilamentAvatarCoverUri) other;
                if (!Intrinsics.areEqual(this.cachePath, filamentAvatarCoverUri.cachePath) || !Intrinsics.areEqual(this.remoteUrl, filamentAvatarCoverUri.remoteUrl) || this.isRemoteCorrect != filamentAvatarCoverUri.isRemoteCorrect) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getCachePath() {
        return this.cachePath;
    }

    @NotNull
    public final File getLocalCacheFile() {
        return new File(this.cachePath);
    }

    @NotNull
    public final String getRemoteUrl() {
        return this.remoteUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        String str = this.cachePath;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.remoteUrl;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        int i18 = (i17 + i16) * 31;
        boolean z16 = this.isRemoteCorrect;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        return i18 + i19;
    }

    public final boolean isLocalCacheExists() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.cachePath);
        if ((!isBlank) && getLocalCacheFile().exists()) {
            return true;
        }
        return false;
    }

    public final boolean isRemoteCorrect() {
        return this.isRemoteCorrect;
    }

    @NotNull
    public String toString() {
        return "FilamentAvatarCoverUri(cachePath=" + this.cachePath + ", remoteUrl=" + this.remoteUrl + ", isRemoteCorrect=" + this.isRemoteCorrect + ")";
    }
}
