package e81;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.qqnt.aio.msg.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "a", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    public static final boolean a(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (d.h(aIOMsgItem.getMsgRecord()) == 3) {
            return true;
        }
        if (d.h(aIOMsgItem.getMsgRecord()) == 1 && !aIOMsgItem.I()) {
            return true;
        }
        return false;
    }
}
