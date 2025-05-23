package eg1;

import android.view.View;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001Bp\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002\u0012!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u000e0\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R2\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR2\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\f\u0010\nR2\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u000e0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000f\u0010\n\u00a8\u0006\u0013"}, d2 = {"Leg1/a;", "", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "a", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "createChannel", "b", NodeProps.ON_CLICK, "", "c", NodeProps.ON_LONG_CLICK, "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, Unit> createChannel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, Unit> onClick;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, Boolean> onLongClick;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function1<? super View, Unit> createChannel, @NotNull Function1<? super View, Unit> onClick, @NotNull Function1<? super View, Boolean> onLongClick) {
        Intrinsics.checkNotNullParameter(createChannel, "createChannel");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onLongClick, "onLongClick");
        this.createChannel = createChannel;
        this.onClick = onClick;
        this.onLongClick = onLongClick;
    }

    @NotNull
    public final Function1<View, Unit> a() {
        return this.createChannel;
    }

    @NotNull
    public final Function1<View, Unit> b() {
        return this.onClick;
    }

    @NotNull
    public final Function1<View, Boolean> c() {
        return this.onLongClick;
    }
}
