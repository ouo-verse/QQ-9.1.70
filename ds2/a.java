package ds2;

import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\nH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u0004H&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H&J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\rH&\u00a8\u0006\u0017"}, d2 = {"Lds2/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "detail", "", "a", "", "source", "f", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "remainApp", "g", "", "isEdit", "c", "b", "e", "fromPosition", "toPosition", h.F, "isChecked", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a {
    void a(@NotNull AppDetail detail);

    void b();

    void c(boolean isEdit);

    void d(boolean isChecked);

    void e(@NotNull AppDetail detail);

    void f(@NotNull AppDetail detail, int source);

    void g(@NotNull AppDetail detail, @NotNull ArrayList<AppDetail> remainApp);

    void h(int fromPosition, int toPosition);
}
