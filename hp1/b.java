package hp1;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BF\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\t\u0010\u0007R2\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0004\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lhp1/b;", "", "Lkotlin/Function0;", "", "a", "Lkotlin/jvm/functions/Function0;", "c", "()Lkotlin/jvm/functions/Function0;", "updateNavigatorExpand", "b", "openChannelList", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "channelId", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "openChannel", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> updateNavigatorExpand;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> openChannelList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<String, Unit> openChannel;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Function0<Unit> updateNavigatorExpand, @NotNull Function0<Unit> openChannelList, @NotNull Function1<? super String, Unit> openChannel) {
        Intrinsics.checkNotNullParameter(updateNavigatorExpand, "updateNavigatorExpand");
        Intrinsics.checkNotNullParameter(openChannelList, "openChannelList");
        Intrinsics.checkNotNullParameter(openChannel, "openChannel");
        this.updateNavigatorExpand = updateNavigatorExpand;
        this.openChannelList = openChannelList;
        this.openChannel = openChannel;
    }

    @NotNull
    public final Function1<String, Unit> a() {
        return this.openChannel;
    }

    @NotNull
    public final Function0<Unit> b() {
        return this.openChannelList;
    }

    @NotNull
    public final Function0<Unit> c() {
        return this.updateNavigatorExpand;
    }
}
