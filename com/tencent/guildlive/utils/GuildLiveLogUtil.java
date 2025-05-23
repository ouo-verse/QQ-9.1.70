package com.tencent.guildlive.utils;

import com.tencent.aio.base.log.f;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guildlive/utils/GuildLiveLogUtil;", "Lcom/tencent/aio/base/log/f;", "", "tag", "msg", "", "c", "d", "e", "i", "", "isColorLevel", "w", "<init>", "()V", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveLogUtil implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildLiveLogUtil> f112967b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guildlive/utils/GuildLiveLogUtil$a;", "", "", "tag", "msg", "", "c", "d", "e", "b", "Lcom/tencent/guildlive/utils/GuildLiveLogUtil;", "LOGGER$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/guildlive/utils/GuildLiveLogUtil;", "LOGGER", "LOG_PRE_FIX", "Ljava/lang/String;", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guildlive.utils.GuildLiveLogUtil$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GuildLiveLogUtil a() {
            return (GuildLiveLogUtil) GuildLiveLogUtil.f112967b.getValue();
        }

        public final void b(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            a().c(tag, msg2);
        }

        public final void c(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            a().d(tag, msg2);
        }

        public final void d(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            a().e(tag, msg2);
        }

        public final void e(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            a().i(tag, msg2);
        }

        Companion() {
        }
    }

    static {
        Lazy<GuildLiveLogUtil> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildLiveLogUtil>() { // from class: com.tencent.guildlive.utils.GuildLiveLogUtil$Companion$LOGGER$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildLiveLogUtil invoke() {
                return new GuildLiveLogUtil();
            }
        });
        f112967b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String tag, String msg2) {
        QLog.i("G_LIVE_" + tag, 2, msg2);
    }

    @Override // com.tencent.aio.base.log.f, com.tencent.mvi.log.b
    public void d(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d("G_LIVE_" + tag, 4, msg2);
    }

    @Override // com.tencent.aio.base.log.f, com.tencent.mvi.log.b
    public void e(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.e("G_LIVE_" + tag, 1, msg2);
    }

    @Override // com.tencent.aio.base.log.f, com.tencent.mvi.log.b
    public void i(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i("G_LIVE_" + tag, 1, msg2);
    }

    @Override // com.tencent.mvi.log.b
    public boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    @Override // com.tencent.aio.base.log.f
    public void w(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.w("G_LIVE_" + tag, 1, msg2);
    }
}
