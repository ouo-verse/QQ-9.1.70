package pg1;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001\bB\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u00a2\u0006\u0004\b*\u0010\u0015J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\t\u001a\u00020\u0007J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lpg1/c;", "Lpg1/d;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "a", "j", "b", "Landroid/view/View;", "v", "onViewAttachedToWindow", "onViewDetachedFromWindow", "", "d", "J", "g", "()J", "k", "(J)V", "autoPagerInterval", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "autoPagerRunnable", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "f", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageChangeCallback", "", tl.h.F, "Z", "()Z", "setStoped$qqguild_component_release", "(Z)V", "stoped", "", "i", "I", "lastItem", "<init>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends d implements View.OnAttachStateChangeListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long autoPagerInterval;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable autoPagerRunnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2.OnPageChangeCallback onPageChangeCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean stoped;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lastItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"pg1/c$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "state", "", "onPageScrollStateChanged", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f426149c;

        b(ViewPager2 viewPager2) {
            this.f426149c = viewPager2;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            Runnable runnable = c.this.autoPagerRunnable;
            if (runnable == null) {
                return;
            }
            if (state != 0) {
                if (state != 1) {
                    if (state != 2) {
                        return;
                    }
                } else {
                    this.f426149c.removeCallbacks(runnable);
                    return;
                }
            }
            this.f426149c.removeCallbacks(runnable);
            this.f426149c.postDelayed(runnable, c.this.getAutoPagerInterval());
        }
    }

    public c(long j3) {
        this.autoPagerInterval = j3;
        this.stoped = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ViewPager2 viewPager2, c this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(viewPager2, "$viewPager2");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (adapter != null) {
            i3 = adapter.getItemCount();
        } else {
            i3 = 0;
        }
        int currentItem = viewPager2.getCurrentItem() + 1;
        if (currentItem < i3) {
            C11734b c11734b = C11734b.f433780a;
            if (QLog.isDebugVersion()) {
                QLog.d("Guild.component.AutoPagerBannerStyle", 2, "[" + System.identityHashCode(viewPager2) + "] auto scroll to " + currentItem, (Throwable) null);
            }
            viewPager2.setCurrentItem(currentItem);
            return;
        }
        this$0.stoped = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(View v3, c this$0) {
        Intrinsics.checkNotNullParameter(v3, "$v");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ViewPager2) v3).setCurrentItem(this$0.lastItem, false);
    }

    @Override // pg1.d
    public void a(@NotNull final ViewPager2 viewPager2, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        viewPager2.addOnAttachStateChangeListener(this);
        b bVar = new b(viewPager2);
        this.onPageChangeCallback = bVar;
        viewPager2.registerOnPageChangeCallback(bVar);
        Runnable runnable = new Runnable() { // from class: pg1.a
            @Override // java.lang.Runnable
            public final void run() {
                c.f(ViewPager2.this, this);
            }
        };
        this.autoPagerRunnable = runnable;
        this.stoped = false;
        if (viewPager2.isAttachedToWindow()) {
            viewPager2.postDelayed(runnable, this.autoPagerInterval);
        }
        this.autoPagerRunnable = runnable;
        this.lastItem = viewPager2.getCurrentItem();
    }

    @Override // pg1.d
    public void b(@NotNull ViewPager2 viewPager2, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        viewPager2.removeOnAttachStateChangeListener(this);
        this.stoped = true;
        Runnable runnable = this.autoPagerRunnable;
        if (runnable != null) {
            viewPager2.removeCallbacks(runnable);
            this.autoPagerRunnable = null;
        }
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.onPageChangeCallback;
        if (onPageChangeCallback != null) {
            viewPager2.unregisterOnPageChangeCallback(onPageChangeCallback);
            this.onPageChangeCallback = null;
        }
    }

    /* renamed from: g, reason: from getter */
    public final long getAutoPagerInterval() {
        return this.autoPagerInterval;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getStoped() {
        return this.stoped;
    }

    public final void j() {
        Runnable runnable;
        if (this.stoped && (runnable = this.autoPagerRunnable) != null) {
            runnable.run();
        }
    }

    public final void k(long j3) {
        this.autoPagerInterval = j3;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull final View v3) {
        Runnable runnable;
        int i3;
        Intrinsics.checkNotNullParameter(v3, "v");
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.AutoPagerBannerStyle", 2, "[" + System.identityHashCode(v3) + "] onViewAttachedToWindow", (Throwable) null);
        }
        ViewPager2 viewPager2 = (ViewPager2) v3;
        int i16 = this.lastItem;
        if (i16 != 0) {
            RecyclerView.Adapter adapter = viewPager2.getAdapter();
            if (adapter != null) {
                i3 = adapter.getItemCount();
            } else {
                i3 = 0;
            }
            if (i16 < i3) {
                v3.post(new Runnable() { // from class: pg1.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.i(v3, this);
                    }
                });
            }
        }
        if (!this.stoped && (runnable = this.autoPagerRunnable) != null) {
            v3.postDelayed(runnable, this.autoPagerInterval);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        C11734b c11734b = C11734b.f433780a;
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.component.AutoPagerBannerStyle", 2, "[" + System.identityHashCode(v3) + "] onViewDetachedFromWindow", (Throwable) null);
        }
        Runnable runnable = this.autoPagerRunnable;
        if (runnable != null) {
            v3.removeCallbacks(runnable);
        }
        this.lastItem = ((ViewPager2) v3).getCurrentItem();
    }

    public /* synthetic */ c(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1000L : j3);
    }
}
