package com.tencent.mobileqq.guild.feed.api;

import com.tencent.mobileqq.guild.data.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/h;", "Lcom/tencent/mobileqq/guild/feed/api/f;", "", "mediumId", "Lcom/tencent/mobileqq/guild/data/o;", "info", "", "e", "", "uploadedSize", "totalSize", "c", "b", "d", tl.h.F, "f", "g", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface h extends f {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static void a(@NotNull h hVar, @NotNull String mediumId, @NotNull o info) {
            Intrinsics.checkNotNullParameter(mediumId, "mediumId");
            Intrinsics.checkNotNullParameter(info, "info");
        }

        public static void b(@NotNull h hVar, @NotNull String mediumId, @NotNull o info) {
            Intrinsics.checkNotNullParameter(mediumId, "mediumId");
            Intrinsics.checkNotNullParameter(info, "info");
        }

        public static void c(@NotNull h hVar, @NotNull String mediumId, long j3, long j16, @NotNull o info) {
            Intrinsics.checkNotNullParameter(mediumId, "mediumId");
            Intrinsics.checkNotNullParameter(info, "info");
        }

        public static void d(@NotNull h hVar, @NotNull String mediumId, @NotNull o info) {
            Intrinsics.checkNotNullParameter(mediumId, "mediumId");
            Intrinsics.checkNotNullParameter(info, "info");
        }

        public static void e(@NotNull h hVar, @NotNull String mediumId, @NotNull o info) {
            Intrinsics.checkNotNullParameter(mediumId, "mediumId");
            Intrinsics.checkNotNullParameter(info, "info");
        }

        public static void f(@NotNull h hVar, @NotNull String mediumId, @NotNull o info) {
            Intrinsics.checkNotNullParameter(mediumId, "mediumId");
            Intrinsics.checkNotNullParameter(info, "info");
        }

        public static void g(@NotNull h hVar, @NotNull o info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.f
    void a(@NotNull o info);

    void b(@NotNull String mediumId, @NotNull o info);

    void c(@NotNull String mediumId, long uploadedSize, long totalSize, @NotNull o info);

    void d(@NotNull String mediumId, @NotNull o info);

    void e(@NotNull String mediumId, @NotNull o info);

    void f(@NotNull String mediumId, @NotNull o info);

    void g(@NotNull String mediumId, @NotNull o info);

    void h(@NotNull String mediumId, @Nullable o info);
}
