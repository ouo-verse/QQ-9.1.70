package com.tencent.mobileqq.guild.setting.qrcode.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeViewModel;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.an;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProQRCodeShareInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wt1.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0082\u0001B@\b\u0007\u0012\u0006\u0010z\u001a\u00020y\u0012\n\b\u0002\u0010|\u001a\u0004\u0018\u00010{\u0012\b\b\u0002\u0010}\u001a\u00020\u0015\u0012\u0006\u0010~\u001a\u00020\u0015\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010&\u001a\u00020#\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0002H&J\b\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u0017\u001a\u00020\u0015H&J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0011H&J\b\u0010\u001a\u001a\u00020\u0002H&J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0015H\u0016R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010;\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010B\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010J\u001a\u00020C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\"\u0010V\u001a\u00020O8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010]\u001a\u00020W8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bE\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010d\u001a\u00020\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010h\u001a\u00020\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\be\u0010_\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR\"\u0010l\u001a\u00020\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bi\u0010_\u001a\u0004\bj\u0010a\"\u0004\bk\u0010cR\"\u0010p\u001a\u00020\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bm\u0010_\u001a\u0004\bn\u0010a\"\u0004\bo\u0010cR\"\u0010t\u001a\u00020\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bq\u0010_\u001a\u0004\br\u0010a\"\u0004\bs\u0010cR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bv\u0010w\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/qrcode/view/GuildQrCodeCenterCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "Z0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "H0", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProQRCodeShareInfo;", "shareInfo", "G0", "F0", "e1", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfo", "f1", "Landroid/widget/TextView;", "textView", "", "guildName", "K0", "d1", "", "X0", "Y0", "qrCodeTipStr", "setQrCodeDeadline", "J0", "padding", "setPadding", "Lcom/tencent/mobileqq/guild/setting/qrcode/GuildQRCodeViewModel;", "d", "Lcom/tencent/mobileqq/guild/setting/qrcode/GuildQRCodeViewModel;", "W0", "()Lcom/tencent/mobileqq/guild/setting/qrcode/GuildQRCodeViewModel;", "mViewModel", "Lcom/tencent/mobileqq/mvvm/d;", "e", "Lcom/tencent/mobileqq/mvvm/d;", "mOwner", "Landroid/view/View;", "f", "Landroid/view/View;", "V0", "()Landroid/view/View;", "mView", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", h.F, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "L0", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "setMGuildInfo", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;)V", "mGuildInfo", "i", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProQRCodeShareInfo;", "O0", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProQRCodeShareInfo;", "setMShareInfo", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProQRCodeShareInfo;)V", "mShareInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "N0", "()Ljava/lang/String;", "setMQrCodeDeadline", "(Ljava/lang/String;)V", "mQrCodeDeadline", "", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "P0", "()F", "setMSharerNameMaxWidthOfHighlightNum", "(F)V", "mSharerNameMaxWidthOfHighlightNum", "", "D", "Z", "mHasInitShareInfo", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "E", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "getMIvQRCode", "()Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "setMIvQRCode", "(Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;)V", "mIvQRCode", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "M0", "()Landroid/widget/ImageView;", "setMIvGuildAvatar", "(Landroid/widget/ImageView;)V", "mIvGuildAvatar", "G", "Landroid/widget/TextView;", "S0", "()Landroid/widget/TextView;", "setMTvGuildName", "(Landroid/widget/TextView;)V", "mTvGuildName", "H", "Q0", "setMTvGuildInfo", "mTvGuildInfo", "I", "T0", "setMTvGuildQRCodeTip", "mTvGuildQRCodeTip", "J", "R0", "setMTvGuildMember", "mTvGuildMember", "K", "U0", "setMTvGuildShareName", "mTvGuildShareName", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "L", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "mGuildSharerAvatar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "def", "layoutID", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILcom/tencent/mobileqq/guild/setting/qrcode/GuildQRCodeViewModel;Lcom/tencent/mobileqq/mvvm/d;)V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class GuildQrCodeCenterCard extends ConstraintLayout {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int N = QQGuildUIUtil.f(4.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private float mSharerNameMaxWidthOfHighlightNum;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mHasInitShareInfo;

    /* renamed from: E, reason: from kotlin metadata */
    public QUIColorfulQRCodeView mIvQRCode;

    /* renamed from: F, reason: from kotlin metadata */
    public ImageView mIvGuildAvatar;

    /* renamed from: G, reason: from kotlin metadata */
    public TextView mTvGuildName;

    /* renamed from: H, reason: from kotlin metadata */
    public TextView mTvGuildInfo;

    /* renamed from: I, reason: from kotlin metadata */
    public TextView mTvGuildQRCodeTip;

    /* renamed from: J, reason: from kotlin metadata */
    public TextView mTvGuildMember;

    /* renamed from: K, reason: from kotlin metadata */
    public TextView mTvGuildShareName;

    /* renamed from: L, reason: from kotlin metadata */
    private GuildUserAvatarView mGuildSharerAvatar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildQRCodeViewModel mViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.mvvm.d mOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public IGProGuildInfo mGuildInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public IGProQRCodeShareInfo mShareInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mQrCodeDeadline;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/qrcode/view/GuildQrCodeCenterCard$a;", "", "", "MEDAL_PADDING", "I", "a", "()I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return GuildQrCodeCenterCard.N;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildQrCodeCenterCard(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16, @NotNull GuildQRCodeViewModel mViewModel, @NotNull com.tencent.mobileqq.mvvm.d mOwner) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mOwner, "mOwner");
        this.mViewModel = mViewModel;
        this.mOwner = mOwner;
        this.mQrCodeDeadline = "";
        View inflate = LayoutInflater.from(context).inflate(i16, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(layoutID, this)");
        this.mView = inflate;
        initView();
        a1();
    }

    private final void F0() {
        Q0().setText(((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(L0().getProfile(), 12));
        e1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0(IGProQRCodeShareInfo shareInfo) {
        if (this.mHasInitShareInfo) {
            return;
        }
        setMShareInfo(shareInfo);
        this.mHasInitShareInfo = true;
        F0();
        J0();
    }

    private final void H0() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.share.GuildQrCodeCenterCard", "bindNoUpdateData medal:" + getMViewModel().mMedalInfo);
        }
        S0().setText(L0().getGuildName());
        S0().post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.qrcode.view.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildQrCodeCenterCard.I0(GuildQrCodeCenterCard.this);
            }
        });
        GuildUserAvatarView guildUserAvatarView = this.mGuildSharerAvatar;
        if (guildUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildSharerAvatar");
            guildUserAvatarView = null;
        }
        GuildQRCodeViewModel guildQRCodeViewModel = this.mViewModel;
        guildUserAvatarView.setAvatarTinyId(guildQRCodeViewModel.mGuildId, guildQRCodeViewModel.mTinyId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(GuildQrCodeCenterCard this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f1(this$0.mViewModel.mMedalInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String K0(TextView textView, String guildName) {
        int measuredWidth = textView.getMeasuredWidth();
        float measureText = textView.getPaint().measureText(guildName);
        float Y0 = Y0() + measureText + N;
        float f16 = measuredWidth;
        if (measureText <= f16 && f16 < Y0) {
            String substring = guildName.substring(0, guildName.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring2 = guildName.substring(guildName.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            return substring + "\n" + substring2;
        }
        return guildName;
    }

    private final void Z0() {
        View findViewById = this.mView.findViewById(R.id.wkp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(R.id.guild_iv_qr_code)");
        setMIvQRCode((QUIColorfulQRCodeView) findViewById);
        View findViewById2 = this.mView.findViewById(R.id.wkd);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mView.findViewById(R.id.guild_iv_guild_avatar)");
        setMIvGuildAvatar((ImageView) findViewById2);
        View findViewById3 = this.mView.findViewById(R.id.x3e);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mView.findViewById(R.id.guild_tv_guild_name)");
        setMTvGuildName((TextView) findViewById3);
        View findViewById4 = this.mView.findViewById(R.id.x3a);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mView.findViewById(R.id.guild_tv_guild_info)");
        setMTvGuildInfo((TextView) findViewById4);
        View findViewById5 = this.mView.findViewById(R.id.x3u);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mView.findViewById(R.id.guild_tv_qr_code_deadline)");
        setMTvGuildQRCodeTip((TextView) findViewById5);
        View findViewById6 = this.mView.findViewById(R.id.x3l);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mView.findViewById(R.id.guild_tv_member)");
        setMTvGuildMember((TextView) findViewById6);
        View findViewById7 = this.mView.findViewById(R.id.wks);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mView.findViewById(R.id.guild_iv_sharer_avatar)");
        this.mGuildSharerAvatar = (GuildUserAvatarView) findViewById7;
        View findViewById8 = this.mView.findViewById(R.id.x3w);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mView.findViewById(R.id.\u2026d_tv_qr_code_sharer_name)");
        setMTvGuildShareName((TextView) findViewById8);
    }

    private final void a1() {
        this.mSharerNameMaxWidthOfHighlightNum = getResources().getDimension(R.dimen.cin);
        IGProGuildInfo iGProGuildInfo = this.mViewModel.mGuildInfo;
        Intrinsics.checkNotNullExpressionValue(iGProGuildInfo, "mViewModel.mGuildInfo");
        setMGuildInfo(iGProGuildInfo);
        H0();
        MutableLiveData<IGProQRCodeShareInfo> shareInfo = this.mViewModel.getShareInfo();
        com.tencent.mobileqq.mvvm.d dVar = this.mOwner;
        final Function1<IGProQRCodeShareInfo, Unit> function1 = new Function1<IGProQRCodeShareInfo, Unit>() { // from class: com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProQRCodeShareInfo iGProQRCodeShareInfo) {
                invoke2(iGProQRCodeShareInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IGProQRCodeShareInfo shareInfo2) {
                GuildQrCodeCenterCard guildQrCodeCenterCard = GuildQrCodeCenterCard.this;
                Intrinsics.checkNotNullExpressionValue(shareInfo2, "shareInfo");
                guildQrCodeCenterCard.G0(shareInfo2);
            }
        };
        shareInfo.observe(dVar, new Observer() { // from class: com.tencent.mobileqq.guild.setting.qrcode.view.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildQrCodeCenterCard.b1(Function1.this, obj);
            }
        });
        MutableLiveData<String> updateQrCodeTipStr = this.mViewModel.getUpdateQrCodeTipStr();
        com.tencent.mobileqq.mvvm.d dVar2 = this.mOwner;
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String qrcodeTipStr) {
                GuildQrCodeCenterCard guildQrCodeCenterCard = GuildQrCodeCenterCard.this;
                Intrinsics.checkNotNullExpressionValue(qrcodeTipStr, "qrcodeTipStr");
                guildQrCodeCenterCard.setQrCodeDeadline(qrcodeTipStr);
                if (qrcodeTipStr.length() == 0) {
                    GuildQrCodeCenterCard.this.T0().setVisibility(8);
                } else {
                    GuildQrCodeCenterCard.this.T0().setVisibility(0);
                }
            }
        };
        updateQrCodeTipStr.observe(dVar2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.qrcode.view.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildQrCodeCenterCard.c1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void e1() {
        String avatarUrl = L0().getAvatarUrl(100);
        if (TextUtils.isEmpty(avatarUrl)) {
            M0().setVisibility(8);
            return;
        }
        M0().setVisibility(0);
        M0().setImageDrawable(((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGuildFaceIcon(avatarUrl, QQGuildUIUtil.f(70.0f), BaseImageUtil.getDefaultFaceDrawable(false), false));
    }

    private final void f1(IGProMedalInfo medalInfo) {
        if (medalInfo != null && medalInfo.getOfficialMedalInfoExt().getIsOffical()) {
            an.INSTANCE.e(new WeakReference<>(S0()), new Function2<URLDrawable, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard$updateGuildMedal$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(URLDrawable uRLDrawable, Integer num) {
                    invoke(uRLDrawable, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull URLDrawable uRLDrawable, int i3) {
                    String K0;
                    Intrinsics.checkNotNullParameter(uRLDrawable, "<anonymous parameter 0>");
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    GuildQrCodeCenterCard guildQrCodeCenterCard = GuildQrCodeCenterCard.this;
                    TextView S0 = guildQrCodeCenterCard.S0();
                    String guildName = GuildQrCodeCenterCard.this.L0().getGuildName();
                    Intrinsics.checkNotNullExpressionValue(guildName, "mGuildInfo.guildName");
                    K0 = guildQrCodeCenterCard.K0(S0, guildName);
                    spannableStringBuilder.append((CharSequence) K0);
                    spannableStringBuilder.append((CharSequence) ":");
                    f fVar = new f(GuildQrCodeCenterCard.this.S0().getContext(), an.INSTANCE.d(), i3, GuildQrCodeCenterCard.this.X0(), GuildQrCodeCenterCard.INSTANCE.a(), 0, -2);
                    fVar.c(GuildQrCodeCenterCard.this.S0());
                    spannableStringBuilder.setSpan(fVar, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append(TokenParser.SP);
                    GuildQrCodeCenterCard.this.S0().setText(spannableStringBuilder);
                    GuildQrCodeCenterCard.this.S0().setMovementMethod(LinkMovementMethod.getInstance());
                }
            }, X0());
        }
    }

    private final void initView() {
        Z0();
        d1();
    }

    public abstract void J0();

    @NotNull
    public final IGProGuildInfo L0() {
        IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
        if (iGProGuildInfo != null) {
            return iGProGuildInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
        return null;
    }

    @NotNull
    public final ImageView M0() {
        ImageView imageView = this.mIvGuildAvatar;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mIvGuildAvatar");
        return null;
    }

    @NotNull
    /* renamed from: N0, reason: from getter */
    public final String getMQrCodeDeadline() {
        return this.mQrCodeDeadline;
    }

    @NotNull
    public final IGProQRCodeShareInfo O0() {
        IGProQRCodeShareInfo iGProQRCodeShareInfo = this.mShareInfo;
        if (iGProQRCodeShareInfo != null) {
            return iGProQRCodeShareInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mShareInfo");
        return null;
    }

    /* renamed from: P0, reason: from getter */
    public final float getMSharerNameMaxWidthOfHighlightNum() {
        return this.mSharerNameMaxWidthOfHighlightNum;
    }

    @NotNull
    public final TextView Q0() {
        TextView textView = this.mTvGuildInfo;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTvGuildInfo");
        return null;
    }

    @NotNull
    public final TextView R0() {
        TextView textView = this.mTvGuildMember;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTvGuildMember");
        return null;
    }

    @NotNull
    public final TextView S0() {
        TextView textView = this.mTvGuildName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTvGuildName");
        return null;
    }

    @NotNull
    public final TextView T0() {
        TextView textView = this.mTvGuildQRCodeTip;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTvGuildQRCodeTip");
        return null;
    }

    @NotNull
    public final TextView U0() {
        TextView textView = this.mTvGuildShareName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTvGuildShareName");
        return null;
    }

    @NotNull
    /* renamed from: V0, reason: from getter */
    public final View getMView() {
        return this.mView;
    }

    @NotNull
    /* renamed from: W0, reason: from getter */
    public final GuildQRCodeViewModel getMViewModel() {
        return this.mViewModel;
    }

    public abstract int X0();

    public abstract int Y0();

    public abstract void d1();

    public final void setMGuildInfo(@NotNull IGProGuildInfo iGProGuildInfo) {
        Intrinsics.checkNotNullParameter(iGProGuildInfo, "<set-?>");
        this.mGuildInfo = iGProGuildInfo;
    }

    public final void setMIvGuildAvatar(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mIvGuildAvatar = imageView;
    }

    public final void setMIvQRCode(@NotNull QUIColorfulQRCodeView qUIColorfulQRCodeView) {
        Intrinsics.checkNotNullParameter(qUIColorfulQRCodeView, "<set-?>");
        this.mIvQRCode = qUIColorfulQRCodeView;
    }

    public final void setMQrCodeDeadline(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mQrCodeDeadline = str;
    }

    public final void setMShareInfo(@NotNull IGProQRCodeShareInfo iGProQRCodeShareInfo) {
        Intrinsics.checkNotNullParameter(iGProQRCodeShareInfo, "<set-?>");
        this.mShareInfo = iGProQRCodeShareInfo;
    }

    public final void setMSharerNameMaxWidthOfHighlightNum(float f16) {
        this.mSharerNameMaxWidthOfHighlightNum = f16;
    }

    public final void setMTvGuildInfo(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mTvGuildInfo = textView;
    }

    public final void setMTvGuildMember(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mTvGuildMember = textView;
    }

    public final void setMTvGuildName(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mTvGuildName = textView;
    }

    public final void setMTvGuildQRCodeTip(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mTvGuildQRCodeTip = textView;
    }

    public final void setMTvGuildShareName(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mTvGuildShareName = textView;
    }

    public void setPadding(int padding) {
        View findViewById = this.mView.findViewById(R.id.w2s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mView.findViewById(R.id.\u2026qr_code_center_container)");
        ((ConstraintLayout) findViewById).setPadding(padding, padding, padding, padding);
    }

    public abstract void setQrCodeDeadline(@NotNull String qrCodeTipStr);
}
