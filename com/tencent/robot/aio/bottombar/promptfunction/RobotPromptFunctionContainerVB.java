package com.tencent.robot.aio.bottombar.promptfunction;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVB;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVM;
import com.tencent.robot.widget.list.vb.CommonListVB;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J2\u0010\u0010\u001a$\u0012 \u0012\u001e\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u000f0\u000e2\u0006\u0010\r\u001a\u00020\u000bH\u0016J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J \u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0018H\u0016R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR'\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/robot/aio/bottombar/promptfunction/RobotPromptFunctionContainerVB;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVB;", "", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "initializeChildVB", "", "isHalfMode", "accumulatedValue", "totalAvailableHint", "w0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "Li64/d;", "e", "Lkotlin/Lazy;", "d1", "()Li64/d;", "mTitleVB", "Lcom/tencent/robot/widget/list/vb/CommonListVB;", "f", "c1", "()Lcom/tencent/robot/widget/list/vb/CommonListVB;", "mListVB", "<init>", "()V", h.F, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotPromptFunctionContainerVB extends SlashDialogVB<ol3.b, MviUIState, w64.e<u54.c>> {

    /* renamed from: i, reason: collision with root package name */
    private static final int f366949i = ViewUtils.dpToPx(75.0f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTitleVB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mListVB;

    public RobotPromptFunctionContainerVB() {
        Lazy lazy;
        Lazy lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<i64.d>() { // from class: com.tencent.robot.aio.bottombar.promptfunction.RobotPromptFunctionContainerVB$mTitleVB$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i64.d invoke() {
                return new i64.d(false, 1, null);
            }
        });
        this.mTitleVB = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CommonListVB<w64.e<u54.c>>>() { // from class: com.tencent.robot.aio.bottombar.promptfunction.RobotPromptFunctionContainerVB$mListVB$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CommonListVB<w64.e<u54.c>> invoke() {
                return new CommonListVB<>(new l54.a());
            }
        });
        this.mListVB = lazy2;
    }

    private final CommonListVB<w64.e<u54.c>> c1() {
        return (CommonListVB) this.mListVB.getValue();
    }

    private final i64.d d1() {
        return (i64.d) this.mTitleVB.getValue();
    }

    private final int e1() {
        return f366949i;
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVB, x64.m
    public int Q(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        return w0(isHalfMode, accumulatedValue, totalAvailableHint);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<ol3.b, MviUIState, w64.e<u54.c>> createVM() {
        return new SlashDialogVM(true);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, w64.e<u54.c>>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, w64.e<u54.c>>> listOf;
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
        return ((d1().w0(isHalfMode, accumulatedValue, totalAvailableHint) + accumulatedValue) + e1()) - accumulatedValue;
    }
}
