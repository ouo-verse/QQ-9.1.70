package pg1;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.guild.component.banner.viewpager2.ProxySmoothScrollerLayoutManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lpg1/o;", "Lpg1/d;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "a", "b", "", "d", "J", "duration", "Landroid/view/View$OnLayoutChangeListener;", "e", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChangeListener", "<init>", "(J)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class o extends d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long duration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnLayoutChangeListener onLayoutChangeListener;

    public o(long j3) {
        this.duration = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ViewPager2 viewPager2, o this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(viewPager2, "$viewPager2");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((viewPager2.getOrientation() == 1 && i18 - i16 != i28 - i26) || (viewPager2.getOrientation() == 0 && i17 - i3 != i27 - i19)) {
            C11734b c11734b = C11734b.f433780a;
            QLog.i("Guild.component.SpeedBannerStyle", 1, "setSpeed in OnLayoutChangeListener, currentItem: " + viewPager2.getCurrentItem() + ", " + viewPager2.hashCode(), null);
            this$0.f(viewPager2);
        }
    }

    private final void f(final ViewPager2 viewPager2) {
        C11734b c11734b = C11734b.f433780a;
        QLog.i("Guild.component.SpeedBannerStyle", 1, "setSpeed(" + this.duration + "), currentItem: " + viewPager2.getCurrentItem() + ", " + viewPager2.hashCode(), null);
        final int currentItem = viewPager2.getCurrentItem();
        com.tencent.mobileqq.guild.component.banner.viewpager2.b bVar = com.tencent.mobileqq.guild.component.banner.viewpager2.b.f215854a;
        bVar.e(viewPager2, this.duration);
        View childAt = viewPager2.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        boolean z16 = ((RecyclerView) childAt).getLayoutManager() instanceof ProxySmoothScrollerLayoutManager;
        bVar.c(viewPager2, this.duration);
        if (!z16 && currentItem != 0) {
            viewPager2.post(new Runnable() { // from class: pg1.n
                @Override // java.lang.Runnable
                public final void run() {
                    o.g(ViewPager2.this, currentItem);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ViewPager2 viewPager2, int i3) {
        Intrinsics.checkNotNullParameter(viewPager2, "$viewPager2");
        C11734b c11734b = C11734b.f433780a;
        QLog.w("Guild.component.SpeedBannerStyle", 1, "currentItem(in setSpeed post): " + viewPager2.getCurrentItem() + ", " + viewPager2.hashCode(), null);
        viewPager2.setCurrentItem(i3, false);
    }

    @Override // pg1.d
    public void a(@NotNull final ViewPager2 viewPager2, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        f(viewPager2);
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: pg1.m
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                o.e(ViewPager2.this, this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        };
        this.onLayoutChangeListener = onLayoutChangeListener;
        recyclerView.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    @Override // pg1.d
    public void b(@NotNull ViewPager2 viewPager2, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        View.OnLayoutChangeListener onLayoutChangeListener = this.onLayoutChangeListener;
        if (onLayoutChangeListener != null) {
            recyclerView.removeOnLayoutChangeListener(onLayoutChangeListener);
            this.onLayoutChangeListener = null;
        }
    }
}
