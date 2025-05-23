package com.tencent.guild.aio.factory;

import android.content.Context;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\t\u001eB\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0013\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J&\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000b2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/guild/aio/factory/b;", "Lcom/tencent/aio/main/businesshelper/c;", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "g", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "a", "k", "", "i", "channelId", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Observer;", "o", "f", h.F, "", "type", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "data", "l", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "observers", "Lcom/tencent/guild/aio/factory/GuildFirstScreenTask;", "b", "Lcom/tencent/guild/aio/factory/GuildFirstScreenTask;", "firstScreenTask", "<init>", "()V", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b implements com.tencent.aio.main.businesshelper.c {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static GuildFirstScreenTask f110383d;

    /* renamed from: e, reason: collision with root package name */
    private static long f110384e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArraySet<Observer> observers = new CopyOnWriteArraySet<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFirstScreenTask firstScreenTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0005R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/guild/aio/factory/b$a;", "", "", "channelId", "guildId", "", "c", "Lcom/tencent/guild/aio/factory/b;", "firstScreenHelper", "Lcom/tencent/guild/aio/factory/GuildFirstScreenTask;", "a", "Landroid/content/Context;", "context", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "b", "d", "", "NOTIFY_TYPE_FIRST_SCREEN", "I", "NOTIFY_TYPE_LOCAL_MSG", "TAG", "Ljava/lang/String;", "TIME_VALID_PERIOD_MS", "mGuildFirstScreenTask", "Lcom/tencent/guild/aio/factory/GuildFirstScreenTask;", "", "mTimeStamp", "J", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.factory.b$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildFirstScreenTask a(@NotNull String channelId, @NotNull b firstScreenHelper) {
            boolean z16;
            String str;
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(firstScreenHelper, "firstScreenHelper");
            if (System.currentTimeMillis() - b.f110384e < 1000) {
                z16 = true;
            } else {
                z16 = false;
            }
            GuildFirstScreenTask guildFirstScreenTask = b.f110383d;
            if (z16) {
                if (guildFirstScreenTask != null) {
                    str = guildFirstScreenTask.getChannelId();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, channelId)) {
                    guildFirstScreenTask.s(firstScreenHelper);
                    b.f110383d = null;
                    return guildFirstScreenTask;
                }
            }
            QLog.i("GuildFirstScreenHelper", 1, "getFirstScreenTask, no preload GuildFirstScreenTask, create a new one.");
            return new GuildFirstScreenTask(firstScreenHelper);
        }

        public final void b(@NotNull Context context, @NotNull AIOParam aioParam) {
            GuildFirstScreenTask guildFirstScreenTask;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(aioParam, "aioParam");
            try {
                Integer d16 = com.tencent.guild.aio.util.a.d(aioParam);
                if (d16 != null && d16.intValue() == 1 && (guildFirstScreenTask = b.f110383d) != null) {
                    guildFirstScreenTask.n(context, aioParam);
                }
            } catch (Exception e16) {
                QLog.i("GuildFirstScreenHelper", 1, "onContextReady, exception: " + e16.getMessage());
            }
        }

        public final void c(@NotNull String channelId, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            int i3 = 1;
            QLog.i("GuildFirstScreenHelper", 1, "preloadFirstScreenMsg, channelId: " + channelId + ", guildId: " + guildId);
            try {
                AIOParam c16 = new AIOParam.a().h(new AIOSession(new AIOContact(4, channelId, guildId, null, 8, null))).c();
                b.f110383d = new GuildFirstScreenTask(null, i3, 0 == true ? 1 : 0);
                GuildFirstScreenTask guildFirstScreenTask = b.f110383d;
                if (guildFirstScreenTask != null) {
                    guildFirstScreenTask.o(c16);
                }
                b.f110384e = System.currentTimeMillis();
            } catch (Exception e16) {
                QLog.i("GuildFirstScreenHelper", 1, "preloadFirstScreenMsg, exception: " + e16.getMessage());
                d();
            }
        }

        public final void d() {
            QLog.i("GuildFirstScreenHelper", 1, "reset");
            b.f110384e = 0L;
            b.f110383d = null;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000b\"\u0004\b\f\u0010\rR\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/factory/b$b;", "", "", "a", "I", "c", "()I", "type", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "channelId", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "Lcom/tencent/aio/msgservice/h;", "()Lcom/tencent/aio/msgservice/h;", "data", "<init>", "(ILjava/lang/String;Lcom/tencent/aio/msgservice/h;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.factory.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1185b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String channelId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> data;

        public C1185b(int i3, @NotNull String channelId, @Nullable com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.type = i3;
            this.channelId = channelId;
            this.data = hVar;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @Nullable
        public final com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> b() {
            return this.data;
        }

        /* renamed from: c, reason: from getter */
        public final int getType() {
            return this.type;
        }
    }

    private final boolean g(AIOParam aioParam) {
        if (Intrinsics.areEqual(aioParam.n(), a.class.getName())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aio.main.businesshelper.c
    public void a(@NotNull AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        QLog.i("GuildFirstScreenHelper", 1, "startAIO mFactoryName: " + aioParam.n() + "  channelId: " + aioParam.r().c().j());
        GuildFirstScreenTask guildFirstScreenTask = this.firstScreenTask;
        if (guildFirstScreenTask != null) {
            guildFirstScreenTask.q();
        }
        if (g(aioParam)) {
            GuildFirstScreenTask a16 = INSTANCE.a(aioParam.r().c().j(), this);
            this.firstScreenTask = a16;
            if (a16 != null) {
                a16.o(aioParam);
            }
        }
    }

    public final void f(@Nullable Observer o16) {
        this.observers.add(o16);
    }

    public final void h(@Nullable Observer o16) {
        this.observers.remove(o16);
    }

    @NotNull
    public final String i() {
        String channelId;
        GuildFirstScreenTask guildFirstScreenTask = this.firstScreenTask;
        if (guildFirstScreenTask == null || (channelId = guildFirstScreenTask.getChannelId()) == null) {
            return "";
        }
        return channelId;
    }

    public final boolean j(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        GuildFirstScreenTask guildFirstScreenTask = this.firstScreenTask;
        if (guildFirstScreenTask != null) {
            return guildFirstScreenTask.l(channelId);
        }
        return false;
    }

    public final void k() {
        GuildFirstScreenTask guildFirstScreenTask = this.firstScreenTask;
        if (guildFirstScreenTask != null) {
            guildFirstScreenTask.m();
        }
    }

    public final void l(int type, @NotNull String channelId, @Nullable com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> data) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Object[] array = this.observers.toArray(new Observer[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        for (Observer observer : (Observer[]) array) {
            observer.update(null, new C1185b(type, channelId, data));
        }
    }

    public final void m() {
        GuildFirstScreenTask guildFirstScreenTask = this.firstScreenTask;
        if (guildFirstScreenTask != null) {
            guildFirstScreenTask.t();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.c
    public void onDestroy() {
        GuildFirstScreenTask guildFirstScreenTask = this.firstScreenTask;
        if (guildFirstScreenTask != null) {
            guildFirstScreenTask.q();
        }
        INSTANCE.d();
    }

    @Override // com.tencent.aio.main.businesshelper.c
    public void onCreate() {
    }
}
