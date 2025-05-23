package com.tencent.mobileqq.login.relogin.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010/\u001a\u00020\u0002\u00a2\u0006\u0004\b0\u00101R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010(\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u0017\u0010+\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\n\u001a\u0004\b*\u0010\fR\u0017\u0010.\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\u0018\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/dialog/g;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "E", "Landroid/view/View;", "p", "()Landroid/view/View;", "contentView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/ImageView;", "deleteIv", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "G", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarIv", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "t", "()Landroid/widget/TextView;", "nicknameTv", "I", "l", "accountTv", "J", ReportConstant.COSTREPORT_PREFIX, "deletePwdLayout", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "K", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "r", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "deletePwdBtn", "L", "u", "pwdDeletedTv", "M", "o", "checkIv", "N", "v", "realDeleteTv", "itemView", "<init>", "(Landroid/view/View;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View contentView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ImageView deleteIv;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final QQProAvatarView avatarIv;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView nicknameTv;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView accountTv;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final View deletePwdLayout;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final QUIButton deletePwdBtn;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final TextView pwdDeletedTv;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final ImageView checkIv;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final TextView realDeleteTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.e38);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.layout_content)");
        this.contentView = findViewById;
        View findViewById2 = itemView.findViewById(R.id.f165918y20);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.iv_delete)");
        this.deleteIv = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f165909du3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.iv_avatar)");
        this.avatarIv = (QQProAvatarView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.k9t);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_nickname)");
        this.nicknameTv = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.f1057466u);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tv_account)");
        this.accountTv = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.f166013ye1);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.layout_delete_pwd)");
        this.deletePwdLayout = findViewById6;
        View findViewById7 = itemView.findViewById(R.id.f164658te1);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.btn_delete_pwd)");
        this.deletePwdBtn = (QUIButton) findViewById7;
        View findViewById8 = itemView.findViewById(R.id.f110216hx);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.tv_pwd_deleted)");
        this.pwdDeletedTv = (TextView) findViewById8;
        View findViewById9 = itemView.findViewById(R.id.duj);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.id.iv_check)");
        this.checkIv = (ImageView) findViewById9;
        View findViewById10 = itemView.findViewById(R.id.f110436ii);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.id.tv_real_delete)");
        this.realDeleteTv = (TextView) findViewById10;
    }

    @NotNull
    public final TextView l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TextView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.accountTv;
    }

    @NotNull
    public final QQProAvatarView m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QQProAvatarView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.avatarIv;
    }

    @NotNull
    public final ImageView o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ImageView) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.checkIv;
    }

    @NotNull
    public final View p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.contentView;
    }

    @NotNull
    public final ImageView q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ImageView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.deleteIv;
    }

    @NotNull
    public final QUIButton r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QUIButton) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.deletePwdBtn;
    }

    @NotNull
    public final View s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.deletePwdLayout;
    }

    @NotNull
    public final TextView t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TextView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.nicknameTv;
    }

    @NotNull
    public final TextView u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TextView) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.pwdDeletedTv;
    }

    @NotNull
    public final TextView v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TextView) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.realDeleteTv;
    }
}
