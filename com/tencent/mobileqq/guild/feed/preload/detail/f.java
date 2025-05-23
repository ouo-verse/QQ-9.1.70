package com.tencent.mobileqq.guild.feed.preload.detail;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailCacheResponse;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.guild.feed.preload.detail.data.ResponseCode;
import com.tencent.mobileqq.guild.feed.preload.detail.f;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0004\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/d;", "secondTask", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/preload/detail/f$a", "Lcom/tencent/mobileqq/guild/feed/preload/detail/d;", "", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailPreloadParams;", "params", "Lcom/tencent/mobileqq/guild/feed/preload/detail/g;", "callback", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f222792a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f222793b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/preload/detail/f$a$a", "Lcom/tencent/mobileqq/guild/feed/preload/detail/g;", "", "isSuccess", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailCacheResponse;", "resp", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.preload.detail.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7773a implements g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f222794a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f222795b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ List<GuildFeedDetailPreloadParams> f222796c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ d f222797d;

            C7773a(g gVar, d dVar, List<GuildFeedDetailPreloadParams> list, d dVar2) {
                this.f222794a = gVar;
                this.f222795b = dVar;
                this.f222796c = list;
                this.f222797d = dVar2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void c(d secondTask, List params, g gVar, d firstTask, GuildFeedDetailCacheResponse resp) {
                Intrinsics.checkNotNullParameter(secondTask, "$secondTask");
                Intrinsics.checkNotNullParameter(params, "$params");
                Intrinsics.checkNotNullParameter(firstTask, "$firstTask");
                Intrinsics.checkNotNullParameter(resp, "$resp");
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                ResponseCode error = resp.getError();
                Objects.toString(firstTask);
                Objects.toString(error);
                bVar.b("now go to second task(" + secondTask + ")");
                Unit unit = Unit.INSTANCE;
                if (unit instanceof String) {
                    bVar.a().add(unit);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("IFeedDetailRequestTask", 1, (String) it.next(), null);
                }
                secondTask.a(params, gVar);
            }

            @Override // com.tencent.mobileqq.guild.feed.preload.detail.g
            public void a(boolean isSuccess, @NotNull final GuildFeedDetailCacheResponse resp) {
                Intrinsics.checkNotNullParameter(resp, "resp");
                if (!isSuccess) {
                    final d dVar = this.f222795b;
                    final List<GuildFeedDetailPreloadParams> list = this.f222796c;
                    final g gVar = this.f222794a;
                    final d dVar2 = this.f222797d;
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.preload.detail.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.a.C7773a.c(d.this, list, gVar, dVar2, resp);
                        }
                    }, 192, null, false);
                    return;
                }
                g gVar2 = this.f222794a;
                if (gVar2 != null) {
                    gVar2.a(isSuccess, resp);
                }
            }
        }

        a(d dVar, d dVar2) {
            this.f222792a = dVar;
            this.f222793b = dVar2;
        }

        @Override // com.tencent.mobileqq.guild.feed.preload.detail.d
        public void a(@NotNull List<GuildFeedDetailPreloadParams> params, @Nullable g callback) {
            Intrinsics.checkNotNullParameter(params, "params");
            d dVar = this.f222792a;
            dVar.a(params, new C7773a(callback, this.f222793b, params, dVar));
        }
    }

    @NotNull
    public static final d a(@NotNull d dVar, @NotNull d secondTask) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(secondTask, "secondTask");
        return new a(dVar, secondTask);
    }
}
