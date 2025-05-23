package com.tencent.mobileqq.guild.setting.qrcode.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeViewModel;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001(B7\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0010\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/qrcode/view/CenterCardHighlightQrCode;", "Lcom/tencent/mobileqq/guild/setting/qrcode/view/GuildQrCodeCenterCard;", "", "g1", "d1", "", "qrCodeTipStr", "setQrCodeDeadline", "J0", "", "padding", "setPadding", "X0", "Y0", "Landroid/widget/TextView;", "P", "Landroid/widget/TextView;", "mTvGuildInvitationInfo", "Landroid/widget/ImageView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/ImageView;", "mIvGuildLabelIcon", BdhLogUtil.LogTag.Tag_Req, "mTvGuildLabel", ExifInterface.LATITUDE_SOUTH, "mMemberIcon", "T", "mCodeHint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "def", "Lcom/tencent/mobileqq/guild/setting/qrcode/GuildQRCodeViewModel;", "mViewModel", "Lcom/tencent/mobileqq/mvvm/d;", "mOwner", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/mobileqq/guild/setting/qrcode/GuildQRCodeViewModel;Lcom/tencent/mobileqq/mvvm/d;)V", "U", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class CenterCardHighlightQrCode extends GuildQrCodeCenterCard {

    /* renamed from: P, reason: from kotlin metadata */
    private TextView mTvGuildInvitationInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImageView mIvGuildLabelIcon;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView mTvGuildLabel;

    /* renamed from: S, reason: from kotlin metadata */
    private ImageView mMemberIcon;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView mCodeHint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CenterCardHighlightQrCode(@NotNull Context context, @NotNull GuildQRCodeViewModel mViewModel, @NotNull com.tencent.mobileqq.mvvm.d mOwner) {
        this(context, null, 0, mViewModel, mOwner, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mOwner, "mOwner");
    }

    private final void g1() {
        ImageView imageView = null;
        if (TextUtils.isEmpty(O0().getMembersCount())) {
            R0().setVisibility(8);
            ImageView imageView2 = this.mMemberIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMemberIcon");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        R0().setText(O0().getMembersCount() + "\u6210\u5458");
        ImageView imageView3 = this.mMemberIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMemberIcon");
        } else {
            imageView = imageView3;
        }
        u.p("https://downv6.qq.com/innovate/guild/qr_code/guild_qrcode_member_icon_black.png", imageView);
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public void J0() {
        U0().setText(getMViewModel().mSharerName + " \u62cd\u4e86\u62cd\u4f60\u8bf4");
        g1();
        TextView textView = this.mTvGuildInvitationInfo;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvGuildInvitationInfo");
            textView = null;
        }
        textView.setText(O0().getChannelCopyWriter());
        String guildLabel = O0().getGuildLabel();
        if (TextUtils.isEmpty(guildLabel)) {
            ImageView imageView = this.mIvGuildLabelIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvGuildLabelIcon");
                imageView = null;
            }
            imageView.setVisibility(8);
            TextView textView3 = this.mTvGuildLabel;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvGuildLabel");
            } else {
                textView2 = textView3;
            }
            textView2.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.mIvGuildLabelIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvGuildLabelIcon");
            imageView2 = null;
        }
        u.p("https://downv6.qq.com/innovate/guild/qr_code/guild_qrcode_explore_icon.png", imageView2);
        TextView textView4 = this.mTvGuildLabel;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvGuildLabel");
        } else {
            textView2 = textView4;
        }
        textView2.setText(guildLabel);
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public int X0() {
        return QQGuildUIUtil.f(20.3f);
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public int Y0() {
        return QQGuildUIUtil.f(37.3f);
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public void d1() {
        View findViewById = getMView().findViewById(R.id.x3b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(R.id.\u2026tv_guild_invitation_info)");
        this.mTvGuildInvitationInfo = (TextView) findViewById;
        View findViewById2 = getMView().findViewById(R.id.wke);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mView.findViewById(R.id.guild_iv_guild_label_icon)");
        this.mIvGuildLabelIcon = (ImageView) findViewById2;
        View findViewById3 = getMView().findViewById(R.id.x3c);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mView.findViewById(R.id.guild_tv_guild_label)");
        this.mTvGuildLabel = (TextView) findViewById3;
        View findViewById4 = getMView().findViewById(R.id.wkf);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mView.findViewById(R.id.\u2026ild_iv_guild_member_icon)");
        this.mMemberIcon = (ImageView) findViewById4;
        View findViewById5 = getMView().findViewById(R.id.x3v);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mView.findViewById(R.id.guild_tv_qr_code_hint)");
        this.mCodeHint = (TextView) findViewById5;
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public void setPadding(int padding) {
        View findViewById = getMView().findViewById(R.id.w2s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(R.id.\u2026qr_code_center_container)");
        ((ConstraintLayout) findViewById).setPadding(padding, padding, padding, 0);
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public void setQrCodeDeadline(@NotNull String qrCodeTipStr) {
        Intrinsics.checkNotNullParameter(qrCodeTipStr, "qrCodeTipStr");
        setMQrCodeDeadline(qrCodeTipStr);
        TextView textView = null;
        if (!TextUtils.isEmpty(getMQrCodeDeadline())) {
            T0().setText("\u8be5\u4e8c\u7ef4\u7801" + getMQrCodeDeadline());
            TextView textView2 = this.mCodeHint;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCodeHint");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.mCodeHint;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCodeHint");
        } else {
            textView = textView3;
        }
        textView.setVisibility(0);
    }

    public /* synthetic */ CenterCardHighlightQrCode(Context context, AttributeSet attributeSet, int i3, GuildQRCodeViewModel guildQRCodeViewModel, com.tencent.mobileqq.mvvm.d dVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, guildQRCodeViewModel, dVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CenterCardHighlightQrCode(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull GuildQRCodeViewModel mViewModel, @NotNull com.tencent.mobileqq.mvvm.d mOwner) {
        super(context, attributeSet, i3, R.layout.f168152f32, mViewModel, mOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mOwner, "mOwner");
    }
}
