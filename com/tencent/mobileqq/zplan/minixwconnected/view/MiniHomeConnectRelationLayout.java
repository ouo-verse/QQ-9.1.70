package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.manager.ZPlanProfileLikeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u001aB\u0019\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u000b\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectRelationLayout;", "Landroid/widget/RelativeLayout;", "", "j", "", "peerUin", "i", "f", "k", tl.h.F, "Lcom/tencent/mobileqq/zplan/manager/ZPlanProfileLikeManager;", "d", "Lcom/tencent/mobileqq/zplan/manager/ZPlanProfileLikeManager;", "likeManager", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectIconLayout;", "e", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectIconLayout;", "profileCardIconLayout", "likeIconLayout", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "owner", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectRelationLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZPlanProfileLikeManager likeManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy profileCardIconLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy likeIconLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectRelationLayout(final Context context, LifecycleOwner lifecycleOwner) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        ZPlanProfileLikeManager zPlanProfileLikeManager = new ZPlanProfileLikeManager(context);
        this.likeManager = zPlanProfileLikeManager;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectIconLayout>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectRelationLayout$profileCardIconLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectIconLayout invoke() {
                Context context2 = context;
                MiniHomeConnectIconLayout miniHomeConnectIconLayout = new MiniHomeConnectIconLayout(context2, c.b(context2, R.drawable.qui_name_card, 0, 4, null), "\u8d44\u6599\u5361");
                miniHomeConnectIconLayout.setTag("profileCardIcon");
                ViewGroup.LayoutParams layoutParams = miniHomeConnectIconLayout.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.addRule(9);
                }
                return miniHomeConnectIconLayout;
            }
        });
        this.profileCardIconLayout = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MiniHomeConnectIconLayout>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectRelationLayout$likeIconLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniHomeConnectIconLayout invoke() {
                Context context2 = context;
                MiniHomeConnectIconLayout miniHomeConnectIconLayout = new MiniHomeConnectIconLayout(context2, c.b(context2, R.drawable.qui_like_qzone, 0, 4, null), "\u70b9\u8d5e");
                miniHomeConnectIconLayout.setTag("likeIcon");
                ViewGroup.LayoutParams layoutParams = miniHomeConnectIconLayout.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.addRule(11);
                }
                return miniHomeConnectIconLayout;
            }
        });
        this.likeIconLayout = lazy2;
        if (lifecycleOwner != null) {
            LiveData<Long> k3 = zPlanProfileLikeManager.k();
            final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectRelationLayout$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke2(l3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final Long l3) {
                    final MiniHomeConnectRelationLayout miniHomeConnectRelationLayout = MiniHomeConnectRelationLayout.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectRelationLayout$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MiniHomeConnectIconLayout d16;
                            Long it = l3;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            if (it.longValue() < 0) {
                                return;
                            }
                            d16 = miniHomeConnectRelationLayout.d();
                            ((TextView) d16.findViewWithTag("iconTextView")).setText(String.valueOf(l3));
                            miniHomeConnectRelationLayout.j();
                        }
                    });
                }
            };
            k3.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MiniHomeConnectRelationLayout.g(Function1.this, obj);
                }
            });
        }
        setLayoutParams(new RelativeLayout.LayoutParams(com.tencent.sqshow.zootopia.utils.i.b(170), com.tencent.sqshow.zootopia.utils.i.b(76)));
        addView(e());
        addView(d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniHomeConnectIconLayout d() {
        return (MiniHomeConnectIconLayout) this.likeIconLayout.getValue();
    }

    private final MiniHomeConnectIconLayout e() {
        return (MiniHomeConnectIconLayout) this.profileCardIconLayout.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        long h16 = this.likeManager.h();
        try {
            ((ImageView) d().findViewWithTag("iconImgView")).setImageDrawable(ie0.a.f().o(getContext(), h16 <= 0 ? R.drawable.qui_like : R.drawable.qui_like_filled, h16 <= 0 ? R.color.qui_common_icon_primary : R.color.qui_common_brand_standard, 1001));
        } catch (Exception e16) {
            QLog.d("MiniHomeConnectRelationLayout", 1, "likeManager setDrawable error = " + e16);
        }
    }

    public final void f(long peerUin) {
        ImageView imageView;
        this.likeManager.l(peerUin);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Drawable a16 = c.a(context, R.drawable.qui_like_filled_brand, R.color.qui_common_brand_standard);
        if (a16 == null || (imageView = (ImageView) d().findViewWithTag("iconImgView")) == null) {
            return;
        }
        imageView.setImageDrawable(a16);
    }

    public final void h() {
        this.likeManager.m();
    }

    public final void i(long peerUin) {
        ImageView imageView;
        this.likeManager.o(peerUin);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Drawable b16 = c.b(context, R.drawable.qui_like, 0, 4, null);
        if (b16 == null || (imageView = (ImageView) d().findViewWithTag("iconImgView")) == null) {
            return;
        }
        imageView.setImageDrawable(b16);
    }

    public final void k() {
        this.likeManager.n();
    }
}
