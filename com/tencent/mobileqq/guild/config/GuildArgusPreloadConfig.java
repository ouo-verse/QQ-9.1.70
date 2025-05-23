package com.tencent.mobileqq.guild.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\fB/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0014\u0010\u000fR\"\u0010\u0018\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/config/e;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "e", "(Z)V", "cacheMoreTab", "c", "g", "isDelegateLayoutInflaterEnabled", "f", "b", "isCloneInflaterInSubThreadEnabled", tl.h.F, "isDelegateResourceEnabled", "<init>", "(ZZZZ)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.config.e, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildArgusPreloadConfig implements IConfigData {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean cacheMoreTab;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isDelegateLayoutInflaterEnabled;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isCloneInflaterInSubThreadEnabled;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isDelegateResourceEnabled;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/config/e$a;", "", "", "content", "Lcom/tencent/mobileqq/guild/config/e;", "a", "sCacheMoreTab", "Ljava/lang/String;", "sIsCloneInflaterInSubThreadEnabled", "sIsDelegateLayoutInflaterEnabled", "sIsDelegateResourceEnabled", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.e$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildArgusPreloadConfig a(@Nullable String content) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().c("GuildArgusPreloadConfigParser", 2, "parse content:" + content);
            }
            GuildArgusPreloadConfig guildArgusPreloadConfig = new GuildArgusPreloadConfig(false, false, false, false, 15, null);
            if (MiscKt.f(content)) {
                return guildArgusPreloadConfig;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                if (jSONObject.has("cacheMoreTab")) {
                    guildArgusPreloadConfig.e(Intrinsics.areEqual(jSONObject.optString("cacheMoreTab"), "1"));
                }
                if (jSONObject.has("isDelegateLayoutInflaterEnabled")) {
                    guildArgusPreloadConfig.g(Intrinsics.areEqual(jSONObject.optString("isDelegateLayoutInflaterEnabled"), "1"));
                }
                if (jSONObject.has("isCloneInflaterInSubThreadEnabled")) {
                    guildArgusPreloadConfig.f(Intrinsics.areEqual(jSONObject.optString("isCloneInflaterInSubThreadEnabled"), "1"));
                }
                if (jSONObject.has("isDelegateResourceEnabled")) {
                    guildArgusPreloadConfig.h(Intrinsics.areEqual(jSONObject.optString("isDelegateResourceEnabled"), "1"));
                }
            } catch (JSONException e16) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "error parse content:" + content;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildArgusPreloadConfigParser", 1, (String) it.next(), e16);
                }
            }
            return guildArgusPreloadConfig;
        }

        Companion() {
        }
    }

    public GuildArgusPreloadConfig() {
        this(false, false, false, false, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCacheMoreTab() {
        return this.cacheMoreTab;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsCloneInflaterInSubThreadEnabled() {
        return this.isCloneInflaterInSubThreadEnabled;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsDelegateLayoutInflaterEnabled() {
        return this.isDelegateLayoutInflaterEnabled;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsDelegateResourceEnabled() {
        return this.isDelegateResourceEnabled;
    }

    public final void e(boolean z16) {
        this.cacheMoreTab = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildArgusPreloadConfig)) {
            return false;
        }
        GuildArgusPreloadConfig guildArgusPreloadConfig = (GuildArgusPreloadConfig) other;
        if (this.cacheMoreTab == guildArgusPreloadConfig.cacheMoreTab && this.isDelegateLayoutInflaterEnabled == guildArgusPreloadConfig.isDelegateLayoutInflaterEnabled && this.isCloneInflaterInSubThreadEnabled == guildArgusPreloadConfig.isCloneInflaterInSubThreadEnabled && this.isDelegateResourceEnabled == guildArgusPreloadConfig.isDelegateResourceEnabled) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.isCloneInflaterInSubThreadEnabled = z16;
    }

    public final void g(boolean z16) {
        this.isDelegateLayoutInflaterEnabled = z16;
    }

    public final void h(boolean z16) {
        this.isDelegateResourceEnabled = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.cacheMoreTab;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isDelegateLayoutInflaterEnabled;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        ?? r27 = this.isCloneInflaterInSubThreadEnabled;
        int i19 = r27;
        if (r27 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        boolean z17 = this.isDelegateResourceEnabled;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i26 + i3;
    }

    @NotNull
    public String toString() {
        return "GuildArgusPreloadConfig(cacheMoreTab=" + this.cacheMoreTab + ", isDelegateLayoutInflaterEnabled=" + this.isDelegateLayoutInflaterEnabled + ", isCloneInflaterInSubThreadEnabled=" + this.isCloneInflaterInSubThreadEnabled + ", isDelegateResourceEnabled=" + this.isDelegateResourceEnabled + ")";
    }

    public GuildArgusPreloadConfig(boolean z16, boolean z17, boolean z18, boolean z19) {
        this.cacheMoreTab = z16;
        this.isDelegateLayoutInflaterEnabled = z17;
        this.isCloneInflaterInSubThreadEnabled = z18;
        this.isDelegateResourceEnabled = z19;
    }

    public /* synthetic */ GuildArgusPreloadConfig(boolean z16, boolean z17, boolean z18, boolean z19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18, (i3 & 8) != 0 ? false : z19);
    }
}
