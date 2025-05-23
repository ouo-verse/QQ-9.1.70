package gn1;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aD\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00020\u0006\u00a8\u0006\n"}, d2 = {"T", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/Observer;", "observer", "", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00020\u0001J\u001e\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"gn1/b$a", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "t", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a<T> implements Observer<UIStateData<List<? extends T>>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Observer<UIStateData<List<T>>> f402436d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LiveData<UIStateData<List<T>>> f402437e;

        a(Observer<UIStateData<List<T>>> observer, LiveData<UIStateData<List<T>>> liveData) {
            this.f402436d = observer;
            this.f402437e = liveData;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable UIStateData<List<T>> t16) {
            boolean z16 = false;
            if (t16 != null && t16.isCacheData()) {
                z16 = true;
            }
            if (z16) {
                this.f402436d.onChanged(t16);
                this.f402437e.removeObserver(this);
            }
        }
    }

    public static final <T> void a(@NotNull LiveData<UIStateData<List<T>>> liveData, @NotNull LifecycleOwner lifecycleOwner, @NotNull Observer<UIStateData<List<T>>> observer) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        liveData.observe(lifecycleOwner, new a(observer, liveData));
    }
}
