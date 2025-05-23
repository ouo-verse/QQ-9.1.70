package com.tencent.mobileqq.guild.rolegroup.fragments.roledetail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.model.ModifyRolePermissionType;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u0001:B\u000f\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010%R\u0016\u00100\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010%R\u0016\u00102\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010%R\u0016\u00104\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010%\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/roledetail/d;", "Landroid/app/Dialog;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "onStart", "Lcom/tencent/mobileqq/guild/rolegroup/model/ModifyRolePermissionType;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/rolegroup/model/ModifyRolePermissionType;", "getModifyType", "()Lcom/tencent/mobileqq/guild/rolegroup/model/ModifyRolePermissionType;", "U", "(Lcom/tencent/mobileqq/guild/rolegroup/model/ModifyRolePermissionType;)V", "modifyType", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/roledetail/d$a$a;", "D", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/roledetail/d$a$a;", "getConfirmClickListener", "()Lcom/tencent/mobileqq/guild/rolegroup/fragments/roledetail/d$a$a;", ExifInterface.LATITUDE_SOUTH, "(Lcom/tencent/mobileqq/guild/rolegroup/fragments/roledetail/d$a$a;)V", "confirmClickListener", "E", "getCancelClickListener", BdhLogUtil.LogTag.Tag_Req, "cancelClickListener", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "getRoleGroupModel", "()Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "W", "(Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;)V", "roleGroupModel", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "titleTv", "H", "contentTv", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "I", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarIv", "J", "nickNameTv", "K", "adminIconTv", "L", "cancelTv", "M", "confirmTv", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "N", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ModifyRolePermissionType modifyType;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Companion.InterfaceC7883a confirmClickListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Companion.InterfaceC7883a cancelClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RoleGroupModel roleGroupModel;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView titleTv;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView contentTv;

    /* renamed from: I, reason: from kotlin metadata */
    private GuildUserAvatarView avatarIv;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView nickNameTv;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView adminIconTv;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView cancelTv;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView confirmTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context) {
        super(context, R.style.awd);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion.InterfaceC7883a interfaceC7883a = this$0.cancelClickListener;
        if (interfaceC7883a != null) {
            interfaceC7883a.onClick();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion.InterfaceC7883a interfaceC7883a = this$0.confirmClickListener;
        if (interfaceC7883a != null) {
            interfaceC7883a.onClick();
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void R(@Nullable Companion.InterfaceC7883a interfaceC7883a) {
        this.cancelClickListener = interfaceC7883a;
    }

    public final void S(@Nullable Companion.InterfaceC7883a interfaceC7883a) {
        this.confirmClickListener = interfaceC7883a;
    }

    public final void U(@Nullable ModifyRolePermissionType modifyRolePermissionType) {
        this.modifyType = modifyRolePermissionType;
    }

    public final void W(@Nullable RoleGroupModel roleGroupModel) {
        this.roleGroupModel = roleGroupModel;
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        long j3;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejx);
        View findViewById = findViewById(R.id.jq_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title_tv)");
        this.titleTv = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.b_6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.content_tv)");
        this.contentTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.wxk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_sample_avatar)");
        this.avatarIv = (GuildUserAvatarView) findViewById3;
        RoleGroupModel roleGroupModel = this.roleGroupModel;
        if (roleGroupModel != null) {
            j3 = roleGroupModel.getManageTagPendingColor();
        } else {
            j3 = 0;
        }
        View findViewById4 = findViewById(R.id.wxl);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.guild_sample_nickname)");
        TextView textView = (TextView) findViewById4;
        this.nickNameTv = textView;
        TextView textView2 = null;
        if (j3 != 0) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nickNameTv");
                textView = null;
            }
            textView.setTextColor((int) j3);
        }
        View findViewById5 = findViewById(R.id.wxj);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.guild_sample_admin_icon)");
        this.adminIconTv = (TextView) findViewById5;
        if (j3 != 0) {
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.guild_confirm_modify_role_permission_tag_bg);
            drawable.setTint((int) j3);
            TextView textView3 = this.adminIconTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adminIconTv");
                textView3 = null;
            }
            textView3.setBackground(drawable);
        }
        View findViewById6 = findViewById(R.id.afr);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.btn_cancel)");
        this.cancelTv = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.agd);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.btn_confirm)");
        this.confirmTv = (TextView) findViewById7;
        TextView textView4 = this.cancelTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelTv");
            textView4 = null;
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.P(d.this, view);
            }
        });
        TextView textView5 = this.confirmTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmTv");
            textView5 = null;
        }
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.Q(d.this, view);
            }
        });
        if (ModifyRolePermissionType.NO_PERMISSION == this.modifyType) {
            TextView textView6 = this.titleTv;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleTv");
                textView6 = null;
            }
            textView6.setText(getContext().getResources().getString(R.string.zni));
            TextView textView7 = this.contentTv;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentTv");
                textView7 = null;
            }
            textView7.setText(getContext().getResources().getString(R.string.zng));
            TextView textView8 = this.confirmTv;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmTv");
            } else {
                textView2 = textView8;
            }
            textView2.setText(getContext().getResources().getString(R.string.a8j));
            return;
        }
        TextView textView9 = this.titleTv;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView9 = null;
        }
        textView9.setText(getContext().getResources().getString(R.string.znj));
        TextView textView10 = this.contentTv;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTv");
            textView10 = null;
        }
        textView10.setText(getContext().getResources().getString(R.string.znh));
        TextView textView11 = this.confirmTv;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmTv");
        } else {
            textView2 = textView11;
        }
        textView2.setText(getContext().getResources().getString(R.string.h3s));
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
        }
    }
}
