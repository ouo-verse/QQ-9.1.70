package ke1;

import com.tencent.qqnt.chats.core.adapter.itemdata.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lke1/j;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "newItem", "", "c", "d", "", "id", "", "e", "()I", "itemViewType", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class j implements com.tencent.qqnt.chats.core.adapter.itemdata.b {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final j f412121c = new j();

    j() {
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    @NotNull
    public List<com.tencent.qqnt.chats.core.adapter.menu.a> a() {
        return b.C9570b.b(this);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    @Nullable
    public Object b(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b bVar) {
        return b.C9570b.a(this, bVar);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    public boolean c(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(newItem, this);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    public boolean d(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(newItem, this);
    }

    @Override // com.tencent.qqnt.base.adapter.b
    public int e() {
        return -5;
    }

    @Override // com.tencent.qqnt.chats.core.adapter.itemdata.b
    public long id() {
        return -9223372036854775806L;
    }
}
