package af1;

import android.os.Bundle;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0003B\u001f\b\u0012\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Laf1/a;", "", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "a", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "b", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "Z", "getJumpToDiscovery", "()Z", "jumpToDiscovery", "<init>", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;Z)V", "c", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam jumpGuildParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean jumpToDiscovery;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007R\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Laf1/a$a;", "", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "Laf1/a;", "a", "", "targetGuildId", "targetChannelId", "Landroid/os/Bundle;", "bundle", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: af1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final a a(@NotNull JumpGuildParam jumpGuildParam) {
            Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
            return new a(jumpGuildParam, false, 2, null);
        }

        @JvmStatic
        @NotNull
        public final a b(@NotNull String targetGuildId, @NotNull String targetChannelId, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(targetGuildId, "targetGuildId");
            Intrinsics.checkNotNullParameter(targetChannelId, "targetChannelId");
            JumpGuildParam jumpGuildParam = new JumpGuildParam(targetGuildId, targetChannelId);
            if (bundle != null) {
                jumpGuildParam.extras.putAll(bundle);
            }
            return new a(jumpGuildParam, false, 2, null);
        }

        Companion() {
        }
    }

    /* synthetic */ a(JumpGuildParam jumpGuildParam, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : jumpGuildParam, (i3 & 2) != 0 ? false : z16);
    }

    @JvmStatic
    @NotNull
    public static final a a(@NotNull JumpGuildParam jumpGuildParam) {
        return INSTANCE.a(jumpGuildParam);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final JumpGuildParam getJumpGuildParam() {
        return this.jumpGuildParam;
    }

    a(JumpGuildParam jumpGuildParam, boolean z16) {
        this.jumpGuildParam = jumpGuildParam == null ? new JumpGuildParam("", "") : jumpGuildParam;
        this.jumpToDiscovery = z16;
    }
}
