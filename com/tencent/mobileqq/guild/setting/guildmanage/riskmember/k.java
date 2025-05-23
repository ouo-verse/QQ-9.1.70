package com.tencent.mobileqq.guild.setting.guildmanage.riskmember;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\\\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006J9\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/k;", "", "Landroid/content/Context;", "context", "", "nickName", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "onRemoveFromRiskClick", "onRemoveFromGuildClick", "Lcom/tencent/widget/ActionSheet;", "f", "onConfirm", "d", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f234201a = new k();

    k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 onConfirm, ActionSheet actionSheet, View clickedView, int i3) {
        Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(clickedView, "clickedView");
        onConfirm.invoke(clickedView);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 onRemoveFromRiskClick, ActionSheet actionSheet, Function1 onRemoveFromGuildClick, View clickedView, int i3) {
        Intrinsics.checkNotNullParameter(onRemoveFromRiskClick, "$onRemoveFromRiskClick");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(onRemoveFromGuildClick, "$onRemoveFromGuildClick");
        Intrinsics.checkNotNullParameter(clickedView, "clickedView");
        if (i3 != 0) {
            if (i3 == 1) {
                onRemoveFromGuildClick.invoke(clickedView);
                actionSheet.dismiss();
                return;
            }
            return;
        }
        onRemoveFromRiskClick.invoke(clickedView);
        actionSheet.dismiss();
    }

    @NotNull
    public final ActionSheet d(@NotNull Context context, @NotNull String nickName, @NotNull final Function1<? super View, Unit> onConfirm) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle("\u5bf9 " + nickName);
        actionSheet.addButton(HardCodeUtil.qqStr(R.string.f153281bo), 0);
        actionSheet.addCancelButton(R.string.f140850f3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.h
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                k.e(Function1.this, actionSheet, view, i3);
            }
        });
        actionSheet.show();
        return actionSheet;
    }

    @NotNull
    public final ActionSheet f(@NotNull Context context, @NotNull String nickName, @NotNull final Function1<? super View, Unit> onRemoveFromRiskClick, @NotNull final Function1<? super View, Unit> onRemoveFromGuildClick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(onRemoveFromRiskClick, "onRemoveFromRiskClick");
        Intrinsics.checkNotNullParameter(onRemoveFromGuildClick, "onRemoveFromGuildClick");
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle("\u5bf9 " + nickName);
        actionSheet.addButton(HardCodeUtil.qqStr(R.string.f153311br), 0);
        actionSheet.addButton(HardCodeUtil.qqStr(R.string.f152951as), 3);
        actionSheet.addCancelButton(R.string.f140850f3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.i
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                k.g(Function1.this, actionSheet, onRemoveFromGuildClick, view, i3);
            }
        });
        actionSheet.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.j
            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public final void onDismiss() {
                k.h();
            }
        });
        actionSheet.show();
        return actionSheet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
    }
}
