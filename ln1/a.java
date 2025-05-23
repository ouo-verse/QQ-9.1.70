package ln1;

import com.tencent.mobileqq.guild.feed.publish.GuildSingleMainTask;
import com.tencent.mobileqq.guild.feed.topic.storage.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lln1/a;", "Lcom/tencent/mobileqq/guild/feed/publish/GuildSingleMainTask$a;", "", "newState", "", "b", "a", "Lcom/tencent/mobileqq/guild/feed/topic/storage/a;", "Lcom/tencent/mobileqq/guild/feed/topic/storage/a;", "persistenceApi", "", "topicId", "<init>", "(J)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends GuildSingleMainTask.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.topic.storage.a persistenceApi;

    public a(long j3) {
        this.persistenceApi = b.f223734a.a(j3);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.GuildSingleMainTask.a
    public void a() {
        com.tencent.mobileqq.guild.feed.topic.storage.a aVar = this.persistenceApi;
        String str = this.f222867a.get();
        Intrinsics.checkNotNullExpressionValue(str, "mainTaskIdSupplier.get()");
        aVar.remove(str);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.GuildSingleMainTask.a
    public void b(int newState) {
        if (newState == 6) {
            com.tencent.mobileqq.guild.feed.topic.storage.a aVar = this.persistenceApi;
            String str = this.f222867a.get();
            Intrinsics.checkNotNullExpressionValue(str, "mainTaskIdSupplier.get()");
            aVar.add(str);
        }
    }
}
