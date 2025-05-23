package com.tencent.mobileqq.mini.api.impl;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.IGuildPermission;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.servlet.GameHallAuthServerlet;
import com.tencent.mobileqq.mini.widget.GuildPermissionDialog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/mini/api/impl/GuildPermissionImpl;", "Lcom/tencent/mobileqq/mini/api/IGuildPermission;", "()V", "dialogResult", "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "", "getUserStatus", "callBack", "Lcom/tencent/mobileqq/mini/api/IGuildPermission$StatusCallBack;", "initDialogBtn", "view", "Landroid/view/View;", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "", "initDialogReport", "dialog", "Landroid/app/Dialog;", "source", "", "showPermissionDialog", "context", "Landroid/content/Context;", "Lcom/tencent/mobileqq/mini/api/IGuildPermission$DialogCallBack;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class GuildPermissionImpl implements IGuildPermission {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PAGE_ID_DIALOG = "pg_gamecentre_authorize";
    private static final String ELEMENT_ID_AUTH = "em_sgrp_gamecentre_authorize";
    private static final String ELEMENT_ID_UNAUTH = "em_sgrp_gamecentre_noauthorize";
    private static final String SOURCE = "sgrp_stream_pgin_source";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/mini/api/impl/GuildPermissionImpl$Companion;", "", "()V", "ELEMENT_ID_AUTH", "", "getELEMENT_ID_AUTH", "()Ljava/lang/String;", "ELEMENT_ID_UNAUTH", "getELEMENT_ID_UNAUTH", "PAGE_ID_DIALOG", "getPAGE_ID_DIALOG", "SOURCE", "getSOURCE", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getELEMENT_ID_AUTH() {
            return GuildPermissionImpl.ELEMENT_ID_AUTH;
        }

        public final String getELEMENT_ID_UNAUTH() {
            return GuildPermissionImpl.ELEMENT_ID_UNAUTH;
        }

        public final String getPAGE_ID_DIALOG() {
            return GuildPermissionImpl.PAGE_ID_DIALOG;
        }

        public final String getSOURCE() {
            return GuildPermissionImpl.SOURCE;
        }

        Companion() {
        }
    }

    private final void dialogResult(final int permission) {
        com.tencent.qqmini.proxyimpl.f.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.mini.api.impl.GuildPermissionImpl$dialogResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                String currentUin = MiniAppUtils.getAppInterface().getCurrentAccountUin();
                LocalPermissionStatus localPermissionStatus = LocalPermissionStatus.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
                localPermissionStatus.setStatus(currentUin, permission);
                GameHallAuthServerlet.setAuth(permission);
            }
        });
    }

    private final void initDialogReport(Dialog dialog, String source) {
        VideoReport.setPageId(dialog, PAGE_ID_DIALOG);
        VideoReport.setPageParams(dialog, SOURCE, source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPermissionDialog$lambda$0(GuildPermissionImpl this$0, IGuildPermission.DialogCallBack dialogCallBack, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dialogResult(1);
        if (dialogCallBack != null) {
            dialogCallBack.onReject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPermissionDialog$lambda$1(GuildPermissionImpl this$0, IGuildPermission.DialogCallBack dialogCallBack, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dialogResult(2);
        if (dialogCallBack != null) {
            dialogCallBack.onConfirm();
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IGuildPermission
    public void getUserStatus(final IGuildPermission.StatusCallBack callBack) {
        com.tencent.qqmini.proxyimpl.f.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.mini.api.impl.GuildPermissionImpl$getUserStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                String currentUin = MiniAppUtils.getAppInterface().getCurrentAccountUin();
                LocalPermissionStatus localPermissionStatus = LocalPermissionStatus.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
                int status = localPermissionStatus.getStatus(currentUin);
                if (status != localPermissionStatus.getNOT_IN_CACHE()) {
                    IGuildPermission.StatusCallBack statusCallBack = IGuildPermission.StatusCallBack.this;
                    if (statusCallBack != null) {
                        statusCallBack.onResult(status);
                        return;
                    }
                    return;
                }
                final IGuildPermission.StatusCallBack statusCallBack2 = IGuildPermission.StatusCallBack.this;
                GameHallAuthServerlet.getAuth(new GameHallAuthServerlet.GetAuthCallBack() { // from class: com.tencent.mobileqq.mini.api.impl.GuildPermissionImpl$getUserStatus$1.1
                    @Override // com.tencent.mobileqq.mini.servlet.GameHallAuthServerlet.GetAuthCallBack
                    public void onError(int code, String msg2) {
                        IGuildPermission.StatusCallBack statusCallBack3 = IGuildPermission.StatusCallBack.this;
                        if (statusCallBack3 != null) {
                            statusCallBack3.onError(code, msg2);
                        }
                    }

                    @Override // com.tencent.mobileqq.mini.servlet.GameHallAuthServerlet.GetAuthCallBack
                    public void onResponse(int authStatus) {
                        String currentUin2 = MiniAppUtils.getAppInterface().getCurrentAccountUin();
                        LocalPermissionStatus localPermissionStatus2 = LocalPermissionStatus.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(currentUin2, "currentUin");
                        localPermissionStatus2.setStatus(currentUin2, authStatus);
                        IGuildPermission.StatusCallBack statusCallBack3 = IGuildPermission.StatusCallBack.this;
                        if (statusCallBack3 != null) {
                            statusCallBack3.onResult(authStatus);
                        }
                    }
                });
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.api.IGuildPermission
    public void showPermissionDialog(Context context, final IGuildPermission.DialogCallBack callBack, String source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        GuildPermissionDialog guildPermissionDialog = new GuildPermissionDialog(context);
        initDialogReport(guildPermissionDialog, source);
        View confirmBtn = guildPermissionDialog.getConfirmBtn();
        Intrinsics.checkNotNullExpressionValue(confirmBtn, "dialog.confirmBtn");
        initDialogBtn(confirmBtn, true);
        View rejectBtn = guildPermissionDialog.getRejectBtn();
        Intrinsics.checkNotNullExpressionValue(rejectBtn, "dialog.rejectBtn");
        initDialogBtn(rejectBtn, false);
        guildPermissionDialog.setRequestTitle(R.string.xxk);
        guildPermissionDialog.setRequestContent(R.string.xxl);
        guildPermissionDialog.setIconText(R.string.xxi);
        guildPermissionDialog.setOnRejectListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.api.impl.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildPermissionImpl.showPermissionDialog$lambda$0(GuildPermissionImpl.this, callBack, view);
            }
        });
        guildPermissionDialog.setOnConfirmListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.api.impl.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildPermissionImpl.showPermissionDialog$lambda$1(GuildPermissionImpl.this, callBack, view);
            }
        });
        guildPermissionDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.mini.api.impl.c
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                GuildPermissionImpl.showPermissionDialog$lambda$2(IGuildPermission.DialogCallBack.this, dialogInterface);
            }
        });
        guildPermissionDialog.show();
    }

    private final void initDialogBtn(View view, boolean confirm) {
        if (confirm) {
            VideoReport.setElementId(view, ELEMENT_ID_AUTH);
        } else {
            VideoReport.setElementId(view, ELEMENT_ID_UNAUTH);
        }
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPermissionDialog$lambda$2(IGuildPermission.DialogCallBack dialogCallBack, DialogInterface dialogInterface) {
        if (dialogCallBack != null) {
            dialogCallBack.onCancel();
        }
    }
}
