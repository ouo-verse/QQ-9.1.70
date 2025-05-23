package i93;

import android.content.Intent;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.publish.part.PublishAtFriendPart;
import com.tencent.mobileqq.wink.publish.part.j;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"Li93/b;", "Lj93/b;", "Landroid/content/Intent;", "intent", "", "d", "", "Lcom/tencent/mobileqq/wink/publish/part/j;", "b", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends j93.b {
    @Override // j93.b
    @Nullable
    protected List<j> b(@NotNull Intent intent) {
        List<j> listOf;
        Intrinsics.checkNotNullParameter(intent, "intent");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new PublishAtFriendPart());
        return listOf;
    }

    @Override // j93.b
    public boolean d(@NotNull Intent intent) {
        String str;
        Intrinsics.checkNotNullParameter(intent, "intent");
        HashMap<String, String> r16 = WinkContext.INSTANCE.d().r();
        if (r16 != null) {
            str = r16.get(QQWinkConstants.KEY_IS_FROM_FRIEND_FIRST_PUBLISH);
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "1");
    }
}
