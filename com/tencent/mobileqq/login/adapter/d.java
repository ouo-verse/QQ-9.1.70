package com.tencent.mobileqq.login.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b+\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/login/adapter/d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "itemView", "Landroid/widget/RelativeLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/RelativeLayout;", "p", "()Landroid/widget/RelativeLayout;", "itemLayout", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "G", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarIv", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "r", "()Landroid/widget/TextView;", "nicknameTv", "I", "l", "accountTv", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "J", "Lcom/tencent/biz/qui/quibutton/QUIButton;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "loginBtn", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "deleteIv", "<init>", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private View itemView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout itemLayout;

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
    private final QUIButton loginBtn;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final ImageView deleteIv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        this.itemView = itemView;
        View findViewById = this.itemView.findViewById(R.id.dq8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.item_layout)");
        this.itemLayout = (RelativeLayout) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.f165909du3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.iv_avatar)");
        this.avatarIv = (QQProAvatarView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.k9t);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_nickname)");
        this.nicknameTv = (TextView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R.id.f1057466u);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_account)");
        this.accountTv = (TextView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R.id.btn_login);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.btn_login)");
        this.loginBtn = (QUIButton) findViewById5;
        View findViewById6 = this.itemView.findViewById(R.id.f165918y20);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.iv_delete)");
        this.deleteIv = (ImageView) findViewById6;
    }

    @NotNull
    public final TextView l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TextView) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.accountTv;
    }

    @NotNull
    public final QQProAvatarView m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QQProAvatarView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.avatarIv;
    }

    @NotNull
    public final ImageView o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ImageView) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.deleteIv;
    }

    @NotNull
    public final RelativeLayout p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.itemLayout;
    }

    @NotNull
    public final QUIButton q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QUIButton) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.loginBtn;
    }

    @NotNull
    public final TextView r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TextView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.nicknameTv;
    }
}
