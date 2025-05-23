package com.tencent.mobileqq.guild.setting.qrcode.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeViewModel;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.TypefaceProvider;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002-.B7\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0014\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u0007H\u0002J\u0014\u0010\u000b\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bR\u00020\u0000H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0016\u0010 \u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/qrcode/view/CenterCardHighlightNum;", "Lcom/tencent/mobileqq/guild/setting/qrcode/view/GuildQrCodeCenterCard;", "", "l1", "", "h1", "i1", "", "Lcom/tencent/mobileqq/guild/setting/qrcode/view/CenterCardHighlightNum$b;", "g1", "guildLabel", "k1", "", WidgetCacheConstellationData.NUM, "", "m1", "d1", "qrCodeTipStr", "setQrCodeDeadline", "J0", "", "X0", "Y0", "Landroid/widget/TextView;", "P", "Landroid/widget/TextView;", "mTvGuildPostNum", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mTvGuildLiveNum", BdhLogUtil.LogTag.Tag_Req, "mTvGuildTeamNum", ExifInterface.LATITUDE_SOUTH, "mTvGuildVoiceNum", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "def", "Lcom/tencent/mobileqq/guild/setting/qrcode/GuildQRCodeViewModel;", "mViewModel", "Lcom/tencent/mobileqq/mvvm/d;", "mOwner", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/mobileqq/guild/setting/qrcode/GuildQRCodeViewModel;Lcom/tencent/mobileqq/mvvm/d;)V", "T", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class CenterCardHighlightNum extends GuildQrCodeCenterCard {

    /* renamed from: P, reason: from kotlin metadata */
    private TextView mTvGuildPostNum;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView mTvGuildLiveNum;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView mTvGuildTeamNum;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView mTvGuildVoiceNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/qrcode/view/CenterCardHighlightNum$b;", "", "", "a", "J", "c", "()J", "labelNum", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "d", "()Landroid/widget/TextView;", "numTv", "contentTv", "", "Ljava/lang/String;", "()Ljava/lang/String;", "contentText", "<init>", "(Lcom/tencent/mobileqq/guild/setting/qrcode/view/CenterCardHighlightNum;JLandroid/widget/TextView;Landroid/widget/TextView;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long labelNum;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TextView numTv;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final TextView contentTv;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String contentText;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CenterCardHighlightNum f234905e;

        public b(CenterCardHighlightNum centerCardHighlightNum, @NotNull long j3, @NotNull TextView numTv, @NotNull TextView contentTv, String contentText) {
            Intrinsics.checkNotNullParameter(numTv, "numTv");
            Intrinsics.checkNotNullParameter(contentTv, "contentTv");
            Intrinsics.checkNotNullParameter(contentText, "contentText");
            this.f234905e = centerCardHighlightNum;
            this.labelNum = j3;
            this.numTv = numTv;
            this.contentTv = contentTv;
            this.contentText = contentText;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getContentText() {
            return this.contentText;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final TextView getContentTv() {
            return this.contentTv;
        }

        /* renamed from: c, reason: from getter */
        public final long getLabelNum() {
            return this.labelNum;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final TextView getNumTv() {
            return this.numTv;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/qrcode/view/CenterCardHighlightNum$c", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
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
                if (CenterCardHighlightNum.this.getContext() == null) {
                    QLog.w("Guild.share.CenterCardHighlightNum", 1, "getContext is null!");
                    return;
                } else {
                    CenterCardHighlightNum.this.getMView().setBackground(new BitmapDrawable(CenterCardHighlightNum.this.getResources(), option.getResultBitMap()));
                    return;
                }
            }
            QLog.w("Guild.share.CenterCardHighlightNum", 1, "updateGuildMedal onStateChange failed!");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CenterCardHighlightNum(@NotNull Context context, @NotNull GuildQRCodeViewModel mViewModel, @NotNull com.tencent.mobileqq.mvvm.d mOwner) {
        this(context, null, 0, mViewModel, mOwner, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mOwner, "mOwner");
    }

    private final List<b> g1() {
        int i3;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ArrayList arrayList = new ArrayList();
        if (O0().getFeedNum() != 0) {
            long feedNum = O0().getFeedNum();
            TextView textView5 = this.mTvGuildPostNum;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvGuildPostNum");
                textView4 = null;
            } else {
                textView4 = textView5;
            }
            View findViewById = getMView().findViewById(R.id.x3s);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(R.id.guild_tv_post)");
            String string = getResources().getString(R.string.f152561_q);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026.guild_quick_search_feed)");
            arrayList.add(new b(this, feedNum, textView4, (TextView) findViewById, string));
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (O0().getLiveNum() != 0) {
            long liveNum = O0().getLiveNum();
            TextView textView6 = this.mTvGuildLiveNum;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvGuildLiveNum");
                textView3 = null;
            } else {
                textView3 = textView6;
            }
            View findViewById2 = getMView().findViewById(R.id.x3i);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mView.findViewById(R.id.guild_tv_live)");
            String string2 = getResources().getString(R.string.f152411_b);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026.guild_qr_code_live_text)");
            arrayList.add(new b(this, liveNum, textView3, (TextView) findViewById2, string2));
            i3++;
        }
        if (i3 != 2 && O0().getGameNum() != 0) {
            long gameNum = O0().getGameNum();
            TextView textView7 = this.mTvGuildTeamNum;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvGuildTeamNum");
                textView2 = null;
            } else {
                textView2 = textView7;
            }
            View findViewById3 = getMView().findViewById(R.id.x3y);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "mView.findViewById(R.id.guild_tv_team)");
            String string3 = getResources().getString(R.string.f152451_f);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st\u2026.guild_qr_code_team_text)");
            arrayList.add(new b(this, gameNum, textView2, (TextView) findViewById3, string3));
            i3++;
        }
        if (i3 != 2 && O0().getAvTime() != 0) {
            long avTime = O0().getAvTime();
            TextView textView8 = this.mTvGuildVoiceNum;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvGuildVoiceNum");
                textView = null;
            } else {
                textView = textView8;
            }
            View findViewById4 = getMView().findViewById(R.id.f165646x42);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "mView.findViewById(R.id.guild_tv_voice)");
            String string4 = getResources().getString(R.string.f152481_i);
            Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st\u2026guild_qr_code_voice_text)");
            arrayList.add(new b(this, avTime, textView, (TextView) findViewById4, string4));
        }
        return arrayList;
    }

    private final float h1() {
        float coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) U0().getPaint().measureText(getMViewModel().mSharerName), getMSharerNameMaxWidthOfHighlightNum());
        return coerceAtMost;
    }

    private final void i1() {
        u.s("https://downv6.qq.com/innovate/guild/qr_code/GuildQRCodeBkgGamma.png", new c());
    }

    private final void k1(b guildLabel) {
        guildLabel.getNumTv().setVisibility(0);
        guildLabel.getContentTv().setVisibility(0);
        long labelNum = guildLabel.getLabelNum();
        if (labelNum >= 99999) {
            guildLabel.getNumTv().setText("10");
            guildLabel.getContentTv().setText("\u4e07+" + guildLabel.getContentText());
        } else if (labelNum >= 10000) {
            guildLabel.getNumTv().setText(m1(labelNum));
            guildLabel.getContentTv().setText("\u4e07" + guildLabel.getContentText());
        } else {
            guildLabel.getNumTv().setText(String.valueOf(labelNum));
        }
        guildLabel.getNumTv().setTypeface(TypefaceProvider.c(getContext(), "fonts/DIN-NextLT-Pro-Condensed.ttf"));
    }

    private final void l1() {
        if (TextUtils.isEmpty(O0().getMembersCount())) {
            R0().setVisibility(8);
            View findViewById = getMView().findViewById(R.id.x3m);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(R.id.guild_tv_member_text)");
            ((TextView) findViewById).setVisibility(8);
            return;
        }
        R0().setText(O0().getMembersCount());
        R0().setTypeface(TypefaceProvider.c(getContext(), "fonts/DIN-NextLT-Pro-Condensed.ttf"));
    }

    private final String m1(long num) {
        long j3 = num % 1000;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.CHINA, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((float) num) / 10000)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public void J0() {
        i1();
        l1();
        U0().setText(getMViewModel().mSharerName);
        U0().setWidth((int) h1());
        View findViewById = getMView().findViewById(R.id.x3b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(R.id.\u2026tv_guild_invitation_info)");
        ((TextView) findViewById).setText(" " + getResources().getString(R.string.f152401_a));
        Iterator<b> it = g1().iterator();
        while (it.hasNext()) {
            k1(it.next());
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
        View findViewById = getMView().findViewById(R.id.x3t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(R.id.guild_tv_post_num)");
        this.mTvGuildPostNum = (TextView) findViewById;
        View findViewById2 = getMView().findViewById(R.id.x3j);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mView.findViewById(R.id.guild_tv_live_num)");
        this.mTvGuildLiveNum = (TextView) findViewById2;
        View findViewById3 = getMView().findViewById(R.id.x3z);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mView.findViewById(R.id.guild_tv_team_num)");
        this.mTvGuildTeamNum = (TextView) findViewById3;
        View findViewById4 = getMView().findViewById(R.id.f165647x43);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mView.findViewById(R.id.guild_tv_voice_num)");
        this.mTvGuildVoiceNum = (TextView) findViewById4;
    }

    @Override // com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard
    public void setQrCodeDeadline(@NotNull String qrCodeTipStr) {
        Intrinsics.checkNotNullParameter(qrCodeTipStr, "qrCodeTipStr");
        setMQrCodeDeadline(qrCodeTipStr);
        if (!TextUtils.isEmpty(getMQrCodeDeadline())) {
            T0().setText(getMQrCodeDeadline());
        }
    }

    public /* synthetic */ CenterCardHighlightNum(Context context, AttributeSet attributeSet, int i3, GuildQRCodeViewModel guildQRCodeViewModel, com.tencent.mobileqq.mvvm.d dVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, guildQRCodeViewModel, dVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CenterCardHighlightNum(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull GuildQRCodeViewModel mViewModel, @NotNull com.tencent.mobileqq.mvvm.d mOwner) {
        super(context, attributeSet, i3, R.layout.f168151f31, mViewModel, mOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mOwner, "mOwner");
    }
}
