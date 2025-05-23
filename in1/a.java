package in1;

import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lin1/a;", "", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildMediaProgressState;", "state", "", "b", "", "", "mediaIds", "delete", "", "a", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a {
    @Nullable
    Object a(@NotNull Set<String> set, @NotNull Continuation<? super List<? extends GuildMediaProgressState>> continuation);

    void b(@NotNull GuildMediaProgressState state);

    void delete(@NotNull List<String> mediaIds);
}
