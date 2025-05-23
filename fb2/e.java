package fb2;

import com.tencent.mobileqq.nearbypro.map.marker.multitype.ItemDelegateNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016R$\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\n8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lfb2/e;", "Lfb2/d;", "T", "Lfb2/c;", "type", "", "b", "Ljava/lang/Class;", "clz", "a", "", "Ljava/util/List;", "getTypes", "()Ljava/util/List;", "types", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class e implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Type<?>> types = new ArrayList();

    @Override // fb2.d
    @NotNull
    public <T> Type<T> a(@NotNull Class<?> clz) {
        T t16;
        Intrinsics.checkNotNullParameter(clz, "clz");
        Iterator<T> it = this.types.iterator();
        while (true) {
            if (it.hasNext()) {
                t16 = it.next();
                if (Intrinsics.areEqual(((Type) t16).a(), clz)) {
                    break;
                }
            } else {
                t16 = (T) null;
                break;
            }
        }
        Type<T> type = t16;
        if (type != null) {
            return type;
        }
        throw new ItemDelegateNotFoundException(clz);
    }

    public <T> void b(@NotNull Type<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.types.add(type);
    }
}
