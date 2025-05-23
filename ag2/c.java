package ag2;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import zf2.PromotionPanelItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lag2/c;", "", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LiveData;", "", "Lzf2/d;", "a", "()Landroidx/lifecycle/LiveData;", "promotionItems", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public interface c {
    LiveData<List<PromotionPanelItem>> a();

    Object b(Continuation<? super Unit> continuation);
}
