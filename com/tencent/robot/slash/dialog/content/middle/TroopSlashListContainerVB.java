package com.tencent.robot.slash.dialog.content.middle;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.robot.slash.dialog.content.avatarbar.AvatarBarVB;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVB;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVM;
import com.tencent.robot.slash.dialog.content.base.b;
import com.tencent.robot.widget.list.vb.CommonListVB;
import i64.d;
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
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J2\u0010\u000e\u001a$\u0012 \u0012\u001e\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\r0\f2\u0006\u0010\u000b\u001a\u00020\tH\u0016J \u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J \u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0017H\u0016R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR'\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/middle/TroopSlashListContainerVB;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVB;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "initializeChildVB", "", "isHalfMode", "", "accumulatedValue", "totalAvailableHint", "w0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "Li64/d;", "e", "Lkotlin/Lazy;", "e1", "()Li64/d;", "mTitleVB", "Lcom/tencent/robot/widget/list/vb/CommonListVB;", "f", "d1", "()Lcom/tencent/robot/widget/list/vb/CommonListVB;", "mListVB", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarVB;", h.F, "c1", "()Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarVB;", "mAvatarBarVB", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopSlashListContainerVB extends SlashDialogVB<ol3.b, MviUIState, e<u54.c>> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTitleVB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mListVB;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mAvatarBarVB;

    public TroopSlashListContainerVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<d>() { // from class: com.tencent.robot.slash.dialog.content.middle.TroopSlashListContainerVB$mTitleVB$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                return new d(false, 1, null);
            }
        });
        this.mTitleVB = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CommonListVB<e<u54.c>>>() { // from class: com.tencent.robot.slash.dialog.content.middle.TroopSlashListContainerVB$mListVB$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CommonListVB<e<u54.c>> invoke() {
                return new CommonListVB<>(new com.tencent.robot.slash.dialog.content.list.a());
            }
        });
        this.mListVB = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<AvatarBarVB>() { // from class: com.tencent.robot.slash.dialog.content.middle.TroopSlashListContainerVB$mAvatarBarVB$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AvatarBarVB invoke() {
                return new AvatarBarVB();
            }
        });
        this.mAvatarBarVB = lazy3;
    }

    private final AvatarBarVB c1() {
        return (AvatarBarVB) this.mAvatarBarVB.getValue();
    }

    private final CommonListVB<e<u54.c>> d1() {
        return (CommonListVB) this.mListVB.getValue();
    }

    private final d e1() {
        return (d) this.mTitleVB.getValue();
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVB, x64.m
    public int Q(boolean isHalfMode, int accumulatedValue, int totalAvailableHint) {
        boolean z16;
        View safetyGetHostView = safetyGetHostView();
        int i3 = 0;
        if (safetyGetHostView != null && safetyGetHostView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return 0;
        }
        int Q = e1().Q(isHalfMode, accumulatedValue, totalAvailableHint) + accumulatedValue;
        int Q2 = Q + c1().Q(isHalfMode, Q, totalAvailableHint);
        Bundle generateVBState = d1().generateVBState(new b.FetchVisualHeight(isHalfMode, Q2, totalAvailableHint));
        if (generateVBState != null) {
            i3 = generateVBState.getInt("half_mode_visual_height");
        }
        return (Q2 + i3) - accumulatedValue;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<ol3.b, MviUIState, e<u54.c>> createVM() {
        return new SlashDialogVM(true);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, e<u54.c>>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new BaseVB[]{e1(), d1(), c1()});
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
        int i3 = 0;
        if (safetyGetHostView != null && safetyGetHostView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return 0;
        }
        int w06 = e1().w0(isHalfMode, accumulatedValue, totalAvailableHint) + accumulatedValue;
        int w07 = w06 + c1().w0(isHalfMode, w06, totalAvailableHint);
        Bundle generateVBState = d1().generateVBState(new b.FetchHeight(isHalfMode, w07, totalAvailableHint));
        if (generateVBState != null) {
            i3 = generateVBState.getInt("half_mode_height");
        }
        return (w07 + i3) - accumulatedValue;
    }
}
