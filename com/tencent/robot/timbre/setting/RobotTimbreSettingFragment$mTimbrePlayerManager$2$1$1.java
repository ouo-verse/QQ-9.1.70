package com.tencent.robot.timbre.setting;

import android.app.Dialog;
import android.content.DialogInterface;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import com.tencent.robot.timbre.RobotTimbrePlayerManager;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
final class RobotTimbreSettingFragment$mTimbrePlayerManager$2$1$1 extends Lambda implements Function1<TtsInfo, Unit> {
    final /* synthetic */ RobotTimbrePlayerManager $this_apply;
    final /* synthetic */ RobotTimbreSettingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotTimbreSettingFragment$mTimbrePlayerManager$2$1$1(RobotTimbreSettingFragment robotTimbreSettingFragment, RobotTimbrePlayerManager robotTimbrePlayerManager) {
        super(1);
        this.this$0 = robotTimbreSettingFragment;
        this.$this_apply = robotTimbrePlayerManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RobotTimbrePlayerManager this_apply, TtsInfo it, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(it, "$it");
        this_apply.g(it);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TtsInfo ttsInfo) {
        invoke2(ttsInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final TtsInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        RobotTimbreSettingFragment robotTimbreSettingFragment = this.this$0;
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(robotTimbreSettingFragment.requireContext(), null, false);
        final RobotTimbrePlayerManager robotTimbrePlayerManager = this.$this_apply;
        showLoadingDialog.show();
        showLoadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.robot.timbre.setting.g
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                RobotTimbreSettingFragment$mTimbrePlayerManager$2$1$1.b(RobotTimbrePlayerManager.this, it, dialogInterface);
            }
        });
        robotTimbreSettingFragment.loadingDialog = showLoadingDialog;
    }
}
