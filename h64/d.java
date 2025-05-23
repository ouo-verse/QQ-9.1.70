package h64;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVB;
import com.tencent.robot.slash.dialog.content.tip.SlashTipContentUIState;
import h64.a;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import u64.g;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00150\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J \u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lh64/d;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVB;", "Lh64/a;", "Lcom/tencent/robot/slash/dialog/content/tip/SlashTipContentUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVB;", "", "i1", "", "needShowAddBtn", "e1", "Landroid/view/View;", "view", "l1", "k1", "g1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "", "Ljava/lang/Class;", "getObserverStates", "state", "j1", "isHalfMode", "", "accumulatedValue", "totalAvailableHint", "w0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mRootLayout", "Lfn2/d;", "f", "Lfn2/d;", "mLoadingLayoutBinding", "Lfn2/b;", h.F, "Lfn2/b;", "mLoadEmptyLayoutBinding", "Lfn2/c;", "i", "Lfn2/c;", "mLoadFiledBinding", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends SlashDialogVB<a, SlashTipContentUIState, e<u54.c>> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mRootLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private fn2.d mLoadingLayoutBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private fn2.b mLoadEmptyLayoutBinding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private fn2.c mLoadFiledBinding;

    private final void e1(boolean needShowAddBtn) {
        ViewGroup viewGroup = this.mRootLayout;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            viewGroup = null;
        }
        viewGroup.removeAllViews();
        if (this.mLoadEmptyLayoutBinding == null) {
            ViewGroup viewGroup3 = this.mRootLayout;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                viewGroup3 = null;
            }
            LayoutInflater from = LayoutInflater.from(viewGroup3.getContext());
            ViewGroup viewGroup4 = this.mRootLayout;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                viewGroup4 = null;
            }
            fn2.b g16 = fn2.b.g(from, viewGroup4, false);
            g16.f400109b.setOnClickListener(new View.OnClickListener() { // from class: h64.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.f1(d.this, view);
                }
            });
            ViewGroup viewGroup5 = this.mRootLayout;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                viewGroup5 = null;
            }
            g16.f400110c.addView(new QUIEmptyState.Builder(viewGroup5.getContext()).setThemeType(0).setImageType(14).setBackgroundColorType(0).setHalfScreenState(true).build());
            this.mLoadEmptyLayoutBinding = g16;
        }
        fn2.b bVar = this.mLoadEmptyLayoutBinding;
        Intrinsics.checkNotNull(bVar);
        if (needShowAddBtn) {
            QUIButton addBtn = bVar.f400109b;
            Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
            l1(addBtn);
        }
        QUIButton qUIButton = bVar.f400109b;
        Boolean valueOf = Boolean.valueOf(needShowAddBtn);
        qUIButton.setVisibility(0);
        if (((View) au.a(valueOf, qUIButton)) == null) {
            qUIButton.setVisibility(8);
        }
        ViewGroup viewGroup6 = this.mRootLayout;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
        } else {
            viewGroup2 = viewGroup6;
        }
        viewGroup2.addView(bVar.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(d this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.k1(it);
        this$0.sendIntent(a.C10417a.f404457d);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void g1() {
        ViewGroup viewGroup = this.mRootLayout;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            viewGroup = null;
        }
        viewGroup.removeAllViews();
        if (this.mLoadFiledBinding == null) {
            ViewGroup viewGroup3 = this.mRootLayout;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                viewGroup3 = null;
            }
            LayoutInflater from = LayoutInflater.from(viewGroup3.getContext());
            ViewGroup viewGroup4 = this.mRootLayout;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                viewGroup4 = null;
            }
            final fn2.c g16 = fn2.c.g(from, viewGroup4, false);
            g16.f400113c.setOnClickListener(new View.OnClickListener() { // from class: h64.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.h1(fn2.c.this, this, view);
                }
            });
            ViewGroup viewGroup5 = this.mRootLayout;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                viewGroup5 = null;
            }
            g16.f400112b.addView(new QUIEmptyState.Builder(viewGroup5.getContext()).setThemeType(0).setImageType(5).setBackgroundColorType(0).setHalfScreenState(true).build());
            this.mLoadFiledBinding = g16;
        }
        ViewGroup viewGroup6 = this.mRootLayout;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
        } else {
            viewGroup2 = viewGroup6;
        }
        fn2.c cVar = this.mLoadFiledBinding;
        Intrinsics.checkNotNull(cVar);
        viewGroup2.addView(cVar.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(fn2.c this_apply, d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!g.f438512a.g()) {
            this$0.sendIntent(a.b.f404458d);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void i1() {
        ViewGroup viewGroup = this.mRootLayout;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            viewGroup = null;
        }
        viewGroup.removeAllViews();
        if (this.mLoadingLayoutBinding == null) {
            ViewGroup viewGroup3 = this.mRootLayout;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                viewGroup3 = null;
            }
            LayoutInflater from = LayoutInflater.from(viewGroup3.getContext());
            ViewGroup viewGroup4 = this.mRootLayout;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
                viewGroup4 = null;
            }
            this.mLoadingLayoutBinding = fn2.d.g(from, viewGroup4, false);
        }
        ViewGroup viewGroup5 = this.mRootLayout;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            viewGroup5 = null;
        }
        Context context = viewGroup5.getContext();
        fn2.d dVar = this.mLoadingLayoutBinding;
        Intrinsics.checkNotNull(dVar);
        int color = context.getColor(R.color.qui_common_fill_standard_secondary);
        dVar.f400116c.setSkeletonColorRes(R.color.qui_common_fill_standard_secondary);
        LinearLayout avatarLayout = dVar.f400115b;
        Intrinsics.checkNotNullExpressionValue(avatarLayout, "avatarLayout");
        for (View view : ViewGroupKt.getChildren(avatarLayout)) {
            if (view instanceof RoundImageView) {
                ((RoundImageView) view).setImageDrawable(new ColorDrawable(color));
            }
        }
        ViewGroup viewGroup6 = this.mRootLayout;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
        } else {
            viewGroup2 = viewGroup6;
        }
        viewGroup2.addView(dVar.getRoot());
    }

    private final void k1(View view) {
        VideoReport.setElementId(view, "em_sgrp_robot_slash_invite_robot");
        VideoReport.reportEvent("dt_clck", view, new HashMap());
    }

    private final void l1(View view) {
        VideoReport.setElementId(view, "em_sgrp_robot_slash_invite_robot");
        VideoReport.reportEvent("dt_imp", view, new HashMap());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends SlashTipContentUIState>> getObserverStates() {
        List<Class<? extends SlashTipContentUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{SlashTipContentUIState.ShowLoadingState.class, SlashTipContentUIState.ShowEmptyState.class, SlashTipContentUIState.ShowFailedState.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull SlashTipContentUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof SlashTipContentUIState.ShowLoadingState) {
            i1();
        } else if (state instanceof SlashTipContentUIState.ShowEmptyState) {
            e1(((SlashTipContentUIState.ShowEmptyState) state).getNeedShowAddBtn());
        } else if (state instanceof SlashTipContentUIState.ShowFailedState) {
            g1();
        }
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVB, x64.m
    public int m() {
        return 1;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRootLayout = frameLayout;
        return frameLayout;
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVB, x64.m
    public int w0(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        boolean z16;
        int coerceAtMost;
        View safetyGetHostView = safetyGetHostView();
        if (safetyGetHostView != null && safetyGetHostView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return 0;
        }
        ViewUtils viewUtils = ViewUtils.f352270a;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(viewUtils.b(365), (totalAvailableHint - accumulatedValue) - viewUtils.b(159));
        return coerceAtMost;
    }
}
