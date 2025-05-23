package com.tencent.robot.draw.vb.container;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c44.g;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.robot.draw.vb.DrawListVB;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVB;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVM;
import f44.a;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import tl.h;
import u54.c;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006:\u0001-B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J2\u0010\u0012\u001a$\u0012 \u0012\u001e\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00110\u00102\u0006\u0010\u000f\u001a\u00020\rH\u0016J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J \u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0018H\u0016R\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R'\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/robot/draw/vb/container/C2CDrawListContainerVB;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVB;", "", "accumulatedValue", "totalAvailableHint", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "initializeChildVB", "", "isHalfMode", "w0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "e", "I", "getDialogTopPadding", "()I", "dialogTopPadding", "Lc44/g;", "f", "Lkotlin/Lazy;", "d1", "()Lc44/g;", "mTitleVB", "Lcom/tencent/robot/draw/vb/DrawListVB;", h.F, "c1", "()Lcom/tencent/robot/draw/vb/DrawListVB;", "mListVB", "<init>", "(I)V", "i", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class C2CDrawListContainerVB extends SlashDialogVB<b, MviUIState, e<c>> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int dialogTopPadding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTitleVB;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mListVB;

    public C2CDrawListContainerVB(int i3) {
        Lazy lazy;
        Lazy lazy2;
        this.dialogTopPadding = i3;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<g>() { // from class: com.tencent.robot.draw.vb.container.C2CDrawListContainerVB$mTitleVB$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                return new g(false, 1, null);
            }
        });
        this.mTitleVB = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<DrawListVB<e<c>>>() { // from class: com.tencent.robot.draw.vb.container.C2CDrawListContainerVB$mListVB$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DrawListVB<e<c>> invoke() {
                return new DrawListVB<>(new a());
            }
        });
        this.mListVB = lazy2;
    }

    private final DrawListVB<e<c>> c1() {
        return (DrawListVB) this.mListVB.getValue();
    }

    private final g d1() {
        return (g) this.mTitleVB.getValue();
    }

    private final int e1(int accumulatedValue, int totalAvailableHint) {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((totalAvailableHint - accumulatedValue) - this.dialogTopPadding, ViewUtils.dip2px(225.0f));
        return coerceAtMost;
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVB, x64.m
    public int Q(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        boolean z16;
        View safetyGetHostView = safetyGetHostView();
        if (safetyGetHostView != null && safetyGetHostView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return 0;
        }
        int Q = d1().Q(isHalfMode, accumulatedValue, totalAvailableHint) + accumulatedValue;
        return (Q + e1(Q, totalAvailableHint)) - accumulatedValue;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<b, MviUIState, e<c>> createVM() {
        return new SlashDialogVM(true);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends b, ? extends MviUIState, e<c>>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends b, ? extends MviUIState, e<c>>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new BaseVB[]{d1(), c1()});
        return listOf;
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVB, x64.m
    public int m() {
        return 1;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        LinearLayout linearLayout = new LinearLayout(createViewParams.a());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVB, x64.m
    public int w0(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        boolean z16;
        View safetyGetHostView = safetyGetHostView();
        if (safetyGetHostView != null && safetyGetHostView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return 0;
        }
        int w06 = d1().w0(isHalfMode, accumulatedValue, totalAvailableHint) + accumulatedValue;
        return (w06 + e1(w06, totalAvailableHint)) - accumulatedValue;
    }
}
