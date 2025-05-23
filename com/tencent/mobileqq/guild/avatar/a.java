package com.tencent.mobileqq.guild.avatar;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tJ\u0006\u0010\f\u001a\u00020\u0005R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/avatar/a;", "", "", "guildId", "tinyId", "", "f", "", "e", "", "tinyIdList", "g", "c", "", "a", "I", "getWidth", "()I", "width", "b", "getHeight", "height", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "preLoadAvatarTinyIdMap", "Lcom/tencent/mobileqq/guild/avatar/e;", "d", "Lcom/tencent/mobileqq/guild/avatar/e;", "avatarUrlListener", "<init>", "(II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Boolean> preLoadAvatarTinyIdMap = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e avatarUrlListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/avatar/a$a;", "", "", "", "tinyIdList", "", "a", "AVATAR_PRELOAD_COUNT_FOR_FIRST_SCREEN", "I", "AVATAR_PRELOAD_COUNT_FOR_SCROLL", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.avatar.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int a(@NotNull List<String> tinyIdList) {
            int coerceAtMost;
            Intrinsics.checkNotNullParameter(tinyIdList, "tinyIdList");
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(tinyIdList.size(), 12);
            return coerceAtMost;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/avatar/a$b", "Lcom/tencent/mobileqq/guild/avatar/e;", "", "guildId", "tinyId", "", "doOnUrlChange", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements e {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.avatar.e
        public void doOnUrlChange(@NotNull String guildId, @NotNull String tinyId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            if (a.this.e(tinyId)) {
                a.this.f(guildId, tinyId);
            }
        }
    }

    public a(int i3, int i16) {
        this.width = i3;
        this.height = i16;
        b bVar = new b();
        this.avatarUrlListener = bVar;
        GuildUserAvatarRepository.f(bVar);
    }

    @JvmStatic
    public static final int d(@NotNull List<String> list) {
        return INSTANCE.a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(String tinyId) {
        if (this.preLoadAvatarTinyIdMap.containsKey(tinyId)) {
            Boolean bool = this.preLoadAvatarTinyIdMap.get(tinyId);
            Intrinsics.checkNotNull(bool);
            if (!bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String guildId, String tinyId) {
        String fullGuildUserUserAvatarUrl = ((IGPSService) ch.R0(IGPSService.class)).getFullGuildUserUserAvatarUrl(guildId, tinyId, 3);
        if (!TextUtils.isEmpty(fullGuildUserUserAvatarUrl)) {
            u.t(fullGuildUserUserAvatarUrl, this.width, this.height);
            this.preLoadAvatarTinyIdMap.put(tinyId, Boolean.TRUE);
        }
    }

    public final void c() {
        GuildUserAvatarRepository.k(this.avatarUrlListener);
    }

    public final void g(@NotNull String guildId, @NotNull List<String> tinyIdList) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyIdList, "tinyIdList");
        for (String str : tinyIdList) {
            if (!this.preLoadAvatarTinyIdMap.containsKey(str)) {
                this.preLoadAvatarTinyIdMap.put(str, Boolean.FALSE);
                f(guildId, str);
            }
        }
    }
}
