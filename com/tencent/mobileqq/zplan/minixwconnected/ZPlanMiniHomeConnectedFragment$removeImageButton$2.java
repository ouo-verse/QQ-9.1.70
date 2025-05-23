package com.tencent.mobileqq.zplan.minixwconnected;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerData;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerOpType;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerStatus;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerUserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.minixwconnected.controller.MiniHomeConnectedController;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.util.QQToastUtil;
import fi3.bi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
final class ZPlanMiniHomeConnectedFragment$removeImageButton$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ ZPlanMiniHomeConnectedFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMiniHomeConnectedFragment$removeImageButton$2(ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment) {
        super(0);
        this.this$0 = zPlanMiniHomeConnectedFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final ZPlanMiniHomeConnectedFragment this$0, final ImageView this_apply, View view) {
        MiniHomeConnectedController miniHomeConnectedController;
        FlowerData J;
        FlowerUserInfo userInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (NetworkUtil.isNetworkAvailable()) {
            miniHomeConnectedController = this$0.controller;
            final boolean z16 = ((miniHomeConnectedController == null || (J = miniHomeConnectedController.J()) == null || (userInfo = J.getUserInfo()) == null) ? null : userInfo.getStatus()) == FlowerStatus.MaxLevel;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.minixwconnected.g
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanMiniHomeConnectedFragment$removeImageButton$2.f(ZPlanMiniHomeConnectedFragment.this, this_apply, z16);
                }
            });
            return;
        }
        QQToastUtil.showQQToastInUiThread(1, ZPlanQQMC.INSTANCE.getXWConnectFlowerConfig().getNetworkExceptionPromptText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final ZPlanMiniHomeConnectedFragment this$0, ImageView this_apply, boolean z16) {
        String removeDialogPromptText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Context context = this_apply.getContext();
        if (z16) {
            removeDialogPromptText = ZPlanQQMC.INSTANCE.getXWConnectFlowerConfig().getRemoveDialogMaxLevelPromptText();
        } else {
            removeDialogPromptText = ZPlanQQMC.INSTANCE.getXWConnectFlowerConfig().getRemoveDialogPromptText();
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, removeDialogPromptText, "\u518d\u60f3\u60f3", "\u7acb\u5373\u94f2\u9664", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZPlanMiniHomeConnectedFragment$removeImageButton$2.g(ZPlanMiniHomeConnectedFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZPlanMiniHomeConnectedFragment$removeImageButton$2.h(dialogInterface, i3);
            }
        });
        createCustomDialog.show();
        this$0.removeConfirmDialog = createCustomDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ZPlanMiniHomeConnectedFragment this$0, DialogInterface dialogInterface, int i3) {
        MiniHomeConnectedController miniHomeConnectedController;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        miniHomeConnectedController = this$0.controller;
        if (miniHomeConnectedController != null) {
            MiniHomeConnectedController.w(miniHomeConnectedController, FlowerOpType.REMOVE, null, 2, null);
        }
        this$0.Sh();
        this$0.ci();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ImageView invoke() {
        bi Xh;
        final ImageView imageView = new ImageView(this.this$0.getContext());
        final ZPlanMiniHomeConnectedFragment zPlanMiniHomeConnectedFragment = this.this$0;
        imageView.setTag("removeImageButton");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(40.0f), ViewUtils.dpToPx(40.0f));
        layoutParams.addRule(11, -1);
        Xh = zPlanMiniHomeConnectedFragment.Xh();
        layoutParams.topMargin = (int) (Xh.getRoot().getHeight() * 0.55f);
        layoutParams.rightMargin = ViewUtils.dpToPx(16.0f);
        imageView.setPadding(ViewUtils.dpToPx(5.0f), ViewUtils.dpToPx(5.0f), ViewUtils.dpToPx(5.0f), ViewUtils.dpToPx(5.0f));
        imageView.setLayoutParams(layoutParams);
        imageView.setVisibility(8);
        imageView.setImageDrawable(imageView.getContext().getDrawable(R.drawable.f159896ig2));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanMiniHomeConnectedFragment$removeImageButton$2.e(ZPlanMiniHomeConnectedFragment.this, imageView, view);
            }
        });
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DialogInterface dialogInterface, int i3) {
    }
}
