package jr1;

import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\f"}, d2 = {"Ljr1/a;", "", "Ljr1/a$a;", "state", "", "b", "c", "Ljr1/a$a;", "lastActiveState", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f410870a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static AbstractC10609a lastActiveState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\nB\u0019\b\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\u0082\u0001\u0002\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Ljr1/a$a;", "", "", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "b", "getSource", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljr1/a$a$a;", "Ljr1/a$a$b;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: jr1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static abstract class AbstractC10609a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String source;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Ljr1/a$a$a;", "Ljr1/a$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: jr1.a$a$a, reason: collision with other inner class name and from toString */
        /* loaded from: classes14.dex */
        public static final /* data */ class ConversationEmbeddedActive extends AbstractC10609a {

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String guildId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConversationEmbeddedActive(@NotNull String guildId) {
                super(guildId, "ConversationEmbedded", null);
                Intrinsics.checkNotNullParameter(guildId, "guildId");
                this.guildId = guildId;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public String getGuildId() {
                return this.guildId;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if ((other instanceof ConversationEmbeddedActive) && Intrinsics.areEqual(getGuildId(), ((ConversationEmbeddedActive) other).getGuildId())) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return getGuildId().hashCode();
            }

            @NotNull
            public String toString() {
                return "ConversationEmbeddedActive(guildId=" + getGuildId() + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Ljr1/a$a$b;", "Ljr1/a$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: jr1.a$a$b, reason: from toString */
        /* loaded from: classes14.dex */
        public static final /* data */ class GuildStandaloneActive extends AbstractC10609a {

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private String guildId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GuildStandaloneActive(@NotNull String guildId) {
                super(guildId, "GuildStandalone", null);
                Intrinsics.checkNotNullParameter(guildId, "guildId");
                this.guildId = guildId;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public String getGuildId() {
                return this.guildId;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if ((other instanceof GuildStandaloneActive) && Intrinsics.areEqual(getGuildId(), ((GuildStandaloneActive) other).getGuildId())) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return getGuildId().hashCode();
            }

            @NotNull
            public String toString() {
                return "GuildStandaloneActive(guildId=" + getGuildId() + ")";
            }
        }

        public /* synthetic */ AbstractC10609a(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        AbstractC10609a(String str, String str2) {
            this.guildId = str;
            this.source = str2;
        }
    }

    a() {
    }

    @JvmStatic
    public static final void b(@NotNull AbstractC10609a state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Logger.f235387a.d().i("Guild.MF.GlobalState", 1, "activate: " + lastActiveState + " -> " + state);
        lastActiveState = state;
    }

    @JvmStatic
    public static final void c(@NotNull AbstractC10609a state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!Intrinsics.areEqual(lastActiveState, state)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "deactivate state error: " + lastActiveState + " != " + state;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GlobalState", 1, (String) it.next(), null);
            }
            return;
        }
        Logger.f235387a.d().i("Guild.MF.GlobalState", 1, "deactivate: " + lastActiveState + " -> null");
        lastActiveState = null;
    }
}
