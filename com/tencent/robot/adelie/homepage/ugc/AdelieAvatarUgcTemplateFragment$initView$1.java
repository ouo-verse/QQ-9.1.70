package com.tencent.robot.adelie.homepage.ugc;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarUgcTemplateMaterial;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/i;", "styleItem", "", "invoke", "(Lcom/tencent/robot/adelie/homepage/ugc/view/i;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieAvatarUgcTemplateFragment$initView$1 extends Lambda implements Function1<AdelieAvatarUgcTemplateMaterial, Unit> {
    final /* synthetic */ AdelieAvatarUgcTemplateFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieAvatarUgcTemplateFragment$initView$1(AdelieAvatarUgcTemplateFragment adelieAvatarUgcTemplateFragment) {
        super(1);
        this.this$0 = adelieAvatarUgcTemplateFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AdelieAvatarUgcTemplateFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.setResult(-1, activity.getIntent());
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AdelieAvatarUgcTemplateMaterial adelieAvatarUgcTemplateMaterial) {
        invoke2(adelieAvatarUgcTemplateMaterial);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull AdelieAvatarUgcTemplateMaterial styleItem) {
        boolean z16;
        Intrinsics.checkNotNullParameter(styleItem, "styleItem");
        if (styleItem.getData() == null) {
            QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u4e0d\u7ed9\u529b\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
            return;
        }
        AdelieAvatarUgcTemplateFragment.INSTANCE.b(styleItem);
        z16 = this.this$0.hasEditPrompt;
        if (z16) {
            FragmentActivity activity = this.this$0.getActivity();
            String string = this.this$0.getString(R.string.zpd);
            final AdelieAvatarUgcTemplateFragment adelieAvatarUgcTemplateFragment = this.this$0;
            DialogUtil.createNoTitleDialog(activity, string, R.string.ylh, R.string.zpe, new DialogInterface.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.ae
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AdelieAvatarUgcTemplateFragment$initView$1.c(AdelieAvatarUgcTemplateFragment.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.ugc.af
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AdelieAvatarUgcTemplateFragment$initView$1.d(dialogInterface, i3);
                }
            }).show();
            return;
        }
        FragmentActivity activity2 = this.this$0.getActivity();
        if (activity2 != null) {
            activity2.setResult(-1, activity2.getIntent());
            activity2.finish();
        }
    }
}
