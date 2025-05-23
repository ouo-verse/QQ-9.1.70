package com.tencent.mobileqq.wink.ai.imagetext.model;

import androidx.annotation.Keep;
import androidx.fragment.app.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.utils.GsonUtils;
import w53.b;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001\"B/\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0002H\u00c6\u0003J;\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u000b\u0010\u0017R\u0017\u0010\f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/ai/imagetext/model/WinkAiImageTextConfig;", "", "", "component1", "component2", "", "component3", "", "component4", "component5", "concurrent", "isStream", "maxLongSide", "timeOutMs", "useImageCache", "copy", "", "toString", "hashCode", "other", "equals", "Z", "getConcurrent", "()Z", "I", "getMaxLongSide", "()I", "J", "getTimeOutMs", "()J", "getUseImageCache", "<init>", "(ZZIJZ)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class WinkAiImageTextConfig {

    @NotNull
    private static final String CANG_LAN_CONFIG_KEY = "qzone_shuoshuo_ai_auto_image_text";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final WinkAiImageTextConfig WINK_AI_IMAGE_TEXT_DEFAULT_CONFIG = new WinkAiImageTextConfig(true, false, 720, 60000, true);
    private final boolean concurrent;
    private final boolean isStream;
    private final int maxLongSide;
    private final long timeOutMs;
    private final boolean useImageCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002R\u0017\u0010\u0006\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/ai/imagetext/model/WinkAiImageTextConfig$a;", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/wink/ai/imagetext/model/WinkAiImageTextConfig;", "", "b", "WINK_AI_IMAGE_TEXT_DEFAULT_CONFIG", "Lcom/tencent/mobileqq/wink/ai/imagetext/model/WinkAiImageTextConfig;", "a", "()Lcom/tencent/mobileqq/wink/ai/imagetext/model/WinkAiImageTextConfig;", "", "CANG_LAN_CONFIG_KEY", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.ai.imagetext.model.WinkAiImageTextConfig$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkAiImageTextConfig a() {
            return WinkAiImageTextConfig.WINK_AI_IMAGE_TEXT_DEFAULT_CONFIG;
        }

        @NotNull
        public final Pair<WinkAiImageTextConfig, Boolean> b() {
            try {
                b.a("WinkAIImageTextAPIHelper", "requestConfig begin");
                String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(WinkAiImageTextConfig.CANG_LAN_CONFIG_KEY, "");
                b.a("WinkAIImageTextAPIHelper", "requestConfig jsonString:" + loadAsString);
                WinkAiImageTextConfig winkAiImageTextConfig = (WinkAiImageTextConfig) GsonUtils.json2Obj(loadAsString, WinkAiImageTextConfig.class);
                if (winkAiImageTextConfig != null) {
                    return new Pair<>(winkAiImageTextConfig, Boolean.TRUE);
                }
            } catch (Exception e16) {
                b.d("WinkAIImageTextAPIHelper", "requestConfig error", e16);
            }
            return new Pair<>(a(), Boolean.FALSE);
        }

        Companion() {
        }
    }

    public WinkAiImageTextConfig(boolean z16, boolean z17, int i3, long j3, boolean z18) {
        this.concurrent = z16;
        this.isStream = z17;
        this.maxLongSide = i3;
        this.timeOutMs = j3;
        this.useImageCache = z18;
    }

    public static /* synthetic */ WinkAiImageTextConfig copy$default(WinkAiImageTextConfig winkAiImageTextConfig, boolean z16, boolean z17, int i3, long j3, boolean z18, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = winkAiImageTextConfig.concurrent;
        }
        if ((i16 & 2) != 0) {
            z17 = winkAiImageTextConfig.isStream;
        }
        boolean z19 = z17;
        if ((i16 & 4) != 0) {
            i3 = winkAiImageTextConfig.maxLongSide;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            j3 = winkAiImageTextConfig.timeOutMs;
        }
        long j16 = j3;
        if ((i16 & 16) != 0) {
            z18 = winkAiImageTextConfig.useImageCache;
        }
        return winkAiImageTextConfig.copy(z16, z19, i17, j16, z18);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getConcurrent() {
        return this.concurrent;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsStream() {
        return this.isStream;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaxLongSide() {
        return this.maxLongSide;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTimeOutMs() {
        return this.timeOutMs;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getUseImageCache() {
        return this.useImageCache;
    }

    @NotNull
    public final WinkAiImageTextConfig copy(boolean concurrent, boolean isStream, int maxLongSide, long timeOutMs, boolean useImageCache) {
        return new WinkAiImageTextConfig(concurrent, isStream, maxLongSide, timeOutMs, useImageCache);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkAiImageTextConfig)) {
            return false;
        }
        WinkAiImageTextConfig winkAiImageTextConfig = (WinkAiImageTextConfig) other;
        if (this.concurrent == winkAiImageTextConfig.concurrent && this.isStream == winkAiImageTextConfig.isStream && this.maxLongSide == winkAiImageTextConfig.maxLongSide && this.timeOutMs == winkAiImageTextConfig.timeOutMs && this.useImageCache == winkAiImageTextConfig.useImageCache) {
            return true;
        }
        return false;
    }

    public final boolean getConcurrent() {
        return this.concurrent;
    }

    public final int getMaxLongSide() {
        return this.maxLongSide;
    }

    public final long getTimeOutMs() {
        return this.timeOutMs;
    }

    public final boolean getUseImageCache() {
        return this.useImageCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.concurrent;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isStream;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int a16 = (((((i16 + i17) * 31) + this.maxLongSide) * 31) + a.a(this.timeOutMs)) * 31;
        boolean z17 = this.useImageCache;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return a16 + i3;
    }

    public final boolean isStream() {
        return this.isStream;
    }

    @NotNull
    public String toString() {
        return "WinkAiImageTextConfig(concurrent=" + this.concurrent + ", isStream=" + this.isStream + ", maxLongSide=" + this.maxLongSide + ", timeOutMs=" + this.timeOutMs + ", useImageCache=" + this.useImageCache + ")";
    }
}
