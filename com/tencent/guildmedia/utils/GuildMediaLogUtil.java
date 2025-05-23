package com.tencent.guildmedia.utils;

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
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guildmedia/utils/GuildMediaLogUtil;", "Lcom/tencent/aio/base/log/f;", "", "tag", "msg", "", "d", "e", "i", "", "isColorLevel", "w", "<init>", "()V", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaLogUtil implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildMediaLogUtil> f113161b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guildmedia/utils/GuildMediaLogUtil$a;", "", "", "tag", "msg", "", "b", "c", "Lcom/tencent/guildmedia/utils/GuildMediaLogUtil;", "LOGGER$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/guildmedia/utils/GuildMediaLogUtil;", "LOGGER", "LOG_PRE_FIX", "Ljava/lang/String;", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guildmedia.utils.GuildMediaLogUtil$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GuildMediaLogUtil a() {
            return (GuildMediaLogUtil) GuildMediaLogUtil.f113161b.getValue();
        }

        public final void b(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            a().e(tag, msg2);
        }

        public final void c(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            a().i(tag, msg2);
        }

        Companion() {
        }
    }

    static {
        Lazy<GuildMediaLogUtil> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildMediaLogUtil>() { // from class: com.tencent.guildmedia.utils.GuildMediaLogUtil$Companion$LOGGER$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildMediaLogUtil invoke() {
                return new GuildMediaLogUtil();
            }
        });
        f113161b = lazy;
    }

    @Override // com.tencent.aio.base.log.f, com.tencent.mvi.log.b
    public void d(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d("G_MEDIA_" + tag, 4, msg2);
    }

    @Override // com.tencent.aio.base.log.f, com.tencent.mvi.log.b
    public void e(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.e("G_MEDIA_" + tag, 1, msg2);
    }

    @Override // com.tencent.aio.base.log.f, com.tencent.mvi.log.b
    public void i(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i("G_MEDIA_" + tag, 1, msg2);
    }

    @Override // com.tencent.mvi.log.b
    public boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    @Override // com.tencent.aio.base.log.f
    public void w(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.w("G_MEDIA_" + tag, 1, msg2);
    }
}
