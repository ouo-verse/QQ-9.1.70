package com.tencent.mobileqq.widget.gridpage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.util.x;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/widget/gridpage/QQGridViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Lcom/tencent/mobileqq/widget/gridpage/c;", "T", "Lcom/tencent/mobileqq/widget/gridpage/b;", "itemAdapter", "", "setAdapter", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "", "d", UserInfo.SEX_FEMALE, "touchDownX", "", "e", "Lkotlin/Lazy;", "a", "()I", "touchSlop", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQGridViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float touchDownX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy touchSlop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQGridViewPager(@NotNull final Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.widget.gridpage.QQGridViewPager$touchSlop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewConfiguration.get(context).getScaledTouchSlop());
            }
        });
        this.touchSlop = lazy;
    }

    private final int a() {
        return ((Number) this.touchSlop.getValue()).intValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x16 = ev5.getX() - this.touchDownX;
                    if (Math.abs(x16) >= a()) {
                        if (canScrollHorizontally(-((int) x16))) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            this.touchDownX = ev5.getX();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(ev5);
    }

    public final <T extends c> void setAdapter(@NotNull b<T> itemAdapter) {
        Intrinsics.checkNotNullParameter(itemAdapter, "itemAdapter");
        setAdapter(new d(itemAdapter));
        getLayoutParams().height = x.c(getContext(), itemAdapter.e() * itemAdapter.c());
    }
}
