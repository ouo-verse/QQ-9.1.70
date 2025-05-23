package i61;

import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h;
import j61.IntimateBaseModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Li61/b;", "Li61/a;", "Lj61/a;", "model", "", "j0", "", "businessTag", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/h;", "itemDelegate", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/h;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull String businessTag, @NotNull h itemDelegate) {
        super(businessTag, itemDelegate);
        Intrinsics.checkNotNullParameter(businessTag, "businessTag");
        Intrinsics.checkNotNullParameter(itemDelegate, "itemDelegate");
    }

    public boolean j0(@NotNull IntimateBaseModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return getItemDelegate().b(model);
    }
}
