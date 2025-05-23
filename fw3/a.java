package fw3;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.viewbinding.ViewBinding;
import com.tencent.qqnt.chats.core.utils.b;
import com.tencent.qqnt.chats.utils.preload.LayoutPreLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw3.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"Lfw3/a;", "Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$c;", "Landroidx/viewbinding/ViewBinding;", "Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$b;", "param", "Lpw3/e;", "c", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements LayoutPreLoader.c<ViewBinding> {
    @Override // com.tencent.qqnt.chats.utils.preload.LayoutPreLoader.c
    public boolean b() {
        return LayoutPreLoader.c.a.a(this);
    }

    @Override // com.tencent.qqnt.chats.utils.preload.LayoutPreLoader.c
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e a(@NotNull LayoutPreLoader.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        Context context = param.a().get();
        if (context == null) {
            return null;
        }
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        b bVar = b.f355092a;
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
        return bVar.b(layoutInflater);
    }
}
