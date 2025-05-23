package com.tencent.mobileqq.guild.setting.qrcode.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeViewModel;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002*+B7\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0006R\u00020\u00000\u0005H\u0002J\u001c\u0010\u000b\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006R\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u000e\u0012\b\u0012\u00060\u0006R\u00020\u0000\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/qrcode/view/CenterCardHighlightContent;", "Lcom/tencent/mobileqq/guild/setting/qrcode/view/GuildQrCodeCenterCard;", "", "i1", "k1", "", "Lcom/tencent/mobileqq/guild/setting/qrcode/view/CenterCardHighlightContent$b;", "h1", "guildLabelInfo", "", "index", "g1", "d1", "", "qrCodeTipStr", "setQrCodeDeadline", "J0", "X0", "Y0", "Landroid/widget/ImageView;", "P", "Landroid/widget/ImageView;", "mMemberIcon", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/List;", "mGuildLabelList", "", BdhLogUtil.LogTag.Tag_Req, UserInfo.SEX_FEMALE, "mIconSize", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "def", "Lcom/tencent/mobileqq/guild/setting/qrcode/GuildQRCodeViewModel;", "mViewModel", "Lcom/tencent/mobileqq/mvvm/d;", "mOwner", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/mobileqq/guild/setting/qrcode/GuildQRCodeViewModel;Lcom/tencent/mobileqq/mvvm/d;)V", ExifInterface.LATITUDE_SOUTH, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class CenterCardHighlightContent extends GuildQrCodeCenterCard {

    /* renamed from: P, reason: from kotlin metadata */
    private ImageView mMemberIcon;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private List<b> mGuildLabelList;

    /* renamed from: R, reason: from kotlin metadata */
    private float mIconSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/qrcode/view/CenterCardHighlightContent$b;", "", "", "a", "I", "b", "()I", "iconDrawableId", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "textContent", "bitmapUrl", "<init>", "(Lcom/tencent/mobileqq/guild/setting/qrcode/view/CenterCardHighlightContent;ILjava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int iconDrawableId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String textContent;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String bitmapUrl;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CenterCardHighlightContent f234899d;

        public b(CenterCardHighlightContent centerCardHighlightContent, @NotNull int i3, @NotNull String textContent, String bitmapUrl) {
            Intrinsics.checkNotNullParameter(textContent, "textContent");
            Intrinsics.checkNotNullParameter(bitmapUrl, "bitmapUrl");
            this.f234899d = centerCardHighlightContent;
            this.iconDrawableId = i3;
            this.textContent = textContent;
            this.bitmapUrl = bitmapUrl;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getBitmapUrl() {
            return this.bitmapUrl;
        }

        /* renamed from: b, reason: from getter */
        public final int getIconDrawableId() {
            return this.iconDrawableId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getTextContent() {
            return this.textContent;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/qrcode/view/CenterCardHighlightContent$c", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GuildPicStateListener {
        c() {
            super(true);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state == LoadState.STATE_SUCCESS && option.getResultBitMap() != null && !option.getResultBitMap().isRecycled()) {
                if (CenterCardHighlightContent.this.getContext() == null) {
                    QLog.w("Guild.share.CenterCardHighlightContent", 1, "getContext is null!");
                    return;
                } else {
                    CenterCardHighlightContent.this.getMView().setBackground(new BitmapDrawable(CenterCardHighlightContent.this.getResources(), option.getResultBitMap()));
                    return;
                }
            }
            QLog.w("Guild.share.CenterCardHighlightContent", 1, "updateGuildMedal onStateChange failed!");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CenterCardHighlightContent(@NotNull Context context, @NotNull GuildQRCodeViewModel mViewModel, @NotNull com.tencent.mobileqq.mvvm.d mOwner) {
        this(context, null, 0, mViewModel, mOwner, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mOwner, "mOwner");
    }

    private final void g1(b guildLabelInfo, int index) {
        int i3;
        if (index < 3) {
            i3 = R.id.wuo;
        } else {
            i3 = R.id.wup;
        }
        View findViewById = getMView().findViewById(i3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(parentLayoutId)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        linearLayout.setVisibility(0);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), guildLabelInfo.getIconDrawableId(), null));
        u.p(guildLabelInfo.getBitmapUrl(), imageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(x.c(getContext(), this.mIconSize), x.c(getContext(), this.mIconSize));
        if (index != 3) {
            layoutParams.setMarginStart(x.c(getContext(), 13.0f));
        }
        imageView.setLayoutParams(layoutParams);
        linearLayout.addView(imageView);
        TextView textView = new TextView(getContext());
        textView.setText(guildLabelInfo.getTextContent());
        textView.setTextSize(12.0f);
        textView.setTextColor(getResources().getColor(R.color.bsx));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart(x.c(getContext(), 4.0f));
        textView.setLayoutParams(layoutParams2);
        linearLayout.addView(textView);
    }

    private final List<b> h1() {
        int i3;
        ArrayList arrayList = new ArrayList();
        String guildLabel = O0().getGuildLabel();
        if (!TextUtils.isEmpty(guildLabel)) {
            Intrinsics.checkNotNullExpressionValue(guildLabel, "guildLabel");
            arrayList.add(new b(this, R.drawable.guild_qr_code_center_card_icon_label, guildLabel, "https://downv6.qq.com/innovate/guild/qr_code/guild_qrcode_explore_icon.png"));
            i3 = 1;
        } else {
            i3 = 0;
        }
        String feedLabel = O0().getFeedLabel();
        if (i3 < 4 && !TextUtils.isEmpty(feedLabel)) {
            Intrinsics.checkNotNullExpressionValue(feedLabel, "feedLabel");
            arrayList.add(new b(this, R.drawable.guild_qr_code_center_card_icon_post, feedLabel, "https://downv6.qq.com/innovate/guild/qr_code/guild_qrcode_feed_icon.png"));
            i3++;
        }
        String streamLabel = O0().getStreamLabel();
        if (i3 < 4 && !TextUtils.isEmpty(streamLabel)) {
            Intrinsics.checkNotNullExpressionValue(streamLabel, "streamLabel");
            arrayList.add(new b(this, R.drawable.guild_qr_code_center_card_icon_live, streamLabel, "https://downv6.qq.com/innovate/guild/qr_code/guild_qrcode_live_icon.png"));
            i3++;
        }
        String teamLabel = O0().getTeamLabel();
        if (i3 < 4 && !TextUtils.isEmpty(teamLabel)) {
            Intrinsics.checkNotNullExpressionValue(teamLabel, "teamLabel");
            arrayList.add(new b(this, R.drawable.guild_qr_code_center_card_icon_team, teamLabel, "https://downv6.qq.com/innovate/guild/qr_code/guild_qrcode_game_icon.png"));
            i3++;
        }
        String voiceLabel = O0().getVoiceLabel();
        if (i3 < 4 && !TextUtils.isEmpty(voiceLabel)) {
            Intrinsics.checkNotNullExpressionValue(voiceLabel, "voiceLabel");
            arrayList.add(new b(this, R.drawable.guild_qr_code_center_card_icon_voice, voiceLabel, "https://downv6.qq.com/innovate/guild/qr_code/guild_qrcode_voice_icon.png"));
        }
        return arrayList;
    }

    private final void i1() {
        u.s("https://downv6.qq.com/innovate/guild/qr_code/GuildQRCodeBkgAlpha.png", new c());
    }

    private final void k1() {
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
        u.p("https://downv6.qq.com/innovate/guild/qr_code/guild_qrcode_member_icon.png", imageView);
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public void J0() {
        i1();
        k1();
        U0().setText(getMViewModel().mSharerName);
        this.mIconSize = 14.0f;
        if (this.mGuildLabelList == null) {
            List<b> h16 = h1();
            this.mGuildLabelList = h16;
            Intrinsics.checkNotNull(h16);
            int size = h16.size();
            int i3 = 0;
            while (i3 < size) {
                List<b> list = this.mGuildLabelList;
                Intrinsics.checkNotNull(list);
                b bVar = list.get(i3);
                i3++;
                g1(bVar, i3);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public int X0() {
        return QQGuildUIUtil.f(23.0f);
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public int Y0() {
        return QQGuildUIUtil.f(42.3f);
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public void d1() {
        View findViewById = getMView().findViewById(R.id.wkf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(R.id.\u2026ild_iv_guild_member_icon)");
        this.mMemberIcon = (ImageView) findViewById;
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public void setQrCodeDeadline(@NotNull String qrCodeTipStr) {
        Intrinsics.checkNotNullParameter(qrCodeTipStr, "qrCodeTipStr");
        setMQrCodeDeadline(qrCodeTipStr);
        if (!TextUtils.isEmpty(getMQrCodeDeadline())) {
            T0().setText(getMQrCodeDeadline());
        }
    }

    public /* synthetic */ CenterCardHighlightContent(Context context, AttributeSet attributeSet, int i3, GuildQRCodeViewModel guildQRCodeViewModel, com.tencent.mobileqq.mvvm.d dVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, guildQRCodeViewModel, dVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CenterCardHighlightContent(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull GuildQRCodeViewModel mViewModel, @NotNull com.tencent.mobileqq.mvvm.d mOwner) {
        super(context, attributeSet, i3, R.layout.f168150f30, mViewModel, mOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mOwner, "mOwner");
    }
}
