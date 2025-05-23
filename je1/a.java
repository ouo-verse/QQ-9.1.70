package je1;

import android.view.View;
import com.tencent.qqnt.chats.core.adapter.ChatsListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\n"}, d2 = {"Lje1/a;", "Lcom/tencent/qqnt/chats/core/adapter/ChatsListAdapter;", "Landroid/view/View;", "view", "", "i1", "Lcom/tencent/qqnt/chats/core/data/a;", "mBuilder", "<init>", "(Lcom/tencent/qqnt/chats/core/data/a;)V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class a extends ChatsListAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.qqnt.chats.core.data.a mBuilder) {
        super(mBuilder);
        Intrinsics.checkNotNullParameter(mBuilder, "mBuilder");
    }

    public abstract void i1(@Nullable View view);
}
