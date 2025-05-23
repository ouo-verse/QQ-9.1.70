package com.tencent.robot.slash.dialog.content.middle;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVB;
import com.tencent.robot.slash.dialog.content.middle.SlashContainerUIState;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J2\u0010\u0017\u001a$\u0012 \u0012\u001e\u0012\u0006\b\u0001\u0012\u00020\u0015\u0012\u0006\b\u0001\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016R6\u0010!\u001a\"\u0012\u0006\b\u0001\u0012\u00020\u0015\u0012\u0006\b\u0001\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0014j\u0002`\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R6\u0010#\u001a\"\u0012\u0006\b\u0001\u0012\u00020\u0015\u0012\u0006\b\u0001\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0014j\u0002`\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/middle/b;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVB;", "", "Lcom/tencent/robot/slash/dialog/content/middle/SlashContainerUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVB;", "Lcom/tencent/robot/slash/dialog/content/middle/SlashContainerUIState$UpdateContainerTipState;", "state", "", "e1", "", "showNormalState", "f1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "bindViewAndData", "d1", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/slash/dialog/content/middle/c;", "c1", "Lcom/tencent/robot/slash/dialog/content/middle/ChildBaseVB;", "e", "Lcom/tencent/mvi/mvvm/BaseVB;", "mListContainerVB", "f", "mTipContentVB", h.F, "Z", "mIsInNormalState", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends SlashDialogVB<Object, SlashContainerUIState, e<u54.c>> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>> mListContainerVB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>> mTipContentVB;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsInNormalState;

    private final void e1(SlashContainerUIState.UpdateContainerTipState state) {
        boolean z16 = state.getState() instanceof SlashDialogMsgIntent.ShowNormalState;
        this.mIsInNormalState = z16;
        f1(z16);
    }

    private final void f1(boolean showNormalState) {
        BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>> baseVB = null;
        if (showNormalState) {
            BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>> baseVB2 = this.mListContainerVB;
            if (baseVB2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListContainerVB");
                baseVB2 = null;
            }
            View safetyGetHostView = baseVB2.safetyGetHostView();
            if (safetyGetHostView != null) {
                safetyGetHostView.setVisibility(0);
            }
            BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>> baseVB3 = this.mTipContentVB;
            if (baseVB3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipContentVB");
            } else {
                baseVB = baseVB3;
            }
            View safetyGetHostView2 = baseVB.safetyGetHostView();
            if (safetyGetHostView2 != null) {
                safetyGetHostView2.setVisibility(8);
                return;
            }
            return;
        }
        BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>> baseVB4 = this.mListContainerVB;
        if (baseVB4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListContainerVB");
            baseVB4 = null;
        }
        View safetyGetHostView3 = baseVB4.safetyGetHostView();
        if (safetyGetHostView3 != null) {
            safetyGetHostView3.setVisibility(8);
        }
        BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>> baseVB5 = this.mTipContentVB;
        if (baseVB5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipContentVB");
        } else {
            baseVB = baseVB5;
        }
        View safetyGetHostView4 = baseVB.safetyGetHostView();
        if (safetyGetHostView4 != null) {
            safetyGetHostView4.setVisibility(0);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        f1(false);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public c createVM() {
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull SlashContainerUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof SlashContainerUIState.UpdateContainerTipState) {
            e1((SlashContainerUIState.UpdateContainerTipState) state);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        Object b16 = getMStrategyService().b(a.class);
        Intrinsics.checkNotNull(b16);
        this.mTipContentVB = ((a) b16).b();
        Object b17 = getMStrategyService().b(a.class);
        Intrinsics.checkNotNull(b17);
        BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>> a16 = ((a) b17).a();
        this.mListContainerVB = a16;
        BaseVB[] baseVBArr = new BaseVB[2];
        BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>> baseVB = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListContainerVB");
            a16 = null;
        }
        baseVBArr[0] = a16;
        BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>> baseVB2 = this.mTipContentVB;
        if (baseVB2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipContentVB");
        } else {
            baseVB = baseVB2;
        }
        baseVBArr[1] = baseVB;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) baseVBArr);
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
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        frameLayout.setLayoutParams(layoutParams);
        return frameLayout;
    }
}
